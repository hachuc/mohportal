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

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.banner.model.Banner;

/**
 * The persistence interface for the banner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see BannerPersistenceImpl
 * @see BannerUtil
 * @generated
 */
public interface BannerPersistence extends BasePersistence<Banner> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BannerUtil} to access the banner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the banners where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.banner.model.Banner> findByTrangThai(
		boolean trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.banner.model.Banner> findByTrangThai(
		boolean trangThai, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.banner.model.Banner> findByTrangThai(
		boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first banner in the ordered set where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner findByTrangThai_First(
		boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException;

	/**
	* Returns the first banner in the ordered set where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner fetchByTrangThai_First(
		boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last banner in the ordered set where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner findByTrangThai_Last(
		boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException;

	/**
	* Returns the last banner in the ordered set where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner fetchByTrangThai_Last(
		boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.banner.model.Banner[] findByTrangThai_PrevAndNext(
		long id, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException;

	/**
	* Removes all the banners where trangThai = &#63; from the database.
	*
	* @param trangThai the trang thai
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(boolean trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(boolean trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the banners where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.banner.model.Banner> findByHienThi(
		boolean trangThai, java.util.Date ngayKetThuc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.banner.model.Banner> findByHienThi(
		boolean trangThai, java.util.Date ngayKetThuc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.banner.model.Banner> findByHienThi(
		boolean trangThai, java.util.Date ngayKetThuc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.banner.model.Banner findByHienThi_First(
		boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException;

	/**
	* Returns the first banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner fetchByHienThi_First(
		boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.banner.model.Banner findByHienThi_Last(
		boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException;

	/**
	* Returns the last banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner fetchByHienThi_Last(
		boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.banner.model.Banner[] findByHienThi_PrevAndNext(
		long id, boolean trangThai, java.util.Date ngayKetThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException;

	/**
	* Removes all the banners where trangThai = &#63; and ngayKetThuc = &#63; from the database.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHienThi(boolean trangThai, java.util.Date ngayKetThuc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners where trangThai = &#63; and ngayKetThuc = &#63;.
	*
	* @param trangThai the trang thai
	* @param ngayKetThuc the ngay ket thuc
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public int countByHienThi(boolean trangThai, java.util.Date ngayKetThuc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the banner in the entity cache if it is enabled.
	*
	* @param banner the banner
	*/
	public void cacheResult(com.viettel.portal.banner.model.Banner banner);

	/**
	* Caches the banners in the entity cache if it is enabled.
	*
	* @param banners the banners
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.banner.model.Banner> banners);

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param id the primary key for the new banner
	* @return the new banner
	*/
	public com.viettel.portal.banner.model.Banner create(long id);

	/**
	* Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the banner
	* @return the banner that was removed
	* @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException;

	public com.viettel.portal.banner.model.Banner updateImpl(
		com.viettel.portal.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the banner with the primary key or throws a {@link com.viettel.portal.banner.NoSuchBannerException} if it could not be found.
	*
	* @param id the primary key of the banner
	* @return the banner
	* @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.banner.NoSuchBannerException;

	/**
	* Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the banner
	* @return the banner, or <code>null</code> if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.banner.model.Banner fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the banners.
	*
	* @return the banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.banner.model.Banner> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.banner.model.Banner> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.banner.model.Banner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banners from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}