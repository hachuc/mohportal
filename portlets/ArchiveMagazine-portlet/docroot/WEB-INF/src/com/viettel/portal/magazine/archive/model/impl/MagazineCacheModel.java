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

import com.viettel.portal.magazine.archive.model.Magazine;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

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
		StringBundler sb = new StringBundler(15);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", PublishNumber=");
		sb.append(PublishNumber);
		sb.append(", PublishMonth=");
		sb.append(PublishMonth);
		sb.append(", PublishYear=");
		sb.append(PublishYear);
		sb.append(", ImageUrl=");
		sb.append(ImageUrl);
		sb.append(", MagazineType=");
		sb.append(MagazineType);
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
		magazineImpl.setPublishMonth(PublishMonth);
		magazineImpl.setPublishYear(PublishYear);

		if (ImageUrl == null) {
			magazineImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			magazineImpl.setImageUrl(ImageUrl);
		}

		magazineImpl.setMagazineType(MagazineType);

		magazineImpl.resetOriginalValues();

		return magazineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		Name = objectInput.readUTF();
		PublishNumber = objectInput.readInt();
		PublishMonth = objectInput.readInt();
		PublishYear = objectInput.readInt();
		ImageUrl = objectInput.readUTF();
		MagazineType = objectInput.readInt();
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
		objectOutput.writeInt(PublishMonth);
		objectOutput.writeInt(PublishYear);

		if (ImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ImageUrl);
		}

		objectOutput.writeInt(MagazineType);
	}

	public int ID;
	public String Name;
	public int PublishNumber;
	public int PublishMonth;
	public int PublishYear;
	public String ImageUrl;
	public int MagazineType;
}