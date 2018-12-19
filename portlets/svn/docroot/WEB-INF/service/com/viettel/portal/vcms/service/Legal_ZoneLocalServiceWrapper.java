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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Legal_ZoneLocalService}.
 *
 * @author chuchv
 * @see Legal_ZoneLocalService
 * @generated
 */
public class Legal_ZoneLocalServiceWrapper implements Legal_ZoneLocalService,
	ServiceWrapper<Legal_ZoneLocalService> {
	public Legal_ZoneLocalServiceWrapper(
		Legal_ZoneLocalService legal_ZoneLocalService) {
		_legal_ZoneLocalService = legal_ZoneLocalService;
	}

	/**
	* Adds the legal_ zone to the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Zone the legal_ zone
	* @return the legal_ zone that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Zone addLegal_Zone(
		com.viettel.portal.vcms.model.Legal_Zone legal_Zone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.addLegal_Zone(legal_Zone);
	}

	/**
	* Creates a new legal_ zone with the primary key. Does not add the legal_ zone to the database.
	*
	* @param ID the primary key for the new legal_ zone
	* @return the new legal_ zone
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Zone createLegal_Zone(int ID) {
		return _legal_ZoneLocalService.createLegal_Zone(ID);
	}

	/**
	* Deletes the legal_ zone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ zone
	* @return the legal_ zone that was removed
	* @throws PortalException if a legal_ zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Zone deleteLegal_Zone(int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.deleteLegal_Zone(ID);
	}

	/**
	* Deletes the legal_ zone from the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Zone the legal_ zone
	* @return the legal_ zone that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Zone deleteLegal_Zone(
		com.viettel.portal.vcms.model.Legal_Zone legal_Zone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.deleteLegal_Zone(legal_Zone);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legal_ZoneLocalService.dynamicQuery();
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
		return _legal_ZoneLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _legal_ZoneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legal_ZoneLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Zone fetchLegal_Zone(int ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.fetchLegal_Zone(ID);
	}

	/**
	* Returns the legal_ zone with the primary key.
	*
	* @param ID the primary key of the legal_ zone
	* @return the legal_ zone
	* @throws PortalException if a legal_ zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Zone getLegal_Zone(int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.getLegal_Zone(ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.viettel.portal.vcms.model.Legal_Zone> getLegal_Zones(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.getLegal_Zones(start, end);
	}

	/**
	* Returns the number of legal_ zones.
	*
	* @return the number of legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegal_ZonesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.getLegal_ZonesCount();
	}

	/**
	* Updates the legal_ zone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legal_Zone the legal_ zone
	* @return the legal_ zone that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Zone updateLegal_Zone(
		com.viettel.portal.vcms.model.Legal_Zone legal_Zone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.updateLegal_Zone(legal_Zone);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legal_ZoneLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legal_ZoneLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legal_ZoneLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Legal_Zone> getZoneByStatus(
		boolean isVisible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ZoneLocalService.getZoneByStatus(isVisible);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Legal_ZoneLocalService getWrappedLegal_ZoneLocalService() {
		return _legal_ZoneLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegal_ZoneLocalService(
		Legal_ZoneLocalService legal_ZoneLocalService) {
		_legal_ZoneLocalService = legal_ZoneLocalService;
	}

	@Override
	public Legal_ZoneLocalService getWrappedService() {
		return _legal_ZoneLocalService;
	}

	@Override
	public void setWrappedService(Legal_ZoneLocalService legal_ZoneLocalService) {
		_legal_ZoneLocalService = legal_ZoneLocalService;
	}

	private Legal_ZoneLocalService _legal_ZoneLocalService;
}