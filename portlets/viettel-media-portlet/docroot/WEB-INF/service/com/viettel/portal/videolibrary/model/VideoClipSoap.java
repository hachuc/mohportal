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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.videolibrary.service.http.VideoClipServiceSoap}.
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.http.VideoClipServiceSoap
 * @generated
 */
public class VideoClipSoap implements Serializable {
	public static VideoClipSoap toSoapModel(VideoClip model) {
		VideoClipSoap soapModel = new VideoClipSoap();

		soapModel.setID(model.getID());
		soapModel.setName(model.getName());
		soapModel.setCategoryID(model.getCategoryID());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setVideoUrl(model.getVideoUrl());
		soapModel.setDuration(model.getDuration());
		soapModel.setViewCount(model.getViewCount());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static VideoClipSoap[] toSoapModels(VideoClip[] models) {
		VideoClipSoap[] soapModels = new VideoClipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoClipSoap[][] toSoapModels(VideoClip[][] models) {
		VideoClipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoClipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoClipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoClipSoap[] toSoapModels(List<VideoClip> models) {
		List<VideoClipSoap> soapModels = new ArrayList<VideoClipSoap>(models.size());

		for (VideoClip model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoClipSoap[soapModels.size()]);
	}

	public VideoClipSoap() {
	}

	public int getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(int pk) {
		setID(pk);
	}

	public int getID() {
		return _ID;
	}

	public void setID(int ID) {
		_ID = ID;
	}

	public String getName() {
		return _Name;
	}

	public void setName(String Name) {
		_Name = Name;
	}

	public int getCategoryID() {
		return _CategoryID;
	}

	public void setCategoryID(int CategoryID) {
		_CategoryID = CategoryID;
	}

	public String getDescription() {
		return _Description;
	}

	public void setDescription(String Description) {
		_Description = Description;
	}

	public String getImageUrl() {
		return _ImageUrl;
	}

	public void setImageUrl(String ImageUrl) {
		_ImageUrl = ImageUrl;
	}

	public String getVideoUrl() {
		return _VideoUrl;
	}

	public void setVideoUrl(String VideoUrl) {
		_VideoUrl = VideoUrl;
	}

	public int getDuration() {
		return _Duration;
	}

	public void setDuration(int Duration) {
		_Duration = Duration;
	}

	public int getViewCount() {
		return _ViewCount;
	}

	public void setViewCount(int ViewCount) {
		_ViewCount = ViewCount;
	}

	public int getStatus() {
		return _Status;
	}

	public void setStatus(int Status) {
		_Status = Status;
	}

	public Date getCreationDate() {
		return _CreationDate;
	}

	public void setCreationDate(Date CreationDate) {
		_CreationDate = CreationDate;
	}

	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;
	}

	private int _ID;
	private String _Name;
	private int _CategoryID;
	private String _Description;
	private String _ImageUrl;
	private String _VideoUrl;
	private int _Duration;
	private int _ViewCount;
	private int _Status;
	private Date _CreationDate;
	private Date _ModifiedDate;
}