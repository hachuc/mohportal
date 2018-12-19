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

import com.liferay.viettel.portal.visitcounter.model.VisitCounterLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VisitCounterLog in entity cache.
 *
 * @author hiepth6
 * @see VisitCounterLog
 * @generated
 */
public class VisitCounterLogCacheModel implements CacheModel<VisitCounterLog>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{visitorIp=");
		sb.append(visitorIp);
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
		sb.append(", hitCounter=");
		sb.append(hitCounter);
		sb.append(", lastAccessPageId=");
		sb.append(lastAccessPageId);
		sb.append(", lastAccessDate=");
		sb.append(lastAccessDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VisitCounterLog toEntityModel() {
		VisitCounterLogImpl visitCounterLogImpl = new VisitCounterLogImpl();

		if (visitorIp == null) {
			visitCounterLogImpl.setVisitorIp(StringPool.BLANK);
		}
		else {
			visitCounterLogImpl.setVisitorIp(visitorIp);
		}

		visitCounterLogImpl.setCompanyId(companyId);
		visitCounterLogImpl.setGroupId(groupId);
		visitCounterLogImpl.setUserId(userId);

		if (userName == null) {
			visitCounterLogImpl.setUserName(StringPool.BLANK);
		}
		else {
			visitCounterLogImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			visitCounterLogImpl.setCreateDate(null);
		}
		else {
			visitCounterLogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			visitCounterLogImpl.setModifiedDate(null);
		}
		else {
			visitCounterLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		visitCounterLogImpl.setHitCounter(hitCounter);
		visitCounterLogImpl.setLastAccessPageId(lastAccessPageId);

		if (lastAccessDate == Long.MIN_VALUE) {
			visitCounterLogImpl.setLastAccessDate(null);
		}
		else {
			visitCounterLogImpl.setLastAccessDate(new Date(lastAccessDate));
		}

		visitCounterLogImpl.resetOriginalValues();

		return visitCounterLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		visitorIp = objectInput.readUTF();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		hitCounter = objectInput.readInt();
		lastAccessPageId = objectInput.readLong();
		lastAccessDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (visitorIp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(visitorIp);
		}

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
		objectOutput.writeInt(hitCounter);
		objectOutput.writeLong(lastAccessPageId);
		objectOutput.writeLong(lastAccessDate);
	}

	public String visitorIp;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int hitCounter;
	public long lastAccessPageId;
	public long lastAccessDate;
}