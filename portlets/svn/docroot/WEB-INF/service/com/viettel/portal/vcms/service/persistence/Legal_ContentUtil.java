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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.vcms.model.Legal_Content;

import java.util.List;

/**
 * The persistence utility for the legal_ content service. This utility wraps {@link Legal_ContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_ContentPersistence
 * @see Legal_ContentPersistenceImpl
 * @generated
 */
public class Legal_ContentUtil {
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
	public static void clearCache(Legal_Content legal_Content) {
		getPersistence().clearCache(legal_Content);
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
	public static List<Legal_Content> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Legal_Content> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Legal_Content> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Legal_Content update(Legal_Content legal_Content)
		throws SystemException {
		return getPersistence().update(legal_Content);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Legal_Content update(Legal_Content legal_Content,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(legal_Content, serviceContext);
	}

	/**
	* Returns all the legal_ contents where Status = &#63;.
	*
	* @param Status the status
	* @return the matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyStatus(
		int Status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyStatus(Status);
	}

	/**
	* Returns a range of all the legal_ contents where Status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Status the status
	* @param start the lower bound of the range of legal_ contents
	* @param end the upper bound of the range of legal_ contents (not inclusive)
	* @return the range of matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyStatus(
		int Status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyStatus(Status, start, end);
	}

	/**
	* Returns an ordered range of all the legal_ contents where Status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Status the status
	* @param start the lower bound of the range of legal_ contents
	* @param end the upper bound of the range of legal_ contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyStatus(
		int Status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyStatus(Status, start, end, orderByComparator);
	}

	/**
	* Returns the first legal_ content in the ordered set where Status = &#63;.
	*
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content findBybyStatus_First(
		int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException {
		return getPersistence().findBybyStatus_First(Status, orderByComparator);
	}

	/**
	* Returns the first legal_ content in the ordered set where Status = &#63;.
	*
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content fetchBybyStatus_First(
		int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyStatus_First(Status, orderByComparator);
	}

	/**
	* Returns the last legal_ content in the ordered set where Status = &#63;.
	*
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content findBybyStatus_Last(
		int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException {
		return getPersistence().findBybyStatus_Last(Status, orderByComparator);
	}

	/**
	* Returns the last legal_ content in the ordered set where Status = &#63;.
	*
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content fetchBybyStatus_Last(
		int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyStatus_Last(Status, orderByComparator);
	}

	/**
	* Returns the legal_ contents before and after the current legal_ content in the ordered set where Status = &#63;.
	*
	* @param ID the primary key of the current legal_ content
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content[] findBybyStatus_PrevAndNext(
		int ID, int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException {
		return getPersistence()
				   .findBybyStatus_PrevAndNext(ID, Status, orderByComparator);
	}

	/**
	* Removes all the legal_ contents where Status = &#63; from the database.
	*
	* @param Status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyStatus(int Status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyStatus(Status);
	}

	/**
	* Returns the number of legal_ contents where Status = &#63;.
	*
	* @param Status the status
	* @return the number of matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyStatus(int Status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyStatus(Status);
	}

	/**
	* Returns all the legal_ contents where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @return the matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyZone(
		int ZoneID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyZone(ZoneID);
	}

	/**
	* Returns a range of all the legal_ contents where ZoneID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ZoneID the zone i d
	* @param start the lower bound of the range of legal_ contents
	* @param end the upper bound of the range of legal_ contents (not inclusive)
	* @return the range of matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyZone(
		int ZoneID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyZone(ZoneID, start, end);
	}

	/**
	* Returns an ordered range of all the legal_ contents where ZoneID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ZoneID the zone i d
	* @param start the lower bound of the range of legal_ contents
	* @param end the upper bound of the range of legal_ contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyZone(
		int ZoneID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyZone(ZoneID, start, end, orderByComparator);
	}

	/**
	* Returns the first legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content findBybyZone_First(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException {
		return getPersistence().findBybyZone_First(ZoneID, orderByComparator);
	}

	/**
	* Returns the first legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content fetchBybyZone_First(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyZone_First(ZoneID, orderByComparator);
	}

	/**
	* Returns the last legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content findBybyZone_Last(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException {
		return getPersistence().findBybyZone_Last(ZoneID, orderByComparator);
	}

	/**
	* Returns the last legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content fetchBybyZone_Last(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyZone_Last(ZoneID, orderByComparator);
	}

	/**
	* Returns the legal_ contents before and after the current legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ID the primary key of the current legal_ content
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content[] findBybyZone_PrevAndNext(
		int ID, int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException {
		return getPersistence()
				   .findBybyZone_PrevAndNext(ID, ZoneID, orderByComparator);
	}

	/**
	* Removes all the legal_ contents where ZoneID = &#63; from the database.
	*
	* @param ZoneID the zone i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyZone(int ZoneID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyZone(ZoneID);
	}

	/**
	* Returns the number of legal_ contents where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @return the number of matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyZone(int ZoneID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyZone(ZoneID);
	}

	/**
	* Caches the legal_ content in the entity cache if it is enabled.
	*
	* @param legal_Content the legal_ content
	*/
	public static void cacheResult(
		com.viettel.portal.vcms.model.Legal_Content legal_Content) {
		getPersistence().cacheResult(legal_Content);
	}

	/**
	* Caches the legal_ contents in the entity cache if it is enabled.
	*
	* @param legal_Contents the legal_ contents
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Legal_Content> legal_Contents) {
		getPersistence().cacheResult(legal_Contents);
	}

	/**
	* Creates a new legal_ content with the primary key. Does not add the legal_ content to the database.
	*
	* @param ID the primary key for the new legal_ content
	* @return the new legal_ content
	*/
	public static com.viettel.portal.vcms.model.Legal_Content create(int ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the legal_ content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ content
	* @return the legal_ content that was removed
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException {
		return getPersistence().remove(ID);
	}

	public static com.viettel.portal.vcms.model.Legal_Content updateImpl(
		com.viettel.portal.vcms.model.Legal_Content legal_Content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legal_Content);
	}

	/**
	* Returns the legal_ content with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_ContentException} if it could not be found.
	*
	* @param ID the primary key of the legal_ content
	* @return the legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the legal_ content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the legal_ content
	* @return the legal_ content, or <code>null</code> if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_Content fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the legal_ contents.
	*
	* @return the legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the legal_ contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ contents
	* @param end the upper bound of the range of legal_ contents (not inclusive)
	* @return the range of legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the legal_ contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ contents
	* @param end the upper bound of the range of legal_ contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_Content> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legal_ contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legal_ contents.
	*
	* @return the number of legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Legal_ContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Legal_ContentPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					Legal_ContentPersistence.class.getName());

			ReferenceRegistry.registerReference(Legal_ContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Legal_ContentPersistence persistence) {
	}

	private static Legal_ContentPersistence _persistence;
}