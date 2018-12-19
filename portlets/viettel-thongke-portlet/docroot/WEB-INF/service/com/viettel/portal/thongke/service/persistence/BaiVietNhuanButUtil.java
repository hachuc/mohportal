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

import com.viettel.portal.thongke.model.BaiVietNhuanBut;

import java.util.List;

/**
 * The persistence utility for the bai viet nhuan but service. This utility wraps {@link BaiVietNhuanButPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see BaiVietNhuanButPersistence
 * @see BaiVietNhuanButPersistenceImpl
 * @generated
 */
public class BaiVietNhuanButUtil {
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
	public static void clearCache(BaiVietNhuanBut baiVietNhuanBut) {
		getPersistence().clearCache(baiVietNhuanBut);
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
	public static List<BaiVietNhuanBut> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BaiVietNhuanBut> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BaiVietNhuanBut> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BaiVietNhuanBut update(BaiVietNhuanBut baiVietNhuanBut)
		throws SystemException {
		return getPersistence().update(baiVietNhuanBut);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BaiVietNhuanBut update(BaiVietNhuanBut baiVietNhuanBut,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(baiVietNhuanBut, serviceContext);
	}

	/**
	* Returns all the bai viet nhuan buts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last bai viet nhuan but in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence()
				   .findByGroup_PrevAndNext(id, groupId, orderByComparator);
	}

	/**
	* Removes all the bai viet nhuan buts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of bai viet nhuan buts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns all the bai viet nhuan buts where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroupAndType(
		long groupId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndType(groupId, type);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroupAndType(
		long groupId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndType(groupId, type, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByGroupAndType(
		long groupId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndType(groupId, type, start, end,
			orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut findByGroupAndType_First(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence()
				   .findByGroupAndType_First(groupId, type, orderByComparator);
	}

	/**
	* Returns the first bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByGroupAndType_First(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndType_First(groupId, type, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut findByGroupAndType_Last(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence()
				   .findByGroupAndType_Last(groupId, type, orderByComparator);
	}

	/**
	* Returns the last bai viet nhuan but in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByGroupAndType_Last(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndType_Last(groupId, type, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut[] findByGroupAndType_PrevAndNext(
		long id, long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence()
				   .findByGroupAndType_PrevAndNext(id, groupId, type,
			orderByComparator);
	}

	/**
	* Removes all the bai viet nhuan buts where groupId = &#63; and type = &#63; from the database.
	*
	* @param groupId the group ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndType(long groupId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndType(groupId, type);
	}

	/**
	* Returns the number of bai viet nhuan buts where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the number of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndType(long groupId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndType(groupId, type);
	}

	/**
	* Returns all the bai viet nhuan buts where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @return the matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByBaiVietID(
		long baiVietId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBaiVietID(baiVietId);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByBaiVietID(
		long baiVietId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBaiVietID(baiVietId, start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findByBaiVietID(
		long baiVietId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBaiVietID(baiVietId, start, end, orderByComparator);
	}

	/**
	* Returns the first bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut findByBaiVietID_First(
		long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence()
				   .findByBaiVietID_First(baiVietId, orderByComparator);
	}

	/**
	* Returns the first bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByBaiVietID_First(
		long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBaiVietID_First(baiVietId, orderByComparator);
	}

	/**
	* Returns the last bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut findByBaiVietID_Last(
		long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence()
				   .findByBaiVietID_Last(baiVietId, orderByComparator);
	}

	/**
	* Returns the last bai viet nhuan but in the ordered set where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bai viet nhuan but, or <code>null</code> if a matching bai viet nhuan but could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByBaiVietID_Last(
		long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBaiVietID_Last(baiVietId, orderByComparator);
	}

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
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut[] findByBaiVietID_PrevAndNext(
		long id, long baiVietId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence()
				   .findByBaiVietID_PrevAndNext(id, baiVietId, orderByComparator);
	}

	/**
	* Removes all the bai viet nhuan buts where baiVietId = &#63; from the database.
	*
	* @param baiVietId the bai viet ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBaiVietID(long baiVietId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBaiVietID(baiVietId);
	}

	/**
	* Returns the number of bai viet nhuan buts where baiVietId = &#63;.
	*
	* @param baiVietId the bai viet ID
	* @return the number of matching bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBaiVietID(long baiVietId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBaiVietID(baiVietId);
	}

	/**
	* Caches the bai viet nhuan but in the entity cache if it is enabled.
	*
	* @param baiVietNhuanBut the bai viet nhuan but
	*/
	public static void cacheResult(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut) {
		getPersistence().cacheResult(baiVietNhuanBut);
	}

	/**
	* Caches the bai viet nhuan buts in the entity cache if it is enabled.
	*
	* @param baiVietNhuanButs the bai viet nhuan buts
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> baiVietNhuanButs) {
		getPersistence().cacheResult(baiVietNhuanButs);
	}

	/**
	* Creates a new bai viet nhuan but with the primary key. Does not add the bai viet nhuan but to the database.
	*
	* @param id the primary key for the new bai viet nhuan but
	* @return the new bai viet nhuan but
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the bai viet nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but that was removed
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.thongke.model.BaiVietNhuanBut updateImpl(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(baiVietNhuanBut);
	}

	/**
	* Returns the bai viet nhuan but with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchBaiVietNhuanButException} if it could not be found.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but
	* @throws com.viettel.portal.thongke.NoSuchBaiVietNhuanButException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchBaiVietNhuanButException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the bai viet nhuan but with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but, or <code>null</code> if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.BaiVietNhuanBut fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the bai viet nhuan buts.
	*
	* @return the bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bai viet nhuan buts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bai viet nhuan buts.
	*
	* @return the number of bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BaiVietNhuanButPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BaiVietNhuanButPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.thongke.service.ClpSerializer.getServletContextName(),
					BaiVietNhuanButPersistence.class.getName());

			ReferenceRegistry.registerReference(BaiVietNhuanButUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BaiVietNhuanButPersistence persistence) {
	}

	private static BaiVietNhuanButPersistence _persistence;
}