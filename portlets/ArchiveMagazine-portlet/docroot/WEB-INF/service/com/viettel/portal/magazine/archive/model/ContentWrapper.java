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

package com.viettel.portal.magazine.archive.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Content}.
 * </p>
 *
 * @author namtv
 * @see Content
 * @generated
 */
public class ContentWrapper implements Content, ModelWrapper<Content> {
	public ContentWrapper(Content content) {
		_content = content;
	}

	@Override
	public Class<?> getModelClass() {
		return Content.class;
	}

	@Override
	public String getModelClassName() {
		return Content.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Subject", getSubject());
		attributes.put("NormalZoneID", getNormalZoneID());
		attributes.put("SpecialZoneID", getSpecialZoneID());
		attributes.put("FileUrl", getFileUrl());
		attributes.put("Author", getAuthor());
		attributes.put("AuthorTitle", getAuthorTitle());
		attributes.put("MagazineID", getMagazineID());
		attributes.put("SortOrder", getSortOrder());
		attributes.put("CreationDate", getCreationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Subject = (String)attributes.get("Subject");

		if (Subject != null) {
			setSubject(Subject);
		}

		Integer NormalZoneID = (Integer)attributes.get("NormalZoneID");

		if (NormalZoneID != null) {
			setNormalZoneID(NormalZoneID);
		}

		Integer SpecialZoneID = (Integer)attributes.get("SpecialZoneID");

		if (SpecialZoneID != null) {
			setSpecialZoneID(SpecialZoneID);
		}

		String FileUrl = (String)attributes.get("FileUrl");

		if (FileUrl != null) {
			setFileUrl(FileUrl);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		String AuthorTitle = (String)attributes.get("AuthorTitle");

		if (AuthorTitle != null) {
			setAuthorTitle(AuthorTitle);
		}

		Integer MagazineID = (Integer)attributes.get("MagazineID");

		if (MagazineID != null) {
			setMagazineID(MagazineID);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}
	}

	/**
	* Returns the primary key of this content.
	*
	* @return the primary key of this content
	*/
	@Override
	public int getPrimaryKey() {
		return _content.getPrimaryKey();
	}

	/**
	* Sets the primary key of this content.
	*
	* @param primaryKey the primary key of this content
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_content.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this content.
	*
	* @return the i d of this content
	*/
	@Override
	public int getID() {
		return _content.getID();
	}

	/**
	* Sets the i d of this content.
	*
	* @param ID the i d of this content
	*/
	@Override
	public void setID(int ID) {
		_content.setID(ID);
	}

	/**
	* Returns the subject of this content.
	*
	* @return the subject of this content
	*/
	@Override
	public java.lang.String getSubject() {
		return _content.getSubject();
	}

	/**
	* Sets the subject of this content.
	*
	* @param Subject the subject of this content
	*/
	@Override
	public void setSubject(java.lang.String Subject) {
		_content.setSubject(Subject);
	}

	/**
	* Returns the normal zone i d of this content.
	*
	* @return the normal zone i d of this content
	*/
	@Override
	public int getNormalZoneID() {
		return _content.getNormalZoneID();
	}

	/**
	* Sets the normal zone i d of this content.
	*
	* @param NormalZoneID the normal zone i d of this content
	*/
	@Override
	public void setNormalZoneID(int NormalZoneID) {
		_content.setNormalZoneID(NormalZoneID);
	}

	/**
	* Returns the special zone i d of this content.
	*
	* @return the special zone i d of this content
	*/
	@Override
	public int getSpecialZoneID() {
		return _content.getSpecialZoneID();
	}

	/**
	* Sets the special zone i d of this content.
	*
	* @param SpecialZoneID the special zone i d of this content
	*/
	@Override
	public void setSpecialZoneID(int SpecialZoneID) {
		_content.setSpecialZoneID(SpecialZoneID);
	}

	/**
	* Returns the file url of this content.
	*
	* @return the file url of this content
	*/
	@Override
	public java.lang.String getFileUrl() {
		return _content.getFileUrl();
	}

	/**
	* Sets the file url of this content.
	*
	* @param FileUrl the file url of this content
	*/
	@Override
	public void setFileUrl(java.lang.String FileUrl) {
		_content.setFileUrl(FileUrl);
	}

	/**
	* Returns the author of this content.
	*
	* @return the author of this content
	*/
	@Override
	public java.lang.String getAuthor() {
		return _content.getAuthor();
	}

	/**
	* Sets the author of this content.
	*
	* @param Author the author of this content
	*/
	@Override
	public void setAuthor(java.lang.String Author) {
		_content.setAuthor(Author);
	}

	/**
	* Returns the author title of this content.
	*
	* @return the author title of this content
	*/
	@Override
	public java.lang.String getAuthorTitle() {
		return _content.getAuthorTitle();
	}

	/**
	* Sets the author title of this content.
	*
	* @param AuthorTitle the author title of this content
	*/
	@Override
	public void setAuthorTitle(java.lang.String AuthorTitle) {
		_content.setAuthorTitle(AuthorTitle);
	}

	/**
	* Returns the magazine i d of this content.
	*
	* @return the magazine i d of this content
	*/
	@Override
	public int getMagazineID() {
		return _content.getMagazineID();
	}

	/**
	* Sets the magazine i d of this content.
	*
	* @param MagazineID the magazine i d of this content
	*/
	@Override
	public void setMagazineID(int MagazineID) {
		_content.setMagazineID(MagazineID);
	}

	/**
	* Returns the sort order of this content.
	*
	* @return the sort order of this content
	*/
	@Override
	public int getSortOrder() {
		return _content.getSortOrder();
	}

	/**
	* Sets the sort order of this content.
	*
	* @param SortOrder the sort order of this content
	*/
	@Override
	public void setSortOrder(int SortOrder) {
		_content.setSortOrder(SortOrder);
	}

	/**
	* Returns the creation date of this content.
	*
	* @return the creation date of this content
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _content.getCreationDate();
	}

	/**
	* Sets the creation date of this content.
	*
	* @param CreationDate the creation date of this content
	*/
	@Override
	public void setCreationDate(java.util.Date CreationDate) {
		_content.setCreationDate(CreationDate);
	}

	@Override
	public boolean isNew() {
		return _content.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_content.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _content.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_content.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _content.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _content.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_content.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _content.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_content.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_content.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_content.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContentWrapper((Content)_content.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.magazine.archive.model.Content content) {
		return _content.compareTo(content);
	}

	@Override
	public int hashCode() {
		return _content.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.magazine.archive.model.Content> toCacheModel() {
		return _content.toCacheModel();
	}

	@Override
	public com.viettel.portal.magazine.archive.model.Content toEscapedModel() {
		return new ContentWrapper(_content.toEscapedModel());
	}

	@Override
	public com.viettel.portal.magazine.archive.model.Content toUnescapedModel() {
		return new ContentWrapper(_content.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _content.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _content.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_content.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContentWrapper)) {
			return false;
		}

		ContentWrapper contentWrapper = (ContentWrapper)obj;

		if (Validator.equals(_content, contentWrapper._content)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Content getWrappedContent() {
		return _content;
	}

	@Override
	public Content getWrappedModel() {
		return _content;
	}

	@Override
	public void resetOriginalValues() {
		_content.resetOriginalValues();
	}

	private Content _content;
}