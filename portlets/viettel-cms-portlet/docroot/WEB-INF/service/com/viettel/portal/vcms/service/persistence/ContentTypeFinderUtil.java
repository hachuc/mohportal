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
public class ContentTypeFinderUtil {
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findByName(
		long groupId, java.lang.String keyword, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByName(groupId, keyword, start, end);
	}

	public static int countByName(long groupId, java.lang.String keyword)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByName(groupId, keyword);
	}

	public static ContentTypeFinder getFinder() {
		if (_finder == null) {
			_finder = (ContentTypeFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					ContentTypeFinder.class.getName());

			ReferenceRegistry.registerReference(ContentTypeFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContentTypeFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContentTypeFinderUtil.class,
			"_finder");
	}

	private static ContentTypeFinder _finder;
}