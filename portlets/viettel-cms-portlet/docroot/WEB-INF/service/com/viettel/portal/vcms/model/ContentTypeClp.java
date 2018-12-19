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

package com.viettel.portal.vcms.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.viettel.portal.vcms.service.ClpSerializer;
import com.viettel.portal.vcms.service.ContentTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class ContentTypeClp extends BaseModelImpl<ContentType>
	implements ContentType {
	public ContentTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContentType.class;
	}

	@Override
	public String getModelClassName() {
		return ContentType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contenTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContenTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contenTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contenTypeId", getContenTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("sortOrder", getSortOrder());
		attributes.put("cost", getCost());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contenTypeId = (Long)attributes.get("contenTypeId");

		if (contenTypeId != null) {
			setContenTypeId(contenTypeId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer sortOrder = (Integer)attributes.get("sortOrder");

		if (sortOrder != null) {
			setSortOrder(sortOrder);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}
	}

	@Override
	public long getContenTypeId() {
		return _contenTypeId;
	}

	@Override
	public void setContenTypeId(long contenTypeId) {
		_contenTypeId = contenTypeId;

		if (_contentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setContenTypeId", long.class);

				method.invoke(_contentTypeRemoteModel, contenTypeId);
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

		if (_contentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contentTypeRemoteModel, groupId);
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

		if (_contentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contentTypeRemoteModel, companyId);
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

		if (_contentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_contentTypeRemoteModel, userId);
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
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_contentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_contentTypeRemoteModel, name);
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

		if (_contentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_contentTypeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSortOrder() {
		return _sortOrder;
	}

	@Override
	public void setSortOrder(int sortOrder) {
		_sortOrder = sortOrder;

		if (_contentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSortOrder", int.class);

				method.invoke(_contentTypeRemoteModel, sortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCost() {
		return _cost;
	}

	@Override
	public void setCost(double cost) {
		_cost = cost;

		if (_contentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCost", double.class);

				method.invoke(_contentTypeRemoteModel, cost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContentTypeRemoteModel() {
		return _contentTypeRemoteModel;
	}

	public void setContentTypeRemoteModel(BaseModel<?> contentTypeRemoteModel) {
		_contentTypeRemoteModel = contentTypeRemoteModel;
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

		Class<?> remoteModelClass = _contentTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contentTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContentTypeLocalServiceUtil.addContentType(this);
		}
		else {
			ContentTypeLocalServiceUtil.updateContentType(this);
		}
	}

	@Override
	public ContentType toEscapedModel() {
		return (ContentType)ProxyUtil.newProxyInstance(ContentType.class.getClassLoader(),
			new Class[] { ContentType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContentTypeClp clone = new ContentTypeClp();

		clone.setContenTypeId(getContenTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setSortOrder(getSortOrder());
		clone.setCost(getCost());

		return clone;
	}

	@Override
	public int compareTo(ContentType contentType) {
		int value = 0;

		if (getSortOrder() < contentType.getSortOrder()) {
			value = -1;
		}
		else if (getSortOrder() > contentType.getSortOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ContentTypeClp)) {
			return false;
		}

		ContentTypeClp contentType = (ContentTypeClp)obj;

		long primaryKey = contentType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{contenTypeId=");
		sb.append(getContenTypeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", sortOrder=");
		sb.append(getSortOrder());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.ContentType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contenTypeId</column-name><column-value><![CDATA[");
		sb.append(getContenTypeId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contenTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _description;
	private int _sortOrder;
	private double _cost;
	private BaseModel<?> _contentTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}