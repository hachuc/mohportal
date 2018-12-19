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

import com.viettel.portal.thongke.model.PhongBanNhuanBut;

/**
 * The persistence interface for the phong ban nhuan but service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanNhuanButPersistenceImpl
 * @see PhongBanNhuanButUtil
 * @generated
 */
public interface PhongBanNhuanButPersistence extends BasePersistence<PhongBanNhuanBut> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhongBanNhuanButUtil} to access the phong ban nhuan but persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the phong ban nhuan buts where status = &#63;.
	*
	* @param status the status
	* @return the matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findBystatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong ban nhuan buts where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @return the range of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong ban nhuan buts where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the first phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the last phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong ban nhuan buts before and after the current phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param id the primary key of the current phong ban nhuan but
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut[] findBystatus_PrevAndNext(
		long id, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Removes all the phong ban nhuan buts where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong ban nhuan buts where status = &#63;.
	*
	* @param status the status
	* @return the number of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong ban nhuan buts where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndStatus(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong ban nhuan buts where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @return the range of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndStatus(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong ban nhuan buts where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndStatus(
		long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong ban nhuan buts before and after the current phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current phong ban nhuan but
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut[] findByGroupAndStatus_PrevAndNext(
		long id, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Removes all the phong ban nhuan buts where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong ban nhuan buts where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @return the matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndCaption(
		long groupId, java.lang.String caption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param caption the caption
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @return the range of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndCaption(
		long groupId, java.lang.String caption, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param caption the caption
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndCaption(
		long groupId, java.lang.String caption, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroupAndCaption_First(
		long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroupAndCaption_First(
		long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroupAndCaption_Last(
		long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroupAndCaption_Last(
		long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong ban nhuan buts before and after the current phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	*
	* @param id the primary key of the current phong ban nhuan but
	* @param groupId the group ID
	* @param caption the caption
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut[] findByGroupAndCaption_PrevAndNext(
		long id, long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Removes all the phong ban nhuan buts where groupId = &#63; and caption = &#63; from the database.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndCaption(long groupId, java.lang.String caption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @return the number of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndCaption(long groupId, java.lang.String caption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong ban nhuan buts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong ban nhuan buts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @return the range of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong ban nhuan buts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong ban nhuan buts before and after the current phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current phong ban nhuan but
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Removes all the phong ban nhuan buts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong ban nhuan buts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the phong ban nhuan but in the entity cache if it is enabled.
	*
	* @param phongBanNhuanBut the phong ban nhuan but
	*/
	public void cacheResult(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut);

	/**
	* Caches the phong ban nhuan buts in the entity cache if it is enabled.
	*
	* @param phongBanNhuanButs the phong ban nhuan buts
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> phongBanNhuanButs);

	/**
	* Creates a new phong ban nhuan but with the primary key. Does not add the phong ban nhuan but to the database.
	*
	* @param id the primary key for the new phong ban nhuan but
	* @return the new phong ban nhuan but
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut create(long id);

	/**
	* Removes the phong ban nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the phong ban nhuan but
	* @return the phong ban nhuan but that was removed
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	public com.viettel.portal.thongke.model.PhongBanNhuanBut updateImpl(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong ban nhuan but with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanNhuanButException} if it could not be found.
	*
	* @param id the primary key of the phong ban nhuan but
	* @return the phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException;

	/**
	* Returns the phong ban nhuan but with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the phong ban nhuan but
	* @return the phong ban nhuan but, or <code>null</code> if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong ban nhuan buts.
	*
	* @return the phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phong ban nhuan buts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @return the range of phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phong ban nhuan buts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phong ban nhuan buts
	* @param end the upper bound of the range of phong ban nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the phong ban nhuan buts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong ban nhuan buts.
	*
	* @return the number of phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}