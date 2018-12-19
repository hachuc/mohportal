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

import com.viettel.portal.videolibrary.NoSuchVLVideoTagException;
import com.viettel.portal.videolibrary.model.VLVideoTag;
import com.viettel.portal.videolibrary.model.impl.VLVideoTagImpl;
import com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the v l video tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLVideoTagPersistence
 * @see VLVideoTagUtil
 * @generated
 */
public class VLVideoTagPersistenceImpl extends BasePersistenceImpl<VLVideoTag>
	implements VLVideoTagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VLVideoTagUtil} to access the v l video tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VLVideoTagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, VLVideoTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, VLVideoTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGS = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, VLVideoTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTags",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGS = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, VLVideoTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTags",
			new String[] { Long.class.getName(), Long.class.getName() },
			VLVideoTagModelImpl.VIDEOID_COLUMN_BITMASK |
			VLVideoTagModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAGS = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTags",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v l video tags where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @return the matching v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findByTags(long videoId, long groupId)
		throws SystemException {
		return findByTags(videoId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l video tags where videoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l video tags
	 * @param end the upper bound of the range of v l video tags (not inclusive)
	 * @return the range of matching v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findByTags(long videoId, long groupId, int start,
		int end) throws SystemException {
		return findByTags(videoId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l video tags where videoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l video tags
	 * @param end the upper bound of the range of v l video tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findByTags(long videoId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGS;
			finderArgs = new Object[] { videoId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGS;
			finderArgs = new Object[] {
					videoId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VLVideoTag> list = (List<VLVideoTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLVideoTag vlVideoTag : list) {
				if ((videoId != vlVideoTag.getVideoId()) ||
						(groupId != vlVideoTag.getGroupId())) {
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

			query.append(_SQL_SELECT_VLVIDEOTAG_WHERE);

			query.append(_FINDER_COLUMN_TAGS_VIDEOID_2);

			query.append(_FINDER_COLUMN_TAGS_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLVideoTagModelImpl.ORDER_BY_JPQL);
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
					list = (List<VLVideoTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideoTag>(list);
				}
				else {
					list = (List<VLVideoTag>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l video tag in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video tag
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a matching v l video tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag findByTags_First(long videoId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoTagException, SystemException {
		VLVideoTag vlVideoTag = fetchByTags_First(videoId, groupId,
				orderByComparator);

		if (vlVideoTag != null) {
			return vlVideoTag;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoTagException(msg.toString());
	}

	/**
	 * Returns the first v l video tag in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video tag, or <code>null</code> if a matching v l video tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag fetchByTags_First(long videoId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLVideoTag> list = findByTags(videoId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l video tag in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video tag
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a matching v l video tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag findByTags_Last(long videoId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoTagException, SystemException {
		VLVideoTag vlVideoTag = fetchByTags_Last(videoId, groupId,
				orderByComparator);

		if (vlVideoTag != null) {
			return vlVideoTag;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoTagException(msg.toString());
	}

	/**
	 * Returns the last v l video tag in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video tag, or <code>null</code> if a matching v l video tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag fetchByTags_Last(long videoId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTags(videoId, groupId);

		if (count == 0) {
			return null;
		}

		List<VLVideoTag> list = findByTags(videoId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l video tags before and after the current v l video tag in the ordered set where videoId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current v l video tag
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l video tag
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag[] findByTags_PrevAndNext(long id, long videoId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLVideoTagException, SystemException {
		VLVideoTag vlVideoTag = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VLVideoTag[] array = new VLVideoTagImpl[3];

			array[0] = getByTags_PrevAndNext(session, vlVideoTag, videoId,
					groupId, orderByComparator, true);

			array[1] = vlVideoTag;

			array[2] = getByTags_PrevAndNext(session, vlVideoTag, videoId,
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

	protected VLVideoTag getByTags_PrevAndNext(Session session,
		VLVideoTag vlVideoTag, long videoId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLVIDEOTAG_WHERE);

		query.append(_FINDER_COLUMN_TAGS_VIDEOID_2);

		query.append(_FINDER_COLUMN_TAGS_GROUPID_2);

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
			query.append(VLVideoTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlVideoTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLVideoTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l video tags where videoId = &#63; and groupId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTags(long videoId, long groupId)
		throws SystemException {
		for (VLVideoTag vlVideoTag : findByTags(videoId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlVideoTag);
		}
	}

	/**
	 * Returns the number of v l video tags where videoId = &#63; and groupId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param groupId the group ID
	 * @return the number of matching v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTags(long videoId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAGS;

		Object[] finderArgs = new Object[] { videoId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLVIDEOTAG_WHERE);

			query.append(_FINDER_COLUMN_TAGS_VIDEOID_2);

			query.append(_FINDER_COLUMN_TAGS_GROUPID_2);

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

	private static final String _FINDER_COLUMN_TAGS_VIDEOID_2 = "vlVideoTag.videoId = ? AND ";
	private static final String _FINDER_COLUMN_TAGS_GROUPID_2 = "vlVideoTag.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, VLVideoTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, VLVideoTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName(), Long.class.getName() },
			VLVideoTagModelImpl.TAGID_COLUMN_BITMASK |
			VLVideoTagModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v l video tags where tagId = &#63; and groupId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @return the matching v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findByVideo(long tagId, long groupId)
		throws SystemException {
		return findByVideo(tagId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l video tags where tagId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l video tags
	 * @param end the upper bound of the range of v l video tags (not inclusive)
	 * @return the range of matching v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findByVideo(long tagId, long groupId, int start,
		int end) throws SystemException {
		return findByVideo(tagId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l video tags where tagId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l video tags
	 * @param end the upper bound of the range of v l video tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findByVideo(long tagId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { tagId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] {
					tagId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VLVideoTag> list = (List<VLVideoTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VLVideoTag vlVideoTag : list) {
				if ((tagId != vlVideoTag.getTagId()) ||
						(groupId != vlVideoTag.getGroupId())) {
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

			query.append(_SQL_SELECT_VLVIDEOTAG_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_TAGID_2);

			query.append(_FINDER_COLUMN_VIDEO_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VLVideoTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tagId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VLVideoTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideoTag>(list);
				}
				else {
					list = (List<VLVideoTag>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v l video tag in the ordered set where tagId = &#63; and groupId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video tag
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a matching v l video tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag findByVideo_First(long tagId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoTagException, SystemException {
		VLVideoTag vlVideoTag = fetchByVideo_First(tagId, groupId,
				orderByComparator);

		if (vlVideoTag != null) {
			return vlVideoTag;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagId=");
		msg.append(tagId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoTagException(msg.toString());
	}

	/**
	 * Returns the first v l video tag in the ordered set where tagId = &#63; and groupId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v l video tag, or <code>null</code> if a matching v l video tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag fetchByVideo_First(long tagId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VLVideoTag> list = findByVideo(tagId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v l video tag in the ordered set where tagId = &#63; and groupId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video tag
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a matching v l video tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag findByVideo_Last(long tagId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVLVideoTagException, SystemException {
		VLVideoTag vlVideoTag = fetchByVideo_Last(tagId, groupId,
				orderByComparator);

		if (vlVideoTag != null) {
			return vlVideoTag;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagId=");
		msg.append(tagId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVLVideoTagException(msg.toString());
	}

	/**
	 * Returns the last v l video tag in the ordered set where tagId = &#63; and groupId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v l video tag, or <code>null</code> if a matching v l video tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag fetchByVideo_Last(long tagId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(tagId, groupId);

		if (count == 0) {
			return null;
		}

		List<VLVideoTag> list = findByVideo(tagId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v l video tags before and after the current v l video tag in the ordered set where tagId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current v l video tag
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v l video tag
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag[] findByVideo_PrevAndNext(long id, long tagId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVLVideoTagException, SystemException {
		VLVideoTag vlVideoTag = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VLVideoTag[] array = new VLVideoTagImpl[3];

			array[0] = getByVideo_PrevAndNext(session, vlVideoTag, tagId,
					groupId, orderByComparator, true);

			array[1] = vlVideoTag;

			array[2] = getByVideo_PrevAndNext(session, vlVideoTag, tagId,
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

	protected VLVideoTag getByVideo_PrevAndNext(Session session,
		VLVideoTag vlVideoTag, long tagId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VLVIDEOTAG_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_TAGID_2);

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
			query.append(VLVideoTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tagId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vlVideoTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VLVideoTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v l video tags where tagId = &#63; and groupId = &#63; from the database.
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long tagId, long groupId)
		throws SystemException {
		for (VLVideoTag vlVideoTag : findByVideo(tagId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vlVideoTag);
		}
	}

	/**
	 * Returns the number of v l video tags where tagId = &#63; and groupId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param groupId the group ID
	 * @return the number of matching v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideo(long tagId, long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { tagId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VLVIDEOTAG_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_TAGID_2);

			query.append(_FINDER_COLUMN_VIDEO_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tagId);

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

	private static final String _FINDER_COLUMN_VIDEO_TAGID_2 = "vlVideoTag.tagId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEO_GROUPID_2 = "vlVideoTag.groupId = ?";

	public VLVideoTagPersistenceImpl() {
		setModelClass(VLVideoTag.class);
	}

	/**
	 * Caches the v l video tag in the entity cache if it is enabled.
	 *
	 * @param vlVideoTag the v l video tag
	 */
	@Override
	public void cacheResult(VLVideoTag vlVideoTag) {
		EntityCacheUtil.putResult(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagImpl.class, vlVideoTag.getPrimaryKey(), vlVideoTag);

		vlVideoTag.resetOriginalValues();
	}

	/**
	 * Caches the v l video tags in the entity cache if it is enabled.
	 *
	 * @param vlVideoTags the v l video tags
	 */
	@Override
	public void cacheResult(List<VLVideoTag> vlVideoTags) {
		for (VLVideoTag vlVideoTag : vlVideoTags) {
			if (EntityCacheUtil.getResult(
						VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
						VLVideoTagImpl.class, vlVideoTag.getPrimaryKey()) == null) {
				cacheResult(vlVideoTag);
			}
			else {
				vlVideoTag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v l video tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VLVideoTagImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VLVideoTagImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v l video tag.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VLVideoTag vlVideoTag) {
		EntityCacheUtil.removeResult(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagImpl.class, vlVideoTag.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VLVideoTag> vlVideoTags) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VLVideoTag vlVideoTag : vlVideoTags) {
			EntityCacheUtil.removeResult(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
				VLVideoTagImpl.class, vlVideoTag.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v l video tag with the primary key. Does not add the v l video tag to the database.
	 *
	 * @param id the primary key for the new v l video tag
	 * @return the new v l video tag
	 */
	@Override
	public VLVideoTag create(long id) {
		VLVideoTag vlVideoTag = new VLVideoTagImpl();

		vlVideoTag.setNew(true);
		vlVideoTag.setPrimaryKey(id);

		return vlVideoTag;
	}

	/**
	 * Removes the v l video tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the v l video tag
	 * @return the v l video tag that was removed
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag remove(long id)
		throws NoSuchVLVideoTagException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the v l video tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v l video tag
	 * @return the v l video tag that was removed
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag remove(Serializable primaryKey)
		throws NoSuchVLVideoTagException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VLVideoTag vlVideoTag = (VLVideoTag)session.get(VLVideoTagImpl.class,
					primaryKey);

			if (vlVideoTag == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVLVideoTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vlVideoTag);
		}
		catch (NoSuchVLVideoTagException nsee) {
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
	protected VLVideoTag removeImpl(VLVideoTag vlVideoTag)
		throws SystemException {
		vlVideoTag = toUnwrappedModel(vlVideoTag);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vlVideoTag)) {
				vlVideoTag = (VLVideoTag)session.get(VLVideoTagImpl.class,
						vlVideoTag.getPrimaryKeyObj());
			}

			if (vlVideoTag != null) {
				session.delete(vlVideoTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vlVideoTag != null) {
			clearCache(vlVideoTag);
		}

		return vlVideoTag;
	}

	@Override
	public VLVideoTag updateImpl(
		com.viettel.portal.videolibrary.model.VLVideoTag vlVideoTag)
		throws SystemException {
		vlVideoTag = toUnwrappedModel(vlVideoTag);

		boolean isNew = vlVideoTag.isNew();

		VLVideoTagModelImpl vlVideoTagModelImpl = (VLVideoTagModelImpl)vlVideoTag;

		Session session = null;

		try {
			session = openSession();

			if (vlVideoTag.isNew()) {
				session.save(vlVideoTag);

				vlVideoTag.setNew(false);
			}
			else {
				session.merge(vlVideoTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VLVideoTagModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vlVideoTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlVideoTagModelImpl.getOriginalVideoId(),
						vlVideoTagModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGS,
					args);

				args = new Object[] {
						vlVideoTagModelImpl.getVideoId(),
						vlVideoTagModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGS,
					args);
			}

			if ((vlVideoTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vlVideoTagModelImpl.getOriginalTagId(),
						vlVideoTagModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] {
						vlVideoTagModelImpl.getTagId(),
						vlVideoTagModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}
		}

		EntityCacheUtil.putResult(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
			VLVideoTagImpl.class, vlVideoTag.getPrimaryKey(), vlVideoTag);

		return vlVideoTag;
	}

	protected VLVideoTag toUnwrappedModel(VLVideoTag vlVideoTag) {
		if (vlVideoTag instanceof VLVideoTagImpl) {
			return vlVideoTag;
		}

		VLVideoTagImpl vlVideoTagImpl = new VLVideoTagImpl();

		vlVideoTagImpl.setNew(vlVideoTag.isNew());
		vlVideoTagImpl.setPrimaryKey(vlVideoTag.getPrimaryKey());

		vlVideoTagImpl.setId(vlVideoTag.getId());
		vlVideoTagImpl.setVideoId(vlVideoTag.getVideoId());
		vlVideoTagImpl.setTagId(vlVideoTag.getTagId());
		vlVideoTagImpl.setGroupId(vlVideoTag.getGroupId());

		return vlVideoTagImpl;
	}

	/**
	 * Returns the v l video tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l video tag
	 * @return the v l video tag
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVLVideoTagException, SystemException {
		VLVideoTag vlVideoTag = fetchByPrimaryKey(primaryKey);

		if (vlVideoTag == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVLVideoTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vlVideoTag;
	}

	/**
	 * Returns the v l video tag with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVLVideoTagException} if it could not be found.
	 *
	 * @param id the primary key of the v l video tag
	 * @return the v l video tag
	 * @throws com.viettel.portal.videolibrary.NoSuchVLVideoTagException if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag findByPrimaryKey(long id)
		throws NoSuchVLVideoTagException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the v l video tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v l video tag
	 * @return the v l video tag, or <code>null</code> if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VLVideoTag vlVideoTag = (VLVideoTag)EntityCacheUtil.getResult(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
				VLVideoTagImpl.class, primaryKey);

		if (vlVideoTag == _nullVLVideoTag) {
			return null;
		}

		if (vlVideoTag == null) {
			Session session = null;

			try {
				session = openSession();

				vlVideoTag = (VLVideoTag)session.get(VLVideoTagImpl.class,
						primaryKey);

				if (vlVideoTag != null) {
					cacheResult(vlVideoTag);
				}
				else {
					EntityCacheUtil.putResult(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
						VLVideoTagImpl.class, primaryKey, _nullVLVideoTag);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VLVideoTagModelImpl.ENTITY_CACHE_ENABLED,
					VLVideoTagImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vlVideoTag;
	}

	/**
	 * Returns the v l video tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the v l video tag
	 * @return the v l video tag, or <code>null</code> if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the v l video tags.
	 *
	 * @return the v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v l video tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l video tags
	 * @param end the upper bound of the range of v l video tags (not inclusive)
	 * @return the range of v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v l video tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l video tags
	 * @param end the upper bound of the range of v l video tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> findAll(int start, int end,
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

		List<VLVideoTag> list = (List<VLVideoTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VLVIDEOTAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VLVIDEOTAG;

				if (pagination) {
					sql = sql.concat(VLVideoTagModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VLVideoTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VLVideoTag>(list);
				}
				else {
					list = (List<VLVideoTag>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v l video tags from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VLVideoTag vlVideoTag : findAll()) {
			remove(vlVideoTag);
		}
	}

	/**
	 * Returns the number of v l video tags.
	 *
	 * @return the number of v l video tags
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

				Query q = session.createQuery(_SQL_COUNT_VLVIDEOTAG);

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
	 * Initializes the v l video tag persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.videolibrary.model.VLVideoTag")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VLVideoTag>> listenersList = new ArrayList<ModelListener<VLVideoTag>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VLVideoTag>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VLVideoTagImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VLVIDEOTAG = "SELECT vlVideoTag FROM VLVideoTag vlVideoTag";
	private static final String _SQL_SELECT_VLVIDEOTAG_WHERE = "SELECT vlVideoTag FROM VLVideoTag vlVideoTag WHERE ";
	private static final String _SQL_COUNT_VLVIDEOTAG = "SELECT COUNT(vlVideoTag) FROM VLVideoTag vlVideoTag";
	private static final String _SQL_COUNT_VLVIDEOTAG_WHERE = "SELECT COUNT(vlVideoTag) FROM VLVideoTag vlVideoTag WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vlVideoTag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VLVideoTag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VLVideoTag exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VLVideoTagPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static VLVideoTag _nullVLVideoTag = new VLVideoTagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VLVideoTag> toCacheModel() {
				return _nullVLVideoTagCacheModel;
			}
		};

	private static CacheModel<VLVideoTag> _nullVLVideoTagCacheModel = new CacheModel<VLVideoTag>() {
			@Override
			public VLVideoTag toEntityModel() {
				return _nullVLVideoTag;
			}
		};
}