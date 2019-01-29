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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.revotech.portal.videolibrary.service.ClpSerializer;
import com.revotech.portal.videolibrary.service.VideoClipLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class VideoClipClp extends BaseModelImpl<VideoClip> implements VideoClip {
	public VideoClipClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VideoClip.class;
	}

	@Override
	public String getModelClassName() {
		return VideoClip.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _ID;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Name", getName());
		attributes.put("CategoryID", getCategoryID());
		attributes.put("Description", getDescription());
		attributes.put("ImageUrl", getImageUrl());
		attributes.put("VideoUrl", getVideoUrl());
		attributes.put("Duration", getDuration());
		attributes.put("ViewCount", getViewCount());
		attributes.put("Status", getStatus());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		Integer CategoryID = (Integer)attributes.get("CategoryID");

		if (CategoryID != null) {
			setCategoryID(CategoryID);
		}

		String Description = (String)attributes.get("Description");

		if (Description != null) {
			setDescription(Description);
		}

		String ImageUrl = (String)attributes.get("ImageUrl");

		if (ImageUrl != null) {
			setImageUrl(ImageUrl);
		}

		String VideoUrl = (String)attributes.get("VideoUrl");

		if (VideoUrl != null) {
			setVideoUrl(VideoUrl);
		}

		Integer Duration = (Integer)attributes.get("Duration");

		if (Duration != null) {
			setDuration(Duration);
		}

		Integer ViewCount = (Integer)attributes.get("ViewCount");

		if (ViewCount != null) {
			setViewCount(ViewCount);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}
	}

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_videoClipRemoteModel, ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _Name;
	}

	@Override
	public void setName(String Name) {
		_Name = Name;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_videoClipRemoteModel, Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCategoryID() {
		return _CategoryID;
	}

	@Override
	public void setCategoryID(int CategoryID) {
		_CategoryID = CategoryID;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryID", int.class);

				method.invoke(_videoClipRemoteModel, CategoryID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _Description;
	}

	@Override
	public void setDescription(String Description) {
		_Description = Description;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_videoClipRemoteModel, Description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUrl() {
		return _ImageUrl;
	}

	@Override
	public void setImageUrl(String ImageUrl) {
		_ImageUrl = ImageUrl;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_videoClipRemoteModel, ImageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVideoUrl() {
		return _VideoUrl;
	}

	@Override
	public void setVideoUrl(String VideoUrl) {
		_VideoUrl = VideoUrl;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoUrl", String.class);

				method.invoke(_videoClipRemoteModel, VideoUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDuration() {
		return _Duration;
	}

	@Override
	public void setDuration(int Duration) {
		_Duration = Duration;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", int.class);

				method.invoke(_videoClipRemoteModel, Duration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewCount() {
		return _ViewCount;
	}

	@Override
	public void setViewCount(int ViewCount) {
		_ViewCount = ViewCount;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCount", int.class);

				method.invoke(_videoClipRemoteModel, ViewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _Status;
	}

	@Override
	public void setStatus(int Status) {
		_Status = Status;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_videoClipRemoteModel, Status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreationDate() {
		return _CreationDate;
	}

	@Override
	public void setCreationDate(Date CreationDate) {
		_CreationDate = CreationDate;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_videoClipRemoteModel, CreationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;

		if (_videoClipRemoteModel != null) {
			try {
				Class<?> clazz = _videoClipRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_videoClipRemoteModel, ModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideoClipRemoteModel() {
		return _videoClipRemoteModel;
	}

	public void setVideoClipRemoteModel(BaseModel<?> videoClipRemoteModel) {
		_videoClipRemoteModel = videoClipRemoteModel;
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

		Class<?> remoteModelClass = _videoClipRemoteModel.getClass();

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

		Object returnValue = method.invoke(_videoClipRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoClipLocalServiceUtil.addVideoClip(this);
		}
		else {
			VideoClipLocalServiceUtil.updateVideoClip(this);
		}
	}

	@Override
	public VideoClip toEscapedModel() {
		return (VideoClip)ProxyUtil.newProxyInstance(VideoClip.class.getClassLoader(),
			new Class[] { VideoClip.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoClipClp clone = new VideoClipClp();

		clone.setID(getID());
		clone.setName(getName());
		clone.setCategoryID(getCategoryID());
		clone.setDescription(getDescription());
		clone.setImageUrl(getImageUrl());
		clone.setVideoUrl(getVideoUrl());
		clone.setDuration(getDuration());
		clone.setViewCount(getViewCount());
		clone.setStatus(getStatus());
		clone.setCreationDate(getCreationDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(VideoClip videoClip) {
		int primaryKey = videoClip.getPrimaryKey();

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

		if (!(obj instanceof VideoClipClp)) {
			return false;
		}

		VideoClipClp videoClip = (VideoClipClp)obj;

		int primaryKey = videoClip.getPrimaryKey();

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
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", CategoryID=");
		sb.append(getCategoryID());
		sb.append(", Description=");
		sb.append(getDescription());
		sb.append(", ImageUrl=");
		sb.append(getImageUrl());
		sb.append(", VideoUrl=");
		sb.append(getVideoUrl());
		sb.append(", Duration=");
		sb.append(getDuration());
		sb.append(", ViewCount=");
		sb.append(getViewCount());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.revotech.portal.videolibrary.model.VideoClip");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CategoryID</column-name><column-value><![CDATA[");
		sb.append(getCategoryID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ImageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>VideoUrl</column-name><column-value><![CDATA[");
		sb.append(getVideoUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ViewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreationDate</column-name><column-value><![CDATA[");
		sb.append(getCreationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private String _Name;
	private int _CategoryID;
	private String _Description;
	private String _ImageUrl;
	private String _VideoUrl;
	private int _Duration;
	private int _ViewCount;
	private int _Status;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private BaseModel<?> _videoClipRemoteModel;
	private Class<?> _clpSerializerClass = com.revotech.portal.videolibrary.service.ClpSerializer.class;
}