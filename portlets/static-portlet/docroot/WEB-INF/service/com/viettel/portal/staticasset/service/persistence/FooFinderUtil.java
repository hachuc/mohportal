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

package com.viettel.portal.staticasset.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author chuchv
 */
public class FooFinderUtil {
	public static java.util.List findLatestArticleByTagName(
		java.lang.String tagName, int begin, int end) {
		return getFinder().findLatestArticleByTagName(tagName, begin, end);
	}

	public static FooFinder getFinder() {
		if (_finder == null) {
			_finder = (FooFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.staticasset.service.ClpSerializer.getServletContextName(),
					FooFinder.class.getName());

			ReferenceRegistry.registerReference(FooFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(FooFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FooFinderUtil.class, "_finder");
	}

	private static FooFinder _finder;
}