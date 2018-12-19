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

package com.liferay.viettel.portal.visitcounter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VisitCounterLogService}.
 *
 * @author hiepth6
 * @see VisitCounterLogService
 * @generated
 */
public class VisitCounterLogServiceWrapper implements VisitCounterLogService,
	ServiceWrapper<VisitCounterLogService> {
	public VisitCounterLogServiceWrapper(
		VisitCounterLogService visitCounterLogService) {
		_visitCounterLogService = visitCounterLogService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _visitCounterLogService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_visitCounterLogService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _visitCounterLogService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VisitCounterLogService getWrappedVisitCounterLogService() {
		return _visitCounterLogService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVisitCounterLogService(
		VisitCounterLogService visitCounterLogService) {
		_visitCounterLogService = visitCounterLogService;
	}

	@Override
	public VisitCounterLogService getWrappedService() {
		return _visitCounterLogService;
	}

	@Override
	public void setWrappedService(VisitCounterLogService visitCounterLogService) {
		_visitCounterLogService = visitCounterLogService;
	}

	private VisitCounterLogService _visitCounterLogService;
}