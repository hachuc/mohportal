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

package com.viettel.portal.thongke.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BaiVietNhuanBut. This utility wraps
 * {@link com.viettel.portal.thongke.service.impl.BaiVietNhuanButLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author lamvn
 * @see BaiVietNhuanButLocalService
 * @see com.viettel.portal.thongke.service.base.BaiVietNhuanButLocalServiceBaseImpl
 * @see com.viettel.portal.thongke.service.impl.BaiVietNhuanButLocalServiceImpl
 * @generated
 */
public class BaiVietNhuanButLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.thongke.service.impl.BaiVietNhuanButLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bai viet nhuan but to the database. Also notifies the appropriate model listeners.
	*
	* @param baiVietNhuanBut the bai viet nhuan but
	* @return the bai viet nhuan but that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut addBaiVietNhuanBut(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBaiVietNhuanBut(baiVietNhuanBut);
	}

	/**
	* Creates a new bai viet nhuan but with the primary key. Does not add the bai viet nhuan but to the database.
	*
	* @param id the primary key for the new bai viet nhuan but
	* @return the new bai viet nhuan but
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut createBaiVietNhuanBut(
		long id) {
		return getService().createBaiVietNhuanBut(id);
	}

	/**
	* Deletes the bai viet nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but that was removed
	* @throws PortalException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut deleteBaiVietNhuanBut(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBaiVietNhuanBut(id);
	}

	/**
	* Deletes the bai viet nhuan but from the database. Also notifies the appropriate model listeners.
	*
	* @param baiVietNhuanBut the bai viet nhuan but
	* @return the bai viet nhuan but that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut deleteBaiVietNhuanBut(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBaiVietNhuanBut(baiVietNhuanBut);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.viettel.portal.thongke.model.BaiVietNhuanBut fetchBaiVietNhuanBut(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBaiVietNhuanBut(id);
	}

	/**
	* Returns the bai viet nhuan but with the primary key.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but
	* @throws PortalException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut getBaiVietNhuanBut(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBaiVietNhuanBut(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bai viet nhuan buts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @return the range of bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> getBaiVietNhuanButs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBaiVietNhuanButs(start, end);
	}

	/**
	* Returns the number of bai viet nhuan buts.
	*
	* @return the number of bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int getBaiVietNhuanButsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBaiVietNhuanButsCount();
	}

	/**
	* Updates the bai viet nhuan but in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param baiVietNhuanBut the bai viet nhuan but
	* @return the bai viet nhuan but that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut updateBaiVietNhuanBut(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBaiVietNhuanBut(baiVietNhuanBut);
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

	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> getByBaiVietId(
		long baiVietId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByBaiVietId(baiVietId);
	}

	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findBaiVietNhuanButs(
		int type, java.lang.Long groupId, java.lang.String keyword,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findBaiVietNhuanButs(type, groupId, keyword, fromDate,
			toDate, start, end);
	}

	public static int countBaiVietNhuanButs(int type, java.lang.Long groupId,
		java.lang.String keyword, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countBaiVietNhuanButs(type, groupId, keyword, fromDate,
			toDate);
	}

	public static java.util.List<java.lang.Object> findBaiVietRatings(
		long classTypeId, int type, long groupId, java.lang.String keyword,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findBaiVietRatings(classTypeId, type, groupId, keyword,
			fromDate, toDate, start, end);
	}

	public static int countBaiVietRatings(long classTypeId, int type,
		long groupId, java.lang.String keyword, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countBaiVietRatings(classTypeId, type, groupId, keyword,
			fromDate, toDate);
	}

	public static java.util.List<java.lang.Object> findBaiVietNhuanButBySQL(
		java.lang.String sql, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findBaiVietNhuanButBySQL(sql, start, end);
	}

	public static int countBaiVietNhuanButBySQL(java.lang.String sql)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countBaiVietNhuanButBySQL(sql);
	}

	public static com.viettel.portal.thongke.model.BaiVietNhuanBut updateBaiVietNhuanBut(
		int loaiBaiViet, int type, long id, long companyId, long groupId,
		long userId, java.lang.String userName, long baiVietId,
		java.lang.String tieuDe, java.lang.String tacGia,
		java.lang.String diaChi, java.util.Date ngayXuatBan,
		java.lang.String rating, double ratingValue,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBaiVietNhuanBut(loaiBaiViet, type, id, companyId,
			groupId, userId, userName, baiVietId, tieuDe, tacGia, diaChi,
			ngayXuatBan, rating, ratingValue, serviceContext);
	}

	public static com.viettel.portal.thongke.model.BaiVietNhuanBut addBaiVietNhuanBut(
		int loaiBaiViet, int type, long companyId, long groupId, long userId,
		java.lang.String userName, long baiVietId, java.lang.String tieuDe,
		java.lang.String tacGia, java.lang.String diaChi,
		java.util.Date ngayXuatBan, java.lang.String rating,
		double ratingValue,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBaiVietNhuanBut(loaiBaiViet, type, companyId, groupId,
			userId, userName, baiVietId, tieuDe, tacGia, diaChi, ngayXuatBan,
			rating, ratingValue, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static BaiVietNhuanButLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BaiVietNhuanButLocalService.class.getName());

			if (invokableLocalService instanceof BaiVietNhuanButLocalService) {
				_service = (BaiVietNhuanButLocalService)invokableLocalService;
			}
			else {
				_service = new BaiVietNhuanButLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BaiVietNhuanButLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BaiVietNhuanButLocalService service) {
	}

	private static BaiVietNhuanButLocalService _service;
}