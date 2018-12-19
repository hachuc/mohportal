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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.magazine.archive.model.Magazine;

import java.util.List;

/**
 * The persistence utility for the magazine service. This utility wraps {@link MagazinePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see MagazinePersistence
 * @see MagazinePersistenceImpl
 * @generated
 */
public class MagazineUtil {
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
	public static void clearCache(Magazine magazine) {
		getPersistence().clearCache(magazine);
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
	public static List<Magazine> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Magazine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Magazine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Magazine update(Magazine magazine) throws SystemException {
		return getPersistence().update(magazine);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Magazine update(Magazine magazine,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(magazine, serviceContext);
	}

	/**
	* Returns all the magazines where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @return the matching magazines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findByPublishNumberAndYear(
		int PublishYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishNumberAndYear(PublishYear);
	}

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
	public static java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findByPublishNumberAndYear(
		int PublishYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishNumberAndYear(PublishYear, start, end);
	}

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
	public static java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findByPublishNumberAndYear(
		int PublishYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishNumberAndYear(PublishYear, start, end,
			orderByComparator);
	}

	/**
	* Returns the first magazine in the ordered set where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a matching magazine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.archive.model.Magazine findByPublishNumberAndYear_First(
		int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException {
		return getPersistence()
				   .findByPublishNumberAndYear_First(PublishYear,
			orderByComparator);
	}

	/**
	* Returns the first magazine in the ordered set where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching magazine, or <code>null</code> if a matching magazine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.archive.model.Magazine fetchByPublishNumberAndYear_First(
		int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishNumberAndYear_First(PublishYear,
			orderByComparator);
	}

	/**
	* Returns the last magazine in the ordered set where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a matching magazine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.archive.model.Magazine findByPublishNumberAndYear_Last(
		int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException {
		return getPersistence()
				   .findByPublishNumberAndYear_Last(PublishYear,
			orderByComparator);
	}

	/**
	* Returns the last magazine in the ordered set where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching magazine, or <code>null</code> if a matching magazine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.archive.model.Magazine fetchByPublishNumberAndYear_Last(
		int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishNumberAndYear_Last(PublishYear,
			orderByComparator);
	}

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
	public static com.viettel.portal.magazine.archive.model.Magazine[] findByPublishNumberAndYear_PrevAndNext(
		int ID, int PublishYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException {
		return getPersistence()
				   .findByPublishNumberAndYear_PrevAndNext(ID, PublishYear,
			orderByComparator);
	}

	/**
	* Removes all the magazines where PublishYear = &#63; from the database.
	*
	* @param PublishYear the publish year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishNumberAndYear(int PublishYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishNumberAndYear(PublishYear);
	}

	/**
	* Returns the number of magazines where PublishYear = &#63;.
	*
	* @param PublishYear the publish year
	* @return the number of matching magazines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishNumberAndYear(int PublishYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishNumberAndYear(PublishYear);
	}

	/**
	* Caches the magazine in the entity cache if it is enabled.
	*
	* @param magazine the magazine
	*/
	public static void cacheResult(
		com.viettel.portal.magazine.archive.model.Magazine magazine) {
		getPersistence().cacheResult(magazine);
	}

	/**
	* Caches the magazines in the entity cache if it is enabled.
	*
	* @param magazines the magazines
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.magazine.archive.model.Magazine> magazines) {
		getPersistence().cacheResult(magazines);
	}

	/**
	* Creates a new magazine with the primary key. Does not add the magazine to the database.
	*
	* @param ID the primary key for the new magazine
	* @return the new magazine
	*/
	public static com.viettel.portal.magazine.archive.model.Magazine create(
		int ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the magazine with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the magazine
	* @return the magazine that was removed
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.archive.model.Magazine remove(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException {
		return getPersistence().remove(ID);
	}

	public static com.viettel.portal.magazine.archive.model.Magazine updateImpl(
		com.viettel.portal.magazine.archive.model.Magazine magazine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(magazine);
	}

	/**
	* Returns the magazine with the primary key or throws a {@link com.viettel.portal.magazine.archive.NoSuchMagazineException} if it could not be found.
	*
	* @param ID the primary key of the magazine
	* @return the magazine
	* @throws com.viettel.portal.magazine.archive.NoSuchMagazineException if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.archive.model.Magazine findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchMagazineException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the magazine with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the magazine
	* @return the magazine, or <code>null</code> if a magazine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.magazine.archive.model.Magazine fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the magazines.
	*
	* @return the magazines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viettel.portal.magazine.archive.model.Magazine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the magazines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of magazines.
	*
	* @return the number of magazines
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MagazinePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MagazinePersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.magazine.archive.service.ClpSerializer.getServletContextName(),
					MagazinePersistence.class.getName());

			ReferenceRegistry.registerReference(MagazineUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MagazinePersistence persistence) {
	}

	private static MagazinePersistence _persistence;
}