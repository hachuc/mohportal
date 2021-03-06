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

package com.viettel.portal.photos.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Photo. This utility wraps
 * {@link com.viettel.portal.photos.service.impl.PhotoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ChucHV
 * @see PhotoLocalService
 * @see com.viettel.portal.photos.service.base.PhotoLocalServiceBaseImpl
 * @see com.viettel.portal.photos.service.impl.PhotoLocalServiceImpl
 * @generated
 */
public class PhotoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.photos.service.impl.PhotoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the photo to the database. Also notifies the appropriate model listeners.
	*
	* @param photo the photo
	* @return the photo that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo addPhoto(
		com.viettel.portal.photos.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPhoto(photo);
	}

	/**
	* Creates a new photo with the primary key. Does not add the photo to the database.
	*
	* @param photoId the primary key for the new photo
	* @return the new photo
	*/
	public static com.viettel.portal.photos.model.Photo createPhoto(
		long photoId) {
		return getService().createPhoto(photoId);
	}

	/**
	* Deletes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param photoId the primary key of the photo
	* @return the photo that was removed
	* @throws PortalException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo deletePhoto(
		long photoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePhoto(photoId);
	}

	/**
	* Deletes the photo from the database. Also notifies the appropriate model listeners.
	*
	* @param photo the photo
	* @return the photo that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo deletePhoto(
		com.viettel.portal.photos.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePhoto(photo);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.viettel.portal.photos.model.Photo fetchPhoto(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPhoto(photoId);
	}

	/**
	* Returns the photo with the primary key.
	*
	* @param photoId the primary key of the photo
	* @return the photo
	* @throws PortalException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo getPhoto(long photoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhoto(photoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the photos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @return the range of photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> getPhotos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhotos(start, end);
	}

	/**
	* Returns the number of photos.
	*
	* @return the number of photos
	* @throws SystemException if a system exception occurred
	*/
	public static int getPhotosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhotosCount();
	}

	/**
	* Updates the photo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param photo the photo
	* @return the photo that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo updatePhoto(
		com.viettel.portal.photos.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePhoto(photo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.viettel.portal.photos.model.Photo> findByAlbumIds(
		java.lang.Long groupId, java.util.List<java.lang.Long> categoryIds) {
		return getService().findByAlbumIds(groupId, categoryIds);
	}

	public static java.util.List<com.viettel.portal.photos.model.Photo> findByGroup(
		java.lang.Long groupId, boolean status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, status, begin, end);
	}

	public static java.util.List<com.viettel.portal.photos.model.Photo> findByCategoryAndGroup(
		long categoryId, long groupId, boolean status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndGroup(categoryId, groupId, status, begin,
			end);
	}

	public static java.util.List<com.viettel.portal.photos.model.Photo> findPhotos(
		java.lang.Long groupId, java.lang.String keyword, long categoryId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findPhotos(groupId, keyword, categoryId, begin, end);
	}

	public static int countPhotos(java.lang.Long groupId,
		java.lang.String keyword, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countPhotos(groupId, keyword, categoryId);
	}

	public static com.viettel.portal.photos.model.Photo updatePhoto(
		long photoId, long categoryId, long companyId, long groupId,
		long userId, java.lang.String userName, java.lang.String caption,
		int order_, boolean status, long fileId, java.lang.String fileName,
		java.lang.String fileLink, long fileSize,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePhoto(photoId, categoryId, companyId, groupId,
			userId, userName, caption, order_, status, fileId, fileName,
			fileLink, fileSize, serviceContext);
	}

	public static com.viettel.portal.photos.model.Photo addPhoto(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String caption, int order_,
		boolean status, long fileId, java.lang.String fileName,
		java.lang.String fileLink, long fileSize,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPhoto(categoryId, companyId, groupId, userId, userName,
			caption, order_, status, fileId, fileName, fileLink, fileSize,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static PhotoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PhotoLocalService.class.getName());

			if (invokableLocalService instanceof PhotoLocalService) {
				_service = (PhotoLocalService)invokableLocalService;
			}
			else {
				_service = new PhotoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PhotoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PhotoLocalService service) {
	}

	private static PhotoLocalService _service;
}