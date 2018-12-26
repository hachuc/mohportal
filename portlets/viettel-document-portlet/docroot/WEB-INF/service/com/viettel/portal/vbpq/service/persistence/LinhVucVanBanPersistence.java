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

package com.viettel.portal.vbpq.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.vbpq.model.LinhVucVanBan;

/**
 * The persistence interface for the linh vuc van ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see LinhVucVanBanPersistenceImpl
 * @see LinhVucVanBanUtil
 * @generated
 */
public interface LinhVucVanBanPersistence extends BasePersistence<LinhVucVanBan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinhVucVanBanUtil} to access the linh vuc van ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the linh vuc van bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByG_(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the linh vuc van bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @return the range of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByG_(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the linh vuc van bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first linh vuc van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan findByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the first linh vuc van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last linh vuc van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan findByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the last linh vuc van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the linh vuc van bans before and after the current linh vuc van ban in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current linh vuc van ban
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan[] findByG__PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Removes all the linh vuc van bans where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of linh vuc van bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the linh vuc van bans where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @return the matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByTrangThai(
		boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the linh vuc van bans where trangThai = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @return the range of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByTrangThai(
		boolean trangThai, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the linh vuc van bans where trangThai = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByTrangThai(
		boolean trangThai, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan findByTrangThai_First(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the first linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByTrangThai_First(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan findByTrangThai_Last(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the last linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByTrangThai_Last(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the linh vuc van bans before and after the current linh vuc van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current linh vuc van ban
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan[] findByTrangThai_PrevAndNext(
		long id, boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Removes all the linh vuc van bans where trangThai = &#63; and groupId = &#63; from the database.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of linh vuc van bans where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @return the number of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the linh vuc van ban where groupId = &#63; and ten = &#63; or throws a {@link com.viettel.portal.vbpq.NoSuchLinhVucVanBanException} if it could not be found.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the matching linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan findByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the linh vuc van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the linh vuc van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByGroupId_Ten(
		long groupId, java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the linh vuc van ban where groupId = &#63; and ten = &#63; from the database.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the linh vuc van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan removeByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the number of linh vuc van bans where groupId = &#63; and ten = &#63;.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the number of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId_Ten(long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the linh vuc van bans where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @return the matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByNhomVanBanId(
		long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the linh vuc van bans where nhomVanBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @return the range of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByNhomVanBanId(
		long nhomVanBanId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the linh vuc van bans where nhomVanBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findByNhomVanBanId(
		long nhomVanBanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan findByNhomVanBanId_First(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the first linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByNhomVanBanId_First(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan findByNhomVanBanId_Last(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the last linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching linh vuc van ban, or <code>null</code> if a matching linh vuc van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByNhomVanBanId_Last(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the linh vuc van bans before and after the current linh vuc van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param id the primary key of the current linh vuc van ban
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan[] findByNhomVanBanId_PrevAndNext(
		long id, long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Removes all the linh vuc van bans where nhomVanBanId = &#63; from the database.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNhomVanBanId(long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of linh vuc van bans where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @return the number of matching linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public int countByNhomVanBanId(long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the linh vuc van ban in the entity cache if it is enabled.
	*
	* @param linhVucVanBan the linh vuc van ban
	*/
	public void cacheResult(
		com.viettel.portal.vbpq.model.LinhVucVanBan linhVucVanBan);

	/**
	* Caches the linh vuc van bans in the entity cache if it is enabled.
	*
	* @param linhVucVanBans the linh vuc van bans
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> linhVucVanBans);

	/**
	* Creates a new linh vuc van ban with the primary key. Does not add the linh vuc van ban to the database.
	*
	* @param id the primary key for the new linh vuc van ban
	* @return the new linh vuc van ban
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan create(long id);

	/**
	* Removes the linh vuc van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the linh vuc van ban
	* @return the linh vuc van ban that was removed
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	public com.viettel.portal.vbpq.model.LinhVucVanBan updateImpl(
		com.viettel.portal.vbpq.model.LinhVucVanBan linhVucVanBan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the linh vuc van ban with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchLinhVucVanBanException} if it could not be found.
	*
	* @param id the primary key of the linh vuc van ban
	* @return the linh vuc van ban
	* @throws com.viettel.portal.vbpq.NoSuchLinhVucVanBanException if a linh vuc van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLinhVucVanBanException;

	/**
	* Returns the linh vuc van ban with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the linh vuc van ban
	* @return the linh vuc van ban, or <code>null</code> if a linh vuc van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.LinhVucVanBan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the linh vuc van bans.
	*
	* @return the linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the linh vuc van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @return the range of linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the linh vuc van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LinhVucVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of linh vuc van bans
	* @param end the upper bound of the range of linh vuc van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.LinhVucVanBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the linh vuc van bans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of linh vuc van bans.
	*
	* @return the number of linh vuc van bans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}