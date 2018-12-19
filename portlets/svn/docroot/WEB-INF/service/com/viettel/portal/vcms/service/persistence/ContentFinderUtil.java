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
public class ContentFinderUtil {
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CA_AU_V_S(
		java.lang.String keyword, long groupId, long categoryId, long authorId,
		int[] status, int[] version,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_CA_AU_V_S(keyword, groupId, categoryId, authorId,
			status, version, obc, start, end);
	}

	public static int countByG_CA_AU_V_S(java.lang.String keyword,
		long groupId, long categoryId, long authorId, int[] status,
		int[] version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByG_CA_AU_V_S(keyword, groupId, categoryId, authorId,
			status, version);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Content> searchByStatusVersion(
		java.lang.String keyword, long groupId, long categoryId, long authorId,
		int[] status, int[] version, int searchOption,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchByStatusVersion(keyword, groupId, categoryId,
			authorId, status, version, searchOption, obc, start, end);
	}

	public static com.viettel.portal.vcms.model.Content findByAutoId(
		long autoId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByAutoId(autoId, groupId);
	}

	public static com.viettel.portal.vcms.model.Content findByContentId(
		long contentId, long groupId, int version, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByContentId(contentId, groupId, version, status);
	}

	public static int countByStatusVersion(java.lang.String keyword,
		long groupId, long categoryId, long authorId, int[] status,
		int[] version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByStatusVersion(keyword, groupId, categoryId,
			authorId, status, version);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Content> findByKeyword(
		java.lang.String keyword, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByKeyword(keyword, groupId, categoryId, obc, start, end);
	}

	public static int countByKeyword(java.lang.String keyword, long groupId,
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeyword(keyword, groupId, categoryId);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Content> findByCategory(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByCategory(groupId, categoryId, obc, start, end);
	}

	public static int countByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByCategory(groupId, categoryId);
	}

	public static ContentFinder getFinder() {
		if (_finder == null) {
			_finder = (ContentFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					ContentFinder.class.getName());

			ReferenceRegistry.registerReference(ContentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContentFinderUtil.class, "_finder");
	}

	private static ContentFinder _finder;
}