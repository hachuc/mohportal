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

import com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException;
import com.liferay.viettel.portal.visitcounter.model.VisitCounterLog;
import com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogImpl;
import com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterLogModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the visit counter log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hiepth6
 * @see VisitCounterLogPersistence
 * @see VisitCounterLogUtil
 * @generated
 */
public class VisitCounterLogPersistenceImpl extends BasePersistenceImpl<VisitCounterLog>
	implements VisitCounterLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VisitCounterLogUtil} to access the visit counter log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VisitCounterLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VisitCounterLogModelImpl.COMPANYID_COLUMN_BITMASK |
			VisitCounterLogModelImpl.HITCOUNTER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the visit counter logs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitCounterLog> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<VisitCounterLog> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

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
	@Override
	public List<VisitCounterLog> findByCompany(long companyId, int start,
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

		List<VisitCounterLog> list = (List<VisitCounterLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VisitCounterLog visitCounterLog : list) {
				if ((companyId != visitCounterLog.getCompanyId())) {
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

			query.append(_SQL_SELECT_VISITCOUNTERLOG_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VisitCounterLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<VisitCounterLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VisitCounterLog>(list);
				}
				else {
					list = (List<VisitCounterLog>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter log
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByCompany_First(companyId,
				orderByComparator);

		if (visitCounterLog != null) {
			return visitCounterLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterLogException(msg.toString());
	}

	/**
	 * Returns the first visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VisitCounterLog> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter log
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByCompany_Last(companyId,
				orderByComparator);

		if (visitCounterLog != null) {
			return visitCounterLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterLogException(msg.toString());
	}

	/**
	 * Returns the last visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<VisitCounterLog> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public VisitCounterLog[] findByCompany_PrevAndNext(String visitorIp,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = findByPrimaryKey(visitorIp);

		Session session = null;

		try {
			session = openSession();

			VisitCounterLog[] array = new VisitCounterLogImpl[3];

			array[0] = getByCompany_PrevAndNext(session, visitCounterLog,
					companyId, orderByComparator, true);

			array[1] = visitCounterLog;

			array[2] = getByCompany_PrevAndNext(session, visitCounterLog,
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

	protected VisitCounterLog getByCompany_PrevAndNext(Session session,
		VisitCounterLog visitCounterLog, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VISITCOUNTERLOG_WHERE);

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
			query.append(VisitCounterLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(visitCounterLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VisitCounterLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit counter logs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (VisitCounterLog visitCounterLog : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(visitCounterLog);
		}
	}

	/**
	 * Returns the number of visit counter logs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching visit counter logs
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

			query.append(_SQL_COUNT_VISITCOUNTERLOG_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "visitCounterLog.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VisitCounterLogModelImpl.GROUPID_COLUMN_BITMASK |
			VisitCounterLogModelImpl.HITCOUNTER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the visit counter logs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitCounterLog> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<VisitCounterLog> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

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
	@Override
	public List<VisitCounterLog> findByGroup(long groupId, int start, int end,
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

		List<VisitCounterLog> list = (List<VisitCounterLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VisitCounterLog visitCounterLog : list) {
				if ((groupId != visitCounterLog.getGroupId())) {
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

			query.append(_SQL_SELECT_VISITCOUNTERLOG_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VisitCounterLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VisitCounterLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VisitCounterLog>(list);
				}
				else {
					list = (List<VisitCounterLog>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter log
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByGroup_First(groupId,
				orderByComparator);

		if (visitCounterLog != null) {
			return visitCounterLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterLogException(msg.toString());
	}

	/**
	 * Returns the first visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VisitCounterLog> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter log
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByGroup_Last(groupId,
				orderByComparator);

		if (visitCounterLog != null) {
			return visitCounterLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterLogException(msg.toString());
	}

	/**
	 * Returns the last visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<VisitCounterLog> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public VisitCounterLog[] findByGroup_PrevAndNext(String visitorIp,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = findByPrimaryKey(visitorIp);

		Session session = null;

		try {
			session = openSession();

			VisitCounterLog[] array = new VisitCounterLogImpl[3];

			array[0] = getByGroup_PrevAndNext(session, visitCounterLog,
					groupId, orderByComparator, true);

			array[1] = visitCounterLog;

			array[2] = getByGroup_PrevAndNext(session, visitCounterLog,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VisitCounterLog getByGroup_PrevAndNext(Session session,
		VisitCounterLog visitCounterLog, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VISITCOUNTERLOG_WHERE);

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
			query.append(VisitCounterLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(visitCounterLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VisitCounterLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit counter logs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (VisitCounterLog visitCounterLog : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(visitCounterLog);
		}
	}

	/**
	 * Returns the number of visit counter logs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching visit counter logs
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

			query.append(_SQL_COUNT_VISITCOUNTERLOG_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "visitCounterLog.groupId = ?";

	public VisitCounterLogPersistenceImpl() {
		setModelClass(VisitCounterLog.class);
	}

	/**
	 * Caches the visit counter log in the entity cache if it is enabled.
	 *
	 * @param visitCounterLog the visit counter log
	 */
	@Override
	public void cacheResult(VisitCounterLog visitCounterLog) {
		EntityCacheUtil.putResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogImpl.class, visitCounterLog.getPrimaryKey(),
			visitCounterLog);

		visitCounterLog.resetOriginalValues();
	}

	/**
	 * Caches the visit counter logs in the entity cache if it is enabled.
	 *
	 * @param visitCounterLogs the visit counter logs
	 */
	@Override
	public void cacheResult(List<VisitCounterLog> visitCounterLogs) {
		for (VisitCounterLog visitCounterLog : visitCounterLogs) {
			if (EntityCacheUtil.getResult(
						VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
						VisitCounterLogImpl.class,
						visitCounterLog.getPrimaryKey()) == null) {
				cacheResult(visitCounterLog);
			}
			else {
				visitCounterLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all visit counter logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VisitCounterLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VisitCounterLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the visit counter log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VisitCounterLog visitCounterLog) {
		EntityCacheUtil.removeResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogImpl.class, visitCounterLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VisitCounterLog> visitCounterLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VisitCounterLog visitCounterLog : visitCounterLogs) {
			EntityCacheUtil.removeResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
				VisitCounterLogImpl.class, visitCounterLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new visit counter log with the primary key. Does not add the visit counter log to the database.
	 *
	 * @param visitorIp the primary key for the new visit counter log
	 * @return the new visit counter log
	 */
	@Override
	public VisitCounterLog create(String visitorIp) {
		VisitCounterLog visitCounterLog = new VisitCounterLogImpl();

		visitCounterLog.setNew(true);
		visitCounterLog.setPrimaryKey(visitorIp);

		return visitCounterLog;
	}

	/**
	 * Removes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visitorIp the primary key of the visit counter log
	 * @return the visit counter log that was removed
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog remove(String visitorIp)
		throws NoSuchVisitCounterLogException, SystemException {
		return remove((Serializable)visitorIp);
	}

	/**
	 * Removes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visit counter log
	 * @return the visit counter log that was removed
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog remove(Serializable primaryKey)
		throws NoSuchVisitCounterLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VisitCounterLog visitCounterLog = (VisitCounterLog)session.get(VisitCounterLogImpl.class,
					primaryKey);

			if (visitCounterLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisitCounterLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(visitCounterLog);
		}
		catch (NoSuchVisitCounterLogException nsee) {
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
	protected VisitCounterLog removeImpl(VisitCounterLog visitCounterLog)
		throws SystemException {
		visitCounterLog = toUnwrappedModel(visitCounterLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(visitCounterLog)) {
				visitCounterLog = (VisitCounterLog)session.get(VisitCounterLogImpl.class,
						visitCounterLog.getPrimaryKeyObj());
			}

			if (visitCounterLog != null) {
				session.delete(visitCounterLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (visitCounterLog != null) {
			clearCache(visitCounterLog);
		}

		return visitCounterLog;
	}

	@Override
	public VisitCounterLog updateImpl(
		com.liferay.viettel.portal.visitcounter.model.VisitCounterLog visitCounterLog)
		throws SystemException {
		visitCounterLog = toUnwrappedModel(visitCounterLog);

		boolean isNew = visitCounterLog.isNew();

		VisitCounterLogModelImpl visitCounterLogModelImpl = (VisitCounterLogModelImpl)visitCounterLog;

		Session session = null;

		try {
			session = openSession();

			if (visitCounterLog.isNew()) {
				session.save(visitCounterLog);

				visitCounterLog.setNew(false);
			}
			else {
				session.merge(visitCounterLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VisitCounterLogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((visitCounterLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						visitCounterLogModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { visitCounterLogModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((visitCounterLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						visitCounterLogModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { visitCounterLogModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogImpl.class, visitCounterLog.getPrimaryKey(),
			visitCounterLog);

		return visitCounterLog;
	}

	protected VisitCounterLog toUnwrappedModel(VisitCounterLog visitCounterLog) {
		if (visitCounterLog instanceof VisitCounterLogImpl) {
			return visitCounterLog;
		}

		VisitCounterLogImpl visitCounterLogImpl = new VisitCounterLogImpl();

		visitCounterLogImpl.setNew(visitCounterLog.isNew());
		visitCounterLogImpl.setPrimaryKey(visitCounterLog.getPrimaryKey());

		visitCounterLogImpl.setVisitorIp(visitCounterLog.getVisitorIp());
		visitCounterLogImpl.setCompanyId(visitCounterLog.getCompanyId());
		visitCounterLogImpl.setGroupId(visitCounterLog.getGroupId());
		visitCounterLogImpl.setUserId(visitCounterLog.getUserId());
		visitCounterLogImpl.setUserName(visitCounterLog.getUserName());
		visitCounterLogImpl.setCreateDate(visitCounterLog.getCreateDate());
		visitCounterLogImpl.setModifiedDate(visitCounterLog.getModifiedDate());
		visitCounterLogImpl.setHitCounter(visitCounterLog.getHitCounter());
		visitCounterLogImpl.setLastAccessPageId(visitCounterLog.getLastAccessPageId());
		visitCounterLogImpl.setLastAccessDate(visitCounterLog.getLastAccessDate());

		return visitCounterLogImpl;
	}

	/**
	 * Returns the visit counter log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit counter log
	 * @return the visit counter log
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByPrimaryKey(primaryKey);

		if (visitCounterLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVisitCounterLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return visitCounterLog;
	}

	/**
	 * Returns the visit counter log with the primary key or throws a {@link com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException} if it could not be found.
	 *
	 * @param visitorIp the primary key of the visit counter log
	 * @return the visit counter log
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog findByPrimaryKey(String visitorIp)
		throws NoSuchVisitCounterLogException, SystemException {
		return findByPrimaryKey((Serializable)visitorIp);
	}

	/**
	 * Returns the visit counter log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit counter log
	 * @return the visit counter log, or <code>null</code> if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VisitCounterLog visitCounterLog = (VisitCounterLog)EntityCacheUtil.getResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
				VisitCounterLogImpl.class, primaryKey);

		if (visitCounterLog == _nullVisitCounterLog) {
			return null;
		}

		if (visitCounterLog == null) {
			Session session = null;

			try {
				session = openSession();

				visitCounterLog = (VisitCounterLog)session.get(VisitCounterLogImpl.class,
						primaryKey);

				if (visitCounterLog != null) {
					cacheResult(visitCounterLog);
				}
				else {
					EntityCacheUtil.putResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
						VisitCounterLogImpl.class, primaryKey,
						_nullVisitCounterLog);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
					VisitCounterLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return visitCounterLog;
	}

	/**
	 * Returns the visit counter log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visitorIp the primary key of the visit counter log
	 * @return the visit counter log, or <code>null</code> if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog fetchByPrimaryKey(String visitorIp)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)visitorIp);
	}

	/**
	 * Returns all the visit counter logs.
	 *
	 * @return the visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitCounterLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<VisitCounterLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<VisitCounterLog> findAll(int start, int end,
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

		List<VisitCounterLog> list = (List<VisitCounterLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VISITCOUNTERLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VISITCOUNTERLOG;

				if (pagination) {
					sql = sql.concat(VisitCounterLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VisitCounterLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VisitCounterLog>(list);
				}
				else {
					list = (List<VisitCounterLog>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the visit counter logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VisitCounterLog visitCounterLog : findAll()) {
			remove(visitCounterLog);
		}
	}

	/**
	 * Returns the number of visit counter logs.
	 *
	 * @return the number of visit counter logs
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

				Query q = session.createQuery(_SQL_COUNT_VISITCOUNTERLOG);

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
	 * Initializes the visit counter log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.viettel.portal.visitcounter.model.VisitCounterLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VisitCounterLog>> listenersList = new ArrayList<ModelListener<VisitCounterLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VisitCounterLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VisitCounterLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VISITCOUNTERLOG = "SELECT visitCounterLog FROM VisitCounterLog visitCounterLog";
	private static final String _SQL_SELECT_VISITCOUNTERLOG_WHERE = "SELECT visitCounterLog FROM VisitCounterLog visitCounterLog WHERE ";
	private static final String _SQL_COUNT_VISITCOUNTERLOG = "SELECT COUNT(visitCounterLog) FROM VisitCounterLog visitCounterLog";
	private static final String _SQL_COUNT_VISITCOUNTERLOG_WHERE = "SELECT COUNT(visitCounterLog) FROM VisitCounterLog visitCounterLog WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "visitCounterLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VisitCounterLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VisitCounterLog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VisitCounterLogPersistenceImpl.class);
	private static VisitCounterLog _nullVisitCounterLog = new VisitCounterLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VisitCounterLog> toCacheModel() {
				return _nullVisitCounterLogCacheModel;
			}
		};

	private static CacheModel<VisitCounterLog> _nullVisitCounterLogCacheModel = new CacheModel<VisitCounterLog>() {
			@Override
			public VisitCounterLog toEntityModel() {
				return _nullVisitCounterLog;
			}
		};
}