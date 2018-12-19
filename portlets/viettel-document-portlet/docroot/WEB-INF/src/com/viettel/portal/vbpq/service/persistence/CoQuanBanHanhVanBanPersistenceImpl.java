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

package com.viettel.portal.vbpq.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException;
import com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan;
import com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanImpl;
import com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the co quan ban hanh van ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see CoQuanBanHanhVanBanPersistence
 * @see CoQuanBanHanhVanBanUtil
 * @generated
 */
public class CoQuanBanHanhVanBanPersistenceImpl extends BasePersistenceImpl<CoQuanBanHanhVanBan>
	implements CoQuanBanHanhVanBanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CoQuanBanHanhVanBanUtil} to access the co quan ban hanh van ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CoQuanBanHanhVanBanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_ = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_ = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_",
			new String[] { Long.class.getName() },
			CoQuanBanHanhVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			CoQuanBanHanhVanBanModelImpl.ORDER__COLUMN_BITMASK |
			CoQuanBanHanhVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_ = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the co quan ban hanh van bans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByG_(long groupId)
		throws SystemException {
		return findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan ban hanh van bans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of co quan ban hanh van bans
	 * @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	 * @return the range of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByG_(long groupId, int start, int end)
		throws SystemException {
		return findByG_(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan ban hanh van bans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of co quan ban hanh van bans
	 * @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByG_(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<CoQuanBanHanhVanBan> list = (List<CoQuanBanHanhVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : list) {
				if ((groupId != coQuanBanHanhVanBan.getGroupId())) {
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

			query.append(_SQL_SELECT_COQUANBANHANHVANBAN_WHERE);

			query.append(_FINDER_COLUMN_G__GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CoQuanBanHanhVanBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CoQuanBanHanhVanBan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CoQuanBanHanhVanBan>(list);
				}
				else {
					list = (List<CoQuanBanHanhVanBan>)QueryUtil.list(q,
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
	 * Returns the first co quan ban hanh van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByG__First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = fetchByG__First(groupId,
				orderByComparator);

		if (coQuanBanHanhVanBan != null) {
			return coQuanBanHanhVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoQuanBanHanhVanBanException(msg.toString());
	}

	/**
	 * Returns the first co quan ban hanh van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByG__First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CoQuanBanHanhVanBan> list = findByG_(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last co quan ban hanh van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByG__Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = fetchByG__Last(groupId,
				orderByComparator);

		if (coQuanBanHanhVanBan != null) {
			return coQuanBanHanhVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoQuanBanHanhVanBanException(msg.toString());
	}

	/**
	 * Returns the last co quan ban hanh van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByG__Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_(groupId);

		if (count == 0) {
			return null;
		}

		List<CoQuanBanHanhVanBan> list = findByG_(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the co quan ban hanh van bans before and after the current co quan ban hanh van ban in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current co quan ban hanh van ban
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan[] findByG__PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CoQuanBanHanhVanBan[] array = new CoQuanBanHanhVanBanImpl[3];

			array[0] = getByG__PrevAndNext(session, coQuanBanHanhVanBan,
					groupId, orderByComparator, true);

			array[1] = coQuanBanHanhVanBan;

			array[2] = getByG__PrevAndNext(session, coQuanBanHanhVanBan,
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

	protected CoQuanBanHanhVanBan getByG__PrevAndNext(Session session,
		CoQuanBanHanhVanBan coQuanBanHanhVanBan, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COQUANBANHANHVANBAN_WHERE);

		query.append(_FINDER_COLUMN_G__GROUPID_2);

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
			query.append(CoQuanBanHanhVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coQuanBanHanhVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CoQuanBanHanhVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the co quan ban hanh van bans where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_(long groupId) throws SystemException {
		for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : findByG_(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(coQuanBanHanhVanBan);
		}
	}

	/**
	 * Returns the number of co quan ban hanh van bans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COQUANBANHANHVANBAN_WHERE);

			query.append(_FINDER_COLUMN_G__GROUPID_2);

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

	private static final String _FINDER_COLUMN_G__GROUPID_2 = "coQuanBanHanhVanBan.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			CoQuanBanHanhVanBanModelImpl.TRANGTHAI_COLUMN_BITMASK |
			CoQuanBanHanhVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			CoQuanBanHanhVanBanModelImpl.ORDER__COLUMN_BITMASK |
			CoQuanBanHanhVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Boolean.class.getName(), Long.class.getName() });

	/**
	 * Returns all the co quan ban hanh van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @return the matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByTrangThai(boolean trangThai,
		long groupId) throws SystemException {
		return findByTrangThai(trangThai, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan ban hanh van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param start the lower bound of the range of co quan ban hanh van bans
	 * @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	 * @return the range of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByTrangThai(boolean trangThai,
		long groupId, int start, int end) throws SystemException {
		return findByTrangThai(trangThai, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan ban hanh van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param start the lower bound of the range of co quan ban hanh van bans
	 * @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByTrangThai(boolean trangThai,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { trangThai, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] {
					trangThai, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CoQuanBanHanhVanBan> list = (List<CoQuanBanHanhVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : list) {
				if ((trangThai != coQuanBanHanhVanBan.getTrangThai()) ||
						(groupId != coQuanBanHanhVanBan.getGroupId())) {
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

			query.append(_SQL_SELECT_COQUANBANHANHVANBAN_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

			query.append(_FINDER_COLUMN_TRANGTHAI_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CoQuanBanHanhVanBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThai);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CoQuanBanHanhVanBan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CoQuanBanHanhVanBan>(list);
				}
				else {
					list = (List<CoQuanBanHanhVanBan>)QueryUtil.list(q,
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
	 * Returns the first co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByTrangThai_First(boolean trangThai,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = fetchByTrangThai_First(trangThai,
				groupId, orderByComparator);

		if (coQuanBanHanhVanBan != null) {
			return coQuanBanHanhVanBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoQuanBanHanhVanBanException(msg.toString());
	}

	/**
	 * Returns the first co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByTrangThai_First(boolean trangThai,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CoQuanBanHanhVanBan> list = findByTrangThai(trangThai, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByTrangThai_Last(boolean trangThai,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = fetchByTrangThai_Last(trangThai,
				groupId, orderByComparator);

		if (coQuanBanHanhVanBan != null) {
			return coQuanBanHanhVanBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoQuanBanHanhVanBanException(msg.toString());
	}

	/**
	 * Returns the last co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByTrangThai_Last(boolean trangThai,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTrangThai(trangThai, groupId);

		if (count == 0) {
			return null;
		}

		List<CoQuanBanHanhVanBan> list = findByTrangThai(trangThai, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the co quan ban hanh van bans before and after the current co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current co quan ban hanh van ban
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan[] findByTrangThai_PrevAndNext(long id,
		boolean trangThai, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CoQuanBanHanhVanBan[] array = new CoQuanBanHanhVanBanImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, coQuanBanHanhVanBan,
					trangThai, groupId, orderByComparator, true);

			array[1] = coQuanBanHanhVanBan;

			array[2] = getByTrangThai_PrevAndNext(session, coQuanBanHanhVanBan,
					trangThai, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CoQuanBanHanhVanBan getByTrangThai_PrevAndNext(Session session,
		CoQuanBanHanhVanBan coQuanBanHanhVanBan, boolean trangThai,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COQUANBANHANHVANBAN_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

		query.append(_FINDER_COLUMN_TRANGTHAI_GROUPID_2);

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
			query.append(CoQuanBanHanhVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(trangThai);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coQuanBanHanhVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CoQuanBanHanhVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the co quan ban hanh van bans where trangThai = &#63; and groupId = &#63; from the database.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTrangThai(boolean trangThai, long groupId)
		throws SystemException {
		for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : findByTrangThai(
				trangThai, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(coQuanBanHanhVanBan);
		}
	}

	/**
	 * Returns the number of co quan ban hanh van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @return the number of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTrangThai(boolean trangThai, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TRANGTHAI;

		Object[] finderArgs = new Object[] { trangThai, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COQUANBANHANHVANBAN_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

			query.append(_FINDER_COLUMN_TRANGTHAI_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThai);

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

	private static final String _FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2 = "coQuanBanHanhVanBan.trangThai = ? AND ";
	private static final String _FINDER_COLUMN_TRANGTHAI_GROUPID_2 = "coQuanBanHanhVanBan.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID_TEN = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGroupId_Ten",
			new String[] { Long.class.getName(), String.class.getName() },
			CoQuanBanHanhVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			CoQuanBanHanhVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_TEN = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Ten",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the co quan ban hanh van ban where groupId = &#63; and ten = &#63; or throws a {@link com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the matching co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByGroupId_Ten(long groupId, String ten)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = fetchByGroupId_Ten(groupId,
				ten);

		if (coQuanBanHanhVanBan == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCoQuanBanHanhVanBanException(msg.toString());
		}

		return coQuanBanHanhVanBan;
	}

	/**
	 * Returns the co quan ban hanh van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByGroupId_Ten(long groupId, String ten)
		throws SystemException {
		return fetchByGroupId_Ten(groupId, ten, true);
	}

	/**
	 * Returns the co quan ban hanh van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByGroupId_Ten(long groupId, String ten,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
					finderArgs, this);
		}

		if (result instanceof CoQuanBanHanhVanBan) {
			CoQuanBanHanhVanBan coQuanBanHanhVanBan = (CoQuanBanHanhVanBan)result;

			if ((groupId != coQuanBanHanhVanBan.getGroupId()) ||
					!Validator.equals(ten, coQuanBanHanhVanBan.getTen())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COQUANBANHANHVANBAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_TEN_GROUPID_2);

			boolean bindTen = false;

			if (ten == null) {
				query.append(_FINDER_COLUMN_GROUPID_TEN_TEN_1);
			}
			else if (ten.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_TEN_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_GROUPID_TEN_TEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindTen) {
					qPos.add(ten);
				}

				List<CoQuanBanHanhVanBan> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CoQuanBanHanhVanBanPersistenceImpl.fetchByGroupId_Ten(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CoQuanBanHanhVanBan coQuanBanHanhVanBan = list.get(0);

					result = coQuanBanHanhVanBan;

					cacheResult(coQuanBanHanhVanBan);

					if ((coQuanBanHanhVanBan.getGroupId() != groupId) ||
							(coQuanBanHanhVanBan.getTen() == null) ||
							!coQuanBanHanhVanBan.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
							finderArgs, coQuanBanHanhVanBan);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CoQuanBanHanhVanBan)result;
		}
	}

	/**
	 * Removes the co quan ban hanh van ban where groupId = &#63; and ten = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the co quan ban hanh van ban that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan removeByGroupId_Ten(long groupId, String ten)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = findByGroupId_Ten(groupId, ten);

		return remove(coQuanBanHanhVanBan);
	}

	/**
	 * Returns the number of co quan ban hanh van bans where groupId = &#63; and ten = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the number of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId_Ten(long groupId, String ten)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID_TEN;

		Object[] finderArgs = new Object[] { groupId, ten };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COQUANBANHANHVANBAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_TEN_GROUPID_2);

			boolean bindTen = false;

			if (ten == null) {
				query.append(_FINDER_COLUMN_GROUPID_TEN_TEN_1);
			}
			else if (ten.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_TEN_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_GROUPID_TEN_TEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindTen) {
					qPos.add(ten);
				}

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

	private static final String _FINDER_COLUMN_GROUPID_TEN_GROUPID_2 = "coQuanBanHanhVanBan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_1 = "coQuanBanHanhVanBan.ten IS NULL";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_2 = "coQuanBanHanhVanBan.ten = ?";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_3 = "(coQuanBanHanhVanBan.ten IS NULL OR coQuanBanHanhVanBan.ten = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NHOMVANBANID =
		new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNhomVanBanId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID =
		new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNhomVanBanId",
			new String[] { Long.class.getName() },
			CoQuanBanHanhVanBanModelImpl.NHOMVANBANID_COLUMN_BITMASK |
			CoQuanBanHanhVanBanModelImpl.ORDER__COLUMN_BITMASK |
			CoQuanBanHanhVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NHOMVANBANID = new FinderPath(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNhomVanBanId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the co quan ban hanh van bans where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @return the matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByNhomVanBanId(long nhomVanBanId)
		throws SystemException {
		return findByNhomVanBanId(nhomVanBanId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan ban hanh van bans where nhomVanBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param start the lower bound of the range of co quan ban hanh van bans
	 * @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	 * @return the range of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByNhomVanBanId(long nhomVanBanId,
		int start, int end) throws SystemException {
		return findByNhomVanBanId(nhomVanBanId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan ban hanh van bans where nhomVanBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param start the lower bound of the range of co quan ban hanh van bans
	 * @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findByNhomVanBanId(long nhomVanBanId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID;
			finderArgs = new Object[] { nhomVanBanId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NHOMVANBANID;
			finderArgs = new Object[] {
					nhomVanBanId,
					
					start, end, orderByComparator
				};
		}

		List<CoQuanBanHanhVanBan> list = (List<CoQuanBanHanhVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : list) {
				if ((nhomVanBanId != coQuanBanHanhVanBan.getNhomVanBanId())) {
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

			query.append(_SQL_SELECT_COQUANBANHANHVANBAN_WHERE);

			query.append(_FINDER_COLUMN_NHOMVANBANID_NHOMVANBANID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CoQuanBanHanhVanBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomVanBanId);

				if (!pagination) {
					list = (List<CoQuanBanHanhVanBan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CoQuanBanHanhVanBan>(list);
				}
				else {
					list = (List<CoQuanBanHanhVanBan>)QueryUtil.list(q,
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
	 * Returns the first co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByNhomVanBanId_First(long nhomVanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = fetchByNhomVanBanId_First(nhomVanBanId,
				orderByComparator);

		if (coQuanBanHanhVanBan != null) {
			return coQuanBanHanhVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomVanBanId=");
		msg.append(nhomVanBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoQuanBanHanhVanBanException(msg.toString());
	}

	/**
	 * Returns the first co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByNhomVanBanId_First(long nhomVanBanId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CoQuanBanHanhVanBan> list = findByNhomVanBanId(nhomVanBanId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByNhomVanBanId_Last(long nhomVanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = fetchByNhomVanBanId_Last(nhomVanBanId,
				orderByComparator);

		if (coQuanBanHanhVanBan != null) {
			return coQuanBanHanhVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomVanBanId=");
		msg.append(nhomVanBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoQuanBanHanhVanBanException(msg.toString());
	}

	/**
	 * Returns the last co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByNhomVanBanId_Last(long nhomVanBanId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNhomVanBanId(nhomVanBanId);

		if (count == 0) {
			return null;
		}

		List<CoQuanBanHanhVanBan> list = findByNhomVanBanId(nhomVanBanId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the co quan ban hanh van bans before and after the current co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param id the primary key of the current co quan ban hanh van ban
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan[] findByNhomVanBanId_PrevAndNext(long id,
		long nhomVanBanId, OrderByComparator orderByComparator)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CoQuanBanHanhVanBan[] array = new CoQuanBanHanhVanBanImpl[3];

			array[0] = getByNhomVanBanId_PrevAndNext(session,
					coQuanBanHanhVanBan, nhomVanBanId, orderByComparator, true);

			array[1] = coQuanBanHanhVanBan;

			array[2] = getByNhomVanBanId_PrevAndNext(session,
					coQuanBanHanhVanBan, nhomVanBanId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CoQuanBanHanhVanBan getByNhomVanBanId_PrevAndNext(
		Session session, CoQuanBanHanhVanBan coQuanBanHanhVanBan,
		long nhomVanBanId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COQUANBANHANHVANBAN_WHERE);

		query.append(_FINDER_COLUMN_NHOMVANBANID_NHOMVANBANID_2);

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
			query.append(CoQuanBanHanhVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nhomVanBanId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coQuanBanHanhVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CoQuanBanHanhVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the co quan ban hanh van bans where nhomVanBanId = &#63; from the database.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNhomVanBanId(long nhomVanBanId)
		throws SystemException {
		for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : findByNhomVanBanId(
				nhomVanBanId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(coQuanBanHanhVanBan);
		}
	}

	/**
	 * Returns the number of co quan ban hanh van bans where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @return the number of matching co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNhomVanBanId(long nhomVanBanId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NHOMVANBANID;

		Object[] finderArgs = new Object[] { nhomVanBanId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COQUANBANHANHVANBAN_WHERE);

			query.append(_FINDER_COLUMN_NHOMVANBANID_NHOMVANBANID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomVanBanId);

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

	private static final String _FINDER_COLUMN_NHOMVANBANID_NHOMVANBANID_2 = "coQuanBanHanhVanBan.nhomVanBanId = ?";

	public CoQuanBanHanhVanBanPersistenceImpl() {
		setModelClass(CoQuanBanHanhVanBan.class);
	}

	/**
	 * Caches the co quan ban hanh van ban in the entity cache if it is enabled.
	 *
	 * @param coQuanBanHanhVanBan the co quan ban hanh van ban
	 */
	@Override
	public void cacheResult(CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		EntityCacheUtil.putResult(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class, coQuanBanHanhVanBan.getPrimaryKey(),
			coQuanBanHanhVanBan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
			new Object[] {
				coQuanBanHanhVanBan.getGroupId(), coQuanBanHanhVanBan.getTen()
			}, coQuanBanHanhVanBan);

		coQuanBanHanhVanBan.resetOriginalValues();
	}

	/**
	 * Caches the co quan ban hanh van bans in the entity cache if it is enabled.
	 *
	 * @param coQuanBanHanhVanBans the co quan ban hanh van bans
	 */
	@Override
	public void cacheResult(List<CoQuanBanHanhVanBan> coQuanBanHanhVanBans) {
		for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : coQuanBanHanhVanBans) {
			if (EntityCacheUtil.getResult(
						CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
						CoQuanBanHanhVanBanImpl.class,
						coQuanBanHanhVanBan.getPrimaryKey()) == null) {
				cacheResult(coQuanBanHanhVanBan);
			}
			else {
				coQuanBanHanhVanBan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all co quan ban hanh van bans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CoQuanBanHanhVanBanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CoQuanBanHanhVanBanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the co quan ban hanh van ban.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		EntityCacheUtil.removeResult(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class, coQuanBanHanhVanBan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(coQuanBanHanhVanBan);
	}

	@Override
	public void clearCache(List<CoQuanBanHanhVanBan> coQuanBanHanhVanBans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : coQuanBanHanhVanBans) {
			EntityCacheUtil.removeResult(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
				CoQuanBanHanhVanBanImpl.class,
				coQuanBanHanhVanBan.getPrimaryKey());

			clearUniqueFindersCache(coQuanBanHanhVanBan);
		}
	}

	protected void cacheUniqueFindersCache(
		CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		if (coQuanBanHanhVanBan.isNew()) {
			Object[] args = new Object[] {
					coQuanBanHanhVanBan.getGroupId(),
					coQuanBanHanhVanBan.getTen()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args,
				coQuanBanHanhVanBan);
		}
		else {
			CoQuanBanHanhVanBanModelImpl coQuanBanHanhVanBanModelImpl = (CoQuanBanHanhVanBanModelImpl)coQuanBanHanhVanBan;

			if ((coQuanBanHanhVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coQuanBanHanhVanBan.getGroupId(),
						coQuanBanHanhVanBan.getTen()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_TEN,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
					args, coQuanBanHanhVanBan);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		CoQuanBanHanhVanBanModelImpl coQuanBanHanhVanBanModelImpl = (CoQuanBanHanhVanBanModelImpl)coQuanBanHanhVanBan;

		Object[] args = new Object[] {
				coQuanBanHanhVanBan.getGroupId(), coQuanBanHanhVanBan.getTen()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args);

		if ((coQuanBanHanhVanBanModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID_TEN.getColumnBitmask()) != 0) {
			args = new Object[] {
					coQuanBanHanhVanBanModelImpl.getOriginalGroupId(),
					coQuanBanHanhVanBanModelImpl.getOriginalTen()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args);
		}
	}

	/**
	 * Creates a new co quan ban hanh van ban with the primary key. Does not add the co quan ban hanh van ban to the database.
	 *
	 * @param id the primary key for the new co quan ban hanh van ban
	 * @return the new co quan ban hanh van ban
	 */
	@Override
	public CoQuanBanHanhVanBan create(long id) {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = new CoQuanBanHanhVanBanImpl();

		coQuanBanHanhVanBan.setNew(true);
		coQuanBanHanhVanBan.setPrimaryKey(id);

		return coQuanBanHanhVanBan;
	}

	/**
	 * Removes the co quan ban hanh van ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the co quan ban hanh van ban
	 * @return the co quan ban hanh van ban that was removed
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan remove(long id)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the co quan ban hanh van ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the co quan ban hanh van ban
	 * @return the co quan ban hanh van ban that was removed
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan remove(Serializable primaryKey)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CoQuanBanHanhVanBan coQuanBanHanhVanBan = (CoQuanBanHanhVanBan)session.get(CoQuanBanHanhVanBanImpl.class,
					primaryKey);

			if (coQuanBanHanhVanBan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoQuanBanHanhVanBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coQuanBanHanhVanBan);
		}
		catch (NoSuchCoQuanBanHanhVanBanException nsee) {
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
	protected CoQuanBanHanhVanBan removeImpl(
		CoQuanBanHanhVanBan coQuanBanHanhVanBan) throws SystemException {
		coQuanBanHanhVanBan = toUnwrappedModel(coQuanBanHanhVanBan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coQuanBanHanhVanBan)) {
				coQuanBanHanhVanBan = (CoQuanBanHanhVanBan)session.get(CoQuanBanHanhVanBanImpl.class,
						coQuanBanHanhVanBan.getPrimaryKeyObj());
			}

			if (coQuanBanHanhVanBan != null) {
				session.delete(coQuanBanHanhVanBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (coQuanBanHanhVanBan != null) {
			clearCache(coQuanBanHanhVanBan);
		}

		return coQuanBanHanhVanBan;
	}

	@Override
	public CoQuanBanHanhVanBan updateImpl(
		com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan)
		throws SystemException {
		coQuanBanHanhVanBan = toUnwrappedModel(coQuanBanHanhVanBan);

		boolean isNew = coQuanBanHanhVanBan.isNew();

		CoQuanBanHanhVanBanModelImpl coQuanBanHanhVanBanModelImpl = (CoQuanBanHanhVanBanModelImpl)coQuanBanHanhVanBan;

		Session session = null;

		try {
			session = openSession();

			if (coQuanBanHanhVanBan.isNew()) {
				session.save(coQuanBanHanhVanBan);

				coQuanBanHanhVanBan.setNew(false);
			}
			else {
				session.merge(coQuanBanHanhVanBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CoQuanBanHanhVanBanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((coQuanBanHanhVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coQuanBanHanhVanBanModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_,
					args);

				args = new Object[] { coQuanBanHanhVanBanModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_,
					args);
			}

			if ((coQuanBanHanhVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coQuanBanHanhVanBanModelImpl.getOriginalTrangThai(),
						coQuanBanHanhVanBanModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						coQuanBanHanhVanBanModelImpl.getTrangThai(),
						coQuanBanHanhVanBanModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((coQuanBanHanhVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coQuanBanHanhVanBanModelImpl.getOriginalNhomVanBanId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NHOMVANBANID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID,
					args);

				args = new Object[] {
						coQuanBanHanhVanBanModelImpl.getNhomVanBanId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NHOMVANBANID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID,
					args);
			}
		}

		EntityCacheUtil.putResult(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanBanHanhVanBanImpl.class, coQuanBanHanhVanBan.getPrimaryKey(),
			coQuanBanHanhVanBan);

		clearUniqueFindersCache(coQuanBanHanhVanBan);
		cacheUniqueFindersCache(coQuanBanHanhVanBan);

		return coQuanBanHanhVanBan;
	}

	protected CoQuanBanHanhVanBan toUnwrappedModel(
		CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		if (coQuanBanHanhVanBan instanceof CoQuanBanHanhVanBanImpl) {
			return coQuanBanHanhVanBan;
		}

		CoQuanBanHanhVanBanImpl coQuanBanHanhVanBanImpl = new CoQuanBanHanhVanBanImpl();

		coQuanBanHanhVanBanImpl.setNew(coQuanBanHanhVanBan.isNew());
		coQuanBanHanhVanBanImpl.setPrimaryKey(coQuanBanHanhVanBan.getPrimaryKey());

		coQuanBanHanhVanBanImpl.setId(coQuanBanHanhVanBan.getId());
		coQuanBanHanhVanBanImpl.setTen(coQuanBanHanhVanBan.getTen());
		coQuanBanHanhVanBanImpl.setTrangThai(coQuanBanHanhVanBan.isTrangThai());
		coQuanBanHanhVanBanImpl.setNgayTao(coQuanBanHanhVanBan.getNgayTao());
		coQuanBanHanhVanBanImpl.setNgaySua(coQuanBanHanhVanBan.getNgaySua());
		coQuanBanHanhVanBanImpl.setNguoiTao(coQuanBanHanhVanBan.getNguoiTao());
		coQuanBanHanhVanBanImpl.setNguoiSua(coQuanBanHanhVanBan.getNguoiSua());
		coQuanBanHanhVanBanImpl.setGroupId(coQuanBanHanhVanBan.getGroupId());
		coQuanBanHanhVanBanImpl.setOrder_(coQuanBanHanhVanBan.getOrder_());
		coQuanBanHanhVanBanImpl.setNhomVanBanId(coQuanBanHanhVanBan.getNhomVanBanId());

		return coQuanBanHanhVanBanImpl;
	}

	/**
	 * Returns the co quan ban hanh van ban with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the co quan ban hanh van ban
	 * @return the co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = fetchByPrimaryKey(primaryKey);

		if (coQuanBanHanhVanBan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoQuanBanHanhVanBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return coQuanBanHanhVanBan;
	}

	/**
	 * Returns the co quan ban hanh van ban with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException} if it could not be found.
	 *
	 * @param id the primary key of the co quan ban hanh van ban
	 * @return the co quan ban hanh van ban
	 * @throws com.viettel.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan findByPrimaryKey(long id)
		throws NoSuchCoQuanBanHanhVanBanException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the co quan ban hanh van ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the co quan ban hanh van ban
	 * @return the co quan ban hanh van ban, or <code>null</code> if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CoQuanBanHanhVanBan coQuanBanHanhVanBan = (CoQuanBanHanhVanBan)EntityCacheUtil.getResult(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
				CoQuanBanHanhVanBanImpl.class, primaryKey);

		if (coQuanBanHanhVanBan == _nullCoQuanBanHanhVanBan) {
			return null;
		}

		if (coQuanBanHanhVanBan == null) {
			Session session = null;

			try {
				session = openSession();

				coQuanBanHanhVanBan = (CoQuanBanHanhVanBan)session.get(CoQuanBanHanhVanBanImpl.class,
						primaryKey);

				if (coQuanBanHanhVanBan != null) {
					cacheResult(coQuanBanHanhVanBan);
				}
				else {
					EntityCacheUtil.putResult(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
						CoQuanBanHanhVanBanImpl.class, primaryKey,
						_nullCoQuanBanHanhVanBan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CoQuanBanHanhVanBanModelImpl.ENTITY_CACHE_ENABLED,
					CoQuanBanHanhVanBanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return coQuanBanHanhVanBan;
	}

	/**
	 * Returns the co quan ban hanh van ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the co quan ban hanh van ban
	 * @return the co quan ban hanh van ban, or <code>null</code> if a co quan ban hanh van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanBanHanhVanBan fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the co quan ban hanh van bans.
	 *
	 * @return the co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan ban hanh van bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of co quan ban hanh van bans
	 * @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	 * @return the range of co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan ban hanh van bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of co quan ban hanh van bans
	 * @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of co quan ban hanh van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoQuanBanHanhVanBan> findAll(int start, int end,
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

		List<CoQuanBanHanhVanBan> list = (List<CoQuanBanHanhVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COQUANBANHANHVANBAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COQUANBANHANHVANBAN;

				if (pagination) {
					sql = sql.concat(CoQuanBanHanhVanBanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CoQuanBanHanhVanBan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CoQuanBanHanhVanBan>(list);
				}
				else {
					list = (List<CoQuanBanHanhVanBan>)QueryUtil.list(q,
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
	 * Removes all the co quan ban hanh van bans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CoQuanBanHanhVanBan coQuanBanHanhVanBan : findAll()) {
			remove(coQuanBanHanhVanBan);
		}
	}

	/**
	 * Returns the number of co quan ban hanh van bans.
	 *
	 * @return the number of co quan ban hanh van bans
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

				Query q = session.createQuery(_SQL_COUNT_COQUANBANHANHVANBAN);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the co quan ban hanh van ban persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CoQuanBanHanhVanBan>> listenersList = new ArrayList<ModelListener<CoQuanBanHanhVanBan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CoQuanBanHanhVanBan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CoQuanBanHanhVanBanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COQUANBANHANHVANBAN = "SELECT coQuanBanHanhVanBan FROM CoQuanBanHanhVanBan coQuanBanHanhVanBan";
	private static final String _SQL_SELECT_COQUANBANHANHVANBAN_WHERE = "SELECT coQuanBanHanhVanBan FROM CoQuanBanHanhVanBan coQuanBanHanhVanBan WHERE ";
	private static final String _SQL_COUNT_COQUANBANHANHVANBAN = "SELECT COUNT(coQuanBanHanhVanBan) FROM CoQuanBanHanhVanBan coQuanBanHanhVanBan";
	private static final String _SQL_COUNT_COQUANBANHANHVANBAN_WHERE = "SELECT COUNT(coQuanBanHanhVanBan) FROM CoQuanBanHanhVanBan coQuanBanHanhVanBan WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coQuanBanHanhVanBan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CoQuanBanHanhVanBan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CoQuanBanHanhVanBan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoQuanBanHanhVanBanPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "ten", "trangThai", "ngayTao", "ngaySua", "nguoiTao",
				"nguoiSua", "groupId", "order_"
			});
	private static CoQuanBanHanhVanBan _nullCoQuanBanHanhVanBan = new CoQuanBanHanhVanBanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CoQuanBanHanhVanBan> toCacheModel() {
				return _nullCoQuanBanHanhVanBanCacheModel;
			}
		};

	private static CacheModel<CoQuanBanHanhVanBan> _nullCoQuanBanHanhVanBanCacheModel =
		new CacheModel<CoQuanBanHanhVanBan>() {
			@Override
			public CoQuanBanHanhVanBan toEntityModel() {
				return _nullCoQuanBanHanhVanBan;
			}
		};
}