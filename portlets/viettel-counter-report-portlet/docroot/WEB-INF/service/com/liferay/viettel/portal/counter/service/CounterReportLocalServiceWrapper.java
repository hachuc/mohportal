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

package com.liferay.viettel.portal.counter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CounterReportLocalService}.
 *
 * @author chuchv
 * @see CounterReportLocalService
 * @generated
 */
public class CounterReportLocalServiceWrapper
	implements CounterReportLocalService,
		ServiceWrapper<CounterReportLocalService> {
	public CounterReportLocalServiceWrapper(
		CounterReportLocalService counterReportLocalService) {
		_counterReportLocalService = counterReportLocalService;
	}

	/**
	* Adds the counter report to the database. Also notifies the appropriate model listeners.
	*
	* @param counterReport the counter report
	* @return the counter report that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport addCounterReport(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.addCounterReport(counterReport);
	}

	/**
	* Creates a new counter report with the primary key. Does not add the counter report to the database.
	*
	* @param reportId the primary key for the new counter report
	* @return the new counter report
	*/
	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport createCounterReport(
		long reportId) {
		return _counterReportLocalService.createCounterReport(reportId);
	}

	/**
	* Deletes the counter report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportId the primary key of the counter report
	* @return the counter report that was removed
	* @throws PortalException if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport deleteCounterReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.deleteCounterReport(reportId);
	}

	/**
	* Deletes the counter report from the database. Also notifies the appropriate model listeners.
	*
	* @param counterReport the counter report
	* @return the counter report that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport deleteCounterReport(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.deleteCounterReport(counterReport);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _counterReportLocalService.dynamicQuery();
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
		return _counterReportLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _counterReportLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _counterReportLocalService.dynamicQuery(dynamicQuery, start,
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
		return _counterReportLocalService.dynamicQueryCount(dynamicQuery);
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
		return _counterReportLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport fetchCounterReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.fetchCounterReport(reportId);
	}

	/**
	* Returns the counter report with the primary key.
	*
	* @param reportId the primary key of the counter report
	* @return the counter report
	* @throws PortalException if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport getCounterReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.getCounterReport(reportId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the counter reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of counter reports
	* @param end the upper bound of the range of counter reports (not inclusive)
	* @return the range of counter reports
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> getCounterReports(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.getCounterReports(start, end);
	}

	/**
	* Returns the number of counter reports.
	*
	* @return the number of counter reports
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCounterReportsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.getCounterReportsCount();
	}

	/**
	* Updates the counter report in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param counterReport the counter report
	* @return the counter report that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport updateCounterReport(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _counterReportLocalService.updateCounterReport(counterReport);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _counterReportLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_counterReportLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _counterReportLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int counterCategory(long categoryId, java.util.Date start,
		java.util.Date end) {
		return _counterReportLocalService.counterCategory(categoryId, start, end);
	}

	@Override
	public java.util.List<com.liferay.viettel.portal.counter.ReportCounter> counterArticle(
		long categoryId, java.util.Date startDate, java.util.Date endDate,
		int start, int end) {
		return _counterReportLocalService.counterArticle(categoryId, startDate,
			endDate, start, end);
	}

	@Override
	public int countArticle(long categoryId, java.util.Date startDate,
		java.util.Date endDate, int start, int end) {
		return _counterReportLocalService.countArticle(categoryId, startDate,
			endDate, start, end);
	}

	@Override
	public int counterVisitor(java.util.Date date) {
		return _counterReportLocalService.counterVisitor(date);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CounterReportLocalService getWrappedCounterReportLocalService() {
		return _counterReportLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCounterReportLocalService(
		CounterReportLocalService counterReportLocalService) {
		_counterReportLocalService = counterReportLocalService;
	}

	@Override
	public CounterReportLocalService getWrappedService() {
		return _counterReportLocalService;
	}

	@Override
	public void setWrappedService(
		CounterReportLocalService counterReportLocalService) {
		_counterReportLocalService = counterReportLocalService;
	}

	private CounterReportLocalService _counterReportLocalService;
}