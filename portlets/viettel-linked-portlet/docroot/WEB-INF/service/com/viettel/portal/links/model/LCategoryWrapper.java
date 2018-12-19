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
 * This class is a wrapper for {@link LCategory}.
 * </p>
 *
 * @author ChucHV
 * @see LCategory
 * @generated
 */
public class LCategoryWrapper implements LCategory, ModelWrapper<LCategory> {
	public LCategoryWrapper(LCategory lCategory) {
		_lCategory = lCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return LCategory.class;
	}

	@Override
	public String getModelClassName() {
		return LCategory.class.getName();
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
		attributes.put("corder", getCorder());
		attributes.put("isActive", getIsActive());

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

		Integer corder = (Integer)attributes.get("corder");

		if (corder != null) {
			setCorder(corder);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	/**
	* Returns the primary key of this l category.
	*
	* @return the primary key of this l category
	*/
	@Override
	public long getPrimaryKey() {
		return _lCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l category.
	*
	* @param primaryKey the primary key of this l category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this l category.
	*
	* @return the category ID of this l category
	*/
	@Override
	public long getCategoryId() {
		return _lCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this l category.
	*
	* @param categoryId the category ID of this l category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_lCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this l category.
	*
	* @return the group ID of this l category
	*/
	@Override
	public long getGroupId() {
		return _lCategory.getGroupId();
	}

	/**
	* Sets the group ID of this l category.
	*
	* @param groupId the group ID of this l category
	*/
	@Override
	public void setGroupId(long groupId) {
		_lCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this l category.
	*
	* @return the company ID of this l category
	*/
	@Override
	public long getCompanyId() {
		return _lCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this l category.
	*
	* @param companyId the company ID of this l category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_lCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this l category.
	*
	* @return the user ID of this l category
	*/
	@Override
	public long getUserId() {
		return _lCategory.getUserId();
	}

	/**
	* Sets the user ID of this l category.
	*
	* @param userId the user ID of this l category
	*/
	@Override
	public void setUserId(long userId) {
		_lCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this l category.
	*
	* @return the user uuid of this l category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this l category.
	*
	* @param userUuid the user uuid of this l category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_lCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this l category.
	*
	* @return the user name of this l category
	*/
	@Override
	public java.lang.String getUserName() {
		return _lCategory.getUserName();
	}

	/**
	* Sets the user name of this l category.
	*
	* @param userName the user name of this l category
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_lCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this l category.
	*
	* @return the create date of this l category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _lCategory.getCreateDate();
	}

	/**
	* Sets the create date of this l category.
	*
	* @param createDate the create date of this l category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_lCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this l category.
	*
	* @return the modified date of this l category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _lCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this l category.
	*
	* @param modifiedDate the modified date of this l category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_lCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category name of this l category.
	*
	* @return the category name of this l category
	*/
	@Override
	public java.lang.String getCategoryName() {
		return _lCategory.getCategoryName();
	}

	/**
	* Sets the category name of this l category.
	*
	* @param categoryName the category name of this l category
	*/
	@Override
	public void setCategoryName(java.lang.String categoryName) {
		_lCategory.setCategoryName(categoryName);
	}

	/**
	* Returns the corder of this l category.
	*
	* @return the corder of this l category
	*/
	@Override
	public int getCorder() {
		return _lCategory.getCorder();
	}

	/**
	* Sets the corder of this l category.
	*
	* @param corder the corder of this l category
	*/
	@Override
	public void setCorder(int corder) {
		_lCategory.setCorder(corder);
	}

	/**
	* Returns the is active of this l category.
	*
	* @return the is active of this l category
	*/
	@Override
	public boolean getIsActive() {
		return _lCategory.getIsActive();
	}

	/**
	* Returns <code>true</code> if this l category is is active.
	*
	* @return <code>true</code> if this l category is is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsActive() {
		return _lCategory.isIsActive();
	}

	/**
	* Sets whether this l category is is active.
	*
	* @param isActive the is active of this l category
	*/
	@Override
	public void setIsActive(boolean isActive) {
		_lCategory.setIsActive(isActive);
	}

	@Override
	public boolean isNew() {
		return _lCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LCategoryWrapper((LCategory)_lCategory.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.links.model.LCategory lCategory) {
		return _lCategory.compareTo(lCategory);
	}

	@Override
	public int hashCode() {
		return _lCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.links.model.LCategory> toCacheModel() {
		return _lCategory.toCacheModel();
	}

	@Override
	public com.viettel.portal.links.model.LCategory toEscapedModel() {
		return new LCategoryWrapper(_lCategory.toEscapedModel());
	}

	@Override
	public com.viettel.portal.links.model.LCategory toUnescapedModel() {
		return new LCategoryWrapper(_lCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LCategoryWrapper)) {
			return false;
		}

		LCategoryWrapper lCategoryWrapper = (LCategoryWrapper)obj;

		if (Validator.equals(_lCategory, lCategoryWrapper._lCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LCategory getWrappedLCategory() {
		return _lCategory;
	}

	@Override
	public LCategory getWrappedModel() {
		return _lCategory;
	}

	@Override
	public void resetOriginalValues() {
		_lCategory.resetOriginalValues();
	}

	private LCategory _lCategory;
}