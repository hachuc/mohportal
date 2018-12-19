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
public class CommentFinderUtil {
	public static java.util.List<com.viettel.portal.vcms.model.Comment> findByKeywords(
		long companyId, long groupId, java.lang.String keywords, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByKeywords(companyId, groupId, keywords, start, end);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Comment> findByC_G_F_E_B(
		long companyId, long groupId, java.lang.String[] fullNames,
		java.lang.String[] emails, java.lang.String[] body,
		boolean andOperator, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_G_F_E_B(companyId, groupId, fullNames, emails,
			body, andOperator, start, end);
	}

	public static int countByKeywords(long companyId, long groupId,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeywords(companyId, groupId, keywords);
	}

	public static int countByC_G_F_N_D(long companyId, long groupId,
		java.lang.String fullName, java.lang.String email,
		java.lang.String body, boolean andOperator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_G_F_N_D(companyId, groupId, fullName, email, body,
			andOperator);
	}

	public static int countByC_G_F_N_D(long companyId, long groupId,
		java.lang.String[] feedIds, java.lang.String[] names,
		java.lang.String[] descriptions, boolean andOperator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_G_F_N_D(companyId, groupId, feedIds, names,
			descriptions, andOperator);
	}

	public static java.util.List customSearchByKeywords(long companyId,
		long groupId, java.lang.String keywords, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .customSearchByKeywords(companyId, groupId, keywords, type,
			start, end);
	}

	public static java.util.List customOneFieldSearchByC_G_F_E_B(
		long companyId, long groupId, java.lang.String[] keywords, int type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .customOneFieldSearchByC_G_F_E_B(companyId, groupId,
			keywords, type, start, end);
	}

	public static java.util.List customSearchByC_G_F_E_B(long companyId,
		long groupId, java.lang.String[] fullNames, java.lang.String[] emails,
		java.lang.String[] body, boolean andOperator, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .customSearchByC_G_F_E_B(companyId, groupId, fullNames,
			emails, body, andOperator, start, end);
	}

	public static int customCountByKeywords(long companyId, long groupId,
		java.lang.String keywords, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .customCountByKeywords(companyId, groupId, keywords, type);
	}

	public static int customCountByC_G_F_N_D(long companyId, long groupId,
		java.lang.String[] feedIds, java.lang.String[] names,
		java.lang.String[] descriptions, boolean andOperator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .customCountByC_G_F_N_D(companyId, groupId, feedIds, names,
			descriptions, andOperator);
	}

	public static int customCountOneFieldByC_G_F_N_D(long companyId,
		long groupId, java.lang.String[] searchKeywords, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .customCountOneFieldByC_G_F_N_D(companyId, groupId,
			searchKeywords, type);
	}

	public static CommentFinder getFinder() {
		if (_finder == null) {
			_finder = (CommentFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					CommentFinder.class.getName());

			ReferenceRegistry.registerReference(CommentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CommentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CommentFinderUtil.class, "_finder");
	}

	private static CommentFinder _finder;
}