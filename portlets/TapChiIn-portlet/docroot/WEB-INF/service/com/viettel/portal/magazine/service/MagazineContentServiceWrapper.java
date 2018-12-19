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

package com.viettel.portal.magazine.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MagazineContentService}.
 *
 * @author namtv
 * @see MagazineContentService
 * @generated
 */
public class MagazineContentServiceWrapper implements MagazineContentService,
	ServiceWrapper<MagazineContentService> {
	public MagazineContentServiceWrapper(
		MagazineContentService magazineContentService) {
		_magazineContentService = magazineContentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _magazineContentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_magazineContentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _magazineContentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MagazineContentService getWrappedMagazineContentService() {
		return _magazineContentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMagazineContentService(
		MagazineContentService magazineContentService) {
		_magazineContentService = magazineContentService;
	}

	@Override
	public MagazineContentService getWrappedService() {
		return _magazineContentService;
	}

	@Override
	public void setWrappedService(MagazineContentService magazineContentService) {
		_magazineContentService = magazineContentService;
	}

	private MagazineContentService _magazineContentService;
}