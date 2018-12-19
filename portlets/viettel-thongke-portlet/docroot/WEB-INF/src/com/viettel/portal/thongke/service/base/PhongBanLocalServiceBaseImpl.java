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

package com.viettel.portal.thongke.service.base;

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

import com.viettel.portal.thongke.model.PhongBan;
import com.viettel.portal.thongke.service.PhongBanLocalService;
import com.viettel.portal.thongke.service.persistence.BaiVietNhuanButFinder;
import com.viettel.portal.thongke.service.persistence.BaiVietNhuanButPersistence;
import com.viettel.portal.thongke.service.persistence.ContentProfitFinder;
import com.viettel.portal.thongke.service.persistence.ContentProfitPersistence;
import com.viettel.portal.thongke.service.persistence.ContentTypeCostPersistence;
import com.viettel.portal.thongke.service.persistence.ContentTypePersistence;
import com.viettel.portal.thongke.service.persistence.PhongBanFinder;
import com.viettel.portal.thongke.service.persistence.PhongBanNhuanButChiTietPersistence;
import com.viettel.portal.thongke.service.persistence.PhongBanNhuanButFinder;
import com.viettel.portal.thongke.service.persistence.PhongBanNhuanButPersistence;
import com.viettel.portal.thongke.service.persistence.PhongBanPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the phong ban local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.viettel.portal.thongke.service.impl.PhongBanLocalServiceImpl}.
 * </p>
 *
 * @author lamvn
 * @see com.viettel.portal.thongke.service.impl.PhongBanLocalServiceImpl
 * @see com.viettel.portal.thongke.service.PhongBanLocalServiceUtil
 * @generated
 */
public abstract class PhongBanLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements PhongBanLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.viettel.portal.thongke.service.PhongBanLocalServiceUtil} to access the phong ban local service.
	 */

	/**
	 * Adds the phong ban to the database. Also notifies the appropriate model listeners.
	 *
	 * @param phongBan the phong ban
	 * @return the phong ban that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PhongBan addPhongBan(PhongBan phongBan) throws SystemException {
		phongBan.setNew(true);

		return phongBanPersistence.update(phongBan);
	}

	/**
	 * Creates a new phong ban with the primary key. Does not add the phong ban to the database.
	 *
	 * @param id the primary key for the new phong ban
	 * @return the new phong ban
	 */
	@Override
	public PhongBan createPhongBan(long id) {
		return phongBanPersistence.create(id);
	}

	/**
	 * Deletes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phong ban
	 * @return the phong ban that was removed
	 * @throws PortalException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PhongBan deletePhongBan(long id)
		throws PortalException, SystemException {
		return phongBanPersistence.remove(id);
	}

	/**
	 * Deletes the phong ban from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phongBan the phong ban
	 * @return the phong ban that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PhongBan deletePhongBan(PhongBan phongBan) throws SystemException {
		return phongBanPersistence.remove(phongBan);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(PhongBan.class,
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
		return phongBanPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return phongBanPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return phongBanPersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return phongBanPersistence.countWithDynamicQuery(dynamicQuery);
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
		return phongBanPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public PhongBan fetchPhongBan(long id) throws SystemException {
		return phongBanPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the phong ban with the primary key.
	 *
	 * @param id the primary key of the phong ban
	 * @return the phong ban
	 * @throws PortalException if a phong ban with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PhongBan getPhongBan(long id)
		throws PortalException, SystemException {
		return phongBanPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return phongBanPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.PhongBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PhongBan> getPhongBans(int start, int end)
		throws SystemException {
		return phongBanPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of phong bans.
	 *
	 * @return the number of phong bans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getPhongBansCount() throws SystemException {
		return phongBanPersistence.countAll();
	}

	/**
	 * Updates the phong ban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phongBan the phong ban
	 * @return the phong ban that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PhongBan updatePhongBan(PhongBan phongBan) throws SystemException {
		return phongBanPersistence.update(phongBan);
	}

	/**
	 * Returns the bai viet nhuan but local service.
	 *
	 * @return the bai viet nhuan but local service
	 */
	public com.viettel.portal.thongke.service.BaiVietNhuanButLocalService getBaiVietNhuanButLocalService() {
		return baiVietNhuanButLocalService;
	}

	/**
	 * Sets the bai viet nhuan but local service.
	 *
	 * @param baiVietNhuanButLocalService the bai viet nhuan but local service
	 */
	public void setBaiVietNhuanButLocalService(
		com.viettel.portal.thongke.service.BaiVietNhuanButLocalService baiVietNhuanButLocalService) {
		this.baiVietNhuanButLocalService = baiVietNhuanButLocalService;
	}

	/**
	 * Returns the bai viet nhuan but persistence.
	 *
	 * @return the bai viet nhuan but persistence
	 */
	public BaiVietNhuanButPersistence getBaiVietNhuanButPersistence() {
		return baiVietNhuanButPersistence;
	}

	/**
	 * Sets the bai viet nhuan but persistence.
	 *
	 * @param baiVietNhuanButPersistence the bai viet nhuan but persistence
	 */
	public void setBaiVietNhuanButPersistence(
		BaiVietNhuanButPersistence baiVietNhuanButPersistence) {
		this.baiVietNhuanButPersistence = baiVietNhuanButPersistence;
	}

	/**
	 * Returns the bai viet nhuan but finder.
	 *
	 * @return the bai viet nhuan but finder
	 */
	public BaiVietNhuanButFinder getBaiVietNhuanButFinder() {
		return baiVietNhuanButFinder;
	}

	/**
	 * Sets the bai viet nhuan but finder.
	 *
	 * @param baiVietNhuanButFinder the bai viet nhuan but finder
	 */
	public void setBaiVietNhuanButFinder(
		BaiVietNhuanButFinder baiVietNhuanButFinder) {
		this.baiVietNhuanButFinder = baiVietNhuanButFinder;
	}

	/**
	 * Returns the content profit local service.
	 *
	 * @return the content profit local service
	 */
	public com.viettel.portal.thongke.service.ContentProfitLocalService getContentProfitLocalService() {
		return contentProfitLocalService;
	}

	/**
	 * Sets the content profit local service.
	 *
	 * @param contentProfitLocalService the content profit local service
	 */
	public void setContentProfitLocalService(
		com.viettel.portal.thongke.service.ContentProfitLocalService contentProfitLocalService) {
		this.contentProfitLocalService = contentProfitLocalService;
	}

	/**
	 * Returns the content profit remote service.
	 *
	 * @return the content profit remote service
	 */
	public com.viettel.portal.thongke.service.ContentProfitService getContentProfitService() {
		return contentProfitService;
	}

	/**
	 * Sets the content profit remote service.
	 *
	 * @param contentProfitService the content profit remote service
	 */
	public void setContentProfitService(
		com.viettel.portal.thongke.service.ContentProfitService contentProfitService) {
		this.contentProfitService = contentProfitService;
	}

	/**
	 * Returns the content profit persistence.
	 *
	 * @return the content profit persistence
	 */
	public ContentProfitPersistence getContentProfitPersistence() {
		return contentProfitPersistence;
	}

	/**
	 * Sets the content profit persistence.
	 *
	 * @param contentProfitPersistence the content profit persistence
	 */
	public void setContentProfitPersistence(
		ContentProfitPersistence contentProfitPersistence) {
		this.contentProfitPersistence = contentProfitPersistence;
	}

	/**
	 * Returns the content profit finder.
	 *
	 * @return the content profit finder
	 */
	public ContentProfitFinder getContentProfitFinder() {
		return contentProfitFinder;
	}

	/**
	 * Sets the content profit finder.
	 *
	 * @param contentProfitFinder the content profit finder
	 */
	public void setContentProfitFinder(ContentProfitFinder contentProfitFinder) {
		this.contentProfitFinder = contentProfitFinder;
	}

	/**
	 * Returns the content type local service.
	 *
	 * @return the content type local service
	 */
	public com.viettel.portal.thongke.service.ContentTypeLocalService getContentTypeLocalService() {
		return contentTypeLocalService;
	}

	/**
	 * Sets the content type local service.
	 *
	 * @param contentTypeLocalService the content type local service
	 */
	public void setContentTypeLocalService(
		com.viettel.portal.thongke.service.ContentTypeLocalService contentTypeLocalService) {
		this.contentTypeLocalService = contentTypeLocalService;
	}

	/**
	 * Returns the content type remote service.
	 *
	 * @return the content type remote service
	 */
	public com.viettel.portal.thongke.service.ContentTypeService getContentTypeService() {
		return contentTypeService;
	}

	/**
	 * Sets the content type remote service.
	 *
	 * @param contentTypeService the content type remote service
	 */
	public void setContentTypeService(
		com.viettel.portal.thongke.service.ContentTypeService contentTypeService) {
		this.contentTypeService = contentTypeService;
	}

	/**
	 * Returns the content type persistence.
	 *
	 * @return the content type persistence
	 */
	public ContentTypePersistence getContentTypePersistence() {
		return contentTypePersistence;
	}

	/**
	 * Sets the content type persistence.
	 *
	 * @param contentTypePersistence the content type persistence
	 */
	public void setContentTypePersistence(
		ContentTypePersistence contentTypePersistence) {
		this.contentTypePersistence = contentTypePersistence;
	}

	/**
	 * Returns the content type cost local service.
	 *
	 * @return the content type cost local service
	 */
	public com.viettel.portal.thongke.service.ContentTypeCostLocalService getContentTypeCostLocalService() {
		return contentTypeCostLocalService;
	}

	/**
	 * Sets the content type cost local service.
	 *
	 * @param contentTypeCostLocalService the content type cost local service
	 */
	public void setContentTypeCostLocalService(
		com.viettel.portal.thongke.service.ContentTypeCostLocalService contentTypeCostLocalService) {
		this.contentTypeCostLocalService = contentTypeCostLocalService;
	}

	/**
	 * Returns the content type cost remote service.
	 *
	 * @return the content type cost remote service
	 */
	public com.viettel.portal.thongke.service.ContentTypeCostService getContentTypeCostService() {
		return contentTypeCostService;
	}

	/**
	 * Sets the content type cost remote service.
	 *
	 * @param contentTypeCostService the content type cost remote service
	 */
	public void setContentTypeCostService(
		com.viettel.portal.thongke.service.ContentTypeCostService contentTypeCostService) {
		this.contentTypeCostService = contentTypeCostService;
	}

	/**
	 * Returns the content type cost persistence.
	 *
	 * @return the content type cost persistence
	 */
	public ContentTypeCostPersistence getContentTypeCostPersistence() {
		return contentTypeCostPersistence;
	}

	/**
	 * Sets the content type cost persistence.
	 *
	 * @param contentTypeCostPersistence the content type cost persistence
	 */
	public void setContentTypeCostPersistence(
		ContentTypeCostPersistence contentTypeCostPersistence) {
		this.contentTypeCostPersistence = contentTypeCostPersistence;
	}

	/**
	 * Returns the phong ban local service.
	 *
	 * @return the phong ban local service
	 */
	public com.viettel.portal.thongke.service.PhongBanLocalService getPhongBanLocalService() {
		return phongBanLocalService;
	}

	/**
	 * Sets the phong ban local service.
	 *
	 * @param phongBanLocalService the phong ban local service
	 */
	public void setPhongBanLocalService(
		com.viettel.portal.thongke.service.PhongBanLocalService phongBanLocalService) {
		this.phongBanLocalService = phongBanLocalService;
	}

	/**
	 * Returns the phong ban persistence.
	 *
	 * @return the phong ban persistence
	 */
	public PhongBanPersistence getPhongBanPersistence() {
		return phongBanPersistence;
	}

	/**
	 * Sets the phong ban persistence.
	 *
	 * @param phongBanPersistence the phong ban persistence
	 */
	public void setPhongBanPersistence(PhongBanPersistence phongBanPersistence) {
		this.phongBanPersistence = phongBanPersistence;
	}

	/**
	 * Returns the phong ban finder.
	 *
	 * @return the phong ban finder
	 */
	public PhongBanFinder getPhongBanFinder() {
		return phongBanFinder;
	}

	/**
	 * Sets the phong ban finder.
	 *
	 * @param phongBanFinder the phong ban finder
	 */
	public void setPhongBanFinder(PhongBanFinder phongBanFinder) {
		this.phongBanFinder = phongBanFinder;
	}

	/**
	 * Returns the phong ban nhuan but local service.
	 *
	 * @return the phong ban nhuan but local service
	 */
	public com.viettel.portal.thongke.service.PhongBanNhuanButLocalService getPhongBanNhuanButLocalService() {
		return phongBanNhuanButLocalService;
	}

	/**
	 * Sets the phong ban nhuan but local service.
	 *
	 * @param phongBanNhuanButLocalService the phong ban nhuan but local service
	 */
	public void setPhongBanNhuanButLocalService(
		com.viettel.portal.thongke.service.PhongBanNhuanButLocalService phongBanNhuanButLocalService) {
		this.phongBanNhuanButLocalService = phongBanNhuanButLocalService;
	}

	/**
	 * Returns the phong ban nhuan but persistence.
	 *
	 * @return the phong ban nhuan but persistence
	 */
	public PhongBanNhuanButPersistence getPhongBanNhuanButPersistence() {
		return phongBanNhuanButPersistence;
	}

	/**
	 * Sets the phong ban nhuan but persistence.
	 *
	 * @param phongBanNhuanButPersistence the phong ban nhuan but persistence
	 */
	public void setPhongBanNhuanButPersistence(
		PhongBanNhuanButPersistence phongBanNhuanButPersistence) {
		this.phongBanNhuanButPersistence = phongBanNhuanButPersistence;
	}

	/**
	 * Returns the phong ban nhuan but finder.
	 *
	 * @return the phong ban nhuan but finder
	 */
	public PhongBanNhuanButFinder getPhongBanNhuanButFinder() {
		return phongBanNhuanButFinder;
	}

	/**
	 * Sets the phong ban nhuan but finder.
	 *
	 * @param phongBanNhuanButFinder the phong ban nhuan but finder
	 */
	public void setPhongBanNhuanButFinder(
		PhongBanNhuanButFinder phongBanNhuanButFinder) {
		this.phongBanNhuanButFinder = phongBanNhuanButFinder;
	}

	/**
	 * Returns the phong ban nhuan but chi tiet local service.
	 *
	 * @return the phong ban nhuan but chi tiet local service
	 */
	public com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalService getPhongBanNhuanButChiTietLocalService() {
		return phongBanNhuanButChiTietLocalService;
	}

	/**
	 * Sets the phong ban nhuan but chi tiet local service.
	 *
	 * @param phongBanNhuanButChiTietLocalService the phong ban nhuan but chi tiet local service
	 */
	public void setPhongBanNhuanButChiTietLocalService(
		com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalService phongBanNhuanButChiTietLocalService) {
		this.phongBanNhuanButChiTietLocalService = phongBanNhuanButChiTietLocalService;
	}

	/**
	 * Returns the phong ban nhuan but chi tiet persistence.
	 *
	 * @return the phong ban nhuan but chi tiet persistence
	 */
	public PhongBanNhuanButChiTietPersistence getPhongBanNhuanButChiTietPersistence() {
		return phongBanNhuanButChiTietPersistence;
	}

	/**
	 * Sets the phong ban nhuan but chi tiet persistence.
	 *
	 * @param phongBanNhuanButChiTietPersistence the phong ban nhuan but chi tiet persistence
	 */
	public void setPhongBanNhuanButChiTietPersistence(
		PhongBanNhuanButChiTietPersistence phongBanNhuanButChiTietPersistence) {
		this.phongBanNhuanButChiTietPersistence = phongBanNhuanButChiTietPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.viettel.portal.thongke.model.PhongBan",
			phongBanLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.viettel.portal.thongke.model.PhongBan");
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
		return PhongBan.class;
	}

	protected String getModelClassName() {
		return PhongBan.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = phongBanPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.viettel.portal.thongke.service.BaiVietNhuanButLocalService.class)
	protected com.viettel.portal.thongke.service.BaiVietNhuanButLocalService baiVietNhuanButLocalService;
	@BeanReference(type = BaiVietNhuanButPersistence.class)
	protected BaiVietNhuanButPersistence baiVietNhuanButPersistence;
	@BeanReference(type = BaiVietNhuanButFinder.class)
	protected BaiVietNhuanButFinder baiVietNhuanButFinder;
	@BeanReference(type = com.viettel.portal.thongke.service.ContentProfitLocalService.class)
	protected com.viettel.portal.thongke.service.ContentProfitLocalService contentProfitLocalService;
	@BeanReference(type = com.viettel.portal.thongke.service.ContentProfitService.class)
	protected com.viettel.portal.thongke.service.ContentProfitService contentProfitService;
	@BeanReference(type = ContentProfitPersistence.class)
	protected ContentProfitPersistence contentProfitPersistence;
	@BeanReference(type = ContentProfitFinder.class)
	protected ContentProfitFinder contentProfitFinder;
	@BeanReference(type = com.viettel.portal.thongke.service.ContentTypeLocalService.class)
	protected com.viettel.portal.thongke.service.ContentTypeLocalService contentTypeLocalService;
	@BeanReference(type = com.viettel.portal.thongke.service.ContentTypeService.class)
	protected com.viettel.portal.thongke.service.ContentTypeService contentTypeService;
	@BeanReference(type = ContentTypePersistence.class)
	protected ContentTypePersistence contentTypePersistence;
	@BeanReference(type = com.viettel.portal.thongke.service.ContentTypeCostLocalService.class)
	protected com.viettel.portal.thongke.service.ContentTypeCostLocalService contentTypeCostLocalService;
	@BeanReference(type = com.viettel.portal.thongke.service.ContentTypeCostService.class)
	protected com.viettel.portal.thongke.service.ContentTypeCostService contentTypeCostService;
	@BeanReference(type = ContentTypeCostPersistence.class)
	protected ContentTypeCostPersistence contentTypeCostPersistence;
	@BeanReference(type = com.viettel.portal.thongke.service.PhongBanLocalService.class)
	protected com.viettel.portal.thongke.service.PhongBanLocalService phongBanLocalService;
	@BeanReference(type = PhongBanPersistence.class)
	protected PhongBanPersistence phongBanPersistence;
	@BeanReference(type = PhongBanFinder.class)
	protected PhongBanFinder phongBanFinder;
	@BeanReference(type = com.viettel.portal.thongke.service.PhongBanNhuanButLocalService.class)
	protected com.viettel.portal.thongke.service.PhongBanNhuanButLocalService phongBanNhuanButLocalService;
	@BeanReference(type = PhongBanNhuanButPersistence.class)
	protected PhongBanNhuanButPersistence phongBanNhuanButPersistence;
	@BeanReference(type = PhongBanNhuanButFinder.class)
	protected PhongBanNhuanButFinder phongBanNhuanButFinder;
	@BeanReference(type = com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalService.class)
	protected com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalService phongBanNhuanButChiTietLocalService;
	@BeanReference(type = PhongBanNhuanButChiTietPersistence.class)
	protected PhongBanNhuanButChiTietPersistence phongBanNhuanButChiTietPersistence;
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
	private PhongBanLocalServiceClpInvoker _clpInvoker = new PhongBanLocalServiceClpInvoker();
}