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

import com.revotech.portal.videolibrary.NoSuchVLVideoException;
import com.revotech.portal.videolibrary.model.VLVideo;
import com.revotech.portal.videolibrary.model.impl.VLVideoImpl;
import com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v l video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLVideoPersistence
 * @see VLVideoUtil
 * @generated
 */
public class VLVideoPersistenceImpl extends BasePersistenceImpl<VLVideo>
	implements VLVideoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VLVideoUtil} to access the v l video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VLVideoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, VLVideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, VLVideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, VLVideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, VLVideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VLVideoModelImpl.GROUPID_COLUMN_BITMASK |
			VLVideoModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the v l videos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l videos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @return the range of matching v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l videos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findByGroup(long groupId, int start, int end,
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

		List<VLVideo> list = (List<VLVideo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLVideo vlVideo : list) {
				if ((groupId != vlVideo.getGroupId())) {
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

			query.append(_SQL_SELECT_VLVIDEO_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLVideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VLVideo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideo>(list);
				}
				else {
					list = (List<VLVideo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l video in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a matching v l video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoException, SystemException {
		VLVideo vlVideo = fetchByGroup_First(groupId, orderByComparator);

		if (vlVideo != null) {
			return vlVideo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoException(msg.toString());
	}

	/**
	 * Returns the first v l video in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video, or <code>null</code> if a matching v l video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLVideo> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l video in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a matching v l video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoException, SystemException {
		VLVideo vlVideo = fetchByGroup_Last(groupId, orderByComparator);

		if (vlVideo != null) {
			return vlVideo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoException(msg.toString());
	}

	/**
	 * Returns the last v l video in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video, or <code>null</code> if a matching v l video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<VLVideo> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l videos before and after the current v l video in the ordered set where groupId = &#63;.
	 *
	 * @param videoId the primary key of the current v l video
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo[] findByGroup_PrevAndNext(long videoId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoException, SystemException {
		VLVideo vlVideo = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			VLVideo[] array = new VLVideoImpl[3];

			array[0] = getByGroup_PrevAndNext(session, vlVideo, groupId,
					orderByComparator, true);

			array[1] = vlVideo;

			array[2] = getByGroup_PrevAndNext(session, vlVideo, groupId,
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

	protected VLVideo getByGroup_PrevAndNext(Session session, VLVideo vlVideo,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLVIDEO_WHERE);

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
			query.append(VLVideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlVideo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLVideo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v l videos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v l videos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the v l videos that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @return the range of matching v l videos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l videos that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l videos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_VLVIDEO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLVideoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLVideoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLVideo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VLVideoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VLVideoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<VLVideo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v l videos before and after the current v l video in the ordered set of v l videos that the user has permission to view where groupId = &#63;.
	 *
	 * @param videoId the primary key of the current v l video
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo[] filterFindByGroup_PrevAndNext(long videoId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(videoId, groupId, orderByComparator);
		}

		VLVideo vlVideo = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			VLVideo[] array = new VLVideoImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, vlVideo, groupId,
					orderByComparator, true);

			array[1] = vlVideo;

			array[2] = filterGetByGroup_PrevAndNext(session, vlVideo, groupId,
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

	protected VLVideo filterGetByGroup_PrevAndNext(Session session,
		VLVideo vlVideo, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLVideoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLVideoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLVideo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VLVideoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VLVideoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlVideo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLVideo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l videos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (VLVideo vlVideo : findByGroup(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vlVideo);
		}
	}

	/**
	 * Returns the number of v l videos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v l videos
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

			query.append(_SQL_COUNT_VLVIDEO_WHERE);

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
	 * Returns the number of v l videos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v l videos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_VLVIDEO_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLVideo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "vlVideo.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, VLVideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, VLVideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() },
			VLVideoModelImpl.CATEGORYID_COLUMN_BITMASK |
			VLVideoModelImpl.GROUPID_COLUMN_BITMASK |
			VLVideoModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v l videos where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findByCategoryId(long categoryId, long groupId)
		throws SystemException {
		return findByCategoryId(categoryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l videos where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @return the range of matching v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findByCategoryId(long categoryId, long groupId,
		int start, int end) throws SystemException {
		return findByCategoryId(categoryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l videos where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findByCategoryId(long categoryId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] {
					categoryId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VLVideo> list = (List<VLVideo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLVideo vlVideo : list) {
				if ((categoryId != vlVideo.getCategoryId()) ||
						(groupId != vlVideo.getGroupId())) {
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

			query.append(_SQL_SELECT_VLVIDEO_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLVideoModelImpl.ORDER_BY_JPQL);
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
					list = (List<VLVideo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideo>(list);
				}
				else {
					list = (List<VLVideo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a matching v l video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo findByCategoryId_First(long categoryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoException, SystemException {
		VLVideo vlVideo = fetchByCategoryId_First(categoryId, groupId,
				orderByComparator);

		if (vlVideo != null) {
			return vlVideo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoException(msg.toString());
	}

	/**
	 * Returns the first v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video, or <code>null</code> if a matching v l video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo fetchByCategoryId_First(long categoryId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLVideo> list = findByCategoryId(categoryId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a matching v l video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo findByCategoryId_Last(long categoryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoException, SystemException {
		VLVideo vlVideo = fetchByCategoryId_Last(categoryId, groupId,
				orderByComparator);

		if (vlVideo != null) {
			return vlVideo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoException(msg.toString());
	}

	/**
	 * Returns the last v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video, or <code>null</code> if a matching v l video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo fetchByCategoryId_Last(long categoryId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryId(categoryId, groupId);

		if (count == 0) {
			return null;
		}

		List<VLVideo> list = findByCategoryId(categoryId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l videos before and after the current v l video in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the primary key of the current v l video
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo[] findByCategoryId_PrevAndNext(long videoId,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLVideoException, SystemException {
		VLVideo vlVideo = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			VLVideo[] array = new VLVideoImpl[3];

			array[0] = getByCategoryId_PrevAndNext(session, vlVideo,
					categoryId, groupId, orderByComparator, true);

			array[1] = vlVideo;

			array[2] = getByCategoryId_PrevAndNext(session, vlVideo,
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

	protected VLVideo getByCategoryId_PrevAndNext(Session session,
		VLVideo vlVideo, long categoryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLVIDEO_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYID_GROUPID_2);

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
			query.append(VLVideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlVideo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLVideo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v l videos that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching v l videos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> filterFindByCategoryId(long categoryId, long groupId)
		throws SystemException {
		return filterFindByCategoryId(categoryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l videos that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @return the range of matching v l videos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> filterFindByCategoryId(long categoryId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByCategoryId(categoryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l videos that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l videos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> filterFindByCategoryId(long categoryId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryId(categoryId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_VLVIDEO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLVideoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLVideoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLVideo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VLVideoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VLVideoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryId);

			qPos.add(groupId);

			return (List<VLVideo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v l videos before and after the current v l video in the ordered set of v l videos that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the primary key of the current v l video
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo[] filterFindByCategoryId_PrevAndNext(long videoId,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLVideoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryId_PrevAndNext(videoId, categoryId, groupId,
				orderByComparator);
		}

		VLVideo vlVideo = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			VLVideo[] array = new VLVideoImpl[3];

			array[0] = filterGetByCategoryId_PrevAndNext(session, vlVideo,
					categoryId, groupId, orderByComparator, true);

			array[1] = vlVideo;

			array[2] = filterGetByCategoryId_PrevAndNext(session, vlVideo,
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

	protected VLVideo filterGetByCategoryId_PrevAndNext(Session session,
		VLVideo vlVideo, long categoryId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VLVIDEO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VLVideoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VLVideoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLVideo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VLVideoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VLVideoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlVideo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLVideo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l videos where categoryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryId(long categoryId, long groupId)
		throws SystemException {
		for (VLVideo vlVideo : findByCategoryId(categoryId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlVideo);
		}
	}

	/**
	 * Returns the number of v l videos where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryId(long categoryId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYID;

		Object[] finderArgs = new Object[] { categoryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLVIDEO_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYID_GROUPID_2);

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

	/**
	 * Returns the number of v l videos that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching v l videos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCategoryId(long categoryId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryId(categoryId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VLVIDEO_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VLVideo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "vlVideo.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYID_GROUPID_2 = "vlVideo.groupId = ?";

	public VLVideoPersistenceImpl() {
		setModelClass(VLVideo.class);
	}

	/**
	 * Caches the v l video in the entity cache if it is enabled.
	 *
	 * @param vlVideo the v l video
	 */
	@Override
	public void cacheResult(VLVideo vlVideo) {
		EntityCacheUtil.putResult(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoImpl.class, vlVideo.getPrimaryKey(), vlVideo);

		vlVideo.resetOriginalValues();
	}

	/**
	 * Caches the v l videos in the entity cache if it is enabled.
	 *
	 * @param vlVideos the v l videos
	 */
	@Override
	public void cacheResult(List<VLVideo> vlVideos) {
		for (VLVideo vlVideo : vlVideos) {
			if (EntityCacheUtil.getResult(
						VLVideoModelImpl.ENTITY_CACHE_ENABLED,
						VLVideoImpl.class, vlVideo.getPrimaryKey()) == null) {
				cacheResult(vlVideo);
			}
			else {
				vlVideo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v l videos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VLVideoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VLVideoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v l video.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VLVideo vlVideo) {
		EntityCacheUtil.removeResult(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoImpl.class, vlVideo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VLVideo> vlVideos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VLVideo vlVideo : vlVideos) {
			EntityCacheUtil.removeResult(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
				VLVideoImpl.class, vlVideo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v l video with the primary key. Does not add the v l video to the database.
	 *
	 * @param videoId the primary key for the new v l video
	 * @return the new v l video
	 */
	@Override
	public VLVideo create(long videoId) {
		VLVideo vlVideo = new VLVideoImpl();

		vlVideo.setNew(true);
		vlVideo.setPrimaryKey(videoId);

		return vlVideo;
	}

	/**
	 * Removes the v l video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the v l video
	 * @return the v l video that was removed
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo remove(long videoId)
		throws NoSuchVLVideoException, SystemException {
		return remove((Serializable)videoId);
	}

	/**
	 * Removes the v l video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v l video
	 * @return the v l video that was removed
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo remove(Serializable primaryKey)
		throws NoSuchVLVideoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VLVideo vlVideo = (VLVideo)session.get(VLVideoImpl.class, primaryKey);

			if (vlVideo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVLVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vlVideo);
		}
		catch (NoSuchVLVideoException nsee) {
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
	protected VLVideo removeImpl(VLVideo vlVideo) throws SystemException {
		vlVideo = toUnwrappedModel(vlVideo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vlVideo)) {
				vlVideo = (VLVideo)session.get(VLVideoImpl.class,
						vlVideo.getPrimaryKeyObj());
			}

			if (vlVideo != null) {
				session.delete(vlVideo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vlVideo != null) {
			clearCache(vlVideo);
		}

		return vlVideo;
	}

	@Override
	public VLVideo updateImpl(
		com.revotech.portal.videolibrary.model.VLVideo vlVideo)
		throws SystemException {
		vlVideo = toUnwrappedModel(vlVideo);

		boolean isNew = vlVideo.isNew();

		VLVideoModelImpl vlVideoModelImpl = (VLVideoModelImpl)vlVideo;

		Session session = null;

		try {
			session = openSession();

			if (vlVideo.isNew()) {
				session.save(vlVideo);

				vlVideo.setNew(false);
			}
			else {
				session.merge(vlVideo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VLVideoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vlVideoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlVideoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { vlVideoModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((vlVideoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlVideoModelImpl.getOriginalCategoryId(),
						vlVideoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);

				args = new Object[] {
						vlVideoModelImpl.getCategoryId(),
						vlVideoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoImpl.class, vlVideo.getPrimaryKey(), vlVideo);

		return vlVideo;
	}

	protected VLVideo toUnwrappedModel(VLVideo vlVideo) {
		if (vlVideo instanceof VLVideoImpl) {
			return vlVideo;
		}

		VLVideoImpl vlVideoImpl = new VLVideoImpl();

		vlVideoImpl.setNew(vlVideo.isNew());
		vlVideoImpl.setPrimaryKey(vlVideo.getPrimaryKey());

		vlVideoImpl.setVideoId(vlVideo.getVideoId());
		vlVideoImpl.setGroupId(vlVideo.getGroupId());
		vlVideoImpl.setCompanyId(vlVideo.getCompanyId());
		vlVideoImpl.setUserId(vlVideo.getUserId());
		vlVideoImpl.setUserName(vlVideo.getUserName());
		vlVideoImpl.setCreateDate(vlVideo.getCreateDate());
		vlVideoImpl.setModifiedDate(vlVideo.getModifiedDate());
		vlVideoImpl.setVideoName(vlVideo.getVideoName());
		vlVideoImpl.setDescription(vlVideo.getDescription());
		vlVideoImpl.setVideoType(vlVideo.getVideoType());
		vlVideoImpl.setVideoUrl(vlVideo.getVideoUrl());
		vlVideoImpl.setViewCount(vlVideo.getViewCount());
		vlVideoImpl.setFileId(vlVideo.getFileId());
		vlVideoImpl.setImage(vlVideo.isImage());
		vlVideoImpl.setImageId(vlVideo.getImageId());
		vlVideoImpl.setSmallImageUrl(vlVideo.getSmallImageUrl());
		vlVideoImpl.setRelateId(vlVideo.getRelateId());
		vlVideoImpl.setInvisible(vlVideo.isInvisible());
		vlVideoImpl.setCategoryId(vlVideo.getCategoryId());

		return vlVideoImpl;
	}

	/**
	 * Returns the v l video with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l video
	 * @return the v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVLVideoException, SystemException {
		VLVideo vlVideo = fetchByPrimaryKey(primaryKey);

		if (vlVideo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVLVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vlVideo;
	}

	/**
	 * Returns the v l video with the primary key or throws a {@link com.revotech.portal.videolibrary.NoSuchVLVideoException} if it could not be found.
	 *
	 * @param videoId the primary key of the v l video
	 * @return the v l video
	 * @throws com.revotech.portal.videolibrary.NoSuchVLVideoException if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo findByPrimaryKey(long videoId)
		throws NoSuchVLVideoException, SystemException {
		return findByPrimaryKey((Serializable)videoId);
	}

	/**
	 * Returns the v l video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l video
	 * @return the v l video, or <code>null</code> if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VLVideo vlVideo = (VLVideo)EntityCacheUtil.getResult(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
				VLVideoImpl.class, primaryKey);

		if (vlVideo == _nullVLVideo) {
			return null;
		}

		if (vlVideo == null) {
			Session session = null;

			try {
				session = openSession();

				vlVideo = (VLVideo)session.get(VLVideoImpl.class, primaryKey);

				if (vlVideo != null) {
					cacheResult(vlVideo);
				}
				else {
					EntityCacheUtil.putResult(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
						VLVideoImpl.class, primaryKey, _nullVLVideo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VLVideoModelImpl.ENTITY_CACHE_ENABLED,
					VLVideoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vlVideo;
	}

	/**
	 * Returns the v l video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoId the primary key of the v l video
	 * @return the v l video, or <code>null</code> if a v l video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideo fetchByPrimaryKey(long videoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)videoId);
	}

	/**
	 * Returns all the v l videos.
	 *
	 * @return the v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @return the range of v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l videos
	 * @param end the upper bound of the range of v l videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v l videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideo> findAll(int start, int end,
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

		List<VLVideo> list = (List<VLVideo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VLVIDEO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VLVIDEO;

				if (pagination) {
					sql = sql.concat(VLVideoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VLVideo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideo>(list);
				}
				else {
					list = (List<VLVideo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v l videos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VLVideo vlVideo : findAll()) {
			remove(vlVideo);
		}
	}

	/**
	 * Returns the number of v l videos.
	 *
	 * @return the number of v l videos
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

				Query q = session.createQuery(_SQL_COUNT_VLVIDEO);

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
	 * Initializes the v l video persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.revotech.portal.videolibrary.model.VLVideo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VLVideo>> listenersList = new ArrayList<ModelListener<VLVideo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VLVideo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VLVideoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VLVIDEO = "SELECT vlVideo FROM VLVideo vlVideo";
	private static final String _SQL_SELECT_VLVIDEO_WHERE = "SELECT vlVideo FROM VLVideo vlVideo WHERE ";
	private static final String _SQL_COUNT_VLVIDEO = "SELECT COUNT(vlVideo) FROM VLVideo vlVideo";
	private static final String _SQL_COUNT_VLVIDEO_WHERE = "SELECT COUNT(vlVideo) FROM VLVideo vlVideo WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "vlVideo.videoId";
	private static final String _FILTER_SQL_SELECT_VLVIDEO_WHERE = "SELECT DISTINCT {vlVideo.*} FROM portal_video vlVideo WHERE ";
	private static final String _FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {portal_video.*} FROM (SELECT DISTINCT vlVideo.videoId FROM portal_video vlVideo WHERE ";
	private static final String _FILTER_SQL_SELECT_VLVIDEO_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN portal_video ON TEMP_TABLE.videoId = portal_video.videoId";
	private static final String _FILTER_SQL_COUNT_VLVIDEO_WHERE = "SELECT COUNT(DISTINCT vlVideo.videoId) AS COUNT_VALUE FROM portal_video vlVideo WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "vlVideo";
	private static final String _FILTER_ENTITY_TABLE = "portal_video";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vlVideo.";
	private static final String _ORDER_BY_ENTITY_TABLE = "portal_video.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VLVideo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VLVideo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VLVideoPersistenceImpl.class);
	private static VLVideo _nullVLVideo = new VLVideoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VLVideo> toCacheModel() {
				return _nullVLVideoCacheModel;
			}
		};

	private static CacheModel<VLVideo> _nullVLVideoCacheModel = new CacheModel<VLVideo>() {
			@Override
			public VLVideo toEntityModel() {
				return _nullVLVideo;
			}
		};
}