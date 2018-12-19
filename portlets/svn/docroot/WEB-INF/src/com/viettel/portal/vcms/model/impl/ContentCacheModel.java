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

import com.viettel.portal.vcms.model.Content;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Content in entity cache.
 *
 * @author chuchv
 * @see Content
 * @generated
 */
public class ContentCacheModel implements CacheModel<Content>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

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
		sb.append(", preVersion=");
		sb.append(preVersion);
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
		sb.append(", copyRight=");
		sb.append(copyRight);
		sb.append(", status=");
		sb.append(status);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
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
		sb.append(", createdByUserId=");
		sb.append(createdByUserId);
		sb.append(", editedByUserId=");
		sb.append(editedByUserId);
		sb.append(", reviewedByUserId=");
		sb.append(reviewedByUserId);
		sb.append(", publishedByUserId=");
		sb.append(publishedByUserId);
		sb.append(", createdByUserName=");
		sb.append(createdByUserName);
		sb.append(", editedByUserName=");
		sb.append(editedByUserName);
		sb.append(", reviewedByUserName=");
		sb.append(reviewedByUserName);
		sb.append(", publishedByUserName=");
		sb.append(publishedByUserName);
		sb.append(", author=");
		sb.append(author);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Content toEntityModel() {
		ContentImpl contentImpl = new ContentImpl();

		contentImpl.setAutoId(autoId);
		contentImpl.setContentId(contentId);
		contentImpl.setGroupId(groupId);
		contentImpl.setCompanyId(companyId);
		contentImpl.setUserId(userId);

		if (userName == null) {
			contentImpl.setUserName(StringPool.BLANK);
		}
		else {
			contentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contentImpl.setCreateDate(null);
		}
		else {
			contentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contentImpl.setModifiedDate(null);
		}
		else {
			contentImpl.setModifiedDate(new Date(modifiedDate));
		}

		contentImpl.setPreVersion(preVersion);
		contentImpl.setVersion(version);

		if (subTitle == null) {
			contentImpl.setSubTitle(StringPool.BLANK);
		}
		else {
			contentImpl.setSubTitle(subTitle);
		}

		if (title == null) {
			contentImpl.setTitle(StringPool.BLANK);
		}
		else {
			contentImpl.setTitle(title);
		}

		if (summary == null) {
			contentImpl.setSummary(StringPool.BLANK);
		}
		else {
			contentImpl.setSummary(summary);
		}

		if (subContent == null) {
			contentImpl.setSubContent(StringPool.BLANK);
		}
		else {
			contentImpl.setSubContent(subContent);
		}

		if (content == null) {
			contentImpl.setContent(StringPool.BLANK);
		}
		else {
			contentImpl.setContent(content);
		}

		contentImpl.setSmallImageId(smallImageId);

		if (smallImageUrl == null) {
			contentImpl.setSmallImageUrl(StringPool.BLANK);
		}
		else {
			contentImpl.setSmallImageUrl(smallImageUrl);
		}

		contentImpl.setCategoryId(categoryId);

		if (copyRight == null) {
			contentImpl.setCopyRight(StringPool.BLANK);
		}
		else {
			contentImpl.setCopyRight(copyRight);
		}

		contentImpl.setStatus(status);

		if (urlTitle == null) {
			contentImpl.setUrlTitle(StringPool.BLANK);
		}
		else {
			contentImpl.setUrlTitle(urlTitle);
		}

		contentImpl.setNewsType(newsType);

		if (imageUrl == null) {
			contentImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			contentImpl.setImageUrl(imageUrl);
		}

		contentImpl.setIsLegalContent(isLegalContent);

		if (imageCaption == null) {
			contentImpl.setImageCaption(StringPool.BLANK);
		}
		else {
			contentImpl.setImageCaption(imageCaption);
		}

		contentImpl.setImagePosition(imagePosition);
		contentImpl.setCreatedByUserId(createdByUserId);
		contentImpl.setEditedByUserId(editedByUserId);
		contentImpl.setReviewedByUserId(reviewedByUserId);
		contentImpl.setPublishedByUserId(publishedByUserId);

		if (createdByUserName == null) {
			contentImpl.setCreatedByUserName(StringPool.BLANK);
		}
		else {
			contentImpl.setCreatedByUserName(createdByUserName);
		}

		if (editedByUserName == null) {
			contentImpl.setEditedByUserName(StringPool.BLANK);
		}
		else {
			contentImpl.setEditedByUserName(editedByUserName);
		}

		if (reviewedByUserName == null) {
			contentImpl.setReviewedByUserName(StringPool.BLANK);
		}
		else {
			contentImpl.setReviewedByUserName(reviewedByUserName);
		}

		if (publishedByUserName == null) {
			contentImpl.setPublishedByUserName(StringPool.BLANK);
		}
		else {
			contentImpl.setPublishedByUserName(publishedByUserName);
		}

		if (author == null) {
			contentImpl.setAuthor(StringPool.BLANK);
		}
		else {
			contentImpl.setAuthor(author);
		}

		if (jobTitle == null) {
			contentImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			contentImpl.setJobTitle(jobTitle);
		}

		contentImpl.resetOriginalValues();

		return contentImpl;
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
		preVersion = objectInput.readInt();
		version = objectInput.readInt();
		subTitle = objectInput.readUTF();
		title = objectInput.readUTF();
		summary = objectInput.readUTF();
		subContent = objectInput.readUTF();
		content = objectInput.readUTF();
		smallImageId = objectInput.readLong();
		smallImageUrl = objectInput.readUTF();
		categoryId = objectInput.readLong();
		copyRight = objectInput.readUTF();
		status = objectInput.readInt();
		urlTitle = objectInput.readUTF();
		newsType = objectInput.readInt();
		imageUrl = objectInput.readUTF();
		isLegalContent = objectInput.readBoolean();
		imageCaption = objectInput.readUTF();
		imagePosition = objectInput.readInt();
		createdByUserId = objectInput.readLong();
		editedByUserId = objectInput.readLong();
		reviewedByUserId = objectInput.readLong();
		publishedByUserId = objectInput.readLong();
		createdByUserName = objectInput.readUTF();
		editedByUserName = objectInput.readUTF();
		reviewedByUserName = objectInput.readUTF();
		publishedByUserName = objectInput.readUTF();
		author = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
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
		objectOutput.writeInt(preVersion);
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

		if (copyRight == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copyRight);
		}

		objectOutput.writeInt(status);

		if (urlTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(urlTitle);
		}

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
		objectOutput.writeLong(createdByUserId);
		objectOutput.writeLong(editedByUserId);
		objectOutput.writeLong(reviewedByUserId);
		objectOutput.writeLong(publishedByUserId);

		if (createdByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdByUserName);
		}

		if (editedByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(editedByUserName);
		}

		if (reviewedByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reviewedByUserName);
		}

		if (publishedByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishedByUserName);
		}

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}
	}

	public long autoId;
	public long contentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int preVersion;
	public int version;
	public String subTitle;
	public String title;
	public String summary;
	public String subContent;
	public String content;
	public long smallImageId;
	public String smallImageUrl;
	public long categoryId;
	public String copyRight;
	public int status;
	public String urlTitle;
	public int newsType;
	public String imageUrl;
	public boolean isLegalContent;
	public String imageCaption;
	public int imagePosition;
	public long createdByUserId;
	public long editedByUserId;
	public long reviewedByUserId;
	public long publishedByUserId;
	public String createdByUserName;
	public String editedByUserName;
	public String reviewedByUserName;
	public String publishedByUserName;
	public String author;
	public String jobTitle;
}