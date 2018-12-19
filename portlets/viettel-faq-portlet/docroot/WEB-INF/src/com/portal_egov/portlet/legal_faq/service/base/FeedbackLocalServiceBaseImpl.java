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

package com.portal_egov.portlet.legal_faq.service.base;

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

import com.portal_egov.portlet.legal_faq.model.Feedback;
import com.portal_egov.portlet.legal_faq.service.FeedbackLocalService;
import com.portal_egov.portlet.legal_faq.service.persistence.FeedbackFinder;
import com.portal_egov.portlet.legal_faq.service.persistence.FeedbackPersistence;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQCategoryFinder;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQCategoryPersistence;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQEntryFinder;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the feedback local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.legal_faq.service.impl.FeedbackLocalServiceImpl}.
 * </p>
 *
 * @author chuchv
 * @see com.portal_egov.portlet.legal_faq.service.impl.FeedbackLocalServiceImpl
 * @see com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil
 * @generated
 */
public abstract class FeedbackLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements FeedbackLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil} to access the feedback local service.
	 */

	/**
	 * Adds the feedback to the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedback the feedback
	 * @return the feedback that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Feedback addFeedback(Feedback feedback) throws SystemException {
		feedback.setNew(true);

		return feedbackPersistence.update(feedback);
	}

	/**
	 * Creates a new feedback with the primary key. Does not add the feedback to the database.
	 *
	 * @param feedbackId the primary key for the new feedback
	 * @return the new feedback
	 */
	@Override
	public Feedback createFeedback(long feedbackId) {
		return feedbackPersistence.create(feedbackId);
	}

	/**
	 * Deletes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws PortalException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Feedback deleteFeedback(long feedbackId)
		throws PortalException, SystemException {
		return feedbackPersistence.remove(feedbackId);
	}

	/**
	 * Deletes the feedback from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedback the feedback
	 * @return the feedback that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Feedback deleteFeedback(Feedback feedback) throws SystemException {
		return feedbackPersistence.remove(feedback);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Feedback.class,
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
		return feedbackPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return feedbackPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return feedbackPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return feedbackPersistence.countWithDynamicQuery(dynamicQuery);
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
		return feedbackPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Feedback fetchFeedback(long feedbackId) throws SystemException {
		return feedbackPersistence.fetchByPrimaryKey(feedbackId);
	}

	/**
	 * Returns the feedback with the primary key.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback
	 * @throws PortalException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback getFeedback(long feedbackId)
		throws PortalException, SystemException {
		return feedbackPersistence.findByPrimaryKey(feedbackId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return feedbackPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> getFeedbacks(int start, int end)
		throws SystemException {
		return feedbackPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of feedbacks.
	 *
	 * @return the number of feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getFeedbacksCount() throws SystemException {
		return feedbackPersistence.countAll();
	}

	/**
	 * Updates the feedback in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param feedback the feedback
	 * @return the feedback that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Feedback updateFeedback(Feedback feedback) throws SystemException {
		return feedbackPersistence.update(feedback);
	}

	/**
	 * Returns the feedback local service.
	 *
	 * @return the feedback local service
	 */
	public com.portal_egov.portlet.legal_faq.service.FeedbackLocalService getFeedbackLocalService() {
		return feedbackLocalService;
	}

	/**
	 * Sets the feedback local service.
	 *
	 * @param feedbackLocalService the feedback local service
	 */
	public void setFeedbackLocalService(
		com.portal_egov.portlet.legal_faq.service.FeedbackLocalService feedbackLocalService) {
		this.feedbackLocalService = feedbackLocalService;
	}

	/**
	 * Returns the feedback remote service.
	 *
	 * @return the feedback remote service
	 */
	public com.portal_egov.portlet.legal_faq.service.FeedbackService getFeedbackService() {
		return feedbackService;
	}

	/**
	 * Sets the feedback remote service.
	 *
	 * @param feedbackService the feedback remote service
	 */
	public void setFeedbackService(
		com.portal_egov.portlet.legal_faq.service.FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	/**
	 * Returns the feedback persistence.
	 *
	 * @return the feedback persistence
	 */
	public FeedbackPersistence getFeedbackPersistence() {
		return feedbackPersistence;
	}

	/**
	 * Sets the feedback persistence.
	 *
	 * @param feedbackPersistence the feedback persistence
	 */
	public void setFeedbackPersistence(FeedbackPersistence feedbackPersistence) {
		this.feedbackPersistence = feedbackPersistence;
	}

	/**
	 * Returns the feedback finder.
	 *
	 * @return the feedback finder
	 */
	public FeedbackFinder getFeedbackFinder() {
		return feedbackFinder;
	}

	/**
	 * Sets the feedback finder.
	 *
	 * @param feedbackFinder the feedback finder
	 */
	public void setFeedbackFinder(FeedbackFinder feedbackFinder) {
		this.feedbackFinder = feedbackFinder;
	}

	/**
	 * Returns the legal f a q category local service.
	 *
	 * @return the legal f a q category local service
	 */
	public com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalService getLegalFAQCategoryLocalService() {
		return legalFAQCategoryLocalService;
	}

	/**
	 * Sets the legal f a q category local service.
	 *
	 * @param legalFAQCategoryLocalService the legal f a q category local service
	 */
	public void setLegalFAQCategoryLocalService(
		com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalService legalFAQCategoryLocalService) {
		this.legalFAQCategoryLocalService = legalFAQCategoryLocalService;
	}

	/**
	 * Returns the legal f a q category remote service.
	 *
	 * @return the legal f a q category remote service
	 */
	public com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryService getLegalFAQCategoryService() {
		return legalFAQCategoryService;
	}

	/**
	 * Sets the legal f a q category remote service.
	 *
	 * @param legalFAQCategoryService the legal f a q category remote service
	 */
	public void setLegalFAQCategoryService(
		com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryService legalFAQCategoryService) {
		this.legalFAQCategoryService = legalFAQCategoryService;
	}

	/**
	 * Returns the legal f a q category persistence.
	 *
	 * @return the legal f a q category persistence
	 */
	public LegalFAQCategoryPersistence getLegalFAQCategoryPersistence() {
		return legalFAQCategoryPersistence;
	}

	/**
	 * Sets the legal f a q category persistence.
	 *
	 * @param legalFAQCategoryPersistence the legal f a q category persistence
	 */
	public void setLegalFAQCategoryPersistence(
		LegalFAQCategoryPersistence legalFAQCategoryPersistence) {
		this.legalFAQCategoryPersistence = legalFAQCategoryPersistence;
	}

	/**
	 * Returns the legal f a q category finder.
	 *
	 * @return the legal f a q category finder
	 */
	public LegalFAQCategoryFinder getLegalFAQCategoryFinder() {
		return legalFAQCategoryFinder;
	}

	/**
	 * Sets the legal f a q category finder.
	 *
	 * @param legalFAQCategoryFinder the legal f a q category finder
	 */
	public void setLegalFAQCategoryFinder(
		LegalFAQCategoryFinder legalFAQCategoryFinder) {
		this.legalFAQCategoryFinder = legalFAQCategoryFinder;
	}

	/**
	 * Returns the legal f a q entry local service.
	 *
	 * @return the legal f a q entry local service
	 */
	public com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalService getLegalFAQEntryLocalService() {
		return legalFAQEntryLocalService;
	}

	/**
	 * Sets the legal f a q entry local service.
	 *
	 * @param legalFAQEntryLocalService the legal f a q entry local service
	 */
	public void setLegalFAQEntryLocalService(
		com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalService legalFAQEntryLocalService) {
		this.legalFAQEntryLocalService = legalFAQEntryLocalService;
	}

	/**
	 * Returns the legal f a q entry remote service.
	 *
	 * @return the legal f a q entry remote service
	 */
	public com.portal_egov.portlet.legal_faq.service.LegalFAQEntryService getLegalFAQEntryService() {
		return legalFAQEntryService;
	}

	/**
	 * Sets the legal f a q entry remote service.
	 *
	 * @param legalFAQEntryService the legal f a q entry remote service
	 */
	public void setLegalFAQEntryService(
		com.portal_egov.portlet.legal_faq.service.LegalFAQEntryService legalFAQEntryService) {
		this.legalFAQEntryService = legalFAQEntryService;
	}

	/**
	 * Returns the legal f a q entry persistence.
	 *
	 * @return the legal f a q entry persistence
	 */
	public LegalFAQEntryPersistence getLegalFAQEntryPersistence() {
		return legalFAQEntryPersistence;
	}

	/**
	 * Sets the legal f a q entry persistence.
	 *
	 * @param legalFAQEntryPersistence the legal f a q entry persistence
	 */
	public void setLegalFAQEntryPersistence(
		LegalFAQEntryPersistence legalFAQEntryPersistence) {
		this.legalFAQEntryPersistence = legalFAQEntryPersistence;
	}

	/**
	 * Returns the legal f a q entry finder.
	 *
	 * @return the legal f a q entry finder
	 */
	public LegalFAQEntryFinder getLegalFAQEntryFinder() {
		return legalFAQEntryFinder;
	}

	/**
	 * Sets the legal f a q entry finder.
	 *
	 * @param legalFAQEntryFinder the legal f a q entry finder
	 */
	public void setLegalFAQEntryFinder(LegalFAQEntryFinder legalFAQEntryFinder) {
		this.legalFAQEntryFinder = legalFAQEntryFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.legal_faq.model.Feedback",
			feedbackLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.legal_faq.model.Feedback");
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
		return Feedback.class;
	}

	protected String getModelClassName() {
		return Feedback.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = feedbackPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.portal_egov.portlet.legal_faq.service.FeedbackLocalService.class)
	protected com.portal_egov.portlet.legal_faq.service.FeedbackLocalService feedbackLocalService;
	@BeanReference(type = com.portal_egov.portlet.legal_faq.service.FeedbackService.class)
	protected com.portal_egov.portlet.legal_faq.service.FeedbackService feedbackService;
	@BeanReference(type = FeedbackPersistence.class)
	protected FeedbackPersistence feedbackPersistence;
	@BeanReference(type = FeedbackFinder.class)
	protected FeedbackFinder feedbackFinder;
	@BeanReference(type = com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalService.class)
	protected com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalService legalFAQCategoryLocalService;
	@BeanReference(type = com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryService.class)
	protected com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryService legalFAQCategoryService;
	@BeanReference(type = LegalFAQCategoryPersistence.class)
	protected LegalFAQCategoryPersistence legalFAQCategoryPersistence;
	@BeanReference(type = LegalFAQCategoryFinder.class)
	protected LegalFAQCategoryFinder legalFAQCategoryFinder;
	@BeanReference(type = com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalService.class)
	protected com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalService legalFAQEntryLocalService;
	@BeanReference(type = com.portal_egov.portlet.legal_faq.service.LegalFAQEntryService.class)
	protected com.portal_egov.portlet.legal_faq.service.LegalFAQEntryService legalFAQEntryService;
	@BeanReference(type = LegalFAQEntryPersistence.class)
	protected LegalFAQEntryPersistence legalFAQEntryPersistence;
	@BeanReference(type = LegalFAQEntryFinder.class)
	protected LegalFAQEntryFinder legalFAQEntryFinder;
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
	private FeedbackLocalServiceClpInvoker _clpInvoker = new FeedbackLocalServiceClpInvoker();
}