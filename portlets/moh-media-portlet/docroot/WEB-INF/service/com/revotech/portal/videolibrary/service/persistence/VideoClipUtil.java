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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.revotech.portal.videolibrary.model.VideoClip;

import java.util.List;

/**
 * The persistence utility for the video clip service. This utility wraps {@link VideoClipPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VideoClipPersistence
 * @see VideoClipPersistenceImpl
 * @generated
 */
public class VideoClipUtil {
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
	public static void clearCache(VideoClip videoClip) {
		getPersistence().clearCache(videoClip);
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
	public static List<VideoClip> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoClip> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoClip> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VideoClip update(VideoClip videoClip)
		throws SystemException {
		return getPersistence().update(videoClip);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VideoClip update(VideoClip videoClip,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoClip, serviceContext);
	}

	/**
	* Returns all the video clips where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @return the matching video clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VideoClip> findByCategoryID(
		int CategoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryID(CategoryID);
	}

	/**
	* Returns a range of all the video clips where CategoryID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CategoryID the category i d
	* @param start the lower bound of the range of video clips
	* @param end the upper bound of the range of video clips (not inclusive)
	* @return the range of matching video clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VideoClip> findByCategoryID(
		int CategoryID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryID(CategoryID, start, end);
	}

	/**
	* Returns an ordered range of all the video clips where CategoryID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CategoryID the category i d
	* @param start the lower bound of the range of video clips
	* @param end the upper bound of the range of video clips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VideoClip> findByCategoryID(
		int CategoryID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryID(CategoryID, start, end, orderByComparator);
	}

	/**
	* Returns the first video clip in the ordered set where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video clip
	* @throws com.revotech.portal.videolibrary.NoSuchVideoClipException if a matching video clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip findByCategoryID_First(
		int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVideoClipException {
		return getPersistence()
				   .findByCategoryID_First(CategoryID, orderByComparator);
	}

	/**
	* Returns the first video clip in the ordered set where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video clip, or <code>null</code> if a matching video clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip fetchByCategoryID_First(
		int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryID_First(CategoryID, orderByComparator);
	}

	/**
	* Returns the last video clip in the ordered set where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video clip
	* @throws com.revotech.portal.videolibrary.NoSuchVideoClipException if a matching video clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip findByCategoryID_Last(
		int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVideoClipException {
		return getPersistence()
				   .findByCategoryID_Last(CategoryID, orderByComparator);
	}

	/**
	* Returns the last video clip in the ordered set where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video clip, or <code>null</code> if a matching video clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip fetchByCategoryID_Last(
		int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryID_Last(CategoryID, orderByComparator);
	}

	/**
	* Returns the video clips before and after the current video clip in the ordered set where CategoryID = &#63;.
	*
	* @param ID the primary key of the current video clip
	* @param CategoryID the category i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video clip
	* @throws com.revotech.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip[] findByCategoryID_PrevAndNext(
		int ID, int CategoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVideoClipException {
		return getPersistence()
				   .findByCategoryID_PrevAndNext(ID, CategoryID,
			orderByComparator);
	}

	/**
	* Removes all the video clips where CategoryID = &#63; from the database.
	*
	* @param CategoryID the category i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryID(int CategoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryID(CategoryID);
	}

	/**
	* Returns the number of video clips where CategoryID = &#63;.
	*
	* @param CategoryID the category i d
	* @return the number of matching video clips
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryID(int CategoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryID(CategoryID);
	}

	/**
	* Caches the video clip in the entity cache if it is enabled.
	*
	* @param videoClip the video clip
	*/
	public static void cacheResult(
		com.revotech.portal.videolibrary.model.VideoClip videoClip) {
		getPersistence().cacheResult(videoClip);
	}

	/**
	* Caches the video clips in the entity cache if it is enabled.
	*
	* @param videoClips the video clips
	*/
	public static void cacheResult(
		java.util.List<com.revotech.portal.videolibrary.model.VideoClip> videoClips) {
		getPersistence().cacheResult(videoClips);
	}

	/**
	* Creates a new video clip with the primary key. Does not add the video clip to the database.
	*
	* @param ID the primary key for the new video clip
	* @return the new video clip
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip create(
		int ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the video clip with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the video clip
	* @return the video clip that was removed
	* @throws com.revotech.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip remove(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVideoClipException {
		return getPersistence().remove(ID);
	}

	public static com.revotech.portal.videolibrary.model.VideoClip updateImpl(
		com.revotech.portal.videolibrary.model.VideoClip videoClip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoClip);
	}

	/**
	* Returns the video clip with the primary key or throws a {@link com.revotech.portal.videolibrary.NoSuchVideoClipException} if it could not be found.
	*
	* @param ID the primary key of the video clip
	* @return the video clip
	* @throws com.revotech.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVideoClipException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the video clip with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the video clip
	* @return the video clip, or <code>null</code> if a video clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VideoClip fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the video clips.
	*
	* @return the video clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VideoClip> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video clips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video clips
	* @param end the upper bound of the range of video clips (not inclusive)
	* @return the range of video clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VideoClip> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video clips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video clips
	* @param end the upper bound of the range of video clips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VideoClip> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video clips from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video clips.
	*
	* @return the number of video clips
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoClipPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoClipPersistence)PortletBeanLocatorUtil.locate(com.revotech.portal.videolibrary.service.ClpSerializer.getServletContextName(),
					VideoClipPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoClipUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VideoClipPersistence persistence) {
	}

	private static VideoClipPersistence _persistence;
}