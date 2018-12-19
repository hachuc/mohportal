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

import com.viettel.portal.videolibrary.NoSuchVLRelateVideoException;
import com.viettel.portal.videolibrary.model.VLRelateVideo;
import com.viettel.portal.videolibrary.model.impl.VLRelateVideoImpl;
import com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the v l relate video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLRelateVideoPersistence
 * @see VLRelateVideoUtil
 * @generated
 */
public class VLRelateVideoPersistenceImpl extends BasePersistenceImpl<VLRelateVideo>
	implements VLRelateVideoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VLRelateVideoUtil} to access the v l relate video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VLRelateVideoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED,
			VLRelateVideoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED,
			VLRelateVideoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RELATEVIDEO =
		new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED,
			VLRelateVideoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRelateVideo",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELATEVIDEO =
		new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED,
			VLRelateVideoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRelateVideo",
			new String[] { Long.class.getName(), Long.class.getName() },
			VLRelateVideoModelImpl.VIDEOID_COLUMN_BITMASK |
			VLRelateVideoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RELATEVIDEO = new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRelateVideo",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v l relate videos where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @return the matching v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findByRelateVideo(long videoId, long groupId)
		throws SystemException {
		return findByRelateVideo(videoId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l relate videos where videoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l relate videos
	 * @param end the upper bound of the range of v l relate videos (not inclusive)
	 * @return the range of matching v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findByRelateVideo(long videoId, long groupId,
		int start, int end) throws SystemException {
		return findByRelateVideo(videoId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l relate videos where videoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l relate videos
	 * @param end the upper bound of the range of v l relate videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findByRelateVideo(long videoId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELATEVIDEO;
			finderArgs = new Object[] { videoId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RELATEVIDEO;
			finderArgs = new Object[] {
					videoId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VLRelateVideo> list = (List<VLRelateVideo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLRelateVideo vlRelateVideo : list) {
				if ((videoId != vlRelateVideo.getVideoId()) ||
						(groupId != vlRelateVideo.getGroupId())) {
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

			query.append(_SQL_SELECT_VLRELATEVIDEO_WHERE);

			query.append(_FINDER_COLUMN_RELATEVIDEO_VIDEOID_2);

			query.append(_FINDER_COLUMN_RELATEVIDEO_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLRelateVideoModelImpl.ORDER_BY_JPQL);
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
					list = (List<VLRelateVideo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLRelateVideo>(list);
				}
				else {
					list = (List<VLRelateVideo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l relate video
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a matching v l relate video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo findByRelateVideo_First(long videoId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLRelateVideoException, SystemException {
		VLRelateVideo vlRelateVideo = fetchByRelateVideo_First(videoId,
				groupId, orderByComparator);

		if (vlRelateVideo != null) {
			return vlRelateVideo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLRelateVideoException(msg.toString());
	}

	/**
	 * Returns the first v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l relate video, or <code>null</code> if a matching v l relate video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo fetchByRelateVideo_First(long videoId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLRelateVideo> list = findByRelateVideo(videoId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l relate video
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a matching v l relate video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo findByRelateVideo_Last(long videoId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLRelateVideoException, SystemException {
		VLRelateVideo vlRelateVideo = fetchByRelateVideo_Last(videoId, groupId,
				orderByComparator);

		if (vlRelateVideo != null) {
			return vlRelateVideo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLRelateVideoException(msg.toString());
	}

	/**
	 * Returns the last v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l relate video, or <code>null</code> if a matching v l relate video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo fetchByRelateVideo_Last(long videoId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRelateVideo(videoId, groupId);

		if (count == 0) {
			return null;
		}

		List<VLRelateVideo> list = findByRelateVideo(videoId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l relate videos before and after the current v l relate video in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current v l relate video
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l relate video
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo[] findByRelateVideo_PrevAndNext(long id, long videoId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLRelateVideoException, SystemException {
		VLRelateVideo vlRelateVideo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VLRelateVideo[] array = new VLRelateVideoImpl[3];

			array[0] = getByRelateVideo_PrevAndNext(session, vlRelateVideo,
					videoId, groupId, orderByComparator, true);

			array[1] = vlRelateVideo;

			array[2] = getByRelateVideo_PrevAndNext(session, vlRelateVideo,
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

	protected VLRelateVideo getByRelateVideo_PrevAndNext(Session session,
		VLRelateVideo vlRelateVideo, long videoId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLRELATEVIDEO_WHERE);

		query.append(_FINDER_COLUMN_RELATEVIDEO_VIDEOID_2);

		query.append(_FINDER_COLUMN_RELATEVIDEO_GROUPID_2);

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
			query.append(VLRelateVideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlRelateVideo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLRelateVideo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l relate videos where videoId = &#63; and groupId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRelateVideo(long videoId, long groupId)
		throws SystemException {
		for (VLRelateVideo vlRelateVideo : findByRelateVideo(videoId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlRelateVideo);
		}
	}

	/**
	 * Returns the number of v l relate videos where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @return the number of matching v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRelateVideo(long videoId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RELATEVIDEO;

		Object[] finderArgs = new Object[] { videoId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLRELATEVIDEO_WHERE);

			query.append(_FINDER_COLUMN_RELATEVIDEO_VIDEOID_2);

			query.append(_FINDER_COLUMN_RELATEVIDEO_GROUPID_2);

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

	private static final String _FINDER_COLUMN_RELATEVIDEO_VIDEOID_2 = "vlRelateVideo.videoId = ? AND ";
	private static final String _FINDER_COLUMN_RELATEVIDEO_GROUPID_2 = "vlRelateVideo.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED,
			VLRelateVideoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByvideo",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED,
			VLRelateVideoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByvideo",
			new String[] { Long.class.getName(), Long.class.getName() },
			VLRelateVideoModelImpl.RELATEID_COLUMN_BITMASK |
			VLRelateVideoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByvideo",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v l relate videos where relateId = &#63; and groupId = &#63;.
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @return the matching v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findByvideo(long relateId, long groupId)
		throws SystemException {
		return findByvideo(relateId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l relate videos where relateId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l relate videos
	 * @param end the upper bound of the range of v l relate videos (not inclusive)
	 * @return the range of matching v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findByvideo(long relateId, long groupId,
		int start, int end) throws SystemException {
		return findByvideo(relateId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l relate videos where relateId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l relate videos
	 * @param end the upper bound of the range of v l relate videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findByvideo(long relateId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { relateId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] {
					relateId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VLRelateVideo> list = (List<VLRelateVideo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLRelateVideo vlRelateVideo : list) {
				if ((relateId != vlRelateVideo.getRelateId()) ||
						(groupId != vlRelateVideo.getGroupId())) {
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

			query.append(_SQL_SELECT_VLRELATEVIDEO_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_RELATEID_2);

			query.append(_FINDER_COLUMN_VIDEO_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLRelateVideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(relateId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VLRelateVideo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLRelateVideo>(list);
				}
				else {
					list = (List<VLRelateVideo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l relate video
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a matching v l relate video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo findByvideo_First(long relateId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLRelateVideoException, SystemException {
		VLRelateVideo vlRelateVideo = fetchByvideo_First(relateId, groupId,
				orderByComparator);

		if (vlRelateVideo != null) {
			return vlRelateVideo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("relateId=");
		msg.append(relateId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLRelateVideoException(msg.toString());
	}

	/**
	 * Returns the first v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l relate video, or <code>null</code> if a matching v l relate video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo fetchByvideo_First(long relateId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLRelateVideo> list = findByvideo(relateId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l relate video
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a matching v l relate video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo findByvideo_Last(long relateId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLRelateVideoException, SystemException {
		VLRelateVideo vlRelateVideo = fetchByvideo_Last(relateId, groupId,
				orderByComparator);

		if (vlRelateVideo != null) {
			return vlRelateVideo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("relateId=");
		msg.append(relateId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLRelateVideoException(msg.toString());
	}

	/**
	 * Returns the last v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l relate video, or <code>null</code> if a matching v l relate video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo fetchByvideo_Last(long relateId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByvideo(relateId, groupId);

		if (count == 0) {
			return null;
		}

		List<VLRelateVideo> list = findByvideo(relateId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l relate videos before and after the current v l relate video in the ordered set where relateId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current v l relate video
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l relate video
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo[] findByvideo_PrevAndNext(long id, long relateId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLRelateVideoException, SystemException {
		VLRelateVideo vlRelateVideo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VLRelateVideo[] array = new VLRelateVideoImpl[3];

			array[0] = getByvideo_PrevAndNext(session, vlRelateVideo, relateId,
					groupId, orderByComparator, true);

			array[1] = vlRelateVideo;

			array[2] = getByvideo_PrevAndNext(session, vlRelateVideo, relateId,
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

	protected VLRelateVideo getByvideo_PrevAndNext(Session session,
		VLRelateVideo vlRelateVideo, long relateId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLRELATEVIDEO_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_RELATEID_2);

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
			query.append(VLRelateVideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(relateId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlRelateVideo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLRelateVideo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l relate videos where relateId = &#63; and groupId = &#63; from the database.
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByvideo(long relateId, long groupId)
		throws SystemException {
		for (VLRelateVideo vlRelateVideo : findByvideo(relateId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlRelateVideo);
		}
	}

	/**
	 * Returns the number of v l relate videos where relateId = &#63; and groupId = &#63;.
	 *
	 * @param relateId the relate ID
	 * @param groupId the group ID
	 * @return the number of matching v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByvideo(long relateId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { relateId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLRELATEVIDEO_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_RELATEID_2);

			query.append(_FINDER_COLUMN_VIDEO_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(relateId);

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

	private static final String _FINDER_COLUMN_VIDEO_RELATEID_2 = "vlRelateVideo.relateId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEO_GROUPID_2 = "vlRelateVideo.groupId = ?";

	public VLRelateVideoPersistenceImpl() {
		setModelClass(VLRelateVideo.class);
	}

	/**
	 * Caches the v l relate video in the entity cache if it is enabled.
	 *
	 * @param vlRelateVideo the v l relate video
	 */
	@Override
	public void cacheResult(VLRelateVideo vlRelateVideo) {
		EntityCacheUtil.putResult(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoImpl.class, vlRelateVideo.getPrimaryKey(),
			vlRelateVideo);

		vlRelateVideo.resetOriginalValues();
	}

	/**
	 * Caches the v l relate videos in the entity cache if it is enabled.
	 *
	 * @param vlRelateVideos the v l relate videos
	 */
	@Override
	public void cacheResult(List<VLRelateVideo> vlRelateVideos) {
		for (VLRelateVideo vlRelateVideo : vlRelateVideos) {
			if (EntityCacheUtil.getResult(
						VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
						VLRelateVideoImpl.class, vlRelateVideo.getPrimaryKey()) == null) {
				cacheResult(vlRelateVideo);
			}
			else {
				vlRelateVideo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v l relate videos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VLRelateVideoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VLRelateVideoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v l relate video.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VLRelateVideo vlRelateVideo) {
		EntityCacheUtil.removeResult(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoImpl.class, vlRelateVideo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VLRelateVideo> vlRelateVideos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VLRelateVideo vlRelateVideo : vlRelateVideos) {
			EntityCacheUtil.removeResult(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
				VLRelateVideoImpl.class, vlRelateVideo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v l relate video with the primary key. Does not add the v l relate video to the database.
	 *
	 * @param id the primary key for the new v l relate video
	 * @return the new v l relate video
	 */
	@Override
	public VLRelateVideo create(long id) {
		VLRelateVideo vlRelateVideo = new VLRelateVideoImpl();

		vlRelateVideo.setNew(true);
		vlRelateVideo.setPrimaryKey(id);

		return vlRelateVideo;
	}

	/**
	 * Removes the v l relate video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the v l relate video
	 * @return the v l relate video that was removed
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo remove(long id)
		throws NoSuchVLRelateVideoException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the v l relate video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v l relate video
	 * @return the v l relate video that was removed
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo remove(Serializable primaryKey)
		throws NoSuchVLRelateVideoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VLRelateVideo vlRelateVideo = (VLRelateVideo)session.get(VLRelateVideoImpl.class,
					primaryKey);

			if (vlRelateVideo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVLRelateVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vlRelateVideo);
		}
		catch (NoSuchVLRelateVideoException nsee) {
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
	protected VLRelateVideo removeImpl(VLRelateVideo vlRelateVideo)
		throws SystemException {
		vlRelateVideo = toUnwrappedModel(vlRelateVideo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vlRelateVideo)) {
				vlRelateVideo = (VLRelateVideo)session.get(VLRelateVideoImpl.class,
						vlRelateVideo.getPrimaryKeyObj());
			}

			if (vlRelateVideo != null) {
				session.delete(vlRelateVideo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vlRelateVideo != null) {
			clearCache(vlRelateVideo);
		}

		return vlRelateVideo;
	}

	@Override
	public VLRelateVideo updateImpl(
		com.viettel.portal.videolibrary.model.VLRelateVideo vlRelateVideo)
		throws SystemException {
		vlRelateVideo = toUnwrappedModel(vlRelateVideo);

		boolean isNew = vlRelateVideo.isNew();

		VLRelateVideoModelImpl vlRelateVideoModelImpl = (VLRelateVideoModelImpl)vlRelateVideo;

		Session session = null;

		try {
			session = openSession();

			if (vlRelateVideo.isNew()) {
				session.save(vlRelateVideo);

				vlRelateVideo.setNew(false);
			}
			else {
				session.merge(vlRelateVideo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VLRelateVideoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vlRelateVideoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELATEVIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlRelateVideoModelImpl.getOriginalVideoId(),
						vlRelateVideoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RELATEVIDEO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELATEVIDEO,
					args);

				args = new Object[] {
						vlRelateVideoModelImpl.getVideoId(),
						vlRelateVideoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RELATEVIDEO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELATEVIDEO,
					args);
			}

			if ((vlRelateVideoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlRelateVideoModelImpl.getOriginalRelateId(),
						vlRelateVideoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] {
						vlRelateVideoModelImpl.getRelateId(),
						vlRelateVideoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}
		}

		EntityCacheUtil.putResult(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
			VLRelateVideoImpl.class, vlRelateVideo.getPrimaryKey(),
			vlRelateVideo);

		return vlRelateVideo;
	}

	protected VLRelateVideo toUnwrappedModel(VLRelateVideo vlRelateVideo) {
		if (vlRelateVideo instanceof VLRelateVideoImpl) {
			return vlRelateVideo;
		}

		VLRelateVideoImpl vlRelateVideoImpl = new VLRelateVideoImpl();

		vlRelateVideoImpl.setNew(vlRelateVideo.isNew());
		vlRelateVideoImpl.setPrimaryKey(vlRelateVideo.getPrimaryKey());

		vlRelateVideoImpl.setId(vlRelateVideo.getId());
		vlRelateVideoImpl.setVideoId(vlRelateVideo.getVideoId());
		vlRelateVideoImpl.setRelateId(vlRelateVideo.getRelateId());
		vlRelateVideoImpl.setGroupId(vlRelateVideo.getGroupId());

		return vlRelateVideoImpl;
	}

	/**
	 * Returns the v l relate video with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l relate video
	 * @return the v l relate video
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVLRelateVideoException, SystemException {
		VLRelateVideo vlRelateVideo = fetchByPrimaryKey(primaryKey);

		if (vlRelateVideo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVLRelateVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vlRelateVideo;
	}

	/**
	 * Returns the v l relate video with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVLRelateVideoException} if it could not be found.
	 *
	 * @param id the primary key of the v l relate video
	 * @return the v l relate video
	 * @throws com.viettel.portal.videolibrary.NoSuchVLRelateVideoException if a v l relate video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo findByPrimaryKey(long id)
		throws NoSuchVLRelateVideoException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the v l relate video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l relate video
	 * @return the v l relate video, or <code>null</code> if a v l relate video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VLRelateVideo vlRelateVideo = (VLRelateVideo)EntityCacheUtil.getResult(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
				VLRelateVideoImpl.class, primaryKey);

		if (vlRelateVideo == _nullVLRelateVideo) {
			return null;
		}

		if (vlRelateVideo == null) {
			Session session = null;

			try {
				session = openSession();

				vlRelateVideo = (VLRelateVideo)session.get(VLRelateVideoImpl.class,
						primaryKey);

				if (vlRelateVideo != null) {
					cacheResult(vlRelateVideo);
				}
				else {
					EntityCacheUtil.putResult(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
						VLRelateVideoImpl.class, primaryKey, _nullVLRelateVideo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VLRelateVideoModelImpl.ENTITY_CACHE_ENABLED,
					VLRelateVideoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vlRelateVideo;
	}

	/**
	 * Returns the v l relate video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the v l relate video
	 * @return the v l relate video, or <code>null</code> if a v l relate video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLRelateVideo fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the v l relate videos.
	 *
	 * @return the v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l relate videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l relate videos
	 * @param end the upper bound of the range of v l relate videos (not inclusive)
	 * @return the range of v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l relate videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLRelateVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l relate videos
	 * @param end the upper bound of the range of v l relate videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v l relate videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLRelateVideo> findAll(int start, int end,
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

		List<VLRelateVideo> list = (List<VLRelateVideo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VLRELATEVIDEO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VLRELATEVIDEO;

				if (pagination) {
					sql = sql.concat(VLRelateVideoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VLRelateVideo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLRelateVideo>(list);
				}
				else {
					list = (List<VLRelateVideo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v l relate videos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VLRelateVideo vlRelateVideo : findAll()) {
			remove(vlRelateVideo);
		}
	}

	/**
	 * Returns the number of v l relate videos.
	 *
	 * @return the number of v l relate videos
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

				Query q = session.createQuery(_SQL_COUNT_VLRELATEVIDEO);

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
	 * Initializes the v l relate video persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.videolibrary.model.VLRelateVideo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VLRelateVideo>> listenersList = new ArrayList<ModelListener<VLRelateVideo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VLRelateVideo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VLRelateVideoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VLRELATEVIDEO = "SELECT vlRelateVideo FROM VLRelateVideo vlRelateVideo";
	private static final String _SQL_SELECT_VLRELATEVIDEO_WHERE = "SELECT vlRelateVideo FROM VLRelateVideo vlRelateVideo WHERE ";
	private static final String _SQL_COUNT_VLRELATEVIDEO = "SELECT COUNT(vlRelateVideo) FROM VLRelateVideo vlRelateVideo";
	private static final String _SQL_COUNT_VLRELATEVIDEO_WHERE = "SELECT COUNT(vlRelateVideo) FROM VLRelateVideo vlRelateVideo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vlRelateVideo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VLRelateVideo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VLRelateVideo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VLRelateVideoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static VLRelateVideo _nullVLRelateVideo = new VLRelateVideoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VLRelateVideo> toCacheModel() {
				return _nullVLRelateVideoCacheModel;
			}
		};

	private static CacheModel<VLRelateVideo> _nullVLRelateVideoCacheModel = new CacheModel<VLRelateVideo>() {
			@Override
			public VLRelateVideo toEntityModel() {
				return _nullVLRelateVideo;
			}
		};
}