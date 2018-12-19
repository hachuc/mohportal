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

import com.viettel.portal.magazine.archive.model.Content;

/**
 * The persistence interface for the content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author namtv
 * @see ContentPersistenceImpl
 * @see ContentUtil
 * @generated
 */
public interface ContentPersistence extends BasePersistence<Content> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentUtil} to access the content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the contents where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> findByMagazine(
		int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents where MagazineID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> findByMagazine(
		int MagazineID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents where MagazineID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> findByMagazine(
		int MagazineID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws com.viettel.portal.magazine.archive.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content findByMagazine_First(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchContentException;

	/**
	* Returns the first content in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content fetchByMagazine_First(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws com.viettel.portal.magazine.archive.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content findByMagazine_Last(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchContentException;

	/**
	* Returns the last content in the ordered set where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content fetchByMagazine_Last(
		int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contents before and after the current content in the ordered set where MagazineID = &#63;.
	*
	* @param ID the primary key of the current content
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content[] findByMagazine_PrevAndNext(
		int ID, int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchContentException;

	/**
	* Returns all the contents that the user has permission to view where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> filterFindByMagazine(
		int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents that the user has permission to view where MagazineID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> filterFindByMagazine(
		int MagazineID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents that the user has permissions to view where MagazineID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param MagazineID the magazine i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> filterFindByMagazine(
		int MagazineID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contents before and after the current content in the ordered set of contents that the user has permission to view where MagazineID = &#63;.
	*
	* @param ID the primary key of the current content
	* @param MagazineID the magazine i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content[] filterFindByMagazine_PrevAndNext(
		int ID, int MagazineID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchContentException;

	/**
	* Removes all the contents where MagazineID = &#63; from the database.
	*
	* @param MagazineID the magazine i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMagazine(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByMagazine(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents that the user has permission to view where MagazineID = &#63;.
	*
	* @param MagazineID the magazine i d
	* @return the number of matching contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByMagazine(int MagazineID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the content in the entity cache if it is enabled.
	*
	* @param content the content
	*/
	public void cacheResult(
		com.viettel.portal.magazine.archive.model.Content content);

	/**
	* Caches the contents in the entity cache if it is enabled.
	*
	* @param contents the contents
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.magazine.archive.model.Content> contents);

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param ID the primary key for the new content
	* @return the new content
	*/
	public com.viettel.portal.magazine.archive.model.Content create(int ID);

	/**
	* Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the content
	* @return the content that was removed
	* @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchContentException;

	public com.viettel.portal.magazine.archive.model.Content updateImpl(
		com.viettel.portal.magazine.archive.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content with the primary key or throws a {@link com.viettel.portal.magazine.archive.NoSuchContentException} if it could not be found.
	*
	* @param ID the primary key of the content
	* @return the content
	* @throws com.viettel.portal.magazine.archive.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.magazine.archive.NoSuchContentException;

	/**
	* Returns the content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the content
	* @return the content, or <code>null</code> if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.magazine.archive.model.Content fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contents.
	*
	* @return the contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.magazine.archive.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.magazine.archive.model.Content> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}