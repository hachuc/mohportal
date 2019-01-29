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

package com.revotech.portal.videolibrary.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.revotech.portal.videolibrary.model.VLCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VLCategory in entity cache.
 *
 * @author ChucHV
 * @see VLCategory
 * @generated
 */
public class VLCategoryCacheModel implements CacheModel<VLCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", invisible=");
		sb.append(invisible);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VLCategory toEntityModel() {
		VLCategoryImpl vlCategoryImpl = new VLCategoryImpl();

		vlCategoryImpl.setCategoryId(categoryId);
		vlCategoryImpl.setGroupId(groupId);
		vlCategoryImpl.setCompanyId(companyId);
		vlCategoryImpl.setUserId(userId);

		if (userName == null) {
			vlCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			vlCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vlCategoryImpl.setCreateDate(null);
		}
		else {
			vlCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vlCategoryImpl.setModifiedDate(null);
		}
		else {
			vlCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryName == null) {
			vlCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			vlCategoryImpl.setCategoryName(categoryName);
		}

		vlCategoryImpl.setInvisible(invisible);

		vlCategoryImpl.resetOriginalValues();

		return vlCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		categoryId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		categoryName = objectInput.readUTF();
		invisible = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (categoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		objectOutput.writeBoolean(invisible);
	}

	public long categoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String categoryName;
	public boolean invisible;
}