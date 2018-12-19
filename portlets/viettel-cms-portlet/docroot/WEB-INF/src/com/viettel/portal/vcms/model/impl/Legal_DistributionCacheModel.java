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

import com.viettel.portal.vcms.model.Legal_Distribution;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Legal_Distribution in entity cache.
 *
 * @author chuchv
 * @see Legal_Distribution
 * @generated
 */
public class Legal_DistributionCacheModel implements CacheModel<Legal_Distribution>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", ContentID=");
		sb.append(ContentID);
		sb.append(", Version=");
		sb.append(Version);
		sb.append(", ZoneID=");
		sb.append(ZoneID);
		sb.append(", DistributedDate=");
		sb.append(DistributedDate);
		sb.append(", Ranking=");
		sb.append(Ranking);
		sb.append(", AllowDiscussion=");
		sb.append(AllowDiscussion);
		sb.append(", ViewedCount=");
		sb.append(ViewedCount);
		sb.append(", MailedCount=");
		sb.append(MailedCount);
		sb.append(", RatedCount=");
		sb.append(RatedCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Legal_Distribution toEntityModel() {
		Legal_DistributionImpl legal_DistributionImpl = new Legal_DistributionImpl();

		legal_DistributionImpl.setID(ID);
		legal_DistributionImpl.setContentID(ContentID);
		legal_DistributionImpl.setVersion(Version);
		legal_DistributionImpl.setZoneID(ZoneID);

		if (DistributedDate == Long.MIN_VALUE) {
			legal_DistributionImpl.setDistributedDate(null);
		}
		else {
			legal_DistributionImpl.setDistributedDate(new Date(DistributedDate));
		}

		legal_DistributionImpl.setRanking(Ranking);
		legal_DistributionImpl.setAllowDiscussion(AllowDiscussion);
		legal_DistributionImpl.setViewedCount(ViewedCount);
		legal_DistributionImpl.setMailedCount(MailedCount);
		legal_DistributionImpl.setRatedCount(RatedCount);

		legal_DistributionImpl.resetOriginalValues();

		return legal_DistributionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		ContentID = objectInput.readInt();
		Version = objectInput.readInt();
		ZoneID = objectInput.readInt();
		DistributedDate = objectInput.readLong();
		Ranking = objectInput.readInt();
		AllowDiscussion = objectInput.readBoolean();
		ViewedCount = objectInput.readInt();
		MailedCount = objectInput.readInt();
		RatedCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ID);
		objectOutput.writeInt(ContentID);
		objectOutput.writeInt(Version);
		objectOutput.writeInt(ZoneID);
		objectOutput.writeLong(DistributedDate);
		objectOutput.writeInt(Ranking);
		objectOutput.writeBoolean(AllowDiscussion);
		objectOutput.writeInt(ViewedCount);
		objectOutput.writeInt(MailedCount);
		objectOutput.writeInt(RatedCount);
	}

	public int ID;
	public int ContentID;
	public int Version;
	public int ZoneID;
	public long DistributedDate;
	public int Ranking;
	public boolean AllowDiscussion;
	public int ViewedCount;
	public int MailedCount;
	public int RatedCount;
}