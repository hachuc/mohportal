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

package com.viettel.portal.links.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.links.model.VLink;

/**
 * The persistence interface for the v link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLinkPersistenceImpl
 * @see VLinkUtil
 * @generated
 */
public interface VLinkPersistence extends BasePersistence<VLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VLinkUtil} to access the v link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the v links where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v links where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @return the range of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v links where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v link in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns the first v link in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v link, or <code>null</code> if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v link in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink findByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns the last v link in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v link, or <code>null</code> if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v links before and after the current v link in the ordered set where groupId = &#63;.
	*
	* @param linkId the primary key of the current v link
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink[] findByGroup_PrevAndNext(
		long linkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns all the v links that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v links that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @return the range of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v links that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v links before and after the current v link in the ordered set of v links that the user has permission to view where groupId = &#63;.
	*
	* @param linkId the primary key of the current v link
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink[] filterFindByGroup_PrevAndNext(
		long linkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Removes all the v links where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v links where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v links that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v links where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @return the matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByGroupAndCateActive(
		long groupId, long categoryId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v links where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @return the range of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByGroupAndCateActive(
		long groupId, long categoryId, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v links where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByGroupAndCateActive(
		long groupId, long categoryId, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v link in the ordered set where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink findByGroupAndCateActive_First(
		long groupId, long categoryId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns the first v link in the ordered set where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v link, or <code>null</code> if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink fetchByGroupAndCateActive_First(
		long groupId, long categoryId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v link in the ordered set where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink findByGroupAndCateActive_Last(
		long groupId, long categoryId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns the last v link in the ordered set where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v link, or <code>null</code> if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink fetchByGroupAndCateActive_Last(
		long groupId, long categoryId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v links before and after the current v link in the ordered set where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param linkId the primary key of the current v link
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink[] findByGroupAndCateActive_PrevAndNext(
		long linkId, long groupId, long categoryId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns all the v links that the user has permission to view where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @return the matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByGroupAndCateActive(
		long groupId, long categoryId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v links that the user has permission to view where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @return the range of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByGroupAndCateActive(
		long groupId, long categoryId, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v links that the user has permissions to view where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByGroupAndCateActive(
		long groupId, long categoryId, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v links before and after the current v link in the ordered set of v links that the user has permission to view where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param linkId the primary key of the current v link
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink[] filterFindByGroupAndCateActive_PrevAndNext(
		long linkId, long groupId, long categoryId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Removes all the v links where groupId = &#63; and categoryId = &#63; and isActive = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndCateActive(long groupId, long categoryId,
		boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v links where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @return the number of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndCateActive(long groupId, long categoryId,
		boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v links that the user has permission to view where groupId = &#63; and categoryId = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isActive the is active
	* @return the number of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupAndCateActive(long groupId, long categoryId,
		boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v links where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByCategoryId(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v links where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @return the range of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByCategoryId(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v links where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findByCategoryId(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v link in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink findByCategoryId_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns the first v link in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v link, or <code>null</code> if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink fetchByCategoryId_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v link in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink findByCategoryId_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns the last v link in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v link, or <code>null</code> if a matching v link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink fetchByCategoryId_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v links before and after the current v link in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param linkId the primary key of the current v link
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink[] findByCategoryId_PrevAndNext(
		long linkId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns all the v links that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByCategoryId(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v links that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @return the range of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByCategoryId(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v links that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> filterFindByCategoryId(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v links before and after the current v link in the ordered set of v links that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param linkId the primary key of the current v link
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink[] filterFindByCategoryId_PrevAndNext(
		long linkId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Removes all the v links where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryId(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v links where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v links
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryId(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v links that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v links that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryId(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the v link in the entity cache if it is enabled.
	*
	* @param vLink the v link
	*/
	public void cacheResult(com.viettel.portal.links.model.VLink vLink);

	/**
	* Caches the v links in the entity cache if it is enabled.
	*
	* @param vLinks the v links
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.links.model.VLink> vLinks);

	/**
	* Creates a new v link with the primary key. Does not add the v link to the database.
	*
	* @param linkId the primary key for the new v link
	* @return the new v link
	*/
	public com.viettel.portal.links.model.VLink create(long linkId);

	/**
	* Removes the v link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the v link
	* @return the v link that was removed
	* @throws com.viettel.portal.links.NoSuchVLinkException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink remove(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	public com.viettel.portal.links.model.VLink updateImpl(
		com.viettel.portal.links.model.VLink vLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v link with the primary key or throws a {@link com.viettel.portal.links.NoSuchVLinkException} if it could not be found.
	*
	* @param linkId the primary key of the v link
	* @return the v link
	* @throws com.viettel.portal.links.NoSuchVLinkException if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink findByPrimaryKey(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.links.NoSuchVLinkException;

	/**
	* Returns the v link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkId the primary key of the v link
	* @return the v link, or <code>null</code> if a v link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.links.model.VLink fetchByPrimaryKey(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v links.
	*
	* @return the v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @return the range of v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.links.model.impl.VLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v links
	* @param end the upper bound of the range of v links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.links.model.VLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v links.
	*
	* @return the number of v links
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}