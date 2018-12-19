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

import com.viettel.portal.vcms.model.Comment;

/**
 * The persistence interface for the comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see CommentPersistenceImpl
 * @see CommentUtil
 * @generated
 */
public interface CommentPersistence extends BasePersistence<Comment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommentUtil} to access the comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the comments where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @return the matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Comment> findByG_D(
		long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the comments where groupId = &#63; and distributionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @return the range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Comment> findByG_D(
		long groupId, long distributionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the comments where groupId = &#63; and distributionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Comment> findByG_D(
		long groupId, long distributionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment
	* @throws com.viettel.portal.vcms.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment findByG_D_First(long groupId,
		long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchCommentException;

	/**
	* Returns the first comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment fetchByG_D_First(
		long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment
	* @throws com.viettel.portal.vcms.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment findByG_D_Last(long groupId,
		long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchCommentException;

	/**
	* Returns the last comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment fetchByG_D_Last(long groupId,
		long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the comments before and after the current comment in the ordered set where groupId = &#63; and distributionId = &#63;.
	*
	* @param commentId the primary key of the current comment
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment
	* @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment[] findByG_D_PrevAndNext(
		long commentId, long groupId, long distributionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchCommentException;

	/**
	* Removes all the comments where groupId = &#63; and distributionId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_D(long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of comments where groupId = &#63; and distributionId = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @return the number of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_D(long groupId, long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the comments where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @return the matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Comment> findByG_D_V(
		long groupId, long distributionId, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the comments where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @return the range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Comment> findByG_D_V(
		long groupId, long distributionId, boolean visible, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the comments where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Comment> findByG_D_V(
		long groupId, long distributionId, boolean visible, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first comment in the ordered set where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment
	* @throws com.viettel.portal.vcms.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment findByG_D_V_First(
		long groupId, long distributionId, boolean visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchCommentException;

	/**
	* Returns the first comment in the ordered set where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment fetchByG_D_V_First(
		long groupId, long distributionId, boolean visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last comment in the ordered set where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment
	* @throws com.viettel.portal.vcms.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment findByG_D_V_Last(
		long groupId, long distributionId, boolean visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchCommentException;

	/**
	* Returns the last comment in the ordered set where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment fetchByG_D_V_Last(
		long groupId, long distributionId, boolean visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the comments before and after the current comment in the ordered set where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* @param commentId the primary key of the current comment
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment
	* @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment[] findByG_D_V_PrevAndNext(
		long commentId, long groupId, long distributionId, boolean visible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchCommentException;

	/**
	* Removes all the comments where groupId = &#63; and distributionId = &#63; and visible = &#63; from the database.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_D_V(long groupId, long distributionId, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of comments where groupId = &#63; and distributionId = &#63; and visible = &#63;.
	*
	* @param groupId the group ID
	* @param distributionId the distribution ID
	* @param visible the visible
	* @return the number of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_D_V(long groupId, long distributionId, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the comment in the entity cache if it is enabled.
	*
	* @param comment the comment
	*/
	public void cacheResult(com.viettel.portal.vcms.model.Comment comment);

	/**
	* Caches the comments in the entity cache if it is enabled.
	*
	* @param comments the comments
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Comment> comments);

	/**
	* Creates a new comment with the primary key. Does not add the comment to the database.
	*
	* @param commentId the primary key for the new comment
	* @return the new comment
	*/
	public com.viettel.portal.vcms.model.Comment create(long commentId);

	/**
	* Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commentId the primary key of the comment
	* @return the comment that was removed
	* @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment remove(long commentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchCommentException;

	public com.viettel.portal.vcms.model.Comment updateImpl(
		com.viettel.portal.vcms.model.Comment comment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the comment with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchCommentException} if it could not be found.
	*
	* @param commentId the primary key of the comment
	* @return the comment
	* @throws com.viettel.portal.vcms.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment findByPrimaryKey(
		long commentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchCommentException;

	/**
	* Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commentId the primary key of the comment
	* @return the comment, or <code>null</code> if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Comment fetchByPrimaryKey(
		long commentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the comments.
	*
	* @return the comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Comment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.Comment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the comments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Comment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the comments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of comments.
	*
	* @return the number of comments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}