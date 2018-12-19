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
 * This class is a wrapper for {@link Legal_Zone}.
 * </p>
 *
 * @author chuchv
 * @see Legal_Zone
 * @generated
 */
public class Legal_ZoneWrapper implements Legal_Zone, ModelWrapper<Legal_Zone> {
	public Legal_ZoneWrapper(Legal_Zone legal_Zone) {
		_legal_Zone = legal_Zone;
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_Zone.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_Zone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("Name", getName());
		attributes.put("Url", getUrl());
		attributes.put("Description", getDescription());
		attributes.put("ParentID", getParentID());
		attributes.put("RealUrl", getRealUrl());
		attributes.put("Visible", getVisible());
		attributes.put("Archived", getArchived());
		attributes.put("SortOrder", getSortOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		String Url = (String)attributes.get("Url");

		if (Url != null) {
			setUrl(Url);
		}

		String Description = (String)attributes.get("Description");

		if (Description != null) {
			setDescription(Description);
		}

		Integer ParentID = (Integer)attributes.get("ParentID");

		if (ParentID != null) {
			setParentID(ParentID);
		}

		String RealUrl = (String)attributes.get("RealUrl");

		if (RealUrl != null) {
			setRealUrl(RealUrl);
		}

		Boolean Visible = (Boolean)attributes.get("Visible");

		if (Visible != null) {
			setVisible(Visible);
		}

		Boolean Archived = (Boolean)attributes.get("Archived");

		if (Archived != null) {
			setArchived(Archived);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}
	}

	/**
	* Returns the primary key of this legal_ zone.
	*
	* @return the primary key of this legal_ zone
	*/
	@Override
	public int getPrimaryKey() {
		return _legal_Zone.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legal_ zone.
	*
	* @param primaryKey the primary key of this legal_ zone
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legal_Zone.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this legal_ zone.
	*
	* @return the i d of this legal_ zone
	*/
	@Override
	public int getID() {
		return _legal_Zone.getID();
	}

	/**
	* Sets the i d of this legal_ zone.
	*
	* @param ID the i d of this legal_ zone
	*/
	@Override
	public void setID(int ID) {
		_legal_Zone.setID(ID);
	}

	/**
	* Returns the creation date of this legal_ zone.
	*
	* @return the creation date of this legal_ zone
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _legal_Zone.getCreationDate();
	}

	/**
	* Sets the creation date of this legal_ zone.
	*
	* @param CreationDate the creation date of this legal_ zone
	*/
	@Override
	public void setCreationDate(java.util.Date CreationDate) {
		_legal_Zone.setCreationDate(CreationDate);
	}

	/**
	* Returns the modified date of this legal_ zone.
	*
	* @return the modified date of this legal_ zone
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legal_Zone.getModifiedDate();
	}

	/**
	* Sets the modified date of this legal_ zone.
	*
	* @param ModifiedDate the modified date of this legal_ zone
	*/
	@Override
	public void setModifiedDate(java.util.Date ModifiedDate) {
		_legal_Zone.setModifiedDate(ModifiedDate);
	}

	/**
	* Returns the name of this legal_ zone.
	*
	* @return the name of this legal_ zone
	*/
	@Override
	public java.lang.String getName() {
		return _legal_Zone.getName();
	}

	/**
	* Sets the name of this legal_ zone.
	*
	* @param Name the name of this legal_ zone
	*/
	@Override
	public void setName(java.lang.String Name) {
		_legal_Zone.setName(Name);
	}

	/**
	* Returns the url of this legal_ zone.
	*
	* @return the url of this legal_ zone
	*/
	@Override
	public java.lang.String getUrl() {
		return _legal_Zone.getUrl();
	}

	/**
	* Sets the url of this legal_ zone.
	*
	* @param Url the url of this legal_ zone
	*/
	@Override
	public void setUrl(java.lang.String Url) {
		_legal_Zone.setUrl(Url);
	}

	/**
	* Returns the description of this legal_ zone.
	*
	* @return the description of this legal_ zone
	*/
	@Override
	public java.lang.String getDescription() {
		return _legal_Zone.getDescription();
	}

	/**
	* Sets the description of this legal_ zone.
	*
	* @param Description the description of this legal_ zone
	*/
	@Override
	public void setDescription(java.lang.String Description) {
		_legal_Zone.setDescription(Description);
	}

	/**
	* Returns the parent i d of this legal_ zone.
	*
	* @return the parent i d of this legal_ zone
	*/
	@Override
	public int getParentID() {
		return _legal_Zone.getParentID();
	}

	/**
	* Sets the parent i d of this legal_ zone.
	*
	* @param ParentID the parent i d of this legal_ zone
	*/
	@Override
	public void setParentID(int ParentID) {
		_legal_Zone.setParentID(ParentID);
	}

	/**
	* Returns the real url of this legal_ zone.
	*
	* @return the real url of this legal_ zone
	*/
	@Override
	public java.lang.String getRealUrl() {
		return _legal_Zone.getRealUrl();
	}

	/**
	* Sets the real url of this legal_ zone.
	*
	* @param RealUrl the real url of this legal_ zone
	*/
	@Override
	public void setRealUrl(java.lang.String RealUrl) {
		_legal_Zone.setRealUrl(RealUrl);
	}

	/**
	* Returns the visible of this legal_ zone.
	*
	* @return the visible of this legal_ zone
	*/
	@Override
	public boolean getVisible() {
		return _legal_Zone.getVisible();
	}

	/**
	* Returns <code>true</code> if this legal_ zone is visible.
	*
	* @return <code>true</code> if this legal_ zone is visible; <code>false</code> otherwise
	*/
	@Override
	public boolean isVisible() {
		return _legal_Zone.isVisible();
	}

	/**
	* Sets whether this legal_ zone is visible.
	*
	* @param Visible the visible of this legal_ zone
	*/
	@Override
	public void setVisible(boolean Visible) {
		_legal_Zone.setVisible(Visible);
	}

	/**
	* Returns the archived of this legal_ zone.
	*
	* @return the archived of this legal_ zone
	*/
	@Override
	public boolean getArchived() {
		return _legal_Zone.getArchived();
	}

	/**
	* Returns <code>true</code> if this legal_ zone is archived.
	*
	* @return <code>true</code> if this legal_ zone is archived; <code>false</code> otherwise
	*/
	@Override
	public boolean isArchived() {
		return _legal_Zone.isArchived();
	}

	/**
	* Sets whether this legal_ zone is archived.
	*
	* @param Archived the archived of this legal_ zone
	*/
	@Override
	public void setArchived(boolean Archived) {
		_legal_Zone.setArchived(Archived);
	}

	/**
	* Returns the sort order of this legal_ zone.
	*
	* @return the sort order of this legal_ zone
	*/
	@Override
	public int getSortOrder() {
		return _legal_Zone.getSortOrder();
	}

	/**
	* Sets the sort order of this legal_ zone.
	*
	* @param SortOrder the sort order of this legal_ zone
	*/
	@Override
	public void setSortOrder(int SortOrder) {
		_legal_Zone.setSortOrder(SortOrder);
	}

	@Override
	public boolean isNew() {
		return _legal_Zone.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legal_Zone.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legal_Zone.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legal_Zone.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legal_Zone.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legal_Zone.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legal_Zone.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legal_Zone.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legal_Zone.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legal_Zone.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legal_Zone.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Legal_ZoneWrapper((Legal_Zone)_legal_Zone.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.vcms.model.Legal_Zone legal_Zone) {
		return _legal_Zone.compareTo(legal_Zone);
	}

	@Override
	public int hashCode() {
		return _legal_Zone.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Legal_Zone> toCacheModel() {
		return _legal_Zone.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Zone toEscapedModel() {
		return new Legal_ZoneWrapper(_legal_Zone.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Zone toUnescapedModel() {
		return new Legal_ZoneWrapper(_legal_Zone.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legal_Zone.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legal_Zone.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legal_Zone.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Legal_ZoneWrapper)) {
			return false;
		}

		Legal_ZoneWrapper legal_ZoneWrapper = (Legal_ZoneWrapper)obj;

		if (Validator.equals(_legal_Zone, legal_ZoneWrapper._legal_Zone)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Legal_Zone getWrappedLegal_Zone() {
		return _legal_Zone;
	}

	@Override
	public Legal_Zone getWrappedModel() {
		return _legal_Zone;
	}

	@Override
	public void resetOriginalValues() {
		_legal_Zone.resetOriginalValues();
	}

	private Legal_Zone _legal_Zone;
}