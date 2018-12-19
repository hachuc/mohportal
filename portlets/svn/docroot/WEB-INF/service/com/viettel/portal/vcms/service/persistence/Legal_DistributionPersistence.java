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

import com.viettel.portal.vcms.model.Legal_Distribution;

/**
 * The persistence interface for the legal_ distribution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_DistributionPersistenceImpl
 * @see Legal_DistributionUtil
 * @generated
 */
public interface Legal_DistributionPersistence extends BasePersistence<Legal_Distribution> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Legal_DistributionUtil} to access the legal_ distribution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the legal_ distributions where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @return the matching legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> findByByZoneID(
		int ZoneID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal_ distributions where ZoneID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ZoneID the zone i d
	* @param start the lower bound of the range of legal_ distributions
	* @param end the upper bound of the range of legal_ distributions (not inclusive)
	* @return the range of matching legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> findByByZoneID(
		int ZoneID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal_ distributions where ZoneID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ZoneID the zone i d
	* @param start the lower bound of the range of legal_ distributions
	* @param end the upper bound of the range of legal_ distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> findByByZoneID(
		int ZoneID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal_ distribution in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ distribution
	* @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a matching legal_ distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution findByByZoneID_First(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_DistributionException;

	/**
	* Returns the first legal_ distribution in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ distribution, or <code>null</code> if a matching legal_ distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution fetchByByZoneID_First(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal_ distribution in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ distribution
	* @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a matching legal_ distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution findByByZoneID_Last(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_DistributionException;

	/**
	* Returns the last legal_ distribution in the ordered set where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ distribution, or <code>null</code> if a matching legal_ distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution fetchByByZoneID_Last(
		int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal_ distributions before and after the current legal_ distribution in the ordered set where ZoneID = &#63;.
	*
	* @param ID the primary key of the current legal_ distribution
	* @param ZoneID the zone i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal_ distribution
	* @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a legal_ distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution[] findByByZoneID_PrevAndNext(
		int ID, int ZoneID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_DistributionException;

	/**
	* Removes all the legal_ distributions where ZoneID = &#63; from the database.
	*
	* @param ZoneID the zone i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByZoneID(int ZoneID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ distributions where ZoneID = &#63;.
	*
	* @param ZoneID the zone i d
	* @return the number of matching legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	public int countByByZoneID(int ZoneID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the legal_ distribution in the entity cache if it is enabled.
	*
	* @param legal_Distribution the legal_ distribution
	*/
	public void cacheResult(
		com.viettel.portal.vcms.model.Legal_Distribution legal_Distribution);

	/**
	* Caches the legal_ distributions in the entity cache if it is enabled.
	*
	* @param legal_Distributions the legal_ distributions
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> legal_Distributions);

	/**
	* Creates a new legal_ distribution with the primary key. Does not add the legal_ distribution to the database.
	*
	* @param ID the primary key for the new legal_ distribution
	* @return the new legal_ distribution
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution create(int ID);

	/**
	* Removes the legal_ distribution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ distribution
	* @return the legal_ distribution that was removed
	* @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a legal_ distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_DistributionException;

	public com.viettel.portal.vcms.model.Legal_Distribution updateImpl(
		com.viettel.portal.vcms.model.Legal_Distribution legal_Distribution)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal_ distribution with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_DistributionException} if it could not be found.
	*
	* @param ID the primary key of the legal_ distribution
	* @return the legal_ distribution
	* @throws com.viettel.portal.vcms.NoSuchLegal_DistributionException if a legal_ distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_DistributionException;

	/**
	* Returns the legal_ distribution with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the legal_ distribution
	* @return the legal_ distribution, or <code>null</code> if a legal_ distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Distribution fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legal_ distributions.
	*
	* @return the legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal_ distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ distributions
	* @param end the upper bound of the range of legal_ distributions (not inclusive)
	* @return the range of legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal_ distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ distributions
	* @param end the upper bound of the range of legal_ distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Distribution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal_ distributions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ distributions.
	*
	* @return the number of legal_ distributions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}