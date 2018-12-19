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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.viettel.portal.counter.model.CounterReport;

/**
 * The persistence interface for the counter report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see CounterReportPersistenceImpl
 * @see CounterReportUtil
 * @generated
 */
public interface CounterReportPersistence extends BasePersistence<CounterReport> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CounterReportUtil} to access the counter report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the counter reports where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the counter reports where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of counter reports
	* @param end the upper bound of the range of counter reports (not inclusive)
	* @return the range of matching counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the counter reports where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of counter reports
	* @param end the upper bound of the range of counter reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first counter report in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching counter report
	* @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a matching counter report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCounterReportException;

	/**
	* Returns the first counter report in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching counter report, or <code>null</code> if a matching counter report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last counter report in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching counter report
	* @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a matching counter report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCounterReportException;

	/**
	* Returns the last counter report in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching counter report, or <code>null</code> if a matching counter report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the counter reports before and after the current counter report in the ordered set where companyId = &#63;.
	*
	* @param reportId the primary key of the current counter report
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next counter report
	* @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport[] findByCompany_PrevAndNext(
		long reportId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCounterReportException;

	/**
	* Removes all the counter reports where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of counter reports where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching counter reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the counter reports where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the counter reports where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of counter reports
	* @param end the upper bound of the range of counter reports (not inclusive)
	* @return the range of matching counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the counter reports where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of counter reports
	* @param end the upper bound of the range of counter reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first counter report in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching counter report
	* @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a matching counter report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCounterReportException;

	/**
	* Returns the first counter report in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching counter report, or <code>null</code> if a matching counter report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last counter report in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching counter report
	* @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a matching counter report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCounterReportException;

	/**
	* Returns the last counter report in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching counter report, or <code>null</code> if a matching counter report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the counter reports before and after the current counter report in the ordered set where groupId = &#63;.
	*
	* @param reportId the primary key of the current counter report
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next counter report
	* @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport[] findByGroup_PrevAndNext(
		long reportId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCounterReportException;

	/**
	* Removes all the counter reports where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of counter reports where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching counter reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the counter report in the entity cache if it is enabled.
	*
	* @param counterReport the counter report
	*/
	public void cacheResult(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport);

	/**
	* Caches the counter reports in the entity cache if it is enabled.
	*
	* @param counterReports the counter reports
	*/
	public void cacheResult(
		java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> counterReports);

	/**
	* Creates a new counter report with the primary key. Does not add the counter report to the database.
	*
	* @param reportId the primary key for the new counter report
	* @return the new counter report
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport create(
		long reportId);

	/**
	* Removes the counter report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportId the primary key of the counter report
	* @return the counter report that was removed
	* @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport remove(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCounterReportException;

	public com.liferay.viettel.portal.counter.model.CounterReport updateImpl(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the counter report with the primary key or throws a {@link com.liferay.viettel.portal.counter.NoSuchCounterReportException} if it could not be found.
	*
	* @param reportId the primary key of the counter report
	* @return the counter report
	* @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport findByPrimaryKey(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.viettel.portal.counter.NoSuchCounterReportException;

	/**
	* Returns the counter report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportId the primary key of the counter report
	* @return the counter report, or <code>null</code> if a counter report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.viettel.portal.counter.model.CounterReport fetchByPrimaryKey(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the counter reports.
	*
	* @return the counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the counter reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of counter reports
	* @param end the upper bound of the range of counter reports (not inclusive)
	* @return the range of counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the counter reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of counter reports
	* @param end the upper bound of the range of counter reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of counter reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.viettel.portal.counter.model.CounterReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the counter reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of counter reports.
	*
	* @return the number of counter reports
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}