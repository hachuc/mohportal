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

package com.viettel.portal.videolibrary.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VLCategoryLocalService}.
 *
 * @author ChucHV
 * @see VLCategoryLocalService
 * @generated
 */
public class VLCategoryLocalServiceWrapper implements VLCategoryLocalService,
	ServiceWrapper<VLCategoryLocalService> {
	public VLCategoryLocalServiceWrapper(
		VLCategoryLocalService vlCategoryLocalService) {
		_vlCategoryLocalService = vlCategoryLocalService;
	}

	/**
	* Adds the v l category to the database. Also notifies the appropriate model listeners.
	*
	* @param vlCategory the v l category
	* @return the v l category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLCategory addVLCategory(
		com.viettel.portal.videolibrary.model.VLCategory vlCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.addVLCategory(vlCategory);
	}

	/**
	* Creates a new v l category with the primary key. Does not add the v l category to the database.
	*
	* @param categoryId the primary key for the new v l category
	* @return the new v l category
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLCategory createVLCategory(
		long categoryId) {
		return _vlCategoryLocalService.createVLCategory(categoryId);
	}

	/**
	* Deletes the v l category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the v l category
	* @return the v l category that was removed
	* @throws PortalException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLCategory deleteVLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.deleteVLCategory(categoryId);
	}

	/**
	* Deletes the v l category from the database. Also notifies the appropriate model listeners.
	*
	* @param vlCategory the v l category
	* @return the v l category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLCategory deleteVLCategory(
		com.viettel.portal.videolibrary.model.VLCategory vlCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.deleteVLCategory(vlCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vlCategoryLocalService.dynamicQuery();
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
		return _vlCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vlCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vlCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vlCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vlCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLCategory fetchVLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.fetchVLCategory(categoryId);
	}

	/**
	* Returns the v l category with the primary key.
	*
	* @param categoryId the primary key of the v l category
	* @return the v l category
	* @throws PortalException if a v l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLCategory getVLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.getVLCategory(categoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v l categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l categories
	* @param end the upper bound of the range of v l categories (not inclusive)
	* @return the range of v l categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> getVLCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.getVLCategories(start, end);
	}

	/**
	* Returns the number of v l categories.
	*
	* @return the number of v l categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVLCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.getVLCategoriesCount();
	}

	/**
	* Updates the v l category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vlCategory the v l category
	* @return the v l category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.videolibrary.model.VLCategory updateVLCategory(
		com.viettel.portal.videolibrary.model.VLCategory vlCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.updateVLCategory(vlCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vlCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vlCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vlCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryId(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.findByCategoryId(groupId, categoryId);
	}

	@Override
	public void removeAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vlCategoryLocalService.removeAll(groupId);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLCategory addLegalCategory(
		long groupId, long companyId, long userId, java.lang.String userName,
		long categoryId, java.lang.String categoryName, boolean isVisible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.addLegalCategory(groupId, companyId,
			userId, userName, categoryId, categoryName, isVisible,
			serviceContext);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLCategory addVLCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, boolean invisible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.addVLCategory(companyId, groupId,
			userId, userName, categoryName, invisible, serviceContext);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.countAll();
	}

	@Override
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.countByGroup(groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.findByCategoryName(categoryName, groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.findByGroup(groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.findByGroup(groupId, start, end);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findByGroupAndState(
		long groupId, boolean invisible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.findByGroupAndState(groupId, invisible);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.findAll();
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<com.viettel.portal.videolibrary.model.VLCategory> getByGroupUserSite(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.getByGroupUserSite(groupId);
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLCategory updateVLCategory(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String categoryName,
		boolean invisible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlCategoryLocalService.updateVLCategory(categoryId, companyId,
			groupId, userId, userName, categoryName, invisible, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VLCategoryLocalService getWrappedVLCategoryLocalService() {
		return _vlCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVLCategoryLocalService(
		VLCategoryLocalService vlCategoryLocalService) {
		_vlCategoryLocalService = vlCategoryLocalService;
	}

	@Override
	public VLCategoryLocalService getWrappedService() {
		return _vlCategoryLocalService;
	}

	@Override
	public void setWrappedService(VLCategoryLocalService vlCategoryLocalService) {
		_vlCategoryLocalService = vlCategoryLocalService;
	}

	private VLCategoryLocalService _vlCategoryLocalService;
}