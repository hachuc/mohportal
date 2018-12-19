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

package com.portal_egov.portlet.legal_faq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegalFAQCategoryLocalService}.
 *
 * @author chuchv
 * @see LegalFAQCategoryLocalService
 * @generated
 */
public class LegalFAQCategoryLocalServiceWrapper
	implements LegalFAQCategoryLocalService,
		ServiceWrapper<LegalFAQCategoryLocalService> {
	public LegalFAQCategoryLocalServiceWrapper(
		LegalFAQCategoryLocalService legalFAQCategoryLocalService) {
		_legalFAQCategoryLocalService = legalFAQCategoryLocalService;
	}

	/**
	* Adds the legal f a q category to the database. Also notifies the appropriate model listeners.
	*
	* @param legalFAQCategory the legal f a q category
	* @return the legal f a q category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory addLegalFAQCategory(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.addLegalFAQCategory(legalFAQCategory);
	}

	/**
	* Creates a new legal f a q category with the primary key. Does not add the legal f a q category to the database.
	*
	* @param categoryId the primary key for the new legal f a q category
	* @return the new legal f a q category
	*/
	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory createLegalFAQCategory(
		long categoryId) {
		return _legalFAQCategoryLocalService.createLegalFAQCategory(categoryId);
	}

	/**
	* Deletes the legal f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the legal f a q category
	* @return the legal f a q category that was removed
	* @throws PortalException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory deleteLegalFAQCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.deleteLegalFAQCategory(categoryId);
	}

	/**
	* Deletes the legal f a q category from the database. Also notifies the appropriate model listeners.
	*
	* @param legalFAQCategory the legal f a q category
	* @return the legal f a q category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory deleteLegalFAQCategory(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.deleteLegalFAQCategory(legalFAQCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalFAQCategoryLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.dynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchLegalFAQCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.fetchLegalFAQCategory(categoryId);
	}

	/**
	* Returns the legal f a q category with the primary key.
	*
	* @param categoryId the primary key of the legal f a q category
	* @return the legal f a q category
	* @throws PortalException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory getLegalFAQCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.getLegalFAQCategory(categoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legal f a q categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @return the range of legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> getLegalFAQCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.getLegalFAQCategories(start, end);
	}

	/**
	* Returns the number of legal f a q categories.
	*
	* @return the number of legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegalFAQCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.getLegalFAQCategoriesCount();
	}

	/**
	* Updates the legal f a q category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legalFAQCategory the legal f a q category
	* @return the legal f a q category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory updateLegalFAQCategory(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.updateLegalFAQCategory(legalFAQCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legalFAQCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legalFAQCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legalFAQCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.countAll();
	}

	@Override
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.countByCompany(companyId);
	}

	@Override
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.countByGroup(groupId);
	}

	@Override
	public int countByParent(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.countByParent(companyId, parentId);
	}

	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.findByCompany(companyId);
	}

	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.findByCompany(companyId, start, end);
	}

	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.findByGroup(groupId);
	}

	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.findByGroup(groupId, start, end);
	}

	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByParent(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.findByParent(companyId, parentId);
	}

	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByParent(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.findByParent(companyId, parentId,
			start, end);
	}

	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByKeyword(
		long groupId, int type, java.lang.String keyword, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.findByKeyword(groupId, type,
			keyword, start, end);
	}

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.getCategory(categoryId);
	}

	@Override
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> getCategoryByType(
		int type, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.getCategoryByType(type, groupId);
	}

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory addCategory(
		long companyId, long groupId, int type, long userId, long parentId,
		java.lang.String categoryName, java.lang.String categoryDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.addCategory(companyId, groupId,
			type, userId, parentId, categoryName, categoryDesc, serviceContext);
	}

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory updateCategory(
		long categoryId, long companyId, long groupId, int type, long userId,
		long parentId, java.lang.String categoryName,
		java.lang.String categoryDesc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategoryLocalService.updateCategory(categoryId,
			companyId, groupId, type, userId, parentId, categoryName,
			categoryDesc);
	}

	@Override
	public void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_legalFAQCategoryLocalService.deleteCategory(categoryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegalFAQCategoryLocalService getWrappedLegalFAQCategoryLocalService() {
		return _legalFAQCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegalFAQCategoryLocalService(
		LegalFAQCategoryLocalService legalFAQCategoryLocalService) {
		_legalFAQCategoryLocalService = legalFAQCategoryLocalService;
	}

	@Override
	public LegalFAQCategoryLocalService getWrappedService() {
		return _legalFAQCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		LegalFAQCategoryLocalService legalFAQCategoryLocalService) {
		_legalFAQCategoryLocalService = legalFAQCategoryLocalService;
	}

	private LegalFAQCategoryLocalService _legalFAQCategoryLocalService;
}