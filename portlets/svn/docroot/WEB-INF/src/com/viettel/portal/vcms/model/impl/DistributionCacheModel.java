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

import com.viettel.portal.vcms.model.Distribution;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Distribution in entity cache.
 *
 * @author chuchv
 * @see Distribution
 * @generated
 */
public class DistributionCacheModel implements CacheModel<Distribution>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{distributionId=");
		sb.append(distributionId);
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
		sb.append(", version=");
		sb.append(version);
		sb.append(", contentId=");
		sb.append(contentId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", distributedDate=");
		sb.append(distributedDate);
		sb.append(", allowDiscussion=");
		sb.append(allowDiscussion);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Distribution toEntityModel() {
		DistributionImpl distributionImpl = new DistributionImpl();

		distributionImpl.setDistributionId(distributionId);
		distributionImpl.setGroupId(groupId);
		distributionImpl.setCompanyId(companyId);
		distributionImpl.setUserId(userId);

		if (userName == null) {
			distributionImpl.setUserName(StringPool.BLANK);
		}
		else {
			distributionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			distributionImpl.setCreateDate(null);
		}
		else {
			distributionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			distributionImpl.setModifiedDate(null);
		}
		else {
			distributionImpl.setModifiedDate(new Date(modifiedDate));
		}

		distributionImpl.setVersion(version);
		distributionImpl.setContentId(contentId);
		distributionImpl.setCategoryId(categoryId);

		if (distributedDate == Long.MIN_VALUE) {
			distributionImpl.setDistributedDate(null);
		}
		else {
			distributionImpl.setDistributedDate(new Date(distributedDate));
		}

		distributionImpl.setAllowDiscussion(allowDiscussion);

		if (title == null) {
			distributionImpl.setTitle(StringPool.BLANK);
		}
		else {
			distributionImpl.setTitle(title);
		}

		distributionImpl.resetOriginalValues();

		return distributionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		distributionId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		version = objectInput.readInt();
		contentId = objectInput.readLong();
		categoryId = objectInput.readLong();
		distributedDate = objectInput.readLong();
		allowDiscussion = objectInput.readBoolean();
		title = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(distributionId);
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
		objectOutput.writeInt(version);
		objectOutput.writeLong(contentId);
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(distributedDate);
		objectOutput.writeBoolean(allowDiscussion);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}
	}

	public long distributionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int version;
	public long contentId;
	public long categoryId;
	public long distributedDate;
	public boolean allowDiscussion;
	public String title;
}