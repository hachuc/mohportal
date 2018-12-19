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

package com.viettel.portal.photos.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Photo}.
 * </p>
 *
 * @author ChucHV
 * @see Photo
 * @generated
 */
public class PhotoWrapper implements Photo, ModelWrapper<Photo> {
	public PhotoWrapper(Photo photo) {
		_photo = photo;
	}

	@Override
	public Class<?> getModelClass() {
		return Photo.class;
	}

	@Override
	public String getModelClassName() {
		return Photo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("photoId", getPhotoId());
		attributes.put("caption", getCaption());
		attributes.put("fileId", getFileId());
		attributes.put("fileLink", getFileLink());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("order_", getOrder_());
		attributes.put("status", getStatus());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long photoId = (Long)attributes.get("photoId");

		if (photoId != null) {
			setPhotoId(photoId);
		}

		String caption = (String)attributes.get("caption");

		if (caption != null) {
			setCaption(caption);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Integer order_ = (Integer)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this photo.
	*
	* @return the primary key of this photo
	*/
	@Override
	public long getPrimaryKey() {
		return _photo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this photo.
	*
	* @param primaryKey the primary key of this photo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_photo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the photo ID of this photo.
	*
	* @return the photo ID of this photo
	*/
	@Override
	public long getPhotoId() {
		return _photo.getPhotoId();
	}

	/**
	* Sets the photo ID of this photo.
	*
	* @param photoId the photo ID of this photo
	*/
	@Override
	public void setPhotoId(long photoId) {
		_photo.setPhotoId(photoId);
	}

	/**
	* Returns the caption of this photo.
	*
	* @return the caption of this photo
	*/
	@Override
	public java.lang.String getCaption() {
		return _photo.getCaption();
	}

	/**
	* Sets the caption of this photo.
	*
	* @param caption the caption of this photo
	*/
	@Override
	public void setCaption(java.lang.String caption) {
		_photo.setCaption(caption);
	}

	/**
	* Returns the file ID of this photo.
	*
	* @return the file ID of this photo
	*/
	@Override
	public long getFileId() {
		return _photo.getFileId();
	}

	/**
	* Sets the file ID of this photo.
	*
	* @param fileId the file ID of this photo
	*/
	@Override
	public void setFileId(long fileId) {
		_photo.setFileId(fileId);
	}

	/**
	* Returns the file link of this photo.
	*
	* @return the file link of this photo
	*/
	@Override
	public java.lang.String getFileLink() {
		return _photo.getFileLink();
	}

	/**
	* Sets the file link of this photo.
	*
	* @param fileLink the file link of this photo
	*/
	@Override
	public void setFileLink(java.lang.String fileLink) {
		_photo.setFileLink(fileLink);
	}

	/**
	* Returns the file name of this photo.
	*
	* @return the file name of this photo
	*/
	@Override
	public java.lang.String getFileName() {
		return _photo.getFileName();
	}

	/**
	* Sets the file name of this photo.
	*
	* @param fileName the file name of this photo
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_photo.setFileName(fileName);
	}

	/**
	* Returns the file size of this photo.
	*
	* @return the file size of this photo
	*/
	@Override
	public java.lang.String getFileSize() {
		return _photo.getFileSize();
	}

	/**
	* Sets the file size of this photo.
	*
	* @param fileSize the file size of this photo
	*/
	@Override
	public void setFileSize(java.lang.String fileSize) {
		_photo.setFileSize(fileSize);
	}

	/**
	* Returns the create date of this photo.
	*
	* @return the create date of this photo
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _photo.getCreateDate();
	}

	/**
	* Sets the create date of this photo.
	*
	* @param createDate the create date of this photo
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_photo.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this photo.
	*
	* @return the modify date of this photo
	*/
	@Override
	public java.util.Date getModifyDate() {
		return _photo.getModifyDate();
	}

	/**
	* Sets the modify date of this photo.
	*
	* @param modifyDate the modify date of this photo
	*/
	@Override
	public void setModifyDate(java.util.Date modifyDate) {
		_photo.setModifyDate(modifyDate);
	}

	/**
	* Returns the order_ of this photo.
	*
	* @return the order_ of this photo
	*/
	@Override
	public int getOrder_() {
		return _photo.getOrder_();
	}

	/**
	* Sets the order_ of this photo.
	*
	* @param order_ the order_ of this photo
	*/
	@Override
	public void setOrder_(int order_) {
		_photo.setOrder_(order_);
	}

	/**
	* Returns the status of this photo.
	*
	* @return the status of this photo
	*/
	@Override
	public boolean getStatus() {
		return _photo.getStatus();
	}

	/**
	* Returns <code>true</code> if this photo is status.
	*
	* @return <code>true</code> if this photo is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _photo.isStatus();
	}

	/**
	* Sets whether this photo is status.
	*
	* @param status the status of this photo
	*/
	@Override
	public void setStatus(boolean status) {
		_photo.setStatus(status);
	}

	/**
	* Returns the user name of this photo.
	*
	* @return the user name of this photo
	*/
	@Override
	public java.lang.String getUserName() {
		return _photo.getUserName();
	}

	/**
	* Sets the user name of this photo.
	*
	* @param userName the user name of this photo
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_photo.setUserName(userName);
	}

	/**
	* Returns the user ID of this photo.
	*
	* @return the user ID of this photo
	*/
	@Override
	public long getUserId() {
		return _photo.getUserId();
	}

	/**
	* Sets the user ID of this photo.
	*
	* @param userId the user ID of this photo
	*/
	@Override
	public void setUserId(long userId) {
		_photo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this photo.
	*
	* @return the user uuid of this photo
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _photo.getUserUuid();
	}

	/**
	* Sets the user uuid of this photo.
	*
	* @param userUuid the user uuid of this photo
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_photo.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this photo.
	*
	* @return the company ID of this photo
	*/
	@Override
	public long getCompanyId() {
		return _photo.getCompanyId();
	}

	/**
	* Sets the company ID of this photo.
	*
	* @param companyId the company ID of this photo
	*/
	@Override
	public void setCompanyId(long companyId) {
		_photo.setCompanyId(companyId);
	}

	/**
	* Returns the category ID of this photo.
	*
	* @return the category ID of this photo
	*/
	@Override
	public long getCategoryId() {
		return _photo.getCategoryId();
	}

	/**
	* Sets the category ID of this photo.
	*
	* @param categoryId the category ID of this photo
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_photo.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this photo.
	*
	* @return the group ID of this photo
	*/
	@Override
	public long getGroupId() {
		return _photo.getGroupId();
	}

	/**
	* Sets the group ID of this photo.
	*
	* @param groupId the group ID of this photo
	*/
	@Override
	public void setGroupId(long groupId) {
		_photo.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _photo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_photo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _photo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_photo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _photo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _photo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_photo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _photo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_photo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_photo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_photo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PhotoWrapper((Photo)_photo.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.photos.model.Photo photo) {
		return _photo.compareTo(photo);
	}

	@Override
	public int hashCode() {
		return _photo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.photos.model.Photo> toCacheModel() {
		return _photo.toCacheModel();
	}

	@Override
	public com.viettel.portal.photos.model.Photo toEscapedModel() {
		return new PhotoWrapper(_photo.toEscapedModel());
	}

	@Override
	public com.viettel.portal.photos.model.Photo toUnescapedModel() {
		return new PhotoWrapper(_photo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _photo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _photo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_photo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhotoWrapper)) {
			return false;
		}

		PhotoWrapper photoWrapper = (PhotoWrapper)obj;

		if (Validator.equals(_photo, photoWrapper._photo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Photo getWrappedPhoto() {
		return _photo;
	}

	@Override
	public Photo getWrappedModel() {
		return _photo;
	}

	@Override
	public void resetOriginalValues() {
		_photo.resetOriginalValues();
	}

	private Photo _photo;
}