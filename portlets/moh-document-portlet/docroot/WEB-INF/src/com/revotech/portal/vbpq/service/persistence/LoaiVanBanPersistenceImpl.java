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

package com.revotech.portal.vbpq.service.persistence;

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

import com.revotech.portal.vbpq.NoSuchLoaiVanBanException;
import com.revotech.portal.vbpq.model.LoaiVanBan;
import com.revotech.portal.vbpq.model.impl.LoaiVanBanImpl;
import com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the loai van ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see LoaiVanBanPersistence
 * @see LoaiVanBanUtil
 * @generated
 */
public class LoaiVanBanPersistenceImpl extends BasePersistenceImpl<LoaiVanBan>
	implements LoaiVanBanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LoaiVanBanUtil} to access the loai van ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LoaiVanBanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_ = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_ = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_",
			new String[] { Long.class.getName() },
			LoaiVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			LoaiVanBanModelImpl.ORDER__COLUMN_BITMASK |
			LoaiVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_ = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the loai van bans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByG_(long groupId) throws SystemException {
		return findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loai van bans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loai van bans
	 * @param end the upper bound of the range of loai van bans (not inclusive)
	 * @return the range of matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByG_(long groupId, int start, int end)
		throws SystemException {
		return findByG_(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loai van bans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loai van bans
	 * @param end the upper bound of the range of loai van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByG_(long groupId, int start, int end,
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

		List<LoaiVanBan> list = (List<LoaiVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LoaiVanBan loaiVanBan : list) {
				if ((groupId != loaiVanBan.getGroupId())) {
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

			query.append(_SQL_SELECT_LOAIVANBAN_WHERE);

			query.append(_FINDER_COLUMN_G__GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoaiVanBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LoaiVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LoaiVanBan>(list);
				}
				else {
					list = (List<LoaiVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first loai van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByG__First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = fetchByG__First(groupId, orderByComparator);

		if (loaiVanBan != null) {
			return loaiVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoaiVanBanException(msg.toString());
	}

	/**
	 * Returns the first loai van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByG__First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LoaiVanBan> list = findByG_(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loai van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByG__Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = fetchByG__Last(groupId, orderByComparator);

		if (loaiVanBan != null) {
			return loaiVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoaiVanBanException(msg.toString());
	}

	/**
	 * Returns the last loai van ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByG__Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_(groupId);

		if (count == 0) {
			return null;
		}

		List<LoaiVanBan> list = findByG_(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loai van bans before and after the current loai van ban in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current loai van ban
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan[] findByG__PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LoaiVanBan[] array = new LoaiVanBanImpl[3];

			array[0] = getByG__PrevAndNext(session, loaiVanBan, groupId,
					orderByComparator, true);

			array[1] = loaiVanBan;

			array[2] = getByG__PrevAndNext(session, loaiVanBan, groupId,
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

	protected LoaiVanBan getByG__PrevAndNext(Session session,
		LoaiVanBan loaiVanBan, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAIVANBAN_WHERE);

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
			query.append(LoaiVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loaiVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LoaiVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loai van bans where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_(long groupId) throws SystemException {
		for (LoaiVanBan loaiVanBan : findByG_(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loaiVanBan);
		}
	}

	/**
	 * Returns the number of loai van bans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching loai van bans
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

			query.append(_SQL_COUNT_LOAIVANBAN_WHERE);

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

	private static final String _FINDER_COLUMN_G__GROUPID_2 = "loaiVanBan.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			LoaiVanBanModelImpl.TRANGTHAI_COLUMN_BITMASK |
			LoaiVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			LoaiVanBanModelImpl.ORDER__COLUMN_BITMASK |
			LoaiVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Boolean.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loai van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @return the matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByTrangThai(boolean trangThai, long groupId)
		throws SystemException {
		return findByTrangThai(trangThai, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loai van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loai van bans
	 * @param end the upper bound of the range of loai van bans (not inclusive)
	 * @return the range of matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByTrangThai(boolean trangThai, long groupId,
		int start, int end) throws SystemException {
		return findByTrangThai(trangThai, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loai van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param start the lower bound of the range of loai van bans
	 * @param end the upper bound of the range of loai van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByTrangThai(boolean trangThai, long groupId,
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

		List<LoaiVanBan> list = (List<LoaiVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LoaiVanBan loaiVanBan : list) {
				if ((trangThai != loaiVanBan.getTrangThai()) ||
						(groupId != loaiVanBan.getGroupId())) {
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

			query.append(_SQL_SELECT_LOAIVANBAN_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

			query.append(_FINDER_COLUMN_TRANGTHAI_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoaiVanBanModelImpl.ORDER_BY_JPQL);
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
					list = (List<LoaiVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LoaiVanBan>(list);
				}
				else {
					list = (List<LoaiVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByTrangThai_First(boolean trangThai, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = fetchByTrangThai_First(trangThai, groupId,
				orderByComparator);

		if (loaiVanBan != null) {
			return loaiVanBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoaiVanBanException(msg.toString());
	}

	/**
	 * Returns the first loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByTrangThai_First(boolean trangThai, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LoaiVanBan> list = findByTrangThai(trangThai, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByTrangThai_Last(boolean trangThai, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = fetchByTrangThai_Last(trangThai, groupId,
				orderByComparator);

		if (loaiVanBan != null) {
			return loaiVanBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoaiVanBanException(msg.toString());
	}

	/**
	 * Returns the last loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByTrangThai_Last(boolean trangThai, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTrangThai(trangThai, groupId);

		if (count == 0) {
			return null;
		}

		List<LoaiVanBan> list = findByTrangThai(trangThai, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loai van bans before and after the current loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current loai van ban
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan[] findByTrangThai_PrevAndNext(long id, boolean trangThai,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LoaiVanBan[] array = new LoaiVanBanImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, loaiVanBan,
					trangThai, groupId, orderByComparator, true);

			array[1] = loaiVanBan;

			array[2] = getByTrangThai_PrevAndNext(session, loaiVanBan,
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

	protected LoaiVanBan getByTrangThai_PrevAndNext(Session session,
		LoaiVanBan loaiVanBan, boolean trangThai, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAIVANBAN_WHERE);

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
			query.append(LoaiVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(trangThai);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loaiVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LoaiVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loai van bans where trangThai = &#63; and groupId = &#63; from the database.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTrangThai(boolean trangThai, long groupId)
		throws SystemException {
		for (LoaiVanBan loaiVanBan : findByTrangThai(trangThai, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loaiVanBan);
		}
	}

	/**
	 * Returns the number of loai van bans where trangThai = &#63; and groupId = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param groupId the group ID
	 * @return the number of matching loai van bans
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

			query.append(_SQL_COUNT_LOAIVANBAN_WHERE);

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

	private static final String _FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2 = "loaiVanBan.trangThai = ? AND ";
	private static final String _FINDER_COLUMN_TRANGTHAI_GROUPID_2 = "loaiVanBan.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID_TEN = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupId_Ten",
			new String[] { Long.class.getName(), String.class.getName() },
			LoaiVanBanModelImpl.GROUPID_COLUMN_BITMASK |
			LoaiVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_TEN = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Ten",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the loai van ban where groupId = &#63; and ten = &#63; or throws a {@link com.revotech.portal.vbpq.NoSuchLoaiVanBanException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the matching loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByGroupId_Ten(long groupId, String ten)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = fetchByGroupId_Ten(groupId, ten);

		if (loaiVanBan == null) {
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

			throw new NoSuchLoaiVanBanException(msg.toString());
		}

		return loaiVanBan;
	}

	/**
	 * Returns the loai van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByGroupId_Ten(long groupId, String ten)
		throws SystemException {
		return fetchByGroupId_Ten(groupId, ten, true);
	}

	/**
	 * Returns the loai van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByGroupId_Ten(long groupId, String ten,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
					finderArgs, this);
		}

		if (result instanceof LoaiVanBan) {
			LoaiVanBan loaiVanBan = (LoaiVanBan)result;

			if ((groupId != loaiVanBan.getGroupId()) ||
					!Validator.equals(ten, loaiVanBan.getTen())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LOAIVANBAN_WHERE);

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

				List<LoaiVanBan> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LoaiVanBanPersistenceImpl.fetchByGroupId_Ten(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LoaiVanBan loaiVanBan = list.get(0);

					result = loaiVanBan;

					cacheResult(loaiVanBan);

					if ((loaiVanBan.getGroupId() != groupId) ||
							(loaiVanBan.getTen() == null) ||
							!loaiVanBan.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
							finderArgs, loaiVanBan);
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
			return (LoaiVanBan)result;
		}
	}

	/**
	 * Removes the loai van ban where groupId = &#63; and ten = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the loai van ban that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan removeByGroupId_Ten(long groupId, String ten)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = findByGroupId_Ten(groupId, ten);

		return remove(loaiVanBan);
	}

	/**
	 * Returns the number of loai van bans where groupId = &#63; and ten = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ten the ten
	 * @return the number of matching loai van bans
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

			query.append(_SQL_COUNT_LOAIVANBAN_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_TEN_GROUPID_2 = "loaiVanBan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_1 = "loaiVanBan.ten IS NULL";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_2 = "loaiVanBan.ten = ?";
	private static final String _FINDER_COLUMN_GROUPID_TEN_TEN_3 = "(loaiVanBan.ten IS NULL OR loaiVanBan.ten = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NHOMVANBANID =
		new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNhomVanBanId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID =
		new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, LoaiVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNhomVanBanId",
			new String[] { Long.class.getName() },
			LoaiVanBanModelImpl.NHOMVANBANID_COLUMN_BITMASK |
			LoaiVanBanModelImpl.ORDER__COLUMN_BITMASK |
			LoaiVanBanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NHOMVANBANID = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNhomVanBanId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the loai van bans where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @return the matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByNhomVanBanId(long nhomVanBanId)
		throws SystemException {
		return findByNhomVanBanId(nhomVanBanId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loai van bans where nhomVanBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param start the lower bound of the range of loai van bans
	 * @param end the upper bound of the range of loai van bans (not inclusive)
	 * @return the range of matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByNhomVanBanId(long nhomVanBanId, int start,
		int end) throws SystemException {
		return findByNhomVanBanId(nhomVanBanId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loai van bans where nhomVanBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param start the lower bound of the range of loai van bans
	 * @param end the upper bound of the range of loai van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findByNhomVanBanId(long nhomVanBanId, int start,
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

		List<LoaiVanBan> list = (List<LoaiVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LoaiVanBan loaiVanBan : list) {
				if ((nhomVanBanId != loaiVanBan.getNhomVanBanId())) {
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

			query.append(_SQL_SELECT_LOAIVANBAN_WHERE);

			query.append(_FINDER_COLUMN_NHOMVANBANID_NHOMVANBANID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoaiVanBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomVanBanId);

				if (!pagination) {
					list = (List<LoaiVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LoaiVanBan>(list);
				}
				else {
					list = (List<LoaiVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first loai van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByNhomVanBanId_First(long nhomVanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = fetchByNhomVanBanId_First(nhomVanBanId,
				orderByComparator);

		if (loaiVanBan != null) {
			return loaiVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomVanBanId=");
		msg.append(nhomVanBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoaiVanBanException(msg.toString());
	}

	/**
	 * Returns the first loai van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByNhomVanBanId_First(long nhomVanBanId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LoaiVanBan> list = findByNhomVanBanId(nhomVanBanId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loai van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByNhomVanBanId_Last(long nhomVanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = fetchByNhomVanBanId_Last(nhomVanBanId,
				orderByComparator);

		if (loaiVanBan != null) {
			return loaiVanBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomVanBanId=");
		msg.append(nhomVanBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoaiVanBanException(msg.toString());
	}

	/**
	 * Returns the last loai van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByNhomVanBanId_Last(long nhomVanBanId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNhomVanBanId(nhomVanBanId);

		if (count == 0) {
			return null;
		}

		List<LoaiVanBan> list = findByNhomVanBanId(nhomVanBanId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loai van bans before and after the current loai van ban in the ordered set where nhomVanBanId = &#63;.
	 *
	 * @param id the primary key of the current loai van ban
	 * @param nhomVanBanId the nhom van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan[] findByNhomVanBanId_PrevAndNext(long id,
		long nhomVanBanId, OrderByComparator orderByComparator)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LoaiVanBan[] array = new LoaiVanBanImpl[3];

			array[0] = getByNhomVanBanId_PrevAndNext(session, loaiVanBan,
					nhomVanBanId, orderByComparator, true);

			array[1] = loaiVanBan;

			array[2] = getByNhomVanBanId_PrevAndNext(session, loaiVanBan,
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

	protected LoaiVanBan getByNhomVanBanId_PrevAndNext(Session session,
		LoaiVanBan loaiVanBan, long nhomVanBanId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAIVANBAN_WHERE);

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
			query.append(LoaiVanBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nhomVanBanId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loaiVanBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LoaiVanBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loai van bans where nhomVanBanId = &#63; from the database.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNhomVanBanId(long nhomVanBanId)
		throws SystemException {
		for (LoaiVanBan loaiVanBan : findByNhomVanBanId(nhomVanBanId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loaiVanBan);
		}
	}

	/**
	 * Returns the number of loai van bans where nhomVanBanId = &#63;.
	 *
	 * @param nhomVanBanId the nhom van ban ID
	 * @return the number of matching loai van bans
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

			query.append(_SQL_COUNT_LOAIVANBAN_WHERE);

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

	private static final String _FINDER_COLUMN_NHOMVANBANID_NHOMVANBANID_2 = "loaiVanBan.nhomVanBanId = ?";

	public LoaiVanBanPersistenceImpl() {
		setModelClass(LoaiVanBan.class);
	}

	/**
	 * Caches the loai van ban in the entity cache if it is enabled.
	 *
	 * @param loaiVanBan the loai van ban
	 */
	@Override
	public void cacheResult(LoaiVanBan loaiVanBan) {
		EntityCacheUtil.putResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey(), loaiVanBan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
			new Object[] { loaiVanBan.getGroupId(), loaiVanBan.getTen() },
			loaiVanBan);

		loaiVanBan.resetOriginalValues();
	}

	/**
	 * Caches the loai van bans in the entity cache if it is enabled.
	 *
	 * @param loaiVanBans the loai van bans
	 */
	@Override
	public void cacheResult(List<LoaiVanBan> loaiVanBans) {
		for (LoaiVanBan loaiVanBan : loaiVanBans) {
			if (EntityCacheUtil.getResult(
						LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
						LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey()) == null) {
				cacheResult(loaiVanBan);
			}
			else {
				loaiVanBan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loai van bans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LoaiVanBanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LoaiVanBanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loai van ban.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LoaiVanBan loaiVanBan) {
		EntityCacheUtil.removeResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(loaiVanBan);
	}

	@Override
	public void clearCache(List<LoaiVanBan> loaiVanBans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LoaiVanBan loaiVanBan : loaiVanBans) {
			EntityCacheUtil.removeResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
				LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey());

			clearUniqueFindersCache(loaiVanBan);
		}
	}

	protected void cacheUniqueFindersCache(LoaiVanBan loaiVanBan) {
		if (loaiVanBan.isNew()) {
			Object[] args = new Object[] {
					loaiVanBan.getGroupId(), loaiVanBan.getTen()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args,
				loaiVanBan);
		}
		else {
			LoaiVanBanModelImpl loaiVanBanModelImpl = (LoaiVanBanModelImpl)loaiVanBan;

			if ((loaiVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loaiVanBan.getGroupId(), loaiVanBan.getTen()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_TEN,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_TEN,
					args, loaiVanBan);
			}
		}
	}

	protected void clearUniqueFindersCache(LoaiVanBan loaiVanBan) {
		LoaiVanBanModelImpl loaiVanBanModelImpl = (LoaiVanBanModelImpl)loaiVanBan;

		Object[] args = new Object[] {
				loaiVanBan.getGroupId(), loaiVanBan.getTen()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args);

		if ((loaiVanBanModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID_TEN.getColumnBitmask()) != 0) {
			args = new Object[] {
					loaiVanBanModelImpl.getOriginalGroupId(),
					loaiVanBanModelImpl.getOriginalTen()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_TEN, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_TEN, args);
		}
	}

	/**
	 * Creates a new loai van ban with the primary key. Does not add the loai van ban to the database.
	 *
	 * @param id the primary key for the new loai van ban
	 * @return the new loai van ban
	 */
	@Override
	public LoaiVanBan create(long id) {
		LoaiVanBan loaiVanBan = new LoaiVanBanImpl();

		loaiVanBan.setNew(true);
		loaiVanBan.setPrimaryKey(id);

		return loaiVanBan;
	}

	/**
	 * Removes the loai van ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the loai van ban
	 * @return the loai van ban that was removed
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan remove(long id)
		throws NoSuchLoaiVanBanException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the loai van ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loai van ban
	 * @return the loai van ban that was removed
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan remove(Serializable primaryKey)
		throws NoSuchLoaiVanBanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LoaiVanBan loaiVanBan = (LoaiVanBan)session.get(LoaiVanBanImpl.class,
					primaryKey);

			if (loaiVanBan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoaiVanBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loaiVanBan);
		}
		catch (NoSuchLoaiVanBanException nsee) {
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
	protected LoaiVanBan removeImpl(LoaiVanBan loaiVanBan)
		throws SystemException {
		loaiVanBan = toUnwrappedModel(loaiVanBan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loaiVanBan)) {
				loaiVanBan = (LoaiVanBan)session.get(LoaiVanBanImpl.class,
						loaiVanBan.getPrimaryKeyObj());
			}

			if (loaiVanBan != null) {
				session.delete(loaiVanBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loaiVanBan != null) {
			clearCache(loaiVanBan);
		}

		return loaiVanBan;
	}

	@Override
	public LoaiVanBan updateImpl(
		com.revotech.portal.vbpq.model.LoaiVanBan loaiVanBan)
		throws SystemException {
		loaiVanBan = toUnwrappedModel(loaiVanBan);

		boolean isNew = loaiVanBan.isNew();

		LoaiVanBanModelImpl loaiVanBanModelImpl = (LoaiVanBanModelImpl)loaiVanBan;

		Session session = null;

		try {
			session = openSession();

			if (loaiVanBan.isNew()) {
				session.save(loaiVanBan);

				loaiVanBan.setNew(false);
			}
			else {
				session.merge(loaiVanBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LoaiVanBanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((loaiVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loaiVanBanModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_,
					args);

				args = new Object[] { loaiVanBanModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_,
					args);
			}

			if ((loaiVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loaiVanBanModelImpl.getOriginalTrangThai(),
						loaiVanBanModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						loaiVanBanModelImpl.getTrangThai(),
						loaiVanBanModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((loaiVanBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loaiVanBanModelImpl.getOriginalNhomVanBanId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NHOMVANBANID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID,
					args);

				args = new Object[] { loaiVanBanModelImpl.getNhomVanBanId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NHOMVANBANID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMVANBANID,
					args);
			}
		}

		EntityCacheUtil.putResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey(), loaiVanBan);

		clearUniqueFindersCache(loaiVanBan);
		cacheUniqueFindersCache(loaiVanBan);

		return loaiVanBan;
	}

	protected LoaiVanBan toUnwrappedModel(LoaiVanBan loaiVanBan) {
		if (loaiVanBan instanceof LoaiVanBanImpl) {
			return loaiVanBan;
		}

		LoaiVanBanImpl loaiVanBanImpl = new LoaiVanBanImpl();

		loaiVanBanImpl.setNew(loaiVanBan.isNew());
		loaiVanBanImpl.setPrimaryKey(loaiVanBan.getPrimaryKey());

		loaiVanBanImpl.setId(loaiVanBan.getId());
		loaiVanBanImpl.setTen(loaiVanBan.getTen());
		loaiVanBanImpl.setTrangThai(loaiVanBan.isTrangThai());
		loaiVanBanImpl.setNgayTao(loaiVanBan.getNgayTao());
		loaiVanBanImpl.setNgaySua(loaiVanBan.getNgaySua());
		loaiVanBanImpl.setNguoiTao(loaiVanBan.getNguoiTao());
		loaiVanBanImpl.setNguoiSua(loaiVanBan.getNguoiSua());
		loaiVanBanImpl.setGroupId(loaiVanBan.getGroupId());
		loaiVanBanImpl.setOrder_(loaiVanBan.getOrder_());
		loaiVanBanImpl.setNhomVanBanId(loaiVanBan.getNhomVanBanId());

		return loaiVanBanImpl;
	}

	/**
	 * Returns the loai van ban with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loai van ban
	 * @return the loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoaiVanBanException, SystemException {
		LoaiVanBan loaiVanBan = fetchByPrimaryKey(primaryKey);

		if (loaiVanBan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoaiVanBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loaiVanBan;
	}

	/**
	 * Returns the loai van ban with the primary key or throws a {@link com.revotech.portal.vbpq.NoSuchLoaiVanBanException} if it could not be found.
	 *
	 * @param id the primary key of the loai van ban
	 * @return the loai van ban
	 * @throws com.revotech.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan findByPrimaryKey(long id)
		throws NoSuchLoaiVanBanException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the loai van ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loai van ban
	 * @return the loai van ban, or <code>null</code> if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LoaiVanBan loaiVanBan = (LoaiVanBan)EntityCacheUtil.getResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
				LoaiVanBanImpl.class, primaryKey);

		if (loaiVanBan == _nullLoaiVanBan) {
			return null;
		}

		if (loaiVanBan == null) {
			Session session = null;

			try {
				session = openSession();

				loaiVanBan = (LoaiVanBan)session.get(LoaiVanBanImpl.class,
						primaryKey);

				if (loaiVanBan != null) {
					cacheResult(loaiVanBan);
				}
				else {
					EntityCacheUtil.putResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
						LoaiVanBanImpl.class, primaryKey, _nullLoaiVanBan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
					LoaiVanBanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loaiVanBan;
	}

	/**
	 * Returns the loai van ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the loai van ban
	 * @return the loai van ban, or <code>null</code> if a loai van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LoaiVanBan fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the loai van bans.
	 *
	 * @return the loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loai van bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai van bans
	 * @param end the upper bound of the range of loai van bans (not inclusive)
	 * @return the range of loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loai van bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai van bans
	 * @param end the upper bound of the range of loai van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loai van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LoaiVanBan> findAll(int start, int end,
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

		List<LoaiVanBan> list = (List<LoaiVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOAIVANBAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOAIVANBAN;

				if (pagination) {
					sql = sql.concat(LoaiVanBanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LoaiVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LoaiVanBan>(list);
				}
				else {
					list = (List<LoaiVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the loai van bans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LoaiVanBan loaiVanBan : findAll()) {
			remove(loaiVanBan);
		}
	}

	/**
	 * Returns the number of loai van bans.
	 *
	 * @return the number of loai van bans
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

				Query q = session.createQuery(_SQL_COUNT_LOAIVANBAN);

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
	 * Initializes the loai van ban persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.revotech.portal.vbpq.model.LoaiVanBan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LoaiVanBan>> listenersList = new ArrayList<ModelListener<LoaiVanBan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LoaiVanBan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LoaiVanBanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOAIVANBAN = "SELECT loaiVanBan FROM LoaiVanBan loaiVanBan";
	private static final String _SQL_SELECT_LOAIVANBAN_WHERE = "SELECT loaiVanBan FROM LoaiVanBan loaiVanBan WHERE ";
	private static final String _SQL_COUNT_LOAIVANBAN = "SELECT COUNT(loaiVanBan) FROM LoaiVanBan loaiVanBan";
	private static final String _SQL_COUNT_LOAIVANBAN_WHERE = "SELECT COUNT(loaiVanBan) FROM LoaiVanBan loaiVanBan WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loaiVanBan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LoaiVanBan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LoaiVanBan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LoaiVanBanPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "ten", "trangThai", "ngayTao", "ngaySua", "nguoiTao",
				"nguoiSua", "groupId", "order_"
			});
	private static LoaiVanBan _nullLoaiVanBan = new LoaiVanBanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LoaiVanBan> toCacheModel() {
				return _nullLoaiVanBanCacheModel;
			}
		};

	private static CacheModel<LoaiVanBan> _nullLoaiVanBanCacheModel = new CacheModel<LoaiVanBan>() {
			@Override
			public LoaiVanBan toEntityModel() {
				return _nullLoaiVanBan;
			}
		};
}