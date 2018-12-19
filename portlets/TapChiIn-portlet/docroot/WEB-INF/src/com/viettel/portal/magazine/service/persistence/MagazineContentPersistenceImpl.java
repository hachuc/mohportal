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

import com.viettel.portal.magazine.NoSuchContentException;
import com.viettel.portal.magazine.model.MagazineContent;
import com.viettel.portal.magazine.model.impl.MagazineContentImpl;
import com.viettel.portal.magazine.model.impl.MagazineContentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the magazine content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see MagazineContentPersistence
 * @see MagazineContentUtil
 * @generated
 */
public class MagazineContentPersistenceImpl extends BasePersistenceImpl<MagazineContent>
	implements MagazineContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MagazineContentUtil} to access the magazine content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MagazineContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED,
			MagazineContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED,
			MagazineContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINEANDZONE =
		new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED,
			MagazineContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMagazineAndZone",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEANDZONE =
		new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED,
			MagazineContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMagazineAndZone",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			MagazineContentModelImpl.MAGAZINEID_COLUMN_BITMASK |
			MagazineContentModelImpl.MAGAZINEZONEID_COLUMN_BITMASK |
			MagazineContentModelImpl.SORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAGAZINEANDZONE = new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMagazineAndZone",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the magazine contents where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @return the matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineAndZone(int MagazineID,
		int MagazineZoneID) throws SystemException {
		return findByMagazineAndZone(MagazineID, MagazineZoneID,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the magazine contents where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @param start the lower bound of the range of magazine contents
	 * @param end the upper bound of the range of magazine contents (not inclusive)
	 * @return the range of matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineAndZone(int MagazineID,
		int MagazineZoneID, int start, int end) throws SystemException {
		return findByMagazineAndZone(MagazineID, MagazineZoneID, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the magazine contents where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @param start the lower bound of the range of magazine contents
	 * @param end the upper bound of the range of magazine contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineAndZone(int MagazineID,
		int MagazineZoneID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEANDZONE;
			finderArgs = new Object[] { MagazineID, MagazineZoneID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINEANDZONE;
			finderArgs = new Object[] {
					MagazineID, MagazineZoneID,
					
					start, end, orderByComparator
				};
		}

		List<MagazineContent> list = (List<MagazineContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MagazineContent magazineContent : list) {
				if ((MagazineID != magazineContent.getMagazineID()) ||
						(MagazineZoneID != magazineContent.getMagazineZoneID())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MAGAZINECONTENT_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINEANDZONE_MAGAZINEID_2);

			query.append(_FINDER_COLUMN_MAGAZINEANDZONE_MAGAZINEZONEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MagazineContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineID);

				qPos.add(MagazineZoneID);

				if (!pagination) {
					list = (List<MagazineContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MagazineContent>(list);
				}
				else {
					list = (List<MagazineContent>)QueryUtil.list(q,
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
	 * Returns the first magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent findByMagazineAndZone_First(int MagazineID,
		int MagazineZoneID, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = fetchByMagazineAndZone_First(MagazineID,
				MagazineZoneID, orderByComparator);

		if (magazineContent != null) {
			return magazineContent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineID=");
		msg.append(MagazineID);

		msg.append(", MagazineZoneID=");
		msg.append(MagazineZoneID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine content, or <code>null</code> if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent fetchByMagazineAndZone_First(int MagazineID,
		int MagazineZoneID, OrderByComparator orderByComparator)
		throws SystemException {
		List<MagazineContent> list = findByMagazineAndZone(MagazineID,
				MagazineZoneID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent findByMagazineAndZone_Last(int MagazineID,
		int MagazineZoneID, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = fetchByMagazineAndZone_Last(MagazineID,
				MagazineZoneID, orderByComparator);

		if (magazineContent != null) {
			return magazineContent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineID=");
		msg.append(MagazineID);

		msg.append(", MagazineZoneID=");
		msg.append(MagazineZoneID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine content, or <code>null</code> if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent fetchByMagazineAndZone_Last(int MagazineID,
		int MagazineZoneID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMagazineAndZone(MagazineID, MagazineZoneID);

		if (count == 0) {
			return null;
		}

		List<MagazineContent> list = findByMagazineAndZone(MagazineID,
				MagazineZoneID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the magazine contents before and after the current magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * @param ID the primary key of the current magazine content
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent[] findByMagazineAndZone_PrevAndNext(int ID,
		int MagazineID, int MagazineZoneID, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			MagazineContent[] array = new MagazineContentImpl[3];

			array[0] = getByMagazineAndZone_PrevAndNext(session,
					magazineContent, MagazineID, MagazineZoneID,
					orderByComparator, true);

			array[1] = magazineContent;

			array[2] = getByMagazineAndZone_PrevAndNext(session,
					magazineContent, MagazineID, MagazineZoneID,
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

	protected MagazineContent getByMagazineAndZone_PrevAndNext(
		Session session, MagazineContent magazineContent, int MagazineID,
		int MagazineZoneID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MAGAZINECONTENT_WHERE);

		query.append(_FINDER_COLUMN_MAGAZINEANDZONE_MAGAZINEID_2);

		query.append(_FINDER_COLUMN_MAGAZINEANDZONE_MAGAZINEZONEID_2);

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
			query.append(MagazineContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(MagazineID);

		qPos.add(MagazineZoneID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(magazineContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MagazineContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the magazine contents where MagazineID = &#63; and MagazineZoneID = &#63; from the database.
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMagazineAndZone(int MagazineID, int MagazineZoneID)
		throws SystemException {
		for (MagazineContent magazineContent : findByMagazineAndZone(
				MagazineID, MagazineZoneID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(magazineContent);
		}
	}

	/**
	 * Returns the number of magazine contents where MagazineID = &#63; and MagazineZoneID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param MagazineZoneID the magazine zone i d
	 * @return the number of matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMagazineAndZone(int MagazineID, int MagazineZoneID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAGAZINEANDZONE;

		Object[] finderArgs = new Object[] { MagazineID, MagazineZoneID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MAGAZINECONTENT_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINEANDZONE_MAGAZINEID_2);

			query.append(_FINDER_COLUMN_MAGAZINEANDZONE_MAGAZINEZONEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineID);

				qPos.add(MagazineZoneID);

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

	private static final String _FINDER_COLUMN_MAGAZINEANDZONE_MAGAZINEID_2 = "magazineContent.MagazineID = ? AND ";
	private static final String _FINDER_COLUMN_MAGAZINEANDZONE_MAGAZINEZONEID_2 = "magazineContent.MagazineZoneID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINEID =
		new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED,
			MagazineContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMagazineID",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID =
		new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED,
			MagazineContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMagazineID",
			new String[] { Integer.class.getName() },
			MagazineContentModelImpl.MAGAZINEID_COLUMN_BITMASK |
			MagazineContentModelImpl.SORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAGAZINEID = new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMagazineID",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the magazine contents where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @return the matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineID(int MagazineID)
		throws SystemException {
		return findByMagazineID(MagazineID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the magazine contents where MagazineID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param start the lower bound of the range of magazine contents
	 * @param end the upper bound of the range of magazine contents (not inclusive)
	 * @return the range of matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineID(int MagazineID, int start,
		int end) throws SystemException {
		return findByMagazineID(MagazineID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the magazine contents where MagazineID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param start the lower bound of the range of magazine contents
	 * @param end the upper bound of the range of magazine contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineID(int MagazineID, int start,
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

		List<MagazineContent> list = (List<MagazineContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MagazineContent magazineContent : list) {
				if ((MagazineID != magazineContent.getMagazineID())) {
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

			query.append(_SQL_SELECT_MAGAZINECONTENT_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINEID_MAGAZINEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MagazineContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineID);

				if (!pagination) {
					list = (List<MagazineContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MagazineContent>(list);
				}
				else {
					list = (List<MagazineContent>)QueryUtil.list(q,
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
	 * Returns the first magazine content in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent findByMagazineID_First(int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = fetchByMagazineID_First(MagazineID,
				orderByComparator);

		if (magazineContent != null) {
			return magazineContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineID=");
		msg.append(MagazineID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first magazine content in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine content, or <code>null</code> if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent fetchByMagazineID_First(int MagazineID,
		OrderByComparator orderByComparator) throws SystemException {
		List<MagazineContent> list = findByMagazineID(MagazineID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last magazine content in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent findByMagazineID_Last(int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = fetchByMagazineID_Last(MagazineID,
				orderByComparator);

		if (magazineContent != null) {
			return magazineContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineID=");
		msg.append(MagazineID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last magazine content in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine content, or <code>null</code> if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent fetchByMagazineID_Last(int MagazineID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMagazineID(MagazineID);

		if (count == 0) {
			return null;
		}

		List<MagazineContent> list = findByMagazineID(MagazineID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the magazine contents before and after the current magazine content in the ordered set where MagazineID = &#63;.
	 *
	 * @param ID the primary key of the current magazine content
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent[] findByMagazineID_PrevAndNext(int ID,
		int MagazineID, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			MagazineContent[] array = new MagazineContentImpl[3];

			array[0] = getByMagazineID_PrevAndNext(session, magazineContent,
					MagazineID, orderByComparator, true);

			array[1] = magazineContent;

			array[2] = getByMagazineID_PrevAndNext(session, magazineContent,
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

	protected MagazineContent getByMagazineID_PrevAndNext(Session session,
		MagazineContent magazineContent, int MagazineID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MAGAZINECONTENT_WHERE);

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
			query.append(MagazineContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(MagazineID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(magazineContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MagazineContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the magazine contents where MagazineID = &#63; from the database.
	 *
	 * @param MagazineID the magazine i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMagazineID(int MagazineID) throws SystemException {
		for (MagazineContent magazineContent : findByMagazineID(MagazineID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(magazineContent);
		}
	}

	/**
	 * Returns the number of magazine contents where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @return the number of matching magazine contents
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

			query.append(_SQL_COUNT_MAGAZINECONTENT_WHERE);

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

	private static final String _FINDER_COLUMN_MAGAZINEID_MAGAZINEID_2 = "magazineContent.MagazineID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINEZONEID =
		new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED,
			MagazineContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMagazineZoneID",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEZONEID =
		new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED,
			MagazineContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMagazineZoneID",
			new String[] { Integer.class.getName() },
			MagazineContentModelImpl.MAGAZINEZONEID_COLUMN_BITMASK |
			MagazineContentModelImpl.SORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAGAZINEZONEID = new FinderPath(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMagazineZoneID",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the magazine contents where MagazineZoneID = &#63;.
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @return the matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineZoneID(int MagazineZoneID)
		throws SystemException {
		return findByMagazineZoneID(MagazineZoneID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the magazine contents where MagazineZoneID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @param start the lower bound of the range of magazine contents
	 * @param end the upper bound of the range of magazine contents (not inclusive)
	 * @return the range of matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineZoneID(int MagazineZoneID,
		int start, int end) throws SystemException {
		return findByMagazineZoneID(MagazineZoneID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the magazine contents where MagazineZoneID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @param start the lower bound of the range of magazine contents
	 * @param end the upper bound of the range of magazine contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findByMagazineZoneID(int MagazineZoneID,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEZONEID;
			finderArgs = new Object[] { MagazineZoneID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINEZONEID;
			finderArgs = new Object[] {
					MagazineZoneID,
					
					start, end, orderByComparator
				};
		}

		List<MagazineContent> list = (List<MagazineContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MagazineContent magazineContent : list) {
				if ((MagazineZoneID != magazineContent.getMagazineZoneID())) {
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

			query.append(_SQL_SELECT_MAGAZINECONTENT_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINEZONEID_MAGAZINEZONEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MagazineContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineZoneID);

				if (!pagination) {
					list = (List<MagazineContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MagazineContent>(list);
				}
				else {
					list = (List<MagazineContent>)QueryUtil.list(q,
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
	 * Returns the first magazine content in the ordered set where MagazineZoneID = &#63;.
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent findByMagazineZoneID_First(int MagazineZoneID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = fetchByMagazineZoneID_First(MagazineZoneID,
				orderByComparator);

		if (magazineContent != null) {
			return magazineContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineZoneID=");
		msg.append(MagazineZoneID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first magazine content in the ordered set where MagazineZoneID = &#63;.
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching magazine content, or <code>null</code> if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent fetchByMagazineZoneID_First(int MagazineZoneID,
		OrderByComparator orderByComparator) throws SystemException {
		List<MagazineContent> list = findByMagazineZoneID(MagazineZoneID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last magazine content in the ordered set where MagazineZoneID = &#63;.
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent findByMagazineZoneID_Last(int MagazineZoneID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = fetchByMagazineZoneID_Last(MagazineZoneID,
				orderByComparator);

		if (magazineContent != null) {
			return magazineContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineZoneID=");
		msg.append(MagazineZoneID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last magazine content in the ordered set where MagazineZoneID = &#63;.
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching magazine content, or <code>null</code> if a matching magazine content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent fetchByMagazineZoneID_Last(int MagazineZoneID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMagazineZoneID(MagazineZoneID);

		if (count == 0) {
			return null;
		}

		List<MagazineContent> list = findByMagazineZoneID(MagazineZoneID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the magazine contents before and after the current magazine content in the ordered set where MagazineZoneID = &#63;.
	 *
	 * @param ID the primary key of the current magazine content
	 * @param MagazineZoneID the magazine zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent[] findByMagazineZoneID_PrevAndNext(int ID,
		int MagazineZoneID, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			MagazineContent[] array = new MagazineContentImpl[3];

			array[0] = getByMagazineZoneID_PrevAndNext(session,
					magazineContent, MagazineZoneID, orderByComparator, true);

			array[1] = magazineContent;

			array[2] = getByMagazineZoneID_PrevAndNext(session,
					magazineContent, MagazineZoneID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MagazineContent getByMagazineZoneID_PrevAndNext(Session session,
		MagazineContent magazineContent, int MagazineZoneID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MAGAZINECONTENT_WHERE);

		query.append(_FINDER_COLUMN_MAGAZINEZONEID_MAGAZINEZONEID_2);

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
			query.append(MagazineContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(MagazineZoneID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(magazineContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MagazineContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the magazine contents where MagazineZoneID = &#63; from the database.
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMagazineZoneID(int MagazineZoneID)
		throws SystemException {
		for (MagazineContent magazineContent : findByMagazineZoneID(
				MagazineZoneID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(magazineContent);
		}
	}

	/**
	 * Returns the number of magazine contents where MagazineZoneID = &#63;.
	 *
	 * @param MagazineZoneID the magazine zone i d
	 * @return the number of matching magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMagazineZoneID(int MagazineZoneID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAGAZINEZONEID;

		Object[] finderArgs = new Object[] { MagazineZoneID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MAGAZINECONTENT_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINEZONEID_MAGAZINEZONEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineZoneID);

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

	private static final String _FINDER_COLUMN_MAGAZINEZONEID_MAGAZINEZONEID_2 = "magazineContent.MagazineZoneID = ?";

	public MagazineContentPersistenceImpl() {
		setModelClass(MagazineContent.class);
	}

	/**
	 * Caches the magazine content in the entity cache if it is enabled.
	 *
	 * @param magazineContent the magazine content
	 */
	@Override
	public void cacheResult(MagazineContent magazineContent) {
		EntityCacheUtil.putResult(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentImpl.class, magazineContent.getPrimaryKey(),
			magazineContent);

		magazineContent.resetOriginalValues();
	}

	/**
	 * Caches the magazine contents in the entity cache if it is enabled.
	 *
	 * @param magazineContents the magazine contents
	 */
	@Override
	public void cacheResult(List<MagazineContent> magazineContents) {
		for (MagazineContent magazineContent : magazineContents) {
			if (EntityCacheUtil.getResult(
						MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
						MagazineContentImpl.class,
						magazineContent.getPrimaryKey()) == null) {
				cacheResult(magazineContent);
			}
			else {
				magazineContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all magazine contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MagazineContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MagazineContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the magazine content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MagazineContent magazineContent) {
		EntityCacheUtil.removeResult(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentImpl.class, magazineContent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MagazineContent> magazineContents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MagazineContent magazineContent : magazineContents) {
			EntityCacheUtil.removeResult(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
				MagazineContentImpl.class, magazineContent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new magazine content with the primary key. Does not add the magazine content to the database.
	 *
	 * @param ID the primary key for the new magazine content
	 * @return the new magazine content
	 */
	@Override
	public MagazineContent create(int ID) {
		MagazineContent magazineContent = new MagazineContentImpl();

		magazineContent.setNew(true);
		magazineContent.setPrimaryKey(ID);

		return magazineContent;
	}

	/**
	 * Removes the magazine content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the magazine content
	 * @return the magazine content that was removed
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent remove(int ID)
		throws NoSuchContentException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the magazine content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the magazine content
	 * @return the magazine content that was removed
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent remove(Serializable primaryKey)
		throws NoSuchContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MagazineContent magazineContent = (MagazineContent)session.get(MagazineContentImpl.class,
					primaryKey);

			if (magazineContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(magazineContent);
		}
		catch (NoSuchContentException nsee) {
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
	protected MagazineContent removeImpl(MagazineContent magazineContent)
		throws SystemException {
		magazineContent = toUnwrappedModel(magazineContent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(magazineContent)) {
				magazineContent = (MagazineContent)session.get(MagazineContentImpl.class,
						magazineContent.getPrimaryKeyObj());
			}

			if (magazineContent != null) {
				session.delete(magazineContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (magazineContent != null) {
			clearCache(magazineContent);
		}

		return magazineContent;
	}

	@Override
	public MagazineContent updateImpl(
		com.viettel.portal.magazine.model.MagazineContent magazineContent)
		throws SystemException {
		magazineContent = toUnwrappedModel(magazineContent);

		boolean isNew = magazineContent.isNew();

		MagazineContentModelImpl magazineContentModelImpl = (MagazineContentModelImpl)magazineContent;

		Session session = null;

		try {
			session = openSession();

			if (magazineContent.isNew()) {
				session.save(magazineContent);

				magazineContent.setNew(false);
			}
			else {
				session.merge(magazineContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MagazineContentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((magazineContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEANDZONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						magazineContentModelImpl.getOriginalMagazineID(),
						magazineContentModelImpl.getOriginalMagazineZoneID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINEANDZONE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEANDZONE,
					args);

				args = new Object[] {
						magazineContentModelImpl.getMagazineID(),
						magazineContentModelImpl.getMagazineZoneID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINEANDZONE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEANDZONE,
					args);
			}

			if ((magazineContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						magazineContentModelImpl.getOriginalMagazineID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID,
					args);

				args = new Object[] { magazineContentModelImpl.getMagazineID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEID,
					args);
			}

			if ((magazineContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEZONEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						magazineContentModelImpl.getOriginalMagazineZoneID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINEZONEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEZONEID,
					args);

				args = new Object[] { magazineContentModelImpl.getMagazineZoneID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINEZONEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINEZONEID,
					args);
			}
		}

		EntityCacheUtil.putResult(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
			MagazineContentImpl.class, magazineContent.getPrimaryKey(),
			magazineContent);

		return magazineContent;
	}

	protected MagazineContent toUnwrappedModel(MagazineContent magazineContent) {
		if (magazineContent instanceof MagazineContentImpl) {
			return magazineContent;
		}

		MagazineContentImpl magazineContentImpl = new MagazineContentImpl();

		magazineContentImpl.setNew(magazineContent.isNew());
		magazineContentImpl.setPrimaryKey(magazineContent.getPrimaryKey());

		magazineContentImpl.setID(magazineContent.getID());
		magazineContentImpl.setHeadline(magazineContent.getHeadline());
		magazineContentImpl.setTeaser(magazineContent.getTeaser());
		magazineContentImpl.setBody(magazineContent.getBody());
		magazineContentImpl.setMagazineZoneID(magazineContent.getMagazineZoneID());
		magazineContentImpl.setMagazineID(magazineContent.getMagazineID());
		magazineContentImpl.setAuthor(magazineContent.getAuthor());
		magazineContentImpl.setJobtitle(magazineContent.getJobtitle());
		magazineContentImpl.setViewedCount(magazineContent.getViewedCount());
		magazineContentImpl.setSortOrder(magazineContent.getSortOrder());
		magazineContentImpl.setMailedCount(magazineContent.getMailedCount());
		magazineContentImpl.setCreationDate(magazineContent.getCreationDate());
		magazineContentImpl.setModifiedDate(magazineContent.getModifiedDate());

		return magazineContentImpl;
	}

	/**
	 * Returns the magazine content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the magazine content
	 * @return the magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContentException, SystemException {
		MagazineContent magazineContent = fetchByPrimaryKey(primaryKey);

		if (magazineContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return magazineContent;
	}

	/**
	 * Returns the magazine content with the primary key or throws a {@link com.viettel.portal.magazine.NoSuchContentException} if it could not be found.
	 *
	 * @param ID the primary key of the magazine content
	 * @return the magazine content
	 * @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent findByPrimaryKey(int ID)
		throws NoSuchContentException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the magazine content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the magazine content
	 * @return the magazine content, or <code>null</code> if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MagazineContent magazineContent = (MagazineContent)EntityCacheUtil.getResult(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
				MagazineContentImpl.class, primaryKey);

		if (magazineContent == _nullMagazineContent) {
			return null;
		}

		if (magazineContent == null) {
			Session session = null;

			try {
				session = openSession();

				magazineContent = (MagazineContent)session.get(MagazineContentImpl.class,
						primaryKey);

				if (magazineContent != null) {
					cacheResult(magazineContent);
				}
				else {
					EntityCacheUtil.putResult(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
						MagazineContentImpl.class, primaryKey,
						_nullMagazineContent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MagazineContentModelImpl.ENTITY_CACHE_ENABLED,
					MagazineContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return magazineContent;
	}

	/**
	 * Returns the magazine content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the magazine content
	 * @return the magazine content, or <code>null</code> if a magazine content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MagazineContent fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the magazine contents.
	 *
	 * @return the magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the magazine contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of magazine contents
	 * @param end the upper bound of the range of magazine contents (not inclusive)
	 * @return the range of magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the magazine contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of magazine contents
	 * @param end the upper bound of the range of magazine contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of magazine contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MagazineContent> findAll(int start, int end,
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

		List<MagazineContent> list = (List<MagazineContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MAGAZINECONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAGAZINECONTENT;

				if (pagination) {
					sql = sql.concat(MagazineContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MagazineContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MagazineContent>(list);
				}
				else {
					list = (List<MagazineContent>)QueryUtil.list(q,
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
	 * Removes all the magazine contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MagazineContent magazineContent : findAll()) {
			remove(magazineContent);
		}
	}

	/**
	 * Returns the number of magazine contents.
	 *
	 * @return the number of magazine contents
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

				Query q = session.createQuery(_SQL_COUNT_MAGAZINECONTENT);

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
	 * Initializes the magazine content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.magazine.model.MagazineContent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MagazineContent>> listenersList = new ArrayList<ModelListener<MagazineContent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MagazineContent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MagazineContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MAGAZINECONTENT = "SELECT magazineContent FROM MagazineContent magazineContent";
	private static final String _SQL_SELECT_MAGAZINECONTENT_WHERE = "SELECT magazineContent FROM MagazineContent magazineContent WHERE ";
	private static final String _SQL_COUNT_MAGAZINECONTENT = "SELECT COUNT(magazineContent) FROM MagazineContent magazineContent";
	private static final String _SQL_COUNT_MAGAZINECONTENT_WHERE = "SELECT COUNT(magazineContent) FROM MagazineContent magazineContent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "magazineContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MagazineContent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MagazineContent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MagazineContentPersistenceImpl.class);
	private static MagazineContent _nullMagazineContent = new MagazineContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MagazineContent> toCacheModel() {
				return _nullMagazineContentCacheModel;
			}
		};

	private static CacheModel<MagazineContent> _nullMagazineContentCacheModel = new CacheModel<MagazineContent>() {
			@Override
			public MagazineContent toEntityModel() {
				return _nullMagazineContent;
			}
		};
}