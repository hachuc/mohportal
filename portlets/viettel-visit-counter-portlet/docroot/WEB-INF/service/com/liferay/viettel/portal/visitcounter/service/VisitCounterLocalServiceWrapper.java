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
 * Provides a wrapper for {@link VisitCounterLocalService}.
 *
 * @author hiepth6
 * @see VisitCounterLocalService
 * @generated
 */
public class VisitCounterLocalServiceWrapper implements VisitCounterLocalService,
	ServiceWrapper<VisitCounterLocalService> {
	public VisitCounterLocalServiceWrapper(
		VisitCounterLocalService visitCounterLocalService) {
		_visitCounterLocalService = visitCounterLocalService;
	}

	/**
	* Adds the visit counter to the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounter the visit counter
	* @return the visit counter that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter addVisitCounter(
		com.liferay.viettel.portal.visitcounter.model.VisitCounter visitCounter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.addVisitCounter(visitCounter);
	}

	/**
	* Creates a new visit counter with the primary key. Does not add the visit counter to the database.
	*
	* @param counterId the primary key for the new visit counter
	* @return the new visit counter
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter createVisitCounter(
		long counterId) {
		return _visitCounterLocalService.createVisitCounter(counterId);
	}

	/**
	* Deletes the visit counter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param counterId the primary key of the visit counter
	* @return the visit counter that was removed
	* @throws PortalException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter deleteVisitCounter(
		long counterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.deleteVisitCounter(counterId);
	}

	/**
	* Deletes the visit counter from the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounter the visit counter
	* @return the visit counter that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter deleteVisitCounter(
		com.liferay.viettel.portal.visitcounter.model.VisitCounter visitCounter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.deleteVisitCounter(visitCounter);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _visitCounterLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter fetchVisitCounter(
		long counterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.fetchVisitCounter(counterId);
	}

	/**
	* Returns the visit counter with the primary key.
	*
	* @param counterId the primary key of the visit counter
	* @return the visit counter
	* @throws PortalException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter getVisitCounter(
		long counterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.getVisitCounter(counterId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the visit counters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @return the range of visit counters
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> getVisitCounters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.getVisitCounters(start, end);
	}

	/**
	* Returns the number of visit counters.
	*
	* @return the number of visit counters
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVisitCountersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.getVisitCountersCount();
	}

	/**
	* Updates the visit counter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param visitCounter the visit counter
	* @return the visit counter that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter updateVisitCounter(
		com.liferay.viettel.portal.visitcounter.model.VisitCounter visitCounter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.updateVisitCounter(visitCounter);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _visitCounterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_visitCounterLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _visitCounterLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.findAll();
	}

	@Override
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.findByCompany(companyId);
	}

	@Override
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.findByGroup(groupId);
	}

	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter getCounter(
		long counterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.getCounter(counterId);
	}

	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounter addCounter(
		long companyId, long groupId, long userId, java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.addCounter(companyId, groupId, userId,
			userName);
	}

	@Override
	public int getCounterValue(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLocalService.getCounterValue(groupId);
	}

	@Override
	public void incrementTotalCounter(long companyId, long groupId,
		long userId, java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounterLocalService.incrementTotalCounter(companyId, groupId,
			userId, userName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VisitCounterLocalService getWrappedVisitCounterLocalService() {
		return _visitCounterLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVisitCounterLocalService(
		VisitCounterLocalService visitCounterLocalService) {
		_visitCounterLocalService = visitCounterLocalService;
	}

	@Override
	public VisitCounterLocalService getWrappedService() {
		return _visitCounterLocalService;
	}

	@Override
	public void setWrappedService(
		VisitCounterLocalService visitCounterLocalService) {
		_visitCounterLocalService = visitCounterLocalService;
	}

	private VisitCounterLocalService _visitCounterLocalService;
}