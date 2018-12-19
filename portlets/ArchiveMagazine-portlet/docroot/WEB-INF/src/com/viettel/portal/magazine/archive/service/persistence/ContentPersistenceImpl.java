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

package com.viettel.portal.magazine.archive.service.persistence;

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

import com.viettel.portal.magazine.archive.NoSuchContentException;
import com.viettel.portal.magazine.archive.model.Content;
import com.viettel.portal.magazine.archive.model.impl.ContentImpl;
import com.viettel.portal.magazine.archive.model.impl.ContentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see ContentPersistence
 * @see ContentUtil
 * @generated
 */
public class ContentPersistenceImpl extends BasePersistenceImpl<Content>
	implements ContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContentUtil} to access the content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINE = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMagazine",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINE =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMagazine",
			new String[] { Integer.class.getName() },
			ContentModelImpl.MAGAZINEID_COLUMN_BITMASK |
			ContentModelImpl.SORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAGAZINE = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMagazine",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the contents where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByMagazine(int MagazineID)
		throws SystemException {
		return findByMagazine(MagazineID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contents where MagazineID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByMagazine(int MagazineID, int start, int end)
		throws SystemException {
		return findByMagazine(MagazineID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where MagazineID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByMagazine(int MagazineID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINE;
			finderArgs = new Object[] { MagazineID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAGAZINE;
			finderArgs = new Object[] { MagazineID, start, end, orderByComparator };
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((MagazineID != content.getMagazineID())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINE_MAGAZINEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineID);

				if (!pagination) {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Content>(list);
				}
				else {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.magazine.archive.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByMagazine_First(int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByMagazine_First(MagazineID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineID=");
		msg.append(MagazineID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByMagazine_First(int MagazineID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByMagazine(MagazineID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.magazine.archive.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByMagazine_Last(int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByMagazine_Last(MagazineID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MagazineID=");
		msg.append(MagazineID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByMagazine_Last(int MagazineID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMagazine(MagazineID);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByMagazine(MagazineID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where MagazineID = &#63;.
	 *
	 * @param ID the primary key of the current content
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByMagazine_PrevAndNext(int ID, int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByMagazine_PrevAndNext(session, content, MagazineID,
					orderByComparator, true);

			array[1] = content;

			array[2] = getByMagazine_PrevAndNext(session, content, MagazineID,
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

	protected Content getByMagazine_PrevAndNext(Session session,
		Content content, int MagazineID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_MAGAZINE_MAGAZINEID_2);

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
			query.append(ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(MagazineID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contents that the user has permission to view where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByMagazine(int MagazineID)
		throws SystemException {
		return filterFindByMagazine(MagazineID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where MagazineID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByMagazine(int MagazineID, int start, int end)
		throws SystemException {
		return filterFindByMagazine(MagazineID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where MagazineID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MagazineID the magazine i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByMagazine(int MagazineID, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByMagazine(MagazineID, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_MAGAZINE_MAGAZINEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContentImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(MagazineID);

			return (List<Content>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where MagazineID = &#63;.
	 *
	 * @param ID the primary key of the current content
	 * @param MagazineID the magazine i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByMagazine_PrevAndNext(int ID, int MagazineID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByMagazine_PrevAndNext(ID, MagazineID, orderByComparator);
		}

		Content content = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByMagazine_PrevAndNext(session, content,
					MagazineID, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByMagazine_PrevAndNext(session, content,
					MagazineID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByMagazine_PrevAndNext(Session session,
		Content content, int MagazineID, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_MAGAZINE_MAGAZINEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContentImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContentImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(MagazineID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contents where MagazineID = &#63; from the database.
	 *
	 * @param MagazineID the magazine i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMagazine(int MagazineID) throws SystemException {
		for (Content content : findByMagazine(MagazineID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMagazine(int MagazineID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAGAZINE;

		Object[] finderArgs = new Object[] { MagazineID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_MAGAZINE_MAGAZINEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MagazineID);

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
	 * Returns the number of contents that the user has permission to view where MagazineID = &#63;.
	 *
	 * @param MagazineID the magazine i d
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByMagazine(int MagazineID) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByMagazine(MagazineID);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_MAGAZINE_MAGAZINEID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(MagazineID);

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

	private static final String _FINDER_COLUMN_MAGAZINE_MAGAZINEID_2 = "content.MagazineID = ?";

	public ContentPersistenceImpl() {
		setModelClass(Content.class);
	}

	/**
	 * Caches the content in the entity cache if it is enabled.
	 *
	 * @param content the content
	 */
	@Override
	public void cacheResult(Content content) {
		EntityCacheUtil.putResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentImpl.class, content.getPrimaryKey(), content);

		content.resetOriginalValues();
	}

	/**
	 * Caches the contents in the entity cache if it is enabled.
	 *
	 * @param contents the contents
	 */
	@Override
	public void cacheResult(List<Content> contents) {
		for (Content content : contents) {
			if (EntityCacheUtil.getResult(
						ContentModelImpl.ENTITY_CACHE_ENABLED,
						ContentImpl.class, content.getPrimaryKey()) == null) {
				cacheResult(content);
			}
			else {
				content.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Content content) {
		EntityCacheUtil.removeResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentImpl.class, content.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Content> contents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Content content : contents) {
			EntityCacheUtil.removeResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
				ContentImpl.class, content.getPrimaryKey());
		}
	}

	/**
	 * Creates a new content with the primary key. Does not add the content to the database.
	 *
	 * @param ID the primary key for the new content
	 * @return the new content
	 */
	@Override
	public Content create(int ID) {
		Content content = new ContentImpl();

		content.setNew(true);
		content.setPrimaryKey(ID);

		return content;
	}

	/**
	 * Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the content
	 * @return the content that was removed
	 * @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content remove(int ID)
		throws NoSuchContentException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content
	 * @return the content that was removed
	 * @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content remove(Serializable primaryKey)
		throws NoSuchContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Content content = (Content)session.get(ContentImpl.class, primaryKey);

			if (content == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(content);
		}
		catch (NoSuchContentException nsee) {
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
	protected Content removeImpl(Content content) throws SystemException {
		content = toUnwrappedModel(content);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(content)) {
				content = (Content)session.get(ContentImpl.class,
						content.getPrimaryKeyObj());
			}

			if (content != null) {
				session.delete(content);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (content != null) {
			clearCache(content);
		}

		return content;
	}

	@Override
	public Content updateImpl(
		com.viettel.portal.magazine.archive.model.Content content)
		throws SystemException {
		content = toUnwrappedModel(content);

		boolean isNew = content.isNew();

		ContentModelImpl contentModelImpl = (ContentModelImpl)content;

		Session session = null;

		try {
			session = openSession();

			if (content.isNew()) {
				session.save(content);

				content.setNew(false);
			}
			else {
				session.merge(content);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalMagazineID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINE,
					args);

				args = new Object[] { contentModelImpl.getMagazineID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAGAZINE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAGAZINE,
					args);
			}
		}

		EntityCacheUtil.putResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentImpl.class, content.getPrimaryKey(), content);

		return content;
	}

	protected Content toUnwrappedModel(Content content) {
		if (content instanceof ContentImpl) {
			return content;
		}

		ContentImpl contentImpl = new ContentImpl();

		contentImpl.setNew(content.isNew());
		contentImpl.setPrimaryKey(content.getPrimaryKey());

		contentImpl.setID(content.getID());
		contentImpl.setSubject(content.getSubject());
		contentImpl.setNormalZoneID(content.getNormalZoneID());
		contentImpl.setSpecialZoneID(content.getSpecialZoneID());
		contentImpl.setFileUrl(content.getFileUrl());
		contentImpl.setAuthor(content.getAuthor());
		contentImpl.setAuthorTitle(content.getAuthorTitle());
		contentImpl.setMagazineID(content.getMagazineID());
		contentImpl.setSortOrder(content.getSortOrder());
		contentImpl.setCreationDate(content.getCreationDate());

		return contentImpl;
	}

	/**
	 * Returns the content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the content
	 * @return the content
	 * @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContentException, SystemException {
		Content content = fetchByPrimaryKey(primaryKey);

		if (content == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return content;
	}

	/**
	 * Returns the content with the primary key or throws a {@link com.viettel.portal.magazine.archive.NoSuchContentException} if it could not be found.
	 *
	 * @param ID the primary key of the content
	 * @return the content
	 * @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByPrimaryKey(int ID)
		throws NoSuchContentException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the content
	 * @return the content, or <code>null</code> if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Content content = (Content)EntityCacheUtil.getResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
				ContentImpl.class, primaryKey);

		if (content == _nullContent) {
			return null;
		}

		if (content == null) {
			Session session = null;

			try {
				session = openSession();

				content = (Content)session.get(ContentImpl.class, primaryKey);

				if (content != null) {
					cacheResult(content);
				}
				else {
					EntityCacheUtil.putResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
						ContentImpl.class, primaryKey, _nullContent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
					ContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return content;
	}

	/**
	 * Returns the content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the content
	 * @return the content, or <code>null</code> if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the contents.
	 *
	 * @return the contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findAll(int start, int end,
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

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTENT;

				if (pagination) {
					sql = sql.concat(ContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Content>(list);
				}
				else {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Content content : findAll()) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents.
	 *
	 * @return the number of contents
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

				Query q = session.createQuery(_SQL_COUNT_CONTENT);

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
	 * Initializes the content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.magazine.archive.model.Content")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Content>> listenersList = new ArrayList<ModelListener<Content>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Content>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTENT = "SELECT content FROM Content content";
	private static final String _SQL_SELECT_CONTENT_WHERE = "SELECT content FROM Content content WHERE ";
	private static final String _SQL_COUNT_CONTENT = "SELECT COUNT(content) FROM Content content";
	private static final String _SQL_COUNT_CONTENT_WHERE = "SELECT COUNT(content) FROM Content content WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "content.ID";
	private static final String _FILTER_SQL_SELECT_CONTENT_WHERE = "SELECT DISTINCT {content.*} FROM ArchiveContent content WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ArchiveContent.*} FROM (SELECT DISTINCT content.ID FROM ArchiveContent content WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ArchiveContent ON TEMP_TABLE.ID = ArchiveContent.ID";
	private static final String _FILTER_SQL_COUNT_CONTENT_WHERE = "SELECT COUNT(DISTINCT content.ID) AS COUNT_VALUE FROM ArchiveContent content WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "content";
	private static final String _FILTER_ENTITY_TABLE = "ArchiveContent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "content.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ArchiveContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Content exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Content exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContentPersistenceImpl.class);
	private static Content _nullContent = new ContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Content> toCacheModel() {
				return _nullContentCacheModel;
			}
		};

	private static CacheModel<Content> _nullContentCacheModel = new CacheModel<Content>() {
			@Override
			public Content toEntityModel() {
				return _nullContent;
			}
		};
}