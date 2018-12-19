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

package com.revotech.portal.tthc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.revotech.portal.tthc.model.Category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author hieptran
 * @see Category
 * @generated
 */
public class CategoryCacheModel implements CacheModel<Category>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

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
		sb.append(", categoryDesc=");
		sb.append(categoryDesc);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", categoryType=");
		sb.append(categoryType);
		sb.append(", catOrder=");
		sb.append(catOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setCategoryId(categoryId);
		categoryImpl.setGroupId(groupId);
		categoryImpl.setCompanyId(companyId);
		categoryImpl.setUserId(userId);

		if (userName == null) {
			categoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			categoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			categoryImpl.setCreateDate(null);
		}
		else {
			categoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			categoryImpl.setModifiedDate(null);
		}
		else {
			categoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryName == null) {
			categoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			categoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			categoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			categoryImpl.setCategoryDesc(categoryDesc);
		}

		categoryImpl.setIsActive(isActive);
		categoryImpl.setCategoryType(categoryType);
		categoryImpl.setCatOrder(catOrder);

		categoryImpl.resetOriginalValues();

		return categoryImpl;
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
		categoryDesc = objectInput.readUTF();
		isActive = objectInput.readBoolean();
		categoryType = objectInput.readInt();
		catOrder = objectInput.readInt();
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

		if (categoryDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryDesc);
		}

		objectOutput.writeBoolean(isActive);
		objectOutput.writeInt(categoryType);
		objectOutput.writeInt(catOrder);
	}

	public long categoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String categoryName;
	public String categoryDesc;
	public boolean isActive;
	public int categoryType;
	public int catOrder;
}