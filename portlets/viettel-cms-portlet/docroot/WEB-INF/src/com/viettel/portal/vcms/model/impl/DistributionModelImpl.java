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

import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.model.DistributionModel;
import com.viettel.portal.vcms.model.DistributionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Distribution service. Represents a row in the &quot;vcms_Distribution&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.vcms.model.DistributionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DistributionImpl}.
 * </p>
 *
 * @author chuchv
 * @see DistributionImpl
 * @see com.viettel.portal.vcms.model.Distribution
 * @see com.viettel.portal.vcms.model.DistributionModel
 * @generated
 */
@JSON(strict = true)
public class DistributionModelImpl extends BaseModelImpl<Distribution>
	implements DistributionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a distribution model instance should use the {@link com.viettel.portal.vcms.model.Distribution} interface instead.
	 */
	public static final String TABLE_NAME = "vcms_Distribution";
	public static final Object[][] TABLE_COLUMNS = {
			{ "distributionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "version", Types.INTEGER },
			{ "subversion", Types.FLOAT },
			{ "contentId", Types.BIGINT },
			{ "categoryId", Types.BIGINT },
			{ "distributedDate", Types.TIMESTAMP },
			{ "allowDiscussion", Types.BOOLEAN },
			{ "title", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table vcms_Distribution (distributionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,version INTEGER,subversion DOUBLE,contentId LONG,categoryId LONG,distributedDate DATE null,allowDiscussion BOOLEAN,title VARCHAR(255) null)";
	public static final String TABLE_SQL_DROP = "drop table vcms_Distribution";
	public static final String ORDER_BY_JPQL = " ORDER BY distribution.distributedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vcms_Distribution.distributedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.vcms.model.Distribution"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.vcms.model.Distribution"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.vcms.model.Distribution"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long CONTENTID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long VERSION_COLUMN_BITMASK = 8L;
	public static long DISTRIBUTEDDATE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Distribution toModel(DistributionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Distribution model = new DistributionImpl();

		model.setDistributionId(soapModel.getDistributionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setVersion(soapModel.getVersion());
		model.setSubversion(soapModel.getSubversion());
		model.setContentId(soapModel.getContentId());
		model.setCategoryId(soapModel.getCategoryId());
		model.setDistributedDate(soapModel.getDistributedDate());
		model.setAllowDiscussion(soapModel.getAllowDiscussion());
		model.setTitle(soapModel.getTitle());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Distribution> toModels(DistributionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Distribution> models = new ArrayList<Distribution>(soapModels.length);

		for (DistributionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.vcms.model.Distribution"));

	public DistributionModelImpl() {
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
	public Class<?> getModelClass() {
		return Distribution.class;
	}

	@Override
	public String getModelClassName() {
		return Distribution.class.getName();
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

	@JSON
	@Override
	public long getDistributionId() {
		return _distributionId;
	}

	@Override
	public void setDistributionId(long distributionId) {
		_distributionId = distributionId;
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
	public int getVersion() {
		return _version;
	}

	@Override
	public void setVersion(int version) {
		_columnBitmask |= VERSION_COLUMN_BITMASK;

		if (!_setOriginalVersion) {
			_setOriginalVersion = true;

			_originalVersion = _version;
		}

		_version = version;
	}

	public int getOriginalVersion() {
		return _originalVersion;
	}

	@JSON
	@Override
	public float getSubversion() {
		return _subversion;
	}

	@Override
	public void setSubversion(float subversion) {
		_subversion = subversion;
	}

	@JSON
	@Override
	public long getContentId() {
		return _contentId;
	}

	@Override
	public void setContentId(long contentId) {
		_columnBitmask |= CONTENTID_COLUMN_BITMASK;

		if (!_setOriginalContentId) {
			_setOriginalContentId = true;

			_originalContentId = _contentId;
		}

		_contentId = contentId;
	}

	public long getOriginalContentId() {
		return _originalContentId;
	}

	@JSON
	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
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
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Distribution.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Distribution toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Distribution)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DistributionImpl distributionImpl = new DistributionImpl();

		distributionImpl.setDistributionId(getDistributionId());
		distributionImpl.setGroupId(getGroupId());
		distributionImpl.setCompanyId(getCompanyId());
		distributionImpl.setUserId(getUserId());
		distributionImpl.setUserName(getUserName());
		distributionImpl.setCreateDate(getCreateDate());
		distributionImpl.setModifiedDate(getModifiedDate());
		distributionImpl.setVersion(getVersion());
		distributionImpl.setSubversion(getSubversion());
		distributionImpl.setContentId(getContentId());
		distributionImpl.setCategoryId(getCategoryId());
		distributionImpl.setDistributedDate(getDistributedDate());
		distributionImpl.setAllowDiscussion(getAllowDiscussion());
		distributionImpl.setTitle(getTitle());

		distributionImpl.resetOriginalValues();

		return distributionImpl;
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

		if (!(obj instanceof Distribution)) {
			return false;
		}

		Distribution distribution = (Distribution)obj;

		long primaryKey = distribution.getPrimaryKey();

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
		DistributionModelImpl distributionModelImpl = this;

		distributionModelImpl._originalGroupId = distributionModelImpl._groupId;

		distributionModelImpl._setOriginalGroupId = false;

		distributionModelImpl._originalVersion = distributionModelImpl._version;

		distributionModelImpl._setOriginalVersion = false;

		distributionModelImpl._originalContentId = distributionModelImpl._contentId;

		distributionModelImpl._setOriginalContentId = false;

		distributionModelImpl._originalCategoryId = distributionModelImpl._categoryId;

		distributionModelImpl._setOriginalCategoryId = false;

		distributionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Distribution> toCacheModel() {
		DistributionCacheModel distributionCacheModel = new DistributionCacheModel();

		distributionCacheModel.distributionId = getDistributionId();

		distributionCacheModel.groupId = getGroupId();

		distributionCacheModel.companyId = getCompanyId();

		distributionCacheModel.userId = getUserId();

		distributionCacheModel.userName = getUserName();

		String userName = distributionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			distributionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			distributionCacheModel.createDate = createDate.getTime();
		}
		else {
			distributionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			distributionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			distributionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		distributionCacheModel.version = getVersion();

		distributionCacheModel.subversion = getSubversion();

		distributionCacheModel.contentId = getContentId();

		distributionCacheModel.categoryId = getCategoryId();

		Date distributedDate = getDistributedDate();

		if (distributedDate != null) {
			distributionCacheModel.distributedDate = distributedDate.getTime();
		}
		else {
			distributionCacheModel.distributedDate = Long.MIN_VALUE;
		}

		distributionCacheModel.allowDiscussion = getAllowDiscussion();

		distributionCacheModel.title = getTitle();

		String title = distributionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			distributionCacheModel.title = null;
		}

		return distributionCacheModel;
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

	private static ClassLoader _classLoader = Distribution.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Distribution.class
		};
	private long _distributionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _version;
	private int _originalVersion;
	private boolean _setOriginalVersion;
	private float _subversion;
	private long _contentId;
	private long _originalContentId;
	private boolean _setOriginalContentId;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private Date _distributedDate;
	private boolean _allowDiscussion;
	private String _title;
	private long _columnBitmask;
	private Distribution _escapedModel;
}