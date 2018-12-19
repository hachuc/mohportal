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

import com.viettel.portal.thongke.model.BaiVietNhuanBut;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BaiVietNhuanBut in entity cache.
 *
 * @author lamvn
 * @see BaiVietNhuanBut
 * @generated
 */
public class BaiVietNhuanButCacheModel implements CacheModel<BaiVietNhuanBut>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(id);
		sb.append(", baiVietId=");
		sb.append(baiVietId);
		sb.append(", loaiBaiViet=");
		sb.append(loaiBaiViet);
		sb.append(", tieuDe=");
		sb.append(tieuDe);
		sb.append(", tacGia=");
		sb.append(tacGia);
		sb.append(", diaChi=");
		sb.append(diaChi);
		sb.append(", ngayXuatBan=");
		sb.append(ngayXuatBan);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", ratingValue=");
		sb.append(ratingValue);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BaiVietNhuanBut toEntityModel() {
		BaiVietNhuanButImpl baiVietNhuanButImpl = new BaiVietNhuanButImpl();

		baiVietNhuanButImpl.setId(id);
		baiVietNhuanButImpl.setBaiVietId(baiVietId);
		baiVietNhuanButImpl.setLoaiBaiViet(loaiBaiViet);

		if (tieuDe == null) {
			baiVietNhuanButImpl.setTieuDe(StringPool.BLANK);
		}
		else {
			baiVietNhuanButImpl.setTieuDe(tieuDe);
		}

		if (tacGia == null) {
			baiVietNhuanButImpl.setTacGia(StringPool.BLANK);
		}
		else {
			baiVietNhuanButImpl.setTacGia(tacGia);
		}

		if (diaChi == null) {
			baiVietNhuanButImpl.setDiaChi(StringPool.BLANK);
		}
		else {
			baiVietNhuanButImpl.setDiaChi(diaChi);
		}

		if (ngayXuatBan == Long.MIN_VALUE) {
			baiVietNhuanButImpl.setNgayXuatBan(null);
		}
		else {
			baiVietNhuanButImpl.setNgayXuatBan(new Date(ngayXuatBan));
		}

		if (rating == null) {
			baiVietNhuanButImpl.setRating(StringPool.BLANK);
		}
		else {
			baiVietNhuanButImpl.setRating(rating);
		}

		baiVietNhuanButImpl.setRatingValue(ratingValue);
		baiVietNhuanButImpl.setCompanyId(companyId);
		baiVietNhuanButImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			baiVietNhuanButImpl.setCreateDate(null);
		}
		else {
			baiVietNhuanButImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			baiVietNhuanButImpl.setModifyDate(null);
		}
		else {
			baiVietNhuanButImpl.setModifyDate(new Date(modifyDate));
		}

		if (userName == null) {
			baiVietNhuanButImpl.setUserName(StringPool.BLANK);
		}
		else {
			baiVietNhuanButImpl.setUserName(userName);
		}

		baiVietNhuanButImpl.setUserId(userId);
		baiVietNhuanButImpl.setType(type);

		baiVietNhuanButImpl.resetOriginalValues();

		return baiVietNhuanButImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		baiVietId = objectInput.readLong();
		loaiBaiViet = objectInput.readInt();
		tieuDe = objectInput.readUTF();
		tacGia = objectInput.readUTF();
		diaChi = objectInput.readUTF();
		ngayXuatBan = objectInput.readLong();
		rating = objectInput.readUTF();
		ratingValue = objectInput.readDouble();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifyDate = objectInput.readLong();
		userName = objectInput.readUTF();
		userId = objectInput.readLong();
		type = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(baiVietId);
		objectOutput.writeInt(loaiBaiViet);

		if (tieuDe == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tieuDe);
		}

		if (tacGia == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tacGia);
		}

		if (diaChi == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diaChi);
		}

		objectOutput.writeLong(ngayXuatBan);

		if (rating == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rating);
		}

		objectOutput.writeDouble(ratingValue);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifyDate);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeInt(type);
	}

	public long id;
	public long baiVietId;
	public int loaiBaiViet;
	public String tieuDe;
	public String tacGia;
	public String diaChi;
	public long ngayXuatBan;
	public String rating;
	public double ratingValue;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifyDate;
	public String userName;
	public long userId;
	public int type;
}