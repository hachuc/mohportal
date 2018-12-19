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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.service.base.DistributionLocalServiceBaseImpl;
import com.viettel.portal.vcms.service.persistence.DistributionUtil;

/**
 * The implementation of the distribution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.vcms.service.DistributionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.DistributionLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.DistributionLocalServiceUtil
 */
public class DistributionLocalServiceImpl
	extends DistributionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.vcms.service.DistributionLocalServiceUtil} to access the distribution local service.
	 */
	public List<Distribution> findByPubishedDate(long groupId, long[] categoryIds, String publishedDate, int start, int end) throws PortalException, SystemException{
		return distributionFinder.findByPubishedDate(groupId, categoryIds, publishedDate, start, end);
	}
	public int countByPubishedDate(long groupId, long[] categoryIds, String publishedDate) throws PortalException, SystemException{
		return distributionFinder.countByPubishedDate(groupId, categoryIds, publishedDate);
	}
	public List<Distribution> getByGroupAndCategory(long groupId, long[] categoryIds, int start, int end) throws SystemException,
	PortalException {
		return distributionFinder.findByGroupAndCategory(groupId, categoryIds, null, start, end);
	}
	public int getCountByGroupAndCategory(long groupId, long[] categoryIds) throws PortalException, SystemException{
		return distributionFinder.countByGroupAndCategory(groupId, categoryIds);
	}
	public List<Distribution> findRelateContents(long groupId, long distributionId, int start, int end) throws PortalException, SystemException{
		return distributionFinder.findNewsestContents(groupId, distributionId, start, end);
	}
	public void deleteByGroupAndCategory(long groupId, long categoryId) throws PortalException, SystemException{
		DistributionUtil.removeByByGroupNCategory(groupId, categoryId);
	}
	public void publishContent(long groupId, long companyId,
			long userId, String userName, long contentId, int version, String title, long[] categoryIds, boolean allowDiscussion,
			Date publishDate, ServiceContext serviceContext) throws SystemException,
			PortalException {
		Date now = new Date();
		if(categoryIds.length<=0)
			return;
		for(long cateId : categoryIds ){
			long distributionId = counterLocalService.increment();
			Distribution distribution = distributionPersistence.create(distributionId);
			distribution.setAllowDiscussion(allowDiscussion);
			distribution.setCategoryId(cateId);
			distribution.setCompanyId(companyId);
			distribution.setContentId(contentId);
			distribution.setCreateDate(now);
			distribution.setDistributedDate(publishDate);
			distribution.setGroupId(groupId);
			distribution.setUserId(userId);
			distribution.setUserName(userName);
			distribution.setVersion(version);
			distribution.setTitle(title);
			addContentResource(distribution, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
			distributionPersistence.update(distribution);
		}
	}
	public void addLegalDistribution(long groupId, long companyId, long userId, String userName,int distId, int contentId, int version, String title,
			int categoryId, boolean allowDiscustion, Date pubishDate, ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();
		Distribution distribution = distributionPersistence.create(distId);
		distribution.setAllowDiscussion(allowDiscustion);
		distribution.setCategoryId(categoryId);
		distribution.setCompanyId(companyId);
		distribution.setContentId(contentId);
		distribution.setCreateDate(now);
		distribution.setDistributedDate(pubishDate);
		distribution.setGroupId(groupId);
		distribution.setUserId(userId);
		distribution.setUserName(userName);
		distribution.setVersion(version);
		distribution.setTitle(title);
		addContentResource(distribution, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		distributionPersistence.update(distribution);
	}
	public void unPublishContent(long groupId, long contentId) throws PortalException, SystemException{
		List<Distribution> lstDistribution = distributionPersistence.filterFindByGroupContentId(groupId, contentId);
		if(lstDistribution.isEmpty()){
			return;
		}
		for(Distribution di : lstDistribution){
			distributionPersistence.remove(di);
		}
	}
	protected void addContentResource(Distribution content,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(content.getCompanyId(),
				content.getGroupId(), content.getUserId(), Distribution.class.getName(),
				content.getPrimaryKey(), groupPermissions, guestPermissions);
	}
	
	public void deleteAllLocations(long groupId, long categoryId) throws SystemException{
		DistributionUtil.removeByByGroupNCategory(groupId, categoryId);
	}
	
	public void removeAll() throws SystemException, PortalException{
		DistributionUtil.removeAll();
	}
}