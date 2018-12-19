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

import com.viettel.portal.thongke.model.BaiVietNhuanBut;

/**
 * The persistence interface for the bai viet nhuan but service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see BaiVietNhuanButPersistenceImpl
 * @see BaiVietNhuanButUtil
 * @generated
 */
public interface BaiVietNhuanButPersistence extends BasePersistence<BaiVietNhuanBut> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BaiVietNhuanButUtil} to access the bai viet nhuan but persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bai viet nhuan buts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bai viet nhuan buts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @return the range of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bai viet nhuan buts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Returns the first bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Returns the last bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bai viet nhuan buts before and after the current bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current bai viet nhuan but
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Removes all the bai viet nhuan buts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bai viet nhuan buts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bai viet nhuan buts where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroupAndType(
		long groupId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bai viet nhuan buts where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @return the range of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroupAndType(
		long groupId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bai viet nhuan buts where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroupAndType(
		long groupId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut findByGroupAndType_First(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Returns the first bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByGroupAndType_First(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut findByGroupAndType_Last(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Returns the last bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByGroupAndType_Last(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bai viet nhuan buts before and after the current bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param id the primary key of the current bai viet nhuan but
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut[] findByGroupAndType_PrevAndNext(
		long id, long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Removes all the bai viet nhuan buts where groupId = &#63; and type = &#63; from the database.
	*
	* @param groupId the group ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndType(long groupId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bai viet nhuan buts where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the number of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndType(long groupId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bai viet nhuan buts where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @return the matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByBaiVietID(
		long baiVietId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bai viet nhuan buts where baiVietId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param baiVietId the bai viet ID
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @return the range of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByBaiVietID(
		long baiVietId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bai viet nhuan buts where baiVietId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param baiVietId the bai viet ID
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByBaiVietID(
		long baiVietId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut findByBaiVietID_First(
		long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Returns the first bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByBaiVietID_First(
		long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut findByBaiVietID_Last(
		long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Returns the last bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByBaiVietID_Last(
		long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bai viet nhuan buts before and after the current bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param id the primary key of the current bai viet nhuan but
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut[] findByBaiVietID_PrevAndNext(
		long id, long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Removes all the bai viet nhuan buts where baiVietId = &#63; from the database.
	*
	* @param baiVietId the bai viet ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBaiVietID(long baiVietId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bai viet nhuan buts where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @return the number of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countByBaiVietID(long baiVietId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bai viet nhuan but in the entity cache if it is enabled.
	*
	* @param baiVietNhuanBut the bai viet nhuan but
	*/
	public void cacheResult(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut);

	/**
	* Caches the bai viet nhuan buts in the entity cache if it is enabled.
	*
	* @param baiVietNhuanButs the bai viet nhuan buts
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> baiVietNhuanButs);

	/**
	* Creates a new bai viet nhuan but with the primary key. Does not add the bai viet nhuan but to the database.
	*
	* @param id the primary key for the new bai viet nhuan but
	* @return the new bai viet nhuan but
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut create(long id);

	/**
	* Removes the bai viet nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but that was removed
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	public com.viettel.portal.thongke.model.BaiVietNhuanBut updateImpl(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bai viet nhuan but with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchBaiVietNhuanButException} if it could not be found.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException;

	/**
	* Returns the bai viet nhuan but with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but, or <code>null</code> if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bai viet nhuan buts.
	*
	* @return the bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bai viet nhuan buts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @return the range of bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bai viet nhuan buts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bai viet nhuan buts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bai viet nhuan buts.
	*
	* @return the number of bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}