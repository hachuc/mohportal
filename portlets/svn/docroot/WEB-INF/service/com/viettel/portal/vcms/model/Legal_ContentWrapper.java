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
 * This class is a wrapper for {@link Legal_Content}.
 * </p>
 *
 * @author chuchv
 * @see Legal_Content
 * @generated
 */
public class Legal_ContentWrapper implements Legal_Content,
	ModelWrapper<Legal_Content> {
	public Legal_ContentWrapper(Legal_Content legal_Content) {
		_legal_Content = legal_Content;
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_Content.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_Content.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("ContentID", getContentID());
		attributes.put("Version", getVersion());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("Byline", getByline());
		attributes.put("Headline", getHeadline());
		attributes.put("Tagline", getTagline());
		attributes.put("Teaser", getTeaser());
		attributes.put("Body", getBody());
		attributes.put("Avatar", getAvatar());
		attributes.put("ImageUrl", getImageUrl());
		attributes.put("ImageDescription", getImageDescription());
		attributes.put("ImageAlign", getImageAlign());
		attributes.put("ZoneID", getZoneID());
		attributes.put("Source", getSource());
		attributes.put("Status", getStatus());
		attributes.put("Author", getAuthor());
		attributes.put("Editor", getEditor());
		attributes.put("Approver", getApprover());
		attributes.put("Deployer", getDeployer());
		attributes.put("Authors", getAuthors());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Integer ContentID = (Integer)attributes.get("ContentID");

		if (ContentID != null) {
			setContentID(ContentID);
		}

		Integer Version = (Integer)attributes.get("Version");

		if (Version != null) {
			setVersion(Version);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		String Byline = (String)attributes.get("Byline");

		if (Byline != null) {
			setByline(Byline);
		}

		String Headline = (String)attributes.get("Headline");

		if (Headline != null) {
			setHeadline(Headline);
		}

		String Tagline = (String)attributes.get("Tagline");

		if (Tagline != null) {
			setTagline(Tagline);
		}

		String Teaser = (String)attributes.get("Teaser");

		if (Teaser != null) {
			setTeaser(Teaser);
		}

		String Body = (String)attributes.get("Body");

		if (Body != null) {
			setBody(Body);
		}

		String Avatar = (String)attributes.get("Avatar");

		if (Avatar != null) {
			setAvatar(Avatar);
		}

		String ImageUrl = (String)attributes.get("ImageUrl");

		if (ImageUrl != null) {
			setImageUrl(ImageUrl);
		}

		String ImageDescription = (String)attributes.get("ImageDescription");

		if (ImageDescription != null) {
			setImageDescription(ImageDescription);
		}

		Integer ImageAlign = (Integer)attributes.get("ImageAlign");

		if (ImageAlign != null) {
			setImageAlign(ImageAlign);
		}

		Integer ZoneID = (Integer)attributes.get("ZoneID");

		if (ZoneID != null) {
			setZoneID(ZoneID);
		}

		String Source = (String)attributes.get("Source");

		if (Source != null) {
			setSource(Source);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		String Editor = (String)attributes.get("Editor");

		if (Editor != null) {
			setEditor(Editor);
		}

		String Approver = (String)attributes.get("Approver");

		if (Approver != null) {
			setApprover(Approver);
		}

		String Deployer = (String)attributes.get("Deployer");

		if (Deployer != null) {
			setDeployer(Deployer);
		}

		String Authors = (String)attributes.get("Authors");

		if (Authors != null) {
			setAuthors(Authors);
		}
	}

	/**
	* Returns the primary key of this legal_ content.
	*
	* @return the primary key of this legal_ content
	*/
	@Override
	public int getPrimaryKey() {
		return _legal_Content.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legal_ content.
	*
	* @param primaryKey the primary key of this legal_ content
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legal_Content.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this legal_ content.
	*
	* @return the i d of this legal_ content
	*/
	@Override
	public int getID() {
		return _legal_Content.getID();
	}

	/**
	* Sets the i d of this legal_ content.
	*
	* @param ID the i d of this legal_ content
	*/
	@Override
	public void setID(int ID) {
		_legal_Content.setID(ID);
	}

	/**
	* Returns the content i d of this legal_ content.
	*
	* @return the content i d of this legal_ content
	*/
	@Override
	public int getContentID() {
		return _legal_Content.getContentID();
	}

	/**
	* Sets the content i d of this legal_ content.
	*
	* @param ContentID the content i d of this legal_ content
	*/
	@Override
	public void setContentID(int ContentID) {
		_legal_Content.setContentID(ContentID);
	}

	/**
	* Returns the version of this legal_ content.
	*
	* @return the version of this legal_ content
	*/
	@Override
	public int getVersion() {
		return _legal_Content.getVersion();
	}

	/**
	* Sets the version of this legal_ content.
	*
	* @param Version the version of this legal_ content
	*/
	@Override
	public void setVersion(int Version) {
		_legal_Content.setVersion(Version);
	}

	/**
	* Returns the creation date of this legal_ content.
	*
	* @return the creation date of this legal_ content
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _legal_Content.getCreationDate();
	}

	/**
	* Sets the creation date of this legal_ content.
	*
	* @param CreationDate the creation date of this legal_ content
	*/
	@Override
	public void setCreationDate(java.util.Date CreationDate) {
		_legal_Content.setCreationDate(CreationDate);
	}

	/**
	* Returns the modified date of this legal_ content.
	*
	* @return the modified date of this legal_ content
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legal_Content.getModifiedDate();
	}

	/**
	* Sets the modified date of this legal_ content.
	*
	* @param ModifiedDate the modified date of this legal_ content
	*/
	@Override
	public void setModifiedDate(java.util.Date ModifiedDate) {
		_legal_Content.setModifiedDate(ModifiedDate);
	}

	/**
	* Returns the byline of this legal_ content.
	*
	* @return the byline of this legal_ content
	*/
	@Override
	public java.lang.String getByline() {
		return _legal_Content.getByline();
	}

	/**
	* Sets the byline of this legal_ content.
	*
	* @param Byline the byline of this legal_ content
	*/
	@Override
	public void setByline(java.lang.String Byline) {
		_legal_Content.setByline(Byline);
	}

	/**
	* Returns the headline of this legal_ content.
	*
	* @return the headline of this legal_ content
	*/
	@Override
	public java.lang.String getHeadline() {
		return _legal_Content.getHeadline();
	}

	/**
	* Sets the headline of this legal_ content.
	*
	* @param Headline the headline of this legal_ content
	*/
	@Override
	public void setHeadline(java.lang.String Headline) {
		_legal_Content.setHeadline(Headline);
	}

	/**
	* Returns the tagline of this legal_ content.
	*
	* @return the tagline of this legal_ content
	*/
	@Override
	public java.lang.String getTagline() {
		return _legal_Content.getTagline();
	}

	/**
	* Sets the tagline of this legal_ content.
	*
	* @param Tagline the tagline of this legal_ content
	*/
	@Override
	public void setTagline(java.lang.String Tagline) {
		_legal_Content.setTagline(Tagline);
	}

	/**
	* Returns the teaser of this legal_ content.
	*
	* @return the teaser of this legal_ content
	*/
	@Override
	public java.lang.String getTeaser() {
		return _legal_Content.getTeaser();
	}

	/**
	* Sets the teaser of this legal_ content.
	*
	* @param Teaser the teaser of this legal_ content
	*/
	@Override
	public void setTeaser(java.lang.String Teaser) {
		_legal_Content.setTeaser(Teaser);
	}

	/**
	* Returns the body of this legal_ content.
	*
	* @return the body of this legal_ content
	*/
	@Override
	public java.lang.String getBody() {
		return _legal_Content.getBody();
	}

	/**
	* Sets the body of this legal_ content.
	*
	* @param Body the body of this legal_ content
	*/
	@Override
	public void setBody(java.lang.String Body) {
		_legal_Content.setBody(Body);
	}

	/**
	* Returns the avatar of this legal_ content.
	*
	* @return the avatar of this legal_ content
	*/
	@Override
	public java.lang.String getAvatar() {
		return _legal_Content.getAvatar();
	}

	/**
	* Sets the avatar of this legal_ content.
	*
	* @param Avatar the avatar of this legal_ content
	*/
	@Override
	public void setAvatar(java.lang.String Avatar) {
		_legal_Content.setAvatar(Avatar);
	}

	/**
	* Returns the image url of this legal_ content.
	*
	* @return the image url of this legal_ content
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _legal_Content.getImageUrl();
	}

	/**
	* Sets the image url of this legal_ content.
	*
	* @param ImageUrl the image url of this legal_ content
	*/
	@Override
	public void setImageUrl(java.lang.String ImageUrl) {
		_legal_Content.setImageUrl(ImageUrl);
	}

	/**
	* Returns the image description of this legal_ content.
	*
	* @return the image description of this legal_ content
	*/
	@Override
	public java.lang.String getImageDescription() {
		return _legal_Content.getImageDescription();
	}

	/**
	* Sets the image description of this legal_ content.
	*
	* @param ImageDescription the image description of this legal_ content
	*/
	@Override
	public void setImageDescription(java.lang.String ImageDescription) {
		_legal_Content.setImageDescription(ImageDescription);
	}

	/**
	* Returns the image align of this legal_ content.
	*
	* @return the image align of this legal_ content
	*/
	@Override
	public int getImageAlign() {
		return _legal_Content.getImageAlign();
	}

	/**
	* Sets the image align of this legal_ content.
	*
	* @param ImageAlign the image align of this legal_ content
	*/
	@Override
	public void setImageAlign(int ImageAlign) {
		_legal_Content.setImageAlign(ImageAlign);
	}

	/**
	* Returns the zone i d of this legal_ content.
	*
	* @return the zone i d of this legal_ content
	*/
	@Override
	public int getZoneID() {
		return _legal_Content.getZoneID();
	}

	/**
	* Sets the zone i d of this legal_ content.
	*
	* @param ZoneID the zone i d of this legal_ content
	*/
	@Override
	public void setZoneID(int ZoneID) {
		_legal_Content.setZoneID(ZoneID);
	}

	/**
	* Returns the source of this legal_ content.
	*
	* @return the source of this legal_ content
	*/
	@Override
	public java.lang.String getSource() {
		return _legal_Content.getSource();
	}

	/**
	* Sets the source of this legal_ content.
	*
	* @param Source the source of this legal_ content
	*/
	@Override
	public void setSource(java.lang.String Source) {
		_legal_Content.setSource(Source);
	}

	/**
	* Returns the status of this legal_ content.
	*
	* @return the status of this legal_ content
	*/
	@Override
	public int getStatus() {
		return _legal_Content.getStatus();
	}

	/**
	* Sets the status of this legal_ content.
	*
	* @param Status the status of this legal_ content
	*/
	@Override
	public void setStatus(int Status) {
		_legal_Content.setStatus(Status);
	}

	/**
	* Returns the author of this legal_ content.
	*
	* @return the author of this legal_ content
	*/
	@Override
	public java.lang.String getAuthor() {
		return _legal_Content.getAuthor();
	}

	/**
	* Sets the author of this legal_ content.
	*
	* @param Author the author of this legal_ content
	*/
	@Override
	public void setAuthor(java.lang.String Author) {
		_legal_Content.setAuthor(Author);
	}

	/**
	* Returns the editor of this legal_ content.
	*
	* @return the editor of this legal_ content
	*/
	@Override
	public java.lang.String getEditor() {
		return _legal_Content.getEditor();
	}

	/**
	* Sets the editor of this legal_ content.
	*
	* @param Editor the editor of this legal_ content
	*/
	@Override
	public void setEditor(java.lang.String Editor) {
		_legal_Content.setEditor(Editor);
	}

	/**
	* Returns the approver of this legal_ content.
	*
	* @return the approver of this legal_ content
	*/
	@Override
	public java.lang.String getApprover() {
		return _legal_Content.getApprover();
	}

	/**
	* Sets the approver of this legal_ content.
	*
	* @param Approver the approver of this legal_ content
	*/
	@Override
	public void setApprover(java.lang.String Approver) {
		_legal_Content.setApprover(Approver);
	}

	/**
	* Returns the deployer of this legal_ content.
	*
	* @return the deployer of this legal_ content
	*/
	@Override
	public java.lang.String getDeployer() {
		return _legal_Content.getDeployer();
	}

	/**
	* Sets the deployer of this legal_ content.
	*
	* @param Deployer the deployer of this legal_ content
	*/
	@Override
	public void setDeployer(java.lang.String Deployer) {
		_legal_Content.setDeployer(Deployer);
	}

	/**
	* Returns the authors of this legal_ content.
	*
	* @return the authors of this legal_ content
	*/
	@Override
	public java.lang.String getAuthors() {
		return _legal_Content.getAuthors();
	}

	/**
	* Sets the authors of this legal_ content.
	*
	* @param Authors the authors of this legal_ content
	*/
	@Override
	public void setAuthors(java.lang.String Authors) {
		_legal_Content.setAuthors(Authors);
	}

	@Override
	public boolean isNew() {
		return _legal_Content.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legal_Content.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legal_Content.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legal_Content.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legal_Content.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legal_Content.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legal_Content.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legal_Content.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legal_Content.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legal_Content.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legal_Content.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Legal_ContentWrapper((Legal_Content)_legal_Content.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vcms.model.Legal_Content legal_Content) {
		return _legal_Content.compareTo(legal_Content);
	}

	@Override
	public int hashCode() {
		return _legal_Content.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Legal_Content> toCacheModel() {
		return _legal_Content.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Content toEscapedModel() {
		return new Legal_ContentWrapper(_legal_Content.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Content toUnescapedModel() {
		return new Legal_ContentWrapper(_legal_Content.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legal_Content.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legal_Content.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legal_Content.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Legal_ContentWrapper)) {
			return false;
		}

		Legal_ContentWrapper legal_ContentWrapper = (Legal_ContentWrapper)obj;

		if (Validator.equals(_legal_Content, legal_ContentWrapper._legal_Content)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Legal_Content getWrappedLegal_Content() {
		return _legal_Content;
	}

	@Override
	public Legal_Content getWrappedModel() {
		return _legal_Content;
	}

	@Override
	public void resetOriginalValues() {
		_legal_Content.resetOriginalValues();
	}

	private Legal_Content _legal_Content;
}