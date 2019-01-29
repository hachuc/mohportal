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

package com.revotech.portal.vbpq.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.revotech.portal.vbpq.model.VanBanPhapQuy;
import com.revotech.portal.vbpq.service.VanBanPhapQuyLocalService;
import com.revotech.portal.vbpq.service.persistence.AttachFilePersistence;
import com.revotech.portal.vbpq.service.persistence.CoQuanBanHanhVanBanFinder;
import com.revotech.portal.vbpq.service.persistence.CoQuanBanHanhVanBanPersistence;
import com.revotech.portal.vbpq.service.persistence.LinhVucVanBanFinder;
import com.revotech.portal.vbpq.service.persistence.LinhVucVanBanPersistence;
import com.revotech.portal.vbpq.service.persistence.LoaiVanBanFinder;
import com.revotech.portal.vbpq.service.persistence.LoaiVanBanPersistence;
import com.revotech.portal.vbpq.service.persistence.NhomVanBanPersistence;
import com.revotech.portal.vbpq.service.persistence.VanBanPhapQuyFinder;
import com.revotech.portal.vbpq.service.persistence.VanBanPhapQuyPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the van ban phap quy local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.revotech.portal.vbpq.service.impl.VanBanPhapQuyLocalServiceImpl}.
 * </p>
 *
 * @author ChucHV
 * @see com.revotech.portal.vbpq.service.impl.VanBanPhapQuyLocalServiceImpl
 * @see com.revotech.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil
 * @generated
 */
public abstract class VanBanPhapQuyLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements VanBanPhapQuyLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.revotech.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil} to access the van ban phap quy local service.
	 */

	/**
	 * Adds the van ban phap quy to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vanBanPhapQuy the van ban phap quy
	 * @return the van ban phap quy that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public VanBanPhapQuy addVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy)
		throws SystemException {
		vanBanPhapQuy.setNew(true);

		return vanBanPhapQuyPersistence.update(vanBanPhapQuy);
	}

	/**
	 * Creates a new van ban phap quy with the primary key. Does not add the van ban phap quy to the database.
	 *
	 * @param id the primary key for the new van ban phap quy
	 * @return the new van ban phap quy
	 */
	@Override
	public VanBanPhapQuy createVanBanPhapQuy(long id) {
		return vanBanPhapQuyPersistence.create(id);
	}

	/**
	 * Deletes the van ban phap quy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the van ban phap quy
	 * @return the van ban phap quy that was removed
	 * @throws PortalException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public VanBanPhapQuy deleteVanBanPhapQuy(long id)
		throws PortalException, SystemException {
		return vanBanPhapQuyPersistence.remove(id);
	}

	/**
	 * Deletes the van ban phap quy from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vanBanPhapQuy the van ban phap quy
	 * @return the van ban phap quy that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public VanBanPhapQuy deleteVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy)
		throws SystemException {
		return vanBanPhapQuyPersistence.remove(vanBanPhapQuy);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(VanBanPhapQuy.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return vanBanPhapQuyPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return vanBanPhapQuyPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return vanBanPhapQuyPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return vanBanPhapQuyPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return vanBanPhapQuyPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public VanBanPhapQuy fetchVanBanPhapQuy(long id) throws SystemException {
		return vanBanPhapQuyPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the van ban phap quy with the primary key.
	 *
	 * @param id the primary key of the van ban phap quy
	 * @return the van ban phap quy
	 * @throws PortalException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy getVanBanPhapQuy(long id)
		throws PortalException, SystemException {
		return vanBanPhapQuyPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return vanBanPhapQuyPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the van ban phap quies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.revotech.portal.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @return the range of van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> getVanBanPhapQuies(int start, int end)
		throws SystemException {
		return vanBanPhapQuyPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of van ban phap quies.
	 *
	 * @return the number of van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVanBanPhapQuiesCount() throws SystemException {
		return vanBanPhapQuyPersistence.countAll();
	}

	/**
	 * Updates the van ban phap quy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vanBanPhapQuy the van ban phap quy
	 * @return the van ban phap quy that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public VanBanPhapQuy updateVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy)
		throws SystemException {
		return vanBanPhapQuyPersistence.update(vanBanPhapQuy);
	}

	/**
	 * Returns the attach file local service.
	 *
	 * @return the attach file local service
	 */
	public com.revotech.portal.vbpq.service.AttachFileLocalService getAttachFileLocalService() {
		return attachFileLocalService;
	}

	/**
	 * Sets the attach file local service.
	 *
	 * @param attachFileLocalService the attach file local service
	 */
	public void setAttachFileLocalService(
		com.revotech.portal.vbpq.service.AttachFileLocalService attachFileLocalService) {
		this.attachFileLocalService = attachFileLocalService;
	}

	/**
	 * Returns the attach file persistence.
	 *
	 * @return the attach file persistence
	 */
	public AttachFilePersistence getAttachFilePersistence() {
		return attachFilePersistence;
	}

	/**
	 * Sets the attach file persistence.
	 *
	 * @param attachFilePersistence the attach file persistence
	 */
	public void setAttachFilePersistence(
		AttachFilePersistence attachFilePersistence) {
		this.attachFilePersistence = attachFilePersistence;
	}

	/**
	 * Returns the co quan ban hanh van ban local service.
	 *
	 * @return the co quan ban hanh van ban local service
	 */
	public com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalService getCoQuanBanHanhVanBanLocalService() {
		return coQuanBanHanhVanBanLocalService;
	}

	/**
	 * Sets the co quan ban hanh van ban local service.
	 *
	 * @param coQuanBanHanhVanBanLocalService the co quan ban hanh van ban local service
	 */
	public void setCoQuanBanHanhVanBanLocalService(
		com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalService coQuanBanHanhVanBanLocalService) {
		this.coQuanBanHanhVanBanLocalService = coQuanBanHanhVanBanLocalService;
	}

	/**
	 * Returns the co quan ban hanh van ban persistence.
	 *
	 * @return the co quan ban hanh van ban persistence
	 */
	public CoQuanBanHanhVanBanPersistence getCoQuanBanHanhVanBanPersistence() {
		return coQuanBanHanhVanBanPersistence;
	}

	/**
	 * Sets the co quan ban hanh van ban persistence.
	 *
	 * @param coQuanBanHanhVanBanPersistence the co quan ban hanh van ban persistence
	 */
	public void setCoQuanBanHanhVanBanPersistence(
		CoQuanBanHanhVanBanPersistence coQuanBanHanhVanBanPersistence) {
		this.coQuanBanHanhVanBanPersistence = coQuanBanHanhVanBanPersistence;
	}

	/**
	 * Returns the co quan ban hanh van ban finder.
	 *
	 * @return the co quan ban hanh van ban finder
	 */
	public CoQuanBanHanhVanBanFinder getCoQuanBanHanhVanBanFinder() {
		return coQuanBanHanhVanBanFinder;
	}

	/**
	 * Sets the co quan ban hanh van ban finder.
	 *
	 * @param coQuanBanHanhVanBanFinder the co quan ban hanh van ban finder
	 */
	public void setCoQuanBanHanhVanBanFinder(
		CoQuanBanHanhVanBanFinder coQuanBanHanhVanBanFinder) {
		this.coQuanBanHanhVanBanFinder = coQuanBanHanhVanBanFinder;
	}

	/**
	 * Returns the linh vuc van ban local service.
	 *
	 * @return the linh vuc van ban local service
	 */
	public com.revotech.portal.vbpq.service.LinhVucVanBanLocalService getLinhVucVanBanLocalService() {
		return linhVucVanBanLocalService;
	}

	/**
	 * Sets the linh vuc van ban local service.
	 *
	 * @param linhVucVanBanLocalService the linh vuc van ban local service
	 */
	public void setLinhVucVanBanLocalService(
		com.revotech.portal.vbpq.service.LinhVucVanBanLocalService linhVucVanBanLocalService) {
		this.linhVucVanBanLocalService = linhVucVanBanLocalService;
	}

	/**
	 * Returns the linh vuc van ban persistence.
	 *
	 * @return the linh vuc van ban persistence
	 */
	public LinhVucVanBanPersistence getLinhVucVanBanPersistence() {
		return linhVucVanBanPersistence;
	}

	/**
	 * Sets the linh vuc van ban persistence.
	 *
	 * @param linhVucVanBanPersistence the linh vuc van ban persistence
	 */
	public void setLinhVucVanBanPersistence(
		LinhVucVanBanPersistence linhVucVanBanPersistence) {
		this.linhVucVanBanPersistence = linhVucVanBanPersistence;
	}

	/**
	 * Returns the linh vuc van ban finder.
	 *
	 * @return the linh vuc van ban finder
	 */
	public LinhVucVanBanFinder getLinhVucVanBanFinder() {
		return linhVucVanBanFinder;
	}

	/**
	 * Sets the linh vuc van ban finder.
	 *
	 * @param linhVucVanBanFinder the linh vuc van ban finder
	 */
	public void setLinhVucVanBanFinder(LinhVucVanBanFinder linhVucVanBanFinder) {
		this.linhVucVanBanFinder = linhVucVanBanFinder;
	}

	/**
	 * Returns the loai van ban local service.
	 *
	 * @return the loai van ban local service
	 */
	public com.revotech.portal.vbpq.service.LoaiVanBanLocalService getLoaiVanBanLocalService() {
		return loaiVanBanLocalService;
	}

	/**
	 * Sets the loai van ban local service.
	 *
	 * @param loaiVanBanLocalService the loai van ban local service
	 */
	public void setLoaiVanBanLocalService(
		com.revotech.portal.vbpq.service.LoaiVanBanLocalService loaiVanBanLocalService) {
		this.loaiVanBanLocalService = loaiVanBanLocalService;
	}

	/**
	 * Returns the loai van ban persistence.
	 *
	 * @return the loai van ban persistence
	 */
	public LoaiVanBanPersistence getLoaiVanBanPersistence() {
		return loaiVanBanPersistence;
	}

	/**
	 * Sets the loai van ban persistence.
	 *
	 * @param loaiVanBanPersistence the loai van ban persistence
	 */
	public void setLoaiVanBanPersistence(
		LoaiVanBanPersistence loaiVanBanPersistence) {
		this.loaiVanBanPersistence = loaiVanBanPersistence;
	}

	/**
	 * Returns the loai van ban finder.
	 *
	 * @return the loai van ban finder
	 */
	public LoaiVanBanFinder getLoaiVanBanFinder() {
		return loaiVanBanFinder;
	}

	/**
	 * Sets the loai van ban finder.
	 *
	 * @param loaiVanBanFinder the loai van ban finder
	 */
	public void setLoaiVanBanFinder(LoaiVanBanFinder loaiVanBanFinder) {
		this.loaiVanBanFinder = loaiVanBanFinder;
	}

	/**
	 * Returns the nhom van ban local service.
	 *
	 * @return the nhom van ban local service
	 */
	public com.revotech.portal.vbpq.service.NhomVanBanLocalService getNhomVanBanLocalService() {
		return nhomVanBanLocalService;
	}

	/**
	 * Sets the nhom van ban local service.
	 *
	 * @param nhomVanBanLocalService the nhom van ban local service
	 */
	public void setNhomVanBanLocalService(
		com.revotech.portal.vbpq.service.NhomVanBanLocalService nhomVanBanLocalService) {
		this.nhomVanBanLocalService = nhomVanBanLocalService;
	}

	/**
	 * Returns the nhom van ban persistence.
	 *
	 * @return the nhom van ban persistence
	 */
	public NhomVanBanPersistence getNhomVanBanPersistence() {
		return nhomVanBanPersistence;
	}

	/**
	 * Sets the nhom van ban persistence.
	 *
	 * @param nhomVanBanPersistence the nhom van ban persistence
	 */
	public void setNhomVanBanPersistence(
		NhomVanBanPersistence nhomVanBanPersistence) {
		this.nhomVanBanPersistence = nhomVanBanPersistence;
	}

	/**
	 * Returns the van ban phap quy local service.
	 *
	 * @return the van ban phap quy local service
	 */
	public com.revotech.portal.vbpq.service.VanBanPhapQuyLocalService getVanBanPhapQuyLocalService() {
		return vanBanPhapQuyLocalService;
	}

	/**
	 * Sets the van ban phap quy local service.
	 *
	 * @param vanBanPhapQuyLocalService the van ban phap quy local service
	 */
	public void setVanBanPhapQuyLocalService(
		com.revotech.portal.vbpq.service.VanBanPhapQuyLocalService vanBanPhapQuyLocalService) {
		this.vanBanPhapQuyLocalService = vanBanPhapQuyLocalService;
	}

	/**
	 * Returns the van ban phap quy persistence.
	 *
	 * @return the van ban phap quy persistence
	 */
	public VanBanPhapQuyPersistence getVanBanPhapQuyPersistence() {
		return vanBanPhapQuyPersistence;
	}

	/**
	 * Sets the van ban phap quy persistence.
	 *
	 * @param vanBanPhapQuyPersistence the van ban phap quy persistence
	 */
	public void setVanBanPhapQuyPersistence(
		VanBanPhapQuyPersistence vanBanPhapQuyPersistence) {
		this.vanBanPhapQuyPersistence = vanBanPhapQuyPersistence;
	}

	/**
	 * Returns the van ban phap quy finder.
	 *
	 * @return the van ban phap quy finder
	 */
	public VanBanPhapQuyFinder getVanBanPhapQuyFinder() {
		return vanBanPhapQuyFinder;
	}

	/**
	 * Sets the van ban phap quy finder.
	 *
	 * @param vanBanPhapQuyFinder the van ban phap quy finder
	 */
	public void setVanBanPhapQuyFinder(VanBanPhapQuyFinder vanBanPhapQuyFinder) {
		this.vanBanPhapQuyFinder = vanBanPhapQuyFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.revotech.portal.vbpq.model.VanBanPhapQuy",
			vanBanPhapQuyLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.revotech.portal.vbpq.model.VanBanPhapQuy");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return VanBanPhapQuy.class;
	}

	protected String getModelClassName() {
		return VanBanPhapQuy.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = vanBanPhapQuyPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.revotech.portal.vbpq.service.AttachFileLocalService.class)
	protected com.revotech.portal.vbpq.service.AttachFileLocalService attachFileLocalService;
	@BeanReference(type = AttachFilePersistence.class)
	protected AttachFilePersistence attachFilePersistence;
	@BeanReference(type = com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalService.class)
	protected com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalService coQuanBanHanhVanBanLocalService;
	@BeanReference(type = CoQuanBanHanhVanBanPersistence.class)
	protected CoQuanBanHanhVanBanPersistence coQuanBanHanhVanBanPersistence;
	@BeanReference(type = CoQuanBanHanhVanBanFinder.class)
	protected CoQuanBanHanhVanBanFinder coQuanBanHanhVanBanFinder;
	@BeanReference(type = com.revotech.portal.vbpq.service.LinhVucVanBanLocalService.class)
	protected com.revotech.portal.vbpq.service.LinhVucVanBanLocalService linhVucVanBanLocalService;
	@BeanReference(type = LinhVucVanBanPersistence.class)
	protected LinhVucVanBanPersistence linhVucVanBanPersistence;
	@BeanReference(type = LinhVucVanBanFinder.class)
	protected LinhVucVanBanFinder linhVucVanBanFinder;
	@BeanReference(type = com.revotech.portal.vbpq.service.LoaiVanBanLocalService.class)
	protected com.revotech.portal.vbpq.service.LoaiVanBanLocalService loaiVanBanLocalService;
	@BeanReference(type = LoaiVanBanPersistence.class)
	protected LoaiVanBanPersistence loaiVanBanPersistence;
	@BeanReference(type = LoaiVanBanFinder.class)
	protected LoaiVanBanFinder loaiVanBanFinder;
	@BeanReference(type = com.revotech.portal.vbpq.service.NhomVanBanLocalService.class)
	protected com.revotech.portal.vbpq.service.NhomVanBanLocalService nhomVanBanLocalService;
	@BeanReference(type = NhomVanBanPersistence.class)
	protected NhomVanBanPersistence nhomVanBanPersistence;
	@BeanReference(type = com.revotech.portal.vbpq.service.VanBanPhapQuyLocalService.class)
	protected com.revotech.portal.vbpq.service.VanBanPhapQuyLocalService vanBanPhapQuyLocalService;
	@BeanReference(type = VanBanPhapQuyPersistence.class)
	protected VanBanPhapQuyPersistence vanBanPhapQuyPersistence;
	@BeanReference(type = VanBanPhapQuyFinder.class)
	protected VanBanPhapQuyFinder vanBanPhapQuyFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private VanBanPhapQuyLocalServiceClpInvoker _clpInvoker = new VanBanPhapQuyLocalServiceClpInvoker();
}