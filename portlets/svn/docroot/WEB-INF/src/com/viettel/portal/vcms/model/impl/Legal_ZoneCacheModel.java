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

import com.viettel.portal.vcms.model.Legal_Zone;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Legal_Zone in entity cache.
 *
 * @author chuchv
 * @see Legal_Zone
 * @generated
 */
public class Legal_ZoneCacheModel implements CacheModel<Legal_Zone>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", CreationDate=");
		sb.append(CreationDate);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", Url=");
		sb.append(Url);
		sb.append(", Description=");
		sb.append(Description);
		sb.append(", ParentID=");
		sb.append(ParentID);
		sb.append(", RealUrl=");
		sb.append(RealUrl);
		sb.append(", Visible=");
		sb.append(Visible);
		sb.append(", Archived=");
		sb.append(Archived);
		sb.append(", SortOrder=");
		sb.append(SortOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Legal_Zone toEntityModel() {
		Legal_ZoneImpl legal_ZoneImpl = new Legal_ZoneImpl();

		legal_ZoneImpl.setID(ID);

		if (CreationDate == Long.MIN_VALUE) {
			legal_ZoneImpl.setCreationDate(null);
		}
		else {
			legal_ZoneImpl.setCreationDate(new Date(CreationDate));
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			legal_ZoneImpl.setModifiedDate(null);
		}
		else {
			legal_ZoneImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (Name == null) {
			legal_ZoneImpl.setName(StringPool.BLANK);
		}
		else {
			legal_ZoneImpl.setName(Name);
		}

		if (Url == null) {
			legal_ZoneImpl.setUrl(StringPool.BLANK);
		}
		else {
			legal_ZoneImpl.setUrl(Url);
		}

		if (Description == null) {
			legal_ZoneImpl.setDescription(StringPool.BLANK);
		}
		else {
			legal_ZoneImpl.setDescription(Description);
		}

		legal_ZoneImpl.setParentID(ParentID);

		if (RealUrl == null) {
			legal_ZoneImpl.setRealUrl(StringPool.BLANK);
		}
		else {
			legal_ZoneImpl.setRealUrl(RealUrl);
		}

		legal_ZoneImpl.setVisible(Visible);
		legal_ZoneImpl.setArchived(Archived);
		legal_ZoneImpl.setSortOrder(SortOrder);

		legal_ZoneImpl.resetOriginalValues();

		return legal_ZoneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		CreationDate = objectInput.readLong();
		ModifiedDate = objectInput.readLong();
		Name = objectInput.readUTF();
		Url = objectInput.readUTF();
		Description = objectInput.readUTF();
		ParentID = objectInput.readInt();
		RealUrl = objectInput.readUTF();
		Visible = objectInput.readBoolean();
		Archived = objectInput.readBoolean();
		SortOrder = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ID);
		objectOutput.writeLong(CreationDate);
		objectOutput.writeLong(ModifiedDate);

		if (Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Name);
		}

		if (Url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Url);
		}

		if (Description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Description);
		}

		objectOutput.writeInt(ParentID);

		if (RealUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(RealUrl);
		}

		objectOutput.writeBoolean(Visible);
		objectOutput.writeBoolean(Archived);
		objectOutput.writeInt(SortOrder);
	}

	public int ID;
	public long CreationDate;
	public long ModifiedDate;
	public String Name;
	public String Url;
	public String Description;
	public int ParentID;
	public String RealUrl;
	public boolean Visible;
	public boolean Archived;
	public int SortOrder;
}