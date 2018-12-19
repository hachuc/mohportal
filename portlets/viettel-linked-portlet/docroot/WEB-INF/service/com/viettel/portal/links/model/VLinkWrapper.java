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

package com.viettel.portal.links.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VLink}.
 * </p>
 *
 * @author ChucHV
 * @see VLink
 * @generated
 */
public class VLinkWrapper implements VLink, ModelWrapper<VLink> {
	public VLinkWrapper(VLink vLink) {
		_vLink = vLink;
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

	/**
	* Returns the primary key of this v link.
	*
	* @return the primary key of this v link
	*/
	@Override
	public long getPrimaryKey() {
		return _vLink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v link.
	*
	* @param primaryKey the primary key of this v link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vLink.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the link ID of this v link.
	*
	* @return the link ID of this v link
	*/
	@Override
	public long getLinkId() {
		return _vLink.getLinkId();
	}

	/**
	* Sets the link ID of this v link.
	*
	* @param linkId the link ID of this v link
	*/
	@Override
	public void setLinkId(long linkId) {
		_vLink.setLinkId(linkId);
	}

	/**
	* Returns the group ID of this v link.
	*
	* @return the group ID of this v link
	*/
	@Override
	public long getGroupId() {
		return _vLink.getGroupId();
	}

	/**
	* Sets the group ID of this v link.
	*
	* @param groupId the group ID of this v link
	*/
	@Override
	public void setGroupId(long groupId) {
		_vLink.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this v link.
	*
	* @return the company ID of this v link
	*/
	@Override
	public long getCompanyId() {
		return _vLink.getCompanyId();
	}

	/**
	* Sets the company ID of this v link.
	*
	* @param companyId the company ID of this v link
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vLink.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this v link.
	*
	* @return the user ID of this v link
	*/
	@Override
	public long getUserId() {
		return _vLink.getUserId();
	}

	/**
	* Sets the user ID of this v link.
	*
	* @param userId the user ID of this v link
	*/
	@Override
	public void setUserId(long userId) {
		_vLink.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v link.
	*
	* @return the user uuid of this v link
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vLink.getUserUuid();
	}

	/**
	* Sets the user uuid of this v link.
	*
	* @param userUuid the user uuid of this v link
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vLink.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this v link.
	*
	* @return the user name of this v link
	*/
	@Override
	public java.lang.String getUserName() {
		return _vLink.getUserName();
	}

	/**
	* Sets the user name of this v link.
	*
	* @param userName the user name of this v link
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vLink.setUserName(userName);
	}

	/**
	* Returns the create date of this v link.
	*
	* @return the create date of this v link
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vLink.getCreateDate();
	}

	/**
	* Sets the create date of this v link.
	*
	* @param createDate the create date of this v link
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vLink.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this v link.
	*
	* @return the modified date of this v link
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vLink.getModifiedDate();
	}

	/**
	* Sets the modified date of this v link.
	*
	* @param modifiedDate the modified date of this v link
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vLink.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the link name of this v link.
	*
	* @return the link name of this v link
	*/
	@Override
	public java.lang.String getLinkName() {
		return _vLink.getLinkName();
	}

	/**
	* Sets the link name of this v link.
	*
	* @param linkName the link name of this v link
	*/
	@Override
	public void setLinkName(java.lang.String linkName) {
		_vLink.setLinkName(linkName);
	}

	/**
	* Returns the url of this v link.
	*
	* @return the url of this v link
	*/
	@Override
	public java.lang.String getUrl() {
		return _vLink.getUrl();
	}

	/**
	* Sets the url of this v link.
	*
	* @param url the url of this v link
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_vLink.setUrl(url);
	}

	/**
	* Returns the is active of this v link.
	*
	* @return the is active of this v link
	*/
	@Override
	public boolean getIsActive() {
		return _vLink.getIsActive();
	}

	/**
	* Returns <code>true</code> if this v link is is active.
	*
	* @return <code>true</code> if this v link is is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsActive() {
		return _vLink.isIsActive();
	}

	/**
	* Sets whether this v link is is active.
	*
	* @param isActive the is active of this v link
	*/
	@Override
	public void setIsActive(boolean isActive) {
		_vLink.setIsActive(isActive);
	}

	/**
	* Returns the corder of this v link.
	*
	* @return the corder of this v link
	*/
	@Override
	public int getCorder() {
		return _vLink.getCorder();
	}

	/**
	* Sets the corder of this v link.
	*
	* @param corder the corder of this v link
	*/
	@Override
	public void setCorder(int corder) {
		_vLink.setCorder(corder);
	}

	/**
	* Returns the category ID of this v link.
	*
	* @return the category ID of this v link
	*/
	@Override
	public long getCategoryId() {
		return _vLink.getCategoryId();
	}

	/**
	* Sets the category ID of this v link.
	*
	* @param categoryId the category ID of this v link
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_vLink.setCategoryId(categoryId);
	}

	@Override
	public boolean isNew() {
		return _vLink.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vLink.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vLink.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vLink.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vLink.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vLink.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vLink.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vLink.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VLinkWrapper((VLink)_vLink.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.links.model.VLink vLink) {
		return _vLink.compareTo(vLink);
	}

	@Override
	public int hashCode() {
		return _vLink.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.links.model.VLink> toCacheModel() {
		return _vLink.toCacheModel();
	}

	@Override
	public com.viettel.portal.links.model.VLink toEscapedModel() {
		return new VLinkWrapper(_vLink.toEscapedModel());
	}

	@Override
	public com.viettel.portal.links.model.VLink toUnescapedModel() {
		return new VLinkWrapper(_vLink.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vLink.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vLink.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VLinkWrapper)) {
			return false;
		}

		VLinkWrapper vLinkWrapper = (VLinkWrapper)obj;

		if (Validator.equals(_vLink, vLinkWrapper._vLink)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VLink getWrappedVLink() {
		return _vLink;
	}

	@Override
	public VLink getWrappedModel() {
		return _vLink;
	}

	@Override
	public void resetOriginalValues() {
		_vLink.resetOriginalValues();
	}

	private VLink _vLink;
}