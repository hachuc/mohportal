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

package com.revotech.portal.videolibrary.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for VLVideoCategory. This utility wraps
 * {@link com.revotech.portal.videolibrary.service.impl.VLVideoCategoryServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author ChucHV
 * @see VLVideoCategoryService
 * @see com.revotech.portal.videolibrary.service.base.VLVideoCategoryServiceBaseImpl
 * @see com.revotech.portal.videolibrary.service.impl.VLVideoCategoryServiceImpl
 * @generated
 */
public class VLVideoCategoryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.revotech.portal.videolibrary.service.impl.VLVideoCategoryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(categoryId, groupId);
	}

	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByVideo(videoId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VLVideoCategoryService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VLVideoCategoryService.class.getName());

			if (invokableService instanceof VLVideoCategoryService) {
				_service = (VLVideoCategoryService)invokableService;
			}
			else {
				_service = new VLVideoCategoryServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(VLVideoCategoryServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VLVideoCategoryService service) {
	}

	private static VLVideoCategoryService _service;
}