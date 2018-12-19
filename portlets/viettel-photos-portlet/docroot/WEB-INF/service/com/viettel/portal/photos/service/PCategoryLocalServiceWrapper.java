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

package com.viettel.portal.photos.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PCategoryLocalService}.
 *
 * @author ChucHV
 * @see PCategoryLocalService
 * @generated
 */
public class PCategoryLocalServiceWrapper implements PCategoryLocalService,
	ServiceWrapper<PCategoryLocalService> {
	public PCategoryLocalServiceWrapper(
		PCategoryLocalService pCategoryLocalService) {
		_pCategoryLocalService = pCategoryLocalService;
	}

	/**
	* Adds the p category to the database. Also notifies the appropriate model listeners.
	*
	* @param pCategory the p category
	* @return the p category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.photos.model.PCategory addPCategory(
		com.viettel.portal.photos.model.PCategory pCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.addPCategory(pCategory);
	}

	/**
	* Creates a new p category with the primary key. Does not add the p category to the database.
	*
	* @param id the primary key for the new p category
	* @return the new p category
	*/
	@Override
	public com.viettel.portal.photos.model.PCategory createPCategory(long id) {
		return _pCategoryLocalService.createPCategory(id);
	}

	/**
	* Deletes the p category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the p category
	* @return the p category that was removed
	* @throws PortalException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.photos.model.PCategory deletePCategory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.deletePCategory(id);
	}

	/**
	* Deletes the p category from the database. Also notifies the appropriate model listeners.
	*
	* @param pCategory the p category
	* @return the p category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.photos.model.PCategory deletePCategory(
		com.viettel.portal.photos.model.PCategory pCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.deletePCategory(pCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pCategoryLocalService.dynamicQuery();
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
		return _pCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _pCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _pCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _pCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _pCategoryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.viettel.portal.photos.model.PCategory fetchPCategory(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.fetchPCategory(id);
	}

	/**
	* Returns the p category with the primary key.
	*
	* @param id the primary key of the p category
	* @return the p category
	* @throws PortalException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.photos.model.PCategory getPCategory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.getPCategory(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the p categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of p categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.photos.model.PCategory> getPCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.getPCategories(start, end);
	}

	/**
	* Returns the number of p categories.
	*
	* @return the number of p categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.getPCategoriesCount();
	}

	/**
	* Updates the p category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pCategory the p category
	* @return the p category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.photos.model.PCategory updatePCategory(
		com.viettel.portal.photos.model.PCategory pCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.updatePCategory(pCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _pCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_pCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _pCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.findByGroup(groupId);
	}

	@Override
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.countByGroup(groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.findByGroup(groupId, start, end);
	}

	@Override
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndName(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.findByGroupAndName(groupId, name);
	}

	@Override
	public com.viettel.portal.photos.model.PCategory addCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, boolean status, int corder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.addCategory(companyId, groupId, userId,
			userName, categoryName, status, corder, serviceContext);
	}

	@Override
	public com.viettel.portal.photos.model.PCategory updateCategory(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String categoryName,
		boolean status, int corder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pCategoryLocalService.updateCategory(categoryId, companyId,
			groupId, userId, userName, categoryName, status, corder,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PCategoryLocalService getWrappedPCategoryLocalService() {
		return _pCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPCategoryLocalService(
		PCategoryLocalService pCategoryLocalService) {
		_pCategoryLocalService = pCategoryLocalService;
	}

	@Override
	public PCategoryLocalService getWrappedService() {
		return _pCategoryLocalService;
	}

	@Override
	public void setWrappedService(PCategoryLocalService pCategoryLocalService) {
		_pCategoryLocalService = pCategoryLocalService;
	}

	private PCategoryLocalService _pCategoryLocalService;
}