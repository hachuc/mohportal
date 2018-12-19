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

import com.viettel.portal.vcms.model.Legal_ContentProfit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Legal_ContentProfit in entity cache.
 *
 * @author chuchv
 * @see Legal_ContentProfit
 * @generated
 */
public class Legal_ContentProfitCacheModel implements CacheModel<Legal_ContentProfit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ContentID=");
		sb.append(ContentID);
		sb.append(", ContentTypeID=");
		sb.append(ContentTypeID);
		sb.append(", Headline=");
		sb.append(Headline);
		sb.append(", Cost=");
		sb.append(Cost);
		sb.append(", Author=");
		sb.append(Author);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", CreationDate=");
		sb.append(CreationDate);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append(", DistributedDate=");
		sb.append(DistributedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Legal_ContentProfit toEntityModel() {
		Legal_ContentProfitImpl legal_ContentProfitImpl = new Legal_ContentProfitImpl();

		legal_ContentProfitImpl.setContentID(ContentID);
		legal_ContentProfitImpl.setContentTypeID(ContentTypeID);

		if (Headline == null) {
			legal_ContentProfitImpl.setHeadline(StringPool.BLANK);
		}
		else {
			legal_ContentProfitImpl.setHeadline(Headline);
		}

		legal_ContentProfitImpl.setCost(Cost);

		if (Author == null) {
			legal_ContentProfitImpl.setAuthor(StringPool.BLANK);
		}
		else {
			legal_ContentProfitImpl.setAuthor(Author);
		}

		legal_ContentProfitImpl.setStatus(Status);

		if (CreationDate == Long.MIN_VALUE) {
			legal_ContentProfitImpl.setCreationDate(null);
		}
		else {
			legal_ContentProfitImpl.setCreationDate(new Date(CreationDate));
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			legal_ContentProfitImpl.setModifiedDate(null);
		}
		else {
			legal_ContentProfitImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (DistributedDate == Long.MIN_VALUE) {
			legal_ContentProfitImpl.setDistributedDate(null);
		}
		else {
			legal_ContentProfitImpl.setDistributedDate(new Date(DistributedDate));
		}

		legal_ContentProfitImpl.resetOriginalValues();

		return legal_ContentProfitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ContentID = objectInput.readInt();
		ContentTypeID = objectInput.readInt();
		Headline = objectInput.readUTF();
		Cost = objectInput.readDouble();
		Author = objectInput.readUTF();
		Status = objectInput.readInt();
		CreationDate = objectInput.readLong();
		ModifiedDate = objectInput.readLong();
		DistributedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ContentID);
		objectOutput.writeInt(ContentTypeID);

		if (Headline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Headline);
		}

		objectOutput.writeDouble(Cost);

		if (Author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Author);
		}

		objectOutput.writeInt(Status);
		objectOutput.writeLong(CreationDate);
		objectOutput.writeLong(ModifiedDate);
		objectOutput.writeLong(DistributedDate);
	}

	public int ContentID;
	public int ContentTypeID;
	public String Headline;
	public double Cost;
	public String Author;
	public int Status;
	public long CreationDate;
	public long ModifiedDate;
	public long DistributedDate;
}