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

package com.viettel.portal.magazine.archive.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.magazine.archive.service.http.ContentServiceSoap}.
 *
 * @author namtv
 * @see com.viettel.portal.magazine.archive.service.http.ContentServiceSoap
 * @generated
 */
public class ContentSoap implements Serializable {
	public static ContentSoap toSoapModel(Content model) {
		ContentSoap soapModel = new ContentSoap();

		soapModel.setID(model.getID());
		soapModel.setSubject(model.getSubject());
		soapModel.setNormalZoneID(model.getNormalZoneID());
		soapModel.setSpecialZoneID(model.getSpecialZoneID());
		soapModel.setFileUrl(model.getFileUrl());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setAuthorTitle(model.getAuthorTitle());
		soapModel.setMagazineID(model.getMagazineID());
		soapModel.setSortOrder(model.getSortOrder());
		soapModel.setCreationDate(model.getCreationDate());

		return soapModel;
	}

	public static ContentSoap[] toSoapModels(Content[] models) {
		ContentSoap[] soapModels = new ContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContentSoap[][] toSoapModels(Content[][] models) {
		ContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContentSoap[] toSoapModels(List<Content> models) {
		List<ContentSoap> soapModels = new ArrayList<ContentSoap>(models.size());

		for (Content model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContentSoap[soapModels.size()]);
	}

	public ContentSoap() {
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

	public String getSubject() {
		return _Subject;
	}

	public void setSubject(String Subject) {
		_Subject = Subject;
	}

	public int getNormalZoneID() {
		return _NormalZoneID;
	}

	public void setNormalZoneID(int NormalZoneID) {
		_NormalZoneID = NormalZoneID;
	}

	public int getSpecialZoneID() {
		return _SpecialZoneID;
	}

	public void setSpecialZoneID(int SpecialZoneID) {
		_SpecialZoneID = SpecialZoneID;
	}

	public String getFileUrl() {
		return _FileUrl;
	}

	public void setFileUrl(String FileUrl) {
		_FileUrl = FileUrl;
	}

	public String getAuthor() {
		return _Author;
	}

	public void setAuthor(String Author) {
		_Author = Author;
	}

	public String getAuthorTitle() {
		return _AuthorTitle;
	}

	public void setAuthorTitle(String AuthorTitle) {
		_AuthorTitle = AuthorTitle;
	}

	public int getMagazineID() {
		return _MagazineID;
	}

	public void setMagazineID(int MagazineID) {
		_MagazineID = MagazineID;
	}

	public int getSortOrder() {
		return _SortOrder;
	}

	public void setSortOrder(int SortOrder) {
		_SortOrder = SortOrder;
	}

	public Date getCreationDate() {
		return _CreationDate;
	}

	public void setCreationDate(Date CreationDate) {
		_CreationDate = CreationDate;
	}

	private int _ID;
	private String _Subject;
	private int _NormalZoneID;
	private int _SpecialZoneID;
	private String _FileUrl;
	private String _Author;
	private String _AuthorTitle;
	private int _MagazineID;
	private int _SortOrder;
	private Date _CreationDate;
}