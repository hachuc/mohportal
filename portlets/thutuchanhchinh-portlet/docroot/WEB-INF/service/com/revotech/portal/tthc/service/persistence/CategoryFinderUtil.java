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

package com.revotech.portal.tthc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author hieptran
 */
public class CategoryFinderUtil {
	public static int countByKeyword(java.lang.String keyword, long groupId,
		int categoryType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeyword(keyword, groupId, categoryType);
	}

	public static java.util.List<com.revotech.portal.tthc.model.Category> findByKeyword(
		java.lang.String keyword, long groupId, int categoryType, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByKeyword(keyword, groupId, categoryType, start, end);
	}

	public static CategoryFinder getFinder() {
		if (_finder == null) {
			_finder = (CategoryFinder)PortletBeanLocatorUtil.locate(com.revotech.portal.tthc.service.ClpSerializer.getServletContextName(),
					CategoryFinder.class.getName());

			ReferenceRegistry.registerReference(CategoryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CategoryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CategoryFinderUtil.class, "_finder");
	}

	private static CategoryFinder _finder;
}