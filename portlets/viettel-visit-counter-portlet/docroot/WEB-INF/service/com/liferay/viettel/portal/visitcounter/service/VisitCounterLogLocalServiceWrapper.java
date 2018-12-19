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
 * Provides a wrapper for {@link VisitCounterLogLocalService}.
 *
 * @author hiepth6
 * @see VisitCounterLogLocalService
 * @generated
 */
public class VisitCounterLogLocalServiceWrapper
	implements VisitCounterLogLocalService,
		ServiceWrapper<VisitCounterLogLocalService> {
	public VisitCounterLogLocalServiceWrapper(
		VisitCounterLogLocalService visitCounterLogLocalService) {
		_visitCounterLogLocalService = visitCounterLogLocalService;
	}

	/**
	* Adds the visit counter log to the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog addVisitCounterLog(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.addVisitCounterLog(visitCounterLog);
	}

	/**
	* Creates a new visit counter log with the primary key. Does not add the visit counter log to the database.
	*
	* @param visitorIp the primary key for the new visit counter log
	* @return the new visit counter log
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog createVisitCounterLog(
		java.lang.String visitorIp) {
		return _visitCounterLogLocalService.createVisitCounterLog(visitorIp);
	}

	/**
	* Deletes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log that was removed
	* @throws PortalException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog deleteVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.deleteVisitCounterLog(visitorIp);
	}

	/**
	* Deletes the visit counter log from the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog deleteVisitCounterLog(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.deleteVisitCounterLog(visitCounterLog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _visitCounterLogLocalService.dynamicQuery();
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
		return _visitCounterLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _visitCounterLogLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _visitCounterLogLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _visitCounterLogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _visitCounterLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog fetchVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.fetchVisitCounterLog(visitorIp);
	}

	/**
	* Returns the visit counter log with the primary key.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log
	* @throws PortalException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog getVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getVisitCounterLog(visitorIp);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the visit counter logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @return the range of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> getVisitCounterLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getVisitCounterLogs(start, end);
	}

	/**
	* Returns the number of visit counter logs.
	*
	* @return the number of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVisitCounterLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getVisitCounterLogsCount();
	}

	/**
	* Updates the visit counter log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog updateVisitCounterLog(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.updateVisitCounterLog(visitCounterLog);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _visitCounterLogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_visitCounterLogLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _visitCounterLogLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.findAll();
	}

	@Override
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.findByCompany(companyId);
	}

	@Override
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.findByGroup(groupId);
	}

	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog getCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getCounterLog(visitorIp);
	}

	@Override
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog addCounterLog(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String visitorIp, long lastAccessPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.addCounterLog(companyId, groupId,
			userId, userName, visitorIp, lastAccessPageId);
	}

	@Override
	public void updateCounterLog(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String visitorIp, int hitCounter,
		long lastAccessPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounterLogLocalService.updateCounterLog(companyId, groupId,
			userId, userName, visitorIp, hitCounter, lastAccessPageId);
	}

	@Override
	public void incrementCounter(java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounterLogLocalService.incrementCounter(visitorIp);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VisitCounterLogLocalService getWrappedVisitCounterLogLocalService() {
		return _visitCounterLogLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVisitCounterLogLocalService(
		VisitCounterLogLocalService visitCounterLogLocalService) {
		_visitCounterLogLocalService = visitCounterLogLocalService;
	}

	@Override
	public VisitCounterLogLocalService getWrappedService() {
		return _visitCounterLogLocalService;
	}

	@Override
	public void setWrappedService(
		VisitCounterLogLocalService visitCounterLogLocalService) {
		_visitCounterLogLocalService = visitCounterLogLocalService;
	}

	private VisitCounterLogLocalService _visitCounterLogLocalService;
}