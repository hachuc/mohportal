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

package com.revotech.portal.vbpq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author ChucHV
 */
public class CoQuanBanHanhVanBanFinderUtil {
	public static int count(java.lang.String keyword, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().count(keyword, groupId);
	}

	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> find(
		java.lang.String keyword, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().find(keyword, groupId, obc, start, end);
	}

	public static CoQuanBanHanhVanBanFinder getFinder() {
		if (_finder == null) {
			_finder = (CoQuanBanHanhVanBanFinder)PortletBeanLocatorUtil.locate(com.revotech.portal.vbpq.service.ClpSerializer.getServletContextName(),
					CoQuanBanHanhVanBanFinder.class.getName());

			ReferenceRegistry.registerReference(CoQuanBanHanhVanBanFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CoQuanBanHanhVanBanFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CoQuanBanHanhVanBanFinderUtil.class,
			"_finder");
	}

	private static CoQuanBanHanhVanBanFinder _finder;
}