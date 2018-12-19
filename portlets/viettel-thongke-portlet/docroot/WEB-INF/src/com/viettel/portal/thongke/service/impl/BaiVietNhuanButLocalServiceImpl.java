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
import com.viettel.portal.thongke.model.BaiVietNhuanBut;
import com.viettel.portal.thongke.model.ContentProfit;
import com.viettel.portal.thongke.model.PhongBanNhuanBut;
import com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet;
import com.viettel.portal.thongke.model.impl.BaiVietNhuanButImpl;
import com.viettel.portal.thongke.service.base.BaiVietNhuanButLocalServiceBaseImpl;

/**
 * The implementation of the bai viet nhuan but local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.thongke.service.BaiVietNhuanButLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author lamvn
 * @see com.viettel.portal.thongke.service.base.BaiVietNhuanButLocalServiceBaseImpl
 * @see com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil
 */
public class BaiVietNhuanButLocalServiceImpl
	extends BaiVietNhuanButLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil} to access the bai viet nhuan but local service.
	 */
	
	public List<BaiVietNhuanBut> getByBaiVietId(long baiVietId) throws PortalException,SystemException{
		return baiVietNhuanButPersistence.findByBaiVietID(baiVietId);
	}
	public List<BaiVietNhuanBut> findBaiVietNhuanButs(int type,Long groupId, String keyword,Date fromDate,Date toDate,  int start, int end) throws PortalException, SystemException{
	    return baiVietNhuanButFinder.findBaiVietNhuanButs( type,groupId, keyword, fromDate, toDate, start, end);
	}
	public int countBaiVietNhuanButs(int type,Long groupId, String keyword,Date fromDate,Date toDate) throws PortalException, SystemException{
		return baiVietNhuanButFinder.countBaiVietNhuanButs(type,groupId, keyword, fromDate, toDate);
	}	
	public List<Object> findBaiVietRatings(long classTypeId,int type,long groupId, String keyword,Date fromDate,Date toDate, int start, int end) throws PortalException, SystemException{
	    return baiVietNhuanButFinder.findBaiVietRatings(classTypeId,type,groupId, keyword, fromDate, toDate, start, end);
	}
	public int countBaiVietRatings(long classTypeId,int type,long groupId, String keyword,Date fromDate,Date toDate) throws PortalException, SystemException{
		return baiVietNhuanButFinder.countBaiVietRatings(classTypeId,type,groupId, keyword, fromDate, toDate);
	}	
	public List<Object> findBaiVietNhuanButBySQL(String sql, int start, int end) throws PortalException, SystemException{
	    return baiVietNhuanButFinder.findBaiVietNhuanButBySQL(sql,start, end);
	}
	public int countBaiVietNhuanButBySQL(String sql) throws PortalException, SystemException{
		return baiVietNhuanButFinder.countBaiVietNhuanButBySQL(sql);
	}
	public BaiVietNhuanBut updateBaiVietNhuanBut(int loaiBaiViet,int type,long id,long companyId,long groupId,long  userId,String userName,
			long baiVietId,String tieuDe,String tacGia,String diaChi,Date ngayXuatBan,String rating,double ratingValue,
			ServiceContext serviceContext) throws PortalException, SystemException{
		Date now = new Date();
		BaiVietNhuanBut bvnb =baiVietNhuanButPersistence.findByPrimaryKey(id);
		if(bvnb != null){
			bvnb.setLoaiBaiViet(loaiBaiViet);
			bvnb.setType(type);
			bvnb.setModifyDate(now);
			bvnb.setUserName(userName);
			bvnb.setUserId(userId);
			bvnb.setGroupId(groupId);
			bvnb.setCompanyId(companyId);
			bvnb.setBaiVietId(baiVietId);
			bvnb.setTieuDe(tieuDe);
			bvnb.setTacGia(tacGia);
			bvnb.setDiaChi(diaChi);
			bvnb.setNgayXuatBan(ngayXuatBan);
			bvnb.setRating(rating);
			bvnb.setRatingValue(ratingValue);
//			if ((serviceContext.getGroupPermissions() != null)
//					|| (serviceContext.getGuestPermissions() != null)) {
//
//				updatePhotoResource(photo, serviceContext.getGroupPermissions(),
//						serviceContext.getGuestPermissions());
//			}
			return baiVietNhuanButPersistence.update(bvnb);
		}
		return bvnb;
	}
	public BaiVietNhuanBut addBaiVietNhuanBut(int loaiBaiViet,int type,long companyId,long groupId,long  userId,String userName,
			long baiVietId,String tieuDe,String tacGia,String diaChi,Date ngayXuatBan,String rating,double ratingValue,
			ServiceContext serviceContext) throws PortalException, SystemException{
		Date now = new Date();

		BaiVietNhuanBut bvnb = new BaiVietNhuanButImpl();
		bvnb.setLoaiBaiViet(loaiBaiViet);
        bvnb.setType(type);
		bvnb.setModifyDate(now);
		bvnb.setCreateDate(now);
		bvnb.setUserName(userName);
		bvnb.setUserId(userId);
		bvnb.setGroupId(groupId);
		bvnb.setCompanyId(companyId);
		bvnb.setBaiVietId(baiVietId);
		bvnb.setTieuDe(tieuDe);
		bvnb.setTacGia(tacGia);
		bvnb.setDiaChi(diaChi);
		bvnb.setNgayXuatBan(ngayXuatBan);
		bvnb.setRating(rating);
		bvnb.setRatingValue(ratingValue);
		
//		if ((serviceContext.getGroupPermissions() != null)
//				|| (serviceContext.getGuestPermissions() != null)) {
//
//			addPhotoResource(photo, serviceContext.getGroupPermissions(),
//					serviceContext.getGuestPermissions());
//		}
		return baiVietNhuanButPersistence.update(bvnb);
	}
	
}