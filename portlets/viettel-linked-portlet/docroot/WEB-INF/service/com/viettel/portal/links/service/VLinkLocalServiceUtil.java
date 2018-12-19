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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VLink. This utility wraps
 * {@link com.viettel.portal.links.service.impl.VLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ChucHV
 * @see VLinkLocalService
 * @see com.viettel.portal.links.service.base.VLinkLocalServiceBaseImpl
 * @see com.viettel.portal.links.service.impl.VLinkLocalServiceImpl
 * @generated
 */
public class VLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.links.service.impl.VLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the v link to the database. Also notifies the appropriate model listeners.
	*
	* @param vLink the v link
	* @return the v link that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.VLink addVLink(
		com.viettel.portal.links.model.VLink vLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVLink(vLink);
	}

	/**
	* Creates a new v link with the primary key. Does not add the v link to the database.
	*
	* @param linkId the primary key for the new v link
	* @return the new v link
	*/
	public static com.viettel.portal.links.model.VLink createVLink(long linkId) {
		return getService().createVLink(linkId);
	}

	/**
	* Deletes the v link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the v link
	* @return the v link that was removed
	* @throws PortalException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.VLink deleteVLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVLink(linkId);
	}

	/**
	* Deletes the v link from the database. Also notifies the appropriate model listeners.
	*
	* @param vLink the v link
	* @return the v link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.VLink deleteVLink(
		com.viettel.portal.links.model.VLink vLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVLink(vLink);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.viettel.portal.links.model.VLink fetchVLink(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVLink(linkId);
	}

	/**
	* Returns the v link with the primary key.
	*
	* @param linkId the primary key of the v link
	* @return the v link
	* @throws PortalException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.VLink getVLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVLink(linkId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.viettel.portal.links.model.VLink> getVLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVLinks(start, end);
	}

	/**
	* Returns the number of v links.
	*
	* @return the number of v links
	* @throws SystemException if a system exception occurred
	*/
	public static int getVLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVLinksCount();
	}

	/**
	* Updates the v link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vLink the v link
	* @return the v link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.VLink updateVLink(
		com.viettel.portal.links.model.VLink vLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVLink(vLink);
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

	public static java.util.List<com.viettel.portal.links.model.VLink> findByGroupAndCateActive(
		long groupId, long categoryId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupAndCateActive(groupId, categoryId, isActive);
	}

	public static com.viettel.portal.links.VLinkGrid findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .findByKeyword(groupId, categoryId, keyword, start, end, obc);
	}

	public static com.viettel.portal.links.model.VLink updateLink(long id,
		long companyId, long groupId, long userId, java.lang.String userName,
		long categoryId, java.lang.String linkName, java.lang.String url,
		int corder, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLink(id, companyId, groupId, userId, userName,
			categoryId, linkName, url, corder, serviceContext);
	}

	public static com.viettel.portal.links.model.VLink addLink(long companyId,
		long groupId, long userId, java.lang.String userName, long categoryId,
		java.lang.String linkName, java.lang.String url, int corder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLink(companyId, groupId, userId, userName, categoryId,
			linkName, url, corder, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static VLinkLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VLinkLocalService.class.getName());

			if (invokableLocalService instanceof VLinkLocalService) {
				_service = (VLinkLocalService)invokableLocalService;
			}
			else {
				_service = new VLinkLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VLinkLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VLinkLocalService service) {
	}

	private static VLinkLocalService _service;
}