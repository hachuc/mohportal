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

import com.revotech.portal.videolibrary.model.VLVideoCategory;

import java.util.List;

/**
 * The persistence utility for the v l video category service. This utility wraps {@link VLVideoCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLVideoCategoryPersistence
 * @see VLVideoCategoryPersistenceImpl
 * @generated
 */
public class VLVideoCategoryUtil {
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
	public static void clearCache(VLVideoCategory vlVideoCategory) {
		getPersistence().clearCache(vlVideoCategory);
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
	public static List<VLVideoCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VLVideoCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VLVideoCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VLVideoCategory update(VLVideoCategory vlVideoCategory)
		throws SystemException {
		return getPersistence().update(vlVideoCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VLVideoCategory update(VLVideoCategory vlVideoCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vlVideoCategory, serviceContext);
	}

	/**
	* Returns all the v l video categories where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, groupId);
	}

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
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, groupId, start, end);
	}

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
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(categoryId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.revotech.portal.videolibrary.model.VLVideoCategory findByCategory_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException {
		return getPersistence()
				   .findByCategory_First(categoryId, groupId, orderByComparator);
	}

	/**
	* Returns the first v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video category, or <code>null</code> if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory fetchByCategory_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(categoryId, groupId, orderByComparator);
	}

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
	public static com.revotech.portal.videolibrary.model.VLVideoCategory findByCategory_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException {
		return getPersistence()
				   .findByCategory_Last(categoryId, groupId, orderByComparator);
	}

	/**
	* Returns the last v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video category, or <code>null</code> if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory fetchByCategory_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, groupId, orderByComparator);
	}

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
	public static com.revotech.portal.videolibrary.model.VLVideoCategory[] findByCategory_PrevAndNext(
		long id, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException {
		return getPersistence()
				   .findByCategory_PrevAndNext(id, categoryId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the v l video categories where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(categoryId, groupId);
	}

	/**
	* Returns the number of v l video categories where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(categoryId, groupId);
	}

	/**
	* Returns all the v l video categories where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @return the matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId, groupId);
	}

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
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId, groupId, start, end);
	}

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
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideo(videoId, groupId, start, end, orderByComparator);
	}

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
	public static com.revotech.portal.videolibrary.model.VLVideoCategory findByVideo_First(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException {
		return getPersistence()
				   .findByVideo_First(videoId, groupId, orderByComparator);
	}

	/**
	* Returns the first v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l video category, or <code>null</code> if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory fetchByVideo_First(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVideo_First(videoId, groupId, orderByComparator);
	}

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
	public static com.revotech.portal.videolibrary.model.VLVideoCategory findByVideo_Last(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException {
		return getPersistence()
				   .findByVideo_Last(videoId, groupId, orderByComparator);
	}

	/**
	* Returns the last v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l video category, or <code>null</code> if a matching v l video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory fetchByVideo_Last(
		long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVideo_Last(videoId, groupId, orderByComparator);
	}

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
	public static com.revotech.portal.videolibrary.model.VLVideoCategory[] findByVideo_PrevAndNext(
		long id, long videoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException {
		return getPersistence()
				   .findByVideo_PrevAndNext(id, videoId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the v l video categories where videoId = &#63; and groupId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideo(long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideo(videoId, groupId);
	}

	/**
	* Returns the number of v l video categories where videoId = &#63; and groupId = &#63;.
	*
	* @param videoId the video ID
	* @param groupId the group ID
	* @return the number of matching v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideo(long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideo(videoId, groupId);
	}

	/**
	* Caches the v l video category in the entity cache if it is enabled.
	*
	* @param vlVideoCategory the v l video category
	*/
	public static void cacheResult(
		com.revotech.portal.videolibrary.model.VLVideoCategory vlVideoCategory) {
		getPersistence().cacheResult(vlVideoCategory);
	}

	/**
	* Caches the v l video categories in the entity cache if it is enabled.
	*
	* @param vlVideoCategories the v l video categories
	*/
	public static void cacheResult(
		java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> vlVideoCategories) {
		getPersistence().cacheResult(vlVideoCategories);
	}

	/**
	* Creates a new v l video category with the primary key. Does not add the v l video category to the database.
	*
	* @param id the primary key for the new v l video category
	* @return the new v l video category
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the v l video category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the v l video category
	* @return the v l video category that was removed
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException {
		return getPersistence().remove(id);
	}

	public static com.revotech.portal.videolibrary.model.VLVideoCategory updateImpl(
		com.revotech.portal.videolibrary.model.VLVideoCategory vlVideoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vlVideoCategory);
	}

	/**
	* Returns the v l video category with the primary key or throws a {@link com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException} if it could not be found.
	*
	* @param id the primary key of the v l video category
	* @return the v l video category
	* @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the v l video category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the v l video category
	* @return the v l video category, or <code>null</code> if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the v l video categories.
	*
	* @return the v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v l video categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v l video categories.
	*
	* @return the number of v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VLVideoCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VLVideoCategoryPersistence)PortletBeanLocatorUtil.locate(com.revotech.portal.videolibrary.service.ClpSerializer.getServletContextName(),
					VLVideoCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(VLVideoCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VLVideoCategoryPersistence persistence) {
	}

	private static VLVideoCategoryPersistence _persistence;
}