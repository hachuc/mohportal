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

package com.viettel.portal.thongke.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.thongke.model.PhongBanNhuanBut;
import com.viettel.portal.thongke.service.base.PhongBanNhuanButLocalServiceBaseImpl;

/**
 * The implementation of the phong ban nhuan but local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.thongke.service.PhongBanNhuanButLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author lamvn
 * @see com.viettel.portal.thongke.service.base.PhongBanNhuanButLocalServiceBaseImpl
 * @see com.viettel.portal.thongke.service.PhongBanNhuanButLocalServiceUtil
 */
public class PhongBanNhuanButLocalServiceImpl
	extends PhongBanNhuanButLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.thongke.service.PhongBanNhuanButLocalServiceUtil} to access the phong ban nhuan but local service.
	 */
	public List<PhongBanNhuanBut> findPhongBanNhuanButs(long groupId, String keyword,Date fromDate,Date toDate, int start, int end) throws PortalException, SystemException{
	    return phongBanNhuanButFinder.findPhongBanNhuanButs(groupId, keyword, fromDate, toDate, start, end);
	}
	public int countPhongBanNhuanButs(long groupId, String keyword,Date fromDate,Date toDate) throws PortalException, SystemException{
		return phongBanNhuanButFinder.countPhongBanNhuanButs(groupId, keyword, fromDate, toDate);
	}	
	public PhongBanNhuanBut updatePhongBanNhuanBut(long id,long companyId,long groupId,long  userId,String userName, String caption,Date fromDate,Date toDate, boolean status,
			ServiceContext serviceContext) throws PortalException, SystemException{
		Date now = new Date();
		PhongBanNhuanBut pbnb = phongBanNhuanButPersistence.findByPrimaryKey(id);
		if(pbnb != null){
			pbnb.setModifyDate(now);
			pbnb.setUserName(userName);
			pbnb.setUserId(userId);
			pbnb.setGroupId(groupId);
			pbnb.setCompanyId(companyId);
			pbnb.setCaption(caption);
			pbnb.setFromDate(fromDate);
			pbnb.setToDate(toDate);
			pbnb.setStatus(status);
			
//			if ((serviceContext.getGroupPermissions() != null)
//					|| (serviceContext.getGuestPermissions() != null)) {
//
//				updatePhotoResource(photo, serviceContext.getGroupPermissions(),
//						serviceContext.getGuestPermissions());
//			}
			return phongBanNhuanButPersistence.update(pbnb);
		}
		return pbnb;
	}
	
	public PhongBanNhuanBut addPhongBanNhuanBut(long companyId,long groupId,long  userId,String userName, String caption,Date fromDate,Date toDate, boolean status,
			ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();

		long entryId = counterLocalService.increment();
		PhongBanNhuanBut pbnb = phongBanNhuanButPersistence.create(entryId);

		pbnb.setGroupId(groupId);
		pbnb.setCompanyId(companyId);
		pbnb.setUserName(userName);
		pbnb.setUserId(userId);
		pbnb.setCreateDate(now);
		pbnb.setModifyDate(now);
		pbnb.setCaption(caption);
		pbnb.setFromDate(fromDate);
		pbnb.setToDate(toDate);
		pbnb.setStatus(status);
		
//		if ((serviceContext.getGroupPermissions() != null)
//				|| (serviceContext.getGuestPermissions() != null)) {
//
//			addPhotoResource(photo, serviceContext.getGroupPermissions(),
//					serviceContext.getGuestPermissions());
//		}
		return phongBanNhuanButPersistence.update(pbnb);
	}
}