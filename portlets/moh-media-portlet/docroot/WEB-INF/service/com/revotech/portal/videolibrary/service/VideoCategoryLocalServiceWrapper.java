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

package com.revotech.portal.videolibrary.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VideoCategoryLocalService}.
 *
 * @author ChucHV
 * @see VideoCategoryLocalService
 * @generated
 */
public class VideoCategoryLocalServiceWrapper
	implements VideoCategoryLocalService,
		ServiceWrapper<VideoCategoryLocalService> {
	public VideoCategoryLocalServiceWrapper(
		VideoCategoryLocalService videoCategoryLocalService) {
		_videoCategoryLocalService = videoCategoryLocalService;
	}

	/**
	* Adds the video category to the database. Also notifies the appropriate model listeners.
	*
	* @param videoCategory the video category
	* @return the video category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory addVideoCategory(
		com.revotech.portal.videolibrary.model.VideoCategory videoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.addVideoCategory(videoCategory);
	}

	/**
	* Creates a new video category with the primary key. Does not add the video category to the database.
	*
	* @param ID the primary key for the new video category
	* @return the new video category
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory createVideoCategory(
		int ID) {
		return _videoCategoryLocalService.createVideoCategory(ID);
	}

	/**
	* Deletes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the video category
	* @return the video category that was removed
	* @throws PortalException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory deleteVideoCategory(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.deleteVideoCategory(ID);
	}

	/**
	* Deletes the video category from the database. Also notifies the appropriate model listeners.
	*
	* @param videoCategory the video category
	* @return the video category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory deleteVideoCategory(
		com.revotech.portal.videolibrary.model.VideoCategory videoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.deleteVideoCategory(videoCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videoCategoryLocalService.dynamicQuery();
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
		return _videoCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoCategoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _videoCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _videoCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory fetchVideoCategory(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.fetchVideoCategory(ID);
	}

	/**
	* Returns the video category with the primary key.
	*
	* @param ID the primary key of the video category
	* @return the video category
	* @throws PortalException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory getVideoCategory(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.getVideoCategory(ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @return the range of video categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.revotech.portal.videolibrary.model.VideoCategory> getVideoCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.getVideoCategories(start, end);
	}

	/**
	* Returns the number of video categories.
	*
	* @return the number of video categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVideoCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.getVideoCategoriesCount();
	}

	/**
	* Updates the video category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoCategory the video category
	* @return the video category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory updateVideoCategory(
		com.revotech.portal.videolibrary.model.VideoCategory videoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.updateVideoCategory(videoCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _videoCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_videoCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _videoCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.revotech.portal.videolibrary.model.VideoCategory> findAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.findAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VideoCategoryLocalService getWrappedVideoCategoryLocalService() {
		return _videoCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVideoCategoryLocalService(
		VideoCategoryLocalService videoCategoryLocalService) {
		_videoCategoryLocalService = videoCategoryLocalService;
	}

	@Override
	public VideoCategoryLocalService getWrappedService() {
		return _videoCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		VideoCategoryLocalService videoCategoryLocalService) {
		_videoCategoryLocalService = videoCategoryLocalService;
	}

	private VideoCategoryLocalService _videoCategoryLocalService;
}