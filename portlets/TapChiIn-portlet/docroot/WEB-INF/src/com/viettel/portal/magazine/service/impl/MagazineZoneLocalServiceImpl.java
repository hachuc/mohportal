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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.magazine.model.Magazine;
import com.viettel.portal.magazine.model.MagazineZone;
import com.viettel.portal.magazine.service.base.MagazineZoneLocalServiceBaseImpl;

/**
 * The implementation of the magazine zone local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.magazine.service.MagazineZoneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author namtv
 * @see com.viettel.portal.magazine.service.base.MagazineZoneLocalServiceBaseImpl
 * @see com.viettel.portal.magazine.service.MagazineZoneLocalServiceUtil
 */
public class MagazineZoneLocalServiceImpl
	extends MagazineZoneLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.magazine.service.MagazineZoneLocalServiceUtil} to access the magazine zone local service.
	 */
	public List<MagazineZone> GetByMagazineId(int magazineId) throws SystemException, PortalException{
		return magazineZonePersistence.findByMagazineID(magazineId);
	}
	
	public int countByMagazineID(int magazineId) throws SystemException, PortalException{
		return magazineZonePersistence.countByMagazineID(magazineId);
	}
	
	public List<MagazineZone> findByMagazineID(int magazineId, int start, int end) throws SystemException, PortalException{
		return magazineZonePersistence.findByMagazineID(magazineId, start, end);
	}
	
	public MagazineZone updateMagazineZone(int id,long groupId,long userId,String userFullname, int magazineID,String name,int sortOrder,ServiceContext serviceContext) throws SystemException,
		PortalException {
		//Date now = new Date();
		MagazineZone mz = magazineZonePersistence.findByPrimaryKey(id);
		if(mz != null){
			mz.setName(name);
			mz.setSortOrder(sortOrder);
			//mz.setMagazineID(magazineID);
			return magazineZonePersistence.update(mz);
		}
		return mz;
	}

	public MagazineZone addMagazineZone(long groupId,long userId,String userFullname, int magazineID,String name,int sortOrder,ServiceContext serviceContext) throws SystemException,
			PortalException {
		
		//Date now = new Date();
		int entryId = (int) counterLocalService.increment();
		MagazineZone mz = magazineZonePersistence.create(entryId);
		
		mz.setName(name);
		mz.setSortOrder(sortOrder);
		mz.setMagazineID(magazineID);
		
		return magazineZonePersistence.update(mz);
	}
}