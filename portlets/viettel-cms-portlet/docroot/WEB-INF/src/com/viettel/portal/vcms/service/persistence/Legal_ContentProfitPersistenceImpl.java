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

import com.viettel.portal.vcms.NoSuchLegal_ContentProfitException;
import com.viettel.portal.vcms.model.Legal_ContentProfit;
import com.viettel.portal.vcms.model.impl.Legal_ContentProfitImpl;
import com.viettel.portal.vcms.model.impl.Legal_ContentProfitModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legal_ content profit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_ContentProfitPersistence
 * @see Legal_ContentProfitUtil
 * @generated
 */
public class Legal_ContentProfitPersistenceImpl extends BasePersistenceImpl<Legal_ContentProfit>
	implements Legal_ContentProfitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Legal_ContentProfitUtil} to access the legal_ content profit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Legal_ContentProfitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentProfitModelImpl.FINDER_CACHE_ENABLED,
			Legal_ContentProfitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentProfitModelImpl.FINDER_CACHE_ENABLED,
			Legal_ContentProfitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentProfitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Legal_ContentProfitPersistenceImpl() {
		setModelClass(Legal_ContentProfit.class);
	}

	/**
	 * Caches the legal_ content profit in the entity cache if it is enabled.
	 *
	 * @param legal_ContentProfit the legal_ content profit
	 */
	@Override
	public void cacheResult(Legal_ContentProfit legal_ContentProfit) {
		EntityCacheUtil.putResult(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentProfitImpl.class, legal_ContentProfit.getPrimaryKey(),
			legal_ContentProfit);

		legal_ContentProfit.resetOriginalValues();
	}

	/**
	 * Caches the legal_ content profits in the entity cache if it is enabled.
	 *
	 * @param legal_ContentProfits the legal_ content profits
	 */
	@Override
	public void cacheResult(List<Legal_ContentProfit> legal_ContentProfits) {
		for (Legal_ContentProfit legal_ContentProfit : legal_ContentProfits) {
			if (EntityCacheUtil.getResult(
						Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
						Legal_ContentProfitImpl.class,
						legal_ContentProfit.getPrimaryKey()) == null) {
				cacheResult(legal_ContentProfit);
			}
			else {
				legal_ContentProfit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal_ content profits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Legal_ContentProfitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Legal_ContentProfitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal_ content profit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Legal_ContentProfit legal_ContentProfit) {
		EntityCacheUtil.removeResult(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentProfitImpl.class, legal_ContentProfit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Legal_ContentProfit> legal_ContentProfits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Legal_ContentProfit legal_ContentProfit : legal_ContentProfits) {
			EntityCacheUtil.removeResult(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
				Legal_ContentProfitImpl.class,
				legal_ContentProfit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legal_ content profit with the primary key. Does not add the legal_ content profit to the database.
	 *
	 * @param ContentID the primary key for the new legal_ content profit
	 * @return the new legal_ content profit
	 */
	@Override
	public Legal_ContentProfit create(int ContentID) {
		Legal_ContentProfit legal_ContentProfit = new Legal_ContentProfitImpl();

		legal_ContentProfit.setNew(true);
		legal_ContentProfit.setPrimaryKey(ContentID);

		return legal_ContentProfit;
	}

	/**
	 * Removes the legal_ content profit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ContentID the primary key of the legal_ content profit
	 * @return the legal_ content profit that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentProfitException if a legal_ content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_ContentProfit remove(int ContentID)
		throws NoSuchLegal_ContentProfitException, SystemException {
		return remove((Serializable)ContentID);
	}

	/**
	 * Removes the legal_ content profit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal_ content profit
	 * @return the legal_ content profit that was removed
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentProfitException if a legal_ content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_ContentProfit remove(Serializable primaryKey)
		throws NoSuchLegal_ContentProfitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Legal_ContentProfit legal_ContentProfit = (Legal_ContentProfit)session.get(Legal_ContentProfitImpl.class,
					primaryKey);

			if (legal_ContentProfit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegal_ContentProfitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legal_ContentProfit);
		}
		catch (NoSuchLegal_ContentProfitException nsee) {
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
	protected Legal_ContentProfit removeImpl(
		Legal_ContentProfit legal_ContentProfit) throws SystemException {
		legal_ContentProfit = toUnwrappedModel(legal_ContentProfit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legal_ContentProfit)) {
				legal_ContentProfit = (Legal_ContentProfit)session.get(Legal_ContentProfitImpl.class,
						legal_ContentProfit.getPrimaryKeyObj());
			}

			if (legal_ContentProfit != null) {
				session.delete(legal_ContentProfit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legal_ContentProfit != null) {
			clearCache(legal_ContentProfit);
		}

		return legal_ContentProfit;
	}

	@Override
	public Legal_ContentProfit updateImpl(
		com.viettel.portal.vcms.model.Legal_ContentProfit legal_ContentProfit)
		throws SystemException {
		legal_ContentProfit = toUnwrappedModel(legal_ContentProfit);

		boolean isNew = legal_ContentProfit.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legal_ContentProfit.isNew()) {
				session.save(legal_ContentProfit);

				legal_ContentProfit.setNew(false);
			}
			else {
				session.merge(legal_ContentProfit);
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

		EntityCacheUtil.putResult(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
			Legal_ContentProfitImpl.class, legal_ContentProfit.getPrimaryKey(),
			legal_ContentProfit);

		return legal_ContentProfit;
	}

	protected Legal_ContentProfit toUnwrappedModel(
		Legal_ContentProfit legal_ContentProfit) {
		if (legal_ContentProfit instanceof Legal_ContentProfitImpl) {
			return legal_ContentProfit;
		}

		Legal_ContentProfitImpl legal_ContentProfitImpl = new Legal_ContentProfitImpl();

		legal_ContentProfitImpl.setNew(legal_ContentProfit.isNew());
		legal_ContentProfitImpl.setPrimaryKey(legal_ContentProfit.getPrimaryKey());

		legal_ContentProfitImpl.setContentID(legal_ContentProfit.getContentID());
		legal_ContentProfitImpl.setContentTypeID(legal_ContentProfit.getContentTypeID());
		legal_ContentProfitImpl.setHeadline(legal_ContentProfit.getHeadline());
		legal_ContentProfitImpl.setCost(legal_ContentProfit.getCost());
		legal_ContentProfitImpl.setAuthor(legal_ContentProfit.getAuthor());
		legal_ContentProfitImpl.setStatus(legal_ContentProfit.getStatus());
		legal_ContentProfitImpl.setCreationDate(legal_ContentProfit.getCreationDate());
		legal_ContentProfitImpl.setModifiedDate(legal_ContentProfit.getModifiedDate());
		legal_ContentProfitImpl.setDistributedDate(legal_ContentProfit.getDistributedDate());

		return legal_ContentProfitImpl;
	}

	/**
	 * Returns the legal_ content profit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ content profit
	 * @return the legal_ content profit
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentProfitException if a legal_ content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_ContentProfit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegal_ContentProfitException, SystemException {
		Legal_ContentProfit legal_ContentProfit = fetchByPrimaryKey(primaryKey);

		if (legal_ContentProfit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegal_ContentProfitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legal_ContentProfit;
	}

	/**
	 * Returns the legal_ content profit with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_ContentProfitException} if it could not be found.
	 *
	 * @param ContentID the primary key of the legal_ content profit
	 * @return the legal_ content profit
	 * @throws com.viettel.portal.vcms.NoSuchLegal_ContentProfitException if a legal_ content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_ContentProfit findByPrimaryKey(int ContentID)
		throws NoSuchLegal_ContentProfitException, SystemException {
		return findByPrimaryKey((Serializable)ContentID);
	}

	/**
	 * Returns the legal_ content profit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal_ content profit
	 * @return the legal_ content profit, or <code>null</code> if a legal_ content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_ContentProfit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Legal_ContentProfit legal_ContentProfit = (Legal_ContentProfit)EntityCacheUtil.getResult(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
				Legal_ContentProfitImpl.class, primaryKey);

		if (legal_ContentProfit == _nullLegal_ContentProfit) {
			return null;
		}

		if (legal_ContentProfit == null) {
			Session session = null;

			try {
				session = openSession();

				legal_ContentProfit = (Legal_ContentProfit)session.get(Legal_ContentProfitImpl.class,
						primaryKey);

				if (legal_ContentProfit != null) {
					cacheResult(legal_ContentProfit);
				}
				else {
					EntityCacheUtil.putResult(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
						Legal_ContentProfitImpl.class, primaryKey,
						_nullLegal_ContentProfit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Legal_ContentProfitModelImpl.ENTITY_CACHE_ENABLED,
					Legal_ContentProfitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legal_ContentProfit;
	}

	/**
	 * Returns the legal_ content profit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ContentID the primary key of the legal_ content profit
	 * @return the legal_ content profit, or <code>null</code> if a legal_ content profit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legal_ContentProfit fetchByPrimaryKey(int ContentID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ContentID);
	}

	/**
	 * Returns all the legal_ content profits.
	 *
	 * @return the legal_ content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_ContentProfit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal_ content profits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ content profits
	 * @param end the upper bound of the range of legal_ content profits (not inclusive)
	 * @return the range of legal_ content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_ContentProfit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal_ content profits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal_ content profits
	 * @param end the upper bound of the range of legal_ content profits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal_ content profits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legal_ContentProfit> findAll(int start, int end,
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

		List<Legal_ContentProfit> list = (List<Legal_ContentProfit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGAL_CONTENTPROFIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGAL_CONTENTPROFIT;

				if (pagination) {
					sql = sql.concat(Legal_ContentProfitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Legal_ContentProfit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legal_ContentProfit>(list);
				}
				else {
					list = (List<Legal_ContentProfit>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the legal_ content profits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Legal_ContentProfit legal_ContentProfit : findAll()) {
			remove(legal_ContentProfit);
		}
	}

	/**
	 * Returns the number of legal_ content profits.
	 *
	 * @return the number of legal_ content profits
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

				Query q = session.createQuery(_SQL_COUNT_LEGAL_CONTENTPROFIT);

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
	 * Initializes the legal_ content profit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.vcms.model.Legal_ContentProfit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Legal_ContentProfit>> listenersList = new ArrayList<ModelListener<Legal_ContentProfit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Legal_ContentProfit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Legal_ContentProfitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGAL_CONTENTPROFIT = "SELECT legal_ContentProfit FROM Legal_ContentProfit legal_ContentProfit";
	private static final String _SQL_COUNT_LEGAL_CONTENTPROFIT = "SELECT COUNT(legal_ContentProfit) FROM Legal_ContentProfit legal_ContentProfit";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legal_ContentProfit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Legal_ContentProfit exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Legal_ContentProfitPersistenceImpl.class);
	private static Legal_ContentProfit _nullLegal_ContentProfit = new Legal_ContentProfitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Legal_ContentProfit> toCacheModel() {
				return _nullLegal_ContentProfitCacheModel;
			}
		};

	private static CacheModel<Legal_ContentProfit> _nullLegal_ContentProfitCacheModel =
		new CacheModel<Legal_ContentProfit>() {
			@Override
			public Legal_ContentProfit toEntityModel() {
				return _nullLegal_ContentProfit;
			}
		};
}