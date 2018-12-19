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
 * Provides a wrapper for {@link ContentProfitLocalService}.
 *
 * @author chuchv
 * @see ContentProfitLocalService
 * @generated
 */
public class ContentProfitLocalServiceWrapper
	implements ContentProfitLocalService,
		ServiceWrapper<ContentProfitLocalService> {
	public ContentProfitLocalServiceWrapper(
		ContentProfitLocalService contentProfitLocalService) {
		_contentProfitLocalService = contentProfitLocalService;
	}

	/**
	* Adds the content profit to the database. Also notifies the appropriate model listeners.
	*
	* @param contentProfit the content profit
	* @return the content profit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentProfit addContentProfit(
		com.viettel.portal.vcms.model.ContentProfit contentProfit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.addContentProfit(contentProfit);
	}

	/**
	* Creates a new content profit with the primary key. Does not add the content profit to the database.
	*
	* @param contentId the primary key for the new content profit
	* @return the new content profit
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentProfit createContentProfit(
		long contentId) {
		return _contentProfitLocalService.createContentProfit(contentId);
	}

	/**
	* Deletes the content profit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the content profit
	* @return the content profit that was removed
	* @throws PortalException if a content profit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentProfit deleteContentProfit(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.deleteContentProfit(contentId);
	}

	/**
	* Deletes the content profit from the database. Also notifies the appropriate model listeners.
	*
	* @param contentProfit the content profit
	* @return the content profit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentProfit deleteContentProfit(
		com.viettel.portal.vcms.model.ContentProfit contentProfit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.deleteContentProfit(contentProfit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentProfitLocalService.dynamicQuery();
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
		return _contentProfitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentProfitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentProfitLocalService.dynamicQuery(dynamicQuery, start,
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
		return _contentProfitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contentProfitLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.ContentProfit fetchContentProfit(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.fetchContentProfit(contentId);
	}

	/**
	* Returns the content profit with the primary key.
	*
	* @param contentId the primary key of the content profit
	* @return the content profit
	* @throws PortalException if a content profit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentProfit getContentProfit(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.getContentProfit(contentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the content profits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content profits
	* @param end the upper bound of the range of content profits (not inclusive)
	* @return the range of content profits
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.ContentProfit> getContentProfits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.getContentProfits(start, end);
	}

	/**
	* Returns the number of content profits.
	*
	* @return the number of content profits
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContentProfitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.getContentProfitsCount();
	}

	/**
	* Updates the content profit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contentProfit the content profit
	* @return the content profit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentProfit updateContentProfit(
		com.viettel.portal.vcms.model.ContentProfit contentProfit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentProfitLocalService.updateContentProfit(contentProfit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contentProfitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentProfitLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentProfitLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addContentCost(long groupId, long companyId, long userId,
		java.lang.String userName, long contentId,
		java.util.Date distributionDate, long contentTypeId,
		java.lang.String headLine,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contentProfitLocalService.addContentCost(groupId, companyId, userId,
			userName, contentId, distributionDate, contentTypeId, headLine,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContentProfitLocalService getWrappedContentProfitLocalService() {
		return _contentProfitLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContentProfitLocalService(
		ContentProfitLocalService contentProfitLocalService) {
		_contentProfitLocalService = contentProfitLocalService;
	}

	@Override
	public ContentProfitLocalService getWrappedService() {
		return _contentProfitLocalService;
	}

	@Override
	public void setWrappedService(
		ContentProfitLocalService contentProfitLocalService) {
		_contentProfitLocalService = contentProfitLocalService;
	}

	private ContentProfitLocalService _contentProfitLocalService;
}