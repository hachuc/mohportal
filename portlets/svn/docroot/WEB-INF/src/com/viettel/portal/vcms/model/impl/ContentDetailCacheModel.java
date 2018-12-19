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

import com.viettel.portal.vcms.model.ContentDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContentDetail in entity cache.
 *
 * @author chuchv
 * @see ContentDetail
 * @generated
 */
public class ContentDetailCacheModel implements CacheModel<ContentDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{autoId=");
		sb.append(autoId);
		sb.append(", contentId=");
		sb.append(contentId);
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
		sb.append(", version=");
		sb.append(version);
		sb.append(", subTitle=");
		sb.append(subTitle);
		sb.append(", title=");
		sb.append(title);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", subContent=");
		sb.append(subContent);
		sb.append(", content=");
		sb.append(content);
		sb.append(", smallImageId=");
		sb.append(smallImageId);
		sb.append(", smallImageUrl=");
		sb.append(smallImageUrl);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", newsType=");
		sb.append(newsType);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", isLegalContent=");
		sb.append(isLegalContent);
		sb.append(", imageCaption=");
		sb.append(imageCaption);
		sb.append(", imagePosition=");
		sb.append(imagePosition);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContentDetail toEntityModel() {
		ContentDetailImpl contentDetailImpl = new ContentDetailImpl();

		contentDetailImpl.setAutoId(autoId);
		contentDetailImpl.setContentId(contentId);
		contentDetailImpl.setGroupId(groupId);
		contentDetailImpl.setCompanyId(companyId);
		contentDetailImpl.setUserId(userId);

		if (userName == null) {
			contentDetailImpl.setUserName(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contentDetailImpl.setCreateDate(null);
		}
		else {
			contentDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contentDetailImpl.setModifiedDate(null);
		}
		else {
			contentDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		contentDetailImpl.setVersion(version);

		if (subTitle == null) {
			contentDetailImpl.setSubTitle(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setSubTitle(subTitle);
		}

		if (title == null) {
			contentDetailImpl.setTitle(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setTitle(title);
		}

		if (summary == null) {
			contentDetailImpl.setSummary(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setSummary(summary);
		}

		if (subContent == null) {
			contentDetailImpl.setSubContent(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setSubContent(subContent);
		}

		if (content == null) {
			contentDetailImpl.setContent(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setContent(content);
		}

		contentDetailImpl.setSmallImageId(smallImageId);

		if (smallImageUrl == null) {
			contentDetailImpl.setSmallImageUrl(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setSmallImageUrl(smallImageUrl);
		}

		contentDetailImpl.setCategoryId(categoryId);
		contentDetailImpl.setStatus(status);
		contentDetailImpl.setNewsType(newsType);

		if (imageUrl == null) {
			contentDetailImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setImageUrl(imageUrl);
		}

		contentDetailImpl.setIsLegalContent(isLegalContent);

		if (imageCaption == null) {
			contentDetailImpl.setImageCaption(StringPool.BLANK);
		}
		else {
			contentDetailImpl.setImageCaption(imageCaption);
		}

		contentDetailImpl.setImagePosition(imagePosition);

		contentDetailImpl.resetOriginalValues();

		return contentDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		autoId = objectInput.readLong();
		contentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		version = objectInput.readInt();
		subTitle = objectInput.readUTF();
		title = objectInput.readUTF();
		summary = objectInput.readUTF();
		subContent = objectInput.readUTF();
		content = objectInput.readUTF();
		smallImageId = objectInput.readLong();
		smallImageUrl = objectInput.readUTF();
		categoryId = objectInput.readLong();
		status = objectInput.readInt();
		newsType = objectInput.readInt();
		imageUrl = objectInput.readUTF();
		isLegalContent = objectInput.readBoolean();
		imageCaption = objectInput.readUTF();
		imagePosition = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(autoId);
		objectOutput.writeLong(contentId);
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
		objectOutput.writeInt(version);

		if (subTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subTitle);
		}

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

		if (subContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subContent);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(smallImageId);

		if (smallImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(smallImageUrl);
		}

		objectOutput.writeLong(categoryId);
		objectOutput.writeInt(status);
		objectOutput.writeInt(newsType);

		if (imageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		objectOutput.writeBoolean(isLegalContent);

		if (imageCaption == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageCaption);
		}

		objectOutput.writeInt(imagePosition);
	}

	public long autoId;
	public long contentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int version;
	public String subTitle;
	public String title;
	public String summary;
	public String subContent;
	public String content;
	public long smallImageId;
	public String smallImageUrl;
	public long categoryId;
	public int status;
	public int newsType;
	public String imageUrl;
	public boolean isLegalContent;
	public String imageCaption;
	public int imagePosition;
}