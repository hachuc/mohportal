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

package com.viettel.portal.magazine.archive.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.magazine.archive.model.Content;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Content in entity cache.
 *
 * @author namtv
 * @see Content
 * @generated
 */
public class ContentCacheModel implements CacheModel<Content>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", Subject=");
		sb.append(Subject);
		sb.append(", NormalZoneID=");
		sb.append(NormalZoneID);
		sb.append(", SpecialZoneID=");
		sb.append(SpecialZoneID);
		sb.append(", FileUrl=");
		sb.append(FileUrl);
		sb.append(", Author=");
		sb.append(Author);
		sb.append(", AuthorTitle=");
		sb.append(AuthorTitle);
		sb.append(", MagazineID=");
		sb.append(MagazineID);
		sb.append(", SortOrder=");
		sb.append(SortOrder);
		sb.append(", CreationDate=");
		sb.append(CreationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Content toEntityModel() {
		ContentImpl contentImpl = new ContentImpl();

		contentImpl.setID(ID);

		if (Subject == null) {
			contentImpl.setSubject(StringPool.BLANK);
		}
		else {
			contentImpl.setSubject(Subject);
		}

		contentImpl.setNormalZoneID(NormalZoneID);
		contentImpl.setSpecialZoneID(SpecialZoneID);

		if (FileUrl == null) {
			contentImpl.setFileUrl(StringPool.BLANK);
		}
		else {
			contentImpl.setFileUrl(FileUrl);
		}

		if (Author == null) {
			contentImpl.setAuthor(StringPool.BLANK);
		}
		else {
			contentImpl.setAuthor(Author);
		}

		if (AuthorTitle == null) {
			contentImpl.setAuthorTitle(StringPool.BLANK);
		}
		else {
			contentImpl.setAuthorTitle(AuthorTitle);
		}

		contentImpl.setMagazineID(MagazineID);
		contentImpl.setSortOrder(SortOrder);

		if (CreationDate == Long.MIN_VALUE) {
			contentImpl.setCreationDate(null);
		}
		else {
			contentImpl.setCreationDate(new Date(CreationDate));
		}

		contentImpl.resetOriginalValues();

		return contentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		Subject = objectInput.readUTF();
		NormalZoneID = objectInput.readInt();
		SpecialZoneID = objectInput.readInt();
		FileUrl = objectInput.readUTF();
		Author = objectInput.readUTF();
		AuthorTitle = objectInput.readUTF();
		MagazineID = objectInput.readInt();
		SortOrder = objectInput.readInt();
		CreationDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ID);

		if (Subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Subject);
		}

		objectOutput.writeInt(NormalZoneID);
		objectOutput.writeInt(SpecialZoneID);

		if (FileUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(FileUrl);
		}

		if (Author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Author);
		}

		if (AuthorTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(AuthorTitle);
		}

		objectOutput.writeInt(MagazineID);
		objectOutput.writeInt(SortOrder);
		objectOutput.writeLong(CreationDate);
	}

	public int ID;
	public String Subject;
	public int NormalZoneID;
	public int SpecialZoneID;
	public String FileUrl;
	public String Author;
	public String AuthorTitle;
	public int MagazineID;
	public int SortOrder;
	public long CreationDate;
}