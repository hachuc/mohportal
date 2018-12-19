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

package com.viettel.portal.vcms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Legal_ContentLocalService}.
 *
 * @author chuchv
 * @see Legal_ContentLocalService
 * @generated
 */
public class Legal_ContentLocalServiceWrapper
	implements Legal_ContentLocalService,
		ServiceWrapper<Legal_ContentLocalService> {
	public Legal_ContentLocalServiceWrapper(
		Legal_ContentLocalService legal_ContentLocalService) {
		_legal_ContentLocalService = legal_ContentLocalService;
	}

	/**
	* Adds the legal_ content to the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Content the legal_ content
	* @return the legal_ content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Content addLegal_Content(
		com.viettel.portal.vcms.model.Legal_Content legal_Content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.addLegal_Content(legal_Content);
	}

	/**
	* Creates a new legal_ content with the primary key. Does not add the legal_ content to the database.
	*
	* @param ID the primary key for the new legal_ content
	* @return the new legal_ content
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Content createLegal_Content(
		int ID) {
		return _legal_ContentLocalService.createLegal_Content(ID);
	}

	/**
	* Deletes the legal_ content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ content
	* @return the legal_ content that was removed
	* @throws PortalException if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Content deleteLegal_Content(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.deleteLegal_Content(ID);
	}

	/**
	* Deletes the legal_ content from the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Content the legal_ content
	* @return the legal_ content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Content deleteLegal_Content(
		com.viettel.portal.vcms.model.Legal_Content legal_Content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.deleteLegal_Content(legal_Content);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legal_ContentLocalService.dynamicQuery();
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
		return _legal_ContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legal_ContentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legal_ContentLocalService.dynamicQuery(dynamicQuery, start,
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
		return _legal_ContentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legal_ContentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Content fetchLegal_Content(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.fetchLegal_Content(ID);
	}

	/**
	* Returns the legal_ content with the primary key.
	*
	* @param ID the primary key of the legal_ content
	* @return the legal_ content
	* @throws PortalException if a legal_ content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Content getLegal_Content(int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.getLegal_Content(ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legal_ contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ contents
	* @param end the upper bound of the range of legal_ contents (not inclusive)
	* @return the range of legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> getLegal_Contents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.getLegal_Contents(start, end);
	}

	/**
	* Returns the number of legal_ contents.
	*
	* @return the number of legal_ contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegal_ContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.getLegal_ContentsCount();
	}

	/**
	* Updates the legal_ content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legal_Content the legal_ content
	* @return the legal_ content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Content updateLegal_Content(
		com.viettel.portal.vcms.model.Legal_Content legal_Content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.updateLegal_Content(legal_Content);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legal_ContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legal_ContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legal_ContentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Legal_Content> getLegalContents(
		int categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_ContentLocalService.getLegalContents(categoryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Legal_ContentLocalService getWrappedLegal_ContentLocalService() {
		return _legal_ContentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegal_ContentLocalService(
		Legal_ContentLocalService legal_ContentLocalService) {
		_legal_ContentLocalService = legal_ContentLocalService;
	}

	@Override
	public Legal_ContentLocalService getWrappedService() {
		return _legal_ContentLocalService;
	}

	@Override
	public void setWrappedService(
		Legal_ContentLocalService legal_ContentLocalService) {
		_legal_ContentLocalService = legal_ContentLocalService;
	}

	private Legal_ContentLocalService _legal_ContentLocalService;
}