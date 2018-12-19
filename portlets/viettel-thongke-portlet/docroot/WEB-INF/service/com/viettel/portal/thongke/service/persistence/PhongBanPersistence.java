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

import com.viettel.portal.thongke.model.PhongBan;

/**
 * The persistence interface for the phong ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanPersistenceImpl
 * @see PhongBanUtil
 * @generated
 */
public interface PhongBanPersistence extends BasePersistence<PhongBan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhongBanUtil} to access the phong ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the phong bans where status = &#63;.
	*
	* @param status the status
	* @return the matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findBystatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong bans where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @return the range of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong bans where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the first phong ban in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the last phong ban in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong bans before and after the current phong ban in the ordered set where status = &#63;.
	*
	* @param id the primary key of the current phong ban
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan[] findBystatus_PrevAndNext(
		long id, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Removes all the phong bans where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong bans where status = &#63;.
	*
	* @param status the status
	* @return the number of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public int countBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong bans where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndStatus(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong bans where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @return the range of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndStatus(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong bans where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndStatus(
		long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong bans before and after the current phong ban in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current phong ban
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan[] findByGroupAndStatus_PrevAndNext(
		long id, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Removes all the phong bans where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong bans where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong bans where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndName(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong bans where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @return the range of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndName(
		long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong bans where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndName(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findByGroupAndName_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchByGroupAndName_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findByGroupAndName_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchByGroupAndName_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong bans before and after the current phong ban in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param id the primary key of the current phong ban
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan[] findByGroupAndName_PrevAndNext(
		long id, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Removes all the phong bans where groupId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndName(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong bans where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndName(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @return the range of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong bans before and after the current phong ban in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current phong ban
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Removes all the phong bans where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the phong ban in the entity cache if it is enabled.
	*
	* @param phongBan the phong ban
	*/
	public void cacheResult(com.viettel.portal.thongke.model.PhongBan phongBan);

	/**
	* Caches the phong bans in the entity cache if it is enabled.
	*
	* @param phongBans the phong bans
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.PhongBan> phongBans);

	/**
	* Creates a new phong ban with the primary key. Does not add the phong ban to the database.
	*
	* @param id the primary key for the new phong ban
	* @return the new phong ban
	*/
	public com.viettel.portal.thongke.model.PhongBan create(long id);

	/**
	* Removes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the phong ban
	* @return the phong ban that was removed
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	public com.viettel.portal.thongke.model.PhongBan updateImpl(
		com.viettel.portal.thongke.model.PhongBan phongBan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong ban with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanException} if it could not be found.
	*
	* @param id the primary key of the phong ban
	* @return the phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException;

	/**
	* Returns the phong ban with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the phong ban
	* @return the phong ban, or <code>null</code> if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBan fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong bans.
	*
	* @return the phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @return the range of phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phong bans
	* @param end the upper bound of the range of phong bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of phong bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the phong bans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong bans.
	*
	* @return the number of phong bans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}