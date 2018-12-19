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
 * This class is a wrapper for {@link ContentTypeCost}.
 * </p>
 *
 * @author lamvn
 * @see ContentTypeCost
 * @generated
 */
public class ContentTypeCostWrapper implements ContentTypeCost,
	ModelWrapper<ContentTypeCost> {
	public ContentTypeCostWrapper(ContentTypeCost contentTypeCost) {
		_contentTypeCost = contentTypeCost;
	}

	@Override
	public Class<?> getModelClass() {
		return ContentTypeCost.class;
	}

	@Override
	public String getModelClassName() {
		return ContentTypeCost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("costId", getCostId());
		attributes.put("groupId", getGroupId());
		attributes.put("contentTypeID", getContentTypeID());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("cost", getCost());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer costId = (Integer)attributes.get("costId");

		if (costId != null) {
			setCostId(costId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer contentTypeID = (Integer)attributes.get("contentTypeID");

		if (contentTypeID != null) {
			setContentTypeID(contentTypeID);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}
	}

	/**
	* Returns the primary key of this content type cost.
	*
	* @return the primary key of this content type cost
	*/
	@Override
	public int getPrimaryKey() {
		return _contentTypeCost.getPrimaryKey();
	}

	/**
	* Sets the primary key of this content type cost.
	*
	* @param primaryKey the primary key of this content type cost
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_contentTypeCost.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cost ID of this content type cost.
	*
	* @return the cost ID of this content type cost
	*/
	@Override
	public int getCostId() {
		return _contentTypeCost.getCostId();
	}

	/**
	* Sets the cost ID of this content type cost.
	*
	* @param costId the cost ID of this content type cost
	*/
	@Override
	public void setCostId(int costId) {
		_contentTypeCost.setCostId(costId);
	}

	/**
	* Returns the group ID of this content type cost.
	*
	* @return the group ID of this content type cost
	*/
	@Override
	public long getGroupId() {
		return _contentTypeCost.getGroupId();
	}

	/**
	* Sets the group ID of this content type cost.
	*
	* @param groupId the group ID of this content type cost
	*/
	@Override
	public void setGroupId(long groupId) {
		_contentTypeCost.setGroupId(groupId);
	}

	/**
	* Returns the content type i d of this content type cost.
	*
	* @return the content type i d of this content type cost
	*/
	@Override
	public int getContentTypeID() {
		return _contentTypeCost.getContentTypeID();
	}

	/**
	* Sets the content type i d of this content type cost.
	*
	* @param contentTypeID the content type i d of this content type cost
	*/
	@Override
	public void setContentTypeID(int contentTypeID) {
		_contentTypeCost.setContentTypeID(contentTypeID);
	}

	/**
	* Returns the from date of this content type cost.
	*
	* @return the from date of this content type cost
	*/
	@Override
	public java.util.Date getFromDate() {
		return _contentTypeCost.getFromDate();
	}

	/**
	* Sets the from date of this content type cost.
	*
	* @param fromDate the from date of this content type cost
	*/
	@Override
	public void setFromDate(java.util.Date fromDate) {
		_contentTypeCost.setFromDate(fromDate);
	}

	/**
	* Returns the to date of this content type cost.
	*
	* @return the to date of this content type cost
	*/
	@Override
	public java.util.Date getToDate() {
		return _contentTypeCost.getToDate();
	}

	/**
	* Sets the to date of this content type cost.
	*
	* @param toDate the to date of this content type cost
	*/
	@Override
	public void setToDate(java.util.Date toDate) {
		_contentTypeCost.setToDate(toDate);
	}

	/**
	* Returns the cost of this content type cost.
	*
	* @return the cost of this content type cost
	*/
	@Override
	public double getCost() {
		return _contentTypeCost.getCost();
	}

	/**
	* Sets the cost of this content type cost.
	*
	* @param cost the cost of this content type cost
	*/
	@Override
	public void setCost(double cost) {
		_contentTypeCost.setCost(cost);
	}

	@Override
	public boolean isNew() {
		return _contentTypeCost.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contentTypeCost.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contentTypeCost.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contentTypeCost.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contentTypeCost.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contentTypeCost.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contentTypeCost.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contentTypeCost.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contentTypeCost.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contentTypeCost.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contentTypeCost.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContentTypeCostWrapper((ContentTypeCost)_contentTypeCost.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.thongke.model.ContentTypeCost contentTypeCost) {
		return _contentTypeCost.compareTo(contentTypeCost);
	}

	@Override
	public int hashCode() {
		return _contentTypeCost.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.thongke.model.ContentTypeCost> toCacheModel() {
		return _contentTypeCost.toCacheModel();
	}

	@Override
	public com.viettel.portal.thongke.model.ContentTypeCost toEscapedModel() {
		return new ContentTypeCostWrapper(_contentTypeCost.toEscapedModel());
	}

	@Override
	public com.viettel.portal.thongke.model.ContentTypeCost toUnescapedModel() {
		return new ContentTypeCostWrapper(_contentTypeCost.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contentTypeCost.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contentTypeCost.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentTypeCost.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContentTypeCostWrapper)) {
			return false;
		}

		ContentTypeCostWrapper contentTypeCostWrapper = (ContentTypeCostWrapper)obj;

		if (Validator.equals(_contentTypeCost,
					contentTypeCostWrapper._contentTypeCost)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContentTypeCost getWrappedContentTypeCost() {
		return _contentTypeCost;
	}

	@Override
	public ContentTypeCost getWrappedModel() {
		return _contentTypeCost;
	}

	@Override
	public void resetOriginalValues() {
		_contentTypeCost.resetOriginalValues();
	}

	private ContentTypeCost _contentTypeCost;
}