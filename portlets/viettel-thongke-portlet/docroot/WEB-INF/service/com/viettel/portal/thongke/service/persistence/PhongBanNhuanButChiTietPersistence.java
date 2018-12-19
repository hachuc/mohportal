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

import com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet;

/**
 * The persistence interface for the phong ban nhuan but chi tiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lamvn
 * @see PhongBanNhuanButChiTietPersistenceImpl
 * @see PhongBanNhuanButChiTietUtil
 * @generated
 */
public interface PhongBanNhuanButChiTietPersistence extends BasePersistence<PhongBanNhuanButChiTiet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhongBanNhuanButChiTietUtil} to access the phong ban nhuan but chi tiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @return the matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanBut(
		long phongBanNhuanButId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPhongBanNhuanBut_First(
		long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;

	/**
	* Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPhongBanNhuanBut_First(
		long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPhongBanNhuanBut_Last(
		long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;

	/**
	* Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPhongBanNhuanBut_Last(
		long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet[] findByPhongBanNhuanBut_PrevAndNext(
		long id, long phongBanNhuanButId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;

	/**
	* Removes all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; from the database.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPhongBanNhuanBut(long phongBanNhuanButId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong ban nhuan but chi tiets where phongBanNhuanButId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @return the number of matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public int countByPhongBanNhuanBut(long phongBanNhuanButId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @return the matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findByPhongBanNhuanButAndPhongBan(
		long phongBanNhuanButId, long phongBanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPhongBanNhuanButAndPhongBan_First(
		long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;

	/**
	* Returns the first phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPhongBanNhuanButAndPhongBan_First(
		long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPhongBanNhuanButAndPhongBan_Last(
		long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;

	/**
	* Returns the last phong ban nhuan but chi tiet in the ordered set where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phong ban nhuan but chi tiet, or <code>null</code> if a matching phong ban nhuan but chi tiet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPhongBanNhuanButAndPhongBan_Last(
		long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet[] findByPhongBanNhuanButAndPhongBan_PrevAndNext(
		long id, long phongBanNhuanButId, long phongBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;

	/**
	* Removes all the phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63; from the database.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPhongBanNhuanButAndPhongBan(long phongBanNhuanButId,
		long phongBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong ban nhuan but chi tiets where phongBanNhuanButId = &#63; and phongBanId = &#63;.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID
	* @param phongBanId the phong ban ID
	* @return the number of matching phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public int countByPhongBanNhuanButAndPhongBan(long phongBanNhuanButId,
		long phongBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the phong ban nhuan but chi tiet in the entity cache if it is enabled.
	*
	* @param phongBanNhuanButChiTiet the phong ban nhuan but chi tiet
	*/
	public void cacheResult(
		com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet phongBanNhuanButChiTiet);

	/**
	* Caches the phong ban nhuan but chi tiets in the entity cache if it is enabled.
	*
	* @param phongBanNhuanButChiTiets the phong ban nhuan but chi tiets
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> phongBanNhuanButChiTiets);

	/**
	* Creates a new phong ban nhuan but chi tiet with the primary key. Does not add the phong ban nhuan but chi tiet to the database.
	*
	* @param id the primary key for the new phong ban nhuan but chi tiet
	* @return the new phong ban nhuan but chi tiet
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet create(
		long id);

	/**
	* Removes the phong ban nhuan but chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the phong ban nhuan but chi tiet
	* @return the phong ban nhuan but chi tiet that was removed
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;

	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet updateImpl(
		com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet phongBanNhuanButChiTiet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phong ban nhuan but chi tiet with the primary key or throws a {@link com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException} if it could not be found.
	*
	* @param id the primary key of the phong ban nhuan but chi tiet
	* @return the phong ban nhuan but chi tiet
	* @throws com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException if a phong ban nhuan but chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.thongke.NoSuchPhongBanNhuanButChiTietException;

	/**
	* Returns the phong ban nhuan but chi tiet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the phong ban nhuan but chi tiet
	* @return the phong ban nhuan but chi tiet, or <code>null</code> if a phong ban nhuan but chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phong ban nhuan but chi tiets.
	*
	* @return the phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the phong ban nhuan but chi tiets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phong ban nhuan but chi tiets.
	*
	* @return the number of phong ban nhuan but chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}