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

package com.viettel.portal.thongke.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.viettel.portal.thongke.service.ClpSerializer;
import com.viettel.portal.thongke.service.PhongBanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lamvn
 */
public class PhongBanClp extends BaseModelImpl<PhongBan> implements PhongBan {
	public PhongBanClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PhongBan.class;
	}

	@Override
	public String getModelClassName() {
		return PhongBan.class.getName();
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
		attributes.put("name", getName());
		attributes.put("order_", getOrder_());
		attributes.put("descriptions", getDescriptions());
		attributes.put("status", getStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer order_ = (Integer)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		String descriptions = (String)attributes.get("descriptions");

		if (descriptions != null) {
			setDescriptions(descriptions);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_phongBanRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_phongBanRemoteModel, name);
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

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder_", int.class);

				method.invoke(_phongBanRemoteModel, order_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescriptions() {
		return _descriptions;
	}

	@Override
	public void setDescriptions(String descriptions) {
		_descriptions = descriptions;

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setDescriptions", String.class);

				method.invoke(_phongBanRemoteModel, descriptions);
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

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_phongBanRemoteModel, status);
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

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_phongBanRemoteModel, companyId);
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

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_phongBanRemoteModel, groupId);
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

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_phongBanRemoteModel, createDate);
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

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setModifyDate", Date.class);

				method.invoke(_phongBanRemoteModel, modifyDate);
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

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_phongBanRemoteModel, userName);
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

		if (_phongBanRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_phongBanRemoteModel, userId);
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

	public BaseModel<?> getPhongBanRemoteModel() {
		return _phongBanRemoteModel;
	}

	public void setPhongBanRemoteModel(BaseModel<?> phongBanRemoteModel) {
		_phongBanRemoteModel = phongBanRemoteModel;
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

		Class<?> remoteModelClass = _phongBanRemoteModel.getClass();

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

		Object returnValue = method.invoke(_phongBanRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PhongBanLocalServiceUtil.addPhongBan(this);
		}
		else {
			PhongBanLocalServiceUtil.updatePhongBan(this);
		}
	}

	@Override
	public PhongBan toEscapedModel() {
		return (PhongBan)ProxyUtil.newProxyInstance(PhongBan.class.getClassLoader(),
			new Class[] { PhongBan.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PhongBanClp clone = new PhongBanClp();

		clone.setId(getId());
		clone.setName(getName());
		clone.setOrder_(getOrder_());
		clone.setDescriptions(getDescriptions());
		clone.setStatus(getStatus());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());
		clone.setUserName(getUserName());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(PhongBan phongBan) {
		int value = 0;

		if (getOrder_() < phongBan.getOrder_()) {
			value = -1;
		}
		else if (getOrder_() > phongBan.getOrder_()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), phongBan.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(phongBan.getName());

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

		if (!(obj instanceof PhongBanClp)) {
			return false;
		}

		PhongBanClp phongBan = (PhongBanClp)obj;

		long primaryKey = phongBan.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", order_=");
		sb.append(getOrder_());
		sb.append(", descriptions=");
		sb.append(getDescriptions());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.thongke.model.PhongBan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order_</column-name><column-value><![CDATA[");
		sb.append(getOrder_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descriptions</column-name><column-value><![CDATA[");
		sb.append(getDescriptions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _name;
	private int _order_;
	private String _descriptions;
	private boolean _status;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifyDate;
	private String _userName;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _phongBanRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.thongke.service.ClpSerializer.class;
}