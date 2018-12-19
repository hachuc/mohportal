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

package com.revotech.portal.tthc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.revotech.portal.tthc.model.LegalDocument;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalDocument in entity cache.
 *
 * @author hieptran
 * @see LegalDocument
 * @generated
 */
public class LegalDocumentCacheModel implements CacheModel<LegalDocument>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{ldId=");
		sb.append(ldId);
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
		sb.append(", ldCode=");
		sb.append(ldCode);
		sb.append(", ldTitle=");
		sb.append(ldTitle);
		sb.append(", ldLink=");
		sb.append(ldLink);
		sb.append(", ldLevel3Link=");
		sb.append(ldLevel3Link);
		sb.append(", ldSubcontent=");
		sb.append(ldSubcontent);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", idLinhvuc=");
		sb.append(idLinhvuc);
		sb.append(", idCoquanbanhanh=");
		sb.append(idCoquanbanhanh);
		sb.append(", ldDonvithuchien=");
		sb.append(ldDonvithuchien);
		sb.append(", ldLevel=");
		sb.append(ldLevel);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalDocument toEntityModel() {
		LegalDocumentImpl legalDocumentImpl = new LegalDocumentImpl();

		legalDocumentImpl.setLdId(ldId);
		legalDocumentImpl.setGroupId(groupId);
		legalDocumentImpl.setCompanyId(companyId);
		legalDocumentImpl.setUserId(userId);

		if (userName == null) {
			legalDocumentImpl.setUserName(StringPool.BLANK);
		}
		else {
			legalDocumentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			legalDocumentImpl.setCreateDate(null);
		}
		else {
			legalDocumentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalDocumentImpl.setModifiedDate(null);
		}
		else {
			legalDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ldCode == null) {
			legalDocumentImpl.setLdCode(StringPool.BLANK);
		}
		else {
			legalDocumentImpl.setLdCode(ldCode);
		}

		if (ldTitle == null) {
			legalDocumentImpl.setLdTitle(StringPool.BLANK);
		}
		else {
			legalDocumentImpl.setLdTitle(ldTitle);
		}

		if (ldLink == null) {
			legalDocumentImpl.setLdLink(StringPool.BLANK);
		}
		else {
			legalDocumentImpl.setLdLink(ldLink);
		}

		if (ldLevel3Link == null) {
			legalDocumentImpl.setLdLevel3Link(StringPool.BLANK);
		}
		else {
			legalDocumentImpl.setLdLevel3Link(ldLevel3Link);
		}

		if (ldSubcontent == null) {
			legalDocumentImpl.setLdSubcontent(StringPool.BLANK);
		}
		else {
			legalDocumentImpl.setLdSubcontent(ldSubcontent);
		}

		legalDocumentImpl.setIsActive(isActive);
		legalDocumentImpl.setIdLinhvuc(idLinhvuc);
		legalDocumentImpl.setIdCoquanbanhanh(idCoquanbanhanh);

		if (ldDonvithuchien == null) {
			legalDocumentImpl.setLdDonvithuchien(StringPool.BLANK);
		}
		else {
			legalDocumentImpl.setLdDonvithuchien(ldDonvithuchien);
		}

		legalDocumentImpl.setLdLevel(ldLevel);

		legalDocumentImpl.resetOriginalValues();

		return legalDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ldId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ldCode = objectInput.readUTF();
		ldTitle = objectInput.readUTF();
		ldLink = objectInput.readUTF();
		ldLevel3Link = objectInput.readUTF();
		ldSubcontent = objectInput.readUTF();
		isActive = objectInput.readBoolean();
		idLinhvuc = objectInput.readLong();
		idCoquanbanhanh = objectInput.readLong();
		ldDonvithuchien = objectInput.readUTF();
		ldLevel = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ldId);
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

		if (ldCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldCode);
		}

		if (ldTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldTitle);
		}

		if (ldLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldLink);
		}

		if (ldLevel3Link == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldLevel3Link);
		}

		if (ldSubcontent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldSubcontent);
		}

		objectOutput.writeBoolean(isActive);
		objectOutput.writeLong(idLinhvuc);
		objectOutput.writeLong(idCoquanbanhanh);

		if (ldDonvithuchien == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldDonvithuchien);
		}

		objectOutput.writeInt(ldLevel);
	}

	public long ldId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ldCode;
	public String ldTitle;
	public String ldLink;
	public String ldLevel3Link;
	public String ldSubcontent;
	public boolean isActive;
	public long idLinhvuc;
	public long idCoquanbanhanh;
	public String ldDonvithuchien;
	public int ldLevel;
}