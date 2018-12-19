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

package com.viettel.portal.magazine.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author namtv
 */
public class MagazineContentFinderUtil {
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> getOlderContent(
		int ID, int MagazineID, int MagazineZoneID, int SortOrder) {
		return getFinder()
				   .getOlderContent(ID, MagazineID, MagazineZoneID, SortOrder);
	}

	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> getNewerContent(
		int ID, int MagazineID, int MagazineZoneID, int SortOrder) {
		return getFinder()
				   .getNewerContent(ID, MagazineID, MagazineZoneID, SortOrder);
	}

	public static MagazineContentFinder getFinder() {
		if (_finder == null) {
			_finder = (MagazineContentFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.magazine.service.ClpSerializer.getServletContextName(),
					MagazineContentFinder.class.getName());

			ReferenceRegistry.registerReference(MagazineContentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(MagazineContentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(MagazineContentFinderUtil.class,
			"_finder");
	}

	private static MagazineContentFinder _finder;
}