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

package com.revotech.portal.videolibrary.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VLCategory}.
 * </p>
 *
 * @author ChucHV
 * @see VLCategory
 * @generated
 */
public class VLCategoryWrapper implements VLCategory, ModelWrapper<VLCategory> {
	public VLCategoryWrapper(VLCategory vlCategory) {
		_vlCategory = vlCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return VLCategory.class;
	}

	@Override
	public String getModelClassName() {
		return VLCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryName", getCategoryName());
		attributes.put("invisible", getInvisible());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		Boolean invisible = (Boolean)attributes.get("invisible");

		if (invisible != null) {
			setInvisible(invisible);
		}
	}

	/**
	* Returns the primary key of this v l category.
	*
	* @return the primary key of this v l category
	*/
	@Override
	public long getPrimaryKey() {
		return _vlCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v l category.
	*
	* @param primaryKey the primary key of this v l category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vlCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this v l category.
	*
	* @return the category ID of this v l category
	*/
	@Override
	public long getCategoryId() {
		return _vlCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this v l category.
	*
	* @param categoryId the category ID of this v l category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_vlCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this v l category.
	*
	* @return the group ID of this v l category
	*/
	@Override
	public long getGroupId() {
		return _vlCategory.getGroupId();
	}

	/**
	* Sets the group ID of this v l category.
	*
	* @param groupId the group ID of this v l category
	*/
	@Override
	public void setGroupId(long groupId) {
		_vlCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this v l category.
	*
	* @return the company ID of this v l category
	*/
	@Override
	public long getCompanyId() {
		return _vlCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this v l category.
	*
	* @param companyId the company ID of this v l category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vlCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this v l category.
	*
	* @return the user ID of this v l category
	*/
	@Override
	public long getUserId() {
		return _vlCategory.getUserId();
	}

	/**
	* Sets the user ID of this v l category.
	*
	* @param userId the user ID of this v l category
	*/
	@Override
	public void setUserId(long userId) {
		_vlCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v l category.
	*
	* @return the user uuid of this v l category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this v l category.
	*
	* @param userUuid the user uuid of this v l category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vlCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this v l category.
	*
	* @return the user name of this v l category
	*/
	@Override
	public java.lang.String getUserName() {
		return _vlCategory.getUserName();
	}

	/**
	* Sets the user name of this v l category.
	*
	* @param userName the user name of this v l category
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vlCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this v l category.
	*
	* @return the create date of this v l category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vlCategory.getCreateDate();
	}

	/**
	* Sets the create date of this v l category.
	*
	* @param createDate the create date of this v l category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vlCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this v l category.
	*
	* @return the modified date of this v l category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vlCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this v l category.
	*
	* @param modifiedDate the modified date of this v l category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vlCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category name of this v l category.
	*
	* @return the category name of this v l category
	*/
	@Override
	public java.lang.String getCategoryName() {
		return _vlCategory.getCategoryName();
	}

	/**
	* Sets the category name of this v l category.
	*
	* @param categoryName the category name of this v l category
	*/
	@Override
	public void setCategoryName(java.lang.String categoryName) {
		_vlCategory.setCategoryName(categoryName);
	}

	/**
	* Returns the invisible of this v l category.
	*
	* @return the invisible of this v l category
	*/
	@Override
	public boolean getInvisible() {
		return _vlCategory.getInvisible();
	}

	/**
	* Returns <code>true</code> if this v l category is invisible.
	*
	* @return <code>true</code> if this v l category is invisible; <code>false</code> otherwise
	*/
	@Override
	public boolean isInvisible() {
		return _vlCategory.isInvisible();
	}

	/**
	* Sets whether this v l category is invisible.
	*
	* @param invisible the invisible of this v l category
	*/
	@Override
	public void setInvisible(boolean invisible) {
		_vlCategory.setInvisible(invisible);
	}

	@Override
	public boolean isNew() {
		return _vlCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vlCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vlCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vlCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vlCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vlCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vlCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vlCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vlCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vlCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vlCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VLCategoryWrapper((VLCategory)_vlCategory.clone());
	}

	@Override
	public int compareTo(
		com.revotech.portal.videolibrary.model.VLCategory vlCategory) {
		return _vlCategory.compareTo(vlCategory);
	}

	@Override
	public int hashCode() {
		return _vlCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.revotech.portal.videolibrary.model.VLCategory> toCacheModel() {
		return _vlCategory.toCacheModel();
	}

	@Override
	public com.revotech.portal.videolibrary.model.VLCategory toEscapedModel() {
		return new VLCategoryWrapper(_vlCategory.toEscapedModel());
	}

	@Override
	public com.revotech.portal.videolibrary.model.VLCategory toUnescapedModel() {
		return new VLCategoryWrapper(_vlCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vlCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vlCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vlCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VLCategoryWrapper)) {
			return false;
		}

		VLCategoryWrapper vlCategoryWrapper = (VLCategoryWrapper)obj;

		if (Validator.equals(_vlCategory, vlCategoryWrapper._vlCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VLCategory getWrappedVLCategory() {
		return _vlCategory;
	}

	@Override
	public VLCategory getWrappedModel() {
		return _vlCategory;
	}

	@Override
	public void resetOriginalValues() {
		_vlCategory.resetOriginalValues();
	}

	private VLCategory _vlCategory;
}