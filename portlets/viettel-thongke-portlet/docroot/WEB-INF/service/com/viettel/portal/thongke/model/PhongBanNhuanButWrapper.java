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
 * This class is a wrapper for {@link PhongBanNhuanBut}.
 * </p>
 *
 * @author lamvn
 * @see PhongBanNhuanBut
 * @generated
 */
public class PhongBanNhuanButWrapper implements PhongBanNhuanBut,
	ModelWrapper<PhongBanNhuanBut> {
	public PhongBanNhuanButWrapper(PhongBanNhuanBut phongBanNhuanBut) {
		_phongBanNhuanBut = phongBanNhuanBut;
	}

	@Override
	public Class<?> getModelClass() {
		return PhongBanNhuanBut.class;
	}

	@Override
	public String getModelClassName() {
		return PhongBanNhuanBut.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("caption", getCaption());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
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

		String caption = (String)attributes.get("caption");

		if (caption != null) {
			setCaption(caption);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
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
	* Returns the primary key of this phong ban nhuan but.
	*
	* @return the primary key of this phong ban nhuan but
	*/
	@Override
	public long getPrimaryKey() {
		return _phongBanNhuanBut.getPrimaryKey();
	}

	/**
	* Sets the primary key of this phong ban nhuan but.
	*
	* @param primaryKey the primary key of this phong ban nhuan but
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_phongBanNhuanBut.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this phong ban nhuan but.
	*
	* @return the ID of this phong ban nhuan but
	*/
	@Override
	public long getId() {
		return _phongBanNhuanBut.getId();
	}

	/**
	* Sets the ID of this phong ban nhuan but.
	*
	* @param id the ID of this phong ban nhuan but
	*/
	@Override
	public void setId(long id) {
		_phongBanNhuanBut.setId(id);
	}

	/**
	* Returns the caption of this phong ban nhuan but.
	*
	* @return the caption of this phong ban nhuan but
	*/
	@Override
	public java.lang.String getCaption() {
		return _phongBanNhuanBut.getCaption();
	}

	/**
	* Sets the caption of this phong ban nhuan but.
	*
	* @param caption the caption of this phong ban nhuan but
	*/
	@Override
	public void setCaption(java.lang.String caption) {
		_phongBanNhuanBut.setCaption(caption);
	}

	/**
	* Returns the from date of this phong ban nhuan but.
	*
	* @return the from date of this phong ban nhuan but
	*/
	@Override
	public java.util.Date getFromDate() {
		return _phongBanNhuanBut.getFromDate();
	}

	/**
	* Sets the from date of this phong ban nhuan but.
	*
	* @param fromDate the from date of this phong ban nhuan but
	*/
	@Override
	public void setFromDate(java.util.Date fromDate) {
		_phongBanNhuanBut.setFromDate(fromDate);
	}

	/**
	* Returns the to date of this phong ban nhuan but.
	*
	* @return the to date of this phong ban nhuan but
	*/
	@Override
	public java.util.Date getToDate() {
		return _phongBanNhuanBut.getToDate();
	}

	/**
	* Sets the to date of this phong ban nhuan but.
	*
	* @param toDate the to date of this phong ban nhuan but
	*/
	@Override
	public void setToDate(java.util.Date toDate) {
		_phongBanNhuanBut.setToDate(toDate);
	}

	/**
	* Returns the status of this phong ban nhuan but.
	*
	* @return the status of this phong ban nhuan but
	*/
	@Override
	public boolean getStatus() {
		return _phongBanNhuanBut.getStatus();
	}

	/**
	* Returns <code>true</code> if this phong ban nhuan but is status.
	*
	* @return <code>true</code> if this phong ban nhuan but is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _phongBanNhuanBut.isStatus();
	}

	/**
	* Sets whether this phong ban nhuan but is status.
	*
	* @param status the status of this phong ban nhuan but
	*/
	@Override
	public void setStatus(boolean status) {
		_phongBanNhuanBut.setStatus(status);
	}

	/**
	* Returns the company ID of this phong ban nhuan but.
	*
	* @return the company ID of this phong ban nhuan but
	*/
	@Override
	public long getCompanyId() {
		return _phongBanNhuanBut.getCompanyId();
	}

	/**
	* Sets the company ID of this phong ban nhuan but.
	*
	* @param companyId the company ID of this phong ban nhuan but
	*/
	@Override
	public void setCompanyId(long companyId) {
		_phongBanNhuanBut.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this phong ban nhuan but.
	*
	* @return the group ID of this phong ban nhuan but
	*/
	@Override
	public long getGroupId() {
		return _phongBanNhuanBut.getGroupId();
	}

	/**
	* Sets the group ID of this phong ban nhuan but.
	*
	* @param groupId the group ID of this phong ban nhuan but
	*/
	@Override
	public void setGroupId(long groupId) {
		_phongBanNhuanBut.setGroupId(groupId);
	}

	/**
	* Returns the create date of this phong ban nhuan but.
	*
	* @return the create date of this phong ban nhuan but
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _phongBanNhuanBut.getCreateDate();
	}

	/**
	* Sets the create date of this phong ban nhuan but.
	*
	* @param createDate the create date of this phong ban nhuan but
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_phongBanNhuanBut.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this phong ban nhuan but.
	*
	* @return the modify date of this phong ban nhuan but
	*/
	@Override
	public java.util.Date getModifyDate() {
		return _phongBanNhuanBut.getModifyDate();
	}

	/**
	* Sets the modify date of this phong ban nhuan but.
	*
	* @param modifyDate the modify date of this phong ban nhuan but
	*/
	@Override
	public void setModifyDate(java.util.Date modifyDate) {
		_phongBanNhuanBut.setModifyDate(modifyDate);
	}

	/**
	* Returns the user name of this phong ban nhuan but.
	*
	* @return the user name of this phong ban nhuan but
	*/
	@Override
	public java.lang.String getUserName() {
		return _phongBanNhuanBut.getUserName();
	}

	/**
	* Sets the user name of this phong ban nhuan but.
	*
	* @param userName the user name of this phong ban nhuan but
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_phongBanNhuanBut.setUserName(userName);
	}

	/**
	* Returns the user ID of this phong ban nhuan but.
	*
	* @return the user ID of this phong ban nhuan but
	*/
	@Override
	public long getUserId() {
		return _phongBanNhuanBut.getUserId();
	}

	/**
	* Sets the user ID of this phong ban nhuan but.
	*
	* @param userId the user ID of this phong ban nhuan but
	*/
	@Override
	public void setUserId(long userId) {
		_phongBanNhuanBut.setUserId(userId);
	}

	/**
	* Returns the user uuid of this phong ban nhuan but.
	*
	* @return the user uuid of this phong ban nhuan but
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _phongBanNhuanBut.getUserUuid();
	}

	/**
	* Sets the user uuid of this phong ban nhuan but.
	*
	* @param userUuid the user uuid of this phong ban nhuan but
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_phongBanNhuanBut.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _phongBanNhuanBut.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_phongBanNhuanBut.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _phongBanNhuanBut.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_phongBanNhuanBut.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _phongBanNhuanBut.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _phongBanNhuanBut.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_phongBanNhuanBut.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _phongBanNhuanBut.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_phongBanNhuanBut.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_phongBanNhuanBut.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_phongBanNhuanBut.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PhongBanNhuanButWrapper((PhongBanNhuanBut)_phongBanNhuanBut.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut) {
		return _phongBanNhuanBut.compareTo(phongBanNhuanBut);
	}

	@Override
	public int hashCode() {
		return _phongBanNhuanBut.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.thongke.model.PhongBanNhuanBut> toCacheModel() {
		return _phongBanNhuanBut.toCacheModel();
	}

	@Override
	public com.viettel.portal.thongke.model.PhongBanNhuanBut toEscapedModel() {
		return new PhongBanNhuanButWrapper(_phongBanNhuanBut.toEscapedModel());
	}

	@Override
	public com.viettel.portal.thongke.model.PhongBanNhuanBut toUnescapedModel() {
		return new PhongBanNhuanButWrapper(_phongBanNhuanBut.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _phongBanNhuanBut.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _phongBanNhuanBut.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_phongBanNhuanBut.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhongBanNhuanButWrapper)) {
			return false;
		}

		PhongBanNhuanButWrapper phongBanNhuanButWrapper = (PhongBanNhuanButWrapper)obj;

		if (Validator.equals(_phongBanNhuanBut,
					phongBanNhuanButWrapper._phongBanNhuanBut)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PhongBanNhuanBut getWrappedPhongBanNhuanBut() {
		return _phongBanNhuanBut;
	}

	@Override
	public PhongBanNhuanBut getWrappedModel() {
		return _phongBanNhuanBut;
	}

	@Override
	public void resetOriginalValues() {
		_phongBanNhuanBut.resetOriginalValues();
	}

	private PhongBanNhuanBut _phongBanNhuanBut;
}