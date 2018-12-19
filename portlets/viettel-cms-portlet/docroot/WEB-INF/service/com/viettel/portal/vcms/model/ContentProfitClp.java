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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.viettel.portal.vcms.service.ClpSerializer;
import com.viettel.portal.vcms.service.ContentProfitLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class ContentProfitClp extends BaseModelImpl<ContentProfit>
	implements ContentProfit {
	public ContentProfitClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContentProfit.class;
	}

	@Override
	public String getModelClassName() {
		return ContentProfit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentId", getContentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("distributedDate", getDistributedDate());
		attributes.put("contentTypeID", getContentTypeID());
		attributes.put("headline", getHeadline());
		attributes.put("cost", getCost());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
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

		Date distributedDate = (Date)attributes.get("distributedDate");

		if (distributedDate != null) {
			setDistributedDate(distributedDate);
		}

		Long contentTypeID = (Long)attributes.get("contentTypeID");

		if (contentTypeID != null) {
			setContentTypeID(contentTypeID);
		}

		String headline = (String)attributes.get("headline");

		if (headline != null) {
			setHeadline(headline);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getContentId() {
		return _contentId;
	}

	@Override
	public void setContentId(long contentId) {
		_contentId = contentId;

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setContentId", long.class);

				method.invoke(_contentProfitRemoteModel, contentId);
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

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contentProfitRemoteModel, groupId);
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

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contentProfitRemoteModel, companyId);
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

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_contentProfitRemoteModel, userId);
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

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_contentProfitRemoteModel, userName);
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

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_contentProfitRemoteModel, createDate);
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

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_contentProfitRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDistributedDate() {
		return _distributedDate;
	}

	@Override
	public void setDistributedDate(Date distributedDate) {
		_distributedDate = distributedDate;

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setDistributedDate", Date.class);

				method.invoke(_contentProfitRemoteModel, distributedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContentTypeID() {
		return _contentTypeID;
	}

	@Override
	public void setContentTypeID(long contentTypeID) {
		_contentTypeID = contentTypeID;

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setContentTypeID", long.class);

				method.invoke(_contentProfitRemoteModel, contentTypeID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHeadline() {
		return _headline;
	}

	@Override
	public void setHeadline(String headline) {
		_headline = headline;

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadline", String.class);

				method.invoke(_contentProfitRemoteModel, headline);
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

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setCost", double.class);

				method.invoke(_contentProfitRemoteModel, cost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_contentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _contentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_contentProfitRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContentProfitRemoteModel() {
		return _contentProfitRemoteModel;
	}

	public void setContentProfitRemoteModel(
		BaseModel<?> contentProfitRemoteModel) {
		_contentProfitRemoteModel = contentProfitRemoteModel;
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

		Class<?> remoteModelClass = _contentProfitRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contentProfitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContentProfitLocalServiceUtil.addContentProfit(this);
		}
		else {
			ContentProfitLocalServiceUtil.updateContentProfit(this);
		}
	}

	@Override
	public ContentProfit toEscapedModel() {
		return (ContentProfit)ProxyUtil.newProxyInstance(ContentProfit.class.getClassLoader(),
			new Class[] { ContentProfit.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContentProfitClp clone = new ContentProfitClp();

		clone.setContentId(getContentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDistributedDate(getDistributedDate());
		clone.setContentTypeID(getContentTypeID());
		clone.setHeadline(getHeadline());
		clone.setCost(getCost());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(ContentProfit contentProfit) {
		int value = 0;

		value = DateUtil.compareTo(getDistributedDate(),
				contentProfit.getDistributedDate());

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

		if (!(obj instanceof ContentProfitClp)) {
			return false;
		}

		ContentProfitClp contentProfit = (ContentProfitClp)obj;

		long primaryKey = contentProfit.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{contentId=");
		sb.append(getContentId());
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
		sb.append(", distributedDate=");
		sb.append(getDistributedDate());
		sb.append(", contentTypeID=");
		sb.append(getContentTypeID());
		sb.append(", headline=");
		sb.append(getHeadline());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.ContentProfit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contentId</column-name><column-value><![CDATA[");
		sb.append(getContentId());
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
			"<column><column-name>distributedDate</column-name><column-value><![CDATA[");
		sb.append(getDistributedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentTypeID</column-name><column-value><![CDATA[");
		sb.append(getContentTypeID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>headline</column-name><column-value><![CDATA[");
		sb.append(getHeadline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _distributedDate;
	private long _contentTypeID;
	private String _headline;
	private double _cost;
	private int _status;
	private BaseModel<?> _contentProfitRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}