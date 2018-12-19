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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.magazine.service.http.MagazineZoneServiceSoap}.
 *
 * @author namtv
 * @see com.viettel.portal.magazine.service.http.MagazineZoneServiceSoap
 * @generated
 */
public class MagazineZoneSoap implements Serializable {
	public static MagazineZoneSoap toSoapModel(MagazineZone model) {
		MagazineZoneSoap soapModel = new MagazineZoneSoap();

		soapModel.setID(model.getID());
		soapModel.setName(model.getName());
		soapModel.setMagazineID(model.getMagazineID());
		soapModel.setSortOrder(model.getSortOrder());

		return soapModel;
	}

	public static MagazineZoneSoap[] toSoapModels(MagazineZone[] models) {
		MagazineZoneSoap[] soapModels = new MagazineZoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MagazineZoneSoap[][] toSoapModels(MagazineZone[][] models) {
		MagazineZoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MagazineZoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MagazineZoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MagazineZoneSoap[] toSoapModels(List<MagazineZone> models) {
		List<MagazineZoneSoap> soapModels = new ArrayList<MagazineZoneSoap>(models.size());

		for (MagazineZone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MagazineZoneSoap[soapModels.size()]);
	}

	public MagazineZoneSoap() {
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

	public int getMagazineID() {
		return _MagazineID;
	}

	public void setMagazineID(int MagazineID) {
		_MagazineID = MagazineID;
	}

	public int getSortOrder() {
		return _SortOrder;
	}

	public void setSortOrder(int SortOrder) {
		_SortOrder = SortOrder;
	}

	private int _ID;
	private String _Name;
	private int _MagazineID;
	private int _SortOrder;
}