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

package com.viettel.portal.vcms.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.vcms.model.Legal_Zone;

/**
 * The persistence interface for the legal_ zone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_ZonePersistenceImpl
 * @see Legal_ZoneUtil
 * @generated
 */
public interface Legal_ZonePersistence extends BasePersistence<Legal_Zone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Legal_ZoneUtil} to access the legal_ zone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the legal_ zones where Visible = &#63;.
	*
	* @param Visible the visible
	* @return the matching legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Zone> findBybyVisible(
		boolean Visible)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal_ zones where Visible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Visible the visible
	* @param start the lower bound of the range of legal_ zones
	* @param end the upper bound of the range of legal_ zones (not inclusive)
	* @return the range of matching legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Zone> findBybyVisible(
		boolean Visible, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal_ zones where Visible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Visible the visible
	* @param start the lower bound of the range of legal_ zones
	* @param end the upper bound of the range of legal_ zones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Zone> findBybyVisible(
		boolean Visible, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal_ zone in the ordered set where Visible = &#63;.
	*
	* @param Visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ zone
	* @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a matching legal_ zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Zone findBybyVisible_First(
		boolean Visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ZoneException;

	/**
	* Returns the first legal_ zone in the ordered set where Visible = &#63;.
	*
	* @param Visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ zone, or <code>null</code> if a matching legal_ zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Zone fetchBybyVisible_First(
		boolean Visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal_ zone in the ordered set where Visible = &#63;.
	*
	* @param Visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ zone
	* @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a matching legal_ zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Zone findBybyVisible_Last(
		boolean Visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ZoneException;

	/**
	* Returns the last legal_ zone in the ordered set where Visible = &#63;.
	*
	* @param Visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ zone, or <code>null</code> if a matching legal_ zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Zone fetchBybyVisible_Last(
		boolean Visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal_ zones before and after the current legal_ zone in the ordered set where Visible = &#63;.
	*
	* @param ID the primary key of the current legal_ zone
	* @param Visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal_ zone
	* @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a legal_ zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Zone[] findBybyVisible_PrevAndNext(
		int ID, boolean Visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ZoneException;

	/**
	* Removes all the legal_ zones where Visible = &#63; from the database.
	*
	* @param Visible the visible
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyVisible(boolean Visible)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ zones where Visible = &#63;.
	*
	* @param Visible the visible
	* @return the number of matching legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyVisible(boolean Visible)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the legal_ zone in the entity cache if it is enabled.
	*
	* @param legal_Zone the legal_ zone
	*/
	public void cacheResult(com.viettel.portal.vcms.model.Legal_Zone legal_Zone);

	/**
	* Caches the legal_ zones in the entity cache if it is enabled.
	*
	* @param legal_Zones the legal_ zones
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Legal_Zone> legal_Zones);

	/**
	* Creates a new legal_ zone with the primary key. Does not add the legal_ zone to the database.
	*
	* @param ID the primary key for the new legal_ zone
	* @return the new legal_ zone
	*/
	public com.viettel.portal.vcms.model.Legal_Zone create(int ID);

	/**
	* Removes the legal_ zone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ zone
	* @return the legal_ zone that was removed
	* @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a legal_ zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Zone remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ZoneException;

	public com.viettel.portal.vcms.model.Legal_Zone updateImpl(
		com.viettel.portal.vcms.model.Legal_Zone legal_Zone)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal_ zone with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_ZoneException} if it could not be found.
	*
	* @param ID the primary key of the legal_ zone
	* @return the legal_ zone
	* @throws com.viettel.portal.vcms.NoSuchLegal_ZoneException if a legal_ zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Zone findByPrimaryKey(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ZoneException;

	/**
	* Returns the legal_ zone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the legal_ zone
	* @return the legal_ zone, or <code>null</code> if a legal_ zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Zone fetchByPrimaryKey(int ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legal_ zones.
	*
	* @return the legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Zone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal_ zones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ zones
	* @param end the upper bound of the range of legal_ zones (not inclusive)
	* @return the range of legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Zone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal_ zones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ZoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ zones
	* @param end the upper bound of the range of legal_ zones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Zone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal_ zones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ zones.
	*
	* @return the number of legal_ zones
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}