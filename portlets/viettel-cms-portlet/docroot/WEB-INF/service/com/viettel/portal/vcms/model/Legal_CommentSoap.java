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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.Legal_CommentServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.Legal_CommentServiceSoap
 * @generated
 */
public class Legal_CommentSoap implements Serializable {
	public static Legal_CommentSoap toSoapModel(Legal_Comment model) {
		Legal_CommentSoap soapModel = new Legal_CommentSoap();

		soapModel.setID(model.getID());
		soapModel.setDistributionID(model.getDistributionID());
		soapModel.setFullname(model.getFullname());
		soapModel.setAddress(model.getAddress());
		soapModel.setEmail(model.getEmail());
		soapModel.setBody(model.getBody());
		soapModel.setVisible(model.getVisible());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIPAddress(model.getIPAddress());

		return soapModel;
	}

	public static Legal_CommentSoap[] toSoapModels(Legal_Comment[] models) {
		Legal_CommentSoap[] soapModels = new Legal_CommentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Legal_CommentSoap[][] toSoapModels(Legal_Comment[][] models) {
		Legal_CommentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Legal_CommentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Legal_CommentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Legal_CommentSoap[] toSoapModels(List<Legal_Comment> models) {
		List<Legal_CommentSoap> soapModels = new ArrayList<Legal_CommentSoap>(models.size());

		for (Legal_Comment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Legal_CommentSoap[soapModels.size()]);
	}

	public Legal_CommentSoap() {
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

	public int getDistributionID() {
		return _DistributionID;
	}

	public void setDistributionID(int DistributionID) {
		_DistributionID = DistributionID;
	}

	public String getFullname() {
		return _Fullname;
	}

	public void setFullname(String Fullname) {
		_Fullname = Fullname;
	}

	public String getAddress() {
		return _Address;
	}

	public void setAddress(String Address) {
		_Address = Address;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getBody() {
		return _Body;
	}

	public void setBody(String Body) {
		_Body = Body;
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

	public String getIPAddress() {
		return _IPAddress;
	}

	public void setIPAddress(String IPAddress) {
		_IPAddress = IPAddress;
	}

	private int _ID;
	private int _DistributionID;
	private String _Fullname;
	private String _Address;
	private String _Email;
	private String _Body;
	private boolean _Visible;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private String _IPAddress;
}