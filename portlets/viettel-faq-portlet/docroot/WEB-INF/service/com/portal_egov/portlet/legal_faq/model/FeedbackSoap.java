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

package com.portal_egov.portlet.legal_faq.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.legal_faq.service.http.FeedbackServiceSoap}.
 *
 * @author chuchv
 * @see com.portal_egov.portlet.legal_faq.service.http.FeedbackServiceSoap
 * @generated
 */
public class FeedbackSoap implements Serializable {
	public static FeedbackSoap toSoapModel(Feedback model) {
		FeedbackSoap soapModel = new FeedbackSoap();

		soapModel.setFeedbackId(model.getFeedbackId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setSummary(model.getSummary());
		soapModel.setBody(model.getBody());
		soapModel.setFullName(model.getFullName());
		soapModel.setWorkFor(model.getWorkFor());
		soapModel.setAddress(model.getAddress());
		soapModel.setPhone(model.getPhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setFileId(model.getFileId());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileURL(model.getFileURL());
		soapModel.setIpAddress(model.getIpAddress());

		return soapModel;
	}

	public static FeedbackSoap[] toSoapModels(Feedback[] models) {
		FeedbackSoap[] soapModels = new FeedbackSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeedbackSoap[][] toSoapModels(Feedback[][] models) {
		FeedbackSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeedbackSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeedbackSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeedbackSoap[] toSoapModels(List<Feedback> models) {
		List<FeedbackSoap> soapModels = new ArrayList<FeedbackSoap>(models.size());

		for (Feedback model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeedbackSoap[soapModels.size()]);
	}

	public FeedbackSoap() {
	}

	public long getPrimaryKey() {
		return _feedbackId;
	}

	public void setPrimaryKey(long pk) {
		setFeedbackId(pk);
	}

	public long getFeedbackId() {
		return _feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
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

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getWorkFor() {
		return _workFor;
	}

	public void setWorkFor(String workFor) {
		_workFor = workFor;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileSize() {
		return _fileSize;
	}

	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFileURL() {
		return _fileURL;
	}

	public void setFileURL(String fileURL) {
		_fileURL = fileURL;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	private long _feedbackId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _summary;
	private String _body;
	private String _fullName;
	private String _workFor;
	private String _address;
	private String _phone;
	private String _email;
	private long _fileId;
	private String _fileSize;
	private String _fileName;
	private String _fileURL;
	private String _ipAddress;
}