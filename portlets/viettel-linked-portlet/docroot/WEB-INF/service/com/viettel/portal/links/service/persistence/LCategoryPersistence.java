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

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.links.model.LCategory;

/**
 * The persistence interface for the l category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see LCategoryPersistenceImpl
 * @see LCategoryUtil
 * @generated
 */
public interface LCategoryPersistence extends BasePersistence<LCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LCategoryUtil} to access the l category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the l categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns the first l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns the last l category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns all the l categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Removes all the l categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l categories where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.LCategory> findByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> findByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> findByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory findByCategoryName_First(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns the first l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory fetchByCategoryName_First(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory findByCategoryName_Last(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns the last l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory fetchByCategoryName_Last(
		java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory[] findByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns all the l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory[] filterFindByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Removes all the l categories where categoryName = &#63; and groupId = &#63; from the database.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryName(java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l categories where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the number of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryName(java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @return the number of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryName(java.lang.String categoryName,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l categories where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @return the matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroupAndState(
		long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroupAndState(
		long groupId, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroupAndState(
		long groupId, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory findByGroupAndState_First(
		long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns the first l category in the ordered set where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory fetchByGroupAndState_First(
		long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory findByGroupAndState_Last(
		long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns the last l category in the ordered set where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l category, or <code>null</code> if a matching l category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory fetchByGroupAndState_Last(
		long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory[] findByGroupAndState_PrevAndNext(
		long categoryId, long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns all the l categories that the user has permission to view where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @return the matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroupAndState(
		long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroupAndState(
		long groupId, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> filterFindByGroupAndState(
		long groupId, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.links.model.LCategory[] filterFindByGroupAndState_PrevAndNext(
		long categoryId, long groupId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Removes all the l categories where groupId = &#63; and isActive = &#63; from the database.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndState(long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l categories where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @return the number of matching l categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndState(long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l categories that the user has permission to view where groupId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param isActive the is active
	* @return the number of matching l categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupAndState(long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l category in the entity cache if it is enabled.
	*
	* @param lCategory the l category
	*/
	public void cacheResult(com.viettel.portal.links.model.LCategory lCategory);

	/**
	* Caches the l categories in the entity cache if it is enabled.
	*
	* @param lCategories the l categories
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.links.model.LCategory> lCategories);

	/**
	* Creates a new l category with the primary key. Does not add the l category to the database.
	*
	* @param categoryId the primary key for the new l category
	* @return the new l category
	*/
	public com.viettel.portal.links.model.LCategory create(long categoryId);

	/**
	* Removes the l category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the l category
	* @return the l category that was removed
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	public com.viettel.portal.links.model.LCategory updateImpl(
		com.viettel.portal.links.model.LCategory lCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l category with the primary key or throws a {@link com.viettel.portal.links.NoSuchLCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the l category
	* @return the l category
	* @throws com.viettel.portal.links.NoSuchLCategoryException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchLCategoryException;

	/**
	* Returns the l category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the l category
	* @return the l category, or <code>null</code> if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.LCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l categories.
	*
	* @return the l categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.LCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.links.model.LCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l categories.
	*
	* @return the number of l categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}