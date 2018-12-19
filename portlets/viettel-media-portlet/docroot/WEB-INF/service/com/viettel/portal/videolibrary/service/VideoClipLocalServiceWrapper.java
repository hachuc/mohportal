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
 * Provides a wrapper for {@link VideoClipLocalService}.
 *
 * @author ChucHV
 * @see VideoClipLocalService
 * @generated
 */
public class VideoClipLocalServiceWrapper implements VideoClipLocalService,
	ServiceWrapper<VideoClipLocalService> {
	public VideoClipLocalServiceWrapper(
		VideoClipLocalService videoClipLocalService) {
		_videoClipLocalService = videoClipLocalService;
	}

	/**
	* Adds the video clip to the database. Also notifies the appropriate model listeners.
	*
	* @param videoClip the video clip
	* @return the video clip that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VideoClip addVideoClip(
		com.viettel.portal.videolibrary.model.VideoClip videoClip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.addVideoClip(videoClip);
	}

	/**
	* Creates a new video clip with the primary key. Does not add the video clip to the database.
	*
	* @param ID the primary key for the new video clip
	* @return the new video clip
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VideoClip createVideoClip(
		int ID) {
		return _videoClipLocalService.createVideoClip(ID);
	}

	/**
	* Deletes the video clip with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the video clip
	* @return the video clip that was removed
	* @throws PortalException if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VideoClip deleteVideoClip(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.deleteVideoClip(ID);
	}

	/**
	* Deletes the video clip from the database. Also notifies the appropriate model listeners.
	*
	* @param videoClip the video clip
	* @return the video clip that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VideoClip deleteVideoClip(
		com.viettel.portal.videolibrary.model.VideoClip videoClip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.deleteVideoClip(videoClip);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videoClipLocalService.dynamicQuery();
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
		return _videoClipLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoClipLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoClipLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _videoClipLocalService.dynamicQueryCount(dynamicQuery);
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
		return _videoClipLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VideoClip fetchVideoClip(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.fetchVideoClip(ID);
	}

	/**
	* Returns the video clip with the primary key.
	*
	* @param ID the primary key of the video clip
	* @return the video clip
	* @throws PortalException if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VideoClip getVideoClip(int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.getVideoClip(ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video clips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video clips
	* @param end the upper bound of the range of video clips (not inclusive)
	* @return the range of video clips
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VideoClip> getVideoClips(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.getVideoClips(start, end);
	}

	/**
	* Returns the number of video clips.
	*
	* @return the number of video clips
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVideoClipsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.getVideoClipsCount();
	}

	/**
	* Updates the video clip in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoClip the video clip
	* @return the video clip that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VideoClip updateVideoClip(
		com.viettel.portal.videolibrary.model.VideoClip videoClip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.updateVideoClip(videoClip);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _videoClipLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_videoClipLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _videoClipLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VideoClip> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoClipLocalService.findAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VideoClipLocalService getWrappedVideoClipLocalService() {
		return _videoClipLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVideoClipLocalService(
		VideoClipLocalService videoClipLocalService) {
		_videoClipLocalService = videoClipLocalService;
	}

	@Override
	public VideoClipLocalService getWrappedService() {
		return _videoClipLocalService;
	}

	@Override
	public void setWrappedService(VideoClipLocalService videoClipLocalService) {
		_videoClipLocalService = videoClipLocalService;
	}

	private VideoClipLocalService _videoClipLocalService;
}