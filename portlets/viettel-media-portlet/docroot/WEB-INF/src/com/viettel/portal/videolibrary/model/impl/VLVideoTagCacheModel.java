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

package com.viettel.portal.videolibrary.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.videolibrary.model.VLVideoTag;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VLVideoTag in entity cache.
 *
 * @author ChucHV
 * @see VLVideoTag
 * @generated
 */
public class VLVideoTagCacheModel implements CacheModel<VLVideoTag>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", tagId=");
		sb.append(tagId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VLVideoTag toEntityModel() {
		VLVideoTagImpl vlVideoTagImpl = new VLVideoTagImpl();

		vlVideoTagImpl.setId(id);
		vlVideoTagImpl.setVideoId(videoId);
		vlVideoTagImpl.setTagId(tagId);
		vlVideoTagImpl.setGroupId(groupId);

		vlVideoTagImpl.resetOriginalValues();

		return vlVideoTagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		videoId = objectInput.readLong();
		tagId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(videoId);
		objectOutput.writeLong(tagId);
		objectOutput.writeLong(groupId);
	}

	public long id;
	public long videoId;
	public long tagId;
	public long groupId;
}