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

package com.viettel.portal.videolibrary.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.videolibrary.NoSuchVLCategoryException;
import com.viettel.portal.videolibrary.model.VLCategory;
import com.viettel.portal.videolibrary.model.impl.VLCategoryImpl;
import com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v l category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLCategoryPersistence
 * @see VLCategoryUtil
 * @generated
 */
public class VLCategoryPersistenceImpl extends BasePersistenceImpl<VLCategory>
	implements VLCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VLCategoryUtil} to access the v l category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VLCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, VLCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, VLCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, VLCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, VLCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VLCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			VLCategoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the v l categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @return the range of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByGroup(long groupId, int start, int end,
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

		List<VLCategory> list = (List<VLCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLCategory vlCategory : list) {
				if ((groupId != vlCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_VLCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VLCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLCategory>(list);
				}
				else {
					list = (List<VLCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = fetchByGroup_First(groupId, orderByComparator);

		if (vlCategory != null) {
			return vlCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLCategoryException(msg.toString());
	}

	/**
	 * Returns the first v l category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l category, or <code>null</code> if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLCategory> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = fetchByGroup_Last(groupId, orderByComparator);

		if (vlCategory != null) {
			return vlCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLCategoryException(msg.toString());
	}

	/**
	 * Returns the last v l category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l category, or <code>null</code> if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<VLCategory> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l categories before and after the current v l category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v l category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory[] findByGroup_PrevAndNext(long categoryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VLCategory[] array = new VLCategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, vlCategory, groupId,
					orderByComparator, true);

			array[1] = vlCategory;

			array[2] = getByGroup_PrevAndNext(session, vlCategory, groupId,
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

	protected VLCategory getByGroup_PrevAndNext(Session session,
		VLCategory vlCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLCATEGORY_WHERE);

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
			query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v l categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the v l categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @return the range of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VLCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VLCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<VLCategory>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v l categories before and after the current v l category in the ordered set of v l categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v l category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory[] filterFindByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		VLCategory vlCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VLCategory[] array = new VLCategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, vlCategory,
					groupId, orderByComparator, true);

			array[1] = vlCategory;

			array[2] = filterGetByGroup_PrevAndNext(session, vlCategory,
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

	protected VLCategory filterGetByGroup_PrevAndNext(Session session,
		VLCategory vlCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VLCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VLCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (VLCategory vlCategory : findByGroup(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vlCategory);
		}
	}

	/**
	 * Returns the number of v l categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v l categories
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

			query.append(_SQL_COUNT_VLCATEGORY_WHERE);

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

	/**
	 * Returns the number of v l categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_VLCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "vlCategory.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, VLCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryName",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, VLCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryName",
			new String[] { String.class.getName(), Long.class.getName() },
			VLCategoryModelImpl.CATEGORYNAME_COLUMN_BITMASK |
			VLCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			VLCategoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAME = new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryName",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v l categories where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @return the matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByCategoryName(String categoryName, long groupId)
		throws SystemException {
		return findByCategoryName(categoryName, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l categories where categoryName = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @return the range of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByCategoryName(String categoryName,
		long groupId, int start, int end) throws SystemException {
		return findByCategoryName(categoryName, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l categories where categoryName = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByCategoryName(String categoryName,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] { categoryName, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] {
					categoryName, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VLCategory> list = (List<VLCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLCategory vlCategory : list) {
				if (!Validator.equals(categoryName, vlCategory.getCategoryName()) ||
						(groupId != vlCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_VLCATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
			}

			query.append(_FINDER_COLUMN_CATEGORYNAME_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoryName) {
					qPos.add(categoryName);
				}

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VLCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLCategory>(list);
				}
				else {
					list = (List<VLCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory findByCategoryName_First(String categoryName,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = fetchByCategoryName_First(categoryName,
				groupId, orderByComparator);

		if (vlCategory != null) {
			return vlCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryName=");
		msg.append(categoryName);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLCategoryException(msg.toString());
	}

	/**
	 * Returns the first v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l category, or <code>null</code> if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory fetchByCategoryName_First(String categoryName,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VLCategory> list = findByCategoryName(categoryName, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory findByCategoryName_Last(String categoryName,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = fetchByCategoryName_Last(categoryName, groupId,
				orderByComparator);

		if (vlCategory != null) {
			return vlCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryName=");
		msg.append(categoryName);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLCategoryException(msg.toString());
	}

	/**
	 * Returns the last v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l category, or <code>null</code> if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory fetchByCategoryName_Last(String categoryName,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryName(categoryName, groupId);

		if (count == 0) {
			return null;
		}

		List<VLCategory> list = findByCategoryName(categoryName, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l categories before and after the current v l category in the ordered set where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v l category
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory[] findByCategoryName_PrevAndNext(long categoryId,
		String categoryName, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VLCategory[] array = new VLCategoryImpl[3];

			array[0] = getByCategoryName_PrevAndNext(session, vlCategory,
					categoryName, groupId, orderByComparator, true);

			array[1] = vlCategory;

			array[2] = getByCategoryName_PrevAndNext(session, vlCategory,
					categoryName, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VLCategory getByCategoryName_PrevAndNext(Session session,
		VLCategory vlCategory, String categoryName, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLCATEGORY_WHERE);

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
		}

		query.append(_FINDER_COLUMN_CATEGORYNAME_GROUPID_2);

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
			query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategoryName) {
			qPos.add(categoryName);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @return the matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByCategoryName(String categoryName,
		long groupId) throws SystemException {
		return filterFindByCategoryName(categoryName, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @return the range of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByCategoryName(String categoryName,
		long groupId, int start, int end) throws SystemException {
		return filterFindByCategoryName(categoryName, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l categories that the user has permissions to view where categoryName = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByCategoryName(String categoryName,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryName(categoryName, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
		}

		query.append(_FINDER_COLUMN_CATEGORYNAME_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VLCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VLCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindCategoryName) {
				qPos.add(categoryName);
			}

			qPos.add(groupId);

			return (List<VLCategory>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v l categories before and after the current v l category in the ordered set of v l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v l category
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory[] filterFindByCategoryName_PrevAndNext(long categoryId,
		String categoryName, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryName_PrevAndNext(categoryId, categoryName,
				groupId, orderByComparator);
		}

		VLCategory vlCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VLCategory[] array = new VLCategoryImpl[3];

			array[0] = filterGetByCategoryName_PrevAndNext(session, vlCategory,
					categoryName, groupId, orderByComparator, true);

			array[1] = vlCategory;

			array[2] = filterGetByCategoryName_PrevAndNext(session, vlCategory,
					categoryName, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VLCategory filterGetByCategoryName_PrevAndNext(Session session,
		VLCategory vlCategory, String categoryName, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
		}

		query.append(_FINDER_COLUMN_CATEGORYNAME_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VLCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VLCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategoryName) {
			qPos.add(categoryName);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l categories where categoryName = &#63; and groupId = &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryName(String categoryName, long groupId)
		throws SystemException {
		for (VLCategory vlCategory : findByCategoryName(categoryName, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlCategory);
		}
	}

	/**
	 * Returns the number of v l categories where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @return the number of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryName(String categoryName, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYNAME;

		Object[] finderArgs = new Object[] { categoryName, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLCATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
			}

			query.append(_FINDER_COLUMN_CATEGORYNAME_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoryName) {
					qPos.add(categoryName);
				}

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

	/**
	 * Returns the number of v l categories that the user has permission to view where categoryName = &#63; and groupId = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @return the number of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCategoryName(String categoryName, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryName(categoryName, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VLCATEGORY_WHERE);

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
		}

		query.append(_FINDER_COLUMN_CATEGORYNAME_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindCategoryName) {
				qPos.add(categoryName);
			}

			qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1 = "vlCategory.categoryName IS NULL AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2 = "vlCategory.categoryName = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3 = "(vlCategory.categoryName IS NULL OR vlCategory.categoryName = '') AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_GROUPID_2 = "vlCategory.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATE =
		new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, VLCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndState",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATE =
		new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, VLCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndState",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			VLCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			VLCategoryModelImpl.INVISIBLE_COLUMN_BITMASK |
			VLCategoryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDSTATE = new FinderPath(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndState",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the v l categories where groupId = &#63; and invisible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @return the matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByGroupAndState(long groupId, boolean invisible)
		throws SystemException {
		return findByGroupAndState(groupId, invisible, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l categories where groupId = &#63; and invisible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @return the range of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByGroupAndState(long groupId,
		boolean invisible, int start, int end) throws SystemException {
		return findByGroupAndState(groupId, invisible, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l categories where groupId = &#63; and invisible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByGroupAndState(long groupId,
		boolean invisible, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATE;
			finderArgs = new Object[] { groupId, invisible };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATE;
			finderArgs = new Object[] {
					groupId, invisible,
					
					start, end, orderByComparator
				};
		}

		List<VLCategory> list = (List<VLCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLCategory vlCategory : list) {
				if ((groupId != vlCategory.getGroupId()) ||
						(invisible != vlCategory.getInvisible())) {
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

			query.append(_SQL_SELECT_VLCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATE_INVISIBLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(invisible);

				if (!pagination) {
					list = (List<VLCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLCategory>(list);
				}
				else {
					list = (List<VLCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory findByGroupAndState_First(long groupId,
		boolean invisible, OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = fetchByGroupAndState_First(groupId, invisible,
				orderByComparator);

		if (vlCategory != null) {
			return vlCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", invisible=");
		msg.append(invisible);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLCategoryException(msg.toString());
	}

	/**
	 * Returns the first v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l category, or <code>null</code> if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory fetchByGroupAndState_First(long groupId,
		boolean invisible, OrderByComparator orderByComparator)
		throws SystemException {
		List<VLCategory> list = findByGroupAndState(groupId, invisible, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory findByGroupAndState_Last(long groupId, boolean invisible,
		OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = fetchByGroupAndState_Last(groupId, invisible,
				orderByComparator);

		if (vlCategory != null) {
			return vlCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", invisible=");
		msg.append(invisible);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLCategoryException(msg.toString());
	}

	/**
	 * Returns the last v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l category, or <code>null</code> if a matching v l category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory fetchByGroupAndState_Last(long groupId,
		boolean invisible, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupAndState(groupId, invisible);

		if (count == 0) {
			return null;
		}

		List<VLCategory> list = findByGroupAndState(groupId, invisible,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l categories before and after the current v l category in the ordered set where groupId = &#63; and invisible = &#63;.
	 *
	 * @param categoryId the primary key of the current v l category
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory[] findByGroupAndState_PrevAndNext(long categoryId,
		long groupId, boolean invisible, OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VLCategory[] array = new VLCategoryImpl[3];

			array[0] = getByGroupAndState_PrevAndNext(session, vlCategory,
					groupId, invisible, orderByComparator, true);

			array[1] = vlCategory;

			array[2] = getByGroupAndState_PrevAndNext(session, vlCategory,
					groupId, invisible, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VLCategory getByGroupAndState_PrevAndNext(Session session,
		VLCategory vlCategory, long groupId, boolean invisible,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDSTATE_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATE_INVISIBLE_2);

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
			query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(invisible);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v l categories that the user has permission to view where groupId = &#63; and invisible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @return the matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByGroupAndState(long groupId,
		boolean invisible) throws SystemException {
		return filterFindByGroupAndState(groupId, invisible, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l categories that the user has permission to view where groupId = &#63; and invisible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @return the range of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByGroupAndState(long groupId,
		boolean invisible, int start, int end) throws SystemException {
		return filterFindByGroupAndState(groupId, invisible, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l categories that the user has permissions to view where groupId = &#63; and invisible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> filterFindByGroupAndState(long groupId,
		boolean invisible, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupAndState(groupId, invisible, start, end,
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
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPANDSTATE_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATE_INVISIBLE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VLCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VLCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(invisible);

			return (List<VLCategory>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v l categories before and after the current v l category in the ordered set of v l categories that the user has permission to view where groupId = &#63; and invisible = &#63;.
	 *
	 * @param categoryId the primary key of the current v l category
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory[] filterFindByGroupAndState_PrevAndNext(long categoryId,
		long groupId, boolean invisible, OrderByComparator orderByComparator)
		throws NoSuchVLCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupAndState_PrevAndNext(categoryId, groupId,
				invisible, orderByComparator);
		}

		VLCategory vlCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VLCategory[] array = new VLCategoryImpl[3];

			array[0] = filterGetByGroupAndState_PrevAndNext(session,
					vlCategory, groupId, invisible, orderByComparator, true);

			array[1] = vlCategory;

			array[2] = filterGetByGroupAndState_PrevAndNext(session,
					vlCategory, groupId, invisible, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VLCategory filterGetByGroupAndState_PrevAndNext(Session session,
		VLCategory vlCategory, long groupId, boolean invisible,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPANDSTATE_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATE_INVISIBLE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VLCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VLCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(invisible);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l categories where groupId = &#63; and invisible = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndState(long groupId, boolean invisible)
		throws SystemException {
		for (VLCategory vlCategory : findByGroupAndState(groupId, invisible,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlCategory);
		}
	}

	/**
	 * Returns the number of v l categories where groupId = &#63; and invisible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @return the number of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupAndState(long groupId, boolean invisible)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDSTATE;

		Object[] finderArgs = new Object[] { groupId, invisible };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATE_INVISIBLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(invisible);

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
	 * Returns the number of v l categories that the user has permission to view where groupId = &#63; and invisible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param invisible the invisible
	 * @return the number of matching v l categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupAndState(long groupId, boolean invisible)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupAndState(groupId, invisible);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VLCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDSTATE_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATE_INVISIBLE_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(invisible);

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

	private static final String _FINDER_COLUMN_GROUPANDSTATE_GROUPID_2 = "vlCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDSTATE_INVISIBLE_2 = "vlCategory.invisible = ?";

	public VLCategoryPersistenceImpl() {
		setModelClass(VLCategory.class);
	}

	/**
	 * Caches the v l category in the entity cache if it is enabled.
	 *
	 * @param vlCategory the v l category
	 */
	@Override
	public void cacheResult(VLCategory vlCategory) {
		EntityCacheUtil.putResult(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryImpl.class, vlCategory.getPrimaryKey(), vlCategory);

		vlCategory.resetOriginalValues();
	}

	/**
	 * Caches the v l categories in the entity cache if it is enabled.
	 *
	 * @param vlCategories the v l categories
	 */
	@Override
	public void cacheResult(List<VLCategory> vlCategories) {
		for (VLCategory vlCategory : vlCategories) {
			if (EntityCacheUtil.getResult(
						VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VLCategoryImpl.class, vlCategory.getPrimaryKey()) == null) {
				cacheResult(vlCategory);
			}
			else {
				vlCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v l categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VLCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VLCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v l category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VLCategory vlCategory) {
		EntityCacheUtil.removeResult(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryImpl.class, vlCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VLCategory> vlCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VLCategory vlCategory : vlCategories) {
			EntityCacheUtil.removeResult(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VLCategoryImpl.class, vlCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v l category with the primary key. Does not add the v l category to the database.
	 *
	 * @param categoryId the primary key for the new v l category
	 * @return the new v l category
	 */
	@Override
	public VLCategory create(long categoryId) {
		VLCategory vlCategory = new VLCategoryImpl();

		vlCategory.setNew(true);
		vlCategory.setPrimaryKey(categoryId);

		return vlCategory;
	}

	/**
	 * Removes the v l category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the v l category
	 * @return the v l category that was removed
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory remove(long categoryId)
		throws NoSuchVLCategoryException, SystemException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the v l category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v l category
	 * @return the v l category that was removed
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory remove(Serializable primaryKey)
		throws NoSuchVLCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VLCategory vlCategory = (VLCategory)session.get(VLCategoryImpl.class,
					primaryKey);

			if (vlCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVLCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vlCategory);
		}
		catch (NoSuchVLCategoryException nsee) {
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
	protected VLCategory removeImpl(VLCategory vlCategory)
		throws SystemException {
		vlCategory = toUnwrappedModel(vlCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vlCategory)) {
				vlCategory = (VLCategory)session.get(VLCategoryImpl.class,
						vlCategory.getPrimaryKeyObj());
			}

			if (vlCategory != null) {
				session.delete(vlCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vlCategory != null) {
			clearCache(vlCategory);
		}

		return vlCategory;
	}

	@Override
	public VLCategory updateImpl(
		com.viettel.portal.videolibrary.model.VLCategory vlCategory)
		throws SystemException {
		vlCategory = toUnwrappedModel(vlCategory);

		boolean isNew = vlCategory.isNew();

		VLCategoryModelImpl vlCategoryModelImpl = (VLCategoryModelImpl)vlCategory;

		Session session = null;

		try {
			session = openSession();

			if (vlCategory.isNew()) {
				session.save(vlCategory);

				vlCategory.setNew(false);
			}
			else {
				session.merge(vlCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VLCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vlCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { vlCategoryModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((vlCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlCategoryModelImpl.getOriginalCategoryName(),
						vlCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);

				args = new Object[] {
						vlCategoryModelImpl.getCategoryName(),
						vlCategoryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);
			}

			if ((vlCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlCategoryModelImpl.getOriginalGroupId(),
						vlCategoryModelImpl.getOriginalInvisible()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATE,
					args);

				args = new Object[] {
						vlCategoryModelImpl.getGroupId(),
						vlCategoryModelImpl.getInvisible()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATE,
					args);
			}
		}

		EntityCacheUtil.putResult(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLCategoryImpl.class, vlCategory.getPrimaryKey(), vlCategory);

		return vlCategory;
	}

	protected VLCategory toUnwrappedModel(VLCategory vlCategory) {
		if (vlCategory instanceof VLCategoryImpl) {
			return vlCategory;
		}

		VLCategoryImpl vlCategoryImpl = new VLCategoryImpl();

		vlCategoryImpl.setNew(vlCategory.isNew());
		vlCategoryImpl.setPrimaryKey(vlCategory.getPrimaryKey());

		vlCategoryImpl.setCategoryId(vlCategory.getCategoryId());
		vlCategoryImpl.setGroupId(vlCategory.getGroupId());
		vlCategoryImpl.setCompanyId(vlCategory.getCompanyId());
		vlCategoryImpl.setUserId(vlCategory.getUserId());
		vlCategoryImpl.setUserName(vlCategory.getUserName());
		vlCategoryImpl.setCreateDate(vlCategory.getCreateDate());
		vlCategoryImpl.setModifiedDate(vlCategory.getModifiedDate());
		vlCategoryImpl.setCategoryName(vlCategory.getCategoryName());
		vlCategoryImpl.setInvisible(vlCategory.isInvisible());

		return vlCategoryImpl;
	}

	/**
	 * Returns the v l category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l category
	 * @return the v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVLCategoryException, SystemException {
		VLCategory vlCategory = fetchByPrimaryKey(primaryKey);

		if (vlCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVLCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vlCategory;
	}

	/**
	 * Returns the v l category with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVLCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the v l category
	 * @return the v l category
	 * @throws com.viettel.portal.videolibrary.NoSuchVLCategoryException if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory findByPrimaryKey(long categoryId)
		throws NoSuchVLCategoryException, SystemException {
		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the v l category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l category
	 * @return the v l category, or <code>null</code> if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VLCategory vlCategory = (VLCategory)EntityCacheUtil.getResult(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VLCategoryImpl.class, primaryKey);

		if (vlCategory == _nullVLCategory) {
			return null;
		}

		if (vlCategory == null) {
			Session session = null;

			try {
				session = openSession();

				vlCategory = (VLCategory)session.get(VLCategoryImpl.class,
						primaryKey);

				if (vlCategory != null) {
					cacheResult(vlCategory);
				}
				else {
					EntityCacheUtil.putResult(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VLCategoryImpl.class, primaryKey, _nullVLCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VLCategoryModelImpl.ENTITY_CACHE_ENABLED,
					VLCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vlCategory;
	}

	/**
	 * Returns the v l category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the v l category
	 * @return the v l category, or <code>null</code> if a v l category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the v l categories.
	 *
	 * @return the v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @return the range of v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findAll(int start, int end,
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

		List<VLCategory> list = (List<VLCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VLCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VLCATEGORY;

				if (pagination) {
					sql = sql.concat(VLCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VLCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLCategory>(list);
				}
				else {
					list = (List<VLCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v l categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VLCategory vlCategory : findAll()) {
			remove(vlCategory);
		}
	}

	/**
	 * Returns the number of v l categories.
	 *
	 * @return the number of v l categories
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

				Query q = session.createQuery(_SQL_COUNT_VLCATEGORY);

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
	 * Initializes the v l category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.videolibrary.model.VLCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VLCategory>> listenersList = new ArrayList<ModelListener<VLCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VLCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VLCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VLCATEGORY = "SELECT vlCategory FROM VLCategory vlCategory";
	private static final String _SQL_SELECT_VLCATEGORY_WHERE = "SELECT vlCategory FROM VLCategory vlCategory WHERE ";
	private static final String _SQL_COUNT_VLCATEGORY = "SELECT COUNT(vlCategory) FROM VLCategory vlCategory";
	private static final String _SQL_COUNT_VLCATEGORY_WHERE = "SELECT COUNT(vlCategory) FROM VLCategory vlCategory WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "vlCategory.categoryId";
	private static final String _FILTER_SQL_SELECT_VLCATEGORY_WHERE = "SELECT DISTINCT {vlCategory.*} FROM portal_videocategory vlCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {portal_videocategory.*} FROM (SELECT DISTINCT vlCategory.categoryId FROM portal_videocategory vlCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_VLCATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN portal_videocategory ON TEMP_TABLE.categoryId = portal_videocategory.categoryId";
	private static final String _FILTER_SQL_COUNT_VLCATEGORY_WHERE = "SELECT COUNT(DISTINCT vlCategory.categoryId) AS COUNT_VALUE FROM portal_videocategory vlCategory WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "vlCategory";
	private static final String _FILTER_ENTITY_TABLE = "portal_videocategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vlCategory.";
	private static final String _ORDER_BY_ENTITY_TABLE = "portal_videocategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VLCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VLCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VLCategoryPersistenceImpl.class);
	private static VLCategory _nullVLCategory = new VLCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VLCategory> toCacheModel() {
				return _nullVLCategoryCacheModel;
			}
		};

	private static CacheModel<VLCategory> _nullVLCategoryCacheModel = new CacheModel<VLCategory>() {
			@Override
			public VLCategory toEntityModel() {
				return _nullVLCategory;
			}
		};
}