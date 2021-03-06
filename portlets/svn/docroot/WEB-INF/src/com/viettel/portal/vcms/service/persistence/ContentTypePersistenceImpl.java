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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.vcms.NoSuchContentTypeException;
import com.viettel.portal.vcms.model.ContentType;
import com.viettel.portal.vcms.model.impl.ContentTypeImpl;
import com.viettel.portal.vcms.model.impl.ContentTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the content type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see ContentTypePersistence
 * @see ContentTypeUtil
 * @generated
 */
public class ContentTypePersistenceImpl extends BasePersistenceImpl<ContentType>
	implements ContentTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContentTypeUtil} to access the content type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContentTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeModelImpl.FINDER_CACHE_ENABLED, ContentTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeModelImpl.FINDER_CACHE_ENABLED, ContentTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeModelImpl.FINDER_CACHE_ENABLED, ContentTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeModelImpl.FINDER_CACHE_ENABLED, ContentTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ContentTypeModelImpl.GROUPID_COLUMN_BITMASK |
			ContentTypeModelImpl.SORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the content types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content types
	 * @param end the upper bound of the range of content types (not inclusive)
	 * @return the range of matching content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content types
	 * @param end the upper bound of the range of content types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findByGroupId(long groupId, int start, int end,
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

		List<ContentType> list = (List<ContentType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentType contentType : list) {
				if ((groupId != contentType.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTENTTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ContentType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentType>(list);
				}
				else {
					list = (List<ContentType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a matching content type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContentTypeException, SystemException {
		ContentType contentType = fetchByGroupId_First(groupId,
				orderByComparator);

		if (contentType != null) {
			return contentType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeException(msg.toString());
	}

	/**
	 * Returns the first content type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type, or <code>null</code> if a matching content type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContentType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a matching content type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContentTypeException, SystemException {
		ContentType contentType = fetchByGroupId_Last(groupId, orderByComparator);

		if (contentType != null) {
			return contentType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeException(msg.toString());
	}

	/**
	 * Returns the last content type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type, or <code>null</code> if a matching content type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ContentType> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content types before and after the current content type in the ordered set where groupId = &#63;.
	 *
	 * @param contenTypeId the primary key of the current content type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content type
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType[] findByGroupId_PrevAndNext(long contenTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContentTypeException, SystemException {
		ContentType contentType = findByPrimaryKey(contenTypeId);

		Session session = null;

		try {
			session = openSession();

			ContentType[] array = new ContentTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, contentType, groupId,
					orderByComparator, true);

			array[1] = contentType;

			array[2] = getByGroupId_PrevAndNext(session, contentType, groupId,
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

	protected ContentType getByGroupId_PrevAndNext(Session session,
		ContentType contentType, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTTYPE_WHERE);

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
			query.append(ContentTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ContentType contentType : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentType);
		}
	}

	/**
	 * Returns the number of content types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching content types
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

			query.append(_SQL_COUNT_CONTENTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "contentType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCH = new FinderPath(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeModelImpl.FINDER_CACHE_ENABLED, ContentTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySearch",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCH = new FinderPath(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBySearch",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the content types where groupId = &#63; and name LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findBySearch(long groupId, String name)
		throws SystemException {
		return findBySearch(groupId, name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content types where groupId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of content types
	 * @param end the upper bound of the range of content types (not inclusive)
	 * @return the range of matching content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findBySearch(long groupId, String name, int start,
		int end) throws SystemException {
		return findBySearch(groupId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content types where groupId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of content types
	 * @param end the upper bound of the range of content types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findBySearch(long groupId, String name, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCH;
		finderArgs = new Object[] { groupId, name, start, end, orderByComparator };

		List<ContentType> list = (List<ContentType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentType contentType : list) {
				if ((groupId != contentType.getGroupId()) ||
						!StringUtil.wildcardMatches(contentType.getName(),
							name, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_CONTENTTYPE_WHERE);

			query.append(_FINDER_COLUMN_SEARCH_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_SEARCH_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCH_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_SEARCH_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ContentType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentType>(list);
				}
				else {
					list = (List<ContentType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a matching content type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType findBySearch_First(long groupId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchContentTypeException, SystemException {
		ContentType contentType = fetchBySearch_First(groupId, name,
				orderByComparator);

		if (contentType != null) {
			return contentType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeException(msg.toString());
	}

	/**
	 * Returns the first content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content type, or <code>null</code> if a matching content type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType fetchBySearch_First(long groupId, String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContentType> list = findBySearch(groupId, name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a matching content type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType findBySearch_Last(long groupId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchContentTypeException, SystemException {
		ContentType contentType = fetchBySearch_Last(groupId, name,
				orderByComparator);

		if (contentType != null) {
			return contentType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentTypeException(msg.toString());
	}

	/**
	 * Returns the last content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content type, or <code>null</code> if a matching content type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType fetchBySearch_Last(long groupId, String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySearch(groupId, name);

		if (count == 0) {
			return null;
		}

		List<ContentType> list = findBySearch(groupId, name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content types before and after the current content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	 *
	 * @param contenTypeId the primary key of the current content type
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content type
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType[] findBySearch_PrevAndNext(long contenTypeId,
		long groupId, String name, OrderByComparator orderByComparator)
		throws NoSuchContentTypeException, SystemException {
		ContentType contentType = findByPrimaryKey(contenTypeId);

		Session session = null;

		try {
			session = openSession();

			ContentType[] array = new ContentTypeImpl[3];

			array[0] = getBySearch_PrevAndNext(session, contentType, groupId,
					name, orderByComparator, true);

			array[1] = contentType;

			array[2] = getBySearch_PrevAndNext(session, contentType, groupId,
					name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContentType getBySearch_PrevAndNext(Session session,
		ContentType contentType, long groupId, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTTYPE_WHERE);

		query.append(_FINDER_COLUMN_SEARCH_GROUPID_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_SEARCH_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SEARCH_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_SEARCH_NAME_2);
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
			query.append(ContentTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content types where groupId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySearch(long groupId, String name)
		throws SystemException {
		for (ContentType contentType : findBySearch(groupId, name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentType);
		}
	}

	/**
	 * Returns the number of content types where groupId = &#63; and name LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearch(long groupId, String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCH;

		Object[] finderArgs = new Object[] { groupId, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENTTYPE_WHERE);

			query.append(_FINDER_COLUMN_SEARCH_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_SEARCH_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCH_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_SEARCH_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_SEARCH_GROUPID_2 = "contentType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_SEARCH_NAME_1 = "contentType.name LIKE NULL";
	private static final String _FINDER_COLUMN_SEARCH_NAME_2 = "contentType.name LIKE ?";
	private static final String _FINDER_COLUMN_SEARCH_NAME_3 = "(contentType.name IS NULL OR contentType.name LIKE '')";

	public ContentTypePersistenceImpl() {
		setModelClass(ContentType.class);
	}

	/**
	 * Caches the content type in the entity cache if it is enabled.
	 *
	 * @param contentType the content type
	 */
	@Override
	public void cacheResult(ContentType contentType) {
		EntityCacheUtil.putResult(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeImpl.class, contentType.getPrimaryKey(), contentType);

		contentType.resetOriginalValues();
	}

	/**
	 * Caches the content types in the entity cache if it is enabled.
	 *
	 * @param contentTypes the content types
	 */
	@Override
	public void cacheResult(List<ContentType> contentTypes) {
		for (ContentType contentType : contentTypes) {
			if (EntityCacheUtil.getResult(
						ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
						ContentTypeImpl.class, contentType.getPrimaryKey()) == null) {
				cacheResult(contentType);
			}
			else {
				contentType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all content types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContentTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContentTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the content type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContentType contentType) {
		EntityCacheUtil.removeResult(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeImpl.class, contentType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContentType> contentTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContentType contentType : contentTypes) {
			EntityCacheUtil.removeResult(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
				ContentTypeImpl.class, contentType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new content type with the primary key. Does not add the content type to the database.
	 *
	 * @param contenTypeId the primary key for the new content type
	 * @return the new content type
	 */
	@Override
	public ContentType create(long contenTypeId) {
		ContentType contentType = new ContentTypeImpl();

		contentType.setNew(true);
		contentType.setPrimaryKey(contenTypeId);

		return contentType;
	}

	/**
	 * Removes the content type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contenTypeId the primary key of the content type
	 * @return the content type that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType remove(long contenTypeId)
		throws NoSuchContentTypeException, SystemException {
		return remove((Serializable)contenTypeId);
	}

	/**
	 * Removes the content type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content type
	 * @return the content type that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType remove(Serializable primaryKey)
		throws NoSuchContentTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContentType contentType = (ContentType)session.get(ContentTypeImpl.class,
					primaryKey);

			if (contentType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contentType);
		}
		catch (NoSuchContentTypeException nsee) {
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
	protected ContentType removeImpl(ContentType contentType)
		throws SystemException {
		contentType = toUnwrappedModel(contentType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contentType)) {
				contentType = (ContentType)session.get(ContentTypeImpl.class,
						contentType.getPrimaryKeyObj());
			}

			if (contentType != null) {
				session.delete(contentType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contentType != null) {
			clearCache(contentType);
		}

		return contentType;
	}

	@Override
	public ContentType updateImpl(
		com.viettel.portal.vcms.model.ContentType contentType)
		throws SystemException {
		contentType = toUnwrappedModel(contentType);

		boolean isNew = contentType.isNew();

		ContentTypeModelImpl contentTypeModelImpl = (ContentTypeModelImpl)contentType;

		Session session = null;

		try {
			session = openSession();

			if (contentType.isNew()) {
				session.save(contentType);

				contentType.setNew(false);
			}
			else {
				session.merge(contentType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContentTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contentTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { contentTypeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ContentTypeImpl.class, contentType.getPrimaryKey(), contentType);

		return contentType;
	}

	protected ContentType toUnwrappedModel(ContentType contentType) {
		if (contentType instanceof ContentTypeImpl) {
			return contentType;
		}

		ContentTypeImpl contentTypeImpl = new ContentTypeImpl();

		contentTypeImpl.setNew(contentType.isNew());
		contentTypeImpl.setPrimaryKey(contentType.getPrimaryKey());

		contentTypeImpl.setContenTypeId(contentType.getContenTypeId());
		contentTypeImpl.setGroupId(contentType.getGroupId());
		contentTypeImpl.setCompanyId(contentType.getCompanyId());
		contentTypeImpl.setUserId(contentType.getUserId());
		contentTypeImpl.setName(contentType.getName());
		contentTypeImpl.setDescription(contentType.getDescription());
		contentTypeImpl.setSortOrder(contentType.getSortOrder());

		return contentTypeImpl;
	}

	/**
	 * Returns the content type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the content type
	 * @return the content type
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContentTypeException, SystemException {
		ContentType contentType = fetchByPrimaryKey(primaryKey);

		if (contentType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContentTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contentType;
	}

	/**
	 * Returns the content type with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentTypeException} if it could not be found.
	 *
	 * @param contenTypeId the primary key of the content type
	 * @return the content type
	 * @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType findByPrimaryKey(long contenTypeId)
		throws NoSuchContentTypeException, SystemException {
		return findByPrimaryKey((Serializable)contenTypeId);
	}

	/**
	 * Returns the content type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the content type
	 * @return the content type, or <code>null</code> if a content type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContentType contentType = (ContentType)EntityCacheUtil.getResult(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
				ContentTypeImpl.class, primaryKey);

		if (contentType == _nullContentType) {
			return null;
		}

		if (contentType == null) {
			Session session = null;

			try {
				session = openSession();

				contentType = (ContentType)session.get(ContentTypeImpl.class,
						primaryKey);

				if (contentType != null) {
					cacheResult(contentType);
				}
				else {
					EntityCacheUtil.putResult(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
						ContentTypeImpl.class, primaryKey, _nullContentType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContentTypeModelImpl.ENTITY_CACHE_ENABLED,
					ContentTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contentType;
	}

	/**
	 * Returns the content type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contenTypeId the primary key of the content type
	 * @return the content type, or <code>null</code> if a content type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentType fetchByPrimaryKey(long contenTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contenTypeId);
	}

	/**
	 * Returns all the content types.
	 *
	 * @return the content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of content types
	 * @param end the upper bound of the range of content types (not inclusive)
	 * @return the range of content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the content types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of content types
	 * @param end the upper bound of the range of content types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of content types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentType> findAll(int start, int end,
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

		List<ContentType> list = (List<ContentType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTENTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTENTTYPE;

				if (pagination) {
					sql = sql.concat(ContentTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContentType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentType>(list);
				}
				else {
					list = (List<ContentType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the content types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContentType contentType : findAll()) {
			remove(contentType);
		}
	}

	/**
	 * Returns the number of content types.
	 *
	 * @return the number of content types
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

				Query q = session.createQuery(_SQL_COUNT_CONTENTTYPE);

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
	 * Initializes the content type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.ContentType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContentType>> listenersList = new ArrayList<ModelListener<ContentType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContentType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContentTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTENTTYPE = "SELECT contentType FROM ContentType contentType";
	private static final String _SQL_SELECT_CONTENTTYPE_WHERE = "SELECT contentType FROM ContentType contentType WHERE ";
	private static final String _SQL_COUNT_CONTENTTYPE = "SELECT COUNT(contentType) FROM ContentType contentType";
	private static final String _SQL_COUNT_CONTENTTYPE_WHERE = "SELECT COUNT(contentType) FROM ContentType contentType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contentType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContentType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContentType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContentTypePersistenceImpl.class);
	private static ContentType _nullContentType = new ContentTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContentType> toCacheModel() {
				return _nullContentTypeCacheModel;
			}
		};

	private static CacheModel<ContentType> _nullContentTypeCacheModel = new CacheModel<ContentType>() {
			@Override
			public ContentType toEntityModel() {
				return _nullContentType;
			}
		};
}