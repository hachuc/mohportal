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

package com.viettel.portal.vcms.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author chuchv
 * @generated
 */
public class NotesPK implements Comparable<NotesPK>, Serializable {
	public long ContentID;
	public int Version;

	public NotesPK() {
	}

	public NotesPK(long ContentID, int Version) {
		this.ContentID = ContentID;
		this.Version = Version;
	}

	public long getContentID() {
		return ContentID;
	}

	public void setContentID(long ContentID) {
		this.ContentID = ContentID;
	}

	public int getVersion() {
		return Version;
	}

	public void setVersion(int Version) {
		this.Version = Version;
	}

	@Override
	public int compareTo(NotesPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (ContentID < pk.ContentID) {
			value = -1;
		}
		else if (ContentID > pk.ContentID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (Version < pk.Version) {
			value = -1;
		}
		else if (Version > pk.Version) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotesPK)) {
			return false;
		}

		NotesPK pk = (NotesPK)obj;

		if ((ContentID == pk.ContentID) && (Version == pk.Version)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(ContentID) + String.valueOf(Version)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("ContentID");
		sb.append(StringPool.EQUAL);
		sb.append(ContentID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("Version");
		sb.append(StringPool.EQUAL);
		sb.append(Version);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}