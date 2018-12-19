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

package com.viettel.portal.photos.service.persistence;

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

import com.viettel.portal.photos.NoSuchPhotoException;
import com.viettel.portal.photos.model.Photo;
import com.viettel.portal.photos.model.impl.PhotoImpl;
import com.viettel.portal.photos.model.impl.PhotoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the photo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see PhotoPersistence
 * @see PhotoUtil
 * @generated
 */
public class PhotoPersistenceImpl extends BasePersistenceImpl<Photo>
	implements PhotoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PhotoUtil} to access the photo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PhotoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Boolean.class.getName() },
			PhotoModelImpl.STATUS_COLUMN_BITMASK |
			PhotoModelImpl.ORDER__COLUMN_BITMASK |
			PhotoModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhotoModelImpl.CAPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the photos where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByStatus(boolean status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the photos where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByStatus(boolean status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the photos where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByStatus(boolean status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<Photo> list = (List<Photo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Photo photo : list) {
				if ((status != photo.getStatus())) {
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

			query.append(_SQL_SELECT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Photo>(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first photo in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByStatus_First(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByStatus_First(status, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the first photo in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByStatus_First(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Photo> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last photo in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByStatus_Last(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByStatus_Last(status, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the last photo in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByStatus_Last(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where status = &#63;.
	 *
	 * @param photoId the primary key of the current photo
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo[] findByStatus_PrevAndNext(long photoId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = findByPrimaryKey(photoId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByStatus_PrevAndNext(session, photo, status,
					orderByComparator, true);

			array[1] = photo;

			array[2] = getByStatus_PrevAndNext(session, photo, status,
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

	protected Photo getByStatus_PrevAndNext(Session session, Photo photo,
		boolean status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(photo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(boolean status) throws SystemException {
		for (Photo photo : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(boolean status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "photo.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			PhotoModelImpl.CATEGORYID_COLUMN_BITMASK |
			PhotoModelImpl.STATUS_COLUMN_BITMASK |
			PhotoModelImpl.ORDER__COLUMN_BITMASK |
			PhotoModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhotoModelImpl.CAPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the photos where categoryId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @return the matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByCategory(long categoryId, boolean status)
		throws SystemException {
		return findByCategory(categoryId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the photos where categoryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByCategory(long categoryId, boolean status,
		int start, int end) throws SystemException {
		return findByCategory(categoryId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the photos where categoryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByCategory(long categoryId, boolean status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] {
					categoryId, status,
					
					start, end, orderByComparator
				};
		}

		List<Photo> list = (List<Photo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Photo photo : list) {
				if ((categoryId != photo.getCategoryId()) ||
						(status != photo.getStatus())) {
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

			query.append(_SQL_SELECT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORY_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Photo>(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first photo in the ordered set where categoryId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByCategory_First(long categoryId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByCategory_First(categoryId, status,
				orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the first photo in the ordered set where categoryId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByCategory_First(long categoryId, boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Photo> list = findByCategory(categoryId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last photo in the ordered set where categoryId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByCategory_Last(long categoryId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByCategory_Last(categoryId, status, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the last photo in the ordered set where categoryId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByCategory_Last(long categoryId, boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId, status);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByCategory(categoryId, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where categoryId = &#63; and status = &#63;.
	 *
	 * @param photoId the primary key of the current photo
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo[] findByCategory_PrevAndNext(long photoId, long categoryId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = findByPrimaryKey(photoId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByCategory_PrevAndNext(session, photo, categoryId,
					status, orderByComparator, true);

			array[1] = photo;

			array[2] = getByCategory_PrevAndNext(session, photo, categoryId,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Photo getByCategory_PrevAndNext(Session session, Photo photo,
		long categoryId, boolean status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORY_STATUS_2);

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
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(photo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where categoryId = &#63; and status = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(long categoryId, boolean status)
		throws SystemException {
		for (Photo photo : findByCategory(categoryId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where categoryId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param status the status
	 * @return the number of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategory(long categoryId, boolean status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { categoryId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORY_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "photo.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORY_STATUS_2 = "photo.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			PhotoModelImpl.CATEGORYID_COLUMN_BITMASK |
			PhotoModelImpl.GROUPID_COLUMN_BITMASK |
			PhotoModelImpl.STATUS_COLUMN_BITMASK |
			PhotoModelImpl.ORDER__COLUMN_BITMASK |
			PhotoModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhotoModelImpl.CAPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDGROUP = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByCategoryAndGroup(long categoryId, long groupId,
		boolean status) throws SystemException {
		return findByCategoryAndGroup(categoryId, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByCategoryAndGroup(long categoryId, long groupId,
		boolean status, int start, int end) throws SystemException {
		return findByCategoryAndGroup(categoryId, groupId, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByCategoryAndGroup(long categoryId, long groupId,
		boolean status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP;
			finderArgs = new Object[] { categoryId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUP;
			finderArgs = new Object[] {
					categoryId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<Photo> list = (List<Photo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Photo photo : list) {
				if ((categoryId != photo.getCategoryId()) ||
						(groupId != photo.getGroupId()) ||
						(status != photo.getStatus())) {
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

			query.append(_SQL_SELECT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Photo>(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByCategoryAndGroup_First(long categoryId, long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByCategoryAndGroup_First(categoryId, groupId,
				status, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the first photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByCategoryAndGroup_First(long categoryId, long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Photo> list = findByCategoryAndGroup(categoryId, groupId, status,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByCategoryAndGroup_Last(long categoryId, long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByCategoryAndGroup_Last(categoryId, groupId, status,
				orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the last photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByCategoryAndGroup_Last(long categoryId, long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndGroup(categoryId, groupId, status);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByCategoryAndGroup(categoryId, groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param photoId the primary key of the current photo
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo[] findByCategoryAndGroup_PrevAndNext(long photoId,
		long categoryId, long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = findByPrimaryKey(photoId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByCategoryAndGroup_PrevAndNext(session, photo,
					categoryId, groupId, status, orderByComparator, true);

			array[1] = photo;

			array[2] = getByCategoryAndGroup_PrevAndNext(session, photo,
					categoryId, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Photo getByCategoryAndGroup_PrevAndNext(Session session,
		Photo photo, long categoryId, long groupId, boolean status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_STATUS_2);

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
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(photo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where categoryId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryAndGroup(long categoryId, long groupId,
		boolean status) throws SystemException {
		for (Photo photo : findByCategoryAndGroup(categoryId, groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryAndGroup(long categoryId, long groupId,
		boolean status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYANDGROUP;

		Object[] finderArgs = new Object[] { categoryId, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(groupId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2 = "photo.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2 = "photo.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_STATUS_2 = "photo.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			PhotoModelImpl.GROUPID_COLUMN_BITMASK |
			PhotoModelImpl.STATUS_COLUMN_BITMASK |
			PhotoModelImpl.ORDER__COLUMN_BITMASK |
			PhotoModelImpl.CREATEDATE_COLUMN_BITMASK |
			PhotoModelImpl.CAPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the photos where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByGroup(long groupId, boolean status)
		throws SystemException {
		return findByGroup(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the photos where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByGroup(long groupId, boolean status, int start,
		int end) throws SystemException {
		return findByGroup(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the photos where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findByGroup(long groupId, boolean status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<Photo> list = (List<Photo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Photo photo : list) {
				if ((groupId != photo.getGroupId()) ||
						(status != photo.getStatus())) {
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

			query.append(_SQL_SELECT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUP_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Photo>(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first photo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByGroup_First(long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByGroup_First(groupId, status, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the first photo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByGroup_First(long groupId, boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Photo> list = findByGroup(groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last photo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByGroup_Last(long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByGroup_Last(groupId, status, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the last photo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByGroup_Last(long groupId, boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByGroup(groupId, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param photoId the primary key of the current photo
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo[] findByGroup_PrevAndNext(long photoId, long groupId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchPhotoException, SystemException {
		Photo photo = findByPrimaryKey(photoId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByGroup_PrevAndNext(session, photo, groupId, status,
					orderByComparator, true);

			array[1] = photo;

			array[2] = getByGroup_PrevAndNext(session, photo, groupId, status,
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

	protected Photo getByGroup_PrevAndNext(Session session, Photo photo,
		long groupId, boolean status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUP_STATUS_2);

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
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(photo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId, boolean status)
		throws SystemException {
		for (Photo photo : findByGroup(groupId, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroup(long groupId, boolean status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUP_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "photo.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUP_STATUS_2 = "photo.status = ?";

	public PhotoPersistenceImpl() {
		setModelClass(Photo.class);
	}

	/**
	 * Caches the photo in the entity cache if it is enabled.
	 *
	 * @param photo the photo
	 */
	@Override
	public void cacheResult(Photo photo) {
		EntityCacheUtil.putResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoImpl.class, photo.getPrimaryKey(), photo);

		photo.resetOriginalValues();
	}

	/**
	 * Caches the photos in the entity cache if it is enabled.
	 *
	 * @param photos the photos
	 */
	@Override
	public void cacheResult(List<Photo> photos) {
		for (Photo photo : photos) {
			if (EntityCacheUtil.getResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
						PhotoImpl.class, photo.getPrimaryKey()) == null) {
				cacheResult(photo);
			}
			else {
				photo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all photos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PhotoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PhotoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the photo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Photo photo) {
		EntityCacheUtil.removeResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoImpl.class, photo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Photo> photos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Photo photo : photos) {
			EntityCacheUtil.removeResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
				PhotoImpl.class, photo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new photo with the primary key. Does not add the photo to the database.
	 *
	 * @param photoId the primary key for the new photo
	 * @return the new photo
	 */
	@Override
	public Photo create(long photoId) {
		Photo photo = new PhotoImpl();

		photo.setNew(true);
		photo.setPrimaryKey(photoId);

		return photo;
	}

	/**
	 * Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param photoId the primary key of the photo
	 * @return the photo that was removed
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo remove(long photoId)
		throws NoSuchPhotoException, SystemException {
		return remove((Serializable)photoId);
	}

	/**
	 * Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo that was removed
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo remove(Serializable primaryKey)
		throws NoSuchPhotoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Photo photo = (Photo)session.get(PhotoImpl.class, primaryKey);

			if (photo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhotoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(photo);
		}
		catch (NoSuchPhotoException nsee) {
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
	protected Photo removeImpl(Photo photo) throws SystemException {
		photo = toUnwrappedModel(photo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(photo)) {
				photo = (Photo)session.get(PhotoImpl.class,
						photo.getPrimaryKeyObj());
			}

			if (photo != null) {
				session.delete(photo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (photo != null) {
			clearCache(photo);
		}

		return photo;
	}

	@Override
	public Photo updateImpl(com.viettel.portal.photos.model.Photo photo)
		throws SystemException {
		photo = toUnwrappedModel(photo);

		boolean isNew = photo.isNew();

		PhotoModelImpl photoModelImpl = (PhotoModelImpl)photo;

		Session session = null;

		try {
			session = openSession();

			if (photo.isNew()) {
				session.save(photo);

				photo.setNew(false);
			}
			else {
				session.merge(photo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PhotoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((photoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { photoModelImpl.getOriginalStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { photoModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((photoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						photoModelImpl.getOriginalCategoryId(),
						photoModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						photoModelImpl.getCategoryId(),
						photoModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((photoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						photoModelImpl.getOriginalCategoryId(),
						photoModelImpl.getOriginalGroupId(),
						photoModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);

				args = new Object[] {
						photoModelImpl.getCategoryId(),
						photoModelImpl.getGroupId(), photoModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);
			}

			if ((photoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						photoModelImpl.getOriginalGroupId(),
						photoModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						photoModelImpl.getGroupId(), photoModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoImpl.class, photo.getPrimaryKey(), photo);

		return photo;
	}

	protected Photo toUnwrappedModel(Photo photo) {
		if (photo instanceof PhotoImpl) {
			return photo;
		}

		PhotoImpl photoImpl = new PhotoImpl();

		photoImpl.setNew(photo.isNew());
		photoImpl.setPrimaryKey(photo.getPrimaryKey());

		photoImpl.setPhotoId(photo.getPhotoId());
		photoImpl.setCaption(photo.getCaption());
		photoImpl.setFileId(photo.getFileId());
		photoImpl.setFileLink(photo.getFileLink());
		photoImpl.setFileName(photo.getFileName());
		photoImpl.setFileSize(photo.getFileSize());
		photoImpl.setCreateDate(photo.getCreateDate());
		photoImpl.setModifyDate(photo.getModifyDate());
		photoImpl.setOrder_(photo.getOrder_());
		photoImpl.setStatus(photo.isStatus());
		photoImpl.setUserName(photo.getUserName());
		photoImpl.setUserId(photo.getUserId());
		photoImpl.setCompanyId(photo.getCompanyId());
		photoImpl.setCategoryId(photo.getCategoryId());
		photoImpl.setGroupId(photo.getGroupId());

		return photoImpl;
	}

	/**
	 * Returns the photo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhotoException, SystemException {
		Photo photo = fetchByPrimaryKey(primaryKey);

		if (photo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhotoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return photo;
	}

	/**
	 * Returns the photo with the primary key or throws a {@link com.viettel.portal.photos.NoSuchPhotoException} if it could not be found.
	 *
	 * @param photoId the primary key of the photo
	 * @return the photo
	 * @throws com.viettel.portal.photos.NoSuchPhotoException if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo findByPrimaryKey(long photoId)
		throws NoSuchPhotoException, SystemException {
		return findByPrimaryKey((Serializable)photoId);
	}

	/**
	 * Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo, or <code>null</code> if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Photo photo = (Photo)EntityCacheUtil.getResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
				PhotoImpl.class, primaryKey);

		if (photo == _nullPhoto) {
			return null;
		}

		if (photo == null) {
			Session session = null;

			try {
				session = openSession();

				photo = (Photo)session.get(PhotoImpl.class, primaryKey);

				if (photo != null) {
					cacheResult(photo);
				}
				else {
					EntityCacheUtil.putResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
						PhotoImpl.class, primaryKey, _nullPhoto);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PhotoModelImpl.ENTITY_CACHE_ENABLED,
					PhotoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return photo;
	}

	/**
	 * Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param photoId the primary key of the photo
	 * @return the photo, or <code>null</code> if a photo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Photo fetchByPrimaryKey(long photoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)photoId);
	}

	/**
	 * Returns all the photos.
	 *
	 * @return the photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the photos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the photos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PhotoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of photos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Photo> findAll(int start, int end,
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

		List<Photo> list = (List<Photo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PHOTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHOTO;

				if (pagination) {
					sql = sql.concat(PhotoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Photo>(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the photos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Photo photo : findAll()) {
			remove(photo);
		}
	}

	/**
	 * Returns the number of photos.
	 *
	 * @return the number of photos
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

				Query q = session.createQuery(_SQL_COUNT_PHOTO);

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
	 * Initializes the photo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.photos.model.Photo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Photo>> listenersList = new ArrayList<ModelListener<Photo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Photo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PhotoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PHOTO = "SELECT photo FROM Photo photo";
	private static final String _SQL_SELECT_PHOTO_WHERE = "SELECT photo FROM Photo photo WHERE ";
	private static final String _SQL_COUNT_PHOTO = "SELECT COUNT(photo) FROM Photo photo";
	private static final String _SQL_COUNT_PHOTO_WHERE = "SELECT COUNT(photo) FROM Photo photo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "photo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Photo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Photo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PhotoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"order_"
			});
	private static Photo _nullPhoto = new PhotoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Photo> toCacheModel() {
				return _nullPhotoCacheModel;
			}
		};

	private static CacheModel<Photo> _nullPhotoCacheModel = new CacheModel<Photo>() {
			@Override
			public Photo toEntityModel() {
				return _nullPhoto;
			}
		};
}