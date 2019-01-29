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

package com.revotech.portal.videolibrary.service.persistence;

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

import com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException;
import com.revotech.portal.videolibrary.model.VLVideoCategory;
import com.revotech.portal.videolibrary.model.impl.VLVideoCategoryImpl;
import com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the v l video category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLVideoCategoryPersistence
 * @see VLVideoCategoryUtil
 * @generated
 */
public class VLVideoCategoryPersistenceImpl extends BasePersistenceImpl<VLVideoCategory>
	implements VLVideoCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VLVideoCategoryUtil} to access the v l video category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VLVideoCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VLVideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VLVideoCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VLVideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VLVideoCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName(), Long.class.getName() },
			VLVideoCategoryModelImpl.CATEGORYID_COLUMN_BITMASK |
			VLVideoCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v l video categories where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findByCategory(long categoryId, long groupId)
		throws SystemException {
		return findByCategory(categoryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l video categories where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l video categories
	 * @param end the upper bound of the range of v l video categories (not inclusive)
	 * @return the range of matching v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findByCategory(long categoryId, long groupId,
		int start, int end) throws SystemException {
		return findByCategory(categoryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l video categories where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l video categories
	 * @param end the upper bound of the range of v l video categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findByCategory(long categoryId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] {
					categoryId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VLVideoCategory> list = (List<VLVideoCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLVideoCategory vlVideoCategory : list) {
				if ((categoryId != vlVideoCategory.getCategoryId()) ||
						(groupId != vlVideoCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_VLVIDEOCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLVideoCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VLVideoCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideoCategory>(list);
				}
				else {
					list = (List<VLVideoCategory>)QueryUtil.list(q,
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
	 * Returns the first v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a matching v l video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory findByCategory_First(long categoryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoCategoryException, SystemException {
		VLVideoCategory vlVideoCategory = fetchByCategory_First(categoryId,
				groupId, orderByComparator);

		if (vlVideoCategory != null) {
			return vlVideoCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoCategoryException(msg.toString());
	}

	/**
	 * Returns the first v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video category, or <code>null</code> if a matching v l video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory fetchByCategory_First(long categoryId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLVideoCategory> list = findByCategory(categoryId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a matching v l video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory findByCategory_Last(long categoryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoCategoryException, SystemException {
		VLVideoCategory vlVideoCategory = fetchByCategory_Last(categoryId,
				groupId, orderByComparator);

		if (vlVideoCategory != null) {
			return vlVideoCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoCategoryException(msg.toString());
	}

	/**
	 * Returns the last v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video category, or <code>null</code> if a matching v l video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory fetchByCategory_Last(long categoryId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId, groupId);

		if (count == 0) {
			return null;
		}

		List<VLVideoCategory> list = findByCategory(categoryId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l video categories before and after the current v l video category in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current v l video category
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory[] findByCategory_PrevAndNext(long id,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLVideoCategoryException, SystemException {
		VLVideoCategory vlVideoCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VLVideoCategory[] array = new VLVideoCategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(session, vlVideoCategory,
					categoryId, groupId, orderByComparator, true);

			array[1] = vlVideoCategory;

			array[2] = getByCategory_PrevAndNext(session, vlVideoCategory,
					categoryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VLVideoCategory getByCategory_PrevAndNext(Session session,
		VLVideoCategory vlVideoCategory, long categoryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLVIDEOCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

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
			query.append(VLVideoCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlVideoCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLVideoCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l video categories where categoryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(long categoryId, long groupId)
		throws SystemException {
		for (VLVideoCategory vlVideoCategory : findByCategory(categoryId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlVideoCategory);
		}
	}

	/**
	 * Returns the number of v l video categories where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategory(long categoryId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { categoryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLVIDEOCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "vlVideoCategory.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORY_GROUPID_2 = "vlVideoCategory.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VLVideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VLVideoCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName(), Long.class.getName() },
			VLVideoCategoryModelImpl.VIDEOID_COLUMN_BITMASK |
			VLVideoCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v l video categories where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @return the matching v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findByVideo(long videoId, long groupId)
		throws SystemException {
		return findByVideo(videoId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l video categories where videoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l video categories
	 * @param end the upper bound of the range of v l video categories (not inclusive)
	 * @return the range of matching v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findByVideo(long videoId, long groupId,
		int start, int end) throws SystemException {
		return findByVideo(videoId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l video categories where videoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l video categories
	 * @param end the upper bound of the range of v l video categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findByVideo(long videoId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] {
					videoId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VLVideoCategory> list = (List<VLVideoCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLVideoCategory vlVideoCategory : list) {
				if ((videoId != vlVideoCategory.getVideoId()) ||
						(groupId != vlVideoCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_VLVIDEOCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEO_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLVideoCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VLVideoCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideoCategory>(list);
				}
				else {
					list = (List<VLVideoCategory>)QueryUtil.list(q,
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
	 * Returns the first v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a matching v l video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory findByVideo_First(long videoId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoCategoryException, SystemException {
		VLVideoCategory vlVideoCategory = fetchByVideo_First(videoId, groupId,
				orderByComparator);

		if (vlVideoCategory != null) {
			return vlVideoCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoCategoryException(msg.toString());
	}

	/**
	 * Returns the first v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video category, or <code>null</code> if a matching v l video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory fetchByVideo_First(long videoId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLVideoCategory> list = findByVideo(videoId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a matching v l video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory findByVideo_Last(long videoId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoCategoryException, SystemException {
		VLVideoCategory vlVideoCategory = fetchByVideo_Last(videoId, groupId,
				orderByComparator);

		if (vlVideoCategory != null) {
			return vlVideoCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoCategoryException(msg.toString());
	}

	/**
	 * Returns the last v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video category, or <code>null</code> if a matching v l video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory fetchByVideo_Last(long videoId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId, groupId);

		if (count == 0) {
			return null;
		}

		List<VLVideoCategory> list = findByVideo(videoId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l video categories before and after the current v l video category in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current v l video category
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory[] findByVideo_PrevAndNext(long id, long videoId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLVideoCategoryException, SystemException {
		VLVideoCategory vlVideoCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VLVideoCategory[] array = new VLVideoCategoryImpl[3];

			array[0] = getByVideo_PrevAndNext(session, vlVideoCategory,
					videoId, groupId, orderByComparator, true);

			array[1] = vlVideoCategory;

			array[2] = getByVideo_PrevAndNext(session, vlVideoCategory,
					videoId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VLVideoCategory getByVideo_PrevAndNext(Session session,
		VLVideoCategory vlVideoCategory, long videoId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLVIDEOCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEO_GROUPID_2);

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
			query.append(VLVideoCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlVideoCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLVideoCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l video categories where videoId = &#63; and groupId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId, long groupId)
		throws SystemException {
		for (VLVideoCategory vlVideoCategory : findByVideo(videoId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlVideoCategory);
		}
	}

	/**
	 * Returns the number of v l video categories where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @return the number of matching v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideo(long videoId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLVIDEOCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEO_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "vlVideoCategory.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEO_GROUPID_2 = "vlVideoCategory.groupId = ?";

	public VLVideoCategoryPersistenceImpl() {
		setModelClass(VLVideoCategory.class);
	}

	/**
	 * Caches the v l video category in the entity cache if it is enabled.
	 *
	 * @param vlVideoCategory the v l video category
	 */
	@Override
	public void cacheResult(VLVideoCategory vlVideoCategory) {
		EntityCacheUtil.putResult(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryImpl.class, vlVideoCategory.getPrimaryKey(),
			vlVideoCategory);

		vlVideoCategory.resetOriginalValues();
	}

	/**
	 * Caches the v l video categories in the entity cache if it is enabled.
	 *
	 * @param vlVideoCategories the v l video categories
	 */
	@Override
	public void cacheResult(List<VLVideoCategory> vlVideoCategories) {
		for (VLVideoCategory vlVideoCategory : vlVideoCategories) {
			if (EntityCacheUtil.getResult(
						VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VLVideoCategoryImpl.class,
						vlVideoCategory.getPrimaryKey()) == null) {
				cacheResult(vlVideoCategory);
			}
			else {
				vlVideoCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v l video categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VLVideoCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VLVideoCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v l video category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VLVideoCategory vlVideoCategory) {
		EntityCacheUtil.removeResult(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryImpl.class, vlVideoCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VLVideoCategory> vlVideoCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VLVideoCategory vlVideoCategory : vlVideoCategories) {
			EntityCacheUtil.removeResult(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VLVideoCategoryImpl.class, vlVideoCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v l video category with the primary key. Does not add the v l video category to the database.
	 *
	 * @param id the primary key for the new v l video category
	 * @return the new v l video category
	 */
	@Override
	public VLVideoCategory create(long id) {
		VLVideoCategory vlVideoCategory = new VLVideoCategoryImpl();

		vlVideoCategory.setNew(true);
		vlVideoCategory.setPrimaryKey(id);

		return vlVideoCategory;
	}

	/**
	 * Removes the v l video category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the v l video category
	 * @return the v l video category that was removed
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory remove(long id)
		throws NoSuchVLVideoCategoryException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the v l video category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v l video category
	 * @return the v l video category that was removed
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory remove(Serializable primaryKey)
		throws NoSuchVLVideoCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VLVideoCategory vlVideoCategory = (VLVideoCategory)session.get(VLVideoCategoryImpl.class,
					primaryKey);

			if (vlVideoCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVLVideoCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vlVideoCategory);
		}
		catch (NoSuchVLVideoCategoryException nsee) {
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
	protected VLVideoCategory removeImpl(VLVideoCategory vlVideoCategory)
		throws SystemException {
		vlVideoCategory = toUnwrappedModel(vlVideoCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vlVideoCategory)) {
				vlVideoCategory = (VLVideoCategory)session.get(VLVideoCategoryImpl.class,
						vlVideoCategory.getPrimaryKeyObj());
			}

			if (vlVideoCategory != null) {
				session.delete(vlVideoCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vlVideoCategory != null) {
			clearCache(vlVideoCategory);
		}

		return vlVideoCategory;
	}

	@Override
	public VLVideoCategory updateImpl(
		com.revotech.portal.videolibrary.model.VLVideoCategory vlVideoCategory)
		throws SystemException {
		vlVideoCategory = toUnwrappedModel(vlVideoCategory);

		boolean isNew = vlVideoCategory.isNew();

		VLVideoCategoryModelImpl vlVideoCategoryModelImpl = (VLVideoCategoryModelImpl)vlVideoCategory;

		Session session = null;

		try {
			session = openSession();

			if (vlVideoCategory.isNew()) {
				session.save(vlVideoCategory);

				vlVideoCategory.setNew(false);
			}
			else {
				session.merge(vlVideoCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VLVideoCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vlVideoCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlVideoCategoryModelImpl.getOriginalCategoryId(),
						vlVideoCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						vlVideoCategoryModelImpl.getCategoryId(),
						vlVideoCategoryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((vlVideoCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlVideoCategoryModelImpl.getOriginalVideoId(),
						vlVideoCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] {
						vlVideoCategoryModelImpl.getVideoId(),
						vlVideoCategoryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}
		}

		EntityCacheUtil.putResult(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoCategoryImpl.class, vlVideoCategory.getPrimaryKey(),
			vlVideoCategory);

		return vlVideoCategory;
	}

	protected VLVideoCategory toUnwrappedModel(VLVideoCategory vlVideoCategory) {
		if (vlVideoCategory instanceof VLVideoCategoryImpl) {
			return vlVideoCategory;
		}

		VLVideoCategoryImpl vlVideoCategoryImpl = new VLVideoCategoryImpl();

		vlVideoCategoryImpl.setNew(vlVideoCategory.isNew());
		vlVideoCategoryImpl.setPrimaryKey(vlVideoCategory.getPrimaryKey());

		vlVideoCategoryImpl.setId(vlVideoCategory.getId());
		vlVideoCategoryImpl.setCategoryId(vlVideoCategory.getCategoryId());
		vlVideoCategoryImpl.setVideoId(vlVideoCategory.getVideoId());
		vlVideoCategoryImpl.setGroupId(vlVideoCategory.getGroupId());

		return vlVideoCategoryImpl;
	}

	/**
	 * Returns the v l video category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l video category
	 * @return the v l video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVLVideoCategoryException, SystemException {
		VLVideoCategory vlVideoCategory = fetchByPrimaryKey(primaryKey);

		if (vlVideoCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVLVideoCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vlVideoCategory;
	}

	/**
	 * Returns the v l video category with the primary key or throws a {@link com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException} if it could not be found.
	 *
	 * @param id the primary key of the v l video category
	 * @return the v l video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoCategoryException if a v l video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory findByPrimaryKey(long id)
		throws NoSuchVLVideoCategoryException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the v l video category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l video category
	 * @return the v l video category, or <code>null</code> if a v l video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VLVideoCategory vlVideoCategory = (VLVideoCategory)EntityCacheUtil.getResult(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VLVideoCategoryImpl.class, primaryKey);

		if (vlVideoCategory == _nullVLVideoCategory) {
			return null;
		}

		if (vlVideoCategory == null) {
			Session session = null;

			try {
				session = openSession();

				vlVideoCategory = (VLVideoCategory)session.get(VLVideoCategoryImpl.class,
						primaryKey);

				if (vlVideoCategory != null) {
					cacheResult(vlVideoCategory);
				}
				else {
					EntityCacheUtil.putResult(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VLVideoCategoryImpl.class, primaryKey,
						_nullVLVideoCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VLVideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
					VLVideoCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vlVideoCategory;
	}

	/**
	 * Returns the v l video category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the v l video category
	 * @return the v l video category, or <code>null</code> if a v l video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoCategory fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the v l video categories.
	 *
	 * @return the v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l video categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l video categories
	 * @param end the upper bound of the range of v l video categories (not inclusive)
	 * @return the range of v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l video categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l video categories
	 * @param end the upper bound of the range of v l video categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v l video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoCategory> findAll(int start, int end,
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

		List<VLVideoCategory> list = (List<VLVideoCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VLVIDEOCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VLVIDEOCATEGORY;

				if (pagination) {
					sql = sql.concat(VLVideoCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VLVideoCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideoCategory>(list);
				}
				else {
					list = (List<VLVideoCategory>)QueryUtil.list(q,
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
	 * Removes all the v l video categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VLVideoCategory vlVideoCategory : findAll()) {
			remove(vlVideoCategory);
		}
	}

	/**
	 * Returns the number of v l video categories.
	 *
	 * @return the number of v l video categories
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

				Query q = session.createQuery(_SQL_COUNT_VLVIDEOCATEGORY);

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
	 * Initializes the v l video category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.revotech.portal.videolibrary.model.VLVideoCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VLVideoCategory>> listenersList = new ArrayList<ModelListener<VLVideoCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VLVideoCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VLVideoCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VLVIDEOCATEGORY = "SELECT vlVideoCategory FROM VLVideoCategory vlVideoCategory";
	private static final String _SQL_SELECT_VLVIDEOCATEGORY_WHERE = "SELECT vlVideoCategory FROM VLVideoCategory vlVideoCategory WHERE ";
	private static final String _SQL_COUNT_VLVIDEOCATEGORY = "SELECT COUNT(vlVideoCategory) FROM VLVideoCategory vlVideoCategory";
	private static final String _SQL_COUNT_VLVIDEOCATEGORY_WHERE = "SELECT COUNT(vlVideoCategory) FROM VLVideoCategory vlVideoCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vlVideoCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VLVideoCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VLVideoCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VLVideoCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static VLVideoCategory _nullVLVideoCategory = new VLVideoCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VLVideoCategory> toCacheModel() {
				return _nullVLVideoCategoryCacheModel;
			}
		};

	private static CacheModel<VLVideoCategory> _nullVLVideoCategoryCacheModel = new CacheModel<VLVideoCategory>() {
			@Override
			public VLVideoCategory toEntityModel() {
				return _nullVLVideoCategory;
			}
		};
}