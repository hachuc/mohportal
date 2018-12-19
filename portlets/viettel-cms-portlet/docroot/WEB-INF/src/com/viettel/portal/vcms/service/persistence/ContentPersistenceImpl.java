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

import com.viettel.portal.vcms.NoSuchContentException;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.impl.ContentImpl;
import com.viettel.portal.vcms.model.impl.ContentModelImpl;

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
 * @author chuchv
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
			new String[] { Long.class.getName(), String.class.getName() },
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.URLTITLE_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the contents where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_U(long groupId, String urlTitle)
		throws SystemException {
		return findByG_U(groupId, urlTitle, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and urlTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_U(long groupId, String urlTitle, int start,
		int end) throws SystemException {
		return findByG_U(groupId, urlTitle, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and urlTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_U(long groupId, String urlTitle, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U;
			finderArgs = new Object[] { groupId, urlTitle };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U;
			finderArgs = new Object[] {
					groupId, urlTitle,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						!Validator.equals(urlTitle, content.getUrlTitle())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_G_U_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_U_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_U_URLTITLE_2);
			}

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

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

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
	 * Returns the first content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_U_First(long groupId, String urlTitle,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_U_First(groupId, urlTitle, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", urlTitle=");
		msg.append(urlTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_U_First(long groupId, String urlTitle,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_U(groupId, urlTitle, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_U_Last(long groupId, String urlTitle,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_U_Last(groupId, urlTitle, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", urlTitle=");
		msg.append(urlTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_U_Last(long groupId, String urlTitle,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_U(groupId, urlTitle);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_U(groupId, urlTitle, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_U_PrevAndNext(long autoId, long groupId,
		String urlTitle, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_U_PrevAndNext(session, content, groupId,
					urlTitle, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_U_PrevAndNext(session, content, groupId,
					urlTitle, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_U_PrevAndNext(Session session, Content content,
		long groupId, String urlTitle, OrderByComparator orderByComparator,
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

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle == null) {
			query.append(_FINDER_COLUMN_G_U_URLTITLE_1);
		}
		else if (urlTitle.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_U_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_U_URLTITLE_2);
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
			query.append(ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindUrlTitle) {
			qPos.add(urlTitle);
		}

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_U(long groupId, String urlTitle)
		throws SystemException {
		return filterFindByG_U(groupId, urlTitle, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and urlTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_U(long groupId, String urlTitle,
		int start, int end) throws SystemException {
		return filterFindByG_U(groupId, urlTitle, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and urlTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_U(long groupId, String urlTitle,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U(groupId, urlTitle, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle == null) {
			query.append(_FINDER_COLUMN_G_U_URLTITLE_1);
		}
		else if (urlTitle.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_U_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_U_URLTITLE_2);
		}

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			if (bindUrlTitle) {
				qPos.add(urlTitle);
			}

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_U_PrevAndNext(long autoId, long groupId,
		String urlTitle, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_PrevAndNext(autoId, groupId, urlTitle,
				orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_U_PrevAndNext(session, content, groupId,
					urlTitle, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_U_PrevAndNext(session, content, groupId,
					urlTitle, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_U_PrevAndNext(Session session,
		Content content, long groupId, String urlTitle,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle == null) {
			query.append(_FINDER_COLUMN_G_U_URLTITLE_1);
		}
		else if (urlTitle.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_U_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_U_URLTITLE_2);
		}

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		if (bindUrlTitle) {
			qPos.add(urlTitle);
		}

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
	 * Removes all the contents where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_U(long groupId, String urlTitle)
		throws SystemException {
		for (Content content : findByG_U(groupId, urlTitle, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_U(long groupId, String urlTitle)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U;

		Object[] finderArgs = new Object[] { groupId, urlTitle };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_G_U_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_U_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_U_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
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

	/**
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_U(long groupId, String urlTitle)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U(groupId, urlTitle);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle == null) {
			query.append(_FINDER_COLUMN_G_U_URLTITLE_1);
		}
		else if (urlTitle.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_U_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_U_URLTITLE_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindUrlTitle) {
				qPos.add(urlTitle);
			}

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

	private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_URLTITLE_1 = "content.urlTitle IS NULL";
	private static final String _FINDER_COLUMN_G_U_URLTITLE_2 = "content.urlTitle = ?";
	private static final String _FINDER_COLUMN_G_U_URLTITLE_3 = "(content.urlTitle IS NULL OR content.urlTitle = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.CATEGORYID_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contents where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C(long groupId, long categoryId)
		throws SystemException {
		return findByG_C(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C(long groupId, long categoryId, int start,
		int end) throws SystemException {
		return findByG_C(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C(long groupId, long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C;
			finderArgs = new Object[] { groupId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C;
			finderArgs = new Object[] {
					groupId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(categoryId != content.getCategoryId())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

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

				qPos.add(groupId);

				qPos.add(categoryId);

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
	 * Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_C_First(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_C_First(groupId, categoryId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_C_First(long groupId, long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_C(groupId, categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_C_Last(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_C_Last(groupId, categoryId, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_C_Last(long groupId, long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_C(groupId, categoryId);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_C(groupId, categoryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_C_PrevAndNext(long autoId, long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_C_PrevAndNext(session, content, groupId,
					categoryId, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_C_PrevAndNext(session, content, groupId,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_C_PrevAndNext(Session session, Content content,
		long groupId, long categoryId, OrderByComparator orderByComparator,
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

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

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

		qPos.add(groupId);

		qPos.add(categoryId);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C(long groupId, long categoryId)
		throws SystemException {
		return filterFindByG_C(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C(long groupId, long categoryId,
		int start, int end) throws SystemException {
		return filterFindByG_C(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C(long groupId, long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C(groupId, categoryId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(categoryId);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_C_PrevAndNext(long autoId, long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_PrevAndNext(autoId, groupId, categoryId,
				orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_C_PrevAndNext(session, content, groupId,
					categoryId, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_C_PrevAndNext(session, content, groupId,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_C_PrevAndNext(Session session,
		Content content, long groupId, long categoryId,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(categoryId);

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
	 * Removes all the contents where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_C(long groupId, long categoryId)
		throws SystemException {
		for (Content content : findByG_C(groupId, categoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C(long groupId, long categoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C;

		Object[] finderArgs = new Object[] { groupId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

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
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_C(long groupId, long categoryId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C(groupId, categoryId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_CATEGORYID_2 = "content.categoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CA_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_CA_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_CA_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.CATEGORYID_COLUMN_BITMASK |
			ContentModelImpl.VERSION_COLUMN_BITMASK |
			ContentModelImpl.STATUS_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CA_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CA_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CA_V_S(long groupId, long categoryId,
		int version, int status) throws SystemException {
		return findByG_CA_V_S(groupId, categoryId, version, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CA_V_S(long groupId, long categoryId,
		int version, int status, int start, int end) throws SystemException {
		return findByG_CA_V_S(groupId, categoryId, version, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CA_V_S(long groupId, long categoryId,
		int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S;
			finderArgs = new Object[] { groupId, categoryId, version, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CA_V_S;
			finderArgs = new Object[] {
					groupId, categoryId, version, status,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(categoryId != content.getCategoryId()) ||
						(version != content.getVersion()) ||
						(status != content.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_CA_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CA_V_S_CATEGORYID_2);

			query.append(_FINDER_COLUMN_G_CA_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_CA_V_S_STATUS_2);

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

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(version);

				qPos.add(status);

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
	 * Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_CA_V_S_First(long groupId, long categoryId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_CA_V_S_First(groupId, categoryId, version,
				status, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_CA_V_S_First(long groupId, long categoryId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Content> list = findByG_CA_V_S(groupId, categoryId, version,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_CA_V_S_Last(long groupId, long categoryId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_CA_V_S_Last(groupId, categoryId, version,
				status, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_CA_V_S_Last(long groupId, long categoryId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_CA_V_S(groupId, categoryId, version, status);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_CA_V_S(groupId, categoryId, version,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_CA_V_S_PrevAndNext(long autoId, long groupId,
		long categoryId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_CA_V_S_PrevAndNext(session, content, groupId,
					categoryId, version, status, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_CA_V_S_PrevAndNext(session, content, groupId,
					categoryId, version, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_CA_V_S_PrevAndNext(Session session,
		Content content, long groupId, long categoryId, int version,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_CA_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_STATUS_2);

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

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(version);

		qPos.add(status);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CA_V_S(long groupId, long categoryId,
		int version, int status) throws SystemException {
		return filterFindByG_CA_V_S(groupId, categoryId, version, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CA_V_S(long groupId, long categoryId,
		int version, int status, int start, int end) throws SystemException {
		return filterFindByG_CA_V_S(groupId, categoryId, version, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CA_V_S(long groupId, long categoryId,
		int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_CA_V_S(groupId, categoryId, version, status, start,
				end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_CA_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(version);

			qPos.add(status);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_CA_V_S_PrevAndNext(long autoId,
		long groupId, long categoryId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_CA_V_S_PrevAndNext(autoId, groupId, categoryId,
				version, status, orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_CA_V_S_PrevAndNext(session, content,
					groupId, categoryId, version, status, orderByComparator,
					true);

			array[1] = content;

			array[2] = filterGetByG_CA_V_S_PrevAndNext(session, content,
					groupId, categoryId, version, status, orderByComparator,
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

	protected Content filterGetByG_CA_V_S_PrevAndNext(Session session,
		Content content, long groupId, long categoryId, int version,
		int status, OrderByComparator orderByComparator, boolean previous) {
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

		query.append(_FINDER_COLUMN_G_CA_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(version);

		qPos.add(status);

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
	 * Removes all the contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_CA_V_S(long groupId, long categoryId, int version,
		int status) throws SystemException {
		for (Content content : findByG_CA_V_S(groupId, categoryId, version,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_CA_V_S(long groupId, long categoryId, int version,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_CA_V_S;

		Object[] finderArgs = new Object[] { groupId, categoryId, version, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_CA_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CA_V_S_CATEGORYID_2);

			query.append(_FINDER_COLUMN_G_CA_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_CA_V_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(version);

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

	/**
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_CA_V_S(long groupId, long categoryId,
		int version, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_CA_V_S(groupId, categoryId, version, status);
		}

		StringBundler query = new StringBundler(5);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_CA_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CA_V_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(version);

			qPos.add(status);

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

	private static final String _FINDER_COLUMN_G_CA_V_S_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_V_S_CATEGORYID_2 = "content.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_V_S_VERSION_2 = "content.version = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_V_S_STATUS_2 = "content.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_B_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_B_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_B_U =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_B_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.CREATEDBYUSERID_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_B_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_B_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contents where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_B_U(long groupId, long createdByUserId)
		throws SystemException {
		return findByG_C_B_U(groupId, createdByUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_B_U(long groupId, long createdByUserId,
		int start, int end) throws SystemException {
		return findByG_C_B_U(groupId, createdByUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_B_U(long groupId, long createdByUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_B_U;
			finderArgs = new Object[] { groupId, createdByUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_B_U;
			finderArgs = new Object[] {
					groupId, createdByUserId,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(createdByUserId != content.getCreatedByUserId())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_C_B_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_B_U_CREATEDBYUSERID_2);

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

				qPos.add(groupId);

				qPos.add(createdByUserId);

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
	 * Returns the first content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_C_B_U_First(long groupId, long createdByUserId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_C_B_U_First(groupId, createdByUserId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", createdByUserId=");
		msg.append(createdByUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_C_B_U_First(long groupId, long createdByUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_C_B_U(groupId, createdByUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_C_B_U_Last(long groupId, long createdByUserId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_C_B_U_Last(groupId, createdByUserId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", createdByUserId=");
		msg.append(createdByUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_C_B_U_Last(long groupId, long createdByUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_C_B_U(groupId, createdByUserId);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_C_B_U(groupId, createdByUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_C_B_U_PrevAndNext(long autoId, long groupId,
		long createdByUserId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_C_B_U_PrevAndNext(session, content, groupId,
					createdByUserId, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_C_B_U_PrevAndNext(session, content, groupId,
					createdByUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_C_B_U_PrevAndNext(Session session,
		Content content, long groupId, long createdByUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_C_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_B_U_CREATEDBYUSERID_2);

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

		qPos.add(groupId);

		qPos.add(createdByUserId);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_B_U(long groupId, long createdByUserId)
		throws SystemException {
		return filterFindByG_C_B_U(groupId, createdByUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_B_U(long groupId,
		long createdByUserId, int start, int end) throws SystemException {
		return filterFindByG_C_B_U(groupId, createdByUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_B_U(long groupId,
		long createdByUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_B_U(groupId, createdByUserId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_B_U_CREATEDBYUSERID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(createdByUserId);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_C_B_U_PrevAndNext(long autoId, long groupId,
		long createdByUserId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_B_U_PrevAndNext(autoId, groupId, createdByUserId,
				orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_C_B_U_PrevAndNext(session, content,
					groupId, createdByUserId, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_C_B_U_PrevAndNext(session, content,
					groupId, createdByUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_C_B_U_PrevAndNext(Session session,
		Content content, long groupId, long createdByUserId,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_B_U_CREATEDBYUSERID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(createdByUserId);

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
	 * Removes all the contents where groupId = &#63; and createdByUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_C_B_U(long groupId, long createdByUserId)
		throws SystemException {
		for (Content content : findByG_C_B_U(groupId, createdByUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C_B_U(long groupId, long createdByUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C_B_U;

		Object[] finderArgs = new Object[] { groupId, createdByUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_C_B_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_B_U_CREATEDBYUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(createdByUserId);

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
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_C_B_U(long groupId, long createdByUserId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_B_U(groupId, createdByUserId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_C_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_B_U_CREATEDBYUSERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(createdByUserId);

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

	private static final String _FINDER_COLUMN_G_C_B_U_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_B_U_CREATEDBYUSERID_2 = "content.createdByUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_E_B_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_E_B_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_B_U =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_E_B_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.EDITEDBYUSERID_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_E_B_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_E_B_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contents where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_E_B_U(long groupId, long editedByUserId)
		throws SystemException {
		return findByG_E_B_U(groupId, editedByUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_E_B_U(long groupId, long editedByUserId,
		int start, int end) throws SystemException {
		return findByG_E_B_U(groupId, editedByUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_E_B_U(long groupId, long editedByUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_B_U;
			finderArgs = new Object[] { groupId, editedByUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_E_B_U;
			finderArgs = new Object[] {
					groupId, editedByUserId,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(editedByUserId != content.getEditedByUserId())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_E_B_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_E_B_U_EDITEDBYUSERID_2);

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

				qPos.add(groupId);

				qPos.add(editedByUserId);

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
	 * Returns the first content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_E_B_U_First(long groupId, long editedByUserId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_E_B_U_First(groupId, editedByUserId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", editedByUserId=");
		msg.append(editedByUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_E_B_U_First(long groupId, long editedByUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_E_B_U(groupId, editedByUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_E_B_U_Last(long groupId, long editedByUserId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_E_B_U_Last(groupId, editedByUserId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", editedByUserId=");
		msg.append(editedByUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_E_B_U_Last(long groupId, long editedByUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_E_B_U(groupId, editedByUserId);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_E_B_U(groupId, editedByUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_E_B_U_PrevAndNext(long autoId, long groupId,
		long editedByUserId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_E_B_U_PrevAndNext(session, content, groupId,
					editedByUserId, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_E_B_U_PrevAndNext(session, content, groupId,
					editedByUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_E_B_U_PrevAndNext(Session session,
		Content content, long groupId, long editedByUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_E_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_B_U_EDITEDBYUSERID_2);

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

		qPos.add(groupId);

		qPos.add(editedByUserId);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_E_B_U(long groupId, long editedByUserId)
		throws SystemException {
		return filterFindByG_E_B_U(groupId, editedByUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_E_B_U(long groupId, long editedByUserId,
		int start, int end) throws SystemException {
		return filterFindByG_E_B_U(groupId, editedByUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_E_B_U(long groupId, long editedByUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_E_B_U(groupId, editedByUserId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_E_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_B_U_EDITEDBYUSERID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(editedByUserId);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_E_B_U_PrevAndNext(long autoId, long groupId,
		long editedByUserId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_E_B_U_PrevAndNext(autoId, groupId, editedByUserId,
				orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_E_B_U_PrevAndNext(session, content,
					groupId, editedByUserId, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_E_B_U_PrevAndNext(session, content,
					groupId, editedByUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_E_B_U_PrevAndNext(Session session,
		Content content, long groupId, long editedByUserId,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_E_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_B_U_EDITEDBYUSERID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(editedByUserId);

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
	 * Removes all the contents where groupId = &#63; and editedByUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_E_B_U(long groupId, long editedByUserId)
		throws SystemException {
		for (Content content : findByG_E_B_U(groupId, editedByUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_E_B_U(long groupId, long editedByUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_E_B_U;

		Object[] finderArgs = new Object[] { groupId, editedByUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_E_B_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_E_B_U_EDITEDBYUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(editedByUserId);

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
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and editedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param editedByUserId the edited by user ID
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_E_B_U(long groupId, long editedByUserId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_E_B_U(groupId, editedByUserId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_E_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_B_U_EDITEDBYUSERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(editedByUserId);

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

	private static final String _FINDER_COLUMN_G_E_B_U_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_E_B_U_EDITEDBYUSERID_2 = "content.editedByUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_R_B_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_R_B_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R_B_U =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_R_B_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.REVIEWEDBYUSERID_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_R_B_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_R_B_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contents where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_R_B_U(long groupId, long reviewedByUserId)
		throws SystemException {
		return findByG_R_B_U(groupId, reviewedByUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_R_B_U(long groupId, long reviewedByUserId,
		int start, int end) throws SystemException {
		return findByG_R_B_U(groupId, reviewedByUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_R_B_U(long groupId, long reviewedByUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R_B_U;
			finderArgs = new Object[] { groupId, reviewedByUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_R_B_U;
			finderArgs = new Object[] {
					groupId, reviewedByUserId,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(reviewedByUserId != content.getReviewedByUserId())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_R_B_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_B_U_REVIEWEDBYUSERID_2);

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

				qPos.add(groupId);

				qPos.add(reviewedByUserId);

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
	 * Returns the first content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_R_B_U_First(long groupId, long reviewedByUserId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_R_B_U_First(groupId, reviewedByUserId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", reviewedByUserId=");
		msg.append(reviewedByUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_R_B_U_First(long groupId, long reviewedByUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_R_B_U(groupId, reviewedByUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_R_B_U_Last(long groupId, long reviewedByUserId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_R_B_U_Last(groupId, reviewedByUserId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", reviewedByUserId=");
		msg.append(reviewedByUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_R_B_U_Last(long groupId, long reviewedByUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_R_B_U(groupId, reviewedByUserId);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_R_B_U(groupId, reviewedByUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_R_B_U_PrevAndNext(long autoId, long groupId,
		long reviewedByUserId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_R_B_U_PrevAndNext(session, content, groupId,
					reviewedByUserId, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_R_B_U_PrevAndNext(session, content, groupId,
					reviewedByUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_R_B_U_PrevAndNext(Session session,
		Content content, long groupId, long reviewedByUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_R_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_B_U_REVIEWEDBYUSERID_2);

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

		qPos.add(groupId);

		qPos.add(reviewedByUserId);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_R_B_U(long groupId, long reviewedByUserId)
		throws SystemException {
		return filterFindByG_R_B_U(groupId, reviewedByUserId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_R_B_U(long groupId,
		long reviewedByUserId, int start, int end) throws SystemException {
		return filterFindByG_R_B_U(groupId, reviewedByUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_R_B_U(long groupId,
		long reviewedByUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_R_B_U(groupId, reviewedByUserId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_R_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_B_U_REVIEWEDBYUSERID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(reviewedByUserId);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_R_B_U_PrevAndNext(long autoId, long groupId,
		long reviewedByUserId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_R_B_U_PrevAndNext(autoId, groupId, reviewedByUserId,
				orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_R_B_U_PrevAndNext(session, content,
					groupId, reviewedByUserId, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_R_B_U_PrevAndNext(session, content,
					groupId, reviewedByUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_R_B_U_PrevAndNext(Session session,
		Content content, long groupId, long reviewedByUserId,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_R_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_B_U_REVIEWEDBYUSERID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(reviewedByUserId);

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
	 * Removes all the contents where groupId = &#63; and reviewedByUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_R_B_U(long groupId, long reviewedByUserId)
		throws SystemException {
		for (Content content : findByG_R_B_U(groupId, reviewedByUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_R_B_U(long groupId, long reviewedByUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_R_B_U;

		Object[] finderArgs = new Object[] { groupId, reviewedByUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_R_B_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_B_U_REVIEWEDBYUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(reviewedByUserId);

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
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and reviewedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param reviewedByUserId the reviewed by user ID
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_R_B_U(long groupId, long reviewedByUserId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_R_B_U(groupId, reviewedByUserId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_R_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_B_U_REVIEWEDBYUSERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(reviewedByUserId);

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

	private static final String _FINDER_COLUMN_G_R_B_U_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_B_U_REVIEWEDBYUSERID_2 = "content.reviewedByUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P_B_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_P_B_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_B_U =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_P_B_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.PUBLISHEDBYUSERID_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P_B_U = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_P_B_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contents where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_P_B_U(long groupId, long publishedByUserId)
		throws SystemException {
		return findByG_P_B_U(groupId, publishedByUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_P_B_U(long groupId, long publishedByUserId,
		int start, int end) throws SystemException {
		return findByG_P_B_U(groupId, publishedByUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_P_B_U(long groupId, long publishedByUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_B_U;
			finderArgs = new Object[] { groupId, publishedByUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P_B_U;
			finderArgs = new Object[] {
					groupId, publishedByUserId,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(publishedByUserId != content.getPublishedByUserId())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_P_B_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_B_U_PUBLISHEDBYUSERID_2);

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

				qPos.add(groupId);

				qPos.add(publishedByUserId);

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
	 * Returns the first content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_P_B_U_First(long groupId, long publishedByUserId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_P_B_U_First(groupId, publishedByUserId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", publishedByUserId=");
		msg.append(publishedByUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_P_B_U_First(long groupId, long publishedByUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_P_B_U(groupId, publishedByUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_P_B_U_Last(long groupId, long publishedByUserId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_P_B_U_Last(groupId, publishedByUserId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", publishedByUserId=");
		msg.append(publishedByUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_P_B_U_Last(long groupId, long publishedByUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_P_B_U(groupId, publishedByUserId);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_P_B_U(groupId, publishedByUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_P_B_U_PrevAndNext(long autoId, long groupId,
		long publishedByUserId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_P_B_U_PrevAndNext(session, content, groupId,
					publishedByUserId, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_P_B_U_PrevAndNext(session, content, groupId,
					publishedByUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_P_B_U_PrevAndNext(Session session,
		Content content, long groupId, long publishedByUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_P_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_B_U_PUBLISHEDBYUSERID_2);

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

		qPos.add(groupId);

		qPos.add(publishedByUserId);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_P_B_U(long groupId,
		long publishedByUserId) throws SystemException {
		return filterFindByG_P_B_U(groupId, publishedByUserId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_P_B_U(long groupId,
		long publishedByUserId, int start, int end) throws SystemException {
		return filterFindByG_P_B_U(groupId, publishedByUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_P_B_U(long groupId,
		long publishedByUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P_B_U(groupId, publishedByUserId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_B_U_PUBLISHEDBYUSERID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(publishedByUserId);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_P_B_U_PrevAndNext(long autoId, long groupId,
		long publishedByUserId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P_B_U_PrevAndNext(autoId, groupId,
				publishedByUserId, orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_P_B_U_PrevAndNext(session, content,
					groupId, publishedByUserId, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_P_B_U_PrevAndNext(session, content,
					groupId, publishedByUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_P_B_U_PrevAndNext(Session session,
		Content content, long groupId, long publishedByUserId,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_B_U_PUBLISHEDBYUSERID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(publishedByUserId);

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
	 * Removes all the contents where groupId = &#63; and publishedByUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_P_B_U(long groupId, long publishedByUserId)
		throws SystemException {
		for (Content content : findByG_P_B_U(groupId, publishedByUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_P_B_U(long groupId, long publishedByUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_P_B_U;

		Object[] finderArgs = new Object[] { groupId, publishedByUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_P_B_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_B_U_PUBLISHEDBYUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(publishedByUserId);

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
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and publishedByUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishedByUserId the published by user ID
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_P_B_U(long groupId, long publishedByUserId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_P_B_U(groupId, publishedByUserId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_P_B_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_B_U_PUBLISHEDBYUSERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(publishedByUserId);

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

	private static final String _FINDER_COLUMN_G_P_B_U_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_B_U_PUBLISHEDBYUSERID_2 = "content.publishedByUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_V = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.CONTENTID_COLUMN_BITMASK |
			ContentModelImpl.VERSION_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_V = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the contents where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_V(long groupId, long contentId, int version)
		throws SystemException {
		return findByG_C_V(groupId, contentId, version, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_V(long groupId, long contentId, int version,
		int start, int end) throws SystemException {
		return findByG_C_V(groupId, contentId, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_V(long groupId, long contentId, int version,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V;
			finderArgs = new Object[] { groupId, contentId, version };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_V;
			finderArgs = new Object[] {
					groupId, contentId, version,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(contentId != content.getContentId()) ||
						(version != content.getVersion())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_C_V_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_V_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_C_V_VERSION_2);

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

				qPos.add(groupId);

				qPos.add(contentId);

				qPos.add(version);

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
	 * Returns the first content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_C_V_First(long groupId, long contentId, int version,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_C_V_First(groupId, contentId, version,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(", version=");
		msg.append(version);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_C_V_First(long groupId, long contentId,
		int version, OrderByComparator orderByComparator)
		throws SystemException {
		List<Content> list = findByG_C_V(groupId, contentId, version, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_C_V_Last(long groupId, long contentId, int version,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_C_V_Last(groupId, contentId, version,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(", version=");
		msg.append(version);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_C_V_Last(long groupId, long contentId, int version,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_C_V(groupId, contentId, version);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_C_V(groupId, contentId, version,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_C_V_PrevAndNext(long autoId, long groupId,
		long contentId, int version, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_C_V_PrevAndNext(session, content, groupId,
					contentId, version, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_C_V_PrevAndNext(session, content, groupId,
					contentId, version, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_C_V_PrevAndNext(Session session, Content content,
		long groupId, long contentId, int version,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_C_V_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_VERSION_2);

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

		qPos.add(groupId);

		qPos.add(contentId);

		qPos.add(version);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_V(long groupId, long contentId,
		int version) throws SystemException {
		return filterFindByG_C_V(groupId, contentId, version,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_V(long groupId, long contentId,
		int version, int start, int end) throws SystemException {
		return filterFindByG_C_V(groupId, contentId, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_V(long groupId, long contentId,
		int version, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_V(groupId, contentId, version, start, end,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_V_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_VERSION_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(contentId);

			qPos.add(version);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_C_V_PrevAndNext(long autoId, long groupId,
		long contentId, int version, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_V_PrevAndNext(autoId, groupId, contentId, version,
				orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_C_V_PrevAndNext(session, content, groupId,
					contentId, version, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_C_V_PrevAndNext(session, content, groupId,
					contentId, version, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_C_V_PrevAndNext(Session session,
		Content content, long groupId, long contentId, int version,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_V_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_VERSION_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(contentId);

		qPos.add(version);

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
	 * Removes all the contents where groupId = &#63; and contentId = &#63; and version = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_C_V(long groupId, long contentId, int version)
		throws SystemException {
		for (Content content : findByG_C_V(groupId, contentId, version,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C_V(long groupId, long contentId, int version)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C_V;

		Object[] finderArgs = new Object[] { groupId, contentId, version };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_C_V_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_V_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_C_V_VERSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentId);

				qPos.add(version);

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
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_C_V(long groupId, long contentId, int version)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_V(groupId, contentId, version);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_C_V_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_VERSION_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contentId);

			qPos.add(version);

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

	private static final String _FINDER_COLUMN_G_C_V_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_CONTENTID_2 = "content.contentId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_VERSION_2 = "content.version = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CO = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_CO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_CO",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.CONTENTID_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CO = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CO",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contents where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CO(long groupId, long contentId)
		throws SystemException {
		return findByG_CO(groupId, contentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CO(long groupId, long contentId, int start,
		int end) throws SystemException {
		return findByG_CO(groupId, contentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CO(long groupId, long contentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO;
			finderArgs = new Object[] { groupId, contentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CO;
			finderArgs = new Object[] {
					groupId, contentId,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(contentId != content.getContentId())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_CO_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CO_CONTENTID_2);

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

				qPos.add(groupId);

				qPos.add(contentId);

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
	 * Returns the first content in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_CO_First(long groupId, long contentId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_CO_First(groupId, contentId,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_CO_First(long groupId, long contentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_CO(groupId, contentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_CO_Last(long groupId, long contentId,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_CO_Last(groupId, contentId, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_CO_Last(long groupId, long contentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_CO(groupId, contentId);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_CO(groupId, contentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_CO_PrevAndNext(long autoId, long groupId,
		long contentId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_CO_PrevAndNext(session, content, groupId,
					contentId, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_CO_PrevAndNext(session, content, groupId,
					contentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_CO_PrevAndNext(Session session, Content content,
		long groupId, long contentId, OrderByComparator orderByComparator,
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

		query.append(_FINDER_COLUMN_G_CO_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CO_CONTENTID_2);

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

		qPos.add(groupId);

		qPos.add(contentId);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CO(long groupId, long contentId)
		throws SystemException {
		return filterFindByG_CO(groupId, contentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CO(long groupId, long contentId,
		int start, int end) throws SystemException {
		return filterFindByG_CO(groupId, contentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CO(long groupId, long contentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_CO(groupId, contentId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_CO_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CO_CONTENTID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(contentId);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and contentId = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_CO_PrevAndNext(long autoId, long groupId,
		long contentId, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_CO_PrevAndNext(autoId, groupId, contentId,
				orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_CO_PrevAndNext(session, content, groupId,
					contentId, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_CO_PrevAndNext(session, content, groupId,
					contentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_CO_PrevAndNext(Session session,
		Content content, long groupId, long contentId,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_CO_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CO_CONTENTID_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(contentId);

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
	 * Removes all the contents where groupId = &#63; and contentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_CO(long groupId, long contentId)
		throws SystemException {
		for (Content content : findByG_CO(groupId, contentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_CO(long groupId, long contentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_CO;

		Object[] finderArgs = new Object[] { groupId, contentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_CO_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CO_CONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentId);

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
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_CO(long groupId, long contentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_CO(groupId, contentId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_CO_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CO_CONTENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contentId);

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

	private static final String _FINDER_COLUMN_G_CO_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CO_CONTENTID_2 = "content.contentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_S =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.CONTENTID_COLUMN_BITMASK |
			ContentModelImpl.VERSION_COLUMN_BITMASK |
			ContentModelImpl.STATUS_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_V_S(long groupId, long contentId,
		int version, int status) throws SystemException {
		return findByG_C_V_S(groupId, contentId, version, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_V_S(long groupId, long contentId,
		int version, int status, int start, int end) throws SystemException {
		return findByG_C_V_S(groupId, contentId, version, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_C_V_S(long groupId, long contentId,
		int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_S;
			finderArgs = new Object[] { groupId, contentId, version, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_V_S;
			finderArgs = new Object[] {
					groupId, contentId, version, status,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(contentId != content.getContentId()) ||
						(version != content.getVersion()) ||
						(status != content.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_C_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_V_S_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_C_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_C_V_S_STATUS_2);

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

				qPos.add(groupId);

				qPos.add(contentId);

				qPos.add(version);

				qPos.add(status);

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
	 * Returns the first content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_C_V_S_First(long groupId, long contentId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_C_V_S_First(groupId, contentId, version,
				status, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_C_V_S_First(long groupId, long contentId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Content> list = findByG_C_V_S(groupId, contentId, version, status,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_C_V_S_Last(long groupId, long contentId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_C_V_S_Last(groupId, contentId, version,
				status, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_C_V_S_Last(long groupId, long contentId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_C_V_S(groupId, contentId, version, status);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_C_V_S(groupId, contentId, version, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_C_V_S_PrevAndNext(long autoId, long groupId,
		long contentId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_C_V_S_PrevAndNext(session, content, groupId,
					contentId, version, status, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_C_V_S_PrevAndNext(session, content, groupId,
					contentId, version, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_C_V_S_PrevAndNext(Session session,
		Content content, long groupId, long contentId, int version, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_C_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_S_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_C_V_S_STATUS_2);

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

		qPos.add(groupId);

		qPos.add(contentId);

		qPos.add(version);

		qPos.add(status);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_V_S(long groupId, long contentId,
		int version, int status) throws SystemException {
		return filterFindByG_C_V_S(groupId, contentId, version, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_V_S(long groupId, long contentId,
		int version, int status, int start, int end) throws SystemException {
		return filterFindByG_C_V_S(groupId, contentId, version, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_C_V_S(long groupId, long contentId,
		int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_V_S(groupId, contentId, version, status, start,
				end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_S_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_C_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(contentId);

			qPos.add(version);

			qPos.add(status);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_C_V_S_PrevAndNext(long autoId, long groupId,
		long contentId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_V_S_PrevAndNext(autoId, groupId, contentId,
				version, status, orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_C_V_S_PrevAndNext(session, content,
					groupId, contentId, version, status, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_C_V_S_PrevAndNext(session, content,
					groupId, contentId, version, status, orderByComparator,
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

	protected Content filterGetByG_C_V_S_PrevAndNext(Session session,
		Content content, long groupId, long contentId, int version, int status,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_S_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_C_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(contentId);

		qPos.add(version);

		qPos.add(status);

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
	 * Removes all the contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_C_V_S(long groupId, long contentId, int version,
		int status) throws SystemException {
		for (Content content : findByG_C_V_S(groupId, contentId, version,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C_V_S(long groupId, long contentId, int version,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C_V_S;

		Object[] finderArgs = new Object[] { groupId, contentId, version, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_C_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_V_S_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_C_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_C_V_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentId);

				qPos.add(version);

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

	/**
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_C_V_S(long groupId, long contentId, int version,
		int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_V_S(groupId, contentId, version, status);
		}

		StringBundler query = new StringBundler(5);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_C_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_V_S_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_C_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_C_V_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contentId);

			qPos.add(version);

			qPos.add(status);

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

	private static final String _FINDER_COLUMN_G_C_V_S_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_S_CONTENTID_2 = "content.contentId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_S_VERSION_2 = "content.version = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_S_STATUS_2 = "content.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CA_AU_V_S =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_CA_AU_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_AU_V_S =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_CA_AU_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.CATEGORYID_COLUMN_BITMASK |
			ContentModelImpl.CREATEDBYUSERID_COLUMN_BITMASK |
			ContentModelImpl.VERSION_COLUMN_BITMASK |
			ContentModelImpl.STATUS_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CA_AU_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CA_AU_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status)
		throws SystemException {
		return findByG_CA_AU_V_S(groupId, categoryId, createdByUserId, version,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status, int start, int end)
		throws SystemException {
		return findByG_CA_AU_V_S(groupId, categoryId, createdByUserId, version,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_AU_V_S;
			finderArgs = new Object[] {
					groupId, categoryId, createdByUserId, version, status
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CA_AU_V_S;
			finderArgs = new Object[] {
					groupId, categoryId, createdByUserId, version, status,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(categoryId != content.getCategoryId()) ||
						(createdByUserId != content.getCreatedByUserId()) ||
						(version != content.getVersion()) ||
						(status != content.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_CATEGORYID_2);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_CREATEDBYUSERID_2);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_STATUS_2);

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

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(createdByUserId);

				qPos.add(version);

				qPos.add(status);

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
	 * Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_CA_AU_V_S_First(long groupId, long categoryId,
		long createdByUserId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_CA_AU_V_S_First(groupId, categoryId,
				createdByUserId, version, status, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", createdByUserId=");
		msg.append(createdByUserId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_CA_AU_V_S_First(long groupId, long categoryId,
		long createdByUserId, int version, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_CA_AU_V_S(groupId, categoryId,
				createdByUserId, version, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_CA_AU_V_S_Last(long groupId, long categoryId,
		long createdByUserId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_CA_AU_V_S_Last(groupId, categoryId,
				createdByUserId, version, status, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", createdByUserId=");
		msg.append(createdByUserId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_CA_AU_V_S_Last(long groupId, long categoryId,
		long createdByUserId, int version, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
				version, status);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_CA_AU_V_S(groupId, categoryId,
				createdByUserId, version, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_CA_AU_V_S_PrevAndNext(long autoId, long groupId,
		long categoryId, long createdByUserId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_CA_AU_V_S_PrevAndNext(session, content, groupId,
					categoryId, createdByUserId, version, status,
					orderByComparator, true);

			array[1] = content;

			array[2] = getByG_CA_AU_V_S_PrevAndNext(session, content, groupId,
					categoryId, createdByUserId, version, status,
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

	protected Content getByG_CA_AU_V_S_PrevAndNext(Session session,
		Content content, long groupId, long categoryId, long createdByUserId,
		int version, int status, OrderByComparator orderByComparator,
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

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_CREATEDBYUSERID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_STATUS_2);

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

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(createdByUserId);

		qPos.add(version);

		qPos.add(status);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status)
		throws SystemException {
		return filterFindByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
			version, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status, int start, int end)
		throws SystemException {
		return filterFindByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
			version, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
				version, status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(7);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_CREATEDBYUSERID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(createdByUserId);

			qPos.add(version);

			qPos.add(status);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_CA_AU_V_S_PrevAndNext(long autoId,
		long groupId, long categoryId, long createdByUserId, int version,
		int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_CA_AU_V_S_PrevAndNext(autoId, groupId, categoryId,
				createdByUserId, version, status, orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_CA_AU_V_S_PrevAndNext(session, content,
					groupId, categoryId, createdByUserId, version, status,
					orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_CA_AU_V_S_PrevAndNext(session, content,
					groupId, categoryId, createdByUserId, version, status,
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

	protected Content filterGetByG_CA_AU_V_S_PrevAndNext(Session session,
		Content content, long groupId, long categoryId, long createdByUserId,
		int version, int status, OrderByComparator orderByComparator,
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

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_CREATEDBYUSERID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(createdByUserId);

		qPos.add(version);

		qPos.add(status);

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
	 * Removes all the contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status)
		throws SystemException {
		for (Content content : findByG_CA_AU_V_S(groupId, categoryId,
				createdByUserId, version, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_CA_AU_V_S;

		Object[] finderArgs = new Object[] {
				groupId, categoryId, createdByUserId, version, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_CATEGORYID_2);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_CREATEDBYUSERID_2);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_CA_AU_V_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(createdByUserId);

				qPos.add(version);

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

	/**
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
				version, status);
		}

		StringBundler query = new StringBundler(6);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_CREATEDBYUSERID_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CA_AU_V_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(createdByUserId);

			qPos.add(version);

			qPos.add(status);

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

	private static final String _FINDER_COLUMN_G_CA_AU_V_S_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_AU_V_S_CATEGORYID_2 = "content.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_AU_V_S_CREATEDBYUSERID_2 = "content.createdByUserId = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_AU_V_S_VERSION_2 = "content.version = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_AU_V_S_STATUS_2 = "content.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_V_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_V_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.VERSION_COLUMN_BITMASK |
			ContentModelImpl.STATUS_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_V_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the contents where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_V_S(long groupId, int version, int status)
		throws SystemException {
		return findByG_V_S(groupId, version, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_V_S(long groupId, int version, int status,
		int start, int end) throws SystemException {
		return findByG_V_S(groupId, version, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_V_S(long groupId, int version, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_V_S;
			finderArgs = new Object[] { groupId, version, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_V_S;
			finderArgs = new Object[] {
					groupId, version, status,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(version != content.getVersion()) ||
						(status != content.getStatus())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_V_S_STATUS_2);

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

				qPos.add(groupId);

				qPos.add(version);

				qPos.add(status);

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
	 * Returns the first content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_V_S_First(long groupId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_V_S_First(groupId, version, status,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_V_S_First(long groupId, int version, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByG_V_S(groupId, version, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_V_S_Last(long groupId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_V_S_Last(groupId, version, status,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_V_S_Last(long groupId, int version, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_V_S(groupId, version, status);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_V_S(groupId, version, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_V_S_PrevAndNext(long autoId, long groupId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_V_S_PrevAndNext(session, content, groupId,
					version, status, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_V_S_PrevAndNext(session, content, groupId,
					version, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_V_S_PrevAndNext(Session session, Content content,
		long groupId, int version, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_V_S_STATUS_2);

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

		qPos.add(groupId);

		qPos.add(version);

		qPos.add(status);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_V_S(long groupId, int version, int status)
		throws SystemException {
		return filterFindByG_V_S(groupId, version, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_V_S(long groupId, int version,
		int status, int start, int end) throws SystemException {
		return filterFindByG_V_S(groupId, version, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_V_S(long groupId, int version,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_V_S(groupId, version, status, start, end,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(version);

			qPos.add(status);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_V_S_PrevAndNext(long autoId, long groupId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_V_S_PrevAndNext(autoId, groupId, version, status,
				orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_V_S_PrevAndNext(session, content, groupId,
					version, status, orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_V_S_PrevAndNext(session, content, groupId,
					version, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content filterGetByG_V_S_PrevAndNext(Session session,
		Content content, long groupId, int version, int status,
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
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(version);

		qPos.add(status);

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
	 * Removes all the contents where groupId = &#63; and version = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_V_S(long groupId, int version, int status)
		throws SystemException {
		for (Content content : findByG_V_S(groupId, version, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_V_S(long groupId, int version, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_V_S;

		Object[] finderArgs = new Object[] { groupId, version, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_V_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(version);

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

	/**
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_V_S(long groupId, int version, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_V_S(groupId, version, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_V_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(version);

			qPos.add(status);

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

	private static final String _FINDER_COLUMN_G_V_S_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_V_S_VERSION_2 = "content.version = ? AND ";
	private static final String _FINDER_COLUMN_G_V_S_STATUS_2 = "content.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_AU_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_AU_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AU_V_S =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_AU_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			ContentModelImpl.GROUPID_COLUMN_BITMASK |
			ContentModelImpl.CREATEDBYUSERID_COLUMN_BITMASK |
			ContentModelImpl.VERSION_COLUMN_BITMASK |
			ContentModelImpl.STATUS_COLUMN_BITMASK |
			ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_AU_V_S = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_AU_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_AU_V_S(long groupId, long createdByUserId,
		int version, int status) throws SystemException {
		return findByG_AU_V_S(groupId, createdByUserId, version, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_AU_V_S(long groupId, long createdByUserId,
		int version, int status, int start, int end) throws SystemException {
		return findByG_AU_V_S(groupId, createdByUserId, version, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByG_AU_V_S(long groupId, long createdByUserId,
		int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AU_V_S;
			finderArgs = new Object[] { groupId, createdByUserId, version, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_AU_V_S;
			finderArgs = new Object[] {
					groupId, createdByUserId, version, status,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((groupId != content.getGroupId()) ||
						(createdByUserId != content.getCreatedByUserId()) ||
						(version != content.getVersion()) ||
						(status != content.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_AU_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_AU_V_S_CREATEDBYUSERID_2);

			query.append(_FINDER_COLUMN_G_AU_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_AU_V_S_STATUS_2);

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

				qPos.add(groupId);

				qPos.add(createdByUserId);

				qPos.add(version);

				qPos.add(status);

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
	 * Returns the first content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_AU_V_S_First(long groupId, long createdByUserId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_AU_V_S_First(groupId, createdByUserId,
				version, status, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", createdByUserId=");
		msg.append(createdByUserId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_AU_V_S_First(long groupId, long createdByUserId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Content> list = findByG_AU_V_S(groupId, createdByUserId, version,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByG_AU_V_S_Last(long groupId, long createdByUserId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByG_AU_V_S_Last(groupId, createdByUserId,
				version, status, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", createdByUserId=");
		msg.append(createdByUserId);

		msg.append(", version=");
		msg.append(version);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByG_AU_V_S_Last(long groupId, long createdByUserId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_AU_V_S(groupId, createdByUserId, version, status);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByG_AU_V_S(groupId, createdByUserId, version,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByG_AU_V_S_PrevAndNext(long autoId, long groupId,
		long createdByUserId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByG_AU_V_S_PrevAndNext(session, content, groupId,
					createdByUserId, version, status, orderByComparator, true);

			array[1] = content;

			array[2] = getByG_AU_V_S_PrevAndNext(session, content, groupId,
					createdByUserId, version, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByG_AU_V_S_PrevAndNext(Session session,
		Content content, long groupId, long createdByUserId, int version,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_AU_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_CREATEDBYUSERID_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_STATUS_2);

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

		qPos.add(groupId);

		qPos.add(createdByUserId);

		qPos.add(version);

		qPos.add(status);

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
	 * Returns all the contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @return the matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_AU_V_S(long groupId,
		long createdByUserId, int version, int status)
		throws SystemException {
		return filterFindByG_AU_V_S(groupId, createdByUserId, version, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_AU_V_S(long groupId,
		long createdByUserId, int version, int status, int start, int end)
		throws SystemException {
		return filterFindByG_AU_V_S(groupId, createdByUserId, version, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> filterFindByG_AU_V_S(long groupId,
		long createdByUserId, int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_AU_V_S(groupId, createdByUserId, version, status,
				start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_AU_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_CREATEDBYUSERID_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

			qPos.add(groupId);

			qPos.add(createdByUserId);

			qPos.add(version);

			qPos.add(status);

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
	 * Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] filterFindByG_AU_V_S_PrevAndNext(long autoId,
		long groupId, long createdByUserId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_AU_V_S_PrevAndNext(autoId, groupId, createdByUserId,
				version, status, orderByComparator);
		}

		Content content = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = filterGetByG_AU_V_S_PrevAndNext(session, content,
					groupId, createdByUserId, version, status,
					orderByComparator, true);

			array[1] = content;

			array[2] = filterGetByG_AU_V_S_PrevAndNext(session, content,
					groupId, createdByUserId, version, status,
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

	protected Content filterGetByG_AU_V_S_PrevAndNext(Session session,
		Content content, long groupId, long createdByUserId, int version,
		int status, OrderByComparator orderByComparator, boolean previous) {
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

		query.append(_FINDER_COLUMN_G_AU_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_CREATEDBYUSERID_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_STATUS_2);

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
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

		qPos.add(groupId);

		qPos.add(createdByUserId);

		qPos.add(version);

		qPos.add(status);

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
	 * Removes all the contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_AU_V_S(long groupId, long createdByUserId,
		int version, int status) throws SystemException {
		for (Content content : findByG_AU_V_S(groupId, createdByUserId,
				version, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_AU_V_S(long groupId, long createdByUserId, int version,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_AU_V_S;

		Object[] finderArgs = new Object[] {
				groupId, createdByUserId, version, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_G_AU_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_AU_V_S_CREATEDBYUSERID_2);

			query.append(_FINDER_COLUMN_G_AU_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_AU_V_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(createdByUserId);

				qPos.add(version);

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

	/**
	 * Returns the number of contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUserId the created by user ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_AU_V_S(long groupId, long createdByUserId,
		int version, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_AU_V_S(groupId, createdByUserId, version, status);
		}

		StringBundler query = new StringBundler(5);

		query.append(_FILTER_SQL_COUNT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_G_AU_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_CREATEDBYUSERID_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_AU_V_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Content.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(createdByUserId);

			qPos.add(version);

			qPos.add(status);

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

	private static final String _FINDER_COLUMN_G_AU_V_S_GROUPID_2 = "content.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_AU_V_S_CREATEDBYUSERID_2 = "content.createdByUserId = ? AND ";
	private static final String _FINDER_COLUMN_G_AU_V_S_VERSION_2 = "content.version = ? AND ";
	private static final String _FINDER_COLUMN_G_AU_V_S_STATUS_2 = "content.status = ?";

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
	 * @param autoId the primary key for the new content
	 * @return the new content
	 */
	@Override
	public Content create(long autoId) {
		Content content = new ContentImpl();

		content.setNew(true);
		content.setPrimaryKey(autoId);

		return content;
	}

	/**
	 * Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autoId the primary key of the content
	 * @return the content that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content remove(long autoId)
		throws NoSuchContentException, SystemException {
		return remove((Serializable)autoId);
	}

	/**
	 * Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content
	 * @return the content that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
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
	public Content updateImpl(com.viettel.portal.vcms.model.Content content)
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
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalUrlTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getUrlTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalCategoryId(),
						contentModelImpl.getOriginalVersion(),
						contentModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CA_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getCategoryId(),
						contentModelImpl.getVersion(),
						contentModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CA_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_B_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalCreatedByUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_B_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_B_U,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getCreatedByUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_B_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_B_U,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_B_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalEditedByUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E_B_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_B_U,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getEditedByUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E_B_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_B_U,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R_B_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalReviewedByUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_R_B_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R_B_U,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getReviewedByUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_R_B_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R_B_U,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_B_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalPublishedByUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P_B_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_B_U,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getPublishedByUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P_B_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_B_U,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalContentId(),
						contentModelImpl.getOriginalVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getContentId(),
						contentModelImpl.getVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalContentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getContentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalContentId(),
						contentModelImpl.getOriginalVersion(),
						contentModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_S,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getContentId(),
						contentModelImpl.getVersion(),
						contentModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V_S,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_AU_V_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalCategoryId(),
						contentModelImpl.getOriginalCreatedByUserId(),
						contentModelImpl.getOriginalVersion(),
						contentModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CA_AU_V_S,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_AU_V_S,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getCategoryId(),
						contentModelImpl.getCreatedByUserId(),
						contentModelImpl.getVersion(),
						contentModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CA_AU_V_S,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_AU_V_S,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_V_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalVersion(),
						contentModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_V_S,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getVersion(),
						contentModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_V_S,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AU_V_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalGroupId(),
						contentModelImpl.getOriginalCreatedByUserId(),
						contentModelImpl.getOriginalVersion(),
						contentModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_AU_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AU_V_S,
					args);

				args = new Object[] {
						contentModelImpl.getGroupId(),
						contentModelImpl.getCreatedByUserId(),
						contentModelImpl.getVersion(),
						contentModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_AU_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AU_V_S,
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

		contentImpl.setAutoId(content.getAutoId());
		contentImpl.setContentId(content.getContentId());
		contentImpl.setGroupId(content.getGroupId());
		contentImpl.setCompanyId(content.getCompanyId());
		contentImpl.setUserId(content.getUserId());
		contentImpl.setUserName(content.getUserName());
		contentImpl.setCreateDate(content.getCreateDate());
		contentImpl.setModifiedDate(content.getModifiedDate());
		contentImpl.setPreVersion(content.getPreVersion());
		contentImpl.setVersion(content.getVersion());
		contentImpl.setSubversion(content.getSubversion());
		contentImpl.setSubTitle(content.getSubTitle());
		contentImpl.setTitle(content.getTitle());
		contentImpl.setSummary(content.getSummary());
		contentImpl.setSubContent(content.getSubContent());
		contentImpl.setContent(content.getContent());
		contentImpl.setSmallImageId(content.getSmallImageId());
		contentImpl.setSmallImageUrl(content.getSmallImageUrl());
		contentImpl.setCategoryId(content.getCategoryId());
		contentImpl.setCopyRight(content.getCopyRight());
		contentImpl.setStatus(content.getStatus());
		contentImpl.setUrlTitle(content.getUrlTitle());
		contentImpl.setNewsType(content.getNewsType());
		contentImpl.setImageUrl(content.getImageUrl());
		contentImpl.setIsLegalContent(content.isIsLegalContent());
		contentImpl.setImageCaption(content.getImageCaption());
		contentImpl.setImagePosition(content.getImagePosition());
		contentImpl.setCreatedByUserId(content.getCreatedByUserId());
		contentImpl.setEditedByUserId(content.getEditedByUserId());
		contentImpl.setReviewedByUserId(content.getReviewedByUserId());
		contentImpl.setPublishedByUserId(content.getPublishedByUserId());
		contentImpl.setCreatedByUserName(content.getCreatedByUserName());
		contentImpl.setEditedByUserName(content.getEditedByUserName());
		contentImpl.setReviewedByUserName(content.getReviewedByUserName());
		contentImpl.setPublishedByUserName(content.getPublishedByUserName());
		contentImpl.setAuthor(content.getAuthor());
		contentImpl.setJobTitle(content.getJobTitle());

		return contentImpl;
	}

	/**
	 * Returns the content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the content
	 * @return the content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
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
	 * Returns the content with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentException} if it could not be found.
	 *
	 * @param autoId the primary key of the content
	 * @return the content
	 * @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByPrimaryKey(long autoId)
		throws NoSuchContentException, SystemException {
		return findByPrimaryKey((Serializable)autoId);
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
	 * @param autoId the primary key of the content
	 * @return the content, or <code>null</code> if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByPrimaryKey(long autoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)autoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
						"value.object.listener.com.viettel.portal.vcms.model.Content")));

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
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "content.autoId";
	private static final String _FILTER_SQL_SELECT_CONTENT_WHERE = "SELECT DISTINCT {content.*} FROM vcms_Content content WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {vcms_Content.*} FROM (SELECT DISTINCT content.autoId FROM vcms_Content content WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTENT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN vcms_Content ON TEMP_TABLE.autoId = vcms_Content.autoId";
	private static final String _FILTER_SQL_COUNT_CONTENT_WHERE = "SELECT COUNT(DISTINCT content.autoId) AS COUNT_VALUE FROM vcms_Content content WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "content";
	private static final String _FILTER_ENTITY_TABLE = "vcms_Content";
	private static final String _ORDER_BY_ENTITY_ALIAS = "content.";
	private static final String _ORDER_BY_ENTITY_TABLE = "vcms_Content.";
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