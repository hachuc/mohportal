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
 * Provides a wrapper for {@link Legal_CommentLocalService}.
 *
 * @author chuchv
 * @see Legal_CommentLocalService
 * @generated
 */
public class Legal_CommentLocalServiceWrapper
	implements Legal_CommentLocalService,
		ServiceWrapper<Legal_CommentLocalService> {
	public Legal_CommentLocalServiceWrapper(
		Legal_CommentLocalService legal_CommentLocalService) {
		_legal_CommentLocalService = legal_CommentLocalService;
	}

	/**
	* Adds the legal_ comment to the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Comment the legal_ comment
	* @return the legal_ comment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Comment addLegal_Comment(
		com.viettel.portal.vcms.model.Legal_Comment legal_Comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.addLegal_Comment(legal_Comment);
	}

	/**
	* Creates a new legal_ comment with the primary key. Does not add the legal_ comment to the database.
	*
	* @param ID the primary key for the new legal_ comment
	* @return the new legal_ comment
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Comment createLegal_Comment(
		int ID) {
		return _legal_CommentLocalService.createLegal_Comment(ID);
	}

	/**
	* Deletes the legal_ comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ comment
	* @return the legal_ comment that was removed
	* @throws PortalException if a legal_ comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Comment deleteLegal_Comment(
		int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.deleteLegal_Comment(ID);
	}

	/**
	* Deletes the legal_ comment from the database. Also notifies the appropriate model listeners.
	*
	* @param legal_Comment the legal_ comment
	* @return the legal_ comment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Comment deleteLegal_Comment(
		com.viettel.portal.vcms.model.Legal_Comment legal_Comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.deleteLegal_Comment(legal_Comment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legal_CommentLocalService.dynamicQuery();
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
		return _legal_CommentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legal_CommentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legal_CommentLocalService.dynamicQuery(dynamicQuery, start,
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
		return _legal_CommentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legal_CommentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Comment fetchLegal_Comment(
		int ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.fetchLegal_Comment(ID);
	}

	/**
	* Returns the legal_ comment with the primary key.
	*
	* @param ID the primary key of the legal_ comment
	* @return the legal_ comment
	* @throws PortalException if a legal_ comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Comment getLegal_Comment(int ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.getLegal_Comment(ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legal_ comments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ comments
	* @param end the upper bound of the range of legal_ comments (not inclusive)
	* @return the range of legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.vcms.model.Legal_Comment> getLegal_Comments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.getLegal_Comments(start, end);
	}

	/**
	* Returns the number of legal_ comments.
	*
	* @return the number of legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegal_CommentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.getLegal_CommentsCount();
	}

	/**
	* Updates the legal_ comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legal_Comment the legal_ comment
	* @return the legal_ comment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.vcms.model.Legal_Comment updateLegal_Comment(
		com.viettel.portal.vcms.model.Legal_Comment legal_Comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.updateLegal_Comment(legal_Comment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legal_CommentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legal_CommentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legal_CommentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.vcms.model.Legal_Comment> getAllComment()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legal_CommentLocalService.getAllComment();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Legal_CommentLocalService getWrappedLegal_CommentLocalService() {
		return _legal_CommentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegal_CommentLocalService(
		Legal_CommentLocalService legal_CommentLocalService) {
		_legal_CommentLocalService = legal_CommentLocalService;
	}

	@Override
	public Legal_CommentLocalService getWrappedService() {
		return _legal_CommentLocalService;
	}

	@Override
	public void setWrappedService(
		Legal_CommentLocalService legal_CommentLocalService) {
		_legal_CommentLocalService = legal_CommentLocalService;
	}

	private Legal_CommentLocalService _legal_CommentLocalService;
}