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

package com.viettel.portal.thongke.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.thongke.model.ContentTypeCost;

/**
 * The persistence interface for the content type cost service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see ContentTypeCostPersistenceImpl
 * @see ContentTypeCostUtil
 * @generated
 */
public interface ContentTypeCostPersistence extends BasePersistence<ContentTypeCost> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentTypeCostUtil} to access the content type cost persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the content type costs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.ContentTypeCost> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content type costs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @return the range of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.ContentTypeCost> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the content type costs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.ContentTypeCost> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content type cost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type cost
	* @throws com.viettel.portal.thongke.NoSuchContentTypeCostException if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchContentTypeCostException;

	/**
	* Returns the first content type cost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type cost, or <code>null</code> if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content type cost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type cost
	* @throws com.viettel.portal.thongke.NoSuchContentTypeCostException if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchContentTypeCostException;

	/**
	* Returns the last content type cost in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type cost, or <code>null</code> if a matching content type cost could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content type costs before and after the current content type cost in the ordered set where groupId = &#63;.
	*
	* @param costId the primary key of the current content type cost
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content type cost
	* @throws com.viettel.portal.thongke.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost[] findByGroupId_PrevAndNext(
		int costId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchContentTypeCostException;

	/**
	* Removes all the content type costs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content type costs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching content type costs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the content type cost in the entity cache if it is enabled.
	*
	* @param contentTypeCost the content type cost
	*/
	public void cacheResult(
		com.viettel.portal.thongke.model.ContentTypeCost contentTypeCost);

	/**
	* Caches the content type costs in the entity cache if it is enabled.
	*
	* @param contentTypeCosts the content type costs
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.ContentTypeCost> contentTypeCosts);

	/**
	* Creates a new content type cost with the primary key. Does not add the content type cost to the database.
	*
	* @param costId the primary key for the new content type cost
	* @return the new content type cost
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost create(int costId);

	/**
	* Removes the content type cost with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param costId the primary key of the content type cost
	* @return the content type cost that was removed
	* @throws com.viettel.portal.thongke.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost remove(int costId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchContentTypeCostException;

	public com.viettel.portal.thongke.model.ContentTypeCost updateImpl(
		com.viettel.portal.thongke.model.ContentTypeCost contentTypeCost)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content type cost with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchContentTypeCostException} if it could not be found.
	*
	* @param costId the primary key of the content type cost
	* @return the content type cost
	* @throws com.viettel.portal.thongke.NoSuchContentTypeCostException if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost findByPrimaryKey(
		int costId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchContentTypeCostException;

	/**
	* Returns the content type cost with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param costId the primary key of the content type cost
	* @return the content type cost, or <code>null</code> if a content type cost with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.ContentTypeCost fetchByPrimaryKey(
		int costId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content type costs.
	*
	* @return the content type costs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.ContentTypeCost> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content type costs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @return the range of content type costs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.ContentTypeCost> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the content type costs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.ContentTypeCostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content type costs
	* @param end the upper bound of the range of content type costs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of content type costs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.ContentTypeCost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the content type costs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content type costs.
	*
	* @return the number of content type costs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}