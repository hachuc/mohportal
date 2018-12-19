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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viettel.portal.vbpq.model.NhomVanBan;

import java.util.List;

/**
 * The persistence utility for the nhom van ban service. This utility wraps {@link NhomVanBanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see NhomVanBanPersistence
 * @see NhomVanBanPersistenceImpl
 * @generated
 */
public class NhomVanBanUtil {
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
	public static void clearCache(NhomVanBan nhomVanBan) {
		getPersistence().clearCache(nhomVanBan);
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
	public static List<NhomVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NhomVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NhomVanBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static NhomVanBan update(NhomVanBan nhomVanBan)
		throws SystemException {
		return getPersistence().update(nhomVanBan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static NhomVanBan update(NhomVanBan nhomVanBan,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(nhomVanBan, serviceContext);
	}

	/**
	* Caches the nhom van ban in the entity cache if it is enabled.
	*
	* @param nhomVanBan the nhom van ban
	*/
	public static void cacheResult(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan) {
		getPersistence().cacheResult(nhomVanBan);
	}

	/**
	* Caches the nhom van bans in the entity cache if it is enabled.
	*
	* @param nhomVanBans the nhom van bans
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> nhomVanBans) {
		getPersistence().cacheResult(nhomVanBans);
	}

	/**
	* Creates a new nhom van ban with the primary key. Does not add the nhom van ban to the database.
	*
	* @param id the primary key for the new nhom van ban
	* @return the new nhom van ban
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the nhom van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban that was removed
	* @throws com.viettel.portal.vbpq.NoSuchNhomVanBanException if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchNhomVanBanException {
		return getPersistence().remove(id);
	}

	public static com.viettel.portal.vbpq.model.NhomVanBan updateImpl(
		com.viettel.portal.vbpq.model.NhomVanBan nhomVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(nhomVanBan);
	}

	/**
	* Returns the nhom van ban with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchNhomVanBanException} if it could not be found.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban
	* @throws com.viettel.portal.vbpq.NoSuchNhomVanBanException if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchNhomVanBanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the nhom van ban with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the nhom van ban
	* @return the nhom van ban, or <code>null</code> if a nhom van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vbpq.model.NhomVanBan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the nhom van bans.
	*
	* @return the nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viettel.portal.vbpq.model.NhomVanBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the nhom van bans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of nhom van bans.
	*
	* @return the number of nhom van bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NhomVanBanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NhomVanBanPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vbpq.service.ClpSerializer.getServletContextName(),
					NhomVanBanPersistence.class.getName());

			ReferenceRegistry.registerReference(NhomVanBanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NhomVanBanPersistence persistence) {
	}

	private static NhomVanBanPersistence _persistence;
}