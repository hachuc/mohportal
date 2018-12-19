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

package com.viettel.portal.magazine.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.magazine.service.http.MagazineContentServiceSoap}.
 *
 * @author namtv
 * @see com.viettel.portal.magazine.service.http.MagazineContentServiceSoap
 * @generated
 */
public class MagazineContentSoap implements Serializable {
	public static MagazineContentSoap toSoapModel(MagazineContent model) {
		MagazineContentSoap soapModel = new MagazineContentSoap();

		soapModel.setID(model.getID());
		soapModel.setHeadline(model.getHeadline());
		soapModel.setTeaser(model.getTeaser());
		soapModel.setBody(model.getBody());
		soapModel.setMagazineZoneID(model.getMagazineZoneID());
		soapModel.setMagazineID(model.getMagazineID());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setJobtitle(model.getJobtitle());
		soapModel.setViewedCount(model.getViewedCount());
		soapModel.setSortOrder(model.getSortOrder());
		soapModel.setMailedCount(model.getMailedCount());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MagazineContentSoap[] toSoapModels(MagazineContent[] models) {
		MagazineContentSoap[] soapModels = new MagazineContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MagazineContentSoap[][] toSoapModels(
		MagazineContent[][] models) {
		MagazineContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MagazineContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MagazineContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MagazineContentSoap[] toSoapModels(
		List<MagazineContent> models) {
		List<MagazineContentSoap> soapModels = new ArrayList<MagazineContentSoap>(models.size());

		for (MagazineContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MagazineContentSoap[soapModels.size()]);
	}

	public MagazineContentSoap() {
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

	public String getHeadline() {
		return _Headline;
	}

	public void setHeadline(String Headline) {
		_Headline = Headline;
	}

	public String getTeaser() {
		return _Teaser;
	}

	public void setTeaser(String Teaser) {
		_Teaser = Teaser;
	}

	public String getBody() {
		return _Body;
	}

	public void setBody(String Body) {
		_Body = Body;
	}

	public int getMagazineZoneID() {
		return _MagazineZoneID;
	}

	public void setMagazineZoneID(int MagazineZoneID) {
		_MagazineZoneID = MagazineZoneID;
	}

	public int getMagazineID() {
		return _MagazineID;
	}

	public void setMagazineID(int MagazineID) {
		_MagazineID = MagazineID;
	}

	public String getAuthor() {
		return _Author;
	}

	public void setAuthor(String Author) {
		_Author = Author;
	}

	public String getJobtitle() {
		return _Jobtitle;
	}

	public void setJobtitle(String Jobtitle) {
		_Jobtitle = Jobtitle;
	}

	public int getViewedCount() {
		return _ViewedCount;
	}

	public void setViewedCount(int ViewedCount) {
		_ViewedCount = ViewedCount;
	}

	public int getSortOrder() {
		return _SortOrder;
	}

	public void setSortOrder(int SortOrder) {
		_SortOrder = SortOrder;
	}

	public int getMailedCount() {
		return _MailedCount;
	}

	public void setMailedCount(int MailedCount) {
		_MailedCount = MailedCount;
	}

	public Date getCreationDate() {
		return _CreationDate;
	}

	public void setCreationDate(Date CreationDate) {
		_CreationDate = CreationDate;
	}

	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;
	}

	private int _ID;
	private String _Headline;
	private String _Teaser;
	private String _Body;
	private int _MagazineZoneID;
	private int _MagazineID;
	private String _Author;
	private String _Jobtitle;
	private int _ViewedCount;
	private int _SortOrder;
	private int _MailedCount;
	private Date _CreationDate;
	private Date _ModifiedDate;
}