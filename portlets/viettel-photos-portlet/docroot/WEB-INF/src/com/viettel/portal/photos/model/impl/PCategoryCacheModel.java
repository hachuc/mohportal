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

package com.viettel.portal.photos.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.photos.model.PCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PCategory in entity cache.
 *
 * @author ChucHV
 * @see PCategory
 * @generated
 */
public class PCategoryCacheModel implements CacheModel<PCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", order_=");
		sb.append(order_);
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
	public PCategory toEntityModel() {
		PCategoryImpl pCategoryImpl = new PCategoryImpl();

		pCategoryImpl.setId(id);

		if (name == null) {
			pCategoryImpl.setName(StringPool.BLANK);
		}
		else {
			pCategoryImpl.setName(name);
		}

		pCategoryImpl.setOrder_(order_);
		pCategoryImpl.setStatus(status);
		pCategoryImpl.setCompanyId(companyId);
		pCategoryImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			pCategoryImpl.setCreateDate(null);
		}
		else {
			pCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			pCategoryImpl.setModifyDate(null);
		}
		else {
			pCategoryImpl.setModifyDate(new Date(modifyDate));
		}

		if (userName == null) {
			pCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			pCategoryImpl.setUserName(userName);
		}

		pCategoryImpl.setUserId(userId);

		pCategoryImpl.resetOriginalValues();

		return pCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();
		order_ = objectInput.readInt();
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
	public boolean status;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifyDate;
	public String userName;
	public long userId;
}