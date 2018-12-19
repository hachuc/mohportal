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

package com.liferay.viettel.portal.counter.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.viettel.portal.counter.model.CounterReport;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CounterReport in entity cache.
 *
 * @author chuchv
 * @see CounterReport
 * @generated
 */
public class CounterReportCacheModel implements CacheModel<CounterReport>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{reportId=");
		sb.append(reportId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CounterReport toEntityModel() {
		CounterReportImpl counterReportImpl = new CounterReportImpl();

		counterReportImpl.setReportId(reportId);
		counterReportImpl.setCompanyId(companyId);
		counterReportImpl.setGroupId(groupId);
		counterReportImpl.setUserId(userId);

		if (userName == null) {
			counterReportImpl.setUserName(StringPool.BLANK);
		}
		else {
			counterReportImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			counterReportImpl.setCreateDate(null);
		}
		else {
			counterReportImpl.setCreateDate(new Date(createDate));
		}

		counterReportImpl.resetOriginalValues();

		return counterReportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(reportId);
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
	}

	public long reportId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}