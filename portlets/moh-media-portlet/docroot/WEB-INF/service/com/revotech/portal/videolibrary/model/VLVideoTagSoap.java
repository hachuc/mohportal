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

package com.revotech.portal.videolibrary.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.revotech.portal.videolibrary.service.http.VLVideoTagServiceSoap}.
 *
 * @author ChucHV
 * @see com.revotech.portal.videolibrary.service.http.VLVideoTagServiceSoap
 * @generated
 */
public class VLVideoTagSoap implements Serializable {
	public static VLVideoTagSoap toSoapModel(VLVideoTag model) {
		VLVideoTagSoap soapModel = new VLVideoTagSoap();

		soapModel.setId(model.getId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setTagId(model.getTagId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static VLVideoTagSoap[] toSoapModels(VLVideoTag[] models) {
		VLVideoTagSoap[] soapModels = new VLVideoTagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VLVideoTagSoap[][] toSoapModels(VLVideoTag[][] models) {
		VLVideoTagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VLVideoTagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VLVideoTagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VLVideoTagSoap[] toSoapModels(List<VLVideoTag> models) {
		List<VLVideoTagSoap> soapModels = new ArrayList<VLVideoTagSoap>(models.size());

		for (VLVideoTag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VLVideoTagSoap[soapModels.size()]);
	}

	public VLVideoTagSoap() {
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

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _id;
	private long _videoId;
	private long _tagId;
	private long _groupId;
}