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
import com.viettel.portal.photos.NoSuchPhotoException;
import com.viettel.portal.photos.model.Photo;
import com.viettel.portal.photos.service.base.PhotoLocalServiceBaseImpl;
import com.viettel.portal.photos.service.persistence.PhotoFinderUtil;

/**
 * The implementation of the photo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.photos.service.PhotoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.photos.service.base.PhotoLocalServiceBaseImpl
 * @see com.viettel.portal.photos.service.PhotoLocalServiceUtil
 */
public class PhotoLocalServiceImpl extends PhotoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.photos.service.PhotoLocalServiceUtil} to access the photo local service.
	 */
	
	public List<Photo> findByAlbumIds(Long groupId, List<Long> categoryIds){
		return photoFinder.findByAlbumIds( groupId, categoryIds);
	}
	
	public List<Photo> findByGroup(Long groupId, boolean status, int begin, int end) throws PortalException, SystemException{
		return photoPersistence.findByGroup(groupId, status, begin, end);
	}
	public List<Photo> findByCategoryAndGroup(long categoryId, long groupId, boolean status, int begin, int end) throws PortalException, SystemException{
		return photoPersistence.findByCategoryAndGroup(categoryId, groupId, status, begin, end);
	}	
//	findByCategoryId
	public List<Photo> findPhotos(Long groupId, String keyword, long categoryId, int begin, int end) throws PortalException, SystemException{
	    return photoFinder.findPhotos( groupId,  keyword, categoryId,  begin,  end);
	}
	public int countPhotos(Long groupId, String keyword, long categoryId) throws PortalException, SystemException{
		return photoFinder.countPhotos( groupId,  keyword,categoryId);
	}	
	public Photo updatePhoto(long photoId,long categoryId,long companyId,
			long groupId,long  userId,String userName, String caption,int order_, boolean status,
			long fileId, String fileName, String fileLink,long fileSize,ServiceContext serviceContext) throws PortalException, SystemException{
		Date now = new Date();
		Photo photo = photoPersistence.findByPrimaryKey(photoId);
		if(photo != null){
			photo.setModifyDate(now);
			photo.setUserName(userName);
			photo.setUserId(userId);
			photo.setGroupId(groupId);
			photo.setCompanyId(companyId);
			photo.setCaption(caption);
			photo.setFileId(fileId);
			photo.setFileLink(fileLink);
			photo.setFileName(fileName);
			photo.setOrder_(order_);
			photo.setCategoryId(categoryId);
			photo.setStatus(status);
			
//			if ((serviceContext.getGroupPermissions() != null)
//					|| (serviceContext.getGuestPermissions() != null)) {
//
//				updatePhotoResource(photo, serviceContext.getGroupPermissions(),
//						serviceContext.getGuestPermissions());
//			}
			return photoPersistence.update(photo);
		}
		return photo;
	}
	
	public Photo addPhoto(long categoryId,long companyId,
			long groupId,long  userId,String userName, String caption,int order_, boolean status,
			long fileId, String fileName, String fileLink,long fileSize,ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();

		long entryId = counterLocalService.increment();
		Photo photo = photoPersistence.create(entryId);

		photo.setGroupId(groupId);
		photo.setCompanyId(companyId);
		photo.setUserName(userName);
		photo.setUserId(userId);
		photo.setCreateDate(now);
		photo.setModifyDate(now);
		photo.setCaption(caption);
		photo.setFileId(fileId);
		photo.setFileLink(fileLink);
		photo.setFileName(fileName);
		photo.setOrder_(order_);
		photo.setStatus(status);
		photo.setCategoryId(categoryId);
		
//		if ((serviceContext.getGroupPermissions() != null)
//				|| (serviceContext.getGuestPermissions() != null)) {
//
//			addPhotoResource(photo, serviceContext.getGroupPermissions(),
//					serviceContext.getGuestPermissions());
//		}
		return photoPersistence.update(photo);
	}
}