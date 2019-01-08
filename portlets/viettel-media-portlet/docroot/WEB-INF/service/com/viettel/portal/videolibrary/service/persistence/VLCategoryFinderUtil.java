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

package com.viettel.portal.videolibrary.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author ChucHV
 */
public class VLCategoryFinderUtil {
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> getByGroupUserSite(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getByGroupUserSite(groupId);
	}

	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByGroup(groupId);
	}

	public static VLCategoryFinder getFinder() {
		if (_finder == null) {
			_finder = (VLCategoryFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.videolibrary.service.ClpSerializer.getServletContextName(),
					VLCategoryFinder.class.getName());

			ReferenceRegistry.registerReference(VLCategoryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VLCategoryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VLCategoryFinderUtil.class,
			"_finder");
	}

	private static VLCategoryFinder _finder;
}