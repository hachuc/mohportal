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

package com.viettel.portal.photos.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.photos.model.PCategory;

import java.util.List;

/**
 * The persistence utility for the p category service. This utility wraps {@link PCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see PCategoryPersistence
 * @see PCategoryPersistenceImpl
 * @generated
 */
public class PCategoryUtil {
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
	public static void clearCache(PCategory pCategory) {
		getPersistence().clearCache(pCategory);
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
	public static List<PCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PCategory update(PCategory pCategory)
		throws SystemException {
		return getPersistence().update(pCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PCategory update(PCategory pCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(pCategory, serviceContext);
	}

	/**
	* Returns all the p categories where status = &#63;.
	*
	* @param status the status
	* @return the matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findBystatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status);
	}

	/**
	* Returns a range of all the p categories where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the p categories where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first p category in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the first p category in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last p category in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last p category in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the p categories before and after the current p category in the ordered set where status = &#63;.
	*
	* @param id the primary key of the current p category
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory[] findBystatus_PrevAndNext(
		long id, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence()
				   .findBystatus_PrevAndNext(id, status, orderByComparator);
	}

	/**
	* Removes all the p categories where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystatus(status);
	}

	/**
	* Returns the number of p categories where status = &#63;.
	*
	* @param status the status
	* @return the number of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystatus(status);
	}

	/**
	* Returns all the p categories where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndStatus(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, status);
	}

	/**
	* Returns a range of all the p categories where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndStatus(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the p categories where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndStatus(
		long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence()
				   .findByGroupAndStatus_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence()
				   .findByGroupAndStatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_Last(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the p categories before and after the current p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current p category
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory[] findByGroupAndStatus_PrevAndNext(
		long id, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence()
				   .findByGroupAndStatus_PrevAndNext(id, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the p categories where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndStatus(groupId, status);
	}

	/**
	* Returns the number of p categories where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndStatus(groupId, status);
	}

	/**
	* Returns all the p categories where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndName(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndName(groupId, name);
	}

	/**
	* Returns a range of all the p categories where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndName(
		long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndName(groupId, name, start, end);
	}

	/**
	* Returns an ordered range of all the p categories where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndName(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndName(groupId, name, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findByGroupAndName_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence()
				   .findByGroupAndName_First(groupId, name, orderByComparator);
	}

	/**
	* Returns the first p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchByGroupAndName_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndName_First(groupId, name, orderByComparator);
	}

	/**
	* Returns the last p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findByGroupAndName_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence()
				   .findByGroupAndName_Last(groupId, name, orderByComparator);
	}

	/**
	* Returns the last p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchByGroupAndName_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndName_Last(groupId, name, orderByComparator);
	}

	/**
	* Returns the p categories before and after the current p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param id the primary key of the current p category
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory[] findByGroupAndName_PrevAndNext(
		long id, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence()
				   .findByGroupAndName_PrevAndNext(id, groupId, name,
			orderByComparator);
	}

	/**
	* Removes all the p categories where groupId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndName(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndName(groupId, name);
	}

	/**
	* Returns the number of p categories where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndName(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndName(groupId, name);
	}

	/**
	* Returns all the p categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the p categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the p categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first p category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first p category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last p category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last p category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the p categories before and after the current p category in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current p category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(id, groupId, orderByComparator);
	}

	/**
	* Removes all the p categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of p categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Caches the p category in the entity cache if it is enabled.
	*
	* @param pCategory the p category
	*/
	public static void cacheResult(
		com.viettel.portal.photos.model.PCategory pCategory) {
		getPersistence().cacheResult(pCategory);
	}

	/**
	* Caches the p categories in the entity cache if it is enabled.
	*
	* @param pCategories the p categories
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.photos.model.PCategory> pCategories) {
		getPersistence().cacheResult(pCategories);
	}

	/**
	* Creates a new p category with the primary key. Does not add the p category to the database.
	*
	* @param id the primary key for the new p category
	* @return the new p category
	*/
	public static com.viettel.portal.photos.model.PCategory create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the p category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the p category
	* @return the p category that was removed
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.photos.model.PCategory updateImpl(
		com.viettel.portal.photos.model.PCategory pCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(pCategory);
	}

	/**
	* Returns the p category with the primary key or throws a {@link com.viettel.portal.photos.NoSuchPCategoryException} if it could not be found.
	*
	* @param id the primary key of the p category
	* @return the p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the p category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the p category
	* @return the p category, or <code>null</code> if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.photos.model.PCategory fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the p categories.
	*
	* @return the p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the p categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the p categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.photos.model.PCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p categories.
	*
	* @return the number of p categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PCategoryPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.photos.service.ClpSerializer.getServletContextName(),
					PCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(PCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PCategoryPersistence persistence) {
	}

	private static PCategoryPersistence _persistence;
}