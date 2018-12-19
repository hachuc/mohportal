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

package com.viettel.portal.thongke.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BaiVietNhuanButLocalService}.
 *
 * @author lamvn
 * @see BaiVietNhuanButLocalService
 * @generated
 */
public class BaiVietNhuanButLocalServiceWrapper
	implements BaiVietNhuanButLocalService,
		ServiceWrapper<BaiVietNhuanButLocalService> {
	public BaiVietNhuanButLocalServiceWrapper(
		BaiVietNhuanButLocalService baiVietNhuanButLocalService) {
		_baiVietNhuanButLocalService = baiVietNhuanButLocalService;
	}

	/**
	* Adds the bai viet nhuan but to the database. Also notifies the appropriate model listeners.
	*
	* @param baiVietNhuanBut the bai viet nhuan but
	* @return the bai viet nhuan but that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut addBaiVietNhuanBut(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.addBaiVietNhuanBut(baiVietNhuanBut);
	}

	/**
	* Creates a new bai viet nhuan but with the primary key. Does not add the bai viet nhuan but to the database.
	*
	* @param id the primary key for the new bai viet nhuan but
	* @return the new bai viet nhuan but
	*/
	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut createBaiVietNhuanBut(
		long id) {
		return _baiVietNhuanButLocalService.createBaiVietNhuanBut(id);
	}

	/**
	* Deletes the bai viet nhuan but with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but that was removed
	* @throws PortalException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut deleteBaiVietNhuanBut(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.deleteBaiVietNhuanBut(id);
	}

	/**
	* Deletes the bai viet nhuan but from the database. Also notifies the appropriate model listeners.
	*
	* @param baiVietNhuanBut the bai viet nhuan but
	* @return the bai viet nhuan but that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut deleteBaiVietNhuanBut(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.deleteBaiVietNhuanBut(baiVietNhuanBut);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _baiVietNhuanButLocalService.dynamicQuery();
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
		return _baiVietNhuanButLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _baiVietNhuanButLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _baiVietNhuanButLocalService.dynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.dynamicQueryCount(dynamicQuery);
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
		return _baiVietNhuanButLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut fetchBaiVietNhuanBut(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.fetchBaiVietNhuanBut(id);
	}

	/**
	* Returns the bai viet nhuan but with the primary key.
	*
	* @param id the primary key of the bai viet nhuan but
	* @return the bai viet nhuan but
	* @throws PortalException if a bai viet nhuan but with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut getBaiVietNhuanBut(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.getBaiVietNhuanBut(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bai viet nhuan buts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.thongke.model.impl.BaiVietNhuanButModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bai viet nhuan buts
	* @param end the upper bound of the range of bai viet nhuan buts (not inclusive)
	* @return the range of bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> getBaiVietNhuanButs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.getBaiVietNhuanButs(start, end);
	}

	/**
	* Returns the number of bai viet nhuan buts.
	*
	* @return the number of bai viet nhuan buts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBaiVietNhuanButsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.getBaiVietNhuanButsCount();
	}

	/**
	* Updates the bai viet nhuan but in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param baiVietNhuanBut the bai viet nhuan but
	* @return the bai viet nhuan but that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut updateBaiVietNhuanBut(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.updateBaiVietNhuanBut(baiVietNhuanBut);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _baiVietNhuanButLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_baiVietNhuanButLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _baiVietNhuanButLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> getByBaiVietId(
		long baiVietId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.getByBaiVietId(baiVietId);
	}

	@Override
	public java.util.List<com.viettel.portal.thongke.model.BaiVietNhuanBut> findBaiVietNhuanButs(
		int type, java.lang.Long groupId, java.lang.String keyword,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.findBaiVietNhuanButs(type, groupId,
			keyword, fromDate, toDate, start, end);
	}

	@Override
	public int countBaiVietNhuanButs(int type, java.lang.Long groupId,
		java.lang.String keyword, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.countBaiVietNhuanButs(type,
			groupId, keyword, fromDate, toDate);
	}

	@Override
	public java.util.List<java.lang.Object> findBaiVietRatings(
		long classTypeId, int type, long groupId, java.lang.String keyword,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.findBaiVietRatings(classTypeId,
			type, groupId, keyword, fromDate, toDate, start, end);
	}

	@Override
	public int countBaiVietRatings(long classTypeId, int type, long groupId,
		java.lang.String keyword, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.countBaiVietRatings(classTypeId,
			type, groupId, keyword, fromDate, toDate);
	}

	@Override
	public java.util.List<java.lang.Object> findBaiVietNhuanButBySQL(
		java.lang.String sql, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.findBaiVietNhuanButBySQL(sql,
			start, end);
	}

	@Override
	public int countBaiVietNhuanButBySQL(java.lang.String sql)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.countBaiVietNhuanButBySQL(sql);
	}

	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut updateBaiVietNhuanBut(
		int loaiBaiViet, int type, long id, long companyId, long groupId,
		long userId, java.lang.String userName, long baiVietId,
		java.lang.String tieuDe, java.lang.String tacGia,
		java.lang.String diaChi, java.util.Date ngayXuatBan,
		java.lang.String rating, double ratingValue,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.updateBaiVietNhuanBut(loaiBaiViet,
			type, id, companyId, groupId, userId, userName, baiVietId, tieuDe,
			tacGia, diaChi, ngayXuatBan, rating, ratingValue, serviceContext);
	}

	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut addBaiVietNhuanBut(
		int loaiBaiViet, int type, long companyId, long groupId, long userId,
		java.lang.String userName, long baiVietId, java.lang.String tieuDe,
		java.lang.String tacGia, java.lang.String diaChi,
		java.util.Date ngayXuatBan, java.lang.String rating,
		double ratingValue,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanButLocalService.addBaiVietNhuanBut(loaiBaiViet,
			type, companyId, groupId, userId, userName, baiVietId, tieuDe,
			tacGia, diaChi, ngayXuatBan, rating, ratingValue, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BaiVietNhuanButLocalService getWrappedBaiVietNhuanButLocalService() {
		return _baiVietNhuanButLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBaiVietNhuanButLocalService(
		BaiVietNhuanButLocalService baiVietNhuanButLocalService) {
		_baiVietNhuanButLocalService = baiVietNhuanButLocalService;
	}

	@Override
	public BaiVietNhuanButLocalService getWrappedService() {
		return _baiVietNhuanButLocalService;
	}

	@Override
	public void setWrappedService(
		BaiVietNhuanButLocalService baiVietNhuanButLocalService) {
		_baiVietNhuanButLocalService = baiVietNhuanButLocalService;
	}

	private BaiVietNhuanButLocalService _baiVietNhuanButLocalService;
}