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

package com.viettel.portal.vbpq.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.vbpq.service.AttachFileLocalServiceUtil;
import com.viettel.portal.vbpq.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class AttachFileClp extends BaseModelImpl<AttachFile>
	implements AttachFile {
	public AttachFileClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AttachFile.class;
	}

	@Override
	public String getModelClassName() {
		return AttachFile.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("vanBanId", getVanBanId());
		attributes.put("fileId", getFileId());
		attributes.put("fileLink", getFileLink());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long vanBanId = (Long)attributes.get("vanBanId");

		if (vanBanId != null) {
			setVanBanId(vanBanId);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileLink = (String)attributes.get("fileLink");

		if (fileLink != null) {
			setFileLink(fileLink);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_attachFileRemoteModel != null) {
			try {
				Class<?> clazz = _attachFileRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_attachFileRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVanBanId() {
		return _vanBanId;
	}

	@Override
	public void setVanBanId(long vanBanId) {
		_vanBanId = vanBanId;

		if (_attachFileRemoteModel != null) {
			try {
				Class<?> clazz = _attachFileRemoteModel.getClass();

				Method method = clazz.getMethod("setVanBanId", long.class);

				method.invoke(_attachFileRemoteModel, vanBanId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		_fileId = fileId;

		if (_attachFileRemoteModel != null) {
			try {
				Class<?> clazz = _attachFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFileId", long.class);

				method.invoke(_attachFileRemoteModel, fileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileLink() {
		return _fileLink;
	}

	@Override
	public void setFileLink(String fileLink) {
		_fileLink = fileLink;

		if (_attachFileRemoteModel != null) {
			try {
				Class<?> clazz = _attachFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFileLink", String.class);

				method.invoke(_attachFileRemoteModel, fileLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_attachFileRemoteModel != null) {
			try {
				Class<?> clazz = _attachFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_attachFileRemoteModel, fileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileSize() {
		return _fileSize;
	}

	@Override
	public void setFileSize(String fileSize) {
		_fileSize = fileSize;

		if (_attachFileRemoteModel != null) {
			try {
				Class<?> clazz = _attachFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFileSize", String.class);

				method.invoke(_attachFileRemoteModel, fileSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAttachFileRemoteModel() {
		return _attachFileRemoteModel;
	}

	public void setAttachFileRemoteModel(BaseModel<?> attachFileRemoteModel) {
		_attachFileRemoteModel = attachFileRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _attachFileRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_attachFileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AttachFileLocalServiceUtil.addAttachFile(this);
		}
		else {
			AttachFileLocalServiceUtil.updateAttachFile(this);
		}
	}

	@Override
	public AttachFile toEscapedModel() {
		return (AttachFile)ProxyUtil.newProxyInstance(AttachFile.class.getClassLoader(),
			new Class[] { AttachFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AttachFileClp clone = new AttachFileClp();

		clone.setId(getId());
		clone.setVanBanId(getVanBanId());
		clone.setFileId(getFileId());
		clone.setFileLink(getFileLink());
		clone.setFileName(getFileName());
		clone.setFileSize(getFileSize());

		return clone;
	}

	@Override
	public int compareTo(AttachFile attachFile) {
		long primaryKey = attachFile.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachFileClp)) {
			return false;
		}

		AttachFileClp attachFile = (AttachFileClp)obj;

		long primaryKey = attachFile.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", vanBanId=");
		sb.append(getVanBanId());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", fileLink=");
		sb.append(getFileLink());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileSize=");
		sb.append(getFileSize());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vbpq.model.AttachFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vanBanId</column-name><column-value><![CDATA[");
		sb.append(getVanBanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileLink</column-name><column-value><![CDATA[");
		sb.append(getFileLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileSize</column-name><column-value><![CDATA[");
		sb.append(getFileSize());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _vanBanId;
	private long _fileId;
	private String _fileLink;
	private String _fileName;
	private String _fileSize;
	private BaseModel<?> _attachFileRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vbpq.service.ClpSerializer.class;
}