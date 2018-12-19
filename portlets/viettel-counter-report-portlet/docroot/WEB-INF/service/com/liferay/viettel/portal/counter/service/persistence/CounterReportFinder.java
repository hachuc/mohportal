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

package com.liferay.viettel.portal.counter.service.persistence;

/**
 * @author chuchv
 */
public interface CounterReportFinder {
	public int counterCategory(long categoryId, java.util.Date start,
		java.util.Date end);

	public int counterVisitor(java.util.Date date);

	public java.util.List counterArticle(long categoryId,
		java.util.Date startDate, java.util.Date endDate, int start, int end);

	public int countArticle(long categoryId, java.util.Date startDate,
		java.util.Date endDate, int start, int end);
}