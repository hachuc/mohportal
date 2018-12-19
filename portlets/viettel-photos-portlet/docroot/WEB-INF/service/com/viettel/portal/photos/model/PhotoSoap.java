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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author ChucHV
 * @generated
 */
public class PhotoSoap implements Serializable {
	public static PhotoSoap toSoapModel(Photo model) {
		PhotoSoap soapModel = new PhotoSoap();

		soapModel.setPhotoId(model.getPhotoId());
		soapModel.setCaption(model.getCaption());
		soapModel.setFileId(model.getFileId());
		soapModel.setFileLink(model.getFileLink());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setOrder_(model.getOrder_());
		soapModel.setStatus(model.getStatus());
		soapModel.setUserName(model.getUserName());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static PhotoSoap[] toSoapModels(Photo[] models) {
		PhotoSoap[] soapModels = new PhotoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhotoSoap[][] toSoapModels(Photo[][] models) {
		PhotoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhotoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhotoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhotoSoap[] toSoapModels(List<Photo> models) {
		List<PhotoSoap> soapModels = new ArrayList<PhotoSoap>(models.size());

		for (Photo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhotoSoap[soapModels.size()]);
	}

	public PhotoSoap() {
	}

	public long getPrimaryKey() {
		return _photoId;
	}

	public void setPrimaryKey(long pk) {
		setPhotoId(pk);
	}

	public long getPhotoId() {
		return _photoId;
	}

	public void setPhotoId(long photoId) {
		_photoId = photoId;
	}

	public String getCaption() {
		return _caption;
	}

	public void setCaption(String caption) {
		_caption = caption;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileLink() {
		return _fileLink;
	}

	public void setFileLink(String fileLink) {
		_fileLink = fileLink;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFileSize() {
		return _fileSize;
	}

	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	public int getOrder_() {
		return _order_;
	}

	public void setOrder_(int order_) {
		_order_ = order_;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _photoId;
	private String _caption;
	private long _fileId;
	private String _fileLink;
	private String _fileName;
	private String _fileSize;
	private Date _createDate;
	private Date _modifyDate;
	private int _order_;
	private boolean _status;
	private String _userName;
	private long _userId;
	private long _companyId;
	private long _categoryId;
	private long _groupId;
}