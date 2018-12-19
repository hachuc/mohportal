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

package com.portal_egov.portlet.legal_faq.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.legal_faq.service.ClpSerializer;
import com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class FeedbackClp extends BaseModelImpl<Feedback> implements Feedback {
	public FeedbackClp() {
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

	@Override
	public long getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFeedbackId", long.class);

				method.invoke(_feedbackRemoteModel, feedbackId);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_feedbackRemoteModel, groupId);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_feedbackRemoteModel, companyId);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_feedbackRemoteModel, userId);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_feedbackRemoteModel, userName);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_feedbackRemoteModel, createDate);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_feedbackRemoteModel, modifiedDate);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_feedbackRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSummary() {
		return _summary;
	}

	@Override
	public void setSummary(String summary) {
		_summary = summary;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setSummary", String.class);

				method.invoke(_feedbackRemoteModel, summary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBody() {
		return _body;
	}

	@Override
	public void setBody(String body) {
		_body = body;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setBody", String.class);

				method.invoke(_feedbackRemoteModel, body);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullName() {
		return _fullName;
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFullName", String.class);

				method.invoke(_feedbackRemoteModel, fullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkFor() {
		return _workFor;
	}

	@Override
	public void setWorkFor(String workFor) {
		_workFor = workFor;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkFor", String.class);

				method.invoke(_feedbackRemoteModel, workFor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_feedbackRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_feedbackRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_feedbackRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		_fileId = fileId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFileId", long.class);

				method.invoke(_feedbackRemoteModel, fileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileSize() {
		return _fileSize;
	}

	@Override
	public void setFileSize(String fileSize) {
		_fileSize = fileSize;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFileSize", String.class);

				method.invoke(_feedbackRemoteModel, fileSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_feedbackRemoteModel, fileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileURL() {
		return _fileURL;
	}

	@Override
	public void setFileURL(String fileURL) {
		_fileURL = fileURL;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFileURL", String.class);

				method.invoke(_feedbackRemoteModel, fileURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIpAddress() {
		return _ipAddress;
	}

	@Override
	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setIpAddress", String.class);

				method.invoke(_feedbackRemoteModel, ipAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFeedbackRemoteModel() {
		return _feedbackRemoteModel;
	}

	public void setFeedbackRemoteModel(BaseModel<?> feedbackRemoteModel) {
		_feedbackRemoteModel = feedbackRemoteModel;
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

		Class<?> remoteModelClass = _feedbackRemoteModel.getClass();

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

		Object returnValue = method.invoke(_feedbackRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FeedbackLocalServiceUtil.addFeedback(this);
		}
		else {
			FeedbackLocalServiceUtil.updateFeedback(this);
		}
	}

	@Override
	public Feedback toEscapedModel() {
		return (Feedback)ProxyUtil.newProxyInstance(Feedback.class.getClassLoader(),
			new Class[] { Feedback.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FeedbackClp clone = new FeedbackClp();

		clone.setFeedbackId(getFeedbackId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setSummary(getSummary());
		clone.setBody(getBody());
		clone.setFullName(getFullName());
		clone.setWorkFor(getWorkFor());
		clone.setAddress(getAddress());
		clone.setPhone(getPhone());
		clone.setEmail(getEmail());
		clone.setFileId(getFileId());
		clone.setFileSize(getFileSize());
		clone.setFileName(getFileName());
		clone.setFileURL(getFileURL());
		clone.setIpAddress(getIpAddress());

		return clone;
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

		if (!(obj instanceof FeedbackClp)) {
			return false;
		}

		FeedbackClp feedback = (FeedbackClp)obj;

		long primaryKey = feedback.getPrimaryKey();

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

	private long _feedbackId;
	private long _groupId;
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
	private BaseModel<?> _feedbackRemoteModel;
	private Class<?> _clpSerializerClass = com.portal_egov.portlet.legal_faq.service.ClpSerializer.class;
}