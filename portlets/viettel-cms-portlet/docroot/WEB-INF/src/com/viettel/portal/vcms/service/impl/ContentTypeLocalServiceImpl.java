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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.ContentProfit;
import com.viettel.portal.vcms.model.ContentType;
import com.viettel.portal.vcms.service.ContentTypeLocalService;
import com.viettel.portal.vcms.service.base.ContentTypeLocalServiceBaseImpl;
import com.viettel.portal.vcms.service.persistence.ContentTypeUtil;

/**
 * The implementation of the content type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.vcms.service.ContentTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.ContentTypeLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.ContentTypeLocalServiceUtil
 */
public class ContentTypeLocalServiceImpl extends ContentTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.vcms.service.ContentTypeLocalServiceUtil} to access the content type local service.
	 */
	public List<ContentType> getContentTypes(long groupId, String keyword, int start, int end) throws PortalException, SystemException{
		return contentTypeFinder.findByName(groupId, keyword, start, end);
	}
	public int countContentTypes(long groupId, String keyword) throws PortalException, SystemException{
		return contentTypeFinder.countByName(groupId, keyword);
	}
	public void updateContentType(long groupId, long companyId, long userId, long contentTypeId, 
			String name, String desc, int sortOrder, double cost, ServiceContext context) throws PortalException, SystemException{
		if(contentTypeId > 0){
			ContentType cType = contentTypePersistence.fetchByPrimaryKey(contentTypeId);
			cType.setName(name);
			cType.setDescription(desc);
			cType.setSortOrder(sortOrder);
			cType.setCost(cost);
			updateContentResource(cType, context.getGroupPermissions(), context.getGuestPermissions());
			contentTypePersistence.update(cType);
		}else{
			contentTypeId = counterLocalService.increment();
			ContentType cType = contentTypePersistence.create(contentTypeId);
			cType.setGroupId(groupId);
			cType.setCompanyId(companyId);
			cType.setUserId(userId);
			cType.setName(name);
			cType.setDescription(desc);
			cType.setSortOrder(sortOrder);
			cType.setCost(cost);
			addContentResource(cType, context.getGroupPermissions(), context.getGuestPermissions());
			contentTypePersistence.update(cType);
		}
	}
	
	protected void addContentResource(ContentType entity, String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(entity.getCompanyId(), entity.getGroupId(),
				entity.getUserId(), Content.class.getName(), entity.getPrimaryKey(), groupPermissions,
				guestPermissions);
	}
	public List<ContentType> getAllContentType(long groupId) throws SystemException, PortalException{
		return ContentTypeUtil.findByGroupId(groupId);
	}
	protected void updateContentResource(ContentType entity, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.updateResources(entity.getCompanyId(), entity.getGroupId(),
				Content.class.getName(), entity.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}