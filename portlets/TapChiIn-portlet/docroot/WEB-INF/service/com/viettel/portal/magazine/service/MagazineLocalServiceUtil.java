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

package com.viettel.portal.magazine.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Magazine. This utility wraps
 * {@link com.viettel.portal.magazine.service.impl.MagazineLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author namtv
 * @see MagazineLocalService
 * @see com.viettel.portal.magazine.service.base.MagazineLocalServiceBaseImpl
 * @see com.viettel.portal.magazine.service.impl.MagazineLocalServiceImpl
 * @generated
 */
public class MagazineLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.magazine.service.impl.MagazineLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the magazine to the database. Also notifies the appropriate model listeners.
	*
	* @param magazine the magazine
	* @return the magazine that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.Magazine addMagazine(
		com.viettel.portal.magazine.model.Magazine magazine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMagazine(magazine);
	}

	/**
	* Creates a new magazine with the primary key. Does not add the magazine to the database.
	*
	* @param ID the primary key for the new magazine
	* @return the new magazine
	*/
	public static com.viettel.portal.magazine.model.Magazine createMagazine(
		int ID) {
		return getService().createMagazine(ID);
	}

	/**
	* Deletes the magazine with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the magazine
	* @return the magazine that was removed
	* @throws PortalException if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.Magazine deleteMagazine(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMagazine(ID);
	}

	/**
	* Deletes the magazine from the database. Also notifies the appropriate model listeners.
	*
	* @param magazine the magazine
	* @return the magazine that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.Magazine deleteMagazine(
		com.viettel.portal.magazine.model.Magazine magazine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMagazine(magazine);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.viettel.portal.magazine.model.Magazine fetchMagazine(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMagazine(ID);
	}

	/**
	* Returns the magazine with the primary key.
	*
	* @param ID the primary key of the magazine
	* @return the magazine
	* @throws PortalException if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.Magazine getMagazine(int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMagazine(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the magazines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of magazines
	* @param end the upper bound of the range of magazines (not inclusive)
	* @return the range of magazines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.Magazine> getMagazines(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMagazines(start, end);
	}

	/**
	* Returns the number of magazines.
	*
	* @return the number of magazines
	* @throws SystemException if a system exception occurred
	*/
	public static int getMagazinesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMagazinesCount();
	}

	/**
	* Updates the magazine in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param magazine the magazine
	* @return the magazine that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.Magazine updateMagazine(
		com.viettel.portal.magazine.model.Magazine magazine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMagazine(magazine);
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

	public static java.util.List<com.viettel.portal.magazine.model.Magazine> getLastestMagazine()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLastestMagazine();
	}

	public static java.util.List<com.viettel.portal.magazine.model.Magazine> searchMagazine(
		long number, long year, int begin, int end) {
		return getService().searchMagazine(number, year, begin, end);
	}

	public static int countMagazine(long number, long year) {
		return getService().countMagazine(number, year);
	}

	public static java.util.List<com.viettel.portal.magazine.model.Magazine> findByPublishYear(
		int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPublishYear(year);
	}

	public static com.viettel.portal.magazine.model.Magazine updateMagazine(
		int id, long groupId, long userId, java.lang.String userFullname,
		java.lang.String name, int publishNumber, int publishYear, long fileId,
		java.util.Date distributedDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMagazine(id, groupId, userId, userFullname, name,
			publishNumber, publishYear, fileId, distributedDate, serviceContext);
	}

	public static com.viettel.portal.magazine.model.Magazine addMagazine(
		long groupId, long userId, java.lang.String userFullname,
		java.lang.String name, int publishNumber, int publishYear, long fileId,
		java.util.Date distributedDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMagazine(groupId, userId, userFullname, name,
			publishNumber, publishYear, fileId, distributedDate, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static MagazineLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MagazineLocalService.class.getName());

			if (invokableLocalService instanceof MagazineLocalService) {
				_service = (MagazineLocalService)invokableLocalService;
			}
			else {
				_service = new MagazineLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MagazineLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MagazineLocalService service) {
	}

	private static MagazineLocalService _service;
}