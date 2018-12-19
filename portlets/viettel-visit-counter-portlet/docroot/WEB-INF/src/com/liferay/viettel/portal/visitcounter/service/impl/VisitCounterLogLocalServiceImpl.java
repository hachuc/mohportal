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

package com.liferay.viettel.portal.visitcounter.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.viettel.portal.visitcounter.model.VisitCounterLog;
import com.liferay.viettel.portal.visitcounter.service.base.VisitCounterLogLocalServiceBaseImpl;

/**
 * The implementation of the visit counter log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.viettel.portal.visitcounter.service.VisitCounterLogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hiepth6
 * @see com.liferay.viettel.portal.visitcounter.service.base.VisitCounterLogLocalServiceBaseImpl
 * @see com.liferay.viettel.portal.visitcounter.service.VisitCounterLogLocalServiceUtil
 */
public class VisitCounterLogLocalServiceImpl
	extends VisitCounterLogLocalServiceBaseImpl {
public List<VisitCounterLog> findAll() throws SystemException{
		
		return visitCounterLogPersistence.findAll();
	}
	
	public List<VisitCounterLog> findByCompany(long companyId) throws SystemException{
		
		return visitCounterLogPersistence.findByCompany(companyId);
	}
	
	public List<VisitCounterLog> findByGroup(long groupId) throws SystemException{
		
		return visitCounterLogPersistence.findByGroup(groupId);
	}
	
	public VisitCounterLog getCounterLog(long visitorLogId) throws SystemException{
		
		return visitCounterLogPersistence.fetchByPrimaryKey(visitorLogId);
	}
	
	public VisitCounterLog addCounterLog(long companyId,long groupId,long userId,String userName,
		String visitorIp,long lastAccessPageId) throws SystemException{
		TimeZone timezone = TimeZone.getTimeZone("Asia/Saigon");
		Calendar c = Calendar.getInstance(timezone);
		Date now = new Date();
		c.setTime(now);
		
		long visistorLogId = counterLocalService.increment();
		
		VisitCounterLog  counterLog = visitCounterLogPersistence.create(visistorLogId);
		
		counterLog.setVisitorIp(visitorIp);
		counterLog.setCompanyId(companyId);
		counterLog.setGroupId(groupId);
		counterLog.setUserId(userId);
		counterLog.setUserName(userName);
		counterLog.setHitCounter(STARTED_HIT_COUNTER_VALUE);
		counterLog.setLastAccessPageId(lastAccessPageId);
		counterLog.setModifiedDate(now);
		counterLog.setLastAccessDate(now);
		Calendar calr = new GregorianCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));
		
		counterLog.setCreateDate(calr.getTime());
		
		
		visitCounterLogPersistence.update(counterLog);
		
		return counterLog;
	}
	
	public void updateCounterLog(long visitorLogId, long companyId,long groupId,long userId,String userName,
		String visitorIp,int hitCounter,long lastAccessPageId) throws SystemException{
		
		VisitCounterLog  counterLog = visitCounterLogPersistence.fetchByPrimaryKey(visitorLogId);
		
		if(counterLog != null){
			
			TimeZone timezone = TimeZone.getTimeZone("Asia/Saigon");
			Calendar calendar = Calendar.getInstance(timezone);
			calendar.setTime(new Date());
			
			counterLog.setCompanyId(companyId);
			counterLog.setGroupId(groupId);
			counterLog.setUserId(userId);
			counterLog.setUserName(userName);
			counterLog.setLastAccessPageId(lastAccessPageId);
			counterLog.setHitCounter(hitCounter);
			counterLog.setModifiedDate(calendar.getTime());
			counterLog.setLastAccessDate(calendar.getTime());
			
			visitCounterLogPersistence.update(counterLog);
		}
	}
	
	public void incrementCounter(String visitorIp) throws SystemException{
		
		
		TimeZone timezone = TimeZone.getTimeZone("Asia/Saigon");
		Calendar c = Calendar.getInstance(timezone);
		Date now = new Date();
		c.setTime(now);
		Calendar calr = new GregorianCalendar(c.get(Calendar.DATE), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
		VisitCounterLog  counterLog = visitCounterLogPersistence.fetchByGIC_First(visitorIp, calr.getTime(), null);
		
		if(counterLog != null){
			//Date now = new Date();
			
			int hitCounter = counterLog.getHitCounter();
			
			hitCounter ++;
			
			counterLog.setHitCounter(hitCounter);
			counterLog.setModifiedDate(now);
			counterLog.setLastAccessDate(now);
			
			visitCounterLogPersistence.update(counterLog);
		}
	}
	public void incrementCounter(String visitorIp, long companyId, long groupId, long userId, String userName, long lastAccessPageId) throws SystemException{
		
		
		TimeZone timezone = TimeZone.getTimeZone("Asia/Saigon");
		Calendar c = Calendar.getInstance(timezone);
		Date now = new Date();
		c.setTime(now);
		Calendar calr = new GregorianCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));
		VisitCounterLog  counterLog = visitCounterLogPersistence.fetchByGIC_First(visitorIp, calr.getTime(), null);
		
		if(counterLog != null){
			//Date now = new Date();
			
			int hitCounter = counterLog.getHitCounter();
			
			hitCounter ++;
			
			counterLog.setHitCounter(hitCounter);
			counterLog.setModifiedDate(now);
			counterLog.setLastAccessDate(now);
			
			visitCounterLogPersistence.update(counterLog);
		}else{
			addCounterLog(companyId, groupId, userId, userName, visitorIp, lastAccessPageId);
		}
	}
	private static final int STARTED_HIT_COUNTER_VALUE = 1;
}