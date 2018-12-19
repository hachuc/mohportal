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

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.vcms.model.DistributionVisisted;

/**
 * The persistence interface for the distribution visisted service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see DistributionVisistedPersistenceImpl
 * @see DistributionVisistedUtil
 * @generated
 */
public interface DistributionVisistedPersistence extends BasePersistence<DistributionVisisted> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DistributionVisistedUtil} to access the distribution visisted persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the distribution visisteds where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @return the matching distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findByG_D(
		long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findByG_D(
		long groupId, long distributionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findByG_D(
		long groupId, long distributionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.vcms.model.DistributionVisisted findByG_D_First(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException;

	/**
	* Returns the first distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution visisted, or <code>null</code> if a matching distribution visisted could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.DistributionVisisted fetchByG_D_First(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.vcms.model.DistributionVisisted findByG_D_Last(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException;

	/**
	* Returns the last distribution visisted in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution visisted, or <code>null</code> if a matching distribution visisted could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.DistributionVisisted fetchByG_D_Last(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.vcms.model.DistributionVisisted[] findByG_D_PrevAndNext(
		long visistedId, long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException;

	/**
	* Removes all the distribution visisteds where groupId = &#63; and distributionId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_D(long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of distribution visisteds where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @return the number of matching distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_D(long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the distribution visisted in the entity cache if it is enabled.
	*
	* @param distributionVisisted the distribution visisted
	*/
	public void cacheResult(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted);

	/**
	* Caches the distribution visisteds in the entity cache if it is enabled.
	*
	* @param distributionVisisteds the distribution visisteds
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> distributionVisisteds);

	/**
	* Creates a new distribution visisted with the primary key. Does not add the distribution visisted to the database.
	*
	* @param visistedId the primary key for the new distribution visisted
	* @return the new distribution visisted
	*/
	public com.viettel.portal.vcms.model.DistributionVisisted create(
		long visistedId);

	/**
	* Removes the distribution visisted with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visistedId the primary key of the distribution visisted
	* @return the distribution visisted that was removed
	* @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.DistributionVisisted remove(
		long visistedId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException;

	public com.viettel.portal.vcms.model.DistributionVisisted updateImpl(
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the distribution visisted with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchDistributionVisistedException} if it could not be found.
	*
	* @param visistedId the primary key of the distribution visisted
	* @return the distribution visisted
	* @throws com.viettel.portal.vcms.NoSuchDistributionVisistedException if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.DistributionVisisted findByPrimaryKey(
		long visistedId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchDistributionVisistedException;

	/**
	* Returns the distribution visisted with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param visistedId the primary key of the distribution visisted
	* @return the distribution visisted, or <code>null</code> if a distribution visisted with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.DistributionVisisted fetchByPrimaryKey(
		long visistedId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the distribution visisteds.
	*
	* @return the distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.DistributionVisisted> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the distribution visisteds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of distribution visisteds.
	*
	* @return the number of distribution visisteds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}