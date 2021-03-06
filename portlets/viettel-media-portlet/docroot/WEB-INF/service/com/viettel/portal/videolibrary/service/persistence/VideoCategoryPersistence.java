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

package com.viettel.portal.videolibrary.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viettel.portal.videolibrary.model.VideoCategory;

/**
 * The persistence interface for the video category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VideoCategoryPersistenceImpl
 * @see VideoCategoryUtil
 * @generated
 */
public interface VideoCategoryPersistence extends BasePersistence<VideoCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoCategoryUtil} to access the video category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video category in the entity cache if it is enabled.
	*
	* @param videoCategory the video category
	*/
	public void cacheResult(
		com.viettel.portal.videolibrary.model.VideoCategory videoCategory);

	/**
	* Caches the video categories in the entity cache if it is enabled.
	*
	* @param videoCategories the video categories
	*/
	public void cacheResult(
		java.util.List<com.viettel.portal.videolibrary.model.VideoCategory> videoCategories);

	/**
	* Creates a new video category with the primary key. Does not add the video category to the database.
	*
	* @param ID the primary key for the new video category
	* @return the new video category
	*/
	public com.viettel.portal.videolibrary.model.VideoCategory create(int ID);

	/**
	* Removes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the video category
	* @return the video category that was removed
	* @throws com.viettel.portal.videolibrary.NoSuchVideoCategoryException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoCategory remove(int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVideoCategoryException;

	public com.viettel.portal.videolibrary.model.VideoCategory updateImpl(
		com.viettel.portal.videolibrary.model.VideoCategory videoCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video category with the primary key or throws a {@link com.viettel.portal.videolibrary.NoSuchVideoCategoryException} if it could not be found.
	*
	* @param ID the primary key of the video category
	* @return the video category
	* @throws com.viettel.portal.videolibrary.NoSuchVideoCategoryException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoCategory findByPrimaryKey(
		int ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viettel.portal.videolibrary.NoSuchVideoCategoryException;

	/**
	* Returns the video category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the video category
	* @return the video category, or <code>null</code> if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viettel.portal.videolibrary.model.VideoCategory fetchByPrimaryKey(
		int ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video categories.
	*
	* @return the video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VideoCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @return the range of video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VideoCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VideoCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viettel.portal.videolibrary.model.VideoCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video categories.
	*
	* @return the number of video categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}