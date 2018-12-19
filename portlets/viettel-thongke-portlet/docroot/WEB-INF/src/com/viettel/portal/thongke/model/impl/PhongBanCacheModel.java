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

import com.viettel.portal.thongke.model.PhongBan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PhongBan in entity cache.
 *
 * @author lamvn
 * @see PhongBan
 * @generated
 */
public class PhongBanCacheModel implements CacheModel<PhongBan>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", order_=");
		sb.append(order_);
		sb.append(", descriptions=");
		sb.append(descriptions);
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
	public PhongBan toEntityModel() {
		PhongBanImpl phongBanImpl = new PhongBanImpl();

		phongBanImpl.setId(id);

		if (name == null) {
			phongBanImpl.setName(StringPool.BLANK);
		}
		else {
			phongBanImpl.setName(name);
		}

		phongBanImpl.setOrder_(order_);

		if (descriptions == null) {
			phongBanImpl.setDescriptions(StringPool.BLANK);
		}
		else {
			phongBanImpl.setDescriptions(descriptions);
		}

		phongBanImpl.setStatus(status);
		phongBanImpl.setCompanyId(companyId);
		phongBanImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			phongBanImpl.setCreateDate(null);
		}
		else {
			phongBanImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			phongBanImpl.setModifyDate(null);
		}
		else {
			phongBanImpl.setModifyDate(new Date(modifyDate));
		}

		if (userName == null) {
			phongBanImpl.setUserName(StringPool.BLANK);
		}
		else {
			phongBanImpl.setUserName(userName);
		}

		phongBanImpl.setUserId(userId);

		phongBanImpl.resetOriginalValues();

		return phongBanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();
		order_ = objectInput.readInt();
		descriptions = objectInput.readUTF();
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(order_);

		if (descriptions == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descriptions);
		}

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
	public String name;
	public int order_;
	public String descriptions;
	public boolean status;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifyDate;
	public String userName;
	public long userId;
}