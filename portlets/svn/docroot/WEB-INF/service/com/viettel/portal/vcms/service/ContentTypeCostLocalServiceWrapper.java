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
 * Provides a wrapper for {@link ContentTypeCostLocalService}.
 *
 * @author chuchv
 * @see ContentTypeCostLocalService
 * @generated
 */
public class ContentTypeCostLocalServiceWrapper
	implements ContentTypeCostLocalService,
		ServiceWrapper<ContentTypeCostLocalService> {
	public ContentTypeCostLocalServiceWrapper(
		ContentTypeCostLocalService contentTypeCostLocalService) {
		_contentTypeCostLocalService = contentTypeCostLocalService;
	}

	/**
	* Adds the content type cost to the database. Also notifies the appropriate model listeners.
	*
	* @param contentTypeCost the content type cost
	* @return the content type cost that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentTypeCost addContentTypeCost(
		com.viettel.portal.vcms.model.ContentTypeCost contentTypeCost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.addContentTypeCost(contentTypeCost);
	}

	/**
	* Creates a new content type cost with the primary key. Does not add the content type cost to the database.
	*
	* @param costId the primary key for the new content type cost
	* @return the new content type cost
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentTypeCost createContentTypeCost(
		long costId) {
		return _contentTypeCostLocalService.createContentTypeCost(costId);
	}

	/**
	* Deletes the content type cost with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param costId the primary key of the content type cost
	* @return the content type cost that was removed
	* @throws PortalException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentTypeCost deleteContentTypeCost(
		long costId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.deleteContentTypeCost(costId);
	}

	/**
	* Deletes the content type cost from the database. Also notifies the appropriate model listeners.
	*
	* @param contentTypeCost the content type cost
	* @return the content type cost that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentTypeCost deleteContentTypeCost(
		com.viettel.portal.vcms.model.ContentTypeCost contentTypeCost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.deleteContentTypeCost(contentTypeCost);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentTypeCostLocalService.dynamicQuery();
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
		return _contentTypeCostLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentTypeCostLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentTypeCostLocalService.dynamicQuery(dynamicQuery, start,
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
		return _contentTypeCostLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contentTypeCostLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.ContentTypeCost fetchContentTypeCost(
		long costId) throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.fetchContentTypeCost(costId);
	}

	/**
	* Returns the content type cost with the primary key.
	*
	* @param costId the primary key of the content type cost
	* @return the content type cost
	* @throws PortalException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentTypeCost getContentTypeCost(
		long costId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.getContentTypeCost(costId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the content type costs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @return the range of content type costs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> getContentTypeCosts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.getContentTypeCosts(start, end);
	}

	/**
	* Returns the number of content type costs.
	*
	* @return the number of content type costs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContentTypeCostsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.getContentTypeCostsCount();
	}

	/**
	* Updates the content type cost in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contentTypeCost the content type cost
	* @return the content type cost that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentTypeCost updateContentTypeCost(
		com.viettel.portal.vcms.model.ContentTypeCost contentTypeCost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeCostLocalService.updateContentTypeCost(contentTypeCost);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contentTypeCostLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentTypeCostLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentTypeCostLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContentTypeCostLocalService getWrappedContentTypeCostLocalService() {
		return _contentTypeCostLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContentTypeCostLocalService(
		ContentTypeCostLocalService contentTypeCostLocalService) {
		_contentTypeCostLocalService = contentTypeCostLocalService;
	}

	@Override
	public ContentTypeCostLocalService getWrappedService() {
		return _contentTypeCostLocalService;
	}

	@Override
	public void setWrappedService(
		ContentTypeCostLocalService contentTypeCostLocalService) {
		_contentTypeCostLocalService = contentTypeCostLocalService;
	}

	private ContentTypeCostLocalService _contentTypeCostLocalService;
}