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

package com.viettel.portal.thongke.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PhongBan}.
 * </p>
 *
 * @author lamvn
 * @see PhongBan
 * @generated
 */
public class PhongBanWrapper implements PhongBan, ModelWrapper<PhongBan> {
	public PhongBanWrapper(PhongBan phongBan) {
		_phongBan = phongBan;
	}

	@Override
	public Class<?> getModelClass() {
		return PhongBan.class;
	}

	@Override
	public String getModelClassName() {
		return PhongBan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("order_", getOrder_());
		attributes.put("descriptions", getDescriptions());
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

		String descriptions = (String)attributes.get("descriptions");

		if (descriptions != null) {
			setDescriptions(descriptions);
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
	* Returns the primary key of this phong ban.
	*
	* @return the primary key of this phong ban
	*/
	@Override
	public long getPrimaryKey() {
		return _phongBan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this phong ban.
	*
	* @param primaryKey the primary key of this phong ban
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_phongBan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this phong ban.
	*
	* @return the ID of this phong ban
	*/
	@Override
	public long getId() {
		return _phongBan.getId();
	}

	/**
	* Sets the ID of this phong ban.
	*
	* @param id the ID of this phong ban
	*/
	@Override
	public void setId(long id) {
		_phongBan.setId(id);
	}

	/**
	* Returns the name of this phong ban.
	*
	* @return the name of this phong ban
	*/
	@Override
	public java.lang.String getName() {
		return _phongBan.getName();
	}

	/**
	* Sets the name of this phong ban.
	*
	* @param name the name of this phong ban
	*/
	@Override
	public void setName(java.lang.String name) {
		_phongBan.setName(name);
	}

	/**
	* Returns the order_ of this phong ban.
	*
	* @return the order_ of this phong ban
	*/
	@Override
	public int getOrder_() {
		return _phongBan.getOrder_();
	}

	/**
	* Sets the order_ of this phong ban.
	*
	* @param order_ the order_ of this phong ban
	*/
	@Override
	public void setOrder_(int order_) {
		_phongBan.setOrder_(order_);
	}

	/**
	* Returns the descriptions of this phong ban.
	*
	* @return the descriptions of this phong ban
	*/
	@Override
	public java.lang.String getDescriptions() {
		return _phongBan.getDescriptions();
	}

	/**
	* Sets the descriptions of this phong ban.
	*
	* @param descriptions the descriptions of this phong ban
	*/
	@Override
	public void setDescriptions(java.lang.String descriptions) {
		_phongBan.setDescriptions(descriptions);
	}

	/**
	* Returns the status of this phong ban.
	*
	* @return the status of this phong ban
	*/
	@Override
	public boolean getStatus() {
		return _phongBan.getStatus();
	}

	/**
	* Returns <code>true</code> if this phong ban is status.
	*
	* @return <code>true</code> if this phong ban is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _phongBan.isStatus();
	}

	/**
	* Sets whether this phong ban is status.
	*
	* @param status the status of this phong ban
	*/
	@Override
	public void setStatus(boolean status) {
		_phongBan.setStatus(status);
	}

	/**
	* Returns the company ID of this phong ban.
	*
	* @return the company ID of this phong ban
	*/
	@Override
	public long getCompanyId() {
		return _phongBan.getCompanyId();
	}

	/**
	* Sets the company ID of this phong ban.
	*
	* @param companyId the company ID of this phong ban
	*/
	@Override
	public void setCompanyId(long companyId) {
		_phongBan.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this phong ban.
	*
	* @return the group ID of this phong ban
	*/
	@Override
	public long getGroupId() {
		return _phongBan.getGroupId();
	}

	/**
	* Sets the group ID of this phong ban.
	*
	* @param groupId the group ID of this phong ban
	*/
	@Override
	public void setGroupId(long groupId) {
		_phongBan.setGroupId(groupId);
	}

	/**
	* Returns the create date of this phong ban.
	*
	* @return the create date of this phong ban
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _phongBan.getCreateDate();
	}

	/**
	* Sets the create date of this phong ban.
	*
	* @param createDate the create date of this phong ban
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_phongBan.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this phong ban.
	*
	* @return the modify date of this phong ban
	*/
	@Override
	public java.util.Date getModifyDate() {
		return _phongBan.getModifyDate();
	}

	/**
	* Sets the modify date of this phong ban.
	*
	* @param modifyDate the modify date of this phong ban
	*/
	@Override
	public void setModifyDate(java.util.Date modifyDate) {
		_phongBan.setModifyDate(modifyDate);
	}

	/**
	* Returns the user name of this phong ban.
	*
	* @return the user name of this phong ban
	*/
	@Override
	public java.lang.String getUserName() {
		return _phongBan.getUserName();
	}

	/**
	* Sets the user name of this phong ban.
	*
	* @param userName the user name of this phong ban
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_phongBan.setUserName(userName);
	}

	/**
	* Returns the user ID of this phong ban.
	*
	* @return the user ID of this phong ban
	*/
	@Override
	public long getUserId() {
		return _phongBan.getUserId();
	}

	/**
	* Sets the user ID of this phong ban.
	*
	* @param userId the user ID of this phong ban
	*/
	@Override
	public void setUserId(long userId) {
		_phongBan.setUserId(userId);
	}

	/**
	* Returns the user uuid of this phong ban.
	*
	* @return the user uuid of this phong ban
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _phongBan.getUserUuid();
	}

	/**
	* Sets the user uuid of this phong ban.
	*
	* @param userUuid the user uuid of this phong ban
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_phongBan.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _phongBan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_phongBan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _phongBan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_phongBan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _phongBan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _phongBan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_phongBan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _phongBan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_phongBan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_phongBan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_phongBan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PhongBanWrapper((PhongBan)_phongBan.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.thongke.model.PhongBan phongBan) {
		return _phongBan.compareTo(phongBan);
	}

	@Override
	public int hashCode() {
		return _phongBan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.thongke.model.PhongBan> toCacheModel() {
		return _phongBan.toCacheModel();
	}

	@Override
	public com.viettel.portal.thongke.model.PhongBan toEscapedModel() {
		return new PhongBanWrapper(_phongBan.toEscapedModel());
	}

	@Override
	public com.viettel.portal.thongke.model.PhongBan toUnescapedModel() {
		return new PhongBanWrapper(_phongBan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _phongBan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _phongBan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_phongBan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhongBanWrapper)) {
			return false;
		}

		PhongBanWrapper phongBanWrapper = (PhongBanWrapper)obj;

		if (Validator.equals(_phongBan, phongBanWrapper._phongBan)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PhongBan getWrappedPhongBan() {
		return _phongBan;
	}

	@Override
	public PhongBan getWrappedModel() {
		return _phongBan;
	}

	@Override
	public void resetOriginalValues() {
		_phongBan.resetOriginalValues();
	}

	private PhongBan _phongBan;
}