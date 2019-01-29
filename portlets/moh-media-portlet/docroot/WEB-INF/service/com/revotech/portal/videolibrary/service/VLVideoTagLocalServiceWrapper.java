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

package com.revotech.portal.videolibrary.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VLVideoTagLocalService}.
 *
 * @author ChucHV
 * @see VLVideoTagLocalService
 * @generated
 */
public class VLVideoTagLocalServiceWrapper implements VLVideoTagLocalService,
	ServiceWrapper<VLVideoTagLocalService> {
	public VLVideoTagLocalServiceWrapper(
		VLVideoTagLocalService vlVideoTagLocalService) {
		_vlVideoTagLocalService = vlVideoTagLocalService;
	}

	/**
	* Adds the v l video tag to the database. Also notifies the appropriate model listeners.
	*
	* @param vlVideoTag the v l video tag
	* @return the v l video tag that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLVideoTag addVLVideoTag(
		com.revotech.portal.videolibrary.model.VLVideoTag vlVideoTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.addVLVideoTag(vlVideoTag);
	}

	/**
	* Creates a new v l video tag with the primary key. Does not add the v l video tag to the database.
	*
	* @param id the primary key for the new v l video tag
	* @return the new v l video tag
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLVideoTag createVLVideoTag(
		long id) {
		return _vlVideoTagLocalService.createVLVideoTag(id);
	}

	/**
	* Deletes the v l video tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the v l video tag
	* @return the v l video tag that was removed
	* @throws PortalException if a v l video tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLVideoTag deleteVLVideoTag(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.deleteVLVideoTag(id);
	}

	/**
	* Deletes the v l video tag from the database. Also notifies the appropriate model listeners.
	*
	* @param vlVideoTag the v l video tag
	* @return the v l video tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLVideoTag deleteVLVideoTag(
		com.revotech.portal.videolibrary.model.VLVideoTag vlVideoTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.deleteVLVideoTag(vlVideoTag);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vlVideoTagLocalService.dynamicQuery();
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
		return _vlVideoTagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vlVideoTagLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vlVideoTagLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vlVideoTagLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vlVideoTagLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.revotech.portal.videolibrary.model.VLVideoTag fetchVLVideoTag(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.fetchVLVideoTag(id);
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
	public com.revotech.portal.videolibrary.model.VLVideoTag getVLVideoTag(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.getVLVideoTag(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v l video tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l video tags
	* @param end the upper bound of the range of v l video tags (not inclusive)
	* @return the range of v l video tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.revotech.portal.videolibrary.model.VLVideoTag> getVLVideoTags(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.getVLVideoTags(start, end);
	}

	/**
	* Returns the number of v l video tags.
	*
	* @return the number of v l video tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVLVideoTagsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.getVLVideoTagsCount();
	}

	/**
	* Updates the v l video tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vlVideoTag the v l video tag
	* @return the v l video tag that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.videolibrary.model.VLVideoTag updateVLVideoTag(
		com.revotech.portal.videolibrary.model.VLVideoTag vlVideoTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideoTagLocalService.updateVLVideoTag(vlVideoTag);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vlVideoTagLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vlVideoTagLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vlVideoTagLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VLVideoTagLocalService getWrappedVLVideoTagLocalService() {
		return _vlVideoTagLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVLVideoTagLocalService(
		VLVideoTagLocalService vlVideoTagLocalService) {
		_vlVideoTagLocalService = vlVideoTagLocalService;
	}

	@Override
	public VLVideoTagLocalService getWrappedService() {
		return _vlVideoTagLocalService;
	}

	@Override
	public void setWrappedService(VLVideoTagLocalService vlVideoTagLocalService) {
		_vlVideoTagLocalService = vlVideoTagLocalService;
	}

	private VLVideoTagLocalService _vlVideoTagLocalService;
}