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
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.links.model.LCategory;
import com.viettel.portal.links.service.impl.LCategoryLocalServiceImpl;
import com.viettel.portal.links.service.persistence.LCategoryFinderUtil;
import com.viettel.portal.links.service.base.LCategoryLocalServiceBaseImpl;

/**
 * The implementation of the l category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.links.service.LCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.links.service.base.LCategoryLocalServiceBaseImpl
 * @see com.viettel.portal.links.service.LCategoryLocalServiceUtil
 */
public class LCategoryLocalServiceImpl extends LCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.links.service.CategoryLocalServiceUtil} to access the category local service.
	 */
	public int countByGroup(long groupId) throws SystemException{
		return lCategoryPersistence.countByGroup(groupId);
	}
	
	public List<LCategory> findByGroup(long groupId) throws SystemException{
		return lCategoryPersistence.findByGroup(groupId);
	}
	
	public int countByGroupAndState(long groupId, boolean isActive) throws SystemException{
		return lCategoryPersistence.countByGroupAndState(groupId, isActive);
	}
	
	public List<LCategory> findByGroupAndState(long groupId, boolean isActive) throws SystemException{
		return lCategoryPersistence.findByGroupAndState(groupId, isActive);
	}
	
	
	public List<LCategory> findByGroup(long groupId, int start, int end) throws SystemException{
		return lCategoryPersistence.findByGroup(groupId, start, end);
	}
	
	public List<LCategory> findByCategoryName(String categoryName, long groupId) throws SystemException{
		return lCategoryPersistence.findByCategoryName(categoryName, groupId);
	}

	public LCategory addCategory(long companyId, long groupId, long userId,
			String userName, String categoryName, boolean isActive, int corder,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		Date now = new Date();

		long categoryId = counterLocalService.increment(LCategory.class.getName());

		LCategory category = lCategoryPersistence.create(categoryId);

		category.setGroupId(groupId);
		category.setCompanyId(companyId);
		category.setUserId(userId);
		category.setUserName(userName);
		category.setCreateDate(now);
		category.setModifiedDate(now);
		category.setCategoryName(categoryName);
		category.setCategoryId(categoryId);
		category.setIsActive(isActive);
		category.setCorder(corder);

		resourceLocalService.addModelResources(category, serviceContext);

		return lCategoryPersistence.update(category);
	}

	public LCategory updateCategory(long categoryId, long companyId,
			long groupId, long userId, String userName, String categoryName,
			boolean isActive, int corder, ServiceContext serviceContext)
			throws SystemException, PortalException {

		Date now = new Date();

		LCategory category = lCategoryPersistence
				.fetchByPrimaryKey(categoryId);

		category.setGroupId(groupId);
		category.setCompanyId(companyId);
		category.setUserId(userId);
		category.setUserName(userName);
		category.setCreateDate(now);
		category.setModifiedDate(now);
		category.setCategoryName(categoryName);
		category.setIsActive(isActive);
		category.setCorder(corder);

		if ((serviceContext.getGroupPermissions() != null)
				|| (serviceContext.getGuestPermissions() != null)) {

			updateCategoryResource(category,
					serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}

		return lCategoryPersistence.update(category);
	}

	protected void updateCategoryResource(LCategory category,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(category.getCompanyId(),
				category.getGroupId(), LCategory.class.getName(),
				category.getPrimaryKey(), groupPermissions, guestPermissions);
	}
	private static final Log LOG = LogFactoryUtil.getLog(LCategoryLocalServiceImpl.class);
}