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

import com.viettel.portal.vbpq.model.VanBanPhapQuy;

import java.util.List;

/**
 * The persistence utility for the van ban phap quy service. This utility wraps {@link VanBanPhapQuyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VanBanPhapQuyPersistence
 * @see VanBanPhapQuyPersistenceImpl
 * @generated
 */
public class VanBanPhapQuyUtil {
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
	public static void clearCache(VanBanPhapQuy vanBanPhapQuy) {
		getPersistence().clearCache(vanBanPhapQuy);
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
	public static List<VanBanPhapQuy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VanBanPhapQuy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VanBanPhapQuy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VanBanPhapQuy update(VanBanPhapQuy vanBanPhapQuy)
		throws SystemException {
		return getPersistence().update(vanBanPhapQuy);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VanBanPhapQuy update(VanBanPhapQuy vanBanPhapQuy,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vanBanPhapQuy, serviceContext);
	}

	/**
	* Returns all the van ban phap quies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByGroupId(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, status);
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByGroupId(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, status, start, end);
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByGroupId(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, status, start, end, orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy findByGroupId_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence()
				   .findByGroupId_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByGroupId_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_First(groupId, status, orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy findByGroupId_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence()
				   .findByGroupId_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByGroupId_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_Last(groupId, status, orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy[] findByGroupId_PrevAndNext(
		long id, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(id, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the van ban phap quies where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId, status);
	}

	/**
	* Returns the number of van ban phap quies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId, status);
	}

	/**
	* Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or throws a {@link com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException} if it could not be found.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @return the matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy findByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence().findByGroupId_MaVanBan(groupId, maVanBan);
	}

	/**
	* Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @return the matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_MaVanBan(groupId, maVanBan);
	}

	/**
	* Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_MaVanBan(groupId, maVanBan, retrieveFromCache);
	}

	/**
	* Removes the van ban phap quy where groupId = &#63; and maVanBan = &#63; from the database.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @return the van ban phap quy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy removeByGroupId_MaVanBan(
		long groupId, java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence().removeByGroupId_MaVanBan(groupId, maVanBan);
	}

	/**
	* Returns the number of van ban phap quies where groupId = &#63; and maVanBan = &#63;.
	*
	* @param groupId the group ID
	* @param maVanBan the ma van ban
	* @return the number of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId_MaVanBan(long groupId,
		java.lang.String maVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId_MaVanBan(groupId, maVanBan);
	}

	/**
	* Returns all the van ban phap quies where status = &#63;.
	*
	* @param status the status
	* @return the matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first van ban phap quy in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first van ban phap quy in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last van ban phap quy in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last van ban phap quy in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy[] findByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence()
				   .findByStatus_PrevAndNext(id, status, orderByComparator);
	}

	/**
	* Removes all the van ban phap quies where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of van ban phap quies where status = &#63;.
	*
	* @param status the status
	* @return the number of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @return the matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_CQBH_S(groupId, coQuanBanHanh, status);
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CQBH_S(groupId, coQuanBanHanh, status, start, end);
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findByG_CQBH_S(
		long groupId, long coQuanBanHanh, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CQBH_S(groupId, coQuanBanHanh, status, start, end,
			orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy findByG_CQBH_S_First(
		long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence()
				   .findByG_CQBH_S_First(groupId, coQuanBanHanh, status,
			orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByG_CQBH_S_First(
		long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_CQBH_S_First(groupId, coQuanBanHanh, status,
			orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy findByG_CQBH_S_Last(
		long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence()
				   .findByG_CQBH_S_Last(groupId, coQuanBanHanh, status,
			orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByG_CQBH_S_Last(
		long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_CQBH_S_Last(groupId, coQuanBanHanh, status,
			orderByComparator);
	}

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
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy[] findByG_CQBH_S_PrevAndNext(
		long id, long groupId, long coQuanBanHanh, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence()
				   .findByG_CQBH_S_PrevAndNext(id, groupId, coQuanBanHanh,
			status, orderByComparator);
	}

	/**
	* Removes all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_CQBH_S(long groupId, long coQuanBanHanh,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_CQBH_S(groupId, coQuanBanHanh, status);
	}

	/**
	* Returns the number of van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param coQuanBanHanh the co quan ban hanh
	* @param status the status
	* @return the number of matching van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_CQBH_S(long groupId, long coQuanBanHanh,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_CQBH_S(groupId, coQuanBanHanh, status);
	}

	/**
	* Caches the van ban phap quy in the entity cache if it is enabled.
	*
	* @param vanBanPhapQuy the van ban phap quy
	*/
	public static void cacheResult(
		com.viettel.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy) {
		getPersistence().cacheResult(vanBanPhapQuy);
	}

	/**
	* Caches the van ban phap quies in the entity cache if it is enabled.
	*
	* @param vanBanPhapQuies the van ban phap quies
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> vanBanPhapQuies) {
		getPersistence().cacheResult(vanBanPhapQuies);
	}

	/**
	* Creates a new van ban phap quy with the primary key. Does not add the van ban phap quy to the database.
	*
	* @param id the primary key for the new van ban phap quy
	* @return the new van ban phap quy
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the van ban phap quy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy that was removed
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.vbpq.model.VanBanPhapQuy updateImpl(
		com.viettel.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vanBanPhapQuy);
	}

	/**
	* Returns the van ban phap quy with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException} if it could not be found.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy
	* @throws com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchVanBanPhapQuyException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the van ban phap quy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the van ban phap quy
	* @return the van ban phap quy, or <code>null</code> if a van ban phap quy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.VanBanPhapQuy fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the van ban phap quies.
	*
	* @return the van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.VanBanPhapQuy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the van ban phap quies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of van ban phap quies.
	*
	* @return the number of van ban phap quies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VanBanPhapQuyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VanBanPhapQuyPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vbpq.service.ClpSerializer.getServletContextName(),
					VanBanPhapQuyPersistence.class.getName());

			ReferenceRegistry.registerReference(VanBanPhapQuyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VanBanPhapQuyPersistence persistence) {
	}

	private static VanBanPhapQuyPersistence _persistence;
}