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
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.vcms.service.http.CommentServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.http.CommentServiceSoap
 * @generated
 */
public class CommentSoap implements Serializable {
	public static CommentSoap toSoapModel(Comment model) {
		CommentSoap soapModel = new CommentSoap();

		soapModel.setCommentId(model.getCommentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDistributionId(model.getDistributionId());
		soapModel.setFullName(model.getFullName());
		soapModel.setAddress(model.getAddress());
		soapModel.setEmail(model.getEmail());
		soapModel.setBody(model.getBody());
		soapModel.setVisible(model.getVisible());
		soapModel.setIpAddress(model.getIpAddress());

		return soapModel;
	}

	public static CommentSoap[] toSoapModels(Comment[] models) {
		CommentSoap[] soapModels = new CommentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommentSoap[][] toSoapModels(Comment[][] models) {
		CommentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommentSoap[] toSoapModels(List<Comment> models) {
		List<CommentSoap> soapModels = new ArrayList<CommentSoap>(models.size());

		for (Comment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommentSoap[soapModels.size()]);
	}

	public CommentSoap() {
	}

	public long getPrimaryKey() {
		return _commentId;
	}

	public void setPrimaryKey(long pk) {
		setCommentId(pk);
	}

	public long getCommentId() {
		return _commentId;
	}

	public void setCommentId(long commentId) {
		_commentId = commentId;
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

	public long getDistributionId() {
		return _distributionId;
	}

	public void setDistributionId(long distributionId) {
		_distributionId = distributionId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public boolean getVisible() {
		return _visible;
	}

	public boolean isVisible() {
		return _visible;
	}

	public void setVisible(boolean visible) {
		_visible = visible;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	private long _commentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _distributionId;
	private String _fullName;
	private String _address;
	private String _email;
	private String _body;
	private boolean _visible;
	private String _ipAddress;
}