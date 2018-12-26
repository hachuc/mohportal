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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.videolibrary.model.VLCategory;

import java.util.List;

/**
 * The persistence utility for the v l category service. This utility wraps {@link VLCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLCategoryPersistence
 * @see VLCategoryPersistenceImpl
 * @generated
 */
public class VLCategoryUtil {
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
	public static void clearCache(VLCategory vlCategory) {
		getPersistence().clearCache(vlCategory);
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
	public static List<VLCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VLCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VLCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VLCategory update(VLCategory vlCategory)
		throws SystemException {
		return getPersistence().update(vlCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VLCategory update(VLCategory vlCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vlCategory, serviceContext);
	}

	/**
	* Returns all the v l categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the v l categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v l categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first v l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first v l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l category, or <code>null</code> if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last v l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last v l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l category, or <code>null</code> if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the v l categories before and after the current v l category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current v l category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v l categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the v l categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v l categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the v l categories before and after the current v l category in the ordered set of v l categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current v l category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the v l categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of v l categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of v l categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns all the v l categories where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryName(categoryName, groupId);
	}

	/**
	* Returns a range of all the v l categories where categoryName = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName(categoryName, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v l categories where categoryName = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName(categoryName, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByCategoryName_First(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByCategoryName_First(categoryName, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l category, or <code>null</code> if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByCategoryName_First(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName_First(categoryName, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByCategoryName_Last(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByCategoryName_Last(categoryName, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l category, or <code>null</code> if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByCategoryName_Last(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName_Last(categoryName, groupId,
			orderByComparator);
	}

	/**
	* Returns the v l categories before and after the current v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current v l category
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory[] findByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByCategoryName_PrevAndNext(categoryId, categoryName,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCategoryName(categoryName, groupId);
	}

	/**
	* Returns a range of all the v l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryName(categoryName, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v l categories that the user has permissions to view where categoryName = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryName(categoryName, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the v l categories before and after the current v l category in the ordered set of v l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current v l category
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory[] filterFindByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .filterFindByCategoryName_PrevAndNext(categoryId,
			categoryName, groupId, orderByComparator);
	}

	/**
	* Removes all the v l categories where categoryName = &#63; and groupId = &#63; from the database.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryName(java.lang.String categoryName,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryName(categoryName, groupId);
	}

	/**
	* Returns the number of v l categories where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the number of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryName(java.lang.String categoryName,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryName(categoryName, groupId);
	}

	/**
	* Returns the number of v l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the number of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryName(java.lang.String categoryName,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCategoryName(categoryName, groupId);
	}

	/**
	* Returns all the v l categories where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryId_GroupId(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId_GroupId(categoryId, groupId);
	}

	/**
	* Returns a range of all the v l categories where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryId_GroupId(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId_GroupId(categoryId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v l categories where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryId_GroupId(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId_GroupId(categoryId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v l category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByCategoryId_GroupId_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByCategoryId_GroupId_First(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v l category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l category, or <code>null</code> if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByCategoryId_GroupId_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId_GroupId_First(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v l category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByCategoryId_GroupId_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByCategoryId_GroupId_Last(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v l category in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l category, or <code>null</code> if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByCategoryId_GroupId_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId_GroupId_Last(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v l categories that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByCategoryId_GroupId(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryId_GroupId(categoryId, groupId);
	}

	/**
	* Returns a range of all the v l categories that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByCategoryId_GroupId(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryId_GroupId(categoryId, groupId, start,
			end);
	}

	/**
	* Returns an ordered range of all the v l categories that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByCategoryId_GroupId(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryId_GroupId(categoryId, groupId, start,
			end, orderByComparator);
	}

	/**
	* Removes all the v l categories where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryId_GroupId(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryId_GroupId(categoryId, groupId);
	}

	/**
	* Returns the number of v l categories where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryId_GroupId(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryId_GroupId(categoryId, groupId);
	}

	/**
	* Returns the number of v l categories that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryId_GroupId(long categoryId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCategoryId_GroupId(categoryId, groupId);
	}

	/**
	* Returns all the v l categories where groupId = &#63; and invisible = &#63;.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @return the matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroupAndState(
		long groupId, boolean invisible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndState(groupId, invisible);
	}

	/**
	* Returns a range of all the v l categories where groupId = &#63; and invisible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroupAndState(
		long groupId, boolean invisible, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndState(groupId, invisible, start, end);
	}

	/**
	* Returns an ordered range of all the v l categories where groupId = &#63; and invisible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroupAndState(
		long groupId, boolean invisible, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndState(groupId, invisible, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByGroupAndState_First(
		long groupId, boolean invisible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByGroupAndState_First(groupId, invisible,
			orderByComparator);
	}

	/**
	* Returns the first v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v l category, or <code>null</code> if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByGroupAndState_First(
		long groupId, boolean invisible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndState_First(groupId, invisible,
			orderByComparator);
	}

	/**
	* Returns the last v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByGroupAndState_Last(
		long groupId, boolean invisible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByGroupAndState_Last(groupId, invisible,
			orderByComparator);
	}

	/**
	* Returns the last v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v l category, or <code>null</code> if a matching v l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByGroupAndState_Last(
		long groupId, boolean invisible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndState_Last(groupId, invisible,
			orderByComparator);
	}

	/**
	* Returns the v l categories before and after the current v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	*
	* @param categoryId the primary key of the current v l category
	* @param groupId the group ID
	* @param invisible the invisible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory[] findByGroupAndState_PrevAndNext(
		long categoryId, long groupId, boolean invisible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .findByGroupAndState_PrevAndNext(categoryId, groupId,
			invisible, orderByComparator);
	}

	/**
	* Returns all the v l categories that the user has permission to view where groupId = &#63; and invisible = &#63;.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @return the matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByGroupAndState(
		long groupId, boolean invisible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupAndState(groupId, invisible);
	}

	/**
	* Returns a range of all the v l categories that the user has permission to view where groupId = &#63; and invisible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByGroupAndState(
		long groupId, boolean invisible, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndState(groupId, invisible, start, end);
	}

	/**
	* Returns an ordered range of all the v l categories that the user has permissions to view where groupId = &#63; and invisible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> filterFindByGroupAndState(
		long groupId, boolean invisible, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndState(groupId, invisible, start, end,
			orderByComparator);
	}

	/**
	* Returns the v l categories before and after the current v l category in the ordered set of v l categories that the user has permission to view where groupId = &#63; and invisible = &#63;.
	*
	* @param categoryId the primary key of the current v l category
	* @param groupId the group ID
	* @param invisible the invisible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory[] filterFindByGroupAndState_PrevAndNext(
		long categoryId, long groupId, boolean invisible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence()
				   .filterFindByGroupAndState_PrevAndNext(categoryId, groupId,
			invisible, orderByComparator);
	}

	/**
	* Removes all the v l categories where groupId = &#63; and invisible = &#63; from the database.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndState(long groupId, boolean invisible)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndState(groupId, invisible);
	}

	/**
	* Returns the number of v l categories where groupId = &#63; and invisible = &#63;.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @return the number of matching v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndState(long groupId, boolean invisible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndState(groupId, invisible);
	}

	/**
	* Returns the number of v l categories that the user has permission to view where groupId = &#63; and invisible = &#63;.
	*
	* @param groupId the group ID
	* @param invisible the invisible
	* @return the number of matching v l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupAndState(long groupId, boolean invisible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupAndState(groupId, invisible);
	}

	/**
	* Caches the v l category in the entity cache if it is enabled.
	*
	* @param vlCategory the v l category
	*/
	public static void cacheResult(
		com.viettel.portal.videolibrary.model.VLCategory vlCategory) {
		getPersistence().cacheResult(vlCategory);
	}

	/**
	* Caches the v l categories in the entity cache if it is enabled.
	*
	* @param vlCategories the v l categories
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.videolibrary.model.VLCategory> vlCategories) {
		getPersistence().cacheResult(vlCategories);
	}

	/**
	* Creates a new v l category with the primary key. Does not add the v l category to the database.
	*
	* @param categoryId the primary key for the new v l category
	* @return the new v l category
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the v l category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the v l category
	* @return the v l category that was removed
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.viettel.portal.videolibrary.model.VLCategory updateImpl(
		com.viettel.portal.videolibrary.model.VLCategory vlCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vlCategory);
	}

	/**
	* Returns the v l category with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVLCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the v l category
	* @return the v l category
	* @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVLCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the v l category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the v l category
	* @return the v l category, or <code>null</code> if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.videolibrary.model.VLCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the v l categories.
	*
	* @return the v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v l categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v l categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v l categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v l categories.
	*
	* @return the number of v l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VLCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VLCategoryPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.videolibrary.service.ClpSerializer.getServletContextName(),
					VLCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(VLCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VLCategoryPersistence persistence) {
	}

	private static VLCategoryPersistence _persistence;
}