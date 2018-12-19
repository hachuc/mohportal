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

import com.viettel.portal.vcms.model.Content;

import java.util.List;

/**
 * The persistence utility for the content service. This utility wraps {@link ContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see ContentPersistence
 * @see ContentPersistenceImpl
 * @generated
 */
public class ContentUtil {
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
	public static void clearCache(Content content) {
		getPersistence().clearCache(content);
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
	public static List<Content> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Content> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Content> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Content update(Content content) throws SystemException {
		return getPersistence().update(content);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Content update(Content content, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(content, serviceContext);
	}

	/**
	* Returns all the contents where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_U(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U(groupId, urlTitle);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and urlTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_U(
		long groupId, java.lang.String urlTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U(groupId, urlTitle, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and urlTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_U(
		long groupId, java.lang.String urlTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U(groupId, urlTitle, start, end, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_U_First(
		long groupId, java.lang.String urlTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_U_First(groupId, urlTitle, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_U_First(
		long groupId, java.lang.String urlTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_U_First(groupId, urlTitle, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_U_Last(
		long groupId, java.lang.String urlTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_U_Last(groupId, urlTitle, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_U_Last(
		long groupId, java.lang.String urlTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_U_Last(groupId, urlTitle, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and urlTitle = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_U_PrevAndNext(
		long autoId, long groupId, java.lang.String urlTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_U_PrevAndNext(autoId, groupId, urlTitle,
			orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_U(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_U(groupId, urlTitle);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and urlTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_U(
		long groupId, java.lang.String urlTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_U(groupId, urlTitle, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and urlTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_U(
		long groupId, java.lang.String urlTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U(groupId, urlTitle, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and urlTitle = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_U_PrevAndNext(
		long autoId, long groupId, java.lang.String urlTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_U_PrevAndNext(autoId, groupId, urlTitle,
			orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and urlTitle = &#63; from the database.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_U(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_U(groupId, urlTitle);
	}

	/**
	* Returns the number of contents where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_U(groupId, urlTitle);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_U(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_U(groupId, urlTitle);
	}

	/**
	* Returns all the contents where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, categoryId);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C(groupId, categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_C_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_First(groupId, categoryId, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_C_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_First(groupId, categoryId, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_C_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_Last(groupId, categoryId, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_C_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_Last(groupId, categoryId, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_C_PrevAndNext(
		long autoId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_PrevAndNext(autoId, groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C(groupId, categoryId);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C(groupId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C(groupId, categoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_C_PrevAndNext(
		long autoId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_C_PrevAndNext(autoId, groupId, categoryId,
			orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C(groupId, categoryId);
	}

	/**
	* Returns the number of contents where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C(groupId, categoryId);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_C(groupId, categoryId);
	}

	/**
	* Returns all the contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CA_V_S(
		long groupId, long categoryId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CA_V_S(groupId, categoryId, version, status);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CA_V_S(
		long groupId, long categoryId, int version, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CA_V_S(groupId, categoryId, version, status, start,
			end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CA_V_S(
		long groupId, long categoryId, int version, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CA_V_S(groupId, categoryId, version, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_CA_V_S_First(
		long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CA_V_S_First(groupId, categoryId, version, status,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_CA_V_S_First(
		long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_CA_V_S_First(groupId, categoryId, version, status,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_CA_V_S_Last(
		long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CA_V_S_Last(groupId, categoryId, version, status,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_CA_V_S_Last(
		long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_CA_V_S_Last(groupId, categoryId, version, status,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_CA_V_S_PrevAndNext(
		long autoId, long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CA_V_S_PrevAndNext(autoId, groupId, categoryId,
			version, status, orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CA_V_S(
		long groupId, long categoryId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_CA_V_S(groupId, categoryId, version, status);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CA_V_S(
		long groupId, long categoryId, int version, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_CA_V_S(groupId, categoryId, version, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CA_V_S(
		long groupId, long categoryId, int version, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_CA_V_S(groupId, categoryId, version, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_CA_V_S_PrevAndNext(
		long autoId, long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_CA_V_S_PrevAndNext(autoId, groupId,
			categoryId, version, status, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_CA_V_S(long groupId, long categoryId,
		int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_CA_V_S(groupId, categoryId, version, status);
	}

	/**
	* Returns the number of contents where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_CA_V_S(long groupId, long categoryId,
		int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_CA_V_S(groupId, categoryId, version, status);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_CA_V_S(long groupId, long categoryId,
		int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_CA_V_S(groupId, categoryId, version, status);
	}

	/**
	* Returns all the contents where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_B_U(
		long groupId, long createdByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C_B_U(groupId, createdByUserId);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and createdByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_B_U(
		long groupId, long createdByUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_B_U(groupId, createdByUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and createdByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_B_U(
		long groupId, long createdByUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_B_U(groupId, createdByUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_C_B_U_First(
		long groupId, long createdByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_B_U_First(groupId, createdByUserId,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_C_B_U_First(
		long groupId, long createdByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_B_U_First(groupId, createdByUserId,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_C_B_U_Last(
		long groupId, long createdByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_B_U_Last(groupId, createdByUserId,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_C_B_U_Last(
		long groupId, long createdByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_B_U_Last(groupId, createdByUserId,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_C_B_U_PrevAndNext(
		long autoId, long groupId, long createdByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_B_U_PrevAndNext(autoId, groupId, createdByUserId,
			orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_B_U(
		long groupId, long createdByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C_B_U(groupId, createdByUserId);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_B_U(
		long groupId, long createdByUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_B_U(groupId, createdByUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and createdByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_B_U(
		long groupId, long createdByUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_B_U(groupId, createdByUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_C_B_U_PrevAndNext(
		long autoId, long groupId, long createdByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_C_B_U_PrevAndNext(autoId, groupId,
			createdByUserId, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and createdByUserId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_B_U(long groupId, long createdByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_B_U(groupId, createdByUserId);
	}

	/**
	* Returns the number of contents where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_B_U(long groupId, long createdByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C_B_U(groupId, createdByUserId);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C_B_U(long groupId, long createdByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_C_B_U(groupId, createdByUserId);
	}

	/**
	* Returns all the contents where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_E_B_U(
		long groupId, long editedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_E_B_U(groupId, editedByUserId);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and editedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_E_B_U(
		long groupId, long editedByUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E_B_U(groupId, editedByUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and editedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_E_B_U(
		long groupId, long editedByUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E_B_U(groupId, editedByUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_E_B_U_First(
		long groupId, long editedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_E_B_U_First(groupId, editedByUserId,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_E_B_U_First(
		long groupId, long editedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_E_B_U_First(groupId, editedByUserId,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_E_B_U_Last(
		long groupId, long editedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_E_B_U_Last(groupId, editedByUserId,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_E_B_U_Last(
		long groupId, long editedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_E_B_U_Last(groupId, editedByUserId,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_E_B_U_PrevAndNext(
		long autoId, long groupId, long editedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_E_B_U_PrevAndNext(autoId, groupId, editedByUserId,
			orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_E_B_U(
		long groupId, long editedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_E_B_U(groupId, editedByUserId);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and editedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_E_B_U(
		long groupId, long editedByUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_E_B_U(groupId, editedByUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and editedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_E_B_U(
		long groupId, long editedByUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_E_B_U(groupId, editedByUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_E_B_U_PrevAndNext(
		long autoId, long groupId, long editedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_E_B_U_PrevAndNext(autoId, groupId,
			editedByUserId, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and editedByUserId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_E_B_U(long groupId, long editedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_E_B_U(groupId, editedByUserId);
	}

	/**
	* Returns the number of contents where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_E_B_U(long groupId, long editedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_E_B_U(groupId, editedByUserId);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and editedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param editedByUserId the edited by user ID
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_E_B_U(long groupId, long editedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_E_B_U(groupId, editedByUserId);
	}

	/**
	* Returns all the contents where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_R_B_U(
		long groupId, long reviewedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R_B_U(groupId, reviewedByUserId);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_R_B_U(
		long groupId, long reviewedByUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_B_U(groupId, reviewedByUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_R_B_U(
		long groupId, long reviewedByUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_B_U(groupId, reviewedByUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_R_B_U_First(
		long groupId, long reviewedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_R_B_U_First(groupId, reviewedByUserId,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_R_B_U_First(
		long groupId, long reviewedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_R_B_U_First(groupId, reviewedByUserId,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_R_B_U_Last(
		long groupId, long reviewedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_R_B_U_Last(groupId, reviewedByUserId,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_R_B_U_Last(
		long groupId, long reviewedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_R_B_U_Last(groupId, reviewedByUserId,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_R_B_U_PrevAndNext(
		long autoId, long groupId, long reviewedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_R_B_U_PrevAndNext(autoId, groupId,
			reviewedByUserId, orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_R_B_U(
		long groupId, long reviewedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_R_B_U(groupId, reviewedByUserId);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_R_B_U(
		long groupId, long reviewedByUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_R_B_U(groupId, reviewedByUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_R_B_U(
		long groupId, long reviewedByUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_R_B_U(groupId, reviewedByUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_R_B_U_PrevAndNext(
		long autoId, long groupId, long reviewedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_R_B_U_PrevAndNext(autoId, groupId,
			reviewedByUserId, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and reviewedByUserId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_R_B_U(long groupId, long reviewedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_R_B_U(groupId, reviewedByUserId);
	}

	/**
	* Returns the number of contents where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_R_B_U(long groupId, long reviewedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_R_B_U(groupId, reviewedByUserId);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and reviewedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param reviewedByUserId the reviewed by user ID
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_R_B_U(long groupId, long reviewedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_R_B_U(groupId, reviewedByUserId);
	}

	/**
	* Returns all the contents where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_P_B_U(
		long groupId, long publishedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P_B_U(groupId, publishedByUserId);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and publishedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_P_B_U(
		long groupId, long publishedByUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P_B_U(groupId, publishedByUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and publishedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_P_B_U(
		long groupId, long publishedByUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P_B_U(groupId, publishedByUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_P_B_U_First(
		long groupId, long publishedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_P_B_U_First(groupId, publishedByUserId,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_P_B_U_First(
		long groupId, long publishedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_B_U_First(groupId, publishedByUserId,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_P_B_U_Last(
		long groupId, long publishedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_P_B_U_Last(groupId, publishedByUserId,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_P_B_U_Last(
		long groupId, long publishedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_B_U_Last(groupId, publishedByUserId,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_P_B_U_PrevAndNext(
		long autoId, long groupId, long publishedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_P_B_U_PrevAndNext(autoId, groupId,
			publishedByUserId, orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_P_B_U(
		long groupId, long publishedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_P_B_U(groupId, publishedByUserId);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and publishedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_P_B_U(
		long groupId, long publishedByUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_P_B_U(groupId, publishedByUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and publishedByUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_P_B_U(
		long groupId, long publishedByUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_P_B_U(groupId, publishedByUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_P_B_U_PrevAndNext(
		long autoId, long groupId, long publishedByUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_P_B_U_PrevAndNext(autoId, groupId,
			publishedByUserId, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and publishedByUserId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_P_B_U(long groupId, long publishedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_P_B_U(groupId, publishedByUserId);
	}

	/**
	* Returns the number of contents where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_P_B_U(long groupId, long publishedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_P_B_U(groupId, publishedByUserId);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and publishedByUserId = &#63;.
	*
	* @param groupId the group ID
	* @param publishedByUserId the published by user ID
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_P_B_U(long groupId, long publishedByUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_P_B_U(groupId, publishedByUserId);
	}

	/**
	* Returns all the contents where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_V(
		long groupId, long contentId, int version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C_V(groupId, contentId, version);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_V(
		long groupId, long contentId, int version, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V(groupId, contentId, version, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_V(
		long groupId, long contentId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V(groupId, contentId, version, start, end,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_C_V_First(
		long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_V_First(groupId, contentId, version,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_C_V_First(
		long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_V_First(groupId, contentId, version,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_C_V_Last(
		long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_V_Last(groupId, contentId, version,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_C_V_Last(
		long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_V_Last(groupId, contentId, version,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_C_V_PrevAndNext(
		long autoId, long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_V_PrevAndNext(autoId, groupId, contentId,
			version, orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_V(
		long groupId, long contentId, int version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C_V(groupId, contentId, version);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_V(
		long groupId, long contentId, int version, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_V(groupId, contentId, version, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_V(
		long groupId, long contentId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_V(groupId, contentId, version, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_C_V_PrevAndNext(
		long autoId, long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_C_V_PrevAndNext(autoId, groupId, contentId,
			version, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and contentId = &#63; and version = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_V(long groupId, long contentId, int version)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_V(groupId, contentId, version);
	}

	/**
	* Returns the number of contents where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_V(long groupId, long contentId, int version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C_V(groupId, contentId, version);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C_V(long groupId, long contentId,
		int version) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_C_V(groupId, contentId, version);
	}

	/**
	* Returns all the contents where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CO(
		long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_CO(groupId, contentId);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CO(
		long groupId, long contentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_CO(groupId, contentId, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CO(
		long groupId, long contentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CO(groupId, contentId, start, end, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_CO_First(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CO_First(groupId, contentId, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_CO_First(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_CO_First(groupId, contentId, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_CO_Last(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CO_Last(groupId, contentId, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_CO_Last(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_CO_Last(groupId, contentId, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_CO_PrevAndNext(
		long autoId, long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CO_PrevAndNext(autoId, groupId, contentId,
			orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CO(
		long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_CO(groupId, contentId);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CO(
		long groupId, long contentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_CO(groupId, contentId, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CO(
		long groupId, long contentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_CO(groupId, contentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and contentId = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_CO_PrevAndNext(
		long autoId, long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_CO_PrevAndNext(autoId, groupId, contentId,
			orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and contentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_CO(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_CO(groupId, contentId);
	}

	/**
	* Returns the number of contents where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_CO(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_CO(groupId, contentId);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_CO(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_CO(groupId, contentId);
	}

	/**
	* Returns all the contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_V_S(
		long groupId, long contentId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V_S(groupId, contentId, version, status);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_V_S(
		long groupId, long contentId, int version, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V_S(groupId, contentId, version, status, start,
			end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_C_V_S(
		long groupId, long contentId, int version, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V_S(groupId, contentId, version, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_C_V_S_First(
		long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_V_S_First(groupId, contentId, version, status,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_C_V_S_First(
		long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_V_S_First(groupId, contentId, version, status,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_C_V_S_Last(
		long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_V_S_Last(groupId, contentId, version, status,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_C_V_S_Last(
		long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_V_S_Last(groupId, contentId, version, status,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_C_V_S_PrevAndNext(
		long autoId, long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_C_V_S_PrevAndNext(autoId, groupId, contentId,
			version, status, orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_V_S(
		long groupId, long contentId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_V_S(groupId, contentId, version, status);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_V_S(
		long groupId, long contentId, int version, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_V_S(groupId, contentId, version, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_C_V_S(
		long groupId, long contentId, int version, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_V_S(groupId, contentId, version, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_C_V_S_PrevAndNext(
		long autoId, long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_C_V_S_PrevAndNext(autoId, groupId, contentId,
			version, status, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_V_S(long groupId, long contentId,
		int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_V_S(groupId, contentId, version, status);
	}

	/**
	* Returns the number of contents where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_V_S(long groupId, long contentId, int version,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_C_V_S(groupId, contentId, version, status);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C_V_S(long groupId, long contentId,
		int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_C_V_S(groupId, contentId, version, status);
	}

	/**
	* Returns all the contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CA_AU_V_S(
		long groupId, long categoryId, long createdByUserId, int version,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
			version, status);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CA_AU_V_S(
		long groupId, long categoryId, long createdByUserId, int version,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
			version, status, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_CA_AU_V_S(
		long groupId, long categoryId, long createdByUserId, int version,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
			version, status, start, end, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_CA_AU_V_S_First(
		long groupId, long categoryId, long createdByUserId, int version,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CA_AU_V_S_First(groupId, categoryId,
			createdByUserId, version, status, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_CA_AU_V_S_First(
		long groupId, long categoryId, long createdByUserId, int version,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_CA_AU_V_S_First(groupId, categoryId,
			createdByUserId, version, status, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_CA_AU_V_S_Last(
		long groupId, long categoryId, long createdByUserId, int version,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CA_AU_V_S_Last(groupId, categoryId,
			createdByUserId, version, status, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_CA_AU_V_S_Last(
		long groupId, long categoryId, long createdByUserId, int version,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_CA_AU_V_S_Last(groupId, categoryId,
			createdByUserId, version, status, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_CA_AU_V_S_PrevAndNext(
		long autoId, long groupId, long categoryId, long createdByUserId,
		int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_CA_AU_V_S_PrevAndNext(autoId, groupId, categoryId,
			createdByUserId, version, status, orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CA_AU_V_S(
		long groupId, long categoryId, long createdByUserId, int version,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_CA_AU_V_S(groupId, categoryId,
			createdByUserId, version, status);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CA_AU_V_S(
		long groupId, long categoryId, long createdByUserId, int version,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_CA_AU_V_S(groupId, categoryId,
			createdByUserId, version, status, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_CA_AU_V_S(
		long groupId, long categoryId, long createdByUserId, int version,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_CA_AU_V_S(groupId, categoryId,
			createdByUserId, version, status, start, end, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_CA_AU_V_S_PrevAndNext(
		long autoId, long groupId, long categoryId, long createdByUserId,
		int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_CA_AU_V_S_PrevAndNext(autoId, groupId,
			categoryId, createdByUserId, version, status, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByG_CA_AU_V_S(groupId, categoryId, createdByUserId, version,
			status);
	}

	/**
	* Returns the number of contents where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_CA_AU_V_S(groupId, categoryId, createdByUserId,
			version, status);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and categoryId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_CA_AU_V_S(long groupId, long categoryId,
		long createdByUserId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_CA_AU_V_S(groupId, categoryId,
			createdByUserId, version, status);
	}

	/**
	* Returns all the contents where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_V_S(
		long groupId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_V_S(groupId, version, status);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_V_S(
		long groupId, int version, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_V_S(groupId, version, status, start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_V_S(
		long groupId, int version, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_V_S(groupId, version, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_V_S_First(
		long groupId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_V_S_First(groupId, version, status,
			orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_V_S_First(
		long groupId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_V_S_First(groupId, version, status,
			orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_V_S_Last(
		long groupId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_V_S_Last(groupId, version, status, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_V_S_Last(
		long groupId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_V_S_Last(groupId, version, status,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_V_S_PrevAndNext(
		long autoId, long groupId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_V_S_PrevAndNext(autoId, groupId, version, status,
			orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_V_S(
		long groupId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_V_S(groupId, version, status);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_V_S(
		long groupId, int version, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_V_S(groupId, version, status, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_V_S(
		long groupId, int version, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_V_S(groupId, version, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_V_S_PrevAndNext(
		long autoId, long groupId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_V_S_PrevAndNext(autoId, groupId, version,
			status, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and version = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_V_S(long groupId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_V_S(groupId, version, status);
	}

	/**
	* Returns the number of contents where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_V_S(long groupId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_V_S(groupId, version, status);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_V_S(long groupId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_V_S(groupId, version, status);
	}

	/**
	* Returns all the contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_AU_V_S(
		long groupId, long createdByUserId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_AU_V_S(groupId, createdByUserId, version, status);
	}

	/**
	* Returns a range of all the contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_AU_V_S(
		long groupId, long createdByUserId, int version, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_AU_V_S(groupId, createdByUserId, version, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findByG_AU_V_S(
		long groupId, long createdByUserId, int version, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_AU_V_S(groupId, createdByUserId, version, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_AU_V_S_First(
		long groupId, long createdByUserId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_AU_V_S_First(groupId, createdByUserId, version,
			status, orderByComparator);
	}

	/**
	* Returns the first content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_AU_V_S_First(
		long groupId, long createdByUserId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_AU_V_S_First(groupId, createdByUserId, version,
			status, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByG_AU_V_S_Last(
		long groupId, long createdByUserId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_AU_V_S_Last(groupId, createdByUserId, version,
			status, orderByComparator);
	}

	/**
	* Returns the last content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByG_AU_V_S_Last(
		long groupId, long createdByUserId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_AU_V_S_Last(groupId, createdByUserId, version,
			status, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] findByG_AU_V_S_PrevAndNext(
		long autoId, long groupId, long createdByUserId, int version,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .findByG_AU_V_S_PrevAndNext(autoId, groupId,
			createdByUserId, version, status, orderByComparator);
	}

	/**
	* Returns all the contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_AU_V_S(
		long groupId, long createdByUserId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_AU_V_S(groupId, createdByUserId, version,
			status);
	}

	/**
	* Returns a range of all the contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_AU_V_S(
		long groupId, long createdByUserId, int version, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_AU_V_S(groupId, createdByUserId, version,
			status, start, end);
	}

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> filterFindByG_AU_V_S(
		long groupId, long createdByUserId, int version, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_AU_V_S(groupId, createdByUserId, version,
			status, start, end, orderByComparator);
	}

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content[] filterFindByG_AU_V_S_PrevAndNext(
		long autoId, long groupId, long createdByUserId, int version,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence()
				   .filterFindByG_AU_V_S_PrevAndNext(autoId, groupId,
			createdByUserId, version, status, orderByComparator);
	}

	/**
	* Removes all the contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_AU_V_S(long groupId, long createdByUserId,
		int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByG_AU_V_S(groupId, createdByUserId, version, status);
	}

	/**
	* Returns the number of contents where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_AU_V_S(long groupId, long createdByUserId,
		int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_AU_V_S(groupId, createdByUserId, version, status);
	}

	/**
	* Returns the number of contents that the user has permission to view where groupId = &#63; and createdByUserId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUserId the created by user ID
	* @param version the version
	* @param status the status
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_AU_V_S(long groupId, long createdByUserId,
		int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_AU_V_S(groupId, createdByUserId, version,
			status);
	}

	/**
	* Caches the content in the entity cache if it is enabled.
	*
	* @param content the content
	*/
	public static void cacheResult(
		com.viettel.portal.vcms.model.Content content) {
		getPersistence().cacheResult(content);
	}

	/**
	* Caches the contents in the entity cache if it is enabled.
	*
	* @param contents the contents
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Content> contents) {
		getPersistence().cacheResult(contents);
	}

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param autoId the primary key for the new content
	* @return the new content
	*/
	public static com.viettel.portal.vcms.model.Content create(long autoId) {
		return getPersistence().create(autoId);
	}

	/**
	* Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autoId the primary key of the content
	* @return the content that was removed
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content remove(long autoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence().remove(autoId);
	}

	public static com.viettel.portal.vcms.model.Content updateImpl(
		com.viettel.portal.vcms.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(content);
	}

	/**
	* Returns the content with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentException} if it could not be found.
	*
	* @param autoId the primary key of the content
	* @return the content
	* @throws com.viettel.portal.vcms.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content findByPrimaryKey(
		long autoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentException {
		return getPersistence().findByPrimaryKey(autoId);
	}

	/**
	* Returns the content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param autoId the primary key of the content
	* @return the content, or <code>null</code> if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Content fetchByPrimaryKey(
		long autoId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(autoId);
	}

	/**
	* Returns all the contents.
	*
	* @return the contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Content> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContentPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					ContentPersistence.class.getName());

			ReferenceRegistry.registerReference(ContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ContentPersistence persistence) {
	}

	private static ContentPersistence _persistence;
}