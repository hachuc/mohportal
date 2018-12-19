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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.videolibrary.model.VideoCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VideoCategory in entity cache.
 *
 * @author ChucHV
 * @see VideoCategory
 * @generated
 */
public class VideoCategoryCacheModel implements CacheModel<VideoCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", Url=");
		sb.append(Url);
		sb.append(", SortOrder=");
		sb.append(SortOrder);
		sb.append(", ItemCount=");
		sb.append(ItemCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VideoCategory toEntityModel() {
		VideoCategoryImpl videoCategoryImpl = new VideoCategoryImpl();

		videoCategoryImpl.setID(ID);

		if (Name == null) {
			videoCategoryImpl.setName(StringPool.BLANK);
		}
		else {
			videoCategoryImpl.setName(Name);
		}

		if (Url == null) {
			videoCategoryImpl.setUrl(StringPool.BLANK);
		}
		else {
			videoCategoryImpl.setUrl(Url);
		}

		videoCategoryImpl.setSortOrder(SortOrder);
		videoCategoryImpl.setItemCount(ItemCount);

		videoCategoryImpl.resetOriginalValues();

		return videoCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		Name = objectInput.readUTF();
		Url = objectInput.readUTF();
		SortOrder = objectInput.readInt();
		ItemCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ID);

		if (Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Name);
		}

		if (Url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Url);
		}

		objectOutput.writeInt(SortOrder);
		objectOutput.writeInt(ItemCount);
	}

	public int ID;
	public String Name;
	public String Url;
	public int SortOrder;
	public int ItemCount;
}