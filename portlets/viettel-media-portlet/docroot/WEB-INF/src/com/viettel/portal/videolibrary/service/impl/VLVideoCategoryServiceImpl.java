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

import com.viettel.portal.videolibrary.model.VLVideoCategory;
import com.viettel.portal.videolibrary.service.base.VLVideoCategoryServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the v l video category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.videolibrary.service.VLVideoCategoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.base.VLVideoCategoryServiceBaseImpl
 * @see com.viettel.portal.videolibrary.service.VLVideoCategoryServiceUtil
 */
public class VLVideoCategoryServiceImpl extends VLVideoCategoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.videolibrary.service.VLVideoCategoryServiceUtil} to access the v l video category remote service.
	 */
	
	public List<VLVideoCategory> findByCategory(long categoryId, long groupId) throws SystemException{
		return vlVideoCategoryLocalService.findByCategory(categoryId, groupId);
	}
	
	public List<VLVideoCategory> findByVideo(long videoId, long groupId) throws SystemException{
		return vlVideoCategoryLocalService.findByVideo(videoId, groupId);
	}
}