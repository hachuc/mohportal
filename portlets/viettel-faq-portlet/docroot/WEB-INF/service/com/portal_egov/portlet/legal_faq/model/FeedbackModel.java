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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Feedback service. Represents a row in the &quot;vcms_feedback&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackImpl}.
 * </p>
 *
 * @author chuchv
 * @see Feedback
 * @see com.portal_egov.portlet.legal_faq.model.impl.FeedbackImpl
 * @see com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl
 * @generated
 */
public interface FeedbackModel extends BaseModel<Feedback>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a feedback model instance should use the {@link Feedback} interface instead.
	 */

	/**
	 * Returns the primary key of this feedback.
	 *
	 * @return the primary key of this feedback
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this feedback.
	 *
	 * @param primaryKey the primary key of this feedback
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the feedback ID of this feedback.
	 *
	 * @return the feedback ID of this feedback
	 */
	public long getFeedbackId();

	/**
	 * Sets the feedback ID of this feedback.
	 *
	 * @param feedbackId the feedback ID of this feedback
	 */
	public void setFeedbackId(long feedbackId);

	/**
	 * Returns the group ID of this feedback.
	 *
	 * @return the group ID of this feedback
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this feedback.
	 *
	 * @param groupId the group ID of this feedback
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this feedback.
	 *
	 * @return the company ID of this feedback
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this feedback.
	 *
	 * @param companyId the company ID of this feedback
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this feedback.
	 *
	 * @return the user ID of this feedback
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this feedback.
	 *
	 * @param userId the user ID of this feedback
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this feedback.
	 *
	 * @return the user uuid of this feedback
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this feedback.
	 *
	 * @param userUuid the user uuid of this feedback
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this feedback.
	 *
	 * @return the user name of this feedback
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this feedback.
	 *
	 * @param userName the user name of this feedback
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this feedback.
	 *
	 * @return the create date of this feedback
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this feedback.
	 *
	 * @param createDate the create date of this feedback
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this feedback.
	 *
	 * @return the modified date of this feedback
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this feedback.
	 *
	 * @param modifiedDate the modified date of this feedback
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this feedback.
	 *
	 * @return the title of this feedback
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this feedback.
	 *
	 * @param title the title of this feedback
	 */
	public void setTitle(String title);

	/**
	 * Returns the summary of this feedback.
	 *
	 * @return the summary of this feedback
	 */
	@AutoEscape
	public String getSummary();

	/**
	 * Sets the summary of this feedback.
	 *
	 * @param summary the summary of this feedback
	 */
	public void setSummary(String summary);

	/**
	 * Returns the body of this feedback.
	 *
	 * @return the body of this feedback
	 */
	@AutoEscape
	public String getBody();

	/**
	 * Sets the body of this feedback.
	 *
	 * @param body the body of this feedback
	 */
	public void setBody(String body);

	/**
	 * Returns the full name of this feedback.
	 *
	 * @return the full name of this feedback
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this feedback.
	 *
	 * @param fullName the full name of this feedback
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the work for of this feedback.
	 *
	 * @return the work for of this feedback
	 */
	@AutoEscape
	public String getWorkFor();

	/**
	 * Sets the work for of this feedback.
	 *
	 * @param workFor the work for of this feedback
	 */
	public void setWorkFor(String workFor);

	/**
	 * Returns the address of this feedback.
	 *
	 * @return the address of this feedback
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this feedback.
	 *
	 * @param address the address of this feedback
	 */
	public void setAddress(String address);

	/**
	 * Returns the phone of this feedback.
	 *
	 * @return the phone of this feedback
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this feedback.
	 *
	 * @param phone the phone of this feedback
	 */
	public void setPhone(String phone);

	/**
	 * Returns the email of this feedback.
	 *
	 * @return the email of this feedback
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this feedback.
	 *
	 * @param email the email of this feedback
	 */
	public void setEmail(String email);

	/**
	 * Returns the file ID of this feedback.
	 *
	 * @return the file ID of this feedback
	 */
	public long getFileId();

	/**
	 * Sets the file ID of this feedback.
	 *
	 * @param fileId the file ID of this feedback
	 */
	public void setFileId(long fileId);

	/**
	 * Returns the file size of this feedback.
	 *
	 * @return the file size of this feedback
	 */
	@AutoEscape
	public String getFileSize();

	/**
	 * Sets the file size of this feedback.
	 *
	 * @param fileSize the file size of this feedback
	 */
	public void setFileSize(String fileSize);

	/**
	 * Returns the file name of this feedback.
	 *
	 * @return the file name of this feedback
	 */
	@AutoEscape
	public String getFileName();

	/**
	 * Sets the file name of this feedback.
	 *
	 * @param fileName the file name of this feedback
	 */
	public void setFileName(String fileName);

	/**
	 * Returns the file u r l of this feedback.
	 *
	 * @return the file u r l of this feedback
	 */
	@AutoEscape
	public String getFileURL();

	/**
	 * Sets the file u r l of this feedback.
	 *
	 * @param fileURL the file u r l of this feedback
	 */
	public void setFileURL(String fileURL);

	/**
	 * Returns the ip address of this feedback.
	 *
	 * @return the ip address of this feedback
	 */
	@AutoEscape
	public String getIpAddress();

	/**
	 * Sets the ip address of this feedback.
	 *
	 * @param ipAddress the ip address of this feedback
	 */
	public void setIpAddress(String ipAddress);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.portal_egov.portlet.legal_faq.model.Feedback feedback);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.portal_egov.portlet.legal_faq.model.Feedback> toCacheModel();

	@Override
	public com.portal_egov.portlet.legal_faq.model.Feedback toEscapedModel();

	@Override
	public com.portal_egov.portlet.legal_faq.model.Feedback toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}