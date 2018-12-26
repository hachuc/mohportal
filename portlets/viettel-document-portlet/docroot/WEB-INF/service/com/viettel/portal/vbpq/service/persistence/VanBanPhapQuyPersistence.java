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

import com.viettel.portal.vbpq.model.VanBanPhapQuy;

/**
 * The persistence interface for the van ban phap quy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VanBanPhapQuyPersistenceImpl
 * @see VanBanPhapQuyUtil
 * @generated
 */
public interface VanBanPhapQuyPersistence extends BasePersistence<VanBanPhapQuy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VanBanPhapQuyUtil} to access the van ban phap quy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the van ban phap quies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByGroupId(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban phap quies where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @return the range of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByGroupId(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban phap quies where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByGroupId(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy findByGroupId_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the first van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByGroupId_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy findByGroupId_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the last van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByGroupId_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the van ban phap quies before and after the current van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current van ban phap quy
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy[] findByGroupId_PrevAndNext(
		long id, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Removes all the van ban phap quies where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban phap quies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or throws a {@link com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException} if it could not be found.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @return the matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy findByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @return the matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the van ban phap quy where groupId = &#63; and maVanBan = &#63; from the database.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @return the van ban phap quy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy removeByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the number of van ban phap quies where groupId = &#63; and maVanBan = &#63;.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @return the number of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId_MaVanBan(long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the van ban phap quies where status = &#63;.
	*
	* @param status the status
	* @return the matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban phap quies where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @return the range of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban phap quies where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban phap quy in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the first van ban phap quy in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last van ban phap quy in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the last van ban phap quy in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the van ban phap quies before and after the current van ban phap quy in the ordered set where status = &#63;.
	*
	* @param id the primary key of the current van ban phap quy
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy[] findByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Removes all the van ban phap quies where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban phap quies where status = &#63;.
	*
	* @param status the status
	* @return the number of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @return the matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @return the range of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy findByG_CQBH_S_First(
		long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the first van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByG_CQBH_S_First(
		long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy findByG_CQBH_S_Last(
		long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the last van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByG_CQBH_S_Last(
		long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the van ban phap quies before and after the current van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param id the primary key of the current van ban phap quy
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy[] findByG_CQBH_S_PrevAndNext(
		long id, long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Removes all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_CQBH_S(long groupId, long coQuanBanHanh, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @return the number of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_CQBH_S(long groupId, long coQuanBanHanh, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the van ban phap quy in the entity cache if it is enabled.
	*
	* @param vanBanPhapQuy the van ban phap quy
	*/
	public void cacheResult(
		com.viettel.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy);

	/**
	* Caches the van ban phap quies in the entity cache if it is enabled.
	*
	* @param vanBanPhapQuies the van ban phap quies
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> vanBanPhapQuies);

	/**
	* Creates a new van ban phap quy with the primary key. Does not add the van ban phap quy to the database.
	*
	* @param id the primary key for the new van ban phap quy
	* @return the new van ban phap quy
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy create(long id);

	/**
	* Removes the van ban phap quy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy that was removed
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	public com.viettel.portal.vbpq.model.VanBanPhapQuy updateImpl(
		com.viettel.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the van ban phap quy with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException} if it could not be found.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException;

	/**
	* Returns the van ban phap quy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy, or <code>null</code> if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the van ban phap quies.
	*
	* @return the van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban phap quies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @return the range of van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban phap quies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of van ban phap quies
	* @param end the upper bound of the range of van ban phap quies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban phap quies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban phap quies.
	*
	* @return the number of van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}