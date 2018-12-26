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

package com.viettel.portal.vbpq.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for CoQuanBanHanhVanBan. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author ChucHV
 * @see CoQuanBanHanhVanBanLocalServiceUtil
 * @see com.viettel.portal.vbpq.service.base.CoQuanBanHanhVanBanLocalServiceBaseImpl
 * @see com.viettel.portal.vbpq.service.impl.CoQuanBanHanhVanBanLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CoQuanBanHanhVanBanLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoQuanBanHanhVanBanLocalServiceUtil} to access the co quan ban hanh van ban local service. Add custom service methods to {@link com.viettel.portal.vbpq.service.impl.CoQuanBanHanhVanBanLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the co quan ban hanh van ban to the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanBanHanhVanBan the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan addCoQuanBanHanhVanBan(
		com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new co quan ban hanh van ban with the primary key. Does not add the co quan ban hanh van ban to the database.
	*
	* @param id the primary key for the new co quan ban hanh van ban
	* @return the new co quan ban hanh van ban
	*/
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan createCoQuanBanHanhVanBan(
		long id);

	/**
	* Deletes the co quan ban hanh van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was removed
	* @throws PortalException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan deleteCoQuanBanHanhVanBan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the co quan ban hanh van ban from the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanBanHanhVanBan the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan deleteCoQuanBanHanhVanBan(
		com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan fetchCoQuanBanHanhVanBan(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the co quan ban hanh van ban with the primary key.
	*
	* @param id the primary key of the co quan ban hanh van ban
	* @return the co quan ban hanh van ban
	* @throws PortalException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan getCoQuanBanHanhVanBan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the co quan ban hanh van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @return the range of co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan> getCoQuanBanHanhVanBans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of co quan ban hanh van bans.
	*
	* @return the number of co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCoQuanBanHanhVanBansCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the co quan ban hanh van ban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanBanHanhVanBan the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan updateCoQuanBanHanhVanBan(
		com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.util.List<com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan> findByNhomVanBanId(
		long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan getByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param keyword
	* @param groupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public int countCoQuan(java.lang.String keyword, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param keyword
	* @param groupId
	* @param obc
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public java.util.List<com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan> findCoQuan(
		java.lang.String keyword, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan> findByTrangThai(
		boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan getCoQuanBanHanh(
		long coquanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param groupId
	* @param trangThai
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public int countByTrangThai(long groupId, boolean trangThai)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param groupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public int countAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param groupId
	* @param trangThai
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan> getByTrangThai(
		long groupId, boolean trangThai, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param groupId
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan> getAll(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Delete coquan by Id
	*
	* @param id
	* @throws PortalException
	* @throws SystemException
	*/
	public void deleteCoQuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Delete coquan by entry
	*
	* @param coquan
	* @throws PortalException
	* @throws SystemException
	*/
	public void deleteCoQuan(
		com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan coquan)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param userId
	* @param id
	* @param ten
	* @param trangThai
	* @param order_
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan updateCoQuanBanHanh(
		long userId, long id, java.lang.String ten, boolean trangThai,
		int order_, long groupId, long nhomVanBanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}