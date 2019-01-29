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

package com.revotech.portal.vbpq.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.revotech.portal.vbpq.NoSuchAttachFileException;
import com.revotech.portal.vbpq.model.AttachFile;
import com.revotech.portal.vbpq.model.impl.AttachFileImpl;
import com.revotech.portal.vbpq.model.impl.AttachFileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the attach file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see AttachFilePersistence
 * @see AttachFileUtil
 * @generated
 */
public class AttachFilePersistenceImpl extends BasePersistenceImpl<AttachFile>
	implements AttachFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AttachFileUtil} to access the attach file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AttachFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileModelImpl.FINDER_CACHE_ENABLED, AttachFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileModelImpl.FINDER_CACHE_ENABLED, AttachFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VANBANID = new FinderPath(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileModelImpl.FINDER_CACHE_ENABLED, AttachFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVANBANID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VANBANID =
		new FinderPath(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileModelImpl.FINDER_CACHE_ENABLED, AttachFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVANBANID",
			new String[] { Long.class.getName() },
			AttachFileModelImpl.VANBANID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VANBANID = new FinderPath(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVANBANID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the attach files where vanBanId = &#63;.
	 *
	 * @param vanBanId the van ban ID
	 * @return the matching attach files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachFile> findByVANBANID(long vanBanId)
		throws SystemException {
		return findByVANBANID(vanBanId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the attach files where vanBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vanBanId the van ban ID
	 * @param start the lower bound of the range of attach files
	 * @param end the upper bound of the range of attach files (not inclusive)
	 * @return the range of matching attach files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachFile> findByVANBANID(long vanBanId, int start, int end)
		throws SystemException {
		return findByVANBANID(vanBanId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attach files where vanBanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vanBanId the van ban ID
	 * @param start the lower bound of the range of attach files
	 * @param end the upper bound of the range of attach files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attach files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachFile> findByVANBANID(long vanBanId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VANBANID;
			finderArgs = new Object[] { vanBanId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VANBANID;
			finderArgs = new Object[] { vanBanId, start, end, orderByComparator };
		}

		List<AttachFile> list = (List<AttachFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttachFile attachFile : list) {
				if ((vanBanId != attachFile.getVanBanId())) {
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

			query.append(_SQL_SELECT_ATTACHFILE_WHERE);

			query.append(_FINDER_COLUMN_VANBANID_VANBANID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttachFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vanBanId);

				if (!pagination) {
					list = (List<AttachFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachFile>(list);
				}
				else {
					list = (List<AttachFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attach file in the ordered set where vanBanId = &#63;.
	 *
	 * @param vanBanId the van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attach file
	 * @throws com.revotech.portal.vbpq.NoSuchAttachFileException if a matching attach file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile findByVANBANID_First(long vanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchAttachFileException, SystemException {
		AttachFile attachFile = fetchByVANBANID_First(vanBanId,
				orderByComparator);

		if (attachFile != null) {
			return attachFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vanBanId=");
		msg.append(vanBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachFileException(msg.toString());
	}

	/**
	 * Returns the first attach file in the ordered set where vanBanId = &#63;.
	 *
	 * @param vanBanId the van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attach file, or <code>null</code> if a matching attach file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile fetchByVANBANID_First(long vanBanId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AttachFile> list = findByVANBANID(vanBanId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attach file in the ordered set where vanBanId = &#63;.
	 *
	 * @param vanBanId the van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attach file
	 * @throws com.revotech.portal.vbpq.NoSuchAttachFileException if a matching attach file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile findByVANBANID_Last(long vanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchAttachFileException, SystemException {
		AttachFile attachFile = fetchByVANBANID_Last(vanBanId, orderByComparator);

		if (attachFile != null) {
			return attachFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vanBanId=");
		msg.append(vanBanId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachFileException(msg.toString());
	}

	/**
	 * Returns the last attach file in the ordered set where vanBanId = &#63;.
	 *
	 * @param vanBanId the van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attach file, or <code>null</code> if a matching attach file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile fetchByVANBANID_Last(long vanBanId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVANBANID(vanBanId);

		if (count == 0) {
			return null;
		}

		List<AttachFile> list = findByVANBANID(vanBanId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attach files before and after the current attach file in the ordered set where vanBanId = &#63;.
	 *
	 * @param id the primary key of the current attach file
	 * @param vanBanId the van ban ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attach file
	 * @throws com.revotech.portal.vbpq.NoSuchAttachFileException if a attach file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile[] findByVANBANID_PrevAndNext(long id, long vanBanId,
		OrderByComparator orderByComparator)
		throws NoSuchAttachFileException, SystemException {
		AttachFile attachFile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AttachFile[] array = new AttachFileImpl[3];

			array[0] = getByVANBANID_PrevAndNext(session, attachFile, vanBanId,
					orderByComparator, true);

			array[1] = attachFile;

			array[2] = getByVANBANID_PrevAndNext(session, attachFile, vanBanId,
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

	protected AttachFile getByVANBANID_PrevAndNext(Session session,
		AttachFile attachFile, long vanBanId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHFILE_WHERE);

		query.append(_FINDER_COLUMN_VANBANID_VANBANID_2);

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
			query.append(AttachFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vanBanId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attachFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttachFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attach files where vanBanId = &#63; from the database.
	 *
	 * @param vanBanId the van ban ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVANBANID(long vanBanId) throws SystemException {
		for (AttachFile attachFile : findByVANBANID(vanBanId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attachFile);
		}
	}

	/**
	 * Returns the number of attach files where vanBanId = &#63;.
	 *
	 * @param vanBanId the van ban ID
	 * @return the number of matching attach files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVANBANID(long vanBanId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VANBANID;

		Object[] finderArgs = new Object[] { vanBanId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTACHFILE_WHERE);

			query.append(_FINDER_COLUMN_VANBANID_VANBANID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vanBanId);

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

	private static final String _FINDER_COLUMN_VANBANID_VANBANID_2 = "attachFile.vanBanId = ?";

	public AttachFilePersistenceImpl() {
		setModelClass(AttachFile.class);
	}

	/**
	 * Caches the attach file in the entity cache if it is enabled.
	 *
	 * @param attachFile the attach file
	 */
	@Override
	public void cacheResult(AttachFile attachFile) {
		EntityCacheUtil.putResult(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileImpl.class, attachFile.getPrimaryKey(), attachFile);

		attachFile.resetOriginalValues();
	}

	/**
	 * Caches the attach files in the entity cache if it is enabled.
	 *
	 * @param attachFiles the attach files
	 */
	@Override
	public void cacheResult(List<AttachFile> attachFiles) {
		for (AttachFile attachFile : attachFiles) {
			if (EntityCacheUtil.getResult(
						AttachFileModelImpl.ENTITY_CACHE_ENABLED,
						AttachFileImpl.class, attachFile.getPrimaryKey()) == null) {
				cacheResult(attachFile);
			}
			else {
				attachFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attach files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AttachFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AttachFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attach file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttachFile attachFile) {
		EntityCacheUtil.removeResult(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileImpl.class, attachFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AttachFile> attachFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttachFile attachFile : attachFiles) {
			EntityCacheUtil.removeResult(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
				AttachFileImpl.class, attachFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new attach file with the primary key. Does not add the attach file to the database.
	 *
	 * @param id the primary key for the new attach file
	 * @return the new attach file
	 */
	@Override
	public AttachFile create(long id) {
		AttachFile attachFile = new AttachFileImpl();

		attachFile.setNew(true);
		attachFile.setPrimaryKey(id);

		return attachFile;
	}

	/**
	 * Removes the attach file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the attach file
	 * @return the attach file that was removed
	 * @throws com.revotech.portal.vbpq.NoSuchAttachFileException if a attach file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile remove(long id)
		throws NoSuchAttachFileException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the attach file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attach file
	 * @return the attach file that was removed
	 * @throws com.revotech.portal.vbpq.NoSuchAttachFileException if a attach file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile remove(Serializable primaryKey)
		throws NoSuchAttachFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AttachFile attachFile = (AttachFile)session.get(AttachFileImpl.class,
					primaryKey);

			if (attachFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttachFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(attachFile);
		}
		catch (NoSuchAttachFileException nsee) {
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
	protected AttachFile removeImpl(AttachFile attachFile)
		throws SystemException {
		attachFile = toUnwrappedModel(attachFile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attachFile)) {
				attachFile = (AttachFile)session.get(AttachFileImpl.class,
						attachFile.getPrimaryKeyObj());
			}

			if (attachFile != null) {
				session.delete(attachFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attachFile != null) {
			clearCache(attachFile);
		}

		return attachFile;
	}

	@Override
	public AttachFile updateImpl(
		com.revotech.portal.vbpq.model.AttachFile attachFile)
		throws SystemException {
		attachFile = toUnwrappedModel(attachFile);

		boolean isNew = attachFile.isNew();

		AttachFileModelImpl attachFileModelImpl = (AttachFileModelImpl)attachFile;

		Session session = null;

		try {
			session = openSession();

			if (attachFile.isNew()) {
				session.save(attachFile);

				attachFile.setNew(false);
			}
			else {
				session.merge(attachFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AttachFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((attachFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VANBANID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachFileModelImpl.getOriginalVanBanId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VANBANID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VANBANID,
					args);

				args = new Object[] { attachFileModelImpl.getVanBanId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VANBANID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VANBANID,
					args);
			}
		}

		EntityCacheUtil.putResult(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
			AttachFileImpl.class, attachFile.getPrimaryKey(), attachFile);

		return attachFile;
	}

	protected AttachFile toUnwrappedModel(AttachFile attachFile) {
		if (attachFile instanceof AttachFileImpl) {
			return attachFile;
		}

		AttachFileImpl attachFileImpl = new AttachFileImpl();

		attachFileImpl.setNew(attachFile.isNew());
		attachFileImpl.setPrimaryKey(attachFile.getPrimaryKey());

		attachFileImpl.setId(attachFile.getId());
		attachFileImpl.setVanBanId(attachFile.getVanBanId());
		attachFileImpl.setFileId(attachFile.getFileId());
		attachFileImpl.setFileLink(attachFile.getFileLink());
		attachFileImpl.setFileName(attachFile.getFileName());
		attachFileImpl.setFileSize(attachFile.getFileSize());

		return attachFileImpl;
	}

	/**
	 * Returns the attach file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the attach file
	 * @return the attach file
	 * @throws com.revotech.portal.vbpq.NoSuchAttachFileException if a attach file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttachFileException, SystemException {
		AttachFile attachFile = fetchByPrimaryKey(primaryKey);

		if (attachFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttachFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return attachFile;
	}

	/**
	 * Returns the attach file with the primary key or throws a {@link com.revotech.portal.vbpq.NoSuchAttachFileException} if it could not be found.
	 *
	 * @param id the primary key of the attach file
	 * @return the attach file
	 * @throws com.revotech.portal.vbpq.NoSuchAttachFileException if a attach file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile findByPrimaryKey(long id)
		throws NoSuchAttachFileException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the attach file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attach file
	 * @return the attach file, or <code>null</code> if a attach file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AttachFile attachFile = (AttachFile)EntityCacheUtil.getResult(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
				AttachFileImpl.class, primaryKey);

		if (attachFile == _nullAttachFile) {
			return null;
		}

		if (attachFile == null) {
			Session session = null;

			try {
				session = openSession();

				attachFile = (AttachFile)session.get(AttachFileImpl.class,
						primaryKey);

				if (attachFile != null) {
					cacheResult(attachFile);
				}
				else {
					EntityCacheUtil.putResult(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
						AttachFileImpl.class, primaryKey, _nullAttachFile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AttachFileModelImpl.ENTITY_CACHE_ENABLED,
					AttachFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attachFile;
	}

	/**
	 * Returns the attach file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the attach file
	 * @return the attach file, or <code>null</code> if a attach file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachFile fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the attach files.
	 *
	 * @return the attach files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attach files
	 * @param end the upper bound of the range of attach files (not inclusive)
	 * @return the range of attach files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attach files
	 * @param end the upper bound of the range of attach files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attach files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachFile> findAll(int start, int end,
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

		List<AttachFile> list = (List<AttachFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ATTACHFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTACHFILE;

				if (pagination) {
					sql = sql.concat(AttachFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AttachFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachFile>(list);
				}
				else {
					list = (List<AttachFile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the attach files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AttachFile attachFile : findAll()) {
			remove(attachFile);
		}
	}

	/**
	 * Returns the number of attach files.
	 *
	 * @return the number of attach files
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

				Query q = session.createQuery(_SQL_COUNT_ATTACHFILE);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the attach file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.revotech.portal.vbpq.model.AttachFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AttachFile>> listenersList = new ArrayList<ModelListener<AttachFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AttachFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AttachFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ATTACHFILE = "SELECT attachFile FROM AttachFile attachFile";
	private static final String _SQL_SELECT_ATTACHFILE_WHERE = "SELECT attachFile FROM AttachFile attachFile WHERE ";
	private static final String _SQL_COUNT_ATTACHFILE = "SELECT COUNT(attachFile) FROM AttachFile attachFile";
	private static final String _SQL_COUNT_ATTACHFILE_WHERE = "SELECT COUNT(attachFile) FROM AttachFile attachFile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "attachFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AttachFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AttachFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AttachFilePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "vanBanId", "fileId", "fileLink", "fileName", "fileSize"
			});
	private static AttachFile _nullAttachFile = new AttachFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AttachFile> toCacheModel() {
				return _nullAttachFileCacheModel;
			}
		};

	private static CacheModel<AttachFile> _nullAttachFileCacheModel = new CacheModel<AttachFile>() {
			@Override
			public AttachFile toEntityModel() {
				return _nullAttachFile;
			}
		};
}