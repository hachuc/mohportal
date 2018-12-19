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

import java.util.Date;
import java.util.List;

import com.viettel.portal.videolibrary.model.VLVideo;
import com.viettel.portal.videolibrary.service.base.VLVideoLocalServiceBaseImpl;
import com.viettel.portal.videolibrary.service.persistence.VLVideoFinderUtil;
import com.viettel.portal.videolibrary.service.persistence.VLVideoUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the v l video local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.videolibrary.service.VLVideoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.base.VLVideoLocalServiceBaseImpl
 * @see com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil
 */
public class VLVideoLocalServiceImpl extends VLVideoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil} to access
	 * the v l video local service.
	 */
	public void removeAll(long groupId) throws SystemException{
		VLVideoUtil.removeByGroup(groupId);
	}
	public VLVideo addVideo(long categoryId, long companyId, long groupId,
			long userId, String userName, String name, String description,
			String videoType, String videoUrl, long videoFileId,
			boolean thumbnailImage, long thumbnailImageId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		Date now = new Date();

		long entryId = counterLocalService.increment();

		VLVideo video = vlVideoPersistence.create(entryId);

		video.setGroupId(groupId);
		video.setCompanyId(companyId);
		video.setUserId(userId);
		video.setUserName(userName);
		video.setCreateDate(now);
		video.setModifiedDate(now);
		video.setVideoName(name);
		video.setDescription(description);
		video.setVideoType(videoType);
		video.setVideoUrl(videoUrl);
		video.setFileId(videoFileId);
		video.setImage(thumbnailImage);
		video.setImageId(thumbnailImageId);
		video.setCategoryId(categoryId);
		resourceLocalService.addModelResources(video, serviceContext);

		return vlVideoPersistence.update(video);
	}
	public VLVideo addLegalVideo(long categoryId, long companyId, long groupId,
			long userId, String userName, String name, String description,
			String videoType, String videoUrl, long videoFileId,
			boolean thumbnailImage, long thumbnailImageId, String smallImageUrl,
			Date createDate, Date modifyDate,ServiceContext serviceContext) throws SystemException,
			PortalException {

		Date now = new Date();

		long entryId = counterLocalService.increment();

		VLVideo video = vlVideoPersistence.create(entryId);

		video.setGroupId(groupId);
		video.setCompanyId(companyId);
		video.setUserId(userId);
		video.setUserName(userName);
		video.setCreateDate(now);
		video.setModifiedDate(now);
		video.setVideoName(name);
		video.setDescription(description);
		video.setVideoType(videoType);
		video.setVideoUrl(videoUrl);
		video.setFileId(videoFileId);
		video.setImage(thumbnailImage);
		video.setImageId(thumbnailImageId);
		video.setSmallImageUrl(smallImageUrl);
		video.setCategoryId(categoryId);
		video.setCreateDate(createDate);
		video.setModifiedDate(modifyDate);
		resourceLocalService.addModelResources(video, serviceContext);

		return vlVideoPersistence.update(video);
	}
	public int countAllByGroup(long groupId) throws SystemException {
		return vlVideoPersistence.countByGroup(groupId);
	}

	public long countByByKeyword(long groupId, long categoryId, String keyword) {
		return VLVideoFinderUtil.countByKeyword(groupId, categoryId, keyword);
	}

	public List<VLVideo> findByGroup(long groupId) throws SystemException {
		return vlVideoPersistence.findByGroup(groupId);
	}

	public List<VLVideo> findByGroup(long groupId, int start, int end)
			throws SystemException {
		return vlVideoPersistence.findByGroup(groupId, start, end);
	}

	public List<VLVideo> findByCategoryId(long categoryId, long groupId)
			throws SystemException {
		return vlVideoPersistence.findByCategoryId(categoryId, groupId);
	}

	public List<VLVideo> findByCategoryId(long categoryId, long groupId,
			int start, int end) throws SystemException {
		return vlVideoPersistence.findByCategoryId(categoryId, groupId, start,
				end);
	}

	public List<VLVideo> findByKeyword(long groupId, long categoryId,
			String keyword, int start, int end, OrderByComparator obc) {
		return VLVideoFinderUtil.findByKeyword(groupId, categoryId, keyword,
				start, end, obc);
	}

	/*
	 * public List<VLVideo> findByKeyword(long groupId, String keyword, int
	 * start, int end) throws SystemException {
	 * 
	 * return VideoEntryFinderUtil.findByKeyword(groupId, keyword, start, end);
	 * }
	 */

	/*
	 * public List<VLVideo> findByCategoryId(long groupId, long categoryId, int
	 * start, int end) throws SystemException {
	 * 
	 * return VideoEntryFinderUtil.findByCategoryId(groupId, categoryId, start,
	 * end); }
	 */

	public VLVideo updateVideo(long entryId, long categoryId, long companyId,
			long groupId, long userId, String userName, String name,
			String description, String videoType, String videoUrl,
			long videoFileId, boolean thumbnailImage, long thumbnailImageId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		Date now = new Date();

		VLVideo video = vlVideoPersistence.fetchByPrimaryKey(entryId);

		video.setGroupId(groupId);
		video.setCompanyId(companyId);
		video.setUserId(userId);
		video.setUserName(userName);
		video.setModifiedDate(now);
		video.setVideoName(name);
		video.setDescription(description);
		video.setVideoType(videoType);
		video.setVideoUrl(videoUrl);
		video.setFileId(videoFileId);
		video.setImage(thumbnailImage);
		video.setImageId(thumbnailImageId);
		video.setCategoryId(categoryId);

		if ((serviceContext.getGroupPermissions() != null)
				|| (serviceContext.getGuestPermissions() != null)) {

			updateVideoResource(video, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}

		return vlVideoPersistence.update(video);
	}

	protected void updateVideoResource(VLVideo video,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(video.getCompanyId(),
				video.getGroupId(), VLVideo.class.getName(),
				video.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}