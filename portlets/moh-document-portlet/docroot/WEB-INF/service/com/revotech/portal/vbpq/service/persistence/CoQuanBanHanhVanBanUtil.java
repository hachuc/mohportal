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

package com.revotech.portal.vbpq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan;

import java.util.List;

/**
 * The persistence utility for the co quan ban hanh van ban service. This utility wraps {@link CoQuanBanHanhVanBanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see CoQuanBanHanhVanBanPersistence
 * @see CoQuanBanHanhVanBanPersistenceImpl
 * @generated
 */
public class CoQuanBanHanhVanBanUtil {
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
	public static void clearCache(CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		getPersistence().clearCache(coQuanBanHanhVanBan);
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
	public static List<CoQuanBanHanhVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CoQuanBanHanhVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CoQuanBanHanhVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CoQuanBanHanhVanBan update(
		CoQuanBanHanhVanBan coQuanBanHanhVanBan) throws SystemException {
		return getPersistence().update(coQuanBanHanhVanBan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CoQuanBanHanhVanBan update(
		CoQuanBanHanhVanBan coQuanBanHanhVanBan, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(coQuanBanHanhVanBan, serviceContext);
	}

	/**
	* Returns all the co quan ban hanh van bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByG_(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_(groupId);
	}

	/**
	* Returns a range of all the co quan ban hanh van bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @return the range of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByG_(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the co quan ban hanh van bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first co quan ban hanh van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan findByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence().findByG__First(groupId, orderByComparator);
	}

	/**
	* Returns the first co quan ban hanh van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG__First(groupId, orderByComparator);
	}

	/**
	* Returns the last co quan ban hanh van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan findByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence().findByG__Last(groupId, orderByComparator);
	}

	/**
	* Returns the last co quan ban hanh van ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG__Last(groupId, orderByComparator);
	}

	/**
	* Returns the co quan ban hanh van bans before and after the current co quan ban hanh van ban in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current co quan ban hanh van ban
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan[] findByG__PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence()
				   .findByG__PrevAndNext(id, groupId, orderByComparator);
	}

	/**
	* Removes all the co quan ban hanh van bans where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_(groupId);
	}

	/**
	* Returns the number of co quan ban hanh van bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_(groupId);
	}

	/**
	* Returns all the co quan ban hanh van bans where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @return the matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByTrangThai(
		boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(trangThai, groupId);
	}

	/**
	* Returns a range of all the co quan ban hanh van bans where trangThai = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @return the range of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByTrangThai(
		boolean trangThai, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(trangThai, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the co quan ban hanh van bans where trangThai = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByTrangThai(
		boolean trangThai, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(trangThai, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan findByTrangThai_First(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence()
				   .findByTrangThai_First(trangThai, groupId, orderByComparator);
	}

	/**
	* Returns the first co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByTrangThai_First(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTrangThai_First(trangThai, groupId, orderByComparator);
	}

	/**
	* Returns the last co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan findByTrangThai_Last(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence()
				   .findByTrangThai_Last(trangThai, groupId, orderByComparator);
	}

	/**
	* Returns the last co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByTrangThai_Last(
		boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTrangThai_Last(trangThai, groupId, orderByComparator);
	}

	/**
	* Returns the co quan ban hanh van bans before and after the current co quan ban hanh van ban in the ordered set where trangThai = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current co quan ban hanh van ban
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan[] findByTrangThai_PrevAndNext(
		long id, boolean trangThai, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, trangThai, groupId,
			orderByComparator);
	}

	/**
	* Removes all the co quan ban hanh van bans where trangThai = &#63; and groupId = &#63; from the database.
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
	* Returns the number of co quan ban hanh van bans where trangThai = &#63; and groupId = &#63;.
	*
	* @param trangThai the trang thai
	* @param groupId the group ID
	* @return the number of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(trangThai, groupId);
	}

	/**
	* Returns the co quan ban hanh van ban where groupId = &#63; and ten = &#63; or throws a {@link com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException} if it could not be found.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the matching co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan findByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence().findByGroupId_Ten(groupId, ten);
	}

	/**
	* Returns the co quan ban hanh van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Ten(groupId, ten);
	}

	/**
	* Returns the co quan ban hanh van ban where groupId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByGroupId_Ten(
		long groupId, java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_Ten(groupId, ten, retrieveFromCache);
	}

	/**
	* Removes the co quan ban hanh van ban where groupId = &#63; and ten = &#63; from the database.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the co quan ban hanh van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan removeByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence().removeByGroupId_Ten(groupId, ten);
	}

	/**
	* Returns the number of co quan ban hanh van bans where groupId = &#63; and ten = &#63;.
	*
	* @param groupId the group ID
	* @param ten the ten
	* @return the number of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId_Ten(long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId_Ten(groupId, ten);
	}

	/**
	* Returns all the co quan ban hanh van bans where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @return the matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByNhomVanBanId(
		long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNhomVanBanId(nhomVanBanId);
	}

	/**
	* Returns a range of all the co quan ban hanh van bans where nhomVanBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @return the range of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByNhomVanBanId(
		long nhomVanBanId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNhomVanBanId(nhomVanBanId, start, end);
	}

	/**
	* Returns an ordered range of all the co quan ban hanh van bans where nhomVanBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findByNhomVanBanId(
		long nhomVanBanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNhomVanBanId(nhomVanBanId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan findByNhomVanBanId_First(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence()
				   .findByNhomVanBanId_First(nhomVanBanId, orderByComparator);
	}

	/**
	* Returns the first co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByNhomVanBanId_First(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNhomVanBanId_First(nhomVanBanId, orderByComparator);
	}

	/**
	* Returns the last co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan findByNhomVanBanId_Last(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence()
				   .findByNhomVanBanId_Last(nhomVanBanId, orderByComparator);
	}

	/**
	* Returns the last co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan ban hanh van ban, or <code>null</code> if a matching co quan ban hanh van ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByNhomVanBanId_Last(
		long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNhomVanBanId_Last(nhomVanBanId, orderByComparator);
	}

	/**
	* Returns the co quan ban hanh van bans before and after the current co quan ban hanh van ban in the ordered set where nhomVanBanId = &#63;.
	*
	* @param id the primary key of the current co quan ban hanh van ban
	* @param nhomVanBanId the nhom van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan[] findByNhomVanBanId_PrevAndNext(
		long id, long nhomVanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence()
				   .findByNhomVanBanId_PrevAndNext(id, nhomVanBanId,
			orderByComparator);
	}

	/**
	* Removes all the co quan ban hanh van bans where nhomVanBanId = &#63; from the database.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNhomVanBanId(long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNhomVanBanId(nhomVanBanId);
	}

	/**
	* Returns the number of co quan ban hanh van bans where nhomVanBanId = &#63;.
	*
	* @param nhomVanBanId the nhom van ban ID
	* @return the number of matching co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNhomVanBanId(long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNhomVanBanId(nhomVanBanId);
	}

	/**
	* Caches the co quan ban hanh van ban in the entity cache if it is enabled.
	*
	* @param coQuanBanHanhVanBan the co quan ban hanh van ban
	*/
	public static void cacheResult(
		com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		getPersistence().cacheResult(coQuanBanHanhVanBan);
	}

	/**
	* Caches the co quan ban hanh van bans in the entity cache if it is enabled.
	*
	* @param coQuanBanHanhVanBans the co quan ban hanh van bans
	*/
	public static void cacheResult(
		java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> coQuanBanHanhVanBans) {
		getPersistence().cacheResult(coQuanBanHanhVanBans);
	}

	/**
	* Creates a new co quan ban hanh van ban with the primary key. Does not add the co quan ban hanh van ban to the database.
	*
	* @param id the primary key for the new co quan ban hanh van ban
	* @return the new co quan ban hanh van ban
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the co quan ban hanh van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was removed
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence().remove(id);
	}

	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan updateImpl(
		com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(coQuanBanHanhVanBan);
	}

	/**
	* Returns the co quan ban hanh van ban with the primary key or throws a {@link com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException} if it could not be found.
	*
	* @param id the primary key of the co quan ban hanh van ban
	* @return the co quan ban hanh van ban
	* @throws com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.vbpq.NoSuchCoQuanBanHanhVanBanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the co quan ban hanh van ban with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the co quan ban hanh van ban
	* @return the co quan ban hanh van ban, or <code>null</code> if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the co quan ban hanh van bans.
	*
	* @return the co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the co quan ban hanh van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @return the range of co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the co quan ban hanh van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the co quan ban hanh van bans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of co quan ban hanh van bans.
	*
	* @return the number of co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoQuanBanHanhVanBanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoQuanBanHanhVanBanPersistence)PortletBeanLocatorUtil.locate(com.revotech.portal.vbpq.service.ClpSerializer.getServletContextName(),
					CoQuanBanHanhVanBanPersistence.class.getName());

			ReferenceRegistry.registerReference(CoQuanBanHanhVanBanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CoQuanBanHanhVanBanPersistence persistence) {
	}

	private static CoQuanBanHanhVanBanPersistence _persistence;
}