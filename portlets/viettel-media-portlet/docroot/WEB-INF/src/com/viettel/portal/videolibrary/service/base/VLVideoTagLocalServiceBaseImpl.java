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

package com.viettel.portal.videolibrary.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.viettel.portal.videolibrary.model.VLVideoTag;
import com.viettel.portal.videolibrary.service.VLVideoTagLocalService;
import com.viettel.portal.videolibrary.service.persistence.VLCategoryFinder;
import com.viettel.portal.videolibrary.service.persistence.VLCategoryPersistence;
import com.viettel.portal.videolibrary.service.persistence.VLRelateVideoPersistence;
import com.viettel.portal.videolibrary.service.persistence.VLVideoCategoryPersistence;
import com.viettel.portal.videolibrary.service.persistence.VLVideoFinder;
import com.viettel.portal.videolibrary.service.persistence.VLVideoPersistence;
import com.viettel.portal.videolibrary.service.persistence.VLVideoTagPersistence;
import com.viettel.portal.videolibrary.service.persistence.VideoCategoryPersistence;
import com.viettel.portal.videolibrary.service.persistence.VideoClipPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the v l video tag local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.viettel.portal.videolibrary.service.impl.VLVideoTagLocalServiceImpl}.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.impl.VLVideoTagLocalServiceImpl
 * @see com.viettel.portal.videolibrary.service.VLVideoTagLocalServiceUtil
 * @generated
 */
public abstract class VLVideoTagLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements VLVideoTagLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.viettel.portal.videolibrary.service.VLVideoTagLocalServiceUtil} to access the v l video tag local service.
	 */

	/**
	 * Adds the v l video tag to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vlVideoTag the v l video tag
	 * @return the v l video tag that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public VLVideoTag addVLVideoTag(VLVideoTag vlVideoTag)
		throws SystemException {
		vlVideoTag.setNew(true);

		return vlVideoTagPersistence.update(vlVideoTag);
	}

	/**
	 * Creates a new v l video tag with the primary key. Does not add the v l video tag to the database.
	 *
	 * @param id the primary key for the new v l video tag
	 * @return the new v l video tag
	 */
	@Override
	public VLVideoTag createVLVideoTag(long id) {
		return vlVideoTagPersistence.create(id);
	}

	/**
	 * Deletes the v l video tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the v l video tag
	 * @return the v l video tag that was removed
	 * @throws PortalException if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public VLVideoTag deleteVLVideoTag(long id)
		throws PortalException, SystemException {
		return vlVideoTagPersistence.remove(id);
	}

	/**
	 * Deletes the v l video tag from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vlVideoTag the v l video tag
	 * @return the v l video tag that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public VLVideoTag deleteVLVideoTag(VLVideoTag vlVideoTag)
		throws SystemException {
		return vlVideoTagPersistence.remove(vlVideoTag);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(VLVideoTag.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return vlVideoTagPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return vlVideoTagPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return vlVideoTagPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return vlVideoTagPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return vlVideoTagPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public VLVideoTag fetchVLVideoTag(long id) throws SystemException {
		return vlVideoTagPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the v l video tag with the primary key.
	 *
	 * @param id the primary key of the v l video tag
	 * @return the v l video tag
	 * @throws PortalException if a v l video tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VLVideoTag getVLVideoTag(long id)
		throws PortalException, SystemException {
		return vlVideoTagPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return vlVideoTagPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the v l video tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v l video tags
	 * @param end the upper bound of the range of v l video tags (not inclusive)
	 * @return the range of v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLVideoTag> getVLVideoTags(int start, int end)
		throws SystemException {
		return vlVideoTagPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of v l video tags.
	 *
	 * @return the number of v l video tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVLVideoTagsCount() throws SystemException {
		return vlVideoTagPersistence.countAll();
	}

	/**
	 * Updates the v l video tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vlVideoTag the v l video tag
	 * @return the v l video tag that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public VLVideoTag updateVLVideoTag(VLVideoTag vlVideoTag)
		throws SystemException {
		return vlVideoTagPersistence.update(vlVideoTag);
	}

	/**
	 * Returns the video category local service.
	 *
	 * @return the video category local service
	 */
	public com.viettel.portal.videolibrary.service.VideoCategoryLocalService getVideoCategoryLocalService() {
		return videoCategoryLocalService;
	}

	/**
	 * Sets the video category local service.
	 *
	 * @param videoCategoryLocalService the video category local service
	 */
	public void setVideoCategoryLocalService(
		com.viettel.portal.videolibrary.service.VideoCategoryLocalService videoCategoryLocalService) {
		this.videoCategoryLocalService = videoCategoryLocalService;
	}

	/**
	 * Returns the video category remote service.
	 *
	 * @return the video category remote service
	 */
	public com.viettel.portal.videolibrary.service.VideoCategoryService getVideoCategoryService() {
		return videoCategoryService;
	}

	/**
	 * Sets the video category remote service.
	 *
	 * @param videoCategoryService the video category remote service
	 */
	public void setVideoCategoryService(
		com.viettel.portal.videolibrary.service.VideoCategoryService videoCategoryService) {
		this.videoCategoryService = videoCategoryService;
	}

	/**
	 * Returns the video category persistence.
	 *
	 * @return the video category persistence
	 */
	public VideoCategoryPersistence getVideoCategoryPersistence() {
		return videoCategoryPersistence;
	}

	/**
	 * Sets the video category persistence.
	 *
	 * @param videoCategoryPersistence the video category persistence
	 */
	public void setVideoCategoryPersistence(
		VideoCategoryPersistence videoCategoryPersistence) {
		this.videoCategoryPersistence = videoCategoryPersistence;
	}

	/**
	 * Returns the video clip local service.
	 *
	 * @return the video clip local service
	 */
	public com.viettel.portal.videolibrary.service.VideoClipLocalService getVideoClipLocalService() {
		return videoClipLocalService;
	}

	/**
	 * Sets the video clip local service.
	 *
	 * @param videoClipLocalService the video clip local service
	 */
	public void setVideoClipLocalService(
		com.viettel.portal.videolibrary.service.VideoClipLocalService videoClipLocalService) {
		this.videoClipLocalService = videoClipLocalService;
	}

	/**
	 * Returns the video clip remote service.
	 *
	 * @return the video clip remote service
	 */
	public com.viettel.portal.videolibrary.service.VideoClipService getVideoClipService() {
		return videoClipService;
	}

	/**
	 * Sets the video clip remote service.
	 *
	 * @param videoClipService the video clip remote service
	 */
	public void setVideoClipService(
		com.viettel.portal.videolibrary.service.VideoClipService videoClipService) {
		this.videoClipService = videoClipService;
	}

	/**
	 * Returns the video clip persistence.
	 *
	 * @return the video clip persistence
	 */
	public VideoClipPersistence getVideoClipPersistence() {
		return videoClipPersistence;
	}

	/**
	 * Sets the video clip persistence.
	 *
	 * @param videoClipPersistence the video clip persistence
	 */
	public void setVideoClipPersistence(
		VideoClipPersistence videoClipPersistence) {
		this.videoClipPersistence = videoClipPersistence;
	}

	/**
	 * Returns the v l category local service.
	 *
	 * @return the v l category local service
	 */
	public com.viettel.portal.videolibrary.service.VLCategoryLocalService getVLCategoryLocalService() {
		return vlCategoryLocalService;
	}

	/**
	 * Sets the v l category local service.
	 *
	 * @param vlCategoryLocalService the v l category local service
	 */
	public void setVLCategoryLocalService(
		com.viettel.portal.videolibrary.service.VLCategoryLocalService vlCategoryLocalService) {
		this.vlCategoryLocalService = vlCategoryLocalService;
	}

	/**
	 * Returns the v l category remote service.
	 *
	 * @return the v l category remote service
	 */
	public com.viettel.portal.videolibrary.service.VLCategoryService getVLCategoryService() {
		return vlCategoryService;
	}

	/**
	 * Sets the v l category remote service.
	 *
	 * @param vlCategoryService the v l category remote service
	 */
	public void setVLCategoryService(
		com.viettel.portal.videolibrary.service.VLCategoryService vlCategoryService) {
		this.vlCategoryService = vlCategoryService;
	}

	/**
	 * Returns the v l category persistence.
	 *
	 * @return the v l category persistence
	 */
	public VLCategoryPersistence getVLCategoryPersistence() {
		return vlCategoryPersistence;
	}

	/**
	 * Sets the v l category persistence.
	 *
	 * @param vlCategoryPersistence the v l category persistence
	 */
	public void setVLCategoryPersistence(
		VLCategoryPersistence vlCategoryPersistence) {
		this.vlCategoryPersistence = vlCategoryPersistence;
	}

	/**
	 * Returns the v l category finder.
	 *
	 * @return the v l category finder
	 */
	public VLCategoryFinder getVLCategoryFinder() {
		return vlCategoryFinder;
	}

	/**
	 * Sets the v l category finder.
	 *
	 * @param vlCategoryFinder the v l category finder
	 */
	public void setVLCategoryFinder(VLCategoryFinder vlCategoryFinder) {
		this.vlCategoryFinder = vlCategoryFinder;
	}

	/**
	 * Returns the v l relate video local service.
	 *
	 * @return the v l relate video local service
	 */
	public com.viettel.portal.videolibrary.service.VLRelateVideoLocalService getVLRelateVideoLocalService() {
		return vlRelateVideoLocalService;
	}

	/**
	 * Sets the v l relate video local service.
	 *
	 * @param vlRelateVideoLocalService the v l relate video local service
	 */
	public void setVLRelateVideoLocalService(
		com.viettel.portal.videolibrary.service.VLRelateVideoLocalService vlRelateVideoLocalService) {
		this.vlRelateVideoLocalService = vlRelateVideoLocalService;
	}

	/**
	 * Returns the v l relate video remote service.
	 *
	 * @return the v l relate video remote service
	 */
	public com.viettel.portal.videolibrary.service.VLRelateVideoService getVLRelateVideoService() {
		return vlRelateVideoService;
	}

	/**
	 * Sets the v l relate video remote service.
	 *
	 * @param vlRelateVideoService the v l relate video remote service
	 */
	public void setVLRelateVideoService(
		com.viettel.portal.videolibrary.service.VLRelateVideoService vlRelateVideoService) {
		this.vlRelateVideoService = vlRelateVideoService;
	}

	/**
	 * Returns the v l relate video persistence.
	 *
	 * @return the v l relate video persistence
	 */
	public VLRelateVideoPersistence getVLRelateVideoPersistence() {
		return vlRelateVideoPersistence;
	}

	/**
	 * Sets the v l relate video persistence.
	 *
	 * @param vlRelateVideoPersistence the v l relate video persistence
	 */
	public void setVLRelateVideoPersistence(
		VLRelateVideoPersistence vlRelateVideoPersistence) {
		this.vlRelateVideoPersistence = vlRelateVideoPersistence;
	}

	/**
	 * Returns the v l video local service.
	 *
	 * @return the v l video local service
	 */
	public com.viettel.portal.videolibrary.service.VLVideoLocalService getVLVideoLocalService() {
		return vlVideoLocalService;
	}

	/**
	 * Sets the v l video local service.
	 *
	 * @param vlVideoLocalService the v l video local service
	 */
	public void setVLVideoLocalService(
		com.viettel.portal.videolibrary.service.VLVideoLocalService vlVideoLocalService) {
		this.vlVideoLocalService = vlVideoLocalService;
	}

	/**
	 * Returns the v l video remote service.
	 *
	 * @return the v l video remote service
	 */
	public com.viettel.portal.videolibrary.service.VLVideoService getVLVideoService() {
		return vlVideoService;
	}

	/**
	 * Sets the v l video remote service.
	 *
	 * @param vlVideoService the v l video remote service
	 */
	public void setVLVideoService(
		com.viettel.portal.videolibrary.service.VLVideoService vlVideoService) {
		this.vlVideoService = vlVideoService;
	}

	/**
	 * Returns the v l video persistence.
	 *
	 * @return the v l video persistence
	 */
	public VLVideoPersistence getVLVideoPersistence() {
		return vlVideoPersistence;
	}

	/**
	 * Sets the v l video persistence.
	 *
	 * @param vlVideoPersistence the v l video persistence
	 */
	public void setVLVideoPersistence(VLVideoPersistence vlVideoPersistence) {
		this.vlVideoPersistence = vlVideoPersistence;
	}

	/**
	 * Returns the v l video finder.
	 *
	 * @return the v l video finder
	 */
	public VLVideoFinder getVLVideoFinder() {
		return vlVideoFinder;
	}

	/**
	 * Sets the v l video finder.
	 *
	 * @param vlVideoFinder the v l video finder
	 */
	public void setVLVideoFinder(VLVideoFinder vlVideoFinder) {
		this.vlVideoFinder = vlVideoFinder;
	}

	/**
	 * Returns the v l video category local service.
	 *
	 * @return the v l video category local service
	 */
	public com.viettel.portal.videolibrary.service.VLVideoCategoryLocalService getVLVideoCategoryLocalService() {
		return vlVideoCategoryLocalService;
	}

	/**
	 * Sets the v l video category local service.
	 *
	 * @param vlVideoCategoryLocalService the v l video category local service
	 */
	public void setVLVideoCategoryLocalService(
		com.viettel.portal.videolibrary.service.VLVideoCategoryLocalService vlVideoCategoryLocalService) {
		this.vlVideoCategoryLocalService = vlVideoCategoryLocalService;
	}

	/**
	 * Returns the v l video category remote service.
	 *
	 * @return the v l video category remote service
	 */
	public com.viettel.portal.videolibrary.service.VLVideoCategoryService getVLVideoCategoryService() {
		return vlVideoCategoryService;
	}

	/**
	 * Sets the v l video category remote service.
	 *
	 * @param vlVideoCategoryService the v l video category remote service
	 */
	public void setVLVideoCategoryService(
		com.viettel.portal.videolibrary.service.VLVideoCategoryService vlVideoCategoryService) {
		this.vlVideoCategoryService = vlVideoCategoryService;
	}

	/**
	 * Returns the v l video category persistence.
	 *
	 * @return the v l video category persistence
	 */
	public VLVideoCategoryPersistence getVLVideoCategoryPersistence() {
		return vlVideoCategoryPersistence;
	}

	/**
	 * Sets the v l video category persistence.
	 *
	 * @param vlVideoCategoryPersistence the v l video category persistence
	 */
	public void setVLVideoCategoryPersistence(
		VLVideoCategoryPersistence vlVideoCategoryPersistence) {
		this.vlVideoCategoryPersistence = vlVideoCategoryPersistence;
	}

	/**
	 * Returns the v l video tag local service.
	 *
	 * @return the v l video tag local service
	 */
	public com.viettel.portal.videolibrary.service.VLVideoTagLocalService getVLVideoTagLocalService() {
		return vlVideoTagLocalService;
	}

	/**
	 * Sets the v l video tag local service.
	 *
	 * @param vlVideoTagLocalService the v l video tag local service
	 */
	public void setVLVideoTagLocalService(
		com.viettel.portal.videolibrary.service.VLVideoTagLocalService vlVideoTagLocalService) {
		this.vlVideoTagLocalService = vlVideoTagLocalService;
	}

	/**
	 * Returns the v l video tag remote service.
	 *
	 * @return the v l video tag remote service
	 */
	public com.viettel.portal.videolibrary.service.VLVideoTagService getVLVideoTagService() {
		return vlVideoTagService;
	}

	/**
	 * Sets the v l video tag remote service.
	 *
	 * @param vlVideoTagService the v l video tag remote service
	 */
	public void setVLVideoTagService(
		com.viettel.portal.videolibrary.service.VLVideoTagService vlVideoTagService) {
		this.vlVideoTagService = vlVideoTagService;
	}

	/**
	 * Returns the v l video tag persistence.
	 *
	 * @return the v l video tag persistence
	 */
	public VLVideoTagPersistence getVLVideoTagPersistence() {
		return vlVideoTagPersistence;
	}

	/**
	 * Sets the v l video tag persistence.
	 *
	 * @param vlVideoTagPersistence the v l video tag persistence
	 */
	public void setVLVideoTagPersistence(
		VLVideoTagPersistence vlVideoTagPersistence) {
		this.vlVideoTagPersistence = vlVideoTagPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.viettel.portal.videolibrary.model.VLVideoTag",
			vlVideoTagLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.viettel.portal.videolibrary.model.VLVideoTag");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return VLVideoTag.class;
	}

	protected String getModelClassName() {
		return VLVideoTag.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = vlVideoTagPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.viettel.portal.videolibrary.service.VideoCategoryLocalService.class)
	protected com.viettel.portal.videolibrary.service.VideoCategoryLocalService videoCategoryLocalService;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VideoCategoryService.class)
	protected com.viettel.portal.videolibrary.service.VideoCategoryService videoCategoryService;
	@BeanReference(type = VideoCategoryPersistence.class)
	protected VideoCategoryPersistence videoCategoryPersistence;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VideoClipLocalService.class)
	protected com.viettel.portal.videolibrary.service.VideoClipLocalService videoClipLocalService;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VideoClipService.class)
	protected com.viettel.portal.videolibrary.service.VideoClipService videoClipService;
	@BeanReference(type = VideoClipPersistence.class)
	protected VideoClipPersistence videoClipPersistence;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLCategoryLocalService.class)
	protected com.viettel.portal.videolibrary.service.VLCategoryLocalService vlCategoryLocalService;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLCategoryService.class)
	protected com.viettel.portal.videolibrary.service.VLCategoryService vlCategoryService;
	@BeanReference(type = VLCategoryPersistence.class)
	protected VLCategoryPersistence vlCategoryPersistence;
	@BeanReference(type = VLCategoryFinder.class)
	protected VLCategoryFinder vlCategoryFinder;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLRelateVideoLocalService.class)
	protected com.viettel.portal.videolibrary.service.VLRelateVideoLocalService vlRelateVideoLocalService;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLRelateVideoService.class)
	protected com.viettel.portal.videolibrary.service.VLRelateVideoService vlRelateVideoService;
	@BeanReference(type = VLRelateVideoPersistence.class)
	protected VLRelateVideoPersistence vlRelateVideoPersistence;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLVideoLocalService.class)
	protected com.viettel.portal.videolibrary.service.VLVideoLocalService vlVideoLocalService;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLVideoService.class)
	protected com.viettel.portal.videolibrary.service.VLVideoService vlVideoService;
	@BeanReference(type = VLVideoPersistence.class)
	protected VLVideoPersistence vlVideoPersistence;
	@BeanReference(type = VLVideoFinder.class)
	protected VLVideoFinder vlVideoFinder;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLVideoCategoryLocalService.class)
	protected com.viettel.portal.videolibrary.service.VLVideoCategoryLocalService vlVideoCategoryLocalService;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLVideoCategoryService.class)
	protected com.viettel.portal.videolibrary.service.VLVideoCategoryService vlVideoCategoryService;
	@BeanReference(type = VLVideoCategoryPersistence.class)
	protected VLVideoCategoryPersistence vlVideoCategoryPersistence;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLVideoTagLocalService.class)
	protected com.viettel.portal.videolibrary.service.VLVideoTagLocalService vlVideoTagLocalService;
	@BeanReference(type = com.viettel.portal.videolibrary.service.VLVideoTagService.class)
	protected com.viettel.portal.videolibrary.service.VLVideoTagService vlVideoTagService;
	@BeanReference(type = VLVideoTagPersistence.class)
	protected VLVideoTagPersistence vlVideoTagPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private VLVideoTagLocalServiceClpInvoker _clpInvoker = new VLVideoTagLocalServiceClpInvoker();
}