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
import com.liferay.portal.model.CacheModel;

import com.revotech.portal.videolibrary.model.VLVideoCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VLVideoCategory in entity cache.
 *
 * @author ChucHV
 * @see VLVideoCategory
 * @generated
 */
public class VLVideoCategoryCacheModel implements CacheModel<VLVideoCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VLVideoCategory toEntityModel() {
		VLVideoCategoryImpl vlVideoCategoryImpl = new VLVideoCategoryImpl();

		vlVideoCategoryImpl.setId(id);
		vlVideoCategoryImpl.setCategoryId(categoryId);
		vlVideoCategoryImpl.setVideoId(videoId);
		vlVideoCategoryImpl.setGroupId(groupId);

		vlVideoCategoryImpl.resetOriginalValues();

		return vlVideoCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		categoryId = objectInput.readLong();
		videoId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(videoId);
		objectOutput.writeLong(groupId);
	}

	public long id;
	public long categoryId;
	public long videoId;
	public long groupId;
}