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

package com.viettel.portal.vcms.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.ContentDetail;
import com.viettel.portal.vcms.service.base.ContentDetailLocalServiceBaseImpl;
import com.viettel.portal.vcms.service.persistence.ContentDetailUtil;
import com.viettel.portal.vcms.service.persistence.ContentUtil;

/**
 * The implementation of the content detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.viettel.portal.vcms.service.ContentDetailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.ContentDetailLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.ContentDetailLocalServiceUtil
 */
public class ContentDetailLocalServiceImpl extends ContentDetailLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.viettel.portal.vcms.service.ContentDetailLocalServiceUtil} to access
	 * the content detail local service.
	 */
	public void removeAll() throws PortalException, SystemException{
		ContentDetailUtil.removeAll();
	}
	public ContentDetail addContentDetail(long groupid, long companyId, long userId, String userName, long autoId,
			long contentId, int version, String subTitle, String title, String summary,
			String subContent, String sContent, long smallImageId, String smallImageUrl, long categoryId,
			String copyRight, int status, long createByUserId, String createByUserName, String author, String jobTitle,
			int newsType, ServiceContext serviceContext) throws SystemException, PortalException {

		// Update content detail
		ContentDetail detail;
		String command = Constants.ADD;
		Date now = new Date();
		if (contentId == 0) {
			contentId = counterLocalService.increment();
			detail = contentDetailPersistence.create(autoId);
		} else {
			detail = ContentDetailUtil.fetchByPrimaryKey(autoId);
			if(detail == null){
				detail = contentDetailPersistence.create(autoId);
			}else{
				command = Constants.UPDATE;
			}
		}
		if (smallImageId > 0) {
			detail.setSmallImageId(smallImageId);
			detail.setSmallImageUrl(smallImageUrl);
		}
		
		detail.setContentId(contentId);
		detail.setGroupId(groupid);
		detail.setCompanyId(companyId);
		detail.setUserId(userId);
		detail.setUserName(userName);
		detail.setCreateDate(now);
		detail.setModifiedDate(now);
		detail.setVersion(version);
		detail.setSubTitle(subTitle);
		detail.setTitle(title);
		detail.setSummary(summary);
		detail.setSubContent(subContent);
		detail.setContent(sContent);
		detail.setCategoryId(categoryId);
		detail.setStatus(status);
		if (command.equals(Constants.ADD)
				&& ((serviceContext.getGroupPermissions() != null) || (serviceContext.getGuestPermissions() != null))) {
			addContentResource(detail, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		} else if (command.equals(Constants.UPDATE)
				&& ((serviceContext.getGroupPermissions() != null) || (serviceContext.getGuestPermissions() != null))) {
			updateContentResource(detail, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		return contentDetailPersistence.update(detail);
	}

	public ContentDetail addLegalContent(long groupid, long companyId,
			long userId, String userName, long autoId, long contentId, int version,
			String subTitle, String title, String summary, String subContent,
			String sContent, long smallImageId, String smallImageUrl, long categoryId,
			int status, int newsType, String imageUrl, boolean isLegalContent, String imageCaption, 
			int imagePosition, Date creationDate, Date modifiedDate,
			ServiceContext serviceContext) throws SystemException, PortalException {
		ContentDetail contentDetail = contentDetailPersistence.create(autoId);
		serviceContext.setAttribute("contentId", contentId);
		
		contentDetail.setContentId(contentId);
		contentDetail.setGroupId(groupid);
		contentDetail.setCompanyId(companyId);
		contentDetail.setUserId(userId);
		contentDetail.setUserName(userName);
		contentDetail.setCreateDate(creationDate);
		contentDetail.setModifiedDate(modifiedDate);
		contentDetail.setVersion(version);
		contentDetail.setSubTitle(subTitle);
		contentDetail.setTitle(title);
		contentDetail.setSummary(summary);
		contentDetail.setSubContent(subContent);
		contentDetail.setContent(sContent);
		if(Validator.isNotNull(smallImageUrl)){
			contentDetail.setSmallImageUrl(smallImageUrl);
		}
		contentDetail.setCategoryId(categoryId);
		contentDetail.setStatus(status);
		
		contentDetail.setNewsType(newsType);
		
		//Update legal field
		contentDetail.setImageUrl(imageUrl);
		contentDetail.setIsLegalContent(isLegalContent);
		contentDetail.setImageCaption(imageCaption);
		contentDetail.setImagePosition(imagePosition);
		
		if ((serviceContext.getGroupPermissions() != null) || (serviceContext.getGuestPermissions() != null)) {
			addContentResource(contentDetail, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}
		return contentDetailPersistence.update(contentDetail);
	}
	
	protected void addContentResource(ContentDetail contentDetail, String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(contentDetail.getCompanyId(), contentDetail.getGroupId(),
				contentDetail.getUserId(), Content.class.getName(), contentDetail.getPrimaryKey(), groupPermissions,
				guestPermissions);
	}

	protected void updateContentResource(ContentDetail contentDetail, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.updateResources(contentDetail.getCompanyId(), contentDetail.getGroupId(),
				Content.class.getName(), contentDetail.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}