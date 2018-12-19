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

package com.viettel.portal.links.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.links.VLinkGrid;
import com.viettel.portal.links.model.LCategory;
import com.viettel.portal.links.model.VLink;
import com.viettel.portal.links.service.impl.VLinkLocalServiceImpl;
import com.viettel.portal.links.service.persistence.VLinkFinderUtil;
import com.viettel.portal.links.service.base.VLinkLocalServiceBaseImpl;

/**
 * The implementation of the v link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.links.service.VLinkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.links.service.base.VLinkLocalServiceBaseImpl
 * @see com.viettel.portal.links.service.VLinkLocalServiceUtil
 */
public class VLinkLocalServiceImpl extends VLinkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.cts.service.LinkLocalServiceUtil} to access the ct local service.
	 */
	public List<VLink> findByGroupAndCateActive(long groupId, long categoryId, boolean isActive) throws SystemException{
		return vLinkPersistence.findByGroupAndCateActive(groupId,categoryId , isActive);
	}
	public VLinkGrid findByKeyword(long groupId, long categoryId, String keyword, int start, int end, OrderByComparator obc){
		try {
			return VLinkFinderUtil.findByKeyword( groupId,  categoryId,  keyword,  start,  end,  obc);
		} catch (Exception e) {
			LOG.error(e);
		}
		return null;
	}
	
	public VLink updateLink(long id, long  companyId,
			long groupId, long userId, String userName, long categoryId, String linkName,String url, int corder
			, ServiceContext serviceContext)throws SystemException,
			PortalException{
		Date now = new Date();
		VLink ct = vLinkPersistence.findByPrimaryKey(id);
		if(ct != null){
			ct.setModifiedDate(now);
			ct.setUserName(userName);
			ct.setUserId(userId);
			ct.setGroupId(groupId);
			ct.setCompanyId(companyId);
			ct.setCorder(corder);
			ct.setLinkName(linkName);
			ct.setUrl(url);
			if(categoryId < 0){
				categoryId = 0l;
			}
			ct.setCategoryId(categoryId);
			if ((serviceContext.getGroupPermissions() != null)
					|| (serviceContext.getGuestPermissions() != null)) {

				updateLinkResource(ct, serviceContext.getGroupPermissions(),
						serviceContext.getGuestPermissions());
			}
			return vLinkPersistence.update(ct);
		}
		return ct;
	}

	public VLink addLink(long  companyId,
			long groupId, long userId, String userName, long categoryId, String linkName,String url, int corder,
			ServiceContext serviceContext)throws SystemException,
			PortalException{

		Date now = new Date();
		long contactId = counterLocalService.increment(VLink.class.getName());
		VLink ct = vLinkPersistence.create(contactId);
		ct.setCreateDate(now);
		ct.setUserName(userName);
		ct.setUserId(userId);
		ct.setGroupId(groupId);
		ct.setCompanyId(companyId);
		ct.setCorder(corder);
		ct.setIsActive(true);
		ct.setLinkName(linkName);
		ct.setUrl(url);
		if(categoryId < 0){
			categoryId = 0l;
		}
		ct.setCategoryId(categoryId);
		if ((serviceContext.getGroupPermissions() != null)
				|| (serviceContext.getGuestPermissions() != null)) {

			addLinkResource(ct, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}
		return vLinkPersistence.update(ct);
	}

	protected void addLinkResource(VLink ct,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(ct.getCompanyId(),
				ct.getGroupId(), ct.getUserId(), VLink.class.getName(),
				ct.getPrimaryKey(), groupPermissions, guestPermissions);
	}

	protected void updateLinkResource(VLink ct,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(ct.getCompanyId(),
				ct.getGroupId(), VLink.class.getName(),
				ct.getPrimaryKey(), groupPermissions, guestPermissions);
	}	
	private static final Log LOG = LogFactoryUtil.getLog(VLinkLocalServiceImpl.class);
}