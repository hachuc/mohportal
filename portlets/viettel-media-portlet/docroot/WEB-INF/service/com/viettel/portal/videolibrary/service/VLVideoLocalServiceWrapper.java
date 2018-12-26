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

package com.viettel.portal.videolibrary.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VLVideoLocalService}.
 *
 * @author ChucHV
 * @see VLVideoLocalService
 * @generated
 */
public class VLVideoLocalServiceWrapper implements VLVideoLocalService,
	ServiceWrapper<VLVideoLocalService> {
	public VLVideoLocalServiceWrapper(VLVideoLocalService vlVideoLocalService) {
		_vlVideoLocalService = vlVideoLocalService;
	}

	/**
	* Adds the v l video to the database. Also notifies the appropriate model listeners.
	*
	* @param vlVideo the v l video
	* @return the v l video that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLVideo addVLVideo(
		com.viettel.portal.videolibrary.model.VLVideo vlVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.addVLVideo(vlVideo);
	}

	/**
	* Creates a new v l video with the primary key. Does not add the v l video to the database.
	*
	* @param videoId the primary key for the new v l video
	* @return the new v l video
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLVideo createVLVideo(
		long videoId) {
		return _vlVideoLocalService.createVLVideo(videoId);
	}

	/**
	* Deletes the v l video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the v l video
	* @return the v l video that was removed
	* @throws PortalException if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLVideo deleteVLVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.deleteVLVideo(videoId);
	}

	/**
	* Deletes the v l video from the database. Also notifies the appropriate model listeners.
	*
	* @param vlVideo the v l video
	* @return the v l video that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLVideo deleteVLVideo(
		com.viettel.portal.videolibrary.model.VLVideo vlVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.deleteVLVideo(vlVideo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vlVideoLocalService.dynamicQuery();
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
		return _vlVideoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vlVideoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vlVideoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vlVideoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vlVideoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideo fetchVLVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.fetchVLVideo(videoId);
	}

	/**
	* Returns the v l video with the primary key.
	*
	* @param videoId the primary key of the v l video
	* @return the v l video
	* @throws PortalException if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLVideo getVLVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.getVLVideo(videoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v l videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @return the range of v l videos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> getVLVideos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.getVLVideos(start, end);
	}

	/**
	* Returns the number of v l videos.
	*
	* @return the number of v l videos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVLVideosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.getVLVideosCount();
	}

	/**
	* Updates the v l video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vlVideo the v l video
	* @return the v l video that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLVideo updateVLVideo(
		com.viettel.portal.videolibrary.model.VLVideo vlVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.updateVLVideo(vlVideo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vlVideoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vlVideoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vlVideoLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void removeAll(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vlVideoLocalService.removeAll(groupId);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideo addVideo(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String name,
		java.lang.String description, java.lang.String videoType,
		java.lang.String videoUrl, long videoFileId, boolean thumbnailImage,
		long thumbnailImageId,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String smallImageUrl)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.addVideo(categoryId, companyId, groupId,
			userId, userName, name, description, videoType, videoUrl,
			videoFileId, thumbnailImage, thumbnailImageId, serviceContext,
			smallImageUrl);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideo addLegalVideo(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String name,
		java.lang.String description, java.lang.String videoType,
		java.lang.String videoUrl, long videoFileId, boolean thumbnailImage,
		long thumbnailImageId, java.lang.String smallImageUrl,
		java.util.Date createDate, java.util.Date modifyDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.addLegalVideo(categoryId, companyId,
			groupId, userId, userName, name, description, videoType, videoUrl,
			videoFileId, thumbnailImage, thumbnailImageId, smallImageUrl,
			createDate, modifyDate, serviceContext);
	}

	@Override
	public int countAllByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.countAllByGroup(groupId);
	}

	@Override
	public long countByByKeyword(long groupId, long categoryId,
		java.lang.String keyword) {
		return _vlVideoLocalService.countByByKeyword(groupId, categoryId,
			keyword);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.findByGroup(groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.findByGroup(groupId, start, end);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByCategoryId(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.findByCategoryId(categoryId, groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByCategoryId(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.findByCategoryId(categoryId, groupId,
			start, end);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _vlVideoLocalService.findByKeyword(groupId, categoryId, keyword,
			start, end, obc);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByKeywordFrontend(
		long groupId, java.lang.String rank, java.lang.String docCode,
		long vlCategoryId, java.lang.String companyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _vlVideoLocalService.findByKeywordFrontend(groupId, rank,
			docCode, vlCategoryId, companyName, start, end, obc);
	}

	@Override
	public long countByKeywordFrontend(long groupId, java.lang.String rank,
		java.lang.String docCode, long vlCategoryId,
		java.lang.String companyName) {
		return _vlVideoLocalService.countByKeywordFrontend(groupId, rank,
			docCode, vlCategoryId, companyName);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideo updateVideo(
		long entryId, long categoryId, long companyId, long groupId,
		long userId, java.lang.String userName, java.lang.String name,
		java.lang.String description, java.lang.String videoType,
		java.lang.String videoUrl, long videoFileId, boolean thumbnailImage,
		long thumbnailImageId,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String smallImageUrl)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoLocalService.updateVideo(entryId, categoryId, companyId,
			groupId, userId, userName, name, description, videoType, videoUrl,
			videoFileId, thumbnailImage, thumbnailImageId, serviceContext,
			smallImageUrl);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VLVideoLocalService getWrappedVLVideoLocalService() {
		return _vlVideoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVLVideoLocalService(
		VLVideoLocalService vlVideoLocalService) {
		_vlVideoLocalService = vlVideoLocalService;
	}

	@Override
	public VLVideoLocalService getWrappedService() {
		return _vlVideoLocalService;
	}

	@Override
	public void setWrappedService(VLVideoLocalService vlVideoLocalService) {
		_vlVideoLocalService = vlVideoLocalService;
	}

	private VLVideoLocalService _vlVideoLocalService;
}