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

import com.viettel.portal.vcms.model.ContentDetail;

/**
 * The persistence interface for the content detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see ContentDetailPersistenceImpl
 * @see ContentDetailUtil
 * @generated
 */
public interface ContentDetailPersistence extends BasePersistence<ContentDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentDetailUtil} to access the content detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the content details where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content details where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @return the range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the content details where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_C_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_C_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_C_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_C_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param autoId the primary key of the current content detail
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail[] findByG_C_PrevAndNext(
		long autoId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Removes all the content details where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content details where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @return the matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CA_V_S(
		long groupId, long categoryId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @return the range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CA_V_S(
		long groupId, long categoryId, int version, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CA_V_S(
		long groupId, long categoryId, int version, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_CA_V_S_First(
		long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_CA_V_S_First(
		long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_CA_V_S_Last(
		long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_CA_V_S_Last(
		long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content detail
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail[] findByG_CA_V_S_PrevAndNext(
		long autoId, long groupId, long categoryId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Removes all the content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_CA_V_S(long groupId, long categoryId, int version,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content details where groupId = &#63; and categoryId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param version the version
	* @param status the status
	* @return the number of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_CA_V_S(long groupId, long categoryId, int version,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content details where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @return the matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO_V(
		long groupId, long contentId, int version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content details where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @return the range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO_V(
		long groupId, long contentId, int version, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the content details where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO_V(
		long groupId, long contentId, int version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_CO_V_First(
		long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_CO_V_First(
		long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_CO_V_Last(
		long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_CO_V_Last(
		long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param autoId the primary key of the current content detail
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail[] findByG_CO_V_PrevAndNext(
		long autoId, long groupId, long contentId, int version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Removes all the content details where groupId = &#63; and contentId = &#63; and version = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_CO_V(long groupId, long contentId, int version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content details where groupId = &#63; and contentId = &#63; and version = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @return the number of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_CO_V(long groupId, long contentId, int version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content details where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO(
		long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content details where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @return the range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO(
		long groupId, long contentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the content details where groupId = &#63; and contentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO(
		long groupId, long contentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_CO_First(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_CO_First(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_CO_Last(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_CO_Last(
		long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and contentId = &#63;.
	*
	* @param autoId the primary key of the current content detail
	* @param groupId the group ID
	* @param contentId the content ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail[] findByG_CO_PrevAndNext(
		long autoId, long groupId, long contentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Removes all the content details where groupId = &#63; and contentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_CO(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content details where groupId = &#63; and contentId = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @return the number of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_CO(long groupId, long contentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @return the matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO_V_S(
		long groupId, long contentId, int version, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @return the range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO_V_S(
		long groupId, long contentId, int version, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findByG_CO_V_S(
		long groupId, long contentId, int version, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_CO_V_S_First(
		long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the first content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_CO_V_S_First(
		long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByG_CO_V_S_Last(
		long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the last content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content detail, or <code>null</code> if a matching content detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByG_CO_V_S_Last(
		long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content details before and after the current content detail in the ordered set where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param autoId the primary key of the current content detail
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail[] findByG_CO_V_S_PrevAndNext(
		long autoId, long groupId, long contentId, int version, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Removes all the content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_CO_V_S(long groupId, long contentId, int version,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content details where groupId = &#63; and contentId = &#63; and version = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param contentId the content ID
	* @param version the version
	* @param status the status
	* @return the number of matching content details
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_CO_V_S(long groupId, long contentId, int version,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the content detail in the entity cache if it is enabled.
	*
	* @param contentDetail the content detail
	*/
	public void cacheResult(
		com.viettel.portal.vcms.model.ContentDetail contentDetail);

	/**
	* Caches the content details in the entity cache if it is enabled.
	*
	* @param contentDetails the content details
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.ContentDetail> contentDetails);

	/**
	* Creates a new content detail with the primary key. Does not add the content detail to the database.
	*
	* @param autoId the primary key for the new content detail
	* @return the new content detail
	*/
	public com.viettel.portal.vcms.model.ContentDetail create(long autoId);

	/**
	* Removes the content detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autoId the primary key of the content detail
	* @return the content detail that was removed
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail remove(long autoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	public com.viettel.portal.vcms.model.ContentDetail updateImpl(
		com.viettel.portal.vcms.model.ContentDetail contentDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content detail with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchContentDetailException} if it could not be found.
	*
	* @param autoId the primary key of the content detail
	* @return the content detail
	* @throws com.viettel.portal.vcms.NoSuchContentDetailException if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail findByPrimaryKey(
		long autoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchContentDetailException;

	/**
	* Returns the content detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param autoId the primary key of the content detail
	* @return the content detail, or <code>null</code> if a content detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.ContentDetail fetchByPrimaryKey(
		long autoId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content details.
	*
	* @return the content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @return the range of content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the content details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of content details
	* @param end the upper bound of the range of content details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of content details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.ContentDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the content details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content details.
	*
	* @return the number of content details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}