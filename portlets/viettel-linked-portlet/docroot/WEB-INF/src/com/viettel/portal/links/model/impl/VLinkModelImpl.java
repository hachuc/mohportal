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

package com.viettel.portal.links.model.impl;

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

import com.viettel.portal.links.model.VLink;
import com.viettel.portal.links.model.VLinkModel;
import com.viettel.portal.links.model.VLinkSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the VLink service. Represents a row in the &quot;portal_link&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.links.model.VLinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VLinkImpl}.
 * </p>
 *
 * @author ChucHV
 * @see VLinkImpl
 * @see com.viettel.portal.links.model.VLink
 * @see com.viettel.portal.links.model.VLinkModel
 * @generated
 */
@JSON(strict = true)
public class VLinkModelImpl extends BaseModelImpl<VLink> implements VLinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a v link model instance should use the {@link com.viettel.portal.links.model.VLink} interface instead.
	 */
	public static final String TABLE_NAME = "portal_link";
	public static final Object[][] TABLE_COLUMNS = {
			{ "linkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "linkName", Types.VARCHAR },
			{ "url", Types.VARCHAR },
			{ "isActive", Types.BOOLEAN },
			{ "corder", Types.INTEGER },
			{ "categoryId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table portal_link (linkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,linkName VARCHAR(500) null,url VARCHAR(2000) null,isActive BOOLEAN,corder INTEGER,categoryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table portal_link";
	public static final String ORDER_BY_JPQL = " ORDER BY vLink.corder DESC, vLink.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY portal_link.corder DESC, portal_link.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.links.model.VLink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.links.model.VLink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.links.model.VLink"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long ISACTIVE_COLUMN_BITMASK = 4L;
	public static long CORDER_COLUMN_BITMASK = 8L;
	public static long CREATEDATE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VLink toModel(VLinkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		VLink model = new VLinkImpl();

		model.setLinkId(soapModel.getLinkId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setLinkName(soapModel.getLinkName());
		model.setUrl(soapModel.getUrl());
		model.setIsActive(soapModel.getIsActive());
		model.setCorder(soapModel.getCorder());
		model.setCategoryId(soapModel.getCategoryId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VLink> toModels(VLinkSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<VLink> models = new ArrayList<VLink>(soapModels.length);

		for (VLinkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.links.model.VLink"));

	public VLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _linkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _linkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return VLink.class;
	}

	@Override
	public String getModelClassName() {
		return VLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("linkId", getLinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("linkName", getLinkName());
		attributes.put("url", getUrl());
		attributes.put("isActive", getIsActive());
		attributes.put("corder", getCorder());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long linkId = (Long)attributes.get("linkId");

		if (linkId != null) {
			setLinkId(linkId);
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

		String linkName = (String)attributes.get("linkName");

		if (linkName != null) {
			setLinkName(linkName);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Integer corder = (Integer)attributes.get("corder");

		if (corder != null) {
			setCorder(corder);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	@JSON
	@Override
	public long getLinkId() {
		return _linkId;
	}

	@Override
	public void setLinkId(long linkId) {
		_linkId = linkId;
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
		_columnBitmask = -1L;

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
	public String getLinkName() {
		if (_linkName == null) {
			return StringPool.BLANK;
		}
		else {
			return _linkName;
		}
	}

	@Override
	public void setLinkName(String linkName) {
		_linkName = linkName;
	}

	@JSON
	@Override
	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		_url = url;
	}

	@JSON
	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_columnBitmask |= ISACTIVE_COLUMN_BITMASK;

		if (!_setOriginalIsActive) {
			_setOriginalIsActive = true;

			_originalIsActive = _isActive;
		}

		_isActive = isActive;
	}

	public boolean getOriginalIsActive() {
		return _originalIsActive;
	}

	@JSON
	@Override
	public int getCorder() {
		return _corder;
	}

	@Override
	public void setCorder(int corder) {
		_columnBitmask = -1L;

		_corder = corder;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			VLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VLink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VLinkImpl vLinkImpl = new VLinkImpl();

		vLinkImpl.setLinkId(getLinkId());
		vLinkImpl.setGroupId(getGroupId());
		vLinkImpl.setCompanyId(getCompanyId());
		vLinkImpl.setUserId(getUserId());
		vLinkImpl.setUserName(getUserName());
		vLinkImpl.setCreateDate(getCreateDate());
		vLinkImpl.setModifiedDate(getModifiedDate());
		vLinkImpl.setLinkName(getLinkName());
		vLinkImpl.setUrl(getUrl());
		vLinkImpl.setIsActive(getIsActive());
		vLinkImpl.setCorder(getCorder());
		vLinkImpl.setCategoryId(getCategoryId());

		vLinkImpl.resetOriginalValues();

		return vLinkImpl;
	}

	@Override
	public int compareTo(VLink vLink) {
		int value = 0;

		if (getCorder() < vLink.getCorder()) {
			value = -1;
		}
		else if (getCorder() > vLink.getCorder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), vLink.getCreateDate());

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

		if (!(obj instanceof VLink)) {
			return false;
		}

		VLink vLink = (VLink)obj;

		long primaryKey = vLink.getPrimaryKey();

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
		VLinkModelImpl vLinkModelImpl = this;

		vLinkModelImpl._originalGroupId = vLinkModelImpl._groupId;

		vLinkModelImpl._setOriginalGroupId = false;

		vLinkModelImpl._originalIsActive = vLinkModelImpl._isActive;

		vLinkModelImpl._setOriginalIsActive = false;

		vLinkModelImpl._originalCategoryId = vLinkModelImpl._categoryId;

		vLinkModelImpl._setOriginalCategoryId = false;

		vLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VLink> toCacheModel() {
		VLinkCacheModel vLinkCacheModel = new VLinkCacheModel();

		vLinkCacheModel.linkId = getLinkId();

		vLinkCacheModel.groupId = getGroupId();

		vLinkCacheModel.companyId = getCompanyId();

		vLinkCacheModel.userId = getUserId();

		vLinkCacheModel.userName = getUserName();

		String userName = vLinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			vLinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			vLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			vLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vLinkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vLinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vLinkCacheModel.linkName = getLinkName();

		String linkName = vLinkCacheModel.linkName;

		if ((linkName != null) && (linkName.length() == 0)) {
			vLinkCacheModel.linkName = null;
		}

		vLinkCacheModel.url = getUrl();

		String url = vLinkCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			vLinkCacheModel.url = null;
		}

		vLinkCacheModel.isActive = getIsActive();

		vLinkCacheModel.corder = getCorder();

		vLinkCacheModel.categoryId = getCategoryId();

		return vLinkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{linkId=");
		sb.append(getLinkId());
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
		sb.append(", linkName=");
		sb.append(getLinkName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", corder=");
		sb.append(getCorder());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.links.model.VLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>linkId</column-name><column-value><![CDATA[");
		sb.append(getLinkId());
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
			"<column><column-name>linkName</column-name><column-value><![CDATA[");
		sb.append(getLinkName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corder</column-name><column-value><![CDATA[");
		sb.append(getCorder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VLink.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { VLink.class };
	private long _linkId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _linkName;
	private String _url;
	private boolean _isActive;
	private boolean _originalIsActive;
	private boolean _setOriginalIsActive;
	private int _corder;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private long _columnBitmask;
	private VLink _escapedModel;
}