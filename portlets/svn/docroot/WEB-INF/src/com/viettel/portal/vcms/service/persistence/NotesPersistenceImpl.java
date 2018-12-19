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

import com.viettel.portal.vcms.NoSuchNotesException;
import com.viettel.portal.vcms.model.Notes;
import com.viettel.portal.vcms.model.impl.NotesImpl;
import com.viettel.portal.vcms.model.impl.NotesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the notes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see NotesPersistence
 * @see NotesUtil
 * @generated
 */
public class NotesPersistenceImpl extends BasePersistenceImpl<Notes>
	implements NotesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotesUtil} to access the notes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesModelImpl.FINDER_CACHE_ENABLED, NotesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesModelImpl.FINDER_CACHE_ENABLED, NotesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_V = new FinderPath(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesModelImpl.FINDER_CACHE_ENABLED, NotesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V = new FinderPath(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesModelImpl.FINDER_CACHE_ENABLED, NotesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			NotesModelImpl.GROUPID_COLUMN_BITMASK |
			NotesModelImpl.CONTENTID_COLUMN_BITMASK |
			NotesModelImpl.VERSION_COLUMN_BITMASK |
			NotesModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_V = new FinderPath(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @return the matching noteses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notes> findByG_C_V(long groupId, long ContentID, int Version)
		throws SystemException {
		return findByG_C_V(groupId, ContentID, Version, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.NotesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @return the range of matching noteses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notes> findByG_C_V(long groupId, long ContentID, int Version,
		int start, int end) throws SystemException {
		return findByG_C_V(groupId, ContentID, Version, start, end, null);
	}

	/**
	 * Returns an ordered range of all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.NotesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching noteses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notes> findByG_C_V(long groupId, long ContentID, int Version,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V;
			finderArgs = new Object[] { groupId, ContentID, Version };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_V;
			finderArgs = new Object[] {
					groupId, ContentID, Version,
					
					start, end, orderByComparator
				};
		}

		List<Notes> list = (List<Notes>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Notes notes : list) {
				if ((groupId != notes.getGroupId()) ||
						(ContentID != notes.getContentID()) ||
						(Version != notes.getVersion())) {
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

			query.append(_SQL_SELECT_NOTES_WHERE);

			query.append(_FINDER_COLUMN_G_C_V_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_V_CONTENTID_2);

			query.append(_FINDER_COLUMN_G_C_V_VERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(ContentID);

				qPos.add(Version);

				if (!pagination) {
					list = (List<Notes>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Notes>(list);
				}
				else {
					list = (List<Notes>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notes
	 * @throws com.viettel.portal.vcms.NoSuchNotesException if a matching notes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes findByG_C_V_First(long groupId, long ContentID, int Version,
		OrderByComparator orderByComparator)
		throws NoSuchNotesException, SystemException {
		Notes notes = fetchByG_C_V_First(groupId, ContentID, Version,
				orderByComparator);

		if (notes != null) {
			return notes;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", ContentID=");
		msg.append(ContentID);

		msg.append(", Version=");
		msg.append(Version);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotesException(msg.toString());
	}

	/**
	 * Returns the first notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notes, or <code>null</code> if a matching notes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes fetchByG_C_V_First(long groupId, long ContentID, int Version,
		OrderByComparator orderByComparator) throws SystemException {
		List<Notes> list = findByG_C_V(groupId, ContentID, Version, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notes
	 * @throws com.viettel.portal.vcms.NoSuchNotesException if a matching notes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes findByG_C_V_Last(long groupId, long ContentID, int Version,
		OrderByComparator orderByComparator)
		throws NoSuchNotesException, SystemException {
		Notes notes = fetchByG_C_V_Last(groupId, ContentID, Version,
				orderByComparator);

		if (notes != null) {
			return notes;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", ContentID=");
		msg.append(ContentID);

		msg.append(", Version=");
		msg.append(Version);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotesException(msg.toString());
	}

	/**
	 * Returns the last notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notes, or <code>null</code> if a matching notes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes fetchByG_C_V_Last(long groupId, long ContentID, int Version,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_C_V(groupId, ContentID, Version);

		if (count == 0) {
			return null;
		}

		List<Notes> list = findByG_C_V(groupId, ContentID, Version, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the noteses before and after the current notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * @param notesPK the primary key of the current notes
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notes
	 * @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes[] findByG_C_V_PrevAndNext(NotesPK notesPK, long groupId,
		long ContentID, int Version, OrderByComparator orderByComparator)
		throws NoSuchNotesException, SystemException {
		Notes notes = findByPrimaryKey(notesPK);

		Session session = null;

		try {
			session = openSession();

			Notes[] array = new NotesImpl[3];

			array[0] = getByG_C_V_PrevAndNext(session, notes, groupId,
					ContentID, Version, orderByComparator, true);

			array[1] = notes;

			array[2] = getByG_C_V_PrevAndNext(session, notes, groupId,
					ContentID, Version, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Notes getByG_C_V_PrevAndNext(Session session, Notes notes,
		long groupId, long ContentID, int Version,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTES_WHERE);

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
			query.append(NotesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(ContentID);

		qPos.add(Version);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notes);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Notes> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_C_V(long groupId, long ContentID, int Version)
		throws SystemException {
		for (Notes notes : findByG_C_V(groupId, ContentID, Version,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notes);
		}
	}

	/**
	 * Returns the number of noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ContentID the content i d
	 * @param Version the version
	 * @return the number of matching noteses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C_V(long groupId, long ContentID, int Version)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C_V;

		Object[] finderArgs = new Object[] { groupId, ContentID, Version };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_NOTES_WHERE);

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

				qPos.add(ContentID);

				qPos.add(Version);

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

	private static final String _FINDER_COLUMN_G_C_V_GROUPID_2 = "notes.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_CONTENTID_2 = "notes.id.ContentID = ? AND ";
	private static final String _FINDER_COLUMN_G_C_V_VERSION_2 = "notes.id.Version = ?";

	public NotesPersistenceImpl() {
		setModelClass(Notes.class);
	}

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	@Override
	public void cacheResult(Notes notes) {
		EntityCacheUtil.putResult(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesImpl.class, notes.getPrimaryKey(), notes);

		notes.resetOriginalValues();
	}

	/**
	 * Caches the noteses in the entity cache if it is enabled.
	 *
	 * @param noteses the noteses
	 */
	@Override
	public void cacheResult(List<Notes> noteses) {
		for (Notes notes : noteses) {
			if (EntityCacheUtil.getResult(NotesModelImpl.ENTITY_CACHE_ENABLED,
						NotesImpl.class, notes.getPrimaryKey()) == null) {
				cacheResult(notes);
			}
			else {
				notes.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all noteses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NotesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NotesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Notes notes) {
		EntityCacheUtil.removeResult(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesImpl.class, notes.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Notes> noteses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Notes notes : noteses) {
			EntityCacheUtil.removeResult(NotesModelImpl.ENTITY_CACHE_ENABLED,
				NotesImpl.class, notes.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notes with the primary key. Does not add the notes to the database.
	 *
	 * @param notesPK the primary key for the new notes
	 * @return the new notes
	 */
	@Override
	public Notes create(NotesPK notesPK) {
		Notes notes = new NotesImpl();

		notes.setNew(true);
		notes.setPrimaryKey(notesPK);

		return notes;
	}

	/**
	 * Removes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notesPK the primary key of the notes
	 * @return the notes that was removed
	 * @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes remove(NotesPK notesPK)
		throws NoSuchNotesException, SystemException {
		return remove((Serializable)notesPK);
	}

	/**
	 * Removes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notes
	 * @return the notes that was removed
	 * @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes remove(Serializable primaryKey)
		throws NoSuchNotesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Notes notes = (Notes)session.get(NotesImpl.class, primaryKey);

			if (notes == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notes);
		}
		catch (NoSuchNotesException nsee) {
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
	protected Notes removeImpl(Notes notes) throws SystemException {
		notes = toUnwrappedModel(notes);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notes)) {
				notes = (Notes)session.get(NotesImpl.class,
						notes.getPrimaryKeyObj());
			}

			if (notes != null) {
				session.delete(notes);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notes != null) {
			clearCache(notes);
		}

		return notes;
	}

	@Override
	public Notes updateImpl(com.viettel.portal.vcms.model.Notes notes)
		throws SystemException {
		notes = toUnwrappedModel(notes);

		boolean isNew = notes.isNew();

		NotesModelImpl notesModelImpl = (NotesModelImpl)notes;

		Session session = null;

		try {
			session = openSession();

			if (notes.isNew()) {
				session.save(notes);

				notes.setNew(false);
			}
			else {
				session.merge(notes);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NotesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((notesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notesModelImpl.getOriginalGroupId(),
						notesModelImpl.getOriginalContentID(),
						notesModelImpl.getOriginalVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V,
					args);

				args = new Object[] {
						notesModelImpl.getGroupId(),
						notesModelImpl.getContentID(),
						notesModelImpl.getVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_V,
					args);
			}
		}

		EntityCacheUtil.putResult(NotesModelImpl.ENTITY_CACHE_ENABLED,
			NotesImpl.class, notes.getPrimaryKey(), notes);

		return notes;
	}

	protected Notes toUnwrappedModel(Notes notes) {
		if (notes instanceof NotesImpl) {
			return notes;
		}

		NotesImpl notesImpl = new NotesImpl();

		notesImpl.setNew(notes.isNew());
		notesImpl.setPrimaryKey(notes.getPrimaryKey());

		notesImpl.setContentID(notes.getContentID());
		notesImpl.setVersion(notes.getVersion());
		notesImpl.setGroupId(notes.getGroupId());
		notesImpl.setCompanyId(notes.getCompanyId());
		notesImpl.setUserId(notes.getUserId());
		notesImpl.setUserName(notes.getUserName());
		notesImpl.setCreateDate(notes.getCreateDate());
		notesImpl.setModifiedDate(notes.getModifiedDate());
		notesImpl.setContent(notes.getContent());

		return notesImpl;
	}

	/**
	 * Returns the notes with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notes
	 * @return the notes
	 * @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotesException, SystemException {
		Notes notes = fetchByPrimaryKey(primaryKey);

		if (notes == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notes;
	}

	/**
	 * Returns the notes with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchNotesException} if it could not be found.
	 *
	 * @param notesPK the primary key of the notes
	 * @return the notes
	 * @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes findByPrimaryKey(NotesPK notesPK)
		throws NoSuchNotesException, SystemException {
		return findByPrimaryKey((Serializable)notesPK);
	}

	/**
	 * Returns the notes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notes
	 * @return the notes, or <code>null</code> if a notes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Notes notes = (Notes)EntityCacheUtil.getResult(NotesModelImpl.ENTITY_CACHE_ENABLED,
				NotesImpl.class, primaryKey);

		if (notes == _nullNotes) {
			return null;
		}

		if (notes == null) {
			Session session = null;

			try {
				session = openSession();

				notes = (Notes)session.get(NotesImpl.class, primaryKey);

				if (notes != null) {
					cacheResult(notes);
				}
				else {
					EntityCacheUtil.putResult(NotesModelImpl.ENTITY_CACHE_ENABLED,
						NotesImpl.class, primaryKey, _nullNotes);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NotesModelImpl.ENTITY_CACHE_ENABLED,
					NotesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notes;
	}

	/**
	 * Returns the notes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notesPK the primary key of the notes
	 * @return the notes, or <code>null</code> if a notes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notes fetchByPrimaryKey(NotesPK notesPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)notesPK);
	}

	/**
	 * Returns all the noteses.
	 *
	 * @return the noteses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notes> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.NotesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @return the range of noteses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notes> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.NotesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of noteses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notes> findAll(int start, int end,
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

		List<Notes> list = (List<Notes>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NOTES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTES;

				if (pagination) {
					sql = sql.concat(NotesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Notes>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Notes>(list);
				}
				else {
					list = (List<Notes>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the noteses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Notes notes : findAll()) {
			remove(notes);
		}
	}

	/**
	 * Returns the number of noteses.
	 *
	 * @return the number of noteses
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

				Query q = session.createQuery(_SQL_COUNT_NOTES);

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
	 * Initializes the notes persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.Notes")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Notes>> listenersList = new ArrayList<ModelListener<Notes>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Notes>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NotesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NOTES = "SELECT notes FROM Notes notes";
	private static final String _SQL_SELECT_NOTES_WHERE = "SELECT notes FROM Notes notes WHERE ";
	private static final String _SQL_COUNT_NOTES = "SELECT COUNT(notes) FROM Notes notes";
	private static final String _SQL_COUNT_NOTES_WHERE = "SELECT COUNT(notes) FROM Notes notes WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notes.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Notes exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Notes exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NotesPersistenceImpl.class);
	private static Notes _nullNotes = new NotesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Notes> toCacheModel() {
				return _nullNotesCacheModel;
			}
		};

	private static CacheModel<Notes> _nullNotesCacheModel = new CacheModel<Notes>() {
			@Override
			public Notes toEntityModel() {
				return _nullNotes;
			}
		};
}