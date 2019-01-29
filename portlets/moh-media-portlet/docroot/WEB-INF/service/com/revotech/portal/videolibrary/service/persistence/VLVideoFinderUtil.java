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

package com.revotech.portal.videolibrary.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author ChucHV
 */
public class VLVideoFinderUtil {
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideo> findByKeywordFrontend(
		long groupId, java.lang.String rank, java.lang.String docCode,
		long vlCategoryId, java.lang.String companyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder()
				   .findByKeywordFrontend(groupId, rank, docCode, vlCategoryId,
			companyName, start, end, obc);
	}

	public static long countByKeywordFrontend(long groupId,
		java.lang.String rank, java.lang.String docCode, long vlCategoryId,
		java.lang.String companyName) {
		return getFinder()
				   .countByKeywordFrontend(groupId, rank, docCode,
			vlCategoryId, companyName);
	}

	public static long countByKeyword(long groupId, long categoryId,
		java.lang.String keyword) {
		return getFinder().countByKeyword(groupId, categoryId, keyword);
	}

	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideo> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder()
				   .findByKeyword(groupId, categoryId, keyword, start, end, obc);
	}

	public static VLVideoFinder getFinder() {
		if (_finder == null) {
			_finder = (VLVideoFinder)PortletBeanLocatorUtil.locate(com.revotech.portal.videolibrary.service.ClpSerializer.getServletContextName(),
					VLVideoFinder.class.getName());

			ReferenceRegistry.registerReference(VLVideoFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VLVideoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VLVideoFinderUtil.class, "_finder");
	}

	private static VLVideoFinder _finder;
}