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

package com.revotech.portal.vbpq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AttachFileLocalService}.
 *
 * @author ChucHV
 * @see AttachFileLocalService
 * @generated
 */
public class AttachFileLocalServiceWrapper implements AttachFileLocalService,
	ServiceWrapper<AttachFileLocalService> {
	public AttachFileLocalServiceWrapper(
		AttachFileLocalService attachFileLocalService) {
		_attachFileLocalService = attachFileLocalService;
	}

	/**
	* Adds the attach file to the database. Also notifies the appropriate model listeners.
	*
	* @param attachFile the attach file
	* @return the attach file that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.AttachFile addAttachFile(
		com.revotech.portal.vbpq.model.AttachFile attachFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.addAttachFile(attachFile);
	}

	/**
	* Creates a new attach file with the primary key. Does not add the attach file to the database.
	*
	* @param id the primary key for the new attach file
	* @return the new attach file
	*/
	@Override
	public com.revotech.portal.vbpq.model.AttachFile createAttachFile(long id) {
		return _attachFileLocalService.createAttachFile(id);
	}

	/**
	* Deletes the attach file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the attach file
	* @return the attach file that was removed
	* @throws PortalException if a attach file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.AttachFile deleteAttachFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.deleteAttachFile(id);
	}

	/**
	* Deletes the attach file from the database. Also notifies the appropriate model listeners.
	*
	* @param attachFile the attach file
	* @return the attach file that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.AttachFile deleteAttachFile(
		com.revotech.portal.vbpq.model.AttachFile attachFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.deleteAttachFile(attachFile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attachFileLocalService.dynamicQuery();
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
		return _attachFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _attachFileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _attachFileLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _attachFileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _attachFileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.revotech.portal.vbpq.model.AttachFile fetchAttachFile(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.fetchAttachFile(id);
	}

	/**
	* Returns the attach file with the primary key.
	*
	* @param id the primary key of the attach file
	* @return the attach file
	* @throws PortalException if a attach file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.AttachFile getAttachFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.getAttachFile(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the attach files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attach files
	* @param end the upper bound of the range of attach files (not inclusive)
	* @return the range of attach files
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.revotech.portal.vbpq.model.AttachFile> getAttachFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.getAttachFiles(start, end);
	}

	/**
	* Returns the number of attach files.
	*
	* @return the number of attach files
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAttachFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.getAttachFilesCount();
	}

	/**
	* Updates the attach file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param attachFile the attach file
	* @return the attach file that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.revotech.portal.vbpq.model.AttachFile updateAttachFile(
		com.revotech.portal.vbpq.model.AttachFile attachFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.updateAttachFile(attachFile);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _attachFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_attachFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _attachFileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void deleteAttachFileVanBan(long vanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_attachFileLocalService.deleteAttachFileVanBan(vanBanId);
	}

	@Override
	public java.util.List<com.revotech.portal.vbpq.model.AttachFile> getAttachByVanBan(
		long vanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.getAttachByVanBan(vanBanId);
	}

	/**
	* @param id
	* @param vanBanId
	* @param fileId
	* @param fileLink
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public com.revotech.portal.vbpq.model.AttachFile updateAttachFile(long id,
		long vanBanId, long fileId, java.lang.String fileLink)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.updateAttachFile(id, vanBanId, fileId,
			fileLink);
	}

	@Override
	public com.revotech.portal.vbpq.model.AttachFile updateAttachFile(long id,
		long vanBanId, long fileId, java.lang.String fileLink,
		java.lang.String fileName, java.lang.String fileSize)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachFileLocalService.updateAttachFile(id, vanBanId, fileId,
			fileLink, fileName, fileSize);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AttachFileLocalService getWrappedAttachFileLocalService() {
		return _attachFileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAttachFileLocalService(
		AttachFileLocalService attachFileLocalService) {
		_attachFileLocalService = attachFileLocalService;
	}

	@Override
	public AttachFileLocalService getWrappedService() {
		return _attachFileLocalService;
	}

	@Override
	public void setWrappedService(AttachFileLocalService attachFileLocalService) {
		_attachFileLocalService = attachFileLocalService;
	}

	private AttachFileLocalService _attachFileLocalService;
}