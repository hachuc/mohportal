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

package com.viettel.portal.thongke.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.thongke.model.ContentTypeCost;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContentTypeCost in entity cache.
 *
 * @author lamvn
 * @see ContentTypeCost
 * @generated
 */
public class ContentTypeCostCacheModel implements CacheModel<ContentTypeCost>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{costId=");
		sb.append(costId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", contentTypeID=");
		sb.append(contentTypeID);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", cost=");
		sb.append(cost);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContentTypeCost toEntityModel() {
		ContentTypeCostImpl contentTypeCostImpl = new ContentTypeCostImpl();

		contentTypeCostImpl.setCostId(costId);
		contentTypeCostImpl.setGroupId(groupId);
		contentTypeCostImpl.setContentTypeID(contentTypeID);

		if (fromDate == Long.MIN_VALUE) {
			contentTypeCostImpl.setFromDate(null);
		}
		else {
			contentTypeCostImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			contentTypeCostImpl.setToDate(null);
		}
		else {
			contentTypeCostImpl.setToDate(new Date(toDate));
		}

		contentTypeCostImpl.setCost(cost);

		contentTypeCostImpl.resetOriginalValues();

		return contentTypeCostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		costId = objectInput.readInt();
		groupId = objectInput.readLong();
		contentTypeID = objectInput.readInt();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		cost = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(costId);
		objectOutput.writeLong(groupId);
		objectOutput.writeInt(contentTypeID);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
		objectOutput.writeDouble(cost);
	}

	public int costId;
	public long groupId;
	public int contentTypeID;
	public long fromDate;
	public long toDate;
	public double cost;
}