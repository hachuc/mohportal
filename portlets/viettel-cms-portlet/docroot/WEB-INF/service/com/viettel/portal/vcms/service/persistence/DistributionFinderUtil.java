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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author chuchv
 */
public class DistributionFinderUtil {
	public static java.util.List findByVersionAndStatus(long groupId,
		long categoryId, java.lang.String keyword, long authorId,
		int searchOption, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByVersionAndStatus(groupId, categoryId, keyword,
			authorId, searchOption, start, end);
	}

	public static int countByVersionAndStatus(long groupId, long categoryId,
		java.lang.String keyword, long authorId, int searchOption)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByVersionAndStatus(groupId, categoryId, keyword,
			authorId, searchOption);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByPubishedDate(
		long groupId, long[] categoryIds, java.lang.String publishedDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByPubishedDate(groupId, categoryIds, publishedDate,
			start, end);
	}

	public static int countByPubishedDate(long groupId, long[] categoryIds,
		java.lang.String publishedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByPubishedDate(groupId, categoryIds, publishedDate);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByGroupAndCategory(
		long groupId, long[] categoryIds,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByGroupAndCategory(groupId, categoryIds, obc, start, end);
	}

	public static int countByGroupAndCategory(long groupId, long[] categoryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByGroupAndCategory(groupId, categoryIds);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findNewsestContents(
		long groupId, long distributionId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findNewsestContents(groupId, distributionId, start, end);
	}

	public static java.util.List getMostViewedNews(long groupId,
		long[] categoryIds, java.util.Date fromDate, java.util.Date toDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getMostViewedNews(groupId, categoryIds, fromDate, toDate,
			start, end);
	}

	public static DistributionFinder getFinder() {
		if (_finder == null) {
			_finder = (DistributionFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					DistributionFinder.class.getName());

			ReferenceRegistry.registerReference(DistributionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DistributionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DistributionFinderUtil.class,
			"_finder");
	}

	private static DistributionFinder _finder;
}