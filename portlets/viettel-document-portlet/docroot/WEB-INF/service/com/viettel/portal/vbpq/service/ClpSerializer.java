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

package com.viettel.portal.vbpq.service;

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

import com.viettel.portal.vbpq.model.AttachFileClp;
import com.viettel.portal.vbpq.model.CoQuanBanHanhVanBanClp;
import com.viettel.portal.vbpq.model.LinhVucVanBanClp;
import com.viettel.portal.vbpq.model.LoaiVanBanClp;
import com.viettel.portal.vbpq.model.NhomVanBanClp;
import com.viettel.portal.vbpq.model.VanBanPhapQuyClp;

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
						"viettel-document-portlet-deployment-context");

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
							"viettel-document-portlet-deployment-context");

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
				_servletContextName = "viettel-document-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AttachFileClp.class.getName())) {
			return translateInputAttachFile(oldModel);
		}

		if (oldModelClassName.equals(CoQuanBanHanhVanBanClp.class.getName())) {
			return translateInputCoQuanBanHanhVanBan(oldModel);
		}

		if (oldModelClassName.equals(LinhVucVanBanClp.class.getName())) {
			return translateInputLinhVucVanBan(oldModel);
		}

		if (oldModelClassName.equals(LoaiVanBanClp.class.getName())) {
			return translateInputLoaiVanBan(oldModel);
		}

		if (oldModelClassName.equals(NhomVanBanClp.class.getName())) {
			return translateInputNhomVanBan(oldModel);
		}

		if (oldModelClassName.equals(VanBanPhapQuyClp.class.getName())) {
			return translateInputVanBanPhapQuy(oldModel);
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

	public static Object translateInputAttachFile(BaseModel<?> oldModel) {
		AttachFileClp oldClpModel = (AttachFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAttachFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCoQuanBanHanhVanBan(
		BaseModel<?> oldModel) {
		CoQuanBanHanhVanBanClp oldClpModel = (CoQuanBanHanhVanBanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCoQuanBanHanhVanBanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLinhVucVanBan(BaseModel<?> oldModel) {
		LinhVucVanBanClp oldClpModel = (LinhVucVanBanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLinhVucVanBanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLoaiVanBan(BaseModel<?> oldModel) {
		LoaiVanBanClp oldClpModel = (LoaiVanBanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLoaiVanBanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNhomVanBan(BaseModel<?> oldModel) {
		NhomVanBanClp oldClpModel = (NhomVanBanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNhomVanBanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVanBanPhapQuy(BaseModel<?> oldModel) {
		VanBanPhapQuyClp oldClpModel = (VanBanPhapQuyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVanBanPhapQuyRemoteModel();

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
					"com.viettel.portal.vbpq.model.impl.AttachFileImpl")) {
			return translateOutputAttachFile(oldModel);
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
					"com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanImpl")) {
			return translateOutputCoQuanBanHanhVanBan(oldModel);
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
					"com.viettel.portal.vbpq.model.impl.LinhVucVanBanImpl")) {
			return translateOutputLinhVucVanBan(oldModel);
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
					"com.viettel.portal.vbpq.model.impl.LoaiVanBanImpl")) {
			return translateOutputLoaiVanBan(oldModel);
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
					"com.viettel.portal.vbpq.model.impl.NhomVanBanImpl")) {
			return translateOutputNhomVanBan(oldModel);
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
					"com.viettel.portal.vbpq.model.impl.VanBanPhapQuyImpl")) {
			return translateOutputVanBanPhapQuy(oldModel);
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
					"com.viettel.portal.vbpq.CoQuanBanHanhTenException")) {
			return new com.viettel.portal.vbpq.CoQuanBanHanhTenException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.DuplicateMaVanBanException")) {
			return new com.viettel.portal.vbpq.DuplicateMaVanBanException();
		}

		if (className.equals("com.viettel.portal.vbpq.DuplicateTenException")) {
			return new com.viettel.portal.vbpq.DuplicateTenException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.LinhVucVanBanTenException")) {
			return new com.viettel.portal.vbpq.LinhVucVanBanTenException();
		}

		if (className.equals("com.viettel.portal.vbpq.LoaiVanBanTenException")) {
			return new com.viettel.portal.vbpq.LoaiVanBanTenException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.RequiredCoQuanBanHanhException")) {
			return new com.viettel.portal.vbpq.RequiredCoQuanBanHanhException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.RequiredLinhVucVanBanException")) {
			return new com.viettel.portal.vbpq.RequiredLinhVucVanBanException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.RequiredLoaiVanBanException")) {
			return new com.viettel.portal.vbpq.RequiredLoaiVanBanException();
		}

		if (className.equals("com.viettel.portal.vbpq.VanBanFileException")) {
			return new com.viettel.portal.vbpq.VanBanFileException();
		}

		if (className.equals("com.viettel.portal.vbpq.VanBanTenException")) {
			return new com.viettel.portal.vbpq.VanBanTenException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.NoSuchAttachFileException")) {
			return new com.viettel.portal.vbpq.NoSuchAttachFileException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException")) {
			return new com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.NoSuchLinhVucVanBanException")) {
			return new com.viettel.portal.vbpq.NoSuchLinhVucVanBanException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.NoSuchLoaiVanBanException")) {
			return new com.viettel.portal.vbpq.NoSuchLoaiVanBanException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.NoSuchNhomVanBanException")) {
			return new com.viettel.portal.vbpq.NoSuchNhomVanBanException();
		}

		if (className.equals(
					"com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException")) {
			return new com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException();
		}

		return throwable;
	}

	public static Object translateOutputAttachFile(BaseModel<?> oldModel) {
		AttachFileClp newModel = new AttachFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAttachFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCoQuanBanHanhVanBan(
		BaseModel<?> oldModel) {
		CoQuanBanHanhVanBanClp newModel = new CoQuanBanHanhVanBanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCoQuanBanHanhVanBanRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLinhVucVanBan(BaseModel<?> oldModel) {
		LinhVucVanBanClp newModel = new LinhVucVanBanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLinhVucVanBanRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLoaiVanBan(BaseModel<?> oldModel) {
		LoaiVanBanClp newModel = new LoaiVanBanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLoaiVanBanRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNhomVanBan(BaseModel<?> oldModel) {
		NhomVanBanClp newModel = new NhomVanBanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNhomVanBanRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVanBanPhapQuy(BaseModel<?> oldModel) {
		VanBanPhapQuyClp newModel = new VanBanPhapQuyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVanBanPhapQuyRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}