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

package com.liferay.viettel.portal.counter.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.viettel.portal.counter.model.CounterReport;
import com.liferay.viettel.portal.counter.service.CounterReportService;
import com.liferay.viettel.portal.counter.service.persistence.CategoryPersistence;
import com.liferay.viettel.portal.counter.service.persistence.CounterReportFinder;
import com.liferay.viettel.portal.counter.service.persistence.CounterReportPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the counter report remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.viettel.portal.counter.service.impl.CounterReportServiceImpl}.
 * </p>
 *
 * @author chuchv
 * @see com.liferay.viettel.portal.counter.service.impl.CounterReportServiceImpl
 * @see com.liferay.viettel.portal.counter.service.CounterReportServiceUtil
 * @generated
 */
public abstract class CounterReportServiceBaseImpl extends BaseServiceImpl
	implements CounterReportService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.viettel.portal.counter.service.CounterReportServiceUtil} to access the counter report remote service.
	 */

	/**
	 * Returns the category local service.
	 *
	 * @return the category local service
	 */
	public com.liferay.viettel.portal.counter.service.CategoryLocalService getCategoryLocalService() {
		return categoryLocalService;
	}

	/**
	 * Sets the category local service.
	 *
	 * @param categoryLocalService the category local service
	 */
	public void setCategoryLocalService(
		com.liferay.viettel.portal.counter.service.CategoryLocalService categoryLocalService) {
		this.categoryLocalService = categoryLocalService;
	}

	/**
	 * Returns the category remote service.
	 *
	 * @return the category remote service
	 */
	public com.liferay.viettel.portal.counter.service.CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * Sets the category remote service.
	 *
	 * @param categoryService the category remote service
	 */
	public void setCategoryService(
		com.liferay.viettel.portal.counter.service.CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Returns the category persistence.
	 *
	 * @return the category persistence
	 */
	public CategoryPersistence getCategoryPersistence() {
		return categoryPersistence;
	}

	/**
	 * Sets the category persistence.
	 *
	 * @param categoryPersistence the category persistence
	 */
	public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
		this.categoryPersistence = categoryPersistence;
	}

	/**
	 * Returns the counter report local service.
	 *
	 * @return the counter report local service
	 */
	public com.liferay.viettel.portal.counter.service.CounterReportLocalService getCounterReportLocalService() {
		return counterReportLocalService;
	}

	/**
	 * Sets the counter report local service.
	 *
	 * @param counterReportLocalService the counter report local service
	 */
	public void setCounterReportLocalService(
		com.liferay.viettel.portal.counter.service.CounterReportLocalService counterReportLocalService) {
		this.counterReportLocalService = counterReportLocalService;
	}

	/**
	 * Returns the counter report remote service.
	 *
	 * @return the counter report remote service
	 */
	public com.liferay.viettel.portal.counter.service.CounterReportService getCounterReportService() {
		return counterReportService;
	}

	/**
	 * Sets the counter report remote service.
	 *
	 * @param counterReportService the counter report remote service
	 */
	public void setCounterReportService(
		com.liferay.viettel.portal.counter.service.CounterReportService counterReportService) {
		this.counterReportService = counterReportService;
	}

	/**
	 * Returns the counter report persistence.
	 *
	 * @return the counter report persistence
	 */
	public CounterReportPersistence getCounterReportPersistence() {
		return counterReportPersistence;
	}

	/**
	 * Sets the counter report persistence.
	 *
	 * @param counterReportPersistence the counter report persistence
	 */
	public void setCounterReportPersistence(
		CounterReportPersistence counterReportPersistence) {
		this.counterReportPersistence = counterReportPersistence;
	}

	/**
	 * Returns the counter report finder.
	 *
	 * @return the counter report finder
	 */
	public CounterReportFinder getCounterReportFinder() {
		return counterReportFinder;
	}

	/**
	 * Sets the counter report finder.
	 *
	 * @param counterReportFinder the counter report finder
	 */
	public void setCounterReportFinder(CounterReportFinder counterReportFinder) {
		this.counterReportFinder = counterReportFinder;
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
		return CounterReport.class;
	}

	protected String getModelClassName() {
		return CounterReport.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = counterReportPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.viettel.portal.counter.service.CategoryLocalService.class)
	protected com.liferay.viettel.portal.counter.service.CategoryLocalService categoryLocalService;
	@BeanReference(type = com.liferay.viettel.portal.counter.service.CategoryService.class)
	protected com.liferay.viettel.portal.counter.service.CategoryService categoryService;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = com.liferay.viettel.portal.counter.service.CounterReportLocalService.class)
	protected com.liferay.viettel.portal.counter.service.CounterReportLocalService counterReportLocalService;
	@BeanReference(type = com.liferay.viettel.portal.counter.service.CounterReportService.class)
	protected com.liferay.viettel.portal.counter.service.CounterReportService counterReportService;
	@BeanReference(type = CounterReportPersistence.class)
	protected CounterReportPersistence counterReportPersistence;
	@BeanReference(type = CounterReportFinder.class)
	protected CounterReportFinder counterReportFinder;
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
	private CounterReportServiceClpInvoker _clpInvoker = new CounterReportServiceClpInvoker();
}