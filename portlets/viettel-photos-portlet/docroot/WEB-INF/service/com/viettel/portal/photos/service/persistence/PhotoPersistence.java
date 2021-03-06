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

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.photos.model.Photo;

/**
 * The persistence interface for the photo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see PhotoPersistenceImpl
 * @see PhotoUtil
 * @generated
 */
public interface PhotoPersistence extends BasePersistence<Photo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhotoUtil} to access the photo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the photos where status = &#63;.
	*
	* @param status the status
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.Photo> findByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findByStatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first photo in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo findByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Returns the first photo in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo fetchByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last photo in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo findByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Returns the last photo in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo fetchByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo[] findByStatus_PrevAndNext(
		long photoId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Removes all the photos where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of photos where status = &#63;.
	*
	* @param status the status
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the photos where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.Photo> findByCategory(
		long categoryId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findByCategory(
		long categoryId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findByCategory(
		long categoryId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo findByCategory_First(
		long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Returns the first photo in the ordered set where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo fetchByCategory_First(
		long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo findByCategory_Last(
		long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Returns the last photo in the ordered set where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo fetchByCategory_Last(
		long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo[] findByCategory_PrevAndNext(
		long photoId, long categoryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Removes all the photos where categoryId = &#63; and status = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of photos where categoryId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param status the status
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.Photo> findByCategoryAndGroup(
		long categoryId, long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findByCategoryAndGroup(
		long categoryId, long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findByCategoryAndGroup(
		long categoryId, long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo findByCategoryAndGroup_First(
		long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

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
	public com.viettel.portal.photos.model.Photo fetchByCategoryAndGroup_First(
		long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo findByCategoryAndGroup_Last(
		long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

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
	public com.viettel.portal.photos.model.Photo fetchByCategoryAndGroup_Last(
		long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo[] findByCategoryAndGroup_PrevAndNext(
		long photoId, long categoryId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Removes all the photos where categoryId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndGroup(long categoryId, long groupId,
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndGroup(long categoryId, long groupId,
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the photos where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching photos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.Photo> findByGroup(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findByGroup(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findByGroup(
		long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo findByGroup_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Returns the first photo in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo fetchByGroup_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo findByGroup_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Returns the last photo in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo, or <code>null</code> if a matching photo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo fetchByGroup_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.photos.model.Photo[] findByGroup_PrevAndNext(
		long photoId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Removes all the photos where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of photos where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching photos
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the photo in the entity cache if it is enabled.
	*
	* @param photo the photo
	*/
	public void cacheResult(com.viettel.portal.photos.model.Photo photo);

	/**
	* Caches the photos in the entity cache if it is enabled.
	*
	* @param photos the photos
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.photos.model.Photo> photos);

	/**
	* Creates a new photo with the primary key. Does not add the photo to the database.
	*
	* @param photoId the primary key for the new photo
	* @return the new photo
	*/
	public com.viettel.portal.photos.model.Photo create(long photoId);

	/**
	* Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param photoId the primary key of the photo
	* @return the photo that was removed
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo remove(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	public com.viettel.portal.photos.model.Photo updateImpl(
		com.viettel.portal.photos.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the photo with the primary key or throws a {@link com.viettel.portal.photos.NoSuchPhotoException} if it could not be found.
	*
	* @param photoId the primary key of the photo
	* @return the photo
	* @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo findByPrimaryKey(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPhotoException;

	/**
	* Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param photoId the primary key of the photo
	* @return the photo, or <code>null</code> if a photo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.Photo fetchByPrimaryKey(long photoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the photos.
	*
	* @return the photos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.Photo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.photos.model.Photo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the photos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of photos.
	*
	* @return the number of photos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}