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

package com.liferay.viettel.portal.visitcounter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.viettel.portal.visitcounter.model.VisitCounter;

import java.util.List;

/**
 * The persistence utility for the visit counter service. This utility wraps {@link VisitCounterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hiepth6
 * @see VisitCounterPersistence
 * @see VisitCounterPersistenceImpl
 * @generated
 */
public class VisitCounterUtil {
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
	public static void clearCache(VisitCounter visitCounter) {
		getPersistence().clearCache(visitCounter);
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
	public static List<VisitCounter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VisitCounter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VisitCounter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VisitCounter update(VisitCounter visitCounter)
		throws SystemException {
		return getPersistence().update(visitCounter);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VisitCounter update(VisitCounter visitCounter,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(visitCounter, serviceContext);
	}

	/**
	* Returns all the visit counters where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the visit counters where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @return the range of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the visit counters where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first visit counter in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first visit counter in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter, or <code>null</code> if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last visit counter in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last visit counter in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter, or <code>null</code> if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the visit counters before and after the current visit counter in the ordered set where companyId = &#63;.
	*
	* @param counterId the primary key of the current visit counter
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter[] findByCompany_PrevAndNext(
		long counterId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException {
		return getPersistence()
				   .findByCompany_PrevAndNext(counterId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the visit counters where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of visit counters where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the visit counters where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the visit counters where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @return the range of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the visit counters where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first visit counter in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first visit counter in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter, or <code>null</code> if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last visit counter in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last visit counter in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter, or <code>null</code> if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the visit counters before and after the current visit counter in the ordered set where groupId = &#63;.
	*
	* @param counterId the primary key of the current visit counter
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter[] findByGroup_PrevAndNext(
		long counterId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException {
		return getPersistence()
				   .findByGroup_PrevAndNext(counterId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the visit counters where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of visit counters where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Caches the visit counter in the entity cache if it is enabled.
	*
	* @param visitCounter the visit counter
	*/
	public static void cacheResult(
		com.liferay.viettel.portal.visitcounter.model.VisitCounter visitCounter) {
		getPersistence().cacheResult(visitCounter);
	}

	/**
	* Caches the visit counters in the entity cache if it is enabled.
	*
	* @param visitCounters the visit counters
	*/
	public static void cacheResult(
		java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> visitCounters) {
		getPersistence().cacheResult(visitCounters);
	}

	/**
	* Creates a new visit counter with the primary key. Does not add the visit counter to the database.
	*
	* @param counterId the primary key for the new visit counter
	* @return the new visit counter
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter create(
		long counterId) {
		return getPersistence().create(counterId);
	}

	/**
	* Removes the visit counter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param counterId the primary key of the visit counter
	* @return the visit counter that was removed
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter remove(
		long counterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException {
		return getPersistence().remove(counterId);
	}

	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter updateImpl(
		com.liferay.viettel.portal.visitcounter.model.VisitCounter visitCounter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(visitCounter);
	}

	/**
	* Returns the visit counter with the primary key or throws a {@link com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException} if it could not be found.
	*
	* @param counterId the primary key of the visit counter
	* @return the visit counter
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter findByPrimaryKey(
		long counterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException {
		return getPersistence().findByPrimaryKey(counterId);
	}

	/**
	* Returns the visit counter with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param counterId the primary key of the visit counter
	* @return the visit counter, or <code>null</code> if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.viettel.portal.visitcounter.model.VisitCounter fetchByPrimaryKey(
		long counterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(counterId);
	}

	/**
	* Returns all the visit counters.
	*
	* @return the visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the visit counters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @return the range of visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the visit counters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the visit counters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of visit counters.
	*
	* @return the number of visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VisitCounterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VisitCounterPersistence)PortletBeanLocatorUtil.locate(com.liferay.viettel.portal.visitcounter.service.ClpSerializer.getServletContextName(),
					VisitCounterPersistence.class.getName());

			ReferenceRegistry.registerReference(VisitCounterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VisitCounterPersistence persistence) {
	}

	private static VisitCounterPersistence _persistence;
}