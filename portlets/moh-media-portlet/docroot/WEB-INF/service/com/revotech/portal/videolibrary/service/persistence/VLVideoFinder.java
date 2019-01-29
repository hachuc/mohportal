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

package com.revotech.portal.videolibrary.service.persistence;

/**
 * @author ChucHV
 */
public interface VLVideoFinder {
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideo> findByKeywordFrontend(
		long groupId, java.lang.String rank, java.lang.String docCode,
		long vlCategoryId, java.lang.String companyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc);

	public long countByKeywordFrontend(long groupId, java.lang.String rank,
		java.lang.String docCode, long vlCategoryId,
		java.lang.String companyName);

	public long countByKeyword(long groupId, long categoryId,
		java.lang.String keyword);

	public java.util.List<com.revotech.portal.videolibrary.model.VLVideo> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc);
}