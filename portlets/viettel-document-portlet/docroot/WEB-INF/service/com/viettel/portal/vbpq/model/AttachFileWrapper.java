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

package com.viettel.portal.vbpq.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AttachFile}.
 * </p>
 *
 * @author ChucHV
 * @see AttachFile
 * @generated
 */
public class AttachFileWrapper implements AttachFile, ModelWrapper<AttachFile> {
	public AttachFileWrapper(AttachFile attachFile) {
		_attachFile = attachFile;
	}

	@Override
	public Class<?> getModelClass() {
		return AttachFile.class;
	}

	@Override
	public String getModelClassName() {
		return AttachFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("vanBanId", getVanBanId());
		attributes.put("fileId", getFileId());
		attributes.put("fileLink", getFileLink());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long vanBanId = (Long)attributes.get("vanBanId");

		if (vanBanId != null) {
			setVanBanId(vanBanId);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileLink = (String)attributes.get("fileLink");

		if (fileLink != null) {
			setFileLink(fileLink);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}
	}

	/**
	* Returns the primary key of this attach file.
	*
	* @return the primary key of this attach file
	*/
	@Override
	public long getPrimaryKey() {
		return _attachFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this attach file.
	*
	* @param primaryKey the primary key of this attach file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_attachFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this attach file.
	*
	* @return the ID of this attach file
	*/
	@Override
	public long getId() {
		return _attachFile.getId();
	}

	/**
	* Sets the ID of this attach file.
	*
	* @param id the ID of this attach file
	*/
	@Override
	public void setId(long id) {
		_attachFile.setId(id);
	}

	/**
	* Returns the van ban ID of this attach file.
	*
	* @return the van ban ID of this attach file
	*/
	@Override
	public long getVanBanId() {
		return _attachFile.getVanBanId();
	}

	/**
	* Sets the van ban ID of this attach file.
	*
	* @param vanBanId the van ban ID of this attach file
	*/
	@Override
	public void setVanBanId(long vanBanId) {
		_attachFile.setVanBanId(vanBanId);
	}

	/**
	* Returns the file ID of this attach file.
	*
	* @return the file ID of this attach file
	*/
	@Override
	public long getFileId() {
		return _attachFile.getFileId();
	}

	/**
	* Sets the file ID of this attach file.
	*
	* @param fileId the file ID of this attach file
	*/
	@Override
	public void setFileId(long fileId) {
		_attachFile.setFileId(fileId);
	}

	/**
	* Returns the file link of this attach file.
	*
	* @return the file link of this attach file
	*/
	@Override
	public java.lang.String getFileLink() {
		return _attachFile.getFileLink();
	}

	/**
	* Sets the file link of this attach file.
	*
	* @param fileLink the file link of this attach file
	*/
	@Override
	public void setFileLink(java.lang.String fileLink) {
		_attachFile.setFileLink(fileLink);
	}

	/**
	* Returns the file name of this attach file.
	*
	* @return the file name of this attach file
	*/
	@Override
	public java.lang.String getFileName() {
		return _attachFile.getFileName();
	}

	/**
	* Sets the file name of this attach file.
	*
	* @param fileName the file name of this attach file
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_attachFile.setFileName(fileName);
	}

	/**
	* Returns the file size of this attach file.
	*
	* @return the file size of this attach file
	*/
	@Override
	public java.lang.String getFileSize() {
		return _attachFile.getFileSize();
	}

	/**
	* Sets the file size of this attach file.
	*
	* @param fileSize the file size of this attach file
	*/
	@Override
	public void setFileSize(java.lang.String fileSize) {
		_attachFile.setFileSize(fileSize);
	}

	@Override
	public boolean isNew() {
		return _attachFile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_attachFile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _attachFile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attachFile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _attachFile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _attachFile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_attachFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _attachFile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_attachFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_attachFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_attachFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AttachFileWrapper((AttachFile)_attachFile.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.vbpq.model.AttachFile attachFile) {
		return _attachFile.compareTo(attachFile);
	}

	@Override
	public int hashCode() {
		return _attachFile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vbpq.model.AttachFile> toCacheModel() {
		return _attachFile.toCacheModel();
	}

	@Override
	public com.viettel.portal.vbpq.model.AttachFile toEscapedModel() {
		return new AttachFileWrapper(_attachFile.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vbpq.model.AttachFile toUnescapedModel() {
		return new AttachFileWrapper(_attachFile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _attachFile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _attachFile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_attachFile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachFileWrapper)) {
			return false;
		}

		AttachFileWrapper attachFileWrapper = (AttachFileWrapper)obj;

		if (Validator.equals(_attachFile, attachFileWrapper._attachFile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AttachFile getWrappedAttachFile() {
		return _attachFile;
	}

	@Override
	public AttachFile getWrappedModel() {
		return _attachFile;
	}

	@Override
	public void resetOriginalValues() {
		_attachFile.resetOriginalValues();
	}

	private AttachFile _attachFile;
}