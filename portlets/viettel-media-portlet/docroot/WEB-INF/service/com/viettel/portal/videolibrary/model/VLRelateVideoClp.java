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
import com.viettel.portal.videolibrary.service.VLRelateVideoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class VLRelateVideoClp extends BaseModelImpl<VLRelateVideo>
	implements VLRelateVideo {
	public VLRelateVideoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VLRelateVideo.class;
	}

	@Override
	public String getModelClassName() {
		return VLRelateVideo.class.getName();
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
		attributes.put("videoId", getVideoId());
		attributes.put("relateId", getRelateId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long relateId = (Long)attributes.get("relateId");

		if (relateId != null) {
			setRelateId(relateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_vlRelateVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlRelateVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_vlRelateVideoRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_videoId = videoId;

		if (_vlRelateVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlRelateVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_vlRelateVideoRemoteModel, videoId);
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

		if (_vlRelateVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlRelateVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setRelateId", long.class);

				method.invoke(_vlRelateVideoRemoteModel, relateId);
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

		if (_vlRelateVideoRemoteModel != null) {
			try {
				Class<?> clazz = _vlRelateVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vlRelateVideoRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVLRelateVideoRemoteModel() {
		return _vlRelateVideoRemoteModel;
	}

	public void setVLRelateVideoRemoteModel(
		BaseModel<?> vlRelateVideoRemoteModel) {
		_vlRelateVideoRemoteModel = vlRelateVideoRemoteModel;
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

		Class<?> remoteModelClass = _vlRelateVideoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vlRelateVideoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VLRelateVideoLocalServiceUtil.addVLRelateVideo(this);
		}
		else {
			VLRelateVideoLocalServiceUtil.updateVLRelateVideo(this);
		}
	}

	@Override
	public VLRelateVideo toEscapedModel() {
		return (VLRelateVideo)ProxyUtil.newProxyInstance(VLRelateVideo.class.getClassLoader(),
			new Class[] { VLRelateVideo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VLRelateVideoClp clone = new VLRelateVideoClp();

		clone.setId(getId());
		clone.setVideoId(getVideoId());
		clone.setRelateId(getRelateId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(VLRelateVideo vlRelateVideo) {
		long primaryKey = vlRelateVideo.getPrimaryKey();

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

		if (!(obj instanceof VLRelateVideoClp)) {
			return false;
		}

		VLRelateVideoClp vlRelateVideo = (VLRelateVideoClp)obj;

		long primaryKey = vlRelateVideo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", relateId=");
		sb.append(getRelateId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.videolibrary.model.VLRelateVideo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relateId</column-name><column-value><![CDATA[");
		sb.append(getRelateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _videoId;
	private long _relateId;
	private long _groupId;
	private BaseModel<?> _vlRelateVideoRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.videolibrary.service.ClpSerializer.class;
}