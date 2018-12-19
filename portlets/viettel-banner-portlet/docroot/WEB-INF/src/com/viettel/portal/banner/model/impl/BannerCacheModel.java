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

package com.viettel.portal.banner.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.banner.model.Banner;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Banner in entity cache.
 *
 * @author ChucHV
 * @see Banner
 * @generated
 */
public class BannerCacheModel implements CacheModel<Banner>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileLink=");
		sb.append(fileLink);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", ngayKetThuc=");
		sb.append(ngayKetThuc);
		sb.append(", lienKet=");
		sb.append(lienKet);
		sb.append(", order_=");
		sb.append(order_);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiTaoId=");
		sb.append(nguoiTaoId);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", nguoiSuaId=");
		sb.append(nguoiSuaId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Banner toEntityModel() {
		BannerImpl bannerImpl = new BannerImpl();

		bannerImpl.setId(id);

		if (ten == null) {
			bannerImpl.setTen(StringPool.BLANK);
		}
		else {
			bannerImpl.setTen(ten);
		}

		bannerImpl.setFileId(fileId);

		if (fileLink == null) {
			bannerImpl.setFileLink(StringPool.BLANK);
		}
		else {
			bannerImpl.setFileLink(fileLink);
		}

		if (fileName == null) {
			bannerImpl.setFileName(StringPool.BLANK);
		}
		else {
			bannerImpl.setFileName(fileName);
		}

		if (fileSize == null) {
			bannerImpl.setFileSize(StringPool.BLANK);
		}
		else {
			bannerImpl.setFileSize(fileSize);
		}

		if (ngayTao == Long.MIN_VALUE) {
			bannerImpl.setNgayTao(null);
		}
		else {
			bannerImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			bannerImpl.setNgaySua(null);
		}
		else {
			bannerImpl.setNgaySua(new Date(ngaySua));
		}

		if (ngayKetThuc == Long.MIN_VALUE) {
			bannerImpl.setNgayKetThuc(null);
		}
		else {
			bannerImpl.setNgayKetThuc(new Date(ngayKetThuc));
		}

		if (lienKet == null) {
			bannerImpl.setLienKet(StringPool.BLANK);
		}
		else {
			bannerImpl.setLienKet(lienKet);
		}

		bannerImpl.setOrder_(order_);
		bannerImpl.setTrangThai(trangThai);

		if (nguoiTao == null) {
			bannerImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			bannerImpl.setNguoiTao(nguoiTao);
		}

		bannerImpl.setNguoiTaoId(nguoiTaoId);

		if (nguoiSua == null) {
			bannerImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			bannerImpl.setNguoiSua(nguoiSua);
		}

		bannerImpl.setNguoiSuaId(nguoiSuaId);
		bannerImpl.setCompanyId(companyId);
		bannerImpl.setGroupId(groupId);

		bannerImpl.resetOriginalValues();

		return bannerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ten = objectInput.readUTF();
		fileId = objectInput.readLong();
		fileLink = objectInput.readUTF();
		fileName = objectInput.readUTF();
		fileSize = objectInput.readUTF();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
		ngayKetThuc = objectInput.readLong();
		lienKet = objectInput.readUTF();
		order_ = objectInput.readInt();
		trangThai = objectInput.readBoolean();
		nguoiTao = objectInput.readUTF();
		nguoiTaoId = objectInput.readLong();
		nguoiSua = objectInput.readUTF();
		nguoiSuaId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
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

		objectOutput.writeLong(fileId);

		if (fileLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileLink);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (fileSize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileSize);
		}

		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);
		objectOutput.writeLong(ngayKetThuc);

		if (lienKet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lienKet);
		}

		objectOutput.writeInt(order_);
		objectOutput.writeBoolean(trangThai);

		if (nguoiTao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiTao);
		}

		objectOutput.writeLong(nguoiTaoId);

		if (nguoiSua == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiSua);
		}

		objectOutput.writeLong(nguoiSuaId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
	}

	public long id;
	public String ten;
	public long fileId;
	public String fileLink;
	public String fileName;
	public String fileSize;
	public long ngayTao;
	public long ngaySua;
	public long ngayKetThuc;
	public String lienKet;
	public int order_;
	public boolean trangThai;
	public String nguoiTao;
	public long nguoiTaoId;
	public String nguoiSua;
	public long nguoiSuaId;
	public long companyId;
	public long groupId;
}