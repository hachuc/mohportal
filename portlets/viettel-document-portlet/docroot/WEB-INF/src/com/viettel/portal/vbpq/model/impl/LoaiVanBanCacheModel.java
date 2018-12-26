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

package com.viettel.portal.vbpq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.vbpq.model.LoaiVanBan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LoaiVanBan in entity cache.
 *
 * @author ChucHV
 * @see LoaiVanBan
 * @generated
 */
public class LoaiVanBanCacheModel implements CacheModel<LoaiVanBan>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", order_=");
		sb.append(order_);
		sb.append(", nhomVanBanId=");
		sb.append(nhomVanBanId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LoaiVanBan toEntityModel() {
		LoaiVanBanImpl loaiVanBanImpl = new LoaiVanBanImpl();

		loaiVanBanImpl.setId(id);

		if (ten == null) {
			loaiVanBanImpl.setTen(StringPool.BLANK);
		}
		else {
			loaiVanBanImpl.setTen(ten);
		}

		loaiVanBanImpl.setTrangThai(trangThai);

		if (ngayTao == Long.MIN_VALUE) {
			loaiVanBanImpl.setNgayTao(null);
		}
		else {
			loaiVanBanImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			loaiVanBanImpl.setNgaySua(null);
		}
		else {
			loaiVanBanImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			loaiVanBanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			loaiVanBanImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			loaiVanBanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			loaiVanBanImpl.setNguoiSua(nguoiSua);
		}

		loaiVanBanImpl.setGroupId(groupId);
		loaiVanBanImpl.setOrder_(order_);
		loaiVanBanImpl.setNhomVanBanId(nhomVanBanId);

		loaiVanBanImpl.resetOriginalValues();

		return loaiVanBanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ten = objectInput.readUTF();
		trangThai = objectInput.readBoolean();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
		nguoiTao = objectInput.readUTF();
		nguoiSua = objectInput.readUTF();
		groupId = objectInput.readLong();
		order_ = objectInput.readInt();
		nhomVanBanId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (ten == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ten);
		}

		objectOutput.writeBoolean(trangThai);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);

		if (nguoiTao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiTao);
		}

		if (nguoiSua == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiSua);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeInt(order_);
		objectOutput.writeLong(nhomVanBanId);
	}

	public long id;
	public String ten;
	public boolean trangThai;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public long groupId;
	public int order_;
	public long nhomVanBanId;
}