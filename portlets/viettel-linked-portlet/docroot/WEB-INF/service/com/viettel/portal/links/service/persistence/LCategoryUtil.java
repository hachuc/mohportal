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

package com.viettel.portal.links.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.links.model.LCategory;

import java.util.List;

/**
 * The persistence utility for the l category service. This utility wraps {@link LCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see LCategoryPersistence
 * @see LCategoryPersistenceImpl
 * @generated
 */
public class LCategoryUtil {
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
	public static void clearCache(LCategory lCategory) {
		getPersistence().clearCache(lCategory);
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
	public static List<LCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LCategory update(LCategory lCategory)
		throws SystemException {
		return getPersistence().update(lCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LCategory update(LCategory lCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lCategory, serviceContext);
	}

	/**
	* Returns all the l categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the l categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the l categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the l categories before and after the current l category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current l category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the l categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the l categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the l categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the l categories before and after the current l category in the ordered set of l categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current l category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the l categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of l categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of l categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns all the l categories where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryName(categoryName, groupId);
	}

	/**
	* Returns a range of all the l categories where categoryName = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName(categoryName, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the l categories where categoryName = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName(categoryName, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory findByCategoryName_First(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .findByCategoryName_First(categoryName, groupId,
			orderByComparator);
	}

	/**
	* Returns the first l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory fetchByCategoryName_First(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName_First(categoryName, groupId,
			orderByComparator);
	}

	/**
	* Returns the last l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory findByCategoryName_Last(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .findByCategoryName_Last(categoryName, groupId,
			orderByComparator);
	}

	/**
	* Returns the last l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory fetchByCategoryName_Last(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName_Last(categoryName, groupId,
			orderByComparator);
	}

	/**
	* Returns the l categories before and after the current l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current l category
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory[] findByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .findByCategoryName_PrevAndNext(categoryId, categoryName,
			groupId, orderByComparator);
	}

	/**
	* Returns all the l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCategoryName(categoryName, groupId);
	}

	/**
	* Returns a range of all the l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryName(categoryName, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the l categories that the user has permissions to view where categoryName = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryName(categoryName, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the l categories before and after the current l category in the ordered set of l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current l category
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory[] filterFindByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .filterFindByCategoryName_PrevAndNext(categoryId,
			categoryName, groupId, orderByComparator);
	}

	/**
	* Removes all the l categories where categoryName = &#63; and groupId = &#63; from the database.
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
	* Returns the number of l categories where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the number of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryName(java.lang.String categoryName,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryName(categoryName, groupId);
	}

	/**
	* Returns the number of l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the number of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryName(java.lang.String categoryName,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCategoryName(categoryName, groupId);
	}

	/**
	* Returns all the l categories where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @return the matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroupAndState(
		long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndState(groupId, isActive);
	}

	/**
	* Returns a range of all the l categories where groupId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroupAndState(
		long groupId, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndState(groupId, isActive, start, end);
	}

	/**
	* Returns an ordered range of all the l categories where groupId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroupAndState(
		long groupId, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndState(groupId, isActive, start, end,
			orderByComparator);
	}

	/**
	* Returns the first l category in the ordered set where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory findByGroupAndState_First(
		long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .findByGroupAndState_First(groupId, isActive,
			orderByComparator);
	}

	/**
	* Returns the first l category in the ordered set where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory fetchByGroupAndState_First(
		long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndState_First(groupId, isActive,
			orderByComparator);
	}

	/**
	* Returns the last l category in the ordered set where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory findByGroupAndState_Last(
		long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .findByGroupAndState_Last(groupId, isActive,
			orderByComparator);
	}

	/**
	* Returns the last l category in the ordered set where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory fetchByGroupAndState_Last(
		long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndState_Last(groupId, isActive,
			orderByComparator);
	}

	/**
	* Returns the l categories before and after the current l category in the ordered set where groupId = &#63; and isActive = &#63;.
	*
	* @param categoryId the primary key of the current l category
	* @param groupId the group ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory[] findByGroupAndState_PrevAndNext(
		long categoryId, long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .findByGroupAndState_PrevAndNext(categoryId, groupId,
			isActive, orderByComparator);
	}

	/**
	* Returns all the l categories that the user has permission to view where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @return the matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroupAndState(
		long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupAndState(groupId, isActive);
	}

	/**
	* Returns a range of all the l categories that the user has permission to view where groupId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroupAndState(
		long groupId, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndState(groupId, isActive, start, end);
	}

	/**
	* Returns an ordered range of all the l categories that the user has permissions to view where groupId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroupAndState(
		long groupId, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndState(groupId, isActive, start, end,
			orderByComparator);
	}

	/**
	* Returns the l categories before and after the current l category in the ordered set of l categories that the user has permission to view where groupId = &#63; and isActive = &#63;.
	*
	* @param categoryId the primary key of the current l category
	* @param groupId the group ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory[] filterFindByGroupAndState_PrevAndNext(
		long categoryId, long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence()
				   .filterFindByGroupAndState_PrevAndNext(categoryId, groupId,
			isActive, orderByComparator);
	}

	/**
	* Removes all the l categories where groupId = &#63; and isActive = &#63; from the database.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndState(long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndState(groupId, isActive);
	}

	/**
	* Returns the number of l categories where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @return the number of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndState(long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndState(groupId, isActive);
	}

	/**
	* Returns the number of l categories that the user has permission to view where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @return the number of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupAndState(long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupAndState(groupId, isActive);
	}

	/**
	* Caches the l category in the entity cache if it is enabled.
	*
	* @param lCategory the l category
	*/
	public static void cacheResult(
		com.viettel.portal.links.model.LCategory lCategory) {
		getPersistence().cacheResult(lCategory);
	}

	/**
	* Caches the l categories in the entity cache if it is enabled.
	*
	* @param lCategories the l categories
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.links.model.LCategory> lCategories) {
		getPersistence().cacheResult(lCategories);
	}

	/**
	* Creates a new l category with the primary key. Does not add the l category to the database.
	*
	* @param categoryId the primary key for the new l category
	* @return the new l category
	*/
	public static com.viettel.portal.links.model.LCategory create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the l category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the l category
	* @return the l category that was removed
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.viettel.portal.links.model.LCategory updateImpl(
		com.viettel.portal.links.model.LCategory lCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lCategory);
	}

	/**
	* Returns the l category with the primary key or throws a {@link com.viettel.portal.links.NoSuchLCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the l category
	* @return the l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the l category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the l category
	* @return the l category, or <code>null</code> if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the l categories.
	*
	* @return the l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the l categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the l categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l categories.
	*
	* @return the number of l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LCategoryPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.links.service.ClpSerializer.getServletContextName(),
					LCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(LCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LCategoryPersistence persistence) {
	}

	private static LCategoryPersistence _persistence;
}