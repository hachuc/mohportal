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
 * Provides the local service utility for PhongBanNhuanBut. This utility wraps
 * {@link com.viettel.portal.thongke.service.impl.PhongBanNhuanButLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author lamvn
 * @see PhongBanNhuanButLocalService
 * @see com.viettel.portal.thongke.service.base.PhongBanNhuanButLocalServiceBaseImpl
 * @see com.viettel.portal.thongke.service.impl.PhongBanNhuanButLocalServiceImpl
 * @generated
 */
public class PhongBanNhuanButLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.thongke.service.impl.PhongBanNhuanButLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the phong ban nhuan but to the database. Also notifies the appropriate model listeners.
	*
	* @param phongBanNhuanBut the phong ban nhuan but
	* @return the phong ban nhuan but that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut addPhongBanNhuanBut(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPhongBanNhuanBut(phongBanNhuanBut);
	}

	/**
	* Creates a new phong ban nhuan but with the primary key. Does not add the phong ban nhuan but to the database.
	*
	* @param id the primary key for the new phong ban nhuan but
	* @return the new phong ban nhuan but
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut createPhongBanNhuanBut(
		long id) {
		return getService().createPhongBanNhuanBut(id);
	}

	/**
	* Deletes the phong ban nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the phong ban nhuan but
	* @return the phong ban nhuan but that was removed
	* @throws PortalException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut deletePhongBanNhuanBut(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePhongBanNhuanBut(id);
	}

	/**
	* Deletes the phong ban nhuan but from the database. Also notifies the appropriate model listeners.
	*
	* @param phongBanNhuanBut the phong ban nhuan but
	* @return the phong ban nhuan but that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut deletePhongBanNhuanBut(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePhongBanNhuanBut(phongBanNhuanBut);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchPhongBanNhuanBut(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPhongBanNhuanBut(id);
	}

	/**
	* Returns the phong ban nhuan but with the primary key.
	*
	* @param id the primary key of the phong ban nhuan but
	* @return the phong ban nhuan but
	* @throws PortalException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut getPhongBanNhuanBut(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhongBanNhuanBut(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the phong ban nhuan buts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @return the range of phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> getPhongBanNhuanButs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhongBanNhuanButs(start, end);
	}

	/**
	* Returns the number of phong ban nhuan buts.
	*
	* @return the number of phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int getPhongBanNhuanButsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPhongBanNhuanButsCount();
	}

	/**
	* Updates the phong ban nhuan but in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param phongBanNhuanBut the phong ban nhuan but
	* @return the phong ban nhuan but that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut updatePhongBanNhuanBut(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePhongBanNhuanBut(phongBanNhuanBut);
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

	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findPhongBanNhuanButs(
		long groupId, java.lang.String keyword, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findPhongBanNhuanButs(groupId, keyword, fromDate, toDate,
			start, end);
	}

	public static int countPhongBanNhuanButs(long groupId,
		java.lang.String keyword, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countPhongBanNhuanButs(groupId, keyword, fromDate, toDate);
	}

	public static com.viettel.portal.thongke.model.PhongBanNhuanBut updatePhongBanNhuanBut(
		long id, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String caption,
		java.util.Date fromDate, java.util.Date toDate, boolean status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePhongBanNhuanBut(id, companyId, groupId, userId,
			userName, caption, fromDate, toDate, status, serviceContext);
	}

	public static com.viettel.portal.thongke.model.PhongBanNhuanBut addPhongBanNhuanBut(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String caption, java.util.Date fromDate,
		java.util.Date toDate, boolean status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPhongBanNhuanBut(companyId, groupId, userId, userName,
			caption, fromDate, toDate, status, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static PhongBanNhuanButLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PhongBanNhuanButLocalService.class.getName());

			if (invokableLocalService instanceof PhongBanNhuanButLocalService) {
				_service = (PhongBanNhuanButLocalService)invokableLocalService;
			}
			else {
				_service = new PhongBanNhuanButLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PhongBanNhuanButLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PhongBanNhuanButLocalService service) {
	}

	private static PhongBanNhuanButLocalService _service;
}