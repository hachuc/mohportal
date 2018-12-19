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

package com.revotech.portal.tthc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.revotech.portal.tthc.model.Category;

/**
 * The persistence interface for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hieptran
 * @see CategoryPersistenceImpl
 * @see CategoryUtil
 * @generated
 */
public interface CategoryPersistence extends BasePersistence<Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the categories where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @return the matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByG_C_A(
		int categoryType, boolean isActive, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByG_C_A(
		int categoryType, boolean isActive, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByG_C_A(
		int categoryType, boolean isActive, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category findByG_C_A_First(
		int categoryType, boolean isActive, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns the first category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category fetchByG_C_A_First(
		int categoryType, boolean isActive, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category findByG_C_A_Last(
		int categoryType, boolean isActive, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns the last category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category fetchByG_C_A_Last(
		int categoryType, boolean isActive, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categories before and after the current category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category[] findByG_C_A_PrevAndNext(
		long categoryId, int categoryType, boolean isActive, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns all the categories that the user has permission to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @return the matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByG_C_A(
		int categoryType, boolean isActive, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories that the user has permission to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByG_C_A(
		int categoryType, boolean isActive, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories that the user has permissions to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByG_C_A(
		int categoryType, boolean isActive, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categories before and after the current category in the ordered set of categories that the user has permission to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category[] filterFindByG_C_A_PrevAndNext(
		long categoryId, int categoryType, boolean isActive, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Removes all the categories where categoryType = &#63; and isActive = &#63; and groupId = &#63; from the database.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C_A(int categoryType, boolean isActive, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @return the number of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C_A(int categoryType, boolean isActive, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories that the user has permission to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	*
	* @param categoryType the category type
	* @param isActive the is active
	* @param groupId the group ID
	* @return the number of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_C_A(int categoryType, boolean isActive,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @return the matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByByKeyword(
		long groupId, java.lang.String categoryName, int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByByKeyword(
		long groupId, java.lang.String categoryName, int categoryType,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByByKeyword(
		long groupId, java.lang.String categoryName, int categoryType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category findByByKeyword_First(
		long groupId, java.lang.String categoryName, int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns the first category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category fetchByByKeyword_First(
		long groupId, java.lang.String categoryName, int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category findByByKeyword_Last(
		long groupId, java.lang.String categoryName, int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns the last category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category fetchByByKeyword_Last(
		long groupId, java.lang.String categoryName, int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categories before and after the current category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category[] findByByKeyword_PrevAndNext(
		long categoryId, long groupId, java.lang.String categoryName,
		int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns all the categories that the user has permission to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @return the matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByByKeyword(
		long groupId, java.lang.String categoryName, int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories that the user has permission to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByByKeyword(
		long groupId, java.lang.String categoryName, int categoryType,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories that the user has permissions to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByByKeyword(
		long groupId, java.lang.String categoryName, int categoryType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categories before and after the current category in the ordered set of categories that the user has permission to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category[] filterFindByByKeyword_PrevAndNext(
		long categoryId, long groupId, java.lang.String categoryName,
		int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Removes all the categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByKeyword(long groupId, java.lang.String categoryName,
		int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @return the number of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByByKeyword(long groupId, java.lang.String categoryName,
		int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories that the user has permission to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	*
	* @param groupId the group ID
	* @param categoryName the category name
	* @param categoryType the category type
	* @return the number of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByByKeyword(long groupId,
		java.lang.String categoryName, int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @return the matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByCategoryName(
		java.lang.String categoryName, long groupId, int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByCategoryName(
		java.lang.String categoryName, long groupId, int categoryType,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findByCategoryName(
		java.lang.String categoryName, long groupId, int categoryType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category findByCategoryName_First(
		java.lang.String categoryName, long groupId, int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns the first category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category fetchByCategoryName_First(
		java.lang.String categoryName, long groupId, int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category findByCategoryName_Last(
		java.lang.String categoryName, long groupId, int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns the last category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category fetchByCategoryName_Last(
		java.lang.String categoryName, long groupId, int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categories before and after the current category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category[] findByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName, long groupId,
		int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns all the categories that the user has permission to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @return the matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories that the user has permission to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int categoryType,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories that the user has permissions to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> filterFindByCategoryName(
		java.lang.String categoryName, long groupId, int categoryType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categories before and after the current category in the ordered set of categories that the user has permission to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category[] filterFindByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName, long groupId,
		int categoryType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Removes all the categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63; from the database.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryName(java.lang.String categoryName,
		long groupId, int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @return the number of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryName(java.lang.String categoryName, long groupId,
		int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories that the user has permission to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	*
	* @param categoryName the category name
	* @param groupId the group ID
	* @param categoryType the category type
	* @return the number of matching categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryName(java.lang.String categoryName,
		long groupId, int categoryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the category in the entity cache if it is enabled.
	*
	* @param category the category
	*/
	public void cacheResult(com.revotech.portal.tthc.model.Category category);

	/**
	* Caches the categories in the entity cache if it is enabled.
	*
	* @param categories the categories
	*/
	public void cacheResult(
		java.util.List<com.revotech.portal.tthc.model.Category> categories);

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	public com.revotech.portal.tthc.model.Category create(long categoryId);

	/**
	* Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	public com.revotech.portal.tthc.model.Category updateImpl(
		com.revotech.portal.tthc.model.Category category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the category with the primary key or throws a {@link com.revotech.portal.tthc.NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchCategoryException;

	/**
	* Returns the category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category, or <code>null</code> if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the categories.
	*
	* @return the categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}