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

package com.portal_egov.portlet.legal_faq.service.persistence;

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

import com.portal_egov.portlet.legal_faq.NoSuchFeedbackException;
import com.portal_egov.portlet.legal_faq.model.Feedback;
import com.portal_egov.portlet.legal_faq.model.impl.FeedbackImpl;
import com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see FeedbackPersistence
 * @see FeedbackUtil
 * @generated
 */
public class FeedbackPersistenceImpl extends BasePersistenceImpl<Feedback>
	implements FeedbackPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FeedbackUtil} to access the feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FeedbackImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG",
			new String[] { Long.class.getName() },
			FeedbackModelImpl.GROUPID_COLUMN_BITMASK |
			FeedbackModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the feedbacks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findByG(long groupId) throws SystemException {
		return findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findByG(long groupId, int start, int end)
		throws SystemException {
		return findByG(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findByG(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Feedback> list = (List<Feedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Feedback feedback : list) {
				if ((groupId != feedback.getGroupId())) {
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

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Feedback>(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first feedback in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a matching feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback findByG_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFeedbackException, SystemException {
		Feedback feedback = fetchByG_First(groupId, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first feedback in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback fetchByG_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Feedback> list = findByG(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a matching feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback findByG_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFeedbackException, SystemException {
		Feedback feedback = fetchByG_Last(groupId, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last feedback in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback fetchByG_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG(groupId);

		if (count == 0) {
			return null;
		}

		List<Feedback> list = findByG(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where groupId = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback[] findByG_PrevAndNext(long feedbackId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFeedbackException, SystemException {
		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = getByG_PrevAndNext(session, feedback, groupId,
					orderByComparator, true);

			array[1] = feedback;

			array[2] = getByG_PrevAndNext(session, feedback, groupId,
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

	protected Feedback getByG_PrevAndNext(Session session, Feedback feedback,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_G_GROUPID_2);

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
			query.append(FeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the feedbacks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> filterFindByG(long groupId) throws SystemException {
		return filterFindByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> filterFindByG(long groupId, int start, int end)
		throws SystemException {
		return filterFindByG(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> filterFindByG(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG(groupId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_FEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_FEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_FEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(FeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Feedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, FeedbackImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, FeedbackImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Feedback>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set of feedbacks that the user has permission to view where groupId = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback[] filterFindByG_PrevAndNext(long feedbackId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFeedbackException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_PrevAndNext(feedbackId, groupId, orderByComparator);
		}

		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = filterGetByG_PrevAndNext(session, feedback, groupId,
					orderByComparator, true);

			array[1] = feedback;

			array[2] = filterGetByG_PrevAndNext(session, feedback, groupId,
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

	protected Feedback filterGetByG_PrevAndNext(Session session,
		Feedback feedback, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_FEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_FEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_FEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(FeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Feedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, FeedbackImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, FeedbackImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedbacks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG(long groupId) throws SystemException {
		for (Feedback feedback : findByG(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_G_GROUPID_2);

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
	 * Returns the number of feedbacks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_FEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Feedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

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

	private static final String _FINDER_COLUMN_G_GROUPID_2 = "feedback.groupId = ?";

	public FeedbackPersistenceImpl() {
		setModelClass(Feedback.class);
	}

	/**
	 * Caches the feedback in the entity cache if it is enabled.
	 *
	 * @param feedback the feedback
	 */
	@Override
	public void cacheResult(Feedback feedback) {
		EntityCacheUtil.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey(), feedback);

		feedback.resetOriginalValues();
	}

	/**
	 * Caches the feedbacks in the entity cache if it is enabled.
	 *
	 * @param feedbacks the feedbacks
	 */
	@Override
	public void cacheResult(List<Feedback> feedbacks) {
		for (Feedback feedback : feedbacks) {
			if (EntityCacheUtil.getResult(
						FeedbackModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackImpl.class, feedback.getPrimaryKey()) == null) {
				cacheResult(feedback);
			}
			else {
				feedback.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all feedbacks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FeedbackImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FeedbackImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the feedback.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Feedback feedback) {
		EntityCacheUtil.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Feedback> feedbacks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Feedback feedback : feedbacks) {
			EntityCacheUtil.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackImpl.class, feedback.getPrimaryKey());
		}
	}

	/**
	 * Creates a new feedback with the primary key. Does not add the feedback to the database.
	 *
	 * @param feedbackId the primary key for the new feedback
	 * @return the new feedback
	 */
	@Override
	public Feedback create(long feedbackId) {
		Feedback feedback = new FeedbackImpl();

		feedback.setNew(true);
		feedback.setPrimaryKey(feedbackId);

		return feedback;
	}

	/**
	 * Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback remove(long feedbackId)
		throws NoSuchFeedbackException, SystemException {
		return remove((Serializable)feedbackId);
	}

	/**
	 * Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback remove(Serializable primaryKey)
		throws NoSuchFeedbackException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Feedback feedback = (Feedback)session.get(FeedbackImpl.class,
					primaryKey);

			if (feedback == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feedback);
		}
		catch (NoSuchFeedbackException nsee) {
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
	protected Feedback removeImpl(Feedback feedback) throws SystemException {
		feedback = toUnwrappedModel(feedback);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feedback)) {
				feedback = (Feedback)session.get(FeedbackImpl.class,
						feedback.getPrimaryKeyObj());
			}

			if (feedback != null) {
				session.delete(feedback);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feedback != null) {
			clearCache(feedback);
		}

		return feedback;
	}

	@Override
	public Feedback updateImpl(
		com.portal_egov.portlet.legal_faq.model.Feedback feedback)
		throws SystemException {
		feedback = toUnwrappedModel(feedback);

		boolean isNew = feedback.isNew();

		FeedbackModelImpl feedbackModelImpl = (FeedbackModelImpl)feedback;

		Session session = null;

		try {
			session = openSession();

			if (feedback.isNew()) {
				session.save(feedback);

				feedback.setNew(false);
			}
			else {
				session.merge(feedback);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FeedbackModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((feedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G,
					args);

				args = new Object[] { feedbackModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G,
					args);
			}
		}

		EntityCacheUtil.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey(), feedback);

		return feedback;
	}

	protected Feedback toUnwrappedModel(Feedback feedback) {
		if (feedback instanceof FeedbackImpl) {
			return feedback;
		}

		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setNew(feedback.isNew());
		feedbackImpl.setPrimaryKey(feedback.getPrimaryKey());

		feedbackImpl.setFeedbackId(feedback.getFeedbackId());
		feedbackImpl.setGroupId(feedback.getGroupId());
		feedbackImpl.setCompanyId(feedback.getCompanyId());
		feedbackImpl.setUserId(feedback.getUserId());
		feedbackImpl.setUserName(feedback.getUserName());
		feedbackImpl.setCreateDate(feedback.getCreateDate());
		feedbackImpl.setModifiedDate(feedback.getModifiedDate());
		feedbackImpl.setTitle(feedback.getTitle());
		feedbackImpl.setSummary(feedback.getSummary());
		feedbackImpl.setBody(feedback.getBody());
		feedbackImpl.setFullName(feedback.getFullName());
		feedbackImpl.setWorkFor(feedback.getWorkFor());
		feedbackImpl.setAddress(feedback.getAddress());
		feedbackImpl.setPhone(feedback.getPhone());
		feedbackImpl.setEmail(feedback.getEmail());
		feedbackImpl.setFileId(feedback.getFileId());
		feedbackImpl.setFileSize(feedback.getFileSize());
		feedbackImpl.setFileName(feedback.getFileName());
		feedbackImpl.setFileURL(feedback.getFileURL());
		feedbackImpl.setIpAddress(feedback.getIpAddress());

		return feedbackImpl;
	}

	/**
	 * Returns the feedback with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeedbackException, SystemException {
		Feedback feedback = fetchByPrimaryKey(primaryKey);

		if (feedback == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feedback;
	}

	/**
	 * Returns the feedback with the primary key or throws a {@link com.portal_egov.portlet.legal_faq.NoSuchFeedbackException} if it could not be found.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback findByPrimaryKey(long feedbackId)
		throws NoSuchFeedbackException, SystemException {
		return findByPrimaryKey((Serializable)feedbackId);
	}

	/**
	 * Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Feedback feedback = (Feedback)EntityCacheUtil.getResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackImpl.class, primaryKey);

		if (feedback == _nullFeedback) {
			return null;
		}

		if (feedback == null) {
			Session session = null;

			try {
				session = openSession();

				feedback = (Feedback)session.get(FeedbackImpl.class, primaryKey);

				if (feedback != null) {
					cacheResult(feedback);
				}
				else {
					EntityCacheUtil.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackImpl.class, primaryKey, _nullFeedback);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feedback;
	}

	/**
	 * Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback fetchByPrimaryKey(long feedbackId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)feedbackId);
	}

	/**
	 * Returns all the feedbacks.
	 *
	 * @return the feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findAll(int start, int end,
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

		List<Feedback> list = (List<Feedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FEEDBACK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEEDBACK;

				if (pagination) {
					sql = sql.concat(FeedbackModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Feedback>(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the feedbacks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Feedback feedback : findAll()) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks.
	 *
	 * @return the number of feedbacks
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

				Query q = session.createQuery(_SQL_COUNT_FEEDBACK);

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
	 * Initializes the feedback persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.legal_faq.model.Feedback")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Feedback>> listenersList = new ArrayList<ModelListener<Feedback>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Feedback>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FeedbackImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FEEDBACK = "SELECT feedback FROM Feedback feedback";
	private static final String _SQL_SELECT_FEEDBACK_WHERE = "SELECT feedback FROM Feedback feedback WHERE ";
	private static final String _SQL_COUNT_FEEDBACK = "SELECT COUNT(feedback) FROM Feedback feedback";
	private static final String _SQL_COUNT_FEEDBACK_WHERE = "SELECT COUNT(feedback) FROM Feedback feedback WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "feedback.feedbackId";
	private static final String _FILTER_SQL_SELECT_FEEDBACK_WHERE = "SELECT DISTINCT {feedback.*} FROM vcms_feedback feedback WHERE ";
	private static final String _FILTER_SQL_SELECT_FEEDBACK_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {vcms_feedback.*} FROM (SELECT DISTINCT feedback.feedbackId FROM vcms_feedback feedback WHERE ";
	private static final String _FILTER_SQL_SELECT_FEEDBACK_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN vcms_feedback ON TEMP_TABLE.feedbackId = vcms_feedback.feedbackId";
	private static final String _FILTER_SQL_COUNT_FEEDBACK_WHERE = "SELECT COUNT(DISTINCT feedback.feedbackId) AS COUNT_VALUE FROM vcms_feedback feedback WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "feedback";
	private static final String _FILTER_ENTITY_TABLE = "vcms_feedback";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feedback.";
	private static final String _ORDER_BY_ENTITY_TABLE = "vcms_feedback.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Feedback exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Feedback exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FeedbackPersistenceImpl.class);
	private static Feedback _nullFeedback = new FeedbackImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Feedback> toCacheModel() {
				return _nullFeedbackCacheModel;
			}
		};

	private static CacheModel<Feedback> _nullFeedbackCacheModel = new CacheModel<Feedback>() {
			@Override
			public Feedback toEntityModel() {
				return _nullFeedback;
			}
		};
}