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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Feedback}.
 * </p>
 *
 * @author chuchv
 * @see Feedback
 * @generated
 */
public class FeedbackWrapper implements Feedback, ModelWrapper<Feedback> {
	public FeedbackWrapper(Feedback feedback) {
		_feedback = feedback;
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

	/**
	* Returns the primary key of this feedback.
	*
	* @return the primary key of this feedback
	*/
	@Override
	public long getPrimaryKey() {
		return _feedback.getPrimaryKey();
	}

	/**
	* Sets the primary key of this feedback.
	*
	* @param primaryKey the primary key of this feedback
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_feedback.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the feedback ID of this feedback.
	*
	* @return the feedback ID of this feedback
	*/
	@Override
	public long getFeedbackId() {
		return _feedback.getFeedbackId();
	}

	/**
	* Sets the feedback ID of this feedback.
	*
	* @param feedbackId the feedback ID of this feedback
	*/
	@Override
	public void setFeedbackId(long feedbackId) {
		_feedback.setFeedbackId(feedbackId);
	}

	/**
	* Returns the group ID of this feedback.
	*
	* @return the group ID of this feedback
	*/
	@Override
	public long getGroupId() {
		return _feedback.getGroupId();
	}

	/**
	* Sets the group ID of this feedback.
	*
	* @param groupId the group ID of this feedback
	*/
	@Override
	public void setGroupId(long groupId) {
		_feedback.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this feedback.
	*
	* @return the company ID of this feedback
	*/
	@Override
	public long getCompanyId() {
		return _feedback.getCompanyId();
	}

	/**
	* Sets the company ID of this feedback.
	*
	* @param companyId the company ID of this feedback
	*/
	@Override
	public void setCompanyId(long companyId) {
		_feedback.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this feedback.
	*
	* @return the user ID of this feedback
	*/
	@Override
	public long getUserId() {
		return _feedback.getUserId();
	}

	/**
	* Sets the user ID of this feedback.
	*
	* @param userId the user ID of this feedback
	*/
	@Override
	public void setUserId(long userId) {
		_feedback.setUserId(userId);
	}

	/**
	* Returns the user uuid of this feedback.
	*
	* @return the user uuid of this feedback
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedback.getUserUuid();
	}

	/**
	* Sets the user uuid of this feedback.
	*
	* @param userUuid the user uuid of this feedback
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_feedback.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this feedback.
	*
	* @return the user name of this feedback
	*/
	@Override
	public java.lang.String getUserName() {
		return _feedback.getUserName();
	}

	/**
	* Sets the user name of this feedback.
	*
	* @param userName the user name of this feedback
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_feedback.setUserName(userName);
	}

	/**
	* Returns the create date of this feedback.
	*
	* @return the create date of this feedback
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _feedback.getCreateDate();
	}

	/**
	* Sets the create date of this feedback.
	*
	* @param createDate the create date of this feedback
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_feedback.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this feedback.
	*
	* @return the modified date of this feedback
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _feedback.getModifiedDate();
	}

	/**
	* Sets the modified date of this feedback.
	*
	* @param modifiedDate the modified date of this feedback
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_feedback.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this feedback.
	*
	* @return the title of this feedback
	*/
	@Override
	public java.lang.String getTitle() {
		return _feedback.getTitle();
	}

	/**
	* Sets the title of this feedback.
	*
	* @param title the title of this feedback
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_feedback.setTitle(title);
	}

	/**
	* Returns the summary of this feedback.
	*
	* @return the summary of this feedback
	*/
	@Override
	public java.lang.String getSummary() {
		return _feedback.getSummary();
	}

	/**
	* Sets the summary of this feedback.
	*
	* @param summary the summary of this feedback
	*/
	@Override
	public void setSummary(java.lang.String summary) {
		_feedback.setSummary(summary);
	}

	/**
	* Returns the body of this feedback.
	*
	* @return the body of this feedback
	*/
	@Override
	public java.lang.String getBody() {
		return _feedback.getBody();
	}

	/**
	* Sets the body of this feedback.
	*
	* @param body the body of this feedback
	*/
	@Override
	public void setBody(java.lang.String body) {
		_feedback.setBody(body);
	}

	/**
	* Returns the full name of this feedback.
	*
	* @return the full name of this feedback
	*/
	@Override
	public java.lang.String getFullName() {
		return _feedback.getFullName();
	}

	/**
	* Sets the full name of this feedback.
	*
	* @param fullName the full name of this feedback
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_feedback.setFullName(fullName);
	}

	/**
	* Returns the work for of this feedback.
	*
	* @return the work for of this feedback
	*/
	@Override
	public java.lang.String getWorkFor() {
		return _feedback.getWorkFor();
	}

	/**
	* Sets the work for of this feedback.
	*
	* @param workFor the work for of this feedback
	*/
	@Override
	public void setWorkFor(java.lang.String workFor) {
		_feedback.setWorkFor(workFor);
	}

	/**
	* Returns the address of this feedback.
	*
	* @return the address of this feedback
	*/
	@Override
	public java.lang.String getAddress() {
		return _feedback.getAddress();
	}

	/**
	* Sets the address of this feedback.
	*
	* @param address the address of this feedback
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_feedback.setAddress(address);
	}

	/**
	* Returns the phone of this feedback.
	*
	* @return the phone of this feedback
	*/
	@Override
	public java.lang.String getPhone() {
		return _feedback.getPhone();
	}

	/**
	* Sets the phone of this feedback.
	*
	* @param phone the phone of this feedback
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_feedback.setPhone(phone);
	}

	/**
	* Returns the email of this feedback.
	*
	* @return the email of this feedback
	*/
	@Override
	public java.lang.String getEmail() {
		return _feedback.getEmail();
	}

	/**
	* Sets the email of this feedback.
	*
	* @param email the email of this feedback
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_feedback.setEmail(email);
	}

	/**
	* Returns the file ID of this feedback.
	*
	* @return the file ID of this feedback
	*/
	@Override
	public long getFileId() {
		return _feedback.getFileId();
	}

	/**
	* Sets the file ID of this feedback.
	*
	* @param fileId the file ID of this feedback
	*/
	@Override
	public void setFileId(long fileId) {
		_feedback.setFileId(fileId);
	}

	/**
	* Returns the file size of this feedback.
	*
	* @return the file size of this feedback
	*/
	@Override
	public java.lang.String getFileSize() {
		return _feedback.getFileSize();
	}

	/**
	* Sets the file size of this feedback.
	*
	* @param fileSize the file size of this feedback
	*/
	@Override
	public void setFileSize(java.lang.String fileSize) {
		_feedback.setFileSize(fileSize);
	}

	/**
	* Returns the file name of this feedback.
	*
	* @return the file name of this feedback
	*/
	@Override
	public java.lang.String getFileName() {
		return _feedback.getFileName();
	}

	/**
	* Sets the file name of this feedback.
	*
	* @param fileName the file name of this feedback
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_feedback.setFileName(fileName);
	}

	/**
	* Returns the file u r l of this feedback.
	*
	* @return the file u r l of this feedback
	*/
	@Override
	public java.lang.String getFileURL() {
		return _feedback.getFileURL();
	}

	/**
	* Sets the file u r l of this feedback.
	*
	* @param fileURL the file u r l of this feedback
	*/
	@Override
	public void setFileURL(java.lang.String fileURL) {
		_feedback.setFileURL(fileURL);
	}

	/**
	* Returns the ip address of this feedback.
	*
	* @return the ip address of this feedback
	*/
	@Override
	public java.lang.String getIpAddress() {
		return _feedback.getIpAddress();
	}

	/**
	* Sets the ip address of this feedback.
	*
	* @param ipAddress the ip address of this feedback
	*/
	@Override
	public void setIpAddress(java.lang.String ipAddress) {
		_feedback.setIpAddress(ipAddress);
	}

	@Override
	public boolean isNew() {
		return _feedback.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_feedback.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _feedback.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feedback.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _feedback.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _feedback.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_feedback.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _feedback.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_feedback.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_feedback.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_feedback.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FeedbackWrapper((Feedback)_feedback.clone());
	}

	@Override
	public int compareTo(
		com.portal_egov.portlet.legal_faq.model.Feedback feedback) {
		return _feedback.compareTo(feedback);
	}

	@Override
	public int hashCode() {
		return _feedback.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.legal_faq.model.Feedback> toCacheModel() {
		return _feedback.toCacheModel();
	}

	@Override
	public com.portal_egov.portlet.legal_faq.model.Feedback toEscapedModel() {
		return new FeedbackWrapper(_feedback.toEscapedModel());
	}

	@Override
	public com.portal_egov.portlet.legal_faq.model.Feedback toUnescapedModel() {
		return new FeedbackWrapper(_feedback.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _feedback.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _feedback.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_feedback.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackWrapper)) {
			return false;
		}

		FeedbackWrapper feedbackWrapper = (FeedbackWrapper)obj;

		if (Validator.equals(_feedback, feedbackWrapper._feedback)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Feedback getWrappedFeedback() {
		return _feedback;
	}

	@Override
	public Feedback getWrappedModel() {
		return _feedback;
	}

	@Override
	public void resetOriginalValues() {
		_feedback.resetOriginalValues();
	}

	private Feedback _feedback;
}