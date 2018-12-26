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

package com.viettel.portal.vbpq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.vbpq.model.AttachFile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AttachFile in entity cache.
 *
 * @author ChucHV
 * @see AttachFile
 * @generated
 */
public class AttachFileCacheModel implements CacheModel<AttachFile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", vanBanId=");
		sb.append(vanBanId);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileLink=");
		sb.append(fileLink);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttachFile toEntityModel() {
		AttachFileImpl attachFileImpl = new AttachFileImpl();

		attachFileImpl.setId(id);
		attachFileImpl.setVanBanId(vanBanId);
		attachFileImpl.setFileId(fileId);

		if (fileLink == null) {
			attachFileImpl.setFileLink(StringPool.BLANK);
		}
		else {
			attachFileImpl.setFileLink(fileLink);
		}

		if (fileName == null) {
			attachFileImpl.setFileName(StringPool.BLANK);
		}
		else {
			attachFileImpl.setFileName(fileName);
		}

		if (fileSize == null) {
			attachFileImpl.setFileSize(StringPool.BLANK);
		}
		else {
			attachFileImpl.setFileSize(fileSize);
		}

		attachFileImpl.resetOriginalValues();

		return attachFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		vanBanId = objectInput.readLong();
		fileId = objectInput.readLong();
		fileLink = objectInput.readUTF();
		fileName = objectInput.readUTF();
		fileSize = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(vanBanId);
		objectOutput.writeLong(fileId);

		if (fileLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileLink);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (fileSize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileSize);
		}
	}

	public long id;
	public long vanBanId;
	public long fileId;
	public String fileLink;
	public String fileName;
	public String fileSize;
}