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

import com.viettel.portal.vcms.model.Legal_ContentProfit;

import java.util.List;

/**
 * The persistence utility for the legal_ content profit service. This utility wraps {@link Legal_ContentProfitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_ContentProfitPersistence
 * @see Legal_ContentProfitPersistenceImpl
 * @generated
 */
public class Legal_ContentProfitUtil {
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
	public static void clearCache(Legal_ContentProfit legal_ContentProfit) {
		getPersistence().clearCache(legal_ContentProfit);
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
	public static List<Legal_ContentProfit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Legal_ContentProfit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Legal_ContentProfit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Legal_ContentProfit update(
		Legal_ContentProfit legal_ContentProfit) throws SystemException {
		return getPersistence().update(legal_ContentProfit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Legal_ContentProfit update(
		Legal_ContentProfit legal_ContentProfit, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(legal_ContentProfit, serviceContext);
	}

	/**
	* Caches the legal_ content profit in the entity cache if it is enabled.
	*
	* @param legal_ContentProfit the legal_ content profit
	*/
	public static void cacheResult(
		com.viettel.portal.vcms.model.Legal_ContentProfit legal_ContentProfit) {
		getPersistence().cacheResult(legal_ContentProfit);
	}

	/**
	* Caches the legal_ content profits in the entity cache if it is enabled.
	*
	* @param legal_ContentProfits the legal_ content profits
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Legal_ContentProfit> legal_ContentProfits) {
		getPersistence().cacheResult(legal_ContentProfits);
	}

	/**
	* Creates a new legal_ content profit with the primary key. Does not add the legal_ content profit to the database.
	*
	* @param ContentID the primary key for the new legal_ content profit
	* @return the new legal_ content profit
	*/
	public static com.viettel.portal.vcms.model.Legal_ContentProfit create(
		int ContentID) {
		return getPersistence().create(ContentID);
	}

	/**
	* Removes the legal_ content profit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ContentID the primary key of the legal_ content profit
	* @return the legal_ content profit that was removed
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentProfitException if a legal_ content profit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_ContentProfit remove(
		int ContentID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentProfitException {
		return getPersistence().remove(ContentID);
	}

	public static com.viettel.portal.vcms.model.Legal_ContentProfit updateImpl(
		com.viettel.portal.vcms.model.Legal_ContentProfit legal_ContentProfit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legal_ContentProfit);
	}

	/**
	* Returns the legal_ content profit with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_ContentProfitException} if it could not be found.
	*
	* @param ContentID the primary key of the legal_ content profit
	* @return the legal_ content profit
	* @throws com.viettel.portal.vcms.NoSuchLegal_ContentProfitException if a legal_ content profit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_ContentProfit findByPrimaryKey(
		int ContentID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_ContentProfitException {
		return getPersistence().findByPrimaryKey(ContentID);
	}

	/**
	* Returns the legal_ content profit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ContentID the primary key of the legal_ content profit
	* @return the legal_ content profit, or <code>null</code> if a legal_ content profit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Legal_ContentProfit fetchByPrimaryKey(
		int ContentID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ContentID);
	}

	/**
	* Returns all the legal_ content profits.
	*
	* @return the legal_ content profits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_ContentProfit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the legal_ content profits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ content profits
	* @param end the upper bound of the range of legal_ content profits (not inclusive)
	* @return the range of legal_ content profits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_ContentProfit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the legal_ content profits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ content profits
	* @param end the upper bound of the range of legal_ content profits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legal_ content profits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Legal_ContentProfit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legal_ content profits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legal_ content profits.
	*
	* @return the number of legal_ content profits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Legal_ContentProfitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Legal_ContentProfitPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					Legal_ContentProfitPersistence.class.getName());

			ReferenceRegistry.registerReference(Legal_ContentProfitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Legal_ContentProfitPersistence persistence) {
	}

	private static Legal_ContentProfitPersistence _persistence;
}