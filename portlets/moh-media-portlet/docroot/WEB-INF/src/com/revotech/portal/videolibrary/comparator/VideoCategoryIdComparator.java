package com.revotech.portal.videolibrary.comparator;

import com.revotech.portal.videolibrary.model.VLVideo;
import com.liferay.portal.kernel.util.OrderByComparator;

public class VideoCategoryIdComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "portal_video.categoryid ASC";

	public static final String ORDER_BY_DESC = "portal_video.categoryid DESC";

	public static final String[] ORDER_BY_FIELDS = { "categoryid" };

	public VideoCategoryIdComparator() {
		this(false);
	}

	public VideoCategoryIdComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		VLVideo video1 = (VLVideo) obj1;
		VLVideo video2 = (VLVideo) obj2;

		int comparatorValue = 0;

		if (video1.getCategoryId() < video2.getCategoryId()) {

			comparatorValue = -1;

		} else if (video1.getCategoryId() > video2.getCategoryId()) {

			comparatorValue = 1;
		}

		if (_ascending) {
			return comparatorValue;
		} else {
			return -comparatorValue;
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
