package com.viettel.portal.videolibrary.comparator;

import com.viettel.portal.videolibrary.model.VLVideo;
import com.liferay.portal.kernel.util.OrderByComparator;

public class VideoNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "portal_video.videoname ASC";

	public static final String ORDER_BY_DESC = "portal_video.videoname DESC";

	public static final String[] ORDER_BY_FIELDS = { "videoname" };

	public VideoNameComparator() {
		this(false);
	}

	public VideoNameComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		VLVideo video1 = (VLVideo) obj1;
		VLVideo video2 = (VLVideo) obj2;

		int comparatorValue = video1.getVideoName().toLowerCase()
				.compareTo(video2.getVideoName().toLowerCase());

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
