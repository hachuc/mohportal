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

package com.liferay.viettel.portal.visitcounter.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VisitCounter}.
 * </p>
 *
 * @author hiepth6
 * @see VisitCounter
 * @generated
 */
public class VisitCounterWrapper implements VisitCounter,
	ModelWrapper<VisitCounter> {
	public VisitCounterWrapper(VisitCounter visitCounter) {
		_visitCounter = visitCounter;
	}

	@Override
	public Class<?> getModelClass() {
		return VisitCounter.class;
	}

	@Override
	public String getModelClassName() {
		return VisitCounter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("counterId", getCounterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("totalHitCounter", getTotalHitCounter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long counterId = (Long)attributes.get("counterId");

		if (counterId != null) {
			setCounterId(counterId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Integer totalHitCounter = (Integer)attributes.get("totalHitCounter");

		if (totalHitCounter != null) {
			setTotalHitCounter(totalHitCounter);
		}
	}

	/**
	* Returns the primary key of this visit counter.
	*
	* @return the primary key of this visit counter
	*/
	@Override
	public long getPrimaryKey() {
		return _visitCounter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this visit counter.
	*
	* @param primaryKey the primary key of this visit counter
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_visitCounter.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the counter ID of this visit counter.
	*
	* @return the counter ID of this visit counter
	*/
	@Override
	public long getCounterId() {
		return _visitCounter.getCounterId();
	}

	/**
	* Sets the counter ID of this visit counter.
	*
	* @param counterId the counter ID of this visit counter
	*/
	@Override
	public void setCounterId(long counterId) {
		_visitCounter.setCounterId(counterId);
	}

	/**
	* Returns the company ID of this visit counter.
	*
	* @return the company ID of this visit counter
	*/
	@Override
	public long getCompanyId() {
		return _visitCounter.getCompanyId();
	}

	/**
	* Sets the company ID of this visit counter.
	*
	* @param companyId the company ID of this visit counter
	*/
	@Override
	public void setCompanyId(long companyId) {
		_visitCounter.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this visit counter.
	*
	* @return the group ID of this visit counter
	*/
	@Override
	public long getGroupId() {
		return _visitCounter.getGroupId();
	}

	/**
	* Sets the group ID of this visit counter.
	*
	* @param groupId the group ID of this visit counter
	*/
	@Override
	public void setGroupId(long groupId) {
		_visitCounter.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this visit counter.
	*
	* @return the user ID of this visit counter
	*/
	@Override
	public long getUserId() {
		return _visitCounter.getUserId();
	}

	/**
	* Sets the user ID of this visit counter.
	*
	* @param userId the user ID of this visit counter
	*/
	@Override
	public void setUserId(long userId) {
		_visitCounter.setUserId(userId);
	}

	/**
	* Returns the user uuid of this visit counter.
	*
	* @return the user uuid of this visit counter
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounter.getUserUuid();
	}

	/**
	* Sets the user uuid of this visit counter.
	*
	* @param userUuid the user uuid of this visit counter
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_visitCounter.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this visit counter.
	*
	* @return the user name of this visit counter
	*/
	@Override
	public java.lang.String getUserName() {
		return _visitCounter.getUserName();
	}

	/**
	* Sets the user name of this visit counter.
	*
	* @param userName the user name of this visit counter
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_visitCounter.setUserName(userName);
	}

	/**
	* Returns the create date of this visit counter.
	*
	* @return the create date of this visit counter
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _visitCounter.getCreateDate();
	}

	/**
	* Sets the create date of this visit counter.
	*
	* @param createDate the create date of this visit counter
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_visitCounter.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this visit counter.
	*
	* @return the modified date of this visit counter
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _visitCounter.getModifiedDate();
	}

	/**
	* Sets the modified date of this visit counter.
	*
	* @param modifiedDate the modified date of this visit counter
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_visitCounter.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the total hit counter of this visit counter.
	*
	* @return the total hit counter of this visit counter
	*/
	@Override
	public int getTotalHitCounter() {
		return _visitCounter.getTotalHitCounter();
	}

	/**
	* Sets the total hit counter of this visit counter.
	*
	* @param totalHitCounter the total hit counter of this visit counter
	*/
	@Override
	public void setTotalHitCounter(int totalHitCounter) {
		_visitCounter.setTotalHitCounter(totalHitCounter);
	}

	@Override
	public boolean isNew() {
		return _visitCounter.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_visitCounter.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _visitCounter.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_visitCounter.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _visitCounter.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _visitCounter.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_visitCounter.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _visitCounter.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_visitCounter.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_visitCounter.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_visitCounter.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VisitCounterWrapper((VisitCounter)_visitCounter.clone());
	}

	@Override
	public int compareTo(
		com.liferay.viettel.portal.visitcounter.model.VisitCounter visitCounter) {
		return _visitCounter.compareTo(visitCounter);
	}

	@Override
	public int hashCode() {
		return _visitCounter.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.viettel.portal.visitcounter.model.VisitCounter> toCacheModel() {
		return _visitCounter.toCacheModel();
	}

	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter toEscapedModel() {
		return new VisitCounterWrapper(_visitCounter.toEscapedModel());
	}

	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter toUnescapedModel() {
		return new VisitCounterWrapper(_visitCounter.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _visitCounter.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _visitCounter.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounter.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VisitCounterWrapper)) {
			return false;
		}

		VisitCounterWrapper visitCounterWrapper = (VisitCounterWrapper)obj;

		if (Validator.equals(_visitCounter, visitCounterWrapper._visitCounter)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VisitCounter getWrappedVisitCounter() {
		return _visitCounter;
	}

	@Override
	public VisitCounter getWrappedModel() {
		return _visitCounter;
	}

	@Override
	public void resetOriginalValues() {
		_visitCounter.resetOriginalValues();
	}

	private VisitCounter _visitCounter;
}