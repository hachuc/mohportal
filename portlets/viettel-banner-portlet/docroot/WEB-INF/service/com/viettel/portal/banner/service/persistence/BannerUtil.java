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

package com.viettel.portal.banner.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.banner.model.Banner;

import java.util.List;

/**
 * The persistence utility for the banner service. This utility wraps {@link BannerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see BannerPersistence
 * @see BannerPersistenceImpl
 * @generated
 */
public class BannerUtil {
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
	public static void clearCache(Banner banner) {
		getPersistence().clearCache(banner);
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
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Banner update(Banner banner) throws SystemException {
		return getPersistence().update(banner);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Banner update(Banner banner, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(banner, serviceContext);
	}

	/**
	* Returns all the banners where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findByTrangThai(
		boolean trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(trangThai);
	}

	/**
	* Returns a range of all the banners where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findByTrangThai(
		boolean trangThai, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(trangThai, start, end);
	}

	/**
	* Returns an ordered range of all the banners where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findByTrangThai(
		boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(trangThai, start, end, orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner findByTrangThai_First(
		boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException {
		return getPersistence()
				   .findByTrangThai_First(trangThai, orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner fetchByTrangThai_First(
		boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTrangThai_First(trangThai, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner findByTrangThai_Last(
		boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException {
		return getPersistence()
				   .findByTrangThai_Last(trangThai, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner fetchByTrangThai_Last(
		boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTrangThai_Last(trangThai, orderByComparator);
	}

	/**
	* Returns the banners before and after the current banner in the ordered set where trangThai = &#63;.
	*
	* @param id the primary key of the current banner
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner[] findByTrangThai_PrevAndNext(
		long id, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, trangThai, orderByComparator);
	}

	/**
	* Removes all the banners where trangThai = &#63; from the database.
	*
	* @param trangThai the trang thai
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(boolean trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(trangThai);
	}

	/**
	* Returns the number of banners where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(boolean trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(trangThai);
	}

	/**
	* Returns all the banners where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findByHienThi(
		boolean trangThai, java.util.Date ngayKetThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHienThi(trangThai, ngayKetThuc);
	}

	/**
	* Returns a range of all the banners where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findByHienThi(
		boolean trangThai, java.util.Date ngayKetThuc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHienThi(trangThai, ngayKetThuc, start, end);
	}

	/**
	* Returns an ordered range of all the banners where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findByHienThi(
		boolean trangThai, java.util.Date ngayKetThuc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHienThi(trangThai, ngayKetThuc, start, end,
			orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner findByHienThi_First(
		boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException {
		return getPersistence()
				   .findByHienThi_First(trangThai, ngayKetThuc,
			orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner fetchByHienThi_First(
		boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHienThi_First(trangThai, ngayKetThuc,
			orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner findByHienThi_Last(
		boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException {
		return getPersistence()
				   .findByHienThi_Last(trangThai, ngayKetThuc, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner fetchByHienThi_Last(
		boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHienThi_Last(trangThai, ngayKetThuc,
			orderByComparator);
	}

	/**
	* Returns the banners before and after the current banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param id the primary key of the current banner
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner[] findByHienThi_PrevAndNext(
		long id, boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException {
		return getPersistence()
				   .findByHienThi_PrevAndNext(id, trangThai, ngayKetThuc,
			orderByComparator);
	}

	/**
	* Removes all the banners where trangThai = &#63; and ngayKetThuc = &#63; from the database.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHienThi(boolean trangThai,
		java.util.Date ngayKetThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHienThi(trangThai, ngayKetThuc);
	}

	/**
	* Returns the number of banners where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHienThi(boolean trangThai,
		java.util.Date ngayKetThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHienThi(trangThai, ngayKetThuc);
	}

	/**
	* Caches the banner in the entity cache if it is enabled.
	*
	* @param banner the banner
	*/
	public static void cacheResult(
		com.viettel.portal.banner.model.Banner banner) {
		getPersistence().cacheResult(banner);
	}

	/**
	* Caches the banners in the entity cache if it is enabled.
	*
	* @param banners the banners
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.banner.model.Banner> banners) {
		getPersistence().cacheResult(banners);
	}

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param id the primary key for the new banner
	* @return the new banner
	*/
	public static com.viettel.portal.banner.model.Banner create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the banner
	* @return the banner that was removed
	* @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.banner.model.Banner updateImpl(
		com.viettel.portal.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(banner);
	}

	/**
	* Returns the banner with the primary key or throws a {@link com.viettel.portal.banner.NoSuchBannerException} if it could not be found.
	*
	* @param id the primary key of the banner
	* @return the banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the banner
	* @return the banner, or <code>null</code> if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.banner.model.Banner fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the banners.
	*
	* @return the banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the banners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the banners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.banner.model.Banner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the banners from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BannerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BannerPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.banner.service.ClpSerializer.getServletContextName(),
					BannerPersistence.class.getName());

			ReferenceRegistry.registerReference(BannerUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BannerPersistence persistence) {
	}

	private static BannerPersistence _persistence;
}