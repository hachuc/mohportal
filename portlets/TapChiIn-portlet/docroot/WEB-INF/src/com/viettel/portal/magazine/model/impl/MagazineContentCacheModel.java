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

package com.viettel.portal.magazine.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.magazine.model.MagazineContent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MagazineContent in entity cache.
 *
 * @author namtv
 * @see MagazineContent
 * @generated
 */
public class MagazineContentCacheModel implements CacheModel<MagazineContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", Headline=");
		sb.append(Headline);
		sb.append(", Teaser=");
		sb.append(Teaser);
		sb.append(", Body=");
		sb.append(Body);
		sb.append(", MagazineZoneID=");
		sb.append(MagazineZoneID);
		sb.append(", MagazineID=");
		sb.append(MagazineID);
		sb.append(", Author=");
		sb.append(Author);
		sb.append(", Jobtitle=");
		sb.append(Jobtitle);
		sb.append(", ViewedCount=");
		sb.append(ViewedCount);
		sb.append(", SortOrder=");
		sb.append(SortOrder);
		sb.append(", MailedCount=");
		sb.append(MailedCount);
		sb.append(", CreationDate=");
		sb.append(CreationDate);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MagazineContent toEntityModel() {
		MagazineContentImpl magazineContentImpl = new MagazineContentImpl();

		magazineContentImpl.setID(ID);

		if (Headline == null) {
			magazineContentImpl.setHeadline(StringPool.BLANK);
		}
		else {
			magazineContentImpl.setHeadline(Headline);
		}

		if (Teaser == null) {
			magazineContentImpl.setTeaser(StringPool.BLANK);
		}
		else {
			magazineContentImpl.setTeaser(Teaser);
		}

		if (Body == null) {
			magazineContentImpl.setBody(StringPool.BLANK);
		}
		else {
			magazineContentImpl.setBody(Body);
		}

		magazineContentImpl.setMagazineZoneID(MagazineZoneID);
		magazineContentImpl.setMagazineID(MagazineID);

		if (Author == null) {
			magazineContentImpl.setAuthor(StringPool.BLANK);
		}
		else {
			magazineContentImpl.setAuthor(Author);
		}

		if (Jobtitle == null) {
			magazineContentImpl.setJobtitle(StringPool.BLANK);
		}
		else {
			magazineContentImpl.setJobtitle(Jobtitle);
		}

		magazineContentImpl.setViewedCount(ViewedCount);
		magazineContentImpl.setSortOrder(SortOrder);
		magazineContentImpl.setMailedCount(MailedCount);

		if (CreationDate == Long.MIN_VALUE) {
			magazineContentImpl.setCreationDate(null);
		}
		else {
			magazineContentImpl.setCreationDate(new Date(CreationDate));
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			magazineContentImpl.setModifiedDate(null);
		}
		else {
			magazineContentImpl.setModifiedDate(new Date(ModifiedDate));
		}

		magazineContentImpl.resetOriginalValues();

		return magazineContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		Headline = objectInput.readUTF();
		Teaser = objectInput.readUTF();
		Body = objectInput.readUTF();
		MagazineZoneID = objectInput.readInt();
		MagazineID = objectInput.readInt();
		Author = objectInput.readUTF();
		Jobtitle = objectInput.readUTF();
		ViewedCount = objectInput.readInt();
		SortOrder = objectInput.readInt();
		MailedCount = objectInput.readInt();
		CreationDate = objectInput.readLong();
		ModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ID);

		if (Headline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Headline);
		}

		if (Teaser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Teaser);
		}

		if (Body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Body);
		}

		objectOutput.writeInt(MagazineZoneID);
		objectOutput.writeInt(MagazineID);

		if (Author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Author);
		}

		if (Jobtitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Jobtitle);
		}

		objectOutput.writeInt(ViewedCount);
		objectOutput.writeInt(SortOrder);
		objectOutput.writeInt(MailedCount);
		objectOutput.writeLong(CreationDate);
		objectOutput.writeLong(ModifiedDate);
	}

	public int ID;
	public String Headline;
	public String Teaser;
	public String Body;
	public int MagazineZoneID;
	public int MagazineID;
	public String Author;
	public String Jobtitle;
	public int ViewedCount;
	public int SortOrder;
	public int MailedCount;
	public long CreationDate;
	public long ModifiedDate;
}