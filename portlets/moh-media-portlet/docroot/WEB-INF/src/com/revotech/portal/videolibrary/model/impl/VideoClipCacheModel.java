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

import com.revotech.portal.videolibrary.model.VideoClip;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VideoClip in entity cache.
 *
 * @author ChucHV
 * @see VideoClip
 * @generated
 */
public class VideoClipCacheModel implements CacheModel<VideoClip>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", CategoryID=");
		sb.append(CategoryID);
		sb.append(", Description=");
		sb.append(Description);
		sb.append(", ImageUrl=");
		sb.append(ImageUrl);
		sb.append(", VideoUrl=");
		sb.append(VideoUrl);
		sb.append(", Duration=");
		sb.append(Duration);
		sb.append(", ViewCount=");
		sb.append(ViewCount);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", CreationDate=");
		sb.append(CreationDate);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VideoClip toEntityModel() {
		VideoClipImpl videoClipImpl = new VideoClipImpl();

		videoClipImpl.setID(ID);

		if (Name == null) {
			videoClipImpl.setName(StringPool.BLANK);
		}
		else {
			videoClipImpl.setName(Name);
		}

		videoClipImpl.setCategoryID(CategoryID);

		if (Description == null) {
			videoClipImpl.setDescription(StringPool.BLANK);
		}
		else {
			videoClipImpl.setDescription(Description);
		}

		if (ImageUrl == null) {
			videoClipImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			videoClipImpl.setImageUrl(ImageUrl);
		}

		if (VideoUrl == null) {
			videoClipImpl.setVideoUrl(StringPool.BLANK);
		}
		else {
			videoClipImpl.setVideoUrl(VideoUrl);
		}

		videoClipImpl.setDuration(Duration);
		videoClipImpl.setViewCount(ViewCount);
		videoClipImpl.setStatus(Status);

		if (CreationDate == Long.MIN_VALUE) {
			videoClipImpl.setCreationDate(null);
		}
		else {
			videoClipImpl.setCreationDate(new Date(CreationDate));
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			videoClipImpl.setModifiedDate(null);
		}
		else {
			videoClipImpl.setModifiedDate(new Date(ModifiedDate));
		}

		videoClipImpl.resetOriginalValues();

		return videoClipImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		Name = objectInput.readUTF();
		CategoryID = objectInput.readInt();
		Description = objectInput.readUTF();
		ImageUrl = objectInput.readUTF();
		VideoUrl = objectInput.readUTF();
		Duration = objectInput.readInt();
		ViewCount = objectInput.readInt();
		Status = objectInput.readInt();
		CreationDate = objectInput.readLong();
		ModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ID);

		if (Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Name);
		}

		objectOutput.writeInt(CategoryID);

		if (Description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Description);
		}

		if (ImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ImageUrl);
		}

		if (VideoUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(VideoUrl);
		}

		objectOutput.writeInt(Duration);
		objectOutput.writeInt(ViewCount);
		objectOutput.writeInt(Status);
		objectOutput.writeLong(CreationDate);
		objectOutput.writeLong(ModifiedDate);
	}

	public int ID;
	public String Name;
	public int CategoryID;
	public String Description;
	public String ImageUrl;
	public String VideoUrl;
	public int Duration;
	public int ViewCount;
	public int Status;
	public long CreationDate;
	public long ModifiedDate;
}