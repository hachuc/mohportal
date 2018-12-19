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

package com.viettel.portal.photos.service.persistence;

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

import com.viettel.portal.photos.NoSuchPCategoryException;
import com.viettel.portal.photos.model.PCategory;
import com.viettel.portal.photos.model.impl.PCategoryImpl;
import com.viettel.portal.photos.model.impl.PCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see PCategoryPersistence
 * @see PCategoryUtil
 * @generated
 */
public class PCategoryPersistenceImpl extends BasePersistenceImpl<PCategory>
	implements PCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PCategoryUtil} to access the p category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Boolean.class.getName() },
			PCategoryModelImpl.STATUS_COLUMN_BITMASK |
			PCategoryModelImpl.ORDER__COLUMN_BITMASK |
			PCategoryModelImpl.CREATEDATE_COLUMN_BITMASK |
			PCategoryModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the p categories where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findBystatus(boolean status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p categories where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @return the range of matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findBystatus(boolean status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p categories where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findBystatus(boolean status, int start, int end,
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

		List<PCategory> list = (List<PCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PCategory pCategory : list) {
				if ((status != pCategory.getStatus())) {
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

			query.append(_SQL_SELECT_PCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PCategory>(list);
				}
				else {
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p category in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findBystatus_First(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchBystatus_First(status, orderByComparator);

		if (pCategory != null) {
			return pCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPCategoryException(msg.toString());
	}

	/**
	 * Returns the first p category in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p category, or <code>null</code> if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchBystatus_First(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<PCategory> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p category in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findBystatus_Last(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchBystatus_Last(status, orderByComparator);

		if (pCategory != null) {
			return pCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPCategoryException(msg.toString());
	}

	/**
	 * Returns the last p category in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p category, or <code>null</code> if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchBystatus_Last(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<PCategory> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p categories before and after the current p category in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current p category
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory[] findBystatus_PrevAndNext(long id, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PCategory[] array = new PCategoryImpl[3];

			array[0] = getBystatus_PrevAndNext(session, pCategory, status,
					orderByComparator, true);

			array[1] = pCategory;

			array[2] = getBystatus_PrevAndNext(session, pCategory, status,
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

	protected PCategory getBystatus_PrevAndNext(Session session,
		PCategory pCategory, boolean status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PCATEGORY_WHERE);

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
			query.append(PCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p categories where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystatus(boolean status) throws SystemException {
		for (PCategory pCategory : findBystatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(pCategory);
		}
	}

	/**
	 * Returns the number of p categories where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching p categories
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

			query.append(_SQL_COUNT_PCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "pCategory.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			PCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			PCategoryModelImpl.STATUS_COLUMN_BITMASK |
			PCategoryModelImpl.ORDER__COLUMN_BITMASK |
			PCategoryModelImpl.CREATEDATE_COLUMN_BITMASK |
			PCategoryModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDSTATUS = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the p categories where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroupAndStatus(long groupId, boolean status)
		throws SystemException {
		return findByGroupAndStatus(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p categories where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @return the range of matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroupAndStatus(long groupId, boolean status,
		int start, int end) throws SystemException {
		return findByGroupAndStatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p categories where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroupAndStatus(long groupId, boolean status,
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

		List<PCategory> list = (List<PCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PCategory pCategory : list) {
				if ((groupId != pCategory.getGroupId()) ||
						(status != pCategory.getStatus())) {
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

			query.append(_SQL_SELECT_PCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PCategoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PCategory>(list);
				}
				else {
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p category in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findByGroupAndStatus_First(long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchByGroupAndStatus_First(groupId, status,
				orderByComparator);

		if (pCategory != null) {
			return pCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPCategoryException(msg.toString());
	}

	/**
	 * Returns the first p category in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p category, or <code>null</code> if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchByGroupAndStatus_First(long groupId, boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<PCategory> list = findByGroupAndStatus(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p category in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findByGroupAndStatus_Last(long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchByGroupAndStatus_Last(groupId, status,
				orderByComparator);

		if (pCategory != null) {
			return pCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPCategoryException(msg.toString());
	}

	/**
	 * Returns the last p category in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p category, or <code>null</code> if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchByGroupAndStatus_Last(long groupId, boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupAndStatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<PCategory> list = findByGroupAndStatus(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p categories before and after the current p category in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current p category
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory[] findByGroupAndStatus_PrevAndNext(long id, long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PCategory[] array = new PCategoryImpl[3];

			array[0] = getByGroupAndStatus_PrevAndNext(session, pCategory,
					groupId, status, orderByComparator, true);

			array[1] = pCategory;

			array[2] = getByGroupAndStatus_PrevAndNext(session, pCategory,
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

	protected PCategory getByGroupAndStatus_PrevAndNext(Session session,
		PCategory pCategory, long groupId, boolean status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PCATEGORY_WHERE);

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
			query.append(PCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p categories where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndStatus(long groupId, boolean status)
		throws SystemException {
		for (PCategory pCategory : findByGroupAndStatus(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pCategory);
		}
	}

	/**
	 * Returns the number of p categories where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching p categories
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

			query.append(_SQL_COUNT_PCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2 = "pCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_STATUS_2 = "pCategory.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDNAME =
		new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME =
		new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndName",
			new String[] { Long.class.getName(), String.class.getName() },
			PCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			PCategoryModelImpl.NAME_COLUMN_BITMASK |
			PCategoryModelImpl.ORDER__COLUMN_BITMASK |
			PCategoryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDNAME = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the p categories where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroupAndName(long groupId, String name)
		throws SystemException {
		return findByGroupAndName(groupId, name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p categories where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @return the range of matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroupAndName(long groupId, String name,
		int start, int end) throws SystemException {
		return findByGroupAndName(groupId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p categories where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroupAndName(long groupId, String name,
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

		List<PCategory> list = (List<PCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PCategory pCategory : list) {
				if ((groupId != pCategory.getGroupId()) ||
						!Validator.equals(name, pCategory.getName())) {
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

			query.append(_SQL_SELECT_PCATEGORY_WHERE);

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
				query.append(PCategoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PCategory>(list);
				}
				else {
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p category in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findByGroupAndName_First(long groupId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchByGroupAndName_First(groupId, name,
				orderByComparator);

		if (pCategory != null) {
			return pCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPCategoryException(msg.toString());
	}

	/**
	 * Returns the first p category in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p category, or <code>null</code> if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchByGroupAndName_First(long groupId, String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<PCategory> list = findByGroupAndName(groupId, name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p category in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findByGroupAndName_Last(long groupId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchByGroupAndName_Last(groupId, name,
				orderByComparator);

		if (pCategory != null) {
			return pCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPCategoryException(msg.toString());
	}

	/**
	 * Returns the last p category in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p category, or <code>null</code> if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchByGroupAndName_Last(long groupId, String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupAndName(groupId, name);

		if (count == 0) {
			return null;
		}

		List<PCategory> list = findByGroupAndName(groupId, name, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p categories before and after the current p category in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param id the primary key of the current p category
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory[] findByGroupAndName_PrevAndNext(long id, long groupId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PCategory[] array = new PCategoryImpl[3];

			array[0] = getByGroupAndName_PrevAndNext(session, pCategory,
					groupId, name, orderByComparator, true);

			array[1] = pCategory;

			array[2] = getByGroupAndName_PrevAndNext(session, pCategory,
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

	protected PCategory getByGroupAndName_PrevAndNext(Session session,
		PCategory pCategory, long groupId, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PCATEGORY_WHERE);

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
			query.append(PCategoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(pCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p categories where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndName(long groupId, String name)
		throws SystemException {
		for (PCategory pCategory : findByGroupAndName(groupId, name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pCategory);
		}
	}

	/**
	 * Returns the number of p categories where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching p categories
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

			query.append(_SQL_COUNT_PCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPANDNAME_GROUPID_2 = "pCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDNAME_NAME_1 = "pCategory.name IS NULL";
	private static final String _FINDER_COLUMN_GROUPANDNAME_NAME_2 = "pCategory.name = ?";
	private static final String _FINDER_COLUMN_GROUPANDNAME_NAME_3 = "(pCategory.name IS NULL OR pCategory.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, PCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			PCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			PCategoryModelImpl.ORDER__COLUMN_BITMASK |
			PCategoryModelImpl.CREATEDATE_COLUMN_BITMASK |
			PCategoryModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @return the range of matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findByGroup(long groupId, int start, int end,
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

		List<PCategory> list = (List<PCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PCategory pCategory : list) {
				if ((groupId != pCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_PCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PCategory>(list);
				}
				else {
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchByGroup_First(groupId, orderByComparator);

		if (pCategory != null) {
			return pCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPCategoryException(msg.toString());
	}

	/**
	 * Returns the first p category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p category, or <code>null</code> if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PCategory> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchByGroup_Last(groupId, orderByComparator);

		if (pCategory != null) {
			return pCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPCategoryException(msg.toString());
	}

	/**
	 * Returns the last p category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p category, or <code>null</code> if a matching p category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<PCategory> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p categories before and after the current p category in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current p category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory[] findByGroup_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PCategory[] array = new PCategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, pCategory, groupId,
					orderByComparator, true);

			array[1] = pCategory;

			array[2] = getByGroup_PrevAndNext(session, pCategory, groupId,
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

	protected PCategory getByGroup_PrevAndNext(Session session,
		PCategory pCategory, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PCATEGORY_WHERE);

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
			query.append(PCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (PCategory pCategory : findByGroup(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(pCategory);
		}
	}

	/**
	 * Returns the number of p categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching p categories
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

			query.append(_SQL_COUNT_PCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "pCategory.groupId = ?";

	public PCategoryPersistenceImpl() {
		setModelClass(PCategory.class);
	}

	/**
	 * Caches the p category in the entity cache if it is enabled.
	 *
	 * @param pCategory the p category
	 */
	@Override
	public void cacheResult(PCategory pCategory) {
		EntityCacheUtil.putResult(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryImpl.class, pCategory.getPrimaryKey(), pCategory);

		pCategory.resetOriginalValues();
	}

	/**
	 * Caches the p categories in the entity cache if it is enabled.
	 *
	 * @param pCategories the p categories
	 */
	@Override
	public void cacheResult(List<PCategory> pCategories) {
		for (PCategory pCategory : pCategories) {
			if (EntityCacheUtil.getResult(
						PCategoryModelImpl.ENTITY_CACHE_ENABLED,
						PCategoryImpl.class, pCategory.getPrimaryKey()) == null) {
				cacheResult(pCategory);
			}
			else {
				pCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PCategory pCategory) {
		EntityCacheUtil.removeResult(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryImpl.class, pCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PCategory> pCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PCategory pCategory : pCategories) {
			EntityCacheUtil.removeResult(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
				PCategoryImpl.class, pCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new p category with the primary key. Does not add the p category to the database.
	 *
	 * @param id the primary key for the new p category
	 * @return the new p category
	 */
	@Override
	public PCategory create(long id) {
		PCategory pCategory = new PCategoryImpl();

		pCategory.setNew(true);
		pCategory.setPrimaryKey(id);

		return pCategory;
	}

	/**
	 * Removes the p category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the p category
	 * @return the p category that was removed
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory remove(long id)
		throws NoSuchPCategoryException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the p category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p category
	 * @return the p category that was removed
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory remove(Serializable primaryKey)
		throws NoSuchPCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PCategory pCategory = (PCategory)session.get(PCategoryImpl.class,
					primaryKey);

			if (pCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pCategory);
		}
		catch (NoSuchPCategoryException nsee) {
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
	protected PCategory removeImpl(PCategory pCategory)
		throws SystemException {
		pCategory = toUnwrappedModel(pCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pCategory)) {
				pCategory = (PCategory)session.get(PCategoryImpl.class,
						pCategory.getPrimaryKeyObj());
			}

			if (pCategory != null) {
				session.delete(pCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pCategory != null) {
			clearCache(pCategory);
		}

		return pCategory;
	}

	@Override
	public PCategory updateImpl(
		com.viettel.portal.photos.model.PCategory pCategory)
		throws SystemException {
		pCategory = toUnwrappedModel(pCategory);

		boolean isNew = pCategory.isNew();

		PCategoryModelImpl pCategoryModelImpl = (PCategoryModelImpl)pCategory;

		Session session = null;

		try {
			session = openSession();

			if (pCategory.isNew()) {
				session.save(pCategory);

				pCategory.setNew(false);
			}
			else {
				session.merge(pCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((pCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pCategoryModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { pCategoryModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((pCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pCategoryModelImpl.getOriginalGroupId(),
						pCategoryModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);

				args = new Object[] {
						pCategoryModelImpl.getGroupId(),
						pCategoryModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);
			}

			if ((pCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pCategoryModelImpl.getOriginalGroupId(),
						pCategoryModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME,
					args);

				args = new Object[] {
						pCategoryModelImpl.getGroupId(),
						pCategoryModelImpl.getName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDNAME,
					args);
			}

			if ((pCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { pCategoryModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PCategoryImpl.class, pCategory.getPrimaryKey(), pCategory);

		return pCategory;
	}

	protected PCategory toUnwrappedModel(PCategory pCategory) {
		if (pCategory instanceof PCategoryImpl) {
			return pCategory;
		}

		PCategoryImpl pCategoryImpl = new PCategoryImpl();

		pCategoryImpl.setNew(pCategory.isNew());
		pCategoryImpl.setPrimaryKey(pCategory.getPrimaryKey());

		pCategoryImpl.setId(pCategory.getId());
		pCategoryImpl.setName(pCategory.getName());
		pCategoryImpl.setOrder_(pCategory.getOrder_());
		pCategoryImpl.setStatus(pCategory.isStatus());
		pCategoryImpl.setCompanyId(pCategory.getCompanyId());
		pCategoryImpl.setGroupId(pCategory.getGroupId());
		pCategoryImpl.setCreateDate(pCategory.getCreateDate());
		pCategoryImpl.setModifyDate(pCategory.getModifyDate());
		pCategoryImpl.setUserName(pCategory.getUserName());
		pCategoryImpl.setUserId(pCategory.getUserId());

		return pCategoryImpl;
	}

	/**
	 * Returns the p category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p category
	 * @return the p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPCategoryException, SystemException {
		PCategory pCategory = fetchByPrimaryKey(primaryKey);

		if (pCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return pCategory;
	}

	/**
	 * Returns the p category with the primary key or throws a {@link com.viettel.portal.photos.NoSuchPCategoryException} if it could not be found.
	 *
	 * @param id the primary key of the p category
	 * @return the p category
	 * @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory findByPrimaryKey(long id)
		throws NoSuchPCategoryException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the p category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p category
	 * @return the p category, or <code>null</code> if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PCategory pCategory = (PCategory)EntityCacheUtil.getResult(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
				PCategoryImpl.class, primaryKey);

		if (pCategory == _nullPCategory) {
			return null;
		}

		if (pCategory == null) {
			Session session = null;

			try {
				session = openSession();

				pCategory = (PCategory)session.get(PCategoryImpl.class,
						primaryKey);

				if (pCategory != null) {
					cacheResult(pCategory);
				}
				else {
					EntityCacheUtil.putResult(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
						PCategoryImpl.class, primaryKey, _nullPCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PCategoryModelImpl.ENTITY_CACHE_ENABLED,
					PCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pCategory;
	}

	/**
	 * Returns the p category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the p category
	 * @return the p category, or <code>null</code> if a p category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PCategory fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the p categories.
	 *
	 * @return the p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @return the range of p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p categories
	 * @param end the upper bound of the range of p categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PCategory> findAll(int start, int end,
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

		List<PCategory> list = (List<PCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PCATEGORY;

				if (pagination) {
					sql = sql.concat(PCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PCategory>(list);
				}
				else {
					list = (List<PCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the p categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PCategory pCategory : findAll()) {
			remove(pCategory);
		}
	}

	/**
	 * Returns the number of p categories.
	 *
	 * @return the number of p categories
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

				Query q = session.createQuery(_SQL_COUNT_PCATEGORY);

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
	 * Initializes the p category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.photos.model.PCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PCategory>> listenersList = new ArrayList<ModelListener<PCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PCATEGORY = "SELECT pCategory FROM PCategory pCategory";
	private static final String _SQL_SELECT_PCATEGORY_WHERE = "SELECT pCategory FROM PCategory pCategory WHERE ";
	private static final String _SQL_COUNT_PCATEGORY = "SELECT COUNT(pCategory) FROM PCategory pCategory";
	private static final String _SQL_COUNT_PCATEGORY_WHERE = "SELECT COUNT(pCategory) FROM PCategory pCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static PCategory _nullPCategory = new PCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PCategory> toCacheModel() {
				return _nullPCategoryCacheModel;
			}
		};

	private static CacheModel<PCategory> _nullPCategoryCacheModel = new CacheModel<PCategory>() {
			@Override
			public PCategory toEntityModel() {
				return _nullPCategory;
			}
		};
}