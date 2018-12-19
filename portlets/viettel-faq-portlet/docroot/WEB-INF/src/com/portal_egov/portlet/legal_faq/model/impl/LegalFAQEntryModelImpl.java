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

package com.portal_egov.portlet.legal_faq.model.impl;

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

import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntryModel;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntrySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LegalFAQEntry service. Represents a row in the &quot;LegalFAQEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.legal_faq.model.LegalFAQEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LegalFAQEntryImpl}.
 * </p>
 *
 * @author chuchv
 * @see LegalFAQEntryImpl
 * @see com.portal_egov.portlet.legal_faq.model.LegalFAQEntry
 * @see com.portal_egov.portlet.legal_faq.model.LegalFAQEntryModel
 * @generated
 */
@JSON(strict = true)
public class LegalFAQEntryModelImpl extends BaseModelImpl<LegalFAQEntry>
	implements LegalFAQEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a legal f a q entry model instance should use the {@link com.portal_egov.portlet.legal_faq.model.LegalFAQEntry} interface instead.
	 */
	public static final String TABLE_NAME = "LegalFAQEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "entryId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "categoryId", Types.BIGINT },
			{ "citizenName", Types.VARCHAR },
			{ "citizenPhone", Types.VARCHAR },
			{ "citizenEmail", Types.VARCHAR },
			{ "askDate", Types.TIMESTAMP },
			{ "askTitle", Types.VARCHAR },
			{ "askContent", Types.VARCHAR },
			{ "answerDate", Types.TIMESTAMP },
			{ "answerContent", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "publishDate", Types.TIMESTAMP },
			{ "viewCount", Types.INTEGER },
			{ "publishStatus", Types.INTEGER },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table LegalFAQEntry (entryId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,categoryId LONG,citizenName VARCHAR(75) null,citizenPhone VARCHAR(75) null,citizenEmail VARCHAR(75) null,askDate DATE null,askTitle VARCHAR(300) null,askContent STRING null,answerDate DATE null,answerContent STRING null,createDate DATE null,modifiedDate DATE null,publishDate DATE null,viewCount INTEGER,publishStatus INTEGER,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table LegalFAQEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY legalFAQEntry.publishDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY LegalFAQEntry.publishDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long PUBLISHSTATUS_COLUMN_BITMASK = 8L;
	public static long STATUS_COLUMN_BITMASK = 16L;
	public static long VIEWCOUNT_COLUMN_BITMASK = 32L;
	public static long PUBLISHDATE_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LegalFAQEntry toModel(LegalFAQEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LegalFAQEntry model = new LegalFAQEntryImpl();

		model.setEntryId(soapModel.getEntryId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCategoryId(soapModel.getCategoryId());
		model.setCitizenName(soapModel.getCitizenName());
		model.setCitizenPhone(soapModel.getCitizenPhone());
		model.setCitizenEmail(soapModel.getCitizenEmail());
		model.setAskDate(soapModel.getAskDate());
		model.setAskTitle(soapModel.getAskTitle());
		model.setAskContent(soapModel.getAskContent());
		model.setAnswerDate(soapModel.getAnswerDate());
		model.setAnswerContent(soapModel.getAnswerContent());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPublishDate(soapModel.getPublishDate());
		model.setViewCount(soapModel.getViewCount());
		model.setPublishStatus(soapModel.getPublishStatus());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LegalFAQEntry> toModels(LegalFAQEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LegalFAQEntry> models = new ArrayList<LegalFAQEntry>(soapModels.length);

		for (LegalFAQEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"));

	public LegalFAQEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _entryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LegalFAQEntry.class;
	}

	@Override
	public String getModelClassName() {
		return LegalFAQEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("categoryId", getCategoryId());
		attributes.put("citizenName", getCitizenName());
		attributes.put("citizenPhone", getCitizenPhone());
		attributes.put("citizenEmail", getCitizenEmail());
		attributes.put("askDate", getAskDate());
		attributes.put("askTitle", getAskTitle());
		attributes.put("askContent", getAskContent());
		attributes.put("answerDate", getAnswerDate());
		attributes.put("answerContent", getAnswerContent());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishDate", getPublishDate());
		attributes.put("viewCount", getViewCount());
		attributes.put("publishStatus", getPublishStatus());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String citizenName = (String)attributes.get("citizenName");

		if (citizenName != null) {
			setCitizenName(citizenName);
		}

		String citizenPhone = (String)attributes.get("citizenPhone");

		if (citizenPhone != null) {
			setCitizenPhone(citizenPhone);
		}

		String citizenEmail = (String)attributes.get("citizenEmail");

		if (citizenEmail != null) {
			setCitizenEmail(citizenEmail);
		}

		Date askDate = (Date)attributes.get("askDate");

		if (askDate != null) {
			setAskDate(askDate);
		}

		String askTitle = (String)attributes.get("askTitle");

		if (askTitle != null) {
			setAskTitle(askTitle);
		}

		String askContent = (String)attributes.get("askContent");

		if (askContent != null) {
			setAskContent(askContent);
		}

		Date answerDate = (Date)attributes.get("answerDate");

		if (answerDate != null) {
			setAnswerDate(answerDate);
		}

		String answerContent = (String)attributes.get("answerContent");

		if (answerContent != null) {
			setAnswerContent(answerContent);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Integer publishStatus = (Integer)attributes.get("publishStatus");

		if (publishStatus != null) {
			setPublishStatus(publishStatus);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getEntryId() {
		return _entryId;
	}

	@Override
	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
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
	public String getCitizenName() {
		if (_citizenName == null) {
			return StringPool.BLANK;
		}
		else {
			return _citizenName;
		}
	}

	@Override
	public void setCitizenName(String citizenName) {
		_citizenName = citizenName;
	}

	@JSON
	@Override
	public String getCitizenPhone() {
		if (_citizenPhone == null) {
			return StringPool.BLANK;
		}
		else {
			return _citizenPhone;
		}
	}

	@Override
	public void setCitizenPhone(String citizenPhone) {
		_citizenPhone = citizenPhone;
	}

	@JSON
	@Override
	public String getCitizenEmail() {
		if (_citizenEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _citizenEmail;
		}
	}

	@Override
	public void setCitizenEmail(String citizenEmail) {
		_citizenEmail = citizenEmail;
	}

	@JSON
	@Override
	public Date getAskDate() {
		return _askDate;
	}

	@Override
	public void setAskDate(Date askDate) {
		_askDate = askDate;
	}

	@JSON
	@Override
	public String getAskTitle() {
		if (_askTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _askTitle;
		}
	}

	@Override
	public void setAskTitle(String askTitle) {
		_askTitle = askTitle;
	}

	@JSON
	@Override
	public String getAskContent() {
		if (_askContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _askContent;
		}
	}

	@Override
	public void setAskContent(String askContent) {
		_askContent = askContent;
	}

	@JSON
	@Override
	public Date getAnswerDate() {
		return _answerDate;
	}

	@Override
	public void setAnswerDate(Date answerDate) {
		_answerDate = answerDate;
	}

	@JSON
	@Override
	public String getAnswerContent() {
		if (_answerContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _answerContent;
		}
	}

	@Override
	public void setAnswerContent(String answerContent) {
		_answerContent = answerContent;
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
	public Date getPublishDate() {
		return _publishDate;
	}

	@Override
	public void setPublishDate(Date publishDate) {
		_columnBitmask = -1L;

		_publishDate = publishDate;
	}

	@JSON
	@Override
	public int getViewCount() {
		return _viewCount;
	}

	@Override
	public void setViewCount(int viewCount) {
		_columnBitmask |= VIEWCOUNT_COLUMN_BITMASK;

		if (!_setOriginalViewCount) {
			_setOriginalViewCount = true;

			_originalViewCount = _viewCount;
		}

		_viewCount = viewCount;
	}

	public int getOriginalViewCount() {
		return _originalViewCount;
	}

	@JSON
	@Override
	public int getPublishStatus() {
		return _publishStatus;
	}

	@Override
	public void setPublishStatus(int publishStatus) {
		_columnBitmask |= PUBLISHSTATUS_COLUMN_BITMASK;

		if (!_setOriginalPublishStatus) {
			_setOriginalPublishStatus = true;

			_originalPublishStatus = _publishStatus;
		}

		_publishStatus = publishStatus;
	}

	public int getOriginalPublishStatus() {
		return _originalPublishStatus;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			LegalFAQEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LegalFAQEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LegalFAQEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LegalFAQEntryImpl legalFAQEntryImpl = new LegalFAQEntryImpl();

		legalFAQEntryImpl.setEntryId(getEntryId());
		legalFAQEntryImpl.setCompanyId(getCompanyId());
		legalFAQEntryImpl.setGroupId(getGroupId());
		legalFAQEntryImpl.setUserId(getUserId());
		legalFAQEntryImpl.setUserName(getUserName());
		legalFAQEntryImpl.setCategoryId(getCategoryId());
		legalFAQEntryImpl.setCitizenName(getCitizenName());
		legalFAQEntryImpl.setCitizenPhone(getCitizenPhone());
		legalFAQEntryImpl.setCitizenEmail(getCitizenEmail());
		legalFAQEntryImpl.setAskDate(getAskDate());
		legalFAQEntryImpl.setAskTitle(getAskTitle());
		legalFAQEntryImpl.setAskContent(getAskContent());
		legalFAQEntryImpl.setAnswerDate(getAnswerDate());
		legalFAQEntryImpl.setAnswerContent(getAnswerContent());
		legalFAQEntryImpl.setCreateDate(getCreateDate());
		legalFAQEntryImpl.setModifiedDate(getModifiedDate());
		legalFAQEntryImpl.setPublishDate(getPublishDate());
		legalFAQEntryImpl.setViewCount(getViewCount());
		legalFAQEntryImpl.setPublishStatus(getPublishStatus());
		legalFAQEntryImpl.setStatus(getStatus());

		legalFAQEntryImpl.resetOriginalValues();

		return legalFAQEntryImpl;
	}

	@Override
	public int compareTo(LegalFAQEntry legalFAQEntry) {
		int value = 0;

		value = DateUtil.compareTo(getPublishDate(),
				legalFAQEntry.getPublishDate());

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

		if (!(obj instanceof LegalFAQEntry)) {
			return false;
		}

		LegalFAQEntry legalFAQEntry = (LegalFAQEntry)obj;

		long primaryKey = legalFAQEntry.getPrimaryKey();

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
		LegalFAQEntryModelImpl legalFAQEntryModelImpl = this;

		legalFAQEntryModelImpl._originalCompanyId = legalFAQEntryModelImpl._companyId;

		legalFAQEntryModelImpl._setOriginalCompanyId = false;

		legalFAQEntryModelImpl._originalGroupId = legalFAQEntryModelImpl._groupId;

		legalFAQEntryModelImpl._setOriginalGroupId = false;

		legalFAQEntryModelImpl._originalCategoryId = legalFAQEntryModelImpl._categoryId;

		legalFAQEntryModelImpl._setOriginalCategoryId = false;

		legalFAQEntryModelImpl._originalViewCount = legalFAQEntryModelImpl._viewCount;

		legalFAQEntryModelImpl._setOriginalViewCount = false;

		legalFAQEntryModelImpl._originalPublishStatus = legalFAQEntryModelImpl._publishStatus;

		legalFAQEntryModelImpl._setOriginalPublishStatus = false;

		legalFAQEntryModelImpl._originalStatus = legalFAQEntryModelImpl._status;

		legalFAQEntryModelImpl._setOriginalStatus = false;

		legalFAQEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LegalFAQEntry> toCacheModel() {
		LegalFAQEntryCacheModel legalFAQEntryCacheModel = new LegalFAQEntryCacheModel();

		legalFAQEntryCacheModel.entryId = getEntryId();

		legalFAQEntryCacheModel.companyId = getCompanyId();

		legalFAQEntryCacheModel.groupId = getGroupId();

		legalFAQEntryCacheModel.userId = getUserId();

		legalFAQEntryCacheModel.userName = getUserName();

		String userName = legalFAQEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			legalFAQEntryCacheModel.userName = null;
		}

		legalFAQEntryCacheModel.categoryId = getCategoryId();

		legalFAQEntryCacheModel.citizenName = getCitizenName();

		String citizenName = legalFAQEntryCacheModel.citizenName;

		if ((citizenName != null) && (citizenName.length() == 0)) {
			legalFAQEntryCacheModel.citizenName = null;
		}

		legalFAQEntryCacheModel.citizenPhone = getCitizenPhone();

		String citizenPhone = legalFAQEntryCacheModel.citizenPhone;

		if ((citizenPhone != null) && (citizenPhone.length() == 0)) {
			legalFAQEntryCacheModel.citizenPhone = null;
		}

		legalFAQEntryCacheModel.citizenEmail = getCitizenEmail();

		String citizenEmail = legalFAQEntryCacheModel.citizenEmail;

		if ((citizenEmail != null) && (citizenEmail.length() == 0)) {
			legalFAQEntryCacheModel.citizenEmail = null;
		}

		Date askDate = getAskDate();

		if (askDate != null) {
			legalFAQEntryCacheModel.askDate = askDate.getTime();
		}
		else {
			legalFAQEntryCacheModel.askDate = Long.MIN_VALUE;
		}

		legalFAQEntryCacheModel.askTitle = getAskTitle();

		String askTitle = legalFAQEntryCacheModel.askTitle;

		if ((askTitle != null) && (askTitle.length() == 0)) {
			legalFAQEntryCacheModel.askTitle = null;
		}

		legalFAQEntryCacheModel.askContent = getAskContent();

		String askContent = legalFAQEntryCacheModel.askContent;

		if ((askContent != null) && (askContent.length() == 0)) {
			legalFAQEntryCacheModel.askContent = null;
		}

		Date answerDate = getAnswerDate();

		if (answerDate != null) {
			legalFAQEntryCacheModel.answerDate = answerDate.getTime();
		}
		else {
			legalFAQEntryCacheModel.answerDate = Long.MIN_VALUE;
		}

		legalFAQEntryCacheModel.answerContent = getAnswerContent();

		String answerContent = legalFAQEntryCacheModel.answerContent;

		if ((answerContent != null) && (answerContent.length() == 0)) {
			legalFAQEntryCacheModel.answerContent = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			legalFAQEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			legalFAQEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			legalFAQEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			legalFAQEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date publishDate = getPublishDate();

		if (publishDate != null) {
			legalFAQEntryCacheModel.publishDate = publishDate.getTime();
		}
		else {
			legalFAQEntryCacheModel.publishDate = Long.MIN_VALUE;
		}

		legalFAQEntryCacheModel.viewCount = getViewCount();

		legalFAQEntryCacheModel.publishStatus = getPublishStatus();

		legalFAQEntryCacheModel.status = getStatus();

		return legalFAQEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", citizenName=");
		sb.append(getCitizenName());
		sb.append(", citizenPhone=");
		sb.append(getCitizenPhone());
		sb.append(", citizenEmail=");
		sb.append(getCitizenEmail());
		sb.append(", askDate=");
		sb.append(getAskDate());
		sb.append(", askTitle=");
		sb.append(getAskTitle());
		sb.append(", askContent=");
		sb.append(getAskContent());
		sb.append(", answerDate=");
		sb.append(getAnswerDate());
		sb.append(", answerContent=");
		sb.append(getAnswerContent());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", publishStatus=");
		sb.append(getPublishStatus());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.legal_faq.model.LegalFAQEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenName</column-name><column-value><![CDATA[");
		sb.append(getCitizenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenPhone</column-name><column-value><![CDATA[");
		sb.append(getCitizenPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenEmail</column-name><column-value><![CDATA[");
		sb.append(getCitizenEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askDate</column-name><column-value><![CDATA[");
		sb.append(getAskDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askTitle</column-name><column-value><![CDATA[");
		sb.append(getAskTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askContent</column-name><column-value><![CDATA[");
		sb.append(getAskContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerDate</column-name><column-value><![CDATA[");
		sb.append(getAnswerDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerContent</column-name><column-value><![CDATA[");
		sb.append(getAnswerContent());
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
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishStatus</column-name><column-value><![CDATA[");
		sb.append(getPublishStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = LegalFAQEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			LegalFAQEntry.class
		};
	private long _entryId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private String _citizenName;
	private String _citizenPhone;
	private String _citizenEmail;
	private Date _askDate;
	private String _askTitle;
	private String _askContent;
	private Date _answerDate;
	private String _answerContent;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishDate;
	private int _viewCount;
	private int _originalViewCount;
	private boolean _setOriginalViewCount;
	private int _publishStatus;
	private int _originalPublishStatus;
	private boolean _setOriginalPublishStatus;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private LegalFAQEntry _escapedModel;
}