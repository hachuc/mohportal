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

package com.viettel.portal.links.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author ChucHV
 */
public class VLinkFinderUtil {
	public static com.viettel.portal.links.VLinkGrid findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByKeyword(groupId, categoryId, keyword, start, end, obc);
	}

	public static VLinkFinder getFinder() {
		if (_finder == null) {
			_finder = (VLinkFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.links.service.ClpSerializer.getServletContextName(),
					VLinkFinder.class.getName());

			ReferenceRegistry.registerReference(VLinkFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(VLinkFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VLinkFinderUtil.class, "_finder");
	}

	private static VLinkFinder _finder;
}