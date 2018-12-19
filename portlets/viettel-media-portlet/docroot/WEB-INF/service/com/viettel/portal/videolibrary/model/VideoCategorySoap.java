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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.videolibrary.service.http.VideoCategoryServiceSoap}.
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.http.VideoCategoryServiceSoap
 * @generated
 */
public class VideoCategorySoap implements Serializable {
	public static VideoCategorySoap toSoapModel(VideoCategory model) {
		VideoCategorySoap soapModel = new VideoCategorySoap();

		soapModel.setID(model.getID());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());
		soapModel.setSortOrder(model.getSortOrder());
		soapModel.setItemCount(model.getItemCount());

		return soapModel;
	}

	public static VideoCategorySoap[] toSoapModels(VideoCategory[] models) {
		VideoCategorySoap[] soapModels = new VideoCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoCategorySoap[][] toSoapModels(VideoCategory[][] models) {
		VideoCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoCategorySoap[] toSoapModels(List<VideoCategory> models) {
		List<VideoCategorySoap> soapModels = new ArrayList<VideoCategorySoap>(models.size());

		for (VideoCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoCategorySoap[soapModels.size()]);
	}

	public VideoCategorySoap() {
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

	public String getUrl() {
		return _Url;
	}

	public void setUrl(String Url) {
		_Url = Url;
	}

	public int getSortOrder() {
		return _SortOrder;
	}

	public void setSortOrder(int SortOrder) {
		_SortOrder = SortOrder;
	}

	public int getItemCount() {
		return _ItemCount;
	}

	public void setItemCount(int ItemCount) {
		_ItemCount = ItemCount;
	}

	private int _ID;
	private String _Name;
	private String _Url;
	private int _SortOrder;
	private int _ItemCount;
}