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

import com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException;
import com.liferay.viettel.portal.visitcounter.model.VisitCounter;
import com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterImpl;
import com.liferay.viettel.portal.visitcounter.model.impl.VisitCounterModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the visit counter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hiepth6
 * @see VisitCounterPersistence
 * @see VisitCounterUtil
 * @generated
 */
public class VisitCounterPersistenceImpl extends BasePersistenceImpl<VisitCounter>
	implements VisitCounterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VisitCounterUtil} to access the visit counter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VisitCounterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, VisitCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, VisitCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, VisitCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, VisitCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VisitCounterModelImpl.COMPANYID_COLUMN_BITMASK |
			VisitCounterModelImpl.TOTALHITCOUNTER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the visit counters where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching visit counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitCounter> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<VisitCounter> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
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
	@Override
	public List<VisitCounter> findByCompany(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<VisitCounter> list = (List<VisitCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VisitCounter visitCounter : list) {
				if ((companyId != visitCounter.getCompanyId())) {
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

			query.append(_SQL_SELECT_VISITCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VisitCounterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<VisitCounter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VisitCounter>(list);
				}
				else {
					list = (List<VisitCounter>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first visit counter in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a matching visit counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterException, SystemException {
		VisitCounter visitCounter = fetchByCompany_First(companyId,
				orderByComparator);

		if (visitCounter != null) {
			return visitCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterException(msg.toString());
	}

	/**
	 * Returns the first visit counter in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter, or <code>null</code> if a matching visit counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VisitCounter> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public VisitCounter findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterException, SystemException {
		VisitCounter visitCounter = fetchByCompany_Last(companyId,
				orderByComparator);

		if (visitCounter != null) {
			return visitCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterException(msg.toString());
	}

	/**
	 * Returns the last visit counter in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter, or <code>null</code> if a matching visit counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<VisitCounter> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public VisitCounter[] findByCompany_PrevAndNext(long counterId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVisitCounterException, SystemException {
		VisitCounter visitCounter = findByPrimaryKey(counterId);

		Session session = null;

		try {
			session = openSession();

			VisitCounter[] array = new VisitCounterImpl[3];

			array[0] = getByCompany_PrevAndNext(session, visitCounter,
					companyId, orderByComparator, true);

			array[1] = visitCounter;

			array[2] = getByCompany_PrevAndNext(session, visitCounter,
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

	protected VisitCounter getByCompany_PrevAndNext(Session session,
		VisitCounter visitCounter, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VISITCOUNTER_WHERE);

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
			query.append(VisitCounterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(visitCounter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VisitCounter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit counters where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (VisitCounter visitCounter : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(visitCounter);
		}
	}

	/**
	 * Returns the number of visit counters where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching visit counters
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

			query.append(_SQL_COUNT_VISITCOUNTER_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "visitCounter.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, VisitCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, VisitCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VisitCounterModelImpl.GROUPID_COLUMN_BITMASK |
			VisitCounterModelImpl.TOTALHITCOUNTER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the visit counters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching visit counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitCounter> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<VisitCounter> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
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
	@Override
	public List<VisitCounter> findByGroup(long groupId, int start, int end,
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

		List<VisitCounter> list = (List<VisitCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VisitCounter visitCounter : list) {
				if ((groupId != visitCounter.getGroupId())) {
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

			query.append(_SQL_SELECT_VISITCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VisitCounterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VisitCounter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VisitCounter>(list);
				}
				else {
					list = (List<VisitCounter>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first visit counter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a matching visit counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterException, SystemException {
		VisitCounter visitCounter = fetchByGroup_First(groupId,
				orderByComparator);

		if (visitCounter != null) {
			return visitCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterException(msg.toString());
	}

	/**
	 * Returns the first visit counter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter, or <code>null</code> if a matching visit counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VisitCounter> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public VisitCounter findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterException, SystemException {
		VisitCounter visitCounter = fetchByGroup_Last(groupId, orderByComparator);

		if (visitCounter != null) {
			return visitCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterException(msg.toString());
	}

	/**
	 * Returns the last visit counter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter, or <code>null</code> if a matching visit counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<VisitCounter> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public VisitCounter[] findByGroup_PrevAndNext(long counterId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterException, SystemException {
		VisitCounter visitCounter = findByPrimaryKey(counterId);

		Session session = null;

		try {
			session = openSession();

			VisitCounter[] array = new VisitCounterImpl[3];

			array[0] = getByGroup_PrevAndNext(session, visitCounter, groupId,
					orderByComparator, true);

			array[1] = visitCounter;

			array[2] = getByGroup_PrevAndNext(session, visitCounter, groupId,
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

	protected VisitCounter getByGroup_PrevAndNext(Session session,
		VisitCounter visitCounter, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VISITCOUNTER_WHERE);

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
			query.append(VisitCounterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(visitCounter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VisitCounter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit counters where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (VisitCounter visitCounter : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(visitCounter);
		}
	}

	/**
	 * Returns the number of visit counters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching visit counters
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

			query.append(_SQL_COUNT_VISITCOUNTER_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "visitCounter.groupId = ?";

	public VisitCounterPersistenceImpl() {
		setModelClass(VisitCounter.class);
	}

	/**
	 * Caches the visit counter in the entity cache if it is enabled.
	 *
	 * @param visitCounter the visit counter
	 */
	@Override
	public void cacheResult(VisitCounter visitCounter) {
		EntityCacheUtil.putResult(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterImpl.class, visitCounter.getPrimaryKey(), visitCounter);

		visitCounter.resetOriginalValues();
	}

	/**
	 * Caches the visit counters in the entity cache if it is enabled.
	 *
	 * @param visitCounters the visit counters
	 */
	@Override
	public void cacheResult(List<VisitCounter> visitCounters) {
		for (VisitCounter visitCounter : visitCounters) {
			if (EntityCacheUtil.getResult(
						VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
						VisitCounterImpl.class, visitCounter.getPrimaryKey()) == null) {
				cacheResult(visitCounter);
			}
			else {
				visitCounter.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all visit counters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VisitCounterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VisitCounterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the visit counter.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VisitCounter visitCounter) {
		EntityCacheUtil.removeResult(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterImpl.class, visitCounter.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VisitCounter> visitCounters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VisitCounter visitCounter : visitCounters) {
			EntityCacheUtil.removeResult(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
				VisitCounterImpl.class, visitCounter.getPrimaryKey());
		}
	}

	/**
	 * Creates a new visit counter with the primary key. Does not add the visit counter to the database.
	 *
	 * @param counterId the primary key for the new visit counter
	 * @return the new visit counter
	 */
	@Override
	public VisitCounter create(long counterId) {
		VisitCounter visitCounter = new VisitCounterImpl();

		visitCounter.setNew(true);
		visitCounter.setPrimaryKey(counterId);

		return visitCounter;
	}

	/**
	 * Removes the visit counter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param counterId the primary key of the visit counter
	 * @return the visit counter that was removed
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter remove(long counterId)
		throws NoSuchVisitCounterException, SystemException {
		return remove((Serializable)counterId);
	}

	/**
	 * Removes the visit counter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visit counter
	 * @return the visit counter that was removed
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter remove(Serializable primaryKey)
		throws NoSuchVisitCounterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VisitCounter visitCounter = (VisitCounter)session.get(VisitCounterImpl.class,
					primaryKey);

			if (visitCounter == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisitCounterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(visitCounter);
		}
		catch (NoSuchVisitCounterException nsee) {
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
	protected VisitCounter removeImpl(VisitCounter visitCounter)
		throws SystemException {
		visitCounter = toUnwrappedModel(visitCounter);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(visitCounter)) {
				visitCounter = (VisitCounter)session.get(VisitCounterImpl.class,
						visitCounter.getPrimaryKeyObj());
			}

			if (visitCounter != null) {
				session.delete(visitCounter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (visitCounter != null) {
			clearCache(visitCounter);
		}

		return visitCounter;
	}

	@Override
	public VisitCounter updateImpl(
		com.liferay.viettel.portal.visitcounter.model.VisitCounter visitCounter)
		throws SystemException {
		visitCounter = toUnwrappedModel(visitCounter);

		boolean isNew = visitCounter.isNew();

		VisitCounterModelImpl visitCounterModelImpl = (VisitCounterModelImpl)visitCounter;

		Session session = null;

		try {
			session = openSession();

			if (visitCounter.isNew()) {
				session.save(visitCounter);

				visitCounter.setNew(false);
			}
			else {
				session.merge(visitCounter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VisitCounterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((visitCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						visitCounterModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { visitCounterModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((visitCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						visitCounterModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { visitCounterModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterImpl.class, visitCounter.getPrimaryKey(), visitCounter);

		return visitCounter;
	}

	protected VisitCounter toUnwrappedModel(VisitCounter visitCounter) {
		if (visitCounter instanceof VisitCounterImpl) {
			return visitCounter;
		}

		VisitCounterImpl visitCounterImpl = new VisitCounterImpl();

		visitCounterImpl.setNew(visitCounter.isNew());
		visitCounterImpl.setPrimaryKey(visitCounter.getPrimaryKey());

		visitCounterImpl.setCounterId(visitCounter.getCounterId());
		visitCounterImpl.setCompanyId(visitCounter.getCompanyId());
		visitCounterImpl.setGroupId(visitCounter.getGroupId());
		visitCounterImpl.setUserId(visitCounter.getUserId());
		visitCounterImpl.setUserName(visitCounter.getUserName());
		visitCounterImpl.setCreateDate(visitCounter.getCreateDate());
		visitCounterImpl.setModifiedDate(visitCounter.getModifiedDate());
		visitCounterImpl.setTotalHitCounter(visitCounter.getTotalHitCounter());

		return visitCounterImpl;
	}

	/**
	 * Returns the visit counter with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit counter
	 * @return the visit counter
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVisitCounterException, SystemException {
		VisitCounter visitCounter = fetchByPrimaryKey(primaryKey);

		if (visitCounter == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVisitCounterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return visitCounter;
	}

	/**
	 * Returns the visit counter with the primary key or throws a {@link com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException} if it could not be found.
	 *
	 * @param counterId the primary key of the visit counter
	 * @return the visit counter
	 * @throws com.liferay.viettel.portal.visitcounter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter findByPrimaryKey(long counterId)
		throws NoSuchVisitCounterException, SystemException {
		return findByPrimaryKey((Serializable)counterId);
	}

	/**
	 * Returns the visit counter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit counter
	 * @return the visit counter, or <code>null</code> if a visit counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VisitCounter visitCounter = (VisitCounter)EntityCacheUtil.getResult(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
				VisitCounterImpl.class, primaryKey);

		if (visitCounter == _nullVisitCounter) {
			return null;
		}

		if (visitCounter == null) {
			Session session = null;

			try {
				session = openSession();

				visitCounter = (VisitCounter)session.get(VisitCounterImpl.class,
						primaryKey);

				if (visitCounter != null) {
					cacheResult(visitCounter);
				}
				else {
					EntityCacheUtil.putResult(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
						VisitCounterImpl.class, primaryKey, _nullVisitCounter);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VisitCounterModelImpl.ENTITY_CACHE_ENABLED,
					VisitCounterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return visitCounter;
	}

	/**
	 * Returns the visit counter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param counterId the primary key of the visit counter
	 * @return the visit counter, or <code>null</code> if a visit counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounter fetchByPrimaryKey(long counterId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)counterId);
	}

	/**
	 * Returns all the visit counters.
	 *
	 * @return the visit counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitCounter> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<VisitCounter> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<VisitCounter> findAll(int start, int end,
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

		List<VisitCounter> list = (List<VisitCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VISITCOUNTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VISITCOUNTER;

				if (pagination) {
					sql = sql.concat(VisitCounterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VisitCounter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VisitCounter>(list);
				}
				else {
					list = (List<VisitCounter>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the visit counters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VisitCounter visitCounter : findAll()) {
			remove(visitCounter);
		}
	}

	/**
	 * Returns the number of visit counters.
	 *
	 * @return the number of visit counters
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

				Query q = session.createQuery(_SQL_COUNT_VISITCOUNTER);

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
	 * Initializes the visit counter persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.viettel.portal.visitcounter.model.VisitCounter")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VisitCounter>> listenersList = new ArrayList<ModelListener<VisitCounter>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VisitCounter>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VisitCounterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VISITCOUNTER = "SELECT visitCounter FROM VisitCounter visitCounter";
	private static final String _SQL_SELECT_VISITCOUNTER_WHERE = "SELECT visitCounter FROM VisitCounter visitCounter WHERE ";
	private static final String _SQL_COUNT_VISITCOUNTER = "SELECT COUNT(visitCounter) FROM VisitCounter visitCounter";
	private static final String _SQL_COUNT_VISITCOUNTER_WHERE = "SELECT COUNT(visitCounter) FROM VisitCounter visitCounter WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "visitCounter.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VisitCounter exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VisitCounter exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VisitCounterPersistenceImpl.class);
	private static VisitCounter _nullVisitCounter = new VisitCounterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VisitCounter> toCacheModel() {
				return _nullVisitCounterCacheModel;
			}
		};

	private static CacheModel<VisitCounter> _nullVisitCounterCacheModel = new CacheModel<VisitCounter>() {
			@Override
			public VisitCounter toEntityModel() {
				return _nullVisitCounter;
			}
		};
}