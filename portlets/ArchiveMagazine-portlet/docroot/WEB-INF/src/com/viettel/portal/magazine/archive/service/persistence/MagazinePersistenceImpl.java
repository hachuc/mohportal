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

package com.viettel.portal.magazine.archive.service.persistence;

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

import com.viettel.portal.magazine.archive.NoSuchMagazineException;
import com.viettel.portal.magazine.archive.model.Magazine;
import com.viettel.portal.magazine.archive.model.impl.MagazineImpl;
import com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the magazine service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see MagazinePersistence
 * @see MagazineUtil
 * @generated
 */
public class MagazinePersistenceImpl extends BasePersistenceImpl<Magazine>
	implements MagazinePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MagazineUtil} to access the magazine persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MagazineImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineModelImpl.FINDER_CACHE_ENABLED, MagazineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineModelImpl.FINDER_CACHE_ENABLED, MagazineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHNUMBERANDYEAR =
		new FinderPath(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineModelImpl.FINDER_CACHE_ENABLED, MagazineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishNumberAndYear",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHNUMBERANDYEAR =
		new FinderPath(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineModelImpl.FINDER_CACHE_ENABLED, MagazineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishNumberAndYear",
			new String[] { Integer.class.getName() },
			MagazineModelImpl.PUBLISHYEAR_COLUMN_BITMASK |
			MagazineModelImpl.PUBLISHMONTH_COLUMN_BITMASK |
			MagazineModelImpl.PUBLISHNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHNUMBERANDYEAR = new FinderPath(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishNumberAndYear",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the magazines where PublishYear = &#63;.
	 *
	 * @param PublishYear the publish year
	 * @return the matching magazines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Magazine> findByPublishNumberAndYear(int PublishYear)
		throws SystemException {
		return findByPublishNumberAndYear(PublishYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the magazines where PublishYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PublishYear the publish year
	 * @param start the lower bound of the range of magazines
	 * @param end the upper bound of the range of magazines (not inclusive)
	 * @return the range of matching magazines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Magazine> findByPublishNumberAndYear(int PublishYear,
		int start, int end) throws SystemException {
		return findByPublishNumberAndYear(PublishYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the magazines where PublishYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PublishYear the publish year
	 * @param start the lower bound of the range of magazines
	 * @param end the upper bound of the range of magazines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching magazines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Magazine> findByPublishNumberAndYear(int PublishYear,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHNUMBERANDYEAR;
			finderArgs = new Object[] { PublishYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHNUMBERANDYEAR;
			finderArgs = new Object[] { PublishYear, start, end, orderByComparator };
		}

		List<Magazine> list = (List<Magazine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Magazine magazine : list) {
				if ((PublishYear != magazine.getPublishYear())) {
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

			query.append(_SQL_SELECT_MAGAZINE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHNUMBERANDYEAR_PUBLISHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MagazineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PublishYear);

				if (!pagination) {
					list = (List<Magazine>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Magazine>(list);
				}
				else {
					list = (List<Magazine>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first magazine in the ordered set where PublishYear = &#63;.
	 *
	 * @param PublishYear the publish year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine
	 * @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a matching magazine could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine findByPublishNumberAndYear_First(int PublishYear,
		OrderByComparator orderByComparator)
		throws NoSuchMagazineException, SystemException {
		Magazine magazine = fetchByPublishNumberAndYear_First(PublishYear,
				orderByComparator);

		if (magazine != null) {
			return magazine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PublishYear=");
		msg.append(PublishYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMagazineException(msg.toString());
	}

	/**
	 * Returns the first magazine in the ordered set where PublishYear = &#63;.
	 *
	 * @param PublishYear the publish year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine, or <code>null</code> if a matching magazine could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine fetchByPublishNumberAndYear_First(int PublishYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<Magazine> list = findByPublishNumberAndYear(PublishYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last magazine in the ordered set where PublishYear = &#63;.
	 *
	 * @param PublishYear the publish year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine
	 * @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a matching magazine could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine findByPublishNumberAndYear_Last(int PublishYear,
		OrderByComparator orderByComparator)
		throws NoSuchMagazineException, SystemException {
		Magazine magazine = fetchByPublishNumberAndYear_Last(PublishYear,
				orderByComparator);

		if (magazine != null) {
			return magazine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PublishYear=");
		msg.append(PublishYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMagazineException(msg.toString());
	}

	/**
	 * Returns the last magazine in the ordered set where PublishYear = &#63;.
	 *
	 * @param PublishYear the publish year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine, or <code>null</code> if a matching magazine could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine fetchByPublishNumberAndYear_Last(int PublishYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishNumberAndYear(PublishYear);

		if (count == 0) {
			return null;
		}

		List<Magazine> list = findByPublishNumberAndYear(PublishYear,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the magazines before and after the current magazine in the ordered set where PublishYear = &#63;.
	 *
	 * @param ID the primary key of the current magazine
	 * @param PublishYear the publish year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next magazine
	 * @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine[] findByPublishNumberAndYear_PrevAndNext(int ID,
		int PublishYear, OrderByComparator orderByComparator)
		throws NoSuchMagazineException, SystemException {
		Magazine magazine = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			Magazine[] array = new MagazineImpl[3];

			array[0] = getByPublishNumberAndYear_PrevAndNext(session, magazine,
					PublishYear, orderByComparator, true);

			array[1] = magazine;

			array[2] = getByPublishNumberAndYear_PrevAndNext(session, magazine,
					PublishYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Magazine getByPublishNumberAndYear_PrevAndNext(Session session,
		Magazine magazine, int PublishYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MAGAZINE_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHNUMBERANDYEAR_PUBLISHYEAR_2);

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
			query.append(MagazineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PublishYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(magazine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Magazine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the magazines where PublishYear = &#63; from the database.
	 *
	 * @param PublishYear the publish year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishNumberAndYear(int PublishYear)
		throws SystemException {
		for (Magazine magazine : findByPublishNumberAndYear(PublishYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(magazine);
		}
	}

	/**
	 * Returns the number of magazines where PublishYear = &#63;.
	 *
	 * @param PublishYear the publish year
	 * @return the number of matching magazines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishNumberAndYear(int PublishYear)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHNUMBERANDYEAR;

		Object[] finderArgs = new Object[] { PublishYear };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MAGAZINE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHNUMBERANDYEAR_PUBLISHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PublishYear);

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

	private static final String _FINDER_COLUMN_PUBLISHNUMBERANDYEAR_PUBLISHYEAR_2 =
		"magazine.PublishYear = ?";

	public MagazinePersistenceImpl() {
		setModelClass(Magazine.class);
	}

	/**
	 * Caches the magazine in the entity cache if it is enabled.
	 *
	 * @param magazine the magazine
	 */
	@Override
	public void cacheResult(Magazine magazine) {
		EntityCacheUtil.putResult(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineImpl.class, magazine.getPrimaryKey(), magazine);

		magazine.resetOriginalValues();
	}

	/**
	 * Caches the magazines in the entity cache if it is enabled.
	 *
	 * @param magazines the magazines
	 */
	@Override
	public void cacheResult(List<Magazine> magazines) {
		for (Magazine magazine : magazines) {
			if (EntityCacheUtil.getResult(
						MagazineModelImpl.ENTITY_CACHE_ENABLED,
						MagazineImpl.class, magazine.getPrimaryKey()) == null) {
				cacheResult(magazine);
			}
			else {
				magazine.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all magazines.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MagazineImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MagazineImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the magazine.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Magazine magazine) {
		EntityCacheUtil.removeResult(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineImpl.class, magazine.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Magazine> magazines) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Magazine magazine : magazines) {
			EntityCacheUtil.removeResult(MagazineModelImpl.ENTITY_CACHE_ENABLED,
				MagazineImpl.class, magazine.getPrimaryKey());
		}
	}

	/**
	 * Creates a new magazine with the primary key. Does not add the magazine to the database.
	 *
	 * @param ID the primary key for the new magazine
	 * @return the new magazine
	 */
	@Override
	public Magazine create(int ID) {
		Magazine magazine = new MagazineImpl();

		magazine.setNew(true);
		magazine.setPrimaryKey(ID);

		return magazine;
	}

	/**
	 * Removes the magazine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the magazine
	 * @return the magazine that was removed
	 * @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine remove(int ID)
		throws NoSuchMagazineException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the magazine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the magazine
	 * @return the magazine that was removed
	 * @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine remove(Serializable primaryKey)
		throws NoSuchMagazineException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Magazine magazine = (Magazine)session.get(MagazineImpl.class,
					primaryKey);

			if (magazine == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMagazineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(magazine);
		}
		catch (NoSuchMagazineException nsee) {
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
	protected Magazine removeImpl(Magazine magazine) throws SystemException {
		magazine = toUnwrappedModel(magazine);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(magazine)) {
				magazine = (Magazine)session.get(MagazineImpl.class,
						magazine.getPrimaryKeyObj());
			}

			if (magazine != null) {
				session.delete(magazine);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (magazine != null) {
			clearCache(magazine);
		}

		return magazine;
	}

	@Override
	public Magazine updateImpl(
		com.viettel.portal.magazine.archive.model.Magazine magazine)
		throws SystemException {
		magazine = toUnwrappedModel(magazine);

		boolean isNew = magazine.isNew();

		MagazineModelImpl magazineModelImpl = (MagazineModelImpl)magazine;

		Session session = null;

		try {
			session = openSession();

			if (magazine.isNew()) {
				session.save(magazine);

				magazine.setNew(false);
			}
			else {
				session.merge(magazine);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MagazineModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((magazineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHNUMBERANDYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						magazineModelImpl.getOriginalPublishYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHNUMBERANDYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHNUMBERANDYEAR,
					args);

				args = new Object[] { magazineModelImpl.getPublishYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHNUMBERANDYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHNUMBERANDYEAR,
					args);
			}
		}

		EntityCacheUtil.putResult(MagazineModelImpl.ENTITY_CACHE_ENABLED,
			MagazineImpl.class, magazine.getPrimaryKey(), magazine);

		return magazine;
	}

	protected Magazine toUnwrappedModel(Magazine magazine) {
		if (magazine instanceof MagazineImpl) {
			return magazine;
		}

		MagazineImpl magazineImpl = new MagazineImpl();

		magazineImpl.setNew(magazine.isNew());
		magazineImpl.setPrimaryKey(magazine.getPrimaryKey());

		magazineImpl.setID(magazine.getID());
		magazineImpl.setName(magazine.getName());
		magazineImpl.setPublishNumber(magazine.getPublishNumber());
		magazineImpl.setPublishMonth(magazine.getPublishMonth());
		magazineImpl.setPublishYear(magazine.getPublishYear());
		magazineImpl.setImageUrl(magazine.getImageUrl());
		magazineImpl.setMagazineType(magazine.getMagazineType());

		return magazineImpl;
	}

	/**
	 * Returns the magazine with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the magazine
	 * @return the magazine
	 * @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMagazineException, SystemException {
		Magazine magazine = fetchByPrimaryKey(primaryKey);

		if (magazine == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMagazineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return magazine;
	}

	/**
	 * Returns the magazine with the primary key or throws a {@link com.viettel.portal.magazine.archive.NoSuchMagazineException} if it could not be found.
	 *
	 * @param ID the primary key of the magazine
	 * @return the magazine
	 * @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine findByPrimaryKey(int ID)
		throws NoSuchMagazineException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the magazine with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the magazine
	 * @return the magazine, or <code>null</code> if a magazine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Magazine magazine = (Magazine)EntityCacheUtil.getResult(MagazineModelImpl.ENTITY_CACHE_ENABLED,
				MagazineImpl.class, primaryKey);

		if (magazine == _nullMagazine) {
			return null;
		}

		if (magazine == null) {
			Session session = null;

			try {
				session = openSession();

				magazine = (Magazine)session.get(MagazineImpl.class, primaryKey);

				if (magazine != null) {
					cacheResult(magazine);
				}
				else {
					EntityCacheUtil.putResult(MagazineModelImpl.ENTITY_CACHE_ENABLED,
						MagazineImpl.class, primaryKey, _nullMagazine);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MagazineModelImpl.ENTITY_CACHE_ENABLED,
					MagazineImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return magazine;
	}

	/**
	 * Returns the magazine with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the magazine
	 * @return the magazine, or <code>null</code> if a magazine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Magazine fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the magazines.
	 *
	 * @return the magazines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Magazine> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of magazines
	 * @param end the upper bound of the range of magazines (not inclusive)
	 * @return the range of magazines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Magazine> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of magazines
	 * @param end the upper bound of the range of magazines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of magazines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Magazine> findAll(int start, int end,
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

		List<Magazine> list = (List<Magazine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MAGAZINE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAGAZINE;

				if (pagination) {
					sql = sql.concat(MagazineModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Magazine>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Magazine>(list);
				}
				else {
					list = (List<Magazine>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the magazines from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Magazine magazine : findAll()) {
			remove(magazine);
		}
	}

	/**
	 * Returns the number of magazines.
	 *
	 * @return the number of magazines
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

				Query q = session.createQuery(_SQL_COUNT_MAGAZINE);

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
	 * Initializes the magazine persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.magazine.archive.model.Magazine")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Magazine>> listenersList = new ArrayList<ModelListener<Magazine>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Magazine>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MagazineImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MAGAZINE = "SELECT magazine FROM Magazine magazine";
	private static final String _SQL_SELECT_MAGAZINE_WHERE = "SELECT magazine FROM Magazine magazine WHERE ";
	private static final String _SQL_COUNT_MAGAZINE = "SELECT COUNT(magazine) FROM Magazine magazine";
	private static final String _SQL_COUNT_MAGAZINE_WHERE = "SELECT COUNT(magazine) FROM Magazine magazine WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "magazine.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Magazine exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Magazine exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MagazinePersistenceImpl.class);
	private static Magazine _nullMagazine = new MagazineImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Magazine> toCacheModel() {
				return _nullMagazineCacheModel;
			}
		};

	private static CacheModel<Magazine> _nullMagazineCacheModel = new CacheModel<Magazine>() {
			@Override
			public Magazine toEntityModel() {
				return _nullMagazine;
			}
		};
}