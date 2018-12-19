/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package com.viettel.portal.vcms.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.viettel.portal.vcms.model.CategoryClp;
import com.viettel.portal.vcms.model.CommentClp;
import com.viettel.portal.vcms.model.ContentClp;
import com.viettel.portal.vcms.model.ContentDetailClp;
import com.viettel.portal.vcms.model.ContentProfitClp;
import com.viettel.portal.vcms.model.ContentTypeClp;
import com.viettel.portal.vcms.model.ContentTypeCostClp;
import com.viettel.portal.vcms.model.DistributionClp;
import com.viettel.portal.vcms.model.DistributionVisistedClp;
import com.viettel.portal.vcms.model.Legal_CommentClp;
import com.viettel.portal.vcms.model.Legal_ContentClp;
import com.viettel.portal.vcms.model.Legal_ContentProfitClp;
import com.viettel.portal.vcms.model.Legal_DistributionClp;
import com.viettel.portal.vcms.model.Legal_ZoneClp;
import com.viettel.portal.vcms.model.NotesClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chuchv
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"viettel-cms-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"viettel-cms-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "viettel-cms-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CategoryClp.class.getName())) {
			return translateInputCategory(oldModel);
		}

		if (oldModelClassName.equals(CommentClp.class.getName())) {
			return translateInputComment(oldModel);
		}

		if (oldModelClassName.equals(ContentClp.class.getName())) {
			return translateInputContent(oldModel);
		}

		if (oldModelClassName.equals(ContentDetailClp.class.getName())) {
			return translateInputContentDetail(oldModel);
		}

		if (oldModelClassName.equals(ContentProfitClp.class.getName())) {
			return translateInputContentProfit(oldModel);
		}

		if (oldModelClassName.equals(ContentTypeClp.class.getName())) {
			return translateInputContentType(oldModel);
		}

		if (oldModelClassName.equals(ContentTypeCostClp.class.getName())) {
			return translateInputContentTypeCost(oldModel);
		}

		if (oldModelClassName.equals(DistributionClp.class.getName())) {
			return translateInputDistribution(oldModel);
		}

		if (oldModelClassName.equals(DistributionVisistedClp.class.getName())) {
			return translateInputDistributionVisisted(oldModel);
		}

		if (oldModelClassName.equals(Legal_CommentClp.class.getName())) {
			return translateInputLegal_Comment(oldModel);
		}

		if (oldModelClassName.equals(Legal_ContentClp.class.getName())) {
			return translateInputLegal_Content(oldModel);
		}

		if (oldModelClassName.equals(Legal_ContentProfitClp.class.getName())) {
			return translateInputLegal_ContentProfit(oldModel);
		}

		if (oldModelClassName.equals(Legal_DistributionClp.class.getName())) {
			return translateInputLegal_Distribution(oldModel);
		}

		if (oldModelClassName.equals(Legal_ZoneClp.class.getName())) {
			return translateInputLegal_Zone(oldModel);
		}

		if (oldModelClassName.equals(NotesClp.class.getName())) {
			return translateInputNotes(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCategory(BaseModel<?> oldModel) {
		CategoryClp oldClpModel = (CategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputComment(BaseModel<?> oldModel) {
		CommentClp oldClpModel = (CommentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContent(BaseModel<?> oldModel) {
		ContentClp oldClpModel = (ContentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContentDetail(BaseModel<?> oldModel) {
		ContentDetailClp oldClpModel = (ContentDetailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContentDetailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContentProfit(BaseModel<?> oldModel) {
		ContentProfitClp oldClpModel = (ContentProfitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContentProfitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContentType(BaseModel<?> oldModel) {
		ContentTypeClp oldClpModel = (ContentTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContentTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContentTypeCost(BaseModel<?> oldModel) {
		ContentTypeCostClp oldClpModel = (ContentTypeCostClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContentTypeCostRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDistribution(BaseModel<?> oldModel) {
		DistributionClp oldClpModel = (DistributionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDistributionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDistributionVisisted(
		BaseModel<?> oldModel) {
		DistributionVisistedClp oldClpModel = (DistributionVisistedClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDistributionVisistedRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegal_Comment(BaseModel<?> oldModel) {
		Legal_CommentClp oldClpModel = (Legal_CommentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegal_CommentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegal_Content(BaseModel<?> oldModel) {
		Legal_ContentClp oldClpModel = (Legal_ContentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegal_ContentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegal_ContentProfit(
		BaseModel<?> oldModel) {
		Legal_ContentProfitClp oldClpModel = (Legal_ContentProfitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegal_ContentProfitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegal_Distribution(BaseModel<?> oldModel) {
		Legal_DistributionClp oldClpModel = (Legal_DistributionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegal_DistributionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegal_Zone(BaseModel<?> oldModel) {
		Legal_ZoneClp oldClpModel = (Legal_ZoneClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegal_ZoneRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNotes(BaseModel<?> oldModel) {
		NotesClp oldClpModel = (NotesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNotesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.CategoryImpl")) {
			return translateOutputCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.CommentImpl")) {
			return translateOutputComment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.ContentImpl")) {
			return translateOutputContent(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.ContentDetailImpl")) {
			return translateOutputContentDetail(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.ContentProfitImpl")) {
			return translateOutputContentProfit(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.ContentTypeImpl")) {
			return translateOutputContentType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.ContentTypeCostImpl")) {
			return translateOutputContentTypeCost(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.DistributionImpl")) {
			return translateOutputDistribution(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.DistributionVisistedImpl")) {
			return translateOutputDistributionVisisted(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.Legal_CommentImpl")) {
			return translateOutputLegal_Comment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.Legal_ContentImpl")) {
			return translateOutputLegal_Content(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.Legal_ContentProfitImpl")) {
			return translateOutputLegal_ContentProfit(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.Legal_DistributionImpl")) {
			return translateOutputLegal_Distribution(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.Legal_ZoneImpl")) {
			return translateOutputLegal_Zone(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.viettel.portal.vcms.model.impl.NotesImpl")) {
			return translateOutputNotes(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.viettel.portal.vcms.NoSuchCategoryException")) {
			return new com.viettel.portal.vcms.NoSuchCategoryException();
		}

		if (className.equals("com.viettel.portal.vcms.NoSuchCommentException")) {
			return new com.viettel.portal.vcms.NoSuchCommentException();
		}

		if (className.equals("com.viettel.portal.vcms.NoSuchContentException")) {
			return new com.viettel.portal.vcms.NoSuchContentException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchContentDetailException")) {
			return new com.viettel.portal.vcms.NoSuchContentDetailException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchContentProfitException")) {
			return new com.viettel.portal.vcms.NoSuchContentProfitException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchContentTypeException")) {
			return new com.viettel.portal.vcms.NoSuchContentTypeException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchContentTypeCostException")) {
			return new com.viettel.portal.vcms.NoSuchContentTypeCostException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchDistributionException")) {
			return new com.viettel.portal.vcms.NoSuchDistributionException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchDistributionVisistedException")) {
			return new com.viettel.portal.vcms.NoSuchDistributionVisistedException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchLegal_CommentException")) {
			return new com.viettel.portal.vcms.NoSuchLegal_CommentException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchLegal_ContentException")) {
			return new com.viettel.portal.vcms.NoSuchLegal_ContentException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchLegal_ContentProfitException")) {
			return new com.viettel.portal.vcms.NoSuchLegal_ContentProfitException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchLegal_DistributionException")) {
			return new com.viettel.portal.vcms.NoSuchLegal_DistributionException();
		}

		if (className.equals(
					"com.viettel.portal.vcms.NoSuchLegal_ZoneException")) {
			return new com.viettel.portal.vcms.NoSuchLegal_ZoneException();
		}

		if (className.equals("com.viettel.portal.vcms.NoSuchNotesException")) {
			return new com.viettel.portal.vcms.NoSuchNotesException();
		}

		return throwable;
	}

	public static Object translateOutputCategory(BaseModel<?> oldModel) {
		CategoryClp newModel = new CategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputComment(BaseModel<?> oldModel) {
		CommentClp newModel = new CommentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContent(BaseModel<?> oldModel) {
		ContentClp newModel = new ContentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContentDetail(BaseModel<?> oldModel) {
		ContentDetailClp newModel = new ContentDetailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContentDetailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContentProfit(BaseModel<?> oldModel) {
		ContentProfitClp newModel = new ContentProfitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContentProfitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContentType(BaseModel<?> oldModel) {
		ContentTypeClp newModel = new ContentTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContentTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContentTypeCost(BaseModel<?> oldModel) {
		ContentTypeCostClp newModel = new ContentTypeCostClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContentTypeCostRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDistribution(BaseModel<?> oldModel) {
		DistributionClp newModel = new DistributionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDistributionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDistributionVisisted(
		BaseModel<?> oldModel) {
		DistributionVisistedClp newModel = new DistributionVisistedClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDistributionVisistedRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegal_Comment(BaseModel<?> oldModel) {
		Legal_CommentClp newModel = new Legal_CommentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegal_CommentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegal_Content(BaseModel<?> oldModel) {
		Legal_ContentClp newModel = new Legal_ContentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegal_ContentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegal_ContentProfit(
		BaseModel<?> oldModel) {
		Legal_ContentProfitClp newModel = new Legal_ContentProfitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegal_ContentProfitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegal_Distribution(
		BaseModel<?> oldModel) {
		Legal_DistributionClp newModel = new Legal_DistributionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegal_DistributionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegal_Zone(BaseModel<?> oldModel) {
		Legal_ZoneClp newModel = new Legal_ZoneClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegal_ZoneRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNotes(BaseModel<?> oldModel) {
		NotesClp newModel = new NotesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNotesRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}