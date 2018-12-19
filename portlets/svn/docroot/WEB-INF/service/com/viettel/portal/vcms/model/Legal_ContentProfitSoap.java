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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.Legal_ContentProfitServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.Legal_ContentProfitServiceSoap
 * @generated
 */
public class Legal_ContentProfitSoap implements Serializable {
	public static Legal_ContentProfitSoap toSoapModel(Legal_ContentProfit model) {
		Legal_ContentProfitSoap soapModel = new Legal_ContentProfitSoap();

		soapModel.setContentID(model.getContentID());
		soapModel.setContentTypeID(model.getContentTypeID());
		soapModel.setHeadline(model.getHeadline());
		soapModel.setCost(model.getCost());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDistributedDate(model.getDistributedDate());

		return soapModel;
	}

	public static Legal_ContentProfitSoap[] toSoapModels(
		Legal_ContentProfit[] models) {
		Legal_ContentProfitSoap[] soapModels = new Legal_ContentProfitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Legal_ContentProfitSoap[][] toSoapModels(
		Legal_ContentProfit[][] models) {
		Legal_ContentProfitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Legal_ContentProfitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Legal_ContentProfitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Legal_ContentProfitSoap[] toSoapModels(
		List<Legal_ContentProfit> models) {
		List<Legal_ContentProfitSoap> soapModels = new ArrayList<Legal_ContentProfitSoap>(models.size());

		for (Legal_ContentProfit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Legal_ContentProfitSoap[soapModels.size()]);
	}

	public Legal_ContentProfitSoap() {
	}

	public int getPrimaryKey() {
		return _ContentID;
	}

	public void setPrimaryKey(int pk) {
		setContentID(pk);
	}

	public int getContentID() {
		return _ContentID;
	}

	public void setContentID(int ContentID) {
		_ContentID = ContentID;
	}

	public int getContentTypeID() {
		return _ContentTypeID;
	}

	public void setContentTypeID(int ContentTypeID) {
		_ContentTypeID = ContentTypeID;
	}

	public String getHeadline() {
		return _Headline;
	}

	public void setHeadline(String Headline) {
		_Headline = Headline;
	}

	public double getCost() {
		return _Cost;
	}

	public void setCost(double Cost) {
		_Cost = Cost;
	}

	public String getAuthor() {
		return _Author;
	}

	public void setAuthor(String Author) {
		_Author = Author;
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

	public Date getDistributedDate() {
		return _DistributedDate;
	}

	public void setDistributedDate(Date DistributedDate) {
		_DistributedDate = DistributedDate;
	}

	private int _ContentID;
	private int _ContentTypeID;
	private String _Headline;
	private double _Cost;
	private String _Author;
	private int _Status;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private Date _DistributedDate;
}