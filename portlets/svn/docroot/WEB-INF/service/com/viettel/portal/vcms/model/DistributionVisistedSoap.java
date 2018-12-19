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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.DistributionVisistedServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.DistributionVisistedServiceSoap
 * @generated
 */
public class DistributionVisistedSoap implements Serializable {
	public static DistributionVisistedSoap toSoapModel(
		DistributionVisisted model) {
		DistributionVisistedSoap soapModel = new DistributionVisistedSoap();

		soapModel.setVisistedId(model.getVisistedId());
		soapModel.setDistributionId(model.getDistributionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static DistributionVisistedSoap[] toSoapModels(
		DistributionVisisted[] models) {
		DistributionVisistedSoap[] soapModels = new DistributionVisistedSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DistributionVisistedSoap[][] toSoapModels(
		DistributionVisisted[][] models) {
		DistributionVisistedSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DistributionVisistedSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DistributionVisistedSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DistributionVisistedSoap[] toSoapModels(
		List<DistributionVisisted> models) {
		List<DistributionVisistedSoap> soapModels = new ArrayList<DistributionVisistedSoap>(models.size());

		for (DistributionVisisted model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DistributionVisistedSoap[soapModels.size()]);
	}

	public DistributionVisistedSoap() {
	}

	public long getPrimaryKey() {
		return _visistedId;
	}

	public void setPrimaryKey(long pk) {
		setVisistedId(pk);
	}

	public long getVisistedId() {
		return _visistedId;
	}

	public void setVisistedId(long visistedId) {
		_visistedId = visistedId;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _visistedId;
	private long _distributionId;
	private long _groupId;
	private Date _createDate;
}