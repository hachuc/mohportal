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

package com.viettel.portal.videolibrary.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.videolibrary.model.VLVideo;

/**
 * The persistence interface for the v l video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLVideoPersistenceImpl
 * @see VLVideoUtil
 * @generated
 */
public interface VLVideoPersistence extends BasePersistence<VLVideo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VLVideoUtil} to access the v l video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the v l videos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v l videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l videos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @return the range of matching v l videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l videos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v l video in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a matching v l video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Returns the first v l video in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video, or <code>null</code> if a matching v l video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v l video in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a matching v l video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Returns the last v l video in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video, or <code>null</code> if a matching v l video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l videos before and after the current v l video in the ordered set where groupId = &#63;.
	*
	* @param videoId the primary key of the current v l video
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo[] findByGroup_PrevAndNext(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Returns all the v l videos that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v l videos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l videos that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @return the range of matching v l videos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l videos that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l videos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l videos before and after the current v l video in the ordered set of v l videos that the user has permission to view where groupId = &#63;.
	*
	* @param videoId the primary key of the current v l video
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo[] filterFindByGroup_PrevAndNext(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Removes all the v l videos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l videos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v l videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l videos that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v l videos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v l videos where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v l videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByCategoryId(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l videos where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @return the range of matching v l videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByCategoryId(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l videos where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findByCategoryId(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a matching v l video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo findByCategoryId_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Returns the first v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video, or <code>null</code> if a matching v l video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo fetchByCategoryId_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a matching v l video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo findByCategoryId_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Returns the last v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video, or <code>null</code> if a matching v l video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo fetchByCategoryId_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l videos before and after the current v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param videoId the primary key of the current v l video
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo[] findByCategoryId_PrevAndNext(
		long videoId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Returns all the v l videos that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v l videos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> filterFindByCategoryId(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l videos that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @return the range of matching v l videos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> filterFindByCategoryId(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l videos that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l videos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> filterFindByCategoryId(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l videos before and after the current v l video in the ordered set of v l videos that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param videoId the primary key of the current v l video
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo[] filterFindByCategoryId_PrevAndNext(
		long videoId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Removes all the v l videos where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryId(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l videos where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v l videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryId(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l videos that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v l videos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryId(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the v l video in the entity cache if it is enabled.
	*
	* @param vlVideo the v l video
	*/
	public void cacheResult(
		com.viettel.portal.videolibrary.model.VLVideo vlVideo);

	/**
	* Caches the v l videos in the entity cache if it is enabled.
	*
	* @param vlVideos the v l videos
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.videolibrary.model.VLVideo> vlVideos);

	/**
	* Creates a new v l video with the primary key. Does not add the v l video to the database.
	*
	* @param videoId the primary key for the new v l video
	* @return the new v l video
	*/
	public com.viettel.portal.videolibrary.model.VLVideo create(long videoId);

	/**
	* Removes the v l video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the v l video
	* @return the v l video that was removed
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo remove(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	public com.viettel.portal.videolibrary.model.VLVideo updateImpl(
		com.viettel.portal.videolibrary.model.VLVideo vlVideo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l video with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVLVideoException} if it could not be found.
	*
	* @param videoId the primary key of the v l video
	* @return the v l video
	* @throws com.viettel.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo findByPrimaryKey(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLVideoException;

	/**
	* Returns the v l video with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the v l video
	* @return the v l video, or <code>null</code> if a v l video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLVideo fetchByPrimaryKey(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v l videos.
	*
	* @return the v l videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l videos
	* @param end the upper bound of the range of v l videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v l videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLVideo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v l videos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l videos.
	*
	* @return the number of v l videos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}