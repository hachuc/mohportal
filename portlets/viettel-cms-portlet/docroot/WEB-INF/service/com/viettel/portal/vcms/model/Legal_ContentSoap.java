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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.Legal_ContentServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.Legal_ContentServiceSoap
 * @generated
 */
public class Legal_ContentSoap implements Serializable {
	public static Legal_ContentSoap toSoapModel(Legal_Content model) {
		Legal_ContentSoap soapModel = new Legal_ContentSoap();

		soapModel.setID(model.getID());
		soapModel.setContentID(model.getContentID());
		soapModel.setVersion(model.getVersion());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setByline(model.getByline());
		soapModel.setHeadline(model.getHeadline());
		soapModel.setTagline(model.getTagline());
		soapModel.setTeaser(model.getTeaser());
		soapModel.setBody(model.getBody());
		soapModel.setAvatar(model.getAvatar());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setImageDescription(model.getImageDescription());
		soapModel.setImageAlign(model.getImageAlign());
		soapModel.setZoneID(model.getZoneID());
		soapModel.setSource(model.getSource());
		soapModel.setStatus(model.getStatus());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setEditor(model.getEditor());
		soapModel.setApprover(model.getApprover());
		soapModel.setDeployer(model.getDeployer());
		soapModel.setAuthors(model.getAuthors());

		return soapModel;
	}

	public static Legal_ContentSoap[] toSoapModels(Legal_Content[] models) {
		Legal_ContentSoap[] soapModels = new Legal_ContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Legal_ContentSoap[][] toSoapModels(Legal_Content[][] models) {
		Legal_ContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Legal_ContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Legal_ContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Legal_ContentSoap[] toSoapModels(List<Legal_Content> models) {
		List<Legal_ContentSoap> soapModels = new ArrayList<Legal_ContentSoap>(models.size());

		for (Legal_Content model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Legal_ContentSoap[soapModels.size()]);
	}

	public Legal_ContentSoap() {
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

	public String getByline() {
		return _Byline;
	}

	public void setByline(String Byline) {
		_Byline = Byline;
	}

	public String getHeadline() {
		return _Headline;
	}

	public void setHeadline(String Headline) {
		_Headline = Headline;
	}

	public String getTagline() {
		return _Tagline;
	}

	public void setTagline(String Tagline) {
		_Tagline = Tagline;
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

	public String getAvatar() {
		return _Avatar;
	}

	public void setAvatar(String Avatar) {
		_Avatar = Avatar;
	}

	public String getImageUrl() {
		return _ImageUrl;
	}

	public void setImageUrl(String ImageUrl) {
		_ImageUrl = ImageUrl;
	}

	public String getImageDescription() {
		return _ImageDescription;
	}

	public void setImageDescription(String ImageDescription) {
		_ImageDescription = ImageDescription;
	}

	public int getImageAlign() {
		return _ImageAlign;
	}

	public void setImageAlign(int ImageAlign) {
		_ImageAlign = ImageAlign;
	}

	public int getZoneID() {
		return _ZoneID;
	}

	public void setZoneID(int ZoneID) {
		_ZoneID = ZoneID;
	}

	public String getSource() {
		return _Source;
	}

	public void setSource(String Source) {
		_Source = Source;
	}

	public int getStatus() {
		return _Status;
	}

	public void setStatus(int Status) {
		_Status = Status;
	}

	public String getAuthor() {
		return _Author;
	}

	public void setAuthor(String Author) {
		_Author = Author;
	}

	public String getEditor() {
		return _Editor;
	}

	public void setEditor(String Editor) {
		_Editor = Editor;
	}

	public String getApprover() {
		return _Approver;
	}

	public void setApprover(String Approver) {
		_Approver = Approver;
	}

	public String getDeployer() {
		return _Deployer;
	}

	public void setDeployer(String Deployer) {
		_Deployer = Deployer;
	}

	public String getAuthors() {
		return _Authors;
	}

	public void setAuthors(String Authors) {
		_Authors = Authors;
	}

	private int _ID;
	private int _ContentID;
	private int _Version;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private String _Byline;
	private String _Headline;
	private String _Tagline;
	private String _Teaser;
	private String _Body;
	private String _Avatar;
	private String _ImageUrl;
	private String _ImageDescription;
	private int _ImageAlign;
	private int _ZoneID;
	private String _Source;
	private int _Status;
	private String _Author;
	private String _Editor;
	private String _Approver;
	private String _Deployer;
	private String _Authors;
}