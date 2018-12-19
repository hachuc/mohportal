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

package com.liferay.viettel.portal.counter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author chuchv
 */
public class CounterReportFinderUtil {
	public static int counterCategory(long categoryId, java.util.Date start,
		java.util.Date end) {
		return getFinder().counterCategory(categoryId, start, end);
	}

	public static int counterVisitor(java.util.Date date) {
		return getFinder().counterVisitor(date);
	}

	public static java.util.List counterArticle(long categoryId,
		java.util.Date startDate, java.util.Date endDate, int start, int end) {
		return getFinder()
				   .counterArticle(categoryId, startDate, endDate, start, end);
	}

	public static int countArticle(long categoryId, java.util.Date startDate,
		java.util.Date endDate, int start, int end) {
		return getFinder()
				   .countArticle(categoryId, startDate, endDate, start, end);
	}

	public static CounterReportFinder getFinder() {
		if (_finder == null) {
			_finder = (CounterReportFinder)PortletBeanLocatorUtil.locate(com.liferay.viettel.portal.counter.service.ClpSerializer.getServletContextName(),
					CounterReportFinder.class.getName());

			ReferenceRegistry.registerReference(CounterReportFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CounterReportFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CounterReportFinderUtil.class,
			"_finder");
	}

	private static CounterReportFinder _finder;
}