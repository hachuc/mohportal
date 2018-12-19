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

import com.viettel.portal.vcms.model.Notes;

import java.util.List;

/**
 * The persistence utility for the notes service. This utility wraps {@link NotesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see NotesPersistence
 * @see NotesPersistenceImpl
 * @generated
 */
public class NotesUtil {
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
	public static void clearCache(Notes notes) {
		getPersistence().clearCache(notes);
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
	public static List<Notes> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Notes> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Notes> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Notes update(Notes notes) throws SystemException {
		return getPersistence().update(notes);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Notes update(Notes notes, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(notes, serviceContext);
	}

	/**
	* Returns all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @return the matching noteses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Notes> findByG_C_V(
		long groupId, long ContentID, int Version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C_V(groupId, ContentID, Version);
	}

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
	public static java.util.List<com.viettel.portal.vcms.model.Notes> findByG_C_V(
		long groupId, long ContentID, int Version, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V(groupId, ContentID, Version, start, end);
	}

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
	public static java.util.List<com.viettel.portal.vcms.model.Notes> findByG_C_V(
		long groupId, long ContentID, int Version, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_V(groupId, ContentID, Version, start, end,
			orderByComparator);
	}

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
	public static com.viettel.portal.vcms.model.Notes findByG_C_V_First(
		long groupId, long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException {
		return getPersistence()
				   .findByG_C_V_First(groupId, ContentID, Version,
			orderByComparator);
	}

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
	public static com.viettel.portal.vcms.model.Notes fetchByG_C_V_First(
		long groupId, long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_V_First(groupId, ContentID, Version,
			orderByComparator);
	}

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
	public static com.viettel.portal.vcms.model.Notes findByG_C_V_Last(
		long groupId, long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException {
		return getPersistence()
				   .findByG_C_V_Last(groupId, ContentID, Version,
			orderByComparator);
	}

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
	public static com.viettel.portal.vcms.model.Notes fetchByG_C_V_Last(
		long groupId, long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_V_Last(groupId, ContentID, Version,
			orderByComparator);
	}

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
	public static com.viettel.portal.vcms.model.Notes[] findByG_C_V_PrevAndNext(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK,
		long groupId, long ContentID, int Version,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException {
		return getPersistence()
				   .findByG_C_V_PrevAndNext(notesPK, groupId, ContentID,
			Version, orderByComparator);
	}

	/**
	* Removes all the noteses where groupId = &#63; and ContentID = &#63; and Version = &#63; from the database.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_V(long groupId, long ContentID, int Version)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_V(groupId, ContentID, Version);
	}

	/**
	* Returns the number of noteses where groupId = &#63; and ContentID = &#63; and Version = &#63;.
	*
	* @param groupId the group ID
	* @param ContentID the content i d
	* @param Version the version
	* @return the number of matching noteses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_V(long groupId, long ContentID, int Version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C_V(groupId, ContentID, Version);
	}

	/**
	* Caches the notes in the entity cache if it is enabled.
	*
	* @param notes the notes
	*/
	public static void cacheResult(com.viettel.portal.vcms.model.Notes notes) {
		getPersistence().cacheResult(notes);
	}

	/**
	* Caches the noteses in the entity cache if it is enabled.
	*
	* @param noteses the noteses
	*/
	public static void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Notes> noteses) {
		getPersistence().cacheResult(noteses);
	}

	/**
	* Creates a new notes with the primary key. Does not add the notes to the database.
	*
	* @param notesPK the primary key for the new notes
	* @return the new notes
	*/
	public static com.viettel.portal.vcms.model.Notes create(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK) {
		return getPersistence().create(notesPK);
	}

	/**
	* Removes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notesPK the primary key of the notes
	* @return the notes that was removed
	* @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Notes remove(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException {
		return getPersistence().remove(notesPK);
	}

	public static com.viettel.portal.vcms.model.Notes updateImpl(
		com.viettel.portal.vcms.model.Notes notes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(notes);
	}

	/**
	* Returns the notes with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchNotesException} if it could not be found.
	*
	* @param notesPK the primary key of the notes
	* @return the notes
	* @throws com.viettel.portal.vcms.NoSuchNotesException if a notes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Notes findByPrimaryKey(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchNotesException {
		return getPersistence().findByPrimaryKey(notesPK);
	}

	/**
	* Returns the notes with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notesPK the primary key of the notes
	* @return the notes, or <code>null</code> if a notes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Notes fetchByPrimaryKey(
		com.viettel.portal.vcms.service.persistence.NotesPK notesPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(notesPK);
	}

	/**
	* Returns all the noteses.
	*
	* @return the noteses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Notes> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viettel.portal.vcms.model.Notes> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viettel.portal.vcms.model.Notes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the noteses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of noteses.
	*
	* @return the number of noteses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NotesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NotesPersistence)PortletBeanLocatorUtil.locate(com.viettel.portal.vcms.service.ClpSerializer.getServletContextName(),
					NotesPersistence.class.getName());

			ReferenceRegistry.registerReference(NotesUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NotesPersistence persistence) {
	}

	private static NotesPersistence _persistence;
}