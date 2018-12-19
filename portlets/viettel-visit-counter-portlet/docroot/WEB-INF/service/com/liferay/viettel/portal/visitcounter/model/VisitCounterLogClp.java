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

package com.liferay.viettel.portal.visitcounter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.viettel.portal.visitcounter.service.ClpSerializer;
import com.liferay.viettel.portal.visitcounter.service.VisitCounterLogLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hiepth6
 */
public class VisitCounterLogClp extends BaseModelImpl<VisitCounterLog>
	implements VisitCounterLog {
	public VisitCounterLogClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VisitCounterLog.class;
	}

	@Override
	public String getModelClassName() {
		return VisitCounterLog.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _visitorIp;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setVisitorIp(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _visitorIp;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("visitorIp", getVisitorIp());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("hitCounter", getHitCounter());
		attributes.put("lastAccessPageId", getLastAccessPageId());
		attributes.put("lastAccessDate", getLastAccessDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String visitorIp = (String)attributes.get("visitorIp");

		if (visitorIp != null) {
			setVisitorIp(visitorIp);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Integer hitCounter = (Integer)attributes.get("hitCounter");

		if (hitCounter != null) {
			setHitCounter(hitCounter);
		}

		Long lastAccessPageId = (Long)attributes.get("lastAccessPageId");

		if (lastAccessPageId != null) {
			setLastAccessPageId(lastAccessPageId);
		}

		Date lastAccessDate = (Date)attributes.get("lastAccessDate");

		if (lastAccessDate != null) {
			setLastAccessDate(lastAccessDate);
		}
	}

	@Override
	public String getVisitorIp() {
		return _visitorIp;
	}

	@Override
	public void setVisitorIp(String visitorIp) {
		_visitorIp = visitorIp;

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setVisitorIp", String.class);

				method.invoke(_visitCounterLogRemoteModel, visitorIp);
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

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_visitCounterLogRemoteModel, companyId);
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

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_visitCounterLogRemoteModel, groupId);
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

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_visitCounterLogRemoteModel, userId);
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

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_visitCounterLogRemoteModel, userName);
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

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_visitCounterLogRemoteModel, createDate);
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

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_visitCounterLogRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHitCounter() {
		return _hitCounter;
	}

	@Override
	public void setHitCounter(int hitCounter) {
		_hitCounter = hitCounter;

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setHitCounter", int.class);

				method.invoke(_visitCounterLogRemoteModel, hitCounter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLastAccessPageId() {
		return _lastAccessPageId;
	}

	@Override
	public void setLastAccessPageId(long lastAccessPageId) {
		_lastAccessPageId = lastAccessPageId;

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setLastAccessPageId",
						long.class);

				method.invoke(_visitCounterLogRemoteModel, lastAccessPageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastAccessDate() {
		return _lastAccessDate;
	}

	@Override
	public void setLastAccessDate(Date lastAccessDate) {
		_lastAccessDate = lastAccessDate;

		if (_visitCounterLogRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterLogRemoteModel.getClass();

				Method method = clazz.getMethod("setLastAccessDate", Date.class);

				method.invoke(_visitCounterLogRemoteModel, lastAccessDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVisitCounterLogRemoteModel() {
		return _visitCounterLogRemoteModel;
	}

	public void setVisitCounterLogRemoteModel(
		BaseModel<?> visitCounterLogRemoteModel) {
		_visitCounterLogRemoteModel = visitCounterLogRemoteModel;
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

		Class<?> remoteModelClass = _visitCounterLogRemoteModel.getClass();

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

		Object returnValue = method.invoke(_visitCounterLogRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VisitCounterLogLocalServiceUtil.addVisitCounterLog(this);
		}
		else {
			VisitCounterLogLocalServiceUtil.updateVisitCounterLog(this);
		}
	}

	@Override
	public VisitCounterLog toEscapedModel() {
		return (VisitCounterLog)ProxyUtil.newProxyInstance(VisitCounterLog.class.getClassLoader(),
			new Class[] { VisitCounterLog.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VisitCounterLogClp clone = new VisitCounterLogClp();

		clone.setVisitorIp(getVisitorIp());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setHitCounter(getHitCounter());
		clone.setLastAccessPageId(getLastAccessPageId());
		clone.setLastAccessDate(getLastAccessDate());

		return clone;
	}

	@Override
	public int compareTo(VisitCounterLog visitCounterLog) {
		int value = 0;

		if (getHitCounter() < visitCounterLog.getHitCounter()) {
			value = -1;
		}
		else if (getHitCounter() > visitCounterLog.getHitCounter()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof VisitCounterLogClp)) {
			return false;
		}

		VisitCounterLogClp visitCounterLog = (VisitCounterLogClp)obj;

		String primaryKey = visitCounterLog.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{visitorIp=");
		sb.append(getVisitorIp());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", hitCounter=");
		sb.append(getHitCounter());
		sb.append(", lastAccessPageId=");
		sb.append(getLastAccessPageId());
		sb.append(", lastAccessDate=");
		sb.append(getLastAccessDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.viettel.portal.visitcounter.model.VisitCounterLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>visitorIp</column-name><column-value><![CDATA[");
		sb.append(getVisitorIp());
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
			"<column><column-name>hitCounter</column-name><column-value><![CDATA[");
		sb.append(getHitCounter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastAccessPageId</column-name><column-value><![CDATA[");
		sb.append(getLastAccessPageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastAccessDate</column-name><column-value><![CDATA[");
		sb.append(getLastAccessDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _visitorIp;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _hitCounter;
	private long _lastAccessPageId;
	private Date _lastAccessDate;
	private BaseModel<?> _visitCounterLogRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.viettel.portal.visitcounter.service.ClpSerializer.class;
}