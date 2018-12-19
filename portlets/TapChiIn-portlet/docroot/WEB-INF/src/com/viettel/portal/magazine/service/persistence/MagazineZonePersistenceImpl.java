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

package com.viettel.portal.magazine.service.persistence;

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

import com.viettel.portal.magazine.NoSuchZoneException;
import com.viettel.portal.magazine.model.MagazineZone;
import com.viettel.portal.magazine.model.impl.MagazineZoneImpl;
import com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the magazine zone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see MagazineZonePersistence
 * @see MagazineZoneUtil
 * @generated
 */
public class MagazineZonePersistenceImpl extends BasePersistenceImpl<MagazineZone>
	implements MagazineZonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MagazineZoneUtil} to access the magazine zone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MagazineZoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneModelImpl.FINDER_CACHE_ENABLED, MagazineZoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneModelImpl.FINDER_CACHE_ENABLED, MagazineZoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINEID =
		new FinderPath(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneModelImpl.FINDER_CACHE_ENABLED, MagazineZoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMagazineID",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID =
		new FinderPath(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneModelImpl.FINDER_CACHE_ENABLED, MagazineZoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMagazineID",
			new String[] { Integer.class.getName() },
			MagazineZoneModelImpl.MAGAZINEID_COLUMN_BITMASK |
			MagazineZoneModelImpl.SORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAGAZINEID = new FinderPath(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMagazineID",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the magazine zones where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @return the matching magazine zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineZone> findByMagazineID(int MagazineID)
		throws SystemException {
		return findByMagazineID(MagazineID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the magazine zones where MagazineID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param start the lower bound of the range of magazine zones
	 * @param end the upper bound of the range of magazine zones (not inclusive)
	 * @return the range of matching magazine zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineZone> findByMagazineID(int MagazineID, int start,
		int end) throws SystemException {
		return findByMagazineID(MagazineID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the magazine zones where MagazineID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param start the lower bound of the range of magazine zones
	 * @param end the upper bound of the range of magazine zones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching magazine zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineZone> findByMagazineID(int MagazineID, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID;
			finderArgs = new Object[] { MagazineID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINEID;
			finderArgs = new Object[] { MagazineID, start, end, orderByComparator };
		}

		List<MagazineZone> list = (List<MagazineZone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MagazineZone magazineZone : list) {
				if ((MagazineID != magazineZone.getMagazineID())) {
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

			query.append(_SQL_SELECT_MAGAZINEZONE_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINEID_MAGAZINEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MagazineZoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineID);

				if (!pagination) {
					list = (List<MagazineZone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MagazineZone>(list);
				}
				else {
					list = (List<MagazineZone>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first magazine zone in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine zone
	 * @throws com.viettel.portal.magazine.NoSuchZoneException if a matching magazine zone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone findByMagazineID_First(int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchZoneException, SystemException {
		MagazineZone magazineZone = fetchByMagazineID_First(MagazineID,
				orderByComparator);

		if (magazineZone != null) {
			return magazineZone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineID=");
		msg.append(MagazineID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchZoneException(msg.toString());
	}

	/**
	 * Returns the first magazine zone in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine zone, or <code>null</code> if a matching magazine zone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone fetchByMagazineID_First(int MagazineID,
		OrderByComparator orderByComparator) throws SystemException {
		List<MagazineZone> list = findByMagazineID(MagazineID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last magazine zone in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine zone
	 * @throws com.viettel.portal.magazine.NoSuchZoneException if a matching magazine zone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone findByMagazineID_Last(int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchZoneException, SystemException {
		MagazineZone magazineZone = fetchByMagazineID_Last(MagazineID,
				orderByComparator);

		if (magazineZone != null) {
			return magazineZone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineID=");
		msg.append(MagazineID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchZoneException(msg.toString());
	}

	/**
	 * Returns the last magazine zone in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine zone, or <code>null</code> if a matching magazine zone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone fetchByMagazineID_Last(int MagazineID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMagazineID(MagazineID);

		if (count == 0) {
			return null;
		}

		List<MagazineZone> list = findByMagazineID(MagazineID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the magazine zones before and after the current magazine zone in the ordered set where MagazineID = &#63;.
	 *
	 * @param ID the primary key of the current magazine zone
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next magazine zone
	 * @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone[] findByMagazineID_PrevAndNext(int ID, int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchZoneException, SystemException {
		MagazineZone magazineZone = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			MagazineZone[] array = new MagazineZoneImpl[3];

			array[0] = getByMagazineID_PrevAndNext(session, magazineZone,
					MagazineID, orderByComparator, true);

			array[1] = magazineZone;

			array[2] = getByMagazineID_PrevAndNext(session, magazineZone,
					MagazineID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MagazineZone getByMagazineID_PrevAndNext(Session session,
		MagazineZone magazineZone, int MagazineID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MAGAZINEZONE_WHERE);

		query.append(_FINDER_COLUMN_MAGAZINEID_MAGAZINEID_2);

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
			query.append(MagazineZoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(MagazineID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(magazineZone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MagazineZone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the magazine zones where MagazineID = &#63; from the database.
	 *
	 * @param MagazineID the magazine i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMagazineID(int MagazineID) throws SystemException {
		for (MagazineZone magazineZone : findByMagazineID(MagazineID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(magazineZone);
		}
	}

	/**
	 * Returns the number of magazine zones where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @return the number of matching magazine zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMagazineID(int MagazineID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAGAZINEID;

		Object[] finderArgs = new Object[] { MagazineID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MAGAZINEZONE_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINEID_MAGAZINEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineID);

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

	private static final String _FINDER_COLUMN_MAGAZINEID_MAGAZINEID_2 = "magazineZone.MagazineID = ?";

	public MagazineZonePersistenceImpl() {
		setModelClass(MagazineZone.class);
	}

	/**
	 * Caches the magazine zone in the entity cache if it is enabled.
	 *
	 * @param magazineZone the magazine zone
	 */
	@Override
	public void cacheResult(MagazineZone magazineZone) {
		EntityCacheUtil.putResult(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneImpl.class, magazineZone.getPrimaryKey(), magazineZone);

		magazineZone.resetOriginalValues();
	}

	/**
	 * Caches the magazine zones in the entity cache if it is enabled.
	 *
	 * @param magazineZones the magazine zones
	 */
	@Override
	public void cacheResult(List<MagazineZone> magazineZones) {
		for (MagazineZone magazineZone : magazineZones) {
			if (EntityCacheUtil.getResult(
						MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
						MagazineZoneImpl.class, magazineZone.getPrimaryKey()) == null) {
				cacheResult(magazineZone);
			}
			else {
				magazineZone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all magazine zones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MagazineZoneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MagazineZoneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the magazine zone.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MagazineZone magazineZone) {
		EntityCacheUtil.removeResult(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneImpl.class, magazineZone.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MagazineZone> magazineZones) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MagazineZone magazineZone : magazineZones) {
			EntityCacheUtil.removeResult(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
				MagazineZoneImpl.class, magazineZone.getPrimaryKey());
		}
	}

	/**
	 * Creates a new magazine zone with the primary key. Does not add the magazine zone to the database.
	 *
	 * @param ID the primary key for the new magazine zone
	 * @return the new magazine zone
	 */
	@Override
	public MagazineZone create(int ID) {
		MagazineZone magazineZone = new MagazineZoneImpl();

		magazineZone.setNew(true);
		magazineZone.setPrimaryKey(ID);

		return magazineZone;
	}

	/**
	 * Removes the magazine zone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the magazine zone
	 * @return the magazine zone that was removed
	 * @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone remove(int ID)
		throws NoSuchZoneException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the magazine zone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the magazine zone
	 * @return the magazine zone that was removed
	 * @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone remove(Serializable primaryKey)
		throws NoSuchZoneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MagazineZone magazineZone = (MagazineZone)session.get(MagazineZoneImpl.class,
					primaryKey);

			if (magazineZone == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchZoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(magazineZone);
		}
		catch (NoSuchZoneException nsee) {
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
	protected MagazineZone removeImpl(MagazineZone magazineZone)
		throws SystemException {
		magazineZone = toUnwrappedModel(magazineZone);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(magazineZone)) {
				magazineZone = (MagazineZone)session.get(MagazineZoneImpl.class,
						magazineZone.getPrimaryKeyObj());
			}

			if (magazineZone != null) {
				session.delete(magazineZone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (magazineZone != null) {
			clearCache(magazineZone);
		}

		return magazineZone;
	}

	@Override
	public MagazineZone updateImpl(
		com.viettel.portal.magazine.model.MagazineZone magazineZone)
		throws SystemException {
		magazineZone = toUnwrappedModel(magazineZone);

		boolean isNew = magazineZone.isNew();

		MagazineZoneModelImpl magazineZoneModelImpl = (MagazineZoneModelImpl)magazineZone;

		Session session = null;

		try {
			session = openSession();

			if (magazineZone.isNew()) {
				session.save(magazineZone);

				magazineZone.setNew(false);
			}
			else {
				session.merge(magazineZone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MagazineZoneModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((magazineZoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						magazineZoneModelImpl.getOriginalMagazineID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID,
					args);

				args = new Object[] { magazineZoneModelImpl.getMagazineID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID,
					args);
			}
		}

		EntityCacheUtil.putResult(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
			MagazineZoneImpl.class, magazineZone.getPrimaryKey(), magazineZone);

		return magazineZone;
	}

	protected MagazineZone toUnwrappedModel(MagazineZone magazineZone) {
		if (magazineZone instanceof MagazineZoneImpl) {
			return magazineZone;
		}

		MagazineZoneImpl magazineZoneImpl = new MagazineZoneImpl();

		magazineZoneImpl.setNew(magazineZone.isNew());
		magazineZoneImpl.setPrimaryKey(magazineZone.getPrimaryKey());

		magazineZoneImpl.setID(magazineZone.getID());
		magazineZoneImpl.setName(magazineZone.getName());
		magazineZoneImpl.setMagazineID(magazineZone.getMagazineID());
		magazineZoneImpl.setSortOrder(magazineZone.getSortOrder());

		return magazineZoneImpl;
	}

	/**
	 * Returns the magazine zone with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the magazine zone
	 * @return the magazine zone
	 * @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchZoneException, SystemException {
		MagazineZone magazineZone = fetchByPrimaryKey(primaryKey);

		if (magazineZone == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchZoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return magazineZone;
	}

	/**
	 * Returns the magazine zone with the primary key or throws a {@link com.viettel.portal.magazine.NoSuchZoneException} if it could not be found.
	 *
	 * @param ID the primary key of the magazine zone
	 * @return the magazine zone
	 * @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone findByPrimaryKey(int ID)
		throws NoSuchZoneException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the magazine zone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the magazine zone
	 * @return the magazine zone, or <code>null</code> if a magazine zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MagazineZone magazineZone = (MagazineZone)EntityCacheUtil.getResult(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
				MagazineZoneImpl.class, primaryKey);

		if (magazineZone == _nullMagazineZone) {
			return null;
		}

		if (magazineZone == null) {
			Session session = null;

			try {
				session = openSession();

				magazineZone = (MagazineZone)session.get(MagazineZoneImpl.class,
						primaryKey);

				if (magazineZone != null) {
					cacheResult(magazineZone);
				}
				else {
					EntityCacheUtil.putResult(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
						MagazineZoneImpl.class, primaryKey, _nullMagazineZone);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MagazineZoneModelImpl.ENTITY_CACHE_ENABLED,
					MagazineZoneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return magazineZone;
	}

	/**
	 * Returns the magazine zone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the magazine zone
	 * @return the magazine zone, or <code>null</code> if a magazine zone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineZone fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the magazine zones.
	 *
	 * @return the magazine zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineZone> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the magazine zones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of magazine zones
	 * @param end the upper bound of the range of magazine zones (not inclusive)
	 * @return the range of magazine zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineZone> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the magazine zones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of magazine zones
	 * @param end the upper bound of the range of magazine zones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of magazine zones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineZone> findAll(int start, int end,
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

		List<MagazineZone> list = (List<MagazineZone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MAGAZINEZONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAGAZINEZONE;

				if (pagination) {
					sql = sql.concat(MagazineZoneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MagazineZone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MagazineZone>(list);
				}
				else {
					list = (List<MagazineZone>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the magazine zones from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MagazineZone magazineZone : findAll()) {
			remove(magazineZone);
		}
	}

	/**
	 * Returns the number of magazine zones.
	 *
	 * @return the number of magazine zones
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

				Query q = session.createQuery(_SQL_COUNT_MAGAZINEZONE);

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
	 * Initializes the magazine zone persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.magazine.model.MagazineZone")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MagazineZone>> listenersList = new ArrayList<ModelListener<MagazineZone>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MagazineZone>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MagazineZoneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MAGAZINEZONE = "SELECT magazineZone FROM MagazineZone magazineZone";
	private static final String _SQL_SELECT_MAGAZINEZONE_WHERE = "SELECT magazineZone FROM MagazineZone magazineZone WHERE ";
	private static final String _SQL_COUNT_MAGAZINEZONE = "SELECT COUNT(magazineZone) FROM MagazineZone magazineZone";
	private static final String _SQL_COUNT_MAGAZINEZONE_WHERE = "SELECT COUNT(magazineZone) FROM MagazineZone magazineZone WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "magazineZone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MagazineZone exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MagazineZone exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MagazineZonePersistenceImpl.class);
	private static MagazineZone _nullMagazineZone = new MagazineZoneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MagazineZone> toCacheModel() {
				return _nullMagazineZoneCacheModel;
			}
		};

	private static CacheModel<MagazineZone> _nullMagazineZoneCacheModel = new CacheModel<MagazineZone>() {
			@Override
			public MagazineZone toEntityModel() {
				return _nullMagazineZone;
			}
		};
}