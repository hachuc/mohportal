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

package com.liferay.viettel.portal.visitcounter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.viettel.portal.visitcounter.service.http.VisitCounterServiceSoap}.
 *
 * @author hiepth6
 * @see com.liferay.viettel.portal.visitcounter.service.http.VisitCounterServiceSoap
 * @generated
 */
public class VisitCounterSoap implements Serializable {
	public static VisitCounterSoap toSoapModel(VisitCounter model) {
		VisitCounterSoap soapModel = new VisitCounterSoap();

		soapModel.setCounterId(model.getCounterId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTotalHitCounter(model.getTotalHitCounter());

		return soapModel;
	}

	public static VisitCounterSoap[] toSoapModels(VisitCounter[] models) {
		VisitCounterSoap[] soapModels = new VisitCounterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VisitCounterSoap[][] toSoapModels(VisitCounter[][] models) {
		VisitCounterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VisitCounterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VisitCounterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VisitCounterSoap[] toSoapModels(List<VisitCounter> models) {
		List<VisitCounterSoap> soapModels = new ArrayList<VisitCounterSoap>(models.size());

		for (VisitCounter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VisitCounterSoap[soapModels.size()]);
	}

	public VisitCounterSoap() {
	}

	public long getPrimaryKey() {
		return _counterId;
	}

	public void setPrimaryKey(long pk) {
		setCounterId(pk);
	}

	public long getCounterId() {
		return _counterId;
	}

	public void setCounterId(long counterId) {
		_counterId = counterId;
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

	public int getTotalHitCounter() {
		return _totalHitCounter;
	}

	public void setTotalHitCounter(int totalHitCounter) {
		_totalHitCounter = totalHitCounter;
	}

	private long _counterId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _totalHitCounter;
}