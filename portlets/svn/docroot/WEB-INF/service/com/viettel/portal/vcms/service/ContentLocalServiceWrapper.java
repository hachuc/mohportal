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
 * Provides a wrapper for {@link ContentLocalService}.
 *
 * @author chuchv
 * @see ContentLocalService
 * @generated
 */
public class ContentLocalServiceWrapper implements ContentLocalService,
	ServiceWrapper<ContentLocalService> {
	public ContentLocalServiceWrapper(ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	/**
	* Adds the content to the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Content addContent(
		com.viettel.portal.vcms.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.addContent(content);
	}

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param autoId the primary key for the new content
	* @return the new content
	*/
	@Override
	public com.viettel.portal.vcms.model.Content createContent(long autoId) {
		return _contentLocalService.createContent(autoId);
	}

	/**
	* Deletes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autoId the primary key of the content
	* @return the content that was removed
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Content deleteContent(long autoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.deleteContent(autoId);
	}

	/**
	* Deletes the content from the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Content deleteContent(
		com.viettel.portal.vcms.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.deleteContent(content);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentLocalService.dynamicQuery();
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
		return _contentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contentLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _contentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.viettel.portal.vcms.model.Content fetchContent(long autoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.fetchContent(autoId);
	}

	/**
	* Returns the content with the primary key.
	*
	* @param autoId the primary key of the content
	* @return the content
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Content getContent(long autoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContent(autoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> getContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContents(start, end);
	}

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContentsCount();
	}

	/**
	* Updates the content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Content updateContent(
		com.viettel.portal.vcms.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.updateContent(content);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> findByStatusVersion(
		java.lang.String keyword, long groupId, long categoryId, long authorId,
		int[] status, int[] version, int searchOption,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.findByStatusVersion(keyword, groupId,
			categoryId, authorId, status, version, searchOption, obc, start, end);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> getContentsByStatusVersion(
		long groupId, int version, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContentsByStatusVersion(groupId,
			version, status, start, end);
	}

	@Override
	public int countContentsByStatusVersion(long groupId, int version,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.countContentsByStatusVersion(groupId,
			version, status);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> getContentsByASV(
		long groupId, long authorId, int version, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContentsByASV(groupId, authorId,
			version, status, start, end);
	}

	@Override
	public int countContentsByASV(long groupId, long authorId, int version,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.countContentsByASV(groupId, authorId,
			version, status);
	}

	@Override
	public com.viettel.portal.vcms.model.Content fecthLastestContent(
		long groupId, long contentId, int version, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.fecthLastestContent(groupId, contentId,
			version, status);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> findByContentAndVersion(
		long groupId, long contentId, int version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.findByContentAndVersion(groupId, contentId,
			version);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> findByGroupContent(
		long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.findByGroupContent(groupId, contentId);
	}

	@Override
	public int countByStatusVersion(java.lang.String keyword, long groupId,
		long categoryId, long authorId, int[] status, int[] version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.countByStatusVersion(keyword, groupId,
			categoryId, authorId, status, version);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> find(
		java.lang.String keyword, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.find(keyword, groupId, categoryId, obc,
			start, end);
	}

	@Override
	public int count(java.lang.String keyword, long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.count(keyword, groupId, categoryId);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> findByCategory(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.findByCategory(groupId, categoryId, obc,
			start, end);
	}

	@Override
	public int countByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.countByCategory(groupId, categoryId);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_V_S(
		long groupId, long contentId, int version, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.findByG_C_V_S(groupId, contentId, version,
			status);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Content> findByG_CA_V_S(
		long groupId, long categoryId, int version, int status, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.findByG_CA_V_S(groupId, categoryId,
			version, status, start, end);
	}

	@Override
	public int countByG_CA_V_S(long groupId, long categoryId, int version,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.countByG_CA_V_S(groupId, categoryId,
			version, status);
	}

	@Override
	public com.viettel.portal.vcms.model.Content getContent(long groupId,
		long contentId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContent(groupId, contentId, version,
			status);
	}

	@Override
	public void deleteByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentLocalService.deleteByCategory(groupId, categoryId);
	}

	@Override
	public com.viettel.portal.vcms.model.Content fetchByAutoId(long autoId,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.fetchByAutoId(autoId, groupId);
	}

	@Override
	public com.viettel.portal.vcms.model.Content findByContentId(
		long contentId, long groupId, int version, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.findByContentId(contentId, groupId,
			version, status);
	}

	@Override
	public com.viettel.portal.vcms.model.Content addContent(long groupid,
		long companyId, long userId, java.lang.String userName, long autoId,
		long contentId, int preVersion, int version, java.lang.String subTitle,
		java.lang.String title, java.lang.String summary,
		java.lang.String subContent, java.lang.String sContent,
		long smallImageId, java.lang.String smallImageUrl, long categoryId,
		java.lang.String copyRight, int status, long createByUserId,
		java.lang.String createByUserName, java.lang.String author,
		java.lang.String jobTitle, int newsType,
		com.liferay.portal.service.ServiceContext serviceContext,
		com.liferay.portal.service.ServiceContext detailContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.addContent(groupid, companyId, userId,
			userName, autoId, contentId, preVersion, version, subTitle, title,
			summary, subContent, sContent, smallImageId, smallImageUrl,
			categoryId, copyRight, status, createByUserId, createByUserName,
			author, jobTitle, newsType, serviceContext, detailContext);
	}

	@Override
	public com.viettel.portal.vcms.model.Content addLegalContent(long groupid,
		long companyId, long userId, java.lang.String userName, long autoId,
		long contentId, int version, java.lang.String subTitle,
		java.lang.String title, java.lang.String summary,
		java.lang.String subContent, java.lang.String sContent,
		long smallImageId, java.lang.String smallImageUrl, long categoryId,
		java.lang.String copyRight, int status, long createByUserId,
		java.lang.String createByUserName, long editedByUserId,
		java.lang.String editedByUserName, long reviewedByUserId,
		java.lang.String reviewedByUserName, long approvedByUserId,
		java.lang.String approvedByUserName, java.lang.String author,
		java.lang.String jobTitle, int newsType, java.lang.String imageUrl,
		boolean isLegalContent, java.lang.String imageCaption,
		int imagePosition, java.util.Date creationDate,
		java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.addLegalContent(groupid, companyId, userId,
			userName, autoId, contentId, version, subTitle, title, summary,
			subContent, sContent, smallImageId, smallImageUrl, categoryId,
			copyRight, status, createByUserId, createByUserName,
			editedByUserId, editedByUserName, reviewedByUserId,
			reviewedByUserName, approvedByUserId, approvedByUserName, author,
			jobTitle, newsType, imageUrl, isLegalContent, imageCaption,
			imagePosition, creationDate, modifiedDate, serviceContext);
	}

	@Override
	public com.viettel.portal.vcms.model.Content addContentVersion(
		long groupid, long companyId, long userId, java.lang.String userName,
		long contentId, int version, java.lang.String subTitle,
		java.lang.String title, java.lang.String urlTitle,
		java.lang.String summary, java.lang.String subContent,
		java.lang.String sContent, long smallImageId,
		java.lang.String smallImageUrl, long categoryId,
		java.lang.String copyRight, int status, long createByUserId,
		long editByUserId, long reviewByUserId, long publishByUserId,
		java.lang.String createByUserName, java.lang.String editByUserName,
		java.lang.String reviewByUserName, java.lang.String publishByUSerName,
		java.lang.String author, java.lang.String jobTitle, int newsType,
		com.liferay.portal.service.ServiceContext serviceContext,
		com.liferay.portal.service.ServiceContext serviceDetailContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.addContentVersion(groupid, companyId,
			userId, userName, contentId, version, subTitle, title, urlTitle,
			summary, subContent, sContent, smallImageId, smallImageUrl,
			categoryId, copyRight, status, createByUserId, editByUserId,
			reviewByUserId, publishByUserId, createByUserName, editByUserName,
			reviewByUserName, publishByUSerName, author, jobTitle, newsType,
			serviceContext, serviceDetailContext);
	}

	@Override
	public void removeContent(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contentLocalService.removeContent(groupId, contentId);
	}

	@Override
	public void removeAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contentLocalService.removeAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContentLocalService getWrappedContentLocalService() {
		return _contentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContentLocalService(
		ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	@Override
	public ContentLocalService getWrappedService() {
		return _contentLocalService;
	}

	@Override
	public void setWrappedService(ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	private ContentLocalService _contentLocalService;
}