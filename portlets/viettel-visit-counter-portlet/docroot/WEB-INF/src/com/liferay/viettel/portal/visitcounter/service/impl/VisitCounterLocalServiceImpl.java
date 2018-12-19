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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.viettel.portal.visitcounter.model.VisitCounter;
import com.liferay.viettel.portal.visitcounter.service.base.VisitCounterLocalServiceBaseImpl;

/**
 * The implementation of the visit counter local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.viettel.portal.visitcounter.service.VisitCounterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hiepth6
 * @see com.liferay.viettel.portal.visitcounter.service.base.VisitCounterLocalServiceBaseImpl
 * @see com.liferay.viettel.portal.visitcounter.service.VisitCounterLocalServiceUtil
 */
public class VisitCounterLocalServiceImpl
	extends VisitCounterLocalServiceBaseImpl {
public List<VisitCounter> findAll() throws SystemException{
		
		return visitCounterPersistence.findAll();
	}
	
	public List<VisitCounter> findByCompany(long companyId) throws SystemException{
		
		return visitCounterPersistence.findByCompany(companyId);
	}
	
	public List<VisitCounter> findByGroup(long groupId) throws SystemException{
		
		return visitCounterPersistence.findByGroup(groupId);
	}
	
	public VisitCounter getCounter(long counterId) throws SystemException{
		
		return visitCounterPersistence.fetchByPrimaryKey(counterId);
	}
	
	public VisitCounter addCounter(long companyId,long groupId,long userId,String userName) throws SystemException{
		
		Date now = new Date();
		
		long counterId = counterLocalService.increment();
		
		VisitCounter counter = visitCounterPersistence.create(counterId);
		
		counter.setCompanyId(companyId);
		counter.setGroupId(groupId);
		counter.setUserId(userId);
		counter.setUserName(userName);
		counter.setCreateDate(now);
		counter.setModifiedDate(now);
		counter.setTotalHitCounter(DEFAULT_COUNTER_VALUE);
		
		visitCounterPersistence.update(counter);
		
		return counter;
	}
	
	public int getCounterValue(long groupId) throws SystemException{
		
		List<VisitCounter> counterList = findByGroup(groupId);
		
		if(counterList.isEmpty()){
			
			return DEFAULT_COUNTER_VALUE;
		
		}else{
			
			VisitCounter counter = counterList.get(0);
			
			return counter.getTotalHitCounter();
		}
	}
	
	public void incrementTotalCounter(long companyId,long groupId,long userId,String userName) throws SystemException{
		
		List<VisitCounter> counterList = findByGroup(groupId);
		
		VisitCounter counter = null;
		
		if(!counterList.isEmpty()){
			
			counter = counterList.get(0);
		
		}else{
			
			counter = addCounter(companyId, groupId, userId, userName);
		}
		
		int totalHitCounter = counter.getTotalHitCounter();
		
		totalHitCounter ++;
		
		counter.setTotalHitCounter(totalHitCounter);
		
		visitCounterPersistence.update(counter, false);
	}
	
	private static final int DEFAULT_COUNTER_VALUE = 1;
}