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

import com.viettel.portal.vcms.model.DistributionVisisted;

import java.util.List;

/**
 * The persistence utility for the distribution visisted service. This utility wraps {@link DistributionVisistedPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see DistributionVisistedPersistence
 * @see DistributionVisistedPersistenceImpl
 * @generated
 */
public class DistributionVisistedUtil {
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
	public static void clearCache(DistributionVisisted distributionVisisted) {
		getPersistence().clearCache(distributionVisisted);
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
	public static List<DistributionVisisted> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DistributionVisisted> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DistributionVisisted> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DistributionVisisted update(
		DistributionVisisted distributionVisisted) throws SystemException {
		return getPersistence().update(distributionVisisted);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DistributionVisisted update(
		DistributionVisisted distributionVisisted, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(distributionVisisted, serviceContext);
	}

	/**
	* Returns all the distribution visisteds where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @return the matching distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findByG_D(
		long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_D(groupId, distributionId);
	}

	/**
	* Returns a range of all the distribution visisteds where groupId = &#63; and distributionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param start the lower bound of the range of distribution visisteds
	* @param end the upper bound of the range of distribution visisteds (not inclusive)
	* @return the range of matching distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findByG_D(
		long groupId, long distributionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_D(groupId, distributionId, start, end);
	}

	/**
	* Returns an ordered range of all the distribution visisteds where groupId = &#63; and distributionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param start the lower bound of the range of distribution visisteds
	* @param end the upper bound of the range of distribution visisteds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findByG_D(
		long groupId, long distributionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_D(groupId, distributionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution visisted
	* @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a matching distribution visisted could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted findByG_D_First(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException {
		return getPersistence()
				   .findByG_D_First(groupId, distributionId, orderByComparator);
	}

	/**
	* Returns the first distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution visisted, or <code>null</code> if a matching distribution visisted could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted fetchByG_D_First(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_D_First(groupId, distributionId, orderByComparator);
	}

	/**
	* Returns the last distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution visisted
	* @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a matching distribution visisted could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted findByG_D_Last(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException {
		return getPersistence()
				   .findByG_D_Last(groupId, distributionId, orderByComparator);
	}

	/**
	* Returns the last distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution visisted, or <code>null</code> if a matching distribution visisted could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted fetchByG_D_Last(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_D_Last(groupId, distributionId, orderByComparator);
	}

	/**
	* Returns the distribution visisteds before and after the current distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param visistedId the primary key of the current distribution visisted
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next distribution visisted
	* @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted[] findByG_D_PrevAndNext(
		long visistedId, long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException {
		return getPersistence()
				   .findByG_D_PrevAndNext(visistedId, groupId, distributionId,
			orderByComparator);
	}

	/**
	* Removes all the distribution visisteds where groupId = &#63; and distributionId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_D(long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_D(groupId, distributionId);
	}

	/**
	* Returns the number of distribution visisteds where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @return the number of matching distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_D(long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_D(groupId, distributionId);
	}

	/**
	* Caches the distribution visisted in the entity cache if it is enabled.
	*
	* @param distributionVisisted the distribution visisted
	*/
	public static void cacheResult(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted) {
		getPersistence().cacheResult(distributionVisisted);
	}

	/**
	* Caches the distribution visisteds in the entity cache if it is enabled.
	*
	* @param distributionVisisteds the distribution visisteds
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> distributionVisisteds) {
		getPersistence().cacheResult(distributionVisisteds);
	}

	/**
	* Creates a new distribution visisted with the primary key. Does not add the distribution visisted to the database.
	*
	* @param visistedId the primary key for the new distribution visisted
	* @return the new distribution visisted
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted create(
		long visistedId) {
		return getPersistence().create(visistedId);
	}

	/**
	* Removes the distribution visisted with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visistedId the primary key of the distribution visisted
	* @return the distribution visisted that was removed
	* @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted remove(
		long visistedId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException {
		return getPersistence().remove(visistedId);
	}

	public static com.viettel.portal.vcms.model.DistributionVisisted updateImpl(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(distributionVisisted);
	}

	/**
	* Returns the distribution visisted with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchDistributionVisistedException} if it could not be found.
	*
	* @param visistedId the primary key of the distribution visisted
	* @return the distribution visisted
	* @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted findByPrimaryKey(
		long visistedId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException {
		return getPersistence().findByPrimaryKey(visistedId);
	}

	/**
	* Returns the distribution visisted with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param visistedId the primary key of the distribution visisted
	* @return the distribution visisted, or <code>null</code> if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.DistributionVisisted fetchByPrimaryKey(
		long visistedId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(visistedId);
	}

	/**
	* Returns all the distribution visisteds.
	*
	* @return the distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the distribution visisteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distribution visisteds
	* @param end the upper bound of the range of distribution visisteds (not inclusive)
	* @return the range of distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the distribution visisteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distribution visisteds
	* @param end the upper bound of the range of distribution visisteds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the distribution visisteds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of distribution visisteds.
	*
	* @return the number of distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DistributionVisistedPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DistributionVisistedPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					DistributionVisistedPersistence.class.getName());

			ReferenceRegistry.registerReference(DistributionVisistedUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DistributionVisistedPersistence persistence) {
	}

	private static DistributionVisistedPersistence _persistence;
}