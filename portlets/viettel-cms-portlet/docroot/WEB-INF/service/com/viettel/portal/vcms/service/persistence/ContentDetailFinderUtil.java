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
public class ContentDetailFinderUtil {
	public static java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByVersion(
		long groupId, long contentId, int[] version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByVersion(groupId, contentId, version);
	}

	public static ContentDetailFinder getFinder() {
		if (_finder == null) {
			_finder = (ContentDetailFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					ContentDetailFinder.class.getName());

			ReferenceRegistry.registerReference(ContentDetailFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContentDetailFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContentDetailFinderUtil.class,
			"_finder");
	}

	private static ContentDetailFinder _finder;
}