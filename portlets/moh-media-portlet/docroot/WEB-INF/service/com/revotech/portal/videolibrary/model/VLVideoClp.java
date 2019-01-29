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

package com.revotech.portal.videolibrary.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.revotech.portal.videolibrary.service.ClpSerializer;
import com.revotech.portal.videolibrary.service.VLVideoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class VLVideoClp extends BaseModelImpl<VLVideo> implements VLVideo {
	public VLVideoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VLVideo.class;
	}

	@Override
	public String getModelClassName() {
		return VLVideo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _videoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoId", getVideoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("videoName", getVideoName());
		attributes.put("description", getDescription());
		attributes.put("videoType", getVideoType());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("viewCount", getViewCount());
		attributes.put("fileId", getFileId());
		attributes.put("image", getImage());
		attributes.put("imageId", getImageId());
		attributes.put("smallImageUrl", getSmallImageUrl());
		attributes.put("relateId", getRelateId());
		attributes.put("invisible", getInvisible());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String videoName = (String)attributes.get("videoName");

		if (videoName != null) {
			setVideoName(videoName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String videoType = (String)attributes.get("videoType");

		if (videoType != null) {
			setVideoType(videoType);
		}

		String videoUrl = (String)attributes.get("videoUrl");

		if (videoUrl != null) {
			setVideoUrl(videoUrl);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		Boolean image = (Boolean)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String smallImageUrl = (String)attributes.get("smallImageUrl");

		if (smallImageUrl != null) {
			setSmallImageUrl(smallImageUrl);
		}

		Long relateId = (Long)attributes.get("relateId");

		if (relateId != null) {
			setRelateId(relateId);
		}

		Boolean invisible = (Boolean)attributes.get("invisible");

		if (invisible != null) {
			setInvisible(invisible);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_videoId = videoId;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_vlVideoRemoteModel, videoId);
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

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vlVideoRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_vlVideoRemoteModel, companyId);
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

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vlVideoRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_vlVideoRemoteModel, userName);
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

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_vlVideoRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_vlVideoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVideoName() {
		return _videoName;
	}

	@Override
	public void setVideoName(String videoName) {
		_videoName = videoName;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoName", String.class);

				method.invoke(_vlVideoRemoteModel, videoName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_vlVideoRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVideoType() {
		return _videoType;
	}

	@Override
	public void setVideoType(String videoType) {
		_videoType = videoType;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoType", String.class);

				method.invoke(_vlVideoRemoteModel, videoType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVideoUrl() {
		return _videoUrl;
	}

	@Override
	public void setVideoUrl(String videoUrl) {
		_videoUrl = videoUrl;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoUrl", String.class);

				method.invoke(_vlVideoRemoteModel, videoUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewCount() {
		return _viewCount;
	}

	@Override
	public void setViewCount(int viewCount) {
		_viewCount = viewCount;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCount", int.class);

				method.invoke(_vlVideoRemoteModel, viewCount);
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

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setFileId", long.class);

				method.invoke(_vlVideoRemoteModel, fileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getImage() {
		return _image;
	}

	@Override
	public boolean isImage() {
		return _image;
	}

	@Override
	public void setImage(boolean image) {
		_image = image;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setImage", boolean.class);

				method.invoke(_vlVideoRemoteModel, image);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImageId() {
		return _imageId;
	}

	@Override
	public void setImageId(long imageId) {
		_imageId = imageId;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setImageId", long.class);

				method.invoke(_vlVideoRemoteModel, imageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSmallImageUrl() {
		return _smallImageUrl;
	}

	@Override
	public void setSmallImageUrl(String smallImageUrl) {
		_smallImageUrl = smallImageUrl;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImageUrl", String.class);

				method.invoke(_vlVideoRemoteModel, smallImageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRelateId() {
		return _relateId;
	}

	@Override
	public void setRelateId(long relateId) {
		_relateId = relateId;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setRelateId", long.class);

				method.invoke(_vlVideoRemoteModel, relateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getInvisible() {
		return _invisible;
	}

	@Override
	public boolean isInvisible() {
		return _invisible;
	}

	@Override
	public void setInvisible(boolean invisible) {
		_invisible = invisible;

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setInvisible", boolean.class);

				method.invoke(_vlVideoRemoteModel, invisible);
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

		if (_vlVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_vlVideoRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVLVideoRemoteModel() {
		return _vlVideoRemoteModel;
	}

	public void setVLVideoRemoteModel(BaseModel<?> vlVideoRemoteModel) {
		_vlVideoRemoteModel = vlVideoRemoteModel;
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

		Class<?> remoteModelClass = _vlVideoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vlVideoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VLVideoLocalServiceUtil.addVLVideo(this);
		}
		else {
			VLVideoLocalServiceUtil.updateVLVideo(this);
		}
	}

	@Override
	public VLVideo toEscapedModel() {
		return (VLVideo)ProxyUtil.newProxyInstance(VLVideo.class.getClassLoader(),
			new Class[] { VLVideo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VLVideoClp clone = new VLVideoClp();

		clone.setVideoId(getVideoId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVideoName(getVideoName());
		clone.setDescription(getDescription());
		clone.setVideoType(getVideoType());
		clone.setVideoUrl(getVideoUrl());
		clone.setViewCount(getViewCount());
		clone.setFileId(getFileId());
		clone.setImage(getImage());
		clone.setImageId(getImageId());
		clone.setSmallImageUrl(getSmallImageUrl());
		clone.setRelateId(getRelateId());
		clone.setInvisible(getInvisible());
		clone.setCategoryId(getCategoryId());

		return clone;
	}

	@Override
	public int compareTo(VLVideo vlVideo) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(), vlVideo.getModifiedDate());

		value = value * -1;

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

		if (!(obj instanceof VLVideoClp)) {
			return false;
		}

		VLVideoClp vlVideo = (VLVideoClp)obj;

		long primaryKey = vlVideo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{videoId=");
		sb.append(getVideoId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", videoName=");
		sb.append(getVideoName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", videoType=");
		sb.append(getVideoType());
		sb.append(", videoUrl=");
		sb.append(getVideoUrl());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append(", smallImageUrl=");
		sb.append(getSmallImageUrl());
		sb.append(", relateId=");
		sb.append(getRelateId());
		sb.append(", invisible=");
		sb.append(getInvisible());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.revotech.portal.videolibrary.model.VLVideo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoName</column-name><column-value><![CDATA[");
		sb.append(getVideoName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoType</column-name><column-value><![CDATA[");
		sb.append(getVideoType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoUrl</column-name><column-value><![CDATA[");
		sb.append(getVideoUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageUrl</column-name><column-value><![CDATA[");
		sb.append(getSmallImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relateId</column-name><column-value><![CDATA[");
		sb.append(getRelateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invisible</column-name><column-value><![CDATA[");
		sb.append(getInvisible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _videoName;
	private String _description;
	private String _videoType;
	private String _videoUrl;
	private int _viewCount;
	private long _fileId;
	private boolean _image;
	private long _imageId;
	private String _smallImageUrl;
	private long _relateId;
	private boolean _invisible;
	private long _categoryId;
	private BaseModel<?> _vlVideoRemoteModel;
	private Class<?> _clpSerializerClass = com.revotech.portal.videolibrary.service.ClpSerializer.class;
}