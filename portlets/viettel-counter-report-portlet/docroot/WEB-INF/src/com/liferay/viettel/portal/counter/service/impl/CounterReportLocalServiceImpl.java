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

package com.liferay.viettel.portal.counter.service.impl;

import com.liferay.viettel.portal.counter.service.base.CounterReportLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import com.liferay.viettel.portal.counter.ReportCounter;
/**
 * The implementation of the counter report local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.viettel.portal.counter.service.CounterReportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.liferay.viettel.portal.counter.service.base.CounterReportLocalServiceBaseImpl
 * @see com.liferay.viettel.portal.counter.service.CounterReportLocalServiceUtil
 */
public class CounterReportLocalServiceImpl
	extends CounterReportLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.viettel.portal.counter.service.CounterReportLocalServiceUtil} to access the counter report local service.
	 */
	public int counterCategory(long categoryId, Date start, Date end){
		return counterReportFinder.counterCategory(categoryId, start, end);
	}
	
	public List<ReportCounter> counterArticle(long categoryId,Date startDate, Date endDate, int start, int end){
		return counterReportFinder.counterArticle(categoryId,startDate, endDate, start, end);
	}
	
	public int countArticle(long categoryId,Date startDate, Date endDate, int start, int end){
		return counterReportFinder.countArticle(categoryId,startDate, endDate, start, end);
	}
	
	public int counterVisitor(Date date){
		return counterReportFinder.counterVisitor(date);
	}
}