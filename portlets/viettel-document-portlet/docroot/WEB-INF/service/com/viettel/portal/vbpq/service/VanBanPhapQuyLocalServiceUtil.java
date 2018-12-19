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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VanBanPhapQuy. This utility wraps
 * {@link com.viettel.portal.vbpq.service.impl.VanBanPhapQuyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ChucHV
 * @see VanBanPhapQuyLocalService
 * @see com.viettel.portal.vbpq.service.base.VanBanPhapQuyLocalServiceBaseImpl
 * @see com.viettel.portal.vbpq.service.impl.VanBanPhapQuyLocalServiceImpl
 * @generated
 */
public class VanBanPhapQuyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.vbpq.service.impl.VanBanPhapQuyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the van ban phap quy to the database. Also notifies the appropriate model listeners.
	*
	* @param vanBanPhapQuy the van ban phap quy
	* @return the van ban phap quy that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy addVanBanPhapQuy(
		com.viettel.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVanBanPhapQuy(vanBanPhapQuy);
	}

	/**
	* Creates a new van ban phap quy with the primary key. Does not add the van ban phap quy to the database.
	*
	* @param id the primary key for the new van ban phap quy
	* @return the new van ban phap quy
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy createVanBanPhapQuy(
		long id) {
		return getService().createVanBanPhapQuy(id);
	}

	/**
	* Deletes the van ban phap quy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy that was removed
	* @throws PortalException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy deleteVanBanPhapQuy(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVanBanPhapQuy(id);
	}

	/**
	* Deletes the van ban phap quy from the database. Also notifies the appropriate model listeners.
	*
	* @param vanBanPhapQuy the van ban phap quy
	* @return the van ban phap quy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy deleteVanBanPhapQuy(
		com.viettel.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVanBanPhapQuy(vanBanPhapQuy);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchVanBanPhapQuy(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVanBanPhapQuy(id);
	}

	/**
	* Returns the van ban phap quy with the primary key.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy
	* @throws PortalException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy getVanBanPhapQuy(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVanBanPhapQuy(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the van ban phap quies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @return the range of van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> getVanBanPhapQuies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVanBanPhapQuies(start, end);
	}

	/**
	* Returns the number of van ban phap quies.
	*
	* @return the number of van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static int getVanBanPhapQuiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVanBanPhapQuiesCount();
	}

	/**
	* Updates the van ban phap quy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vanBanPhapQuy the van ban phap quy
	* @return the van ban phap quy that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy updateVanBanPhapQuy(
		com.viettel.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVanBanPhapQuy(vanBanPhapQuy);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.viettel.portal.vbpq.model.VanBanPhapQuy getByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroupId_MaVanBan(groupId, maVanBan);
	}

	public static int countAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll(groupId);
	}

	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> getAll(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll(groupId, start, end);
	}

	public static com.viettel.portal.vbpq.model.VanBanPhapQuy getVanBan(
		long vanbanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVanBan(vanbanId);
	}

	public static void deleteVanBan(long vanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVanBan(vanBanId);
	}

	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByG_CQBH_S(groupId, coQuanBanHanh, status);
	}

	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByG_CQBH_S(groupId, coQuanBanHanh, status, start, end);
	}

	public static void deleteVanBan(
		com.viettel.portal.vbpq.model.VanBanPhapQuy vanBan)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVanBan(vanBan);
	}

	public static com.viettel.portal.vbpq.model.VanBanPhapQuy updateVanBanPhapQuy(
		long userId, long groupId, long id, java.lang.String maVanBan,
		boolean neverExpire, long coQuanBanHanh, long linhVucVanBan,
		long loaiVanBan, java.util.Date ngayBanHanh,
		java.util.Date ngayCoHieuLuc, java.util.Date ngayHetHieuLuc,
		java.lang.String nguoiKy, java.lang.String trichYeu,
		long vanBanThayThe, int status, long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVanBanPhapQuy(userId, groupId, id, maVanBan,
			neverExpire, coQuanBanHanh, linhVucVanBan, loaiVanBan, ngayBanHanh,
			ngayCoHieuLuc, ngayHetHieuLuc, nguoiKy, trichYeu, vanBanThayThe,
			status, nhomVanBanId);
	}

	/**
	* @param id
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy updateStatusVanBan(
		long vanBanId, int status, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStatusVanBan(vanBanId, status, userId);
	}

	public static int count(java.lang.String keyword, long groupId,
		long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds,
		long[] nhomVanBanIds, java.lang.Integer status,
		java.util.Date startDateObj, java.util.Date endDateObj)
		throws java.lang.Exception {
		return getService()
				   .count(keyword, groupId, loaiVanBanIds, linhVucVanBanIds,
			coQuanBanHanhIds, nhomVanBanIds, status, startDateObj, endDateObj);
	}

	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> find(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys) throws java.lang.Exception {
		return getService()
				   .find(keyword, groupId, loaiVanBanIds, linhVucVanBanIds,
			coQuanBanHanhIds, nhomVanBanIds, status, startDateObj, endDateObj,
			start, end, obc, orderBys);
	}

	public static com.viettel.portal.vbpq.VanBanPhapQuyGrid timKiemVanBanPhapQuy(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys) throws java.lang.Exception {
		return getService()
				   .timKiemVanBanPhapQuy(keyword, groupId, loaiVanBanIds,
			linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds, status,
			startDateObj, endDateObj, start, end, obc, orderBys);
	}

	public static com.viettel.portal.vbpq.VanBanPhapQuyGrid timKiemVanBanPhapQuyTheoNgayTao(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String[] orderBys) throws java.lang.Exception {
		return getService()
				   .timKiemVanBanPhapQuyTheoNgayTao(keyword, groupId,
			loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds,
			status, startDateObj, endDateObj, start, end, obc, orderBys);
	}

	public static void clearService() {
		_service = null;
	}

	public static VanBanPhapQuyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VanBanPhapQuyLocalService.class.getName());

			if (invokableLocalService instanceof VanBanPhapQuyLocalService) {
				_service = (VanBanPhapQuyLocalService)invokableLocalService;
			}
			else {
				_service = new VanBanPhapQuyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VanBanPhapQuyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VanBanPhapQuyLocalService service) {
	}

	private static VanBanPhapQuyLocalService _service;
}