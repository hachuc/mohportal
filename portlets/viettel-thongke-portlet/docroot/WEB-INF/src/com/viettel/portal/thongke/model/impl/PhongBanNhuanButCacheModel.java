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

import com.viettel.portal.thongke.model.PhongBanNhuanBut;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PhongBanNhuanBut in entity cache.
 *
 * @author lamvn
 * @see PhongBanNhuanBut
 * @generated
 */
public class PhongBanNhuanButCacheModel implements CacheModel<PhongBanNhuanBut>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", caption=");
		sb.append(caption);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", status=");
		sb.append(status);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhongBanNhuanBut toEntityModel() {
		PhongBanNhuanButImpl phongBanNhuanButImpl = new PhongBanNhuanButImpl();

		phongBanNhuanButImpl.setId(id);

		if (caption == null) {
			phongBanNhuanButImpl.setCaption(StringPool.BLANK);
		}
		else {
			phongBanNhuanButImpl.setCaption(caption);
		}

		if (fromDate == Long.MIN_VALUE) {
			phongBanNhuanButImpl.setFromDate(null);
		}
		else {
			phongBanNhuanButImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			phongBanNhuanButImpl.setToDate(null);
		}
		else {
			phongBanNhuanButImpl.setToDate(new Date(toDate));
		}

		phongBanNhuanButImpl.setStatus(status);
		phongBanNhuanButImpl.setCompanyId(companyId);
		phongBanNhuanButImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			phongBanNhuanButImpl.setCreateDate(null);
		}
		else {
			phongBanNhuanButImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			phongBanNhuanButImpl.setModifyDate(null);
		}
		else {
			phongBanNhuanButImpl.setModifyDate(new Date(modifyDate));
		}

		if (userName == null) {
			phongBanNhuanButImpl.setUserName(StringPool.BLANK);
		}
		else {
			phongBanNhuanButImpl.setUserName(userName);
		}

		phongBanNhuanButImpl.setUserId(userId);

		phongBanNhuanButImpl.resetOriginalValues();

		return phongBanNhuanButImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		caption = objectInput.readUTF();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		status = objectInput.readBoolean();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifyDate = objectInput.readLong();
		userName = objectInput.readUTF();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (caption == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(caption);
		}

		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
		objectOutput.writeBoolean(status);
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
	}

	public long id;
	public String caption;
	public long fromDate;
	public long toDate;
	public boolean status;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifyDate;
	public String userName;
	public long userId;
}