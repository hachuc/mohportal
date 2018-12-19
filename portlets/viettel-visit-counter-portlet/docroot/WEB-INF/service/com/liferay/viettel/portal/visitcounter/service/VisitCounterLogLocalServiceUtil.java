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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VisitCounterLog. This utility wraps
 * {@link com.liferay.viettel.portal.visitcounter.service.impl.VisitCounterLogLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author hiepth6
 * @see VisitCounterLogLocalService
 * @see com.liferay.viettel.portal.visitcounter.service.base.VisitCounterLogLocalServiceBaseImpl
 * @see com.liferay.viettel.portal.visitcounter.service.impl.VisitCounterLogLocalServiceImpl
 * @generated
 */
public class VisitCounterLogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.viettel.portal.visitcounter.service.impl.VisitCounterLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the visit counter log to the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog addVisitCounterLog(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVisitCounterLog(visitCounterLog);
	}

	/**
	* Creates a new visit counter log with the primary key. Does not add the visit counter log to the database.
	*
	* @param visitorIp the primary key for the new visit counter log
	* @return the new visit counter log
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog createVisitCounterLog(
		java.lang.String visitorIp) {
		return getService().createVisitCounterLog(visitorIp);
	}

	/**
	* Deletes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log that was removed
	* @throws PortalException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog deleteVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVisitCounterLog(visitorIp);
	}

	/**
	* Deletes the visit counter log from the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog deleteVisitCounterLog(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVisitCounterLog(visitCounterLog);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog fetchVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVisitCounterLog(visitorIp);
	}

	/**
	* Returns the visit counter log with the primary key.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log
	* @throws PortalException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog getVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVisitCounterLog(visitorIp);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> getVisitCounterLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVisitCounterLogs(start, end);
	}

	/**
	* Returns the number of visit counter logs.
	*
	* @return the number of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static int getVisitCounterLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVisitCounterLogsCount();
	}

	/**
	* Updates the visit counter log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog updateVisitCounterLog(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVisitCounterLog(visitCounterLog);
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

	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog getCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCounterLog(visitorIp);
	}

	public static com.liferay.viettel.portal.visitcounter.model.VisitCounterLog addCounterLog(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String visitorIp, long lastAccessPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCounterLog(companyId, groupId, userId, userName,
			visitorIp, lastAccessPageId);
	}

	public static void updateCounterLog(long companyId, long groupId,
		long userId, java.lang.String userName, java.lang.String visitorIp,
		int hitCounter, long lastAccessPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateCounterLog(companyId, groupId, userId, userName, visitorIp,
			hitCounter, lastAccessPageId);
	}

	public static void incrementCounter(java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().incrementCounter(visitorIp);
	}

	public static void clearService() {
		_service = null;
	}

	public static VisitCounterLogLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VisitCounterLogLocalService.class.getName());

			if (invokableLocalService instanceof VisitCounterLogLocalService) {
				_service = (VisitCounterLogLocalService)invokableLocalService;
			}
			else {
				_service = new VisitCounterLogLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VisitCounterLogLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VisitCounterLogLocalService service) {
	}

	private static VisitCounterLogLocalService _service;
}