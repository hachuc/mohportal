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
 * Provides the local service utility for LCategory. This utility wraps
 * {@link com.viettel.portal.links.service.impl.LCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ChucHV
 * @see LCategoryLocalService
 * @see com.viettel.portal.links.service.base.LCategoryLocalServiceBaseImpl
 * @see com.viettel.portal.links.service.impl.LCategoryLocalServiceImpl
 * @generated
 */
public class LCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.links.service.impl.LCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the l category to the database. Also notifies the appropriate model listeners.
	*
	* @param lCategory the l category
	* @return the l category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory addLCategory(
		com.viettel.portal.links.model.LCategory lCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLCategory(lCategory);
	}

	/**
	* Creates a new l category with the primary key. Does not add the l category to the database.
	*
	* @param categoryId the primary key for the new l category
	* @return the new l category
	*/
	public static com.viettel.portal.links.model.LCategory createLCategory(
		long categoryId) {
		return getService().createLCategory(categoryId);
	}

	/**
	* Deletes the l category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the l category
	* @return the l category that was removed
	* @throws PortalException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory deleteLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLCategory(categoryId);
	}

	/**
	* Deletes the l category from the database. Also notifies the appropriate model listeners.
	*
	* @param lCategory the l category
	* @return the l category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory deleteLCategory(
		com.viettel.portal.links.model.LCategory lCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLCategory(lCategory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.viettel.portal.links.model.LCategory fetchLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLCategory(categoryId);
	}

	/**
	* Returns the l category with the primary key.
	*
	* @param categoryId the primary key of the l category
	* @return the l category
	* @throws PortalException if a l category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory getLCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLCategory(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.LCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l categories
	* @param end the upper bound of the range of l categories (not inclusive)
	* @return the range of l categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.links.model.LCategory> getLCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLCategories(start, end);
	}

	/**
	* Returns the number of l categories.
	*
	* @return the number of l categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getLCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLCategoriesCount();
	}

	/**
	* Updates the l category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lCategory the l category
	* @return the l category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.links.model.LCategory updateLCategory(
		com.viettel.portal.links.model.LCategory lCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLCategory(lCategory);
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

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static int countByGroupAndState(long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupAndState(groupId, isActive);
	}

	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroupAndState(
		long groupId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupAndState(groupId, isActive);
	}

	public static java.util.List<com.viettel.portal.links.model.LCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.viettel.portal.links.model.LCategory> findByCategoryName(
		java.lang.String categoryName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryName(categoryName, groupId);
	}

	public static com.viettel.portal.links.model.LCategory addCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, boolean isActive, int corder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCategory(companyId, groupId, userId, userName,
			categoryName, isActive, corder, serviceContext);
	}

	public static com.viettel.portal.links.model.LCategory updateCategory(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String categoryName,
		boolean isActive, int corder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCategory(categoryId, companyId, groupId, userId,
			userName, categoryName, isActive, corder, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static LCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LCategoryLocalService.class.getName());

			if (invokableLocalService instanceof LCategoryLocalService) {
				_service = (LCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new LCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LCategoryLocalService service) {
	}

	private static LCategoryLocalService _service;
}