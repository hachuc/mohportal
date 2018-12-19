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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.DistributionServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.DistributionServiceSoap
 * @generated
 */
public class DistributionSoap implements Serializable {
	public static DistributionSoap toSoapModel(Distribution model) {
		DistributionSoap soapModel = new DistributionSoap();

		soapModel.setDistributionId(model.getDistributionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVersion(model.getVersion());
		soapModel.setContentId(model.getContentId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setDistributedDate(model.getDistributedDate());
		soapModel.setAllowDiscussion(model.getAllowDiscussion());
		soapModel.setTitle(model.getTitle());

		return soapModel;
	}

	public static DistributionSoap[] toSoapModels(Distribution[] models) {
		DistributionSoap[] soapModels = new DistributionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DistributionSoap[][] toSoapModels(Distribution[][] models) {
		DistributionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DistributionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DistributionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DistributionSoap[] toSoapModels(List<Distribution> models) {
		List<DistributionSoap> soapModels = new ArrayList<DistributionSoap>(models.size());

		for (Distribution model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DistributionSoap[soapModels.size()]);
	}

	public DistributionSoap() {
	}

	public long getPrimaryKey() {
		return _distributionId;
	}

	public void setPrimaryKey(long pk) {
		setDistributionId(pk);
	}

	public long getDistributionId() {
		return _distributionId;
	}

	public void setDistributionId(long distributionId) {
		_distributionId = distributionId;
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

	public int getVersion() {
		return _version;
	}

	public void setVersion(int version) {
		_version = version;
	}

	public long getContentId() {
		return _contentId;
	}

	public void setContentId(long contentId) {
		_contentId = contentId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public Date getDistributedDate() {
		return _distributedDate;
	}

	public void setDistributedDate(Date distributedDate) {
		_distributedDate = distributedDate;
	}

	public boolean getAllowDiscussion() {
		return _allowDiscussion;
	}

	public boolean isAllowDiscussion() {
		return _allowDiscussion;
	}

	public void setAllowDiscussion(boolean allowDiscussion) {
		_allowDiscussion = allowDiscussion;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private long _distributionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _version;
	private long _contentId;
	private long _categoryId;
	private Date _distributedDate;
	private boolean _allowDiscussion;
	private String _title;
}