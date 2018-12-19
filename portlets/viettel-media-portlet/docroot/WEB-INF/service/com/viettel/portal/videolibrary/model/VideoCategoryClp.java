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

package com.viettel.portal.videolibrary.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.videolibrary.service.ClpSerializer;
import com.viettel.portal.videolibrary.service.VideoCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class VideoCategoryClp extends BaseModelImpl<VideoCategory>
	implements VideoCategory {
	public VideoCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VideoCategory.class;
	}

	@Override
	public String getModelClassName() {
		return VideoCategory.class.getName();
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
		attributes.put("Url", getUrl());
		attributes.put("SortOrder", getSortOrder());
		attributes.put("ItemCount", getItemCount());

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

		String Url = (String)attributes.get("Url");

		if (Url != null) {
			setUrl(Url);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}

		Integer ItemCount = (Integer)attributes.get("ItemCount");

		if (ItemCount != null) {
			setItemCount(ItemCount);
		}
	}

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_videoCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _videoCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_videoCategoryRemoteModel, ID);
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

		if (_videoCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _videoCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_videoCategoryRemoteModel, Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _Url;
	}

	@Override
	public void setUrl(String Url) {
		_Url = Url;

		if (_videoCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _videoCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_videoCategoryRemoteModel, Url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSortOrder() {
		return _SortOrder;
	}

	@Override
	public void setSortOrder(int SortOrder) {
		_SortOrder = SortOrder;

		if (_videoCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _videoCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSortOrder", int.class);

				method.invoke(_videoCategoryRemoteModel, SortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getItemCount() {
		return _ItemCount;
	}

	@Override
	public void setItemCount(int ItemCount) {
		_ItemCount = ItemCount;

		if (_videoCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _videoCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCount", int.class);

				method.invoke(_videoCategoryRemoteModel, ItemCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideoCategoryRemoteModel() {
		return _videoCategoryRemoteModel;
	}

	public void setVideoCategoryRemoteModel(
		BaseModel<?> videoCategoryRemoteModel) {
		_videoCategoryRemoteModel = videoCategoryRemoteModel;
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

		Class<?> remoteModelClass = _videoCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_videoCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoCategoryLocalServiceUtil.addVideoCategory(this);
		}
		else {
			VideoCategoryLocalServiceUtil.updateVideoCategory(this);
		}
	}

	@Override
	public VideoCategory toEscapedModel() {
		return (VideoCategory)ProxyUtil.newProxyInstance(VideoCategory.class.getClassLoader(),
			new Class[] { VideoCategory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoCategoryClp clone = new VideoCategoryClp();

		clone.setID(getID());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setSortOrder(getSortOrder());
		clone.setItemCount(getItemCount());

		return clone;
	}

	@Override
	public int compareTo(VideoCategory videoCategory) {
		int primaryKey = videoCategory.getPrimaryKey();

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

		if (!(obj instanceof VideoCategoryClp)) {
			return false;
		}

		VideoCategoryClp videoCategory = (VideoCategoryClp)obj;

		int primaryKey = videoCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", Url=");
		sb.append(getUrl());
		sb.append(", SortOrder=");
		sb.append(getSortOrder());
		sb.append(", ItemCount=");
		sb.append(getItemCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.videolibrary.model.VideoCategory");
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
			"<column><column-name>Url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ItemCount</column-name><column-value><![CDATA[");
		sb.append(getItemCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private String _Name;
	private String _Url;
	private int _SortOrder;
	private int _ItemCount;
	private BaseModel<?> _videoCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.videolibrary.service.ClpSerializer.class;
}