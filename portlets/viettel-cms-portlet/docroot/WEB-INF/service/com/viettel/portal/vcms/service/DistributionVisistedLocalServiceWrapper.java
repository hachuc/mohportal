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
 * Provides a wrapper for {@link DistributionVisistedLocalService}.
 *
 * @author chuchv
 * @see DistributionVisistedLocalService
 * @generated
 */
public class DistributionVisistedLocalServiceWrapper
	implements DistributionVisistedLocalService,
		ServiceWrapper<DistributionVisistedLocalService> {
	public DistributionVisistedLocalServiceWrapper(
		DistributionVisistedLocalService distributionVisistedLocalService) {
		_distributionVisistedLocalService = distributionVisistedLocalService;
	}

	/**
	* Adds the distribution visisted to the database. Also notifies the appropriate model listeners.
	*
	* @param distributionVisisted the distribution visisted
	* @return the distribution visisted that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted addDistributionVisisted(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.addDistributionVisisted(distributionVisisted);
	}

	/**
	* Creates a new distribution visisted with the primary key. Does not add the distribution visisted to the database.
	*
	* @param visistedId the primary key for the new distribution visisted
	* @return the new distribution visisted
	*/
	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted createDistributionVisisted(
		long visistedId) {
		return _distributionVisistedLocalService.createDistributionVisisted(visistedId);
	}

	/**
	* Deletes the distribution visisted with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visistedId the primary key of the distribution visisted
	* @return the distribution visisted that was removed
	* @throws PortalException if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted deleteDistributionVisisted(
		long visistedId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.deleteDistributionVisisted(visistedId);
	}

	/**
	* Deletes the distribution visisted from the database. Also notifies the appropriate model listeners.
	*
	* @param distributionVisisted the distribution visisted
	* @return the distribution visisted that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted deleteDistributionVisisted(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.deleteDistributionVisisted(distributionVisisted);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _distributionVisistedLocalService.dynamicQuery();
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
		return _distributionVisistedLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _distributionVisistedLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _distributionVisistedLocalService.dynamicQuery(dynamicQuery,
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
		return _distributionVisistedLocalService.dynamicQueryCount(dynamicQuery);
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
		return _distributionVisistedLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted fetchDistributionVisisted(
		long visistedId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.fetchDistributionVisisted(visistedId);
	}

	/**
	* Returns the distribution visisted with the primary key.
	*
	* @param visistedId the primary key of the distribution visisted
	* @return the distribution visisted
	* @throws PortalException if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted getDistributionVisisted(
		long visistedId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.getDistributionVisisted(visistedId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the distribution visisteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distribution visisteds
	* @param end the upper bound of the range of distribution visisteds (not inclusive)
	* @return the range of distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> getDistributionVisisteds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.getDistributionVisisteds(start,
			end);
	}

	/**
	* Returns the number of distribution visisteds.
	*
	* @return the number of distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDistributionVisistedsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.getDistributionVisistedsCount();
	}

	/**
	* Updates the distribution visisted in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param distributionVisisted the distribution visisted
	* @return the distribution visisted that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted updateDistributionVisisted(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionVisistedLocalService.updateDistributionVisisted(distributionVisisted);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _distributionVisistedLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_distributionVisistedLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _distributionVisistedLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void addVisited(long groupId, long distributionId,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_distributionVisistedLocalService.addVisited(groupId, distributionId,
			createDate);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DistributionVisistedLocalService getWrappedDistributionVisistedLocalService() {
		return _distributionVisistedLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDistributionVisistedLocalService(
		DistributionVisistedLocalService distributionVisistedLocalService) {
		_distributionVisistedLocalService = distributionVisistedLocalService;
	}

	@Override
	public DistributionVisistedLocalService getWrappedService() {
		return _distributionVisistedLocalService;
	}

	@Override
	public void setWrappedService(
		DistributionVisistedLocalService distributionVisistedLocalService) {
		_distributionVisistedLocalService = distributionVisistedLocalService;
	}

	private DistributionVisistedLocalService _distributionVisistedLocalService;
}