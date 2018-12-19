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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.ContentProfitServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.ContentProfitServiceSoap
 * @generated
 */
public class ContentProfitSoap implements Serializable {
	public static ContentProfitSoap toSoapModel(ContentProfit model) {
		ContentProfitSoap soapModel = new ContentProfitSoap();

		soapModel.setContentId(model.getContentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDistributedDate(model.getDistributedDate());
		soapModel.setContentTypeID(model.getContentTypeID());
		soapModel.setHeadline(model.getHeadline());
		soapModel.setCost(model.getCost());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ContentProfitSoap[] toSoapModels(ContentProfit[] models) {
		ContentProfitSoap[] soapModels = new ContentProfitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContentProfitSoap[][] toSoapModels(ContentProfit[][] models) {
		ContentProfitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContentProfitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContentProfitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContentProfitSoap[] toSoapModels(List<ContentProfit> models) {
		List<ContentProfitSoap> soapModels = new ArrayList<ContentProfitSoap>(models.size());

		for (ContentProfit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContentProfitSoap[soapModels.size()]);
	}

	public ContentProfitSoap() {
	}

	public long getPrimaryKey() {
		return _contentId;
	}

	public void setPrimaryKey(long pk) {
		setContentId(pk);
	}

	public long getContentId() {
		return _contentId;
	}

	public void setContentId(long contentId) {
		_contentId = contentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getDistributedDate() {
		return _distributedDate;
	}

	public void setDistributedDate(Date distributedDate) {
		_distributedDate = distributedDate;
	}

	public int getContentTypeID() {
		return _contentTypeID;
	}

	public void setContentTypeID(int contentTypeID) {
		_contentTypeID = contentTypeID;
	}

	public String getHeadline() {
		return _headline;
	}

	public void setHeadline(String headline) {
		_headline = headline;
	}

	public double getCost() {
		return _cost;
	}

	public void setCost(double cost) {
		_cost = cost;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _contentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _distributedDate;
	private int _contentTypeID;
	private String _headline;
	private double _cost;
	private int _status;
}