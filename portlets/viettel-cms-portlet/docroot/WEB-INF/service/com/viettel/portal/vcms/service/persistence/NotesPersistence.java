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

import com.viettel.portal.vcms.model.Notes;

/**
 * The persistence interface for the notes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see NotesPersistenceImpl
 * @see NotesUtil
 * @generated
 */
public interface NotesPersistence extends BasePersistence<Notes> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotesUtil} to access the notes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @return the matching noteses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Notes> findByG_C_V(
		long groupId, long ContentID, int Version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.NotesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @param start the lower bound of the range of noteses
	* @param end the upper bound of the range of noteses (not inclusive)
	* @return the range of matching noteses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Notes> findByG_C_V(
		long groupId, long ContentID, int Version, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.NotesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @param start the lower bound of the range of noteses
	* @param end the upper bound of the range of noteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching noteses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Notes> findByG_C_V(
		long groupId, long ContentID, int Version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notes
	* @throws com.viettel.portal.vcms.NoSuchNotesException if a matching notes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Notes findByG_C_V_First(long groupId,
		long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException;

	/**
	* Returns the first notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notes, or <code>null</code> if a matching notes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Notes fetchByG_C_V_First(
		long groupId, long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notes
	* @throws com.viettel.portal.vcms.NoSuchNotesException if a matching notes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Notes findByG_C_V_Last(long groupId,
		long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException;

	/**
	* Returns the last notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notes, or <code>null</code> if a matching notes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Notes fetchByG_C_V_Last(long groupId,
		long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the noteses before and after the current notes in the ordered set where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param notesPK the primary key of the current notes
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notes
	* @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Notes[] findByG_C_V_PrevAndNext(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK,
		long groupId, long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException;

	/**
	* Removes all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63; from the database.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C_V(long groupId, long ContentID, int Version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @return the number of matching noteses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C_V(long groupId, long ContentID, int Version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the notes in the entity cache if it is enabled.
	*
	* @param notes the notes
	*/
	public void cacheResult(com.viettel.portal.vcms.model.Notes notes);

	/**
	* Caches the noteses in the entity cache if it is enabled.
	*
	* @param noteses the noteses
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Notes> noteses);

	/**
	* Creates a new notes with the primary key. Does not add the notes to the database.
	*
	* @param notesPK the primary key for the new notes
	* @return the new notes
	*/
	public com.viettel.portal.vcms.model.Notes create(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK);

	/**
	* Removes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notesPK the primary key of the notes
	* @return the notes that was removed
	* @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Notes remove(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException;

	public com.viettel.portal.vcms.model.Notes updateImpl(
		com.viettel.portal.vcms.model.Notes notes)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notes with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchNotesException} if it could not be found.
	*
	* @param notesPK the primary key of the notes
	* @return the notes
	* @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Notes findByPrimaryKey(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException;

	/**
	* Returns the notes with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notesPK the primary key of the notes
	* @return the notes, or <code>null</code> if a notes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Notes fetchByPrimaryKey(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the noteses.
	*
	* @return the noteses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Notes> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the noteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.NotesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of noteses
	* @param end the upper bound of the range of noteses (not inclusive)
	* @return the range of noteses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Notes> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the noteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.NotesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of noteses
	* @param end the upper bound of the range of noteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of noteses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Notes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the noteses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of noteses.
	*
	* @return the number of noteses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}