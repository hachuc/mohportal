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

package com.viettel.portal.thongke.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author lamvn
 */
public class PhongBanNhuanButFinderUtil {
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findPhongBanNhuanButs(
		long groupId, java.lang.String keyword, java.util.Date fromDate,
		java.util.Date toDate, int start, int end) {
		return getFinder()
				   .findPhongBanNhuanButs(groupId, keyword, fromDate, toDate,
			start, end);
	}

	public static int countPhongBanNhuanButs(long groupId,
		java.lang.String keyword, java.util.Date fromDate, java.util.Date toDate) {
		return getFinder()
				   .countPhongBanNhuanButs(groupId, keyword, fromDate, toDate);
	}

	public static PhongBanNhuanButFinder getFinder() {
		if (_finder == null) {
			_finder = (PhongBanNhuanButFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.thongke.service.ClpSerializer.getServletContextName(),
					PhongBanNhuanButFinder.class.getName());

			ReferenceRegistry.registerReference(PhongBanNhuanButFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PhongBanNhuanButFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PhongBanNhuanButFinderUtil.class,
			"_finder");
	}

	private static PhongBanNhuanButFinder _finder;
}