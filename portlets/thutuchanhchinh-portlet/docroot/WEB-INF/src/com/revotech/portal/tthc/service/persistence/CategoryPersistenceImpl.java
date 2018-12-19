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

package com.revotech.portal.tthc.service.persistence;

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
import com.liferay.portal.kernel.util.CharPool;
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

import com.revotech.portal.tthc.NoSuchCategoryException;
import com.revotech.portal.tthc.model.Category;
import com.revotech.portal.tthc.model.impl.CategoryImpl;
import com.revotech.portal.tthc.model.impl.CategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hieptran
 * @see CategoryPersistence
 * @see CategoryUtil
 * @generated
 */
public class CategoryPersistenceImpl extends BasePersistenceImpl<Category>
	implements CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_A = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_A",
			new String[] {
				Integer.class.getName(), Boolean.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_A = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_A",
			new String[] {
				Integer.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			CategoryModelImpl.CATEGORYTYPE_COLUMN_BITMASK |
			CategoryModelImpl.ISACTIVE_COLUMN_BITMASK |
			CategoryModelImpl.GROUPID_COLUMN_BITMASK |
			CategoryModelImpl.CATORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_A = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_A",
			new String[] {
				Integer.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the categories where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @return the matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByG_C_A(int categoryType, boolean isActive,
		long groupId) throws SystemException {
		return findByG_C_A(categoryType, isActive, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByG_C_A(int categoryType, boolean isActive,
		long groupId, int start, int end) throws SystemException {
		return findByG_C_A(categoryType, isActive, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByG_C_A(int categoryType, boolean isActive,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_A;
			finderArgs = new Object[] { categoryType, isActive, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_A;
			finderArgs = new Object[] {
					categoryType, isActive, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Category> list = (List<Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Category category : list) {
				if ((categoryType != category.getCategoryType()) ||
						(isActive != category.getIsActive()) ||
						(groupId != category.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_C_A_CATEGORYTYPE_2);

			query.append(_FINDER_COLUMN_G_C_A_ISACTIVE_2);

			query.append(_FINDER_COLUMN_G_C_A_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryType);

				qPos.add(isActive);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Category>(list);
				}
				else {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category findByG_C_A_First(int categoryType, boolean isActive,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = fetchByG_C_A_First(categoryType, isActive, groupId,
				orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryType=");
		msg.append(categoryType);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the first category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category fetchByG_C_A_First(int categoryType, boolean isActive,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Category> list = findByG_C_A(categoryType, isActive, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category findByG_C_A_Last(int categoryType, boolean isActive,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = fetchByG_C_A_Last(categoryType, isActive, groupId,
				orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryType=");
		msg.append(categoryType);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the last category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category fetchByG_C_A_Last(int categoryType, boolean isActive,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_C_A(categoryType, isActive, groupId);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByG_C_A(categoryType, isActive, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category[] findByG_C_A_PrevAndNext(long categoryId,
		int categoryType, boolean isActive, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByG_C_A_PrevAndNext(session, category, categoryType,
					isActive, groupId, orderByComparator, true);

			array[1] = category;

			array[2] = getByG_C_A_PrevAndNext(session, category, categoryType,
					isActive, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Category getByG_C_A_PrevAndNext(Session session,
		Category category, int categoryType, boolean isActive, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_G_C_A_CATEGORYTYPE_2);

		query.append(_FINDER_COLUMN_G_C_A_ISACTIVE_2);

		query.append(_FINDER_COLUMN_G_C_A_GROUPID_2);

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
			query.append(CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryType);

		qPos.add(isActive);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the categories that the user has permission to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @return the matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByG_C_A(int categoryType, boolean isActive,
		long groupId) throws SystemException {
		return filterFindByG_C_A(categoryType, isActive, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories that the user has permission to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByG_C_A(int categoryType, boolean isActive,
		long groupId, int start, int end) throws SystemException {
		return filterFindByG_C_A(categoryType, isActive, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the categories that the user has permissions to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByG_C_A(int categoryType, boolean isActive,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_A(categoryType, isActive, groupId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_A_CATEGORYTYPE_2);

		query.append(_FINDER_COLUMN_G_C_A_ISACTIVE_2);

		query.append(_FINDER_COLUMN_G_C_A_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryType);

			qPos.add(isActive);

			qPos.add(groupId);

			return (List<Category>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the categories before and after the current category in the ordered set of categories that the user has permission to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category[] filterFindByG_C_A_PrevAndNext(long categoryId,
		int categoryType, boolean isActive, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_A_PrevAndNext(categoryId, categoryType, isActive,
				groupId, orderByComparator);
		}

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = filterGetByG_C_A_PrevAndNext(session, category,
					categoryType, isActive, groupId, orderByComparator, true);

			array[1] = category;

			array[2] = filterGetByG_C_A_PrevAndNext(session, category,
					categoryType, isActive, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Category filterGetByG_C_A_PrevAndNext(Session session,
		Category category, int categoryType, boolean isActive, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_A_CATEGORYTYPE_2);

		query.append(_FINDER_COLUMN_G_C_A_ISACTIVE_2);

		query.append(_FINDER_COLUMN_G_C_A_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryType);

		qPos.add(isActive);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where categoryType = &#63; and isActive = &#63; and groupId = &#63; from the database.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_C_A(int categoryType, boolean isActive, long groupId)
		throws SystemException {
		for (Category category : findByG_C_A(categoryType, isActive, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(category);
		}
	}

	/**
	 * Returns the number of categories where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @return the number of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C_A(int categoryType, boolean isActive, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C_A;

		Object[] finderArgs = new Object[] { categoryType, isActive, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_C_A_CATEGORYTYPE_2);

			query.append(_FINDER_COLUMN_G_C_A_ISACTIVE_2);

			query.append(_FINDER_COLUMN_G_C_A_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryType);

				qPos.add(isActive);

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
	 * Returns the number of categories that the user has permission to view where categoryType = &#63; and isActive = &#63; and groupId = &#63;.
	 *
	 * @param categoryType the category type
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @return the number of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_C_A(int categoryType, boolean isActive,
		long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_A(categoryType, isActive, groupId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_G_C_A_CATEGORYTYPE_2);

		query.append(_FINDER_COLUMN_G_C_A_ISACTIVE_2);

		query.append(_FINDER_COLUMN_G_C_A_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryType);

			qPos.add(isActive);

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

	private static final String _FINDER_COLUMN_G_C_A_CATEGORYTYPE_2 = "category.categoryType = ? AND ";
	private static final String _FINDER_COLUMN_G_C_A_ISACTIVE_2 = "category.isActive = ? AND ";
	private static final String _FINDER_COLUMN_G_C_A_GROUPID_2 = "category.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYKEYWORD =
		new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByKeyword",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_BYKEYWORD =
		new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByByKeyword",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @return the matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByByKeyword(long groupId, String categoryName,
		int categoryType) throws SystemException {
		return findByByKeyword(groupId, categoryName, categoryType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByByKeyword(long groupId, String categoryName,
		int categoryType, int start, int end) throws SystemException {
		return findByByKeyword(groupId, categoryName, categoryType, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByByKeyword(long groupId, String categoryName,
		int categoryType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYKEYWORD;
		finderArgs = new Object[] {
				groupId, categoryName, categoryType,
				
				start, end, orderByComparator
			};

		List<Category> list = (List<Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Category category : list) {
				if ((groupId != category.getGroupId()) ||
						!StringUtil.wildcardMatches(
							category.getCategoryName(), categoryName,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(categoryType != category.getCategoryType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_BYKEYWORD_GROUPID_2);

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_2);
			}

			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCategoryName) {
					qPos.add(categoryName);
				}

				qPos.add(categoryType);

				if (!pagination) {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Category>(list);
				}
				else {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category findByByKeyword_First(long groupId, String categoryName,
		int categoryType, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = fetchByByKeyword_First(groupId, categoryName,
				categoryType, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryName=");
		msg.append(categoryName);

		msg.append(", categoryType=");
		msg.append(categoryType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the first category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category fetchByByKeyword_First(long groupId, String categoryName,
		int categoryType, OrderByComparator orderByComparator)
		throws SystemException {
		List<Category> list = findByByKeyword(groupId, categoryName,
				categoryType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category findByByKeyword_Last(long groupId, String categoryName,
		int categoryType, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = fetchByByKeyword_Last(groupId, categoryName,
				categoryType, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryName=");
		msg.append(categoryName);

		msg.append(", categoryType=");
		msg.append(categoryType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the last category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category fetchByByKeyword_Last(long groupId, String categoryName,
		int categoryType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByByKeyword(groupId, categoryName, categoryType);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByByKeyword(groupId, categoryName,
				categoryType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category[] findByByKeyword_PrevAndNext(long categoryId,
		long groupId, String categoryName, int categoryType,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByByKeyword_PrevAndNext(session, category, groupId,
					categoryName, categoryType, orderByComparator, true);

			array[1] = category;

			array[2] = getByByKeyword_PrevAndNext(session, category, groupId,
					categoryName, categoryType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Category getByByKeyword_PrevAndNext(Session session,
		Category category, long groupId, String categoryName, int categoryType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_BYKEYWORD_GROUPID_2);

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_2);
		}

		query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYTYPE_2);

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
			query.append(CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindCategoryName) {
			qPos.add(categoryName);
		}

		qPos.add(categoryType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the categories that the user has permission to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @return the matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByByKeyword(long groupId,
		String categoryName, int categoryType) throws SystemException {
		return filterFindByByKeyword(groupId, categoryName, categoryType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories that the user has permission to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByByKeyword(long groupId,
		String categoryName, int categoryType, int start, int end)
		throws SystemException {
		return filterFindByByKeyword(groupId, categoryName, categoryType,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories that the user has permissions to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByByKeyword(long groupId,
		String categoryName, int categoryType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByByKeyword(groupId, categoryName, categoryType, start,
				end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_BYKEYWORD_GROUPID_2);

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_2);
		}

		query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYTYPE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindCategoryName) {
				qPos.add(categoryName);
			}

			qPos.add(categoryType);

			return (List<Category>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the categories before and after the current category in the ordered set of categories that the user has permission to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category[] filterFindByByKeyword_PrevAndNext(long categoryId,
		long groupId, String categoryName, int categoryType,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByByKeyword_PrevAndNext(categoryId, groupId,
				categoryName, categoryType, orderByComparator);
		}

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = filterGetByByKeyword_PrevAndNext(session, category,
					groupId, categoryName, categoryType, orderByComparator, true);

			array[1] = category;

			array[2] = filterGetByByKeyword_PrevAndNext(session, category,
					groupId, categoryName, categoryType, orderByComparator,
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

	protected Category filterGetByByKeyword_PrevAndNext(Session session,
		Category category, long groupId, String categoryName, int categoryType,
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
			query.append(_FILTER_SQL_SELECT_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_BYKEYWORD_GROUPID_2);

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_2);
		}

		query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYTYPE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindCategoryName) {
			qPos.add(categoryName);
		}

		qPos.add(categoryType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByByKeyword(long groupId, String categoryName,
		int categoryType) throws SystemException {
		for (Category category : findByByKeyword(groupId, categoryName,
				categoryType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(category);
		}
	}

	/**
	 * Returns the number of categories where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @return the number of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByByKeyword(long groupId, String categoryName,
		int categoryType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_BYKEYWORD;

		Object[] finderArgs = new Object[] { groupId, categoryName, categoryType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_BYKEYWORD_GROUPID_2);

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_2);
			}

			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCategoryName) {
					qPos.add(categoryName);
				}

				qPos.add(categoryType);

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
	 * Returns the number of categories that the user has permission to view where groupId = &#63; and categoryName LIKE &#63; and categoryType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryName the category name
	 * @param categoryType the category type
	 * @return the number of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByByKeyword(long groupId, String categoryName,
		int categoryType) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByByKeyword(groupId, categoryName, categoryType);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_BYKEYWORD_GROUPID_2);

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_2);
		}

		query.append(_FINDER_COLUMN_BYKEYWORD_CATEGORYTYPE_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindCategoryName) {
				qPos.add(categoryName);
			}

			qPos.add(categoryType);

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

	private static final String _FINDER_COLUMN_BYKEYWORD_GROUPID_2 = "category.groupId = ? AND ";
	private static final String _FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_1 = "category.categoryName LIKE NULL AND ";
	private static final String _FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_2 = "category.categoryName LIKE ? AND ";
	private static final String _FINDER_COLUMN_BYKEYWORD_CATEGORYNAME_3 = "(category.categoryName IS NULL OR category.categoryName LIKE '') AND ";
	private static final String _FINDER_COLUMN_BYKEYWORD_CATEGORYTYPE_2 = "category.categoryType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryName",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryName",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CategoryModelImpl.CATEGORYNAME_COLUMN_BITMASK |
			CategoryModelImpl.GROUPID_COLUMN_BITMASK |
			CategoryModelImpl.CATEGORYTYPE_COLUMN_BITMASK |
			CategoryModelImpl.CATORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAME = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryName",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @return the matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByCategoryName(String categoryName, long groupId,
		int categoryType) throws SystemException {
		return findByCategoryName(categoryName, groupId, categoryType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByCategoryName(String categoryName, long groupId,
		int categoryType, int start, int end) throws SystemException {
		return findByCategoryName(categoryName, groupId, categoryType, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findByCategoryName(String categoryName, long groupId,
		int categoryType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] { categoryName, groupId, categoryType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] {
					categoryName, groupId, categoryType,
					
					start, end, orderByComparator
				};
		}

		List<Category> list = (List<Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Category category : list) {
				if (!Validator.equals(categoryName, category.getCategoryName()) ||
						(groupId != category.getGroupId()) ||
						(categoryType != category.getCategoryType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CATEGORY_WHERE);

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

			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
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

				qPos.add(categoryType);

				if (!pagination) {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Category>(list);
				}
				else {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category findByCategoryName_First(String categoryName, long groupId,
		int categoryType, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = fetchByCategoryName_First(categoryName, groupId,
				categoryType, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryName=");
		msg.append(categoryName);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", categoryType=");
		msg.append(categoryType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the first category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category fetchByCategoryName_First(String categoryName,
		long groupId, int categoryType, OrderByComparator orderByComparator)
		throws SystemException {
		List<Category> list = findByCategoryName(categoryName, groupId,
				categoryType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category findByCategoryName_Last(String categoryName, long groupId,
		int categoryType, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = fetchByCategoryName_Last(categoryName, groupId,
				categoryType, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryName=");
		msg.append(categoryName);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", categoryType=");
		msg.append(categoryType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the last category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category fetchByCategoryName_Last(String categoryName, long groupId,
		int categoryType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryName(categoryName, groupId, categoryType);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByCategoryName(categoryName, groupId,
				categoryType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category[] findByCategoryName_PrevAndNext(long categoryId,
		String categoryName, long groupId, int categoryType,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByCategoryName_PrevAndNext(session, category,
					categoryName, groupId, categoryType, orderByComparator, true);

			array[1] = category;

			array[2] = getByCategoryName_PrevAndNext(session, category,
					categoryName, groupId, categoryType, orderByComparator,
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

	protected Category getByCategoryName_PrevAndNext(Session session,
		Category category, String categoryName, long groupId, int categoryType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORY_WHERE);

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

		query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYTYPE_2);

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
			query.append(CategoryModelImpl.ORDER_BY_JPQL);
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

		qPos.add(categoryType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the categories that the user has permission to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @return the matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByCategoryName(String categoryName,
		long groupId, int categoryType) throws SystemException {
		return filterFindByCategoryName(categoryName, groupId, categoryType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories that the user has permission to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByCategoryName(String categoryName,
		long groupId, int categoryType, int start, int end)
		throws SystemException {
		return filterFindByCategoryName(categoryName, groupId, categoryType,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories that the user has permissions to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> filterFindByCategoryName(String categoryName,
		long groupId, int categoryType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryName(categoryName, groupId, categoryType,
				start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
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

		query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYTYPE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindCategoryName) {
				qPos.add(categoryName);
			}

			qPos.add(groupId);

			qPos.add(categoryType);

			return (List<Category>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the categories before and after the current category in the ordered set of categories that the user has permission to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category[] filterFindByCategoryName_PrevAndNext(long categoryId,
		String categoryName, long groupId, int categoryType,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryName_PrevAndNext(categoryId, categoryName,
				groupId, categoryType, orderByComparator);
		}

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = filterGetByCategoryName_PrevAndNext(session, category,
					categoryName, groupId, categoryType, orderByComparator, true);

			array[1] = category;

			array[2] = filterGetByCategoryName_PrevAndNext(session, category,
					categoryName, groupId, categoryType, orderByComparator,
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

	protected Category filterGetByCategoryName_PrevAndNext(Session session,
		Category category, String categoryName, long groupId, int categoryType,
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
			query.append(_FILTER_SQL_SELECT_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
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

		query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYTYPE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategoryName) {
			qPos.add(categoryName);
		}

		qPos.add(groupId);

		qPos.add(categoryType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryName(String categoryName, long groupId,
		int categoryType) throws SystemException {
		for (Category category : findByCategoryName(categoryName, groupId,
				categoryType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(category);
		}
	}

	/**
	 * Returns the number of categories where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @return the number of matching categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryName(String categoryName, long groupId,
		int categoryType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYNAME;

		Object[] finderArgs = new Object[] { categoryName, groupId, categoryType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CATEGORY_WHERE);

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

			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYTYPE_2);

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

				qPos.add(categoryType);

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
	 * Returns the number of categories that the user has permission to view where categoryName = &#63; and groupId = &#63; and categoryType = &#63;.
	 *
	 * @param categoryName the category name
	 * @param groupId the group ID
	 * @param categoryType the category type
	 * @return the number of matching categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCategoryName(String categoryName, long groupId,
		int categoryType) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryName(categoryName, groupId, categoryType);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CATEGORY_WHERE);

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

		query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYTYPE_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Category.class.getName(),
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

			qPos.add(categoryType);

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

	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1 = "category.categoryName IS NULL AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2 = "category.categoryName = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3 = "(category.categoryName IS NULL OR category.categoryName = '') AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_GROUPID_2 = "category.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYTYPE_2 = "category.categoryType = ?";

	public CategoryPersistenceImpl() {
		setModelClass(Category.class);
	}

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	@Override
	public void cacheResult(Category category) {
		EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryImpl.class, category.getPrimaryKey(), category);

		category.resetOriginalValues();
	}

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	@Override
	public void cacheResult(List<Category> categories) {
		for (Category category : categories) {
			if (EntityCacheUtil.getResult(
						CategoryModelImpl.ENTITY_CACHE_ENABLED,
						CategoryImpl.class, category.getPrimaryKey()) == null) {
				cacheResult(category);
			}
			else {
				category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Category category) {
		EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryImpl.class, category.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Category> categories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Category category : categories) {
			EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
				CategoryImpl.class, category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	@Override
	public Category create(long categoryId) {
		Category category = new CategoryImpl();

		category.setNew(true);
		category.setPrimaryKey(categoryId);

		return category;
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category remove(long categoryId)
		throws NoSuchCategoryException, SystemException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category that was removed
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category remove(Serializable primaryKey)
		throws NoSuchCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Category category = (Category)session.get(CategoryImpl.class,
					primaryKey);

			if (category == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(category);
		}
		catch (NoSuchCategoryException nsee) {
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
	protected Category removeImpl(Category category) throws SystemException {
		category = toUnwrappedModel(category);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(category)) {
				category = (Category)session.get(CategoryImpl.class,
						category.getPrimaryKeyObj());
			}

			if (category != null) {
				session.delete(category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (category != null) {
			clearCache(category);
		}

		return category;
	}

	@Override
	public Category updateImpl(com.revotech.portal.tthc.model.Category category)
		throws SystemException {
		category = toUnwrappedModel(category);

		boolean isNew = category.isNew();

		CategoryModelImpl categoryModelImpl = (CategoryModelImpl)category;

		Session session = null;

		try {
			session = openSession();

			if (category.isNew()) {
				session.save(category);

				category.setNew(false);
			}
			else {
				session.merge(category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((categoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						categoryModelImpl.getOriginalCategoryType(),
						categoryModelImpl.getOriginalIsActive(),
						categoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_A,
					args);

				args = new Object[] {
						categoryModelImpl.getCategoryType(),
						categoryModelImpl.getIsActive(),
						categoryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_A,
					args);
			}

			if ((categoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						categoryModelImpl.getOriginalCategoryName(),
						categoryModelImpl.getOriginalGroupId(),
						categoryModelImpl.getOriginalCategoryType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);

				args = new Object[] {
						categoryModelImpl.getCategoryName(),
						categoryModelImpl.getGroupId(),
						categoryModelImpl.getCategoryType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryImpl.class, category.getPrimaryKey(), category);

		return category;
	}

	protected Category toUnwrappedModel(Category category) {
		if (category instanceof CategoryImpl) {
			return category;
		}

		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setNew(category.isNew());
		categoryImpl.setPrimaryKey(category.getPrimaryKey());

		categoryImpl.setCategoryId(category.getCategoryId());
		categoryImpl.setGroupId(category.getGroupId());
		categoryImpl.setCompanyId(category.getCompanyId());
		categoryImpl.setUserId(category.getUserId());
		categoryImpl.setUserName(category.getUserName());
		categoryImpl.setCreateDate(category.getCreateDate());
		categoryImpl.setModifiedDate(category.getModifiedDate());
		categoryImpl.setCategoryName(category.getCategoryName());
		categoryImpl.setCategoryDesc(category.getCategoryDesc());
		categoryImpl.setIsActive(category.isIsActive());
		categoryImpl.setCategoryType(category.getCategoryType());
		categoryImpl.setCatOrder(category.getCatOrder());

		return categoryImpl;
	}

	/**
	 * Returns the category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryException, SystemException {
		Category category = fetchByPrimaryKey(primaryKey);

		if (category == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return category;
	}

	/**
	 * Returns the category with the primary key or throws a {@link com.revotech.portal.tthc.NoSuchCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws com.revotech.portal.tthc.NoSuchCategoryException if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category findByPrimaryKey(long categoryId)
		throws NoSuchCategoryException, SystemException {
		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Category category = (Category)EntityCacheUtil.getResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
				CategoryImpl.class, primaryKey);

		if (category == _nullCategory) {
			return null;
		}

		if (category == null) {
			Session session = null;

			try {
				session = openSession();

				category = (Category)session.get(CategoryImpl.class, primaryKey);

				if (category != null) {
					cacheResult(category);
				}
				else {
					EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
						CategoryImpl.class, primaryKey, _nullCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
					CategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return category;
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Category fetchByPrimaryKey(long categoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the categories.
	 *
	 * @return the categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Category> findAll(int start, int end,
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

		List<Category> list = (List<Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORY;

				if (pagination) {
					sql = sql.concat(CategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Category>(list);
				}
				else {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Category category : findAll()) {
			remove(category);
		}
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
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

				Query q = session.createQuery(_SQL_COUNT_CATEGORY);

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
	 * Initializes the category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.revotech.portal.tthc.model.Category")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Category>> listenersList = new ArrayList<ModelListener<Category>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Category>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CATEGORY = "SELECT category FROM Category category";
	private static final String _SQL_SELECT_CATEGORY_WHERE = "SELECT category FROM Category category WHERE ";
	private static final String _SQL_COUNT_CATEGORY = "SELECT COUNT(category) FROM Category category";
	private static final String _SQL_COUNT_CATEGORY_WHERE = "SELECT COUNT(category) FROM Category category WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "category.categoryId";
	private static final String _FILTER_SQL_SELECT_CATEGORY_WHERE = "SELECT DISTINCT {category.*} FROM tthc_Category category WHERE ";
	private static final String _FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {tthc_Category.*} FROM (SELECT DISTINCT category.categoryId FROM tthc_Category category WHERE ";
	private static final String _FILTER_SQL_SELECT_CATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN tthc_Category ON TEMP_TABLE.categoryId = tthc_Category.categoryId";
	private static final String _FILTER_SQL_COUNT_CATEGORY_WHERE = "SELECT COUNT(DISTINCT category.categoryId) AS COUNT_VALUE FROM tthc_Category category WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "category";
	private static final String _FILTER_ENTITY_TABLE = "tthc_Category";
	private static final String _ORDER_BY_ENTITY_ALIAS = "category.";
	private static final String _ORDER_BY_ENTITY_TABLE = "tthc_Category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Category exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CategoryPersistenceImpl.class);
	private static Category _nullCategory = new CategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Category> toCacheModel() {
				return _nullCategoryCacheModel;
			}
		};

	private static CacheModel<Category> _nullCategoryCacheModel = new CacheModel<Category>() {
			@Override
			public Category toEntityModel() {
				return _nullCategory;
			}
		};
}