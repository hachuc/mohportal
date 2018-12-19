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

import com.viettel.portal.vcms.model.Notes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Notes in entity cache.
 *
 * @author chuchv
 * @see Notes
 * @generated
 */
public class NotesCacheModel implements CacheModel<Notes>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ContentID=");
		sb.append(ContentID);
		sb.append(", Version=");
		sb.append(Version);
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
		sb.append(", Content=");
		sb.append(Content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notes toEntityModel() {
		NotesImpl notesImpl = new NotesImpl();

		notesImpl.setContentID(ContentID);
		notesImpl.setVersion(Version);
		notesImpl.setGroupId(groupId);
		notesImpl.setCompanyId(companyId);
		notesImpl.setUserId(userId);

		if (userName == null) {
			notesImpl.setUserName(StringPool.BLANK);
		}
		else {
			notesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			notesImpl.setCreateDate(null);
		}
		else {
			notesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notesImpl.setModifiedDate(null);
		}
		else {
			notesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (Content == null) {
			notesImpl.setContent(StringPool.BLANK);
		}
		else {
			notesImpl.setContent(Content);
		}

		notesImpl.resetOriginalValues();

		return notesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ContentID = objectInput.readLong();
		Version = objectInput.readInt();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		Content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ContentID);
		objectOutput.writeInt(Version);
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

		if (Content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Content);
		}
	}

	public long ContentID;
	public int Version;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String Content;
}