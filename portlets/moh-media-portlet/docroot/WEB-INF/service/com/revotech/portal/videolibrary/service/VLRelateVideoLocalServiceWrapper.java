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
 * Provides a wrapper for {@link VLRelateVideoLocalService}.
 *
 * @author ChucHV
 * @see VLRelateVideoLocalService
 * @generated
 */
public class VLRelateVideoLocalServiceWrapper
	implements VLRelateVideoLocalService,
		ServiceWrapper<VLRelateVideoLocalService> {
	public VLRelateVideoLocalServiceWrapper(
		VLRelateVideoLocalService vlRelateVideoLocalService) {
		_vlRelateVideoLocalService = vlRelateVideoLocalService;
	}

	/**
	* Adds the v l relate video to the database. Also notifies the appropriate model listeners.
	*
	* @param vlRelateVideo the v l relate video
	* @return the v l relate video that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo addVLRelateVideo(
		com.revotech.portal.videolibrary.model.VLRelateVideo vlRelateVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.addVLRelateVideo(vlRelateVideo);
	}

	/**
	* Creates a new v l relate video with the primary key. Does not add the v l relate video to the database.
	*
	* @param id the primary key for the new v l relate video
	* @return the new v l relate video
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo createVLRelateVideo(
		long id) {
		return _vlRelateVideoLocalService.createVLRelateVideo(id);
	}

	/**
	* Deletes the v l relate video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the v l relate video
	* @return the v l relate video that was removed
	* @throws PortalException if a v l relate video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo deleteVLRelateVideo(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.deleteVLRelateVideo(id);
	}

	/**
	* Deletes the v l relate video from the database. Also notifies the appropriate model listeners.
	*
	* @param vlRelateVideo the v l relate video
	* @return the v l relate video that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo deleteVLRelateVideo(
		com.revotech.portal.videolibrary.model.VLRelateVideo vlRelateVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.deleteVLRelateVideo(vlRelateVideo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vlRelateVideoLocalService.dynamicQuery();
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
		return _vlRelateVideoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vlRelateVideoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vlRelateVideoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _vlRelateVideoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vlRelateVideoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo fetchVLRelateVideo(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.fetchVLRelateVideo(id);
	}

	/**
	* Returns the v l relate video with the primary key.
	*
	* @param id the primary key of the v l relate video
	* @return the v l relate video
	* @throws PortalException if a v l relate video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo getVLRelateVideo(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.getVLRelateVideo(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v l relate videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l relate videos
	* @param end the upper bound of the range of v l relate videos (not inclusive)
	* @return the range of v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.revotech.portal.videolibrary.model.VLRelateVideo> getVLRelateVideos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.getVLRelateVideos(start, end);
	}

	/**
	* Returns the number of v l relate videos.
	*
	* @return the number of v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVLRelateVideosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.getVLRelateVideosCount();
	}

	/**
	* Updates the v l relate video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vlRelateVideo the v l relate video
	* @return the v l relate video that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo updateVLRelateVideo(
		com.revotech.portal.videolibrary.model.VLRelateVideo vlRelateVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlRelateVideoLocalService.updateVLRelateVideo(vlRelateVideo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vlRelateVideoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vlRelateVideoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vlRelateVideoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VLRelateVideoLocalService getWrappedVLRelateVideoLocalService() {
		return _vlRelateVideoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVLRelateVideoLocalService(
		VLRelateVideoLocalService vlRelateVideoLocalService) {
		_vlRelateVideoLocalService = vlRelateVideoLocalService;
	}

	@Override
	public VLRelateVideoLocalService getWrappedService() {
		return _vlRelateVideoLocalService;
	}

	@Override
	public void setWrappedService(
		VLRelateVideoLocalService vlRelateVideoLocalService) {
		_vlRelateVideoLocalService = vlRelateVideoLocalService;
	}

	private VLRelateVideoLocalService _vlRelateVideoLocalService;
}