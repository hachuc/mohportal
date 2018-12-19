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
 * Provides a wrapper for {@link ContentTypeLocalService}.
 *
 * @author chuchv
 * @see ContentTypeLocalService
 * @generated
 */
public class ContentTypeLocalServiceWrapper implements ContentTypeLocalService,
	ServiceWrapper<ContentTypeLocalService> {
	public ContentTypeLocalServiceWrapper(
		ContentTypeLocalService contentTypeLocalService) {
		_contentTypeLocalService = contentTypeLocalService;
	}

	/**
	* Adds the content type to the database. Also notifies the appropriate model listeners.
	*
	* @param contentType the content type
	* @return the content type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentType addContentType(
		com.viettel.portal.vcms.model.ContentType contentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.addContentType(contentType);
	}

	/**
	* Creates a new content type with the primary key. Does not add the content type to the database.
	*
	* @param contenTypeId the primary key for the new content type
	* @return the new content type
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentType createContentType(
		long contenTypeId) {
		return _contentTypeLocalService.createContentType(contenTypeId);
	}

	/**
	* Deletes the content type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contenTypeId the primary key of the content type
	* @return the content type that was removed
	* @throws PortalException if a content type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentType deleteContentType(
		long contenTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.deleteContentType(contenTypeId);
	}

	/**
	* Deletes the content type from the database. Also notifies the appropriate model listeners.
	*
	* @param contentType the content type
	* @return the content type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentType deleteContentType(
		com.viettel.portal.vcms.model.ContentType contentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.deleteContentType(contentType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentTypeLocalService.dynamicQuery();
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
		return _contentTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _contentTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contentTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.ContentType fetchContentType(
		long contenTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.fetchContentType(contenTypeId);
	}

	/**
	* Returns the content type with the primary key.
	*
	* @param contenTypeId the primary key of the content type
	* @return the content type
	* @throws PortalException if a content type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentType getContentType(
		long contenTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.getContentType(contenTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the content types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content types
	* @param end the upper bound of the range of content types (not inclusive)
	* @return the range of content types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.ContentType> getContentTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.getContentTypes(start, end);
	}

	/**
	* Returns the number of content types.
	*
	* @return the number of content types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContentTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.getContentTypesCount();
	}

	/**
	* Updates the content type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contentType the content type
	* @return the content type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.ContentType updateContentType(
		com.viettel.portal.vcms.model.ContentType contentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.updateContentType(contentType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contentTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.ContentType> getContentTypes(
		long groupId, java.lang.String keyword, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.getContentTypes(groupId, keyword,
			start, end);
	}

	@Override
	public int countContentTypes(long groupId, java.lang.String keyword)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentTypeLocalService.countContentTypes(groupId, keyword);
	}

	@Override
	public void updateContentType(long groupId, long companyId, long userId,
		long contentTypeId, java.lang.String name, java.lang.String desc,
		int sortOrder, com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contentTypeLocalService.updateContentType(groupId, companyId, userId,
			contentTypeId, name, desc, sortOrder, context);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContentTypeLocalService getWrappedContentTypeLocalService() {
		return _contentTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContentTypeLocalService(
		ContentTypeLocalService contentTypeLocalService) {
		_contentTypeLocalService = contentTypeLocalService;
	}

	@Override
	public ContentTypeLocalService getWrappedService() {
		return _contentTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ContentTypeLocalService contentTypeLocalService) {
		_contentTypeLocalService = contentTypeLocalService;
	}

	private ContentTypeLocalService _contentTypeLocalService;
}