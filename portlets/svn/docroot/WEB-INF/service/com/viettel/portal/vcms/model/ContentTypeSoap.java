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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.ContentTypeServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.ContentTypeServiceSoap
 * @generated
 */
public class ContentTypeSoap implements Serializable {
	public static ContentTypeSoap toSoapModel(ContentType model) {
		ContentTypeSoap soapModel = new ContentTypeSoap();

		soapModel.setContenTypeId(model.getContenTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setSortOrder(model.getSortOrder());

		return soapModel;
	}

	public static ContentTypeSoap[] toSoapModels(ContentType[] models) {
		ContentTypeSoap[] soapModels = new ContentTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContentTypeSoap[][] toSoapModels(ContentType[][] models) {
		ContentTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContentTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContentTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContentTypeSoap[] toSoapModels(List<ContentType> models) {
		List<ContentTypeSoap> soapModels = new ArrayList<ContentTypeSoap>(models.size());

		for (ContentType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContentTypeSoap[soapModels.size()]);
	}

	public ContentTypeSoap() {
	}

	public long getPrimaryKey() {
		return _contenTypeId;
	}

	public void setPrimaryKey(long pk) {
		setContenTypeId(pk);
	}

	public long getContenTypeId() {
		return _contenTypeId;
	}

	public void setContenTypeId(long contenTypeId) {
		_contenTypeId = contenTypeId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getSortOrder() {
		return _sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		_sortOrder = sortOrder;
	}

	private long _contenTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _name;
	private String _description;
	private int _sortOrder;
}