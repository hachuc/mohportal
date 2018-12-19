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

package com.portal_egov.portlet.legal_faq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalFAQCategory in entity cache.
 *
 * @author chuchv
 * @see LegalFAQCategory
 * @generated
 */
public class LegalFAQCategoryCacheModel implements CacheModel<LegalFAQCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryDesc=");
		sb.append(categoryDesc);
		sb.append(", categoryType=");
		sb.append(categoryType);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalFAQCategory toEntityModel() {
		LegalFAQCategoryImpl legalFAQCategoryImpl = new LegalFAQCategoryImpl();

		legalFAQCategoryImpl.setCategoryId(categoryId);
		legalFAQCategoryImpl.setCompanyId(companyId);
		legalFAQCategoryImpl.setGroupId(groupId);
		legalFAQCategoryImpl.setUserId(userId);
		legalFAQCategoryImpl.setParentId(parentId);

		if (categoryName == null) {
			legalFAQCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			legalFAQCategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			legalFAQCategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			legalFAQCategoryImpl.setCategoryDesc(categoryDesc);
		}

		legalFAQCategoryImpl.setCategoryType(categoryType);

		if (createDate == Long.MIN_VALUE) {
			legalFAQCategoryImpl.setCreateDate(null);
		}
		else {
			legalFAQCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalFAQCategoryImpl.setModifiedDate(null);
		}
		else {
			legalFAQCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalFAQCategoryImpl.resetOriginalValues();

		return legalFAQCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		categoryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		parentId = objectInput.readLong();
		categoryName = objectInput.readUTF();
		categoryDesc = objectInput.readUTF();
		categoryType = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(parentId);

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

		objectOutput.writeInt(categoryType);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long categoryId;
	public long companyId;
	public long groupId;
	public long userId;
	public long parentId;
	public String categoryName;
	public String categoryDesc;
	public int categoryType;
	public long createDate;
	public long modifiedDate;
}