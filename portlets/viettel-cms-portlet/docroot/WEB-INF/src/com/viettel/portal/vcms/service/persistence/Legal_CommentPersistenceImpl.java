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

import com.viettel.portal.vcms.NoSuchLegal_CommentException;
import com.viettel.portal.vcms.model.Legal_Comment;
import com.viettel.portal.vcms.model.impl.Legal_CommentImpl;
import com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legal_ comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_CommentPersistence
 * @see Legal_CommentUtil
 * @generated
 */
public class Legal_CommentPersistenceImpl extends BasePersistenceImpl<Legal_Comment>
	implements Legal_CommentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Legal_CommentUtil} to access the legal_ comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Legal_CommentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentModelImpl.FINDER_CACHE_ENABLED,
			Legal_CommentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentModelImpl.FINDER_CACHE_ENABLED,
			Legal_CommentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYDISTRIBUTION =
		new FinderPath(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentModelImpl.FINDER_CACHE_ENABLED,
			Legal_CommentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByByDistribution",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDISTRIBUTION =
		new FinderPath(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentModelImpl.FINDER_CACHE_ENABLED,
			Legal_CommentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByByDistribution", new String[] { Integer.class.getName() },
			Legal_CommentModelImpl.DISTRIBUTIONID_COLUMN_BITMASK |
			Legal_CommentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYDISTRIBUTION = new FinderPath(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByDistribution",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the legal_ comments where DistributionID = &#63;.
	 *
	 * @param DistributionID the distribution i d
	 * @return the matching legal_ comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Comment> findByByDistribution(int DistributionID)
		throws SystemException {
		return findByByDistribution(DistributionID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ comments where DistributionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DistributionID the distribution i d
	 * @param start the lower bound of the range of legal_ comments
	 * @param end the upper bound of the range of legal_ comments (not inclusive)
	 * @return the range of matching legal_ comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Comment> findByByDistribution(int DistributionID,
		int start, int end) throws SystemException {
		return findByByDistribution(DistributionID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ comments where DistributionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DistributionID the distribution i d
	 * @param start the lower bound of the range of legal_ comments
	 * @param end the upper bound of the range of legal_ comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal_ comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Comment> findByByDistribution(int DistributionID,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDISTRIBUTION;
			finderArgs = new Object[] { DistributionID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYDISTRIBUTION;
			finderArgs = new Object[] {
					DistributionID,
					
					start, end, orderByComparator
				};
		}

		List<Legal_Comment> list = (List<Legal_Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Legal_Comment legal_Comment : list) {
				if ((DistributionID != legal_Comment.getDistributionID())) {
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

			query.append(_SQL_SELECT_LEGAL_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_BYDISTRIBUTION_DISTRIBUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Legal_CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(DistributionID);

				if (!pagination) {
					list = (List<Legal_Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Comment>(list);
				}
				else {
					list = (List<Legal_Comment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal_ comment in the ordered set where DistributionID = &#63;.
	 *
	 * @param DistributionID the distribution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ comment
	 * @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a matching legal_ comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment findByByDistribution_First(int DistributionID,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_CommentException, SystemException {
		Legal_Comment legal_Comment = fetchByByDistribution_First(DistributionID,
				orderByComparator);

		if (legal_Comment != null) {
			return legal_Comment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DistributionID=");
		msg.append(DistributionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_CommentException(msg.toString());
	}

	/**
	 * Returns the first legal_ comment in the ordered set where DistributionID = &#63;.
	 *
	 * @param DistributionID the distribution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ comment, or <code>null</code> if a matching legal_ comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment fetchByByDistribution_First(int DistributionID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Legal_Comment> list = findByByDistribution(DistributionID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal_ comment in the ordered set where DistributionID = &#63;.
	 *
	 * @param DistributionID the distribution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ comment
	 * @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a matching legal_ comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment findByByDistribution_Last(int DistributionID,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_CommentException, SystemException {
		Legal_Comment legal_Comment = fetchByByDistribution_Last(DistributionID,
				orderByComparator);

		if (legal_Comment != null) {
			return legal_Comment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DistributionID=");
		msg.append(DistributionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_CommentException(msg.toString());
	}

	/**
	 * Returns the last legal_ comment in the ordered set where DistributionID = &#63;.
	 *
	 * @param DistributionID the distribution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ comment, or <code>null</code> if a matching legal_ comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment fetchByByDistribution_Last(int DistributionID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByByDistribution(DistributionID);

		if (count == 0) {
			return null;
		}

		List<Legal_Comment> list = findByByDistribution(DistributionID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal_ comments before and after the current legal_ comment in the ordered set where DistributionID = &#63;.
	 *
	 * @param ID the primary key of the current legal_ comment
	 * @param DistributionID the distribution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal_ comment
	 * @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a legal_ comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment[] findByByDistribution_PrevAndNext(int ID,
		int DistributionID, OrderByComparator orderByComparator)
		throws NoSuchLegal_CommentException, SystemException {
		Legal_Comment legal_Comment = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			Legal_Comment[] array = new Legal_CommentImpl[3];

			array[0] = getByByDistribution_PrevAndNext(session, legal_Comment,
					DistributionID, orderByComparator, true);

			array[1] = legal_Comment;

			array[2] = getByByDistribution_PrevAndNext(session, legal_Comment,
					DistributionID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Legal_Comment getByByDistribution_PrevAndNext(Session session,
		Legal_Comment legal_Comment, int DistributionID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGAL_COMMENT_WHERE);

		query.append(_FINDER_COLUMN_BYDISTRIBUTION_DISTRIBUTIONID_2);

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
			query.append(Legal_CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(DistributionID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legal_Comment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Legal_Comment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal_ comments where DistributionID = &#63; from the database.
	 *
	 * @param DistributionID the distribution i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByByDistribution(int DistributionID)
		throws SystemException {
		for (Legal_Comment legal_Comment : findByByDistribution(
				DistributionID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legal_Comment);
		}
	}

	/**
	 * Returns the number of legal_ comments where DistributionID = &#63;.
	 *
	 * @param DistributionID the distribution i d
	 * @return the number of matching legal_ comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByByDistribution(int DistributionID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYDISTRIBUTION;

		Object[] finderArgs = new Object[] { DistributionID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGAL_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_BYDISTRIBUTION_DISTRIBUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(DistributionID);

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

	private static final String _FINDER_COLUMN_BYDISTRIBUTION_DISTRIBUTIONID_2 = "legal_Comment.DistributionID = ?";

	public Legal_CommentPersistenceImpl() {
		setModelClass(Legal_Comment.class);
	}

	/**
	 * Caches the legal_ comment in the entity cache if it is enabled.
	 *
	 * @param legal_Comment the legal_ comment
	 */
	@Override
	public void cacheResult(Legal_Comment legal_Comment) {
		EntityCacheUtil.putResult(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentImpl.class, legal_Comment.getPrimaryKey(),
			legal_Comment);

		legal_Comment.resetOriginalValues();
	}

	/**
	 * Caches the legal_ comments in the entity cache if it is enabled.
	 *
	 * @param legal_Comments the legal_ comments
	 */
	@Override
	public void cacheResult(List<Legal_Comment> legal_Comments) {
		for (Legal_Comment legal_Comment : legal_Comments) {
			if (EntityCacheUtil.getResult(
						Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
						Legal_CommentImpl.class, legal_Comment.getPrimaryKey()) == null) {
				cacheResult(legal_Comment);
			}
			else {
				legal_Comment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal_ comments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Legal_CommentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Legal_CommentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal_ comment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Legal_Comment legal_Comment) {
		EntityCacheUtil.removeResult(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentImpl.class, legal_Comment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Legal_Comment> legal_Comments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Legal_Comment legal_Comment : legal_Comments) {
			EntityCacheUtil.removeResult(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
				Legal_CommentImpl.class, legal_Comment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legal_ comment with the primary key. Does not add the legal_ comment to the database.
	 *
	 * @param ID the primary key for the new legal_ comment
	 * @return the new legal_ comment
	 */
	@Override
	public Legal_Comment create(int ID) {
		Legal_Comment legal_Comment = new Legal_CommentImpl();

		legal_Comment.setNew(true);
		legal_Comment.setPrimaryKey(ID);

		return legal_Comment;
	}

	/**
	 * Removes the legal_ comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the legal_ comment
	 * @return the legal_ comment that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a legal_ comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment remove(int ID)
		throws NoSuchLegal_CommentException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the legal_ comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal_ comment
	 * @return the legal_ comment that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a legal_ comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment remove(Serializable primaryKey)
		throws NoSuchLegal_CommentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Legal_Comment legal_Comment = (Legal_Comment)session.get(Legal_CommentImpl.class,
					primaryKey);

			if (legal_Comment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegal_CommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legal_Comment);
		}
		catch (NoSuchLegal_CommentException nsee) {
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
	protected Legal_Comment removeImpl(Legal_Comment legal_Comment)
		throws SystemException {
		legal_Comment = toUnwrappedModel(legal_Comment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legal_Comment)) {
				legal_Comment = (Legal_Comment)session.get(Legal_CommentImpl.class,
						legal_Comment.getPrimaryKeyObj());
			}

			if (legal_Comment != null) {
				session.delete(legal_Comment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legal_Comment != null) {
			clearCache(legal_Comment);
		}

		return legal_Comment;
	}

	@Override
	public Legal_Comment updateImpl(
		com.viettel.portal.vcms.model.Legal_Comment legal_Comment)
		throws SystemException {
		legal_Comment = toUnwrappedModel(legal_Comment);

		boolean isNew = legal_Comment.isNew();

		Legal_CommentModelImpl legal_CommentModelImpl = (Legal_CommentModelImpl)legal_Comment;

		Session session = null;

		try {
			session = openSession();

			if (legal_Comment.isNew()) {
				session.save(legal_Comment);

				legal_Comment.setNew(false);
			}
			else {
				session.merge(legal_Comment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Legal_CommentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legal_CommentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDISTRIBUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legal_CommentModelImpl.getOriginalDistributionID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYDISTRIBUTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDISTRIBUTION,
					args);

				args = new Object[] { legal_CommentModelImpl.getDistributionID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYDISTRIBUTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDISTRIBUTION,
					args);
			}
		}

		EntityCacheUtil.putResult(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_CommentImpl.class, legal_Comment.getPrimaryKey(),
			legal_Comment);

		return legal_Comment;
	}

	protected Legal_Comment toUnwrappedModel(Legal_Comment legal_Comment) {
		if (legal_Comment instanceof Legal_CommentImpl) {
			return legal_Comment;
		}

		Legal_CommentImpl legal_CommentImpl = new Legal_CommentImpl();

		legal_CommentImpl.setNew(legal_Comment.isNew());
		legal_CommentImpl.setPrimaryKey(legal_Comment.getPrimaryKey());

		legal_CommentImpl.setID(legal_Comment.getID());
		legal_CommentImpl.setDistributionID(legal_Comment.getDistributionID());
		legal_CommentImpl.setFullname(legal_Comment.getFullname());
		legal_CommentImpl.setAddress(legal_Comment.getAddress());
		legal_CommentImpl.setEmail(legal_Comment.getEmail());
		legal_CommentImpl.setBody(legal_Comment.getBody());
		legal_CommentImpl.setVisible(legal_Comment.isVisible());
		legal_CommentImpl.setCreationDate(legal_Comment.getCreationDate());
		legal_CommentImpl.setModifiedDate(legal_Comment.getModifiedDate());
		legal_CommentImpl.setIPAddress(legal_Comment.getIPAddress());

		return legal_CommentImpl;
	}

	/**
	 * Returns the legal_ comment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ comment
	 * @return the legal_ comment
	 * @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a legal_ comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegal_CommentException, SystemException {
		Legal_Comment legal_Comment = fetchByPrimaryKey(primaryKey);

		if (legal_Comment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegal_CommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legal_Comment;
	}

	/**
	 * Returns the legal_ comment with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_CommentException} if it could not be found.
	 *
	 * @param ID the primary key of the legal_ comment
	 * @return the legal_ comment
	 * @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a legal_ comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment findByPrimaryKey(int ID)
		throws NoSuchLegal_CommentException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the legal_ comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ comment
	 * @return the legal_ comment, or <code>null</code> if a legal_ comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Legal_Comment legal_Comment = (Legal_Comment)EntityCacheUtil.getResult(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
				Legal_CommentImpl.class, primaryKey);

		if (legal_Comment == _nullLegal_Comment) {
			return null;
		}

		if (legal_Comment == null) {
			Session session = null;

			try {
				session = openSession();

				legal_Comment = (Legal_Comment)session.get(Legal_CommentImpl.class,
						primaryKey);

				if (legal_Comment != null) {
					cacheResult(legal_Comment);
				}
				else {
					EntityCacheUtil.putResult(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
						Legal_CommentImpl.class, primaryKey, _nullLegal_Comment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Legal_CommentModelImpl.ENTITY_CACHE_ENABLED,
					Legal_CommentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legal_Comment;
	}

	/**
	 * Returns the legal_ comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the legal_ comment
	 * @return the legal_ comment, or <code>null</code> if a legal_ comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Comment fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the legal_ comments.
	 *
	 * @return the legal_ comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Comment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ comments
	 * @param end the upper bound of the range of legal_ comments (not inclusive)
	 * @return the range of legal_ comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Comment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ comments
	 * @param end the upper bound of the range of legal_ comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal_ comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Comment> findAll(int start, int end,
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

		List<Legal_Comment> list = (List<Legal_Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGAL_COMMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGAL_COMMENT;

				if (pagination) {
					sql = sql.concat(Legal_CommentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Legal_Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Comment>(list);
				}
				else {
					list = (List<Legal_Comment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legal_ comments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Legal_Comment legal_Comment : findAll()) {
			remove(legal_Comment);
		}
	}

	/**
	 * Returns the number of legal_ comments.
	 *
	 * @return the number of legal_ comments
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

				Query q = session.createQuery(_SQL_COUNT_LEGAL_COMMENT);

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
	 * Initializes the legal_ comment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.Legal_Comment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Legal_Comment>> listenersList = new ArrayList<ModelListener<Legal_Comment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Legal_Comment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Legal_CommentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGAL_COMMENT = "SELECT legal_Comment FROM Legal_Comment legal_Comment";
	private static final String _SQL_SELECT_LEGAL_COMMENT_WHERE = "SELECT legal_Comment FROM Legal_Comment legal_Comment WHERE ";
	private static final String _SQL_COUNT_LEGAL_COMMENT = "SELECT COUNT(legal_Comment) FROM Legal_Comment legal_Comment";
	private static final String _SQL_COUNT_LEGAL_COMMENT_WHERE = "SELECT COUNT(legal_Comment) FROM Legal_Comment legal_Comment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legal_Comment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Legal_Comment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Legal_Comment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Legal_CommentPersistenceImpl.class);
	private static Legal_Comment _nullLegal_Comment = new Legal_CommentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Legal_Comment> toCacheModel() {
				return _nullLegal_CommentCacheModel;
			}
		};

	private static CacheModel<Legal_Comment> _nullLegal_CommentCacheModel = new CacheModel<Legal_Comment>() {
			@Override
			public Legal_Comment toEntityModel() {
				return _nullLegal_Comment;
			}
		};
}