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
 * Provides a wrapper for {@link ContentDetailLocalService}.
 *
 * @author chuchv
 * @see ContentDetailLocalService
 * @generated
 */
public class ContentDetailLocalServiceWrapper
	implements ContentDetailLocalService,
		ServiceWrapper<ContentDetailLocalService> {
	public ContentDetailLocalServiceWrapper(
		ContentDetailLocalService contentDetailLocalService) {
		_contentDetailLocalService = contentDetailLocalService;
	}

	/**
	* Adds the content detail to the database. Also notifies the appropriate model listeners.
	*
	* @param contentDetail the content detail
	* @return the content detail that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentDetail addContentDetail(
		com.viettel.portal.vcms.model.ContentDetail contentDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.addContentDetail(contentDetail);
	}

	/**
	* Creates a new content detail with the primary key. Does not add the content detail to the database.
	*
	* @param autoId the primary key for the new content detail
	* @return the new content detail
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentDetail createContentDetail(
		long autoId) {
		return _contentDetailLocalService.createContentDetail(autoId);
	}

	/**
	* Deletes the content detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autoId the primary key of the content detail
	* @return the content detail that was removed
	* @throws PortalException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentDetail deleteContentDetail(
		long autoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.deleteContentDetail(autoId);
	}

	/**
	* Deletes the content detail from the database. Also notifies the appropriate model listeners.
	*
	* @param contentDetail the content detail
	* @return the content detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentDetail deleteContentDetail(
		com.viettel.portal.vcms.model.ContentDetail contentDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.deleteContentDetail(contentDetail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentDetailLocalService.dynamicQuery();
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
		return _contentDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentDetailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentDetailLocalService.dynamicQuery(dynamicQuery, start,
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
		return _contentDetailLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contentDetailLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.ContentDetail fetchContentDetail(
		long autoId) throws com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.fetchContentDetail(autoId);
	}

	/**
	* Returns the content detail with the primary key.
	*
	* @param autoId the primary key of the content detail
	* @return the content detail
	* @throws PortalException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentDetail getContentDetail(
		long autoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.getContentDetail(autoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the content details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @return the range of content details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> getContentDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.getContentDetails(start, end);
	}

	/**
	* Returns the number of content details.
	*
	* @return the number of content details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContentDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.getContentDetailsCount();
	}

	/**
	* Updates the content detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contentDetail the content detail
	* @return the content detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentDetail updateContentDetail(
		com.viettel.portal.vcms.model.ContentDetail contentDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.updateContentDetail(contentDetail);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contentDetailLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentDetailLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentDetailLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void removeAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contentDetailLocalService.removeAll();
	}

	@Override
	public com.viettel.portal.vcms.model.ContentDetail addContentDetail(
		long groupid, long companyId, long userId, java.lang.String userName,
		long autoId, long contentId, int version, java.lang.String subTitle,
		java.lang.String title, java.lang.String summary,
		java.lang.String subContent, java.lang.String sContent,
		long smallImageId, java.lang.String smallImageUrl, long categoryId,
		java.lang.String copyRight, int status, long createByUserId,
		java.lang.String createByUserName, java.lang.String author,
		java.lang.String jobTitle, int newsType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.addContentDetail(groupid, companyId,
			userId, userName, autoId, contentId, version, subTitle, title,
			summary, subContent, sContent, smallImageId, smallImageUrl,
			categoryId, copyRight, status, createByUserId, createByUserName,
			author, jobTitle, newsType, serviceContext);
	}

	@Override
	public com.viettel.portal.vcms.model.ContentDetail addLegalContent(
		long groupid, long companyId, long userId, java.lang.String userName,
		long autoId, long contentId, int version, java.lang.String subTitle,
		java.lang.String title, java.lang.String summary,
		java.lang.String subContent, java.lang.String sContent,
		long smallImageId, java.lang.String smallImageUrl, long categoryId,
		int status, int newsType, java.lang.String imageUrl,
		boolean isLegalContent, java.lang.String imageCaption,
		int imagePosition, java.util.Date creationDate,
		java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentDetailLocalService.addLegalContent(groupid, companyId,
			userId, userName, autoId, contentId, version, subTitle, title,
			summary, subContent, sContent, smallImageId, smallImageUrl,
			categoryId, status, newsType, imageUrl, isLegalContent,
			imageCaption, imagePosition, creationDate, modifiedDate,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContentDetailLocalService getWrappedContentDetailLocalService() {
		return _contentDetailLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContentDetailLocalService(
		ContentDetailLocalService contentDetailLocalService) {
		_contentDetailLocalService = contentDetailLocalService;
	}

	@Override
	public ContentDetailLocalService getWrappedService() {
		return _contentDetailLocalService;
	}

	@Override
	public void setWrappedService(
		ContentDetailLocalService contentDetailLocalService) {
		_contentDetailLocalService = contentDetailLocalService;
	}

	private ContentDetailLocalService _contentDetailLocalService;
}