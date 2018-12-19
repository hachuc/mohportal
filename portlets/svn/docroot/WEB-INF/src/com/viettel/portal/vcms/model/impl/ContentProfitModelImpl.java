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

package com.viettel.portal.vcms.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.viettel.portal.vcms.model.ContentProfit;
import com.viettel.portal.vcms.model.ContentProfitModel;
import com.viettel.portal.vcms.model.ContentProfitSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ContentProfit service. Represents a row in the &quot;vcms_Content_Profit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.vcms.model.ContentProfitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContentProfitImpl}.
 * </p>
 *
 * @author chuchv
 * @see ContentProfitImpl
 * @see com.viettel.portal.vcms.model.ContentProfit
 * @see com.viettel.portal.vcms.model.ContentProfitModel
 * @generated
 */
@JSON(strict = true)
public class ContentProfitModelImpl extends BaseModelImpl<ContentProfit>
	implements ContentProfitModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a content profit model instance should use the {@link com.viettel.portal.vcms.model.ContentProfit} interface instead.
	 */
	public static final String TABLE_NAME = "vcms_Content_Profit";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "distributedDate", Types.TIMESTAMP },
			{ "contentTypeID", Types.INTEGER },
			{ "headline", Types.VARCHAR },
			{ "cost", Types.DOUBLE },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table vcms_Content_Profit (contentId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,distributedDate DATE null,contentTypeID INTEGER,headline STRING null,cost DOUBLE,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table vcms_Content_Profit";
	public static final String ORDER_BY_JPQL = " ORDER BY contentProfit.distributedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vcms_Content_Profit.distributedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.vcms.model.ContentProfit"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.vcms.model.ContentProfit"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.vcms.model.ContentProfit"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long DISTRIBUTEDDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ContentProfit toModel(ContentProfitSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ContentProfit model = new ContentProfitImpl();

		model.setContentId(soapModel.getContentId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDistributedDate(soapModel.getDistributedDate());
		model.setContentTypeID(soapModel.getContentTypeID());
		model.setHeadline(soapModel.getHeadline());
		model.setCost(soapModel.getCost());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ContentProfit> toModels(ContentProfitSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ContentProfit> models = new ArrayList<ContentProfit>(soapModels.length);

		for (ContentProfitSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.vcms.model.ContentProfit"));

	public ContentProfitModelImpl() {
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
	public Class<?> getModelClass() {
		return ContentProfit.class;
	}

	@Override
	public String getModelClassName() {
		return ContentProfit.class.getName();
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

		Integer contentTypeID = (Integer)attributes.get("contentTypeID");

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

	@JSON
	@Override
	public long getContentId() {
		return _contentId;
	}

	@Override
	public void setContentId(long contentId) {
		_contentId = contentId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public Date getDistributedDate() {
		return _distributedDate;
	}

	@Override
	public void setDistributedDate(Date distributedDate) {
		_columnBitmask = -1L;

		_distributedDate = distributedDate;
	}

	@JSON
	@Override
	public int getContentTypeID() {
		return _contentTypeID;
	}

	@Override
	public void setContentTypeID(int contentTypeID) {
		_contentTypeID = contentTypeID;
	}

	@JSON
	@Override
	public String getHeadline() {
		if (_headline == null) {
			return StringPool.BLANK;
		}
		else {
			return _headline;
		}
	}

	@Override
	public void setHeadline(String headline) {
		_headline = headline;
	}

	@JSON
	@Override
	public double getCost() {
		return _cost;
	}

	@Override
	public void setCost(double cost) {
		_cost = cost;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ContentProfit.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ContentProfit toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ContentProfit)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ContentProfitImpl contentProfitImpl = new ContentProfitImpl();

		contentProfitImpl.setContentId(getContentId());
		contentProfitImpl.setGroupId(getGroupId());
		contentProfitImpl.setCompanyId(getCompanyId());
		contentProfitImpl.setUserId(getUserId());
		contentProfitImpl.setUserName(getUserName());
		contentProfitImpl.setCreateDate(getCreateDate());
		contentProfitImpl.setModifiedDate(getModifiedDate());
		contentProfitImpl.setDistributedDate(getDistributedDate());
		contentProfitImpl.setContentTypeID(getContentTypeID());
		contentProfitImpl.setHeadline(getHeadline());
		contentProfitImpl.setCost(getCost());
		contentProfitImpl.setStatus(getStatus());

		contentProfitImpl.resetOriginalValues();

		return contentProfitImpl;
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

		if (!(obj instanceof ContentProfit)) {
			return false;
		}

		ContentProfit contentProfit = (ContentProfit)obj;

		long primaryKey = contentProfit.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ContentProfitModelImpl contentProfitModelImpl = this;

		contentProfitModelImpl._originalGroupId = contentProfitModelImpl._groupId;

		contentProfitModelImpl._setOriginalGroupId = false;

		contentProfitModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ContentProfit> toCacheModel() {
		ContentProfitCacheModel contentProfitCacheModel = new ContentProfitCacheModel();

		contentProfitCacheModel.contentId = getContentId();

		contentProfitCacheModel.groupId = getGroupId();

		contentProfitCacheModel.companyId = getCompanyId();

		contentProfitCacheModel.userId = getUserId();

		contentProfitCacheModel.userName = getUserName();

		String userName = contentProfitCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			contentProfitCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			contentProfitCacheModel.createDate = createDate.getTime();
		}
		else {
			contentProfitCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			contentProfitCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			contentProfitCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date distributedDate = getDistributedDate();

		if (distributedDate != null) {
			contentProfitCacheModel.distributedDate = distributedDate.getTime();
		}
		else {
			contentProfitCacheModel.distributedDate = Long.MIN_VALUE;
		}

		contentProfitCacheModel.contentTypeID = getContentTypeID();

		contentProfitCacheModel.headline = getHeadline();

		String headline = contentProfitCacheModel.headline;

		if ((headline != null) && (headline.length() == 0)) {
			contentProfitCacheModel.headline = null;
		}

		contentProfitCacheModel.cost = getCost();

		contentProfitCacheModel.status = getStatus();

		return contentProfitCacheModel;
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

	private static ClassLoader _classLoader = ContentProfit.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ContentProfit.class
		};
	private long _contentId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _distributedDate;
	private int _contentTypeID;
	private String _headline;
	private double _cost;
	private int _status;
	private long _columnBitmask;
	private ContentProfit _escapedModel;
}