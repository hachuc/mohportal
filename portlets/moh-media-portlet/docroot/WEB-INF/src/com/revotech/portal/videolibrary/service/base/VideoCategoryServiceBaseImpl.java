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

package com.revotech.portal.videolibrary.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.revotech.portal.videolibrary.model.VideoCategory;
import com.revotech.portal.videolibrary.service.VideoCategoryService;
import com.revotech.portal.videolibrary.service.persistence.VLCategoryFinder;
import com.revotech.portal.videolibrary.service.persistence.VLCategoryPersistence;
import com.revotech.portal.videolibrary.service.persistence.VLRelateVideoPersistence;
import com.revotech.portal.videolibrary.service.persistence.VLVideoCategoryPersistence;
import com.revotech.portal.videolibrary.service.persistence.VLVideoFinder;
import com.revotech.portal.videolibrary.service.persistence.VLVideoPersistence;
import com.revotech.portal.videolibrary.service.persistence.VLVideoTagPersistence;
import com.revotech.portal.videolibrary.service.persistence.VideoCategoryPersistence;
import com.revotech.portal.videolibrary.service.persistence.VideoClipPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the video category remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.revotech.portal.videolibrary.service.impl.VideoCategoryServiceImpl}.
 * </p>
 *
 * @author ChucHV
 * @see com.revotech.portal.videolibrary.service.impl.VideoCategoryServiceImpl
 * @see com.revotech.portal.videolibrary.service.VideoCategoryServiceUtil
 * @generated
 */
public abstract class VideoCategoryServiceBaseImpl extends BaseServiceImpl
	implements VideoCategoryService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.revotech.portal.videolibrary.service.VideoCategoryServiceUtil} to access the video category remote service.
	 */

	/**
	 * Returns the video category local service.
	 *
	 * @return the video category local service
	 */
	public com.revotech.portal.videolibrary.service.VideoCategoryLocalService getVideoCategoryLocalService() {
		return videoCategoryLocalService;
	}

	/**
	 * Sets the video category local service.
	 *
	 * @param videoCategoryLocalService the video category local service
	 */
	public void setVideoCategoryLocalService(
		com.revotech.portal.videolibrary.service.VideoCategoryLocalService videoCategoryLocalService) {
		this.videoCategoryLocalService = videoCategoryLocalService;
	}

	/**
	 * Returns the video category remote service.
	 *
	 * @return the video category remote service
	 */
	public com.revotech.portal.videolibrary.service.VideoCategoryService getVideoCategoryService() {
		return videoCategoryService;
	}

	/**
	 * Sets the video category remote service.
	 *
	 * @param videoCategoryService the video category remote service
	 */
	public void setVideoCategoryService(
		com.revotech.portal.videolibrary.service.VideoCategoryService videoCategoryService) {
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
	public com.revotech.portal.videolibrary.service.VideoClipLocalService getVideoClipLocalService() {
		return videoClipLocalService;
	}

	/**
	 * Sets the video clip local service.
	 *
	 * @param videoClipLocalService the video clip local service
	 */
	public void setVideoClipLocalService(
		com.revotech.portal.videolibrary.service.VideoClipLocalService videoClipLocalService) {
		this.videoClipLocalService = videoClipLocalService;
	}

	/**
	 * Returns the video clip remote service.
	 *
	 * @return the video clip remote service
	 */
	public com.revotech.portal.videolibrary.service.VideoClipService getVideoClipService() {
		return videoClipService;
	}

	/**
	 * Sets the video clip remote service.
	 *
	 * @param videoClipService the video clip remote service
	 */
	public void setVideoClipService(
		com.revotech.portal.videolibrary.service.VideoClipService videoClipService) {
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
	public com.revotech.portal.videolibrary.service.VLCategoryLocalService getVLCategoryLocalService() {
		return vlCategoryLocalService;
	}

	/**
	 * Sets the v l category local service.
	 *
	 * @param vlCategoryLocalService the v l category local service
	 */
	public void setVLCategoryLocalService(
		com.revotech.portal.videolibrary.service.VLCategoryLocalService vlCategoryLocalService) {
		this.vlCategoryLocalService = vlCategoryLocalService;
	}

	/**
	 * Returns the v l category remote service.
	 *
	 * @return the v l category remote service
	 */
	public com.revotech.portal.videolibrary.service.VLCategoryService getVLCategoryService() {
		return vlCategoryService;
	}

	/**
	 * Sets the v l category remote service.
	 *
	 * @param vlCategoryService the v l category remote service
	 */
	public void setVLCategoryService(
		com.revotech.portal.videolibrary.service.VLCategoryService vlCategoryService) {
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
	public com.revotech.portal.videolibrary.service.VLRelateVideoLocalService getVLRelateVideoLocalService() {
		return vlRelateVideoLocalService;
	}

	/**
	 * Sets the v l relate video local service.
	 *
	 * @param vlRelateVideoLocalService the v l relate video local service
	 */
	public void setVLRelateVideoLocalService(
		com.revotech.portal.videolibrary.service.VLRelateVideoLocalService vlRelateVideoLocalService) {
		this.vlRelateVideoLocalService = vlRelateVideoLocalService;
	}

	/**
	 * Returns the v l relate video remote service.
	 *
	 * @return the v l relate video remote service
	 */
	public com.revotech.portal.videolibrary.service.VLRelateVideoService getVLRelateVideoService() {
		return vlRelateVideoService;
	}

	/**
	 * Sets the v l relate video remote service.
	 *
	 * @param vlRelateVideoService the v l relate video remote service
	 */
	public void setVLRelateVideoService(
		com.revotech.portal.videolibrary.service.VLRelateVideoService vlRelateVideoService) {
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
	public com.revotech.portal.videolibrary.service.VLVideoLocalService getVLVideoLocalService() {
		return vlVideoLocalService;
	}

	/**
	 * Sets the v l video local service.
	 *
	 * @param vlVideoLocalService the v l video local service
	 */
	public void setVLVideoLocalService(
		com.revotech.portal.videolibrary.service.VLVideoLocalService vlVideoLocalService) {
		this.vlVideoLocalService = vlVideoLocalService;
	}

	/**
	 * Returns the v l video remote service.
	 *
	 * @return the v l video remote service
	 */
	public com.revotech.portal.videolibrary.service.VLVideoService getVLVideoService() {
		return vlVideoService;
	}

	/**
	 * Sets the v l video remote service.
	 *
	 * @param vlVideoService the v l video remote service
	 */
	public void setVLVideoService(
		com.revotech.portal.videolibrary.service.VLVideoService vlVideoService) {
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
	public com.revotech.portal.videolibrary.service.VLVideoCategoryLocalService getVLVideoCategoryLocalService() {
		return vlVideoCategoryLocalService;
	}

	/**
	 * Sets the v l video category local service.
	 *
	 * @param vlVideoCategoryLocalService the v l video category local service
	 */
	public void setVLVideoCategoryLocalService(
		com.revotech.portal.videolibrary.service.VLVideoCategoryLocalService vlVideoCategoryLocalService) {
		this.vlVideoCategoryLocalService = vlVideoCategoryLocalService;
	}

	/**
	 * Returns the v l video category remote service.
	 *
	 * @return the v l video category remote service
	 */
	public com.revotech.portal.videolibrary.service.VLVideoCategoryService getVLVideoCategoryService() {
		return vlVideoCategoryService;
	}

	/**
	 * Sets the v l video category remote service.
	 *
	 * @param vlVideoCategoryService the v l video category remote service
	 */
	public void setVLVideoCategoryService(
		com.revotech.portal.videolibrary.service.VLVideoCategoryService vlVideoCategoryService) {
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
	public com.revotech.portal.videolibrary.service.VLVideoTagLocalService getVLVideoTagLocalService() {
		return vlVideoTagLocalService;
	}

	/**
	 * Sets the v l video tag local service.
	 *
	 * @param vlVideoTagLocalService the v l video tag local service
	 */
	public void setVLVideoTagLocalService(
		com.revotech.portal.videolibrary.service.VLVideoTagLocalService vlVideoTagLocalService) {
		this.vlVideoTagLocalService = vlVideoTagLocalService;
	}

	/**
	 * Returns the v l video tag remote service.
	 *
	 * @return the v l video tag remote service
	 */
	public com.revotech.portal.videolibrary.service.VLVideoTagService getVLVideoTagService() {
		return vlVideoTagService;
	}

	/**
	 * Sets the v l video tag remote service.
	 *
	 * @param vlVideoTagService the v l video tag remote service
	 */
	public void setVLVideoTagService(
		com.revotech.portal.videolibrary.service.VLVideoTagService vlVideoTagService) {
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
	}

	public void destroy() {
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
		return VideoCategory.class;
	}

	protected String getModelClassName() {
		return VideoCategory.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = videoCategoryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.revotech.portal.videolibrary.service.VideoCategoryLocalService.class)
	protected com.revotech.portal.videolibrary.service.VideoCategoryLocalService videoCategoryLocalService;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VideoCategoryService.class)
	protected com.revotech.portal.videolibrary.service.VideoCategoryService videoCategoryService;
	@BeanReference(type = VideoCategoryPersistence.class)
	protected VideoCategoryPersistence videoCategoryPersistence;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VideoClipLocalService.class)
	protected com.revotech.portal.videolibrary.service.VideoClipLocalService videoClipLocalService;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VideoClipService.class)
	protected com.revotech.portal.videolibrary.service.VideoClipService videoClipService;
	@BeanReference(type = VideoClipPersistence.class)
	protected VideoClipPersistence videoClipPersistence;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLCategoryLocalService.class)
	protected com.revotech.portal.videolibrary.service.VLCategoryLocalService vlCategoryLocalService;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLCategoryService.class)
	protected com.revotech.portal.videolibrary.service.VLCategoryService vlCategoryService;
	@BeanReference(type = VLCategoryPersistence.class)
	protected VLCategoryPersistence vlCategoryPersistence;
	@BeanReference(type = VLCategoryFinder.class)
	protected VLCategoryFinder vlCategoryFinder;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLRelateVideoLocalService.class)
	protected com.revotech.portal.videolibrary.service.VLRelateVideoLocalService vlRelateVideoLocalService;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLRelateVideoService.class)
	protected com.revotech.portal.videolibrary.service.VLRelateVideoService vlRelateVideoService;
	@BeanReference(type = VLRelateVideoPersistence.class)
	protected VLRelateVideoPersistence vlRelateVideoPersistence;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLVideoLocalService.class)
	protected com.revotech.portal.videolibrary.service.VLVideoLocalService vlVideoLocalService;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLVideoService.class)
	protected com.revotech.portal.videolibrary.service.VLVideoService vlVideoService;
	@BeanReference(type = VLVideoPersistence.class)
	protected VLVideoPersistence vlVideoPersistence;
	@BeanReference(type = VLVideoFinder.class)
	protected VLVideoFinder vlVideoFinder;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLVideoCategoryLocalService.class)
	protected com.revotech.portal.videolibrary.service.VLVideoCategoryLocalService vlVideoCategoryLocalService;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLVideoCategoryService.class)
	protected com.revotech.portal.videolibrary.service.VLVideoCategoryService vlVideoCategoryService;
	@BeanReference(type = VLVideoCategoryPersistence.class)
	protected VLVideoCategoryPersistence vlVideoCategoryPersistence;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLVideoTagLocalService.class)
	protected com.revotech.portal.videolibrary.service.VLVideoTagLocalService vlVideoTagLocalService;
	@BeanReference(type = com.revotech.portal.videolibrary.service.VLVideoTagService.class)
	protected com.revotech.portal.videolibrary.service.VLVideoTagService vlVideoTagService;
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
	private VideoCategoryServiceClpInvoker _clpInvoker = new VideoCategoryServiceClpInvoker();
}