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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.videolibrary.service.http.VLVideoCategoryServiceSoap}.
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.http.VLVideoCategoryServiceSoap
 * @generated
 */
public class VLVideoCategorySoap implements Serializable {
	public static VLVideoCategorySoap toSoapModel(VLVideoCategory model) {
		VLVideoCategorySoap soapModel = new VLVideoCategorySoap();

		soapModel.setId(model.getId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static VLVideoCategorySoap[] toSoapModels(VLVideoCategory[] models) {
		VLVideoCategorySoap[] soapModels = new VLVideoCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VLVideoCategorySoap[][] toSoapModels(
		VLVideoCategory[][] models) {
		VLVideoCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VLVideoCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VLVideoCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VLVideoCategorySoap[] toSoapModels(
		List<VLVideoCategory> models) {
		List<VLVideoCategorySoap> soapModels = new ArrayList<VLVideoCategorySoap>(models.size());

		for (VLVideoCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VLVideoCategorySoap[soapModels.size()]);
	}

	public VLVideoCategorySoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
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

	private long _id;
	private long _categoryId;
	private long _videoId;
	private long _groupId;
}