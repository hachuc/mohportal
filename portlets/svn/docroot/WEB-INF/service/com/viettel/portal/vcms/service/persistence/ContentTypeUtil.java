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

import com.viettel.portal.vcms.model.ContentType;

import java.util.List;

/**
 * The persistence utility for the content type service. This utility wraps {@link ContentTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see ContentTypePersistence
 * @see ContentTypePersistenceImpl
 * @generated
 */
public class ContentTypeUtil {
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
	public static void clearCache(ContentType contentType) {
		getPersistence().clearCache(contentType);
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
	public static List<ContentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ContentType update(ContentType contentType)
		throws SystemException {
		return getPersistence().update(contentType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ContentType update(ContentType contentType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contentType, serviceContext);
	}

	/**
	* Returns all the content types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the content types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of content types
	* @param end the upper bound of the range of content types (not inclusive)
	* @return the range of matching content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the content types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of content types
	* @param end the upper bound of the range of content types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first content type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type
	* @throws com.viettel.portal.vcms.NoSuchContentTypeException if a matching content type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first content type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type, or <code>null</code> if a matching content type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last content type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type
	* @throws com.viettel.portal.vcms.NoSuchContentTypeException if a matching content type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last content type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type, or <code>null</code> if a matching content type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the content types before and after the current content type in the ordered set where groupId = &#63;.
	*
	* @param contenTypeId the primary key of the current content type
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content type
	* @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType[] findByGroupId_PrevAndNext(
		long contenTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(contenTypeId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the content types where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of content types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching content types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the content types where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findBySearch(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySearch(groupId, name);
	}

	/**
	* Returns a range of all the content types where groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of content types
	* @param end the upper bound of the range of content types (not inclusive)
	* @return the range of matching content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findBySearch(
		long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySearch(groupId, name, start, end);
	}

	/**
	* Returns an ordered range of all the content types where groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of content types
	* @param end the upper bound of the range of content types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findBySearch(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearch(groupId, name, start, end, orderByComparator);
	}

	/**
	* Returns the first content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type
	* @throws com.viettel.portal.vcms.NoSuchContentTypeException if a matching content type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType findBySearch_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeException {
		return getPersistence()
				   .findBySearch_First(groupId, name, orderByComparator);
	}

	/**
	* Returns the first content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content type, or <code>null</code> if a matching content type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType fetchBySearch_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearch_First(groupId, name, orderByComparator);
	}

	/**
	* Returns the last content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type
	* @throws com.viettel.portal.vcms.NoSuchContentTypeException if a matching content type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType findBySearch_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeException {
		return getPersistence()
				   .findBySearch_Last(groupId, name, orderByComparator);
	}

	/**
	* Returns the last content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content type, or <code>null</code> if a matching content type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType fetchBySearch_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearch_Last(groupId, name, orderByComparator);
	}

	/**
	* Returns the content types before and after the current content type in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param contenTypeId the primary key of the current content type
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content type
	* @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType[] findBySearch_PrevAndNext(
		long contenTypeId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeException {
		return getPersistence()
				   .findBySearch_PrevAndNext(contenTypeId, groupId, name,
			orderByComparator);
	}

	/**
	* Removes all the content types where groupId = &#63; and name LIKE &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySearch(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySearch(groupId, name);
	}

	/**
	* Returns the number of content types where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching content types
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySearch(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySearch(groupId, name);
	}

	/**
	* Caches the content type in the entity cache if it is enabled.
	*
	* @param contentType the content type
	*/
	public static void cacheResult(
		com.viettel.portal.vcms.model.ContentType contentType) {
		getPersistence().cacheResult(contentType);
	}

	/**
	* Caches the content types in the entity cache if it is enabled.
	*
	* @param contentTypes the content types
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.ContentType> contentTypes) {
		getPersistence().cacheResult(contentTypes);
	}

	/**
	* Creates a new content type with the primary key. Does not add the content type to the database.
	*
	* @param contenTypeId the primary key for the new content type
	* @return the new content type
	*/
	public static com.viettel.portal.vcms.model.ContentType create(
		long contenTypeId) {
		return getPersistence().create(contenTypeId);
	}

	/**
	* Removes the content type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contenTypeId the primary key of the content type
	* @return the content type that was removed
	* @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType remove(
		long contenTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeException {
		return getPersistence().remove(contenTypeId);
	}

	public static com.viettel.portal.vcms.model.ContentType updateImpl(
		com.viettel.portal.vcms.model.ContentType contentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contentType);
	}

	/**
	* Returns the content type with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentTypeException} if it could not be found.
	*
	* @param contenTypeId the primary key of the content type
	* @return the content type
	* @throws com.viettel.portal.vcms.NoSuchContentTypeException if a content type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType findByPrimaryKey(
		long contenTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentTypeException {
		return getPersistence().findByPrimaryKey(contenTypeId);
	}

	/**
	* Returns the content type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contenTypeId the primary key of the content type
	* @return the content type, or <code>null</code> if a content type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.ContentType fetchByPrimaryKey(
		long contenTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contenTypeId);
	}

	/**
	* Returns all the content types.
	*
	* @return the content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the content types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content types
	* @param end the upper bound of the range of content types (not inclusive)
	* @return the range of content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the content types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content types
	* @param end the upper bound of the range of content types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of content types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.ContentType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the content types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of content types.
	*
	* @return the number of content types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContentTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContentTypePersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					ContentTypePersistence.class.getName());

			ReferenceRegistry.registerReference(ContentTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ContentTypePersistence persistence) {
	}

	private static ContentTypePersistence _persistence;
}