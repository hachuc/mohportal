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

package com.revotech.portal.videolibrary.service.persistence;

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

import com.revotech.portal.videolibrary.NoSuchVideoCategoryException;
import com.revotech.portal.videolibrary.model.VideoCategory;
import com.revotech.portal.videolibrary.model.impl.VideoCategoryImpl;
import com.revotech.portal.videolibrary.model.impl.VideoCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VideoCategoryPersistence
 * @see VideoCategoryUtil
 * @generated
 */
public class VideoCategoryPersistenceImpl extends BasePersistenceImpl<VideoCategory>
	implements VideoCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoCategoryUtil} to access the video category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VideoCategoryPersistenceImpl() {
		setModelClass(VideoCategory.class);
	}

	/**
	 * Caches the video category in the entity cache if it is enabled.
	 *
	 * @param videoCategory the video category
	 */
	@Override
	public void cacheResult(VideoCategory videoCategory) {
		EntityCacheUtil.putResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryImpl.class, videoCategory.getPrimaryKey(),
			videoCategory);

		videoCategory.resetOriginalValues();
	}

	/**
	 * Caches the video categories in the entity cache if it is enabled.
	 *
	 * @param videoCategories the video categories
	 */
	@Override
	public void cacheResult(List<VideoCategory> videoCategories) {
		for (VideoCategory videoCategory : videoCategories) {
			if (EntityCacheUtil.getResult(
						VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VideoCategoryImpl.class, videoCategory.getPrimaryKey()) == null) {
				cacheResult(videoCategory);
			}
			else {
				videoCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoCategory videoCategory) {
		EntityCacheUtil.removeResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryImpl.class, videoCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoCategory> videoCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoCategory videoCategory : videoCategories) {
			EntityCacheUtil.removeResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VideoCategoryImpl.class, videoCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video category with the primary key. Does not add the video category to the database.
	 *
	 * @param ID the primary key for the new video category
	 * @return the new video category
	 */
	@Override
	public VideoCategory create(int ID) {
		VideoCategory videoCategory = new VideoCategoryImpl();

		videoCategory.setNew(true);
		videoCategory.setPrimaryKey(ID);

		return videoCategory;
	}

	/**
	 * Removes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the video category
	 * @return the video category that was removed
	 * @throws com.revotech.portal.videolibrary.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory remove(int ID)
		throws NoSuchVideoCategoryException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video category
	 * @return the video category that was removed
	 * @throws com.revotech.portal.videolibrary.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory remove(Serializable primaryKey)
		throws NoSuchVideoCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoCategory videoCategory = (VideoCategory)session.get(VideoCategoryImpl.class,
					primaryKey);

			if (videoCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoCategory);
		}
		catch (NoSuchVideoCategoryException nsee) {
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
	protected VideoCategory removeImpl(VideoCategory videoCategory)
		throws SystemException {
		videoCategory = toUnwrappedModel(videoCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(videoCategory)) {
				videoCategory = (VideoCategory)session.get(VideoCategoryImpl.class,
						videoCategory.getPrimaryKeyObj());
			}

			if (videoCategory != null) {
				session.delete(videoCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (videoCategory != null) {
			clearCache(videoCategory);
		}

		return videoCategory;
	}

	@Override
	public VideoCategory updateImpl(
		com.revotech.portal.videolibrary.model.VideoCategory videoCategory)
		throws SystemException {
		videoCategory = toUnwrappedModel(videoCategory);

		boolean isNew = videoCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (videoCategory.isNew()) {
				session.save(videoCategory);

				videoCategory.setNew(false);
			}
			else {
				session.merge(videoCategory);
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

		EntityCacheUtil.putResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryImpl.class, videoCategory.getPrimaryKey(),
			videoCategory);

		return videoCategory;
	}

	protected VideoCategory toUnwrappedModel(VideoCategory videoCategory) {
		if (videoCategory instanceof VideoCategoryImpl) {
			return videoCategory;
		}

		VideoCategoryImpl videoCategoryImpl = new VideoCategoryImpl();

		videoCategoryImpl.setNew(videoCategory.isNew());
		videoCategoryImpl.setPrimaryKey(videoCategory.getPrimaryKey());

		videoCategoryImpl.setID(videoCategory.getID());
		videoCategoryImpl.setName(videoCategory.getName());
		videoCategoryImpl.setUrl(videoCategory.getUrl());
		videoCategoryImpl.setSortOrder(videoCategory.getSortOrder());
		videoCategoryImpl.setItemCount(videoCategory.getItemCount());

		return videoCategoryImpl;
	}

	/**
	 * Returns the video category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video category
	 * @return the video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoCategoryException, SystemException {
		VideoCategory videoCategory = fetchByPrimaryKey(primaryKey);

		if (videoCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return videoCategory;
	}

	/**
	 * Returns the video category with the primary key or throws a {@link com.revotech.portal.videolibrary.NoSuchVideoCategoryException} if it could not be found.
	 *
	 * @param ID the primary key of the video category
	 * @return the video category
	 * @throws com.revotech.portal.videolibrary.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory findByPrimaryKey(int ID)
		throws NoSuchVideoCategoryException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the video category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video category
	 * @return the video category, or <code>null</code> if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VideoCategory videoCategory = (VideoCategory)EntityCacheUtil.getResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VideoCategoryImpl.class, primaryKey);

		if (videoCategory == _nullVideoCategory) {
			return null;
		}

		if (videoCategory == null) {
			Session session = null;

			try {
				session = openSession();

				videoCategory = (VideoCategory)session.get(VideoCategoryImpl.class,
						primaryKey);

				if (videoCategory != null) {
					cacheResult(videoCategory);
				}
				else {
					EntityCacheUtil.putResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VideoCategoryImpl.class, primaryKey, _nullVideoCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
					VideoCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return videoCategory;
	}

	/**
	 * Returns the video category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the video category
	 * @return the video category, or <code>null</code> if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory fetchByPrimaryKey(int ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the video categories.
	 *
	 * @return the video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @return the range of video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoCategory> findAll(int start, int end,
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

		List<VideoCategory> list = (List<VideoCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOCATEGORY;

				if (pagination) {
					sql = sql.concat(VideoCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VideoCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VideoCategory>(list);
				}
				else {
					list = (List<VideoCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the video categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VideoCategory videoCategory : findAll()) {
			remove(videoCategory);
		}
	}

	/**
	 * Returns the number of video categories.
	 *
	 * @return the number of video categories
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

				Query q = session.createQuery(_SQL_COUNT_VIDEOCATEGORY);

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
	 * Initializes the video category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.revotech.portal.videolibrary.model.VideoCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoCategory>> listenersList = new ArrayList<ModelListener<VideoCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEOCATEGORY = "SELECT videoCategory FROM VideoCategory videoCategory";
	private static final String _SQL_COUNT_VIDEOCATEGORY = "SELECT COUNT(videoCategory) FROM VideoCategory videoCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoCategory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoCategoryPersistenceImpl.class);
	private static VideoCategory _nullVideoCategory = new VideoCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoCategory> toCacheModel() {
				return _nullVideoCategoryCacheModel;
			}
		};

	private static CacheModel<VideoCategory> _nullVideoCategoryCacheModel = new CacheModel<VideoCategory>() {
			@Override
			public VideoCategory toEntityModel() {
				return _nullVideoCategory;
			}
		};
}