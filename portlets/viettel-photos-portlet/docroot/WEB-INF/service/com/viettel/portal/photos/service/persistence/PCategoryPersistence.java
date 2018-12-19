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

package com.viettel.portal.photos.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.photos.model.PCategory;

/**
 * The persistence interface for the p category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see PCategoryPersistenceImpl
 * @see PCategoryUtil
 * @generated
 */
public interface PCategoryPersistence extends BasePersistence<PCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PCategoryUtil} to access the p category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p categories where status = &#63;.
	*
	* @param status the status
	* @return the matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findBystatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p categories where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p categories where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p category in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the first p category in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p category in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the last p category in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p categories before and after the current p category in the ordered set where status = &#63;.
	*
	* @param id the primary key of the current p category
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory[] findBystatus_PrevAndNext(
		long id, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Removes all the p categories where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p categories where status = &#63;.
	*
	* @param status the status
	* @return the number of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public int countBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p categories where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndStatus(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p categories where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndStatus(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p categories where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndStatus(
		long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the first p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the last p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p categories before and after the current p category in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current p category
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory[] findByGroupAndStatus_PrevAndNext(
		long id, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Removes all the p categories where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p categories where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p categories where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndName(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p categories where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndName(
		long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p categories where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroupAndName(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findByGroupAndName_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the first p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchByGroupAndName_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findByGroupAndName_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the last p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchByGroupAndName_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p categories before and after the current p category in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param id the primary key of the current p category
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory[] findByGroupAndName_PrevAndNext(
		long id, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Removes all the p categories where groupId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndName(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p categories where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndName(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the first p category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the last p category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p category, or <code>null</code> if a matching p category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p categories before and after the current p category in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current p category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Removes all the p categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching p categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p category in the entity cache if it is enabled.
	*
	* @param pCategory the p category
	*/
	public void cacheResult(com.viettel.portal.photos.model.PCategory pCategory);

	/**
	* Caches the p categories in the entity cache if it is enabled.
	*
	* @param pCategories the p categories
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.photos.model.PCategory> pCategories);

	/**
	* Creates a new p category with the primary key. Does not add the p category to the database.
	*
	* @param id the primary key for the new p category
	* @return the new p category
	*/
	public com.viettel.portal.photos.model.PCategory create(long id);

	/**
	* Removes the p category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the p category
	* @return the p category that was removed
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	public com.viettel.portal.photos.model.PCategory updateImpl(
		com.viettel.portal.photos.model.PCategory pCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p category with the primary key or throws a {@link com.viettel.portal.photos.NoSuchPCategoryException} if it could not be found.
	*
	* @param id the primary key of the p category
	* @return the p category
	* @throws com.viettel.portal.photos.NoSuchPCategoryException if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.photos.NoSuchPCategoryException;

	/**
	* Returns the p category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the p category
	* @return the p category, or <code>null</code> if a p category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.photos.model.PCategory fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p categories.
	*
	* @return the p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @return the range of p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p categories
	* @param end the upper bound of the range of p categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.photos.model.PCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p categories.
	*
	* @return the number of p categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}