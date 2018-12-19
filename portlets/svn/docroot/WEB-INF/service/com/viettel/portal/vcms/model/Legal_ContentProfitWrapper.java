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
 * This class is a wrapper for {@link Legal_ContentProfit}.
 * </p>
 *
 * @author chuchv
 * @see Legal_ContentProfit
 * @generated
 */
public class Legal_ContentProfitWrapper implements Legal_ContentProfit,
	ModelWrapper<Legal_ContentProfit> {
	public Legal_ContentProfitWrapper(Legal_ContentProfit legal_ContentProfit) {
		_legal_ContentProfit = legal_ContentProfit;
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_ContentProfit.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_ContentProfit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ContentID", getContentID());
		attributes.put("ContentTypeID", getContentTypeID());
		attributes.put("Headline", getHeadline());
		attributes.put("Cost", getCost());
		attributes.put("Author", getAuthor());
		attributes.put("Status", getStatus());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("DistributedDate", getDistributedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ContentID = (Integer)attributes.get("ContentID");

		if (ContentID != null) {
			setContentID(ContentID);
		}

		Integer ContentTypeID = (Integer)attributes.get("ContentTypeID");

		if (ContentTypeID != null) {
			setContentTypeID(ContentTypeID);
		}

		String Headline = (String)attributes.get("Headline");

		if (Headline != null) {
			setHeadline(Headline);
		}

		Double Cost = (Double)attributes.get("Cost");

		if (Cost != null) {
			setCost(Cost);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		Date DistributedDate = (Date)attributes.get("DistributedDate");

		if (DistributedDate != null) {
			setDistributedDate(DistributedDate);
		}
	}

	/**
	* Returns the primary key of this legal_ content profit.
	*
	* @return the primary key of this legal_ content profit
	*/
	@Override
	public int getPrimaryKey() {
		return _legal_ContentProfit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legal_ content profit.
	*
	* @param primaryKey the primary key of this legal_ content profit
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legal_ContentProfit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content i d of this legal_ content profit.
	*
	* @return the content i d of this legal_ content profit
	*/
	@Override
	public int getContentID() {
		return _legal_ContentProfit.getContentID();
	}

	/**
	* Sets the content i d of this legal_ content profit.
	*
	* @param ContentID the content i d of this legal_ content profit
	*/
	@Override
	public void setContentID(int ContentID) {
		_legal_ContentProfit.setContentID(ContentID);
	}

	/**
	* Returns the content type i d of this legal_ content profit.
	*
	* @return the content type i d of this legal_ content profit
	*/
	@Override
	public int getContentTypeID() {
		return _legal_ContentProfit.getContentTypeID();
	}

	/**
	* Sets the content type i d of this legal_ content profit.
	*
	* @param ContentTypeID the content type i d of this legal_ content profit
	*/
	@Override
	public void setContentTypeID(int ContentTypeID) {
		_legal_ContentProfit.setContentTypeID(ContentTypeID);
	}

	/**
	* Returns the headline of this legal_ content profit.
	*
	* @return the headline of this legal_ content profit
	*/
	@Override
	public java.lang.String getHeadline() {
		return _legal_ContentProfit.getHeadline();
	}

	/**
	* Sets the headline of this legal_ content profit.
	*
	* @param Headline the headline of this legal_ content profit
	*/
	@Override
	public void setHeadline(java.lang.String Headline) {
		_legal_ContentProfit.setHeadline(Headline);
	}

	/**
	* Returns the cost of this legal_ content profit.
	*
	* @return the cost of this legal_ content profit
	*/
	@Override
	public double getCost() {
		return _legal_ContentProfit.getCost();
	}

	/**
	* Sets the cost of this legal_ content profit.
	*
	* @param Cost the cost of this legal_ content profit
	*/
	@Override
	public void setCost(double Cost) {
		_legal_ContentProfit.setCost(Cost);
	}

	/**
	* Returns the author of this legal_ content profit.
	*
	* @return the author of this legal_ content profit
	*/
	@Override
	public java.lang.String getAuthor() {
		return _legal_ContentProfit.getAuthor();
	}

	/**
	* Sets the author of this legal_ content profit.
	*
	* @param Author the author of this legal_ content profit
	*/
	@Override
	public void setAuthor(java.lang.String Author) {
		_legal_ContentProfit.setAuthor(Author);
	}

	/**
	* Returns the status of this legal_ content profit.
	*
	* @return the status of this legal_ content profit
	*/
	@Override
	public int getStatus() {
		return _legal_ContentProfit.getStatus();
	}

	/**
	* Sets the status of this legal_ content profit.
	*
	* @param Status the status of this legal_ content profit
	*/
	@Override
	public void setStatus(int Status) {
		_legal_ContentProfit.setStatus(Status);
	}

	/**
	* Returns the creation date of this legal_ content profit.
	*
	* @return the creation date of this legal_ content profit
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _legal_ContentProfit.getCreationDate();
	}

	/**
	* Sets the creation date of this legal_ content profit.
	*
	* @param CreationDate the creation date of this legal_ content profit
	*/
	@Override
	public void setCreationDate(java.util.Date CreationDate) {
		_legal_ContentProfit.setCreationDate(CreationDate);
	}

	/**
	* Returns the modified date of this legal_ content profit.
	*
	* @return the modified date of this legal_ content profit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legal_ContentProfit.getModifiedDate();
	}

	/**
	* Sets the modified date of this legal_ content profit.
	*
	* @param ModifiedDate the modified date of this legal_ content profit
	*/
	@Override
	public void setModifiedDate(java.util.Date ModifiedDate) {
		_legal_ContentProfit.setModifiedDate(ModifiedDate);
	}

	/**
	* Returns the distributed date of this legal_ content profit.
	*
	* @return the distributed date of this legal_ content profit
	*/
	@Override
	public java.util.Date getDistributedDate() {
		return _legal_ContentProfit.getDistributedDate();
	}

	/**
	* Sets the distributed date of this legal_ content profit.
	*
	* @param DistributedDate the distributed date of this legal_ content profit
	*/
	@Override
	public void setDistributedDate(java.util.Date DistributedDate) {
		_legal_ContentProfit.setDistributedDate(DistributedDate);
	}

	@Override
	public boolean isNew() {
		return _legal_ContentProfit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legal_ContentProfit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legal_ContentProfit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legal_ContentProfit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legal_ContentProfit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legal_ContentProfit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legal_ContentProfit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legal_ContentProfit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legal_ContentProfit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legal_ContentProfit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legal_ContentProfit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Legal_ContentProfitWrapper((Legal_ContentProfit)_legal_ContentProfit.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vcms.model.Legal_ContentProfit legal_ContentProfit) {
		return _legal_ContentProfit.compareTo(legal_ContentProfit);
	}

	@Override
	public int hashCode() {
		return _legal_ContentProfit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Legal_ContentProfit> toCacheModel() {
		return _legal_ContentProfit.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_ContentProfit toEscapedModel() {
		return new Legal_ContentProfitWrapper(_legal_ContentProfit.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_ContentProfit toUnescapedModel() {
		return new Legal_ContentProfitWrapper(_legal_ContentProfit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legal_ContentProfit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legal_ContentProfit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legal_ContentProfit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Legal_ContentProfitWrapper)) {
			return false;
		}

		Legal_ContentProfitWrapper legal_ContentProfitWrapper = (Legal_ContentProfitWrapper)obj;

		if (Validator.equals(_legal_ContentProfit,
					legal_ContentProfitWrapper._legal_ContentProfit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Legal_ContentProfit getWrappedLegal_ContentProfit() {
		return _legal_ContentProfit;
	}

	@Override
	public Legal_ContentProfit getWrappedModel() {
		return _legal_ContentProfit;
	}

	@Override
	public void resetOriginalValues() {
		_legal_ContentProfit.resetOriginalValues();
	}

	private Legal_ContentProfit _legal_ContentProfit;
}