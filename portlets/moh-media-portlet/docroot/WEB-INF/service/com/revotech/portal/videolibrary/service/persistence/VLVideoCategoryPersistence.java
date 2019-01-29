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

package com.revotech.portal.videolibrary.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.revotech.portal.videolibrary.model.VLVideoCategory;

/**
 * The persistence interface for the v l video category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLVideoCategoryPersistenceImpl
 * @see VLVideoCategoryUtil
 * @generated
 */
public interface VLVideoCategoryPersistence extends BasePersistence<VLVideoCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VLVideoCategoryUtil} to access the v l video category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the v l video categories where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l video categories where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l video categories
	* @param end the upper bound of the range of v l video categories (not inclusive)
	* @return the range of matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l video categories where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l video categories
	* @param end the upper bound of the range of v l video categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video category
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory findByCategory_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;

	/**
	* Returns the first v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video category, or <code>null</code> if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory fetchByCategory_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video category
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory findByCategory_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;

	/**
	* Returns the last v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video category, or <code>null</code> if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory fetchByCategory_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l video categories before and after the current v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current v l video category
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l video category
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory[] findByCategory_PrevAndNext(
		long id, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;

	/**
	* Removes all the v l video categories where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l video categories where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v l video categories where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @return the matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l video categories where videoId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l video categories
	* @param end the upper bound of the range of v l video categories (not inclusive)
	* @return the range of matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l video categories where videoId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l video categories
	* @param end the upper bound of the range of v l video categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video category
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory findByVideo_First(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;

	/**
	* Returns the first v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video category, or <code>null</code> if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory fetchByVideo_First(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video category
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory findByVideo_Last(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;

	/**
	* Returns the last v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video category, or <code>null</code> if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory fetchByVideo_Last(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l video categories before and after the current v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current v l video category
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l video category
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory[] findByVideo_PrevAndNext(
		long id, long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;

	/**
	* Removes all the v l video categories where videoId = &#63; and groupId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideo(long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l video categories where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @return the number of matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideo(long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the v l video category in the entity cache if it is enabled.
	*
	* @param vlVideoCategory the v l video category
	*/
	public void cacheResult(
		com.revotech.portal.videolibrary.model.VLVideoCategory vlVideoCategory);

	/**
	* Caches the v l video categories in the entity cache if it is enabled.
	*
	* @param vlVideoCategories the v l video categories
	*/
	public void cacheResult(
		java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> vlVideoCategories);

	/**
	* Creates a new v l video category with the primary key. Does not add the v l video category to the database.
	*
	* @param id the primary key for the new v l video category
	* @return the new v l video category
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory create(
		long id);

	/**
	* Removes the v l video category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the v l video category
	* @return the v l video category that was removed
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;

	public com.revotech.portal.videolibrary.model.VLVideoCategory updateImpl(
		com.revotech.portal.videolibrary.model.VLVideoCategory vlVideoCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l video category with the primary key or throws a {@link com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException} if it could not be found.
	*
	* @param id the primary key of the v l video category
	* @return the v l video category
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;

	/**
	* Returns the v l video category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the v l video category
	* @return the v l video category, or <code>null</code> if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.videolibrary.model.VLVideoCategory fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v l video categories.
	*
	* @return the v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l video categories
	* @param end the upper bound of the range of v l video categories (not inclusive)
	* @return the range of v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l video categories
	* @param end the upper bound of the range of v l video categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v l video categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l video categories.
	*
	* @return the number of v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}