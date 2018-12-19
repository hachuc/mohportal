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

package com.portal_egov.portlet.legal_faq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author chuchv
 */
public class FeedbackFinderUtil {
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static int countFeedbacks(long groupId, java.lang.String keyword) {
		return getFinder().countFeedbacks(groupId, keyword);
	}

	public static FeedbackFinder getFinder() {
		if (_finder == null) {
			_finder = (FeedbackFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.legal_faq.service.ClpSerializer.getServletContextName(),
					FeedbackFinder.class.getName());

			ReferenceRegistry.registerReference(FeedbackFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FeedbackFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FeedbackFinderUtil.class, "_finder");
	}

	private static FeedbackFinder _finder;
}