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

package com.viettel.portal.videolibrary.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.videolibrary.service.http.VLVideoServiceSoap}.
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.http.VLVideoServiceSoap
 * @generated
 */
public class VLVideoSoap implements Serializable {
	public static VLVideoSoap toSoapModel(VLVideo model) {
		VLVideoSoap soapModel = new VLVideoSoap();

		soapModel.setVideoId(model.getVideoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVideoName(model.getVideoName());
		soapModel.setDescription(model.getDescription());
		soapModel.setVideoType(model.getVideoType());
		soapModel.setVideoUrl(model.getVideoUrl());
		soapModel.setViewCount(model.getViewCount());
		soapModel.setFileId(model.getFileId());
		soapModel.setImage(model.getImage());
		soapModel.setImageId(model.getImageId());
		soapModel.setSmallImageUrl(model.getSmallImageUrl());
		soapModel.setRelateId(model.getRelateId());
		soapModel.setInvisible(model.getInvisible());
		soapModel.setCategoryId(model.getCategoryId());

		return soapModel;
	}

	public static VLVideoSoap[] toSoapModels(VLVideo[] models) {
		VLVideoSoap[] soapModels = new VLVideoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VLVideoSoap[][] toSoapModels(VLVideo[][] models) {
		VLVideoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VLVideoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VLVideoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VLVideoSoap[] toSoapModels(List<VLVideo> models) {
		List<VLVideoSoap> soapModels = new ArrayList<VLVideoSoap>(models.size());

		for (VLVideo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VLVideoSoap[soapModels.size()]);
	}

	public VLVideoSoap() {
	}

	public long getPrimaryKey() {
		return _videoId;
	}

	public void setPrimaryKey(long pk) {
		setVideoId(pk);
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getVideoName() {
		return _videoName;
	}

	public void setVideoName(String videoName) {
		_videoName = videoName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getVideoType() {
		return _videoType;
	}

	public void setVideoType(String videoType) {
		_videoType = videoType;
	}

	public String getVideoUrl() {
		return _videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		_videoUrl = videoUrl;
	}

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public boolean getImage() {
		return _image;
	}

	public boolean isImage() {
		return _image;
	}

	public void setImage(boolean image) {
		_image = image;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getSmallImageUrl() {
		return _smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		_smallImageUrl = smallImageUrl;
	}

	public long getRelateId() {
		return _relateId;
	}

	public void setRelateId(long relateId) {
		_relateId = relateId;
	}

	public boolean getInvisible() {
		return _invisible;
	}

	public boolean isInvisible() {
		return _invisible;
	}

	public void setInvisible(boolean invisible) {
		_invisible = invisible;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	private long _videoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _videoName;
	private String _description;
	private String _videoType;
	private String _videoUrl;
	private int _viewCount;
	private long _fileId;
	private boolean _image;
	private long _imageId;
	private String _smallImageUrl;
	private long _relateId;
	private boolean _invisible;
	private long _categoryId;
}