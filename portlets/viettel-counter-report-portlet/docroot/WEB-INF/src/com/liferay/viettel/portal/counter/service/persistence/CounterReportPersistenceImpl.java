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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.viettel.portal.counter.NoSuchCounterReportException;
import com.liferay.viettel.portal.counter.model.CounterReport;
import com.liferay.viettel.portal.counter.model.impl.CounterReportImpl;
import com.liferay.viettel.portal.counter.model.impl.CounterReportModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the counter report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see CounterReportPersistence
 * @see CounterReportUtil
 * @generated
 */
public class CounterReportPersistenceImpl extends BasePersistenceImpl<CounterReport>
	implements CounterReportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CounterReportUtil} to access the counter report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CounterReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED,
			CounterReportImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED,
			CounterReportImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED,
			CounterReportImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED,
			CounterReportImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompany", new String[] { Long.class.getName() },
			CounterReportModelImpl.COMPANYID_COLUMN_BITMASK |
			CounterReportModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the counter reports where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching counter reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CounterReport> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<CounterReport> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

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
	@Override
	public List<CounterReport> findByCompany(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<CounterReport> list = (List<CounterReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CounterReport counterReport : list) {
				if ((companyId != counterReport.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COUNTERREPORT_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CounterReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<CounterReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CounterReport>(list);
				}
				else {
					list = (List<CounterReport>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first counter report in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter report
	 * @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a matching counter report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCounterReportException, SystemException {
		CounterReport counterReport = fetchByCompany_First(companyId,
				orderByComparator);

		if (counterReport != null) {
			return counterReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCounterReportException(msg.toString());
	}

	/**
	 * Returns the first counter report in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter report, or <code>null</code> if a matching counter report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CounterReport> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last counter report in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter report
	 * @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a matching counter report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCounterReportException, SystemException {
		CounterReport counterReport = fetchByCompany_Last(companyId,
				orderByComparator);

		if (counterReport != null) {
			return counterReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCounterReportException(msg.toString());
	}

	/**
	 * Returns the last counter report in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter report, or <code>null</code> if a matching counter report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<CounterReport> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CounterReport[] findByCompany_PrevAndNext(long reportId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCounterReportException, SystemException {
		CounterReport counterReport = findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			CounterReport[] array = new CounterReportImpl[3];

			array[0] = getByCompany_PrevAndNext(session, counterReport,
					companyId, orderByComparator, true);

			array[1] = counterReport;

			array[2] = getByCompany_PrevAndNext(session, counterReport,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CounterReport getByCompany_PrevAndNext(Session session,
		CounterReport counterReport, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COUNTERREPORT_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CounterReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(counterReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CounterReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the counter reports where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (CounterReport counterReport : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(counterReport);
		}
	}

	/**
	 * Returns the number of counter reports where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching counter reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompany(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANY;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COUNTERREPORT_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "counterReport.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED,
			CounterReportImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED,
			CounterReportImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup", new String[] { Long.class.getName() },
			CounterReportModelImpl.GROUPID_COLUMN_BITMASK |
			CounterReportModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the counter reports where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching counter reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CounterReport> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CounterReport> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

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
	@Override
	public List<CounterReport> findByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<CounterReport> list = (List<CounterReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CounterReport counterReport : list) {
				if ((groupId != counterReport.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COUNTERREPORT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CounterReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CounterReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CounterReport>(list);
				}
				else {
					list = (List<CounterReport>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first counter report in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter report
	 * @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a matching counter report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCounterReportException, SystemException {
		CounterReport counterReport = fetchByGroup_First(groupId,
				orderByComparator);

		if (counterReport != null) {
			return counterReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCounterReportException(msg.toString());
	}

	/**
	 * Returns the first counter report in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter report, or <code>null</code> if a matching counter report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CounterReport> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last counter report in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter report
	 * @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a matching counter report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCounterReportException, SystemException {
		CounterReport counterReport = fetchByGroup_Last(groupId,
				orderByComparator);

		if (counterReport != null) {
			return counterReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCounterReportException(msg.toString());
	}

	/**
	 * Returns the last counter report in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter report, or <code>null</code> if a matching counter report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<CounterReport> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CounterReport[] findByGroup_PrevAndNext(long reportId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCounterReportException, SystemException {
		CounterReport counterReport = findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			CounterReport[] array = new CounterReportImpl[3];

			array[0] = getByGroup_PrevAndNext(session, counterReport, groupId,
					orderByComparator, true);

			array[1] = counterReport;

			array[2] = getByGroup_PrevAndNext(session, counterReport, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CounterReport getByGroup_PrevAndNext(Session session,
		CounterReport counterReport, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COUNTERREPORT_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CounterReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(counterReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CounterReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the counter reports where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (CounterReport counterReport : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(counterReport);
		}
	}

	/**
	 * Returns the number of counter reports where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching counter reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroup(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COUNTERREPORT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "counterReport.groupId = ?";

	public CounterReportPersistenceImpl() {
		setModelClass(CounterReport.class);
	}

	/**
	 * Caches the counter report in the entity cache if it is enabled.
	 *
	 * @param counterReport the counter report
	 */
	@Override
	public void cacheResult(CounterReport counterReport) {
		EntityCacheUtil.putResult(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportImpl.class, counterReport.getPrimaryKey(),
			counterReport);

		counterReport.resetOriginalValues();
	}

	/**
	 * Caches the counter reports in the entity cache if it is enabled.
	 *
	 * @param counterReports the counter reports
	 */
	@Override
	public void cacheResult(List<CounterReport> counterReports) {
		for (CounterReport counterReport : counterReports) {
			if (EntityCacheUtil.getResult(
						CounterReportModelImpl.ENTITY_CACHE_ENABLED,
						CounterReportImpl.class, counterReport.getPrimaryKey()) == null) {
				cacheResult(counterReport);
			}
			else {
				counterReport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all counter reports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CounterReportImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CounterReportImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the counter report.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CounterReport counterReport) {
		EntityCacheUtil.removeResult(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportImpl.class, counterReport.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CounterReport> counterReports) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CounterReport counterReport : counterReports) {
			EntityCacheUtil.removeResult(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
				CounterReportImpl.class, counterReport.getPrimaryKey());
		}
	}

	/**
	 * Creates a new counter report with the primary key. Does not add the counter report to the database.
	 *
	 * @param reportId the primary key for the new counter report
	 * @return the new counter report
	 */
	@Override
	public CounterReport create(long reportId) {
		CounterReport counterReport = new CounterReportImpl();

		counterReport.setNew(true);
		counterReport.setPrimaryKey(reportId);

		return counterReport;
	}

	/**
	 * Removes the counter report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the counter report
	 * @return the counter report that was removed
	 * @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a counter report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport remove(long reportId)
		throws NoSuchCounterReportException, SystemException {
		return remove((Serializable)reportId);
	}

	/**
	 * Removes the counter report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the counter report
	 * @return the counter report that was removed
	 * @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a counter report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport remove(Serializable primaryKey)
		throws NoSuchCounterReportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CounterReport counterReport = (CounterReport)session.get(CounterReportImpl.class,
					primaryKey);

			if (counterReport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCounterReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(counterReport);
		}
		catch (NoSuchCounterReportException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CounterReport removeImpl(CounterReport counterReport)
		throws SystemException {
		counterReport = toUnwrappedModel(counterReport);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(counterReport)) {
				counterReport = (CounterReport)session.get(CounterReportImpl.class,
						counterReport.getPrimaryKeyObj());
			}

			if (counterReport != null) {
				session.delete(counterReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (counterReport != null) {
			clearCache(counterReport);
		}

		return counterReport;
	}

	@Override
	public CounterReport updateImpl(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport)
		throws SystemException {
		counterReport = toUnwrappedModel(counterReport);

		boolean isNew = counterReport.isNew();

		CounterReportModelImpl counterReportModelImpl = (CounterReportModelImpl)counterReport;

		Session session = null;

		try {
			session = openSession();

			if (counterReport.isNew()) {
				session.save(counterReport);

				counterReport.setNew(false);
			}
			else {
				session.merge(counterReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CounterReportModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((counterReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						counterReportModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { counterReportModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((counterReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						counterReportModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { counterReportModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
			CounterReportImpl.class, counterReport.getPrimaryKey(),
			counterReport);

		return counterReport;
	}

	protected CounterReport toUnwrappedModel(CounterReport counterReport) {
		if (counterReport instanceof CounterReportImpl) {
			return counterReport;
		}

		CounterReportImpl counterReportImpl = new CounterReportImpl();

		counterReportImpl.setNew(counterReport.isNew());
		counterReportImpl.setPrimaryKey(counterReport.getPrimaryKey());

		counterReportImpl.setReportId(counterReport.getReportId());
		counterReportImpl.setCompanyId(counterReport.getCompanyId());
		counterReportImpl.setGroupId(counterReport.getGroupId());
		counterReportImpl.setUserId(counterReport.getUserId());
		counterReportImpl.setUserName(counterReport.getUserName());
		counterReportImpl.setCreateDate(counterReport.getCreateDate());

		return counterReportImpl;
	}

	/**
	 * Returns the counter report with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the counter report
	 * @return the counter report
	 * @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a counter report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCounterReportException, SystemException {
		CounterReport counterReport = fetchByPrimaryKey(primaryKey);

		if (counterReport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCounterReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return counterReport;
	}

	/**
	 * Returns the counter report with the primary key or throws a {@link com.liferay.viettel.portal.counter.NoSuchCounterReportException} if it could not be found.
	 *
	 * @param reportId the primary key of the counter report
	 * @return the counter report
	 * @throws com.liferay.viettel.portal.counter.NoSuchCounterReportException if a counter report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport findByPrimaryKey(long reportId)
		throws NoSuchCounterReportException, SystemException {
		return findByPrimaryKey((Serializable)reportId);
	}

	/**
	 * Returns the counter report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the counter report
	 * @return the counter report, or <code>null</code> if a counter report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CounterReport counterReport = (CounterReport)EntityCacheUtil.getResult(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
				CounterReportImpl.class, primaryKey);

		if (counterReport == _nullCounterReport) {
			return null;
		}

		if (counterReport == null) {
			Session session = null;

			try {
				session = openSession();

				counterReport = (CounterReport)session.get(CounterReportImpl.class,
						primaryKey);

				if (counterReport != null) {
					cacheResult(counterReport);
				}
				else {
					EntityCacheUtil.putResult(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
						CounterReportImpl.class, primaryKey, _nullCounterReport);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CounterReportModelImpl.ENTITY_CACHE_ENABLED,
					CounterReportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return counterReport;
	}

	/**
	 * Returns the counter report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the counter report
	 * @return the counter report, or <code>null</code> if a counter report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CounterReport fetchByPrimaryKey(long reportId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)reportId);
	}

	/**
	 * Returns all the counter reports.
	 *
	 * @return the counter reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CounterReport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CounterReport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CounterReport> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CounterReport> list = (List<CounterReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COUNTERREPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COUNTERREPORT;

				if (pagination) {
					sql = sql.concat(CounterReportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CounterReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CounterReport>(list);
				}
				else {
					list = (List<CounterReport>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the counter reports from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CounterReport counterReport : findAll()) {
			remove(counterReport);
		}
	}

	/**
	 * Returns the number of counter reports.
	 *
	 * @return the number of counter reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COUNTERREPORT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the counter report persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.viettel.portal.counter.model.CounterReport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CounterReport>> listenersList = new ArrayList<ModelListener<CounterReport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CounterReport>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CounterReportImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COUNTERREPORT = "SELECT counterReport FROM CounterReport counterReport";
	private static final String _SQL_SELECT_COUNTERREPORT_WHERE = "SELECT counterReport FROM CounterReport counterReport WHERE ";
	private static final String _SQL_COUNT_COUNTERREPORT = "SELECT COUNT(counterReport) FROM CounterReport counterReport";
	private static final String _SQL_COUNT_COUNTERREPORT_WHERE = "SELECT COUNT(counterReport) FROM CounterReport counterReport WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "counterReport.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CounterReport exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CounterReport exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CounterReportPersistenceImpl.class);
	private static CounterReport _nullCounterReport = new CounterReportImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CounterReport> toCacheModel() {
				return _nullCounterReportCacheModel;
			}
		};

	private static CacheModel<CounterReport> _nullCounterReportCacheModel = new CacheModel<CounterReport>() {
			@Override
			public CounterReport toEntityModel() {
				return _nullCounterReport;
			}
		};
}