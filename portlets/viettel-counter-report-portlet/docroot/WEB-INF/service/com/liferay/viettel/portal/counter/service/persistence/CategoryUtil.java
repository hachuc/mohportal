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

package com.liferay.viettel.portal.counter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.viettel.portal.counter.model.Category;

import java.util.List;

/**
 * The persistence utility for the category service. This utility wraps {@link CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see CategoryPersistence
 * @see CategoryPersistenceImpl
 * @generated
 */
public class CategoryUtil {
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
	public static void clearCache(Category category) {
		getPersistence().clearCache(category);
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
	public static List<Category> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Category update(Category category) throws SystemException {
		return getPersistence().update(category);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Category update(Category category,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(category, serviceContext);
	}

	/**
	* Returns all the categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.counter.model.Category> findByG_C(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId);
	}

	/**
	* Returns a range of all the categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.counter.model.Category> findByG_C(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.counter.model.Category> findByG_C(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws com.liferay.viettel.portal.counter.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.Category findByG_C_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCategoryException {
		return getPersistence().findByG_C_First(groupId, orderByComparator);
	}

	/**
	* Returns the first category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.Category fetchByG_C_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_C_First(groupId, orderByComparator);
	}

	/**
	* Returns the last category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws com.liferay.viettel.portal.counter.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.Category findByG_C_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCategoryException {
		return getPersistence().findByG_C_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.Category fetchByG_C_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_C_Last(groupId, orderByComparator);
	}

	/**
	* Returns the categories before and after the current category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws com.liferay.viettel.portal.counter.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.Category[] findByG_C_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCategoryException {
		return getPersistence()
				   .findByG_C_PrevAndNext(categoryId, groupId, orderByComparator);
	}

	/**
	* Removes all the categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C(groupId);
	}

	/**
	* Returns the number of categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C(groupId);
	}

	/**
	* Caches the category in the entity cache if it is enabled.
	*
	* @param category the category
	*/
	public static void cacheResult(
		com.liferay.viettel.portal.counter.model.Category category) {
		getPersistence().cacheResult(category);
	}

	/**
	* Caches the categories in the entity cache if it is enabled.
	*
	* @param categories the categories
	*/
	public static void cacheResult(
		java.util.List<com.liferay.viettel.portal.counter.model.Category> categories) {
		getPersistence().cacheResult(categories);
	}

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	public static com.liferay.viettel.portal.counter.model.Category create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws com.liferay.viettel.portal.counter.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.Category remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.liferay.viettel.portal.counter.model.Category updateImpl(
		com.liferay.viettel.portal.counter.model.Category category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(category);
	}

	/**
	* Returns the category with the primary key or throws a {@link com.liferay.viettel.portal.counter.NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws com.liferay.viettel.portal.counter.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category, or <code>null</code> if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.counter.model.Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the categories.
	*
	* @return the categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.counter.model.Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.counter.model.Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.counter.model.Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoryPersistence)PortletBeanLocatorUtil.locate(com.liferay.viettel.portal.counter.service.ClpSerializer.getServletContextName(),
					CategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CategoryPersistence persistence) {
	}

	private static CategoryPersistence _persistence;
}