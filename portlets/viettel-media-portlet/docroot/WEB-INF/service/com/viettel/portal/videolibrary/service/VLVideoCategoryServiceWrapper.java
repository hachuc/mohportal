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
 * Provides a wrapper for {@link VLVideoCategoryService}.
 *
 * @author ChucHV
 * @see VLVideoCategoryService
 * @generated
 */
public class VLVideoCategoryServiceWrapper implements VLVideoCategoryService,
	ServiceWrapper<VLVideoCategoryService> {
	public VLVideoCategoryServiceWrapper(
		VLVideoCategoryService vlVideoCategoryService) {
		_vlVideoCategoryService = vlVideoCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vlVideoCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vlVideoCategoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vlVideoCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoCategoryService.findByCategory(categoryId, groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoCategoryService.findByVideo(videoId, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VLVideoCategoryService getWrappedVLVideoCategoryService() {
		return _vlVideoCategoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVLVideoCategoryService(
		VLVideoCategoryService vlVideoCategoryService) {
		_vlVideoCategoryService = vlVideoCategoryService;
	}

	@Override
	public VLVideoCategoryService getWrappedService() {
		return _vlVideoCategoryService;
	}

	@Override
	public void setWrappedService(VLVideoCategoryService vlVideoCategoryService) {
		_vlVideoCategoryService = vlVideoCategoryService;
	}

	private VLVideoCategoryService _vlVideoCategoryService;
}