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

import com.viettel.portal.magazine.model.MagazineZone;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MagazineZone in entity cache.
 *
 * @author namtv
 * @see MagazineZone
 * @generated
 */
public class MagazineZoneCacheModel implements CacheModel<MagazineZone>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", MagazineID=");
		sb.append(MagazineID);
		sb.append(", SortOrder=");
		sb.append(SortOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MagazineZone toEntityModel() {
		MagazineZoneImpl magazineZoneImpl = new MagazineZoneImpl();

		magazineZoneImpl.setID(ID);

		if (Name == null) {
			magazineZoneImpl.setName(StringPool.BLANK);
		}
		else {
			magazineZoneImpl.setName(Name);
		}

		magazineZoneImpl.setMagazineID(MagazineID);
		magazineZoneImpl.setSortOrder(SortOrder);

		magazineZoneImpl.resetOriginalValues();

		return magazineZoneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		Name = objectInput.readUTF();
		MagazineID = objectInput.readInt();
		SortOrder = objectInput.readInt();
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

		objectOutput.writeInt(MagazineID);
		objectOutput.writeInt(SortOrder);
	}

	public int ID;
	public String Name;
	public int MagazineID;
	public int SortOrder;
}