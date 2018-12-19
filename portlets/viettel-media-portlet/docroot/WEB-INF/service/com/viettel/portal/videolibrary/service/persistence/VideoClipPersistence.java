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

import com.viettel.portal.videolibrary.model.VideoClip;

/**
 * The persistence interface for the video clip service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VideoClipPersistenceImpl
 * @see VideoClipUtil
 * @generated
 */
public interface VideoClipPersistence extends BasePersistence<VideoClip> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoClipUtil} to access the video clip persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the video clips where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @return the matching video clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VideoClip> findByCategoryID(
		int CategoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video clips where CategoryID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CategoryID the category i d
	* @param start the lower bound of the range of video clips
	* @param end the upper bound of the range of video clips (not inclusive)
	* @return the range of matching video clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VideoClip> findByCategoryID(
		int CategoryID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video clips where CategoryID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CategoryID the category i d
	* @param start the lower bound of the range of video clips
	* @param end the upper bound of the range of video clips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VideoClip> findByCategoryID(
		int CategoryID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video clip in the ordered set where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video clip
	* @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a matching video clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoClip findByCategoryID_First(
		int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVideoClipException;

	/**
	* Returns the first video clip in the ordered set where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video clip, or <code>null</code> if a matching video clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoClip fetchByCategoryID_First(
		int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video clip in the ordered set where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video clip
	* @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a matching video clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoClip findByCategoryID_Last(
		int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVideoClipException;

	/**
	* Returns the last video clip in the ordered set where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video clip, or <code>null</code> if a matching video clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoClip fetchByCategoryID_Last(
		int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video clips before and after the current video clip in the ordered set where CategoryID = &#63;.
	*
	* @param ID the primary key of the current video clip
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video clip
	* @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoClip[] findByCategoryID_PrevAndNext(
		int ID, int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVideoClipException;

	/**
	* Removes all the video clips where CategoryID = &#63; from the database.
	*
	* @param CategoryID the category i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryID(int CategoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video clips where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @return the number of matching video clips
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryID(int CategoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the video clip in the entity cache if it is enabled.
	*
	* @param videoClip the video clip
	*/
	public void cacheResult(
		com.viettel.portal.videolibrary.model.VideoClip videoClip);

	/**
	* Caches the video clips in the entity cache if it is enabled.
	*
	* @param videoClips the video clips
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.videolibrary.model.VideoClip> videoClips);

	/**
	* Creates a new video clip with the primary key. Does not add the video clip to the database.
	*
	* @param ID the primary key for the new video clip
	* @return the new video clip
	*/
	public com.viettel.portal.videolibrary.model.VideoClip create(int ID);

	/**
	* Removes the video clip with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the video clip
	* @return the video clip that was removed
	* @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoClip remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVideoClipException;

	public com.viettel.portal.videolibrary.model.VideoClip updateImpl(
		com.viettel.portal.videolibrary.model.VideoClip videoClip)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video clip with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVideoClipException} if it could not be found.
	*
	* @param ID the primary key of the video clip
	* @return the video clip
	* @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoClip findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVideoClipException;

	/**
	* Returns the video clip with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the video clip
	* @return the video clip, or <code>null</code> if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoClip fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video clips.
	*
	* @return the video clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VideoClip> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.videolibrary.model.VideoClip> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video clips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video clips
	* @param end the upper bound of the range of video clips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VideoClip> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video clips from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video clips.
	*
	* @return the number of video clips
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}