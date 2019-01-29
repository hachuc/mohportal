package com.revotech.portal.videolibrary.util;

import javax.portlet.PortletRequest;

import com.revotech.portal.videolibrary.comparator.VideoCategoryIdComparator;
import com.revotech.portal.videolibrary.comparator.VideoCreateDateComparator;
import com.revotech.portal.videolibrary.comparator.VideoModifiedDateComparator;
import com.revotech.portal.videolibrary.comparator.VideoNameComparator;
import com.revotech.portal.videolibrary.comparator.VideoUserNameComparator;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class VideoUtil {
	public static String getLike(PortletRequest portletRequest, String param) {
		return getLike(portletRequest, param, null, true);
	}

	public static String getLike(PortletRequest portletRequest, String param,
			boolean toLowerCase) {

		return getLike(portletRequest, param, null, toLowerCase);
	}

	public static String getLike(PortletRequest portletRequest, String param,
			String defaultValue) {

		return getLike(portletRequest, param, defaultValue, true);
	}

	public static String getLike(PortletRequest portletRequest, String param,
			String defaultValue, boolean toLowerCase) {

		String value = portletRequest.getParameter(param);

		if (value != null) {
			value = value.trim();

			if (toLowerCase) {
				value = value.toLowerCase();
			}
		}

		if (Validator.isNull(value)) {
			value = defaultValue;
		} else {
			value = StringPool.PERCENT + value + StringPool.PERCENT;
		}

		return value;
	}

	public static OrderByComparator getVideoOrderByComparator(
			String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if ("asc".equals(orderByType)) {
			ascending = true;
		}

		if (Validator.equals(orderByColumn, "video-name")) {

			return new VideoNameComparator(ascending);

		} else if (Validator.equals(orderByColumn, "video-category-id")) {

			return new VideoCategoryIdComparator(ascending);

		} else if (Validator.equals(orderByColumn, "user-name")) {

			return new VideoUserNameComparator(ascending);

		} else if (Validator.equals(orderByColumn, "create-date")) {

			return new VideoCreateDateComparator(ascending);

		} else if (Validator.equals(orderByColumn, "modified-date")) {

			return new VideoModifiedDateComparator(ascending);
		}

		return null;
	}
}
