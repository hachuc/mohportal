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

package com.liferay.viettel.portal.counter.model;

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
 * @author chuchv
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
		attributes.put("sortOrder", getSortOrder());
		attributes.put("archived", getArchived());
		attributes.put("layoutId", getLayoutId());

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

		Integer sortOrder = (Integer)attributes.get("sortOrder");

		if (sortOrder != null) {
			setSortOrder(sortOrder);
		}

		Boolean archived = (Boolean)attributes.get("archived");

		if (archived != null) {
			setArchived(archived);
		}

		Long layoutId = (Long)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
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
	* Returns the sort order of this category.
	*
	* @return the sort order of this category
	*/
	@Override
	public int getSortOrder() {
		return _category.getSortOrder();
	}

	/**
	* Sets the sort order of this category.
	*
	* @param sortOrder the sort order of this category
	*/
	@Override
	public void setSortOrder(int sortOrder) {
		_category.setSortOrder(sortOrder);
	}

	/**
	* Returns the archived of this category.
	*
	* @return the archived of this category
	*/
	@Override
	public boolean getArchived() {
		return _category.getArchived();
	}

	/**
	* Returns <code>true</code> if this category is archived.
	*
	* @return <code>true</code> if this category is archived; <code>false</code> otherwise
	*/
	@Override
	public boolean isArchived() {
		return _category.isArchived();
	}

	/**
	* Sets whether this category is archived.
	*
	* @param archived the archived of this category
	*/
	@Override
	public void setArchived(boolean archived) {
		_category.setArchived(archived);
	}

	/**
	* Returns the layout ID of this category.
	*
	* @return the layout ID of this category
	*/
	@Override
	public long getLayoutId() {
		return _category.getLayoutId();
	}

	/**
	* Sets the layout ID of this category.
	*
	* @param layoutId the layout ID of this category
	*/
	@Override
	public void setLayoutId(long layoutId) {
		_category.setLayoutId(layoutId);
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
	public int compareTo(
		com.liferay.viettel.portal.counter.model.Category category) {
		return _category.compareTo(category);
	}

	@Override
	public int hashCode() {
		return _category.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.viettel.portal.counter.model.Category> toCacheModel() {
		return _category.toCacheModel();
	}

	@Override
	public com.liferay.viettel.portal.counter.model.Category toEscapedModel() {
		return new CategoryWrapper(_category.toEscapedModel());
	}

	@Override
	public com.liferay.viettel.portal.counter.model.Category toUnescapedModel() {
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