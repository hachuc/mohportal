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

import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalFAQEntry in entity cache.
 *
 * @author chuchv
 * @see LegalFAQEntry
 * @generated
 */
public class LegalFAQEntryCacheModel implements CacheModel<LegalFAQEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", citizenName=");
		sb.append(citizenName);
		sb.append(", citizenPhone=");
		sb.append(citizenPhone);
		sb.append(", citizenEmail=");
		sb.append(citizenEmail);
		sb.append(", askDate=");
		sb.append(askDate);
		sb.append(", askTitle=");
		sb.append(askTitle);
		sb.append(", askContent=");
		sb.append(askContent);
		sb.append(", answerDate=");
		sb.append(answerDate);
		sb.append(", answerContent=");
		sb.append(answerContent);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append(", publishStatus=");
		sb.append(publishStatus);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalFAQEntry toEntityModel() {
		LegalFAQEntryImpl legalFAQEntryImpl = new LegalFAQEntryImpl();

		legalFAQEntryImpl.setEntryId(entryId);
		legalFAQEntryImpl.setCompanyId(companyId);
		legalFAQEntryImpl.setGroupId(groupId);
		legalFAQEntryImpl.setUserId(userId);

		if (userName == null) {
			legalFAQEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setUserName(userName);
		}

		legalFAQEntryImpl.setCategoryId(categoryId);

		if (citizenName == null) {
			legalFAQEntryImpl.setCitizenName(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setCitizenName(citizenName);
		}

		if (citizenPhone == null) {
			legalFAQEntryImpl.setCitizenPhone(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setCitizenPhone(citizenPhone);
		}

		if (citizenEmail == null) {
			legalFAQEntryImpl.setCitizenEmail(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setCitizenEmail(citizenEmail);
		}

		if (askDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setAskDate(null);
		}
		else {
			legalFAQEntryImpl.setAskDate(new Date(askDate));
		}

		if (askTitle == null) {
			legalFAQEntryImpl.setAskTitle(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setAskTitle(askTitle);
		}

		if (askContent == null) {
			legalFAQEntryImpl.setAskContent(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setAskContent(askContent);
		}

		if (answerDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setAnswerDate(null);
		}
		else {
			legalFAQEntryImpl.setAnswerDate(new Date(answerDate));
		}

		if (answerContent == null) {
			legalFAQEntryImpl.setAnswerContent(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setAnswerContent(answerContent);
		}

		if (createDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setCreateDate(null);
		}
		else {
			legalFAQEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setModifiedDate(null);
		}
		else {
			legalFAQEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (publishDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setPublishDate(null);
		}
		else {
			legalFAQEntryImpl.setPublishDate(new Date(publishDate));
		}

		legalFAQEntryImpl.setViewCount(viewCount);
		legalFAQEntryImpl.setPublishStatus(publishStatus);
		legalFAQEntryImpl.setStatus(status);

		legalFAQEntryImpl.resetOriginalValues();

		return legalFAQEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		entryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		categoryId = objectInput.readLong();
		citizenName = objectInput.readUTF();
		citizenPhone = objectInput.readUTF();
		citizenEmail = objectInput.readUTF();
		askDate = objectInput.readLong();
		askTitle = objectInput.readUTF();
		askContent = objectInput.readUTF();
		answerDate = objectInput.readLong();
		answerContent = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		publishDate = objectInput.readLong();
		viewCount = objectInput.readInt();
		publishStatus = objectInput.readInt();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(entryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(categoryId);

		if (citizenName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(citizenName);
		}

		if (citizenPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(citizenPhone);
		}

		if (citizenEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(citizenEmail);
		}

		objectOutput.writeLong(askDate);

		if (askTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(askTitle);
		}

		if (askContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(askContent);
		}

		objectOutput.writeLong(answerDate);

		if (answerContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answerContent);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(publishDate);
		objectOutput.writeInt(viewCount);
		objectOutput.writeInt(publishStatus);
		objectOutput.writeInt(status);
	}

	public long entryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long categoryId;
	public String citizenName;
	public String citizenPhone;
	public String citizenEmail;
	public long askDate;
	public String askTitle;
	public String askContent;
	public long answerDate;
	public String answerContent;
	public long createDate;
	public long modifiedDate;
	public long publishDate;
	public int viewCount;
	public int publishStatus;
	public int status;
}