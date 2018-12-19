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

package com.portal_egov.portlet.legal_faq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author chuchv
 */
public class LegalFAQCategoryFinderUtil {
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByKeyword(
		long groupId, int type, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, type, keyword, start, end);
	}

	public static LegalFAQCategoryFinder getFinder() {
		if (_finder == null) {
			_finder = (LegalFAQCategoryFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.legal_faq.service.ClpSerializer.getServletContextName(),
					LegalFAQCategoryFinder.class.getName());

			ReferenceRegistry.registerReference(LegalFAQCategoryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(LegalFAQCategoryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(LegalFAQCategoryFinderUtil.class,
			"_finder");
	}

	private static LegalFAQCategoryFinder _finder;
}