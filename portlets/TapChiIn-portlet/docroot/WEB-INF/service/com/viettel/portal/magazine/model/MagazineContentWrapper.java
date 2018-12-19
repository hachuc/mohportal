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
 * This class is a wrapper for {@link MagazineContent}.
 * </p>
 *
 * @author namtv
 * @see MagazineContent
 * @generated
 */
public class MagazineContentWrapper implements MagazineContent,
	ModelWrapper<MagazineContent> {
	public MagazineContentWrapper(MagazineContent magazineContent) {
		_magazineContent = magazineContent;
	}

	@Override
	public Class<?> getModelClass() {
		return MagazineContent.class;
	}

	@Override
	public String getModelClassName() {
		return MagazineContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Headline", getHeadline());
		attributes.put("Teaser", getTeaser());
		attributes.put("Body", getBody());
		attributes.put("MagazineZoneID", getMagazineZoneID());
		attributes.put("MagazineID", getMagazineID());
		attributes.put("Author", getAuthor());
		attributes.put("Jobtitle", getJobtitle());
		attributes.put("ViewedCount", getViewedCount());
		attributes.put("SortOrder", getSortOrder());
		attributes.put("MailedCount", getMailedCount());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Headline = (String)attributes.get("Headline");

		if (Headline != null) {
			setHeadline(Headline);
		}

		String Teaser = (String)attributes.get("Teaser");

		if (Teaser != null) {
			setTeaser(Teaser);
		}

		String Body = (String)attributes.get("Body");

		if (Body != null) {
			setBody(Body);
		}

		Integer MagazineZoneID = (Integer)attributes.get("MagazineZoneID");

		if (MagazineZoneID != null) {
			setMagazineZoneID(MagazineZoneID);
		}

		Integer MagazineID = (Integer)attributes.get("MagazineID");

		if (MagazineID != null) {
			setMagazineID(MagazineID);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		String Jobtitle = (String)attributes.get("Jobtitle");

		if (Jobtitle != null) {
			setJobtitle(Jobtitle);
		}

		Integer ViewedCount = (Integer)attributes.get("ViewedCount");

		if (ViewedCount != null) {
			setViewedCount(ViewedCount);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}

		Integer MailedCount = (Integer)attributes.get("MailedCount");

		if (MailedCount != null) {
			setMailedCount(MailedCount);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}
	}

	/**
	* Returns the primary key of this magazine content.
	*
	* @return the primary key of this magazine content
	*/
	@Override
	public int getPrimaryKey() {
		return _magazineContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this magazine content.
	*
	* @param primaryKey the primary key of this magazine content
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_magazineContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this magazine content.
	*
	* @return the i d of this magazine content
	*/
	@Override
	public int getID() {
		return _magazineContent.getID();
	}

	/**
	* Sets the i d of this magazine content.
	*
	* @param ID the i d of this magazine content
	*/
	@Override
	public void setID(int ID) {
		_magazineContent.setID(ID);
	}

	/**
	* Returns the headline of this magazine content.
	*
	* @return the headline of this magazine content
	*/
	@Override
	public java.lang.String getHeadline() {
		return _magazineContent.getHeadline();
	}

	/**
	* Sets the headline of this magazine content.
	*
	* @param Headline the headline of this magazine content
	*/
	@Override
	public void setHeadline(java.lang.String Headline) {
		_magazineContent.setHeadline(Headline);
	}

	/**
	* Returns the teaser of this magazine content.
	*
	* @return the teaser of this magazine content
	*/
	@Override
	public java.lang.String getTeaser() {
		return _magazineContent.getTeaser();
	}

	/**
	* Sets the teaser of this magazine content.
	*
	* @param Teaser the teaser of this magazine content
	*/
	@Override
	public void setTeaser(java.lang.String Teaser) {
		_magazineContent.setTeaser(Teaser);
	}

	/**
	* Returns the body of this magazine content.
	*
	* @return the body of this magazine content
	*/
	@Override
	public java.lang.String getBody() {
		return _magazineContent.getBody();
	}

	/**
	* Sets the body of this magazine content.
	*
	* @param Body the body of this magazine content
	*/
	@Override
	public void setBody(java.lang.String Body) {
		_magazineContent.setBody(Body);
	}

	/**
	* Returns the magazine zone i d of this magazine content.
	*
	* @return the magazine zone i d of this magazine content
	*/
	@Override
	public int getMagazineZoneID() {
		return _magazineContent.getMagazineZoneID();
	}

	/**
	* Sets the magazine zone i d of this magazine content.
	*
	* @param MagazineZoneID the magazine zone i d of this magazine content
	*/
	@Override
	public void setMagazineZoneID(int MagazineZoneID) {
		_magazineContent.setMagazineZoneID(MagazineZoneID);
	}

	/**
	* Returns the magazine i d of this magazine content.
	*
	* @return the magazine i d of this magazine content
	*/
	@Override
	public int getMagazineID() {
		return _magazineContent.getMagazineID();
	}

	/**
	* Sets the magazine i d of this magazine content.
	*
	* @param MagazineID the magazine i d of this magazine content
	*/
	@Override
	public void setMagazineID(int MagazineID) {
		_magazineContent.setMagazineID(MagazineID);
	}

	/**
	* Returns the author of this magazine content.
	*
	* @return the author of this magazine content
	*/
	@Override
	public java.lang.String getAuthor() {
		return _magazineContent.getAuthor();
	}

	/**
	* Sets the author of this magazine content.
	*
	* @param Author the author of this magazine content
	*/
	@Override
	public void setAuthor(java.lang.String Author) {
		_magazineContent.setAuthor(Author);
	}

	/**
	* Returns the jobtitle of this magazine content.
	*
	* @return the jobtitle of this magazine content
	*/
	@Override
	public java.lang.String getJobtitle() {
		return _magazineContent.getJobtitle();
	}

	/**
	* Sets the jobtitle of this magazine content.
	*
	* @param Jobtitle the jobtitle of this magazine content
	*/
	@Override
	public void setJobtitle(java.lang.String Jobtitle) {
		_magazineContent.setJobtitle(Jobtitle);
	}

	/**
	* Returns the viewed count of this magazine content.
	*
	* @return the viewed count of this magazine content
	*/
	@Override
	public int getViewedCount() {
		return _magazineContent.getViewedCount();
	}

	/**
	* Sets the viewed count of this magazine content.
	*
	* @param ViewedCount the viewed count of this magazine content
	*/
	@Override
	public void setViewedCount(int ViewedCount) {
		_magazineContent.setViewedCount(ViewedCount);
	}

	/**
	* Returns the sort order of this magazine content.
	*
	* @return the sort order of this magazine content
	*/
	@Override
	public int getSortOrder() {
		return _magazineContent.getSortOrder();
	}

	/**
	* Sets the sort order of this magazine content.
	*
	* @param SortOrder the sort order of this magazine content
	*/
	@Override
	public void setSortOrder(int SortOrder) {
		_magazineContent.setSortOrder(SortOrder);
	}

	/**
	* Returns the mailed count of this magazine content.
	*
	* @return the mailed count of this magazine content
	*/
	@Override
	public int getMailedCount() {
		return _magazineContent.getMailedCount();
	}

	/**
	* Sets the mailed count of this magazine content.
	*
	* @param MailedCount the mailed count of this magazine content
	*/
	@Override
	public void setMailedCount(int MailedCount) {
		_magazineContent.setMailedCount(MailedCount);
	}

	/**
	* Returns the creation date of this magazine content.
	*
	* @return the creation date of this magazine content
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _magazineContent.getCreationDate();
	}

	/**
	* Sets the creation date of this magazine content.
	*
	* @param CreationDate the creation date of this magazine content
	*/
	@Override
	public void setCreationDate(java.util.Date CreationDate) {
		_magazineContent.setCreationDate(CreationDate);
	}

	/**
	* Returns the modified date of this magazine content.
	*
	* @return the modified date of this magazine content
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _magazineContent.getModifiedDate();
	}

	/**
	* Sets the modified date of this magazine content.
	*
	* @param ModifiedDate the modified date of this magazine content
	*/
	@Override
	public void setModifiedDate(java.util.Date ModifiedDate) {
		_magazineContent.setModifiedDate(ModifiedDate);
	}

	@Override
	public boolean isNew() {
		return _magazineContent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_magazineContent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _magazineContent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_magazineContent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _magazineContent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _magazineContent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_magazineContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _magazineContent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_magazineContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_magazineContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_magazineContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MagazineContentWrapper((MagazineContent)_magazineContent.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.magazine.model.MagazineContent magazineContent) {
		return _magazineContent.compareTo(magazineContent);
	}

	@Override
	public int hashCode() {
		return _magazineContent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.magazine.model.MagazineContent> toCacheModel() {
		return _magazineContent.toCacheModel();
	}

	@Override
	public com.viettel.portal.magazine.model.MagazineContent toEscapedModel() {
		return new MagazineContentWrapper(_magazineContent.toEscapedModel());
	}

	@Override
	public com.viettel.portal.magazine.model.MagazineContent toUnescapedModel() {
		return new MagazineContentWrapper(_magazineContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _magazineContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _magazineContent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_magazineContent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MagazineContentWrapper)) {
			return false;
		}

		MagazineContentWrapper magazineContentWrapper = (MagazineContentWrapper)obj;

		if (Validator.equals(_magazineContent,
					magazineContentWrapper._magazineContent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MagazineContent getWrappedMagazineContent() {
		return _magazineContent;
	}

	@Override
	public MagazineContent getWrappedModel() {
		return _magazineContent;
	}

	@Override
	public void resetOriginalValues() {
		_magazineContent.resetOriginalValues();
	}

	private MagazineContent _magazineContent;
}