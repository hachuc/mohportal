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

package com.viettel.portal.photos.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PCategory}.
 * </p>
 *
 * @author ChucHV
 * @see PCategory
 * @generated
 */
public class PCategoryWrapper implements PCategory, ModelWrapper<PCategory> {
	public PCategoryWrapper(PCategory pCategory) {
		_pCategory = pCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return PCategory.class;
	}

	@Override
	public String getModelClassName() {
		return PCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("order_", getOrder_());
		attributes.put("status", getStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer order_ = (Integer)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this p category.
	*
	* @return the primary key of this p category
	*/
	@Override
	public long getPrimaryKey() {
		return _pCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p category.
	*
	* @param primaryKey the primary key of this p category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this p category.
	*
	* @return the ID of this p category
	*/
	@Override
	public long getId() {
		return _pCategory.getId();
	}

	/**
	* Sets the ID of this p category.
	*
	* @param id the ID of this p category
	*/
	@Override
	public void setId(long id) {
		_pCategory.setId(id);
	}

	/**
	* Returns the name of this p category.
	*
	* @return the name of this p category
	*/
	@Override
	public java.lang.String getName() {
		return _pCategory.getName();
	}

	/**
	* Sets the name of this p category.
	*
	* @param name the name of this p category
	*/
	@Override
	public void setName(java.lang.String name) {
		_pCategory.setName(name);
	}

	/**
	* Returns the order_ of this p category.
	*
	* @return the order_ of this p category
	*/
	@Override
	public int getOrder_() {
		return _pCategory.getOrder_();
	}

	/**
	* Sets the order_ of this p category.
	*
	* @param order_ the order_ of this p category
	*/
	@Override
	public void setOrder_(int order_) {
		_pCategory.setOrder_(order_);
	}

	/**
	* Returns the status of this p category.
	*
	* @return the status of this p category
	*/
	@Override
	public boolean getStatus() {
		return _pCategory.getStatus();
	}

	/**
	* Returns <code>true</code> if this p category is status.
	*
	* @return <code>true</code> if this p category is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _pCategory.isStatus();
	}

	/**
	* Sets whether this p category is status.
	*
	* @param status the status of this p category
	*/
	@Override
	public void setStatus(boolean status) {
		_pCategory.setStatus(status);
	}

	/**
	* Returns the company ID of this p category.
	*
	* @return the company ID of this p category
	*/
	@Override
	public long getCompanyId() {
		return _pCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this p category.
	*
	* @param companyId the company ID of this p category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_pCategory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this p category.
	*
	* @return the group ID of this p category
	*/
	@Override
	public long getGroupId() {
		return _pCategory.getGroupId();
	}

	/**
	* Sets the group ID of this p category.
	*
	* @param groupId the group ID of this p category
	*/
	@Override
	public void setGroupId(long groupId) {
		_pCategory.setGroupId(groupId);
	}

	/**
	* Returns the create date of this p category.
	*
	* @return the create date of this p category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _pCategory.getCreateDate();
	}

	/**
	* Sets the create date of this p category.
	*
	* @param createDate the create date of this p category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_pCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this p category.
	*
	* @return the modify date of this p category
	*/
	@Override
	public java.util.Date getModifyDate() {
		return _pCategory.getModifyDate();
	}

	/**
	* Sets the modify date of this p category.
	*
	* @param modifyDate the modify date of this p category
	*/
	@Override
	public void setModifyDate(java.util.Date modifyDate) {
		_pCategory.setModifyDate(modifyDate);
	}

	/**
	* Returns the user name of this p category.
	*
	* @return the user name of this p category
	*/
	@Override
	public java.lang.String getUserName() {
		return _pCategory.getUserName();
	}

	/**
	* Sets the user name of this p category.
	*
	* @param userName the user name of this p category
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_pCategory.setUserName(userName);
	}

	/**
	* Returns the user ID of this p category.
	*
	* @return the user ID of this p category
	*/
	@Override
	public long getUserId() {
		return _pCategory.getUserId();
	}

	/**
	* Sets the user ID of this p category.
	*
	* @param userId the user ID of this p category
	*/
	@Override
	public void setUserId(long userId) {
		_pCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p category.
	*
	* @return the user uuid of this p category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this p category.
	*
	* @param userUuid the user uuid of this p category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_pCategory.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _pCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_pCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _pCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _pCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _pCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_pCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_pCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PCategoryWrapper((PCategory)_pCategory.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.photos.model.PCategory pCategory) {
		return _pCategory.compareTo(pCategory);
	}

	@Override
	public int hashCode() {
		return _pCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.photos.model.PCategory> toCacheModel() {
		return _pCategory.toCacheModel();
	}

	@Override
	public com.viettel.portal.photos.model.PCategory toEscapedModel() {
		return new PCategoryWrapper(_pCategory.toEscapedModel());
	}

	@Override
	public com.viettel.portal.photos.model.PCategory toUnescapedModel() {
		return new PCategoryWrapper(_pCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _pCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PCategoryWrapper)) {
			return false;
		}

		PCategoryWrapper pCategoryWrapper = (PCategoryWrapper)obj;

		if (Validator.equals(_pCategory, pCategoryWrapper._pCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PCategory getWrappedPCategory() {
		return _pCategory;
	}

	@Override
	public PCategory getWrappedModel() {
		return _pCategory;
	}

	@Override
	public void resetOriginalValues() {
		_pCategory.resetOriginalValues();
	}

	private PCategory _pCategory;
}