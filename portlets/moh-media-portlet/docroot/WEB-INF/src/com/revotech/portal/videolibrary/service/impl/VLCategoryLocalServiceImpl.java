/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.revotech.portal.videolibrary.service.impl;

import java.util.Date;
import java.util.List;

import com.revotech.portal.videolibrary.model.VLCategory;
import com.revotech.portal.videolibrary.service.base.VLCategoryLocalServiceBaseImpl;
import com.revotech.portal.videolibrary.service.persistence.VLCategoryFinder;
import com.revotech.portal.videolibrary.service.persistence.VLCategoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the v l category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.revotech.portal.videolibrary.service.VLCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.revotech.portal.videolibrary.service.base.VLCategoryLocalServiceBaseImpl
 * @see com.revotech.portal.videolibrary.service.VLCategoryLocalServiceUtil
 */
public class VLCategoryLocalServiceImpl extends VLCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.revotech.portal.videolibrary.service.VLCategoryLocalServiceUtil} to access the v l category local service.
	 */
	public List<VLCategory> findByCategoryId(long groupId, long categoryId) throws SystemException, PortalException{
		return VLCategoryUtil.findByCategoryId_GroupId(categoryId, groupId);
	}
	public void removeAll(long groupId) throws SystemException, PortalException{
		VLCategoryUtil.removeByGroup(groupId);
	}
	public VLCategory addLegalCategory(long groupId, long companyId, long userId, String userName, long categoryId, String categoryName, boolean isVisible, ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();
		if(categoryId == 0)
			categoryId = counterLocalService.increment(VLCategory.class.getName());
		
		VLCategory category = vlCategoryPersistence.create(categoryId);

		category.setGroupId(groupId);
		category.setCompanyId(companyId);
		category.setUserId(userId);
		category.setUserName(userName);
		category.setCreateDate(now);
		category.setModifiedDate(now);
		category.setCategoryName(categoryName);
		category.setInvisible(isVisible);

		resourceLocalService.addModelResources(category, serviceContext);

		return vlCategoryPersistence.update(category);
	}
	public VLCategory addVLCategory(long companyId, long groupId, long userId,
			String userName, String categoryName, boolean invisible,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		Date now = new Date();

		long categoryId = counterLocalService.increment(VLCategory.class.getName());

		VLCategory category = vlCategoryPersistence.create(categoryId);

		category.setGroupId(groupId);
		category.setCompanyId(companyId);
		category.setUserId(userId);
		category.setUserName(userName);
		category.setCreateDate(now);
		category.setModifiedDate(now);
		category.setCategoryName(categoryName);
		category.setCategoryId(categoryId);
		category.setInvisible(invisible);

		resourceLocalService.addModelResources(category, serviceContext);

		return vlCategoryPersistence.update(category);
	}
	
	public int countAll() throws SystemException{
		return vlCategoryPersistence.countAll();
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return vlCategoryPersistence.countByGroup(groupId);
	}
	
	
	public List<VLCategory> findByCategoryName(String categoryName, long groupId) throws SystemException{
		return vlCategoryPersistence.findByCategoryName(categoryName, groupId);
	}
	
	public List<VLCategory> findByGroup(long groupId) throws SystemException{
		return vlCategoryPersistence.findByGroup(groupId);
	}
	
	public List<VLCategory> findByGroup(long groupId, int start, int end) throws SystemException{
		return vlCategoryPersistence.findByGroup(groupId, start, end);
	}
	
	public List<VLCategory> findByGroupAndState(long groupId, boolean invisible) throws SystemException{
		return vlCategoryPersistence.findByGroupAndState(groupId, invisible);
	}

	public List<VLCategory> findAll() throws SystemException{
		return vlCategoryPersistence.findAll();
	}
	
	public List<VLCategory> findAll(int start, int end) throws SystemException{
		return vlCategoryPersistence.findAll(start, end);
	}

	public List<VLCategory> getByGroupUserSite(long groupId) throws SystemException{
		return vlCategoryFinder.getByGroupUserSite(groupId);
	}
	
	public VLCategory updateVLCategory(long categoryId, long companyId,
			long groupId, long userId, String userName, String categoryName,
			boolean invisible, ServiceContext serviceContext)
			throws SystemException, PortalException {

		Date now = new Date();

		VLCategory category = vlCategoryPersistence
				.fetchByPrimaryKey(categoryId);

		category.setGroupId(groupId);
		category.setCompanyId(companyId);
		category.setUserId(userId);
		category.setUserName(userName);
		category.setCreateDate(now);
		category.setModifiedDate(now);
		category.setCategoryName(categoryName);
		category.setInvisible(invisible);

		if ((serviceContext.getGroupPermissions() != null)
				|| (serviceContext.getGuestPermissions() != null)) {

			updateVLCategoryResource(category,
					serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}

		return vlCategoryPersistence.update(category);
	}

	protected void updateVLCategoryResource(VLCategory category,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(category.getCompanyId(),
				category.getGroupId(), VLCategory.class.getName(),
				category.getPrimaryKey(), groupPermissions, guestPermissions);
	}
	
	
}