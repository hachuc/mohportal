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

package com.revotech.portal.videolibrary.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VLVideoCategory. This utility wraps
 * {@link com.revotech.portal.videolibrary.service.impl.VLVideoCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ChucHV
 * @see VLVideoCategoryLocalService
 * @see com.revotech.portal.videolibrary.service.base.VLVideoCategoryLocalServiceBaseImpl
 * @see com.revotech.portal.videolibrary.service.impl.VLVideoCategoryLocalServiceImpl
 * @generated
 */
public class VLVideoCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.revotech.portal.videolibrary.service.impl.VLVideoCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the v l video category to the database. Also notifies the appropriate model listeners.
	*
	* @param vlVideoCategory the v l video category
	* @return the v l video category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory addVLVideoCategory(
		com.revotech.portal.videolibrary.model.VLVideoCategory vlVideoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVLVideoCategory(vlVideoCategory);
	}

	/**
	* Creates a new v l video category with the primary key. Does not add the v l video category to the database.
	*
	* @param id the primary key for the new v l video category
	* @return the new v l video category
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory createVLVideoCategory(
		long id) {
		return getService().createVLVideoCategory(id);
	}

	/**
	* Deletes the v l video category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the v l video category
	* @return the v l video category that was removed
	* @throws PortalException if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory deleteVLVideoCategory(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVLVideoCategory(id);
	}

	/**
	* Deletes the v l video category from the database. Also notifies the appropriate model listeners.
	*
	* @param vlVideoCategory the v l video category
	* @return the v l video category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory deleteVLVideoCategory(
		com.revotech.portal.videolibrary.model.VLVideoCategory vlVideoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVLVideoCategory(vlVideoCategory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.revotech.portal.videolibrary.model.VLVideoCategory fetchVLVideoCategory(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVLVideoCategory(id);
	}

	/**
	* Returns the v l video category with the primary key.
	*
	* @param id the primary key of the v l video category
	* @return the v l video category
	* @throws PortalException if a v l video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory getVLVideoCategory(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVLVideoCategory(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v l video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.videolibrary.model.impl.VLVideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v l video categories
	* @param end the upper bound of the range of v l video categories (not inclusive)
	* @return the range of v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> getVLVideoCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVLVideoCategories(start, end);
	}

	/**
	* Returns the number of v l video categories.
	*
	* @return the number of v l video categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getVLVideoCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVLVideoCategoriesCount();
	}

	/**
	* Updates the v l video category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vlVideoCategory the v l video category
	* @return the v l video category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.videolibrary.model.VLVideoCategory updateVLVideoCategory(
		com.revotech.portal.videolibrary.model.VLVideoCategory vlVideoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVLVideoCategory(vlVideoCategory);
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

	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByCategory(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(categoryId, groupId);
	}

	public static java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> findByVideo(
		long videoId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByVideo(videoId, groupId);
	}

	public static com.revotech.portal.videolibrary.model.VLVideoCategory addVLVideoCategory(
		long categoryId, long videoId, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVLVideoCategory(categoryId, videoId, groupId,
			serviceContext);
	}

	public static com.revotech.portal.videolibrary.model.VLVideoCategory updateVLVideoCategory(
		long id, long categoryId, long videoId, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVLVideoCategory(id, categoryId, videoId, groupId,
			serviceContext);
	}

	public static void deleteVideoCategoryMapByCategory(long categoryId,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVideoCategoryMapByCategory(categoryId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VLVideoCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VLVideoCategoryLocalService.class.getName());

			if (invokableLocalService instanceof VLVideoCategoryLocalService) {
				_service = (VLVideoCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new VLVideoCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VLVideoCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VLVideoCategoryLocalService service) {
	}

	private static VLVideoCategoryLocalService _service;
}