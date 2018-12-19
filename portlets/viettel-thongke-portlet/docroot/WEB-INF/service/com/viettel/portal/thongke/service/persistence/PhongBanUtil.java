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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.thongke.model.PhongBan;

import java.util.List;

/**
 * The persistence utility for the phong ban service. This utility wraps {@link PhongBanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanPersistence
 * @see PhongBanPersistenceImpl
 * @generated
 */
public class PhongBanUtil {
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
	public static void clearCache(PhongBan phongBan) {
		getPersistence().clearCache(phongBan);
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
	public static List<PhongBan> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhongBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhongBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PhongBan update(PhongBan phongBan) throws SystemException {
		return getPersistence().update(phongBan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PhongBan update(PhongBan phongBan,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(phongBan, serviceContext);
	}

	/**
	* Returns all the phong bans where status = &#63;.
	*
	* @param status the status
	* @return the matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findBystatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first phong ban in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan findBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the first phong ban in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last phong ban in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan findBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last phong ban in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBan[] findBystatus_PrevAndNext(
		long id, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence()
				   .findBystatus_PrevAndNext(id, status, orderByComparator);
	}

	/**
	* Removes all the phong bans where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystatus(status);
	}

	/**
	* Returns the number of phong bans where status = &#63;.
	*
	* @param status the status
	* @return the number of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystatus(status);
	}

	/**
	* Returns all the phong bans where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndStatus(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, status);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndStatus(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, status, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndStatus(
		long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, status, start, end,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBan findByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence()
				   .findByGroupAndStatus_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_First(groupId, status,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBan findByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence()
				   .findByGroupAndStatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_Last(groupId, status,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBan[] findByGroupAndStatus_PrevAndNext(
		long id, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence()
				   .findByGroupAndStatus_PrevAndNext(id, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the phong bans where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndStatus(groupId, status);
	}

	/**
	* Returns the number of phong bans where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndStatus(groupId, status);
	}

	/**
	* Returns all the phong bans where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndName(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndName(groupId, name);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndName(
		long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndName(groupId, name, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroupAndName(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndName(groupId, name, start, end,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBan findByGroupAndName_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence()
				   .findByGroupAndName_First(groupId, name, orderByComparator);
	}

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchByGroupAndName_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndName_First(groupId, name, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBan findByGroupAndName_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence()
				   .findByGroupAndName_Last(groupId, name, orderByComparator);
	}

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchByGroupAndName_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndName_Last(groupId, name, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBan[] findByGroupAndName_PrevAndNext(
		long id, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence()
				   .findByGroupAndName_PrevAndNext(id, groupId, name,
			orderByComparator);
	}

	/**
	* Removes all the phong bans where groupId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndName(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndName(groupId, name);
	}

	/**
	* Returns the number of phong bans where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndName(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndName(groupId, name);
	}

	/**
	* Returns all the phong bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first phong ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last phong ban in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBan[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence()
				   .findByGroup_PrevAndNext(id, groupId, orderByComparator);
	}

	/**
	* Removes all the phong bans where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of phong bans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Caches the phong ban in the entity cache if it is enabled.
	*
	* @param phongBan the phong ban
	*/
	public static void cacheResult(
		com.viettel.portal.thongke.model.PhongBan phongBan) {
		getPersistence().cacheResult(phongBan);
	}

	/**
	* Caches the phong bans in the entity cache if it is enabled.
	*
	* @param phongBans the phong bans
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.PhongBan> phongBans) {
		getPersistence().cacheResult(phongBans);
	}

	/**
	* Creates a new phong ban with the primary key. Does not add the phong ban to the database.
	*
	* @param id the primary key for the new phong ban
	* @return the new phong ban
	*/
	public static com.viettel.portal.thongke.model.PhongBan create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the phong ban
	* @return the phong ban that was removed
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.thongke.model.PhongBan updateImpl(
		com.viettel.portal.thongke.model.PhongBan phongBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(phongBan);
	}

	/**
	* Returns the phong ban with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanException} if it could not be found.
	*
	* @param id the primary key of the phong ban
	* @return the phong ban
	* @throws com.viettel.portal.thongke.NoSuchPhongBanException if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the phong ban with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the phong ban
	* @return the phong ban, or <code>null</code> if a phong ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the phong bans.
	*
	* @return the phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the phong bans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of phong bans.
	*
	* @return the number of phong bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PhongBanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PhongBanPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.thongke.service.ClpSerializer.getServletContextName(),
					PhongBanPersistence.class.getName());

			ReferenceRegistry.registerReference(PhongBanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PhongBanPersistence persistence) {
	}

	private static PhongBanPersistence _persistence;
}