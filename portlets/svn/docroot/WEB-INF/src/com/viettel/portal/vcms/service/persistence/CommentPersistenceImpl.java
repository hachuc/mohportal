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

import com.viettel.portal.vcms.NoSuchCommentException;
import com.viettel.portal.vcms.model.Comment;
import com.viettel.portal.vcms.model.impl.CommentImpl;
import com.viettel.portal.vcms.model.impl.CommentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see CommentPersistence
 * @see CommentUtil
 * @generated
 */
public class CommentPersistenceImpl extends BasePersistenceImpl<Comment>
	implements CommentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CommentUtil} to access the comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CommentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_D = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_D",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_D",
			new String[] { Long.class.getName(), Long.class.getName() },
			CommentModelImpl.GROUPID_COLUMN_BITMASK |
			CommentModelImpl.DISTRIBUTIONID_COLUMN_BITMASK |
			CommentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_D = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_D",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the comments where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @return the matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByG_D(long groupId, long distributionId)
		throws SystemException {
		return findByG_D(groupId, distributionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comments where groupId = &#63; and distributionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByG_D(long groupId, long distributionId,
		int start, int end) throws SystemException {
		return findByG_D(groupId, distributionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comments where groupId = &#63; and distributionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByG_D(long groupId, long distributionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D;
			finderArgs = new Object[] { groupId, distributionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_D;
			finderArgs = new Object[] {
					groupId, distributionId,
					
					start, end, orderByComparator
				};
		}

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Comment comment : list) {
				if ((groupId != comment.getGroupId()) ||
						(distributionId != comment.getDistributionId())) {
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

			query.append(_SQL_SELECT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_G_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_D_DISTRIBUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(distributionId);

				if (!pagination) {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Comment>(list);
				}
				else {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws com.viettel.portal.vcms.NoSuchCommentException if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByG_D_First(long groupId, long distributionId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByG_D_First(groupId, distributionId,
				orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", distributionId=");
		msg.append(distributionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the first comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByG_D_First(long groupId, long distributionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Comment> list = findByG_D(groupId, distributionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws com.viettel.portal.vcms.NoSuchCommentException if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByG_D_Last(long groupId, long distributionId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByG_D_Last(groupId, distributionId,
				orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", distributionId=");
		msg.append(distributionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the last comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByG_D_Last(long groupId, long distributionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_D(groupId, distributionId);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByG_D(groupId, distributionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment[] findByG_D_PrevAndNext(long commentId, long groupId,
		long distributionId, OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByG_D_PrevAndNext(session, comment, groupId,
					distributionId, orderByComparator, true);

			array[1] = comment;

			array[2] = getByG_D_PrevAndNext(session, comment, groupId,
					distributionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByG_D_PrevAndNext(Session session, Comment comment,
		long groupId, long distributionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMENT_WHERE);

		query.append(_FINDER_COLUMN_G_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_D_DISTRIBUTIONID_2);

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
			query.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(distributionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(comment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Comment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where groupId = &#63; and distributionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_D(long groupId, long distributionId)
		throws SystemException {
		for (Comment comment : findByG_D(groupId, distributionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where groupId = &#63; and distributionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param distributionId the distribution ID
	 * @return the number of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_D(long groupId, long distributionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_D;

		Object[] finderArgs = new Object[] { groupId, distributionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_G_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_D_DISTRIBUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(distributionId);

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

	private static final String _FINDER_COLUMN_G_D_GROUPID_2 = "comment.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_D_DISTRIBUTIONID_2 = "comment.distributionId = ?";

	public CommentPersistenceImpl() {
		setModelClass(Comment.class);
	}

	/**
	 * Caches the comment in the entity cache if it is enabled.
	 *
	 * @param comment the comment
	 */
	@Override
	public void cacheResult(Comment comment) {
		EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey(), comment);

		comment.resetOriginalValues();
	}

	/**
	 * Caches the comments in the entity cache if it is enabled.
	 *
	 * @param comments the comments
	 */
	@Override
	public void cacheResult(List<Comment> comments) {
		for (Comment comment : comments) {
			if (EntityCacheUtil.getResult(
						CommentModelImpl.ENTITY_CACHE_ENABLED,
						CommentImpl.class, comment.getPrimaryKey()) == null) {
				cacheResult(comment);
			}
			else {
				comment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all comments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CommentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CommentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the comment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Comment comment) {
		EntityCacheUtil.removeResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Comment> comments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Comment comment : comments) {
			EntityCacheUtil.removeResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
				CommentImpl.class, comment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new comment with the primary key. Does not add the comment to the database.
	 *
	 * @param commentId the primary key for the new comment
	 * @return the new comment
	 */
	@Override
	public Comment create(long commentId) {
		Comment comment = new CommentImpl();

		comment.setNew(true);
		comment.setPrimaryKey(commentId);

		return comment;
	}

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment that was removed
	 * @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment remove(long commentId)
		throws NoSuchCommentException, SystemException {
		return remove((Serializable)commentId);
	}

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comment
	 * @return the comment that was removed
	 * @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment remove(Serializable primaryKey)
		throws NoSuchCommentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Comment comment = (Comment)session.get(CommentImpl.class, primaryKey);

			if (comment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(comment);
		}
		catch (NoSuchCommentException nsee) {
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
	protected Comment removeImpl(Comment comment) throws SystemException {
		comment = toUnwrappedModel(comment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comment)) {
				comment = (Comment)session.get(CommentImpl.class,
						comment.getPrimaryKeyObj());
			}

			if (comment != null) {
				session.delete(comment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (comment != null) {
			clearCache(comment);
		}

		return comment;
	}

	@Override
	public Comment updateImpl(com.viettel.portal.vcms.model.Comment comment)
		throws SystemException {
		comment = toUnwrappedModel(comment);

		boolean isNew = comment.isNew();

		CommentModelImpl commentModelImpl = (CommentModelImpl)comment;

		Session session = null;

		try {
			session = openSession();

			if (comment.isNew()) {
				session.save(comment);

				comment.setNew(false);
			}
			else {
				session.merge(comment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CommentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((commentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commentModelImpl.getOriginalGroupId(),
						commentModelImpl.getOriginalDistributionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D,
					args);

				args = new Object[] {
						commentModelImpl.getGroupId(),
						commentModelImpl.getDistributionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_D,
					args);
			}
		}

		EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey(), comment);

		return comment;
	}

	protected Comment toUnwrappedModel(Comment comment) {
		if (comment instanceof CommentImpl) {
			return comment;
		}

		CommentImpl commentImpl = new CommentImpl();

		commentImpl.setNew(comment.isNew());
		commentImpl.setPrimaryKey(comment.getPrimaryKey());

		commentImpl.setCommentId(comment.getCommentId());
		commentImpl.setGroupId(comment.getGroupId());
		commentImpl.setCompanyId(comment.getCompanyId());
		commentImpl.setUserId(comment.getUserId());
		commentImpl.setUserName(comment.getUserName());
		commentImpl.setCreateDate(comment.getCreateDate());
		commentImpl.setModifiedDate(comment.getModifiedDate());
		commentImpl.setDistributionId(comment.getDistributionId());
		commentImpl.setDistributedDate(comment.getDistributedDate());
		commentImpl.setFullName(comment.getFullName());
		commentImpl.setAddress(comment.getAddress());
		commentImpl.setEmail(comment.getEmail());
		commentImpl.setBody(comment.getBody());
		commentImpl.setVisible(comment.isVisible());
		commentImpl.setIpAddress(comment.getIpAddress());

		return commentImpl;
	}

	/**
	 * Returns the comment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the comment
	 * @return the comment
	 * @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByPrimaryKey(primaryKey);

		if (comment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return comment;
	}

	/**
	 * Returns the comment with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchCommentException} if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment
	 * @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByPrimaryKey(long commentId)
		throws NoSuchCommentException, SystemException {
		return findByPrimaryKey((Serializable)commentId);
	}

	/**
	 * Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comment
	 * @return the comment, or <code>null</code> if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Comment comment = (Comment)EntityCacheUtil.getResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
				CommentImpl.class, primaryKey);

		if (comment == _nullComment) {
			return null;
		}

		if (comment == null) {
			Session session = null;

			try {
				session = openSession();

				comment = (Comment)session.get(CommentImpl.class, primaryKey);

				if (comment != null) {
					cacheResult(comment);
				}
				else {
					EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
						CommentImpl.class, primaryKey, _nullComment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
					CommentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return comment;
	}

	/**
	 * Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment, or <code>null</code> if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByPrimaryKey(long commentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)commentId);
	}

	/**
	 * Returns all the comments.
	 *
	 * @return the comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findAll(int start, int end,
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

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMENT;

				if (pagination) {
					sql = sql.concat(CommentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Comment>(list);
				}
				else {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the comments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Comment comment : findAll()) {
			remove(comment);
		}
	}

	/**
	 * Returns the number of comments.
	 *
	 * @return the number of comments
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

				Query q = session.createQuery(_SQL_COUNT_COMMENT);

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
	 * Initializes the comment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.Comment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Comment>> listenersList = new ArrayList<ModelListener<Comment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Comment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CommentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMMENT = "SELECT comment FROM Comment comment";
	private static final String _SQL_SELECT_COMMENT_WHERE = "SELECT comment FROM Comment comment WHERE ";
	private static final String _SQL_COUNT_COMMENT = "SELECT COUNT(comment) FROM Comment comment";
	private static final String _SQL_COUNT_COMMENT_WHERE = "SELECT COUNT(comment) FROM Comment comment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "comment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Comment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Comment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CommentPersistenceImpl.class);
	private static Comment _nullComment = new CommentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Comment> toCacheModel() {
				return _nullCommentCacheModel;
			}
		};

	private static CacheModel<Comment> _nullCommentCacheModel = new CacheModel<Comment>() {
			@Override
			public Comment toEntityModel() {
				return _nullComment;
			}
		};
}