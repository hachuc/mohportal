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

package com.viettel.portal.magazine.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author namtv
 */
public class MagazineFinderUtil {
	public static java.util.List<com.viettel.portal.magazine.model.Magazine> getLatestMagazine() {
		return getFinder().getLatestMagazine();
	}

	public static java.util.List<com.viettel.portal.magazine.model.Magazine> searchMagazine(
		long number, long year, int begin, int end) {
		return getFinder().searchMagazine(number, year, begin, end);
	}

	public static int countMagazine(long number, long year) {
		return getFinder().countMagazine(number, year);
	}

	public static MagazineFinder getFinder() {
		if (_finder == null) {
			_finder = (MagazineFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.magazine.service.ClpSerializer.getServletContextName(),
					MagazineFinder.class.getName());

			ReferenceRegistry.registerReference(MagazineFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(MagazineFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(MagazineFinderUtil.class, "_finder");
	}

	private static MagazineFinder _finder;
}