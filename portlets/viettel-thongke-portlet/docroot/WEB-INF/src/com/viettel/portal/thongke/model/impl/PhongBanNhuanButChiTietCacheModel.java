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

package com.viettel.portal.thongke.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PhongBanNhuanButChiTiet in entity cache.
 *
 * @author lamvn
 * @see PhongBanNhuanButChiTiet
 * @generated
 */
public class PhongBanNhuanButChiTietCacheModel implements CacheModel<PhongBanNhuanButChiTiet>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", phongBanNhuanButId=");
		sb.append(phongBanNhuanButId);
		sb.append(", phongBanId=");
		sb.append(phongBanId);
		sb.append(", phongBanTen=");
		sb.append(phongBanTen);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", ratingValue=");
		sb.append(ratingValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhongBanNhuanButChiTiet toEntityModel() {
		PhongBanNhuanButChiTietImpl phongBanNhuanButChiTietImpl = new PhongBanNhuanButChiTietImpl();

		phongBanNhuanButChiTietImpl.setId(id);
		phongBanNhuanButChiTietImpl.setPhongBanNhuanButId(phongBanNhuanButId);
		phongBanNhuanButChiTietImpl.setPhongBanId(phongBanId);

		if (phongBanTen == null) {
			phongBanNhuanButChiTietImpl.setPhongBanTen(StringPool.BLANK);
		}
		else {
			phongBanNhuanButChiTietImpl.setPhongBanTen(phongBanTen);
		}

		if (rating == null) {
			phongBanNhuanButChiTietImpl.setRating(StringPool.BLANK);
		}
		else {
			phongBanNhuanButChiTietImpl.setRating(rating);
		}

		phongBanNhuanButChiTietImpl.setRatingValue(ratingValue);

		phongBanNhuanButChiTietImpl.resetOriginalValues();

		return phongBanNhuanButChiTietImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		phongBanNhuanButId = objectInput.readLong();
		phongBanId = objectInput.readLong();
		phongBanTen = objectInput.readUTF();
		rating = objectInput.readUTF();
		ratingValue = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(phongBanNhuanButId);
		objectOutput.writeLong(phongBanId);

		if (phongBanTen == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phongBanTen);
		}

		if (rating == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rating);
		}

		objectOutput.writeDouble(ratingValue);
	}

	public long id;
	public long phongBanNhuanButId;
	public long phongBanId;
	public String phongBanTen;
	public String rating;
	public double ratingValue;
}