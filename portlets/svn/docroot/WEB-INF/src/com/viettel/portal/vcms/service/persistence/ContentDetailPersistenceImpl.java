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

import com.viettel.portal.vcms.NoSuchContentDetailException;
import com.viettel.portal.vcms.model.ContentDetail;
import com.viettel.portal.vcms.model.impl.ContentDetailImpl;
import com.viettel.portal.vcms.model.impl.ContentDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the content detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see ContentDetailPersistence
 * @see ContentDetailUtil
 * @generated
 */
public class ContentDetailPersistenceImpl extends BasePersistenceImpl<ContentDetail>
	implements ContentDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContentDetailUtil} to access the content detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContentDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentDetailModelImpl.GROUPID_COLUMN_BITMASK |
			ContentDetailModelImpl.CATEGORYID_COLUMN_BITMASK |
			ContentDetailModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the content details where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_C(long groupId, long categoryId)
		throws SystemException {
		return findByG_C(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content details where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @return the range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_C(long groupId, long categoryId,
		int start, int end) throws SystemException {
		return findByG_C(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content details where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_C(long groupId, long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ContentDetail> list = (List<ContentDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentDetail contentDetail : list) {
				if ((groupId != contentDetail.getGroupId()) ||
						(categoryId != contentDetail.getCategoryId())) {
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

			query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentDetail>(list);
				}
				else {
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_C_First(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_C_First(groupId, categoryId,
				orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the first content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_C_First(long groupId, long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContentDetail> list = findByG_C(groupId, categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_C_Last(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_C_Last(groupId, categoryId,
				orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_C_Last(long groupId, long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_C(groupId, categoryId);

		if (count == 0) {
			return null;
		}

		List<ContentDetail> list = findByG_C(groupId, categoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param autoId the primary key of the current content detail
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail[] findByG_C_PrevAndNext(long autoId, long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			ContentDetail[] array = new ContentDetailImpl[3];

			array[0] = getByG_C_PrevAndNext(session, contentDetail, groupId,
					categoryId, orderByComparator, true);

			array[1] = contentDetail;

			array[2] = getByG_C_PrevAndNext(session, contentDetail, groupId,
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

	protected ContentDetail getByG_C_PrevAndNext(Session session,
		ContentDetail contentDetail, long groupId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

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
			query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content details where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_C(long groupId, long categoryId)
		throws SystemException {
		for (ContentDetail contentDetail : findByG_C(groupId, categoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentDetail);
		}
	}

	/**
	 * Returns the number of content details where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching content details
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

			query.append(_SQL_COUNT_CONTENTDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "contentDetail.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_CATEGORYID_2 = "contentDetail.categoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CA_V_S = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_CA_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S =
		new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_CA_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			ContentDetailModelImpl.GROUPID_COLUMN_BITMASK |
			ContentDetailModelImpl.CATEGORYID_COLUMN_BITMASK |
			ContentDetailModelImpl.VERSION_COLUMN_BITMASK |
			ContentDetailModelImpl.STATUS_COLUMN_BITMASK |
			ContentDetailModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CA_V_S = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CA_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @return the matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CA_V_S(long groupId, long categoryId,
		int version, int status) throws SystemException {
		return findByG_CA_V_S(groupId, categoryId, version, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @return the range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CA_V_S(long groupId, long categoryId,
		int version, int status, int start, int end) throws SystemException {
		return findByG_CA_V_S(groupId, categoryId, version, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CA_V_S(long groupId, long categoryId,
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

		List<ContentDetail> list = (List<ContentDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentDetail contentDetail : list) {
				if ((groupId != contentDetail.getGroupId()) ||
						(categoryId != contentDetail.getCategoryId()) ||
						(version != contentDetail.getVersion()) ||
						(status != contentDetail.getStatus())) {
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

			query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

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
				query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentDetail>(list);
				}
				else {
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_CA_V_S_First(long groupId, long categoryId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_CA_V_S_First(groupId,
				categoryId, version, status, orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
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

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the first content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_CA_V_S_First(long groupId, long categoryId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContentDetail> list = findByG_CA_V_S(groupId, categoryId, version,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_CA_V_S_Last(long groupId, long categoryId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_CA_V_S_Last(groupId, categoryId,
				version, status, orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
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

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_CA_V_S_Last(long groupId, long categoryId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_CA_V_S(groupId, categoryId, version, status);

		if (count == 0) {
			return null;
		}

		List<ContentDetail> list = findByG_CA_V_S(groupId, categoryId, version,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content detail
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail[] findByG_CA_V_S_PrevAndNext(long autoId,
		long groupId, long categoryId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			ContentDetail[] array = new ContentDetailImpl[3];

			array[0] = getByG_CA_V_S_PrevAndNext(session, contentDetail,
					groupId, categoryId, version, status, orderByComparator,
					true);

			array[1] = contentDetail;

			array[2] = getByG_CA_V_S_PrevAndNext(session, contentDetail,
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

	protected ContentDetail getByG_CA_V_S_PrevAndNext(Session session,
		ContentDetail contentDetail, long groupId, long categoryId,
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

		query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

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
			query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(contentDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63; from the database.
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
		for (ContentDetail contentDetail : findByG_CA_V_S(groupId, categoryId,
				version, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentDetail);
		}
	}

	/**
	 * Returns the number of content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching content details
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

			query.append(_SQL_COUNT_CONTENTDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_G_CA_V_S_GROUPID_2 = "contentDetail.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_V_S_CATEGORYID_2 = "contentDetail.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_V_S_VERSION_2 = "contentDetail.version = ? AND ";
	private static final String _FINDER_COLUMN_G_CA_V_S_STATUS_2 = "contentDetail.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CO_V = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_CO_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V =
		new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_CO_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ContentDetailModelImpl.GROUPID_COLUMN_BITMASK |
			ContentDetailModelImpl.CONTENTID_COLUMN_BITMASK |
			ContentDetailModelImpl.VERSION_COLUMN_BITMASK |
			ContentDetailModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CO_V = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CO_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the content details where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @return the matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO_V(long groupId, long contentId,
		int version) throws SystemException {
		return findByG_CO_V(groupId, contentId, version, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content details where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @return the range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO_V(long groupId, long contentId,
		int version, int start, int end) throws SystemException {
		return findByG_CO_V(groupId, contentId, version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content details where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO_V(long groupId, long contentId,
		int version, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V;
			finderArgs = new Object[] { groupId, contentId, version };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CO_V;
			finderArgs = new Object[] {
					groupId, contentId, version,
					
					start, end, orderByComparator
				};
		}

		List<ContentDetail> list = (List<ContentDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentDetail contentDetail : list) {
				if ((groupId != contentDetail.getGroupId()) ||
						(contentId != contentDetail.getContentId()) ||
						(version != contentDetail.getVersion())) {
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

			query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_G_CO_V_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CO_V_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_CO_V_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentDetail>(list);
				}
				else {
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_CO_V_First(long groupId, long contentId,
		int version, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_CO_V_First(groupId, contentId,
				version, orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
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

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_CO_V_First(long groupId, long contentId,
		int version, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContentDetail> list = findByG_CO_V(groupId, contentId, version, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_CO_V_Last(long groupId, long contentId,
		int version, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_CO_V_Last(groupId, contentId,
				version, orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
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

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_CO_V_Last(long groupId, long contentId,
		int version, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_CO_V(groupId, contentId, version);

		if (count == 0) {
			return null;
		}

		List<ContentDetail> list = findByG_CO_V(groupId, contentId, version,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param autoId the primary key of the current content detail
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail[] findByG_CO_V_PrevAndNext(long autoId, long groupId,
		long contentId, int version, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			ContentDetail[] array = new ContentDetailImpl[3];

			array[0] = getByG_CO_V_PrevAndNext(session, contentDetail, groupId,
					contentId, version, orderByComparator, true);

			array[1] = contentDetail;

			array[2] = getByG_CO_V_PrevAndNext(session, contentDetail, groupId,
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

	protected ContentDetail getByG_CO_V_PrevAndNext(Session session,
		ContentDetail contentDetail, long groupId, long contentId, int version,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

		query.append(_FINDER_COLUMN_G_CO_V_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CO_V_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_CO_V_VERSION_2);

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
			query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(contentDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content details where groupId = &#63; and contentId = &#63; and version = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_CO_V(long groupId, long contentId, int version)
		throws SystemException {
		for (ContentDetail contentDetail : findByG_CO_V(groupId, contentId,
				version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentDetail);
		}
	}

	/**
	 * Returns the number of content details where groupId = &#63; and contentId = &#63; and version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @return the number of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_CO_V(long groupId, long contentId, int version)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_CO_V;

		Object[] finderArgs = new Object[] { groupId, contentId, version };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_G_CO_V_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CO_V_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_CO_V_VERSION_2);

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

	private static final String _FINDER_COLUMN_G_CO_V_GROUPID_2 = "contentDetail.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CO_V_CONTENTID_2 = "contentDetail.contentId = ? AND ";
	private static final String _FINDER_COLUMN_G_CO_V_VERSION_2 = "contentDetail.version = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CO = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_CO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_CO",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentDetailModelImpl.GROUPID_COLUMN_BITMASK |
			ContentDetailModelImpl.CONTENTID_COLUMN_BITMASK |
			ContentDetailModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CO = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CO",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the content details where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO(long groupId, long contentId)
		throws SystemException {
		return findByG_CO(groupId, contentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content details where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @return the range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO(long groupId, long contentId,
		int start, int end) throws SystemException {
		return findByG_CO(groupId, contentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content details where groupId = &#63; and contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO(long groupId, long contentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ContentDetail> list = (List<ContentDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentDetail contentDetail : list) {
				if ((groupId != contentDetail.getGroupId()) ||
						(contentId != contentDetail.getContentId())) {
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

			query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_G_CO_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CO_CONTENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentDetail>(list);
				}
				else {
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_CO_First(long groupId, long contentId,
		OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_CO_First(groupId, contentId,
				orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_CO_First(long groupId, long contentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContentDetail> list = findByG_CO(groupId, contentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_CO_Last(long groupId, long contentId,
		OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_CO_Last(groupId, contentId,
				orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentId=");
		msg.append(contentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_CO_Last(long groupId, long contentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_CO(groupId, contentId);

		if (count == 0) {
			return null;
		}

		List<ContentDetail> list = findByG_CO(groupId, contentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	 *
	 * @param autoId the primary key of the current content detail
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail[] findByG_CO_PrevAndNext(long autoId, long groupId,
		long contentId, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			ContentDetail[] array = new ContentDetailImpl[3];

			array[0] = getByG_CO_PrevAndNext(session, contentDetail, groupId,
					contentId, orderByComparator, true);

			array[1] = contentDetail;

			array[2] = getByG_CO_PrevAndNext(session, contentDetail, groupId,
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

	protected ContentDetail getByG_CO_PrevAndNext(Session session,
		ContentDetail contentDetail, long groupId, long contentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

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
			query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content details where groupId = &#63; and contentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_CO(long groupId, long contentId)
		throws SystemException {
		for (ContentDetail contentDetail : findByG_CO(groupId, contentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentDetail);
		}
	}

	/**
	 * Returns the number of content details where groupId = &#63; and contentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @return the number of matching content details
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

			query.append(_SQL_COUNT_CONTENTDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_G_CO_GROUPID_2 = "contentDetail.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CO_CONTENTID_2 = "contentDetail.contentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CO_V_S = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_CO_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V_S =
		new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED,
			ContentDetailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_CO_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			ContentDetailModelImpl.GROUPID_COLUMN_BITMASK |
			ContentDetailModelImpl.CONTENTID_COLUMN_BITMASK |
			ContentDetailModelImpl.VERSION_COLUMN_BITMASK |
			ContentDetailModelImpl.STATUS_COLUMN_BITMASK |
			ContentDetailModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CO_V_S = new FinderPath(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CO_V_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @return the matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO_V_S(long groupId, long contentId,
		int version, int status) throws SystemException {
		return findByG_CO_V_S(groupId, contentId, version, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @return the range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO_V_S(long groupId, long contentId,
		int version, int status, int start, int end) throws SystemException {
		return findByG_CO_V_S(groupId, contentId, version, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findByG_CO_V_S(long groupId, long contentId,
		int version, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V_S;
			finderArgs = new Object[] { groupId, contentId, version, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CO_V_S;
			finderArgs = new Object[] {
					groupId, contentId, version, status,
					
					start, end, orderByComparator
				};
		}

		List<ContentDetail> list = (List<ContentDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentDetail contentDetail : list) {
				if ((groupId != contentDetail.getGroupId()) ||
						(contentId != contentDetail.getContentId()) ||
						(version != contentDetail.getVersion()) ||
						(status != contentDetail.getStatus())) {
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

			query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_G_CO_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CO_V_S_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_CO_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_CO_V_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentDetail>(list);
				}
				else {
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_CO_V_S_First(long groupId, long contentId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_CO_V_S_First(groupId, contentId,
				version, status, orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
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

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_CO_V_S_First(long groupId, long contentId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContentDetail> list = findByG_CO_V_S(groupId, contentId, version,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByG_CO_V_S_Last(long groupId, long contentId,
		int version, int status, OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByG_CO_V_S_Last(groupId, contentId,
				version, status, orderByComparator);

		if (contentDetail != null) {
			return contentDetail;
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

		throw new NoSuchContentDetailException(msg.toString());
	}

	/**
	 * Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByG_CO_V_S_Last(long groupId, long contentId,
		int version, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_CO_V_S(groupId, contentId, version, status);

		if (count == 0) {
			return null;
		}

		List<ContentDetail> list = findByG_CO_V_S(groupId, contentId, version,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param autoId the primary key of the current content detail
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail[] findByG_CO_V_S_PrevAndNext(long autoId,
		long groupId, long contentId, int version, int status,
		OrderByComparator orderByComparator)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = findByPrimaryKey(autoId);

		Session session = null;

		try {
			session = openSession();

			ContentDetail[] array = new ContentDetailImpl[3];

			array[0] = getByG_CO_V_S_PrevAndNext(session, contentDetail,
					groupId, contentId, version, status, orderByComparator, true);

			array[1] = contentDetail;

			array[2] = getByG_CO_V_S_PrevAndNext(session, contentDetail,
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

	protected ContentDetail getByG_CO_V_S_PrevAndNext(Session session,
		ContentDetail contentDetail, long groupId, long contentId, int version,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTDETAIL_WHERE);

		query.append(_FINDER_COLUMN_G_CO_V_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CO_V_S_CONTENTID_2);

		query.append(_FINDER_COLUMN_G_CO_V_S_VERSION_2);

		query.append(_FINDER_COLUMN_G_CO_V_S_STATUS_2);

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
			query.append(ContentDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(contentDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_CO_V_S(long groupId, long contentId, int version,
		int status) throws SystemException {
		for (ContentDetail contentDetail : findByG_CO_V_S(groupId, contentId,
				version, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contentDetail);
		}
	}

	/**
	 * Returns the number of content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentId the content ID
	 * @param version the version
	 * @param status the status
	 * @return the number of matching content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_CO_V_S(long groupId, long contentId, int version,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_CO_V_S;

		Object[] finderArgs = new Object[] { groupId, contentId, version, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CONTENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_G_CO_V_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CO_V_S_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_CO_V_S_VERSION_2);

			query.append(_FINDER_COLUMN_G_CO_V_S_STATUS_2);

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

	private static final String _FINDER_COLUMN_G_CO_V_S_GROUPID_2 = "contentDetail.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CO_V_S_CONTENTID_2 = "contentDetail.contentId = ? AND ";
	private static final String _FINDER_COLUMN_G_CO_V_S_VERSION_2 = "contentDetail.version = ? AND ";
	private static final String _FINDER_COLUMN_G_CO_V_S_STATUS_2 = "contentDetail.status = ?";

	public ContentDetailPersistenceImpl() {
		setModelClass(ContentDetail.class);
	}

	/**
	 * Caches the content detail in the entity cache if it is enabled.
	 *
	 * @param contentDetail the content detail
	 */
	@Override
	public void cacheResult(ContentDetail contentDetail) {
		EntityCacheUtil.putResult(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailImpl.class, contentDetail.getPrimaryKey(),
			contentDetail);

		contentDetail.resetOriginalValues();
	}

	/**
	 * Caches the content details in the entity cache if it is enabled.
	 *
	 * @param contentDetails the content details
	 */
	@Override
	public void cacheResult(List<ContentDetail> contentDetails) {
		for (ContentDetail contentDetail : contentDetails) {
			if (EntityCacheUtil.getResult(
						ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
						ContentDetailImpl.class, contentDetail.getPrimaryKey()) == null) {
				cacheResult(contentDetail);
			}
			else {
				contentDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all content details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContentDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContentDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the content detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContentDetail contentDetail) {
		EntityCacheUtil.removeResult(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailImpl.class, contentDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContentDetail> contentDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContentDetail contentDetail : contentDetails) {
			EntityCacheUtil.removeResult(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
				ContentDetailImpl.class, contentDetail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new content detail with the primary key. Does not add the content detail to the database.
	 *
	 * @param autoId the primary key for the new content detail
	 * @return the new content detail
	 */
	@Override
	public ContentDetail create(long autoId) {
		ContentDetail contentDetail = new ContentDetailImpl();

		contentDetail.setNew(true);
		contentDetail.setPrimaryKey(autoId);

		return contentDetail;
	}

	/**
	 * Removes the content detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autoId the primary key of the content detail
	 * @return the content detail that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail remove(long autoId)
		throws NoSuchContentDetailException, SystemException {
		return remove((Serializable)autoId);
	}

	/**
	 * Removes the content detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content detail
	 * @return the content detail that was removed
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail remove(Serializable primaryKey)
		throws NoSuchContentDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContentDetail contentDetail = (ContentDetail)session.get(ContentDetailImpl.class,
					primaryKey);

			if (contentDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contentDetail);
		}
		catch (NoSuchContentDetailException nsee) {
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
	protected ContentDetail removeImpl(ContentDetail contentDetail)
		throws SystemException {
		contentDetail = toUnwrappedModel(contentDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contentDetail)) {
				contentDetail = (ContentDetail)session.get(ContentDetailImpl.class,
						contentDetail.getPrimaryKeyObj());
			}

			if (contentDetail != null) {
				session.delete(contentDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contentDetail != null) {
			clearCache(contentDetail);
		}

		return contentDetail;
	}

	@Override
	public ContentDetail updateImpl(
		com.viettel.portal.vcms.model.ContentDetail contentDetail)
		throws SystemException {
		contentDetail = toUnwrappedModel(contentDetail);

		boolean isNew = contentDetail.isNew();

		ContentDetailModelImpl contentDetailModelImpl = (ContentDetailModelImpl)contentDetail;

		Session session = null;

		try {
			session = openSession();

			if (contentDetail.isNew()) {
				session.save(contentDetail);

				contentDetail.setNew(false);
			}
			else {
				session.merge(contentDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContentDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contentDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentDetailModelImpl.getOriginalGroupId(),
						contentDetailModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);

				args = new Object[] {
						contentDetailModelImpl.getGroupId(),
						contentDetailModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);
			}

			if ((contentDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentDetailModelImpl.getOriginalGroupId(),
						contentDetailModelImpl.getOriginalCategoryId(),
						contentDetailModelImpl.getOriginalVersion(),
						contentDetailModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CA_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S,
					args);

				args = new Object[] {
						contentDetailModelImpl.getGroupId(),
						contentDetailModelImpl.getCategoryId(),
						contentDetailModelImpl.getVersion(),
						contentDetailModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CA_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CA_V_S,
					args);
			}

			if ((contentDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentDetailModelImpl.getOriginalGroupId(),
						contentDetailModelImpl.getOriginalContentId(),
						contentDetailModelImpl.getOriginalVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CO_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V,
					args);

				args = new Object[] {
						contentDetailModelImpl.getGroupId(),
						contentDetailModelImpl.getContentId(),
						contentDetailModelImpl.getVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CO_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V,
					args);
			}

			if ((contentDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentDetailModelImpl.getOriginalGroupId(),
						contentDetailModelImpl.getOriginalContentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO,
					args);

				args = new Object[] {
						contentDetailModelImpl.getGroupId(),
						contentDetailModelImpl.getContentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO,
					args);
			}

			if ((contentDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentDetailModelImpl.getOriginalGroupId(),
						contentDetailModelImpl.getOriginalContentId(),
						contentDetailModelImpl.getOriginalVersion(),
						contentDetailModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CO_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V_S,
					args);

				args = new Object[] {
						contentDetailModelImpl.getGroupId(),
						contentDetailModelImpl.getContentId(),
						contentDetailModelImpl.getVersion(),
						contentDetailModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CO_V_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CO_V_S,
					args);
			}
		}

		EntityCacheUtil.putResult(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
			ContentDetailImpl.class, contentDetail.getPrimaryKey(),
			contentDetail);

		return contentDetail;
	}

	protected ContentDetail toUnwrappedModel(ContentDetail contentDetail) {
		if (contentDetail instanceof ContentDetailImpl) {
			return contentDetail;
		}

		ContentDetailImpl contentDetailImpl = new ContentDetailImpl();

		contentDetailImpl.setNew(contentDetail.isNew());
		contentDetailImpl.setPrimaryKey(contentDetail.getPrimaryKey());

		contentDetailImpl.setAutoId(contentDetail.getAutoId());
		contentDetailImpl.setContentId(contentDetail.getContentId());
		contentDetailImpl.setGroupId(contentDetail.getGroupId());
		contentDetailImpl.setCompanyId(contentDetail.getCompanyId());
		contentDetailImpl.setUserId(contentDetail.getUserId());
		contentDetailImpl.setUserName(contentDetail.getUserName());
		contentDetailImpl.setCreateDate(contentDetail.getCreateDate());
		contentDetailImpl.setModifiedDate(contentDetail.getModifiedDate());
		contentDetailImpl.setVersion(contentDetail.getVersion());
		contentDetailImpl.setSubTitle(contentDetail.getSubTitle());
		contentDetailImpl.setTitle(contentDetail.getTitle());
		contentDetailImpl.setSummary(contentDetail.getSummary());
		contentDetailImpl.setSubContent(contentDetail.getSubContent());
		contentDetailImpl.setContent(contentDetail.getContent());
		contentDetailImpl.setSmallImageId(contentDetail.getSmallImageId());
		contentDetailImpl.setSmallImageUrl(contentDetail.getSmallImageUrl());
		contentDetailImpl.setCategoryId(contentDetail.getCategoryId());
		contentDetailImpl.setStatus(contentDetail.getStatus());
		contentDetailImpl.setNewsType(contentDetail.getNewsType());
		contentDetailImpl.setImageUrl(contentDetail.getImageUrl());
		contentDetailImpl.setIsLegalContent(contentDetail.isIsLegalContent());
		contentDetailImpl.setImageCaption(contentDetail.getImageCaption());
		contentDetailImpl.setImagePosition(contentDetail.getImagePosition());

		return contentDetailImpl;
	}

	/**
	 * Returns the content detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the content detail
	 * @return the content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContentDetailException, SystemException {
		ContentDetail contentDetail = fetchByPrimaryKey(primaryKey);

		if (contentDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContentDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contentDetail;
	}

	/**
	 * Returns the content detail with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentDetailException} if it could not be found.
	 *
	 * @param autoId the primary key of the content detail
	 * @return the content detail
	 * @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail findByPrimaryKey(long autoId)
		throws NoSuchContentDetailException, SystemException {
		return findByPrimaryKey((Serializable)autoId);
	}

	/**
	 * Returns the content detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the content detail
	 * @return the content detail, or <code>null</code> if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContentDetail contentDetail = (ContentDetail)EntityCacheUtil.getResult(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
				ContentDetailImpl.class, primaryKey);

		if (contentDetail == _nullContentDetail) {
			return null;
		}

		if (contentDetail == null) {
			Session session = null;

			try {
				session = openSession();

				contentDetail = (ContentDetail)session.get(ContentDetailImpl.class,
						primaryKey);

				if (contentDetail != null) {
					cacheResult(contentDetail);
				}
				else {
					EntityCacheUtil.putResult(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
						ContentDetailImpl.class, primaryKey, _nullContentDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContentDetailModelImpl.ENTITY_CACHE_ENABLED,
					ContentDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contentDetail;
	}

	/**
	 * Returns the content detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param autoId the primary key of the content detail
	 * @return the content detail, or <code>null</code> if a content detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentDetail fetchByPrimaryKey(long autoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)autoId);
	}

	/**
	 * Returns all the content details.
	 *
	 * @return the content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @return the range of content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the content details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of content details
	 * @param end the upper bound of the range of content details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of content details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContentDetail> findAll(int start, int end,
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

		List<ContentDetail> list = (List<ContentDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTENTDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTENTDETAIL;

				if (pagination) {
					sql = sql.concat(ContentDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContentDetail>(list);
				}
				else {
					list = (List<ContentDetail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the content details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContentDetail contentDetail : findAll()) {
			remove(contentDetail);
		}
	}

	/**
	 * Returns the number of content details.
	 *
	 * @return the number of content details
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

				Query q = session.createQuery(_SQL_COUNT_CONTENTDETAIL);

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
	 * Initializes the content detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.ContentDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContentDetail>> listenersList = new ArrayList<ModelListener<ContentDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContentDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContentDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTENTDETAIL = "SELECT contentDetail FROM ContentDetail contentDetail";
	private static final String _SQL_SELECT_CONTENTDETAIL_WHERE = "SELECT contentDetail FROM ContentDetail contentDetail WHERE ";
	private static final String _SQL_COUNT_CONTENTDETAIL = "SELECT COUNT(contentDetail) FROM ContentDetail contentDetail";
	private static final String _SQL_COUNT_CONTENTDETAIL_WHERE = "SELECT COUNT(contentDetail) FROM ContentDetail contentDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contentDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContentDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContentDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContentDetailPersistenceImpl.class);
	private static ContentDetail _nullContentDetail = new ContentDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContentDetail> toCacheModel() {
				return _nullContentDetailCacheModel;
			}
		};

	private static CacheModel<ContentDetail> _nullContentDetailCacheModel = new CacheModel<ContentDetail>() {
			@Override
			public ContentDetail toEntityModel() {
				return _nullContentDetail;
			}
		};
}