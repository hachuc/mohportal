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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Comment}.
 * </p>
 *
 * @author chuchv
 * @see Comment
 * @generated
 */
public class CommentWrapper implements Comment, ModelWrapper<Comment> {
	public CommentWrapper(Comment comment) {
		_comment = comment;
	}

	@Override
	public Class<?> getModelClass() {
		return Comment.class;
	}

	@Override
	public String getModelClassName() {
		return Comment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commentId", getCommentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("distributionId", getDistributionId());
		attributes.put("fullName", getFullName());
		attributes.put("address", getAddress());
		attributes.put("email", getEmail());
		attributes.put("body", getBody());
		attributes.put("visible", getVisible());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
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

		Long distributionId = (Long)attributes.get("distributionId");

		if (distributionId != null) {
			setDistributionId(distributionId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		Boolean visible = (Boolean)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	/**
	* Returns the primary key of this comment.
	*
	* @return the primary key of this comment
	*/
	@Override
	public long getPrimaryKey() {
		return _comment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this comment.
	*
	* @param primaryKey the primary key of this comment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_comment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the comment ID of this comment.
	*
	* @return the comment ID of this comment
	*/
	@Override
	public long getCommentId() {
		return _comment.getCommentId();
	}

	/**
	* Sets the comment ID of this comment.
	*
	* @param commentId the comment ID of this comment
	*/
	@Override
	public void setCommentId(long commentId) {
		_comment.setCommentId(commentId);
	}

	/**
	* Returns the group ID of this comment.
	*
	* @return the group ID of this comment
	*/
	@Override
	public long getGroupId() {
		return _comment.getGroupId();
	}

	/**
	* Sets the group ID of this comment.
	*
	* @param groupId the group ID of this comment
	*/
	@Override
	public void setGroupId(long groupId) {
		_comment.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this comment.
	*
	* @return the company ID of this comment
	*/
	@Override
	public long getCompanyId() {
		return _comment.getCompanyId();
	}

	/**
	* Sets the company ID of this comment.
	*
	* @param companyId the company ID of this comment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_comment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this comment.
	*
	* @return the user ID of this comment
	*/
	@Override
	public long getUserId() {
		return _comment.getUserId();
	}

	/**
	* Sets the user ID of this comment.
	*
	* @param userId the user ID of this comment
	*/
	@Override
	public void setUserId(long userId) {
		_comment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this comment.
	*
	* @return the user uuid of this comment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _comment.getUserUuid();
	}

	/**
	* Sets the user uuid of this comment.
	*
	* @param userUuid the user uuid of this comment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_comment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this comment.
	*
	* @return the user name of this comment
	*/
	@Override
	public java.lang.String getUserName() {
		return _comment.getUserName();
	}

	/**
	* Sets the user name of this comment.
	*
	* @param userName the user name of this comment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_comment.setUserName(userName);
	}

	/**
	* Returns the create date of this comment.
	*
	* @return the create date of this comment
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _comment.getCreateDate();
	}

	/**
	* Sets the create date of this comment.
	*
	* @param createDate the create date of this comment
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_comment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this comment.
	*
	* @return the modified date of this comment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _comment.getModifiedDate();
	}

	/**
	* Sets the modified date of this comment.
	*
	* @param modifiedDate the modified date of this comment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_comment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the distribution ID of this comment.
	*
	* @return the distribution ID of this comment
	*/
	@Override
	public long getDistributionId() {
		return _comment.getDistributionId();
	}

	/**
	* Sets the distribution ID of this comment.
	*
	* @param distributionId the distribution ID of this comment
	*/
	@Override
	public void setDistributionId(long distributionId) {
		_comment.setDistributionId(distributionId);
	}

	/**
	* Returns the full name of this comment.
	*
	* @return the full name of this comment
	*/
	@Override
	public java.lang.String getFullName() {
		return _comment.getFullName();
	}

	/**
	* Sets the full name of this comment.
	*
	* @param fullName the full name of this comment
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_comment.setFullName(fullName);
	}

	/**
	* Returns the address of this comment.
	*
	* @return the address of this comment
	*/
	@Override
	public java.lang.String getAddress() {
		return _comment.getAddress();
	}

	/**
	* Sets the address of this comment.
	*
	* @param address the address of this comment
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_comment.setAddress(address);
	}

	/**
	* Returns the email of this comment.
	*
	* @return the email of this comment
	*/
	@Override
	public java.lang.String getEmail() {
		return _comment.getEmail();
	}

	/**
	* Sets the email of this comment.
	*
	* @param email the email of this comment
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_comment.setEmail(email);
	}

	/**
	* Returns the body of this comment.
	*
	* @return the body of this comment
	*/
	@Override
	public java.lang.String getBody() {
		return _comment.getBody();
	}

	/**
	* Sets the body of this comment.
	*
	* @param body the body of this comment
	*/
	@Override
	public void setBody(java.lang.String body) {
		_comment.setBody(body);
	}

	/**
	* Returns the visible of this comment.
	*
	* @return the visible of this comment
	*/
	@Override
	public boolean getVisible() {
		return _comment.getVisible();
	}

	/**
	* Returns <code>true</code> if this comment is visible.
	*
	* @return <code>true</code> if this comment is visible; <code>false</code> otherwise
	*/
	@Override
	public boolean isVisible() {
		return _comment.isVisible();
	}

	/**
	* Sets whether this comment is visible.
	*
	* @param visible the visible of this comment
	*/
	@Override
	public void setVisible(boolean visible) {
		_comment.setVisible(visible);
	}

	/**
	* Returns the ip address of this comment.
	*
	* @return the ip address of this comment
	*/
	@Override
	public java.lang.String getIpAddress() {
		return _comment.getIpAddress();
	}

	/**
	* Sets the ip address of this comment.
	*
	* @param ipAddress the ip address of this comment
	*/
	@Override
	public void setIpAddress(java.lang.String ipAddress) {
		_comment.setIpAddress(ipAddress);
	}

	@Override
	public boolean isNew() {
		return _comment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_comment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _comment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_comment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _comment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _comment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_comment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _comment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_comment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_comment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_comment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommentWrapper((Comment)_comment.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.vcms.model.Comment comment) {
		return _comment.compareTo(comment);
	}

	@Override
	public int hashCode() {
		return _comment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Comment> toCacheModel() {
		return _comment.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Comment toEscapedModel() {
		return new CommentWrapper(_comment.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Comment toUnescapedModel() {
		return new CommentWrapper(_comment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _comment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _comment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_comment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommentWrapper)) {
			return false;
		}

		CommentWrapper commentWrapper = (CommentWrapper)obj;

		if (Validator.equals(_comment, commentWrapper._comment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Comment getWrappedComment() {
		return _comment;
	}

	@Override
	public Comment getWrappedModel() {
		return _comment;
	}

	@Override
	public void resetOriginalValues() {
		_comment.resetOriginalValues();
	}

	private Comment _comment;
}