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
 * Provides a wrapper for {@link VLinkLocalService}.
 *
 * @author ChucHV
 * @see VLinkLocalService
 * @generated
 */
public class VLinkLocalServiceWrapper implements VLinkLocalService,
	ServiceWrapper<VLinkLocalService> {
	public VLinkLocalServiceWrapper(VLinkLocalService vLinkLocalService) {
		_vLinkLocalService = vLinkLocalService;
	}

	/**
	* Adds the v link to the database. Also notifies the appropriate model listeners.
	*
	* @param vLink the v link
	* @return the v link that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.VLink addVLink(
		com.viettel.portal.links.model.VLink vLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.addVLink(vLink);
	}

	/**
	* Creates a new v link with the primary key. Does not add the v link to the database.
	*
	* @param linkId the primary key for the new v link
	* @return the new v link
	*/
	@Override
	public com.viettel.portal.links.model.VLink createVLink(long linkId) {
		return _vLinkLocalService.createVLink(linkId);
	}

	/**
	* Deletes the v link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the v link
	* @return the v link that was removed
	* @throws PortalException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.VLink deleteVLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.deleteVLink(linkId);
	}

	/**
	* Deletes the v link from the database. Also notifies the appropriate model listeners.
	*
	* @param vLink the v link
	* @return the v link that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.VLink deleteVLink(
		com.viettel.portal.links.model.VLink vLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.deleteVLink(vLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vLinkLocalService.dynamicQuery();
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
		return _vLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vLinkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vLinkLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vLinkLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.viettel.portal.links.model.VLink fetchVLink(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.fetchVLink(linkId);
	}

	/**
	* Returns the v link with the primary key.
	*
	* @param linkId the primary key of the v link
	* @return the v link
	* @throws PortalException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.VLink getVLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.getVLink(linkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @return the range of v links
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.links.model.VLink> getVLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.getVLinks(start, end);
	}

	/**
	* Returns the number of v links.
	*
	* @return the number of v links
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.getVLinksCount();
	}

	/**
	* Updates the v link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vLink the v link
	* @return the v link that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.links.model.VLink updateVLink(
		com.viettel.portal.links.model.VLink vLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.updateVLink(vLink);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vLinkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vLinkLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vLinkLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.links.model.VLink> findByGroupAndCateActive(
		long groupId, long categoryId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.findByGroupAndCateActive(groupId, categoryId,
			isActive);
	}

	@Override
	public com.viettel.portal.links.VLinkGrid findByKeyword(long groupId,
		long categoryId, java.lang.String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _vLinkLocalService.findByKeyword(groupId, categoryId, keyword,
			start, end, obc);
	}

	@Override
	public com.viettel.portal.links.model.VLink updateLink(long id,
		long companyId, long groupId, long userId, java.lang.String userName,
		long categoryId, java.lang.String linkName, java.lang.String url,
		int corder, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.updateLink(id, companyId, groupId, userId,
			userName, categoryId, linkName, url, corder, serviceContext);
	}

	@Override
	public com.viettel.portal.links.model.VLink addLink(long companyId,
		long groupId, long userId, java.lang.String userName, long categoryId,
		java.lang.String linkName, java.lang.String url, int corder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vLinkLocalService.addLink(companyId, groupId, userId, userName,
			categoryId, linkName, url, corder, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VLinkLocalService getWrappedVLinkLocalService() {
		return _vLinkLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVLinkLocalService(VLinkLocalService vLinkLocalService) {
		_vLinkLocalService = vLinkLocalService;
	}

	@Override
	public VLinkLocalService getWrappedService() {
		return _vLinkLocalService;
	}

	@Override
	public void setWrappedService(VLinkLocalService vLinkLocalService) {
		_vLinkLocalService = vLinkLocalService;
	}

	private VLinkLocalService _vLinkLocalService;
}