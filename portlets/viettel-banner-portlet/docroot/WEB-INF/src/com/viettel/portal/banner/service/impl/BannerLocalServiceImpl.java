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

package com.viettel.portal.banner.service.impl;
import java.util.Date;
import java.util.List;

import com.viettel.portal.banner.model.Banner;
import com.viettel.portal.banner.service.base.BannerLocalServiceBaseImpl;
import com.viettel.portal.banner.service.persistence.BannerFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the banner local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.banner.service.BannerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.banner.service.base.BannerLocalServiceBaseImpl
 * @see com.viettel.portal.banner.service.BannerLocalServiceUtil
 */
public class BannerLocalServiceImpl extends BannerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.banner.service.BannerLocalServiceUtil} to access the banner local service.
	 */
	public List<Banner> findBannersByIds(List<Long> ids) throws PortalException, SystemException{
	    return BannerFinderUtil.findBannersByIds( ids );
	}	
	public List<Banner> findBanners(Long groupId, String ten, int begin, int end) throws PortalException, SystemException{
	    return BannerFinderUtil.findBanners( groupId,  ten,  begin,  end);
	}
	public int countBanners(Long groupId, String ten) throws PortalException, SystemException{
		return BannerFinderUtil.countBanners( groupId,  ten);
	}	
	
	public Banner updateBanner(long id, long companyId, long groupId,
			long userId, String userName, String ten, Date ngayKetThuc, int order_, String lienKet,
			long fileId, String fileLink, String fileName, long fileSize, ServiceContext serviceContext) throws SystemException,
			PortalException {
		Date now = new Date();
		Banner banner = bannerPersistence.findByPrimaryKey(id);
		if(banner != null){
			banner.setNgaySua(now);
			banner.setNguoiSua(userName);
			banner.setNguoiSuaId(userId);
			banner.setGroupId(groupId);
			banner.setCompanyId(companyId);
			banner.setTen(ten);
			banner.setFileId(fileId);
			banner.setNgayKetThuc(ngayKetThuc);
			banner.setFileLink(fileLink);
			banner.setFileName(fileName);
			banner.setOrder_(order_);
			banner.setLienKet(lienKet);
			
			if ((serviceContext.getGroupPermissions() != null)
					|| (serviceContext.getGuestPermissions() != null)) {

				updateBannerResource(banner, serviceContext.getGroupPermissions(),
						serviceContext.getGuestPermissions());
			}
			return bannerPersistence.update(banner);
		}
		return banner;
	}

	public Banner addBanner(long companyId, long groupId,
			long userId, String userName, String ten, Date ngayKetThuc, int order_, String lienKet,
			long fileId, String fileLink, String fileName, long fileSize, ServiceContext serviceContext) throws SystemException,
			PortalException {

		Date now = new Date();

		long entryId = counterLocalService.increment();
		Banner banner = bannerPersistence.create(entryId);

		banner.setGroupId(groupId);
		banner.setCompanyId(companyId);
		banner.setNguoiTao(userName);
		banner.setNguoiTaoId(userId);
		banner.setNgayTao(now);
		banner.setTen(ten);
		banner.setFileId(fileId);
		banner.setNgayKetThuc(ngayKetThuc);
		banner.setFileLink(fileLink);
		banner.setFileName(fileName);
		banner.setTrangThai(true);
		banner.setOrder_(order_);
		banner.setLienKet(lienKet);
		
		if ((serviceContext.getGroupPermissions() != null)
				|| (serviceContext.getGuestPermissions() != null)) {

			addBannerResource(banner, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}
		return bannerPersistence.update(banner);
	}

	protected void addBannerResource(Banner banner,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(banner.getCompanyId(),
				banner.getGroupId(), banner.getNguoiTaoId(), Banner.class.getName(),
				banner.getPrimaryKey(), groupPermissions, guestPermissions);
	}

	protected void updateBannerResource(Banner banner,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(banner.getCompanyId(),
				banner.getGroupId(), Banner.class.getName(),
				banner.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}