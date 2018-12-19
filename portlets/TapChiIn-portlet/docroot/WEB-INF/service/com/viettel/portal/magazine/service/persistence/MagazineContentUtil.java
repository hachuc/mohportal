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

import com.viettel.portal.magazine.model.MagazineContent;

import java.util.List;

/**
 * The persistence utility for the magazine content service. This utility wraps {@link MagazineContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see MagazineContentPersistence
 * @see MagazineContentPersistenceImpl
 * @generated
 */
public class MagazineContentUtil {
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
	public static void clearCache(MagazineContent magazineContent) {
		getPersistence().clearCache(magazineContent);
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
	public static List<MagazineContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MagazineContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MagazineContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MagazineContent update(MagazineContent magazineContent)
		throws SystemException {
		return getPersistence().update(magazineContent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MagazineContent update(MagazineContent magazineContent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(magazineContent, serviceContext);
	}

	/**
	* Returns all the magazine contents where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @return the matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineAndZone(
		int MagazineID, int MagazineZoneID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMagazineAndZone(MagazineID, MagazineZoneID);
	}

	/**
	* Returns a range of all the magazine contents where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @param start the lower bound of the range of magazine contents
	* @param end the upper bound of the range of magazine contents (not inclusive)
	* @return the range of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineAndZone(
		int MagazineID, int MagazineZoneID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMagazineAndZone(MagazineID, MagazineZoneID, start, end);
	}

	/**
	* Returns an ordered range of all the magazine contents where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @param start the lower bound of the range of magazine contents
	* @param end the upper bound of the range of magazine contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineAndZone(
		int MagazineID, int MagazineZoneID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMagazineAndZone(MagazineID, MagazineZoneID, start,
			end, orderByComparator);
	}

	/**
	* Returns the first magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent findByMagazineAndZone_First(
		int MagazineID, int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineAndZone_First(MagazineID, MagazineZoneID,
			orderByComparator);
	}

	/**
	* Returns the first magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine content, or <code>null</code> if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent fetchByMagazineAndZone_First(
		int MagazineID, int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMagazineAndZone_First(MagazineID, MagazineZoneID,
			orderByComparator);
	}

	/**
	* Returns the last magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent findByMagazineAndZone_Last(
		int MagazineID, int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineAndZone_Last(MagazineID, MagazineZoneID,
			orderByComparator);
	}

	/**
	* Returns the last magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine content, or <code>null</code> if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent fetchByMagazineAndZone_Last(
		int MagazineID, int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMagazineAndZone_Last(MagazineID, MagazineZoneID,
			orderByComparator);
	}

	/**
	* Returns the magazine contents before and after the current magazine content in the ordered set where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* @param ID the primary key of the current magazine content
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent[] findByMagazineAndZone_PrevAndNext(
		int ID, int MagazineID, int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineAndZone_PrevAndNext(ID, MagazineID,
			MagazineZoneID, orderByComparator);
	}

	/**
	* Removes all the magazine contents where MagazineID = &#63; and MagazineZoneID = &#63; from the database.
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMagazineAndZone(int MagazineID,
		int MagazineZoneID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMagazineAndZone(MagazineID, MagazineZoneID);
	}

	/**
	* Returns the number of magazine contents where MagazineID = &#63; and MagazineZoneID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param MagazineZoneID the magazine zone i d
	* @return the number of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMagazineAndZone(int MagazineID, int MagazineZoneID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMagazineAndZone(MagazineID, MagazineZoneID);
	}

	/**
	* Returns all the magazine contents where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineID(
		int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMagazineID(MagazineID);
	}

	/**
	* Returns a range of all the magazine contents where MagazineID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param start the lower bound of the range of magazine contents
	* @param end the upper bound of the range of magazine contents (not inclusive)
	* @return the range of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineID(
		int MagazineID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMagazineID(MagazineID, start, end);
	}

	/**
	* Returns an ordered range of all the magazine contents where MagazineID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param start the lower bound of the range of magazine contents
	* @param end the upper bound of the range of magazine contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineID(
		int MagazineID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMagazineID(MagazineID, start, end, orderByComparator);
	}

	/**
	* Returns the first magazine content in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent findByMagazineID_First(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineID_First(MagazineID, orderByComparator);
	}

	/**
	* Returns the first magazine content in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine content, or <code>null</code> if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent fetchByMagazineID_First(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMagazineID_First(MagazineID, orderByComparator);
	}

	/**
	* Returns the last magazine content in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent findByMagazineID_Last(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineID_Last(MagazineID, orderByComparator);
	}

	/**
	* Returns the last magazine content in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine content, or <code>null</code> if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent fetchByMagazineID_Last(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMagazineID_Last(MagazineID, orderByComparator);
	}

	/**
	* Returns the magazine contents before and after the current magazine content in the ordered set where MagazineID = &#63;.
	*
	* @param ID the primary key of the current magazine content
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent[] findByMagazineID_PrevAndNext(
		int ID, int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineID_PrevAndNext(ID, MagazineID,
			orderByComparator);
	}

	/**
	* Removes all the magazine contents where MagazineID = &#63; from the database.
	*
	* @param MagazineID the magazine i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMagazineID(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMagazineID(MagazineID);
	}

	/**
	* Returns the number of magazine contents where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the number of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMagazineID(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMagazineID(MagazineID);
	}

	/**
	* Returns all the magazine contents where MagazineZoneID = &#63;.
	*
	* @param MagazineZoneID the magazine zone i d
	* @return the matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineZoneID(
		int MagazineZoneID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMagazineZoneID(MagazineZoneID);
	}

	/**
	* Returns a range of all the magazine contents where MagazineZoneID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineZoneID the magazine zone i d
	* @param start the lower bound of the range of magazine contents
	* @param end the upper bound of the range of magazine contents (not inclusive)
	* @return the range of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineZoneID(
		int MagazineZoneID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMagazineZoneID(MagazineZoneID, start, end);
	}

	/**
	* Returns an ordered range of all the magazine contents where MagazineZoneID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineZoneID the magazine zone i d
	* @param start the lower bound of the range of magazine contents
	* @param end the upper bound of the range of magazine contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findByMagazineZoneID(
		int MagazineZoneID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMagazineZoneID(MagazineZoneID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first magazine content in the ordered set where MagazineZoneID = &#63;.
	*
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent findByMagazineZoneID_First(
		int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineZoneID_First(MagazineZoneID, orderByComparator);
	}

	/**
	* Returns the first magazine content in the ordered set where MagazineZoneID = &#63;.
	*
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine content, or <code>null</code> if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent fetchByMagazineZoneID_First(
		int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMagazineZoneID_First(MagazineZoneID,
			orderByComparator);
	}

	/**
	* Returns the last magazine content in the ordered set where MagazineZoneID = &#63;.
	*
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent findByMagazineZoneID_Last(
		int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineZoneID_Last(MagazineZoneID, orderByComparator);
	}

	/**
	* Returns the last magazine content in the ordered set where MagazineZoneID = &#63;.
	*
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine content, or <code>null</code> if a matching magazine content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent fetchByMagazineZoneID_Last(
		int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMagazineZoneID_Last(MagazineZoneID, orderByComparator);
	}

	/**
	* Returns the magazine contents before and after the current magazine content in the ordered set where MagazineZoneID = &#63;.
	*
	* @param ID the primary key of the current magazine content
	* @param MagazineZoneID the magazine zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent[] findByMagazineZoneID_PrevAndNext(
		int ID, int MagazineZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence()
				   .findByMagazineZoneID_PrevAndNext(ID, MagazineZoneID,
			orderByComparator);
	}

	/**
	* Removes all the magazine contents where MagazineZoneID = &#63; from the database.
	*
	* @param MagazineZoneID the magazine zone i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMagazineZoneID(int MagazineZoneID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMagazineZoneID(MagazineZoneID);
	}

	/**
	* Returns the number of magazine contents where MagazineZoneID = &#63;.
	*
	* @param MagazineZoneID the magazine zone i d
	* @return the number of matching magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMagazineZoneID(int MagazineZoneID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMagazineZoneID(MagazineZoneID);
	}

	/**
	* Caches the magazine content in the entity cache if it is enabled.
	*
	* @param magazineContent the magazine content
	*/
	public static void cacheResult(
		com.viettel.portal.magazine.model.MagazineContent magazineContent) {
		getPersistence().cacheResult(magazineContent);
	}

	/**
	* Caches the magazine contents in the entity cache if it is enabled.
	*
	* @param magazineContents the magazine contents
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.magazine.model.MagazineContent> magazineContents) {
		getPersistence().cacheResult(magazineContents);
	}

	/**
	* Creates a new magazine content with the primary key. Does not add the magazine content to the database.
	*
	* @param ID the primary key for the new magazine content
	* @return the new magazine content
	*/
	public static com.viettel.portal.magazine.model.MagazineContent create(
		int ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the magazine content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the magazine content
	* @return the magazine content that was removed
	* @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent remove(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence().remove(ID);
	}

	public static com.viettel.portal.magazine.model.MagazineContent updateImpl(
		com.viettel.portal.magazine.model.MagazineContent magazineContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(magazineContent);
	}

	/**
	* Returns the magazine content with the primary key or throws a {@link com.viettel.portal.magazine.NoSuchContentException} if it could not be found.
	*
	* @param ID the primary key of the magazine content
	* @return the magazine content
	* @throws com.viettel.portal.magazine.NoSuchContentException if a magazine content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.NoSuchContentException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the magazine content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the magazine content
	* @return the magazine content, or <code>null</code> if a magazine content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.model.MagazineContent fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the magazine contents.
	*
	* @return the magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the magazine contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of magazine contents
	* @param end the upper bound of the range of magazine contents (not inclusive)
	* @return the range of magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the magazine contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.model.impl.MagazineContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of magazine contents
	* @param end the upper bound of the range of magazine contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.model.MagazineContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the magazine contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of magazine contents.
	*
	* @return the number of magazine contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MagazineContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MagazineContentPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.magazine.service.ClpSerializer.getServletContextName(),
					MagazineContentPersistence.class.getName());

			ReferenceRegistry.registerReference(MagazineContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MagazineContentPersistence persistence) {
	}

	private static MagazineContentPersistence _persistence;
}