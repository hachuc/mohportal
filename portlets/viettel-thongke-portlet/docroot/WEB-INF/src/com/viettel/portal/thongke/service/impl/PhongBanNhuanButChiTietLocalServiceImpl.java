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
import com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet;
import com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietImpl;
import com.viettel.portal.thongke.service.base.PhongBanNhuanButChiTietLocalServiceBaseImpl;

/**
 * The implementation of the phong ban nhuan but chi tiet local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author lamvn
 * @see com.viettel.portal.thongke.service.base.PhongBanNhuanButChiTietLocalServiceBaseImpl
 * @see com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalServiceUtil
 */
public class PhongBanNhuanButChiTietLocalServiceImpl
	extends PhongBanNhuanButChiTietLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalServiceUtil} to access the phong ban nhuan but chi tiet local service.
	 */
	public List<PhongBanNhuanButChiTiet> getByPhongBanNhuanButId(long phongBanNhuanButId) throws PortalException,SystemException{
		return phongBanNhuanButChiTietPersistence.findByPhongBanNhuanBut(phongBanNhuanButId);
	}
	public PhongBanNhuanButChiTiet updatePhongBanNhuanButChiTiet(long id,long phongBanNhuanButId,long phongBanId, String phongBanTen,String rating,double ratingValue,
			ServiceContext serviceContext) throws PortalException, SystemException{
		Date now = new Date();
		PhongBanNhuanButChiTiet pbnbct = phongBanNhuanButChiTietPersistence.findByPrimaryKey(id);
		if(pbnbct != null){
			pbnbct.setPhongBanId(phongBanId);
			pbnbct.setPhongBanNhuanButId(phongBanNhuanButId);
			pbnbct.setPhongBanTen(phongBanTen);
			pbnbct.setRating(rating);
			pbnbct.setRatingValue(ratingValue);
//			if ((serviceContext.getGroupPermissions() != null)
//					|| (serviceContext.getGuestPermissions() != null)) {
//
//				updatePhotoResource(photo, serviceContext.getGroupPermissions(),
//						serviceContext.getGuestPermissions());
//			}
			return phongBanNhuanButChiTietPersistence.update(pbnbct);
		}
		return pbnbct;
	}
	
	public PhongBanNhuanButChiTiet addPhongBanNhuanButChiTiet(long phongBanNhuanButId,long phongBanId, String phongBanTen,String rating,double ratingValue,
			ServiceContext serviceContext) throws SystemException, PortalException{
		
		
		PhongBanNhuanButChiTiet pbnbct = new PhongBanNhuanButChiTietImpl();

		pbnbct.setPhongBanId(phongBanId);
		pbnbct.setPhongBanNhuanButId(phongBanNhuanButId);
		pbnbct.setPhongBanTen(phongBanTen);
		pbnbct.setRating(rating);
		pbnbct.setRatingValue(ratingValue);
		
//		if ((serviceContext.getGroupPermissions() != null)
//				|| (serviceContext.getGuestPermissions() != null)) {
//
//			addPhotoResource(photo, serviceContext.getGroupPermissions(),
//					serviceContext.getGuestPermissions());
//		}
		return phongBanNhuanButChiTietPersistence.update(pbnbct);
	}
}