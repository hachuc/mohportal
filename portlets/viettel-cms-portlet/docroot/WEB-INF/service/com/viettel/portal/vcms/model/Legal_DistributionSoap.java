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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.Legal_DistributionServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.Legal_DistributionServiceSoap
 * @generated
 */
public class Legal_DistributionSoap implements Serializable {
	public static Legal_DistributionSoap toSoapModel(Legal_Distribution model) {
		Legal_DistributionSoap soapModel = new Legal_DistributionSoap();

		soapModel.setID(model.getID());
		soapModel.setContentID(model.getContentID());
		soapModel.setVersion(model.getVersion());
		soapModel.setZoneID(model.getZoneID());
		soapModel.setDistributedDate(model.getDistributedDate());
		soapModel.setRanking(model.getRanking());
		soapModel.setAllowDiscussion(model.getAllowDiscussion());
		soapModel.setViewedCount(model.getViewedCount());
		soapModel.setMailedCount(model.getMailedCount());
		soapModel.setRatedCount(model.getRatedCount());

		return soapModel;
	}

	public static Legal_DistributionSoap[] toSoapModels(
		Legal_Distribution[] models) {
		Legal_DistributionSoap[] soapModels = new Legal_DistributionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Legal_DistributionSoap[][] toSoapModels(
		Legal_Distribution[][] models) {
		Legal_DistributionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Legal_DistributionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Legal_DistributionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Legal_DistributionSoap[] toSoapModels(
		List<Legal_Distribution> models) {
		List<Legal_DistributionSoap> soapModels = new ArrayList<Legal_DistributionSoap>(models.size());

		for (Legal_Distribution model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Legal_DistributionSoap[soapModels.size()]);
	}

	public Legal_DistributionSoap() {
	}

	public int getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(int pk) {
		setID(pk);
	}

	public int getID() {
		return _ID;
	}

	public void setID(int ID) {
		_ID = ID;
	}

	public int getContentID() {
		return _ContentID;
	}

	public void setContentID(int ContentID) {
		_ContentID = ContentID;
	}

	public int getVersion() {
		return _Version;
	}

	public void setVersion(int Version) {
		_Version = Version;
	}

	public int getZoneID() {
		return _ZoneID;
	}

	public void setZoneID(int ZoneID) {
		_ZoneID = ZoneID;
	}

	public Date getDistributedDate() {
		return _DistributedDate;
	}

	public void setDistributedDate(Date DistributedDate) {
		_DistributedDate = DistributedDate;
	}

	public int getRanking() {
		return _Ranking;
	}

	public void setRanking(int Ranking) {
		_Ranking = Ranking;
	}

	public boolean getAllowDiscussion() {
		return _AllowDiscussion;
	}

	public boolean isAllowDiscussion() {
		return _AllowDiscussion;
	}

	public void setAllowDiscussion(boolean AllowDiscussion) {
		_AllowDiscussion = AllowDiscussion;
	}

	public int getViewedCount() {
		return _ViewedCount;
	}

	public void setViewedCount(int ViewedCount) {
		_ViewedCount = ViewedCount;
	}

	public int getMailedCount() {
		return _MailedCount;
	}

	public void setMailedCount(int MailedCount) {
		_MailedCount = MailedCount;
	}

	public int getRatedCount() {
		return _RatedCount;
	}

	public void setRatedCount(int RatedCount) {
		_RatedCount = RatedCount;
	}

	private int _ID;
	private int _ContentID;
	private int _Version;
	private int _ZoneID;
	private Date _DistributedDate;
	private int _Ranking;
	private boolean _AllowDiscussion;
	private int _ViewedCount;
	private int _MailedCount;
	private int _RatedCount;
}