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

import com.viettel.portal.vbpq.model.VanBanPhapQuy;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VanBanPhapQuy in entity cache.
 *
 * @author ChucHV
 * @see VanBanPhapQuy
 * @generated
 */
public class VanBanPhapQuyCacheModel implements CacheModel<VanBanPhapQuy>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{id=");
		sb.append(id);
		sb.append(", maVanBan=");
		sb.append(maVanBan);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", trichYeu=");
		sb.append(trichYeu);
		sb.append(", coQuanBanHanh=");
		sb.append(coQuanBanHanh);
		sb.append(", loaiVanBan=");
		sb.append(loaiVanBan);
		sb.append(", linhVucVanBan=");
		sb.append(linhVucVanBan);
		sb.append(", ngayBanHanh=");
		sb.append(ngayBanHanh);
		sb.append(", ngayCoHieuLuc=");
		sb.append(ngayCoHieuLuc);
		sb.append(", ngayHetHieuLuc=");
		sb.append(ngayHetHieuLuc);
		sb.append(", nguoiKy=");
		sb.append(nguoiKy);
		sb.append(", vanBanThayThe=");
		sb.append(vanBanThayThe);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByDate=");
		sb.append(statusByDate);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", nhomVanBanId=");
		sb.append(nhomVanBanId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VanBanPhapQuy toEntityModel() {
		VanBanPhapQuyImpl vanBanPhapQuyImpl = new VanBanPhapQuyImpl();

		vanBanPhapQuyImpl.setId(id);

		if (maVanBan == null) {
			vanBanPhapQuyImpl.setMaVanBan(StringPool.BLANK);
		}
		else {
			vanBanPhapQuyImpl.setMaVanBan(maVanBan);
		}

		if (ngayTao == Long.MIN_VALUE) {
			vanBanPhapQuyImpl.setNgayTao(null);
		}
		else {
			vanBanPhapQuyImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			vanBanPhapQuyImpl.setNgaySua(null);
		}
		else {
			vanBanPhapQuyImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			vanBanPhapQuyImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			vanBanPhapQuyImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			vanBanPhapQuyImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			vanBanPhapQuyImpl.setNguoiSua(nguoiSua);
		}

		if (trichYeu == null) {
			vanBanPhapQuyImpl.setTrichYeu(StringPool.BLANK);
		}
		else {
			vanBanPhapQuyImpl.setTrichYeu(trichYeu);
		}

		vanBanPhapQuyImpl.setCoQuanBanHanh(coQuanBanHanh);
		vanBanPhapQuyImpl.setLoaiVanBan(loaiVanBan);
		vanBanPhapQuyImpl.setLinhVucVanBan(linhVucVanBan);

		if (ngayBanHanh == Long.MIN_VALUE) {
			vanBanPhapQuyImpl.setNgayBanHanh(null);
		}
		else {
			vanBanPhapQuyImpl.setNgayBanHanh(new Date(ngayBanHanh));
		}

		if (ngayCoHieuLuc == Long.MIN_VALUE) {
			vanBanPhapQuyImpl.setNgayCoHieuLuc(null);
		}
		else {
			vanBanPhapQuyImpl.setNgayCoHieuLuc(new Date(ngayCoHieuLuc));
		}

		if (ngayHetHieuLuc == Long.MIN_VALUE) {
			vanBanPhapQuyImpl.setNgayHetHieuLuc(null);
		}
		else {
			vanBanPhapQuyImpl.setNgayHetHieuLuc(new Date(ngayHetHieuLuc));
		}

		if (nguoiKy == null) {
			vanBanPhapQuyImpl.setNguoiKy(StringPool.BLANK);
		}
		else {
			vanBanPhapQuyImpl.setNguoiKy(nguoiKy);
		}

		vanBanPhapQuyImpl.setVanBanThayThe(vanBanThayThe);
		vanBanPhapQuyImpl.setGroupId(groupId);
		vanBanPhapQuyImpl.setStatus(status);

		if (statusByDate == Long.MIN_VALUE) {
			vanBanPhapQuyImpl.setStatusByDate(null);
		}
		else {
			vanBanPhapQuyImpl.setStatusByDate(new Date(statusByDate));
		}

		vanBanPhapQuyImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			vanBanPhapQuyImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			vanBanPhapQuyImpl.setStatusByUserName(statusByUserName);
		}

		vanBanPhapQuyImpl.setNhomVanBanId(nhomVanBanId);

		vanBanPhapQuyImpl.resetOriginalValues();

		return vanBanPhapQuyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		maVanBan = objectInput.readUTF();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
		nguoiTao = objectInput.readUTF();
		nguoiSua = objectInput.readUTF();
		trichYeu = objectInput.readUTF();
		coQuanBanHanh = objectInput.readLong();
		loaiVanBan = objectInput.readLong();
		linhVucVanBan = objectInput.readLong();
		ngayBanHanh = objectInput.readLong();
		ngayCoHieuLuc = objectInput.readLong();
		ngayHetHieuLuc = objectInput.readLong();
		nguoiKy = objectInput.readUTF();
		vanBanThayThe = objectInput.readLong();
		groupId = objectInput.readLong();
		status = objectInput.readInt();
		statusByDate = objectInput.readLong();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		nhomVanBanId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (maVanBan == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maVanBan);
		}

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

		if (trichYeu == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trichYeu);
		}

		objectOutput.writeLong(coQuanBanHanh);
		objectOutput.writeLong(loaiVanBan);
		objectOutput.writeLong(linhVucVanBan);
		objectOutput.writeLong(ngayBanHanh);
		objectOutput.writeLong(ngayCoHieuLuc);
		objectOutput.writeLong(ngayHetHieuLuc);

		if (nguoiKy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiKy);
		}

		objectOutput.writeLong(vanBanThayThe);
		objectOutput.writeLong(groupId);
		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByDate);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(nhomVanBanId);
	}

	public long id;
	public String maVanBan;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public String trichYeu;
	public long coQuanBanHanh;
	public long loaiVanBan;
	public long linhVucVanBan;
	public long ngayBanHanh;
	public long ngayCoHieuLuc;
	public long ngayHetHieuLuc;
	public String nguoiKy;
	public long vanBanThayThe;
	public long groupId;
	public int status;
	public long statusByDate;
	public long statusByUserId;
	public String statusByUserName;
	public long nhomVanBanId;
}