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

package com.viettel.portal.magazine.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Magazine}.
 * </p>
 *
 * @author namtv
 * @see Magazine
 * @generated
 */
public class MagazineWrapper implements Magazine, ModelWrapper<Magazine> {
	public MagazineWrapper(Magazine magazine) {
		_magazine = magazine;
	}

	@Override
	public Class<?> getModelClass() {
		return Magazine.class;
	}

	@Override
	public String getModelClassName() {
		return Magazine.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Name", getName());
		attributes.put("PublishNumber", getPublishNumber());
		attributes.put("PublishYear", getPublishYear());
		attributes.put("ImageUrl", getImageUrl());
		attributes.put("ImageID", getImageID());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("DistributedDate", getDistributedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		Integer PublishNumber = (Integer)attributes.get("PublishNumber");

		if (PublishNumber != null) {
			setPublishNumber(PublishNumber);
		}

		Integer PublishYear = (Integer)attributes.get("PublishYear");

		if (PublishYear != null) {
			setPublishYear(PublishYear);
		}

		String ImageUrl = (String)attributes.get("ImageUrl");

		if (ImageUrl != null) {
			setImageUrl(ImageUrl);
		}

		Long ImageID = (Long)attributes.get("ImageID");

		if (ImageID != null) {
			setImageID(ImageID);
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
	* Returns the primary key of this magazine.
	*
	* @return the primary key of this magazine
	*/
	@Override
	public int getPrimaryKey() {
		return _magazine.getPrimaryKey();
	}

	/**
	* Sets the primary key of this magazine.
	*
	* @param primaryKey the primary key of this magazine
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_magazine.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this magazine.
	*
	* @return the i d of this magazine
	*/
	@Override
	public int getID() {
		return _magazine.getID();
	}

	/**
	* Sets the i d of this magazine.
	*
	* @param ID the i d of this magazine
	*/
	@Override
	public void setID(int ID) {
		_magazine.setID(ID);
	}

	/**
	* Returns the name of this magazine.
	*
	* @return the name of this magazine
	*/
	@Override
	public java.lang.String getName() {
		return _magazine.getName();
	}

	/**
	* Sets the name of this magazine.
	*
	* @param Name the name of this magazine
	*/
	@Override
	public void setName(java.lang.String Name) {
		_magazine.setName(Name);
	}

	/**
	* Returns the publish number of this magazine.
	*
	* @return the publish number of this magazine
	*/
	@Override
	public int getPublishNumber() {
		return _magazine.getPublishNumber();
	}

	/**
	* Sets the publish number of this magazine.
	*
	* @param PublishNumber the publish number of this magazine
	*/
	@Override
	public void setPublishNumber(int PublishNumber) {
		_magazine.setPublishNumber(PublishNumber);
	}

	/**
	* Returns the publish year of this magazine.
	*
	* @return the publish year of this magazine
	*/
	@Override
	public int getPublishYear() {
		return _magazine.getPublishYear();
	}

	/**
	* Sets the publish year of this magazine.
	*
	* @param PublishYear the publish year of this magazine
	*/
	@Override
	public void setPublishYear(int PublishYear) {
		_magazine.setPublishYear(PublishYear);
	}

	/**
	* Returns the image url of this magazine.
	*
	* @return the image url of this magazine
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _magazine.getImageUrl();
	}

	/**
	* Sets the image url of this magazine.
	*
	* @param ImageUrl the image url of this magazine
	*/
	@Override
	public void setImageUrl(java.lang.String ImageUrl) {
		_magazine.setImageUrl(ImageUrl);
	}

	/**
	* Returns the image i d of this magazine.
	*
	* @return the image i d of this magazine
	*/
	@Override
	public long getImageID() {
		return _magazine.getImageID();
	}

	/**
	* Sets the image i d of this magazine.
	*
	* @param ImageID the image i d of this magazine
	*/
	@Override
	public void setImageID(long ImageID) {
		_magazine.setImageID(ImageID);
	}

	/**
	* Returns the creation date of this magazine.
	*
	* @return the creation date of this magazine
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _magazine.getCreationDate();
	}

	/**
	* Sets the creation date of this magazine.
	*
	* @param CreationDate the creation date of this magazine
	*/
	@Override
	public void setCreationDate(java.util.Date CreationDate) {
		_magazine.setCreationDate(CreationDate);
	}

	/**
	* Returns the modified date of this magazine.
	*
	* @return the modified date of this magazine
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _magazine.getModifiedDate();
	}

	/**
	* Sets the modified date of this magazine.
	*
	* @param ModifiedDate the modified date of this magazine
	*/
	@Override
	public void setModifiedDate(java.util.Date ModifiedDate) {
		_magazine.setModifiedDate(ModifiedDate);
	}

	/**
	* Returns the distributed date of this magazine.
	*
	* @return the distributed date of this magazine
	*/
	@Override
	public java.util.Date getDistributedDate() {
		return _magazine.getDistributedDate();
	}

	/**
	* Sets the distributed date of this magazine.
	*
	* @param DistributedDate the distributed date of this magazine
	*/
	@Override
	public void setDistributedDate(java.util.Date DistributedDate) {
		_magazine.setDistributedDate(DistributedDate);
	}

	@Override
	public boolean isNew() {
		return _magazine.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_magazine.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _magazine.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_magazine.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _magazine.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _magazine.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_magazine.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _magazine.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_magazine.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_magazine.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_magazine.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MagazineWrapper((Magazine)_magazine.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.magazine.model.Magazine magazine) {
		return _magazine.compareTo(magazine);
	}

	@Override
	public int hashCode() {
		return _magazine.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.magazine.model.Magazine> toCacheModel() {
		return _magazine.toCacheModel();
	}

	@Override
	public com.viettel.portal.magazine.model.Magazine toEscapedModel() {
		return new MagazineWrapper(_magazine.toEscapedModel());
	}

	@Override
	public com.viettel.portal.magazine.model.Magazine toUnescapedModel() {
		return new MagazineWrapper(_magazine.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _magazine.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _magazine.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_magazine.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MagazineWrapper)) {
			return false;
		}

		MagazineWrapper magazineWrapper = (MagazineWrapper)obj;

		if (Validator.equals(_magazine, magazineWrapper._magazine)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Magazine getWrappedMagazine() {
		return _magazine;
	}

	@Override
	public Magazine getWrappedModel() {
		return _magazine;
	}

	@Override
	public void resetOriginalValues() {
		_magazine.resetOriginalValues();
	}

	private Magazine _magazine;
}