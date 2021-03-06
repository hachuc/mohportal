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

package com.viettel.portal.links.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.links.service.http.VLinkServiceSoap}.
 *
 * @author ChucHV
 * @see com.viettel.portal.links.service.http.VLinkServiceSoap
 * @generated
 */
public class VLinkSoap implements Serializable {
	public static VLinkSoap toSoapModel(VLink model) {
		VLinkSoap soapModel = new VLinkSoap();

		soapModel.setLinkId(model.getLinkId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLinkName(model.getLinkName());
		soapModel.setUrl(model.getUrl());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setCorder(model.getCorder());
		soapModel.setCategoryId(model.getCategoryId());

		return soapModel;
	}

	public static VLinkSoap[] toSoapModels(VLink[] models) {
		VLinkSoap[] soapModels = new VLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VLinkSoap[][] toSoapModels(VLink[][] models) {
		VLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VLinkSoap[] toSoapModels(List<VLink> models) {
		List<VLinkSoap> soapModels = new ArrayList<VLinkSoap>(models.size());

		for (VLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VLinkSoap[soapModels.size()]);
	}

	public VLinkSoap() {
	}

	public long getPrimaryKey() {
		return _linkId;
	}

	public void setPrimaryKey(long pk) {
		setLinkId(pk);
	}

	public long getLinkId() {
		return _linkId;
	}

	public void setLinkId(long linkId) {
		_linkId = linkId;
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

	public String getLinkName() {
		return _linkName;
	}

	public void setLinkName(String linkName) {
		_linkName = linkName;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public int getCorder() {
		return _corder;
	}

	public void setCorder(int corder) {
		_corder = corder;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	private long _linkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _linkName;
	private String _url;
	private boolean _isActive;
	private int _corder;
	private long _categoryId;
}