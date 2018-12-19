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

package com.portal_egov.portlet.legal_faq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegalFAQCategoryService}.
 *
 * @author chuchv
 * @see LegalFAQCategoryService
 * @generated
 */
public class LegalFAQCategoryServiceWrapper implements LegalFAQCategoryService,
	ServiceWrapper<LegalFAQCategoryService> {
	public LegalFAQCategoryServiceWrapper(
		LegalFAQCategoryService legalFAQCategoryService) {
		_legalFAQCategoryService = legalFAQCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legalFAQCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legalFAQCategoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legalFAQCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegalFAQCategoryService getWrappedLegalFAQCategoryService() {
		return _legalFAQCategoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegalFAQCategoryService(
		LegalFAQCategoryService legalFAQCategoryService) {
		_legalFAQCategoryService = legalFAQCategoryService;
	}

	@Override
	public LegalFAQCategoryService getWrappedService() {
		return _legalFAQCategoryService;
	}

	@Override
	public void setWrappedService(
		LegalFAQCategoryService legalFAQCategoryService) {
		_legalFAQCategoryService = legalFAQCategoryService;
	}

	private LegalFAQCategoryService _legalFAQCategoryService;
}