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

package com.revotech.portal.tthc.service.persistence;

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

import com.revotech.portal.tthc.NoSuchLegalDocumentException;
import com.revotech.portal.tthc.model.LegalDocument;
import com.revotech.portal.tthc.model.impl.LegalDocumentImpl;
import com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legal document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hieptran
 * @see LegalDocumentPersistence
 * @see LegalDocumentUtil
 * @generated
 */
public class LegalDocumentPersistenceImpl extends BasePersistenceImpl<LegalDocument>
	implements LegalDocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegalDocumentUtil} to access the legal document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegalDocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentModelImpl.FINDER_CACHE_ENABLED,
			LegalDocumentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentModelImpl.FINDER_CACHE_ENABLED,
			LegalDocumentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_A = new FinderPath(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentModelImpl.FINDER_CACHE_ENABLED,
			LegalDocumentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_L_A",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A = new FinderPath(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentModelImpl.FINDER_CACHE_ENABLED,
			LegalDocumentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_L_A",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LDLEVEL_COLUMN_BITMASK |
			LegalDocumentModelImpl.ISACTIVE_COLUMN_BITMASK |
			LegalDocumentModelImpl.LDCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_A = new FinderPath(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_A",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @return the matching legal documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> findByG_L_A(long groupId, int ldLevel,
		boolean isActive) throws SystemException {
		return findByG_L_A(groupId, ldLevel, isActive, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> findByG_L_A(long groupId, int ldLevel,
		boolean isActive, int start, int end) throws SystemException {
		return findByG_L_A(groupId, ldLevel, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> findByG_L_A(long groupId, int ldLevel,
		boolean isActive, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A;
			finderArgs = new Object[] { groupId, ldLevel, isActive };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_A;
			finderArgs = new Object[] {
					groupId, ldLevel, isActive,
					
					start, end, orderByComparator
				};
		}

		List<LegalDocument> list = (List<LegalDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalDocument legalDocument : list) {
				if ((groupId != legalDocument.getGroupId()) ||
						(ldLevel != legalDocument.getLdLevel()) ||
						(isActive != legalDocument.getIsActive())) {
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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_L_A_LDLEVEL_2);

			query.append(_FINDER_COLUMN_G_L_A_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(ldLevel);

				qPos.add(isActive);

				if (!pagination) {
					list = (List<LegalDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegalDocument>(list);
				}
				else {
					list = (List<LegalDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a matching legal document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument findByG_L_A_First(long groupId, int ldLevel,
		boolean isActive, OrderByComparator orderByComparator)
		throws NoSuchLegalDocumentException, SystemException {
		LegalDocument legalDocument = fetchByG_L_A_First(groupId, ldLevel,
				isActive, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", ldLevel=");
		msg.append(ldLevel);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument fetchByG_L_A_First(long groupId, int ldLevel,
		boolean isActive, OrderByComparator orderByComparator)
		throws SystemException {
		List<LegalDocument> list = findByG_L_A(groupId, ldLevel, isActive, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a matching legal document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument findByG_L_A_Last(long groupId, int ldLevel,
		boolean isActive, OrderByComparator orderByComparator)
		throws NoSuchLegalDocumentException, SystemException {
		LegalDocument legalDocument = fetchByG_L_A_Last(groupId, ldLevel,
				isActive, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", ldLevel=");
		msg.append(ldLevel);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument fetchByG_L_A_Last(long groupId, int ldLevel,
		boolean isActive, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_L_A(groupId, ldLevel, isActive);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_A(groupId, ldLevel, isActive,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param ldId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument[] findByG_L_A_PrevAndNext(long ldId, long groupId,
		int ldLevel, boolean isActive, OrderByComparator orderByComparator)
		throws NoSuchLegalDocumentException, SystemException {
		LegalDocument legalDocument = findByPrimaryKey(ldId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_A_PrevAndNext(session, legalDocument, groupId,
					ldLevel, isActive, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_A_PrevAndNext(session, legalDocument, groupId,
					ldLevel, isActive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByG_L_A_PrevAndNext(Session session,
		LegalDocument legalDocument, long groupId, int ldLevel,
		boolean isActive, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_L_A_LDLEVEL_2);

		query.append(_FINDER_COLUMN_G_L_A_ISACTIVE_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(ldLevel);

		qPos.add(isActive);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @return the matching legal documents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> filterFindByG_L_A(long groupId, int ldLevel,
		boolean isActive) throws SystemException {
		return filterFindByG_L_A(groupId, ldLevel, isActive, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> filterFindByG_L_A(long groupId, int ldLevel,
		boolean isActive, int start, int end) throws SystemException {
		return filterFindByG_L_A(groupId, ldLevel, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents that the user has permissions to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> filterFindByG_L_A(long groupId, int ldLevel,
		boolean isActive, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_L_A(groupId, ldLevel, isActive, start, end,
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
			query.append(_FILTER_SQL_SELECT_LEGALDOCUMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALDOCUMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_L_A_LDLEVEL_2);

		query.append(_FINDER_COLUMN_G_L_A_ISACTIVE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALDOCUMENT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalDocument.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LegalDocumentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LegalDocumentImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(ldLevel);

			qPos.add(isActive);

			return (List<LegalDocument>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set of legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param ldId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument[] filterFindByG_L_A_PrevAndNext(long ldId,
		long groupId, int ldLevel, boolean isActive,
		OrderByComparator orderByComparator)
		throws NoSuchLegalDocumentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_L_A_PrevAndNext(ldId, groupId, ldLevel, isActive,
				orderByComparator);
		}

		LegalDocument legalDocument = findByPrimaryKey(ldId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = filterGetByG_L_A_PrevAndNext(session, legalDocument,
					groupId, ldLevel, isActive, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = filterGetByG_L_A_PrevAndNext(session, legalDocument,
					groupId, ldLevel, isActive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument filterGetByG_L_A_PrevAndNext(Session session,
		LegalDocument legalDocument, long groupId, int ldLevel,
		boolean isActive, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALDOCUMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALDOCUMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_L_A_LDLEVEL_2);

		query.append(_FINDER_COLUMN_G_L_A_ISACTIVE_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALDOCUMENT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalDocument.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LegalDocumentImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LegalDocumentImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(ldLevel);

		qPos.add(isActive);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_L_A(long groupId, int ldLevel, boolean isActive)
		throws SystemException {
		for (LegalDocument legalDocument : findByG_L_A(groupId, ldLevel,
				isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @return the number of matching legal documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_L_A(long groupId, int ldLevel, boolean isActive)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_L_A;

		Object[] finderArgs = new Object[] { groupId, ldLevel, isActive };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_L_A_LDLEVEL_2);

			query.append(_FINDER_COLUMN_G_L_A_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(ldLevel);

				qPos.add(isActive);

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
	 * Returns the number of legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ldLevel the ld level
	 * @param isActive the is active
	 * @return the number of matching legal documents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_L_A(long groupId, int ldLevel, boolean isActive)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_L_A(groupId, ldLevel, isActive);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_L_A_LDLEVEL_2);

		query.append(_FINDER_COLUMN_G_L_A_ISACTIVE_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalDocument.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(ldLevel);

			qPos.add(isActive);

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

	private static final String _FINDER_COLUMN_G_L_A_GROUPID_2 = "legalDocument.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_A_LDLEVEL_2 = "legalDocument.ldLevel = ? AND ";
	private static final String _FINDER_COLUMN_G_L_A_ISACTIVE_2 = "legalDocument.isActive = ?";

	public LegalDocumentPersistenceImpl() {
		setModelClass(LegalDocument.class);
	}

	/**
	 * Caches the legal document in the entity cache if it is enabled.
	 *
	 * @param legalDocument the legal document
	 */
	@Override
	public void cacheResult(LegalDocument legalDocument) {
		EntityCacheUtil.putResult(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentImpl.class, legalDocument.getPrimaryKey(),
			legalDocument);

		legalDocument.resetOriginalValues();
	}

	/**
	 * Caches the legal documents in the entity cache if it is enabled.
	 *
	 * @param legalDocuments the legal documents
	 */
	@Override
	public void cacheResult(List<LegalDocument> legalDocuments) {
		for (LegalDocument legalDocument : legalDocuments) {
			if (EntityCacheUtil.getResult(
						LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
						LegalDocumentImpl.class, legalDocument.getPrimaryKey()) == null) {
				cacheResult(legalDocument);
			}
			else {
				legalDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegalDocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegalDocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal document.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalDocument legalDocument) {
		EntityCacheUtil.removeResult(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentImpl.class, legalDocument.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalDocument> legalDocuments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalDocument legalDocument : legalDocuments) {
			EntityCacheUtil.removeResult(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
				LegalDocumentImpl.class, legalDocument.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legal document with the primary key. Does not add the legal document to the database.
	 *
	 * @param ldId the primary key for the new legal document
	 * @return the new legal document
	 */
	@Override
	public LegalDocument create(long ldId) {
		LegalDocument legalDocument = new LegalDocumentImpl();

		legalDocument.setNew(true);
		legalDocument.setPrimaryKey(ldId);

		return legalDocument;
	}

	/**
	 * Removes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ldId the primary key of the legal document
	 * @return the legal document that was removed
	 * @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument remove(long ldId)
		throws NoSuchLegalDocumentException, SystemException {
		return remove((Serializable)ldId);
	}

	/**
	 * Removes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal document
	 * @return the legal document that was removed
	 * @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument remove(Serializable primaryKey)
		throws NoSuchLegalDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegalDocument legalDocument = (LegalDocument)session.get(LegalDocumentImpl.class,
					primaryKey);

			if (legalDocument == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legalDocument);
		}
		catch (NoSuchLegalDocumentException nsee) {
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
	protected LegalDocument removeImpl(LegalDocument legalDocument)
		throws SystemException {
		legalDocument = toUnwrappedModel(legalDocument);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalDocument)) {
				legalDocument = (LegalDocument)session.get(LegalDocumentImpl.class,
						legalDocument.getPrimaryKeyObj());
			}

			if (legalDocument != null) {
				session.delete(legalDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legalDocument != null) {
			clearCache(legalDocument);
		}

		return legalDocument;
	}

	@Override
	public LegalDocument updateImpl(
		com.revotech.portal.tthc.model.LegalDocument legalDocument)
		throws SystemException {
		legalDocument = toUnwrappedModel(legalDocument);

		boolean isNew = legalDocument.isNew();

		LegalDocumentModelImpl legalDocumentModelImpl = (LegalDocumentModelImpl)legalDocument;

		Session session = null;

		try {
			session = openSession();

			if (legalDocument.isNew()) {
				session.save(legalDocument);

				legalDocument.setNew(false);
			}
			else {
				session.merge(legalDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LegalDocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legalDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legalDocumentModelImpl.getOriginalGroupId(),
						legalDocumentModelImpl.getOriginalLdLevel(),
						legalDocumentModelImpl.getOriginalIsActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A,
					args);

				args = new Object[] {
						legalDocumentModelImpl.getGroupId(),
						legalDocumentModelImpl.getLdLevel(),
						legalDocumentModelImpl.getIsActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A,
					args);
			}
		}

		EntityCacheUtil.putResult(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
			LegalDocumentImpl.class, legalDocument.getPrimaryKey(),
			legalDocument);

		return legalDocument;
	}

	protected LegalDocument toUnwrappedModel(LegalDocument legalDocument) {
		if (legalDocument instanceof LegalDocumentImpl) {
			return legalDocument;
		}

		LegalDocumentImpl legalDocumentImpl = new LegalDocumentImpl();

		legalDocumentImpl.setNew(legalDocument.isNew());
		legalDocumentImpl.setPrimaryKey(legalDocument.getPrimaryKey());

		legalDocumentImpl.setLdId(legalDocument.getLdId());
		legalDocumentImpl.setGroupId(legalDocument.getGroupId());
		legalDocumentImpl.setCompanyId(legalDocument.getCompanyId());
		legalDocumentImpl.setUserId(legalDocument.getUserId());
		legalDocumentImpl.setUserName(legalDocument.getUserName());
		legalDocumentImpl.setCreateDate(legalDocument.getCreateDate());
		legalDocumentImpl.setModifiedDate(legalDocument.getModifiedDate());
		legalDocumentImpl.setLdCode(legalDocument.getLdCode());
		legalDocumentImpl.setLdTitle(legalDocument.getLdTitle());
		legalDocumentImpl.setLdLink(legalDocument.getLdLink());
		legalDocumentImpl.setLdLevel3Link(legalDocument.getLdLevel3Link());
		legalDocumentImpl.setLdSubcontent(legalDocument.getLdSubcontent());
		legalDocumentImpl.setIsActive(legalDocument.isIsActive());
		legalDocumentImpl.setIdLinhvuc(legalDocument.getIdLinhvuc());
		legalDocumentImpl.setIdCoquanbanhanh(legalDocument.getIdCoquanbanhanh());
		legalDocumentImpl.setLdDonvithuchien(legalDocument.getLdDonvithuchien());
		legalDocumentImpl.setLdLevel(legalDocument.getLdLevel());

		return legalDocumentImpl;
	}

	/**
	 * Returns the legal document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal document
	 * @return the legal document
	 * @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalDocumentException, SystemException {
		LegalDocument legalDocument = fetchByPrimaryKey(primaryKey);

		if (legalDocument == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legalDocument;
	}

	/**
	 * Returns the legal document with the primary key or throws a {@link com.revotech.portal.tthc.NoSuchLegalDocumentException} if it could not be found.
	 *
	 * @param ldId the primary key of the legal document
	 * @return the legal document
	 * @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument findByPrimaryKey(long ldId)
		throws NoSuchLegalDocumentException, SystemException {
		return findByPrimaryKey((Serializable)ldId);
	}

	/**
	 * Returns the legal document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal document
	 * @return the legal document, or <code>null</code> if a legal document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegalDocument legalDocument = (LegalDocument)EntityCacheUtil.getResult(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
				LegalDocumentImpl.class, primaryKey);

		if (legalDocument == _nullLegalDocument) {
			return null;
		}

		if (legalDocument == null) {
			Session session = null;

			try {
				session = openSession();

				legalDocument = (LegalDocument)session.get(LegalDocumentImpl.class,
						primaryKey);

				if (legalDocument != null) {
					cacheResult(legalDocument);
				}
				else {
					EntityCacheUtil.putResult(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
						LegalDocumentImpl.class, primaryKey, _nullLegalDocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegalDocumentModelImpl.ENTITY_CACHE_ENABLED,
					LegalDocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legalDocument;
	}

	/**
	 * Returns the legal document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ldId the primary key of the legal document
	 * @return the legal document, or <code>null</code> if a legal document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalDocument fetchByPrimaryKey(long ldId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ldId);
	}

	/**
	 * Returns all the legal documents.
	 *
	 * @return the legal documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of legal documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegalDocument> findAll(int start, int end,
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

		List<LegalDocument> list = (List<LegalDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGALDOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALDOCUMENT;

				if (pagination) {
					sql = sql.concat(LegalDocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegalDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegalDocument>(list);
				}
				else {
					list = (List<LegalDocument>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legal documents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegalDocument legalDocument : findAll()) {
			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents.
	 *
	 * @return the number of legal documents
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

				Query q = session.createQuery(_SQL_COUNT_LEGALDOCUMENT);

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
	 * Initializes the legal document persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.revotech.portal.tthc.model.LegalDocument")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegalDocument>> listenersList = new ArrayList<ModelListener<LegalDocument>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegalDocument>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegalDocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGALDOCUMENT = "SELECT legalDocument FROM LegalDocument legalDocument";
	private static final String _SQL_SELECT_LEGALDOCUMENT_WHERE = "SELECT legalDocument FROM LegalDocument legalDocument WHERE ";
	private static final String _SQL_COUNT_LEGALDOCUMENT = "SELECT COUNT(legalDocument) FROM LegalDocument legalDocument";
	private static final String _SQL_COUNT_LEGALDOCUMENT_WHERE = "SELECT COUNT(legalDocument) FROM LegalDocument legalDocument WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "legalDocument.ldId";
	private static final String _FILTER_SQL_SELECT_LEGALDOCUMENT_WHERE = "SELECT DISTINCT {legalDocument.*} FROM tthc_LegalDocument legalDocument WHERE ";
	private static final String _FILTER_SQL_SELECT_LEGALDOCUMENT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {tthc_LegalDocument.*} FROM (SELECT DISTINCT legalDocument.ldId FROM tthc_LegalDocument legalDocument WHERE ";
	private static final String _FILTER_SQL_SELECT_LEGALDOCUMENT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN tthc_LegalDocument ON TEMP_TABLE.ldId = tthc_LegalDocument.ldId";
	private static final String _FILTER_SQL_COUNT_LEGALDOCUMENT_WHERE = "SELECT COUNT(DISTINCT legalDocument.ldId) AS COUNT_VALUE FROM tthc_LegalDocument legalDocument WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "legalDocument";
	private static final String _FILTER_ENTITY_TABLE = "tthc_LegalDocument";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legalDocument.";
	private static final String _ORDER_BY_ENTITY_TABLE = "tthc_LegalDocument.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegalDocument exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LegalDocument exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegalDocumentPersistenceImpl.class);
	private static LegalDocument _nullLegalDocument = new LegalDocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegalDocument> toCacheModel() {
				return _nullLegalDocumentCacheModel;
			}
		};

	private static CacheModel<LegalDocument> _nullLegalDocumentCacheModel = new CacheModel<LegalDocument>() {
			@Override
			public LegalDocument toEntityModel() {
				return _nullLegalDocument;
			}
		};
}