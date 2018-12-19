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
 * Provides the local service utility for NhomVanBan. This utility wraps
 * {@link com.viettel.portal.vbpq.service.impl.NhomVanBanLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ChucHV
 * @see NhomVanBanLocalService
 * @see com.viettel.portal.vbpq.service.base.NhomVanBanLocalServiceBaseImpl
 * @see com.viettel.portal.vbpq.service.impl.NhomVanBanLocalServiceImpl
 * @generated
 */
public class NhomVanBanLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.vbpq.service.impl.NhomVanBanLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the nhom van ban to the database. Also notifies the appropriate model listeners.
	*
	* @param nhomVanBan the nhom van ban
	* @return the nhom van ban that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan addNhomVanBan(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNhomVanBan(nhomVanBan);
	}

	/**
	* Creates a new nhom van ban with the primary key. Does not add the nhom van ban to the database.
	*
	* @param id the primary key for the new nhom van ban
	* @return the new nhom van ban
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan createNhomVanBan(
		long id) {
		return getService().createNhomVanBan(id);
	}

	/**
	* Deletes the nhom van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban that was removed
	* @throws PortalException if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan deleteNhomVanBan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNhomVanBan(id);
	}

	/**
	* Deletes the nhom van ban from the database. Also notifies the appropriate model listeners.
	*
	* @param nhomVanBan the nhom van ban
	* @return the nhom van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan deleteNhomVanBan(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNhomVanBan(nhomVanBan);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.viettel.portal.vbpq.model.NhomVanBan fetchNhomVanBan(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchNhomVanBan(id);
	}

	/**
	* Returns the nhom van ban with the primary key.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban
	* @throws PortalException if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan getNhomVanBan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNhomVanBan(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> getNhomVanBans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNhomVanBans(start, end);
	}

	/**
	* Returns the number of nhom van bans.
	*
	* @return the number of nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int getNhomVanBansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNhomVanBansCount();
	}

	/**
	* Updates the nhom van ban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nhomVanBan the nhom van ban
	* @return the nhom van ban that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan updateNhomVanBan(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNhomVanBan(nhomVanBan);
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

	public static java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> getNhomVanBanByGroupId(
		long groupId) throws java.lang.Exception {
		return getService().getNhomVanBanByGroupId(groupId);
	}

	public static java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> getNhomVanBanByGroupId(
		java.util.List<java.lang.Long> groupIds) throws java.lang.Exception {
		return getService().getNhomVanBanByGroupId(groupIds);
	}

	public static java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> getNhomVanBanById(
		java.util.List<java.lang.Long> ids) throws java.lang.Exception {
		return getService().getNhomVanBanById(ids);
	}

	public static void clearService() {
		_service = null;
	}

	public static NhomVanBanLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NhomVanBanLocalService.class.getName());

			if (invokableLocalService instanceof NhomVanBanLocalService) {
				_service = (NhomVanBanLocalService)invokableLocalService;
			}
			else {
				_service = new NhomVanBanLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(NhomVanBanLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(NhomVanBanLocalService service) {
	}

	private static NhomVanBanLocalService _service;
}