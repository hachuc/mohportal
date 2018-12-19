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

import com.viettel.portal.vcms.model.Legal_Content;

/**
 * The persistence interface for the legal_ content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_ContentPersistenceImpl
 * @see Legal_ContentUtil
 * @generated
 */
public interface Legal_ContentPersistence extends BasePersistence<Legal_Content> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Legal_ContentUtil} to access the legal_ content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the legal_ contents where Status = &#63;.
	*
	* @param Status the status
	* @return the matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyStatus(
		int Status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyStatus(
		int Status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyStatus(
		int Status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal_ content in the ordered set where Status = &#63;.
	*
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content findBybyStatus_First(
		int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException;

	/**
	* Returns the first legal_ content in the ordered set where Status = &#63;.
	*
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content fetchBybyStatus_First(
		int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal_ content in the ordered set where Status = &#63;.
	*
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content findBybyStatus_Last(
		int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException;

	/**
	* Returns the last legal_ content in the ordered set where Status = &#63;.
	*
	* @param Status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content fetchBybyStatus_Last(
		int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.vcms.model.Legal_Content[] findBybyStatus_PrevAndNext(
		int ID, int Status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException;

	/**
	* Removes all the legal_ contents where Status = &#63; from the database.
	*
	* @param Status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyStatus(int Status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ contents where Status = &#63;.
	*
	* @param Status the status
	* @return the number of matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyStatus(int Status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legal_ contents where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @return the matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyZone(
		int ZoneID) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyZone(
		int ZoneID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findBybyZone(
		int ZoneID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content findBybyZone_First(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException;

	/**
	* Returns the first legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content fetchBybyZone_First(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content findBybyZone_Last(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException;

	/**
	* Returns the last legal_ content in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ content, or <code>null</code> if a matching legal_ content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content fetchBybyZone_Last(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.viettel.portal.vcms.model.Legal_Content[] findBybyZone_PrevAndNext(
		int ID, int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException;

	/**
	* Removes all the legal_ contents where ZoneID = &#63; from the database.
	*
	* @param ZoneID the zone i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyZone(int ZoneID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ contents where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @return the number of matching legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyZone(int ZoneID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the legal_ content in the entity cache if it is enabled.
	*
	* @param legal_Content the legal_ content
	*/
	public void cacheResult(
		com.viettel.portal.vcms.model.Legal_Content legal_Content);

	/**
	* Caches the legal_ contents in the entity cache if it is enabled.
	*
	* @param legal_Contents the legal_ contents
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Legal_Content> legal_Contents);

	/**
	* Creates a new legal_ content with the primary key. Does not add the legal_ content to the database.
	*
	* @param ID the primary key for the new legal_ content
	* @return the new legal_ content
	*/
	public com.viettel.portal.vcms.model.Legal_Content create(int ID);

	/**
	* Removes the legal_ content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ content
	* @return the legal_ content that was removed
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException;

	public com.viettel.portal.vcms.model.Legal_Content updateImpl(
		com.viettel.portal.vcms.model.Legal_Content legal_Content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal_ content with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_ContentException} if it could not be found.
	*
	* @param ID the primary key of the legal_ content
	* @return the legal_ content
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentException if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content findByPrimaryKey(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentException;

	/**
	* Returns the legal_ content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the legal_ content
	* @return the legal_ content, or <code>null</code> if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Content fetchByPrimaryKey(int ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legal_ contents.
	*
	* @return the legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal_ contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ contents.
	*
	* @return the number of legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}