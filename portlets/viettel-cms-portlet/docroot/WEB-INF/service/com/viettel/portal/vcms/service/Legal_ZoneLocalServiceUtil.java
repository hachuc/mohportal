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

package com.viettel.portal.vcms.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Legal_Zone. This utility wraps
 * {@link com.viettel.portal.vcms.service.impl.Legal_ZoneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author chuchv
 * @see Legal_ZoneLocalService
 * @see com.viettel.portal.vcms.service.base.Legal_ZoneLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.impl.Legal_ZoneLocalServiceImpl
 * @generated
 */
public class Legal_ZoneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.vcms.service.impl.Legal_ZoneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the legal_ zone to the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Zone the legal_ zone
	* @return the legal_ zone that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Zone addLegal_Zone(
		com.viettel.portal.vcms.model.Legal_Zone legal_Zone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLegal_Zone(legal_Zone);
	}

	/**
	* Creates a new legal_ zone with the primary key. Does not add the legal_ zone to the database.
	*
	* @param ID the primary key for the new legal_ zone
	* @return the new legal_ zone
	*/
	public static com.viettel.portal.vcms.model.Legal_Zone createLegal_Zone(
		int ID) {
		return getService().createLegal_Zone(ID);
	}

	/**
	* Deletes the legal_ zone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ zone
	* @return the legal_ zone that was removed
	* @throws PortalException if a legal_ zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Zone deleteLegal_Zone(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegal_Zone(ID);
	}

	/**
	* Deletes the legal_ zone from the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Zone the legal_ zone
	* @return the legal_ zone that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Zone deleteLegal_Zone(
		com.viettel.portal.vcms.model.Legal_Zone legal_Zone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegal_Zone(legal_Zone);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.viettel.portal.vcms.model.Legal_Zone fetchLegal_Zone(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLegal_Zone(ID);
	}

	/**
	* Returns the legal_ zone with the primary key.
	*
	* @param ID the primary key of the legal_ zone
	* @return the legal_ zone
	* @throws PortalException if a legal_ zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Zone getLegal_Zone(int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegal_Zone(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legal_ zones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ zones
	* @param end the upper bound of the range of legal_ zones (not inclusive)
	* @return the range of legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Zone> getLegal_Zones(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegal_Zones(start, end);
	}

	/**
	* Returns the number of legal_ zones.
	*
	* @return the number of legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public static int getLegal_ZonesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegal_ZonesCount();
	}

	/**
	* Updates the legal_ zone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legal_Zone the legal_ zone
	* @return the legal_ zone that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Zone updateLegal_Zone(
		com.viettel.portal.vcms.model.Legal_Zone legal_Zone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLegal_Zone(legal_Zone);
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

	public static java.util.List<com.viettel.portal.vcms.model.Legal_Zone> getZoneByStatus(
		boolean isVisible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getZoneByStatus(isVisible);
	}

	public static void clearService() {
		_service = null;
	}

	public static Legal_ZoneLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Legal_ZoneLocalService.class.getName());

			if (invokableLocalService instanceof Legal_ZoneLocalService) {
				_service = (Legal_ZoneLocalService)invokableLocalService;
			}
			else {
				_service = new Legal_ZoneLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(Legal_ZoneLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(Legal_ZoneLocalService service) {
	}

	private static Legal_ZoneLocalService _service;
}