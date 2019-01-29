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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for VLCategory. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author ChucHV
 * @see VLCategoryServiceUtil
 * @see com.revotech.portal.videolibrary.service.base.VLCategoryServiceBaseImpl
 * @see com.revotech.portal.videolibrary.service.impl.VLCategoryServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VLCategoryService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VLCategoryServiceUtil} to access the v l category remote service. Add custom service methods to {@link com.revotech.portal.videolibrary.service.impl.VLCategoryServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.revotech.portal.videolibrary.model.VLCategory addVLCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, boolean invisible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.revotech.portal.videolibrary.model.VLCategory> findByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.revotech.portal.videolibrary.model.VLCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.revotech.portal.videolibrary.model.VLCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.revotech.portal.videolibrary.model.VLCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.revotech.portal.videolibrary.model.VLCategory updateVLCategory(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String categoryName,
		boolean invisible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}