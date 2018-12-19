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

import com.viettel.portal.vcms.NoSuchContentProfitException;
import com.viettel.portal.vcms.model.ContentProfit;
import com.viettel.portal.vcms.model.impl.ContentProfitImpl;
import com.viettel.portal.vcms.model.impl.ContentProfitModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the content profit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see ContentProfitPersistence
 * @see ContentProfitUtil
 * @generated
 */
public class ContentProfitPersistenceImpl extends BasePersistenceImpl<ContentProfit>
	implements ContentProfitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContentProfitUtil} to access the content profit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContentProfitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitModelImpl.FINDER_CACHE_ENABLED,
			ContentProfitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitModelImpl.FINDER_CACHE_ENABLED,
			ContentProfitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitModelImpl.FINDER_CACHE_ENABLED,
			ContentProfitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitModelImpl.FINDER_CACHE_ENABLED,
			ContentProfitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			ContentProfitModelImpl.GROUPID_COLUMN_BITMASK |
			ContentProfitModelImpl.DISTRIBUTEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the content profits where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentProfit> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content profits where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content profits
	 * @param end the upper bound of the range of content profits (not inclusive)
	 * @return the range of matching content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentProfit> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content profits where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content profits
	 * @param end the upper bound of the range of content profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentProfit> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ContentProfit> list = (List<ContentProfit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentProfit contentProfit : list) {
				if ((groupId != contentProfit.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTENTPROFIT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentProfitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ContentProfit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentProfit>(list);
				}
				else {
					list = (List<ContentProfit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content profit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content profit
	 * @throws com.viettel.portal.vcms.NoSuchContentProfitException if a matching content profit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContentProfitException, SystemException {
		ContentProfit contentProfit = fetchByGroupId_First(groupId,
				orderByComparator);

		if (contentProfit != null) {
			return contentProfit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentProfitException(msg.toString());
	}

	/**
	 * Returns the first content profit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content profit, or <code>null</code> if a matching content profit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContentProfit> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content profit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content profit
	 * @throws com.viettel.portal.vcms.NoSuchContentProfitException if a matching content profit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContentProfitException, SystemException {
		ContentProfit contentProfit = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (contentProfit != null) {
			return contentProfit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentProfitException(msg.toString());
	}

	/**
	 * Returns the last content profit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content profit, or <code>null</code> if a matching content profit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ContentProfit> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content profits before and after the current content profit in the ordered set where groupId = &#63;.
	 *
	 * @param contentId the primary key of the current content profit
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content profit
	 * @throws com.viettel.portal.vcms.NoSuchContentProfitException if a content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit[] findByGroupId_PrevAndNext(long contentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContentProfitException, SystemException {
		ContentProfit contentProfit = findByPrimaryKey(contentId);

		Session session = null;

		try {
			session = openSession();

			ContentProfit[] array = new ContentProfitImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, contentProfit,
					groupId, orderByComparator, true);

			array[1] = contentProfit;

			array[2] = getByGroupId_PrevAndNext(session, contentProfit,
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

	protected ContentProfit getByGroupId_PrevAndNext(Session session,
		ContentProfit contentProfit, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTPROFIT_WHERE);

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
			query.append(ContentProfitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentProfit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentProfit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content profits where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ContentProfit contentProfit : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentProfit);
		}
	}

	/**
	 * Returns the number of content profits where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching content profits
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

			query.append(_SQL_COUNT_CONTENTPROFIT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "contentProfit.groupId = ?";

	public ContentProfitPersistenceImpl() {
		setModelClass(ContentProfit.class);
	}

	/**
	 * Caches the content profit in the entity cache if it is enabled.
	 *
	 * @param contentProfit the content profit
	 */
	@Override
	public void cacheResult(ContentProfit contentProfit) {
		EntityCacheUtil.putResult(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitImpl.class, contentProfit.getPrimaryKey(),
			contentProfit);

		contentProfit.resetOriginalValues();
	}

	/**
	 * Caches the content profits in the entity cache if it is enabled.
	 *
	 * @param contentProfits the content profits
	 */
	@Override
	public void cacheResult(List<ContentProfit> contentProfits) {
		for (ContentProfit contentProfit : contentProfits) {
			if (EntityCacheUtil.getResult(
						ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
						ContentProfitImpl.class, contentProfit.getPrimaryKey()) == null) {
				cacheResult(contentProfit);
			}
			else {
				contentProfit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all content profits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContentProfitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContentProfitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the content profit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContentProfit contentProfit) {
		EntityCacheUtil.removeResult(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitImpl.class, contentProfit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContentProfit> contentProfits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContentProfit contentProfit : contentProfits) {
			EntityCacheUtil.removeResult(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
				ContentProfitImpl.class, contentProfit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new content profit with the primary key. Does not add the content profit to the database.
	 *
	 * @param contentId the primary key for the new content profit
	 * @return the new content profit
	 */
	@Override
	public ContentProfit create(long contentId) {
		ContentProfit contentProfit = new ContentProfitImpl();

		contentProfit.setNew(true);
		contentProfit.setPrimaryKey(contentId);

		return contentProfit;
	}

	/**
	 * Removes the content profit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentId the primary key of the content profit
	 * @return the content profit that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentProfitException if a content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit remove(long contentId)
		throws NoSuchContentProfitException, SystemException {
		return remove((Serializable)contentId);
	}

	/**
	 * Removes the content profit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content profit
	 * @return the content profit that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentProfitException if a content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit remove(Serializable primaryKey)
		throws NoSuchContentProfitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContentProfit contentProfit = (ContentProfit)session.get(ContentProfitImpl.class,
					primaryKey);

			if (contentProfit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentProfitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contentProfit);
		}
		catch (NoSuchContentProfitException nsee) {
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
	protected ContentProfit removeImpl(ContentProfit contentProfit)
		throws SystemException {
		contentProfit = toUnwrappedModel(contentProfit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contentProfit)) {
				contentProfit = (ContentProfit)session.get(ContentProfitImpl.class,
						contentProfit.getPrimaryKeyObj());
			}

			if (contentProfit != null) {
				session.delete(contentProfit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contentProfit != null) {
			clearCache(contentProfit);
		}

		return contentProfit;
	}

	@Override
	public ContentProfit updateImpl(
		com.viettel.portal.vcms.model.ContentProfit contentProfit)
		throws SystemException {
		contentProfit = toUnwrappedModel(contentProfit);

		boolean isNew = contentProfit.isNew();

		ContentProfitModelImpl contentProfitModelImpl = (ContentProfitModelImpl)contentProfit;

		Session session = null;

		try {
			session = openSession();

			if (contentProfit.isNew()) {
				session.save(contentProfit);

				contentProfit.setNew(false);
			}
			else {
				session.merge(contentProfit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContentProfitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contentProfitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentProfitModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { contentProfitModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			ContentProfitImpl.class, contentProfit.getPrimaryKey(),
			contentProfit);

		return contentProfit;
	}

	protected ContentProfit toUnwrappedModel(ContentProfit contentProfit) {
		if (contentProfit instanceof ContentProfitImpl) {
			return contentProfit;
		}

		ContentProfitImpl contentProfitImpl = new ContentProfitImpl();

		contentProfitImpl.setNew(contentProfit.isNew());
		contentProfitImpl.setPrimaryKey(contentProfit.getPrimaryKey());

		contentProfitImpl.setContentId(contentProfit.getContentId());
		contentProfitImpl.setGroupId(contentProfit.getGroupId());
		contentProfitImpl.setCompanyId(contentProfit.getCompanyId());
		contentProfitImpl.setUserId(contentProfit.getUserId());
		contentProfitImpl.setUserName(contentProfit.getUserName());
		contentProfitImpl.setCreateDate(contentProfit.getCreateDate());
		contentProfitImpl.setModifiedDate(contentProfit.getModifiedDate());
		contentProfitImpl.setDistributedDate(contentProfit.getDistributedDate());
		contentProfitImpl.setContentTypeID(contentProfit.getContentTypeID());
		contentProfitImpl.setHeadline(contentProfit.getHeadline());
		contentProfitImpl.setCost(contentProfit.getCost());
		contentProfitImpl.setStatus(contentProfit.getStatus());

		return contentProfitImpl;
	}

	/**
	 * Returns the content profit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the content profit
	 * @return the content profit
	 * @throws com.viettel.portal.vcms.NoSuchContentProfitException if a content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContentProfitException, SystemException {
		ContentProfit contentProfit = fetchByPrimaryKey(primaryKey);

		if (contentProfit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContentProfitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contentProfit;
	}

	/**
	 * Returns the content profit with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentProfitException} if it could not be found.
	 *
	 * @param contentId the primary key of the content profit
	 * @return the content profit
	 * @throws com.viettel.portal.vcms.NoSuchContentProfitException if a content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit findByPrimaryKey(long contentId)
		throws NoSuchContentProfitException, SystemException {
		return findByPrimaryKey((Serializable)contentId);
	}

	/**
	 * Returns the content profit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the content profit
	 * @return the content profit, or <code>null</code> if a content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContentProfit contentProfit = (ContentProfit)EntityCacheUtil.getResult(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
				ContentProfitImpl.class, primaryKey);

		if (contentProfit == _nullContentProfit) {
			return null;
		}

		if (contentProfit == null) {
			Session session = null;

			try {
				session = openSession();

				contentProfit = (ContentProfit)session.get(ContentProfitImpl.class,
						primaryKey);

				if (contentProfit != null) {
					cacheResult(contentProfit);
				}
				else {
					EntityCacheUtil.putResult(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
						ContentProfitImpl.class, primaryKey, _nullContentProfit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
					ContentProfitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contentProfit;
	}

	/**
	 * Returns the content profit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contentId the primary key of the content profit
	 * @return the content profit, or <code>null</code> if a content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentProfit fetchByPrimaryKey(long contentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contentId);
	}

	/**
	 * Returns all the content profits.
	 *
	 * @return the content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentProfit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content profits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of content profits
	 * @param end the upper bound of the range of content profits (not inclusive)
	 * @return the range of content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentProfit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the content profits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of content profits
	 * @param end the upper bound of the range of content profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentProfit> findAll(int start, int end,
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

		List<ContentProfit> list = (List<ContentProfit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTENTPROFIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTENTPROFIT;

				if (pagination) {
					sql = sql.concat(ContentProfitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContentProfit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentProfit>(list);
				}
				else {
					list = (List<ContentProfit>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the content profits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContentProfit contentProfit : findAll()) {
			remove(contentProfit);
		}
	}

	/**
	 * Returns the number of content profits.
	 *
	 * @return the number of content profits
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

				Query q = session.createQuery(_SQL_COUNT_CONTENTPROFIT);

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
	 * Initializes the content profit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.ContentProfit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContentProfit>> listenersList = new ArrayList<ModelListener<ContentProfit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContentProfit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContentProfitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTENTPROFIT = "SELECT contentProfit FROM ContentProfit contentProfit";
	private static final String _SQL_SELECT_CONTENTPROFIT_WHERE = "SELECT contentProfit FROM ContentProfit contentProfit WHERE ";
	private static final String _SQL_COUNT_CONTENTPROFIT = "SELECT COUNT(contentProfit) FROM ContentProfit contentProfit";
	private static final String _SQL_COUNT_CONTENTPROFIT_WHERE = "SELECT COUNT(contentProfit) FROM ContentProfit contentProfit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contentProfit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContentProfit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContentProfit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContentProfitPersistenceImpl.class);
	private static ContentProfit _nullContentProfit = new ContentProfitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContentProfit> toCacheModel() {
				return _nullContentProfitCacheModel;
			}
		};

	private static CacheModel<ContentProfit> _nullContentProfitCacheModel = new CacheModel<ContentProfit>() {
			@Override
			public ContentProfit toEntityModel() {
				return _nullContentProfit;
			}
		};
}