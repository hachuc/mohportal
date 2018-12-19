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

package com.viettel.portal.links.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.viettel.portal.links.model.LCategory;
import com.viettel.portal.links.service.LCategoryService;
import com.viettel.portal.links.service.persistence.LCategoryFinder;
import com.viettel.portal.links.service.persistence.LCategoryPersistence;
import com.viettel.portal.links.service.persistence.VLinkFinder;
import com.viettel.portal.links.service.persistence.VLinkPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the l category remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.viettel.portal.links.service.impl.LCategoryServiceImpl}.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.links.service.impl.LCategoryServiceImpl
 * @see com.viettel.portal.links.service.LCategoryServiceUtil
 * @generated
 */
public abstract class LCategoryServiceBaseImpl extends BaseServiceImpl
	implements LCategoryService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.viettel.portal.links.service.LCategoryServiceUtil} to access the l category remote service.
	 */

	/**
	 * Returns the l category local service.
	 *
	 * @return the l category local service
	 */
	public com.viettel.portal.links.service.LCategoryLocalService getLCategoryLocalService() {
		return lCategoryLocalService;
	}

	/**
	 * Sets the l category local service.
	 *
	 * @param lCategoryLocalService the l category local service
	 */
	public void setLCategoryLocalService(
		com.viettel.portal.links.service.LCategoryLocalService lCategoryLocalService) {
		this.lCategoryLocalService = lCategoryLocalService;
	}

	/**
	 * Returns the l category remote service.
	 *
	 * @return the l category remote service
	 */
	public com.viettel.portal.links.service.LCategoryService getLCategoryService() {
		return lCategoryService;
	}

	/**
	 * Sets the l category remote service.
	 *
	 * @param lCategoryService the l category remote service
	 */
	public void setLCategoryService(
		com.viettel.portal.links.service.LCategoryService lCategoryService) {
		this.lCategoryService = lCategoryService;
	}

	/**
	 * Returns the l category persistence.
	 *
	 * @return the l category persistence
	 */
	public LCategoryPersistence getLCategoryPersistence() {
		return lCategoryPersistence;
	}

	/**
	 * Sets the l category persistence.
	 *
	 * @param lCategoryPersistence the l category persistence
	 */
	public void setLCategoryPersistence(
		LCategoryPersistence lCategoryPersistence) {
		this.lCategoryPersistence = lCategoryPersistence;
	}

	/**
	 * Returns the l category finder.
	 *
	 * @return the l category finder
	 */
	public LCategoryFinder getLCategoryFinder() {
		return lCategoryFinder;
	}

	/**
	 * Sets the l category finder.
	 *
	 * @param lCategoryFinder the l category finder
	 */
	public void setLCategoryFinder(LCategoryFinder lCategoryFinder) {
		this.lCategoryFinder = lCategoryFinder;
	}

	/**
	 * Returns the v link local service.
	 *
	 * @return the v link local service
	 */
	public com.viettel.portal.links.service.VLinkLocalService getVLinkLocalService() {
		return vLinkLocalService;
	}

	/**
	 * Sets the v link local service.
	 *
	 * @param vLinkLocalService the v link local service
	 */
	public void setVLinkLocalService(
		com.viettel.portal.links.service.VLinkLocalService vLinkLocalService) {
		this.vLinkLocalService = vLinkLocalService;
	}

	/**
	 * Returns the v link remote service.
	 *
	 * @return the v link remote service
	 */
	public com.viettel.portal.links.service.VLinkService getVLinkService() {
		return vLinkService;
	}

	/**
	 * Sets the v link remote service.
	 *
	 * @param vLinkService the v link remote service
	 */
	public void setVLinkService(
		com.viettel.portal.links.service.VLinkService vLinkService) {
		this.vLinkService = vLinkService;
	}

	/**
	 * Returns the v link persistence.
	 *
	 * @return the v link persistence
	 */
	public VLinkPersistence getVLinkPersistence() {
		return vLinkPersistence;
	}

	/**
	 * Sets the v link persistence.
	 *
	 * @param vLinkPersistence the v link persistence
	 */
	public void setVLinkPersistence(VLinkPersistence vLinkPersistence) {
		this.vLinkPersistence = vLinkPersistence;
	}

	/**
	 * Returns the v link finder.
	 *
	 * @return the v link finder
	 */
	public VLinkFinder getVLinkFinder() {
		return vLinkFinder;
	}

	/**
	 * Sets the v link finder.
	 *
	 * @param vLinkFinder the v link finder
	 */
	public void setVLinkFinder(VLinkFinder vLinkFinder) {
		this.vLinkFinder = vLinkFinder;
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
		return LCategory.class;
	}

	protected String getModelClassName() {
		return LCategory.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = lCategoryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.viettel.portal.links.service.LCategoryLocalService.class)
	protected com.viettel.portal.links.service.LCategoryLocalService lCategoryLocalService;
	@BeanReference(type = com.viettel.portal.links.service.LCategoryService.class)
	protected com.viettel.portal.links.service.LCategoryService lCategoryService;
	@BeanReference(type = LCategoryPersistence.class)
	protected LCategoryPersistence lCategoryPersistence;
	@BeanReference(type = LCategoryFinder.class)
	protected LCategoryFinder lCategoryFinder;
	@BeanReference(type = com.viettel.portal.links.service.VLinkLocalService.class)
	protected com.viettel.portal.links.service.VLinkLocalService vLinkLocalService;
	@BeanReference(type = com.viettel.portal.links.service.VLinkService.class)
	protected com.viettel.portal.links.service.VLinkService vLinkService;
	@BeanReference(type = VLinkPersistence.class)
	protected VLinkPersistence vLinkPersistence;
	@BeanReference(type = VLinkFinder.class)
	protected VLinkFinder vLinkFinder;
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
	private LCategoryServiceClpInvoker _clpInvoker = new LCategoryServiceClpInvoker();
}