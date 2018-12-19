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

import com.viettel.portal.vcms.model.Legal_Comment;

/**
 * The persistence interface for the legal_ comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chuchv
 * @see Legal_CommentPersistenceImpl
 * @see Legal_CommentUtil
 * @generated
 */
public interface Legal_CommentPersistence extends BasePersistence<Legal_Comment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Legal_CommentUtil} to access the legal_ comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the legal_ comments where DistributionID = &#63;.
	*
	* @param DistributionID the distribution i d
	* @return the matching legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Comment> findByByDistribution(
		int DistributionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal_ comments where DistributionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DistributionID the distribution i d
	* @param start the lower bound of the range of legal_ comments
	* @param end the upper bound of the range of legal_ comments (not inclusive)
	* @return the range of matching legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Comment> findByByDistribution(
		int DistributionID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal_ comments where DistributionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DistributionID the distribution i d
	* @param start the lower bound of the range of legal_ comments
	* @param end the upper bound of the range of legal_ comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Comment> findByByDistribution(
		int DistributionID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal_ comment in the ordered set where DistributionID = &#63;.
	*
	* @param DistributionID the distribution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ comment
	* @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a matching legal_ comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Comment findByByDistribution_First(
		int DistributionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_CommentException;

	/**
	* Returns the first legal_ comment in the ordered set where DistributionID = &#63;.
	*
	* @param DistributionID the distribution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal_ comment, or <code>null</code> if a matching legal_ comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Comment fetchByByDistribution_First(
		int DistributionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal_ comment in the ordered set where DistributionID = &#63;.
	*
	* @param DistributionID the distribution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ comment
	* @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a matching legal_ comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Comment findByByDistribution_Last(
		int DistributionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_CommentException;

	/**
	* Returns the last legal_ comment in the ordered set where DistributionID = &#63;.
	*
	* @param DistributionID the distribution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal_ comment, or <code>null</code> if a matching legal_ comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Comment fetchByByDistribution_Last(
		int DistributionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal_ comments before and after the current legal_ comment in the ordered set where DistributionID = &#63;.
	*
	* @param ID the primary key of the current legal_ comment
	* @param DistributionID the distribution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal_ comment
	* @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a legal_ comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Comment[] findByByDistribution_PrevAndNext(
		int ID, int DistributionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_CommentException;

	/**
	* Removes all the legal_ comments where DistributionID = &#63; from the database.
	*
	* @param DistributionID the distribution i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByDistribution(int DistributionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ comments where DistributionID = &#63;.
	*
	* @param DistributionID the distribution i d
	* @return the number of matching legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	public int countByByDistribution(int DistributionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the legal_ comment in the entity cache if it is enabled.
	*
	* @param legal_Comment the legal_ comment
	*/
	public void cacheResult(
		com.viettel.portal.vcms.model.Legal_Comment legal_Comment);

	/**
	* Caches the legal_ comments in the entity cache if it is enabled.
	*
	* @param legal_Comments the legal_ comments
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vcms.model.Legal_Comment> legal_Comments);

	/**
	* Creates a new legal_ comment with the primary key. Does not add the legal_ comment to the database.
	*
	* @param ID the primary key for the new legal_ comment
	* @return the new legal_ comment
	*/
	public com.viettel.portal.vcms.model.Legal_Comment create(int ID);

	/**
	* Removes the legal_ comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the legal_ comment
	* @return the legal_ comment that was removed
	* @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a legal_ comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Comment remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_CommentException;

	public com.viettel.portal.vcms.model.Legal_Comment updateImpl(
		com.viettel.portal.vcms.model.Legal_Comment legal_Comment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal_ comment with the primary key or throws a {@link com.viettel.portal.vcms.NoSuchLegal_CommentException} if it could not be found.
	*
	* @param ID the primary key of the legal_ comment
	* @return the legal_ comment
	* @throws com.viettel.portal.vcms.NoSuchLegal_CommentException if a legal_ comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Comment findByPrimaryKey(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vcms.NoSuchLegal_CommentException;

	/**
	* Returns the legal_ comment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the legal_ comment
	* @return the legal_ comment, or <code>null</code> if a legal_ comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vcms.model.Legal_Comment fetchByPrimaryKey(int ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legal_ comments.
	*
	* @return the legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Comment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viettel.portal.vcms.model.Legal_Comment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal_ comments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vcms.model.impl.Legal_CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legal_ comments
	* @param end the upper bound of the range of legal_ comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vcms.model.Legal_Comment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal_ comments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal_ comments.
	*
	* @return the number of legal_ comments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}