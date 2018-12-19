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

package com.viettel.portal.vcms.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.vcms.model.Comment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Comment in entity cache.
 *
 * @author chuchv
 * @see Comment
 * @generated
 */
public class CommentCacheModel implements CacheModel<Comment>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{commentId=");
		sb.append(commentId);
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
		sb.append(", distributionId=");
		sb.append(distributionId);
		sb.append(", distributedDate=");
		sb.append(distributedDate);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", address=");
		sb.append(address);
		sb.append(", email=");
		sb.append(email);
		sb.append(", body=");
		sb.append(body);
		sb.append(", visible=");
		sb.append(visible);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Comment toEntityModel() {
		CommentImpl commentImpl = new CommentImpl();

		commentImpl.setCommentId(commentId);
		commentImpl.setGroupId(groupId);
		commentImpl.setCompanyId(companyId);
		commentImpl.setUserId(userId);

		if (userName == null) {
			commentImpl.setUserName(StringPool.BLANK);
		}
		else {
			commentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			commentImpl.setCreateDate(null);
		}
		else {
			commentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commentImpl.setModifiedDate(null);
		}
		else {
			commentImpl.setModifiedDate(new Date(modifiedDate));
		}

		commentImpl.setDistributionId(distributionId);

		if (distributedDate == Long.MIN_VALUE) {
			commentImpl.setDistributedDate(null);
		}
		else {
			commentImpl.setDistributedDate(new Date(distributedDate));
		}

		if (fullName == null) {
			commentImpl.setFullName(StringPool.BLANK);
		}
		else {
			commentImpl.setFullName(fullName);
		}

		if (address == null) {
			commentImpl.setAddress(StringPool.BLANK);
		}
		else {
			commentImpl.setAddress(address);
		}

		if (email == null) {
			commentImpl.setEmail(StringPool.BLANK);
		}
		else {
			commentImpl.setEmail(email);
		}

		if (body == null) {
			commentImpl.setBody(StringPool.BLANK);
		}
		else {
			commentImpl.setBody(body);
		}

		commentImpl.setVisible(visible);

		if (ipAddress == null) {
			commentImpl.setIpAddress(StringPool.BLANK);
		}
		else {
			commentImpl.setIpAddress(ipAddress);
		}

		commentImpl.resetOriginalValues();

		return commentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		commentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		distributionId = objectInput.readLong();
		distributedDate = objectInput.readLong();
		fullName = objectInput.readUTF();
		address = objectInput.readUTF();
		email = objectInput.readUTF();
		body = objectInput.readUTF();
		visible = objectInput.readBoolean();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(commentId);
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
		objectOutput.writeLong(distributionId);
		objectOutput.writeLong(distributedDate);

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(body);
		}

		objectOutput.writeBoolean(visible);

		if (ipAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public long commentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long distributionId;
	public long distributedDate;
	public String fullName;
	public String address;
	public String email;
	public String body;
	public boolean visible;
	public String ipAddress;
}