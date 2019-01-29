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

package com.revotech.portal.vbpq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LoaiVanBanLocalService}.
 *
 * @author ChucHV
 * @see LoaiVanBanLocalService
 * @generated
 */
public class LoaiVanBanLocalServiceWrapper implements LoaiVanBanLocalService,
	ServiceWrapper<LoaiVanBanLocalService> {
	public LoaiVanBanLocalServiceWrapper(
		LoaiVanBanLocalService loaiVanBanLocalService) {
		_loaiVanBanLocalService = loaiVanBanLocalService;
	}

	/**
	* Adds the loai van ban to the database. Also notifies the appropriate model listeners.
	*
	* @param loaiVanBan the loai van ban
	* @return the loai van ban that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan addLoaiVanBan(
		com.revotech.portal.vbpq.model.LoaiVanBan loaiVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.addLoaiVanBan(loaiVanBan);
	}

	/**
	* Creates a new loai van ban with the primary key. Does not add the loai van ban to the database.
	*
	* @param id the primary key for the new loai van ban
	* @return the new loai van ban
	*/
	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan createLoaiVanBan(long id) {
		return _loaiVanBanLocalService.createLoaiVanBan(id);
	}

	/**
	* Deletes the loai van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loai van ban
	* @return the loai van ban that was removed
	* @throws PortalException if a loai van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan deleteLoaiVanBan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.deleteLoaiVanBan(id);
	}

	/**
	* Deletes the loai van ban from the database. Also notifies the appropriate model listeners.
	*
	* @param loaiVanBan the loai van ban
	* @return the loai van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan deleteLoaiVanBan(
		com.revotech.portal.vbpq.model.LoaiVanBan loaiVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.deleteLoaiVanBan(loaiVanBan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loaiVanBanLocalService.dynamicQuery();
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
		return _loaiVanBanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _loaiVanBanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _loaiVanBanLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _loaiVanBanLocalService.dynamicQueryCount(dynamicQuery);
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
		return _loaiVanBanLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan fetchLoaiVanBan(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.fetchLoaiVanBan(id);
	}

	/**
	* Returns the loai van ban with the primary key.
	*
	* @param id the primary key of the loai van ban
	* @return the loai van ban
	* @throws PortalException if a loai van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan getLoaiVanBan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.getLoaiVanBan(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the loai van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @return the range of loai van bans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.revotech.portal.vbpq.model.LoaiVanBan> getLoaiVanBans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.getLoaiVanBans(start, end);
	}

	/**
	* Returns the number of loai van bans.
	*
	* @return the number of loai van bans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLoaiVanBansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.getLoaiVanBansCount();
	}

	/**
	* Updates the loai van ban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loaiVanBan the loai van ban
	* @return the loai van ban that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan updateLoaiVanBan(
		com.revotech.portal.vbpq.model.LoaiVanBan loaiVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.updateLoaiVanBan(loaiVanBan);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _loaiVanBanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_loaiVanBanLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _loaiVanBanLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.revotech.portal.vbpq.model.LoaiVanBan> findByNhomVanBanId(
		long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.findByNhomVanBanId(nhomVanBanId);
	}

	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan getByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.getByGroupId_Ten(groupId, ten);
	}

	/**
	* @param keyword
	* @param groupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countLoaiVb(java.lang.String keyword, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.countLoaiVb(keyword, groupId);
	}

	/**
	* @param keyword
	* @param groupId
	* @param obc
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.revotech.portal.vbpq.model.LoaiVanBan> findLoaiVb(
		java.lang.String keyword, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.findLoaiVb(keyword, groupId, obc, start,
			end);
	}

	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan getLoaiVb(long linhvucId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.getLoaiVb(linhvucId);
	}

	/**
	* @param groupId
	* @param trangThai
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countByTrangThai(long groupId, boolean trangThai)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.countByTrangThai(groupId, trangThai);
	}

	/**
	* @param groupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.countAll(groupId);
	}

	/**
	* @param groupId
	* @param trangThai
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.revotech.portal.vbpq.model.LoaiVanBan> getByTrangThai(
		long groupId, boolean trangThai, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.getByTrangThai(groupId, trangThai,
			start, end);
	}

	/**
	* @param groupId
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.revotech.portal.vbpq.model.LoaiVanBan> getAll(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.getAll(groupId, start, end);
	}

	/**
	* Delete LoaiVanban by Id
	*
	* @param id
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteLoaiVb(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_loaiVanBanLocalService.deleteLoaiVb(id);
	}

	/**
	* Delete LoaiVanban by entry
	*
	* @param coquan
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteLoaiVb(com.revotech.portal.vbpq.model.LoaiVanBan loaivb)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_loaiVanBanLocalService.deleteLoaiVb(loaivb);
	}

	/**
	* @param userId
	* @param id
	* @param ten
	* @param trangThai
	* @param order_
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan updateLoaiVanBan(
		long userId, long id, java.lang.String ten, boolean trangThai,
		int order_, long groupId, long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiVanBanLocalService.updateLoaiVanBan(userId, id, ten,
			trangThai, order_, groupId, nhomVanBanId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LoaiVanBanLocalService getWrappedLoaiVanBanLocalService() {
		return _loaiVanBanLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLoaiVanBanLocalService(
		LoaiVanBanLocalService loaiVanBanLocalService) {
		_loaiVanBanLocalService = loaiVanBanLocalService;
	}

	@Override
	public LoaiVanBanLocalService getWrappedService() {
		return _loaiVanBanLocalService;
	}

	@Override
	public void setWrappedService(LoaiVanBanLocalService loaiVanBanLocalService) {
		_loaiVanBanLocalService = loaiVanBanLocalService;
	}

	private LoaiVanBanLocalService _loaiVanBanLocalService;
}