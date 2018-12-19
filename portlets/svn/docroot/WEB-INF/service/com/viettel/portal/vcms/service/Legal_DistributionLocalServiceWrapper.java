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
 * Provides a wrapper for {@link Legal_DistributionLocalService}.
 *
 * @author chuchv
 * @see Legal_DistributionLocalService
 * @generated
 */
public class Legal_DistributionLocalServiceWrapper
	implements Legal_DistributionLocalService,
		ServiceWrapper<Legal_DistributionLocalService> {
	public Legal_DistributionLocalServiceWrapper(
		Legal_DistributionLocalService legal_DistributionLocalService) {
		_legal_DistributionLocalService = legal_DistributionLocalService;
	}

	/**
	* Adds the legal_ distribution to the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Distribution the legal_ distribution
	* @return the legal_ distribution that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution addLegal_Distribution(
		com.viettel.portal.vcms.model.Legal_Distribution legal_Distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.addLegal_Distribution(legal_Distribution);
	}

	/**
	* Creates a new legal_ distribution with the primary key. Does not add the legal_ distribution to the database.
	*
	* @param ID the primary key for the new legal_ distribution
	* @return the new legal_ distribution
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution createLegal_Distribution(
		int ID) {
		return _legal_DistributionLocalService.createLegal_Distribution(ID);
	}

	/**
	* Deletes the legal_ distribution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ distribution
	* @return the legal_ distribution that was removed
	* @throws PortalException if a legal_ distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution deleteLegal_Distribution(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.deleteLegal_Distribution(ID);
	}

	/**
	* Deletes the legal_ distribution from the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Distribution the legal_ distribution
	* @return the legal_ distribution that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution deleteLegal_Distribution(
		com.viettel.portal.vcms.model.Legal_Distribution legal_Distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.deleteLegal_Distribution(legal_Distribution);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legal_DistributionLocalService.dynamicQuery();
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
		return _legal_DistributionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legal_DistributionLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legal_DistributionLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _legal_DistributionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legal_DistributionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution fetchLegal_Distribution(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.fetchLegal_Distribution(ID);
	}

	/**
	* Returns the legal_ distribution with the primary key.
	*
	* @param ID the primary key of the legal_ distribution
	* @return the legal_ distribution
	* @throws PortalException if a legal_ distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution getLegal_Distribution(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.getLegal_Distribution(ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legal_ distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ distributions
	* @param end the upper bound of the range of legal_ distributions (not inclusive)
	* @return the range of legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> getLegal_Distributions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.getLegal_Distributions(start, end);
	}

	/**
	* Returns the number of legal_ distributions.
	*
	* @return the number of legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegal_DistributionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.getLegal_DistributionsCount();
	}

	/**
	* Updates the legal_ distribution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legal_Distribution the legal_ distribution
	* @return the legal_ distribution that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution updateLegal_Distribution(
		com.viettel.portal.vcms.model.Legal_Distribution legal_Distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.updateLegal_Distribution(legal_Distribution);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legal_DistributionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legal_DistributionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legal_DistributionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> getByZone(
		int zoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_DistributionLocalService.getByZone(zoneId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Legal_DistributionLocalService getWrappedLegal_DistributionLocalService() {
		return _legal_DistributionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegal_DistributionLocalService(
		Legal_DistributionLocalService legal_DistributionLocalService) {
		_legal_DistributionLocalService = legal_DistributionLocalService;
	}

	@Override
	public Legal_DistributionLocalService getWrappedService() {
		return _legal_DistributionLocalService;
	}

	@Override
	public void setWrappedService(
		Legal_DistributionLocalService legal_DistributionLocalService) {
		_legal_DistributionLocalService = legal_DistributionLocalService;
	}

	private Legal_DistributionLocalService _legal_DistributionLocalService;
}