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

package com.viettel.portal.photos.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.photos.model.Photo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Photo in entity cache.
 *
 * @author ChucHV
 * @see Photo
 * @generated
 */
public class PhotoCacheModel implements CacheModel<Photo>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{photoId=");
		sb.append(photoId);
		sb.append(", caption=");
		sb.append(caption);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileLink=");
		sb.append(fileLink);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", order_=");
		sb.append(order_);
		sb.append(", status=");
		sb.append(status);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Photo toEntityModel() {
		PhotoImpl photoImpl = new PhotoImpl();

		photoImpl.setPhotoId(photoId);

		if (caption == null) {
			photoImpl.setCaption(StringPool.BLANK);
		}
		else {
			photoImpl.setCaption(caption);
		}

		photoImpl.setFileId(fileId);

		if (fileLink == null) {
			photoImpl.setFileLink(StringPool.BLANK);
		}
		else {
			photoImpl.setFileLink(fileLink);
		}

		if (fileName == null) {
			photoImpl.setFileName(StringPool.BLANK);
		}
		else {
			photoImpl.setFileName(fileName);
		}

		if (fileSize == null) {
			photoImpl.setFileSize(StringPool.BLANK);
		}
		else {
			photoImpl.setFileSize(fileSize);
		}

		if (createDate == Long.MIN_VALUE) {
			photoImpl.setCreateDate(null);
		}
		else {
			photoImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			photoImpl.setModifyDate(null);
		}
		else {
			photoImpl.setModifyDate(new Date(modifyDate));
		}

		photoImpl.setOrder_(order_);
		photoImpl.setStatus(status);

		if (userName == null) {
			photoImpl.setUserName(StringPool.BLANK);
		}
		else {
			photoImpl.setUserName(userName);
		}

		photoImpl.setUserId(userId);
		photoImpl.setCompanyId(companyId);
		photoImpl.setCategoryId(categoryId);
		photoImpl.setGroupId(groupId);

		photoImpl.resetOriginalValues();

		return photoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		photoId = objectInput.readLong();
		caption = objectInput.readUTF();
		fileId = objectInput.readLong();
		fileLink = objectInput.readUTF();
		fileName = objectInput.readUTF();
		fileSize = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifyDate = objectInput.readLong();
		order_ = objectInput.readInt();
		status = objectInput.readBoolean();
		userName = objectInput.readUTF();
		userId = objectInput.readLong();
		companyId = objectInput.readLong();
		categoryId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(photoId);

		if (caption == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(caption);
		}

		objectOutput.writeLong(fileId);

		if (fileLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileLink);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (fileSize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileSize);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifyDate);
		objectOutput.writeInt(order_);
		objectOutput.writeBoolean(status);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(groupId);
	}

	public long photoId;
	public String caption;
	public long fileId;
	public String fileLink;
	public String fileName;
	public String fileSize;
	public long createDate;
	public long modifyDate;
	public int order_;
	public boolean status;
	public String userName;
	public long userId;
	public long companyId;
	public long categoryId;
	public long groupId;
}