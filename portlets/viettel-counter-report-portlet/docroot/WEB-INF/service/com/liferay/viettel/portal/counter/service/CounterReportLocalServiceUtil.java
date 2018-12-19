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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CounterReport. This utility wraps
 * {@link com.liferay.viettel.portal.counter.service.impl.CounterReportLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author chuchv
 * @see CounterReportLocalService
 * @see com.liferay.viettel.portal.counter.service.base.CounterReportLocalServiceBaseImpl
 * @see com.liferay.viettel.portal.counter.service.impl.CounterReportLocalServiceImpl
 * @generated
 */
public class CounterReportLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.viettel.portal.counter.service.impl.CounterReportLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the counter report to the database. Also notifies the appropriate model listeners.
	*
	* @param counterReport the counter report
	* @return the counter report that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.CounterReport addCounterReport(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCounterReport(counterReport);
	}

	/**
	* Creates a new counter report with the primary key. Does not add the counter report to the database.
	*
	* @param reportId the primary key for the new counter report
	* @return the new counter report
	*/
	public static com.liferay.viettel.portal.counter.model.CounterReport createCounterReport(
		long reportId) {
		return getService().createCounterReport(reportId);
	}

	/**
	* Deletes the counter report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportId the primary key of the counter report
	* @return the counter report that was removed
	* @throws PortalException if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.CounterReport deleteCounterReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCounterReport(reportId);
	}

	/**
	* Deletes the counter report from the database. Also notifies the appropriate model listeners.
	*
	* @param counterReport the counter report
	* @return the counter report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.CounterReport deleteCounterReport(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCounterReport(counterReport);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.viettel.portal.counter.model.CounterReport fetchCounterReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCounterReport(reportId);
	}

	/**
	* Returns the counter report with the primary key.
	*
	* @param reportId the primary key of the counter report
	* @return the counter report
	* @throws PortalException if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.CounterReport getCounterReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCounterReport(reportId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> getCounterReports(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCounterReports(start, end);
	}

	/**
	* Returns the number of counter reports.
	*
	* @return the number of counter reports
	* @throws SystemException if a system exception occurred
	*/
	public static int getCounterReportsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCounterReportsCount();
	}

	/**
	* Updates the counter report in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param counterReport the counter report
	* @return the counter report that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.CounterReport updateCounterReport(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCounterReport(counterReport);
	}

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

	public static int counterCategory(long categoryId, java.util.Date start,
		java.util.Date end) {
		return getService().counterCategory(categoryId, start, end);
	}

	public static java.util.List<com.liferay.viettel.portal.counter.ReportCounter> counterArticle(
		long categoryId, java.util.Date startDate, java.util.Date endDate,
		int start, int end) {
		return getService()
				   .counterArticle(categoryId, startDate, endDate, start, end);
	}

	public static int countArticle(long categoryId, java.util.Date startDate,
		java.util.Date endDate, int start, int end) {
		return getService()
				   .countArticle(categoryId, startDate, endDate, start, end);
	}

	public static int counterVisitor(java.util.Date date) {
		return getService().counterVisitor(date);
	}

	public static void clearService() {
		_service = null;
	}

	public static CounterReportLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CounterReportLocalService.class.getName());

			if (invokableLocalService instanceof CounterReportLocalService) {
				_service = (CounterReportLocalService)invokableLocalService;
			}
			else {
				_service = new CounterReportLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CounterReportLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CounterReportLocalService service) {
	}

	private static CounterReportLocalService _service;
}