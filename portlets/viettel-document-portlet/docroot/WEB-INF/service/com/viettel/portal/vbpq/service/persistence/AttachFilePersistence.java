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

package com.viettel.portal.vbpq.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.vbpq.model.AttachFile;

/**
 * The persistence interface for the attach file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see AttachFilePersistenceImpl
 * @see AttachFileUtil
 * @generated
 */
public interface AttachFilePersistence extends BasePersistence<AttachFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttachFileUtil} to access the attach file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the attach files where vanBanId = &#63;.
	*
	* @param vanBanId the van ban ID
	* @return the matching attach files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.AttachFile> findByVANBANID(
		long vanBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the attach files where vanBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vanBanId the van ban ID
	* @param start the lower bound of the range of attach files
	* @param end the upper bound of the range of attach files (not inclusive)
	* @return the range of matching attach files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.AttachFile> findByVANBANID(
		long vanBanId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the attach files where vanBanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vanBanId the van ban ID
	* @param start the lower bound of the range of attach files
	* @param end the upper bound of the range of attach files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attach files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.AttachFile> findByVANBANID(
		long vanBanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attach file in the ordered set where vanBanId = &#63;.
	*
	* @param vanBanId the van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attach file
	* @throws com.viettel.portal.vbpq.NoSuchAttachFileException if a matching attach file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.AttachFile findByVANBANID_First(
		long vanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchAttachFileException;

	/**
	* Returns the first attach file in the ordered set where vanBanId = &#63;.
	*
	* @param vanBanId the van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attach file, or <code>null</code> if a matching attach file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.AttachFile fetchByVANBANID_First(
		long vanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attach file in the ordered set where vanBanId = &#63;.
	*
	* @param vanBanId the van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attach file
	* @throws com.viettel.portal.vbpq.NoSuchAttachFileException if a matching attach file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.AttachFile findByVANBANID_Last(
		long vanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchAttachFileException;

	/**
	* Returns the last attach file in the ordered set where vanBanId = &#63;.
	*
	* @param vanBanId the van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attach file, or <code>null</code> if a matching attach file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.AttachFile fetchByVANBANID_Last(
		long vanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attach files before and after the current attach file in the ordered set where vanBanId = &#63;.
	*
	* @param id the primary key of the current attach file
	* @param vanBanId the van ban ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attach file
	* @throws com.viettel.portal.vbpq.NoSuchAttachFileException if a attach file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.AttachFile[] findByVANBANID_PrevAndNext(
		long id, long vanBanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchAttachFileException;

	/**
	* Removes all the attach files where vanBanId = &#63; from the database.
	*
	* @param vanBanId the van ban ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVANBANID(long vanBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attach files where vanBanId = &#63;.
	*
	* @param vanBanId the van ban ID
	* @return the number of matching attach files
	* @throws SystemException if a system exception occurred
	*/
	public int countByVANBANID(long vanBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the attach file in the entity cache if it is enabled.
	*
	* @param attachFile the attach file
	*/
	public void cacheResult(com.viettel.portal.vbpq.model.AttachFile attachFile);

	/**
	* Caches the attach files in the entity cache if it is enabled.
	*
	* @param attachFiles the attach files
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.vbpq.model.AttachFile> attachFiles);

	/**
	* Creates a new attach file with the primary key. Does not add the attach file to the database.
	*
	* @param id the primary key for the new attach file
	* @return the new attach file
	*/
	public com.viettel.portal.vbpq.model.AttachFile create(long id);

	/**
	* Removes the attach file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the attach file
	* @return the attach file that was removed
	* @throws com.viettel.portal.vbpq.NoSuchAttachFileException if a attach file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.AttachFile remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchAttachFileException;

	public com.viettel.portal.vbpq.model.AttachFile updateImpl(
		com.viettel.portal.vbpq.model.AttachFile attachFile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attach file with the primary key or throws a {@link com.viettel.portal.vbpq.NoSuchAttachFileException} if it could not be found.
	*
	* @param id the primary key of the attach file
	* @return the attach file
	* @throws com.viettel.portal.vbpq.NoSuchAttachFileException if a attach file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.AttachFile findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.vbpq.NoSuchAttachFileException;

	/**
	* Returns the attach file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the attach file
	* @return the attach file, or <code>null</code> if a attach file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.vbpq.model.AttachFile fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the attach files.
	*
	* @return the attach files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.AttachFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the attach files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attach files
	* @param end the upper bound of the range of attach files (not inclusive)
	* @return the range of attach files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.AttachFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the attach files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.AttachFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attach files
	* @param end the upper bound of the range of attach files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attach files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.vbpq.model.AttachFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the attach files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attach files.
	*
	* @return the number of attach files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}