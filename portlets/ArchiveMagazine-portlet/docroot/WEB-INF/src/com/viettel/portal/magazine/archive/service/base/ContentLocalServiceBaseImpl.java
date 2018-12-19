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

package com.viettel.portal.magazine.archive.service.base;

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

import com.viettel.portal.magazine.archive.model.Content;
import com.viettel.portal.magazine.archive.service.ContentLocalService;
import com.viettel.portal.magazine.archive.service.persistence.ContentPersistence;
import com.viettel.portal.magazine.archive.service.persistence.MagazinePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the content local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.viettel.portal.magazine.archive.service.impl.ContentLocalServiceImpl}.
 * </p>
 *
 * @author namtv
 * @see com.viettel.portal.magazine.archive.service.impl.ContentLocalServiceImpl
 * @see com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil
 * @generated
 */
public abstract class ContentLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ContentLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil} to access the content local service.
	 */

	/**
	 * Adds the content to the database. Also notifies the appropriate model listeners.
	 *
	 * @param content the content
	 * @return the content that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Content addContent(Content content) throws SystemException {
		content.setNew(true);

		return contentPersistence.update(content);
	}

	/**
	 * Creates a new content with the primary key. Does not add the content to the database.
	 *
	 * @param ID the primary key for the new content
	 * @return the new content
	 */
	@Override
	public Content createContent(int ID) {
		return contentPersistence.create(ID);
	}

	/**
	 * Deletes the content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the content
	 * @return the content that was removed
	 * @throws PortalException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Content deleteContent(int ID)
		throws PortalException, SystemException {
		return contentPersistence.remove(ID);
	}

	/**
	 * Deletes the content from the database. Also notifies the appropriate model listeners.
	 *
	 * @param content the content
	 * @return the content that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Content deleteContent(Content content) throws SystemException {
		return contentPersistence.remove(content);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Content.class,
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
		return contentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return contentPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return contentPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return contentPersistence.countWithDynamicQuery(dynamicQuery);
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
		return contentPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Content fetchContent(int ID) throws SystemException {
		return contentPersistence.fetchByPrimaryKey(ID);
	}

	/**
	 * Returns the content with the primary key.
	 *
	 * @param ID the primary key of the content
	 * @return the content
	 * @throws PortalException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content getContent(int ID) throws PortalException, SystemException {
		return contentPersistence.findByPrimaryKey(ID);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return contentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> getContents(int start, int end)
		throws SystemException {
		return contentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of contents.
	 *
	 * @return the number of contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getContentsCount() throws SystemException {
		return contentPersistence.countAll();
	}

	/**
	 * Updates the content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param content the content
	 * @return the content that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Content updateContent(Content content) throws SystemException {
		return contentPersistence.update(content);
	}

	/**
	 * Returns the content local service.
	 *
	 * @return the content local service
	 */
	public com.viettel.portal.magazine.archive.service.ContentLocalService getContentLocalService() {
		return contentLocalService;
	}

	/**
	 * Sets the content local service.
	 *
	 * @param contentLocalService the content local service
	 */
	public void setContentLocalService(
		com.viettel.portal.magazine.archive.service.ContentLocalService contentLocalService) {
		this.contentLocalService = contentLocalService;
	}

	/**
	 * Returns the content remote service.
	 *
	 * @return the content remote service
	 */
	public com.viettel.portal.magazine.archive.service.ContentService getContentService() {
		return contentService;
	}

	/**
	 * Sets the content remote service.
	 *
	 * @param contentService the content remote service
	 */
	public void setContentService(
		com.viettel.portal.magazine.archive.service.ContentService contentService) {
		this.contentService = contentService;
	}

	/**
	 * Returns the content persistence.
	 *
	 * @return the content persistence
	 */
	public ContentPersistence getContentPersistence() {
		return contentPersistence;
	}

	/**
	 * Sets the content persistence.
	 *
	 * @param contentPersistence the content persistence
	 */
	public void setContentPersistence(ContentPersistence contentPersistence) {
		this.contentPersistence = contentPersistence;
	}

	/**
	 * Returns the magazine local service.
	 *
	 * @return the magazine local service
	 */
	public com.viettel.portal.magazine.archive.service.MagazineLocalService getMagazineLocalService() {
		return magazineLocalService;
	}

	/**
	 * Sets the magazine local service.
	 *
	 * @param magazineLocalService the magazine local service
	 */
	public void setMagazineLocalService(
		com.viettel.portal.magazine.archive.service.MagazineLocalService magazineLocalService) {
		this.magazineLocalService = magazineLocalService;
	}

	/**
	 * Returns the magazine remote service.
	 *
	 * @return the magazine remote service
	 */
	public com.viettel.portal.magazine.archive.service.MagazineService getMagazineService() {
		return magazineService;
	}

	/**
	 * Sets the magazine remote service.
	 *
	 * @param magazineService the magazine remote service
	 */
	public void setMagazineService(
		com.viettel.portal.magazine.archive.service.MagazineService magazineService) {
		this.magazineService = magazineService;
	}

	/**
	 * Returns the magazine persistence.
	 *
	 * @return the magazine persistence
	 */
	public MagazinePersistence getMagazinePersistence() {
		return magazinePersistence;
	}

	/**
	 * Sets the magazine persistence.
	 *
	 * @param magazinePersistence the magazine persistence
	 */
	public void setMagazinePersistence(MagazinePersistence magazinePersistence) {
		this.magazinePersistence = magazinePersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.viettel.portal.magazine.archive.model.Content",
			contentLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.viettel.portal.magazine.archive.model.Content");
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
		return Content.class;
	}

	protected String getModelClassName() {
		return Content.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = contentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.viettel.portal.magazine.archive.service.ContentLocalService.class)
	protected com.viettel.portal.magazine.archive.service.ContentLocalService contentLocalService;
	@BeanReference(type = com.viettel.portal.magazine.archive.service.ContentService.class)
	protected com.viettel.portal.magazine.archive.service.ContentService contentService;
	@BeanReference(type = ContentPersistence.class)
	protected ContentPersistence contentPersistence;
	@BeanReference(type = com.viettel.portal.magazine.archive.service.MagazineLocalService.class)
	protected com.viettel.portal.magazine.archive.service.MagazineLocalService magazineLocalService;
	@BeanReference(type = com.viettel.portal.magazine.archive.service.MagazineService.class)
	protected com.viettel.portal.magazine.archive.service.MagazineService magazineService;
	@BeanReference(type = MagazinePersistence.class)
	protected MagazinePersistence magazinePersistence;
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
	private ContentLocalServiceClpInvoker _clpInvoker = new ContentLocalServiceClpInvoker();
}