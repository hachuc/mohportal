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

package com.viettel.portal.vbpq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author ChucHV
 */
public class VanBanPhapQuyFinderUtil {
	public static int timKiemVanBanPhapQuyCount(java.lang.String keyword,
		long groupId, long[] loaiVanBanIds, long[] linhVucVanBanIds,
		long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .timKiemVanBanPhapQuyCount(keyword, groupId, loaiVanBanIds,
			linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds, status,
			startDateObj, endDateObj);
	}

	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> timKiemVanBanPhapQuyFind(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .timKiemVanBanPhapQuyFind(keyword, groupId, loaiVanBanIds,
			linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds, status,
			startDateObj, endDateObj, start, end, obc, orderBys);
	}

	public static com.viettel.portal.vbpq.VanBanPhapQuyGrid timKiemVanBanPhapQuy(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .timKiemVanBanPhapQuy(keyword, groupId, loaiVanBanIds,
			linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds, status,
			startDateObj, endDateObj, start, end, obc, orderBys);
	}

	public static com.viettel.portal.vbpq.VanBanPhapQuyGrid timKiemVanBanPhapQuyTheoNgayTao(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys) throws java.lang.Exception {
		return getFinder()
				   .timKiemVanBanPhapQuyTheoNgayTao(keyword, groupId,
			loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds,
			status, startDateObj, endDateObj, start, end, obc, orderBys);
	}

	public static VanBanPhapQuyFinder getFinder() {
		if (_finder == null) {
			_finder = (VanBanPhapQuyFinder)PortletBeanLocatorUtil.locate(com.viettel.portal.vbpq.service.ClpSerializer.getServletContextName(),
					VanBanPhapQuyFinder.class.getName());

			ReferenceRegistry.registerReference(VanBanPhapQuyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VanBanPhapQuyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VanBanPhapQuyFinderUtil.class,
			"_finder");
	}

	private static VanBanPhapQuyFinder _finder;
}