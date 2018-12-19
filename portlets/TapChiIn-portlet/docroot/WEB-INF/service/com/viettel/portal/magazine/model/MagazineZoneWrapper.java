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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MagazineZone}.
 * </p>
 *
 * @author namtv
 * @see MagazineZone
 * @generated
 */
public class MagazineZoneWrapper implements MagazineZone,
	ModelWrapper<MagazineZone> {
	public MagazineZoneWrapper(MagazineZone magazineZone) {
		_magazineZone = magazineZone;
	}

	@Override
	public Class<?> getModelClass() {
		return MagazineZone.class;
	}

	@Override
	public String getModelClassName() {
		return MagazineZone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Name", getName());
		attributes.put("MagazineID", getMagazineID());
		attributes.put("SortOrder", getSortOrder());

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

		Integer MagazineID = (Integer)attributes.get("MagazineID");

		if (MagazineID != null) {
			setMagazineID(MagazineID);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}
	}

	/**
	* Returns the primary key of this magazine zone.
	*
	* @return the primary key of this magazine zone
	*/
	@Override
	public int getPrimaryKey() {
		return _magazineZone.getPrimaryKey();
	}

	/**
	* Sets the primary key of this magazine zone.
	*
	* @param primaryKey the primary key of this magazine zone
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_magazineZone.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this magazine zone.
	*
	* @return the i d of this magazine zone
	*/
	@Override
	public int getID() {
		return _magazineZone.getID();
	}

	/**
	* Sets the i d of this magazine zone.
	*
	* @param ID the i d of this magazine zone
	*/
	@Override
	public void setID(int ID) {
		_magazineZone.setID(ID);
	}

	/**
	* Returns the name of this magazine zone.
	*
	* @return the name of this magazine zone
	*/
	@Override
	public java.lang.String getName() {
		return _magazineZone.getName();
	}

	/**
	* Sets the name of this magazine zone.
	*
	* @param Name the name of this magazine zone
	*/
	@Override
	public void setName(java.lang.String Name) {
		_magazineZone.setName(Name);
	}

	/**
	* Returns the magazine i d of this magazine zone.
	*
	* @return the magazine i d of this magazine zone
	*/
	@Override
	public int getMagazineID() {
		return _magazineZone.getMagazineID();
	}

	/**
	* Sets the magazine i d of this magazine zone.
	*
	* @param MagazineID the magazine i d of this magazine zone
	*/
	@Override
	public void setMagazineID(int MagazineID) {
		_magazineZone.setMagazineID(MagazineID);
	}

	/**
	* Returns the sort order of this magazine zone.
	*
	* @return the sort order of this magazine zone
	*/
	@Override
	public int getSortOrder() {
		return _magazineZone.getSortOrder();
	}

	/**
	* Sets the sort order of this magazine zone.
	*
	* @param SortOrder the sort order of this magazine zone
	*/
	@Override
	public void setSortOrder(int SortOrder) {
		_magazineZone.setSortOrder(SortOrder);
	}

	@Override
	public boolean isNew() {
		return _magazineZone.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_magazineZone.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _magazineZone.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_magazineZone.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _magazineZone.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _magazineZone.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_magazineZone.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _magazineZone.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_magazineZone.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_magazineZone.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_magazineZone.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MagazineZoneWrapper((MagazineZone)_magazineZone.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.magazine.model.MagazineZone magazineZone) {
		return _magazineZone.compareTo(magazineZone);
	}

	@Override
	public int hashCode() {
		return _magazineZone.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.magazine.model.MagazineZone> toCacheModel() {
		return _magazineZone.toCacheModel();
	}

	@Override
	public com.viettel.portal.magazine.model.MagazineZone toEscapedModel() {
		return new MagazineZoneWrapper(_magazineZone.toEscapedModel());
	}

	@Override
	public com.viettel.portal.magazine.model.MagazineZone toUnescapedModel() {
		return new MagazineZoneWrapper(_magazineZone.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _magazineZone.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _magazineZone.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_magazineZone.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MagazineZoneWrapper)) {
			return false;
		}

		MagazineZoneWrapper magazineZoneWrapper = (MagazineZoneWrapper)obj;

		if (Validator.equals(_magazineZone, magazineZoneWrapper._magazineZone)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MagazineZone getWrappedMagazineZone() {
		return _magazineZone;
	}

	@Override
	public MagazineZone getWrappedModel() {
		return _magazineZone;
	}

	@Override
	public void resetOriginalValues() {
		_magazineZone.resetOriginalValues();
	}

	private MagazineZone _magazineZone;
}