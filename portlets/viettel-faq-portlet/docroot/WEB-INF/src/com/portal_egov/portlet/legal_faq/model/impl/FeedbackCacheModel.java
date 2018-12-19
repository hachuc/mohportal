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

package com.portal_egov.portlet.legal_faq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.legal_faq.model.Feedback;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Feedback in entity cache.
 *
 * @author chuchv
 * @see Feedback
 * @generated
 */
public class FeedbackCacheModel implements CacheModel<Feedback>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{feedbackId=");
		sb.append(feedbackId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", body=");
		sb.append(body);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", workFor=");
		sb.append(workFor);
		sb.append(", address=");
		sb.append(address);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileURL=");
		sb.append(fileURL);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Feedback toEntityModel() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setFeedbackId(feedbackId);
		feedbackImpl.setGroupId(groupId);
		feedbackImpl.setCompanyId(companyId);
		feedbackImpl.setUserId(userId);

		if (userName == null) {
			feedbackImpl.setUserName(StringPool.BLANK);
		}
		else {
			feedbackImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			feedbackImpl.setCreateDate(null);
		}
		else {
			feedbackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			feedbackImpl.setModifiedDate(null);
		}
		else {
			feedbackImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			feedbackImpl.setTitle(StringPool.BLANK);
		}
		else {
			feedbackImpl.setTitle(title);
		}

		if (summary == null) {
			feedbackImpl.setSummary(StringPool.BLANK);
		}
		else {
			feedbackImpl.setSummary(summary);
		}

		if (body == null) {
			feedbackImpl.setBody(StringPool.BLANK);
		}
		else {
			feedbackImpl.setBody(body);
		}

		if (fullName == null) {
			feedbackImpl.setFullName(StringPool.BLANK);
		}
		else {
			feedbackImpl.setFullName(fullName);
		}

		if (workFor == null) {
			feedbackImpl.setWorkFor(StringPool.BLANK);
		}
		else {
			feedbackImpl.setWorkFor(workFor);
		}

		if (address == null) {
			feedbackImpl.setAddress(StringPool.BLANK);
		}
		else {
			feedbackImpl.setAddress(address);
		}

		if (phone == null) {
			feedbackImpl.setPhone(StringPool.BLANK);
		}
		else {
			feedbackImpl.setPhone(phone);
		}

		if (email == null) {
			feedbackImpl.setEmail(StringPool.BLANK);
		}
		else {
			feedbackImpl.setEmail(email);
		}

		feedbackImpl.setFileId(fileId);

		if (fileSize == null) {
			feedbackImpl.setFileSize(StringPool.BLANK);
		}
		else {
			feedbackImpl.setFileSize(fileSize);
		}

		if (fileName == null) {
			feedbackImpl.setFileName(StringPool.BLANK);
		}
		else {
			feedbackImpl.setFileName(fileName);
		}

		if (fileURL == null) {
			feedbackImpl.setFileURL(StringPool.BLANK);
		}
		else {
			feedbackImpl.setFileURL(fileURL);
		}

		if (ipAddress == null) {
			feedbackImpl.setIpAddress(StringPool.BLANK);
		}
		else {
			feedbackImpl.setIpAddress(ipAddress);
		}

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		feedbackId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		summary = objectInput.readUTF();
		body = objectInput.readUTF();
		fullName = objectInput.readUTF();
		workFor = objectInput.readUTF();
		address = objectInput.readUTF();
		phone = objectInput.readUTF();
		email = objectInput.readUTF();
		fileId = objectInput.readLong();
		fileSize = objectInput.readUTF();
		fileName = objectInput.readUTF();
		fileURL = objectInput.readUTF();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(feedbackId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (summary == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(summary);
		}

		if (body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(body);
		}

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (workFor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workFor);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(fileId);

		if (fileSize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileSize);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (fileURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileURL);
		}

		if (ipAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public long feedbackId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String summary;
	public String body;
	public String fullName;
	public String workFor;
	public String address;
	public String phone;
	public String email;
	public long fileId;
	public String fileSize;
	public String fileName;
	public String fileURL;
	public String ipAddress;
}