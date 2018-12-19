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
import com.viettel.portal.thongke.model.PhongBan;
import com.viettel.portal.thongke.service.base.PhongBanLocalServiceBaseImpl;

/**
 * The implementation of the phong ban local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.thongke.service.PhongBanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author lamvn
 * @see com.viettel.portal.thongke.service.base.PhongBanLocalServiceBaseImpl
 * @see com.viettel.portal.thongke.service.PhongBanLocalServiceUtil
 */
public class PhongBanLocalServiceImpl extends PhongBanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.thongke.service.PhongBanLocalServiceUtil} to access the phong ban local service.
	 */
	public List<PhongBan> findPhongBans(Long groupId, String keyword,  int begin, int end) throws PortalException, SystemException{
	    return phongBanFinder.findPhongBans( groupId,  keyword,   begin,  end);
	}
	public int countPhongBans(Long groupId, String keyword) throws PortalException, SystemException{
		return phongBanFinder.countPhongBans( groupId,  keyword);
	}	
	public List<Object> findPhongBanRatings(long phongBanNhuanButId,long groupId, String keyword,Date fromDate,Date toDate, int start, int end) throws PortalException, SystemException{
	    return phongBanFinder.findPhongBanRatings(phongBanNhuanButId, groupId, keyword, fromDate, toDate, start, end);
	}
	public int countPhongBanRatings(long phongBanNhuanButId,long groupId, String keyword,Date fromDate,Date toDate) throws PortalException, SystemException{
		return phongBanFinder.countPhongBanRatings(phongBanNhuanButId, groupId, keyword, fromDate, toDate);
	}	
	public PhongBan updatePhongBan(long id,long companyId,long groupId,long  userId,String userName, String name,String descriptions,int order_, boolean status,
			ServiceContext serviceContext) throws PortalException, SystemException{
		Date now = new Date();
		PhongBan phongBan = phongBanPersistence.findByPrimaryKey(id);
		if(phongBan != null){
			phongBan.setModifyDate(now);
			phongBan.setUserName(userName);
			phongBan.setUserId(userId);
			phongBan.setGroupId(groupId);
			phongBan.setCompanyId(companyId);
			phongBan.setName(name);
			phongBan.setDescriptions(descriptions);
			phongBan.setOrder_(order_);
			phongBan.setStatus(status);
			
//			if ((serviceContext.getGroupPermissions() != null)
//					|| (serviceContext.getGuestPermissions() != null)) {
//
//				updatePhotoResource(photo, serviceContext.getGroupPermissions(),
//						serviceContext.getGuestPermissions());
//			}
			return phongBanPersistence.update(phongBan);
		}
		return phongBan;
	}
	
	public PhongBan addPhongBan(long companyId,long groupId,long  userId,String userName, String name,String descriptions,int order_, boolean status,
			ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();

		long entryId = counterLocalService.increment();
		PhongBan phongBan = phongBanPersistence.create(entryId);

		phongBan.setGroupId(groupId);
		phongBan.setCompanyId(companyId);
		phongBan.setUserName(userName);
		phongBan.setUserId(userId);
		phongBan.setCreateDate(now);
		phongBan.setModifyDate(now);
		phongBan.setName(name);
		phongBan.setDescriptions(descriptions);
		phongBan.setOrder_(order_);
		phongBan.setStatus(status);
		
//		if ((serviceContext.getGroupPermissions() != null)
//				|| (serviceContext.getGuestPermissions() != null)) {
//
//			addPhotoResource(photo, serviceContext.getGroupPermissions(),
//					serviceContext.getGuestPermissions());
//		}
		return phongBanPersistence.update(phongBan);
	}
}