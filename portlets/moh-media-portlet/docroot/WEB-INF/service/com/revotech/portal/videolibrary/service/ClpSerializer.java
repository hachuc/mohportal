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

package com.revotech.portal.videolibrary.service;

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

import com.revotech.portal.videolibrary.model.VLCategoryClp;
import com.revotech.portal.videolibrary.model.VLRelateVideoClp;
import com.revotech.portal.videolibrary.model.VLVideoCategoryClp;
import com.revotech.portal.videolibrary.model.VLVideoClp;
import com.revotech.portal.videolibrary.model.VLVideoTagClp;
import com.revotech.portal.videolibrary.model.VideoCategoryClp;
import com.revotech.portal.videolibrary.model.VideoClipClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChucHV
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
						"moh-media-portlet-deployment-context");

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
							"moh-media-portlet-deployment-context");

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
				_servletContextName = "moh-media-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(VideoCategoryClp.class.getName())) {
			return translateInputVideoCategory(oldModel);
		}

		if (oldModelClassName.equals(VideoClipClp.class.getName())) {
			return translateInputVideoClip(oldModel);
		}

		if (oldModelClassName.equals(VLCategoryClp.class.getName())) {
			return translateInputVLCategory(oldModel);
		}

		if (oldModelClassName.equals(VLRelateVideoClp.class.getName())) {
			return translateInputVLRelateVideo(oldModel);
		}

		if (oldModelClassName.equals(VLVideoClp.class.getName())) {
			return translateInputVLVideo(oldModel);
		}

		if (oldModelClassName.equals(VLVideoCategoryClp.class.getName())) {
			return translateInputVLVideoCategory(oldModel);
		}

		if (oldModelClassName.equals(VLVideoTagClp.class.getName())) {
			return translateInputVLVideoTag(oldModel);
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

	public static Object translateInputVideoCategory(BaseModel<?> oldModel) {
		VideoCategoryClp oldClpModel = (VideoCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVideoCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVideoClip(BaseModel<?> oldModel) {
		VideoClipClp oldClpModel = (VideoClipClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVideoClipRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVLCategory(BaseModel<?> oldModel) {
		VLCategoryClp oldClpModel = (VLCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVLCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVLRelateVideo(BaseModel<?> oldModel) {
		VLRelateVideoClp oldClpModel = (VLRelateVideoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVLRelateVideoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVLVideo(BaseModel<?> oldModel) {
		VLVideoClp oldClpModel = (VLVideoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVLVideoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVLVideoCategory(BaseModel<?> oldModel) {
		VLVideoCategoryClp oldClpModel = (VLVideoCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVLVideoCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVLVideoTag(BaseModel<?> oldModel) {
		VLVideoTagClp oldClpModel = (VLVideoTagClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVLVideoTagRemoteModel();

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
					"com.revotech.portal.videolibrary.model.impl.VideoCategoryImpl")) {
			return translateOutputVideoCategory(oldModel);
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
					"com.revotech.portal.videolibrary.model.impl.VideoClipImpl")) {
			return translateOutputVideoClip(oldModel);
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
					"com.revotech.portal.videolibrary.model.impl.VLCategoryImpl")) {
			return translateOutputVLCategory(oldModel);
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
					"com.revotech.portal.videolibrary.model.impl.VLRelateVideoImpl")) {
			return translateOutputVLRelateVideo(oldModel);
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
					"com.revotech.portal.videolibrary.model.impl.VLVideoImpl")) {
			return translateOutputVLVideo(oldModel);
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
					"com.revotech.portal.videolibrary.model.impl.VLVideoCategoryImpl")) {
			return translateOutputVLVideoCategory(oldModel);
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
					"com.revotech.portal.videolibrary.model.impl.VLVideoTagImpl")) {
			return translateOutputVLVideoTag(oldModel);
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

		if (className.equals(
					"com.revotech.portal.videolibrary.ImageFileSizeException")) {
			return new com.revotech.portal.videolibrary.ImageFileSizeException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.ImageFileTypeException")) {
			return new com.revotech.portal.videolibrary.ImageFileTypeException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.VideoFileSizeException")) {
			return new com.revotech.portal.videolibrary.VideoFileSizeException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.VideoFileTypeException")) {
			return new com.revotech.portal.videolibrary.VideoFileTypeException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.NoSuchVideoCategoryException")) {
			return new com.revotech.portal.videolibrary.NoSuchVideoCategoryException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.NoSuchVideoClipException")) {
			return new com.revotech.portal.videolibrary.NoSuchVideoClipException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.NoSuchVLCategoryException")) {
			return new com.revotech.portal.videolibrary.NoSuchVLCategoryException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.NoSuchVLRelateVideoException")) {
			return new com.revotech.portal.videolibrary.NoSuchVLRelateVideoException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.NoSuchVLVideoException")) {
			return new com.revotech.portal.videolibrary.NoSuchVLVideoException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException")) {
			return new com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException();
		}

		if (className.equals(
					"com.revotech.portal.videolibrary.NoSuchVLVideoTagException")) {
			return new com.revotech.portal.videolibrary.NoSuchVLVideoTagException();
		}

		return throwable;
	}

	public static Object translateOutputVideoCategory(BaseModel<?> oldModel) {
		VideoCategoryClp newModel = new VideoCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVideoCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVideoClip(BaseModel<?> oldModel) {
		VideoClipClp newModel = new VideoClipClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVideoClipRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVLCategory(BaseModel<?> oldModel) {
		VLCategoryClp newModel = new VLCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVLCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVLRelateVideo(BaseModel<?> oldModel) {
		VLRelateVideoClp newModel = new VLRelateVideoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVLRelateVideoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVLVideo(BaseModel<?> oldModel) {
		VLVideoClp newModel = new VLVideoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVLVideoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVLVideoCategory(BaseModel<?> oldModel) {
		VLVideoCategoryClp newModel = new VLVideoCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVLVideoCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVLVideoTag(BaseModel<?> oldModel) {
		VLVideoTagClp newModel = new VLVideoTagClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVLVideoTagRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}