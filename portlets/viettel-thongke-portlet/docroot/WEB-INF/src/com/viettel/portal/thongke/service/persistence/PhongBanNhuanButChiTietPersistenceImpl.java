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

import com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;
import com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet;
import com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietImpl;
import com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the phong ban nhuan but chi tiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanNhuanButChiTietPersistence
 * @see PhongBanNhuanButChiTietUtil
 * @generated
 */
public class PhongBanNhuanButChiTietPersistenceImpl extends BasePersistenceImpl<PhongBanNhuanButChiTiet>
	implements PhongBanNhuanButChiTietPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PhongBanNhuanButChiTietUtil} to access the phong ban nhuan but chi tiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PhongBanNhuanButChiTietImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PHONGBANNHUANBUT =
		new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPhongBanNhuanBut",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUT =
		new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPhongBanNhuanBut", new String[] { Long.class.getName() },
			PhongBanNhuanButChiTietModelImpl.PHONGBANNHUANBUTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PHONGBANNHUANBUT = new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPhongBanNhuanBut", new String[] { Long.class.getName() });

	/**
	 * Returns all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @return the matching phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId) throws SystemException {
		return findByPhongBanNhuanBut(phongBanNhuanButId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param start the lower bound of the range of phong ban nhuan but chi tiets
	 * @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	 * @return the range of matching phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId, int start, int end) throws SystemException {
		return findByPhongBanNhuanBut(phongBanNhuanButId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param start the lower bound of the range of phong ban nhuan but chi tiets
	 * @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUT;
			finderArgs = new Object[] { phongBanNhuanButId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PHONGBANNHUANBUT;
			finderArgs = new Object[] {
					phongBanNhuanButId,
					
					start, end, orderByComparator
				};
		}

		List<PhongBanNhuanButChiTiet> list = (List<PhongBanNhuanButChiTiet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBanNhuanButChiTiet phongBanNhuanButChiTiet : list) {
				if ((phongBanNhuanButId != phongBanNhuanButChiTiet.getPhongBanNhuanButId())) {
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

			query.append(_SQL_SELECT_PHONGBANNHUANBUTCHITIET_WHERE);

			query.append(_FINDER_COLUMN_PHONGBANNHUANBUT_PHONGBANNHUANBUTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanNhuanButChiTietModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phongBanNhuanButId);

				if (!pagination) {
					list = (List<PhongBanNhuanButChiTiet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBanNhuanButChiTiet>(list);
				}
				else {
					list = (List<PhongBanNhuanButChiTiet>)QueryUtil.list(q,
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
	 * Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but chi tiet
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet findByPhongBanNhuanBut_First(
		long phongBanNhuanButId, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = fetchByPhongBanNhuanBut_First(phongBanNhuanButId,
				orderByComparator);

		if (phongBanNhuanButChiTiet != null) {
			return phongBanNhuanButChiTiet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phongBanNhuanButId=");
		msg.append(phongBanNhuanButId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButChiTietException(msg.toString());
	}

	/**
	 * Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet fetchByPhongBanNhuanBut_First(
		long phongBanNhuanButId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PhongBanNhuanButChiTiet> list = findByPhongBanNhuanBut(phongBanNhuanButId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but chi tiet
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet findByPhongBanNhuanBut_Last(
		long phongBanNhuanButId, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = fetchByPhongBanNhuanBut_Last(phongBanNhuanButId,
				orderByComparator);

		if (phongBanNhuanButChiTiet != null) {
			return phongBanNhuanButChiTiet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phongBanNhuanButId=");
		msg.append(phongBanNhuanButId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButChiTietException(msg.toString());
	}

	/**
	 * Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet fetchByPhongBanNhuanBut_Last(
		long phongBanNhuanButId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPhongBanNhuanBut(phongBanNhuanButId);

		if (count == 0) {
			return null;
		}

		List<PhongBanNhuanButChiTiet> list = findByPhongBanNhuanBut(phongBanNhuanButId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong ban nhuan but chi tiets before and after the current phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	 *
	 * @param id the primary key of the current phong ban nhuan but chi tiet
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban nhuan but chi tiet
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet[] findByPhongBanNhuanBut_PrevAndNext(
		long id, long phongBanNhuanButId, OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBanNhuanButChiTiet[] array = new PhongBanNhuanButChiTietImpl[3];

			array[0] = getByPhongBanNhuanBut_PrevAndNext(session,
					phongBanNhuanButChiTiet, phongBanNhuanButId,
					orderByComparator, true);

			array[1] = phongBanNhuanButChiTiet;

			array[2] = getByPhongBanNhuanBut_PrevAndNext(session,
					phongBanNhuanButChiTiet, phongBanNhuanButId,
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

	protected PhongBanNhuanButChiTiet getByPhongBanNhuanBut_PrevAndNext(
		Session session, PhongBanNhuanButChiTiet phongBanNhuanButChiTiet,
		long phongBanNhuanButId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBANNHUANBUTCHITIET_WHERE);

		query.append(_FINDER_COLUMN_PHONGBANNHUANBUT_PHONGBANNHUANBUTID_2);

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
			query.append(PhongBanNhuanButChiTietModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(phongBanNhuanButId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBanNhuanButChiTiet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBanNhuanButChiTiet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; from the database.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPhongBanNhuanBut(long phongBanNhuanButId)
		throws SystemException {
		for (PhongBanNhuanButChiTiet phongBanNhuanButChiTiet : findByPhongBanNhuanBut(
				phongBanNhuanButId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phongBanNhuanButChiTiet);
		}
	}

	/**
	 * Returns the number of phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @return the number of matching phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPhongBanNhuanBut(long phongBanNhuanButId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PHONGBANNHUANBUT;

		Object[] finderArgs = new Object[] { phongBanNhuanButId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHONGBANNHUANBUTCHITIET_WHERE);

			query.append(_FINDER_COLUMN_PHONGBANNHUANBUT_PHONGBANNHUANBUTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phongBanNhuanButId);

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

	private static final String _FINDER_COLUMN_PHONGBANNHUANBUT_PHONGBANNHUANBUTID_2 =
		"phongBanNhuanButChiTiet.phongBanNhuanButId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PHONGBANNHUANBUTANDPHONGBAN =
		new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPhongBanNhuanButAndPhongBan",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUTANDPHONGBAN =
		new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPhongBanNhuanButAndPhongBan",
			new String[] { Long.class.getName(), Long.class.getName() },
			PhongBanNhuanButChiTietModelImpl.PHONGBANNHUANBUTID_COLUMN_BITMASK |
			PhongBanNhuanButChiTietModelImpl.PHONGBANID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PHONGBANNHUANBUTANDPHONGBAN =
		new FinderPath(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPhongBanNhuanButAndPhongBan",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @return the matching phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId) throws SystemException {
		return findByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
			phongBanId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @param start the lower bound of the range of phong ban nhuan but chi tiets
	 * @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	 * @return the range of matching phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId, int start, int end)
		throws SystemException {
		return findByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
			phongBanId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @param start the lower bound of the range of phong ban nhuan but chi tiets
	 * @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUTANDPHONGBAN;
			finderArgs = new Object[] { phongBanNhuanButId, phongBanId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PHONGBANNHUANBUTANDPHONGBAN;
			finderArgs = new Object[] {
					phongBanNhuanButId, phongBanId,
					
					start, end, orderByComparator
				};
		}

		List<PhongBanNhuanButChiTiet> list = (List<PhongBanNhuanButChiTiet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PhongBanNhuanButChiTiet phongBanNhuanButChiTiet : list) {
				if ((phongBanNhuanButId != phongBanNhuanButChiTiet.getPhongBanNhuanButId()) ||
						(phongBanId != phongBanNhuanButChiTiet.getPhongBanId())) {
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

			query.append(_SQL_SELECT_PHONGBANNHUANBUTCHITIET_WHERE);

			query.append(_FINDER_COLUMN_PHONGBANNHUANBUTANDPHONGBAN_PHONGBANNHUANBUTID_2);

			query.append(_FINDER_COLUMN_PHONGBANNHUANBUTANDPHONGBAN_PHONGBANID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhongBanNhuanButChiTietModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phongBanNhuanButId);

				qPos.add(phongBanId);

				if (!pagination) {
					list = (List<PhongBanNhuanButChiTiet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBanNhuanButChiTiet>(list);
				}
				else {
					list = (List<PhongBanNhuanButChiTiet>)QueryUtil.list(q,
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
	 * Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but chi tiet
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet findByPhongBanNhuanButAndPhongBan_First(
		long phongBanNhuanButId, long phongBanId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = fetchByPhongBanNhuanButAndPhongBan_First(phongBanNhuanButId,
				phongBanId, orderByComparator);

		if (phongBanNhuanButChiTiet != null) {
			return phongBanNhuanButChiTiet;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phongBanNhuanButId=");
		msg.append(phongBanNhuanButId);

		msg.append(", phongBanId=");
		msg.append(phongBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButChiTietException(msg.toString());
	}

	/**
	 * Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet fetchByPhongBanNhuanButAndPhongBan_First(
		long phongBanNhuanButId, long phongBanId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PhongBanNhuanButChiTiet> list = findByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
				phongBanId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but chi tiet
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet findByPhongBanNhuanButAndPhongBan_Last(
		long phongBanNhuanButId, long phongBanId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = fetchByPhongBanNhuanButAndPhongBan_Last(phongBanNhuanButId,
				phongBanId, orderByComparator);

		if (phongBanNhuanButChiTiet != null) {
			return phongBanNhuanButChiTiet;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phongBanNhuanButId=");
		msg.append(phongBanNhuanButId);

		msg.append(", phongBanId=");
		msg.append(phongBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhongBanNhuanButChiTietException(msg.toString());
	}

	/**
	 * Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet fetchByPhongBanNhuanButAndPhongBan_Last(
		long phongBanNhuanButId, long phongBanId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
				phongBanId);

		if (count == 0) {
			return null;
		}

		List<PhongBanNhuanButChiTiet> list = findByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
				phongBanId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong ban nhuan but chi tiets before and after the current phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * @param id the primary key of the current phong ban nhuan but chi tiet
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban nhuan but chi tiet
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet[] findByPhongBanNhuanButAndPhongBan_PrevAndNext(
		long id, long phongBanNhuanButId, long phongBanId,
		OrderByComparator orderByComparator)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PhongBanNhuanButChiTiet[] array = new PhongBanNhuanButChiTietImpl[3];

			array[0] = getByPhongBanNhuanButAndPhongBan_PrevAndNext(session,
					phongBanNhuanButChiTiet, phongBanNhuanButId, phongBanId,
					orderByComparator, true);

			array[1] = phongBanNhuanButChiTiet;

			array[2] = getByPhongBanNhuanButAndPhongBan_PrevAndNext(session,
					phongBanNhuanButChiTiet, phongBanNhuanButId, phongBanId,
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

	protected PhongBanNhuanButChiTiet getByPhongBanNhuanButAndPhongBan_PrevAndNext(
		Session session, PhongBanNhuanButChiTiet phongBanNhuanButChiTiet,
		long phongBanNhuanButId, long phongBanId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONGBANNHUANBUTCHITIET_WHERE);

		query.append(_FINDER_COLUMN_PHONGBANNHUANBUTANDPHONGBAN_PHONGBANNHUANBUTID_2);

		query.append(_FINDER_COLUMN_PHONGBANNHUANBUTANDPHONGBAN_PHONGBANID_2);

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
			query.append(PhongBanNhuanButChiTietModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(phongBanNhuanButId);

		qPos.add(phongBanId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phongBanNhuanButChiTiet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhongBanNhuanButChiTiet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63; from the database.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPhongBanNhuanButAndPhongBan(long phongBanNhuanButId,
		long phongBanId) throws SystemException {
		for (PhongBanNhuanButChiTiet phongBanNhuanButChiTiet : findByPhongBanNhuanButAndPhongBan(
				phongBanNhuanButId, phongBanId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(phongBanNhuanButChiTiet);
		}
	}

	/**
	 * Returns the number of phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	 *
	 * @param phongBanNhuanButId the phong ban nhuan but ID
	 * @param phongBanId the phong ban ID
	 * @return the number of matching phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPhongBanNhuanButAndPhongBan(long phongBanNhuanButId,
		long phongBanId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PHONGBANNHUANBUTANDPHONGBAN;

		Object[] finderArgs = new Object[] { phongBanNhuanButId, phongBanId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHONGBANNHUANBUTCHITIET_WHERE);

			query.append(_FINDER_COLUMN_PHONGBANNHUANBUTANDPHONGBAN_PHONGBANNHUANBUTID_2);

			query.append(_FINDER_COLUMN_PHONGBANNHUANBUTANDPHONGBAN_PHONGBANID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phongBanNhuanButId);

				qPos.add(phongBanId);

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

	private static final String _FINDER_COLUMN_PHONGBANNHUANBUTANDPHONGBAN_PHONGBANNHUANBUTID_2 =
		"phongBanNhuanButChiTiet.phongBanNhuanButId = ? AND ";
	private static final String _FINDER_COLUMN_PHONGBANNHUANBUTANDPHONGBAN_PHONGBANID_2 =
		"phongBanNhuanButChiTiet.phongBanId = ?";

	public PhongBanNhuanButChiTietPersistenceImpl() {
		setModelClass(PhongBanNhuanButChiTiet.class);
	}

	/**
	 * Caches the phong ban nhuan but chi tiet in the entity cache if it is enabled.
	 *
	 * @param phongBanNhuanButChiTiet the phong ban nhuan but chi tiet
	 */
	@Override
	public void cacheResult(PhongBanNhuanButChiTiet phongBanNhuanButChiTiet) {
		EntityCacheUtil.putResult(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			phongBanNhuanButChiTiet.getPrimaryKey(), phongBanNhuanButChiTiet);

		phongBanNhuanButChiTiet.resetOriginalValues();
	}

	/**
	 * Caches the phong ban nhuan but chi tiets in the entity cache if it is enabled.
	 *
	 * @param phongBanNhuanButChiTiets the phong ban nhuan but chi tiets
	 */
	@Override
	public void cacheResult(
		List<PhongBanNhuanButChiTiet> phongBanNhuanButChiTiets) {
		for (PhongBanNhuanButChiTiet phongBanNhuanButChiTiet : phongBanNhuanButChiTiets) {
			if (EntityCacheUtil.getResult(
						PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
						PhongBanNhuanButChiTietImpl.class,
						phongBanNhuanButChiTiet.getPrimaryKey()) == null) {
				cacheResult(phongBanNhuanButChiTiet);
			}
			else {
				phongBanNhuanButChiTiet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phong ban nhuan but chi tiets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PhongBanNhuanButChiTietImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PhongBanNhuanButChiTietImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phong ban nhuan but chi tiet.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhongBanNhuanButChiTiet phongBanNhuanButChiTiet) {
		EntityCacheUtil.removeResult(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			phongBanNhuanButChiTiet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<PhongBanNhuanButChiTiet> phongBanNhuanButChiTiets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PhongBanNhuanButChiTiet phongBanNhuanButChiTiet : phongBanNhuanButChiTiets) {
			EntityCacheUtil.removeResult(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
				PhongBanNhuanButChiTietImpl.class,
				phongBanNhuanButChiTiet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new phong ban nhuan but chi tiet with the primary key. Does not add the phong ban nhuan but chi tiet to the database.
	 *
	 * @param id the primary key for the new phong ban nhuan but chi tiet
	 * @return the new phong ban nhuan but chi tiet
	 */
	@Override
	public PhongBanNhuanButChiTiet create(long id) {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = new PhongBanNhuanButChiTietImpl();

		phongBanNhuanButChiTiet.setNew(true);
		phongBanNhuanButChiTiet.setPrimaryKey(id);

		return phongBanNhuanButChiTiet;
	}

	/**
	 * Removes the phong ban nhuan but chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phong ban nhuan but chi tiet
	 * @return the phong ban nhuan but chi tiet that was removed
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet remove(long id)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the phong ban nhuan but chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phong ban nhuan but chi tiet
	 * @return the phong ban nhuan but chi tiet that was removed
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet remove(Serializable primaryKey)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = (PhongBanNhuanButChiTiet)session.get(PhongBanNhuanButChiTietImpl.class,
					primaryKey);

			if (phongBanNhuanButChiTiet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhongBanNhuanButChiTietException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(phongBanNhuanButChiTiet);
		}
		catch (NoSuchPhongBanNhuanButChiTietException nsee) {
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
	protected PhongBanNhuanButChiTiet removeImpl(
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet)
		throws SystemException {
		phongBanNhuanButChiTiet = toUnwrappedModel(phongBanNhuanButChiTiet);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phongBanNhuanButChiTiet)) {
				phongBanNhuanButChiTiet = (PhongBanNhuanButChiTiet)session.get(PhongBanNhuanButChiTietImpl.class,
						phongBanNhuanButChiTiet.getPrimaryKeyObj());
			}

			if (phongBanNhuanButChiTiet != null) {
				session.delete(phongBanNhuanButChiTiet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (phongBanNhuanButChiTiet != null) {
			clearCache(phongBanNhuanButChiTiet);
		}

		return phongBanNhuanButChiTiet;
	}

	@Override
	public PhongBanNhuanButChiTiet updateImpl(
		com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet phongBanNhuanButChiTiet)
		throws SystemException {
		phongBanNhuanButChiTiet = toUnwrappedModel(phongBanNhuanButChiTiet);

		boolean isNew = phongBanNhuanButChiTiet.isNew();

		PhongBanNhuanButChiTietModelImpl phongBanNhuanButChiTietModelImpl = (PhongBanNhuanButChiTietModelImpl)phongBanNhuanButChiTiet;

		Session session = null;

		try {
			session = openSession();

			if (phongBanNhuanButChiTiet.isNew()) {
				session.save(phongBanNhuanButChiTiet);

				phongBanNhuanButChiTiet.setNew(false);
			}
			else {
				session.merge(phongBanNhuanButChiTiet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PhongBanNhuanButChiTietModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((phongBanNhuanButChiTietModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanNhuanButChiTietModelImpl.getOriginalPhongBanNhuanButId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PHONGBANNHUANBUT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUT,
					args);

				args = new Object[] {
						phongBanNhuanButChiTietModelImpl.getPhongBanNhuanButId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PHONGBANNHUANBUT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUT,
					args);
			}

			if ((phongBanNhuanButChiTietModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUTANDPHONGBAN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phongBanNhuanButChiTietModelImpl.getOriginalPhongBanNhuanButId(),
						phongBanNhuanButChiTietModelImpl.getOriginalPhongBanId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PHONGBANNHUANBUTANDPHONGBAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUTANDPHONGBAN,
					args);

				args = new Object[] {
						phongBanNhuanButChiTietModelImpl.getPhongBanNhuanButId(),
						phongBanNhuanButChiTietModelImpl.getPhongBanId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PHONGBANNHUANBUTANDPHONGBAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONGBANNHUANBUTANDPHONGBAN,
					args);
			}
		}

		EntityCacheUtil.putResult(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
			PhongBanNhuanButChiTietImpl.class,
			phongBanNhuanButChiTiet.getPrimaryKey(), phongBanNhuanButChiTiet);

		return phongBanNhuanButChiTiet;
	}

	protected PhongBanNhuanButChiTiet toUnwrappedModel(
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet) {
		if (phongBanNhuanButChiTiet instanceof PhongBanNhuanButChiTietImpl) {
			return phongBanNhuanButChiTiet;
		}

		PhongBanNhuanButChiTietImpl phongBanNhuanButChiTietImpl = new PhongBanNhuanButChiTietImpl();

		phongBanNhuanButChiTietImpl.setNew(phongBanNhuanButChiTiet.isNew());
		phongBanNhuanButChiTietImpl.setPrimaryKey(phongBanNhuanButChiTiet.getPrimaryKey());

		phongBanNhuanButChiTietImpl.setId(phongBanNhuanButChiTiet.getId());
		phongBanNhuanButChiTietImpl.setPhongBanNhuanButId(phongBanNhuanButChiTiet.getPhongBanNhuanButId());
		phongBanNhuanButChiTietImpl.setPhongBanId(phongBanNhuanButChiTiet.getPhongBanId());
		phongBanNhuanButChiTietImpl.setPhongBanTen(phongBanNhuanButChiTiet.getPhongBanTen());
		phongBanNhuanButChiTietImpl.setRating(phongBanNhuanButChiTiet.getRating());
		phongBanNhuanButChiTietImpl.setRatingValue(phongBanNhuanButChiTiet.getRatingValue());

		return phongBanNhuanButChiTietImpl;
	}

	/**
	 * Returns the phong ban nhuan but chi tiet with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the phong ban nhuan but chi tiet
	 * @return the phong ban nhuan but chi tiet
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = fetchByPrimaryKey(primaryKey);

		if (phongBanNhuanButChiTiet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhongBanNhuanButChiTietException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return phongBanNhuanButChiTiet;
	}

	/**
	 * Returns the phong ban nhuan but chi tiet with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException} if it could not be found.
	 *
	 * @param id the primary key of the phong ban nhuan but chi tiet
	 * @return the phong ban nhuan but chi tiet
	 * @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet findByPrimaryKey(long id)
		throws NoSuchPhongBanNhuanButChiTietException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the phong ban nhuan but chi tiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phong ban nhuan but chi tiet
	 * @return the phong ban nhuan but chi tiet, or <code>null</code> if a phong ban nhuan but chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet = (PhongBanNhuanButChiTiet)EntityCacheUtil.getResult(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
				PhongBanNhuanButChiTietImpl.class, primaryKey);

		if (phongBanNhuanButChiTiet == _nullPhongBanNhuanButChiTiet) {
			return null;
		}

		if (phongBanNhuanButChiTiet == null) {
			Session session = null;

			try {
				session = openSession();

				phongBanNhuanButChiTiet = (PhongBanNhuanButChiTiet)session.get(PhongBanNhuanButChiTietImpl.class,
						primaryKey);

				if (phongBanNhuanButChiTiet != null) {
					cacheResult(phongBanNhuanButChiTiet);
				}
				else {
					EntityCacheUtil.putResult(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
						PhongBanNhuanButChiTietImpl.class, primaryKey,
						_nullPhongBanNhuanButChiTiet);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PhongBanNhuanButChiTietModelImpl.ENTITY_CACHE_ENABLED,
					PhongBanNhuanButChiTietImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return phongBanNhuanButChiTiet;
	}

	/**
	 * Returns the phong ban nhuan but chi tiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phong ban nhuan but chi tiet
	 * @return the phong ban nhuan but chi tiet, or <code>null</code> if a phong ban nhuan but chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBanNhuanButChiTiet fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the phong ban nhuan but chi tiets.
	 *
	 * @return the phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong ban nhuan but chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong ban nhuan but chi tiets
	 * @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	 * @return the range of phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong ban nhuan but chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong ban nhuan but chi tiets
	 * @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phong ban nhuan but chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBanNhuanButChiTiet> findAll(int start, int end,
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

		List<PhongBanNhuanButChiTiet> list = (List<PhongBanNhuanButChiTiet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PHONGBANNHUANBUTCHITIET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHONGBANNHUANBUTCHITIET;

				if (pagination) {
					sql = sql.concat(PhongBanNhuanButChiTietModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PhongBanNhuanButChiTiet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PhongBanNhuanButChiTiet>(list);
				}
				else {
					list = (List<PhongBanNhuanButChiTiet>)QueryUtil.list(q,
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
	 * Removes all the phong ban nhuan but chi tiets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PhongBanNhuanButChiTiet phongBanNhuanButChiTiet : findAll()) {
			remove(phongBanNhuanButChiTiet);
		}
	}

	/**
	 * Returns the number of phong ban nhuan but chi tiets.
	 *
	 * @return the number of phong ban nhuan but chi tiets
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

				Query q = session.createQuery(_SQL_COUNT_PHONGBANNHUANBUTCHITIET);

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
	 * Initializes the phong ban nhuan but chi tiet persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PhongBanNhuanButChiTiet>> listenersList = new ArrayList<ModelListener<PhongBanNhuanButChiTiet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PhongBanNhuanButChiTiet>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PhongBanNhuanButChiTietImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PHONGBANNHUANBUTCHITIET = "SELECT phongBanNhuanButChiTiet FROM PhongBanNhuanButChiTiet phongBanNhuanButChiTiet";
	private static final String _SQL_SELECT_PHONGBANNHUANBUTCHITIET_WHERE = "SELECT phongBanNhuanButChiTiet FROM PhongBanNhuanButChiTiet phongBanNhuanButChiTiet WHERE ";
	private static final String _SQL_COUNT_PHONGBANNHUANBUTCHITIET = "SELECT COUNT(phongBanNhuanButChiTiet) FROM PhongBanNhuanButChiTiet phongBanNhuanButChiTiet";
	private static final String _SQL_COUNT_PHONGBANNHUANBUTCHITIET_WHERE = "SELECT COUNT(phongBanNhuanButChiTiet) FROM PhongBanNhuanButChiTiet phongBanNhuanButChiTiet WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "phongBanNhuanButChiTiet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PhongBanNhuanButChiTiet exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PhongBanNhuanButChiTiet exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PhongBanNhuanButChiTietPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static PhongBanNhuanButChiTiet _nullPhongBanNhuanButChiTiet = new PhongBanNhuanButChiTietImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PhongBanNhuanButChiTiet> toCacheModel() {
				return _nullPhongBanNhuanButChiTietCacheModel;
			}
		};

	private static CacheModel<PhongBanNhuanButChiTiet> _nullPhongBanNhuanButChiTietCacheModel =
		new CacheModel<PhongBanNhuanButChiTiet>() {
			@Override
			public PhongBanNhuanButChiTiet toEntityModel() {
				return _nullPhongBanNhuanButChiTiet;
			}
		};
}