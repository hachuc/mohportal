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

import com.liferay.portal.service.persistence.BasePersistence;

import com.revotech.portal.tthc.model.LegalDocument;

/**
 * The persistence interface for the legal document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hieptran
 * @see LegalDocumentPersistenceImpl
 * @see LegalDocumentUtil
 * @generated
 */
public interface LegalDocumentPersistence extends BasePersistence<LegalDocument> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalDocumentUtil} to access the legal document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @return the matching legal documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> findByG_L_A(
		long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> findByG_L_A(
		long groupId, int ldLevel, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> findByG_L_A(
		long groupId, int ldLevel, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.revotech.portal.tthc.model.LegalDocument findByG_L_A_First(
		long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException;

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
	public com.revotech.portal.tthc.model.LegalDocument fetchByG_L_A_First(
		long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.revotech.portal.tthc.model.LegalDocument findByG_L_A_Last(
		long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException;

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
	public com.revotech.portal.tthc.model.LegalDocument fetchByG_L_A_Last(
		long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.revotech.portal.tthc.model.LegalDocument[] findByG_L_A_PrevAndNext(
		long ldId, long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException;

	/**
	* Returns all the legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @return the matching legal documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> filterFindByG_L_A(
		long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> filterFindByG_L_A(
		long groupId, int ldLevel, boolean isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> filterFindByG_L_A(
		long groupId, int ldLevel, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.revotech.portal.tthc.model.LegalDocument[] filterFindByG_L_A_PrevAndNext(
		long ldId, long groupId, int ldLevel, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException;

	/**
	* Removes all the legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63; from the database.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L_A(long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal documents where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @return the number of matching legal documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L_A(long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal documents that the user has permission to view where groupId = &#63; and ldLevel = &#63; and isActive = &#63;.
	*
	* @param groupId the group ID
	* @param ldLevel the ld level
	* @param isActive the is active
	* @return the number of matching legal documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_L_A(long groupId, int ldLevel, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the legal document in the entity cache if it is enabled.
	*
	* @param legalDocument the legal document
	*/
	public void cacheResult(
		com.revotech.portal.tthc.model.LegalDocument legalDocument);

	/**
	* Caches the legal documents in the entity cache if it is enabled.
	*
	* @param legalDocuments the legal documents
	*/
	public void cacheResult(
		java.util.List<com.revotech.portal.tthc.model.LegalDocument> legalDocuments);

	/**
	* Creates a new legal document with the primary key. Does not add the legal document to the database.
	*
	* @param ldId the primary key for the new legal document
	* @return the new legal document
	*/
	public com.revotech.portal.tthc.model.LegalDocument create(long ldId);

	/**
	* Removes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ldId the primary key of the legal document
	* @return the legal document that was removed
	* @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.LegalDocument remove(long ldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException;

	public com.revotech.portal.tthc.model.LegalDocument updateImpl(
		com.revotech.portal.tthc.model.LegalDocument legalDocument)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal document with the primary key or throws a {@link com.revotech.portal.tthc.NoSuchLegalDocumentException} if it could not be found.
	*
	* @param ldId the primary key of the legal document
	* @return the legal document
	* @throws com.revotech.portal.tthc.NoSuchLegalDocumentException if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.LegalDocument findByPrimaryKey(
		long ldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.revotech.portal.tthc.NoSuchLegalDocumentException;

	/**
	* Returns the legal document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ldId the primary key of the legal document
	* @return the legal document, or <code>null</code> if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.revotech.portal.tthc.model.LegalDocument fetchByPrimaryKey(
		long ldId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legal documents.
	*
	* @return the legal documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal documents.
	*
	* @return the number of legal documents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}