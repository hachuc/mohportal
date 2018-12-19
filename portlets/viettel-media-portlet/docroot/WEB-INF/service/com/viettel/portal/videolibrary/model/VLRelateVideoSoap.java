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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.videolibrary.service.http.VLRelateVideoServiceSoap}.
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.http.VLRelateVideoServiceSoap
 * @generated
 */
public class VLRelateVideoSoap implements Serializable {
	public static VLRelateVideoSoap toSoapModel(VLRelateVideo model) {
		VLRelateVideoSoap soapModel = new VLRelateVideoSoap();

		soapModel.setId(model.getId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setRelateId(model.getRelateId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static VLRelateVideoSoap[] toSoapModels(VLRelateVideo[] models) {
		VLRelateVideoSoap[] soapModels = new VLRelateVideoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VLRelateVideoSoap[][] toSoapModels(VLRelateVideo[][] models) {
		VLRelateVideoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VLRelateVideoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VLRelateVideoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VLRelateVideoSoap[] toSoapModels(List<VLRelateVideo> models) {
		List<VLRelateVideoSoap> soapModels = new ArrayList<VLRelateVideoSoap>(models.size());

		for (VLRelateVideo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VLRelateVideoSoap[soapModels.size()]);
	}

	public VLRelateVideoSoap() {
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

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getRelateId() {
		return _relateId;
	}

	public void setRelateId(long relateId) {
		_relateId = relateId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _id;
	private long _videoId;
	private long _relateId;
	private long _groupId;
}