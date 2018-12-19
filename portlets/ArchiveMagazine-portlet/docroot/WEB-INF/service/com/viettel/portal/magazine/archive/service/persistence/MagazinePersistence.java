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

package com.viettel.portal.magazine.archive.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.magazine.archive.model.Magazine;

/**
 * The persistence interface for the magazine service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see MagazinePersistenceImpl
 * @see MagazineUtil
 * @generated
 */
public interface MagazinePersistence extends BasePersistence<Magazine> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MagazineUtil} to access the magazine persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the magazines where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @return the matching magazines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findByPublishNumberAndYear(
		int PublishYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the magazines where PublishYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PublishYear the publish year
	* @param start the lower bound of the range of magazines
	* @param end the upper bound of the range of magazines (not inclusive)
	* @return the range of matching magazines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findByPublishNumberAndYear(
		int PublishYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the magazines where PublishYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PublishYear the publish year
	* @param start the lower bound of the range of magazines
	* @param end the upper bound of the range of magazines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching magazines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findByPublishNumberAndYear(
		int PublishYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first magazine in the ordered set where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a matching magazine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Magazine findByPublishNumberAndYear_First(
		int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException;

	/**
	* Returns the first magazine in the ordered set where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine, or <code>null</code> if a matching magazine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Magazine fetchByPublishNumberAndYear_First(
		int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last magazine in the ordered set where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a matching magazine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Magazine findByPublishNumberAndYear_Last(
		int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException;

	/**
	* Returns the last magazine in the ordered set where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine, or <code>null</code> if a matching magazine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Magazine fetchByPublishNumberAndYear_Last(
		int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the magazines before and after the current magazine in the ordered set where PublishYear = &#63;.
	*
	* @param ID the primary key of the current magazine
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next magazine
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Magazine[] findByPublishNumberAndYear_PrevAndNext(
		int ID, int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException;

	/**
	* Removes all the magazines where PublishYear = &#63; from the database.
	*
	* @param PublishYear the publish year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishNumberAndYear(int PublishYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of magazines where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @return the number of matching magazines
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishNumberAndYear(int PublishYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the magazine in the entity cache if it is enabled.
	*
	* @param magazine the magazine
	*/
	public void cacheResult(
		com.viettel.portal.magazine.archive.model.Magazine magazine);

	/**
	* Caches the magazines in the entity cache if it is enabled.
	*
	* @param magazines the magazines
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.magazine.archive.model.Magazine> magazines);

	/**
	* Creates a new magazine with the primary key. Does not add the magazine to the database.
	*
	* @param ID the primary key for the new magazine
	* @return the new magazine
	*/
	public com.viettel.portal.magazine.archive.model.Magazine create(int ID);

	/**
	* Removes the magazine with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the magazine
	* @return the magazine that was removed
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Magazine remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException;

	public com.viettel.portal.magazine.archive.model.Magazine updateImpl(
		com.viettel.portal.magazine.archive.model.Magazine magazine)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the magazine with the primary key or throws a {@link com.viettel.portal.magazine.archive.NoSuchMagazineException} if it could not be found.
	*
	* @param ID the primary key of the magazine
	* @return the magazine
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Magazine findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException;

	/**
	* Returns the magazine with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the magazine
	* @return the magazine, or <code>null</code> if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Magazine fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the magazines.
	*
	* @return the magazines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the magazines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of magazines
	* @param end the upper bound of the range of magazines (not inclusive)
	* @return the range of magazines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the magazines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.MagazineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of magazines
	* @param end the upper bound of the range of magazines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of magazines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the magazines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of magazines.
	*
	* @return the number of magazines
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}