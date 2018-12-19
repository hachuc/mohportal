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

package com.viettel.portal.vcms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.vcms.model.ContentTypeCost;

import java.util.List;

/**
 * The persistence utility for the content type cost service. This utility wraps {@link ContentTypeCostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see ContentTypeCostPersistence
 * @see ContentTypeCostPersistenceImpl
 * @generated
 */
public class ContentTypeCostUtil {
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
	public static void clearCache(ContentTypeCost contentTypeCost) {
		getPersistence().clearCache(contentTypeCost);
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
	public static List<ContentTypeCost> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContentTypeCost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContentTypeCost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ContentTypeCost update(ContentTypeCost contentTypeCost)
		throws SystemException {
		return getPersistence().update(contentTypeCost);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ContentTypeCost update(ContentTypeCost contentTypeCost,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contentTypeCost, serviceContext);
	}

	/**
	* Returns all the content type costs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the content type costs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @return the range of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the content type costs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first content type cost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type cost
	* @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeCostException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first content type cost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type cost, or <code>null</code> if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last content type cost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type cost
	* @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeCostException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last content type cost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type cost, or <code>null</code> if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the content type costs before and after the current content type cost in the ordered set where groupId = &#63;.
	*
	* @param costId the primary key of the current content type cost
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content type cost
	* @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost[] findByGroupId_PrevAndNext(
		long costId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeCostException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(costId, groupId, orderByComparator);
	}

	/**
	* Removes all the content type costs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of content type costs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the content type costs where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @return the matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findByCostByDate(
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCostByDate(fromDate, toDate);
	}

	/**
	* Returns a range of all the content type costs where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @return the range of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findByCostByDate(
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCostByDate(fromDate, toDate, start, end);
	}

	/**
	* Returns an ordered range of all the content type costs where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findByCostByDate(
		java.util.Date fromDate, java.util.Date toDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCostByDate(fromDate, toDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type cost
	* @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost findByCostByDate_First(
		java.util.Date fromDate, java.util.Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeCostException {
		return getPersistence()
				   .findByCostByDate_First(fromDate, toDate, orderByComparator);
	}

	/**
	* Returns the first content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type cost, or <code>null</code> if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost fetchByCostByDate_First(
		java.util.Date fromDate, java.util.Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCostByDate_First(fromDate, toDate, orderByComparator);
	}

	/**
	* Returns the last content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type cost
	* @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost findByCostByDate_Last(
		java.util.Date fromDate, java.util.Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeCostException {
		return getPersistence()
				   .findByCostByDate_Last(fromDate, toDate, orderByComparator);
	}

	/**
	* Returns the last content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type cost, or <code>null</code> if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost fetchByCostByDate_Last(
		java.util.Date fromDate, java.util.Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCostByDate_Last(fromDate, toDate, orderByComparator);
	}

	/**
	* Returns the content type costs before and after the current content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* @param costId the primary key of the current content type cost
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content type cost
	* @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost[] findByCostByDate_PrevAndNext(
		long costId, java.util.Date fromDate, java.util.Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeCostException {
		return getPersistence()
				   .findByCostByDate_PrevAndNext(costId, fromDate, toDate,
			orderByComparator);
	}

	/**
	* Removes all the content type costs where fromDate &gt; &#63; and toDate &lt; &#63; from the database.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCostByDate(java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCostByDate(fromDate, toDate);
	}

	/**
	* Returns the number of content type costs where fromDate &gt; &#63; and toDate &lt; &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @return the number of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCostByDate(java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCostByDate(fromDate, toDate);
	}

	/**
	* Caches the content type cost in the entity cache if it is enabled.
	*
	* @param contentTypeCost the content type cost
	*/
	public static void cacheResult(
		com.viettel.portal.vcms.model.ContentTypeCost contentTypeCost) {
		getPersistence().cacheResult(contentTypeCost);
	}

	/**
	* Caches the content type costs in the entity cache if it is enabled.
	*
	* @param contentTypeCosts the content type costs
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> contentTypeCosts) {
		getPersistence().cacheResult(contentTypeCosts);
	}

	/**
	* Creates a new content type cost with the primary key. Does not add the content type cost to the database.
	*
	* @param costId the primary key for the new content type cost
	* @return the new content type cost
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost create(
		long costId) {
		return getPersistence().create(costId);
	}

	/**
	* Removes the content type cost with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param costId the primary key of the content type cost
	* @return the content type cost that was removed
	* @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost remove(
		long costId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeCostException {
		return getPersistence().remove(costId);
	}

	public static com.viettel.portal.vcms.model.ContentTypeCost updateImpl(
		com.viettel.portal.vcms.model.ContentTypeCost contentTypeCost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contentTypeCost);
	}

	/**
	* Returns the content type cost with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentTypeCostException} if it could not be found.
	*
	* @param costId the primary key of the content type cost
	* @return the content type cost
	* @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost findByPrimaryKey(
		long costId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeCostException {
		return getPersistence().findByPrimaryKey(costId);
	}

	/**
	* Returns the content type cost with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param costId the primary key of the content type cost
	* @return the content type cost, or <code>null</code> if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentTypeCost fetchByPrimaryKey(
		long costId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(costId);
	}

	/**
	* Returns all the content type costs.
	*
	* @return the content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the content type costs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @return the range of content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the content type costs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentTypeCost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the content type costs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of content type costs.
	*
	* @return the number of content type costs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContentTypeCostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContentTypeCostPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					ContentTypeCostPersistence.class.getName());

			ReferenceRegistry.registerReference(ContentTypeCostUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ContentTypeCostPersistence persistence) {
	}

	private static ContentTypeCostPersistence _persistence;
}