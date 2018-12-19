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
public class LegalDocumentFinderUtil {
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> searchByStatusVersion(
		java.lang.String keywords, long groupId, long category1Id,
		long category12d, int level, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchByStatusVersion(keywords, groupId, category1Id,
			category12d, level, start, end);
	}

	public static java.util.List searchFieldByStatusVersion(
		java.lang.String keywords, long groupId, long category1Id,
		long category12d, int level, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchFieldByStatusVersion(keywords, groupId, category1Id,
			category12d, level, start, end);
	}

	public static int countByStatusVersion(java.lang.String keywords,
		long groupId, long category1Id, long category2Id, int level)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByStatusVersion(keywords, groupId, category1Id,
			category2Id, level);
	}

	public static LegalDocumentFinder getFinder() {
		if (_finder == null) {
			_finder = (LegalDocumentFinder)PortletBeanLocatorUtil.locate(com.revotech.portal.tthc.service.ClpSerializer.getServletContextName(),
					LegalDocumentFinder.class.getName());

			ReferenceRegistry.registerReference(LegalDocumentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(LegalDocumentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(LegalDocumentFinderUtil.class,
			"_finder");
	}

	private static LegalDocumentFinder _finder;
}