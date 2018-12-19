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

package com.viettel.portal.thongke.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.thongke.service.http.ContentTypeCostServiceSoap}.
 *
 * @author lamvn
 * @see com.viettel.portal.thongke.service.http.ContentTypeCostServiceSoap
 * @generated
 */
public class ContentTypeCostSoap implements Serializable {
	public static ContentTypeCostSoap toSoapModel(ContentTypeCost model) {
		ContentTypeCostSoap soapModel = new ContentTypeCostSoap();

		soapModel.setCostId(model.getCostId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setContentTypeID(model.getContentTypeID());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setCost(model.getCost());

		return soapModel;
	}

	public static ContentTypeCostSoap[] toSoapModels(ContentTypeCost[] models) {
		ContentTypeCostSoap[] soapModels = new ContentTypeCostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContentTypeCostSoap[][] toSoapModels(
		ContentTypeCost[][] models) {
		ContentTypeCostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContentTypeCostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContentTypeCostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContentTypeCostSoap[] toSoapModels(
		List<ContentTypeCost> models) {
		List<ContentTypeCostSoap> soapModels = new ArrayList<ContentTypeCostSoap>(models.size());

		for (ContentTypeCost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContentTypeCostSoap[soapModels.size()]);
	}

	public ContentTypeCostSoap() {
	}

	public int getPrimaryKey() {
		return _costId;
	}

	public void setPrimaryKey(int pk) {
		setCostId(pk);
	}

	public int getCostId() {
		return _costId;
	}

	public void setCostId(int costId) {
		_costId = costId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getContentTypeID() {
		return _contentTypeID;
	}

	public void setContentTypeID(int contentTypeID) {
		_contentTypeID = contentTypeID;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public double getCost() {
		return _cost;
	}

	public void setCost(double cost) {
		_cost = cost;
	}

	private int _costId;
	private long _groupId;
	private int _contentTypeID;
	private Date _fromDate;
	private Date _toDate;
	private double _cost;
}