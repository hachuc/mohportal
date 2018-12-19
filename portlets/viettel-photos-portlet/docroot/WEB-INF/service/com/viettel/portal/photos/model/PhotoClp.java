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

package com.viettel.portal.photos.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.viettel.portal.photos.service.ClpSerializer;
import com.viettel.portal.photos.service.PhotoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class PhotoClp extends BaseModelImpl<Photo> implements Photo {
	public PhotoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Photo.class;
	}

	@Override
	public String getModelClassName() {
		return Photo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _photoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPhotoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _photoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("photoId", getPhotoId());
		attributes.put("caption", getCaption());
		attributes.put("fileId", getFileId());
		attributes.put("fileLink", getFileLink());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("order_", getOrder_());
		attributes.put("status", getStatus());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long photoId = (Long)attributes.get("photoId");

		if (photoId != null) {
			setPhotoId(photoId);
		}

		String caption = (String)attributes.get("caption");

		if (caption != null) {
			setCaption(caption);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Integer order_ = (Integer)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getPhotoId() {
		return _photoId;
	}

	@Override
	public void setPhotoId(long photoId) {
		_photoId = photoId;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setPhotoId", long.class);

				method.invoke(_photoRemoteModel, photoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCaption() {
		return _caption;
	}

	@Override
	public void setCaption(String caption) {
		_caption = caption;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setCaption", String.class);

				method.invoke(_photoRemoteModel, caption);
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

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setFileId", long.class);

				method.invoke(_photoRemoteModel, fileId);
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

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setFileLink", String.class);

				method.invoke(_photoRemoteModel, fileLink);
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

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_photoRemoteModel, fileName);
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

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setFileSize", String.class);

				method.invoke(_photoRemoteModel, fileSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_photoRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifyDate() {
		return _modifyDate;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifyDate", Date.class);

				method.invoke(_photoRemoteModel, modifyDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOrder_() {
		return _order_;
	}

	@Override
	public void setOrder_(int order_) {
		_order_ = order_;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder_", int.class);

				method.invoke(_photoRemoteModel, order_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_photoRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_photoRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_photoRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_photoRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_photoRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_photoRemoteModel != null) {
			try {
				Class<?> clazz = _photoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_photoRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPhotoRemoteModel() {
		return _photoRemoteModel;
	}

	public void setPhotoRemoteModel(BaseModel<?> photoRemoteModel) {
		_photoRemoteModel = photoRemoteModel;
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

		Class<?> remoteModelClass = _photoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_photoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PhotoLocalServiceUtil.addPhoto(this);
		}
		else {
			PhotoLocalServiceUtil.updatePhoto(this);
		}
	}

	@Override
	public Photo toEscapedModel() {
		return (Photo)ProxyUtil.newProxyInstance(Photo.class.getClassLoader(),
			new Class[] { Photo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PhotoClp clone = new PhotoClp();

		clone.setPhotoId(getPhotoId());
		clone.setCaption(getCaption());
		clone.setFileId(getFileId());
		clone.setFileLink(getFileLink());
		clone.setFileName(getFileName());
		clone.setFileSize(getFileSize());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());
		clone.setOrder_(getOrder_());
		clone.setStatus(getStatus());
		clone.setUserName(getUserName());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setCategoryId(getCategoryId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(Photo photo) {
		int value = 0;

		if (getOrder_() < photo.getOrder_()) {
			value = -1;
		}
		else if (getOrder_() > photo.getOrder_()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), photo.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getCaption().compareTo(photo.getCaption());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhotoClp)) {
			return false;
		}

		PhotoClp photo = (PhotoClp)obj;

		long primaryKey = photo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{photoId=");
		sb.append(getPhotoId());
		sb.append(", caption=");
		sb.append(getCaption());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", fileLink=");
		sb.append(getFileLink());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileSize=");
		sb.append(getFileSize());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", order_=");
		sb.append(getOrder_());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.photos.model.Photo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>photoId</column-name><column-value><![CDATA[");
		sb.append(getPhotoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>caption</column-name><column-value><![CDATA[");
		sb.append(getCaption());
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
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order_</column-name><column-value><![CDATA[");
		sb.append(getOrder_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _photoId;
	private String _caption;
	private long _fileId;
	private String _fileLink;
	private String _fileName;
	private String _fileSize;
	private Date _createDate;
	private Date _modifyDate;
	private int _order_;
	private boolean _status;
	private String _userName;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _categoryId;
	private long _groupId;
	private BaseModel<?> _photoRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.photos.service.ClpSerializer.class;
}