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

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.vbpq.model.NhomVanBan;

/**
 * The persistence interface for the nhom van ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see NhomVanBanPersistenceImpl
 * @see NhomVanBanUtil
 * @generated
 */
public interface NhomVanBanPersistence extends BasePersistence<NhomVanBan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NhomVanBanUtil} to access the nhom van ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the nhom van ban in the entity cache if it is enabled.
	*
	* @param nhomVanBan the nhom van ban
	*/
	public void cacheResult(com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan);

	/**
	* Caches the nhom van bans in the entity cache if it is enabled.
	*
	* @param nhomVanBans the nhom van bans
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> nhomVanBans);

	/**
	* Creates a new nhom van ban with the primary key. Does not add the nhom van ban to the database.
	*
	* @param id the primary key for the new nhom van ban
	* @return the new nhom van ban
	*/
	public com.viettel.portal.vbpq.model.NhomVanBan create(long id);

	/**
	* Removes the nhom van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban that was removed
	* @throws com.viettel.portal.vbpq.NoSuchNhomVanBanException if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.NhomVanBan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchNhomVanBanException;

	public com.viettel.portal.vbpq.model.NhomVanBan updateImpl(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the nhom van ban with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchNhomVanBanException} if it could not be found.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban
	* @throws com.viettel.portal.vbpq.NoSuchNhomVanBanException if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.NhomVanBan findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchNhomVanBanException;

	/**
	* Returns the nhom van ban with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban, or <code>null</code> if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.NhomVanBan fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the nhom van bans.
	*
	* @return the nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the nhom van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of nhom van bans
	* @param end the upper bound of the range of nhom van bans (not inclusive)
	* @return the range of nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the nhom van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.NhomVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of nhom van bans
	* @param end the upper bound of the range of nhom van bans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the nhom van bans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nhom van bans.
	*
	* @return the number of nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}