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

package com.revotech.portal.tthc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.revotech.portal.tthc.model.LegalDocument;

import java.util.List;

/**
 * The persistence utility for the legal document service. This utility wraps {@link LegalDocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hieptran
 * @see LegalDocumentPersistence
 * @see LegalDocumentPersistenceImpl
 * @generated
 */
public class LegalDocumentUtil {
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
	public static void clearCache(LegalDocument legalDocument) {
		getPersistence().clearCache(legalDocument);
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
	public static List<LegalDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LegalDocument update(LegalDocument legalDocument)
		throws SystemException {
		return getPersistence().update(legalDocument);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LegalDocument update(LegalDocument legalDocument,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(legalDocument, serviceContext);
	}

	/**
	* Returns all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @return the matching legal documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> findByG_L_A(
		long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L_A(groupId, ldLevel, isActive);
	}

	/**
	* Returns a range of all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param start the lower bound of the range of legal documents
	* @param end the upper bound of the range of legal documents (not inclusive)
	* @return the range of matching legal documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> findByG_L_A(
		long groupId, int ldLevel, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_A(groupId, ldLevel, isActive, start, end);
	}

	/**
	* Returns an ordered range of all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param start the lower bound of the range of legal documents
	* @param end the upper bound of the range of legal documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> findByG_L_A(
		long groupId, int ldLevel, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_A(groupId, ldLevel, isActive, start, end,
			orderByComparator);
	}

	/**
	* Returns the first legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal document
	* @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a matching legal document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument findByG_L_A_First(
		long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException {
		return getPersistence()
				   .findByG_L_A_First(groupId, ldLevel, isActive,
			orderByComparator);
	}

	/**
	* Returns the first legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument fetchByG_L_A_First(
		long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_L_A_First(groupId, ldLevel, isActive,
			orderByComparator);
	}

	/**
	* Returns the last legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal document
	* @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a matching legal document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument findByG_L_A_Last(
		long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException {
		return getPersistence()
				   .findByG_L_A_Last(groupId, ldLevel, isActive,
			orderByComparator);
	}

	/**
	* Returns the last legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument fetchByG_L_A_Last(
		long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_L_A_Last(groupId, ldLevel, isActive,
			orderByComparator);
	}

	/**
	* Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param ldId the primary key of the current legal document
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal document
	* @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument[] findByG_L_A_PrevAndNext(
		long ldId, long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException {
		return getPersistence()
				   .findByG_L_A_PrevAndNext(ldId, groupId, ldLevel, isActive,
			orderByComparator);
	}

	/**
	* Returns all the legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @return the matching legal documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> filterFindByG_L_A(
		long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_L_A(groupId, ldLevel, isActive);
	}

	/**
	* Returns a range of all the legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param start the lower bound of the range of legal documents
	* @param end the upper bound of the range of legal documents (not inclusive)
	* @return the range of matching legal documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> filterFindByG_L_A(
		long groupId, int ldLevel, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_L_A(groupId, ldLevel, isActive, start, end);
	}

	/**
	* Returns an ordered range of all the legal documents that the user has permissions to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param start the lower bound of the range of legal documents
	* @param end the upper bound of the range of legal documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> filterFindByG_L_A(
		long groupId, int ldLevel, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_L_A(groupId, ldLevel, isActive, start, end,
			orderByComparator);
	}

	/**
	* Returns the legal documents before and after the current legal document in the ordered set of legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param ldId the primary key of the current legal document
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal document
	* @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument[] filterFindByG_L_A_PrevAndNext(
		long ldId, long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException {
		return getPersistence()
				   .filterFindByG_L_A_PrevAndNext(ldId, groupId, ldLevel,
			isActive, orderByComparator);
	}

	/**
	* Removes all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63; from the database.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_A(long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_A(groupId, ldLevel, isActive);
	}

	/**
	* Returns the number of legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @return the number of matching legal documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_A(long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L_A(groupId, ldLevel, isActive);
	}

	/**
	* Returns the number of legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @return the number of matching legal documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_L_A(long groupId, int ldLevel,
		boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_L_A(groupId, ldLevel, isActive);
	}

	/**
	* Caches the legal document in the entity cache if it is enabled.
	*
	* @param legalDocument the legal document
	*/
	public static void cacheResult(
		com.revotech.portal.tthc.model.LegalDocument legalDocument) {
		getPersistence().cacheResult(legalDocument);
	}

	/**
	* Caches the legal documents in the entity cache if it is enabled.
	*
	* @param legalDocuments the legal documents
	*/
	public static void cacheResult(
		java.util.List<com.revotech.portal.tthc.model.LegalDocument> legalDocuments) {
		getPersistence().cacheResult(legalDocuments);
	}

	/**
	* Creates a new legal document with the primary key. Does not add the legal document to the database.
	*
	* @param ldId the primary key for the new legal document
	* @return the new legal document
	*/
	public static com.revotech.portal.tthc.model.LegalDocument create(long ldId) {
		return getPersistence().create(ldId);
	}

	/**
	* Removes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ldId the primary key of the legal document
	* @return the legal document that was removed
	* @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument remove(long ldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException {
		return getPersistence().remove(ldId);
	}

	public static com.revotech.portal.tthc.model.LegalDocument updateImpl(
		com.revotech.portal.tthc.model.LegalDocument legalDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legalDocument);
	}

	/**
	* Returns the legal document with the primary key or throws a {@link com.revotech.portal.tthc.NoSuchLegalDocumentException} if it could not be found.
	*
	* @param ldId the primary key of the legal document
	* @return the legal document
	* @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument findByPrimaryKey(
		long ldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException {
		return getPersistence().findByPrimaryKey(ldId);
	}

	/**
	* Returns the legal document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ldId the primary key of the legal document
	* @return the legal document, or <code>null</code> if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.revotech.portal.tthc.model.LegalDocument fetchByPrimaryKey(
		long ldId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ldId);
	}

	/**
	* Returns all the legal documents.
	*
	* @return the legal documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the legal documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal documents
	* @param end the upper bound of the range of legal documents (not inclusive)
	* @return the range of legal documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the legal documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal documents
	* @param end the upper bound of the range of legal documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legal documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.revotech.portal.tthc.model.LegalDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legal documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legal documents.
	*
	* @return the number of legal documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LegalDocumentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LegalDocumentPersistence)PortletBeanLocatorUtil.locate(com.revotech.portal.tthc.service.ClpSerializer.getServletContextName(),
					LegalDocumentPersistence.class.getName());

			ReferenceRegistry.registerReference(LegalDocumentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LegalDocumentPersistence persistence) {
	}

	private static LegalDocumentPersistence _persistence;
}