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

package com.viettel.portal.magazine.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.viettel.portal.magazine.model.Magazine;
import com.viettel.portal.magazine.service.base.MagazineLocalServiceBaseImpl;
import com.viettel.portal.magazine.service.persistence.MagazineFinderUtil;
import com.viettel.portal.magazine.service.persistence.MagazineUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
/**
 * The implementation of the magazine local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.magazine.service.MagazineLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author namtv
 * @see com.viettel.portal.magazine.service.base.MagazineLocalServiceBaseImpl
 * @see com.viettel.portal.magazine.service.MagazineLocalServiceUtil
 */
public class MagazineLocalServiceImpl extends MagazineLocalServiceBaseImpl {
	public List<Magazine> getLastestMagazine() throws SystemException{
		return MagazineUtil.findAll(0, 1);
	}
	
	public List<Magazine> searchMagazine(long number, long year, int begin, int end){
		return magazineFinder.searchMagazine( number,  year,  begin,  end);
	}
	public int countMagazine(long number, long year){
		return magazineFinder.countMagazine( number,  year);
	}
	
	public List<Magazine> findByPublishYear(int year)  throws SystemException, PortalException{
		return magazinePersistence.findByPublishYear(year);
	}
	
	public Magazine updateMagazine(int id,long groupId,long userId,String userFullname,String name,int publishNumber,int publishYear,long fileId, Date distributedDate,ServiceContext serviceContext) throws SystemException,
			PortalException {
		Date now = new Date();
		Magazine magazine = magazinePersistence.findByPrimaryKey(id);
		if(magazine != null){
			magazine.setName(name);
			magazine.setPublishNumber(publishNumber);
			magazine.setPublishYear(publishYear);
			magazine.setImageID(fileId);
			magazine.setDistributedDate(distributedDate);
			magazine.setModifiedDate(now);
			return magazinePersistence.update(magazine);
		}
		return magazine;
	}

	public Magazine addMagazine(long groupId,long userId,String userFullname,String name,int publishNumber,int publishYear,long fileId, Date distributedDate,ServiceContext serviceContext) throws SystemException,
			PortalException {

		Date now = new Date();
		int entryId = (int) counterLocalService.increment();
		Magazine magazine = magazinePersistence.create(entryId);

		magazine.setName(name);
		magazine.setPublishNumber(publishNumber);
		magazine.setPublishYear(publishYear);
		magazine.setImageID(fileId);
		magazine.setDistributedDate(distributedDate);
		magazine.setCreationDate(now);
		
		return magazinePersistence.update(magazine);
	}

}