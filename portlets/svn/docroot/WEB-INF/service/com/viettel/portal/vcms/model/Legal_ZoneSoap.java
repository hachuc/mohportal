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

package com.viettel.portal.vcms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.Legal_ZoneServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.Legal_ZoneServiceSoap
 * @generated
 */
public class Legal_ZoneSoap implements Serializable {
	public static Legal_ZoneSoap toSoapModel(Legal_Zone model) {
		Legal_ZoneSoap soapModel = new Legal_ZoneSoap();

		soapModel.setID(model.getID());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());
		soapModel.setDescription(model.getDescription());
		soapModel.setParentID(model.getParentID());
		soapModel.setRealUrl(model.getRealUrl());
		soapModel.setVisible(model.getVisible());
		soapModel.setArchived(model.getArchived());
		soapModel.setSortOrder(model.getSortOrder());

		return soapModel;
	}

	public static Legal_ZoneSoap[] toSoapModels(Legal_Zone[] models) {
		Legal_ZoneSoap[] soapModels = new Legal_ZoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Legal_ZoneSoap[][] toSoapModels(Legal_Zone[][] models) {
		Legal_ZoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Legal_ZoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Legal_ZoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Legal_ZoneSoap[] toSoapModels(List<Legal_Zone> models) {
		List<Legal_ZoneSoap> soapModels = new ArrayList<Legal_ZoneSoap>(models.size());

		for (Legal_Zone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Legal_ZoneSoap[soapModels.size()]);
	}

	public Legal_ZoneSoap() {
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

	public String getDescription() {
		return _Description;
	}

	public void setDescription(String Description) {
		_Description = Description;
	}

	public int getParentID() {
		return _ParentID;
	}

	public void setParentID(int ParentID) {
		_ParentID = ParentID;
	}

	public String getRealUrl() {
		return _RealUrl;
	}

	public void setRealUrl(String RealUrl) {
		_RealUrl = RealUrl;
	}

	public boolean getVisible() {
		return _Visible;
	}

	public boolean isVisible() {
		return _Visible;
	}

	public void setVisible(boolean Visible) {
		_Visible = Visible;
	}

	public boolean getArchived() {
		return _Archived;
	}

	public boolean isArchived() {
		return _Archived;
	}

	public void setArchived(boolean Archived) {
		_Archived = Archived;
	}

	public int getSortOrder() {
		return _SortOrder;
	}

	public void setSortOrder(int SortOrder) {
		_SortOrder = SortOrder;
	}

	private int _ID;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private String _Name;
	private String _Url;
	private String _Description;
	private int _ParentID;
	private String _RealUrl;
	private boolean _Visible;
	private boolean _Archived;
	private int _SortOrder;
}