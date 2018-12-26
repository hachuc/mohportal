/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.viettel.portal.videolibrary.comparator;

import com.viettel.portal.videolibrary.model.VLVideo;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class VideoCreateDateComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = " portal_video.createDate ASC";

	public static final String ORDER_BY_DESC = " portal_video.createDate DESC";

	public static final String[] ORDER_BY_FIELDS = { "createDate" };

	public VideoCreateDateComparator() {

		this(false);
	}

	public VideoCreateDateComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		VLVideo video1 = (VLVideo) obj1;
		VLVideo video2 = (VLVideo) obj2;

		int value = DateUtil.compareTo(video1.getCreateDate(),
				video2.getCreateDate());

		if (_ascending) {
			return value;
		} else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {

		if (_ascending) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {

		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {

		return _ascending;
	}

	private boolean _ascending;

}