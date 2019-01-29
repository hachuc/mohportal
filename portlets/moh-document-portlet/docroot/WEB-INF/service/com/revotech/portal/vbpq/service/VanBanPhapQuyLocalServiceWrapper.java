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
 * Provides a wrapper for {@link VanBanPhapQuyLocalService}.
 *
 * @author ChucHV
 * @see VanBanPhapQuyLocalService
 * @generated
 */
public class VanBanPhapQuyLocalServiceWrapper
	implements VanBanPhapQuyLocalService,
		ServiceWrapper<VanBanPhapQuyLocalService> {
	public VanBanPhapQuyLocalServiceWrapper(
		VanBanPhapQuyLocalService vanBanPhapQuyLocalService) {
		_vanBanPhapQuyLocalService = vanBanPhapQuyLocalService;
	}

	/**
	* Adds the van ban phap quy to the database. Also notifies the appropriate model listeners.
	*
	* @param vanBanPhapQuy the van ban phap quy
	* @return the van ban phap quy that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy addVanBanPhapQuy(
		com.revotech.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.addVanBanPhapQuy(vanBanPhapQuy);
	}

	/**
	* Creates a new van ban phap quy with the primary key. Does not add the van ban phap quy to the database.
	*
	* @param id the primary key for the new van ban phap quy
	* @return the new van ban phap quy
	*/
	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy createVanBanPhapQuy(
		long id) {
		return _vanBanPhapQuyLocalService.createVanBanPhapQuy(id);
	}

	/**
	* Deletes the van ban phap quy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy that was removed
	* @throws PortalException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy deleteVanBanPhapQuy(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.deleteVanBanPhapQuy(id);
	}

	/**
	* Deletes the van ban phap quy from the database. Also notifies the appropriate model listeners.
	*
	* @param vanBanPhapQuy the van ban phap quy
	* @return the van ban phap quy that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy deleteVanBanPhapQuy(
		com.revotech.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.deleteVanBanPhapQuy(vanBanPhapQuy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vanBanPhapQuyLocalService.dynamicQuery();
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
		return _vanBanPhapQuyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vanBanPhapQuyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vanBanPhapQuyLocalService.dynamicQuery(dynamicQuery, start,
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
		return _vanBanPhapQuyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vanBanPhapQuyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy fetchVanBanPhapQuy(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.fetchVanBanPhapQuy(id);
	}

	/**
	* Returns the van ban phap quy with the primary key.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy
	* @throws PortalException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy getVanBanPhapQuy(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.getVanBanPhapQuy(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the van ban phap quies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @return the range of van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.revotech.portal.vbpq.model.VanBanPhapQuy> getVanBanPhapQuies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.getVanBanPhapQuies(start, end);
	}

	/**
	* Returns the number of van ban phap quies.
	*
	* @return the number of van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVanBanPhapQuiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.getVanBanPhapQuiesCount();
	}

	/**
	* Updates the van ban phap quy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vanBanPhapQuy the van ban phap quy
	* @return the van ban phap quy that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy updateVanBanPhapQuy(
		com.revotech.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.updateVanBanPhapQuy(vanBanPhapQuy);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vanBanPhapQuyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vanBanPhapQuyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vanBanPhapQuyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy getByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.getByGroupId_MaVanBan(groupId,
			maVanBan);
	}

	@Override
	public int countAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.countAll(groupId);
	}

	@Override
	public java.util.List<com.revotech.portal.vbpq.model.VanBanPhapQuy> getAll(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.getAll(groupId, start, end);
	}

	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy getVanBan(long vanbanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.getVanBan(vanbanId);
	}

	@Override
	public void deleteVanBan(long vanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vanBanPhapQuyLocalService.deleteVanBan(vanBanId);
	}

	@Override
	public java.util.List<com.revotech.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.findByG_CQBH_S(groupId,
			coQuanBanHanh, status);
	}

	@Override
	public java.util.List<com.revotech.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.findByG_CQBH_S(groupId,
			coQuanBanHanh, status, start, end);
	}

	@Override
	public void deleteVanBan(
		com.revotech.portal.vbpq.model.VanBanPhapQuy vanBan)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vanBanPhapQuyLocalService.deleteVanBan(vanBan);
	}

	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy updateVanBanPhapQuy(
		long userId, long groupId, long id, java.lang.String maVanBan,
		boolean neverExpire, long coQuanBanHanh, long linhVucVanBan,
		long loaiVanBan, java.util.Date ngayBanHanh,
		java.util.Date ngayCoHieuLuc, java.util.Date ngayHetHieuLuc,
		java.lang.String nguoiKy, java.lang.String trichYeu,
		long vanBanThayThe, int status, long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.updateVanBanPhapQuy(userId, groupId,
			id, maVanBan, neverExpire, coQuanBanHanh, linhVucVanBan,
			loaiVanBan, ngayBanHanh, ngayCoHieuLuc, ngayHetHieuLuc, nguoiKy,
			trichYeu, vanBanThayThe, status, nhomVanBanId);
	}

	/**
	* @param id
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy updateStatusVanBan(
		long vanBanId, int status, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuyLocalService.updateStatusVanBan(vanBanId, status,
			userId);
	}

	@Override
	public int count(java.lang.String keyword, long groupId,
		long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds,
		long[] nhomVanBanIds, java.lang.Integer status,
		java.util.Date startDateObj, java.util.Date endDateObj)
		throws java.lang.Exception {
		return _vanBanPhapQuyLocalService.count(keyword, groupId,
			loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds,
			status, startDateObj, endDateObj);
	}

	@Override
	public java.util.List<com.revotech.portal.vbpq.model.VanBanPhapQuy> find(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys) throws java.lang.Exception {
		return _vanBanPhapQuyLocalService.find(keyword, groupId, loaiVanBanIds,
			linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds, status,
			startDateObj, endDateObj, start, end, obc, orderBys);
	}

	@Override
	public com.revotech.portal.vbpq.VanBanPhapQuyGrid timKiemVanBanPhapQuy(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys) throws java.lang.Exception {
		return _vanBanPhapQuyLocalService.timKiemVanBanPhapQuy(keyword,
			groupId, loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds,
			nhomVanBanIds, status, startDateObj, endDateObj, start, end, obc,
			orderBys);
	}

	@Override
	public com.revotech.portal.vbpq.VanBanPhapQuyGrid timKiemVanBanPhapQuyTheoNgayTao(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys) throws java.lang.Exception {
		return _vanBanPhapQuyLocalService.timKiemVanBanPhapQuyTheoNgayTao(keyword,
			groupId, loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds,
			nhomVanBanIds, status, startDateObj, endDateObj, start, end, obc,
			orderBys);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VanBanPhapQuyLocalService getWrappedVanBanPhapQuyLocalService() {
		return _vanBanPhapQuyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVanBanPhapQuyLocalService(
		VanBanPhapQuyLocalService vanBanPhapQuyLocalService) {
		_vanBanPhapQuyLocalService = vanBanPhapQuyLocalService;
	}

	@Override
	public VanBanPhapQuyLocalService getWrappedService() {
		return _vanBanPhapQuyLocalService;
	}

	@Override
	public void setWrappedService(
		VanBanPhapQuyLocalService vanBanPhapQuyLocalService) {
		_vanBanPhapQuyLocalService = vanBanPhapQuyLocalService;
	}

	private VanBanPhapQuyLocalService _vanBanPhapQuyLocalService;
}