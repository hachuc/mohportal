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
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.ContentDetail;
import com.viettel.portal.vcms.model.ContentProfit;
import com.viettel.portal.vcms.service.base.ContentProfitLocalServiceBaseImpl;

/**
 * The implementation of the content profit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.vcms.service.ContentProfitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.ContentProfitLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.ContentProfitLocalServiceUtil
 */
public class ContentProfitLocalServiceImpl
	extends ContentProfitLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.vcms.service.ContentProfitLocalServiceUtil} to access the content profit local service.
	 */
	public void addContentCost(long groupId, long companyId, long userId, String userName, Date distributionDate,
			int contentTypeId, String headLine, ServiceContext serviceContext) throws PortalException, SystemException{
		
	}
	
	protected void addContentResource(ContentProfit entity, String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(entity.getCompanyId(), entity.getGroupId(),
				entity.getUserId(), Content.class.getName(), entity.getPrimaryKey(), groupPermissions,
				guestPermissions);
	}

	protected void updateContentResource(ContentProfit entity, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.updateResources(entity.getCompanyId(), entity.getGroupId(),
				Content.class.getName(), entity.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}