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

package com.revotech.portal.tthc.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author hieptran
 * @see Category
 * @generated
 */
public class CategoryWrapper implements Category, ModelWrapper<Category> {
	public CategoryWrapper(Category category) {
		_category = category;
	}

	@Override
	public Class<?> getModelClass() {
		return Category.class;
	}

	@Override
	public String getModelClassName() {
		return Category.class.getName();
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
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("isActive", getIsActive());
		attributes.put("categoryType", getCategoryType());
		attributes.put("catOrder", getCatOrder());

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

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Integer categoryType = (Integer)attributes.get("categoryType");

		if (categoryType != null) {
			setCategoryType(categoryType);
		}

		Integer catOrder = (Integer)attributes.get("catOrder");

		if (catOrder != null) {
			setCatOrder(catOrder);
		}
	}

	/**
	* Returns the primary key of this category.
	*
	* @return the primary key of this category
	*/
	@Override
	public long getPrimaryKey() {
		return _category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category.
	*
	* @param primaryKey the primary key of this category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this category.
	*
	* @return the category ID of this category
	*/
	@Override
	public long getCategoryId() {
		return _category.getCategoryId();
	}

	/**
	* Sets the category ID of this category.
	*
	* @param categoryId the category ID of this category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_category.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this category.
	*
	* @return the group ID of this category
	*/
	@Override
	public long getGroupId() {
		return _category.getGroupId();
	}

	/**
	* Sets the group ID of this category.
	*
	* @param groupId the group ID of this category
	*/
	@Override
	public void setGroupId(long groupId) {
		_category.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this category.
	*
	* @return the company ID of this category
	*/
	@Override
	public long getCompanyId() {
		return _category.getCompanyId();
	}

	/**
	* Sets the company ID of this category.
	*
	* @param companyId the company ID of this category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_category.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this category.
	*
	* @return the user ID of this category
	*/
	@Override
	public long getUserId() {
		return _category.getUserId();
	}

	/**
	* Sets the user ID of this category.
	*
	* @param userId the user ID of this category
	*/
	@Override
	public void setUserId(long userId) {
		_category.setUserId(userId);
	}

	/**
	* Returns the user uuid of this category.
	*
	* @return the user uuid of this category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _category.getUserUuid();
	}

	/**
	* Sets the user uuid of this category.
	*
	* @param userUuid the user uuid of this category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_category.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this category.
	*
	* @return the user name of this category
	*/
	@Override
	public java.lang.String getUserName() {
		return _category.getUserName();
	}

	/**
	* Sets the user name of this category.
	*
	* @param userName the user name of this category
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_category.setUserName(userName);
	}

	/**
	* Returns the create date of this category.
	*
	* @return the create date of this category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _category.getCreateDate();
	}

	/**
	* Sets the create date of this category.
	*
	* @param createDate the create date of this category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_category.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this category.
	*
	* @return the modified date of this category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _category.getModifiedDate();
	}

	/**
	* Sets the modified date of this category.
	*
	* @param modifiedDate the modified date of this category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_category.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category name of this category.
	*
	* @return the category name of this category
	*/
	@Override
	public java.lang.String getCategoryName() {
		return _category.getCategoryName();
	}

	/**
	* Sets the category name of this category.
	*
	* @param categoryName the category name of this category
	*/
	@Override
	public void setCategoryName(java.lang.String categoryName) {
		_category.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this category.
	*
	* @return the category desc of this category
	*/
	@Override
	public java.lang.String getCategoryDesc() {
		return _category.getCategoryDesc();
	}

	/**
	* Sets the category desc of this category.
	*
	* @param categoryDesc the category desc of this category
	*/
	@Override
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_category.setCategoryDesc(categoryDesc);
	}

	/**
	* Returns the is active of this category.
	*
	* @return the is active of this category
	*/
	@Override
	public boolean getIsActive() {
		return _category.getIsActive();
	}

	/**
	* Returns <code>true</code> if this category is is active.
	*
	* @return <code>true</code> if this category is is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsActive() {
		return _category.isIsActive();
	}

	/**
	* Sets whether this category is is active.
	*
	* @param isActive the is active of this category
	*/
	@Override
	public void setIsActive(boolean isActive) {
		_category.setIsActive(isActive);
	}

	/**
	* Returns the category type of this category.
	*
	* @return the category type of this category
	*/
	@Override
	public int getCategoryType() {
		return _category.getCategoryType();
	}

	/**
	* Sets the category type of this category.
	*
	* @param categoryType the category type of this category
	*/
	@Override
	public void setCategoryType(int categoryType) {
		_category.setCategoryType(categoryType);
	}

	/**
	* Returns the cat order of this category.
	*
	* @return the cat order of this category
	*/
	@Override
	public int getCatOrder() {
		return _category.getCatOrder();
	}

	/**
	* Sets the cat order of this category.
	*
	* @param catOrder the cat order of this category
	*/
	@Override
	public void setCatOrder(int catOrder) {
		_category.setCatOrder(catOrder);
	}

	@Override
	public boolean isNew() {
		return _category.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_category.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _category.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_category.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _category.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _category.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_category.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _category.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_category.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_category.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryWrapper((Category)_category.clone());
	}

	@Override
	public int compareTo(com.revotech.portal.tthc.model.Category category) {
		return _category.compareTo(category);
	}

	@Override
	public int hashCode() {
		return _category.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.revotech.portal.tthc.model.Category> toCacheModel() {
		return _category.toCacheModel();
	}

	@Override
	public com.revotech.portal.tthc.model.Category toEscapedModel() {
		return new CategoryWrapper(_category.toEscapedModel());
	}

	@Override
	public com.revotech.portal.tthc.model.Category toUnescapedModel() {
		return new CategoryWrapper(_category.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _category.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _category.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_category.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoryWrapper)) {
			return false;
		}

		CategoryWrapper categoryWrapper = (CategoryWrapper)obj;

		if (Validator.equals(_category, categoryWrapper._category)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Category getWrappedCategory() {
		return _category;
	}

	@Override
	public Category getWrappedModel() {
		return _category;
	}

	@Override
	public void resetOriginalValues() {
		_category.resetOriginalValues();
	}

	private Category _category;
}