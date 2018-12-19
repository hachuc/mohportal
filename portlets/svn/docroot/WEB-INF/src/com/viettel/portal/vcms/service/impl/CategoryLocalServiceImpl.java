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
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.vcms.model.Category;
import com.viettel.portal.vcms.service.base.CategoryLocalServiceBaseImpl;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.viettel.portal.vcms.service.CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.CategoryLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.CategoryLocalServiceUtil
 */
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.viettel.portal.vcms.service.CategoryLocalServiceUtil} to access the
	 * category local service.
	 */
	public List<Category> getCategories(long groupId, int start, int end) throws SystemException, PortalException {
		return categoryPersistence.findByG_C(groupId, start, end);
	}
	public List<Category> getAllCategories(long groupId) throws SystemException, PortalException {
		return categoryPersistence.findByG_C(groupId);
	}
	public int getCountCategories(long groupId) throws SystemException, PortalException {
		return categoryPersistence.countByG_C(groupId);
	}

	public Category addCategory(long companyId, long groupId, long userId, int sortOrder, String categoryName,
			String categoryDesc, ServiceContext serviceContext) throws SystemException, PortalException {

		Date now = new Date();

		long categoryId = counterLocalService.increment();

		Category category = categoryPersistence.create(categoryId);

		category.setCompanyId(companyId);
		category.setGroupId(groupId);
		category.setUserId(userId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		category.setSortOrder(sortOrder);
		category.setCreateDate(now);
		category.setModifiedDate(now);

		categoryPersistence.update(category);

		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

			addCategoryResources(category, serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGuestPermissions());
		} else {

			addCategoryResources(category, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}

		return category;
	}
	
	public Category addLegalCategory(long companyId, long groupId, long userId, int categoryId, int sortOrder, String categoryName,
			String categoryDesc, ServiceContext serviceContext) throws SystemException, PortalException {

		Date now = new Date();

		Category category = categoryPersistence.create(categoryId);

		category.setCompanyId(companyId);
		category.setGroupId(groupId);
		category.setUserId(userId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		category.setSortOrder(sortOrder);
		category.setCreateDate(now);
		category.setModifiedDate(now);

		categoryPersistence.update(category);

		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

			addCategoryResources(category, serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGuestPermissions());
		} else {

			addCategoryResources(category, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}

		return category;
	}

	public Category updateCategory(long categoryId, long companyId, long groupId, long userId, int sortOrder,
			String categoryName, String categoryDesc) throws SystemException, PortalException {

		Date now = new Date();

		Category category = categoryPersistence.fetchByPrimaryKey(categoryId);

		category.setCompanyId(companyId);
		category.setGroupId(groupId);
		category.setUserId(userId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		category.setSortOrder(sortOrder);
		category.setModifiedDate(now);

		categoryPersistence.update(category);

		return category;
	}

	public void delCategory(long categoryId) throws SystemException, PortalException {

		Category Category = categoryPersistence.fetchByPrimaryKey(categoryId);

		if (Category != null) {

			categoryPersistence.remove(Category);
			resourceLocalService.deleteResource(Category.getCompanyId(), Category.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, Category.getCategoryId());
		}
	}

	private void addCategoryResources(Category category, boolean addGroupPermissions,
			boolean addGuestPermissions) throws PortalException, SystemException {

		resourceLocalService.addResources(category.getCompanyId(), category.getGroupId(),
				category.getUserId(), Category.class.getName(), category.getCategoryId(), false,
				addGroupPermissions, addGuestPermissions);
	}

	private void addCategoryResources(Category category, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.addModelResources(category.getCompanyId(), category.getGroupId(),
				category.getUserId(), Category.class.getName(), category.getCategoryId(),
				groupPermissions, guestPermissions);
	}
}