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
 * Provides a wrapper for {@link DistributionLocalService}.
 *
 * @author chuchv
 * @see DistributionLocalService
 * @generated
 */
public class DistributionLocalServiceWrapper implements DistributionLocalService,
	ServiceWrapper<DistributionLocalService> {
	public DistributionLocalServiceWrapper(
		DistributionLocalService distributionLocalService) {
		_distributionLocalService = distributionLocalService;
	}

	/**
	* Adds the distribution to the database. Also notifies the appropriate model listeners.
	*
	* @param distribution the distribution
	* @return the distribution that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Distribution addDistribution(
		com.viettel.portal.vcms.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.addDistribution(distribution);
	}

	/**
	* Creates a new distribution with the primary key. Does not add the distribution to the database.
	*
	* @param distributionId the primary key for the new distribution
	* @return the new distribution
	*/
	@Override
	public com.viettel.portal.vcms.model.Distribution createDistribution(
		long distributionId) {
		return _distributionLocalService.createDistribution(distributionId);
	}

	/**
	* Deletes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution that was removed
	* @throws PortalException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Distribution deleteDistribution(
		long distributionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.deleteDistribution(distributionId);
	}

	/**
	* Deletes the distribution from the database. Also notifies the appropriate model listeners.
	*
	* @param distribution the distribution
	* @return the distribution that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Distribution deleteDistribution(
		com.viettel.portal.vcms.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.deleteDistribution(distribution);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _distributionLocalService.dynamicQuery();
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
		return _distributionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _distributionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _distributionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _distributionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _distributionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.Distribution fetchDistribution(
		long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.fetchDistribution(distributionId);
	}

	/**
	* Returns the distribution with the primary key.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution
	* @throws PortalException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Distribution getDistribution(
		long distributionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.getDistribution(distributionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of distributions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.Distribution> getDistributions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.getDistributions(start, end);
	}

	/**
	* Returns the number of distributions.
	*
	* @return the number of distributions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDistributionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.getDistributionsCount();
	}

	/**
	* Updates the distribution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param distribution the distribution
	* @return the distribution that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Distribution updateDistribution(
		com.viettel.portal.vcms.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.updateDistribution(distribution);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _distributionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_distributionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _distributionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Distribution> findByPubishedDate(
		long groupId, long[] categoryIds, java.lang.String publishedDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.findByPubishedDate(groupId,
			categoryIds, publishedDate, start, end);
	}

	@Override
	public int countByPubishedDate(long groupId, long[] categoryIds,
		java.lang.String publishedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.countByPubishedDate(groupId,
			categoryIds, publishedDate);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Distribution> getByGroupAndCategory(
		long groupId, long[] categoryIds, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.getByGroupAndCategory(groupId,
			categoryIds, start, end);
	}

	@Override
	public int getCountByGroupAndCategory(long groupId, long[] categoryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.getCountByGroupAndCategory(groupId,
			categoryIds);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Distribution> findRelateContents(
		long groupId, long distributionId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _distributionLocalService.findRelateContents(groupId,
			distributionId, start, end);
	}

	@Override
	public void deleteByGroupAndCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_distributionLocalService.deleteByGroupAndCategory(groupId, categoryId);
	}

	@Override
	public void publishContent(long groupId, long companyId, long userId,
		java.lang.String userName, long contentId, int version,
		java.lang.String title, long[] categoryIds, boolean allowDiscussion,
		java.util.Date publishDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_distributionLocalService.publishContent(groupId, companyId, userId,
			userName, contentId, version, title, categoryIds, allowDiscussion,
			publishDate, serviceContext);
	}

	@Override
	public void addLegalDistribution(long groupId, long companyId, long userId,
		java.lang.String userName, int distId, int contentId, int version,
		java.lang.String title, int categoryId, boolean allowDiscustion,
		java.util.Date pubishDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_distributionLocalService.addLegalDistribution(groupId, companyId,
			userId, userName, distId, contentId, version, title, categoryId,
			allowDiscustion, pubishDate, serviceContext);
	}

	@Override
	public void unPublishContent(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_distributionLocalService.unPublishContent(groupId, contentId);
	}

	@Override
	public void deleteAllLocations(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_distributionLocalService.deleteAllLocations(groupId, categoryId);
	}

	@Override
	public void removeAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_distributionLocalService.removeAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DistributionLocalService getWrappedDistributionLocalService() {
		return _distributionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDistributionLocalService(
		DistributionLocalService distributionLocalService) {
		_distributionLocalService = distributionLocalService;
	}

	@Override
	public DistributionLocalService getWrappedService() {
		return _distributionLocalService;
	}

	@Override
	public void setWrappedService(
		DistributionLocalService distributionLocalService) {
		_distributionLocalService = distributionLocalService;
	}

	private DistributionLocalService _distributionLocalService;
}