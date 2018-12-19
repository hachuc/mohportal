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

import com.viettel.portal.vcms.service.persistence.NotesPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.NotesServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.NotesServiceSoap
 * @generated
 */
public class NotesSoap implements Serializable {
	public static NotesSoap toSoapModel(Notes model) {
		NotesSoap soapModel = new NotesSoap();

		soapModel.setContentID(model.getContentID());
		soapModel.setVersion(model.getVersion());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static NotesSoap[] toSoapModels(Notes[] models) {
		NotesSoap[] soapModels = new NotesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotesSoap[][] toSoapModels(Notes[][] models) {
		NotesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotesSoap[] toSoapModels(List<Notes> models) {
		List<NotesSoap> soapModels = new ArrayList<NotesSoap>(models.size());

		for (Notes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotesSoap[soapModels.size()]);
	}

	public NotesSoap() {
	}

	public NotesPK getPrimaryKey() {
		return new NotesPK(_ContentID, _Version);
	}

	public void setPrimaryKey(NotesPK pk) {
		setContentID(pk.ContentID);
		setVersion(pk.Version);
	}

	public long getContentID() {
		return _ContentID;
	}

	public void setContentID(long ContentID) {
		_ContentID = ContentID;
	}

	public int getVersion() {
		return _Version;
	}

	public void setVersion(int Version) {
		_Version = Version;
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

	public String getContent() {
		return _Content;
	}

	public void setContent(String Content) {
		_Content = Content;
	}

	private long _ContentID;
	private int _Version;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _Content;
}