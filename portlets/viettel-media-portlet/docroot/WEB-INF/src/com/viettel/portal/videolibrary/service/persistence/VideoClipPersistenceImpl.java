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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.videolibrary.NoSuchVideoClipException;
import com.viettel.portal.videolibrary.model.VideoClip;
import com.viettel.portal.videolibrary.model.impl.VideoClipImpl;
import com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video clip service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VideoClipPersistence
 * @see VideoClipUtil
 * @generated
 */
public class VideoClipPersistenceImpl extends BasePersistenceImpl<VideoClip>
	implements VideoClipPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoClipUtil} to access the video clip persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoClipImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipModelImpl.FINDER_CACHE_ENABLED, VideoClipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipModelImpl.FINDER_CACHE_ENABLED, VideoClipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipModelImpl.FINDER_CACHE_ENABLED, VideoClipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryID",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipModelImpl.FINDER_CACHE_ENABLED, VideoClipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryID",
			new String[] { Integer.class.getName() },
			VideoClipModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryID",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the video clips where CategoryID = &#63;.
	 *
	 * @param CategoryID the category i d
	 * @return the matching video clips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoClip> findByCategoryID(int CategoryID)
		throws SystemException {
		return findByCategoryID(CategoryID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video clips where CategoryID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CategoryID the category i d
	 * @param start the lower bound of the range of video clips
	 * @param end the upper bound of the range of video clips (not inclusive)
	 * @return the range of matching video clips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoClip> findByCategoryID(int CategoryID, int start, int end)
		throws SystemException {
		return findByCategoryID(CategoryID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video clips where CategoryID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CategoryID the category i d
	 * @param start the lower bound of the range of video clips
	 * @param end the upper bound of the range of video clips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video clips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoClip> findByCategoryID(int CategoryID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { CategoryID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { CategoryID, start, end, orderByComparator };
		}

		List<VideoClip> list = (List<VideoClip>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VideoClip videoClip : list) {
				if ((CategoryID != videoClip.getCategoryID())) {
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

			query.append(_SQL_SELECT_VIDEOCLIP_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoClipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CategoryID);

				if (!pagination) {
					list = (List<VideoClip>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VideoClip>(list);
				}
				else {
					list = (List<VideoClip>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video clip in the ordered set where CategoryID = &#63;.
	 *
	 * @param CategoryID the category i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video clip
	 * @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a matching video clip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip findByCategoryID_First(int CategoryID,
		OrderByComparator orderByComparator)
		throws NoSuchVideoClipException, SystemException {
		VideoClip videoClip = fetchByCategoryID_First(CategoryID,
				orderByComparator);

		if (videoClip != null) {
			return videoClip;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("CategoryID=");
		msg.append(CategoryID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoClipException(msg.toString());
	}

	/**
	 * Returns the first video clip in the ordered set where CategoryID = &#63;.
	 *
	 * @param CategoryID the category i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video clip, or <code>null</code> if a matching video clip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip fetchByCategoryID_First(int CategoryID,
		OrderByComparator orderByComparator) throws SystemException {
		List<VideoClip> list = findByCategoryID(CategoryID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video clip in the ordered set where CategoryID = &#63;.
	 *
	 * @param CategoryID the category i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video clip
	 * @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a matching video clip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip findByCategoryID_Last(int CategoryID,
		OrderByComparator orderByComparator)
		throws NoSuchVideoClipException, SystemException {
		VideoClip videoClip = fetchByCategoryID_Last(CategoryID,
				orderByComparator);

		if (videoClip != null) {
			return videoClip;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("CategoryID=");
		msg.append(CategoryID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoClipException(msg.toString());
	}

	/**
	 * Returns the last video clip in the ordered set where CategoryID = &#63;.
	 *
	 * @param CategoryID the category i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video clip, or <code>null</code> if a matching video clip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip fetchByCategoryID_Last(int CategoryID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryID(CategoryID);

		if (count == 0) {
			return null;
		}

		List<VideoClip> list = findByCategoryID(CategoryID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video clips before and after the current video clip in the ordered set where CategoryID = &#63;.
	 *
	 * @param ID the primary key of the current video clip
	 * @param CategoryID the category i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video clip
	 * @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip[] findByCategoryID_PrevAndNext(int ID, int CategoryID,
		OrderByComparator orderByComparator)
		throws NoSuchVideoClipException, SystemException {
		VideoClip videoClip = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			VideoClip[] array = new VideoClipImpl[3];

			array[0] = getByCategoryID_PrevAndNext(session, videoClip,
					CategoryID, orderByComparator, true);

			array[1] = videoClip;

			array[2] = getByCategoryID_PrevAndNext(session, videoClip,
					CategoryID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoClip getByCategoryID_PrevAndNext(Session session,
		VideoClip videoClip, int CategoryID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOCLIP_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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
			query.append(VideoClipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(CategoryID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoClip);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoClip> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video clips where CategoryID = &#63; from the database.
	 *
	 * @param CategoryID the category i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryID(int CategoryID) throws SystemException {
		for (VideoClip videoClip : findByCategoryID(CategoryID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(videoClip);
		}
	}

	/**
	 * Returns the number of video clips where CategoryID = &#63;.
	 *
	 * @param CategoryID the category i d
	 * @return the number of matching video clips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryID(int CategoryID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYID;

		Object[] finderArgs = new Object[] { CategoryID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOCLIP_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CategoryID);

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

	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "videoClip.CategoryID = ?";

	public VideoClipPersistenceImpl() {
		setModelClass(VideoClip.class);
	}

	/**
	 * Caches the video clip in the entity cache if it is enabled.
	 *
	 * @param videoClip the video clip
	 */
	@Override
	public void cacheResult(VideoClip videoClip) {
		EntityCacheUtil.putResult(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipImpl.class, videoClip.getPrimaryKey(), videoClip);

		videoClip.resetOriginalValues();
	}

	/**
	 * Caches the video clips in the entity cache if it is enabled.
	 *
	 * @param videoClips the video clips
	 */
	@Override
	public void cacheResult(List<VideoClip> videoClips) {
		for (VideoClip videoClip : videoClips) {
			if (EntityCacheUtil.getResult(
						VideoClipModelImpl.ENTITY_CACHE_ENABLED,
						VideoClipImpl.class, videoClip.getPrimaryKey()) == null) {
				cacheResult(videoClip);
			}
			else {
				videoClip.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video clips.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoClipImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoClipImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video clip.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoClip videoClip) {
		EntityCacheUtil.removeResult(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipImpl.class, videoClip.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoClip> videoClips) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoClip videoClip : videoClips) {
			EntityCacheUtil.removeResult(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
				VideoClipImpl.class, videoClip.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video clip with the primary key. Does not add the video clip to the database.
	 *
	 * @param ID the primary key for the new video clip
	 * @return the new video clip
	 */
	@Override
	public VideoClip create(int ID) {
		VideoClip videoClip = new VideoClipImpl();

		videoClip.setNew(true);
		videoClip.setPrimaryKey(ID);

		return videoClip;
	}

	/**
	 * Removes the video clip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the video clip
	 * @return the video clip that was removed
	 * @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip remove(int ID)
		throws NoSuchVideoClipException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the video clip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video clip
	 * @return the video clip that was removed
	 * @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip remove(Serializable primaryKey)
		throws NoSuchVideoClipException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoClip videoClip = (VideoClip)session.get(VideoClipImpl.class,
					primaryKey);

			if (videoClip == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoClipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoClip);
		}
		catch (NoSuchVideoClipException nsee) {
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
	protected VideoClip removeImpl(VideoClip videoClip)
		throws SystemException {
		videoClip = toUnwrappedModel(videoClip);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(videoClip)) {
				videoClip = (VideoClip)session.get(VideoClipImpl.class,
						videoClip.getPrimaryKeyObj());
			}

			if (videoClip != null) {
				session.delete(videoClip);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (videoClip != null) {
			clearCache(videoClip);
		}

		return videoClip;
	}

	@Override
	public VideoClip updateImpl(
		com.viettel.portal.videolibrary.model.VideoClip videoClip)
		throws SystemException {
		videoClip = toUnwrappedModel(videoClip);

		boolean isNew = videoClip.isNew();

		VideoClipModelImpl videoClipModelImpl = (VideoClipModelImpl)videoClip;

		Session session = null;

		try {
			session = openSession();

			if (videoClip.isNew()) {
				session.save(videoClip);

				videoClip.setNew(false);
			}
			else {
				session.merge(videoClip);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoClipModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoClipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoClipModelImpl.getOriginalCategoryID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);

				args = new Object[] { videoClipModelImpl.getCategoryID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
			VideoClipImpl.class, videoClip.getPrimaryKey(), videoClip);

		return videoClip;
	}

	protected VideoClip toUnwrappedModel(VideoClip videoClip) {
		if (videoClip instanceof VideoClipImpl) {
			return videoClip;
		}

		VideoClipImpl videoClipImpl = new VideoClipImpl();

		videoClipImpl.setNew(videoClip.isNew());
		videoClipImpl.setPrimaryKey(videoClip.getPrimaryKey());

		videoClipImpl.setID(videoClip.getID());
		videoClipImpl.setName(videoClip.getName());
		videoClipImpl.setCategoryID(videoClip.getCategoryID());
		videoClipImpl.setDescription(videoClip.getDescription());
		videoClipImpl.setImageUrl(videoClip.getImageUrl());
		videoClipImpl.setVideoUrl(videoClip.getVideoUrl());
		videoClipImpl.setDuration(videoClip.getDuration());
		videoClipImpl.setViewCount(videoClip.getViewCount());
		videoClipImpl.setStatus(videoClip.getStatus());
		videoClipImpl.setCreationDate(videoClip.getCreationDate());
		videoClipImpl.setModifiedDate(videoClip.getModifiedDate());

		return videoClipImpl;
	}

	/**
	 * Returns the video clip with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video clip
	 * @return the video clip
	 * @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoClipException, SystemException {
		VideoClip videoClip = fetchByPrimaryKey(primaryKey);

		if (videoClip == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoClipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return videoClip;
	}

	/**
	 * Returns the video clip with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVideoClipException} if it could not be found.
	 *
	 * @param ID the primary key of the video clip
	 * @return the video clip
	 * @throws com.viettel.portal.videolibrary.NoSuchVideoClipException if a video clip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip findByPrimaryKey(int ID)
		throws NoSuchVideoClipException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the video clip with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video clip
	 * @return the video clip, or <code>null</code> if a video clip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VideoClip videoClip = (VideoClip)EntityCacheUtil.getResult(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
				VideoClipImpl.class, primaryKey);

		if (videoClip == _nullVideoClip) {
			return null;
		}

		if (videoClip == null) {
			Session session = null;

			try {
				session = openSession();

				videoClip = (VideoClip)session.get(VideoClipImpl.class,
						primaryKey);

				if (videoClip != null) {
					cacheResult(videoClip);
				}
				else {
					EntityCacheUtil.putResult(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
						VideoClipImpl.class, primaryKey, _nullVideoClip);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VideoClipModelImpl.ENTITY_CACHE_ENABLED,
					VideoClipImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return videoClip;
	}

	/**
	 * Returns the video clip with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the video clip
	 * @return the video clip, or <code>null</code> if a video clip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoClip fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the video clips.
	 *
	 * @return the video clips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoClip> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video clips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video clips
	 * @param end the upper bound of the range of video clips (not inclusive)
	 * @return the range of video clips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoClip> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video clips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoClipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video clips
	 * @param end the upper bound of the range of video clips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video clips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoClip> findAll(int start, int end,
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

		List<VideoClip> list = (List<VideoClip>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOCLIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOCLIP;

				if (pagination) {
					sql = sql.concat(VideoClipModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VideoClip>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VideoClip>(list);
				}
				else {
					list = (List<VideoClip>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the video clips from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VideoClip videoClip : findAll()) {
			remove(videoClip);
		}
	}

	/**
	 * Returns the number of video clips.
	 *
	 * @return the number of video clips
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

				Query q = session.createQuery(_SQL_COUNT_VIDEOCLIP);

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
	 * Initializes the video clip persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.videolibrary.model.VideoClip")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoClip>> listenersList = new ArrayList<ModelListener<VideoClip>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoClip>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoClipImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEOCLIP = "SELECT videoClip FROM VideoClip videoClip";
	private static final String _SQL_SELECT_VIDEOCLIP_WHERE = "SELECT videoClip FROM VideoClip videoClip WHERE ";
	private static final String _SQL_COUNT_VIDEOCLIP = "SELECT COUNT(videoClip) FROM VideoClip videoClip";
	private static final String _SQL_COUNT_VIDEOCLIP_WHERE = "SELECT COUNT(videoClip) FROM VideoClip videoClip WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoClip.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoClip exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoClip exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoClipPersistenceImpl.class);
	private static VideoClip _nullVideoClip = new VideoClipImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoClip> toCacheModel() {
				return _nullVideoClipCacheModel;
			}
		};

	private static CacheModel<VideoClip> _nullVideoClipCacheModel = new CacheModel<VideoClip>() {
			@Override
			public VideoClip toEntityModel() {
				return _nullVideoClip;
			}
		};
}