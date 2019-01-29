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

package com.revotech.portal.vbpq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.revotech.portal.vbpq.model.NhomVanBan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NhomVanBan in entity cache.
 *
 * @author ChucHV
 * @see NhomVanBan
 * @generated
 */
public class NhomVanBanCacheModel implements CacheModel<NhomVanBan>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tenNhom=");
		sb.append(tenNhom);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiTaoId=");
		sb.append(nguoiTaoId);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", nguoiSuaId=");
		sb.append(nguoiSuaId);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NhomVanBan toEntityModel() {
		NhomVanBanImpl nhomVanBanImpl = new NhomVanBanImpl();

		nhomVanBanImpl.setId(id);

		if (tenNhom == null) {
			nhomVanBanImpl.setTenNhom(StringPool.BLANK);
		}
		else {
			nhomVanBanImpl.setTenNhom(tenNhom);
		}

		if (nguoiTao == null) {
			nhomVanBanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			nhomVanBanImpl.setNguoiTao(nguoiTao);
		}

		nhomVanBanImpl.setNguoiTaoId(nguoiTaoId);

		if (ngayTao == Long.MIN_VALUE) {
			nhomVanBanImpl.setNgayTao(null);
		}
		else {
			nhomVanBanImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			nhomVanBanImpl.setNgaySua(null);
		}
		else {
			nhomVanBanImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			nhomVanBanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			nhomVanBanImpl.setNguoiSua(nguoiSua);
		}

		nhomVanBanImpl.setNguoiSuaId(nguoiSuaId);
		nhomVanBanImpl.setTrangThai(trangThai);
		nhomVanBanImpl.setGroupId(groupId);

		nhomVanBanImpl.resetOriginalValues();

		return nhomVanBanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		tenNhom = objectInput.readUTF();
		nguoiTao = objectInput.readUTF();
		nguoiTaoId = objectInput.readLong();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
		nguoiSua = objectInput.readUTF();
		nguoiSuaId = objectInput.readLong();
		trangThai = objectInput.readInt();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (tenNhom == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tenNhom);
		}

		if (nguoiTao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiTao);
		}

		objectOutput.writeLong(nguoiTaoId);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);

		if (nguoiSua == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiSua);
		}

		objectOutput.writeLong(nguoiSuaId);
		objectOutput.writeInt(trangThai);
		objectOutput.writeLong(groupId);
	}

	public long id;
	public String tenNhom;
	public String nguoiTao;
	public long nguoiTaoId;
	public long ngayTao;
	public long ngaySua;
	public String nguoiSua;
	public long nguoiSuaId;
	public int trangThai;
	public long groupId;
}