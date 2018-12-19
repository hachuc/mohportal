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

package com.viettel.portal.magazine.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.magazine.service.http.MagazineServiceSoap}.
 *
 * @author namtv
 * @see com.viettel.portal.magazine.service.http.MagazineServiceSoap
 * @generated
 */
public class MagazineSoap implements Serializable {
	public static MagazineSoap toSoapModel(Magazine model) {
		MagazineSoap soapModel = new MagazineSoap();

		soapModel.setID(model.getID());
		soapModel.setName(model.getName());
		soapModel.setPublishNumber(model.getPublishNumber());
		soapModel.setPublishYear(model.getPublishYear());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setImageID(model.getImageID());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDistributedDate(model.getDistributedDate());

		return soapModel;
	}

	public static MagazineSoap[] toSoapModels(Magazine[] models) {
		MagazineSoap[] soapModels = new MagazineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MagazineSoap[][] toSoapModels(Magazine[][] models) {
		MagazineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MagazineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MagazineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MagazineSoap[] toSoapModels(List<Magazine> models) {
		List<MagazineSoap> soapModels = new ArrayList<MagazineSoap>(models.size());

		for (Magazine model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MagazineSoap[soapModels.size()]);
	}

	public MagazineSoap() {
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

	public int getPublishNumber() {
		return _PublishNumber;
	}

	public void setPublishNumber(int PublishNumber) {
		_PublishNumber = PublishNumber;
	}

	public int getPublishYear() {
		return _PublishYear;
	}

	public void setPublishYear(int PublishYear) {
		_PublishYear = PublishYear;
	}

	public String getImageUrl() {
		return _ImageUrl;
	}

	public void setImageUrl(String ImageUrl) {
		_ImageUrl = ImageUrl;
	}

	public long getImageID() {
		return _ImageID;
	}

	public void setImageID(long ImageID) {
		_ImageID = ImageID;
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

	public Date getDistributedDate() {
		return _DistributedDate;
	}

	public void setDistributedDate(Date DistributedDate) {
		_DistributedDate = DistributedDate;
	}

	private int _ID;
	private String _Name;
	private int _PublishNumber;
	private int _PublishYear;
	private String _ImageUrl;
	private long _ImageID;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private Date _DistributedDate;
}