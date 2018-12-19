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

package com.viettel.portal.thongke.service.persistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;
import com.viettel.portal.thongke.model.BaiVietNhuanBut;
import com.viettel.portal.thongke.model.impl.BaiVietNhuanButImpl;
import com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bai viet nhuan but service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see BaiVietNhuanButPersistence
 * @see BaiVietNhuanButUtil
 * @generated
 */
public class BaiVietNhuanButPersistenceImpl extends BasePersistenceImpl<BaiVietNhuanBut>
	implements BaiVietNhuanButPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BaiVietNhuanButUtil} to access the bai viet nhuan but persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BaiVietNhuanButImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED,
			BaiVietNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED,
			BaiVietNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED,
			BaiVietNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED,
			BaiVietNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			BaiVietNhuanButModelImpl.GROUPID_COLUMN_BITMASK |
			BaiVietNhuanButModelImpl.CREATEDATE_COLUMN_BITMASK |
			BaiVietNhuanButModelImpl.TIEUDE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bai viet nhuan buts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bai viet nhuan buts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of bai viet nhuan buts
	 * @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	 * @return the range of matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bai viet nhuan buts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of bai viet nhuan buts
	 * @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByGroup(long groupId, int start, int end,
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

		List<BaiVietNhuanBut> list = (List<BaiVietNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BaiVietNhuanBut baiVietNhuanBut : list) {
				if ((groupId != baiVietNhuanBut.getGroupId())) {
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

			query.append(_SQL_SELECT_BAIVIETNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BaiVietNhuanButModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<BaiVietNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BaiVietNhuanBut>(list);
				}
				else {
					list = (List<BaiVietNhuanBut>)QueryUtil.list(q,
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
	 * Returns the first bai viet nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = fetchByGroup_First(groupId,
				orderByComparator);

		if (baiVietNhuanBut != null) {
			return baiVietNhuanBut;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBaiVietNhuanButException(msg.toString());
	}

	/**
	 * Returns the first bai viet nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BaiVietNhuanBut> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bai viet nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = fetchByGroup_Last(groupId,
				orderByComparator);

		if (baiVietNhuanBut != null) {
			return baiVietNhuanBut;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBaiVietNhuanButException(msg.toString());
	}

	/**
	 * Returns the last bai viet nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<BaiVietNhuanBut> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bai viet nhuan buts before and after the current bai viet nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current bai viet nhuan but
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut[] findByGroup_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BaiVietNhuanBut[] array = new BaiVietNhuanButImpl[3];

			array[0] = getByGroup_PrevAndNext(session, baiVietNhuanBut,
					groupId, orderByComparator, true);

			array[1] = baiVietNhuanBut;

			array[2] = getByGroup_PrevAndNext(session, baiVietNhuanBut,
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

	protected BaiVietNhuanBut getByGroup_PrevAndNext(Session session,
		BaiVietNhuanBut baiVietNhuanBut, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BAIVIETNHUANBUT_WHERE);

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
			query.append(BaiVietNhuanButModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(baiVietNhuanBut);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BaiVietNhuanBut> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bai viet nhuan buts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (BaiVietNhuanBut baiVietNhuanBut : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(baiVietNhuanBut);
		}
	}

	/**
	 * Returns the number of bai viet nhuan buts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching bai viet nhuan buts
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

			query.append(_SQL_COUNT_BAIVIETNHUANBUT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "baiVietNhuanBut.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDTYPE =
		new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED,
			BaiVietNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDTYPE =
		new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED,
			BaiVietNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndType",
			new String[] { Long.class.getName(), Integer.class.getName() },
			BaiVietNhuanButModelImpl.GROUPID_COLUMN_BITMASK |
			BaiVietNhuanButModelImpl.TYPE_COLUMN_BITMASK |
			BaiVietNhuanButModelImpl.CREATEDATE_COLUMN_BITMASK |
			BaiVietNhuanButModelImpl.TIEUDE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDTYPE = new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndType",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the bai viet nhuan buts where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @return the matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByGroupAndType(long groupId, int type)
		throws SystemException {
		return findByGroupAndType(groupId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bai viet nhuan buts where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param start the lower bound of the range of bai viet nhuan buts
	 * @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	 * @return the range of matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByGroupAndType(long groupId, int type,
		int start, int end) throws SystemException {
		return findByGroupAndType(groupId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bai viet nhuan buts where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param start the lower bound of the range of bai viet nhuan buts
	 * @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByGroupAndType(long groupId, int type,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDTYPE;
			finderArgs = new Object[] { groupId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDTYPE;
			finderArgs = new Object[] {
					groupId, type,
					
					start, end, orderByComparator
				};
		}

		List<BaiVietNhuanBut> list = (List<BaiVietNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BaiVietNhuanBut baiVietNhuanBut : list) {
				if ((groupId != baiVietNhuanBut.getGroupId()) ||
						(type != baiVietNhuanBut.getType())) {
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

			query.append(_SQL_SELECT_BAIVIETNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDTYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDTYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BaiVietNhuanButModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(type);

				if (!pagination) {
					list = (List<BaiVietNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BaiVietNhuanBut>(list);
				}
				else {
					list = (List<BaiVietNhuanBut>)QueryUtil.list(q,
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
	 * Returns the first bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut findByGroupAndType_First(long groupId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = fetchByGroupAndType_First(groupId,
				type, orderByComparator);

		if (baiVietNhuanBut != null) {
			return baiVietNhuanBut;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBaiVietNhuanButException(msg.toString());
	}

	/**
	 * Returns the first bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut fetchByGroupAndType_First(long groupId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		List<BaiVietNhuanBut> list = findByGroupAndType(groupId, type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut findByGroupAndType_Last(long groupId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = fetchByGroupAndType_Last(groupId,
				type, orderByComparator);

		if (baiVietNhuanBut != null) {
			return baiVietNhuanBut;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBaiVietNhuanButException(msg.toString());
	}

	/**
	 * Returns the last bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut fetchByGroupAndType_Last(long groupId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupAndType(groupId, type);

		if (count == 0) {
			return null;
		}

		List<BaiVietNhuanBut> list = findByGroupAndType(groupId, type,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bai viet nhuan buts before and after the current bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param id the primary key of the current bai viet nhuan but
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut[] findByGroupAndType_PrevAndNext(long id,
		long groupId, int type, OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BaiVietNhuanBut[] array = new BaiVietNhuanButImpl[3];

			array[0] = getByGroupAndType_PrevAndNext(session, baiVietNhuanBut,
					groupId, type, orderByComparator, true);

			array[1] = baiVietNhuanBut;

			array[2] = getByGroupAndType_PrevAndNext(session, baiVietNhuanBut,
					groupId, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BaiVietNhuanBut getByGroupAndType_PrevAndNext(Session session,
		BaiVietNhuanBut baiVietNhuanBut, long groupId, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BAIVIETNHUANBUT_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDTYPE_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDTYPE_TYPE_2);

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
			query.append(BaiVietNhuanButModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(baiVietNhuanBut);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BaiVietNhuanBut> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bai viet nhuan buts where groupId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndType(long groupId, int type)
		throws SystemException {
		for (BaiVietNhuanBut baiVietNhuanBut : findByGroupAndType(groupId,
				type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(baiVietNhuanBut);
		}
	}

	/**
	 * Returns the number of bai viet nhuan buts where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @return the number of matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupAndType(long groupId, int type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDTYPE;

		Object[] finderArgs = new Object[] { groupId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BAIVIETNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDTYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDTYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(type);

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

	private static final String _FINDER_COLUMN_GROUPANDTYPE_GROUPID_2 = "baiVietNhuanBut.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDTYPE_TYPE_2 = "baiVietNhuanBut.type = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BAIVIETID =
		new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED,
			BaiVietNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBaiVietID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAIVIETID =
		new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED,
			BaiVietNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBaiVietID",
			new String[] { Long.class.getName() },
			BaiVietNhuanButModelImpl.BAIVIETID_COLUMN_BITMASK |
			BaiVietNhuanButModelImpl.CREATEDATE_COLUMN_BITMASK |
			BaiVietNhuanButModelImpl.TIEUDE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BAIVIETID = new FinderPath(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBaiVietID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bai viet nhuan buts where baiVietId = &#63;.
	 *
	 * @param baiVietId the bai viet ID
	 * @return the matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByBaiVietID(long baiVietId)
		throws SystemException {
		return findByBaiVietID(baiVietId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the bai viet nhuan buts where baiVietId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param baiVietId the bai viet ID
	 * @param start the lower bound of the range of bai viet nhuan buts
	 * @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	 * @return the range of matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByBaiVietID(long baiVietId, int start,
		int end) throws SystemException {
		return findByBaiVietID(baiVietId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bai viet nhuan buts where baiVietId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param baiVietId the bai viet ID
	 * @param start the lower bound of the range of bai viet nhuan buts
	 * @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findByBaiVietID(long baiVietId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAIVIETID;
			finderArgs = new Object[] { baiVietId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BAIVIETID;
			finderArgs = new Object[] { baiVietId, start, end, orderByComparator };
		}

		List<BaiVietNhuanBut> list = (List<BaiVietNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BaiVietNhuanBut baiVietNhuanBut : list) {
				if ((baiVietId != baiVietNhuanBut.getBaiVietId())) {
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

			query.append(_SQL_SELECT_BAIVIETNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_BAIVIETID_BAIVIETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BaiVietNhuanButModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(baiVietId);

				if (!pagination) {
					list = (List<BaiVietNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BaiVietNhuanBut>(list);
				}
				else {
					list = (List<BaiVietNhuanBut>)QueryUtil.list(q,
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
	 * Returns the first bai viet nhuan but in the ordered set where baiVietId = &#63;.
	 *
	 * @param baiVietId the bai viet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut findByBaiVietID_First(long baiVietId,
		OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = fetchByBaiVietID_First(baiVietId,
				orderByComparator);

		if (baiVietNhuanBut != null) {
			return baiVietNhuanBut;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("baiVietId=");
		msg.append(baiVietId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBaiVietNhuanButException(msg.toString());
	}

	/**
	 * Returns the first bai viet nhuan but in the ordered set where baiVietId = &#63;.
	 *
	 * @param baiVietId the bai viet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut fetchByBaiVietID_First(long baiVietId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BaiVietNhuanBut> list = findByBaiVietID(baiVietId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bai viet nhuan but in the ordered set where baiVietId = &#63;.
	 *
	 * @param baiVietId the bai viet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut findByBaiVietID_Last(long baiVietId,
		OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = fetchByBaiVietID_Last(baiVietId,
				orderByComparator);

		if (baiVietNhuanBut != null) {
			return baiVietNhuanBut;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("baiVietId=");
		msg.append(baiVietId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBaiVietNhuanButException(msg.toString());
	}

	/**
	 * Returns the last bai viet nhuan but in the ordered set where baiVietId = &#63;.
	 *
	 * @param baiVietId the bai viet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut fetchByBaiVietID_Last(long baiVietId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBaiVietID(baiVietId);

		if (count == 0) {
			return null;
		}

		List<BaiVietNhuanBut> list = findByBaiVietID(baiVietId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bai viet nhuan buts before and after the current bai viet nhuan but in the ordered set where baiVietId = &#63;.
	 *
	 * @param id the primary key of the current bai viet nhuan but
	 * @param baiVietId the bai viet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut[] findByBaiVietID_PrevAndNext(long id,
		long baiVietId, OrderByComparator orderByComparator)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BaiVietNhuanBut[] array = new BaiVietNhuanButImpl[3];

			array[0] = getByBaiVietID_PrevAndNext(session, baiVietNhuanBut,
					baiVietId, orderByComparator, true);

			array[1] = baiVietNhuanBut;

			array[2] = getByBaiVietID_PrevAndNext(session, baiVietNhuanBut,
					baiVietId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BaiVietNhuanBut getByBaiVietID_PrevAndNext(Session session,
		BaiVietNhuanBut baiVietNhuanBut, long baiVietId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BAIVIETNHUANBUT_WHERE);

		query.append(_FINDER_COLUMN_BAIVIETID_BAIVIETID_2);

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
			query.append(BaiVietNhuanButModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(baiVietId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(baiVietNhuanBut);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BaiVietNhuanBut> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bai viet nhuan buts where baiVietId = &#63; from the database.
	 *
	 * @param baiVietId the bai viet ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBaiVietID(long baiVietId) throws SystemException {
		for (BaiVietNhuanBut baiVietNhuanBut : findByBaiVietID(baiVietId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(baiVietNhuanBut);
		}
	}

	/**
	 * Returns the number of bai viet nhuan buts where baiVietId = &#63;.
	 *
	 * @param baiVietId the bai viet ID
	 * @return the number of matching bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBaiVietID(long baiVietId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BAIVIETID;

		Object[] finderArgs = new Object[] { baiVietId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BAIVIETNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_BAIVIETID_BAIVIETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(baiVietId);

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

	private static final String _FINDER_COLUMN_BAIVIETID_BAIVIETID_2 = "baiVietNhuanBut.baiVietId = ?";

	public BaiVietNhuanButPersistenceImpl() {
		setModelClass(BaiVietNhuanBut.class);
	}

	/**
	 * Caches the bai viet nhuan but in the entity cache if it is enabled.
	 *
	 * @param baiVietNhuanBut the bai viet nhuan but
	 */
	@Override
	public void cacheResult(BaiVietNhuanBut baiVietNhuanBut) {
		EntityCacheUtil.putResult(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButImpl.class, baiVietNhuanBut.getPrimaryKey(),
			baiVietNhuanBut);

		baiVietNhuanBut.resetOriginalValues();
	}

	/**
	 * Caches the bai viet nhuan buts in the entity cache if it is enabled.
	 *
	 * @param baiVietNhuanButs the bai viet nhuan buts
	 */
	@Override
	public void cacheResult(List<BaiVietNhuanBut> baiVietNhuanButs) {
		for (BaiVietNhuanBut baiVietNhuanBut : baiVietNhuanButs) {
			if (EntityCacheUtil.getResult(
						BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
						BaiVietNhuanButImpl.class,
						baiVietNhuanBut.getPrimaryKey()) == null) {
				cacheResult(baiVietNhuanBut);
			}
			else {
				baiVietNhuanBut.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bai viet nhuan buts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BaiVietNhuanButImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BaiVietNhuanButImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bai viet nhuan but.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BaiVietNhuanBut baiVietNhuanBut) {
		EntityCacheUtil.removeResult(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButImpl.class, baiVietNhuanBut.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BaiVietNhuanBut> baiVietNhuanButs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BaiVietNhuanBut baiVietNhuanBut : baiVietNhuanButs) {
			EntityCacheUtil.removeResult(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
				BaiVietNhuanButImpl.class, baiVietNhuanBut.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bai viet nhuan but with the primary key. Does not add the bai viet nhuan but to the database.
	 *
	 * @param id the primary key for the new bai viet nhuan but
	 * @return the new bai viet nhuan but
	 */
	@Override
	public BaiVietNhuanBut create(long id) {
		BaiVietNhuanBut baiVietNhuanBut = new BaiVietNhuanButImpl();

		baiVietNhuanBut.setNew(true);
		baiVietNhuanBut.setPrimaryKey(id);

		return baiVietNhuanBut;
	}

	/**
	 * Removes the bai viet nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bai viet nhuan but
	 * @return the bai viet nhuan but that was removed
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut remove(long id)
		throws NoSuchBaiVietNhuanButException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the bai viet nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bai viet nhuan but
	 * @return the bai viet nhuan but that was removed
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut remove(Serializable primaryKey)
		throws NoSuchBaiVietNhuanButException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BaiVietNhuanBut baiVietNhuanBut = (BaiVietNhuanBut)session.get(BaiVietNhuanButImpl.class,
					primaryKey);

			if (baiVietNhuanBut == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBaiVietNhuanButException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(baiVietNhuanBut);
		}
		catch (NoSuchBaiVietNhuanButException nsee) {
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
	protected BaiVietNhuanBut removeImpl(BaiVietNhuanBut baiVietNhuanBut)
		throws SystemException {
		baiVietNhuanBut = toUnwrappedModel(baiVietNhuanBut);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(baiVietNhuanBut)) {
				baiVietNhuanBut = (BaiVietNhuanBut)session.get(BaiVietNhuanButImpl.class,
						baiVietNhuanBut.getPrimaryKeyObj());
			}

			if (baiVietNhuanBut != null) {
				session.delete(baiVietNhuanBut);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (baiVietNhuanBut != null) {
			clearCache(baiVietNhuanBut);
		}

		return baiVietNhuanBut;
	}

	@Override
	public BaiVietNhuanBut updateImpl(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws SystemException {
		baiVietNhuanBut = toUnwrappedModel(baiVietNhuanBut);

		boolean isNew = baiVietNhuanBut.isNew();

		BaiVietNhuanButModelImpl baiVietNhuanButModelImpl = (BaiVietNhuanButModelImpl)baiVietNhuanBut;

		Session session = null;

		try {
			session = openSession();

			if (baiVietNhuanBut.isNew()) {
				session.save(baiVietNhuanBut);

				baiVietNhuanBut.setNew(false);
			}
			else {
				session.merge(baiVietNhuanBut);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BaiVietNhuanButModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((baiVietNhuanButModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						baiVietNhuanButModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { baiVietNhuanButModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((baiVietNhuanButModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						baiVietNhuanButModelImpl.getOriginalGroupId(),
						baiVietNhuanButModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDTYPE,
					args);

				args = new Object[] {
						baiVietNhuanButModelImpl.getGroupId(),
						baiVietNhuanButModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDTYPE,
					args);
			}

			if ((baiVietNhuanButModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAIVIETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						baiVietNhuanButModelImpl.getOriginalBaiVietId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BAIVIETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAIVIETID,
					args);

				args = new Object[] { baiVietNhuanButModelImpl.getBaiVietId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BAIVIETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAIVIETID,
					args);
			}
		}

		EntityCacheUtil.putResult(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			BaiVietNhuanButImpl.class, baiVietNhuanBut.getPrimaryKey(),
			baiVietNhuanBut);

		return baiVietNhuanBut;
	}

	protected BaiVietNhuanBut toUnwrappedModel(BaiVietNhuanBut baiVietNhuanBut) {
		if (baiVietNhuanBut instanceof BaiVietNhuanButImpl) {
			return baiVietNhuanBut;
		}

		BaiVietNhuanButImpl baiVietNhuanButImpl = new BaiVietNhuanButImpl();

		baiVietNhuanButImpl.setNew(baiVietNhuanBut.isNew());
		baiVietNhuanButImpl.setPrimaryKey(baiVietNhuanBut.getPrimaryKey());

		baiVietNhuanButImpl.setId(baiVietNhuanBut.getId());
		baiVietNhuanButImpl.setBaiVietId(baiVietNhuanBut.getBaiVietId());
		baiVietNhuanButImpl.setLoaiBaiViet(baiVietNhuanBut.getLoaiBaiViet());
		baiVietNhuanButImpl.setTieuDe(baiVietNhuanBut.getTieuDe());
		baiVietNhuanButImpl.setTacGia(baiVietNhuanBut.getTacGia());
		baiVietNhuanButImpl.setDiaChi(baiVietNhuanBut.getDiaChi());
		baiVietNhuanButImpl.setNgayXuatBan(baiVietNhuanBut.getNgayXuatBan());
		baiVietNhuanButImpl.setRating(baiVietNhuanBut.getRating());
		baiVietNhuanButImpl.setRatingValue(baiVietNhuanBut.getRatingValue());
		baiVietNhuanButImpl.setCompanyId(baiVietNhuanBut.getCompanyId());
		baiVietNhuanButImpl.setGroupId(baiVietNhuanBut.getGroupId());
		baiVietNhuanButImpl.setCreateDate(baiVietNhuanBut.getCreateDate());
		baiVietNhuanButImpl.setModifyDate(baiVietNhuanBut.getModifyDate());
		baiVietNhuanButImpl.setUserName(baiVietNhuanBut.getUserName());
		baiVietNhuanButImpl.setUserId(baiVietNhuanBut.getUserId());
		baiVietNhuanButImpl.setType(baiVietNhuanBut.getType());

		return baiVietNhuanButImpl;
	}

	/**
	 * Returns the bai viet nhuan but with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bai viet nhuan but
	 * @return the bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBaiVietNhuanButException, SystemException {
		BaiVietNhuanBut baiVietNhuanBut = fetchByPrimaryKey(primaryKey);

		if (baiVietNhuanBut == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBaiVietNhuanButException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return baiVietNhuanBut;
	}

	/**
	 * Returns the bai viet nhuan but with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchBaiVietNhuanButException} if it could not be found.
	 *
	 * @param id the primary key of the bai viet nhuan but
	 * @return the bai viet nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut findByPrimaryKey(long id)
		throws NoSuchBaiVietNhuanButException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bai viet nhuan but with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bai viet nhuan but
	 * @return the bai viet nhuan but, or <code>null</code> if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BaiVietNhuanBut baiVietNhuanBut = (BaiVietNhuanBut)EntityCacheUtil.getResult(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
				BaiVietNhuanButImpl.class, primaryKey);

		if (baiVietNhuanBut == _nullBaiVietNhuanBut) {
			return null;
		}

		if (baiVietNhuanBut == null) {
			Session session = null;

			try {
				session = openSession();

				baiVietNhuanBut = (BaiVietNhuanBut)session.get(BaiVietNhuanButImpl.class,
						primaryKey);

				if (baiVietNhuanBut != null) {
					cacheResult(baiVietNhuanBut);
				}
				else {
					EntityCacheUtil.putResult(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
						BaiVietNhuanButImpl.class, primaryKey,
						_nullBaiVietNhuanBut);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BaiVietNhuanButModelImpl.ENTITY_CACHE_ENABLED,
					BaiVietNhuanButImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return baiVietNhuanBut;
	}

	/**
	 * Returns the bai viet nhuan but with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bai viet nhuan but
	 * @return the bai viet nhuan but, or <code>null</code> if a bai viet nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BaiVietNhuanBut fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the bai viet nhuan buts.
	 *
	 * @return the bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bai viet nhuan buts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bai viet nhuan buts
	 * @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	 * @return the range of bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bai viet nhuan buts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bai viet nhuan buts
	 * @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bai viet nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BaiVietNhuanBut> findAll(int start, int end,
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

		List<BaiVietNhuanBut> list = (List<BaiVietNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BAIVIETNHUANBUT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BAIVIETNHUANBUT;

				if (pagination) {
					sql = sql.concat(BaiVietNhuanButModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BaiVietNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BaiVietNhuanBut>(list);
				}
				else {
					list = (List<BaiVietNhuanBut>)QueryUtil.list(q,
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
	 * Removes all the bai viet nhuan buts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BaiVietNhuanBut baiVietNhuanBut : findAll()) {
			remove(baiVietNhuanBut);
		}
	}

	/**
	 * Returns the number of bai viet nhuan buts.
	 *
	 * @return the number of bai viet nhuan buts
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

				Query q = session.createQuery(_SQL_COUNT_BAIVIETNHUANBUT);

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
	 * Initializes the bai viet nhuan but persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.thongke.model.BaiVietNhuanBut")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BaiVietNhuanBut>> listenersList = new ArrayList<ModelListener<BaiVietNhuanBut>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BaiVietNhuanBut>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BaiVietNhuanButImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BAIVIETNHUANBUT = "SELECT baiVietNhuanBut FROM BaiVietNhuanBut baiVietNhuanBut";
	private static final String _SQL_SELECT_BAIVIETNHUANBUT_WHERE = "SELECT baiVietNhuanBut FROM BaiVietNhuanBut baiVietNhuanBut WHERE ";
	private static final String _SQL_COUNT_BAIVIETNHUANBUT = "SELECT COUNT(baiVietNhuanBut) FROM BaiVietNhuanBut baiVietNhuanBut";
	private static final String _SQL_COUNT_BAIVIETNHUANBUT_WHERE = "SELECT COUNT(baiVietNhuanBut) FROM BaiVietNhuanBut baiVietNhuanBut WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "baiVietNhuanBut.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BaiVietNhuanBut exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BaiVietNhuanBut exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BaiVietNhuanButPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "type"
			});
	private static BaiVietNhuanBut _nullBaiVietNhuanBut = new BaiVietNhuanButImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BaiVietNhuanBut> toCacheModel() {
				return _nullBaiVietNhuanButCacheModel;
			}
		};

	private static CacheModel<BaiVietNhuanBut> _nullBaiVietNhuanButCacheModel = new CacheModel<BaiVietNhuanBut>() {
			@Override
			public BaiVietNhuanBut toEntityModel() {
				return _nullBaiVietNhuanBut;
			}
		};
}