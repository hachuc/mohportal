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

package com.viettel.portal.videolibrary.service.impl;

import java.util.List;

import com.viettel.portal.videolibrary.model.VLCategory;
import com.viettel.portal.videolibrary.service.base.VLCategoryServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the v l category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.videolibrary.service.VLCategoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.base.VLCategoryServiceBaseImpl
 * @see com.viettel.portal.videolibrary.service.VLCategoryServiceUtil
 */
public class VLCategoryServiceImpl extends VLCategoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.videolibrary.service.VLCategoryServiceUtil} to access the v l category remote service.
	 */

	public VLCategory addVLCategory(long companyId, long groupId, long userId,
			String userName, String categoryName, boolean invisible,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		return vlCategoryLocalService.addVLCategory(companyId, groupId, userId,
				userName, categoryName, invisible, serviceContext);
	}
	
	public int countAll() throws SystemException{
		return vlCategoryLocalService.countAll();
	}
	
	public List<VLCategory> findByCategoryName(String categoryName, long groupId) throws SystemException{
		return vlCategoryLocalService.findByCategoryName(categoryName, groupId);
	}
	
	public List<VLCategory> findByGroup(long groupId) throws SystemException{
		return vlCategoryLocalService.findByGroup(groupId);
	}
	
	public List<VLCategory> findAll() throws SystemException{
		return vlCategoryLocalService.findAll();
	}
	
	public List<VLCategory> findAll(int start, int end) throws SystemException{
		return vlCategoryLocalService.findAll(start, end);
	}

	public VLCategory updateVLCategory(long categoryId, long companyId,
			long groupId, long userId, String userName, String categoryName,
			boolean invisible, ServiceContext serviceContext)
			throws SystemException, PortalException {
		return vlCategoryLocalService.updateVLCategory(categoryId, companyId,
				groupId, userId, userName, categoryName, invisible,
				serviceContext);
	}
}