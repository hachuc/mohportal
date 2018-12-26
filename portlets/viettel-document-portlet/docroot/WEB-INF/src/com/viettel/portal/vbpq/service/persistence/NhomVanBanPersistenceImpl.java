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

package com.viettel.portal.vbpq.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.vbpq.NoSuchNhomVanBanException;
import com.viettel.portal.vbpq.model.NhomVanBan;
import com.viettel.portal.vbpq.model.impl.NhomVanBanImpl;
import com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the nhom van ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see NhomVanBanPersistence
 * @see NhomVanBanUtil
 * @generated
 */
public class NhomVanBanPersistenceImpl extends BasePersistenceImpl<NhomVanBan>
	implements NhomVanBanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NhomVanBanUtil} to access the nhom van ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NhomVanBanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
			NhomVanBanModelImpl.FINDER_CACHE_ENABLED, NhomVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
			NhomVanBanModelImpl.FINDER_CACHE_ENABLED, NhomVanBanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
			NhomVanBanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NhomVanBanPersistenceImpl() {
		setModelClass(NhomVanBan.class);
	}

	/**
	 * Caches the nhom van ban in the entity cache if it is enabled.
	 *
	 * @param nhomVanBan the nhom van ban
	 */
	@Override
	public void cacheResult(NhomVanBan nhomVanBan) {
		EntityCacheUtil.putResult(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
			NhomVanBanImpl.class, nhomVanBan.getPrimaryKey(), nhomVanBan);

		nhomVanBan.resetOriginalValues();
	}

	/**
	 * Caches the nhom van bans in the entity cache if it is enabled.
	 *
	 * @param nhomVanBans the nhom van bans
	 */
	@Override
	public void cacheResult(List<NhomVanBan> nhomVanBans) {
		for (NhomVanBan nhomVanBan : nhomVanBans) {
			if (EntityCacheUtil.getResult(
						NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
						NhomVanBanImpl.class, nhomVanBan.getPrimaryKey()) == null) {
				cacheResult(nhomVanBan);
			}
			else {
				nhomVanBan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all nhom van bans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NhomVanBanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NhomVanBanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nhom van ban.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NhomVanBan nhomVanBan) {
		EntityCacheUtil.removeResult(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
			NhomVanBanImpl.class, nhomVanBan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NhomVanBan> nhomVanBans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NhomVanBan nhomVanBan : nhomVanBans) {
			EntityCacheUtil.removeResult(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
				NhomVanBanImpl.class, nhomVanBan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new nhom van ban with the primary key. Does not add the nhom van ban to the database.
	 *
	 * @param id the primary key for the new nhom van ban
	 * @return the new nhom van ban
	 */
	@Override
	public NhomVanBan create(long id) {
		NhomVanBan nhomVanBan = new NhomVanBanImpl();

		nhomVanBan.setNew(true);
		nhomVanBan.setPrimaryKey(id);

		return nhomVanBan;
	}

	/**
	 * Removes the nhom van ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom van ban
	 * @return the nhom van ban that was removed
	 * @throws com.viettel.portal.vbpq.NoSuchNhomVanBanException if a nhom van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomVanBan remove(long id)
		throws NoSuchNhomVanBanException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the nhom van ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nhom van ban
	 * @return the nhom van ban that was removed
	 * @throws com.viettel.portal.vbpq.NoSuchNhomVanBanException if a nhom van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomVanBan remove(Serializable primaryKey)
		throws NoSuchNhomVanBanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NhomVanBan nhomVanBan = (NhomVanBan)session.get(NhomVanBanImpl.class,
					primaryKey);

			if (nhomVanBan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNhomVanBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nhomVanBan);
		}
		catch (NoSuchNhomVanBanException nsee) {
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
	protected NhomVanBan removeImpl(NhomVanBan nhomVanBan)
		throws SystemException {
		nhomVanBan = toUnwrappedModel(nhomVanBan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nhomVanBan)) {
				nhomVanBan = (NhomVanBan)session.get(NhomVanBanImpl.class,
						nhomVanBan.getPrimaryKeyObj());
			}

			if (nhomVanBan != null) {
				session.delete(nhomVanBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nhomVanBan != null) {
			clearCache(nhomVanBan);
		}

		return nhomVanBan;
	}

	@Override
	public NhomVanBan updateImpl(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws SystemException {
		nhomVanBan = toUnwrappedModel(nhomVanBan);

		boolean isNew = nhomVanBan.isNew();

		Session session = null;

		try {
			session = openSession();

			if (nhomVanBan.isNew()) {
				session.save(nhomVanBan);

				nhomVanBan.setNew(false);
			}
			else {
				session.merge(nhomVanBan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
			NhomVanBanImpl.class, nhomVanBan.getPrimaryKey(), nhomVanBan);

		return nhomVanBan;
	}

	protected NhomVanBan toUnwrappedModel(NhomVanBan nhomVanBan) {
		if (nhomVanBan instanceof NhomVanBanImpl) {
			return nhomVanBan;
		}

		NhomVanBanImpl nhomVanBanImpl = new NhomVanBanImpl();

		nhomVanBanImpl.setNew(nhomVanBan.isNew());
		nhomVanBanImpl.setPrimaryKey(nhomVanBan.getPrimaryKey());

		nhomVanBanImpl.setId(nhomVanBan.getId());
		nhomVanBanImpl.setTenNhom(nhomVanBan.getTenNhom());
		nhomVanBanImpl.setNguoiTao(nhomVanBan.getNguoiTao());
		nhomVanBanImpl.setNguoiTaoId(nhomVanBan.getNguoiTaoId());
		nhomVanBanImpl.setNgayTao(nhomVanBan.getNgayTao());
		nhomVanBanImpl.setNgaySua(nhomVanBan.getNgaySua());
		nhomVanBanImpl.setNguoiSua(nhomVanBan.getNguoiSua());
		nhomVanBanImpl.setNguoiSuaId(nhomVanBan.getNguoiSuaId());
		nhomVanBanImpl.setTrangThai(nhomVanBan.getTrangThai());
		nhomVanBanImpl.setGroupId(nhomVanBan.getGroupId());

		return nhomVanBanImpl;
	}

	/**
	 * Returns the nhom van ban with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the nhom van ban
	 * @return the nhom van ban
	 * @throws com.viettel.portal.vbpq.NoSuchNhomVanBanException if a nhom van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomVanBan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNhomVanBanException, SystemException {
		NhomVanBan nhomVanBan = fetchByPrimaryKey(primaryKey);

		if (nhomVanBan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNhomVanBanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return nhomVanBan;
	}

	/**
	 * Returns the nhom van ban with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchNhomVanBanException} if it could not be found.
	 *
	 * @param id the primary key of the nhom van ban
	 * @return the nhom van ban
	 * @throws com.viettel.portal.vbpq.NoSuchNhomVanBanException if a nhom van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomVanBan findByPrimaryKey(long id)
		throws NoSuchNhomVanBanException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the nhom van ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nhom van ban
	 * @return the nhom van ban, or <code>null</code> if a nhom van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomVanBan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NhomVanBan nhomVanBan = (NhomVanBan)EntityCacheUtil.getResult(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
				NhomVanBanImpl.class, primaryKey);

		if (nhomVanBan == _nullNhomVanBan) {
			return null;
		}

		if (nhomVanBan == null) {
			Session session = null;

			try {
				session = openSession();

				nhomVanBan = (NhomVanBan)session.get(NhomVanBanImpl.class,
						primaryKey);

				if (nhomVanBan != null) {
					cacheResult(nhomVanBan);
				}
				else {
					EntityCacheUtil.putResult(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
						NhomVanBanImpl.class, primaryKey, _nullNhomVanBan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NhomVanBanModelImpl.ENTITY_CACHE_ENABLED,
					NhomVanBanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nhomVanBan;
	}

	/**
	 * Returns the nhom van ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom van ban
	 * @return the nhom van ban, or <code>null</code> if a nhom van ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomVanBan fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the nhom van bans.
	 *
	 * @return the nhom van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NhomVanBan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nhom van bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom van bans
	 * @param end the upper bound of the range of nhom van bans (not inclusive)
	 * @return the range of nhom van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NhomVanBan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nhom van bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom van bans
	 * @param end the upper bound of the range of nhom van bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nhom van bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NhomVanBan> findAll(int start, int end,
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

		List<NhomVanBan> list = (List<NhomVanBan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NHOMVANBAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NHOMVANBAN;

				if (pagination) {
					sql = sql.concat(NhomVanBanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NhomVanBan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NhomVanBan>(list);
				}
				else {
					list = (List<NhomVanBan>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the nhom van bans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NhomVanBan nhomVanBan : findAll()) {
			remove(nhomVanBan);
		}
	}

	/**
	 * Returns the number of nhom van bans.
	 *
	 * @return the number of nhom van bans
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

				Query q = session.createQuery(_SQL_COUNT_NHOMVANBAN);

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
	 * Initializes the nhom van ban persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vbpq.model.NhomVanBan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NhomVanBan>> listenersList = new ArrayList<ModelListener<NhomVanBan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NhomVanBan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NhomVanBanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NHOMVANBAN = "SELECT nhomVanBan FROM NhomVanBan nhomVanBan";
	private static final String _SQL_COUNT_NHOMVANBAN = "SELECT COUNT(nhomVanBan) FROM NhomVanBan nhomVanBan";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nhomVanBan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NhomVanBan exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NhomVanBanPersistenceImpl.class);
	private static NhomVanBan _nullNhomVanBan = new NhomVanBanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NhomVanBan> toCacheModel() {
				return _nullNhomVanBanCacheModel;
			}
		};

	private static CacheModel<NhomVanBan> _nullNhomVanBanCacheModel = new CacheModel<NhomVanBan>() {
			@Override
			public NhomVanBan toEntityModel() {
				return _nullNhomVanBan;
			}
		};
}