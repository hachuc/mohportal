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

import com.viettel.portal.magazine.model.Magazine;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Magazine in entity cache.
 *
 * @author namtv
 * @see Magazine
 * @generated
 */
public class MagazineCacheModel implements CacheModel<Magazine>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", PublishNumber=");
		sb.append(PublishNumber);
		sb.append(", PublishYear=");
		sb.append(PublishYear);
		sb.append(", ImageUrl=");
		sb.append(ImageUrl);
		sb.append(", ImageID=");
		sb.append(ImageID);
		sb.append(", CreationDate=");
		sb.append(CreationDate);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append(", DistributedDate=");
		sb.append(DistributedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Magazine toEntityModel() {
		MagazineImpl magazineImpl = new MagazineImpl();

		magazineImpl.setID(ID);

		if (Name == null) {
			magazineImpl.setName(StringPool.BLANK);
		}
		else {
			magazineImpl.setName(Name);
		}

		magazineImpl.setPublishNumber(PublishNumber);
		magazineImpl.setPublishYear(PublishYear);

		if (ImageUrl == null) {
			magazineImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			magazineImpl.setImageUrl(ImageUrl);
		}

		magazineImpl.setImageID(ImageID);

		if (CreationDate == Long.MIN_VALUE) {
			magazineImpl.setCreationDate(null);
		}
		else {
			magazineImpl.setCreationDate(new Date(CreationDate));
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			magazineImpl.setModifiedDate(null);
		}
		else {
			magazineImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (DistributedDate == Long.MIN_VALUE) {
			magazineImpl.setDistributedDate(null);
		}
		else {
			magazineImpl.setDistributedDate(new Date(DistributedDate));
		}

		magazineImpl.resetOriginalValues();

		return magazineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		Name = objectInput.readUTF();
		PublishNumber = objectInput.readInt();
		PublishYear = objectInput.readInt();
		ImageUrl = objectInput.readUTF();
		ImageID = objectInput.readLong();
		CreationDate = objectInput.readLong();
		ModifiedDate = objectInput.readLong();
		DistributedDate = objectInput.readLong();
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

		objectOutput.writeInt(PublishNumber);
		objectOutput.writeInt(PublishYear);

		if (ImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ImageUrl);
		}

		objectOutput.writeLong(ImageID);
		objectOutput.writeLong(CreationDate);
		objectOutput.writeLong(ModifiedDate);
		objectOutput.writeLong(DistributedDate);
	}

	public int ID;
	public String Name;
	public int PublishNumber;
	public int PublishYear;
	public String ImageUrl;
	public long ImageID;
	public long CreationDate;
	public long ModifiedDate;
	public long DistributedDate;
}