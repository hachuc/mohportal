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

import com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet;

import java.util.List;

/**
 * The persistence utility for the phong ban nhuan but chi tiet service. This utility wraps {@link PhongBanNhuanButChiTietPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanNhuanButChiTietPersistence
 * @see PhongBanNhuanButChiTietPersistenceImpl
 * @generated
 */
public class PhongBanNhuanButChiTietUtil {
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
	public static void clearCache(
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet) {
		getPersistence().clearCache(phongBanNhuanButChiTiet);
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
	public static List<PhongBanNhuanButChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhongBanNhuanButChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhongBanNhuanButChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PhongBanNhuanButChiTiet update(
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet)
		throws SystemException {
		return getPersistence().update(phongBanNhuanButChiTiet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PhongBanNhuanButChiTiet update(
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(phongBanNhuanButChiTiet, serviceContext);
	}

	/**
	* Returns all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @return the matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPhongBanNhuanBut(phongBanNhuanButId);
	}

	/**
	* Returns a range of all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param start the lower bound of the range of phong ban nhuan but chi tiets
	* @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	* @return the range of matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhongBanNhuanBut(phongBanNhuanButId, start, end);
	}

	/**
	* Returns an ordered range of all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param start the lower bound of the range of phong ban nhuan but chi tiets
	* @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhongBanNhuanBut(phongBanNhuanButId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPhongBanNhuanBut_First(
		long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException {
		return getPersistence()
				   .findByPhongBanNhuanBut_First(phongBanNhuanButId,
			orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPhongBanNhuanBut_First(
		long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPhongBanNhuanBut_First(phongBanNhuanButId,
			orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPhongBanNhuanBut_Last(
		long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException {
		return getPersistence()
				   .findByPhongBanNhuanBut_Last(phongBanNhuanButId,
			orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPhongBanNhuanBut_Last(
		long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPhongBanNhuanBut_Last(phongBanNhuanButId,
			orderByComparator);
	}

	/**
	* Returns the phong ban nhuan but chi tiets before and after the current phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param id the primary key of the current phong ban nhuan but chi tiet
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet[] findByPhongBanNhuanBut_PrevAndNext(
		long id, long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException {
		return getPersistence()
				   .findByPhongBanNhuanBut_PrevAndNext(id, phongBanNhuanButId,
			orderByComparator);
	}

	/**
	* Removes all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; from the database.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPhongBanNhuanBut(long phongBanNhuanButId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPhongBanNhuanBut(phongBanNhuanButId);
	}

	/**
	* Returns the number of phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @return the number of matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPhongBanNhuanBut(long phongBanNhuanButId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPhongBanNhuanBut(phongBanNhuanButId);
	}

	/**
	* Returns all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @return the matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
			phongBanId);
	}

	/**
	* Returns a range of all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param start the lower bound of the range of phong ban nhuan but chi tiets
	* @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	* @return the range of matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
			phongBanId, start, end);
	}

	/**
	* Returns an ordered range of all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param start the lower bound of the range of phong ban nhuan but chi tiets
	* @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
			phongBanId, start, end, orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPhongBanNhuanButAndPhongBan_First(
		long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException {
		return getPersistence()
				   .findByPhongBanNhuanButAndPhongBan_First(phongBanNhuanButId,
			phongBanId, orderByComparator);
	}

	/**
	* Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPhongBanNhuanButAndPhongBan_First(
		long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPhongBanNhuanButAndPhongBan_First(phongBanNhuanButId,
			phongBanId, orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPhongBanNhuanButAndPhongBan_Last(
		long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException {
		return getPersistence()
				   .findByPhongBanNhuanButAndPhongBan_Last(phongBanNhuanButId,
			phongBanId, orderByComparator);
	}

	/**
	* Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPhongBanNhuanButAndPhongBan_Last(
		long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPhongBanNhuanButAndPhongBan_Last(phongBanNhuanButId,
			phongBanId, orderByComparator);
	}

	/**
	* Returns the phong ban nhuan but chi tiets before and after the current phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param id the primary key of the current phong ban nhuan but chi tiet
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet[] findByPhongBanNhuanButAndPhongBan_PrevAndNext(
		long id, long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException {
		return getPersistence()
				   .findByPhongBanNhuanButAndPhongBan_PrevAndNext(id,
			phongBanNhuanButId, phongBanId, orderByComparator);
	}

	/**
	* Removes all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63; from the database.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPhongBanNhuanButAndPhongBan(phongBanNhuanButId, phongBanId);
	}

	/**
	* Returns the number of phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @return the number of matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPhongBanNhuanButAndPhongBan(phongBanNhuanButId,
			phongBanId);
	}

	/**
	* Caches the phong ban nhuan but chi tiet in the entity cache if it is enabled.
	*
	* @param phongBanNhuanButChiTiet the phong ban nhuan but chi tiet
	*/
	public static void cacheResult(
		com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet phongBanNhuanButChiTiet) {
		getPersistence().cacheResult(phongBanNhuanButChiTiet);
	}

	/**
	* Caches the phong ban nhuan but chi tiets in the entity cache if it is enabled.
	*
	* @param phongBanNhuanButChiTiets the phong ban nhuan but chi tiets
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> phongBanNhuanButChiTiets) {
		getPersistence().cacheResult(phongBanNhuanButChiTiets);
	}

	/**
	* Creates a new phong ban nhuan but chi tiet with the primary key. Does not add the phong ban nhuan but chi tiet to the database.
	*
	* @param id the primary key for the new phong ban nhuan but chi tiet
	* @return the new phong ban nhuan but chi tiet
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the phong ban nhuan but chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the phong ban nhuan but chi tiet
	* @return the phong ban nhuan but chi tiet that was removed
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet updateImpl(
		com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet phongBanNhuanButChiTiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(phongBanNhuanButChiTiet);
	}

	/**
	* Returns the phong ban nhuan but chi tiet with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException} if it could not be found.
	*
	* @param id the primary key of the phong ban nhuan but chi tiet
	* @return the phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the phong ban nhuan but chi tiet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the phong ban nhuan but chi tiet
	* @return the phong ban nhuan but chi tiet, or <code>null</code> if a phong ban nhuan but chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the phong ban nhuan but chi tiets.
	*
	* @return the phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the phong ban nhuan but chi tiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phong ban nhuan but chi tiets
	* @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	* @return the range of phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the phong ban nhuan but chi tiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanNhuanButChiTietModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phong ban nhuan but chi tiets
	* @param end the upper bound of the range of phong ban nhuan but chi tiets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the phong ban nhuan but chi tiets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of phong ban nhuan but chi tiets.
	*
	* @return the number of phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PhongBanNhuanButChiTietPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PhongBanNhuanButChiTietPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.thongke.service.ClpSerializer.getServletContextName(),
					PhongBanNhuanButChiTietPersistence.class.getName());

			ReferenceRegistry.registerReference(PhongBanNhuanButChiTietUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PhongBanNhuanButChiTietPersistence persistence) {
	}

	private static PhongBanNhuanButChiTietPersistence _persistence;
}