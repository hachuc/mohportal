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

import com.viettel.portal.vcms.NoSuchLegal_DistributionException;
import com.viettel.portal.vcms.model.Legal_Distribution;
import com.viettel.portal.vcms.model.impl.Legal_DistributionImpl;
import com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legal_ distribution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_DistributionPersistence
 * @see Legal_DistributionUtil
 * @generated
 */
public class Legal_DistributionPersistenceImpl extends BasePersistenceImpl<Legal_Distribution>
	implements Legal_DistributionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Legal_DistributionUtil} to access the legal_ distribution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Legal_DistributionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionModelImpl.FINDER_CACHE_ENABLED,
			Legal_DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionModelImpl.FINDER_CACHE_ENABLED,
			Legal_DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYZONEID = new FinderPath(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionModelImpl.FINDER_CACHE_ENABLED,
			Legal_DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByZoneID",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONEID =
		new FinderPath(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionModelImpl.FINDER_CACHE_ENABLED,
			Legal_DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByZoneID",
			new String[] { Integer.class.getName() },
			Legal_DistributionModelImpl.ZONEID_COLUMN_BITMASK |
			Legal_DistributionModelImpl.DISTRIBUTEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYZONEID = new FinderPath(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByZoneID",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the legal_ distributions where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @return the matching legal_ distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Distribution> findByByZoneID(int ZoneID)
		throws SystemException {
		return findByByZoneID(ZoneID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ distributions where ZoneID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ZoneID the zone i d
	 * @param start the lower bound of the range of legal_ distributions
	 * @param end the upper bound of the range of legal_ distributions (not inclusive)
	 * @return the range of matching legal_ distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Distribution> findByByZoneID(int ZoneID, int start,
		int end) throws SystemException {
		return findByByZoneID(ZoneID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ distributions where ZoneID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ZoneID the zone i d
	 * @param start the lower bound of the range of legal_ distributions
	 * @param end the upper bound of the range of legal_ distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal_ distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Distribution> findByByZoneID(int ZoneID, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONEID;
			finderArgs = new Object[] { ZoneID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYZONEID;
			finderArgs = new Object[] { ZoneID, start, end, orderByComparator };
		}

		List<Legal_Distribution> list = (List<Legal_Distribution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Legal_Distribution legal_Distribution : list) {
				if ((ZoneID != legal_Distribution.getZoneID())) {
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

			query.append(_SQL_SELECT_LEGAL_DISTRIBUTION_WHERE);

			query.append(_FINDER_COLUMN_BYZONEID_ZONEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Legal_DistributionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ZoneID);

				if (!pagination) {
					list = (List<Legal_Distribution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Distribution>(list);
				}
				else {
					list = (List<Legal_Distribution>)QueryUtil.list(q,
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
	 * Returns the first legal_ distribution in the ordered set where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ distribution
	 * @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a matching legal_ distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution findByByZoneID_First(int ZoneID,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_DistributionException, SystemException {
		Legal_Distribution legal_Distribution = fetchByByZoneID_First(ZoneID,
				orderByComparator);

		if (legal_Distribution != null) {
			return legal_Distribution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ZoneID=");
		msg.append(ZoneID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_DistributionException(msg.toString());
	}

	/**
	 * Returns the first legal_ distribution in the ordered set where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ distribution, or <code>null</code> if a matching legal_ distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution fetchByByZoneID_First(int ZoneID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Legal_Distribution> list = findByByZoneID(ZoneID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal_ distribution in the ordered set where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ distribution
	 * @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a matching legal_ distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution findByByZoneID_Last(int ZoneID,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_DistributionException, SystemException {
		Legal_Distribution legal_Distribution = fetchByByZoneID_Last(ZoneID,
				orderByComparator);

		if (legal_Distribution != null) {
			return legal_Distribution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ZoneID=");
		msg.append(ZoneID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_DistributionException(msg.toString());
	}

	/**
	 * Returns the last legal_ distribution in the ordered set where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ distribution, or <code>null</code> if a matching legal_ distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution fetchByByZoneID_Last(int ZoneID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByByZoneID(ZoneID);

		if (count == 0) {
			return null;
		}

		List<Legal_Distribution> list = findByByZoneID(ZoneID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal_ distributions before and after the current legal_ distribution in the ordered set where ZoneID = &#63;.
	 *
	 * @param ID the primary key of the current legal_ distribution
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal_ distribution
	 * @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a legal_ distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution[] findByByZoneID_PrevAndNext(int ID, int ZoneID,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_DistributionException, SystemException {
		Legal_Distribution legal_Distribution = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			Legal_Distribution[] array = new Legal_DistributionImpl[3];

			array[0] = getByByZoneID_PrevAndNext(session, legal_Distribution,
					ZoneID, orderByComparator, true);

			array[1] = legal_Distribution;

			array[2] = getByByZoneID_PrevAndNext(session, legal_Distribution,
					ZoneID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Legal_Distribution getByByZoneID_PrevAndNext(Session session,
		Legal_Distribution legal_Distribution, int ZoneID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGAL_DISTRIBUTION_WHERE);

		query.append(_FINDER_COLUMN_BYZONEID_ZONEID_2);

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
			query.append(Legal_DistributionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ZoneID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legal_Distribution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Legal_Distribution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal_ distributions where ZoneID = &#63; from the database.
	 *
	 * @param ZoneID the zone i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByByZoneID(int ZoneID) throws SystemException {
		for (Legal_Distribution legal_Distribution : findByByZoneID(ZoneID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legal_Distribution);
		}
	}

	/**
	 * Returns the number of legal_ distributions where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @return the number of matching legal_ distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByByZoneID(int ZoneID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYZONEID;

		Object[] finderArgs = new Object[] { ZoneID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGAL_DISTRIBUTION_WHERE);

			query.append(_FINDER_COLUMN_BYZONEID_ZONEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ZoneID);

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

	private static final String _FINDER_COLUMN_BYZONEID_ZONEID_2 = "legal_Distribution.ZoneID = ?";

	public Legal_DistributionPersistenceImpl() {
		setModelClass(Legal_Distribution.class);
	}

	/**
	 * Caches the legal_ distribution in the entity cache if it is enabled.
	 *
	 * @param legal_Distribution the legal_ distribution
	 */
	@Override
	public void cacheResult(Legal_Distribution legal_Distribution) {
		EntityCacheUtil.putResult(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionImpl.class, legal_Distribution.getPrimaryKey(),
			legal_Distribution);

		legal_Distribution.resetOriginalValues();
	}

	/**
	 * Caches the legal_ distributions in the entity cache if it is enabled.
	 *
	 * @param legal_Distributions the legal_ distributions
	 */
	@Override
	public void cacheResult(List<Legal_Distribution> legal_Distributions) {
		for (Legal_Distribution legal_Distribution : legal_Distributions) {
			if (EntityCacheUtil.getResult(
						Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
						Legal_DistributionImpl.class,
						legal_Distribution.getPrimaryKey()) == null) {
				cacheResult(legal_Distribution);
			}
			else {
				legal_Distribution.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal_ distributions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Legal_DistributionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Legal_DistributionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal_ distribution.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Legal_Distribution legal_Distribution) {
		EntityCacheUtil.removeResult(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionImpl.class, legal_Distribution.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Legal_Distribution> legal_Distributions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Legal_Distribution legal_Distribution : legal_Distributions) {
			EntityCacheUtil.removeResult(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
				Legal_DistributionImpl.class, legal_Distribution.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legal_ distribution with the primary key. Does not add the legal_ distribution to the database.
	 *
	 * @param ID the primary key for the new legal_ distribution
	 * @return the new legal_ distribution
	 */
	@Override
	public Legal_Distribution create(int ID) {
		Legal_Distribution legal_Distribution = new Legal_DistributionImpl();

		legal_Distribution.setNew(true);
		legal_Distribution.setPrimaryKey(ID);

		return legal_Distribution;
	}

	/**
	 * Removes the legal_ distribution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the legal_ distribution
	 * @return the legal_ distribution that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a legal_ distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution remove(int ID)
		throws NoSuchLegal_DistributionException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the legal_ distribution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal_ distribution
	 * @return the legal_ distribution that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a legal_ distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution remove(Serializable primaryKey)
		throws NoSuchLegal_DistributionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Legal_Distribution legal_Distribution = (Legal_Distribution)session.get(Legal_DistributionImpl.class,
					primaryKey);

			if (legal_Distribution == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegal_DistributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legal_Distribution);
		}
		catch (NoSuchLegal_DistributionException nsee) {
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
	protected Legal_Distribution removeImpl(
		Legal_Distribution legal_Distribution) throws SystemException {
		legal_Distribution = toUnwrappedModel(legal_Distribution);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legal_Distribution)) {
				legal_Distribution = (Legal_Distribution)session.get(Legal_DistributionImpl.class,
						legal_Distribution.getPrimaryKeyObj());
			}

			if (legal_Distribution != null) {
				session.delete(legal_Distribution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legal_Distribution != null) {
			clearCache(legal_Distribution);
		}

		return legal_Distribution;
	}

	@Override
	public Legal_Distribution updateImpl(
		com.viettel.portal.vcms.model.Legal_Distribution legal_Distribution)
		throws SystemException {
		legal_Distribution = toUnwrappedModel(legal_Distribution);

		boolean isNew = legal_Distribution.isNew();

		Legal_DistributionModelImpl legal_DistributionModelImpl = (Legal_DistributionModelImpl)legal_Distribution;

		Session session = null;

		try {
			session = openSession();

			if (legal_Distribution.isNew()) {
				session.save(legal_Distribution);

				legal_Distribution.setNew(false);
			}
			else {
				session.merge(legal_Distribution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Legal_DistributionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legal_DistributionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legal_DistributionModelImpl.getOriginalZoneID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYZONEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONEID,
					args);

				args = new Object[] { legal_DistributionModelImpl.getZoneID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYZONEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONEID,
					args);
			}
		}

		EntityCacheUtil.putResult(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
			Legal_DistributionImpl.class, legal_Distribution.getPrimaryKey(),
			legal_Distribution);

		return legal_Distribution;
	}

	protected Legal_Distribution toUnwrappedModel(
		Legal_Distribution legal_Distribution) {
		if (legal_Distribution instanceof Legal_DistributionImpl) {
			return legal_Distribution;
		}

		Legal_DistributionImpl legal_DistributionImpl = new Legal_DistributionImpl();

		legal_DistributionImpl.setNew(legal_Distribution.isNew());
		legal_DistributionImpl.setPrimaryKey(legal_Distribution.getPrimaryKey());

		legal_DistributionImpl.setID(legal_Distribution.getID());
		legal_DistributionImpl.setContentID(legal_Distribution.getContentID());
		legal_DistributionImpl.setVersion(legal_Distribution.getVersion());
		legal_DistributionImpl.setZoneID(legal_Distribution.getZoneID());
		legal_DistributionImpl.setDistributedDate(legal_Distribution.getDistributedDate());
		legal_DistributionImpl.setRanking(legal_Distribution.getRanking());
		legal_DistributionImpl.setAllowDiscussion(legal_Distribution.isAllowDiscussion());
		legal_DistributionImpl.setViewedCount(legal_Distribution.getViewedCount());
		legal_DistributionImpl.setMailedCount(legal_Distribution.getMailedCount());
		legal_DistributionImpl.setRatedCount(legal_Distribution.getRatedCount());

		return legal_DistributionImpl;
	}

	/**
	 * Returns the legal_ distribution with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ distribution
	 * @return the legal_ distribution
	 * @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a legal_ distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegal_DistributionException, SystemException {
		Legal_Distribution legal_Distribution = fetchByPrimaryKey(primaryKey);

		if (legal_Distribution == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegal_DistributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legal_Distribution;
	}

	/**
	 * Returns the legal_ distribution with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_DistributionException} if it could not be found.
	 *
	 * @param ID the primary key of the legal_ distribution
	 * @return the legal_ distribution
	 * @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a legal_ distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution findByPrimaryKey(int ID)
		throws NoSuchLegal_DistributionException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the legal_ distribution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ distribution
	 * @return the legal_ distribution, or <code>null</code> if a legal_ distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Legal_Distribution legal_Distribution = (Legal_Distribution)EntityCacheUtil.getResult(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
				Legal_DistributionImpl.class, primaryKey);

		if (legal_Distribution == _nullLegal_Distribution) {
			return null;
		}

		if (legal_Distribution == null) {
			Session session = null;

			try {
				session = openSession();

				legal_Distribution = (Legal_Distribution)session.get(Legal_DistributionImpl.class,
						primaryKey);

				if (legal_Distribution != null) {
					cacheResult(legal_Distribution);
				}
				else {
					EntityCacheUtil.putResult(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
						Legal_DistributionImpl.class, primaryKey,
						_nullLegal_Distribution);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Legal_DistributionModelImpl.ENTITY_CACHE_ENABLED,
					Legal_DistributionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legal_Distribution;
	}

	/**
	 * Returns the legal_ distribution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the legal_ distribution
	 * @return the legal_ distribution, or <code>null</code> if a legal_ distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Distribution fetchByPrimaryKey(int ID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the legal_ distributions.
	 *
	 * @return the legal_ distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Distribution> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ distributions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ distributions
	 * @param end the upper bound of the range of legal_ distributions (not inclusive)
	 * @return the range of legal_ distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Distribution> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ distributions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ distributions
	 * @param end the upper bound of the range of legal_ distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal_ distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Distribution> findAll(int start, int end,
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

		List<Legal_Distribution> list = (List<Legal_Distribution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGAL_DISTRIBUTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGAL_DISTRIBUTION;

				if (pagination) {
					sql = sql.concat(Legal_DistributionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Legal_Distribution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Distribution>(list);
				}
				else {
					list = (List<Legal_Distribution>)QueryUtil.list(q,
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
	 * Removes all the legal_ distributions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Legal_Distribution legal_Distribution : findAll()) {
			remove(legal_Distribution);
		}
	}

	/**
	 * Returns the number of legal_ distributions.
	 *
	 * @return the number of legal_ distributions
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

				Query q = session.createQuery(_SQL_COUNT_LEGAL_DISTRIBUTION);

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
	 * Initializes the legal_ distribution persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.Legal_Distribution")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Legal_Distribution>> listenersList = new ArrayList<ModelListener<Legal_Distribution>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Legal_Distribution>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Legal_DistributionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGAL_DISTRIBUTION = "SELECT legal_Distribution FROM Legal_Distribution legal_Distribution";
	private static final String _SQL_SELECT_LEGAL_DISTRIBUTION_WHERE = "SELECT legal_Distribution FROM Legal_Distribution legal_Distribution WHERE ";
	private static final String _SQL_COUNT_LEGAL_DISTRIBUTION = "SELECT COUNT(legal_Distribution) FROM Legal_Distribution legal_Distribution";
	private static final String _SQL_COUNT_LEGAL_DISTRIBUTION_WHERE = "SELECT COUNT(legal_Distribution) FROM Legal_Distribution legal_Distribution WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legal_Distribution.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Legal_Distribution exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Legal_Distribution exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Legal_DistributionPersistenceImpl.class);
	private static Legal_Distribution _nullLegal_Distribution = new Legal_DistributionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Legal_Distribution> toCacheModel() {
				return _nullLegal_DistributionCacheModel;
			}
		};

	private static CacheModel<Legal_Distribution> _nullLegal_DistributionCacheModel =
		new CacheModel<Legal_Distribution>() {
			@Override
			public Legal_Distribution toEntityModel() {
				return _nullLegal_Distribution;
			}
		};
}