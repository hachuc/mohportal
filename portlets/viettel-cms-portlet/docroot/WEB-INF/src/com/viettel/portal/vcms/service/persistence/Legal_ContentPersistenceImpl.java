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

import com.viettel.portal.vcms.NoSuchLegal_ContentException;
import com.viettel.portal.vcms.model.Legal_Content;
import com.viettel.portal.vcms.model.impl.Legal_ContentImpl;
import com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legal_ content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_ContentPersistence
 * @see Legal_ContentUtil
 * @generated
 */
public class Legal_ContentPersistenceImpl extends BasePersistenceImpl<Legal_Content>
	implements Legal_ContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Legal_ContentUtil} to access the legal_ content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Legal_ContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED,
			Legal_ContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED,
			Legal_ContentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTATUS = new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED,
			Legal_ContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS =
		new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED,
			Legal_ContentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyStatus", new String[] { Integer.class.getName() },
			Legal_ContentModelImpl.STATUS_COLUMN_BITMASK |
			Legal_ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYSTATUS = new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the legal_ contents where Status = &#63;.
	 *
	 * @param Status the status
	 * @return the matching legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findBybyStatus(int Status)
		throws SystemException {
		return findBybyStatus(Status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ contents where Status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param Status the status
	 * @param start the lower bound of the range of legal_ contents
	 * @param end the upper bound of the range of legal_ contents (not inclusive)
	 * @return the range of matching legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findBybyStatus(int Status, int start, int end)
		throws SystemException {
		return findBybyStatus(Status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ contents where Status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param Status the status
	 * @param start the lower bound of the range of legal_ contents
	 * @param end the upper bound of the range of legal_ contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findBybyStatus(int Status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS;
			finderArgs = new Object[] { Status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTATUS;
			finderArgs = new Object[] { Status, start, end, orderByComparator };
		}

		List<Legal_Content> list = (List<Legal_Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Legal_Content legal_Content : list) {
				if ((Status != legal_Content.getStatus())) {
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

			query.append(_SQL_SELECT_LEGAL_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_BYSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Legal_ContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(Status);

				if (!pagination) {
					list = (List<Legal_Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Content>(list);
				}
				else {
					list = (List<Legal_Content>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal_ content in the ordered set where Status = &#63;.
	 *
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ content
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content findBybyStatus_First(int Status,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ContentException, SystemException {
		Legal_Content legal_Content = fetchBybyStatus_First(Status,
				orderByComparator);

		if (legal_Content != null) {
			return legal_Content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Status=");
		msg.append(Status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_ContentException(msg.toString());
	}

	/**
	 * Returns the first legal_ content in the ordered set where Status = &#63;.
	 *
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content fetchBybyStatus_First(int Status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Legal_Content> list = findBybyStatus(Status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal_ content in the ordered set where Status = &#63;.
	 *
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ content
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content findBybyStatus_Last(int Status,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ContentException, SystemException {
		Legal_Content legal_Content = fetchBybyStatus_Last(Status,
				orderByComparator);

		if (legal_Content != null) {
			return legal_Content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Status=");
		msg.append(Status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_ContentException(msg.toString());
	}

	/**
	 * Returns the last legal_ content in the ordered set where Status = &#63;.
	 *
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content fetchBybyStatus_Last(int Status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyStatus(Status);

		if (count == 0) {
			return null;
		}

		List<Legal_Content> list = findBybyStatus(Status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal_ contents before and after the current legal_ content in the ordered set where Status = &#63;.
	 *
	 * @param ID the primary key of the current legal_ content
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal_ content
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content[] findBybyStatus_PrevAndNext(int ID, int Status,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ContentException, SystemException {
		Legal_Content legal_Content = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			Legal_Content[] array = new Legal_ContentImpl[3];

			array[0] = getBybyStatus_PrevAndNext(session, legal_Content,
					Status, orderByComparator, true);

			array[1] = legal_Content;

			array[2] = getBybyStatus_PrevAndNext(session, legal_Content,
					Status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Legal_Content getBybyStatus_PrevAndNext(Session session,
		Legal_Content legal_Content, int Status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGAL_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_BYSTATUS_STATUS_2);

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
			query.append(Legal_ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(Status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legal_Content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Legal_Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal_ contents where Status = &#63; from the database.
	 *
	 * @param Status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyStatus(int Status) throws SystemException {
		for (Legal_Content legal_Content : findBybyStatus(Status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legal_Content);
		}
	}

	/**
	 * Returns the number of legal_ contents where Status = &#63;.
	 *
	 * @param Status the status
	 * @return the number of matching legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyStatus(int Status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYSTATUS;

		Object[] finderArgs = new Object[] { Status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGAL_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_BYSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(Status);

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

	private static final String _FINDER_COLUMN_BYSTATUS_STATUS_2 = "legal_Content.Status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYZONE = new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED,
			Legal_ContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyZone",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONE =
		new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED,
			Legal_ContentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyZone", new String[] { Integer.class.getName() },
			Legal_ContentModelImpl.ZONEID_COLUMN_BITMASK |
			Legal_ContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYZONE = new FinderPath(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyZone",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the legal_ contents where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @return the matching legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findBybyZone(int ZoneID)
		throws SystemException {
		return findBybyZone(ZoneID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ contents where ZoneID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ZoneID the zone i d
	 * @param start the lower bound of the range of legal_ contents
	 * @param end the upper bound of the range of legal_ contents (not inclusive)
	 * @return the range of matching legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findBybyZone(int ZoneID, int start, int end)
		throws SystemException {
		return findBybyZone(ZoneID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ contents where ZoneID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ZoneID the zone i d
	 * @param start the lower bound of the range of legal_ contents
	 * @param end the upper bound of the range of legal_ contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findBybyZone(int ZoneID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONE;
			finderArgs = new Object[] { ZoneID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYZONE;
			finderArgs = new Object[] { ZoneID, start, end, orderByComparator };
		}

		List<Legal_Content> list = (List<Legal_Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Legal_Content legal_Content : list) {
				if ((ZoneID != legal_Content.getZoneID())) {
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

			query.append(_SQL_SELECT_LEGAL_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_BYZONE_ZONEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Legal_ContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ZoneID);

				if (!pagination) {
					list = (List<Legal_Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Content>(list);
				}
				else {
					list = (List<Legal_Content>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal_ content in the ordered set where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ content
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content findBybyZone_First(int ZoneID,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ContentException, SystemException {
		Legal_Content legal_Content = fetchBybyZone_First(ZoneID,
				orderByComparator);

		if (legal_Content != null) {
			return legal_Content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ZoneID=");
		msg.append(ZoneID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_ContentException(msg.toString());
	}

	/**
	 * Returns the first legal_ content in the ordered set where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content fetchBybyZone_First(int ZoneID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Legal_Content> list = findBybyZone(ZoneID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal_ content in the ordered set where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ content
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content findBybyZone_Last(int ZoneID,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ContentException, SystemException {
		Legal_Content legal_Content = fetchBybyZone_Last(ZoneID,
				orderByComparator);

		if (legal_Content != null) {
			return legal_Content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ZoneID=");
		msg.append(ZoneID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegal_ContentException(msg.toString());
	}

	/**
	 * Returns the last legal_ content in the ordered set where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content fetchBybyZone_Last(int ZoneID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyZone(ZoneID);

		if (count == 0) {
			return null;
		}

		List<Legal_Content> list = findBybyZone(ZoneID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal_ contents before and after the current legal_ content in the ordered set where ZoneID = &#63;.
	 *
	 * @param ID the primary key of the current legal_ content
	 * @param ZoneID the zone i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal_ content
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content[] findBybyZone_PrevAndNext(int ID, int ZoneID,
		OrderByComparator orderByComparator)
		throws NoSuchLegal_ContentException, SystemException {
		Legal_Content legal_Content = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			Legal_Content[] array = new Legal_ContentImpl[3];

			array[0] = getBybyZone_PrevAndNext(session, legal_Content, ZoneID,
					orderByComparator, true);

			array[1] = legal_Content;

			array[2] = getBybyZone_PrevAndNext(session, legal_Content, ZoneID,
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

	protected Legal_Content getBybyZone_PrevAndNext(Session session,
		Legal_Content legal_Content, int ZoneID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGAL_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_BYZONE_ZONEID_2);

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
			query.append(Legal_ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ZoneID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legal_Content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Legal_Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal_ contents where ZoneID = &#63; from the database.
	 *
	 * @param ZoneID the zone i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyZone(int ZoneID) throws SystemException {
		for (Legal_Content legal_Content : findBybyZone(ZoneID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legal_Content);
		}
	}

	/**
	 * Returns the number of legal_ contents where ZoneID = &#63;.
	 *
	 * @param ZoneID the zone i d
	 * @return the number of matching legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyZone(int ZoneID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYZONE;

		Object[] finderArgs = new Object[] { ZoneID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGAL_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_BYZONE_ZONEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ZoneID);

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

	private static final String _FINDER_COLUMN_BYZONE_ZONEID_2 = "legal_Content.ZoneID = ?";

	public Legal_ContentPersistenceImpl() {
		setModelClass(Legal_Content.class);
	}

	/**
	 * Caches the legal_ content in the entity cache if it is enabled.
	 *
	 * @param legal_Content the legal_ content
	 */
	@Override
	public void cacheResult(Legal_Content legal_Content) {
		EntityCacheUtil.putResult(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentImpl.class, legal_Content.getPrimaryKey(),
			legal_Content);

		legal_Content.resetOriginalValues();
	}

	/**
	 * Caches the legal_ contents in the entity cache if it is enabled.
	 *
	 * @param legal_Contents the legal_ contents
	 */
	@Override
	public void cacheResult(List<Legal_Content> legal_Contents) {
		for (Legal_Content legal_Content : legal_Contents) {
			if (EntityCacheUtil.getResult(
						Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
						Legal_ContentImpl.class, legal_Content.getPrimaryKey()) == null) {
				cacheResult(legal_Content);
			}
			else {
				legal_Content.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal_ contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Legal_ContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Legal_ContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal_ content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Legal_Content legal_Content) {
		EntityCacheUtil.removeResult(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentImpl.class, legal_Content.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Legal_Content> legal_Contents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Legal_Content legal_Content : legal_Contents) {
			EntityCacheUtil.removeResult(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
				Legal_ContentImpl.class, legal_Content.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legal_ content with the primary key. Does not add the legal_ content to the database.
	 *
	 * @param ID the primary key for the new legal_ content
	 * @return the new legal_ content
	 */
	@Override
	public Legal_Content create(int ID) {
		Legal_Content legal_Content = new Legal_ContentImpl();

		legal_Content.setNew(true);
		legal_Content.setPrimaryKey(ID);

		return legal_Content;
	}

	/**
	 * Removes the legal_ content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the legal_ content
	 * @return the legal_ content that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content remove(int ID)
		throws NoSuchLegal_ContentException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the legal_ content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal_ content
	 * @return the legal_ content that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content remove(Serializable primaryKey)
		throws NoSuchLegal_ContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Legal_Content legal_Content = (Legal_Content)session.get(Legal_ContentImpl.class,
					primaryKey);

			if (legal_Content == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegal_ContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legal_Content);
		}
		catch (NoSuchLegal_ContentException nsee) {
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
	protected Legal_Content removeImpl(Legal_Content legal_Content)
		throws SystemException {
		legal_Content = toUnwrappedModel(legal_Content);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legal_Content)) {
				legal_Content = (Legal_Content)session.get(Legal_ContentImpl.class,
						legal_Content.getPrimaryKeyObj());
			}

			if (legal_Content != null) {
				session.delete(legal_Content);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legal_Content != null) {
			clearCache(legal_Content);
		}

		return legal_Content;
	}

	@Override
	public Legal_Content updateImpl(
		com.viettel.portal.vcms.model.Legal_Content legal_Content)
		throws SystemException {
		legal_Content = toUnwrappedModel(legal_Content);

		boolean isNew = legal_Content.isNew();

		Legal_ContentModelImpl legal_ContentModelImpl = (Legal_ContentModelImpl)legal_Content;

		Session session = null;

		try {
			session = openSession();

			if (legal_Content.isNew()) {
				session.save(legal_Content);

				legal_Content.setNew(false);
			}
			else {
				session.merge(legal_Content);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Legal_ContentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legal_ContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legal_ContentModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSTATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS,
					args);

				args = new Object[] { legal_ContentModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSTATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS,
					args);
			}

			if ((legal_ContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legal_ContentModelImpl.getOriginalZoneID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYZONE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONE,
					args);

				args = new Object[] { legal_ContentModelImpl.getZoneID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYZONE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYZONE,
					args);
			}
		}

		EntityCacheUtil.putResult(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentImpl.class, legal_Content.getPrimaryKey(),
			legal_Content);

		return legal_Content;
	}

	protected Legal_Content toUnwrappedModel(Legal_Content legal_Content) {
		if (legal_Content instanceof Legal_ContentImpl) {
			return legal_Content;
		}

		Legal_ContentImpl legal_ContentImpl = new Legal_ContentImpl();

		legal_ContentImpl.setNew(legal_Content.isNew());
		legal_ContentImpl.setPrimaryKey(legal_Content.getPrimaryKey());

		legal_ContentImpl.setID(legal_Content.getID());
		legal_ContentImpl.setContentID(legal_Content.getContentID());
		legal_ContentImpl.setVersion(legal_Content.getVersion());
		legal_ContentImpl.setCreationDate(legal_Content.getCreationDate());
		legal_ContentImpl.setModifiedDate(legal_Content.getModifiedDate());
		legal_ContentImpl.setByline(legal_Content.getByline());
		legal_ContentImpl.setHeadline(legal_Content.getHeadline());
		legal_ContentImpl.setTagline(legal_Content.getTagline());
		legal_ContentImpl.setTeaser(legal_Content.getTeaser());
		legal_ContentImpl.setBody(legal_Content.getBody());
		legal_ContentImpl.setAvatar(legal_Content.getAvatar());
		legal_ContentImpl.setImageUrl(legal_Content.getImageUrl());
		legal_ContentImpl.setImageDescription(legal_Content.getImageDescription());
		legal_ContentImpl.setImageAlign(legal_Content.getImageAlign());
		legal_ContentImpl.setZoneID(legal_Content.getZoneID());
		legal_ContentImpl.setSource(legal_Content.getSource());
		legal_ContentImpl.setStatus(legal_Content.getStatus());
		legal_ContentImpl.setAuthor(legal_Content.getAuthor());
		legal_ContentImpl.setEditor(legal_Content.getEditor());
		legal_ContentImpl.setApprover(legal_Content.getApprover());
		legal_ContentImpl.setDeployer(legal_Content.getDeployer());
		legal_ContentImpl.setAuthors(legal_Content.getAuthors());

		return legal_ContentImpl;
	}

	/**
	 * Returns the legal_ content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ content
	 * @return the legal_ content
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegal_ContentException, SystemException {
		Legal_Content legal_Content = fetchByPrimaryKey(primaryKey);

		if (legal_Content == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegal_ContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legal_Content;
	}

	/**
	 * Returns the legal_ content with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_ContentException} if it could not be found.
	 *
	 * @param ID the primary key of the legal_ content
	 * @return the legal_ content
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content findByPrimaryKey(int ID)
		throws NoSuchLegal_ContentException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the legal_ content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ content
	 * @return the legal_ content, or <code>null</code> if a legal_ content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Legal_Content legal_Content = (Legal_Content)EntityCacheUtil.getResult(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
				Legal_ContentImpl.class, primaryKey);

		if (legal_Content == _nullLegal_Content) {
			return null;
		}

		if (legal_Content == null) {
			Session session = null;

			try {
				session = openSession();

				legal_Content = (Legal_Content)session.get(Legal_ContentImpl.class,
						primaryKey);

				if (legal_Content != null) {
					cacheResult(legal_Content);
				}
				else {
					EntityCacheUtil.putResult(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
						Legal_ContentImpl.class, primaryKey, _nullLegal_Content);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Legal_ContentModelImpl.ENTITY_CACHE_ENABLED,
					Legal_ContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legal_Content;
	}

	/**
	 * Returns the legal_ content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the legal_ content
	 * @return the legal_ content, or <code>null</code> if a legal_ content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_Content fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the legal_ contents.
	 *
	 * @return the legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ contents
	 * @param end the upper bound of the range of legal_ contents (not inclusive)
	 * @return the range of legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ contents
	 * @param end the upper bound of the range of legal_ contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal_ contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_Content> findAll(int start, int end,
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

		List<Legal_Content> list = (List<Legal_Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGAL_CONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGAL_CONTENT;

				if (pagination) {
					sql = sql.concat(Legal_ContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Legal_Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_Content>(list);
				}
				else {
					list = (List<Legal_Content>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legal_ contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Legal_Content legal_Content : findAll()) {
			remove(legal_Content);
		}
	}

	/**
	 * Returns the number of legal_ contents.
	 *
	 * @return the number of legal_ contents
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

				Query q = session.createQuery(_SQL_COUNT_LEGAL_CONTENT);

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
	 * Initializes the legal_ content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.Legal_Content")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Legal_Content>> listenersList = new ArrayList<ModelListener<Legal_Content>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Legal_Content>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Legal_ContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGAL_CONTENT = "SELECT legal_Content FROM Legal_Content legal_Content";
	private static final String _SQL_SELECT_LEGAL_CONTENT_WHERE = "SELECT legal_Content FROM Legal_Content legal_Content WHERE ";
	private static final String _SQL_COUNT_LEGAL_CONTENT = "SELECT COUNT(legal_Content) FROM Legal_Content legal_Content";
	private static final String _SQL_COUNT_LEGAL_CONTENT_WHERE = "SELECT COUNT(legal_Content) FROM Legal_Content legal_Content WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legal_Content.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Legal_Content exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Legal_Content exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Legal_ContentPersistenceImpl.class);
	private static Legal_Content _nullLegal_Content = new Legal_ContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Legal_Content> toCacheModel() {
				return _nullLegal_ContentCacheModel;
			}
		};

	private static CacheModel<Legal_Content> _nullLegal_ContentCacheModel = new CacheModel<Legal_Content>() {
			@Override
			public Legal_Content toEntityModel() {
				return _nullLegal_Content;
			}
		};
}