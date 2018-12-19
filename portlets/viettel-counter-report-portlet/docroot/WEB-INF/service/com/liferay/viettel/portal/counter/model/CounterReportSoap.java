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

package com.liferay.viettel.portal.counter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.viettel.portal.counter.service.http.CounterReportServiceSoap}.
 *
 * @author chuchv
 * @see com.liferay.viettel.portal.counter.service.http.CounterReportServiceSoap
 * @generated
 */
public class CounterReportSoap implements Serializable {
	public static CounterReportSoap toSoapModel(CounterReport model) {
		CounterReportSoap soapModel = new CounterReportSoap();

		soapModel.setReportId(model.getReportId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static CounterReportSoap[] toSoapModels(CounterReport[] models) {
		CounterReportSoap[] soapModels = new CounterReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CounterReportSoap[][] toSoapModels(CounterReport[][] models) {
		CounterReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CounterReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CounterReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CounterReportSoap[] toSoapModels(List<CounterReport> models) {
		List<CounterReportSoap> soapModels = new ArrayList<CounterReportSoap>(models.size());

		for (CounterReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CounterReportSoap[soapModels.size()]);
	}

	public CounterReportSoap() {
	}

	public long getPrimaryKey() {
		return _reportId;
	}

	public void setPrimaryKey(long pk) {
		setReportId(pk);
	}

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
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

	private long _reportId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}