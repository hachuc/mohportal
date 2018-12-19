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
import com.viettel.portal.vcms.service.DistributionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class DistributionClp extends BaseModelImpl<Distribution>
	implements Distribution {
	public DistributionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Distribution.class;
	}

	@Override
	public String getModelClassName() {
		return Distribution.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _distributionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDistributionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _distributionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("distributionId", getDistributionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("version", getVersion());
		attributes.put("subversion", getSubversion());
		attributes.put("contentId", getContentId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("distributedDate", getDistributedDate());
		attributes.put("allowDiscussion", getAllowDiscussion());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long distributionId = (Long)attributes.get("distributionId");

		if (distributionId != null) {
			setDistributionId(distributionId);
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

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Float subversion = (Float)attributes.get("subversion");

		if (subversion != null) {
			setSubversion(subversion);
		}

		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Date distributedDate = (Date)attributes.get("distributedDate");

		if (distributedDate != null) {
			setDistributedDate(distributedDate);
		}

		Boolean allowDiscussion = (Boolean)attributes.get("allowDiscussion");

		if (allowDiscussion != null) {
			setAllowDiscussion(allowDiscussion);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	@Override
	public long getDistributionId() {
		return _distributionId;
	}

	@Override
	public void setDistributionId(long distributionId) {
		_distributionId = distributionId;

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setDistributionId", long.class);

				method.invoke(_distributionRemoteModel, distributionId);
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

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_distributionRemoteModel, groupId);
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

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_distributionRemoteModel, companyId);
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

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_distributionRemoteModel, userId);
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

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_distributionRemoteModel, userName);
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

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_distributionRemoteModel, createDate);
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

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_distributionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVersion() {
		return _version;
	}

	@Override
	public void setVersion(int version) {
		_version = version;

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", int.class);

				method.invoke(_distributionRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getSubversion() {
		return _subversion;
	}

	@Override
	public void setSubversion(float subversion) {
		_subversion = subversion;

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setSubversion", float.class);

				method.invoke(_distributionRemoteModel, subversion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContentId() {
		return _contentId;
	}

	@Override
	public void setContentId(long contentId) {
		_contentId = contentId;

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setContentId", long.class);

				method.invoke(_distributionRemoteModel, contentId);
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

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_distributionRemoteModel, categoryId);
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

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setDistributedDate", Date.class);

				method.invoke(_distributionRemoteModel, distributedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAllowDiscussion() {
		return _allowDiscussion;
	}

	@Override
	public boolean isAllowDiscussion() {
		return _allowDiscussion;
	}

	@Override
	public void setAllowDiscussion(boolean allowDiscussion) {
		_allowDiscussion = allowDiscussion;

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setAllowDiscussion",
						boolean.class);

				method.invoke(_distributionRemoteModel, allowDiscussion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_distributionRemoteModel != null) {
			try {
				Class<?> clazz = _distributionRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_distributionRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDistributionRemoteModel() {
		return _distributionRemoteModel;
	}

	public void setDistributionRemoteModel(BaseModel<?> distributionRemoteModel) {
		_distributionRemoteModel = distributionRemoteModel;
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

		Class<?> remoteModelClass = _distributionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_distributionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DistributionLocalServiceUtil.addDistribution(this);
		}
		else {
			DistributionLocalServiceUtil.updateDistribution(this);
		}
	}

	@Override
	public Distribution toEscapedModel() {
		return (Distribution)ProxyUtil.newProxyInstance(Distribution.class.getClassLoader(),
			new Class[] { Distribution.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DistributionClp clone = new DistributionClp();

		clone.setDistributionId(getDistributionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVersion(getVersion());
		clone.setSubversion(getSubversion());
		clone.setContentId(getContentId());
		clone.setCategoryId(getCategoryId());
		clone.setDistributedDate(getDistributedDate());
		clone.setAllowDiscussion(getAllowDiscussion());
		clone.setTitle(getTitle());

		return clone;
	}

	@Override
	public int compareTo(Distribution distribution) {
		int value = 0;

		value = DateUtil.compareTo(getDistributedDate(),
				distribution.getDistributedDate());

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

		if (!(obj instanceof DistributionClp)) {
			return false;
		}

		DistributionClp distribution = (DistributionClp)obj;

		long primaryKey = distribution.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{distributionId=");
		sb.append(getDistributionId());
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
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", subversion=");
		sb.append(getSubversion());
		sb.append(", contentId=");
		sb.append(getContentId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", distributedDate=");
		sb.append(getDistributedDate());
		sb.append(", allowDiscussion=");
		sb.append(getAllowDiscussion());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Distribution");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>distributionId</column-name><column-value><![CDATA[");
		sb.append(getDistributionId());
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
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subversion</column-name><column-value><![CDATA[");
		sb.append(getSubversion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentId</column-name><column-value><![CDATA[");
		sb.append(getContentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>distributedDate</column-name><column-value><![CDATA[");
		sb.append(getDistributedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allowDiscussion</column-name><column-value><![CDATA[");
		sb.append(getAllowDiscussion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _distributionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _version;
	private float _subversion;
	private long _contentId;
	private long _categoryId;
	private Date _distributedDate;
	private boolean _allowDiscussion;
	private String _title;
	private BaseModel<?> _distributionRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}