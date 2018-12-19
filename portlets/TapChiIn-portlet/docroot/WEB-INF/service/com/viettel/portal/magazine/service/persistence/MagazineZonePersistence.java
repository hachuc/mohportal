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

package com.viettel.portal.magazine.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.magazine.model.MagazineZone;

/**
 * The persistence interface for the magazine zone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see MagazineZonePersistenceImpl
 * @see MagazineZoneUtil
 * @generated
 */
public interface MagazineZonePersistence extends BasePersistence<MagazineZone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MagazineZoneUtil} to access the magazine zone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the magazine zones where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the matching magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.model.MagazineZone> findByMagazineID(
		int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the magazine zones where MagazineID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param start the lower bound of the range of magazine zones
	* @param end the upper bound of the range of magazine zones (not inclusive)
	* @return the range of matching magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.model.MagazineZone> findByMagazineID(
		int MagazineID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the magazine zones where MagazineID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param start the lower bound of the range of magazine zones
	* @param end the upper bound of the range of magazine zones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.model.MagazineZone> findByMagazineID(
		int MagazineID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine zone
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a matching magazine zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.model.MagazineZone findByMagazineID_First(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException;

	/**
	* Returns the first magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine zone, or <code>null</code> if a matching magazine zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.model.MagazineZone fetchByMagazineID_First(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine zone
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a matching magazine zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.model.MagazineZone findByMagazineID_Last(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException;

	/**
	* Returns the last magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine zone, or <code>null</code> if a matching magazine zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.model.MagazineZone fetchByMagazineID_Last(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the magazine zones before and after the current magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param ID the primary key of the current magazine zone
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next magazine zone
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.model.MagazineZone[] findByMagazineID_PrevAndNext(
		int ID, int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException;

	/**
	* Removes all the magazine zones where MagazineID = &#63; from the database.
	*
	* @param MagazineID the magazine i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMagazineID(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of magazine zones where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the number of matching magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public int countByMagazineID(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the magazine zone in the entity cache if it is enabled.
	*
	* @param magazineZone the magazine zone
	*/
	public void cacheResult(
		com.viettel.portal.magazine.model.MagazineZone magazineZone);

	/**
	* Caches the magazine zones in the entity cache if it is enabled.
	*
	* @param magazineZones the magazine zones
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.magazine.model.MagazineZone> magazineZones);

	/**
	* Creates a new magazine zone with the primary key. Does not add the magazine zone to the database.
	*
	* @param ID the primary key for the new magazine zone
	* @return the new magazine zone
	*/
	public com.viettel.portal.magazine.model.MagazineZone create(int ID);

	/**
	* Removes the magazine zone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the magazine zone
	* @return the magazine zone that was removed
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.model.MagazineZone remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException;

	public com.viettel.portal.magazine.model.MagazineZone updateImpl(
		com.viettel.portal.magazine.model.MagazineZone magazineZone)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the magazine zone with the primary key or throws a {@link com.viettel.portal.magazine.NoSuchZoneException} if it could not be found.
	*
	* @param ID the primary key of the magazine zone
	* @return the magazine zone
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.model.MagazineZone findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException;

	/**
	* Returns the magazine zone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the magazine zone
	* @return the magazine zone, or <code>null</code> if a magazine zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.model.MagazineZone fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the magazine zones.
	*
	* @return the magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.model.MagazineZone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the magazine zones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of magazine zones
	* @param end the upper bound of the range of magazine zones (not inclusive)
	* @return the range of magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.model.MagazineZone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the magazine zones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of magazine zones
	* @param end the upper bound of the range of magazine zones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.model.MagazineZone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the magazine zones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of magazine zones.
	*
	* @return the number of magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}