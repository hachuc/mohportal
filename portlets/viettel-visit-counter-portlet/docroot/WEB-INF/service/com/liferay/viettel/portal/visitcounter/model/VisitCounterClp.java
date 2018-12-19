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
import com.liferay.viettel.portal.visitcounter.service.VisitCounterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hiepth6
 */
public class VisitCounterClp extends BaseModelImpl<VisitCounter>
	implements VisitCounter {
	public VisitCounterClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VisitCounter.class;
	}

	@Override
	public String getModelClassName() {
		return VisitCounter.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _counterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCounterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _counterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("counterId", getCounterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("totalHitCounter", getTotalHitCounter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long counterId = (Long)attributes.get("counterId");

		if (counterId != null) {
			setCounterId(counterId);
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

		Integer totalHitCounter = (Integer)attributes.get("totalHitCounter");

		if (totalHitCounter != null) {
			setTotalHitCounter(totalHitCounter);
		}
	}

	@Override
	public long getCounterId() {
		return _counterId;
	}

	@Override
	public void setCounterId(long counterId) {
		_counterId = counterId;

		if (_visitCounterRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setCounterId", long.class);

				method.invoke(_visitCounterRemoteModel, counterId);
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

		if (_visitCounterRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_visitCounterRemoteModel, companyId);
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

		if (_visitCounterRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_visitCounterRemoteModel, groupId);
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

		if (_visitCounterRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_visitCounterRemoteModel, userId);
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

		if (_visitCounterRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_visitCounterRemoteModel, userName);
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

		if (_visitCounterRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_visitCounterRemoteModel, createDate);
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

		if (_visitCounterRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_visitCounterRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTotalHitCounter() {
		return _totalHitCounter;
	}

	@Override
	public void setTotalHitCounter(int totalHitCounter) {
		_totalHitCounter = totalHitCounter;

		if (_visitCounterRemoteModel != null) {
			try {
				Class<?> clazz = _visitCounterRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalHitCounter", int.class);

				method.invoke(_visitCounterRemoteModel, totalHitCounter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVisitCounterRemoteModel() {
		return _visitCounterRemoteModel;
	}

	public void setVisitCounterRemoteModel(BaseModel<?> visitCounterRemoteModel) {
		_visitCounterRemoteModel = visitCounterRemoteModel;
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

		Class<?> remoteModelClass = _visitCounterRemoteModel.getClass();

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

		Object returnValue = method.invoke(_visitCounterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VisitCounterLocalServiceUtil.addVisitCounter(this);
		}
		else {
			VisitCounterLocalServiceUtil.updateVisitCounter(this);
		}
	}

	@Override
	public VisitCounter toEscapedModel() {
		return (VisitCounter)ProxyUtil.newProxyInstance(VisitCounter.class.getClassLoader(),
			new Class[] { VisitCounter.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VisitCounterClp clone = new VisitCounterClp();

		clone.setCounterId(getCounterId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTotalHitCounter(getTotalHitCounter());

		return clone;
	}

	@Override
	public int compareTo(VisitCounter visitCounter) {
		int value = 0;

		if (getTotalHitCounter() < visitCounter.getTotalHitCounter()) {
			value = -1;
		}
		else if (getTotalHitCounter() > visitCounter.getTotalHitCounter()) {
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

		if (!(obj instanceof VisitCounterClp)) {
			return false;
		}

		VisitCounterClp visitCounter = (VisitCounterClp)obj;

		long primaryKey = visitCounter.getPrimaryKey();

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

		sb.append("{counterId=");
		sb.append(getCounterId());
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
		sb.append(", totalHitCounter=");
		sb.append(getTotalHitCounter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.viettel.portal.visitcounter.model.VisitCounter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>counterId</column-name><column-value><![CDATA[");
		sb.append(getCounterId());
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
			"<column><column-name>totalHitCounter</column-name><column-value><![CDATA[");
		sb.append(getTotalHitCounter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _counterId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _totalHitCounter;
	private BaseModel<?> _visitCounterRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.viettel.portal.visitcounter.service.ClpSerializer.class;
}