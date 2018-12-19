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
 * Provides a wrapper for {@link LinhVucVanBanLocalService}.
 *
 * @author ChucHV
 * @see LinhVucVanBanLocalService
 * @generated
 */
public class LinhVucVanBanLocalServiceWrapper
	implements LinhVucVanBanLocalService,
		ServiceWrapper<LinhVucVanBanLocalService> {
	public LinhVucVanBanLocalServiceWrapper(
		LinhVucVanBanLocalService linhVucVanBanLocalService) {
		_linhVucVanBanLocalService = linhVucVanBanLocalService;
	}

	/**
	* Adds the linh vuc van ban to the database. Also notifies the appropriate model listeners.
	*
	* @param linhVucVanBan the linh vuc van ban
	* @return the linh vuc van ban that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan addLinhVucVanBan(
		com.viettel.portal.vbpq.model.LinhVucVanBan linhVucVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.addLinhVucVanBan(linhVucVanBan);
	}

	/**
	* Creates a new linh vuc van ban with the primary key. Does not add the linh vuc van ban to the database.
	*
	* @param id the primary key for the new linh vuc van ban
	* @return the new linh vuc van ban
	*/
	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan createLinhVucVanBan(
		long id) {
		return _linhVucVanBanLocalService.createLinhVucVanBan(id);
	}

	/**
	* Deletes the linh vuc van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the linh vuc van ban
	* @return the linh vuc van ban that was removed
	* @throws PortalException if a linh vuc van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan deleteLinhVucVanBan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.deleteLinhVucVanBan(id);
	}

	/**
	* Deletes the linh vuc van ban from the database. Also notifies the appropriate model listeners.
	*
	* @param linhVucVanBan the linh vuc van ban
	* @return the linh vuc van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan deleteLinhVucVanBan(
		com.viettel.portal.vbpq.model.LinhVucVanBan linhVucVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.deleteLinhVucVanBan(linhVucVanBan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _linhVucVanBanLocalService.dynamicQuery();
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
		return _linhVucVanBanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _linhVucVanBanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _linhVucVanBanLocalService.dynamicQuery(dynamicQuery, start,
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
		return _linhVucVanBanLocalService.dynamicQueryCount(dynamicQuery);
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
		return _linhVucVanBanLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchLinhVucVanBan(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.fetchLinhVucVanBan(id);
	}

	/**
	* Returns the linh vuc van ban with the primary key.
	*
	* @param id the primary key of the linh vuc van ban
	* @return the linh vuc van ban
	* @throws PortalException if a linh vuc van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan getLinhVucVanBan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.getLinhVucVanBan(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the linh vuc van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @return the range of linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> getLinhVucVanBans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.getLinhVucVanBans(start, end);
	}

	/**
	* Returns the number of linh vuc van bans.
	*
	* @return the number of linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLinhVucVanBansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.getLinhVucVanBansCount();
	}

	/**
	* Updates the linh vuc van ban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param linhVucVanBan the linh vuc van ban
	* @return the linh vuc van ban that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan updateLinhVucVanBan(
		com.viettel.portal.vbpq.model.LinhVucVanBan linhVucVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.updateLinhVucVanBan(linhVucVanBan);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _linhVucVanBanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_linhVucVanBanLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _linhVucVanBanLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByNhomVanBanId(
		long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.findByNhomVanBanId(nhomVanBanId);
	}

	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan getByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.getByGroupId_Ten(groupId, ten);
	}

	/**
	* @param keyword
	* @param groupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countLinhVuc(java.lang.String keyword, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.countLinhVuc(keyword, groupId);
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
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findLinhVuc(
		java.lang.String keyword, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.findLinhVuc(keyword, groupId, obc,
			start, end);
	}

	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan getLinhVuc(
		long linhvucId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.getLinhVuc(linhvucId);
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
		return _linhVucVanBanLocalService.countByTrangThai(groupId, trangThai);
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
		return _linhVucVanBanLocalService.countAll(groupId);
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
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> getByTrangThai(
		long groupId, boolean trangThai, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.getByTrangThai(groupId, trangThai,
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
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> getAll(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.getAll(groupId, start, end);
	}

	/**
	* Delete coquan by Id
	*
	* @param id
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteLinhVuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linhVucVanBanLocalService.deleteLinhVuc(id);
	}

	/**
	* Delete coquan by entry
	*
	* @param coquan
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteLinhVuc(
		com.viettel.portal.vbpq.model.LinhVucVanBan linhvuc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linhVucVanBanLocalService.deleteLinhVuc(linhvuc);
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
	public com.viettel.portal.vbpq.model.LinhVucVanBan updateLinhVucVanBan(
		long userId, long id, java.lang.String ten, boolean trangThai,
		int order_, long groupId, long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linhVucVanBanLocalService.updateLinhVucVanBan(userId, id, ten,
			trangThai, order_, groupId, nhomVanBanId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LinhVucVanBanLocalService getWrappedLinhVucVanBanLocalService() {
		return _linhVucVanBanLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLinhVucVanBanLocalService(
		LinhVucVanBanLocalService linhVucVanBanLocalService) {
		_linhVucVanBanLocalService = linhVucVanBanLocalService;
	}

	@Override
	public LinhVucVanBanLocalService getWrappedService() {
		return _linhVucVanBanLocalService;
	}

	@Override
	public void setWrappedService(
		LinhVucVanBanLocalService linhVucVanBanLocalService) {
		_linhVucVanBanLocalService = linhVucVanBanLocalService;
	}

	private LinhVucVanBanLocalService _linhVucVanBanLocalService;
}