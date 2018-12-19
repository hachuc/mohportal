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

import com.viettel.portal.vcms.model.Legal_Comment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Legal_Comment in entity cache.
 *
 * @author chuchv
 * @see Legal_Comment
 * @generated
 */
public class Legal_CommentCacheModel implements CacheModel<Legal_Comment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", DistributionID=");
		sb.append(DistributionID);
		sb.append(", Fullname=");
		sb.append(Fullname);
		sb.append(", Address=");
		sb.append(Address);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", Body=");
		sb.append(Body);
		sb.append(", Visible=");
		sb.append(Visible);
		sb.append(", CreationDate=");
		sb.append(CreationDate);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append(", IPAddress=");
		sb.append(IPAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Legal_Comment toEntityModel() {
		Legal_CommentImpl legal_CommentImpl = new Legal_CommentImpl();

		legal_CommentImpl.setID(ID);
		legal_CommentImpl.setDistributionID(DistributionID);

		if (Fullname == null) {
			legal_CommentImpl.setFullname(StringPool.BLANK);
		}
		else {
			legal_CommentImpl.setFullname(Fullname);
		}

		if (Address == null) {
			legal_CommentImpl.setAddress(StringPool.BLANK);
		}
		else {
			legal_CommentImpl.setAddress(Address);
		}

		if (Email == null) {
			legal_CommentImpl.setEmail(StringPool.BLANK);
		}
		else {
			legal_CommentImpl.setEmail(Email);
		}

		if (Body == null) {
			legal_CommentImpl.setBody(StringPool.BLANK);
		}
		else {
			legal_CommentImpl.setBody(Body);
		}

		legal_CommentImpl.setVisible(Visible);

		if (CreationDate == Long.MIN_VALUE) {
			legal_CommentImpl.setCreationDate(null);
		}
		else {
			legal_CommentImpl.setCreationDate(new Date(CreationDate));
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			legal_CommentImpl.setModifiedDate(null);
		}
		else {
			legal_CommentImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (IPAddress == null) {
			legal_CommentImpl.setIPAddress(StringPool.BLANK);
		}
		else {
			legal_CommentImpl.setIPAddress(IPAddress);
		}

		legal_CommentImpl.resetOriginalValues();

		return legal_CommentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		DistributionID = objectInput.readInt();
		Fullname = objectInput.readUTF();
		Address = objectInput.readUTF();
		Email = objectInput.readUTF();
		Body = objectInput.readUTF();
		Visible = objectInput.readBoolean();
		CreationDate = objectInput.readLong();
		ModifiedDate = objectInput.readLong();
		IPAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ID);
		objectOutput.writeInt(DistributionID);

		if (Fullname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Fullname);
		}

		if (Address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Address);
		}

		if (Email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Email);
		}

		if (Body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Body);
		}

		objectOutput.writeBoolean(Visible);
		objectOutput.writeLong(CreationDate);
		objectOutput.writeLong(ModifiedDate);

		if (IPAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(IPAddress);
		}
	}

	public int ID;
	public int DistributionID;
	public String Fullname;
	public String Address;
	public String Email;
	public String Body;
	public boolean Visible;
	public long CreationDate;
	public long ModifiedDate;
	public String IPAddress;
}