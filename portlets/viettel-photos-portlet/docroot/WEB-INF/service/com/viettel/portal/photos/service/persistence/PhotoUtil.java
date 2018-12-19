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

package com.viettel.portal.photos.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.photos.model.Photo;

import java.util.List;

/**
 * The persistence utility for the photo service. This utility wraps {@link PhotoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see PhotoPersistence
 * @see PhotoPersistenceImpl
 * @generated
 */
public class PhotoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Photo photo) {
		getPersistence().clearCache(photo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Photo> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Photo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Photo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Photo update(Photo photo) throws SystemException {
		return getPersistence().update(photo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Photo update(Photo photo, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(photo, serviceContext);
	}

	/**
	* Returns all the photos where status = &#63;.
	*
	* @param status the status
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the photos where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @return the range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByStatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the photos where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the photos before and after the current photo in the ordered set where status = &#63;.
	*
	* @param photoId the primary key of the current photo
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo[] findByStatus_PrevAndNext(
		long photoId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByStatus_PrevAndNext(photoId, status, orderByComparator);
	}

	/**
	* Removes all the photos where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of photos where status = &#63;.
	*
	* @param status the status
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the photos where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByCategory(
		long categoryId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, status);
	}

	/**
	* Returns a range of all the photos where categoryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param status the status
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @return the range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByCategory(
		long categoryId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, status, start, end);
	}

	/**
	* Returns an ordered range of all the photos where categoryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param status the status
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByCategory(
		long categoryId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(categoryId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByCategory_First(
		long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByCategory_First(categoryId, status, orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByCategory_First(
		long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(categoryId, status, orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByCategory_Last(
		long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByCategory_Last(categoryId, status, orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByCategory_Last(
		long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, status, orderByComparator);
	}

	/**
	* Returns the photos before and after the current photo in the ordered set where categoryId = &#63; and status = &#63;.
	*
	* @param photoId the primary key of the current photo
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo[] findByCategory_PrevAndNext(
		long photoId, long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByCategory_PrevAndNext(photoId, categoryId, status,
			orderByComparator);
	}

	/**
	* Removes all the photos where categoryId = &#63; and status = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long categoryId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(categoryId, status);
	}

	/**
	* Returns the number of photos where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long categoryId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(categoryId, status);
	}

	/**
	* Returns all the photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByCategoryAndGroup(
		long categoryId, long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, status);
	}

	/**
	* Returns a range of all the photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @return the range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByCategoryAndGroup(
		long categoryId, long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, status, start,
			end);
	}

	/**
	* Returns an ordered range of all the photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByCategoryAndGroup(
		long categoryId, long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByCategoryAndGroup_First(
		long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByCategoryAndGroup_First(categoryId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByCategoryAndGroup_First(
		long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_First(categoryId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByCategoryAndGroup_Last(
		long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByCategoryAndGroup_Last(categoryId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByCategoryAndGroup_Last(
		long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_Last(categoryId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the photos before and after the current photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param photoId the primary key of the current photo
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo[] findByCategoryAndGroup_PrevAndNext(
		long photoId, long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByCategoryAndGroup_PrevAndNext(photoId, categoryId,
			groupId, status, orderByComparator);
	}

	/**
	* Removes all the photos where categoryId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndGroup(long categoryId, long groupId,
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryAndGroup(categoryId, groupId, status);
	}

	/**
	* Returns the number of photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndGroup(long categoryId, long groupId,
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCategoryAndGroup(categoryId, groupId, status);
	}

	/**
	* Returns all the photos where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByGroup(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, status);
	}

	/**
	* Returns a range of all the photos where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @return the range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByGroup(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the photos where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findByGroup(
		long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByGroup_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByGroup_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first photo in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByGroup_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroup_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByGroup_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByGroup_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last photo in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByGroup_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroup_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the photos before and after the current photo in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param photoId the primary key of the current photo
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo[] findByGroup_PrevAndNext(
		long photoId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence()
				   .findByGroup_PrevAndNext(photoId, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the photos where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId, status);
	}

	/**
	* Returns the number of photos where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId, status);
	}

	/**
	* Caches the photo in the entity cache if it is enabled.
	*
	* @param photo the photo
	*/
	public static void cacheResult(com.viettel.portal.photos.model.Photo photo) {
		getPersistence().cacheResult(photo);
	}

	/**
	* Caches the photos in the entity cache if it is enabled.
	*
	* @param photos the photos
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.photos.model.Photo> photos) {
		getPersistence().cacheResult(photos);
	}

	/**
	* Creates a new photo with the primary key. Does not add the photo to the database.
	*
	* @param photoId the primary key for the new photo
	* @return the new photo
	*/
	public static com.viettel.portal.photos.model.Photo create(long photoId) {
		return getPersistence().create(photoId);
	}

	/**
	* Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param photoId the primary key of the photo
	* @return the photo that was removed
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo remove(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence().remove(photoId);
	}

	public static com.viettel.portal.photos.model.Photo updateImpl(
		com.viettel.portal.photos.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(photo);
	}

	/**
	* Returns the photo with the primary key or throws a {@link com.viettel.portal.photos.NoSuchPhotoException} if it could not be found.
	*
	* @param photoId the primary key of the photo
	* @return the photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo findByPrimaryKey(
		long photoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException {
		return getPersistence().findByPrimaryKey(photoId);
	}

	/**
	* Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param photoId the primary key of the photo
	* @return the photo, or <code>null</code> if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.Photo fetchByPrimaryKey(
		long photoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(photoId);
	}

	/**
	* Returns all the photos.
	*
	* @return the photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.viettel.portal.photos.model.Photo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the photos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of photos
	* @param end the upper bound of the range of photos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of photos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.Photo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the photos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of photos.
	*
	* @return the number of photos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PhotoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PhotoPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.photos.service.ClpSerializer.getServletContextName(),
					PhotoPersistence.class.getName());

			ReferenceRegistry.registerReference(PhotoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PhotoPersistence persistence) {
	}

	private static PhotoPersistence _persistence;
}