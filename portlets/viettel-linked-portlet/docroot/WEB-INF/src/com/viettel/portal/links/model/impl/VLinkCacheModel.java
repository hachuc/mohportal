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

package com.viettel.portal.links.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.links.model.VLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VLink in entity cache.
 *
 * @author ChucHV
 * @see VLink
 * @generated
 */
public class VLinkCacheModel implements CacheModel<VLink>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{linkId=");
		sb.append(linkId);
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
		sb.append(", linkName=");
		sb.append(linkName);
		sb.append(", url=");
		sb.append(url);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", corder=");
		sb.append(corder);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VLink toEntityModel() {
		VLinkImpl vLinkImpl = new VLinkImpl();

		vLinkImpl.setLinkId(linkId);
		vLinkImpl.setGroupId(groupId);
		vLinkImpl.setCompanyId(companyId);
		vLinkImpl.setUserId(userId);

		if (userName == null) {
			vLinkImpl.setUserName(StringPool.BLANK);
		}
		else {
			vLinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vLinkImpl.setCreateDate(null);
		}
		else {
			vLinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vLinkImpl.setModifiedDate(null);
		}
		else {
			vLinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (linkName == null) {
			vLinkImpl.setLinkName(StringPool.BLANK);
		}
		else {
			vLinkImpl.setLinkName(linkName);
		}

		if (url == null) {
			vLinkImpl.setUrl(StringPool.BLANK);
		}
		else {
			vLinkImpl.setUrl(url);
		}

		vLinkImpl.setIsActive(isActive);
		vLinkImpl.setCorder(corder);
		vLinkImpl.setCategoryId(categoryId);

		vLinkImpl.resetOriginalValues();

		return vLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		linkId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		linkName = objectInput.readUTF();
		url = objectInput.readUTF();
		isActive = objectInput.readBoolean();
		corder = objectInput.readInt();
		categoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(linkId);
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

		if (linkName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkName);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeBoolean(isActive);
		objectOutput.writeInt(corder);
		objectOutput.writeLong(categoryId);
	}

	public long linkId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String linkName;
	public String url;
	public boolean isActive;
	public int corder;
	public long categoryId;
}