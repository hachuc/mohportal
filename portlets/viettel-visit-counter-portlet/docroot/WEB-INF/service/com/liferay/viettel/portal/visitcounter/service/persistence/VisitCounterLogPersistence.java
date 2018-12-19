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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.viettel.portal.visitcounter.model.VisitCounterLog;

/**
 * The persistence interface for the visit counter log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hiepth6
 * @see VisitCounterLogPersistenceImpl
 * @see VisitCounterLogUtil
 * @generated
 */
public interface VisitCounterLogPersistence extends BasePersistence<VisitCounterLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VisitCounterLogUtil} to access the visit counter log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the visit counter logs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the visit counter logs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @return the range of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the visit counter logs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first visit counter log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter log
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;

	/**
	* Returns the first visit counter log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last visit counter log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter log
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;

	/**
	* Returns the last visit counter log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the visit counter logs before and after the current visit counter log in the ordered set where companyId = &#63;.
	*
	* @param visitorIp the primary key of the current visit counter log
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter log
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog[] findByCompany_PrevAndNext(
		java.lang.String visitorIp, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;

	/**
	* Removes all the visit counter logs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of visit counter logs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the visit counter logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the visit counter logs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @return the range of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the visit counter logs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first visit counter log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter log
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;

	/**
	* Returns the first visit counter log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last visit counter log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter log
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;

	/**
	* Returns the last visit counter log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the visit counter logs before and after the current visit counter log in the ordered set where groupId = &#63;.
	*
	* @param visitorIp the primary key of the current visit counter log
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter log
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog[] findByGroup_PrevAndNext(
		java.lang.String visitorIp, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;

	/**
	* Removes all the visit counter logs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of visit counter logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the visit counter log in the entity cache if it is enabled.
	*
	* @param visitCounterLog the visit counter log
	*/
	public void cacheResult(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog);

	/**
	* Caches the visit counter logs in the entity cache if it is enabled.
	*
	* @param visitCounterLogs the visit counter logs
	*/
	public void cacheResult(
		java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> visitCounterLogs);

	/**
	* Creates a new visit counter log with the primary key. Does not add the visit counter log to the database.
	*
	* @param visitorIp the primary key for the new visit counter log
	* @return the new visit counter log
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog create(
		java.lang.String visitorIp);

	/**
	* Removes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log that was removed
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog remove(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;

	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog updateImpl(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the visit counter log with the primary key or throws a {@link com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException} if it could not be found.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log
	* @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog findByPrimaryKey(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;

	/**
	* Returns the visit counter log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log, or <code>null</code> if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.visitcounter.model.VisitCounterLog fetchByPrimaryKey(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the visit counter logs.
	*
	* @return the visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the visit counter logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @return the range of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the visit counter logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.visitcounter.model.VisitCounterLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the visit counter logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of visit counter logs.
	*
	* @return the number of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}