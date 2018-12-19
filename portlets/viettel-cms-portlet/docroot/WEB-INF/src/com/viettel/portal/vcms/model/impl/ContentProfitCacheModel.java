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

package com.viettel.portal.vcms.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.vcms.model.ContentProfit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContentProfit in entity cache.
 *
 * @author chuchv
 * @see ContentProfit
 * @generated
 */
public class ContentProfitCacheModel implements CacheModel<ContentProfit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{contentId=");
		sb.append(contentId);
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
		sb.append(", distributedDate=");
		sb.append(distributedDate);
		sb.append(", contentTypeID=");
		sb.append(contentTypeID);
		sb.append(", headline=");
		sb.append(headline);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContentProfit toEntityModel() {
		ContentProfitImpl contentProfitImpl = new ContentProfitImpl();

		contentProfitImpl.setContentId(contentId);
		contentProfitImpl.setGroupId(groupId);
		contentProfitImpl.setCompanyId(companyId);
		contentProfitImpl.setUserId(userId);

		if (userName == null) {
			contentProfitImpl.setUserName(StringPool.BLANK);
		}
		else {
			contentProfitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contentProfitImpl.setCreateDate(null);
		}
		else {
			contentProfitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contentProfitImpl.setModifiedDate(null);
		}
		else {
			contentProfitImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (distributedDate == Long.MIN_VALUE) {
			contentProfitImpl.setDistributedDate(null);
		}
		else {
			contentProfitImpl.setDistributedDate(new Date(distributedDate));
		}

		contentProfitImpl.setContentTypeID(contentTypeID);

		if (headline == null) {
			contentProfitImpl.setHeadline(StringPool.BLANK);
		}
		else {
			contentProfitImpl.setHeadline(headline);
		}

		contentProfitImpl.setCost(cost);
		contentProfitImpl.setStatus(status);

		contentProfitImpl.resetOriginalValues();

		return contentProfitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		distributedDate = objectInput.readLong();
		contentTypeID = objectInput.readLong();
		headline = objectInput.readUTF();
		cost = objectInput.readDouble();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contentId);
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
		objectOutput.writeLong(distributedDate);
		objectOutput.writeLong(contentTypeID);

		if (headline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(headline);
		}

		objectOutput.writeDouble(cost);
		objectOutput.writeInt(status);
	}

	public long contentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long distributedDate;
	public long contentTypeID;
	public String headline;
	public double cost;
	public int status;
}