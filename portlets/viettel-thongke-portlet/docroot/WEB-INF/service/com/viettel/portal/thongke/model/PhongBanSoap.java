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
 * This class is used by SOAP remote services.
 *
 * @author lamvn
 * @generated
 */
public class PhongBanSoap implements Serializable {
	public static PhongBanSoap toSoapModel(PhongBan model) {
		PhongBanSoap soapModel = new PhongBanSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setOrder_(model.getOrder_());
		soapModel.setDescriptions(model.getDescriptions());
		soapModel.setStatus(model.getStatus());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setUserName(model.getUserName());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static PhongBanSoap[] toSoapModels(PhongBan[] models) {
		PhongBanSoap[] soapModels = new PhongBanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhongBanSoap[][] toSoapModels(PhongBan[][] models) {
		PhongBanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhongBanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhongBanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhongBanSoap[] toSoapModels(List<PhongBan> models) {
		List<PhongBanSoap> soapModels = new ArrayList<PhongBanSoap>(models.size());

		for (PhongBan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhongBanSoap[soapModels.size()]);
	}

	public PhongBanSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getOrder_() {
		return _order_;
	}

	public void setOrder_(int order_) {
		_order_ = order_;
	}

	public String getDescriptions() {
		return _descriptions;
	}

	public void setDescriptions(String descriptions) {
		_descriptions = descriptions;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _id;
	private String _name;
	private int _order_;
	private String _descriptions;
	private boolean _status;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifyDate;
	private String _userName;
	private long _userId;
}