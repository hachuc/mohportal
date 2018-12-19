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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.thongke.NoSuchPhongBanException;
import com.viettel.portal.thongke.model.PhongBan;
import com.viettel.portal.thongke.model.impl.PhongBanImpl;
import com.viettel.portal.thongke.model.impl.PhongBanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the phong ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanPersistence
 * @see PhongBanUtil
 * @generated
 */
public class PhongBanPersistenceImpl extends BasePersistenceImpl<PhongBan>
	implements PhongBanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PhongBanUtil} to access the phong ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PhongBanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Boolean.class.getName() },
			PhongBanModelImpl.STATUS_COLUMN_BITMASK |
			PhongBanModelImpl.ORDER__COLUMN_BITMASK |
			PhongBanModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhongBanModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the phong bans where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findBystatus(boolean status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong bans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findBystatus(boolean status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong bans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findBystatus(boolean status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<PhongBan> list = (List<PhongBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBan phongBan : list) {
				if ((status != phongBan.getStatus())) {
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

			query.append(_SQL_SELECT_PHONGBAN_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBan>(list);
				}
				else {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first phong ban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findBystatus_First(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchBystatus_First(status, orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanException(msg.toString());
	}

	/**
	 * Returns the first phong ban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchBystatus_First(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<PhongBan> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findBystatus_Last(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchBystatus_Last(status, orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanException(msg.toString());
	}

	/**
	 * Returns the last phong ban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchBystatus_Last(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<PhongBan> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong bans before and after the current phong ban in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current phong ban
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan[] findBystatus_PrevAndNext(long id, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBan[] array = new PhongBanImpl[3];

			array[0] = getBystatus_PrevAndNext(session, phongBan, status,
					orderByComparator, true);

			array[1] = phongBan;

			array[2] = getBystatus_PrevAndNext(session, phongBan, status,
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

	protected PhongBan getBystatus_PrevAndNext(Session session,
		PhongBan phongBan, boolean status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBAN_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(PhongBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong bans where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystatus(boolean status) throws SystemException {
		for (PhongBan phongBan : findBystatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(phongBan);
		}
	}

	/**
	 * Returns the number of phong bans where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystatus(boolean status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHONGBAN_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "phongBan.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			PhongBanModelImpl.GROUPID_COLUMN_BITMASK |
			PhongBanModelImpl.STATUS_COLUMN_BITMASK |
			PhongBanModelImpl.ORDER__COLUMN_BITMASK |
			PhongBanModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhongBanModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDSTATUS = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the phong bans where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroupAndStatus(long groupId, boolean status)
		throws SystemException {
		return findByGroupAndStatus(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong bans where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroupAndStatus(long groupId, boolean status,
		int start, int end) throws SystemException {
		return findByGroupAndStatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong bans where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroupAndStatus(long groupId, boolean status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<PhongBan> list = (List<PhongBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBan phongBan : list) {
				if ((groupId != phongBan.getGroupId()) ||
						(status != phongBan.getStatus())) {
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

			query.append(_SQL_SELECT_PHONGBAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBan>(list);
				}
				else {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first phong ban in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findByGroupAndStatus_First(long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchByGroupAndStatus_First(groupId, status,
				orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanException(msg.toString());
	}

	/**
	 * Returns the first phong ban in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchByGroupAndStatus_First(long groupId, boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<PhongBan> list = findByGroupAndStatus(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findByGroupAndStatus_Last(long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchByGroupAndStatus_Last(groupId, status,
				orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanException(msg.toString());
	}

	/**
	 * Returns the last phong ban in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchByGroupAndStatus_Last(long groupId, boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupAndStatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<PhongBan> list = findByGroupAndStatus(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong bans before and after the current phong ban in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current phong ban
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan[] findByGroupAndStatus_PrevAndNext(long id, long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBan[] array = new PhongBanImpl[3];

			array[0] = getByGroupAndStatus_PrevAndNext(session, phongBan,
					groupId, status, orderByComparator, true);

			array[1] = phongBan;

			array[2] = getByGroupAndStatus_PrevAndNext(session, phongBan,
					groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhongBan getByGroupAndStatus_PrevAndNext(Session session,
		PhongBan phongBan, long groupId, boolean status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBAN_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

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
			query.append(PhongBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong bans where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndStatus(long groupId, boolean status)
		throws SystemException {
		for (PhongBan phongBan : findByGroupAndStatus(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phongBan);
		}
	}

	/**
	 * Returns the number of phong bans where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupAndStatus(long groupId, boolean status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDSTATUS;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHONGBAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2 = "phongBan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_STATUS_2 = "phongBan.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDNAME =
		new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME =
		new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndName",
			new String[] { Long.class.getName(), String.class.getName() },
			PhongBanModelImpl.GROUPID_COLUMN_BITMASK |
			PhongBanModelImpl.NAME_COLUMN_BITMASK |
			PhongBanModelImpl.ORDER__COLUMN_BITMASK |
			PhongBanModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDNAME = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the phong bans where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroupAndName(long groupId, String name)
		throws SystemException {
		return findByGroupAndName(groupId, name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong bans where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroupAndName(long groupId, String name,
		int start, int end) throws SystemException {
		return findByGroupAndName(groupId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong bans where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroupAndName(long groupId, String name,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME;
			finderArgs = new Object[] { groupId, name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDNAME;
			finderArgs = new Object[] {
					groupId, name,
					
					start, end, orderByComparator
				};
		}

		List<PhongBan> list = (List<PhongBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBan phongBan : list) {
				if ((groupId != phongBan.getGroupId()) ||
						!Validator.equals(name, phongBan.getName())) {
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

			query.append(_SQL_SELECT_PHONGBAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDNAME_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBan>(list);
				}
				else {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first phong ban in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findByGroupAndName_First(long groupId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchByGroupAndName_First(groupId, name,
				orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanException(msg.toString());
	}

	/**
	 * Returns the first phong ban in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchByGroupAndName_First(long groupId, String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<PhongBan> list = findByGroupAndName(groupId, name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findByGroupAndName_Last(long groupId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchByGroupAndName_Last(groupId, name,
				orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanException(msg.toString());
	}

	/**
	 * Returns the last phong ban in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchByGroupAndName_Last(long groupId, String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupAndName(groupId, name);

		if (count == 0) {
			return null;
		}

		List<PhongBan> list = findByGroupAndName(groupId, name, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong bans before and after the current phong ban in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param id the primary key of the current phong ban
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan[] findByGroupAndName_PrevAndNext(long id, long groupId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBan[] array = new PhongBanImpl[3];

			array[0] = getByGroupAndName_PrevAndNext(session, phongBan,
					groupId, name, orderByComparator, true);

			array[1] = phongBan;

			array[2] = getByGroupAndName_PrevAndNext(session, phongBan,
					groupId, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhongBan getByGroupAndName_PrevAndNext(Session session,
		PhongBan phongBan, long groupId, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBAN_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDNAME_GROUPID_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_2);
		}

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
			query.append(PhongBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong bans where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndName(long groupId, String name)
		throws SystemException {
		for (PhongBan phongBan : findByGroupAndName(groupId, name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phongBan);
		}
	}

	/**
	 * Returns the number of phong bans where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupAndName(long groupId, String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDNAME;

		Object[] finderArgs = new Object[] { groupId, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHONGBAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDNAME_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_GROUPANDNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_GROUPANDNAME_GROUPID_2 = "phongBan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDNAME_NAME_1 = "phongBan.name IS NULL";
	private static final String _FINDER_COLUMN_GROUPANDNAME_NAME_2 = "phongBan.name = ?";
	private static final String _FINDER_COLUMN_GROUPANDNAME_NAME_3 = "(phongBan.name IS NULL OR phongBan.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, PhongBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			PhongBanModelImpl.GROUPID_COLUMN_BITMASK |
			PhongBanModelImpl.ORDER__COLUMN_BITMASK |
			PhongBanModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhongBanModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the phong bans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong bans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong bans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findByGroup(long groupId, int start, int end,
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

		List<PhongBan> list = (List<PhongBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBan phongBan : list) {
				if ((groupId != phongBan.getGroupId())) {
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

			query.append(_SQL_SELECT_PHONGBAN_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBan>(list);
				}
				else {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first phong ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchByGroup_First(groupId, orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanException(msg.toString());
	}

	/**
	 * Returns the first phong ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PhongBan> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchByGroup_Last(groupId, orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanException(msg.toString());
	}

	/**
	 * Returns the last phong ban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<PhongBan> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong bans before and after the current phong ban in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current phong ban
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan[] findByGroup_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBan[] array = new PhongBanImpl[3];

			array[0] = getByGroup_PrevAndNext(session, phongBan, groupId,
					orderByComparator, true);

			array[1] = phongBan;

			array[2] = getByGroup_PrevAndNext(session, phongBan, groupId,
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

	protected PhongBan getByGroup_PrevAndNext(Session session,
		PhongBan phongBan, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBAN_WHERE);

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
			query.append(PhongBanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong bans where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (PhongBan phongBan : findByGroup(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(phongBan);
		}
	}

	/**
	 * Returns the number of phong bans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching phong bans
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

			query.append(_SQL_COUNT_PHONGBAN_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "phongBan.groupId = ?";

	public PhongBanPersistenceImpl() {
		setModelClass(PhongBan.class);
	}

	/**
	 * Caches the phong ban in the entity cache if it is enabled.
	 *
	 * @param phongBan the phong ban
	 */
	@Override
	public void cacheResult(PhongBan phongBan) {
		EntityCacheUtil.putResult(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanImpl.class, phongBan.getPrimaryKey(), phongBan);

		phongBan.resetOriginalValues();
	}

	/**
	 * Caches the phong bans in the entity cache if it is enabled.
	 *
	 * @param phongBans the phong bans
	 */
	@Override
	public void cacheResult(List<PhongBan> phongBans) {
		for (PhongBan phongBan : phongBans) {
			if (EntityCacheUtil.getResult(
						PhongBanModelImpl.ENTITY_CACHE_ENABLED,
						PhongBanImpl.class, phongBan.getPrimaryKey()) == null) {
				cacheResult(phongBan);
			}
			else {
				phongBan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phong bans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PhongBanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PhongBanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phong ban.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhongBan phongBan) {
		EntityCacheUtil.removeResult(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanImpl.class, phongBan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PhongBan> phongBans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PhongBan phongBan : phongBans) {
			EntityCacheUtil.removeResult(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
				PhongBanImpl.class, phongBan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new phong ban with the primary key. Does not add the phong ban to the database.
	 *
	 * @param id the primary key for the new phong ban
	 * @return the new phong ban
	 */
	@Override
	public PhongBan create(long id) {
		PhongBan phongBan = new PhongBanImpl();

		phongBan.setNew(true);
		phongBan.setPrimaryKey(id);

		return phongBan;
	}

	/**
	 * Removes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phong ban
	 * @return the phong ban that was removed
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan remove(long id)
		throws NoSuchPhongBanException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phong ban
	 * @return the phong ban that was removed
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan remove(Serializable primaryKey)
		throws NoSuchPhongBanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PhongBan phongBan = (PhongBan)session.get(PhongBanImpl.class,
					primaryKey);

			if (phongBan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhongBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(phongBan);
		}
		catch (NoSuchPhongBanException nsee) {
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
	protected PhongBan removeImpl(PhongBan phongBan) throws SystemException {
		phongBan = toUnwrappedModel(phongBan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phongBan)) {
				phongBan = (PhongBan)session.get(PhongBanImpl.class,
						phongBan.getPrimaryKeyObj());
			}

			if (phongBan != null) {
				session.delete(phongBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (phongBan != null) {
			clearCache(phongBan);
		}

		return phongBan;
	}

	@Override
	public PhongBan updateImpl(
		com.viettel.portal.thongke.model.PhongBan phongBan)
		throws SystemException {
		phongBan = toUnwrappedModel(phongBan);

		boolean isNew = phongBan.isNew();

		PhongBanModelImpl phongBanModelImpl = (PhongBanModelImpl)phongBan;

		Session session = null;

		try {
			session = openSession();

			if (phongBan.isNew()) {
				session.save(phongBan);

				phongBan.setNew(false);
			}
			else {
				session.merge(phongBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PhongBanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((phongBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { phongBanModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((phongBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanModelImpl.getOriginalGroupId(),
						phongBanModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);

				args = new Object[] {
						phongBanModelImpl.getGroupId(),
						phongBanModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);
			}

			if ((phongBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanModelImpl.getOriginalGroupId(),
						phongBanModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME,
					args);

				args = new Object[] {
						phongBanModelImpl.getGroupId(),
						phongBanModelImpl.getName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME,
					args);
			}

			if ((phongBanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { phongBanModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanImpl.class, phongBan.getPrimaryKey(), phongBan);

		return phongBan;
	}

	protected PhongBan toUnwrappedModel(PhongBan phongBan) {
		if (phongBan instanceof PhongBanImpl) {
			return phongBan;
		}

		PhongBanImpl phongBanImpl = new PhongBanImpl();

		phongBanImpl.setNew(phongBan.isNew());
		phongBanImpl.setPrimaryKey(phongBan.getPrimaryKey());

		phongBanImpl.setId(phongBan.getId());
		phongBanImpl.setName(phongBan.getName());
		phongBanImpl.setOrder_(phongBan.getOrder_());
		phongBanImpl.setDescriptions(phongBan.getDescriptions());
		phongBanImpl.setStatus(phongBan.isStatus());
		phongBanImpl.setCompanyId(phongBan.getCompanyId());
		phongBanImpl.setGroupId(phongBan.getGroupId());
		phongBanImpl.setCreateDate(phongBan.getCreateDate());
		phongBanImpl.setModifyDate(phongBan.getModifyDate());
		phongBanImpl.setUserName(phongBan.getUserName());
		phongBanImpl.setUserId(phongBan.getUserId());

		return phongBanImpl;
	}

	/**
	 * Returns the phong ban with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the phong ban
	 * @return the phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhongBanException, SystemException {
		PhongBan phongBan = fetchByPrimaryKey(primaryKey);

		if (phongBan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhongBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return phongBan;
	}

	/**
	 * Returns the phong ban with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanException} if it could not be found.
	 *
	 * @param id the primary key of the phong ban
	 * @return the phong ban
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan findByPrimaryKey(long id)
		throws NoSuchPhongBanException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the phong ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phong ban
	 * @return the phong ban, or <code>null</code> if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PhongBan phongBan = (PhongBan)EntityCacheUtil.getResult(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
				PhongBanImpl.class, primaryKey);

		if (phongBan == _nullPhongBan) {
			return null;
		}

		if (phongBan == null) {
			Session session = null;

			try {
				session = openSession();

				phongBan = (PhongBan)session.get(PhongBanImpl.class, primaryKey);

				if (phongBan != null) {
					cacheResult(phongBan);
				}
				else {
					EntityCacheUtil.putResult(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
						PhongBanImpl.class, primaryKey, _nullPhongBan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PhongBanModelImpl.ENTITY_CACHE_ENABLED,
					PhongBanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return phongBan;
	}

	/**
	 * Returns the phong ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phong ban
	 * @return the phong ban, or <code>null</code> if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the phong bans.
	 *
	 * @return the phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> findAll(int start, int end,
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

		List<PhongBan> list = (List<PhongBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PHONGBAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHONGBAN;

				if (pagination) {
					sql = sql.concat(PhongBanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBan>(list);
				}
				else {
					list = (List<PhongBan>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the phong bans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PhongBan phongBan : findAll()) {
			remove(phongBan);
		}
	}

	/**
	 * Returns the number of phong bans.
	 *
	 * @return the number of phong bans
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

				Query q = session.createQuery(_SQL_COUNT_PHONGBAN);

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
	 * Initializes the phong ban persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.thongke.model.PhongBan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PhongBan>> listenersList = new ArrayList<ModelListener<PhongBan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PhongBan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PhongBanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PHONGBAN = "SELECT phongBan FROM PhongBan phongBan";
	private static final String _SQL_SELECT_PHONGBAN_WHERE = "SELECT phongBan FROM PhongBan phongBan WHERE ";
	private static final String _SQL_COUNT_PHONGBAN = "SELECT COUNT(phongBan) FROM PhongBan phongBan";
	private static final String _SQL_COUNT_PHONGBAN_WHERE = "SELECT COUNT(phongBan) FROM PhongBan phongBan WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "phongBan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PhongBan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PhongBan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PhongBanPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static PhongBan _nullPhongBan = new PhongBanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PhongBan> toCacheModel() {
				return _nullPhongBanCacheModel;
			}
		};

	private static CacheModel<PhongBan> _nullPhongBanCacheModel = new CacheModel<PhongBan>() {
			@Override
			public PhongBan toEntityModel() {
				return _nullPhongBan;
			}
		};
}