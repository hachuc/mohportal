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

package com.revotech.portal.videolibrary.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.revotech.portal.videolibrary.service.http.VLCategoryServiceSoap}.
 *
 * @author ChucHV
 * @see com.revotech.portal.videolibrary.service.http.VLCategoryServiceSoap
 * @generated
 */
public class VLCategorySoap implements Serializable {
	public static VLCategorySoap toSoapModel(VLCategory model) {
		VLCategorySoap soapModel = new VLCategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setInvisible(model.getInvisible());

		return soapModel;
	}

	public static VLCategorySoap[] toSoapModels(VLCategory[] models) {
		VLCategorySoap[] soapModels = new VLCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VLCategorySoap[][] toSoapModels(VLCategory[][] models) {
		VLCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VLCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VLCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VLCategorySoap[] toSoapModels(List<VLCategory> models) {
		List<VLCategorySoap> soapModels = new ArrayList<VLCategorySoap>(models.size());

		for (VLCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VLCategorySoap[soapModels.size()]);
	}

	public VLCategorySoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
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

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	public boolean getInvisible() {
		return _invisible;
	}

	public boolean isInvisible() {
		return _invisible;
	}

	public void setInvisible(boolean invisible) {
		_invisible = invisible;
	}

	private long _categoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _categoryName;
	private boolean _invisible;
}