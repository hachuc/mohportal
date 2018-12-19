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

package com.revotech.portal.tthc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.revotech.portal.tthc.service.http.LegalDocumentServiceSoap}.
 *
 * @author hieptran
 * @see com.revotech.portal.tthc.service.http.LegalDocumentServiceSoap
 * @generated
 */
public class LegalDocumentSoap implements Serializable {
	public static LegalDocumentSoap toSoapModel(LegalDocument model) {
		LegalDocumentSoap soapModel = new LegalDocumentSoap();

		soapModel.setLdId(model.getLdId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLdCode(model.getLdCode());
		soapModel.setLdTitle(model.getLdTitle());
		soapModel.setLdLink(model.getLdLink());
		soapModel.setLdLevel3Link(model.getLdLevel3Link());
		soapModel.setLdSubcontent(model.getLdSubcontent());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setIdLinhvuc(model.getIdLinhvuc());
		soapModel.setIdCoquanbanhanh(model.getIdCoquanbanhanh());
		soapModel.setLdDonvithuchien(model.getLdDonvithuchien());
		soapModel.setLdLevel(model.getLdLevel());

		return soapModel;
	}

	public static LegalDocumentSoap[] toSoapModels(LegalDocument[] models) {
		LegalDocumentSoap[] soapModels = new LegalDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalDocumentSoap[][] toSoapModels(LegalDocument[][] models) {
		LegalDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalDocumentSoap[] toSoapModels(List<LegalDocument> models) {
		List<LegalDocumentSoap> soapModels = new ArrayList<LegalDocumentSoap>(models.size());

		for (LegalDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalDocumentSoap[soapModels.size()]);
	}

	public LegalDocumentSoap() {
	}

	public long getPrimaryKey() {
		return _ldId;
	}

	public void setPrimaryKey(long pk) {
		setLdId(pk);
	}

	public long getLdId() {
		return _ldId;
	}

	public void setLdId(long ldId) {
		_ldId = ldId;
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

	public String getLdCode() {
		return _ldCode;
	}

	public void setLdCode(String ldCode) {
		_ldCode = ldCode;
	}

	public String getLdTitle() {
		return _ldTitle;
	}

	public void setLdTitle(String ldTitle) {
		_ldTitle = ldTitle;
	}

	public String getLdLink() {
		return _ldLink;
	}

	public void setLdLink(String ldLink) {
		_ldLink = ldLink;
	}

	public String getLdLevel3Link() {
		return _ldLevel3Link;
	}

	public void setLdLevel3Link(String ldLevel3Link) {
		_ldLevel3Link = ldLevel3Link;
	}

	public String getLdSubcontent() {
		return _ldSubcontent;
	}

	public void setLdSubcontent(String ldSubcontent) {
		_ldSubcontent = ldSubcontent;
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

	public long getIdLinhvuc() {
		return _idLinhvuc;
	}

	public void setIdLinhvuc(long idLinhvuc) {
		_idLinhvuc = idLinhvuc;
	}

	public long getIdCoquanbanhanh() {
		return _idCoquanbanhanh;
	}

	public void setIdCoquanbanhanh(long idCoquanbanhanh) {
		_idCoquanbanhanh = idCoquanbanhanh;
	}

	public String getLdDonvithuchien() {
		return _ldDonvithuchien;
	}

	public void setLdDonvithuchien(String ldDonvithuchien) {
		_ldDonvithuchien = ldDonvithuchien;
	}

	public int getLdLevel() {
		return _ldLevel;
	}

	public void setLdLevel(int ldLevel) {
		_ldLevel = ldLevel;
	}

	private long _ldId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ldCode;
	private String _ldTitle;
	private String _ldLink;
	private String _ldLevel3Link;
	private String _ldSubcontent;
	private boolean _isActive;
	private long _idLinhvuc;
	private long _idCoquanbanhanh;
	private String _ldDonvithuchien;
	private int _ldLevel;
}