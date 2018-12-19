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

package com.liferay.viettel.portal.visitcounter.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.viettel.portal.visitcounter.model.VisitCounter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VisitCounter in entity cache.
 *
 * @author hiepth6
 * @see VisitCounter
 * @generated
 */
public class VisitCounterCacheModel implements CacheModel<VisitCounter>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{counterId=");
		sb.append(counterId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", totalHitCounter=");
		sb.append(totalHitCounter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VisitCounter toEntityModel() {
		VisitCounterImpl visitCounterImpl = new VisitCounterImpl();

		visitCounterImpl.setCounterId(counterId);
		visitCounterImpl.setCompanyId(companyId);
		visitCounterImpl.setGroupId(groupId);
		visitCounterImpl.setUserId(userId);

		if (userName == null) {
			visitCounterImpl.setUserName(StringPool.BLANK);
		}
		else {
			visitCounterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			visitCounterImpl.setCreateDate(null);
		}
		else {
			visitCounterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			visitCounterImpl.setModifiedDate(null);
		}
		else {
			visitCounterImpl.setModifiedDate(new Date(modifiedDate));
		}

		visitCounterImpl.setTotalHitCounter(totalHitCounter);

		visitCounterImpl.resetOriginalValues();

		return visitCounterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		counterId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		totalHitCounter = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(counterId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(totalHitCounter);
	}

	public long counterId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int totalHitCounter;
}