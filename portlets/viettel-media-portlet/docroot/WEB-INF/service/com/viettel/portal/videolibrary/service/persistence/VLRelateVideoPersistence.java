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

import com.viettel.portal.videolibrary.model.VLRelateVideo;

/**
 * The persistence interface for the v l relate video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLRelateVideoPersistenceImpl
 * @see VLRelateVideoUtil
 * @generated
 */
public interface VLRelateVideoPersistence extends BasePersistence<VLRelateVideo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VLRelateVideoUtil} to access the v l relate video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the v l relate videos where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @return the matching v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findByRelateVideo(
		long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l relate videos where videoId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l relate videos
	* @param end the upper bound of the range of v l relate videos (not inclusive)
	* @return the range of matching v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findByRelateVideo(
		long videoId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l relate videos where videoId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l relate videos
	* @param end the upper bound of the range of v l relate videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findByRelateVideo(
		long videoId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l relate video
	* @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a matching v l relate video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo findByRelateVideo_First(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;

	/**
	* Returns the first v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l relate video, or <code>null</code> if a matching v l relate video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo fetchByRelateVideo_First(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l relate video
	* @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a matching v l relate video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo findByRelateVideo_Last(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;

	/**
	* Returns the last v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l relate video, or <code>null</code> if a matching v l relate video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo fetchByRelateVideo_Last(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l relate videos before and after the current v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current v l relate video
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l relate video
	* @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo[] findByRelateVideo_PrevAndNext(
		long id, long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;

	/**
	* Removes all the v l relate videos where videoId = &#63; and groupId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRelateVideo(long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l relate videos where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @return the number of matching v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByRelateVideo(long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v l relate videos where relateId = &#63; and groupId = &#63;.
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @return the matching v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findByvideo(
		long relateId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l relate videos where relateId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l relate videos
	* @param end the upper bound of the range of v l relate videos (not inclusive)
	* @return the range of matching v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findByvideo(
		long relateId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l relate videos where relateId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l relate videos
	* @param end the upper bound of the range of v l relate videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findByvideo(
		long relateId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l relate video
	* @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a matching v l relate video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo findByvideo_First(
		long relateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;

	/**
	* Returns the first v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l relate video, or <code>null</code> if a matching v l relate video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo fetchByvideo_First(
		long relateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l relate video
	* @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a matching v l relate video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo findByvideo_Last(
		long relateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;

	/**
	* Returns the last v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l relate video, or <code>null</code> if a matching v l relate video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo fetchByvideo_Last(
		long relateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l relate videos before and after the current v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current v l relate video
	* @param relateId the relate ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l relate video
	* @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo[] findByvideo_PrevAndNext(
		long id, long relateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;

	/**
	* Removes all the v l relate videos where relateId = &#63; and groupId = &#63; from the database.
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByvideo(long relateId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l relate videos where relateId = &#63; and groupId = &#63;.
	*
	* @param relateId the relate ID
	* @param groupId the group ID
	* @return the number of matching v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByvideo(long relateId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the v l relate video in the entity cache if it is enabled.
	*
	* @param vlRelateVideo the v l relate video
	*/
	public void cacheResult(
		com.viettel.portal.videolibrary.model.VLRelateVideo vlRelateVideo);

	/**
	* Caches the v l relate videos in the entity cache if it is enabled.
	*
	* @param vlRelateVideos the v l relate videos
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> vlRelateVideos);

	/**
	* Creates a new v l relate video with the primary key. Does not add the v l relate video to the database.
	*
	* @param id the primary key for the new v l relate video
	* @return the new v l relate video
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo create(long id);

	/**
	* Removes the v l relate video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the v l relate video
	* @return the v l relate video that was removed
	* @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;

	public com.viettel.portal.videolibrary.model.VLRelateVideo updateImpl(
		com.viettel.portal.videolibrary.model.VLRelateVideo vlRelateVideo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v l relate video with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVLRelateVideoException} if it could not be found.
	*
	* @param id the primary key of the v l relate video
	* @return the v l relate video
	* @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;

	/**
	* Returns the v l relate video with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the v l relate video
	* @return the v l relate video, or <code>null</code> if a v l relate video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VLRelateVideo fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v l relate videos.
	*
	* @return the v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v l relate videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l relate videos
	* @param end the upper bound of the range of v l relate videos (not inclusive)
	* @return the range of v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v l relate videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l relate videos
	* @param end the upper bound of the range of v l relate videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VLRelateVideo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v l relate videos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v l relate videos.
	*
	* @return the number of v l relate videos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}