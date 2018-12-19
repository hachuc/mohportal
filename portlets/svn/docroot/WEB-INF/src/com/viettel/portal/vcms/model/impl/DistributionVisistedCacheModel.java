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
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.vcms.model.DistributionVisisted;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DistributionVisisted in entity cache.
 *
 * @author chuchv
 * @see DistributionVisisted
 * @generated
 */
public class DistributionVisistedCacheModel implements CacheModel<DistributionVisisted>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{visistedId=");
		sb.append(visistedId);
		sb.append(", distributionId=");
		sb.append(distributionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DistributionVisisted toEntityModel() {
		DistributionVisistedImpl distributionVisistedImpl = new DistributionVisistedImpl();

		distributionVisistedImpl.setVisistedId(visistedId);
		distributionVisistedImpl.setDistributionId(distributionId);
		distributionVisistedImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			distributionVisistedImpl.setCreateDate(null);
		}
		else {
			distributionVisistedImpl.setCreateDate(new Date(createDate));
		}

		distributionVisistedImpl.resetOriginalValues();

		return distributionVisistedImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		visistedId = objectInput.readLong();
		distributionId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(visistedId);
		objectOutput.writeLong(distributionId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
	}

	public long visistedId;
	public long distributionId;
	public long groupId;
	public long createDate;
}