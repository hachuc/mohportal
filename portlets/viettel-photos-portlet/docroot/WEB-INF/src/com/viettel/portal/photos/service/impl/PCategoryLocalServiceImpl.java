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

package com.viettel.portal.photos.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.photos.model.PCategory;
import com.viettel.portal.photos.service.base.PCategoryLocalServiceBaseImpl;

/**
 * The implementation of the p category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.photos.service.PCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.photos.service.base.PCategoryLocalServiceBaseImpl
 * @see com.viettel.portal.photos.service.PCategoryLocalServiceUtil
 */
public class PCategoryLocalServiceImpl extends PCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.photos.service.PCategoryLocalServiceUtil} to access the p category local service.
	 */
	public List<PCategory> findByGroup(long groupId)  throws PortalException, SystemException{
		return pCategoryPersistence.findByGroup(groupId);
	}
	public int countByGroup(long groupId)  throws PortalException, SystemException{
		return pCategoryPersistence.countByGroup(groupId);
	}	
	public List<PCategory> findByGroup(long groupId, int start, int end) throws PortalException, SystemException{
		return pCategoryPersistence.findByGroup(groupId, start, end);
	}
	
	public List<PCategory> findByGroupAndName(long groupId, String name)  throws PortalException, SystemException{
		return pCategoryPersistence.findByGroupAndName(groupId, name);
	}	
	public PCategory addCategory(long companyId, long groupId,
			long userId, String userName,String categoryName, boolean status, int corder,
			ServiceContext serviceContext) throws SystemException, PortalException {

		Date now = new Date();
	
		long categoryId = counterLocalService.increment(PCategory.class.getName());
		
		//System.err.println("categoryId -> " + categoryId);
	
		PCategory category = pCategoryPersistence.create(categoryId);
	
		category.setGroupId(groupId);
		category.setCompanyId(companyId);
		category.setUserId(userId);
		category.setUserName(userName);
		category.setCreateDate(now);
		category.setModifyDate(now);
		category.setName(categoryName);
		//category.setId(categoryId);
		category.setStatus(status);
		category.setOrder_(corder);
	
	//	updateCategoryResource(category,
	//			serviceContext.getGroupPermissions(),
	//			serviceContext.getGuestPermissions());
		pCategoryPersistence.update(category);
	
		return category;
		
	}
	
	public PCategory updateCategory(long categoryId, long companyId,
			long groupId, long userId, String userName,String categoryName, boolean status, int corder,
			ServiceContext serviceContext)throws PortalException, SystemException{

		Date now = new Date();

		PCategory category = pCategoryPersistence
				.fetchByPrimaryKey(categoryId);

		category.setGroupId(groupId);
		category.setCompanyId(companyId);
		category.setUserId(userId);
		category.setUserName(userName);
		category.setModifyDate(now);
		category.setName(categoryName);
		category.setStatus(status);
		category.setOrder_(corder);

//		if ((serviceContext.getGroupPermissions() != null)
//				|| (serviceContext.getGuestPermissions() != null)) {
//
//			updateCategoryResource(category,
//					serviceContext.getGroupPermissions(),
//					serviceContext.getGuestPermissions());
//		}

		return pCategoryPersistence.update(category);
		
	}
	protected void updateCategoryResource(PCategory category,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(category.getCompanyId(),
				category.getGroupId(), PCategory.class.getName(),
				category.getPrimaryKey(), groupPermissions, guestPermissions);
	}	
}