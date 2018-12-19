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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.magazine.model.MagazineZone;

import java.util.List;

/**
 * The persistence utility for the magazine zone service. This utility wraps {@link MagazineZonePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see MagazineZonePersistence
 * @see MagazineZonePersistenceImpl
 * @generated
 */
public class MagazineZoneUtil {
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
	public static void clearCache(MagazineZone magazineZone) {
		getPersistence().clearCache(magazineZone);
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
	public static List<MagazineZone> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MagazineZone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MagazineZone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MagazineZone update(MagazineZone magazineZone)
		throws SystemException {
		return getPersistence().update(magazineZone);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MagazineZone update(MagazineZone magazineZone,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(magazineZone, serviceContext);
	}

	/**
	* Returns all the magazine zones where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the matching magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineZone> findByMagazineID(
		int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMagazineID(MagazineID);
	}

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
	public static java.util.List<com.viettel.portal.magazine.model.MagazineZone> findByMagazineID(
		int MagazineID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMagazineID(MagazineID, start, end);
	}

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
	public static java.util.List<com.viettel.portal.magazine.model.MagazineZone> findByMagazineID(
		int MagazineID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMagazineID(MagazineID, start, end, orderByComparator);
	}

	/**
	* Returns the first magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine zone
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a matching magazine zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineZone findByMagazineID_First(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException {
		return getPersistence()
				   .findByMagazineID_First(MagazineID, orderByComparator);
	}

	/**
	* Returns the first magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine zone, or <code>null</code> if a matching magazine zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineZone fetchByMagazineID_First(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMagazineID_First(MagazineID, orderByComparator);
	}

	/**
	* Returns the last magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine zone
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a matching magazine zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineZone findByMagazineID_Last(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException {
		return getPersistence()
				   .findByMagazineID_Last(MagazineID, orderByComparator);
	}

	/**
	* Returns the last magazine zone in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine zone, or <code>null</code> if a matching magazine zone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineZone fetchByMagazineID_Last(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMagazineID_Last(MagazineID, orderByComparator);
	}

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
	public static com.viettel.portal.magazine.model.MagazineZone[] findByMagazineID_PrevAndNext(
		int ID, int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException {
		return getPersistence()
				   .findByMagazineID_PrevAndNext(ID, MagazineID,
			orderByComparator);
	}

	/**
	* Removes all the magazine zones where MagazineID = &#63; from the database.
	*
	* @param MagazineID the magazine i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMagazineID(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMagazineID(MagazineID);
	}

	/**
	* Returns the number of magazine zones where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the number of matching magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMagazineID(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMagazineID(MagazineID);
	}

	/**
	* Caches the magazine zone in the entity cache if it is enabled.
	*
	* @param magazineZone the magazine zone
	*/
	public static void cacheResult(
		com.viettel.portal.magazine.model.MagazineZone magazineZone) {
		getPersistence().cacheResult(magazineZone);
	}

	/**
	* Caches the magazine zones in the entity cache if it is enabled.
	*
	* @param magazineZones the magazine zones
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.magazine.model.MagazineZone> magazineZones) {
		getPersistence().cacheResult(magazineZones);
	}

	/**
	* Creates a new magazine zone with the primary key. Does not add the magazine zone to the database.
	*
	* @param ID the primary key for the new magazine zone
	* @return the new magazine zone
	*/
	public static com.viettel.portal.magazine.model.MagazineZone create(int ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the magazine zone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the magazine zone
	* @return the magazine zone that was removed
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineZone remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException {
		return getPersistence().remove(ID);
	}

	public static com.viettel.portal.magazine.model.MagazineZone updateImpl(
		com.viettel.portal.magazine.model.MagazineZone magazineZone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(magazineZone);
	}

	/**
	* Returns the magazine zone with the primary key or throws a {@link com.viettel.portal.magazine.NoSuchZoneException} if it could not be found.
	*
	* @param ID the primary key of the magazine zone
	* @return the magazine zone
	* @throws com.viettel.portal.magazine.NoSuchZoneException if a magazine zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineZone findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchZoneException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the magazine zone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the magazine zone
	* @return the magazine zone, or <code>null</code> if a magazine zone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineZone fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the magazine zones.
	*
	* @return the magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineZone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viettel.portal.magazine.model.MagazineZone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viettel.portal.magazine.model.MagazineZone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the magazine zones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of magazine zones.
	*
	* @return the number of magazine zones
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MagazineZonePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MagazineZonePersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.magazine.service.ClpSerializer.getServletContextName(),
					MagazineZonePersistence.class.getName());

			ReferenceRegistry.registerReference(MagazineZoneUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MagazineZonePersistence persistence) {
	}

	private static MagazineZonePersistence _persistence;
}