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

import com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;
import com.viettel.portal.vbpq.model.LinhVucVanBan;
import com.viettel.portal.vbpq.model.impl.LinhVucVanBanImpl;
import com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the linh vuc van ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see LinhVucVanBanPersistence
 * @see LinhVucVanBanUtil
 * @generated
 */
public class LinhVucVanBanPersistenceImpl extends BasePersistenceImpl<LinhVucVanBan>
	implements LinhVucVanBanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LinhVucVanBanUtil} to access the linh vuc van ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LinhVucVanBanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_ = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_ = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_", new String[] { Long.class.getName() },
			LinhVucVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			LinhVucVanBanModelImpl.ORDER__COLUMN_BITMASK |
			LinhVucVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_ = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the linh vuc van bans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByG_(long groupId) throws SystemException {
		return findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linh vuc van bans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of linh vuc van bans
	 * @param end the upper bound of the range of linh vuc van bans (not inclusive)
	 * @return the range of matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByG_(long groupId, int start, int end)
		throws SystemException {
		return findByG_(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the linh vuc van bans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of linh vuc van bans
	 * @param end the upper bound of the range of linh vuc van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByG_(long groupId, int start, int end,
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

		List<LinhVucVanBan> list = (List<LinhVucVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LinhVucVanBan linhVucVanBan : list) {
				if ((groupId != linhVucVanBan.getGroupId())) {
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

			query.append(_SQL_SELECT_LINHVUCVANBAN_WHERE);

			query.append(_FINDER_COLUMN_G__GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LinhVucVanBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LinhVucVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LinhVucVanBan>(list);
				}
				else {
					list = (List<LinhVucVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first linh vuc van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByG__First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = fetchByG__First(groupId, orderByComparator);

		if (linhVucVanBan != null) {
			return linhVucVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinhVucVanBanException(msg.toString());
	}

	/**
	 * Returns the first linh vuc van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByG__First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LinhVucVanBan> list = findByG_(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last linh vuc van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByG__Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = fetchByG__Last(groupId, orderByComparator);

		if (linhVucVanBan != null) {
			return linhVucVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinhVucVanBanException(msg.toString());
	}

	/**
	 * Returns the last linh vuc van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByG__Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_(groupId);

		if (count == 0) {
			return null;
		}

		List<LinhVucVanBan> list = findByG_(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the linh vuc van bans before and after the current linh vuc van ban in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current linh vuc van ban
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan[] findByG__PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LinhVucVanBan[] array = new LinhVucVanBanImpl[3];

			array[0] = getByG__PrevAndNext(session, linhVucVanBan, groupId,
					orderByComparator, true);

			array[1] = linhVucVanBan;

			array[2] = getByG__PrevAndNext(session, linhVucVanBan, groupId,
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

	protected LinhVucVanBan getByG__PrevAndNext(Session session,
		LinhVucVanBan linhVucVanBan, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINHVUCVANBAN_WHERE);

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
			query.append(LinhVucVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(linhVucVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LinhVucVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the linh vuc van bans where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_(long groupId) throws SystemException {
		for (LinhVucVanBan linhVucVanBan : findByG_(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(linhVucVanBan);
		}
	}

	/**
	 * Returns the number of linh vuc van bans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching linh vuc van bans
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

			query.append(_SQL_COUNT_LINHVUCVANBAN_WHERE);

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

	private static final String _FINDER_COLUMN_G__GROUPID_2 = "linhVucVanBan.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTrangThai",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			LinhVucVanBanModelImpl.TRANGTHAI_COLUMN_BITMASK |
			LinhVucVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			LinhVucVanBanModelImpl.ORDER__COLUMN_BITMASK |
			LinhVucVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Boolean.class.getName(), Long.class.getName() });

	/**
	 * Returns all the linh vuc van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @return the matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByTrangThai(boolean trangThai, long groupId)
		throws SystemException {
		return findByTrangThai(trangThai, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linh vuc van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param start the lower bound of the range of linh vuc van bans
	 * @param end the upper bound of the range of linh vuc van bans (not inclusive)
	 * @return the range of matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByTrangThai(boolean trangThai, long groupId,
		int start, int end) throws SystemException {
		return findByTrangThai(trangThai, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the linh vuc van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param start the lower bound of the range of linh vuc van bans
	 * @param end the upper bound of the range of linh vuc van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByTrangThai(boolean trangThai, long groupId,
		int start, int end, OrderByComparator orderByComparator)
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

		List<LinhVucVanBan> list = (List<LinhVucVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LinhVucVanBan linhVucVanBan : list) {
				if ((trangThai != linhVucVanBan.getTrangThai()) ||
						(groupId != linhVucVanBan.getGroupId())) {
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

			query.append(_SQL_SELECT_LINHVUCVANBAN_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

			query.append(_FINDER_COLUMN_TRANGTHAI_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LinhVucVanBanModelImpl.ORDER_BY_JPQL);
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
					list = (List<LinhVucVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LinhVucVanBan>(list);
				}
				else {
					list = (List<LinhVucVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByTrangThai_First(boolean trangThai, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = fetchByTrangThai_First(trangThai,
				groupId, orderByComparator);

		if (linhVucVanBan != null) {
			return linhVucVanBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinhVucVanBanException(msg.toString());
	}

	/**
	 * Returns the first linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByTrangThai_First(boolean trangThai,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<LinhVucVanBan> list = findByTrangThai(trangThai, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByTrangThai_Last(boolean trangThai, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = fetchByTrangThai_Last(trangThai, groupId,
				orderByComparator);

		if (linhVucVanBan != null) {
			return linhVucVanBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinhVucVanBanException(msg.toString());
	}

	/**
	 * Returns the last linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByTrangThai_Last(boolean trangThai, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTrangThai(trangThai, groupId);

		if (count == 0) {
			return null;
		}

		List<LinhVucVanBan> list = findByTrangThai(trangThai, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the linh vuc van bans before and after the current linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current linh vuc van ban
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan[] findByTrangThai_PrevAndNext(long id,
		boolean trangThai, long groupId, OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LinhVucVanBan[] array = new LinhVucVanBanImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, linhVucVanBan,
					trangThai, groupId, orderByComparator, true);

			array[1] = linhVucVanBan;

			array[2] = getByTrangThai_PrevAndNext(session, linhVucVanBan,
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

	protected LinhVucVanBan getByTrangThai_PrevAndNext(Session session,
		LinhVucVanBan linhVucVanBan, boolean trangThai, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINHVUCVANBAN_WHERE);

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
			query.append(LinhVucVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(trangThai);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(linhVucVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LinhVucVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the linh vuc van bans where trangThai = &#63; and groupId = &#63; from the database.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTrangThai(boolean trangThai, long groupId)
		throws SystemException {
		for (LinhVucVanBan linhVucVanBan : findByTrangThai(trangThai, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(linhVucVanBan);
		}
	}

	/**
	 * Returns the number of linh vuc van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @return the number of matching linh vuc van bans
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

			query.append(_SQL_COUNT_LINHVUCVANBAN_WHERE);

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

	private static final String _FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2 = "linhVucVanBan.trangThai = ? AND ";
	private static final String _FINDER_COLUMN_TRANGTHAI_GROUPID_2 = "linhVucVanBan.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID_TEN = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGroupId_Ten",
			new String[] { Long.class.getName(), String.class.getName() },
			LinhVucVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			LinhVucVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_TEN = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Ten",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the linh vuc van ban where groupId = &#63; and ten = &#63; or throws a {@link com.viettel.portal.vbpq.NoSuchLinhVucVanBanException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the matching linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByGroupId_Ten(long groupId, String ten)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = fetchByGroupId_Ten(groupId, ten);

		if (linhVucVanBan == null) {
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

			throw new NoSuchLinhVucVanBanException(msg.toString());
		}

		return linhVucVanBan;
	}

	/**
	 * Returns the linh vuc van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByGroupId_Ten(long groupId, String ten)
		throws SystemException {
		return fetchByGroupId_Ten(groupId, ten, true);
	}

	/**
	 * Returns the linh vuc van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByGroupId_Ten(long groupId, String ten,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
					finderArgs, this);
		}

		if (result instanceof LinhVucVanBan) {
			LinhVucVanBan linhVucVanBan = (LinhVucVanBan)result;

			if ((groupId != linhVucVanBan.getGroupId()) ||
					!Validator.equals(ten, linhVucVanBan.getTen())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LINHVUCVANBAN_WHERE);

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

				List<LinhVucVanBan> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LinhVucVanBanPersistenceImpl.fetchByGroupId_Ten(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LinhVucVanBan linhVucVanBan = list.get(0);

					result = linhVucVanBan;

					cacheResult(linhVucVanBan);

					if ((linhVucVanBan.getGroupId() != groupId) ||
							(linhVucVanBan.getTen() == null) ||
							!linhVucVanBan.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
							finderArgs, linhVucVanBan);
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
			return (LinhVucVanBan)result;
		}
	}

	/**
	 * Removes the linh vuc van ban where groupId = &#63; and ten = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the linh vuc van ban that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan removeByGroupId_Ten(long groupId, String ten)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = findByGroupId_Ten(groupId, ten);

		return remove(linhVucVanBan);
	}

	/**
	 * Returns the number of linh vuc van bans where groupId = &#63; and ten = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the number of matching linh vuc van bans
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

			query.append(_SQL_COUNT_LINHVUCVANBAN_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_TEN_GROUPID_2 = "linhVucVanBan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_1 = "linhVucVanBan.ten IS NULL";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_2 = "linhVucVanBan.ten = ?";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_3 = "(linhVucVanBan.ten IS NULL OR linhVucVanBan.ten = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NHOMVANBANID =
		new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNhomVanBanId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID =
		new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
			LinhVucVanBanImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNhomVanBanId", new String[] { Long.class.getName() },
			LinhVucVanBanModelImpl.NHOMVANBANID_COLUMN_BITMASK |
			LinhVucVanBanModelImpl.ORDER__COLUMN_BITMASK |
			LinhVucVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NHOMVANBANID = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNhomVanBanId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the linh vuc van bans where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @return the matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByNhomVanBanId(long nhomVanBanId)
		throws SystemException {
		return findByNhomVanBanId(nhomVanBanId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linh vuc van bans where nhomVanBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param start the lower bound of the range of linh vuc van bans
	 * @param end the upper bound of the range of linh vuc van bans (not inclusive)
	 * @return the range of matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByNhomVanBanId(long nhomVanBanId, int start,
		int end) throws SystemException {
		return findByNhomVanBanId(nhomVanBanId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the linh vuc van bans where nhomVanBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param start the lower bound of the range of linh vuc van bans
	 * @param end the upper bound of the range of linh vuc van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findByNhomVanBanId(long nhomVanBanId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<LinhVucVanBan> list = (List<LinhVucVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LinhVucVanBan linhVucVanBan : list) {
				if ((nhomVanBanId != linhVucVanBan.getNhomVanBanId())) {
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

			query.append(_SQL_SELECT_LINHVUCVANBAN_WHERE);

			query.append(_FINDER_COLUMN_NHOMVANBANID_NHOMVANBANID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LinhVucVanBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomVanBanId);

				if (!pagination) {
					list = (List<LinhVucVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LinhVucVanBan>(list);
				}
				else {
					list = (List<LinhVucVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByNhomVanBanId_First(long nhomVanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = fetchByNhomVanBanId_First(nhomVanBanId,
				orderByComparator);

		if (linhVucVanBan != null) {
			return linhVucVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomVanBanId=");
		msg.append(nhomVanBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinhVucVanBanException(msg.toString());
	}

	/**
	 * Returns the first linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByNhomVanBanId_First(long nhomVanBanId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LinhVucVanBan> list = findByNhomVanBanId(nhomVanBanId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByNhomVanBanId_Last(long nhomVanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = fetchByNhomVanBanId_Last(nhomVanBanId,
				orderByComparator);

		if (linhVucVanBan != null) {
			return linhVucVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomVanBanId=");
		msg.append(nhomVanBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinhVucVanBanException(msg.toString());
	}

	/**
	 * Returns the last linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByNhomVanBanId_Last(long nhomVanBanId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNhomVanBanId(nhomVanBanId);

		if (count == 0) {
			return null;
		}

		List<LinhVucVanBan> list = findByNhomVanBanId(nhomVanBanId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the linh vuc van bans before and after the current linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param id the primary key of the current linh vuc van ban
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan[] findByNhomVanBanId_PrevAndNext(long id,
		long nhomVanBanId, OrderByComparator orderByComparator)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LinhVucVanBan[] array = new LinhVucVanBanImpl[3];

			array[0] = getByNhomVanBanId_PrevAndNext(session, linhVucVanBan,
					nhomVanBanId, orderByComparator, true);

			array[1] = linhVucVanBan;

			array[2] = getByNhomVanBanId_PrevAndNext(session, linhVucVanBan,
					nhomVanBanId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinhVucVanBan getByNhomVanBanId_PrevAndNext(Session session,
		LinhVucVanBan linhVucVanBan, long nhomVanBanId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINHVUCVANBAN_WHERE);

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
			query.append(LinhVucVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nhomVanBanId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(linhVucVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LinhVucVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the linh vuc van bans where nhomVanBanId = &#63; from the database.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNhomVanBanId(long nhomVanBanId)
		throws SystemException {
		for (LinhVucVanBan linhVucVanBan : findByNhomVanBanId(nhomVanBanId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(linhVucVanBan);
		}
	}

	/**
	 * Returns the number of linh vuc van bans where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @return the number of matching linh vuc van bans
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

			query.append(_SQL_COUNT_LINHVUCVANBAN_WHERE);

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

	private static final String _FINDER_COLUMN_NHOMVANBANID_NHOMVANBANID_2 = "linhVucVanBan.nhomVanBanId = ?";

	public LinhVucVanBanPersistenceImpl() {
		setModelClass(LinhVucVanBan.class);
	}

	/**
	 * Caches the linh vuc van ban in the entity cache if it is enabled.
	 *
	 * @param linhVucVanBan the linh vuc van ban
	 */
	@Override
	public void cacheResult(LinhVucVanBan linhVucVanBan) {
		EntityCacheUtil.putResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey(),
			linhVucVanBan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
			new Object[] { linhVucVanBan.getGroupId(), linhVucVanBan.getTen() },
			linhVucVanBan);

		linhVucVanBan.resetOriginalValues();
	}

	/**
	 * Caches the linh vuc van bans in the entity cache if it is enabled.
	 *
	 * @param linhVucVanBans the linh vuc van bans
	 */
	@Override
	public void cacheResult(List<LinhVucVanBan> linhVucVanBans) {
		for (LinhVucVanBan linhVucVanBan : linhVucVanBans) {
			if (EntityCacheUtil.getResult(
						LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
						LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey()) == null) {
				cacheResult(linhVucVanBan);
			}
			else {
				linhVucVanBan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all linh vuc van bans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LinhVucVanBanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LinhVucVanBanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the linh vuc van ban.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LinhVucVanBan linhVucVanBan) {
		EntityCacheUtil.removeResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(linhVucVanBan);
	}

	@Override
	public void clearCache(List<LinhVucVanBan> linhVucVanBans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LinhVucVanBan linhVucVanBan : linhVucVanBans) {
			EntityCacheUtil.removeResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
				LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey());

			clearUniqueFindersCache(linhVucVanBan);
		}
	}

	protected void cacheUniqueFindersCache(LinhVucVanBan linhVucVanBan) {
		if (linhVucVanBan.isNew()) {
			Object[] args = new Object[] {
					linhVucVanBan.getGroupId(), linhVucVanBan.getTen()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args,
				linhVucVanBan);
		}
		else {
			LinhVucVanBanModelImpl linhVucVanBanModelImpl = (LinhVucVanBanModelImpl)linhVucVanBan;

			if ((linhVucVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						linhVucVanBan.getGroupId(), linhVucVanBan.getTen()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_TEN,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
					args, linhVucVanBan);
			}
		}
	}

	protected void clearUniqueFindersCache(LinhVucVanBan linhVucVanBan) {
		LinhVucVanBanModelImpl linhVucVanBanModelImpl = (LinhVucVanBanModelImpl)linhVucVanBan;

		Object[] args = new Object[] {
				linhVucVanBan.getGroupId(), linhVucVanBan.getTen()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args);

		if ((linhVucVanBanModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID_TEN.getColumnBitmask()) != 0) {
			args = new Object[] {
					linhVucVanBanModelImpl.getOriginalGroupId(),
					linhVucVanBanModelImpl.getOriginalTen()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args);
		}
	}

	/**
	 * Creates a new linh vuc van ban with the primary key. Does not add the linh vuc van ban to the database.
	 *
	 * @param id the primary key for the new linh vuc van ban
	 * @return the new linh vuc van ban
	 */
	@Override
	public LinhVucVanBan create(long id) {
		LinhVucVanBan linhVucVanBan = new LinhVucVanBanImpl();

		linhVucVanBan.setNew(true);
		linhVucVanBan.setPrimaryKey(id);

		return linhVucVanBan;
	}

	/**
	 * Removes the linh vuc van ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the linh vuc van ban
	 * @return the linh vuc van ban that was removed
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan remove(long id)
		throws NoSuchLinhVucVanBanException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the linh vuc van ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the linh vuc van ban
	 * @return the linh vuc van ban that was removed
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan remove(Serializable primaryKey)
		throws NoSuchLinhVucVanBanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LinhVucVanBan linhVucVanBan = (LinhVucVanBan)session.get(LinhVucVanBanImpl.class,
					primaryKey);

			if (linhVucVanBan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinhVucVanBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(linhVucVanBan);
		}
		catch (NoSuchLinhVucVanBanException nsee) {
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
	protected LinhVucVanBan removeImpl(LinhVucVanBan linhVucVanBan)
		throws SystemException {
		linhVucVanBan = toUnwrappedModel(linhVucVanBan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(linhVucVanBan)) {
				linhVucVanBan = (LinhVucVanBan)session.get(LinhVucVanBanImpl.class,
						linhVucVanBan.getPrimaryKeyObj());
			}

			if (linhVucVanBan != null) {
				session.delete(linhVucVanBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (linhVucVanBan != null) {
			clearCache(linhVucVanBan);
		}

		return linhVucVanBan;
	}

	@Override
	public LinhVucVanBan updateImpl(
		com.viettel.portal.vbpq.model.LinhVucVanBan linhVucVanBan)
		throws SystemException {
		linhVucVanBan = toUnwrappedModel(linhVucVanBan);

		boolean isNew = linhVucVanBan.isNew();

		LinhVucVanBanModelImpl linhVucVanBanModelImpl = (LinhVucVanBanModelImpl)linhVucVanBan;

		Session session = null;

		try {
			session = openSession();

			if (linhVucVanBan.isNew()) {
				session.save(linhVucVanBan);

				linhVucVanBan.setNew(false);
			}
			else {
				session.merge(linhVucVanBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LinhVucVanBanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((linhVucVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						linhVucVanBanModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_,
					args);

				args = new Object[] { linhVucVanBanModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_,
					args);
			}

			if ((linhVucVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						linhVucVanBanModelImpl.getOriginalTrangThai(),
						linhVucVanBanModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						linhVucVanBanModelImpl.getTrangThai(),
						linhVucVanBanModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((linhVucVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						linhVucVanBanModelImpl.getOriginalNhomVanBanId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NHOMVANBANID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID,
					args);

				args = new Object[] { linhVucVanBanModelImpl.getNhomVanBanId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NHOMVANBANID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID,
					args);
			}
		}

		EntityCacheUtil.putResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey(),
			linhVucVanBan);

		clearUniqueFindersCache(linhVucVanBan);
		cacheUniqueFindersCache(linhVucVanBan);

		return linhVucVanBan;
	}

	protected LinhVucVanBan toUnwrappedModel(LinhVucVanBan linhVucVanBan) {
		if (linhVucVanBan instanceof LinhVucVanBanImpl) {
			return linhVucVanBan;
		}

		LinhVucVanBanImpl linhVucVanBanImpl = new LinhVucVanBanImpl();

		linhVucVanBanImpl.setNew(linhVucVanBan.isNew());
		linhVucVanBanImpl.setPrimaryKey(linhVucVanBan.getPrimaryKey());

		linhVucVanBanImpl.setId(linhVucVanBan.getId());
		linhVucVanBanImpl.setTen(linhVucVanBan.getTen());
		linhVucVanBanImpl.setTrangThai(linhVucVanBan.isTrangThai());
		linhVucVanBanImpl.setNgayTao(linhVucVanBan.getNgayTao());
		linhVucVanBanImpl.setNgaySua(linhVucVanBan.getNgaySua());
		linhVucVanBanImpl.setNguoiTao(linhVucVanBan.getNguoiTao());
		linhVucVanBanImpl.setNguoiSua(linhVucVanBan.getNguoiSua());
		linhVucVanBanImpl.setGroupId(linhVucVanBan.getGroupId());
		linhVucVanBanImpl.setOrder_(linhVucVanBan.getOrder_());
		linhVucVanBanImpl.setNhomVanBanId(linhVucVanBan.getNhomVanBanId());

		return linhVucVanBanImpl;
	}

	/**
	 * Returns the linh vuc van ban with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the linh vuc van ban
	 * @return the linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLinhVucVanBanException, SystemException {
		LinhVucVanBan linhVucVanBan = fetchByPrimaryKey(primaryKey);

		if (linhVucVanBan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLinhVucVanBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return linhVucVanBan;
	}

	/**
	 * Returns the linh vuc van ban with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchLinhVucVanBanException} if it could not be found.
	 *
	 * @param id the primary key of the linh vuc van ban
	 * @return the linh vuc van ban
	 * @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan findByPrimaryKey(long id)
		throws NoSuchLinhVucVanBanException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the linh vuc van ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the linh vuc van ban
	 * @return the linh vuc van ban, or <code>null</code> if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LinhVucVanBan linhVucVanBan = (LinhVucVanBan)EntityCacheUtil.getResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
				LinhVucVanBanImpl.class, primaryKey);

		if (linhVucVanBan == _nullLinhVucVanBan) {
			return null;
		}

		if (linhVucVanBan == null) {
			Session session = null;

			try {
				session = openSession();

				linhVucVanBan = (LinhVucVanBan)session.get(LinhVucVanBanImpl.class,
						primaryKey);

				if (linhVucVanBan != null) {
					cacheResult(linhVucVanBan);
				}
				else {
					EntityCacheUtil.putResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
						LinhVucVanBanImpl.class, primaryKey, _nullLinhVucVanBan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
					LinhVucVanBanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return linhVucVanBan;
	}

	/**
	 * Returns the linh vuc van ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the linh vuc van ban
	 * @return the linh vuc van ban, or <code>null</code> if a linh vuc van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinhVucVanBan fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the linh vuc van bans.
	 *
	 * @return the linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linh vuc van bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of linh vuc van bans
	 * @param end the upper bound of the range of linh vuc van bans (not inclusive)
	 * @return the range of linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the linh vuc van bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of linh vuc van bans
	 * @param end the upper bound of the range of linh vuc van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of linh vuc van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinhVucVanBan> findAll(int start, int end,
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

		List<LinhVucVanBan> list = (List<LinhVucVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LINHVUCVANBAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LINHVUCVANBAN;

				if (pagination) {
					sql = sql.concat(LinhVucVanBanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LinhVucVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LinhVucVanBan>(list);
				}
				else {
					list = (List<LinhVucVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the linh vuc van bans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LinhVucVanBan linhVucVanBan : findAll()) {
			remove(linhVucVanBan);
		}
	}

	/**
	 * Returns the number of linh vuc van bans.
	 *
	 * @return the number of linh vuc van bans
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

				Query q = session.createQuery(_SQL_COUNT_LINHVUCVANBAN);

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
	 * Initializes the linh vuc van ban persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vbpq.model.LinhVucVanBan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LinhVucVanBan>> listenersList = new ArrayList<ModelListener<LinhVucVanBan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LinhVucVanBan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LinhVucVanBanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LINHVUCVANBAN = "SELECT linhVucVanBan FROM LinhVucVanBan linhVucVanBan";
	private static final String _SQL_SELECT_LINHVUCVANBAN_WHERE = "SELECT linhVucVanBan FROM LinhVucVanBan linhVucVanBan WHERE ";
	private static final String _SQL_COUNT_LINHVUCVANBAN = "SELECT COUNT(linhVucVanBan) FROM LinhVucVanBan linhVucVanBan";
	private static final String _SQL_COUNT_LINHVUCVANBAN_WHERE = "SELECT COUNT(linhVucVanBan) FROM LinhVucVanBan linhVucVanBan WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "linhVucVanBan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LinhVucVanBan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LinhVucVanBan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LinhVucVanBanPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "ten", "trangThai", "ngayTao", "ngaySua", "nguoiTao",
				"nguoiSua", "groupId", "order_"
			});
	private static LinhVucVanBan _nullLinhVucVanBan = new LinhVucVanBanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LinhVucVanBan> toCacheModel() {
				return _nullLinhVucVanBanCacheModel;
			}
		};

	private static CacheModel<LinhVucVanBan> _nullLinhVucVanBanCacheModel = new CacheModel<LinhVucVanBan>() {
			@Override
			public LinhVucVanBan toEntityModel() {
				return _nullLinhVucVanBan;
			}
		};
}