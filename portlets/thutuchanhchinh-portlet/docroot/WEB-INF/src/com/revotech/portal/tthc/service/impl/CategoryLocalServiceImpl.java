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

package com.revotech.portal.tthc.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.revotech.portal.tthc.model.Category;
import com.revotech.portal.tthc.service.CategoryLocalServiceUtil;
import com.revotech.portal.tthc.service.base.CategoryLocalServiceBaseImpl;
import com.revotech.portal.tthc.service.persistence.CategoryFinderUtil;
import com.revotech.portal.tthc.service.persistence.CategoryUtil;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.revotech.portal.tthc.service.CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hieptran
 * @see com.revotech.portal.tthc.service.base.CategoryLocalServiceBaseImpl
 * @see com.revotech.portal.tthc.service.CategoryLocalServiceUtil
 */
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.revotech.portal.tthc.service.CategoryLocalServiceUtil} to access the category local service.
	 */
	public List<Category> findByKeyword(long groupId, String keyword, int categoryType, int start, int end)  throws PortalException, SystemException{
		return CategoryFinderUtil.findByKeyword(keyword, groupId, categoryType, start, end);
	}
	public int countByKeyword(long groupId, String keyword, int categoryType) throws PortalException, SystemException{
		return CategoryFinderUtil.countByKeyword(keyword, groupId, categoryType);
	}
	public List<Category> getByCategoryType(long groupId, int categoryType) throws PortalException, SystemException{
		return CategoryUtil.filterFindByG_C_A(categoryType, true, groupId);
	}
	public List<Category> getCategories(long groupId, boolean isActive, int categoryType, int start, int end) throws PortalException, SystemException{
		return CategoryUtil.findByG_C_A(categoryType, isActive, groupId, start, end);
	}
	public List<Category> findByCategoryName(long groupId, int categoryType, String categoryName) throws SystemException, PortalException{
		return categoryPersistence.findByCategoryName(categoryName, groupId, categoryType);
	}
	public void addCategory(long groupId, long companyId, long userId, String userName, String categoryName, String categoryDesc, 
			int categoryType, int catOrder, boolean isActive, ServiceContext serviceContext) throws PortalException, SystemException{
		long categoryId = CounterLocalServiceUtil.increment(Category.class.getName());
		Category cat = categoryPersistence.create(categoryId);
		
		Date now = new Date();
		
		cat.setGroupId(groupId);
		cat.setCompanyId(companyId);
		cat.setUserId(userId);
		cat.setUserName(userName);
		cat.setCategoryName(categoryName);
		cat.setCategoryDesc(categoryDesc);
		cat.setCategoryType(categoryType);
		cat.setCatOrder(catOrder);
		cat.setCreateDate(now);
		cat.setModifiedDate(now);
		cat.setIsActive(isActive);
		//categoryPersistence.update(cat);
		resourceLocalService.addModelResources(cat, serviceContext);
		categoryPersistence.update(cat);
	}
	
	public void updateCategory(long groupId, long companyId, long userId, String userName, long categoryId, String categoryName, 
			String categoryDesc, boolean isActive,  int categoryType, int catOrder, ServiceContext serviceContext) throws PortalException, SystemException{
		
		Category cat = categoryPersistence.fetchByPrimaryKey(categoryId);
		if(cat == null)
			return;
		Date now = new Date();
		cat.setGroupId(groupId);
		cat.setCompanyId(companyId);
		cat.setUserId(userId);
		cat.setUserName(userName);
		cat.setCategoryName(categoryName);
		cat.setCategoryDesc(categoryDesc);
		cat.setCategoryType(categoryType);
		cat.setCatOrder(catOrder);
		cat.setIsActive(isActive);
		cat.setModifiedDate(now);
		categoryPersistence.update(cat);
		if ((serviceContext.getGroupPermissions() != null)
				|| (serviceContext.getGuestPermissions() != null)) {

			updateBannerResource(cat, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}
	}
	
	protected void addBannerResource(Category banner,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(banner.getCompanyId(),
				banner.getGroupId(), banner.getUserId(), Category.class.getName(),
				banner.getPrimaryKey(), groupPermissions, guestPermissions);
	}

	protected void updateBannerResource(Category banner,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(banner.getCompanyId(),
				banner.getGroupId(), Category.class.getName(),
				banner.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}