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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import com.viettel.portal.vcms.NoSuchContentTypeCostException;
import com.viettel.portal.vcms.model.ContentTypeCost;
import com.viettel.portal.vcms.model.impl.ContentTypeCostImpl;
import com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the content type cost service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see ContentTypeCostPersistence
 * @see ContentTypeCostUtil
 * @generated
 */
public class ContentTypeCostPersistenceImpl extends BasePersistenceImpl<ContentTypeCost>
	implements ContentTypeCostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContentTypeCostUtil} to access the content type cost persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContentTypeCostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED,
			ContentTypeCostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED,
			ContentTypeCostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED,
			ContentTypeCostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED,
			ContentTypeCostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ContentTypeCostModelImpl.GROUPID_COLUMN_BITMASK |
			ContentTypeCostModelImpl.TODATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the content type costs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content type costs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content type costs
	 * @param end the upper bound of the range of content type costs (not inclusive)
	 * @return the range of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content type costs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content type costs
	 * @param end the upper bound of the range of content type costs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ContentTypeCost> list = (List<ContentTypeCost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentTypeCost contentTypeCost : list) {
				if ((groupId != contentTypeCost.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTENTTYPECOST_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentTypeCostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ContentTypeCost>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentTypeCost>(list);
				}
				else {
					list = (List<ContentTypeCost>)QueryUtil.list(q,
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
	 * Returns the first content type cost in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = fetchByGroupId_First(groupId,
				orderByComparator);

		if (contentTypeCost != null) {
			return contentTypeCost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeCostException(msg.toString());
	}

	/**
	 * Returns the first content type cost in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type cost, or <code>null</code> if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContentTypeCost> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content type cost in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (contentTypeCost != null) {
			return contentTypeCost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeCostException(msg.toString());
	}

	/**
	 * Returns the last content type cost in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type cost, or <code>null</code> if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ContentTypeCost> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content type costs before and after the current content type cost in the ordered set where groupId = &#63;.
	 *
	 * @param costId the primary key of the current content type cost
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost[] findByGroupId_PrevAndNext(long costId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = findByPrimaryKey(costId);

		Session session = null;

		try {
			session = openSession();

			ContentTypeCost[] array = new ContentTypeCostImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, contentTypeCost,
					groupId, orderByComparator, true);

			array[1] = contentTypeCost;

			array[2] = getByGroupId_PrevAndNext(session, contentTypeCost,
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

	protected ContentTypeCost getByGroupId_PrevAndNext(Session session,
		ContentTypeCost contentTypeCost, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTTYPECOST_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ContentTypeCostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentTypeCost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentTypeCost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content type costs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ContentTypeCost contentTypeCost : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentTypeCost);
		}
	}

	/**
	 * Returns the number of content type costs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENTTYPECOST_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "contentTypeCost.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPTYPE =
		new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED,
			ContentTypeCostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPTYPE =
		new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED,
			ContentTypeCostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupType",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentTypeCostModelImpl.GROUPID_COLUMN_BITMASK |
			ContentTypeCostModelImpl.CONTENTTYPEID_COLUMN_BITMASK |
			ContentTypeCostModelImpl.TODATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPTYPE = new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupType",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the content type costs where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @return the matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByGroupType(long groupId,
		long contentTypeID) throws SystemException {
		return findByGroupType(groupId, contentTypeID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content type costs where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @param start the lower bound of the range of content type costs
	 * @param end the upper bound of the range of content type costs (not inclusive)
	 * @return the range of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByGroupType(long groupId,
		long contentTypeID, int start, int end) throws SystemException {
		return findByGroupType(groupId, contentTypeID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content type costs where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @param start the lower bound of the range of content type costs
	 * @param end the upper bound of the range of content type costs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByGroupType(long groupId,
		long contentTypeID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPTYPE;
			finderArgs = new Object[] { groupId, contentTypeID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPTYPE;
			finderArgs = new Object[] {
					groupId, contentTypeID,
					
					start, end, orderByComparator
				};
		}

		List<ContentTypeCost> list = (List<ContentTypeCost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentTypeCost contentTypeCost : list) {
				if ((groupId != contentTypeCost.getGroupId()) ||
						(contentTypeID != contentTypeCost.getContentTypeID())) {
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

			query.append(_SQL_SELECT_CONTENTTYPECOST_WHERE);

			query.append(_FINDER_COLUMN_GROUPTYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPTYPE_CONTENTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentTypeCostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentTypeID);

				if (!pagination) {
					list = (List<ContentTypeCost>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentTypeCost>(list);
				}
				else {
					list = (List<ContentTypeCost>)QueryUtil.list(q,
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
	 * Returns the first content type cost in the ordered set where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost findByGroupType_First(long groupId,
		long contentTypeID, OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = fetchByGroupType_First(groupId,
				contentTypeID, orderByComparator);

		if (contentTypeCost != null) {
			return contentTypeCost;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentTypeID=");
		msg.append(contentTypeID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeCostException(msg.toString());
	}

	/**
	 * Returns the first content type cost in the ordered set where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type cost, or <code>null</code> if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost fetchByGroupType_First(long groupId,
		long contentTypeID, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContentTypeCost> list = findByGroupType(groupId, contentTypeID, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content type cost in the ordered set where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost findByGroupType_Last(long groupId,
		long contentTypeID, OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = fetchByGroupType_Last(groupId,
				contentTypeID, orderByComparator);

		if (contentTypeCost != null) {
			return contentTypeCost;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentTypeID=");
		msg.append(contentTypeID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeCostException(msg.toString());
	}

	/**
	 * Returns the last content type cost in the ordered set where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type cost, or <code>null</code> if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost fetchByGroupType_Last(long groupId,
		long contentTypeID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupType(groupId, contentTypeID);

		if (count == 0) {
			return null;
		}

		List<ContentTypeCost> list = findByGroupType(groupId, contentTypeID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content type costs before and after the current content type cost in the ordered set where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * @param costId the primary key of the current content type cost
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost[] findByGroupType_PrevAndNext(long costId,
		long groupId, long contentTypeID, OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = findByPrimaryKey(costId);

		Session session = null;

		try {
			session = openSession();

			ContentTypeCost[] array = new ContentTypeCostImpl[3];

			array[0] = getByGroupType_PrevAndNext(session, contentTypeCost,
					groupId, contentTypeID, orderByComparator, true);

			array[1] = contentTypeCost;

			array[2] = getByGroupType_PrevAndNext(session, contentTypeCost,
					groupId, contentTypeID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContentTypeCost getByGroupType_PrevAndNext(Session session,
		ContentTypeCost contentTypeCost, long groupId, long contentTypeID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTTYPECOST_WHERE);

		query.append(_FINDER_COLUMN_GROUPTYPE_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPTYPE_CONTENTTYPEID_2);

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
			query.append(ContentTypeCostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contentTypeID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentTypeCost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentTypeCost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content type costs where groupId = &#63; and contentTypeID = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupType(long groupId, long contentTypeID)
		throws SystemException {
		for (ContentTypeCost contentTypeCost : findByGroupType(groupId,
				contentTypeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentTypeCost);
		}
	}

	/**
	 * Returns the number of content type costs where groupId = &#63; and contentTypeID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentTypeID the content type i d
	 * @return the number of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupType(long groupId, long contentTypeID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPTYPE;

		Object[] finderArgs = new Object[] { groupId, contentTypeID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENTTYPECOST_WHERE);

			query.append(_FINDER_COLUMN_GROUPTYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPTYPE_CONTENTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentTypeID);

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

	private static final String _FINDER_COLUMN_GROUPTYPE_GROUPID_2 = "contentTypeCost.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPTYPE_CONTENTTYPEID_2 = "contentTypeCost.contentTypeID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COSTBYDATE =
		new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED,
			ContentTypeCostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCostByDate",
			new String[] {
				Date.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_COSTBYDATE =
		new FinderPath(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCostByDate",
			new String[] { Date.class.getName(), Date.class.getName() });

	/**
	 * Returns all the content type costs where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByCostByDate(Date fromDate, Date toDate)
		throws SystemException {
		return findByCostByDate(fromDate, toDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content type costs where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param start the lower bound of the range of content type costs
	 * @param end the upper bound of the range of content type costs (not inclusive)
	 * @return the range of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByCostByDate(Date fromDate, Date toDate,
		int start, int end) throws SystemException {
		return findByCostByDate(fromDate, toDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content type costs where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param start the lower bound of the range of content type costs
	 * @param end the upper bound of the range of content type costs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findByCostByDate(Date fromDate, Date toDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COSTBYDATE;
		finderArgs = new Object[] {
				fromDate, toDate,
				
				start, end, orderByComparator
			};

		List<ContentTypeCost> list = (List<ContentTypeCost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentTypeCost contentTypeCost : list) {
				if ((fromDate.getTime() >= contentTypeCost.getFromDate()
															  .getTime()) ||
						(toDate.getTime() <= contentTypeCost.getToDate()
																.getTime())) {
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

			query.append(_SQL_SELECT_CONTENTTYPECOST_WHERE);

			boolean bindFromDate = false;

			if (fromDate == null) {
				query.append(_FINDER_COLUMN_COSTBYDATE_FROMDATE_1);
			}
			else {
				bindFromDate = true;

				query.append(_FINDER_COLUMN_COSTBYDATE_FROMDATE_2);
			}

			boolean bindToDate = false;

			if (toDate == null) {
				query.append(_FINDER_COLUMN_COSTBYDATE_TODATE_1);
			}
			else {
				bindToDate = true;

				query.append(_FINDER_COLUMN_COSTBYDATE_TODATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentTypeCostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFromDate) {
					qPos.add(CalendarUtil.getTimestamp(fromDate));
				}

				if (bindToDate) {
					qPos.add(CalendarUtil.getTimestamp(toDate));
				}

				if (!pagination) {
					list = (List<ContentTypeCost>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentTypeCost>(list);
				}
				else {
					list = (List<ContentTypeCost>)QueryUtil.list(q,
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
	 * Returns the first content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost findByCostByDate_First(Date fromDate, Date toDate,
		OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = fetchByCostByDate_First(fromDate,
				toDate, orderByComparator);

		if (contentTypeCost != null) {
			return contentTypeCost;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fromDate=");
		msg.append(fromDate);

		msg.append(", toDate=");
		msg.append(toDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeCostException(msg.toString());
	}

	/**
	 * Returns the first content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type cost, or <code>null</code> if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost fetchByCostByDate_First(Date fromDate, Date toDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContentTypeCost> list = findByCostByDate(fromDate, toDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost findByCostByDate_Last(Date fromDate, Date toDate,
		OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = fetchByCostByDate_Last(fromDate,
				toDate, orderByComparator);

		if (contentTypeCost != null) {
			return contentTypeCost;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fromDate=");
		msg.append(fromDate);

		msg.append(", toDate=");
		msg.append(toDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeCostException(msg.toString());
	}

	/**
	 * Returns the last content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type cost, or <code>null</code> if a matching content type cost could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost fetchByCostByDate_Last(Date fromDate, Date toDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCostByDate(fromDate, toDate);

		if (count == 0) {
			return null;
		}

		List<ContentTypeCost> list = findByCostByDate(fromDate, toDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content type costs before and after the current content type cost in the ordered set where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * @param costId the primary key of the current content type cost
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost[] findByCostByDate_PrevAndNext(long costId,
		Date fromDate, Date toDate, OrderByComparator orderByComparator)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = findByPrimaryKey(costId);

		Session session = null;

		try {
			session = openSession();

			ContentTypeCost[] array = new ContentTypeCostImpl[3];

			array[0] = getByCostByDate_PrevAndNext(session, contentTypeCost,
					fromDate, toDate, orderByComparator, true);

			array[1] = contentTypeCost;

			array[2] = getByCostByDate_PrevAndNext(session, contentTypeCost,
					fromDate, toDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContentTypeCost getByCostByDate_PrevAndNext(Session session,
		ContentTypeCost contentTypeCost, Date fromDate, Date toDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTTYPECOST_WHERE);

		boolean bindFromDate = false;

		if (fromDate == null) {
			query.append(_FINDER_COLUMN_COSTBYDATE_FROMDATE_1);
		}
		else {
			bindFromDate = true;

			query.append(_FINDER_COLUMN_COSTBYDATE_FROMDATE_2);
		}

		boolean bindToDate = false;

		if (toDate == null) {
			query.append(_FINDER_COLUMN_COSTBYDATE_TODATE_1);
		}
		else {
			bindToDate = true;

			query.append(_FINDER_COLUMN_COSTBYDATE_TODATE_2);
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
			query.append(ContentTypeCostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFromDate) {
			qPos.add(CalendarUtil.getTimestamp(fromDate));
		}

		if (bindToDate) {
			qPos.add(CalendarUtil.getTimestamp(toDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentTypeCost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentTypeCost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content type costs where fromDate &gt; &#63; and toDate &lt; &#63; from the database.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCostByDate(Date fromDate, Date toDate)
		throws SystemException {
		for (ContentTypeCost contentTypeCost : findByCostByDate(fromDate,
				toDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentTypeCost);
		}
	}

	/**
	 * Returns the number of content type costs where fromDate &gt; &#63; and toDate &lt; &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the number of matching content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCostByDate(Date fromDate, Date toDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_COSTBYDATE;

		Object[] finderArgs = new Object[] { fromDate, toDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENTTYPECOST_WHERE);

			boolean bindFromDate = false;

			if (fromDate == null) {
				query.append(_FINDER_COLUMN_COSTBYDATE_FROMDATE_1);
			}
			else {
				bindFromDate = true;

				query.append(_FINDER_COLUMN_COSTBYDATE_FROMDATE_2);
			}

			boolean bindToDate = false;

			if (toDate == null) {
				query.append(_FINDER_COLUMN_COSTBYDATE_TODATE_1);
			}
			else {
				bindToDate = true;

				query.append(_FINDER_COLUMN_COSTBYDATE_TODATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFromDate) {
					qPos.add(CalendarUtil.getTimestamp(fromDate));
				}

				if (bindToDate) {
					qPos.add(CalendarUtil.getTimestamp(toDate));
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

	private static final String _FINDER_COLUMN_COSTBYDATE_FROMDATE_1 = "contentTypeCost.fromDate > NULL AND ";
	private static final String _FINDER_COLUMN_COSTBYDATE_FROMDATE_2 = "contentTypeCost.fromDate > ? AND ";
	private static final String _FINDER_COLUMN_COSTBYDATE_TODATE_1 = "contentTypeCost.toDate < NULL";
	private static final String _FINDER_COLUMN_COSTBYDATE_TODATE_2 = "contentTypeCost.toDate < ?";

	public ContentTypeCostPersistenceImpl() {
		setModelClass(ContentTypeCost.class);
	}

	/**
	 * Caches the content type cost in the entity cache if it is enabled.
	 *
	 * @param contentTypeCost the content type cost
	 */
	@Override
	public void cacheResult(ContentTypeCost contentTypeCost) {
		EntityCacheUtil.putResult(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostImpl.class, contentTypeCost.getPrimaryKey(),
			contentTypeCost);

		contentTypeCost.resetOriginalValues();
	}

	/**
	 * Caches the content type costs in the entity cache if it is enabled.
	 *
	 * @param contentTypeCosts the content type costs
	 */
	@Override
	public void cacheResult(List<ContentTypeCost> contentTypeCosts) {
		for (ContentTypeCost contentTypeCost : contentTypeCosts) {
			if (EntityCacheUtil.getResult(
						ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
						ContentTypeCostImpl.class,
						contentTypeCost.getPrimaryKey()) == null) {
				cacheResult(contentTypeCost);
			}
			else {
				contentTypeCost.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all content type costs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContentTypeCostImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContentTypeCostImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the content type cost.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContentTypeCost contentTypeCost) {
		EntityCacheUtil.removeResult(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostImpl.class, contentTypeCost.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContentTypeCost> contentTypeCosts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContentTypeCost contentTypeCost : contentTypeCosts) {
			EntityCacheUtil.removeResult(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
				ContentTypeCostImpl.class, contentTypeCost.getPrimaryKey());
		}
	}

	/**
	 * Creates a new content type cost with the primary key. Does not add the content type cost to the database.
	 *
	 * @param costId the primary key for the new content type cost
	 * @return the new content type cost
	 */
	@Override
	public ContentTypeCost create(long costId) {
		ContentTypeCost contentTypeCost = new ContentTypeCostImpl();

		contentTypeCost.setNew(true);
		contentTypeCost.setPrimaryKey(costId);

		return contentTypeCost;
	}

	/**
	 * Removes the content type cost with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param costId the primary key of the content type cost
	 * @return the content type cost that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost remove(long costId)
		throws NoSuchContentTypeCostException, SystemException {
		return remove((Serializable)costId);
	}

	/**
	 * Removes the content type cost with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content type cost
	 * @return the content type cost that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost remove(Serializable primaryKey)
		throws NoSuchContentTypeCostException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContentTypeCost contentTypeCost = (ContentTypeCost)session.get(ContentTypeCostImpl.class,
					primaryKey);

			if (contentTypeCost == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentTypeCostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contentTypeCost);
		}
		catch (NoSuchContentTypeCostException nsee) {
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
	protected ContentTypeCost removeImpl(ContentTypeCost contentTypeCost)
		throws SystemException {
		contentTypeCost = toUnwrappedModel(contentTypeCost);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contentTypeCost)) {
				contentTypeCost = (ContentTypeCost)session.get(ContentTypeCostImpl.class,
						contentTypeCost.getPrimaryKeyObj());
			}

			if (contentTypeCost != null) {
				session.delete(contentTypeCost);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contentTypeCost != null) {
			clearCache(contentTypeCost);
		}

		return contentTypeCost;
	}

	@Override
	public ContentTypeCost updateImpl(
		com.viettel.portal.vcms.model.ContentTypeCost contentTypeCost)
		throws SystemException {
		contentTypeCost = toUnwrappedModel(contentTypeCost);

		boolean isNew = contentTypeCost.isNew();

		ContentTypeCostModelImpl contentTypeCostModelImpl = (ContentTypeCostModelImpl)contentTypeCost;

		Session session = null;

		try {
			session = openSession();

			if (contentTypeCost.isNew()) {
				session.save(contentTypeCost);

				contentTypeCost.setNew(false);
			}
			else {
				session.merge(contentTypeCost);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContentTypeCostModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contentTypeCostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentTypeCostModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { contentTypeCostModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((contentTypeCostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentTypeCostModelImpl.getOriginalGroupId(),
						contentTypeCostModelImpl.getOriginalContentTypeID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPTYPE,
					args);

				args = new Object[] {
						contentTypeCostModelImpl.getGroupId(),
						contentTypeCostModelImpl.getContentTypeID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeCostImpl.class, contentTypeCost.getPrimaryKey(),
			contentTypeCost);

		return contentTypeCost;
	}

	protected ContentTypeCost toUnwrappedModel(ContentTypeCost contentTypeCost) {
		if (contentTypeCost instanceof ContentTypeCostImpl) {
			return contentTypeCost;
		}

		ContentTypeCostImpl contentTypeCostImpl = new ContentTypeCostImpl();

		contentTypeCostImpl.setNew(contentTypeCost.isNew());
		contentTypeCostImpl.setPrimaryKey(contentTypeCost.getPrimaryKey());

		contentTypeCostImpl.setCostId(contentTypeCost.getCostId());
		contentTypeCostImpl.setGroupId(contentTypeCost.getGroupId());
		contentTypeCostImpl.setContentTypeID(contentTypeCost.getContentTypeID());
		contentTypeCostImpl.setFromDate(contentTypeCost.getFromDate());
		contentTypeCostImpl.setToDate(contentTypeCost.getToDate());
		contentTypeCostImpl.setCost(contentTypeCost.getCost());

		return contentTypeCostImpl;
	}

	/**
	 * Returns the content type cost with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the content type cost
	 * @return the content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContentTypeCostException, SystemException {
		ContentTypeCost contentTypeCost = fetchByPrimaryKey(primaryKey);

		if (contentTypeCost == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContentTypeCostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contentTypeCost;
	}

	/**
	 * Returns the content type cost with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentTypeCostException} if it could not be found.
	 *
	 * @param costId the primary key of the content type cost
	 * @return the content type cost
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost findByPrimaryKey(long costId)
		throws NoSuchContentTypeCostException, SystemException {
		return findByPrimaryKey((Serializable)costId);
	}

	/**
	 * Returns the content type cost with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the content type cost
	 * @return the content type cost, or <code>null</code> if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContentTypeCost contentTypeCost = (ContentTypeCost)EntityCacheUtil.getResult(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
				ContentTypeCostImpl.class, primaryKey);

		if (contentTypeCost == _nullContentTypeCost) {
			return null;
		}

		if (contentTypeCost == null) {
			Session session = null;

			try {
				session = openSession();

				contentTypeCost = (ContentTypeCost)session.get(ContentTypeCostImpl.class,
						primaryKey);

				if (contentTypeCost != null) {
					cacheResult(contentTypeCost);
				}
				else {
					EntityCacheUtil.putResult(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
						ContentTypeCostImpl.class, primaryKey,
						_nullContentTypeCost);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContentTypeCostModelImpl.ENTITY_CACHE_ENABLED,
					ContentTypeCostImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contentTypeCost;
	}

	/**
	 * Returns the content type cost with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param costId the primary key of the content type cost
	 * @return the content type cost, or <code>null</code> if a content type cost with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentTypeCost fetchByPrimaryKey(long costId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)costId);
	}

	/**
	 * Returns all the content type costs.
	 *
	 * @return the content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content type costs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of content type costs
	 * @param end the upper bound of the range of content type costs (not inclusive)
	 * @return the range of content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the content type costs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of content type costs
	 * @param end the upper bound of the range of content type costs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of content type costs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentTypeCost> findAll(int start, int end,
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

		List<ContentTypeCost> list = (List<ContentTypeCost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTENTTYPECOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTENTTYPECOST;

				if (pagination) {
					sql = sql.concat(ContentTypeCostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContentTypeCost>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentTypeCost>(list);
				}
				else {
					list = (List<ContentTypeCost>)QueryUtil.list(q,
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
	 * Removes all the content type costs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContentTypeCost contentTypeCost : findAll()) {
			remove(contentTypeCost);
		}
	}

	/**
	 * Returns the number of content type costs.
	 *
	 * @return the number of content type costs
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

				Query q = session.createQuery(_SQL_COUNT_CONTENTTYPECOST);

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
	 * Initializes the content type cost persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.ContentTypeCost")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContentTypeCost>> listenersList = new ArrayList<ModelListener<ContentTypeCost>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContentTypeCost>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContentTypeCostImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTENTTYPECOST = "SELECT contentTypeCost FROM ContentTypeCost contentTypeCost";
	private static final String _SQL_SELECT_CONTENTTYPECOST_WHERE = "SELECT contentTypeCost FROM ContentTypeCost contentTypeCost WHERE ";
	private static final String _SQL_COUNT_CONTENTTYPECOST = "SELECT COUNT(contentTypeCost) FROM ContentTypeCost contentTypeCost";
	private static final String _SQL_COUNT_CONTENTTYPECOST_WHERE = "SELECT COUNT(contentTypeCost) FROM ContentTypeCost contentTypeCost WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contentTypeCost.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContentTypeCost exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContentTypeCost exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContentTypeCostPersistenceImpl.class);
	private static ContentTypeCost _nullContentTypeCost = new ContentTypeCostImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContentTypeCost> toCacheModel() {
				return _nullContentTypeCostCacheModel;
			}
		};

	private static CacheModel<ContentTypeCost> _nullContentTypeCostCacheModel = new CacheModel<ContentTypeCost>() {
			@Override
			public ContentTypeCost toEntityModel() {
				return _nullContentTypeCost;
			}
		};
}