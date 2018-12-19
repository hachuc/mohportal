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

/**
 * @author ChucHV
 */
public interface VanBanPhapQuyFinder {
	public int timKiemVanBanPhapQuyCount(java.lang.String keyword,
		long groupId, long[] loaiVanBanIds, long[] linhVucVanBanIds,
		long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> timKiemVanBanPhapQuyFind(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.viettel.portal.vbpq.VanBanPhapQuyGrid timKiemVanBanPhapQuy(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.viettel.portal.vbpq.VanBanPhapQuyGrid timKiemVanBanPhapQuyTheoNgayTao(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys) throws java.lang.Exception;
}