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

import com.portal_egov.portlet.legal_faq.model.Feedback;
import com.portal_egov.portlet.legal_faq.model.FeedbackModel;
import com.portal_egov.portlet.legal_faq.model.FeedbackSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Feedback service. Represents a row in the &quot;vcms_feedback&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.legal_faq.model.FeedbackModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FeedbackImpl}.
 * </p>
 *
 * @author chuchv
 * @see FeedbackImpl
 * @see com.portal_egov.portlet.legal_faq.model.Feedback
 * @see com.portal_egov.portlet.legal_faq.model.FeedbackModel
 * @generated
 */
@JSON(strict = true)
public class FeedbackModelImpl extends BaseModelImpl<Feedback>
	implements FeedbackModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a feedback model instance should use the {@link com.portal_egov.portlet.legal_faq.model.Feedback} interface instead.
	 */
	public static final String TABLE_NAME = "vcms_feedback";
	public static final Object[][] TABLE_COLUMNS = {
			{ "feedbackId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "summary", Types.VARCHAR },
			{ "body", Types.VARCHAR },
			{ "fullName", Types.VARCHAR },
			{ "workFor", Types.VARCHAR },
			{ "address", Types.VARCHAR },
			{ "phone", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "fileId", Types.BIGINT },
			{ "fileSize", Types.VARCHAR },
			{ "fileName", Types.VARCHAR },
			{ "fileURL", Types.VARCHAR },
			{ "ipAddress", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table vcms_feedback (feedbackId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(1000) null,summary VARCHAR(2000) null,body STRING null,fullName VARCHAR(255) null,workFor VARCHAR(500) null,address VARCHAR(255) null,phone VARCHAR(75) null,email VARCHAR(255) null,fileId LONG,fileSize VARCHAR(75) null,fileName VARCHAR(255) null,fileURL VARCHAR(2000) null,ipAddress VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vcms_feedback";
	public static final String ORDER_BY_JPQL = " ORDER BY feedback.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vcms_feedback.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.legal_faq.model.Feedback"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.legal_faq.model.Feedback"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.legal_faq.model.Feedback"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long CREATEDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Feedback toModel(FeedbackSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Feedback model = new FeedbackImpl();

		model.setFeedbackId(soapModel.getFeedbackId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setSummary(soapModel.getSummary());
		model.setBody(soapModel.getBody());
		model.setFullName(soapModel.getFullName());
		model.setWorkFor(soapModel.getWorkFor());
		model.setAddress(soapModel.getAddress());
		model.setPhone(soapModel.getPhone());
		model.setEmail(soapModel.getEmail());
		model.setFileId(soapModel.getFileId());
		model.setFileSize(soapModel.getFileSize());
		model.setFileName(soapModel.getFileName());
		model.setFileURL(soapModel.getFileURL());
		model.setIpAddress(soapModel.getIpAddress());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Feedback> toModels(FeedbackSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Feedback> models = new ArrayList<Feedback>(soapModels.length);

		for (FeedbackSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.legal_faq.model.Feedback"));

	public FeedbackModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFeedbackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("summary", getSummary());
		attributes.put("body", getBody());
		attributes.put("fullName", getFullName());
		attributes.put("workFor", getWorkFor());
		attributes.put("address", getAddress());
		attributes.put("phone", getPhone());
		attributes.put("email", getEmail());
		attributes.put("fileId", getFileId());
		attributes.put("fileSize", getFileSize());
		attributes.put("fileName", getFileName());
		attributes.put("fileURL", getFileURL());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String workFor = (String)attributes.get("workFor");

		if (workFor != null) {
			setWorkFor(workFor);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileURL = (String)attributes.get("fileURL");

		if (fileURL != null) {
			setFileURL(fileURL);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@JSON
	@Override
	public long getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
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

	@JSON
	@Override
	public String getSummary() {
		if (_summary == null) {
			return StringPool.BLANK;
		}
		else {
			return _summary;
		}
	}

	@Override
	public void setSummary(String summary) {
		_summary = summary;
	}

	@JSON
	@Override
	public String getBody() {
		if (_body == null) {
			return StringPool.BLANK;
		}
		else {
			return _body;
		}
	}

	@Override
	public void setBody(String body) {
		_body = body;
	}

	@JSON
	@Override
	public String getFullName() {
		if (_fullName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	@JSON
	@Override
	public String getWorkFor() {
		if (_workFor == null) {
			return StringPool.BLANK;
		}
		else {
			return _workFor;
		}
	}

	@Override
	public void setWorkFor(String workFor) {
		_workFor = workFor;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	@Override
	public String getPhone() {
		if (_phone == null) {
			return StringPool.BLANK;
		}
		else {
			return _phone;
		}
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	@JSON
	@Override
	public String getFileSize() {
		if (_fileSize == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileSize;
		}
	}

	@Override
	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
	}

	@JSON
	@Override
	public String getFileName() {
		if (_fileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	@JSON
	@Override
	public String getFileURL() {
		if (_fileURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileURL;
		}
	}

	@Override
	public void setFileURL(String fileURL) {
		_fileURL = fileURL;
	}

	@JSON
	@Override
	public String getIpAddress() {
		if (_ipAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _ipAddress;
		}
	}

	@Override
	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Feedback.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Feedback toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Feedback)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setFeedbackId(getFeedbackId());
		feedbackImpl.setGroupId(getGroupId());
		feedbackImpl.setCompanyId(getCompanyId());
		feedbackImpl.setUserId(getUserId());
		feedbackImpl.setUserName(getUserName());
		feedbackImpl.setCreateDate(getCreateDate());
		feedbackImpl.setModifiedDate(getModifiedDate());
		feedbackImpl.setTitle(getTitle());
		feedbackImpl.setSummary(getSummary());
		feedbackImpl.setBody(getBody());
		feedbackImpl.setFullName(getFullName());
		feedbackImpl.setWorkFor(getWorkFor());
		feedbackImpl.setAddress(getAddress());
		feedbackImpl.setPhone(getPhone());
		feedbackImpl.setEmail(getEmail());
		feedbackImpl.setFileId(getFileId());
		feedbackImpl.setFileSize(getFileSize());
		feedbackImpl.setFileName(getFileName());
		feedbackImpl.setFileURL(getFileURL());
		feedbackImpl.setIpAddress(getIpAddress());

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public int compareTo(Feedback feedback) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), feedback.getCreateDate());

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

		if (!(obj instanceof Feedback)) {
			return false;
		}

		Feedback feedback = (Feedback)obj;

		long primaryKey = feedback.getPrimaryKey();

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
		FeedbackModelImpl feedbackModelImpl = this;

		feedbackModelImpl._originalGroupId = feedbackModelImpl._groupId;

		feedbackModelImpl._setOriginalGroupId = false;

		feedbackModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Feedback> toCacheModel() {
		FeedbackCacheModel feedbackCacheModel = new FeedbackCacheModel();

		feedbackCacheModel.feedbackId = getFeedbackId();

		feedbackCacheModel.groupId = getGroupId();

		feedbackCacheModel.companyId = getCompanyId();

		feedbackCacheModel.userId = getUserId();

		feedbackCacheModel.userName = getUserName();

		String userName = feedbackCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			feedbackCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			feedbackCacheModel.createDate = createDate.getTime();
		}
		else {
			feedbackCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			feedbackCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			feedbackCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		feedbackCacheModel.title = getTitle();

		String title = feedbackCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			feedbackCacheModel.title = null;
		}

		feedbackCacheModel.summary = getSummary();

		String summary = feedbackCacheModel.summary;

		if ((summary != null) && (summary.length() == 0)) {
			feedbackCacheModel.summary = null;
		}

		feedbackCacheModel.body = getBody();

		String body = feedbackCacheModel.body;

		if ((body != null) && (body.length() == 0)) {
			feedbackCacheModel.body = null;
		}

		feedbackCacheModel.fullName = getFullName();

		String fullName = feedbackCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			feedbackCacheModel.fullName = null;
		}

		feedbackCacheModel.workFor = getWorkFor();

		String workFor = feedbackCacheModel.workFor;

		if ((workFor != null) && (workFor.length() == 0)) {
			feedbackCacheModel.workFor = null;
		}

		feedbackCacheModel.address = getAddress();

		String address = feedbackCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			feedbackCacheModel.address = null;
		}

		feedbackCacheModel.phone = getPhone();

		String phone = feedbackCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			feedbackCacheModel.phone = null;
		}

		feedbackCacheModel.email = getEmail();

		String email = feedbackCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			feedbackCacheModel.email = null;
		}

		feedbackCacheModel.fileId = getFileId();

		feedbackCacheModel.fileSize = getFileSize();

		String fileSize = feedbackCacheModel.fileSize;

		if ((fileSize != null) && (fileSize.length() == 0)) {
			feedbackCacheModel.fileSize = null;
		}

		feedbackCacheModel.fileName = getFileName();

		String fileName = feedbackCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			feedbackCacheModel.fileName = null;
		}

		feedbackCacheModel.fileURL = getFileURL();

		String fileURL = feedbackCacheModel.fileURL;

		if ((fileURL != null) && (fileURL.length() == 0)) {
			feedbackCacheModel.fileURL = null;
		}

		feedbackCacheModel.ipAddress = getIpAddress();

		String ipAddress = feedbackCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			feedbackCacheModel.ipAddress = null;
		}

		return feedbackCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{feedbackId=");
		sb.append(getFeedbackId());
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
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", summary=");
		sb.append(getSummary());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", workFor=");
		sb.append(getWorkFor());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", fileSize=");
		sb.append(getFileSize());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileURL=");
		sb.append(getFileURL());
		sb.append(", ipAddress=");
		sb.append(getIpAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.legal_faq.model.Feedback");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>feedbackId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>summary</column-name><column-value><![CDATA[");
		sb.append(getSummary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workFor</column-name><column-value><![CDATA[");
		sb.append(getWorkFor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileSize</column-name><column-value><![CDATA[");
		sb.append(getFileSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileURL</column-name><column-value><![CDATA[");
		sb.append(getFileURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipAddress</column-name><column-value><![CDATA[");
		sb.append(getIpAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Feedback.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Feedback.class
		};
	private long _feedbackId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _summary;
	private String _body;
	private String _fullName;
	private String _workFor;
	private String _address;
	private String _phone;
	private String _email;
	private long _fileId;
	private String _fileSize;
	private String _fileName;
	private String _fileURL;
	private String _ipAddress;
	private long _columnBitmask;
	private Feedback _escapedModel;
}