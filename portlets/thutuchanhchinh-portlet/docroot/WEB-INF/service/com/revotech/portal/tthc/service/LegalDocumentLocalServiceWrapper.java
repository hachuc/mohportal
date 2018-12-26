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

package com.revotech.portal.tthc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegalDocumentLocalService}.
 *
 * @author hieptran
 * @see LegalDocumentLocalService
 * @generated
 */
public class LegalDocumentLocalServiceWrapper
	implements LegalDocumentLocalService,
		ServiceWrapper<LegalDocumentLocalService> {
	public LegalDocumentLocalServiceWrapper(
		LegalDocumentLocalService legalDocumentLocalService) {
		_legalDocumentLocalService = legalDocumentLocalService;
	}

	/**
	* Adds the legal document to the database. Also notifies the appropriate model listeners.
	*
	* @param legalDocument the legal document
	* @return the legal document that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.tthc.model.LegalDocument addLegalDocument(
		com.revotech.portal.tthc.model.LegalDocument legalDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.addLegalDocument(legalDocument);
	}

	/**
	* Creates a new legal document with the primary key. Does not add the legal document to the database.
	*
	* @param ldId the primary key for the new legal document
	* @return the new legal document
	*/
	@Override
	public com.revotech.portal.tthc.model.LegalDocument createLegalDocument(
		long ldId) {
		return _legalDocumentLocalService.createLegalDocument(ldId);
	}

	/**
	* Deletes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ldId the primary key of the legal document
	* @return the legal document that was removed
	* @throws PortalException if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.tthc.model.LegalDocument deleteLegalDocument(
		long ldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.deleteLegalDocument(ldId);
	}

	/**
	* Deletes the legal document from the database. Also notifies the appropriate model listeners.
	*
	* @param legalDocument the legal document
	* @return the legal document that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.tthc.model.LegalDocument deleteLegalDocument(
		com.revotech.portal.tthc.model.LegalDocument legalDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.deleteLegalDocument(legalDocument);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalDocumentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.tthc.model.impl.LegalDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.revotech.portal.tthc.model.LegalDocument fetchLegalDocument(
		long ldId) throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.fetchLegalDocument(ldId);
	}

	/**
	* Returns the legal document with the primary key.
	*
	* @param ldId the primary key of the legal document
	* @return the legal document
	* @throws PortalException if a legal document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.tthc.model.LegalDocument getLegalDocument(
		long ldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.getLegalDocument(ldId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> getLegalDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.getLegalDocuments(start, end);
	}

	/**
	* Returns the number of legal documents.
	*
	* @return the number of legal documents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegalDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.getLegalDocumentsCount();
	}

	/**
	* Updates the legal document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legalDocument the legal document
	* @return the legal document that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.tthc.model.LegalDocument updateLegalDocument(
		com.revotech.portal.tthc.model.LegalDocument legalDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.updateLegalDocument(legalDocument);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legalDocumentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legalDocumentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legalDocumentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List findFieldByKeyword(java.lang.String keywords,
		long groupId, long category1Id, long category12d, int level, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.findFieldByKeyword(keywords, groupId,
			category1Id, category12d, level, start, end);
	}

	@Override
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> findByKeyword(
		java.lang.String keywords, long groupId, long category1Id,
		long category12d, int level, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.findByKeyword(keywords, groupId,
			category1Id, category12d, level, start, end);
	}

	@Override
	public int countByKeyword(java.lang.String keywords, long groupId,
		long category1Id, long category2Id, int level)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.countByKeyword(keywords, groupId,
			category1Id, category2Id, level);
	}

	@Override
	public java.util.List<com.revotech.portal.tthc.model.LegalDocument> getLatestLegalDocument(
		long groupId, int level, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalDocumentLocalService.getLatestLegalDocument(groupId,
			level, isActive, start, end, obc);
	}

	@Override
	public void addLegalDocument(long groupId, long companyId, long userId,
		java.lang.String userName, java.lang.String ldCode,
		java.lang.String ldTitle, java.lang.String ldLink,
		java.lang.String ldLevel3Link, java.lang.String ldSubcontent,
		boolean isActive, long idLinhvuc, long idCoquanbanhanh,
		java.lang.String ldDonvithuchien, int level,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_legalDocumentLocalService.addLegalDocument(groupId, companyId, userId,
			userName, ldCode, ldTitle, ldLink, ldLevel3Link, ldSubcontent,
			isActive, idLinhvuc, idCoquanbanhanh, ldDonvithuchien, level,
			serviceContext);
	}

	@Override
	public void updateLegalDocument(long ldId, long groupId, long companyId,
		long userId, java.lang.String userName, java.lang.String ldCode,
		java.lang.String ldTitle, java.lang.String ldLink,
		java.lang.String ldLevel3Link, java.lang.String ldSubcontent,
		boolean isActive, long idLinhvuc, long idCoquanbanhanh,
		java.lang.String ldDonvithuchien, int level,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_legalDocumentLocalService.updateLegalDocument(ldId, groupId,
			companyId, userId, userName, ldCode, ldTitle, ldLink, ldLevel3Link,
			ldSubcontent, isActive, idLinhvuc, idCoquanbanhanh,
			ldDonvithuchien, level, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegalDocumentLocalService getWrappedLegalDocumentLocalService() {
		return _legalDocumentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegalDocumentLocalService(
		LegalDocumentLocalService legalDocumentLocalService) {
		_legalDocumentLocalService = legalDocumentLocalService;
	}

	@Override
	public LegalDocumentLocalService getWrappedService() {
		return _legalDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		LegalDocumentLocalService legalDocumentLocalService) {
		_legalDocumentLocalService = legalDocumentLocalService;
	}

	private LegalDocumentLocalService _legalDocumentLocalService;
}