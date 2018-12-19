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

package com.portal_egov.portlet.legal_faq.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.legal_faq.model.Feedback;

/**
 * The persistence interface for the feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see FeedbackPersistenceImpl
 * @see FeedbackUtil
 * @generated
 */
public interface FeedbackPersistence extends BasePersistence<Feedback> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeedbackUtil} to access the feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the feedbacks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> findByG(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the feedbacks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @return the range of matching feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> findByG(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the feedbacks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> findByG(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback
	* @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a matching feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback findByG_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchFeedbackException;

	/**
	* Returns the first feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback fetchByG_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback
	* @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a matching feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback findByG_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchFeedbackException;

	/**
	* Returns the last feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback fetchByG_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the feedbacks before and after the current feedback in the ordered set where groupId = &#63;.
	*
	* @param feedbackId the primary key of the current feedback
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next feedback
	* @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback[] findByG_PrevAndNext(
		long feedbackId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchFeedbackException;

	/**
	* Returns all the feedbacks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> filterFindByG(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the feedbacks that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @return the range of matching feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> filterFindByG(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the feedbacks that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> filterFindByG(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the feedbacks before and after the current feedback in the ordered set of feedbacks that the user has permission to view where groupId = &#63;.
	*
	* @param feedbackId the primary key of the current feedback
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next feedback
	* @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback[] filterFindByG_PrevAndNext(
		long feedbackId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchFeedbackException;

	/**
	* Removes all the feedbacks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of feedbacks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByG(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of feedbacks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the feedback in the entity cache if it is enabled.
	*
	* @param feedback the feedback
	*/
	public void cacheResult(
		com.portal_egov.portlet.legal_faq.model.Feedback feedback);

	/**
	* Caches the feedbacks in the entity cache if it is enabled.
	*
	* @param feedbacks the feedbacks
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> feedbacks);

	/**
	* Creates a new feedback with the primary key. Does not add the feedback to the database.
	*
	* @param feedbackId the primary key for the new feedback
	* @return the new feedback
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback create(
		long feedbackId);

	/**
	* Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback that was removed
	* @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback remove(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchFeedbackException;

	public com.portal_egov.portlet.legal_faq.model.Feedback updateImpl(
		com.portal_egov.portlet.legal_faq.model.Feedback feedback)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the feedback with the primary key or throws a {@link com.portal_egov.portlet.legal_faq.NoSuchFeedbackException} if it could not be found.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback
	* @throws com.portal_egov.portlet.legal_faq.NoSuchFeedbackException if a feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback findByPrimaryKey(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchFeedbackException;

	/**
	* Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.Feedback fetchByPrimaryKey(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the feedbacks.
	*
	* @return the feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the feedbacks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @return the range of feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the feedbacks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.portal_egov.portlet.legal_faq.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.Feedback> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the feedbacks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of feedbacks.
	*
	* @return the number of feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}