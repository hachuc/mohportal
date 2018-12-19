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
 * This class is a wrapper for {@link Notes}.
 * </p>
 *
 * @author chuchv
 * @see Notes
 * @generated
 */
public class NotesWrapper implements Notes, ModelWrapper<Notes> {
	public NotesWrapper(Notes notes) {
		_notes = notes;
	}

	@Override
	public Class<?> getModelClass() {
		return Notes.class;
	}

	@Override
	public String getModelClassName() {
		return Notes.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ContentID", getContentID());
		attributes.put("Version", getVersion());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("Content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ContentID = (Long)attributes.get("ContentID");

		if (ContentID != null) {
			setContentID(ContentID);
		}

		Integer Version = (Integer)attributes.get("Version");

		if (Version != null) {
			setVersion(Version);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String Content = (String)attributes.get("Content");

		if (Content != null) {
			setContent(Content);
		}
	}

	/**
	* Returns the primary key of this notes.
	*
	* @return the primary key of this notes
	*/
	@Override
	public com.viettel.portal.vcms.service.persistence.NotesPK getPrimaryKey() {
		return _notes.getPrimaryKey();
	}

	/**
	* Sets the primary key of this notes.
	*
	* @param primaryKey the primary key of this notes
	*/
	@Override
	public void setPrimaryKey(
		com.viettel.portal.vcms.service.persistence.NotesPK primaryKey) {
		_notes.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content i d of this notes.
	*
	* @return the content i d of this notes
	*/
	@Override
	public long getContentID() {
		return _notes.getContentID();
	}

	/**
	* Sets the content i d of this notes.
	*
	* @param ContentID the content i d of this notes
	*/
	@Override
	public void setContentID(long ContentID) {
		_notes.setContentID(ContentID);
	}

	/**
	* Returns the version of this notes.
	*
	* @return the version of this notes
	*/
	@Override
	public int getVersion() {
		return _notes.getVersion();
	}

	/**
	* Sets the version of this notes.
	*
	* @param Version the version of this notes
	*/
	@Override
	public void setVersion(int Version) {
		_notes.setVersion(Version);
	}

	/**
	* Returns the group ID of this notes.
	*
	* @return the group ID of this notes
	*/
	@Override
	public long getGroupId() {
		return _notes.getGroupId();
	}

	/**
	* Sets the group ID of this notes.
	*
	* @param groupId the group ID of this notes
	*/
	@Override
	public void setGroupId(long groupId) {
		_notes.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this notes.
	*
	* @return the company ID of this notes
	*/
	@Override
	public long getCompanyId() {
		return _notes.getCompanyId();
	}

	/**
	* Sets the company ID of this notes.
	*
	* @param companyId the company ID of this notes
	*/
	@Override
	public void setCompanyId(long companyId) {
		_notes.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this notes.
	*
	* @return the user ID of this notes
	*/
	@Override
	public long getUserId() {
		return _notes.getUserId();
	}

	/**
	* Sets the user ID of this notes.
	*
	* @param userId the user ID of this notes
	*/
	@Override
	public void setUserId(long userId) {
		_notes.setUserId(userId);
	}

	/**
	* Returns the user uuid of this notes.
	*
	* @return the user uuid of this notes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notes.getUserUuid();
	}

	/**
	* Sets the user uuid of this notes.
	*
	* @param userUuid the user uuid of this notes
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_notes.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this notes.
	*
	* @return the user name of this notes
	*/
	@Override
	public java.lang.String getUserName() {
		return _notes.getUserName();
	}

	/**
	* Sets the user name of this notes.
	*
	* @param userName the user name of this notes
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_notes.setUserName(userName);
	}

	/**
	* Returns the create date of this notes.
	*
	* @return the create date of this notes
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _notes.getCreateDate();
	}

	/**
	* Sets the create date of this notes.
	*
	* @param createDate the create date of this notes
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_notes.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this notes.
	*
	* @return the modified date of this notes
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _notes.getModifiedDate();
	}

	/**
	* Sets the modified date of this notes.
	*
	* @param modifiedDate the modified date of this notes
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_notes.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the content of this notes.
	*
	* @return the content of this notes
	*/
	@Override
	public java.lang.String getContent() {
		return _notes.getContent();
	}

	/**
	* Sets the content of this notes.
	*
	* @param Content the content of this notes
	*/
	@Override
	public void setContent(java.lang.String Content) {
		_notes.setContent(Content);
	}

	@Override
	public boolean isNew() {
		return _notes.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_notes.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _notes.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_notes.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _notes.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _notes.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_notes.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _notes.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_notes.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_notes.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_notes.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NotesWrapper((Notes)_notes.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.vcms.model.Notes notes) {
		return _notes.compareTo(notes);
	}

	@Override
	public int hashCode() {
		return _notes.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Notes> toCacheModel() {
		return _notes.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Notes toEscapedModel() {
		return new NotesWrapper(_notes.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Notes toUnescapedModel() {
		return new NotesWrapper(_notes.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _notes.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _notes.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_notes.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotesWrapper)) {
			return false;
		}

		NotesWrapper notesWrapper = (NotesWrapper)obj;

		if (Validator.equals(_notes, notesWrapper._notes)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Notes getWrappedNotes() {
		return _notes;
	}

	@Override
	public Notes getWrappedModel() {
		return _notes;
	}

	@Override
	public void resetOriginalValues() {
		_notes.resetOriginalValues();
	}

	private Notes _notes;
}