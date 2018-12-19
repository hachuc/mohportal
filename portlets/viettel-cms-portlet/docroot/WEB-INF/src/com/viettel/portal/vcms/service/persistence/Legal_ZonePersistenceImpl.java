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

import com.viettel.portal.vcms.NoSuchLegal_ZoneException;
import com.viettel.portal.vcms.model.Legal_Zone;
import com.viettel.portal.vcms.model.impl.Legal_ZoneImpl;
import com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legal_ zone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_ZonePersistence
 * @see Legal_ZoneUtil
 * @generated
 */
public class Legal_ZonePersistenceImpl extends BasePersistenceImpl<Legal_Zone>
	implements Legal_ZonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Legal_ZoneUtil} to access the legal_ zone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Legal_ZoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneModelImpl.FINDER_CACHE_ENABLED, Legal_ZoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneModelImpl.FINDER_CACHE_ENABLED, Legal_ZoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYVISIBLE =
		new FinderPath(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneModelImpl.FINDER_CACHE_ENABLED, Legal_ZoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyVisible",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYVISIBLE =
		new FinderPath(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneModelImpl.FINDER_CACHE_ENABLED, Legal_ZoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyVisible",
			new String[] { Boolean.class.getName() },
			Legal_ZoneModelImpl.VISIBLE_COLUMN_BITMASK |
			Legal_ZoneModelImpl.SORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYVISIBLE = new FinderPath(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyVisible",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the legal_ zones where Visible = &#63;.
	 *
	 * @param Visible the visible
	 * @return the matching legal_ zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Zone> findBybyVisible(boolean Visible)
		throws SystemException {
		return findBybyVisible(Visible, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal_ zones where Visible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param Visible the visible
	 * @param start the lower bound of the range of legal_ zones
	 * @param end the upper bound of the range of legal_ zones (not inclusive)
	 * @return the range of matching legal_ zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Zone> findBybyVisible(boolean Visible, int start, int end)
		throws SystemException {
		return findBybyVisible(Visible, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ zones where Visible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param Visible the visible
	 * @param start the lower bound of the range of legal_ zones
	 * @param end the upper bound of the range of legal_ zones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal_ zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Zone> findBybyVisible(boolean Visible, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYVISIBLE;
			finderArgs = new Object[] { Visible };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYVISIBLE;
			finderArgs = new Object[] { Visible, start, end, orderByComparator };
		}

		List<Legal_Zone> list = (List<Legal_Zone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Legal_Zone legal_Zone : list) {
				if ((Visible != legal_Zone.getVisible())) {
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

			query.append(_SQL_SELECT_LEGAL_ZONE_WHERE);

			query.append(_FINDER_COLUMN_BYVISIBLE_VISIBLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Legal_ZoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(Visible);

				if (!pagination) {
					list = (List<Legal_Zone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Zone>(list);
				}
				else {
					list = (List<Legal_Zone>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal_ zone in the ordered set where Visible = &#63;.
	 *
	 * @param Visible the visible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ zone
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a matching legal_ zone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone findBybyVisible_First(boolean Visible,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ZoneException, SystemException {
		Legal_Zone legal_Zone = fetchBybyVisible_First(Visible,
				orderByComparator);

		if (legal_Zone != null) {
			return legal_Zone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Visible=");
		msg.append(Visible);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_ZoneException(msg.toString());
	}

	/**
	 * Returns the first legal_ zone in the ordered set where Visible = &#63;.
	 *
	 * @param Visible the visible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ zone, or <code>null</code> if a matching legal_ zone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone fetchBybyVisible_First(boolean Visible,
		OrderByComparator orderByComparator) throws SystemException {
		List<Legal_Zone> list = findBybyVisible(Visible, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal_ zone in the ordered set where Visible = &#63;.
	 *
	 * @param Visible the visible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ zone
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a matching legal_ zone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone findBybyVisible_Last(boolean Visible,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ZoneException, SystemException {
		Legal_Zone legal_Zone = fetchBybyVisible_Last(Visible, orderByComparator);

		if (legal_Zone != null) {
			return legal_Zone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Visible=");
		msg.append(Visible);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_ZoneException(msg.toString());
	}

	/**
	 * Returns the last legal_ zone in the ordered set where Visible = &#63;.
	 *
	 * @param Visible the visible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ zone, or <code>null</code> if a matching legal_ zone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone fetchBybyVisible_Last(boolean Visible,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyVisible(Visible);

		if (count == 0) {
			return null;
		}

		List<Legal_Zone> list = findBybyVisible(Visible, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal_ zones before and after the current legal_ zone in the ordered set where Visible = &#63;.
	 *
	 * @param ID the primary key of the current legal_ zone
	 * @param Visible the visible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal_ zone
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a legal_ zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone[] findBybyVisible_PrevAndNext(int ID, boolean Visible,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ZoneException, SystemException {
		Legal_Zone legal_Zone = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			Legal_Zone[] array = new Legal_ZoneImpl[3];

			array[0] = getBybyVisible_PrevAndNext(session, legal_Zone, Visible,
					orderByComparator, true);

			array[1] = legal_Zone;

			array[2] = getBybyVisible_PrevAndNext(session, legal_Zone, Visible,
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

	protected Legal_Zone getBybyVisible_PrevAndNext(Session session,
		Legal_Zone legal_Zone, boolean Visible,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGAL_ZONE_WHERE);

		query.append(_FINDER_COLUMN_BYVISIBLE_VISIBLE_2);

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
			query.append(Legal_ZoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(Visible);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legal_Zone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Legal_Zone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal_ zones where Visible = &#63; from the database.
	 *
	 * @param Visible the visible
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyVisible(boolean Visible) throws SystemException {
		for (Legal_Zone legal_Zone : findBybyVisible(Visible,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legal_Zone);
		}
	}

	/**
	 * Returns the number of legal_ zones where Visible = &#63;.
	 *
	 * @param Visible the visible
	 * @return the number of matching legal_ zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyVisible(boolean Visible) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYVISIBLE;

		Object[] finderArgs = new Object[] { Visible };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGAL_ZONE_WHERE);

			query.append(_FINDER_COLUMN_BYVISIBLE_VISIBLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(Visible);

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

	private static final String _FINDER_COLUMN_BYVISIBLE_VISIBLE_2 = "legal_Zone.Visible = ?";

	public Legal_ZonePersistenceImpl() {
		setModelClass(Legal_Zone.class);
	}

	/**
	 * Caches the legal_ zone in the entity cache if it is enabled.
	 *
	 * @param legal_Zone the legal_ zone
	 */
	@Override
	public void cacheResult(Legal_Zone legal_Zone) {
		EntityCacheUtil.putResult(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneImpl.class, legal_Zone.getPrimaryKey(), legal_Zone);

		legal_Zone.resetOriginalValues();
	}

	/**
	 * Caches the legal_ zones in the entity cache if it is enabled.
	 *
	 * @param legal_Zones the legal_ zones
	 */
	@Override
	public void cacheResult(List<Legal_Zone> legal_Zones) {
		for (Legal_Zone legal_Zone : legal_Zones) {
			if (EntityCacheUtil.getResult(
						Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
						Legal_ZoneImpl.class, legal_Zone.getPrimaryKey()) == null) {
				cacheResult(legal_Zone);
			}
			else {
				legal_Zone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal_ zones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Legal_ZoneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Legal_ZoneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal_ zone.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Legal_Zone legal_Zone) {
		EntityCacheUtil.removeResult(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneImpl.class, legal_Zone.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Legal_Zone> legal_Zones) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Legal_Zone legal_Zone : legal_Zones) {
			EntityCacheUtil.removeResult(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
				Legal_ZoneImpl.class, legal_Zone.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legal_ zone with the primary key. Does not add the legal_ zone to the database.
	 *
	 * @param ID the primary key for the new legal_ zone
	 * @return the new legal_ zone
	 */
	@Override
	public Legal_Zone create(int ID) {
		Legal_Zone legal_Zone = new Legal_ZoneImpl();

		legal_Zone.setNew(true);
		legal_Zone.setPrimaryKey(ID);

		return legal_Zone;
	}

	/**
	 * Removes the legal_ zone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the legal_ zone
	 * @return the legal_ zone that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a legal_ zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone remove(int ID)
		throws NoSuchLegal_ZoneException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the legal_ zone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal_ zone
	 * @return the legal_ zone that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a legal_ zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone remove(Serializable primaryKey)
		throws NoSuchLegal_ZoneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Legal_Zone legal_Zone = (Legal_Zone)session.get(Legal_ZoneImpl.class,
					primaryKey);

			if (legal_Zone == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegal_ZoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legal_Zone);
		}
		catch (NoSuchLegal_ZoneException nsee) {
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
	protected Legal_Zone removeImpl(Legal_Zone legal_Zone)
		throws SystemException {
		legal_Zone = toUnwrappedModel(legal_Zone);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legal_Zone)) {
				legal_Zone = (Legal_Zone)session.get(Legal_ZoneImpl.class,
						legal_Zone.getPrimaryKeyObj());
			}

			if (legal_Zone != null) {
				session.delete(legal_Zone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legal_Zone != null) {
			clearCache(legal_Zone);
		}

		return legal_Zone;
	}

	@Override
	public Legal_Zone updateImpl(
		com.viettel.portal.vcms.model.Legal_Zone legal_Zone)
		throws SystemException {
		legal_Zone = toUnwrappedModel(legal_Zone);

		boolean isNew = legal_Zone.isNew();

		Legal_ZoneModelImpl legal_ZoneModelImpl = (Legal_ZoneModelImpl)legal_Zone;

		Session session = null;

		try {
			session = openSession();

			if (legal_Zone.isNew()) {
				session.save(legal_Zone);

				legal_Zone.setNew(false);
			}
			else {
				session.merge(legal_Zone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Legal_ZoneModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legal_ZoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYVISIBLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legal_ZoneModelImpl.getOriginalVisible()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYVISIBLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYVISIBLE,
					args);

				args = new Object[] { legal_ZoneModelImpl.getVisible() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYVISIBLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYVISIBLE,
					args);
			}
		}

		EntityCacheUtil.putResult(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ZoneImpl.class, legal_Zone.getPrimaryKey(), legal_Zone);

		return legal_Zone;
	}

	protected Legal_Zone toUnwrappedModel(Legal_Zone legal_Zone) {
		if (legal_Zone instanceof Legal_ZoneImpl) {
			return legal_Zone;
		}

		Legal_ZoneImpl legal_ZoneImpl = new Legal_ZoneImpl();

		legal_ZoneImpl.setNew(legal_Zone.isNew());
		legal_ZoneImpl.setPrimaryKey(legal_Zone.getPrimaryKey());

		legal_ZoneImpl.setID(legal_Zone.getID());
		legal_ZoneImpl.setCreationDate(legal_Zone.getCreationDate());
		legal_ZoneImpl.setModifiedDate(legal_Zone.getModifiedDate());
		legal_ZoneImpl.setName(legal_Zone.getName());
		legal_ZoneImpl.setUrl(legal_Zone.getUrl());
		legal_ZoneImpl.setDescription(legal_Zone.getDescription());
		legal_ZoneImpl.setParentID(legal_Zone.getParentID());
		legal_ZoneImpl.setRealUrl(legal_Zone.getRealUrl());
		legal_ZoneImpl.setVisible(legal_Zone.isVisible());
		legal_ZoneImpl.setArchived(legal_Zone.isArchived());
		legal_ZoneImpl.setSortOrder(legal_Zone.getSortOrder());

		return legal_ZoneImpl;
	}

	/**
	 * Returns the legal_ zone with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ zone
	 * @return the legal_ zone
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a legal_ zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegal_ZoneException, SystemException {
		Legal_Zone legal_Zone = fetchByPrimaryKey(primaryKey);

		if (legal_Zone == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegal_ZoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legal_Zone;
	}

	/**
	 * Returns the legal_ zone with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_ZoneException} if it could not be found.
	 *
	 * @param ID the primary key of the legal_ zone
	 * @return the legal_ zone
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a legal_ zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone findByPrimaryKey(int ID)
		throws NoSuchLegal_ZoneException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the legal_ zone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ zone
	 * @return the legal_ zone, or <code>null</code> if a legal_ zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Legal_Zone legal_Zone = (Legal_Zone)EntityCacheUtil.getResult(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
				Legal_ZoneImpl.class, primaryKey);

		if (legal_Zone == _nullLegal_Zone) {
			return null;
		}

		if (legal_Zone == null) {
			Session session = null;

			try {
				session = openSession();

				legal_Zone = (Legal_Zone)session.get(Legal_ZoneImpl.class,
						primaryKey);

				if (legal_Zone != null) {
					cacheResult(legal_Zone);
				}
				else {
					EntityCacheUtil.putResult(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
						Legal_ZoneImpl.class, primaryKey, _nullLegal_Zone);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Legal_ZoneModelImpl.ENTITY_CACHE_ENABLED,
					Legal_ZoneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legal_Zone;
	}

	/**
	 * Returns the legal_ zone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the legal_ zone
	 * @return the legal_ zone, or <code>null</code> if a legal_ zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Zone fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the legal_ zones.
	 *
	 * @return the legal_ zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Zone> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ zones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ zones
	 * @param end the upper bound of the range of legal_ zones (not inclusive)
	 * @return the range of legal_ zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Zone> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ zones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ zones
	 * @param end the upper bound of the range of legal_ zones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal_ zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Zone> findAll(int start, int end,
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

		List<Legal_Zone> list = (List<Legal_Zone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGAL_ZONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGAL_ZONE;

				if (pagination) {
					sql = sql.concat(Legal_ZoneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Legal_Zone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Zone>(list);
				}
				else {
					list = (List<Legal_Zone>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legal_ zones from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Legal_Zone legal_Zone : findAll()) {
			remove(legal_Zone);
		}
	}

	/**
	 * Returns the number of legal_ zones.
	 *
	 * @return the number of legal_ zones
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

				Query q = session.createQuery(_SQL_COUNT_LEGAL_ZONE);

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
	 * Initializes the legal_ zone persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.Legal_Zone")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Legal_Zone>> listenersList = new ArrayList<ModelListener<Legal_Zone>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Legal_Zone>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Legal_ZoneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGAL_ZONE = "SELECT legal_Zone FROM Legal_Zone legal_Zone";
	private static final String _SQL_SELECT_LEGAL_ZONE_WHERE = "SELECT legal_Zone FROM Legal_Zone legal_Zone WHERE ";
	private static final String _SQL_COUNT_LEGAL_ZONE = "SELECT COUNT(legal_Zone) FROM Legal_Zone legal_Zone";
	private static final String _SQL_COUNT_LEGAL_ZONE_WHERE = "SELECT COUNT(legal_Zone) FROM Legal_Zone legal_Zone WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legal_Zone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Legal_Zone exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Legal_Zone exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Legal_ZonePersistenceImpl.class);
	private static Legal_Zone _nullLegal_Zone = new Legal_ZoneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Legal_Zone> toCacheModel() {
				return _nullLegal_ZoneCacheModel;
			}
		};

	private static CacheModel<Legal_Zone> _nullLegal_ZoneCacheModel = new CacheModel<Legal_Zone>() {
			@Override
			public Legal_Zone toEntityModel() {
				return _nullLegal_Zone;
			}
		};
}