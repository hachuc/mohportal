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

import com.viettel.portal.thongke.model.PhongBanNhuanBut;

import java.util.List;

/**
 * The persistence utility for the phong ban nhuan but service. This utility wraps {@link PhongBanNhuanButPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanNhuanButPersistence
 * @see PhongBanNhuanButPersistenceImpl
 * @generated
 */
public class PhongBanNhuanButUtil {
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
	public static void clearCache(PhongBanNhuanBut phongBanNhuanBut) {
		getPersistence().clearCache(phongBanNhuanBut);
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
	public static List<PhongBanNhuanBut> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhongBanNhuanBut> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhongBanNhuanBut> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PhongBanNhuanBut update(PhongBanNhuanBut phongBanNhuanBut)
		throws SystemException {
		return getPersistence().update(phongBanNhuanBut);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PhongBanNhuanBut update(PhongBanNhuanBut phongBanNhuanBut,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(phongBanNhuanBut, serviceContext);
	}

	/**
	* Returns all the phong ban nhuan buts where status = &#63;.
	*
	* @param status the status
	* @return the matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findBystatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut[] findBystatus_PrevAndNext(
		long id, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence()
				   .findBystatus_PrevAndNext(id, status, orderByComparator);
	}

	/**
	* Removes all the phong ban nhuan buts where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystatus(status);
	}

	/**
	* Returns the number of phong ban nhuan buts where status = &#63;.
	*
	* @param status the status
	* @return the number of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystatus(status);
	}

	/**
	* Returns all the phong ban nhuan buts where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndStatus(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, status);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndStatus(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, status, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndStatus(
		long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, status, start, end,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence()
				   .findByGroupAndStatus_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroupAndStatus_First(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_First(groupId, status,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence()
				   .findByGroupAndStatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroupAndStatus_Last(
		long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_Last(groupId, status,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut[] findByGroupAndStatus_PrevAndNext(
		long id, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence()
				   .findByGroupAndStatus_PrevAndNext(id, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the phong ban nhuan buts where groupId = &#63; and status = &#63; from the database.
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
	* Returns the number of phong ban nhuan buts where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndStatus(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndStatus(groupId, status);
	}

	/**
	* Returns all the phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @return the matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndCaption(
		long groupId, java.lang.String caption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndCaption(groupId, caption);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndCaption(
		long groupId, java.lang.String caption, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndCaption(groupId, caption, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroupAndCaption(
		long groupId, java.lang.String caption, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndCaption(groupId, caption, start, end,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroupAndCaption_First(
		long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence()
				   .findByGroupAndCaption_First(groupId, caption,
			orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroupAndCaption_First(
		long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndCaption_First(groupId, caption,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroupAndCaption_Last(
		long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence()
				   .findByGroupAndCaption_Last(groupId, caption,
			orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroupAndCaption_Last(
		long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndCaption_Last(groupId, caption,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut[] findByGroupAndCaption_PrevAndNext(
		long id, long groupId, java.lang.String caption,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence()
				   .findByGroupAndCaption_PrevAndNext(id, groupId, caption,
			orderByComparator);
	}

	/**
	* Removes all the phong ban nhuan buts where groupId = &#63; and caption = &#63; from the database.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndCaption(long groupId,
		java.lang.String caption)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndCaption(groupId, caption);
	}

	/**
	* Returns the number of phong ban nhuan buts where groupId = &#63; and caption = &#63;.
	*
	* @param groupId the group ID
	* @param caption the caption
	* @return the number of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndCaption(long groupId,
		java.lang.String caption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndCaption(groupId, caption);
	}

	/**
	* Returns all the phong ban nhuan buts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but, or <code>null</code> if a matching phong ban nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence()
				   .findByGroup_PrevAndNext(id, groupId, orderByComparator);
	}

	/**
	* Removes all the phong ban nhuan buts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of phong ban nhuan buts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Caches the phong ban nhuan but in the entity cache if it is enabled.
	*
	* @param phongBanNhuanBut the phong ban nhuan but
	*/
	public static void cacheResult(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut) {
		getPersistence().cacheResult(phongBanNhuanBut);
	}

	/**
	* Caches the phong ban nhuan buts in the entity cache if it is enabled.
	*
	* @param phongBanNhuanButs the phong ban nhuan buts
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> phongBanNhuanButs) {
		getPersistence().cacheResult(phongBanNhuanButs);
	}

	/**
	* Creates a new phong ban nhuan but with the primary key. Does not add the phong ban nhuan but to the database.
	*
	* @param id the primary key for the new phong ban nhuan but
	* @return the new phong ban nhuan but
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the phong ban nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the phong ban nhuan but
	* @return the phong ban nhuan but that was removed
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.thongke.model.PhongBanNhuanBut updateImpl(
		com.viettel.portal.thongke.model.PhongBanNhuanBut phongBanNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(phongBanNhuanBut);
	}

	/**
	* Returns the phong ban nhuan but with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanNhuanButException} if it could not be found.
	*
	* @param id the primary key of the phong ban nhuan but
	* @return the phong ban nhuan but
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButException if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the phong ban nhuan but with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the phong ban nhuan but
	* @return the phong ban nhuan but, or <code>null</code> if a phong ban nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanBut fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the phong ban nhuan buts.
	*
	* @return the phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanBut> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the phong ban nhuan buts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of phong ban nhuan buts.
	*
	* @return the number of phong ban nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PhongBanNhuanButPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PhongBanNhuanButPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.thongke.service.ClpSerializer.getServletContextName(),
					PhongBanNhuanButPersistence.class.getName());

			ReferenceRegistry.registerReference(PhongBanNhuanButUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PhongBanNhuanButPersistence persistence) {
	}

	private static PhongBanNhuanButPersistence _persistence;
}