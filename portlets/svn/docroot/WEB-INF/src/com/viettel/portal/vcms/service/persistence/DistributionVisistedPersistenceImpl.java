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

package com.viettel.portal.vcms.service.persistence;

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

import com.viettel.portal.vcms.NoSuchDistributionVisistedException;
import com.viettel.portal.vcms.model.DistributionVisisted;
import com.viettel.portal.vcms.model.impl.DistributionVisistedImpl;
import com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the distribution visisted service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see DistributionVisistedPersistence
 * @see DistributionVisistedUtil
 * @generated
 */
public class DistributionVisistedPersistenceImpl extends BasePersistenceImpl<DistributionVisisted>
	implements DistributionVisistedPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DistributionVisistedUtil} to access the distribution visisted persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DistributionVisistedImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedModelImpl.FINDER_CACHE_ENABLED,
			DistributionVisistedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedModelImpl.FINDER_CACHE_ENABLED,
			DistributionVisistedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_D = new FinderPath(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedModelImpl.FINDER_CACHE_ENABLED,
			DistributionVisistedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_D",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D = new FinderPath(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedModelImpl.FINDER_CACHE_ENABLED,
			DistributionVisistedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_D",
			new String[] { Long.class.getName(), Long.class.getName() },
			DistributionVisistedModelImpl.GROUPID_COLUMN_BITMASK |
			DistributionVisistedModelImpl.DISTRIBUTIONID_COLUMN_BITMASK |
			DistributionVisistedModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_D = new FinderPath(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_D",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the distribution visisteds where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @return the matching distribution visisteds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DistributionVisisted> findByG_D(long groupId,
		long distributionId) throws SystemException {
		return findByG_D(groupId, distributionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distribution visisteds where groupId = &#63; and distributionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param start the lower bound of the range of distribution visisteds
	 * @param end the upper bound of the range of distribution visisteds (not inclusive)
	 * @return the range of matching distribution visisteds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DistributionVisisted> findByG_D(long groupId,
		long distributionId, int start, int end) throws SystemException {
		return findByG_D(groupId, distributionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the distribution visisteds where groupId = &#63; and distributionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param start the lower bound of the range of distribution visisteds
	 * @param end the upper bound of the range of distribution visisteds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching distribution visisteds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DistributionVisisted> findByG_D(long groupId,
		long distributionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D;
			finderArgs = new Object[] { groupId, distributionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_D;
			finderArgs = new Object[] {
					groupId, distributionId,
					
					start, end, orderByComparator
				};
		}

		List<DistributionVisisted> list = (List<DistributionVisisted>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DistributionVisisted distributionVisisted : list) {
				if ((groupId != distributionVisisted.getGroupId()) ||
						(distributionId != distributionVisisted.getDistributionId())) {
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

			query.append(_SQL_SELECT_DISTRIBUTIONVISISTED_WHERE);

			query.append(_FINDER_COLUMN_G_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_D_DISTRIBUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DistributionVisistedModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(distributionId);

				if (!pagination) {
					list = (List<DistributionVisisted>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DistributionVisisted>(list);
				}
				else {
					list = (List<DistributionVisisted>)QueryUtil.list(q,
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
	 * Returns the first distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution visisted
	 * @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a matching distribution visisted could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted findByG_D_First(long groupId,
		long distributionId, OrderByComparator orderByComparator)
		throws NoSuchDistributionVisistedException, SystemException {
		DistributionVisisted distributionVisisted = fetchByG_D_First(groupId,
				distributionId, orderByComparator);

		if (distributionVisisted != null) {
			return distributionVisisted;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", distributionId=");
		msg.append(distributionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionVisistedException(msg.toString());
	}

	/**
	 * Returns the first distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution visisted, or <code>null</code> if a matching distribution visisted could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted fetchByG_D_First(long groupId,
		long distributionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<DistributionVisisted> list = findByG_D(groupId, distributionId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution visisted
	 * @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a matching distribution visisted could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted findByG_D_Last(long groupId,
		long distributionId, OrderByComparator orderByComparator)
		throws NoSuchDistributionVisistedException, SystemException {
		DistributionVisisted distributionVisisted = fetchByG_D_Last(groupId,
				distributionId, orderByComparator);

		if (distributionVisisted != null) {
			return distributionVisisted;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", distributionId=");
		msg.append(distributionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionVisistedException(msg.toString());
	}

	/**
	 * Returns the last distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution visisted, or <code>null</code> if a matching distribution visisted could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted fetchByG_D_Last(long groupId,
		long distributionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_D(groupId, distributionId);

		if (count == 0) {
			return null;
		}

		List<DistributionVisisted> list = findByG_D(groupId, distributionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the distribution visisteds before and after the current distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param visistedId the primary key of the current distribution visisted
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next distribution visisted
	 * @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted[] findByG_D_PrevAndNext(long visistedId,
		long groupId, long distributionId, OrderByComparator orderByComparator)
		throws NoSuchDistributionVisistedException, SystemException {
		DistributionVisisted distributionVisisted = findByPrimaryKey(visistedId);

		Session session = null;

		try {
			session = openSession();

			DistributionVisisted[] array = new DistributionVisistedImpl[3];

			array[0] = getByG_D_PrevAndNext(session, distributionVisisted,
					groupId, distributionId, orderByComparator, true);

			array[1] = distributionVisisted;

			array[2] = getByG_D_PrevAndNext(session, distributionVisisted,
					groupId, distributionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DistributionVisisted getByG_D_PrevAndNext(Session session,
		DistributionVisisted distributionVisisted, long groupId,
		long distributionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISTRIBUTIONVISISTED_WHERE);

		query.append(_FINDER_COLUMN_G_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_D_DISTRIBUTIONID_2);

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
			query.append(DistributionVisistedModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(distributionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(distributionVisisted);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DistributionVisisted> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the distribution visisteds where groupId = &#63; and distributionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_D(long groupId, long distributionId)
		throws SystemException {
		for (DistributionVisisted distributionVisisted : findByG_D(groupId,
				distributionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(distributionVisisted);
		}
	}

	/**
	 * Returns the number of distribution visisteds where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @return the number of matching distribution visisteds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_D(long groupId, long distributionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_D;

		Object[] finderArgs = new Object[] { groupId, distributionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DISTRIBUTIONVISISTED_WHERE);

			query.append(_FINDER_COLUMN_G_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_D_DISTRIBUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(distributionId);

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

	private static final String _FINDER_COLUMN_G_D_GROUPID_2 = "distributionVisisted.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_D_DISTRIBUTIONID_2 = "distributionVisisted.distributionId = ?";

	public DistributionVisistedPersistenceImpl() {
		setModelClass(DistributionVisisted.class);
	}

	/**
	 * Caches the distribution visisted in the entity cache if it is enabled.
	 *
	 * @param distributionVisisted the distribution visisted
	 */
	@Override
	public void cacheResult(DistributionVisisted distributionVisisted) {
		EntityCacheUtil.putResult(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedImpl.class,
			distributionVisisted.getPrimaryKey(), distributionVisisted);

		distributionVisisted.resetOriginalValues();
	}

	/**
	 * Caches the distribution visisteds in the entity cache if it is enabled.
	 *
	 * @param distributionVisisteds the distribution visisteds
	 */
	@Override
	public void cacheResult(List<DistributionVisisted> distributionVisisteds) {
		for (DistributionVisisted distributionVisisted : distributionVisisteds) {
			if (EntityCacheUtil.getResult(
						DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
						DistributionVisistedImpl.class,
						distributionVisisted.getPrimaryKey()) == null) {
				cacheResult(distributionVisisted);
			}
			else {
				distributionVisisted.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all distribution visisteds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DistributionVisistedImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DistributionVisistedImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the distribution visisted.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DistributionVisisted distributionVisisted) {
		EntityCacheUtil.removeResult(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedImpl.class, distributionVisisted.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DistributionVisisted> distributionVisisteds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DistributionVisisted distributionVisisted : distributionVisisteds) {
			EntityCacheUtil.removeResult(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
				DistributionVisistedImpl.class,
				distributionVisisted.getPrimaryKey());
		}
	}

	/**
	 * Creates a new distribution visisted with the primary key. Does not add the distribution visisted to the database.
	 *
	 * @param visistedId the primary key for the new distribution visisted
	 * @return the new distribution visisted
	 */
	@Override
	public DistributionVisisted create(long visistedId) {
		DistributionVisisted distributionVisisted = new DistributionVisistedImpl();

		distributionVisisted.setNew(true);
		distributionVisisted.setPrimaryKey(visistedId);

		return distributionVisisted;
	}

	/**
	 * Removes the distribution visisted with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visistedId the primary key of the distribution visisted
	 * @return the distribution visisted that was removed
	 * @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted remove(long visistedId)
		throws NoSuchDistributionVisistedException, SystemException {
		return remove((Serializable)visistedId);
	}

	/**
	 * Removes the distribution visisted with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the distribution visisted
	 * @return the distribution visisted that was removed
	 * @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted remove(Serializable primaryKey)
		throws NoSuchDistributionVisistedException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DistributionVisisted distributionVisisted = (DistributionVisisted)session.get(DistributionVisistedImpl.class,
					primaryKey);

			if (distributionVisisted == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDistributionVisistedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(distributionVisisted);
		}
		catch (NoSuchDistributionVisistedException nsee) {
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
	protected DistributionVisisted removeImpl(
		DistributionVisisted distributionVisisted) throws SystemException {
		distributionVisisted = toUnwrappedModel(distributionVisisted);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(distributionVisisted)) {
				distributionVisisted = (DistributionVisisted)session.get(DistributionVisistedImpl.class,
						distributionVisisted.getPrimaryKeyObj());
			}

			if (distributionVisisted != null) {
				session.delete(distributionVisisted);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (distributionVisisted != null) {
			clearCache(distributionVisisted);
		}

		return distributionVisisted;
	}

	@Override
	public DistributionVisisted updateImpl(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted)
		throws SystemException {
		distributionVisisted = toUnwrappedModel(distributionVisisted);

		boolean isNew = distributionVisisted.isNew();

		DistributionVisistedModelImpl distributionVisistedModelImpl = (DistributionVisistedModelImpl)distributionVisisted;

		Session session = null;

		try {
			session = openSession();

			if (distributionVisisted.isNew()) {
				session.save(distributionVisisted);

				distributionVisisted.setNew(false);
			}
			else {
				session.merge(distributionVisisted);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DistributionVisistedModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((distributionVisistedModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						distributionVisistedModelImpl.getOriginalGroupId(),
						distributionVisistedModelImpl.getOriginalDistributionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D,
					args);

				args = new Object[] {
						distributionVisistedModelImpl.getGroupId(),
						distributionVisistedModelImpl.getDistributionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D,
					args);
			}
		}

		EntityCacheUtil.putResult(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
			DistributionVisistedImpl.class,
			distributionVisisted.getPrimaryKey(), distributionVisisted);

		return distributionVisisted;
	}

	protected DistributionVisisted toUnwrappedModel(
		DistributionVisisted distributionVisisted) {
		if (distributionVisisted instanceof DistributionVisistedImpl) {
			return distributionVisisted;
		}

		DistributionVisistedImpl distributionVisistedImpl = new DistributionVisistedImpl();

		distributionVisistedImpl.setNew(distributionVisisted.isNew());
		distributionVisistedImpl.setPrimaryKey(distributionVisisted.getPrimaryKey());

		distributionVisistedImpl.setVisistedId(distributionVisisted.getVisistedId());
		distributionVisistedImpl.setDistributionId(distributionVisisted.getDistributionId());
		distributionVisistedImpl.setGroupId(distributionVisisted.getGroupId());
		distributionVisistedImpl.setCreateDate(distributionVisisted.getCreateDate());

		return distributionVisistedImpl;
	}

	/**
	 * Returns the distribution visisted with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the distribution visisted
	 * @return the distribution visisted
	 * @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDistributionVisistedException, SystemException {
		DistributionVisisted distributionVisisted = fetchByPrimaryKey(primaryKey);

		if (distributionVisisted == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDistributionVisistedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return distributionVisisted;
	}

	/**
	 * Returns the distribution visisted with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchDistributionVisistedException} if it could not be found.
	 *
	 * @param visistedId the primary key of the distribution visisted
	 * @return the distribution visisted
	 * @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted findByPrimaryKey(long visistedId)
		throws NoSuchDistributionVisistedException, SystemException {
		return findByPrimaryKey((Serializable)visistedId);
	}

	/**
	 * Returns the distribution visisted with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the distribution visisted
	 * @return the distribution visisted, or <code>null</code> if a distribution visisted with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DistributionVisisted distributionVisisted = (DistributionVisisted)EntityCacheUtil.getResult(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
				DistributionVisistedImpl.class, primaryKey);

		if (distributionVisisted == _nullDistributionVisisted) {
			return null;
		}

		if (distributionVisisted == null) {
			Session session = null;

			try {
				session = openSession();

				distributionVisisted = (DistributionVisisted)session.get(DistributionVisistedImpl.class,
						primaryKey);

				if (distributionVisisted != null) {
					cacheResult(distributionVisisted);
				}
				else {
					EntityCacheUtil.putResult(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
						DistributionVisistedImpl.class, primaryKey,
						_nullDistributionVisisted);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DistributionVisistedModelImpl.ENTITY_CACHE_ENABLED,
					DistributionVisistedImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return distributionVisisted;
	}

	/**
	 * Returns the distribution visisted with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visistedId the primary key of the distribution visisted
	 * @return the distribution visisted, or <code>null</code> if a distribution visisted with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DistributionVisisted fetchByPrimaryKey(long visistedId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)visistedId);
	}

	/**
	 * Returns all the distribution visisteds.
	 *
	 * @return the distribution visisteds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DistributionVisisted> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distribution visisteds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of distribution visisteds
	 * @param end the upper bound of the range of distribution visisteds (not inclusive)
	 * @return the range of distribution visisteds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DistributionVisisted> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the distribution visisteds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of distribution visisteds
	 * @param end the upper bound of the range of distribution visisteds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of distribution visisteds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DistributionVisisted> findAll(int start, int end,
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

		List<DistributionVisisted> list = (List<DistributionVisisted>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISTRIBUTIONVISISTED);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISTRIBUTIONVISISTED;

				if (pagination) {
					sql = sql.concat(DistributionVisistedModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DistributionVisisted>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DistributionVisisted>(list);
				}
				else {
					list = (List<DistributionVisisted>)QueryUtil.list(q,
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
	 * Removes all the distribution visisteds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DistributionVisisted distributionVisisted : findAll()) {
			remove(distributionVisisted);
		}
	}

	/**
	 * Returns the number of distribution visisteds.
	 *
	 * @return the number of distribution visisteds
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

				Query q = session.createQuery(_SQL_COUNT_DISTRIBUTIONVISISTED);

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
	 * Initializes the distribution visisted persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.DistributionVisisted")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DistributionVisisted>> listenersList = new ArrayList<ModelListener<DistributionVisisted>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DistributionVisisted>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DistributionVisistedImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DISTRIBUTIONVISISTED = "SELECT distributionVisisted FROM DistributionVisisted distributionVisisted";
	private static final String _SQL_SELECT_DISTRIBUTIONVISISTED_WHERE = "SELECT distributionVisisted FROM DistributionVisisted distributionVisisted WHERE ";
	private static final String _SQL_COUNT_DISTRIBUTIONVISISTED = "SELECT COUNT(distributionVisisted) FROM DistributionVisisted distributionVisisted";
	private static final String _SQL_COUNT_DISTRIBUTIONVISISTED_WHERE = "SELECT COUNT(distributionVisisted) FROM DistributionVisisted distributionVisisted WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "distributionVisisted.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DistributionVisisted exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DistributionVisisted exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DistributionVisistedPersistenceImpl.class);
	private static DistributionVisisted _nullDistributionVisisted = new DistributionVisistedImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DistributionVisisted> toCacheModel() {
				return _nullDistributionVisistedCacheModel;
			}
		};

	private static CacheModel<DistributionVisisted> _nullDistributionVisistedCacheModel =
		new CacheModel<DistributionVisisted>() {
			@Override
			public DistributionVisisted toEntityModel() {
				return _nullDistributionVisisted;
			}
		};
}