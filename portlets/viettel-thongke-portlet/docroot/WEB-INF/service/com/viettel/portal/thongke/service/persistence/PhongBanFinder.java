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

/**
 * @author lamvn
 */
public interface PhongBanFinder {
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findPhongBans(
		java.lang.Long groupId, java.lang.String keyword, int start, int end);

	public java.util.List<java.lang.Object> findPhongBanRatings(
		long phongBanNhuanButId, long groupId, java.lang.String keyword,
		java.util.Date fromDate, java.util.Date toDate, int start, int end);

	public int countPhongBans(java.lang.Long groupId, java.lang.String keyword);

	public int countPhongBanRatings(long phongBanNhuanButId, long groupId,
		java.lang.String keyword, java.util.Date fromDate, java.util.Date toDate);
}