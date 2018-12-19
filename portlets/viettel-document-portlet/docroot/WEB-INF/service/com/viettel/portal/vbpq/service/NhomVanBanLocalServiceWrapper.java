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

package com.viettel.portal.vbpq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NhomVanBanLocalService}.
 *
 * @author ChucHV
 * @see NhomVanBanLocalService
 * @generated
 */
public class NhomVanBanLocalServiceWrapper implements NhomVanBanLocalService,
	ServiceWrapper<NhomVanBanLocalService> {
	public NhomVanBanLocalServiceWrapper(
		NhomVanBanLocalService nhomVanBanLocalService) {
		_nhomVanBanLocalService = nhomVanBanLocalService;
	}

	/**
	* Adds the nhom van ban to the database. Also notifies the appropriate model listeners.
	*
	* @param nhomVanBan the nhom van ban
	* @return the nhom van ban that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.NhomVanBan addNhomVanBan(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.addNhomVanBan(nhomVanBan);
	}

	/**
	* Creates a new nhom van ban with the primary key. Does not add the nhom van ban to the database.
	*
	* @param id the primary key for the new nhom van ban
	* @return the new nhom van ban
	*/
	@Override
	public com.viettel.portal.vbpq.model.NhomVanBan createNhomVanBan(long id) {
		return _nhomVanBanLocalService.createNhomVanBan(id);
	}

	/**
	* Deletes the nhom van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban that was removed
	* @throws PortalException if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.NhomVanBan deleteNhomVanBan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.deleteNhomVanBan(id);
	}

	/**
	* Deletes the nhom van ban from the database. Also notifies the appropriate model listeners.
	*
	* @param nhomVanBan the nhom van ban
	* @return the nhom van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.NhomVanBan deleteNhomVanBan(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.deleteNhomVanBan(nhomVanBan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _nhomVanBanLocalService.dynamicQuery();
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
		return _nhomVanBanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _nhomVanBanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _nhomVanBanLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _nhomVanBanLocalService.dynamicQueryCount(dynamicQuery);
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
		return _nhomVanBanLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vbpq.model.NhomVanBan fetchNhomVanBan(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.fetchNhomVanBan(id);
	}

	/**
	* Returns the nhom van ban with the primary key.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban
	* @throws PortalException if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.NhomVanBan getNhomVanBan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.getNhomVanBan(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the nhom van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of nhom van bans
	* @param end the upper bound of the range of nhom van bans (not inclusive)
	* @return the range of nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> getNhomVanBans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.getNhomVanBans(start, end);
	}

	/**
	* Returns the number of nhom van bans.
	*
	* @return the number of nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getNhomVanBansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.getNhomVanBansCount();
	}

	/**
	* Updates the nhom van ban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nhomVanBan the nhom van ban
	* @return the nhom van ban that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.NhomVanBan updateNhomVanBan(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomVanBanLocalService.updateNhomVanBan(nhomVanBan);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _nhomVanBanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_nhomVanBanLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _nhomVanBanLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> getNhomVanBanByGroupId(
		long groupId) throws java.lang.Exception {
		return _nhomVanBanLocalService.getNhomVanBanByGroupId(groupId);
	}

	@Override
	public java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> getNhomVanBanByGroupId(
		java.util.List<java.lang.Long> groupIds) throws java.lang.Exception {
		return _nhomVanBanLocalService.getNhomVanBanByGroupId(groupIds);
	}

	@Override
	public java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> getNhomVanBanById(
		java.util.List<java.lang.Long> ids) throws java.lang.Exception {
		return _nhomVanBanLocalService.getNhomVanBanById(ids);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NhomVanBanLocalService getWrappedNhomVanBanLocalService() {
		return _nhomVanBanLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNhomVanBanLocalService(
		NhomVanBanLocalService nhomVanBanLocalService) {
		_nhomVanBanLocalService = nhomVanBanLocalService;
	}

	@Override
	public NhomVanBanLocalService getWrappedService() {
		return _nhomVanBanLocalService;
	}

	@Override
	public void setWrappedService(NhomVanBanLocalService nhomVanBanLocalService) {
		_nhomVanBanLocalService = nhomVanBanLocalService;
	}

	private NhomVanBanLocalService _nhomVanBanLocalService;
}