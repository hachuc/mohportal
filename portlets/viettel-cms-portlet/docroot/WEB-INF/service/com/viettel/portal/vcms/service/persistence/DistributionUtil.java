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

package com.viettel.portal.vcms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.vcms.model.Distribution;

import java.util.List;

/**
 * The persistence utility for the distribution service. This utility wraps {@link DistributionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see DistributionPersistence
 * @see DistributionPersistenceImpl
 * @generated
 */
public class DistributionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Distribution distribution) {
		getPersistence().clearCache(distribution);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Distribution> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Distribution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Distribution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Distribution update(Distribution distribution)
		throws SystemException {
		return getPersistence().update(distribution);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Distribution update(Distribution distribution,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(distribution, serviceContext);
	}

	/**
	* Returns all the distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @return the matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByG_C_V_C(
		long groupId, long contentId, int version, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V_C(groupId, contentId, version, categoryId);
	}

	/**
	* Returns a range of all the distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByG_C_V_C(
		long groupId, long contentId, int version, long categoryId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V_C(groupId, contentId, version, categoryId,
			start, end);
	}

	/**
	* Returns an ordered range of all the distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByG_C_V_C(
		long groupId, long contentId, int version, long categoryId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V_C(groupId, contentId, version, categoryId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution findByG_C_V_C_First(
		long groupId, long contentId, int version, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByG_C_V_C_First(groupId, contentId, version,
			categoryId, orderByComparator);
	}

	/**
	* Returns the first distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution fetchByG_C_V_C_First(
		long groupId, long contentId, int version, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_V_C_First(groupId, contentId, version,
			categoryId, orderByComparator);
	}

	/**
	* Returns the last distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution findByG_C_V_C_Last(
		long groupId, long contentId, int version, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByG_C_V_C_Last(groupId, contentId, version, categoryId,
			orderByComparator);
	}

	/**
	* Returns the last distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution fetchByG_C_V_C_Last(
		long groupId, long contentId, int version, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_V_C_Last(groupId, contentId, version,
			categoryId, orderByComparator);
	}

	/**
	* Returns the distributions before and after the current distribution in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param distributionId the primary key of the current distribution
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution[] findByG_C_V_C_PrevAndNext(
		long distributionId, long groupId, long contentId, int version,
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByG_C_V_C_PrevAndNext(distributionId, groupId,
			contentId, version, categoryId, orderByComparator);
	}

	/**
	* Returns all the distributions that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @return the matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByG_C_V_C(
		long groupId, long contentId, int version, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_V_C(groupId, contentId, version, categoryId);
	}

	/**
	* Returns a range of all the distributions that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByG_C_V_C(
		long groupId, long contentId, int version, long categoryId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_V_C(groupId, contentId, version,
			categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the distributions that the user has permissions to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByG_C_V_C(
		long groupId, long contentId, int version, long categoryId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_V_C(groupId, contentId, version,
			categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the distributions before and after the current distribution in the ordered set of distributions that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param distributionId the primary key of the current distribution
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution[] filterFindByG_C_V_C_PrevAndNext(
		long distributionId, long groupId, long contentId, int version,
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .filterFindByG_C_V_C_PrevAndNext(distributionId, groupId,
			contentId, version, categoryId, orderByComparator);
	}

	/**
	* Removes all the distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_V_C(long groupId, long contentId,
		int version, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_V_C(groupId, contentId, version, categoryId);
	}

	/**
	* Returns the number of distributions where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @return the number of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_V_C(long groupId, long contentId, int version,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_C_V_C(groupId, contentId, version, categoryId);
	}

	/**
	* Returns the number of distributions that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param categoryId the category ID
	* @return the number of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C_V_C(long groupId, long contentId,
		int version, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_C_V_C(groupId, contentId, version, categoryId);
	}

	/**
	* Returns all the distributions where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByByGroupNCategory(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByGroupNCategory(groupId, categoryId);
	}

	/**
	* Returns a range of all the distributions where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByByGroupNCategory(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByGroupNCategory(groupId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the distributions where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByByGroupNCategory(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByGroupNCategory(groupId, categoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution findByByGroupNCategory_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByByGroupNCategory_First(groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the first distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution fetchByByGroupNCategory_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByByGroupNCategory_First(groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the last distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution findByByGroupNCategory_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByByGroupNCategory_Last(groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the last distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution fetchByByGroupNCategory_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByByGroupNCategory_Last(groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the distributions before and after the current distribution in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param distributionId the primary key of the current distribution
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution[] findByByGroupNCategory_PrevAndNext(
		long distributionId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByByGroupNCategory_PrevAndNext(distributionId, groupId,
			categoryId, orderByComparator);
	}

	/**
	* Returns all the distributions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByByGroupNCategory(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByByGroupNCategory(groupId, categoryId);
	}

	/**
	* Returns a range of all the distributions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByByGroupNCategory(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByByGroupNCategory(groupId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the distributions that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByByGroupNCategory(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByByGroupNCategory(groupId, categoryId, start,
			end, orderByComparator);
	}

	/**
	* Returns the distributions before and after the current distribution in the ordered set of distributions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param distributionId the primary key of the current distribution
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution[] filterFindByByGroupNCategory_PrevAndNext(
		long distributionId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .filterFindByByGroupNCategory_PrevAndNext(distributionId,
			groupId, categoryId, orderByComparator);
	}

	/**
	* Removes all the distributions where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByGroupNCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByGroupNCategory(groupId, categoryId);
	}

	/**
	* Returns the number of distributions where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByGroupNCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByGroupNCategory(groupId, categoryId);
	}

	/**
	* Returns the number of distributions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByByGroupNCategory(long groupId,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByByGroupNCategory(groupId, categoryId);
	}

	/**
	* Returns all the distributions where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByGroupContentId(
		long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupContentId(groupId, contentId);
	}

	/**
	* Returns a range of all the distributions where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByGroupContentId(
		long groupId, long contentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupContentId(groupId, contentId, start, end);
	}

	/**
	* Returns an ordered range of all the distributions where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findByGroupContentId(
		long groupId, long contentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupContentId(groupId, contentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution findByGroupContentId_First(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByGroupContentId_First(groupId, contentId,
			orderByComparator);
	}

	/**
	* Returns the first distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution fetchByGroupContentId_First(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupContentId_First(groupId, contentId,
			orderByComparator);
	}

	/**
	* Returns the last distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution findByGroupContentId_Last(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByGroupContentId_Last(groupId, contentId,
			orderByComparator);
	}

	/**
	* Returns the last distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution fetchByGroupContentId_Last(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupContentId_Last(groupId, contentId,
			orderByComparator);
	}

	/**
	* Returns the distributions before and after the current distribution in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param distributionId the primary key of the current distribution
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution[] findByGroupContentId_PrevAndNext(
		long distributionId, long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .findByGroupContentId_PrevAndNext(distributionId, groupId,
			contentId, orderByComparator);
	}

	/**
	* Returns all the distributions that the user has permission to view where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByGroupContentId(
		long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupContentId(groupId, contentId);
	}

	/**
	* Returns a range of all the distributions that the user has permission to view where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByGroupContentId(
		long groupId, long contentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupContentId(groupId, contentId, start, end);
	}

	/**
	* Returns an ordered range of all the distributions that the user has permissions to view where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> filterFindByGroupContentId(
		long groupId, long contentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupContentId(groupId, contentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the distributions before and after the current distribution in the ordered set of distributions that the user has permission to view where groupId = &#63; and contentId = &#63;.
	*
	* @param distributionId the primary key of the current distribution
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution[] filterFindByGroupContentId_PrevAndNext(
		long distributionId, long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence()
				   .filterFindByGroupContentId_PrevAndNext(distributionId,
			groupId, contentId, orderByComparator);
	}

	/**
	* Removes all the distributions where groupId = &#63; and contentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupContentId(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupContentId(groupId, contentId);
	}

	/**
	* Returns the number of distributions where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the number of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupContentId(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupContentId(groupId, contentId);
	}

	/**
	* Returns the number of distributions that the user has permission to view where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the number of matching distributions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupContentId(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupContentId(groupId, contentId);
	}

	/**
	* Caches the distribution in the entity cache if it is enabled.
	*
	* @param distribution the distribution
	*/
	public static void cacheResult(
		com.viettel.portal.vcms.model.Distribution distribution) {
		getPersistence().cacheResult(distribution);
	}

	/**
	* Caches the distributions in the entity cache if it is enabled.
	*
	* @param distributions the distributions
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Distribution> distributions) {
		getPersistence().cacheResult(distributions);
	}

	/**
	* Creates a new distribution with the primary key. Does not add the distribution to the database.
	*
	* @param distributionId the primary key for the new distribution
	* @return the new distribution
	*/
	public static com.viettel.portal.vcms.model.Distribution create(
		long distributionId) {
		return getPersistence().create(distributionId);
	}

	/**
	* Removes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution that was removed
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution remove(
		long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence().remove(distributionId);
	}

	public static com.viettel.portal.vcms.model.Distribution updateImpl(
		com.viettel.portal.vcms.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(distribution);
	}

	/**
	* Returns the distribution with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchDistributionException} if it could not be found.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution
	* @throws com.viettel.portal.vcms.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution findByPrimaryKey(
		long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionException {
		return getPersistence().findByPrimaryKey(distributionId);
	}

	/**
	* Returns the distribution with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution, or <code>null</code> if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Distribution fetchByPrimaryKey(
		long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(distributionId);
	}

	/**
	* Returns all the distributions.
	*
	* @return the distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Distribution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the distributions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of distributions.
	*
	* @return the number of distributions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DistributionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DistributionPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					DistributionPersistence.class.getName());

			ReferenceRegistry.registerReference(DistributionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DistributionPersistence persistence) {
	}

	private static DistributionPersistence _persistence;
}