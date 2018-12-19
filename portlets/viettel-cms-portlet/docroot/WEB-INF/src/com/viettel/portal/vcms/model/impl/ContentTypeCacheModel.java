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

import com.viettel.portal.vcms.model.ContentType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContentType in entity cache.
 *
 * @author chuchv
 * @see ContentType
 * @generated
 */
public class ContentTypeCacheModel implements CacheModel<ContentType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{contenTypeId=");
		sb.append(contenTypeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", sortOrder=");
		sb.append(sortOrder);
		sb.append(", cost=");
		sb.append(cost);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContentType toEntityModel() {
		ContentTypeImpl contentTypeImpl = new ContentTypeImpl();

		contentTypeImpl.setContenTypeId(contenTypeId);
		contentTypeImpl.setGroupId(groupId);
		contentTypeImpl.setCompanyId(companyId);
		contentTypeImpl.setUserId(userId);

		if (name == null) {
			contentTypeImpl.setName(StringPool.BLANK);
		}
		else {
			contentTypeImpl.setName(name);
		}

		if (description == null) {
			contentTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			contentTypeImpl.setDescription(description);
		}

		contentTypeImpl.setSortOrder(sortOrder);
		contentTypeImpl.setCost(cost);

		contentTypeImpl.resetOriginalValues();

		return contentTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contenTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		sortOrder = objectInput.readInt();
		cost = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contenTypeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(sortOrder);
		objectOutput.writeDouble(cost);
	}

	public long contenTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String name;
	public String description;
	public int sortOrder;
	public double cost;
}