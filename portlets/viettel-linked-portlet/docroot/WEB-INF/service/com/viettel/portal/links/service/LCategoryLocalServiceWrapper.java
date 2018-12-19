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

package com.viettel.portal.links.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LCategoryLocalService}.
 *
 * @author ChucHV
 * @see LCategoryLocalService
 * @generated
 */
public class LCategoryLocalServiceWrapper implements LCategoryLocalService,
	ServiceWrapper<LCategoryLocalService> {
	public LCategoryLocalServiceWrapper(
		LCategoryLocalService lCategoryLocalService) {
		_lCategoryLocalService = lCategoryLocalService;
	}

	/**
	* Adds the l category to the database. Also notifies the appropriate model listeners.
	*
	* @param lCategory the l category
	* @return the l category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.LCategory addLCategory(
		com.viettel.portal.links.model.LCategory lCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.addLCategory(lCategory);
	}

	/**
	* Creates a new l category with the primary key. Does not add the l category to the database.
	*
	* @param categoryId the primary key for the new l category
	* @return the new l category
	*/
	@Override
	public com.viettel.portal.links.model.LCategory createLCategory(
		long categoryId) {
		return _lCategoryLocalService.createLCategory(categoryId);
	}

	/**
	* Deletes the l category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the l category
	* @return the l category that was removed
	* @throws PortalException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.LCategory deleteLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.deleteLCategory(categoryId);
	}

	/**
	* Deletes the l category from the database. Also notifies the appropriate model listeners.
	*
	* @param lCategory the l category
	* @return the l category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.LCategory deleteLCategory(
		com.viettel.portal.links.model.LCategory lCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.deleteLCategory(lCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lCategoryLocalService.dynamicQuery();
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
		return _lCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _lCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lCategoryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.viettel.portal.links.model.LCategory fetchLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.fetchLCategory(categoryId);
	}

	/**
	* Returns the l category with the primary key.
	*
	* @param categoryId the primary key of the l category
	* @return the l category
	* @throws PortalException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.LCategory getLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.getLCategory(categoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of l categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.links.model.LCategory> getLCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.getLCategories(start, end);
	}

	/**
	* Returns the number of l categories.
	*
	* @return the number of l categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.getLCategoriesCount();
	}

	/**
	* Updates the l category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lCategory the l category
	* @return the l category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.LCategory updateLCategory(
		com.viettel.portal.links.model.LCategory lCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.updateLCategory(lCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.countByGroup(groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.findByGroup(groupId);
	}

	@Override
	public int countByGroupAndState(long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.countByGroupAndState(groupId, isActive);
	}

	@Override
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroupAndState(
		long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.findByGroupAndState(groupId, isActive);
	}

	@Override
	public java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.findByGroup(groupId, start, end);
	}

	@Override
	public java.util.List<com.viettel.portal.links.model.LCategory> findByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.findByCategoryName(categoryName, groupId);
	}

	@Override
	public com.viettel.portal.links.model.LCategory addCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, boolean isActive, int corder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.addCategory(companyId, groupId, userId,
			userName, categoryName, isActive, corder, serviceContext);
	}

	@Override
	public com.viettel.portal.links.model.LCategory updateCategory(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String categoryName,
		boolean isActive, int corder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lCategoryLocalService.updateCategory(categoryId, companyId,
			groupId, userId, userName, categoryName, isActive, corder,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LCategoryLocalService getWrappedLCategoryLocalService() {
		return _lCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLCategoryLocalService(
		LCategoryLocalService lCategoryLocalService) {
		_lCategoryLocalService = lCategoryLocalService;
	}

	@Override
	public LCategoryLocalService getWrappedService() {
		return _lCategoryLocalService;
	}

	@Override
	public void setWrappedService(LCategoryLocalService lCategoryLocalService) {
		_lCategoryLocalService = lCategoryLocalService;
	}

	private LCategoryLocalService _lCategoryLocalService;
}