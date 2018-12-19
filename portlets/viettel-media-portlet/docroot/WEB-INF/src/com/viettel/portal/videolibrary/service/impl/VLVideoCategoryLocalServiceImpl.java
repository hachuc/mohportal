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
import com.viettel.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil;
import com.viettel.portal.videolibrary.service.base.VLVideoCategoryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the v l video category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.videolibrary.service.VLVideoCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.base.VLVideoCategoryLocalServiceBaseImpl
 * @see com.viettel.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil
 */
public class VLVideoCategoryLocalServiceImpl
	extends VLVideoCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil} to access the v l video category local service.
	 */

	public List<VLVideoCategory> findByCategory(long categoryId, long groupId)
			throws SystemException {
		return vlVideoCategoryPersistence.findByCategory(categoryId, groupId);
	}

	public List<VLVideoCategory> findByVideo(long videoId, long groupId)
			throws SystemException {
		return vlVideoCategoryPersistence.findByVideo(videoId, groupId);
	}

	public VLVideoCategory addVLVideoCategory(long categoryId, long videoId,
			long groupId, ServiceContext serviceContext)
			throws SystemException, PortalException {

		long id = counterLocalService
				.increment(VLVideoCategory.class.getName());

		VLVideoCategory videoCategory = vlVideoCategoryPersistence.create(id);

		videoCategory.setCategoryId(categoryId);
		videoCategory.setVideoId(videoId);
		videoCategory.setGroupId(groupId);

		return vlVideoCategoryPersistence.update(videoCategory);
	}

	public VLVideoCategory updateVLVideoCategory(long id, long categoryId,
			long videoId, long groupId, ServiceContext serviceContext)
			throws SystemException, PortalException {

		VLVideoCategory videoCategory = vlVideoCategoryPersistence
				.fetchByPrimaryKey(id);

		videoCategory.setCategoryId(categoryId);
		videoCategory.setVideoId(videoId);
		videoCategory.setVideoId(groupId);

		return vlVideoCategoryPersistence.update(videoCategory);
	}

	public void deleteVideoCategoryMapByCategory(long categoryId, long groupId)
			throws SystemException, PortalException {

		List<VLVideoCategory> listEntries = vlVideoCategoryPersistence
				.findByCategory(categoryId, groupId);
		if (listEntries != null)
			for (int i = 0; i < listEntries.size(); i++) {
				VLVideoCategory videoCategory = listEntries.get(i);
				VLVideoCategoryLocalServiceUtil
						.deleteVLVideoCategory(videoCategory.getId());
			}

	}
}