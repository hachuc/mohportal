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

package com.viettel.portal.videolibrary.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VLCategoryService}.
 *
 * @author ChucHV
 * @see VLCategoryService
 * @generated
 */
public class VLCategoryServiceWrapper implements VLCategoryService,
	ServiceWrapper<VLCategoryService> {
	public VLCategoryServiceWrapper(VLCategoryService vlCategoryService) {
		_vlCategoryService = vlCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vlCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vlCategoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vlCategoryService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLCategory addVLCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, boolean invisible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryService.addVLCategory(companyId, groupId, userId,
			userName, categoryName, invisible, serviceContext);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryService.countAll();
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryService.findByCategoryName(categoryName, groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryService.findByGroup(groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryService.findAll();
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryService.findAll(start, end);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLCategory updateVLCategory(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String categoryName,
		boolean invisible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryService.updateVLCategory(categoryId, companyId,
			groupId, userId, userName, categoryName, invisible, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VLCategoryService getWrappedVLCategoryService() {
		return _vlCategoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVLCategoryService(VLCategoryService vlCategoryService) {
		_vlCategoryService = vlCategoryService;
	}

	@Override
	public VLCategoryService getWrappedService() {
		return _vlCategoryService;
	}

	@Override
	public void setWrappedService(VLCategoryService vlCategoryService) {
		_vlCategoryService = vlCategoryService;
	}

	private VLCategoryService _vlCategoryService;
}