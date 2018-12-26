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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.vbpq.model.LoaiVanBan;

import java.util.List;

/**
 * The persistence utility for the loai van ban service. This utility wraps {@link LoaiVanBanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see LoaiVanBanPersistence
 * @see LoaiVanBanPersistenceImpl
 * @generated
 */
public class LoaiVanBanUtil {
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
	public static void clearCache(LoaiVanBan loaiVanBan) {
		getPersistence().clearCache(loaiVanBan);
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
	public static List<LoaiVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LoaiVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LoaiVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LoaiVanBan update(LoaiVanBan loaiVanBan)
		throws SystemException {
		return getPersistence().update(loaiVanBan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LoaiVanBan update(LoaiVanBan loaiVanBan,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(loaiVanBan, serviceContext);
	}

	/**
	* Returns all the loai van bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByG_(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_(groupId);
	}

	/**
	* Returns a range of all the loai van bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @return the range of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByG_(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the loai van bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first loai van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan findByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence().findByG__First(groupId, orderByComparator);
	}

	/**
	* Returns the first loai van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG__First(groupId, orderByComparator);
	}

	/**
	* Returns the last loai van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan findByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence().findByG__Last(groupId, orderByComparator);
	}

	/**
	* Returns the last loai van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG__Last(groupId, orderByComparator);
	}

	/**
	* Returns the loai van bans before and after the current loai van ban in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current loai van ban
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan[] findByG__PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence()
				   .findByG__PrevAndNext(id, groupId, orderByComparator);
	}

	/**
	* Removes all the loai van bans where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_(groupId);
	}

	/**
	* Returns the number of loai van bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_(groupId);
	}

	/**
	* Returns all the loai van bans where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @return the matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByTrangThai(
		boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(trangThai, groupId);
	}

	/**
	* Returns a range of all the loai van bans where trangThai = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @return the range of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByTrangThai(
		boolean trangThai, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(trangThai, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the loai van bans where trangThai = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByTrangThai(
		boolean trangThai, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(trangThai, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan findByTrangThai_First(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence()
				   .findByTrangThai_First(trangThai, groupId, orderByComparator);
	}

	/**
	* Returns the first loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByTrangThai_First(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTrangThai_First(trangThai, groupId, orderByComparator);
	}

	/**
	* Returns the last loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan findByTrangThai_Last(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence()
				   .findByTrangThai_Last(trangThai, groupId, orderByComparator);
	}

	/**
	* Returns the last loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByTrangThai_Last(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTrangThai_Last(trangThai, groupId, orderByComparator);
	}

	/**
	* Returns the loai van bans before and after the current loai van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current loai van ban
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan[] findByTrangThai_PrevAndNext(
		long id, boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, trangThai, groupId,
			orderByComparator);
	}

	/**
	* Removes all the loai van bans where trangThai = &#63; and groupId = &#63; from the database.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(trangThai, groupId);
	}

	/**
	* Returns the number of loai van bans where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @return the number of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(trangThai, groupId);
	}

	/**
	* Returns the loai van ban where groupId = &#63; and ten = &#63; or throws a {@link com.viettel.portal.vbpq.NoSuchLoaiVanBanException} if it could not be found.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the matching loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan findByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence().findByGroupId_Ten(groupId, ten);
	}

	/**
	* Returns the loai van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Ten(groupId, ten);
	}

	/**
	* Returns the loai van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByGroupId_Ten(
		long groupId, java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_Ten(groupId, ten, retrieveFromCache);
	}

	/**
	* Removes the loai van ban where groupId = &#63; and ten = &#63; from the database.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the loai van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan removeByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence().removeByGroupId_Ten(groupId, ten);
	}

	/**
	* Returns the number of loai van bans where groupId = &#63; and ten = &#63;.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the number of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId_Ten(long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId_Ten(groupId, ten);
	}

	/**
	* Returns all the loai van bans where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @return the matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByNhomVanBanId(
		long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNhomVanBanId(nhomVanBanId);
	}

	/**
	* Returns a range of all the loai van bans where nhomVanBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @return the range of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByNhomVanBanId(
		long nhomVanBanId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNhomVanBanId(nhomVanBanId, start, end);
	}

	/**
	* Returns an ordered range of all the loai van bans where nhomVanBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findByNhomVanBanId(
		long nhomVanBanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNhomVanBanId(nhomVanBanId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first loai van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan findByNhomVanBanId_First(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence()
				   .findByNhomVanBanId_First(nhomVanBanId, orderByComparator);
	}

	/**
	* Returns the first loai van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByNhomVanBanId_First(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNhomVanBanId_First(nhomVanBanId, orderByComparator);
	}

	/**
	* Returns the last loai van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan findByNhomVanBanId_Last(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence()
				   .findByNhomVanBanId_Last(nhomVanBanId, orderByComparator);
	}

	/**
	* Returns the last loai van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loai van ban, or <code>null</code> if a matching loai van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByNhomVanBanId_Last(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNhomVanBanId_Last(nhomVanBanId, orderByComparator);
	}

	/**
	* Returns the loai van bans before and after the current loai van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param id the primary key of the current loai van ban
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan[] findByNhomVanBanId_PrevAndNext(
		long id, long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence()
				   .findByNhomVanBanId_PrevAndNext(id, nhomVanBanId,
			orderByComparator);
	}

	/**
	* Removes all the loai van bans where nhomVanBanId = &#63; from the database.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNhomVanBanId(long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNhomVanBanId(nhomVanBanId);
	}

	/**
	* Returns the number of loai van bans where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @return the number of matching loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNhomVanBanId(long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNhomVanBanId(nhomVanBanId);
	}

	/**
	* Caches the loai van ban in the entity cache if it is enabled.
	*
	* @param loaiVanBan the loai van ban
	*/
	public static void cacheResult(
		com.viettel.portal.vbpq.model.LoaiVanBan loaiVanBan) {
		getPersistence().cacheResult(loaiVanBan);
	}

	/**
	* Caches the loai van bans in the entity cache if it is enabled.
	*
	* @param loaiVanBans the loai van bans
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> loaiVanBans) {
		getPersistence().cacheResult(loaiVanBans);
	}

	/**
	* Creates a new loai van ban with the primary key. Does not add the loai van ban to the database.
	*
	* @param id the primary key for the new loai van ban
	* @return the new loai van ban
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the loai van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loai van ban
	* @return the loai van ban that was removed
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.vbpq.model.LoaiVanBan updateImpl(
		com.viettel.portal.vbpq.model.LoaiVanBan loaiVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(loaiVanBan);
	}

	/**
	* Returns the loai van ban with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchLoaiVanBanException} if it could not be found.
	*
	* @param id the primary key of the loai van ban
	* @return the loai van ban
	* @throws com.viettel.portal.vbpq.NoSuchLoaiVanBanException if a loai van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchLoaiVanBanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the loai van ban with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the loai van ban
	* @return the loai van ban, or <code>null</code> if a loai van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.LoaiVanBan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the loai van bans.
	*
	* @return the loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the loai van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @return the range of loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the loai van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.LoaiVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loai van bans
	* @param end the upper bound of the range of loai van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.LoaiVanBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the loai van bans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of loai van bans.
	*
	* @return the number of loai van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LoaiVanBanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LoaiVanBanPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vbpq.service.ClpSerializer.getServletContextName(),
					LoaiVanBanPersistence.class.getName());

			ReferenceRegistry.registerReference(LoaiVanBanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LoaiVanBanPersistence persistence) {
	}

	private static LoaiVanBanPersistence _persistence;
}