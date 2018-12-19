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
 * This class is a wrapper for {@link DistributionVisisted}.
 * </p>
 *
 * @author chuchv
 * @see DistributionVisisted
 * @generated
 */
public class DistributionVisistedWrapper implements DistributionVisisted,
	ModelWrapper<DistributionVisisted> {
	public DistributionVisistedWrapper(
		DistributionVisisted distributionVisisted) {
		_distributionVisisted = distributionVisisted;
	}

	@Override
	public Class<?> getModelClass() {
		return DistributionVisisted.class;
	}

	@Override
	public String getModelClassName() {
		return DistributionVisisted.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("visistedId", getVisistedId());
		attributes.put("distributionId", getDistributionId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long visistedId = (Long)attributes.get("visistedId");

		if (visistedId != null) {
			setVisistedId(visistedId);
		}

		Long distributionId = (Long)attributes.get("distributionId");

		if (distributionId != null) {
			setDistributionId(distributionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this distribution visisted.
	*
	* @return the primary key of this distribution visisted
	*/
	@Override
	public long getPrimaryKey() {
		return _distributionVisisted.getPrimaryKey();
	}

	/**
	* Sets the primary key of this distribution visisted.
	*
	* @param primaryKey the primary key of this distribution visisted
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_distributionVisisted.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the visisted ID of this distribution visisted.
	*
	* @return the visisted ID of this distribution visisted
	*/
	@Override
	public long getVisistedId() {
		return _distributionVisisted.getVisistedId();
	}

	/**
	* Sets the visisted ID of this distribution visisted.
	*
	* @param visistedId the visisted ID of this distribution visisted
	*/
	@Override
	public void setVisistedId(long visistedId) {
		_distributionVisisted.setVisistedId(visistedId);
	}

	/**
	* Returns the distribution ID of this distribution visisted.
	*
	* @return the distribution ID of this distribution visisted
	*/
	@Override
	public long getDistributionId() {
		return _distributionVisisted.getDistributionId();
	}

	/**
	* Sets the distribution ID of this distribution visisted.
	*
	* @param distributionId the distribution ID of this distribution visisted
	*/
	@Override
	public void setDistributionId(long distributionId) {
		_distributionVisisted.setDistributionId(distributionId);
	}

	/**
	* Returns the group ID of this distribution visisted.
	*
	* @return the group ID of this distribution visisted
	*/
	@Override
	public long getGroupId() {
		return _distributionVisisted.getGroupId();
	}

	/**
	* Sets the group ID of this distribution visisted.
	*
	* @param groupId the group ID of this distribution visisted
	*/
	@Override
	public void setGroupId(long groupId) {
		_distributionVisisted.setGroupId(groupId);
	}

	/**
	* Returns the create date of this distribution visisted.
	*
	* @return the create date of this distribution visisted
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _distributionVisisted.getCreateDate();
	}

	/**
	* Sets the create date of this distribution visisted.
	*
	* @param createDate the create date of this distribution visisted
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_distributionVisisted.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _distributionVisisted.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_distributionVisisted.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _distributionVisisted.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_distributionVisisted.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _distributionVisisted.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _distributionVisisted.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_distributionVisisted.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _distributionVisisted.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_distributionVisisted.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_distributionVisisted.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_distributionVisisted.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DistributionVisistedWrapper((DistributionVisisted)_distributionVisisted.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted) {
		return _distributionVisisted.compareTo(distributionVisisted);
	}

	@Override
	public int hashCode() {
		return _distributionVisisted.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.DistributionVisisted> toCacheModel() {
		return _distributionVisisted.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted toEscapedModel() {
		return new DistributionVisistedWrapper(_distributionVisisted.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted toUnescapedModel() {
		return new DistributionVisistedWrapper(_distributionVisisted.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _distributionVisisted.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _distributionVisisted.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_distributionVisisted.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DistributionVisistedWrapper)) {
			return false;
		}

		DistributionVisistedWrapper distributionVisistedWrapper = (DistributionVisistedWrapper)obj;

		if (Validator.equals(_distributionVisisted,
					distributionVisistedWrapper._distributionVisisted)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DistributionVisisted getWrappedDistributionVisisted() {
		return _distributionVisisted;
	}

	@Override
	public DistributionVisisted getWrappedModel() {
		return _distributionVisisted;
	}

	@Override
	public void resetOriginalValues() {
		_distributionVisisted.resetOriginalValues();
	}

	private DistributionVisisted _distributionVisisted;
}