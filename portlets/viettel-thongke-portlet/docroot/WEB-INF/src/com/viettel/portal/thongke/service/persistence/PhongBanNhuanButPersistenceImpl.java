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

import com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;
import com.viettel.portal.thongke.model.PhongBanNhuanBut;
import com.viettel.portal.thongke.model.impl.PhongBanNhuanButImpl;
import com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the phong ban nhuan but service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanNhuanButPersistence
 * @see PhongBanNhuanButUtil
 * @generated
 */
public class PhongBanNhuanButPersistenceImpl extends BasePersistenceImpl<PhongBanNhuanBut>
	implements PhongBanNhuanButPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PhongBanNhuanButUtil} to access the phong ban nhuan but persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PhongBanNhuanButImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBystatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Boolean.class.getName() },
			PhongBanNhuanButModelImpl.STATUS_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.CAPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the phong ban nhuan buts where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findBystatus(boolean status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong ban nhuan buts where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @return the range of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findBystatus(boolean status, int start,
		int end) throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong ban nhuan buts where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findBystatus(boolean status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<PhongBanNhuanBut> list = (List<PhongBanNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBanNhuanBut phongBanNhuanBut : list) {
				if ((status != phongBanNhuanBut.getStatus())) {
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

			query.append(_SQL_SELECT_PHONGBANNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBanNhuanBut>(list);
				}
				else {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
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
	 * Returns the first phong ban nhuan but in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findBystatus_First(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchBystatus_First(status,
				orderByComparator);

		if (phongBanNhuanBut != null) {
			return phongBanNhuanBut;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButException(msg.toString());
	}

	/**
	 * Returns the first phong ban nhuan but in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchBystatus_First(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<PhongBanNhuanBut> list = findBystatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban nhuan but in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findBystatus_Last(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchBystatus_Last(status,
				orderByComparator);

		if (phongBanNhuanBut != null) {
			return phongBanNhuanBut;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButException(msg.toString());
	}

	/**
	 * Returns the last phong ban nhuan but in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchBystatus_Last(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<PhongBanNhuanBut> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong ban nhuan buts before and after the current phong ban nhuan but in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current phong ban nhuan but
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut[] findBystatus_PrevAndNext(long id, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBanNhuanBut[] array = new PhongBanNhuanButImpl[3];

			array[0] = getBystatus_PrevAndNext(session, phongBanNhuanBut,
					status, orderByComparator, true);

			array[1] = phongBanNhuanBut;

			array[2] = getBystatus_PrevAndNext(session, phongBanNhuanBut,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhongBanNhuanBut getBystatus_PrevAndNext(Session session,
		PhongBanNhuanBut phongBanNhuanBut, boolean status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBANNHUANBUT_WHERE);

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
			query.append(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBanNhuanBut);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBanNhuanBut> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong ban nhuan buts where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystatus(boolean status) throws SystemException {
		for (PhongBanNhuanBut phongBanNhuanBut : findBystatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phongBanNhuanBut);
		}
	}

	/**
	 * Returns the number of phong ban nhuan buts where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching phong ban nhuan buts
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

			query.append(_SQL_COUNT_PHONGBANNHUANBUT_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "phongBanNhuanBut.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			PhongBanNhuanButModelImpl.GROUPID_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.STATUS_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.CAPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDSTATUS = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the phong ban nhuan buts where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroupAndStatus(long groupId,
		boolean status) throws SystemException {
		return findByGroupAndStatus(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong ban nhuan buts where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @return the range of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroupAndStatus(long groupId,
		boolean status, int start, int end) throws SystemException {
		return findByGroupAndStatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong ban nhuan buts where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroupAndStatus(long groupId,
		boolean status, int start, int end, OrderByComparator orderByComparator)
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

		List<PhongBanNhuanBut> list = (List<PhongBanNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBanNhuanBut phongBanNhuanBut : list) {
				if ((groupId != phongBanNhuanBut.getGroupId()) ||
						(status != phongBanNhuanBut.getStatus())) {
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

			query.append(_SQL_SELECT_PHONGBANNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
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
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBanNhuanBut>(list);
				}
				else {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
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
	 * Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findByGroupAndStatus_First(long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchByGroupAndStatus_First(groupId,
				status, orderByComparator);

		if (phongBanNhuanBut != null) {
			return phongBanNhuanBut;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButException(msg.toString());
	}

	/**
	 * Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchByGroupAndStatus_First(long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws SystemException {
		List<PhongBanNhuanBut> list = findByGroupAndStatus(groupId, status, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findByGroupAndStatus_Last(long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchByGroupAndStatus_Last(groupId,
				status, orderByComparator);

		if (phongBanNhuanBut != null) {
			return phongBanNhuanBut;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButException(msg.toString());
	}

	/**
	 * Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchByGroupAndStatus_Last(long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupAndStatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<PhongBanNhuanBut> list = findByGroupAndStatus(groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong ban nhuan buts before and after the current phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current phong ban nhuan but
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut[] findByGroupAndStatus_PrevAndNext(long id,
		long groupId, boolean status, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBanNhuanBut[] array = new PhongBanNhuanButImpl[3];

			array[0] = getByGroupAndStatus_PrevAndNext(session,
					phongBanNhuanBut, groupId, status, orderByComparator, true);

			array[1] = phongBanNhuanBut;

			array[2] = getByGroupAndStatus_PrevAndNext(session,
					phongBanNhuanBut, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhongBanNhuanBut getByGroupAndStatus_PrevAndNext(
		Session session, PhongBanNhuanBut phongBanNhuanBut, long groupId,
		boolean status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBANNHUANBUT_WHERE);

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
			query.append(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBanNhuanBut);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBanNhuanBut> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong ban nhuan buts where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndStatus(long groupId, boolean status)
		throws SystemException {
		for (PhongBanNhuanBut phongBanNhuanBut : findByGroupAndStatus(groupId,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phongBanNhuanBut);
		}
	}

	/**
	 * Returns the number of phong ban nhuan buts where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching phong ban nhuan buts
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

			query.append(_SQL_COUNT_PHONGBANNHUANBUT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2 = "phongBanNhuanBut.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_STATUS_2 = "phongBanNhuanBut.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDCAPTION =
		new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndCaption",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCAPTION =
		new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCaption",
			new String[] { Long.class.getName(), String.class.getName() },
			PhongBanNhuanButModelImpl.GROUPID_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.CAPTION_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDCAPTION = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupAndCaption",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @return the matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroupAndCaption(long groupId,
		String caption) throws SystemException {
		return findByGroupAndCaption(groupId, caption, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @return the range of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroupAndCaption(long groupId,
		String caption, int start, int end) throws SystemException {
		return findByGroupAndCaption(groupId, caption, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroupAndCaption(long groupId,
		String caption, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCAPTION;
			finderArgs = new Object[] { groupId, caption };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDCAPTION;
			finderArgs = new Object[] {
					groupId, caption,
					
					start, end, orderByComparator
				};
		}

		List<PhongBanNhuanBut> list = (List<PhongBanNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBanNhuanBut phongBanNhuanBut : list) {
				if ((groupId != phongBanNhuanBut.getGroupId()) ||
						!Validator.equals(caption, phongBanNhuanBut.getCaption())) {
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

			query.append(_SQL_SELECT_PHONGBANNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCAPTION_GROUPID_2);

			boolean bindCaption = false;

			if (caption == null) {
				query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_1);
			}
			else if (caption.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_3);
			}
			else {
				bindCaption = true;

				query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCaption) {
					qPos.add(caption);
				}

				if (!pagination) {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBanNhuanBut>(list);
				}
				else {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
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
	 * Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findByGroupAndCaption_First(long groupId,
		String caption, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchByGroupAndCaption_First(groupId,
				caption, orderByComparator);

		if (phongBanNhuanBut != null) {
			return phongBanNhuanBut;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", caption=");
		msg.append(caption);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButException(msg.toString());
	}

	/**
	 * Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchByGroupAndCaption_First(long groupId,
		String caption, OrderByComparator orderByComparator)
		throws SystemException {
		List<PhongBanNhuanBut> list = findByGroupAndCaption(groupId, caption,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findByGroupAndCaption_Last(long groupId,
		String caption, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchByGroupAndCaption_Last(groupId,
				caption, orderByComparator);

		if (phongBanNhuanBut != null) {
			return phongBanNhuanBut;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", caption=");
		msg.append(caption);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButException(msg.toString());
	}

	/**
	 * Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchByGroupAndCaption_Last(long groupId,
		String caption, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupAndCaption(groupId, caption);

		if (count == 0) {
			return null;
		}

		List<PhongBanNhuanBut> list = findByGroupAndCaption(groupId, caption,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong ban nhuan buts before and after the current phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	 *
	 * @param id the primary key of the current phong ban nhuan but
	 * @param groupId the group ID
	 * @param caption the caption
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut[] findByGroupAndCaption_PrevAndNext(long id,
		long groupId, String caption, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBanNhuanBut[] array = new PhongBanNhuanButImpl[3];

			array[0] = getByGroupAndCaption_PrevAndNext(session,
					phongBanNhuanBut, groupId, caption, orderByComparator, true);

			array[1] = phongBanNhuanBut;

			array[2] = getByGroupAndCaption_PrevAndNext(session,
					phongBanNhuanBut, groupId, caption, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhongBanNhuanBut getByGroupAndCaption_PrevAndNext(
		Session session, PhongBanNhuanBut phongBanNhuanBut, long groupId,
		String caption, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBANNHUANBUT_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDCAPTION_GROUPID_2);

		boolean bindCaption = false;

		if (caption == null) {
			query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_1);
		}
		else if (caption.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_3);
		}
		else {
			bindCaption = true;

			query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_2);
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
			query.append(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindCaption) {
			qPos.add(caption);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBanNhuanBut);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBanNhuanBut> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong ban nhuan buts where groupId = &#63; and caption = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndCaption(long groupId, String caption)
		throws SystemException {
		for (PhongBanNhuanBut phongBanNhuanBut : findByGroupAndCaption(
				groupId, caption, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phongBanNhuanBut);
		}
	}

	/**
	 * Returns the number of phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	 *
	 * @param groupId the group ID
	 * @param caption the caption
	 * @return the number of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupAndCaption(long groupId, String caption)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDCAPTION;

		Object[] finderArgs = new Object[] { groupId, caption };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHONGBANNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCAPTION_GROUPID_2);

			boolean bindCaption = false;

			if (caption == null) {
				query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_1);
			}
			else if (caption.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_3);
			}
			else {
				bindCaption = true;

				query.append(_FINDER_COLUMN_GROUPANDCAPTION_CAPTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCaption) {
					qPos.add(caption);
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

	private static final String _FINDER_COLUMN_GROUPANDCAPTION_GROUPID_2 = "phongBanNhuanBut.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDCAPTION_CAPTION_1 = "phongBanNhuanBut.caption IS NULL";
	private static final String _FINDER_COLUMN_GROUPANDCAPTION_CAPTION_2 = "phongBanNhuanBut.caption = ?";
	private static final String _FINDER_COLUMN_GROUPANDCAPTION_CAPTION_3 = "(phongBanNhuanBut.caption IS NULL OR phongBanNhuanBut.caption = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			PhongBanNhuanButModelImpl.GROUPID_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhongBanNhuanButModelImpl.CAPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the phong ban nhuan buts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong ban nhuan buts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @return the range of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong ban nhuan buts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findByGroup(long groupId, int start, int end,
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

		List<PhongBanNhuanBut> list = (List<PhongBanNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBanNhuanBut phongBanNhuanBut : list) {
				if ((groupId != phongBanNhuanBut.getGroupId())) {
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

			query.append(_SQL_SELECT_PHONGBANNHUANBUT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBanNhuanBut>(list);
				}
				else {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
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
	 * Returns the first phong ban nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchByGroup_First(groupId,
				orderByComparator);

		if (phongBanNhuanBut != null) {
			return phongBanNhuanBut;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButException(msg.toString());
	}

	/**
	 * Returns the first phong ban nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PhongBanNhuanBut> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchByGroup_Last(groupId,
				orderByComparator);

		if (phongBanNhuanBut != null) {
			return phongBanNhuanBut;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButException(msg.toString());
	}

	/**
	 * Returns the last phong ban nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<PhongBanNhuanBut> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong ban nhuan buts before and after the current phong ban nhuan but in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current phong ban nhuan but
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut[] findByGroup_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBanNhuanBut[] array = new PhongBanNhuanButImpl[3];

			array[0] = getByGroup_PrevAndNext(session, phongBanNhuanBut,
					groupId, orderByComparator, true);

			array[1] = phongBanNhuanBut;

			array[2] = getByGroup_PrevAndNext(session, phongBanNhuanBut,
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

	protected PhongBanNhuanBut getByGroup_PrevAndNext(Session session,
		PhongBanNhuanBut phongBanNhuanBut, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBANNHUANBUT_WHERE);

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
			query.append(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBanNhuanBut);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBanNhuanBut> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong ban nhuan buts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (PhongBanNhuanBut phongBanNhuanBut : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phongBanNhuanBut);
		}
	}

	/**
	 * Returns the number of phong ban nhuan buts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching phong ban nhuan buts
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

			query.append(_SQL_COUNT_PHONGBANNHUANBUT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "phongBanNhuanBut.groupId = ?";

	public PhongBanNhuanButPersistenceImpl() {
		setModelClass(PhongBanNhuanBut.class);
	}

	/**
	 * Caches the phong ban nhuan but in the entity cache if it is enabled.
	 *
	 * @param phongBanNhuanBut the phong ban nhuan but
	 */
	@Override
	public void cacheResult(PhongBanNhuanBut phongBanNhuanBut) {
		EntityCacheUtil.putResult(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButImpl.class, phongBanNhuanBut.getPrimaryKey(),
			phongBanNhuanBut);

		phongBanNhuanBut.resetOriginalValues();
	}

	/**
	 * Caches the phong ban nhuan buts in the entity cache if it is enabled.
	 *
	 * @param phongBanNhuanButs the phong ban nhuan buts
	 */
	@Override
	public void cacheResult(List<PhongBanNhuanBut> phongBanNhuanButs) {
		for (PhongBanNhuanBut phongBanNhuanBut : phongBanNhuanButs) {
			if (EntityCacheUtil.getResult(
						PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
						PhongBanNhuanButImpl.class,
						phongBanNhuanBut.getPrimaryKey()) == null) {
				cacheResult(phongBanNhuanBut);
			}
			else {
				phongBanNhuanBut.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phong ban nhuan buts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PhongBanNhuanButImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PhongBanNhuanButImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phong ban nhuan but.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhongBanNhuanBut phongBanNhuanBut) {
		EntityCacheUtil.removeResult(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButImpl.class, phongBanNhuanBut.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PhongBanNhuanBut> phongBanNhuanButs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PhongBanNhuanBut phongBanNhuanBut : phongBanNhuanButs) {
			EntityCacheUtil.removeResult(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
				PhongBanNhuanButImpl.class, phongBanNhuanBut.getPrimaryKey());
		}
	}

	/**
	 * Creates a new phong ban nhuan but with the primary key. Does not add the phong ban nhuan but to the database.
	 *
	 * @param id the primary key for the new phong ban nhuan but
	 * @return the new phong ban nhuan but
	 */
	@Override
	public PhongBanNhuanBut create(long id) {
		PhongBanNhuanBut phongBanNhuanBut = new PhongBanNhuanButImpl();

		phongBanNhuanBut.setNew(true);
		phongBanNhuanBut.setPrimaryKey(id);

		return phongBanNhuanBut;
	}

	/**
	 * Removes the phong ban nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phong ban nhuan but
	 * @return the phong ban nhuan but that was removed
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut remove(long id)
		throws NoSuchPhongBanNhuanButException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the phong ban nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phong ban nhuan but
	 * @return the phong ban nhuan but that was removed
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut remove(Serializable primaryKey)
		throws NoSuchPhongBanNhuanButException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PhongBanNhuanBut phongBanNhuanBut = (PhongBanNhuanBut)session.get(PhongBanNhuanButImpl.class,
					primaryKey);

			if (phongBanNhuanBut == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhongBanNhuanButException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(phongBanNhuanBut);
		}
		catch (NoSuchPhongBanNhuanButException nsee) {
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
	protected PhongBanNhuanBut removeImpl(PhongBanNhuanBut phongBanNhuanBut)
		throws SystemException {
		phongBanNhuanBut = toUnwrappedModel(phongBanNhuanBut);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phongBanNhuanBut)) {
				phongBanNhuanBut = (PhongBanNhuanBut)session.get(PhongBanNhuanButImpl.class,
						phongBanNhuanBut.getPrimaryKeyObj());
			}

			if (phongBanNhuanBut != null) {
				session.delete(phongBanNhuanBut);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (phongBanNhuanBut != null) {
			clearCache(phongBanNhuanBut);
		}

		return phongBanNhuanBut;
	}

	@Override
	public PhongBanNhuanBut updateImpl(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut)
		throws SystemException {
		phongBanNhuanBut = toUnwrappedModel(phongBanNhuanBut);

		boolean isNew = phongBanNhuanBut.isNew();

		PhongBanNhuanButModelImpl phongBanNhuanButModelImpl = (PhongBanNhuanButModelImpl)phongBanNhuanBut;

		Session session = null;

		try {
			session = openSession();

			if (phongBanNhuanBut.isNew()) {
				session.save(phongBanNhuanBut);

				phongBanNhuanBut.setNew(false);
			}
			else {
				session.merge(phongBanNhuanBut);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PhongBanNhuanButModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((phongBanNhuanButModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanNhuanButModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { phongBanNhuanButModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((phongBanNhuanButModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanNhuanButModelImpl.getOriginalGroupId(),
						phongBanNhuanButModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);

				args = new Object[] {
						phongBanNhuanButModelImpl.getGroupId(),
						phongBanNhuanButModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);
			}

			if ((phongBanNhuanButModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCAPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanNhuanButModelImpl.getOriginalGroupId(),
						phongBanNhuanButModelImpl.getOriginalCaption()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCAPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCAPTION,
					args);

				args = new Object[] {
						phongBanNhuanButModelImpl.getGroupId(),
						phongBanNhuanButModelImpl.getCaption()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCAPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCAPTION,
					args);
			}

			if ((phongBanNhuanButModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanNhuanButModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { phongBanNhuanButModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButImpl.class, phongBanNhuanBut.getPrimaryKey(),
			phongBanNhuanBut);

		return phongBanNhuanBut;
	}

	protected PhongBanNhuanBut toUnwrappedModel(
		PhongBanNhuanBut phongBanNhuanBut) {
		if (phongBanNhuanBut instanceof PhongBanNhuanButImpl) {
			return phongBanNhuanBut;
		}

		PhongBanNhuanButImpl phongBanNhuanButImpl = new PhongBanNhuanButImpl();

		phongBanNhuanButImpl.setNew(phongBanNhuanBut.isNew());
		phongBanNhuanButImpl.setPrimaryKey(phongBanNhuanBut.getPrimaryKey());

		phongBanNhuanButImpl.setId(phongBanNhuanBut.getId());
		phongBanNhuanButImpl.setCaption(phongBanNhuanBut.getCaption());
		phongBanNhuanButImpl.setFromDate(phongBanNhuanBut.getFromDate());
		phongBanNhuanButImpl.setToDate(phongBanNhuanBut.getToDate());
		phongBanNhuanButImpl.setStatus(phongBanNhuanBut.isStatus());
		phongBanNhuanButImpl.setCompanyId(phongBanNhuanBut.getCompanyId());
		phongBanNhuanButImpl.setGroupId(phongBanNhuanBut.getGroupId());
		phongBanNhuanButImpl.setCreateDate(phongBanNhuanBut.getCreateDate());
		phongBanNhuanButImpl.setModifyDate(phongBanNhuanBut.getModifyDate());
		phongBanNhuanButImpl.setUserName(phongBanNhuanBut.getUserName());
		phongBanNhuanButImpl.setUserId(phongBanNhuanBut.getUserId());

		return phongBanNhuanButImpl;
	}

	/**
	 * Returns the phong ban nhuan but with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the phong ban nhuan but
	 * @return the phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhongBanNhuanButException, SystemException {
		PhongBanNhuanBut phongBanNhuanBut = fetchByPrimaryKey(primaryKey);

		if (phongBanNhuanBut == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhongBanNhuanButException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return phongBanNhuanBut;
	}

	/**
	 * Returns the phong ban nhuan but with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanNhuanButException} if it could not be found.
	 *
	 * @param id the primary key of the phong ban nhuan but
	 * @return the phong ban nhuan but
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut findByPrimaryKey(long id)
		throws NoSuchPhongBanNhuanButException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the phong ban nhuan but with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phong ban nhuan but
	 * @return the phong ban nhuan but, or <code>null</code> if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PhongBanNhuanBut phongBanNhuanBut = (PhongBanNhuanBut)EntityCacheUtil.getResult(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
				PhongBanNhuanButImpl.class, primaryKey);

		if (phongBanNhuanBut == _nullPhongBanNhuanBut) {
			return null;
		}

		if (phongBanNhuanBut == null) {
			Session session = null;

			try {
				session = openSession();

				phongBanNhuanBut = (PhongBanNhuanBut)session.get(PhongBanNhuanButImpl.class,
						primaryKey);

				if (phongBanNhuanBut != null) {
					cacheResult(phongBanNhuanBut);
				}
				else {
					EntityCacheUtil.putResult(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
						PhongBanNhuanButImpl.class, primaryKey,
						_nullPhongBanNhuanBut);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PhongBanNhuanButModelImpl.ENTITY_CACHE_ENABLED,
					PhongBanNhuanButImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return phongBanNhuanBut;
	}

	/**
	 * Returns the phong ban nhuan but with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phong ban nhuan but
	 * @return the phong ban nhuan but, or <code>null</code> if a phong ban nhuan but with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanBut fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the phong ban nhuan buts.
	 *
	 * @return the phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong ban nhuan buts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @return the range of phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong ban nhuan buts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong ban nhuan buts
	 * @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phong ban nhuan buts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanBut> findAll(int start, int end,
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

		List<PhongBanNhuanBut> list = (List<PhongBanNhuanBut>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PHONGBANNHUANBUT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHONGBANNHUANBUT;

				if (pagination) {
					sql = sql.concat(PhongBanNhuanButModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBanNhuanBut>(list);
				}
				else {
					list = (List<PhongBanNhuanBut>)QueryUtil.list(q,
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
	 * Removes all the phong ban nhuan buts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PhongBanNhuanBut phongBanNhuanBut : findAll()) {
			remove(phongBanNhuanBut);
		}
	}

	/**
	 * Returns the number of phong ban nhuan buts.
	 *
	 * @return the number of phong ban nhuan buts
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

				Query q = session.createQuery(_SQL_COUNT_PHONGBANNHUANBUT);

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
	 * Initializes the phong ban nhuan but persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.thongke.model.PhongBanNhuanBut")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PhongBanNhuanBut>> listenersList = new ArrayList<ModelListener<PhongBanNhuanBut>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PhongBanNhuanBut>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PhongBanNhuanButImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PHONGBANNHUANBUT = "SELECT phongBanNhuanBut FROM PhongBanNhuanBut phongBanNhuanBut";
	private static final String _SQL_SELECT_PHONGBANNHUANBUT_WHERE = "SELECT phongBanNhuanBut FROM PhongBanNhuanBut phongBanNhuanBut WHERE ";
	private static final String _SQL_COUNT_PHONGBANNHUANBUT = "SELECT COUNT(phongBanNhuanBut) FROM PhongBanNhuanBut phongBanNhuanBut";
	private static final String _SQL_COUNT_PHONGBANNHUANBUT_WHERE = "SELECT COUNT(phongBanNhuanBut) FROM PhongBanNhuanBut phongBanNhuanBut WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "phongBanNhuanBut.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PhongBanNhuanBut exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PhongBanNhuanBut exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PhongBanNhuanButPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static PhongBanNhuanBut _nullPhongBanNhuanBut = new PhongBanNhuanButImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PhongBanNhuanBut> toCacheModel() {
				return _nullPhongBanNhuanButCacheModel;
			}
		};

	private static CacheModel<PhongBanNhuanBut> _nullPhongBanNhuanButCacheModel = new CacheModel<PhongBanNhuanBut>() {
			@Override
			public PhongBanNhuanBut toEntityModel() {
				return _nullPhongBanNhuanBut;
			}
		};
}