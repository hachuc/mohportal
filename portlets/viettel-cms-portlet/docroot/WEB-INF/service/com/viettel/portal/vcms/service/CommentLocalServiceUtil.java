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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Comment. This utility wraps
 * {@link com.viettel.portal.vcms.service.impl.CommentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author chuchv
 * @see CommentLocalService
 * @see com.viettel.portal.vcms.service.base.CommentLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.impl.CommentLocalServiceImpl
 * @generated
 */
public class CommentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.viettel.portal.vcms.service.impl.CommentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the comment to the database. Also notifies the appropriate model listeners.
	*
	* @param comment the comment
	* @return the comment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Comment addComment(
		com.viettel.portal.vcms.model.Comment comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addComment(comment);
	}

	/**
	* Creates a new comment with the primary key. Does not add the comment to the database.
	*
	* @param commentId the primary key for the new comment
	* @return the new comment
	*/
	public static com.viettel.portal.vcms.model.Comment createComment(
		long commentId) {
		return getService().createComment(commentId);
	}

	/**
	* Deletes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commentId the primary key of the comment
	* @return the comment that was removed
	* @throws PortalException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Comment deleteComment(
		long commentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteComment(commentId);
	}

	/**
	* Deletes the comment from the database. Also notifies the appropriate model listeners.
	*
	* @param comment the comment
	* @return the comment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Comment deleteComment(
		com.viettel.portal.vcms.model.Comment comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteComment(comment);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.viettel.portal.vcms.model.Comment fetchComment(
		long commentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchComment(commentId);
	}

	/**
	* Returns the comment with the primary key.
	*
	* @param commentId the primary key of the comment
	* @return the comment
	* @throws PortalException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Comment getComment(
		long commentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getComment(commentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the comments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @return the range of comments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viettel.portal.vcms.model.Comment> getComments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getComments(start, end);
	}

	/**
	* Returns the number of comments.
	*
	* @return the number of comments
	* @throws SystemException if a system exception occurred
	*/
	public static int getCommentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCommentsCount();
	}

	/**
	* Updates the comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param comment the comment
	* @return the comment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.viettel.portal.vcms.model.Comment updateComment(
		com.viettel.portal.vcms.model.Comment comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateComment(comment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List customSearchByKeyword(long companyId,
		long groupId, java.lang.String keyword, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .customSearchByKeyword(companyId, groupId, keyword, type,
			start, end);
	}

	public static int customCountByKeyword(long companyId, long groupId,
		java.lang.String keywords, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .customCountByKeyword(companyId, groupId, keywords, type);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Comment> getAllComment()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllComment();
	}

	public static java.util.List<com.viettel.portal.vcms.model.Comment> getVisibleComment(
		long groupId, long distId, boolean isVisible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVisibleComment(groupId, distId, isVisible);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Comment> findByKeyword(
		long companyId, long groupId, java.lang.String keyword, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByKeyword(companyId, groupId, keyword, start, end);
	}

	public static int countByKeyword(long companyId, long groupId,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByKeyword(companyId, groupId, keywords);
	}

	public static java.util.List<com.viettel.portal.vcms.model.Comment> getByContentId(
		long groupId, long distributionId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByContentId(groupId, distributionId, start, end);
	}

	public static int countByContentId(long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByContentId(groupId, distributionId);
	}

	public static void addLegalComment(long groupId, long companyId,
		long userId, java.lang.String userName, java.util.Date createDate,
		java.util.Date modifyDate, int id, int distributionId,
		java.lang.String fullName, java.lang.String address,
		java.lang.String email, java.lang.String body, boolean visible,
		java.lang.String ipAddress,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLegalComment(groupId, companyId, userId, userName, createDate,
			modifyDate, id, distributionId, fullName, address, email, body,
			visible, ipAddress, serviceContext);
	}

	public static void addComment(long groupId, long companyId, long userId,
		java.lang.String userName, long id, long distributionId,
		java.lang.String fullName, java.lang.String address,
		java.lang.String email, java.lang.String body, boolean visible,
		java.lang.String ipAddress,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addComment(groupId, companyId, userId, userName, id,
			distributionId, fullName, address, email, body, visible, ipAddress,
			serviceContext);
	}

	public static void deleteAllData()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAllData();
	}

	public static void clearService() {
		_service = null;
	}

	public static CommentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CommentLocalService.class.getName());

			if (invokableLocalService instanceof CommentLocalService) {
				_service = (CommentLocalService)invokableLocalService;
			}
			else {
				_service = new CommentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CommentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CommentLocalService service) {
	}

	private static CommentLocalService _service;
}