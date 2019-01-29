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

package com.revotech.portal.videolibrary.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.revotech.portal.videolibrary.model.VLVideo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VLVideo in entity cache.
 *
 * @author ChucHV
 * @see VLVideo
 * @generated
 */
public class VLVideoCacheModel implements CacheModel<VLVideo>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{videoId=");
		sb.append(videoId);
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
		sb.append(", videoName=");
		sb.append(videoName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", videoType=");
		sb.append(videoType);
		sb.append(", videoUrl=");
		sb.append(videoUrl);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", image=");
		sb.append(image);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", smallImageUrl=");
		sb.append(smallImageUrl);
		sb.append(", relateId=");
		sb.append(relateId);
		sb.append(", invisible=");
		sb.append(invisible);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VLVideo toEntityModel() {
		VLVideoImpl vlVideoImpl = new VLVideoImpl();

		vlVideoImpl.setVideoId(videoId);
		vlVideoImpl.setGroupId(groupId);
		vlVideoImpl.setCompanyId(companyId);
		vlVideoImpl.setUserId(userId);

		if (userName == null) {
			vlVideoImpl.setUserName(StringPool.BLANK);
		}
		else {
			vlVideoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vlVideoImpl.setCreateDate(null);
		}
		else {
			vlVideoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vlVideoImpl.setModifiedDate(null);
		}
		else {
			vlVideoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (videoName == null) {
			vlVideoImpl.setVideoName(StringPool.BLANK);
		}
		else {
			vlVideoImpl.setVideoName(videoName);
		}

		if (description == null) {
			vlVideoImpl.setDescription(StringPool.BLANK);
		}
		else {
			vlVideoImpl.setDescription(description);
		}

		if (videoType == null) {
			vlVideoImpl.setVideoType(StringPool.BLANK);
		}
		else {
			vlVideoImpl.setVideoType(videoType);
		}

		if (videoUrl == null) {
			vlVideoImpl.setVideoUrl(StringPool.BLANK);
		}
		else {
			vlVideoImpl.setVideoUrl(videoUrl);
		}

		vlVideoImpl.setViewCount(viewCount);
		vlVideoImpl.setFileId(fileId);
		vlVideoImpl.setImage(image);
		vlVideoImpl.setImageId(imageId);

		if (smallImageUrl == null) {
			vlVideoImpl.setSmallImageUrl(StringPool.BLANK);
		}
		else {
			vlVideoImpl.setSmallImageUrl(smallImageUrl);
		}

		vlVideoImpl.setRelateId(relateId);
		vlVideoImpl.setInvisible(invisible);
		vlVideoImpl.setCategoryId(categoryId);

		vlVideoImpl.resetOriginalValues();

		return vlVideoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		videoName = objectInput.readUTF();
		description = objectInput.readUTF();
		videoType = objectInput.readUTF();
		videoUrl = objectInput.readUTF();
		viewCount = objectInput.readInt();
		fileId = objectInput.readLong();
		image = objectInput.readBoolean();
		imageId = objectInput.readLong();
		smallImageUrl = objectInput.readUTF();
		relateId = objectInput.readLong();
		invisible = objectInput.readBoolean();
		categoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(videoId);
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

		if (videoName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(videoName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (videoType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(videoType);
		}

		if (videoUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(videoUrl);
		}

		objectOutput.writeInt(viewCount);
		objectOutput.writeLong(fileId);
		objectOutput.writeBoolean(image);
		objectOutput.writeLong(imageId);

		if (smallImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(smallImageUrl);
		}

		objectOutput.writeLong(relateId);
		objectOutput.writeBoolean(invisible);
		objectOutput.writeLong(categoryId);
	}

	public long videoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String videoName;
	public String description;
	public String videoType;
	public String videoUrl;
	public int viewCount;
	public long fileId;
	public boolean image;
	public long imageId;
	public String smallImageUrl;
	public long relateId;
	public boolean invisible;
	public long categoryId;
}