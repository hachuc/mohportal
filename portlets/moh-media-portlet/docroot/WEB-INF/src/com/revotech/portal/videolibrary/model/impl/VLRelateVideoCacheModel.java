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

import com.revotech.portal.videolibrary.model.VLRelateVideo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VLRelateVideo in entity cache.
 *
 * @author ChucHV
 * @see VLRelateVideo
 * @generated
 */
public class VLRelateVideoCacheModel implements CacheModel<VLRelateVideo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", relateId=");
		sb.append(relateId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VLRelateVideo toEntityModel() {
		VLRelateVideoImpl vlRelateVideoImpl = new VLRelateVideoImpl();

		vlRelateVideoImpl.setId(id);
		vlRelateVideoImpl.setVideoId(videoId);
		vlRelateVideoImpl.setRelateId(relateId);
		vlRelateVideoImpl.setGroupId(groupId);

		vlRelateVideoImpl.resetOriginalValues();

		return vlRelateVideoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		videoId = objectInput.readLong();
		relateId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(videoId);
		objectOutput.writeLong(relateId);
		objectOutput.writeLong(groupId);
	}

	public long id;
	public long videoId;
	public long relateId;
	public long groupId;
}