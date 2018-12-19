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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.vcms.NoSuchDistributionException;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.model.impl.DistributionImpl;
import com.viettel.portal.vcms.model.impl.DistributionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the distribution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see DistributionPersistence
 * @see DistributionUtil
 * @generated
 */
public class DistributionPersistenceImpl extends BasePersistenceImpl<Distribution>
	implements DistributionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DistributionUtil} to access the distribution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DistributionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_V_C = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_V_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_C =
		new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_V_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName()
			},
			DistributionModelImpl.GROUPID_COLUMN_BITMASK |
			DistributionModelImpl.CONTENTID_COLUMN_BITMASK |
			DistributionModelImpl.VERSION_COLUMN_BITMASK |
			DistributionModelImpl.CATEGORYID_COLUMN_BITMASK |
			DistributionModelImpl.DISTRIBUTEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_V_C = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_V_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @return the matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByG_C_V_C(long groupId, long contentId,
		int version, long categoryId) throws SystemException {
		return findByG_C_V_C(groupId, contentId, version, categoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByG_C_V_C(long groupId, long contentId,
		int version, long categoryId, int start, int end)
		throws SystemException {
		return findByG_C_V_C(groupId, contentId, version, categoryId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByG_C_V_C(long groupId, long contentId,
		int version, long categoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_C;
			finderArgs = new Object[] { groupId, contentId, version, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_V_C;
			finderArgs = new Object[] {
					groupId, contentId, version, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<Distribution> list = (List<Distribution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Distribution distribution : list) {
				if ((groupId != distribution.getGroupId()) ||
						(contentId != distribution.getContentId()) ||
						(version != distribution.getVersion()) ||
						(categoryId != distribution.getCategoryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

			query.append(_FINDER_COLUMN_G_C_V_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_V_C_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_C_V_C_VERSION_2);

			query.append(_FINDER_COLUMN_G_C_V_C_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentId);

				qPos.add(version);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Distribution>(list);
				}
				else {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByG_C_V_C_First(long groupId, long contentId,
		int version, long categoryId, OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByG_C_V_C_First(groupId, contentId,
				version, categoryId, orderByComparator);

		if (distribution != null) {
			return distribution;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionException(msg.toString());
	}

	/**
	 * Returns the first distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByG_C_V_C_First(long groupId, long contentId,
		int version, long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Distribution> list = findByG_C_V_C(groupId, contentId, version,
				categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByG_C_V_C_Last(long groupId, long contentId,
		int version, long categoryId, OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByG_C_V_C_Last(groupId, contentId,
				version, categoryId, orderByComparator);

		if (distribution != null) {
			return distribution;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionException(msg.toString());
	}

	/**
	 * Returns the last distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByG_C_V_C_Last(long groupId, long contentId,
		int version, long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_C_V_C(groupId, contentId, version, categoryId);

		if (count == 0) {
			return null;
		}

		List<Distribution> list = findByG_C_V_C(groupId, contentId, version,
				categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the distributions before and after the current distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param distributionId the primary key of the current distribution
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution[] findByG_C_V_C_PrevAndNext(long distributionId,
		long groupId, long contentId, int version, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = findByPrimaryKey(distributionId);

		Session session = null;

		try {
			session = openSession();

			Distribution[] array = new DistributionImpl[3];

			array[0] = getByG_C_V_C_PrevAndNext(session, distribution, groupId,
					contentId, version, categoryId, orderByComparator, true);

			array[1] = distribution;

			array[2] = getByG_C_V_C_PrevAndNext(session, distribution, groupId,
					contentId, version, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Distribution getByG_C_V_C_PrevAndNext(Session session,
		Distribution distribution, long groupId, long contentId, int version,
		long categoryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

		query.append(_FINDER_COLUMN_G_C_V_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_C_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_C_VERSION_2);

		query.append(_FINDER_COLUMN_G_C_V_C_CATEGORYID_2);

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
			query.append(DistributionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contentId);

		qPos.add(version);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(distribution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Distribution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the distributions that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @return the matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByG_C_V_C(long groupId, long contentId,
		int version, long categoryId) throws SystemException {
		return filterFindByG_C_V_C(groupId, contentId, version, categoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByG_C_V_C(long groupId, long contentId,
		int version, long categoryId, int start, int end)
		throws SystemException {
		return filterFindByG_C_V_C(groupId, contentId, version, categoryId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the distributions that the user has permissions to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByG_C_V_C(long groupId, long contentId,
		int version, long categoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_V_C(groupId, contentId, version, categoryId,
				start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_V_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_C_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_C_VERSION_2);

		query.append(_FINDER_COLUMN_G_C_V_C_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DistributionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DistributionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DistributionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contentId);

			qPos.add(version);

			qPos.add(categoryId);

			return (List<Distribution>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the distributions before and after the current distribution in the ordered set of distributions that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param distributionId the primary key of the current distribution
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution[] filterFindByG_C_V_C_PrevAndNext(long distributionId,
		long groupId, long contentId, int version, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_V_C_PrevAndNext(distributionId, groupId,
				contentId, version, categoryId, orderByComparator);
		}

		Distribution distribution = findByPrimaryKey(distributionId);

		Session session = null;

		try {
			session = openSession();

			Distribution[] array = new DistributionImpl[3];

			array[0] = filterGetByG_C_V_C_PrevAndNext(session, distribution,
					groupId, contentId, version, categoryId, orderByComparator,
					true);

			array[1] = distribution;

			array[2] = filterGetByG_C_V_C_PrevAndNext(session, distribution,
					groupId, contentId, version, categoryId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Distribution filterGetByG_C_V_C_PrevAndNext(Session session,
		Distribution distribution, long groupId, long contentId, int version,
		long categoryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_V_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_C_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_C_VERSION_2);

		query.append(_FINDER_COLUMN_G_C_V_C_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DistributionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DistributionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DistributionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contentId);

		qPos.add(version);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(distribution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Distribution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_C_V_C(long groupId, long contentId, int version,
		long categoryId) throws SystemException {
		for (Distribution distribution : findByG_C_V_C(groupId, contentId,
				version, categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(distribution);
		}
	}

	/**
	 * Returns the number of distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @return the number of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C_V_C(long groupId, long contentId, int version,
		long categoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C_V_C;

		Object[] finderArgs = new Object[] {
				groupId, contentId, version, categoryId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_DISTRIBUTION_WHERE);

			query.append(_FINDER_COLUMN_G_C_V_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_V_C_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_C_V_C_VERSION_2);

			query.append(_FINDER_COLUMN_G_C_V_C_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentId);

				qPos.add(version);

				qPos.add(categoryId);

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

	/**
	 * Returns the number of distributions that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param categoryId the category ID
	 * @return the number of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_C_V_C(long groupId, long contentId, int version,
		long categoryId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_V_C(groupId, contentId, version, categoryId);
		}

		StringBundler query = new StringBundler(5);

		query.append(_FILTER_SQL_COUNT_DISTRIBUTION_WHERE);

		query.append(_FINDER_COLUMN_G_C_V_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_C_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_C_VERSION_2);

		query.append(_FINDER_COLUMN_G_C_V_C_CATEGORYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contentId);

			qPos.add(version);

			qPos.add(categoryId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_C_V_C_GROUPID_2 = "distribution.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_C_CONTENTID_2 = "distribution.contentId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_C_VERSION_2 = "distribution.version = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_C_CATEGORYID_2 = "distribution.categoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYGROUPNCATEGORY =
		new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByGroupNCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPNCATEGORY =
		new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByByGroupNCategory",
			new String[] { Long.class.getName(), Long.class.getName() },
			DistributionModelImpl.GROUPID_COLUMN_BITMASK |
			DistributionModelImpl.CATEGORYID_COLUMN_BITMASK |
			DistributionModelImpl.DISTRIBUTEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYGROUPNCATEGORY = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByByGroupNCategory",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the distributions where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByByGroupNCategory(long groupId,
		long categoryId) throws SystemException {
		return findByByGroupNCategory(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByByGroupNCategory(long groupId,
		long categoryId, int start, int end) throws SystemException {
		return findByByGroupNCategory(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the distributions where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByByGroupNCategory(long groupId,
		long categoryId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPNCATEGORY;
			finderArgs = new Object[] { groupId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYGROUPNCATEGORY;
			finderArgs = new Object[] {
					groupId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<Distribution> list = (List<Distribution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Distribution distribution : list) {
				if ((groupId != distribution.getGroupId()) ||
						(categoryId != distribution.getCategoryId())) {
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

			query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

			query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_GROUPID_2);

			query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Distribution>(list);
				}
				else {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByByGroupNCategory_First(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByByGroupNCategory_First(groupId,
				categoryId, orderByComparator);

		if (distribution != null) {
			return distribution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionException(msg.toString());
	}

	/**
	 * Returns the first distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByByGroupNCategory_First(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Distribution> list = findByByGroupNCategory(groupId, categoryId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByByGroupNCategory_Last(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByByGroupNCategory_Last(groupId,
				categoryId, orderByComparator);

		if (distribution != null) {
			return distribution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionException(msg.toString());
	}

	/**
	 * Returns the last distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByByGroupNCategory_Last(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByByGroupNCategory(groupId, categoryId);

		if (count == 0) {
			return null;
		}

		List<Distribution> list = findByByGroupNCategory(groupId, categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the distributions before and after the current distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param distributionId the primary key of the current distribution
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution[] findByByGroupNCategory_PrevAndNext(
		long distributionId, long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = findByPrimaryKey(distributionId);

		Session session = null;

		try {
			session = openSession();

			Distribution[] array = new DistributionImpl[3];

			array[0] = getByByGroupNCategory_PrevAndNext(session, distribution,
					groupId, categoryId, orderByComparator, true);

			array[1] = distribution;

			array[2] = getByByGroupNCategory_PrevAndNext(session, distribution,
					groupId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Distribution getByByGroupNCategory_PrevAndNext(Session session,
		Distribution distribution, long groupId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

		query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_GROUPID_2);

		query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_CATEGORYID_2);

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
			query.append(DistributionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(distribution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Distribution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the distributions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByByGroupNCategory(long groupId,
		long categoryId) throws SystemException {
		return filterFindByByGroupNCategory(groupId, categoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByByGroupNCategory(long groupId,
		long categoryId, int start, int end) throws SystemException {
		return filterFindByByGroupNCategory(groupId, categoryId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the distributions that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByByGroupNCategory(long groupId,
		long categoryId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByByGroupNCategory(groupId, categoryId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_GROUPID_2);

		query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DistributionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DistributionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DistributionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			return (List<Distribution>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the distributions before and after the current distribution in the ordered set of distributions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param distributionId the primary key of the current distribution
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution[] filterFindByByGroupNCategory_PrevAndNext(
		long distributionId, long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByByGroupNCategory_PrevAndNext(distributionId, groupId,
				categoryId, orderByComparator);
		}

		Distribution distribution = findByPrimaryKey(distributionId);

		Session session = null;

		try {
			session = openSession();

			Distribution[] array = new DistributionImpl[3];

			array[0] = filterGetByByGroupNCategory_PrevAndNext(session,
					distribution, groupId, categoryId, orderByComparator, true);

			array[1] = distribution;

			array[2] = filterGetByByGroupNCategory_PrevAndNext(session,
					distribution, groupId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Distribution filterGetByByGroupNCategory_PrevAndNext(
		Session session, Distribution distribution, long groupId,
		long categoryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_GROUPID_2);

		query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DistributionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DistributionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DistributionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(distribution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Distribution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the distributions where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByByGroupNCategory(long groupId, long categoryId)
		throws SystemException {
		for (Distribution distribution : findByByGroupNCategory(groupId,
				categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(distribution);
		}
	}

	/**
	 * Returns the number of distributions where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByByGroupNCategory(long groupId, long categoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYGROUPNCATEGORY;

		Object[] finderArgs = new Object[] { groupId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DISTRIBUTION_WHERE);

			query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_GROUPID_2);

			query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

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

	/**
	 * Returns the number of distributions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByByGroupNCategory(long groupId, long categoryId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByByGroupNCategory(groupId, categoryId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_DISTRIBUTION_WHERE);

		query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_GROUPID_2);

		query.append(_FINDER_COLUMN_BYGROUPNCATEGORY_CATEGORYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_BYGROUPNCATEGORY_GROUPID_2 = "distribution.groupId = ? AND ";
	private static final String _FINDER_COLUMN_BYGROUPNCATEGORY_CATEGORYID_2 = "distribution.categoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCONTENTID =
		new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupContentId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCONTENTID =
		new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupContentId",
			new String[] { Long.class.getName(), Long.class.getName() },
			DistributionModelImpl.GROUPID_COLUMN_BITMASK |
			DistributionModelImpl.CONTENTID_COLUMN_BITMASK |
			DistributionModelImpl.DISTRIBUTEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCONTENTID = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupContentId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the distributions where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByGroupContentId(long groupId, long contentId)
		throws SystemException {
		return findByGroupContentId(groupId, contentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByGroupContentId(long groupId,
		long contentId, int start, int end) throws SystemException {
		return findByGroupContentId(groupId, contentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the distributions where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByGroupContentId(long groupId,
		long contentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCONTENTID;
			finderArgs = new Object[] { groupId, contentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCONTENTID;
			finderArgs = new Object[] {
					groupId, contentId,
					
					start, end, orderByComparator
				};
		}

		List<Distribution> list = (List<Distribution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Distribution distribution : list) {
				if ((groupId != distribution.getGroupId()) ||
						(contentId != distribution.getContentId())) {
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

			query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPCONTENTID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCONTENTID_CONTENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentId);

				if (!pagination) {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Distribution>(list);
				}
				else {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByGroupContentId_First(long groupId,
		long contentId, OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByGroupContentId_First(groupId,
				contentId, orderByComparator);

		if (distribution != null) {
			return distribution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionException(msg.toString());
	}

	/**
	 * Returns the first distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByGroupContentId_First(long groupId,
		long contentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Distribution> list = findByGroupContentId(groupId, contentId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByGroupContentId_Last(long groupId, long contentId,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByGroupContentId_Last(groupId,
				contentId, orderByComparator);

		if (distribution != null) {
			return distribution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionException(msg.toString());
	}

	/**
	 * Returns the last distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByGroupContentId_Last(long groupId,
		long contentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupContentId(groupId, contentId);

		if (count == 0) {
			return null;
		}

		List<Distribution> list = findByGroupContentId(groupId, contentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the distributions before and after the current distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param distributionId the primary key of the current distribution
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution[] findByGroupContentId_PrevAndNext(
		long distributionId, long groupId, long contentId,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = findByPrimaryKey(distributionId);

		Session session = null;

		try {
			session = openSession();

			Distribution[] array = new DistributionImpl[3];

			array[0] = getByGroupContentId_PrevAndNext(session, distribution,
					groupId, contentId, orderByComparator, true);

			array[1] = distribution;

			array[2] = getByGroupContentId_PrevAndNext(session, distribution,
					groupId, contentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Distribution getByGroupContentId_PrevAndNext(Session session,
		Distribution distribution, long groupId, long contentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

		query.append(_FINDER_COLUMN_GROUPCONTENTID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCONTENTID_CONTENTID_2);

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
			query.append(DistributionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(distribution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Distribution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the distributions that the user has permission to view where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByGroupContentId(long groupId,
		long contentId) throws SystemException {
		return filterFindByGroupContentId(groupId, contentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions that the user has permission to view where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByGroupContentId(long groupId,
		long contentId, int start, int end) throws SystemException {
		return filterFindByGroupContentId(groupId, contentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the distributions that the user has permissions to view where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> filterFindByGroupContentId(long groupId,
		long contentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupContentId(groupId, contentId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPCONTENTID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCONTENTID_CONTENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DistributionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DistributionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DistributionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contentId);

			return (List<Distribution>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the distributions before and after the current distribution in the ordered set of distributions that the user has permission to view where groupId = &#63; and contentId = &#63;.
	 *
	 * @param distributionId the primary key of the current distribution
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution[] filterFindByGroupContentId_PrevAndNext(
		long distributionId, long groupId, long contentId,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupContentId_PrevAndNext(distributionId, groupId,
				contentId, orderByComparator);
		}

		Distribution distribution = findByPrimaryKey(distributionId);

		Session session = null;

		try {
			session = openSession();

			Distribution[] array = new DistributionImpl[3];

			array[0] = filterGetByGroupContentId_PrevAndNext(session,
					distribution, groupId, contentId, orderByComparator, true);

			array[1] = distribution;

			array[2] = filterGetByGroupContentId_PrevAndNext(session,
					distribution, groupId, contentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Distribution filterGetByGroupContentId_PrevAndNext(
		Session session, Distribution distribution, long groupId,
		long contentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPCONTENTID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCONTENTID_CONTENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DistributionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DistributionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DistributionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(distribution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Distribution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the distributions where groupId = &#63; and contentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupContentId(long groupId, long contentId)
		throws SystemException {
		for (Distribution distribution : findByGroupContentId(groupId,
				contentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(distribution);
		}
	}

	/**
	 * Returns the number of distributions where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the number of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupContentId(long groupId, long contentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPCONTENTID;

		Object[] finderArgs = new Object[] { groupId, contentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DISTRIBUTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPCONTENTID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCONTENTID_CONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentId);

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

	/**
	 * Returns the number of distributions that the user has permission to view where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the number of matching distributions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupContentId(long groupId, long contentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupContentId(groupId, contentId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_DISTRIBUTION_WHERE);

		query.append(_FINDER_COLUMN_GROUPCONTENTID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCONTENTID_CONTENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Distribution.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contentId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPCONTENTID_GROUPID_2 = "distribution.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCONTENTID_CONTENTID_2 = "distribution.contentId = ?";

	public DistributionPersistenceImpl() {
		setModelClass(Distribution.class);
	}

	/**
	 * Caches the distribution in the entity cache if it is enabled.
	 *
	 * @param distribution the distribution
	 */
	@Override
	public void cacheResult(Distribution distribution) {
		EntityCacheUtil.putResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionImpl.class, distribution.getPrimaryKey(), distribution);

		distribution.resetOriginalValues();
	}

	/**
	 * Caches the distributions in the entity cache if it is enabled.
	 *
	 * @param distributions the distributions
	 */
	@Override
	public void cacheResult(List<Distribution> distributions) {
		for (Distribution distribution : distributions) {
			if (EntityCacheUtil.getResult(
						DistributionModelImpl.ENTITY_CACHE_ENABLED,
						DistributionImpl.class, distribution.getPrimaryKey()) == null) {
				cacheResult(distribution);
			}
			else {
				distribution.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all distributions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DistributionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DistributionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the distribution.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Distribution distribution) {
		EntityCacheUtil.removeResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionImpl.class, distribution.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Distribution> distributions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Distribution distribution : distributions) {
			EntityCacheUtil.removeResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
				DistributionImpl.class, distribution.getPrimaryKey());
		}
	}

	/**
	 * Creates a new distribution with the primary key. Does not add the distribution to the database.
	 *
	 * @param distributionId the primary key for the new distribution
	 * @return the new distribution
	 */
	@Override
	public Distribution create(long distributionId) {
		Distribution distribution = new DistributionImpl();

		distribution.setNew(true);
		distribution.setPrimaryKey(distributionId);

		return distribution;
	}

	/**
	 * Removes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param distributionId the primary key of the distribution
	 * @return the distribution that was removed
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution remove(long distributionId)
		throws NoSuchDistributionException, SystemException {
		return remove((Serializable)distributionId);
	}

	/**
	 * Removes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the distribution
	 * @return the distribution that was removed
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution remove(Serializable primaryKey)
		throws NoSuchDistributionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Distribution distribution = (Distribution)session.get(DistributionImpl.class,
					primaryKey);

			if (distribution == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDistributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(distribution);
		}
		catch (NoSuchDistributionException nsee) {
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
	protected Distribution removeImpl(Distribution distribution)
		throws SystemException {
		distribution = toUnwrappedModel(distribution);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(distribution)) {
				distribution = (Distribution)session.get(DistributionImpl.class,
						distribution.getPrimaryKeyObj());
			}

			if (distribution != null) {
				session.delete(distribution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (distribution != null) {
			clearCache(distribution);
		}

		return distribution;
	}

	@Override
	public Distribution updateImpl(
		com.viettel.portal.vcms.model.Distribution distribution)
		throws SystemException {
		distribution = toUnwrappedModel(distribution);

		boolean isNew = distribution.isNew();

		DistributionModelImpl distributionModelImpl = (DistributionModelImpl)distribution;

		Session session = null;

		try {
			session = openSession();

			if (distribution.isNew()) {
				session.save(distribution);

				distribution.setNew(false);
			}
			else {
				session.merge(distribution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DistributionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((distributionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						distributionModelImpl.getOriginalGroupId(),
						distributionModelImpl.getOriginalContentId(),
						distributionModelImpl.getOriginalVersion(),
						distributionModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_V_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_C,
					args);

				args = new Object[] {
						distributionModelImpl.getGroupId(),
						distributionModelImpl.getContentId(),
						distributionModelImpl.getVersion(),
						distributionModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_V_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_C,
					args);
			}

			if ((distributionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPNCATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						distributionModelImpl.getOriginalGroupId(),
						distributionModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYGROUPNCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPNCATEGORY,
					args);

				args = new Object[] {
						distributionModelImpl.getGroupId(),
						distributionModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYGROUPNCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPNCATEGORY,
					args);
			}

			if ((distributionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCONTENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						distributionModelImpl.getOriginalGroupId(),
						distributionModelImpl.getOriginalContentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCONTENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCONTENTID,
					args);

				args = new Object[] {
						distributionModelImpl.getGroupId(),
						distributionModelImpl.getContentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCONTENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCONTENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionImpl.class, distribution.getPrimaryKey(), distribution);

		return distribution;
	}

	protected Distribution toUnwrappedModel(Distribution distribution) {
		if (distribution instanceof DistributionImpl) {
			return distribution;
		}

		DistributionImpl distributionImpl = new DistributionImpl();

		distributionImpl.setNew(distribution.isNew());
		distributionImpl.setPrimaryKey(distribution.getPrimaryKey());

		distributionImpl.setDistributionId(distribution.getDistributionId());
		distributionImpl.setGroupId(distribution.getGroupId());
		distributionImpl.setCompanyId(distribution.getCompanyId());
		distributionImpl.setUserId(distribution.getUserId());
		distributionImpl.setUserName(distribution.getUserName());
		distributionImpl.setCreateDate(distribution.getCreateDate());
		distributionImpl.setModifiedDate(distribution.getModifiedDate());
		distributionImpl.setVersion(distribution.getVersion());
		distributionImpl.setContentId(distribution.getContentId());
		distributionImpl.setCategoryId(distribution.getCategoryId());
		distributionImpl.setDistributedDate(distribution.getDistributedDate());
		distributionImpl.setAllowDiscussion(distribution.isAllowDiscussion());
		distributionImpl.setTitle(distribution.getTitle());

		return distributionImpl;
	}

	/**
	 * Returns the distribution with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the distribution
	 * @return the distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByPrimaryKey(primaryKey);

		if (distribution == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDistributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return distribution;
	}

	/**
	 * Returns the distribution with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchDistributionException} if it could not be found.
	 *
	 * @param distributionId the primary key of the distribution
	 * @return the distribution
	 * @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByPrimaryKey(long distributionId)
		throws NoSuchDistributionException, SystemException {
		return findByPrimaryKey((Serializable)distributionId);
	}

	/**
	 * Returns the distribution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the distribution
	 * @return the distribution, or <code>null</code> if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Distribution distribution = (Distribution)EntityCacheUtil.getResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
				DistributionImpl.class, primaryKey);

		if (distribution == _nullDistribution) {
			return null;
		}

		if (distribution == null) {
			Session session = null;

			try {
				session = openSession();

				distribution = (Distribution)session.get(DistributionImpl.class,
						primaryKey);

				if (distribution != null) {
					cacheResult(distribution);
				}
				else {
					EntityCacheUtil.putResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
						DistributionImpl.class, primaryKey, _nullDistribution);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
					DistributionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return distribution;
	}

	/**
	 * Returns the distribution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param distributionId the primary key of the distribution
	 * @return the distribution, or <code>null</code> if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByPrimaryKey(long distributionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)distributionId);
	}

	/**
	 * Returns all the distributions.
	 *
	 * @return the distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the distributions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findAll(int start, int end,
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

		List<Distribution> list = (List<Distribution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISTRIBUTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISTRIBUTION;

				if (pagination) {
					sql = sql.concat(DistributionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Distribution>(list);
				}
				else {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the distributions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Distribution distribution : findAll()) {
			remove(distribution);
		}
	}

	/**
	 * Returns the number of distributions.
	 *
	 * @return the number of distributions
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

				Query q = session.createQuery(_SQL_COUNT_DISTRIBUTION);

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
	 * Initializes the distribution persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.Distribution")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Distribution>> listenersList = new ArrayList<ModelListener<Distribution>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Distribution>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DistributionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DISTRIBUTION = "SELECT distribution FROM Distribution distribution";
	private static final String _SQL_SELECT_DISTRIBUTION_WHERE = "SELECT distribution FROM Distribution distribution WHERE ";
	private static final String _SQL_COUNT_DISTRIBUTION = "SELECT COUNT(distribution) FROM Distribution distribution";
	private static final String _SQL_COUNT_DISTRIBUTION_WHERE = "SELECT COUNT(distribution) FROM Distribution distribution WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "distribution.distributionId";
	private static final String _FILTER_SQL_SELECT_DISTRIBUTION_WHERE = "SELECT DISTINCT {distribution.*} FROM vcms_Distribution distribution WHERE ";
	private static final String _FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {vcms_Distribution.*} FROM (SELECT DISTINCT distribution.distributionId FROM vcms_Distribution distribution WHERE ";
	private static final String _FILTER_SQL_SELECT_DISTRIBUTION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN vcms_Distribution ON TEMP_TABLE.distributionId = vcms_Distribution.distributionId";
	private static final String _FILTER_SQL_COUNT_DISTRIBUTION_WHERE = "SELECT COUNT(DISTINCT distribution.distributionId) AS COUNT_VALUE FROM vcms_Distribution distribution WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "distribution";
	private static final String _FILTER_ENTITY_TABLE = "vcms_Distribution";
	private static final String _ORDER_BY_ENTITY_ALIAS = "distribution.";
	private static final String _ORDER_BY_ENTITY_TABLE = "vcms_Distribution.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Distribution exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Distribution exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DistributionPersistenceImpl.class);
	private static Distribution _nullDistribution = new DistributionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Distribution> toCacheModel() {
				return _nullDistributionCacheModel;
			}
		};

	private static CacheModel<Distribution> _nullDistributionCacheModel = new CacheModel<Distribution>() {
			@Override
			public Distribution toEntityModel() {
				return _nullDistribution;
			}
		};
}