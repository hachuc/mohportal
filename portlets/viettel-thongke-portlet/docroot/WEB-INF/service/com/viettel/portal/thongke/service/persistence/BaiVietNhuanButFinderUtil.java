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

package com.viettel.portal.thongke.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author lamvn
 */
public class BaiVietNhuanButFinderUtil {
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findBaiVietNhuanButs(
		int type, java.lang.Long groupId, java.lang.String keyword,
		java.util.Date fromDate, java.util.Date toDate, int start, int end) {
		return getFinder()
				   .findBaiVietNhuanButs(type, groupId, keyword, fromDate,
			toDate, start, end);
	}

	public static java.util.List<java.lang.Object> findBaiVietRatings(
		long classTypeId, int type, long groupId, java.lang.String keyword,
		java.util.Date fromDate, java.util.Date toDate, int start, int end) {
		return getFinder()
				   .findBaiVietRatings(classTypeId, type, groupId, keyword,
			fromDate, toDate, start, end);
	}

	public static int countBaiVietNhuanButs(int type, java.lang.Long groupId,
		java.lang.String keyword, java.util.Date fromDate, java.util.Date toDate) {
		return getFinder()
				   .countBaiVietNhuanButs(type, groupId, keyword, fromDate,
			toDate);
	}

	public static int countBaiVietRatings(long classTypeId, int type,
		long groupId, java.lang.String keyword, java.util.Date fromDate,
		java.util.Date toDate) {
		return getFinder()
				   .countBaiVietRatings(classTypeId, type, groupId, keyword,
			fromDate, toDate);
	}

	public static java.util.List<java.lang.Object> findBaiVietNhuanButBySQL(
		java.lang.String sql, int start, int end) {
		return getFinder().findBaiVietNhuanButBySQL(sql, start, end);
	}

	public static int countBaiVietNhuanButBySQL(java.lang.String sql) {
		return getFinder().countBaiVietNhuanButBySQL(sql);
	}

	public static BaiVietNhuanButFinder getFinder() {
		if (_finder == null) {
			_finder = (BaiVietNhuanButFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.thongke.service.ClpSerializer.getServletContextName(),
					BaiVietNhuanButFinder.class.getName());

			ReferenceRegistry.registerReference(BaiVietNhuanButFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BaiVietNhuanButFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BaiVietNhuanButFinderUtil.class,
			"_finder");
	}

	private static BaiVietNhuanButFinder _finder;
}