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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.ContentDetailServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.ContentDetailServiceSoap
 * @generated
 */
public class ContentDetailSoap implements Serializable {
	public static ContentDetailSoap toSoapModel(ContentDetail model) {
		ContentDetailSoap soapModel = new ContentDetailSoap();

		soapModel.setAutoId(model.getAutoId());
		soapModel.setContentId(model.getContentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVersion(model.getVersion());
		soapModel.setSubversion(model.getSubversion());
		soapModel.setSubTitle(model.getSubTitle());
		soapModel.setTitle(model.getTitle());
		soapModel.setSummary(model.getSummary());
		soapModel.setSubContent(model.getSubContent());
		soapModel.setContent(model.getContent());
		soapModel.setSmallImageId(model.getSmallImageId());
		soapModel.setSmallImageUrl(model.getSmallImageUrl());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setStatus(model.getStatus());
		soapModel.setNewsType(model.getNewsType());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setIsLegalContent(model.getIsLegalContent());
		soapModel.setImageCaption(model.getImageCaption());
		soapModel.setImagePosition(model.getImagePosition());

		return soapModel;
	}

	public static ContentDetailSoap[] toSoapModels(ContentDetail[] models) {
		ContentDetailSoap[] soapModels = new ContentDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContentDetailSoap[][] toSoapModels(ContentDetail[][] models) {
		ContentDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContentDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContentDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContentDetailSoap[] toSoapModels(List<ContentDetail> models) {
		List<ContentDetailSoap> soapModels = new ArrayList<ContentDetailSoap>(models.size());

		for (ContentDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContentDetailSoap[soapModels.size()]);
	}

	public ContentDetailSoap() {
	}

	public long getPrimaryKey() {
		return _autoId;
	}

	public void setPrimaryKey(long pk) {
		setAutoId(pk);
	}

	public long getAutoId() {
		return _autoId;
	}

	public void setAutoId(long autoId) {
		_autoId = autoId;
	}

	public long getContentId() {
		return _contentId;
	}

	public void setContentId(long contentId) {
		_contentId = contentId;
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

	public float getSubversion() {
		return _subversion;
	}

	public void setSubversion(float subversion) {
		_subversion = subversion;
	}

	public String getSubTitle() {
		return _subTitle;
	}

	public void setSubTitle(String subTitle) {
		_subTitle = subTitle;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public String getSubContent() {
		return _subContent;
	}

	public void setSubContent(String subContent) {
		_subContent = subContent;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getSmallImageId() {
		return _smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		_smallImageId = smallImageId;
	}

	public String getSmallImageUrl() {
		return _smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		_smallImageUrl = smallImageUrl;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getNewsType() {
		return _newsType;
	}

	public void setNewsType(int newsType) {
		_newsType = newsType;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public boolean getIsLegalContent() {
		return _isLegalContent;
	}

	public boolean isIsLegalContent() {
		return _isLegalContent;
	}

	public void setIsLegalContent(boolean isLegalContent) {
		_isLegalContent = isLegalContent;
	}

	public String getImageCaption() {
		return _imageCaption;
	}

	public void setImageCaption(String imageCaption) {
		_imageCaption = imageCaption;
	}

	public int getImagePosition() {
		return _imagePosition;
	}

	public void setImagePosition(int imagePosition) {
		_imagePosition = imagePosition;
	}

	private long _autoId;
	private long _contentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _version;
	private float _subversion;
	private String _subTitle;
	private String _title;
	private String _summary;
	private String _subContent;
	private String _content;
	private long _smallImageId;
	private String _smallImageUrl;
	private long _categoryId;
	private int _status;
	private int _newsType;
	private String _imageUrl;
	private boolean _isLegalContent;
	private String _imageCaption;
	private int _imagePosition;
}