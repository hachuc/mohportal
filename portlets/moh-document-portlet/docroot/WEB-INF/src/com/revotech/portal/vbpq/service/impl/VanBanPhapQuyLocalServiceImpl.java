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

package com.revotech.portal.vbpq.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.revotech.portal.vbpq.service.base.VanBanPhapQuyLocalServiceBaseImpl;
import com.revotech.portal.vbpq.VanBanPhapQuyGrid;
import com.revotech.portal.vbpq.model.VanBanPhapQuy;
import com.revotech.portal.vbpq.service.impl.VanBanPhapQuyLocalServiceImpl;
import com.revotech.portal.vbpq.util.VanBanPhapQuyConstants;

/**
 * The implementation of the van ban phap quy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.revotech.portal.vbpq.service.VanBanPhapQuyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.revotech.portal.vbpq.service.base.VanBanPhapQuyLocalServiceBaseImpl
 * @see com.revotech.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil
 */
public class VanBanPhapQuyLocalServiceImpl
	extends VanBanPhapQuyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.revotech.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil} to access the van ban phap quy local service.
	 */
	public VanBanPhapQuy getByGroupId_MaVanBan(long groupId, String maVanBan)
			throws SystemException {
		return vanBanPhapQuyPersistence.fetchByGroupId_MaVanBan(groupId,
				maVanBan);
	}
	
	public int countAll(long groupId) throws PortalException, SystemException {
		return vanBanPhapQuyPersistence.countByGroupId(groupId,
				VanBanPhapQuyConstants.STATUS_PUBLISH);
	}

	public List<VanBanPhapQuy> getAll(long groupId, int start, int end)
			throws PortalException, SystemException {
		return vanBanPhapQuyPersistence.findByGroupId(groupId,
				VanBanPhapQuyConstants.STATUS_PUBLISH, start, end);
	}

	public VanBanPhapQuy getVanBan(long vanbanId) throws PortalException,
			SystemException {
		return vanBanPhapQuyPersistence.fetchByPrimaryKey(vanbanId);
	}

	public void deleteVanBan(long vanBanId) throws PortalException,
			SystemException {

		VanBanPhapQuy vanBan = vanBanPhapQuyPersistence
				.findByPrimaryKey(vanBanId);

		deleteVanBan(vanBan);
	}

	public List<VanBanPhapQuy> findByG_CQBH_S(long groupId, long coQuanBanHanh,
			int status) throws PortalException, SystemException {
		return vanBanPhapQuyPersistence.findByG_CQBH_S(groupId, coQuanBanHanh,
				status);
	}

	public List<VanBanPhapQuy> findByG_CQBH_S(long groupId, long coQuanBanHanh,
			int status, int start, int end) throws PortalException,
			SystemException {
		return vanBanPhapQuyPersistence.findByG_CQBH_S(groupId, coQuanBanHanh,
				status, start, end);
	}

	public void deleteVanBan(VanBanPhapQuy vanBan) throws PortalException,
			SystemException {
		vanBanPhapQuyPersistence.remove(vanBan);
	}

	public VanBanPhapQuy updateVanBanPhapQuy(long userId, long groupId,
			long id, String maVanBan, boolean neverExpire, long coQuanBanHanh,
			long linhVucVanBan, long loaiVanBan, Date ngayBanHanh,
			Date ngayCoHieuLuc, Date ngayHetHieuLuc, String nguoiKy,
			String trichYeu, long vanBanThayThe, int status, long nhomVanBanId)
			throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();
		VanBanPhapQuy vanban = null;

		if (id > 0) {
			vanban = vanBanPhapQuyPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(VanBanPhapQuy.class.getName());
			vanban = vanBanPhapQuyPersistence.create(id);
			vanban.setNgayTao(now);
			vanban.setNguoiTao(user.getFullName());
		}

		vanban.setNgaySua(now);
		vanban.setNguoiSua(user.getFullName());
		vanban.setGroupId(groupId);
		vanban.setMaVanBan(maVanBan);
		vanban.setStatus(status);
		vanban.setStatusByDate(now);
		vanban.setStatusByUserId(userId);
		vanban.setStatusByUserName(user.getFullName());
		vanban.setCoQuanBanHanh(coQuanBanHanh);
		vanban.setLinhVucVanBan(linhVucVanBan);
		vanban.setLoaiVanBan(loaiVanBan);
		vanban.setNgayBanHanh(ngayBanHanh);
		vanban.setNgayCoHieuLuc(ngayCoHieuLuc);
		vanban.setNgayHetHieuLuc(ngayHetHieuLuc);
		vanban.setNguoiKy(nguoiKy);
		vanban.setTrichYeu(trichYeu);
		vanban.setVanBanThayThe(vanBanThayThe);
		vanban.setNhomVanBanId(nhomVanBanId);

		vanBanPhapQuyPersistence.update(vanban);

		return vanban;
	}

	/**
	 * @param id
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public VanBanPhapQuy updateStatusVanBan(long vanBanId, int status,
			long userId) throws PortalException, SystemException {

		VanBanPhapQuy vanBan = vanBanPhapQuyPersistence
				.findByPrimaryKey(vanBanId);
		Date dateNow = new Date();
		User user = userPersistence.findByPrimaryKey(userId);
		vanBan.setStatus(status);
		vanBan.setStatusByDate(dateNow);
		vanBan.setStatusByUserId(userId);
		vanBan.setStatusByUserName(user.getFullName());

		vanBanPhapQuyPersistence.update(vanBan);

		return vanBan;
	}
	
	public int count(String keyword, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
			Integer status, Date startDateObj, Date endDateObj) 
		throws Exception {
		try {
			return vanBanPhapQuyFinder.timKiemVanBanPhapQuyCount(keyword, groupId,
				loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds,
				nhomVanBanIds, status, startDateObj, endDateObj);
		} catch(Exception e) {
			_log.error(e);
		}
		return 0;
	}
	
	public List<VanBanPhapQuy> find(String keyword, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
			Integer status, Date startDateObj, Date endDateObj, int start,
			int end, OrderByComparator obc, String[] orderBys) 
		throws Exception {
		List<VanBanPhapQuy> result = new ArrayList<VanBanPhapQuy>();
		try {
			result = vanBanPhapQuyFinder.timKiemVanBanPhapQuyFind( keyword,  groupId,
					 loaiVanBanIds,  linhVucVanBanIds,  coQuanBanHanhIds,  nhomVanBanIds,
					 status,  startDateObj,  endDateObj,  start,
					 end,  obc,orderBys);
		} catch(Exception e) {
			_log.error(e);
		}
		return result;
	}
	
	public VanBanPhapQuyGrid timKiemVanBanPhapQuy(String keyword, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
			Integer status, Date startDateObj, Date endDateObj, int start,
			int end, OrderByComparator obc, String[] orderBys) 
		throws Exception {
		VanBanPhapQuyGrid grid = new VanBanPhapQuyGrid();
		try {
			grid = vanBanPhapQuyFinder.timKiemVanBanPhapQuy(keyword, groupId,
				loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds,
				nhomVanBanIds, status, startDateObj, endDateObj,
				start, end, obc, orderBys);
		} catch(Exception e) {
			_log.error(e);
		}
		return grid;
	}
	
	public VanBanPhapQuyGrid timKiemVanBanPhapQuyTheoNgayTao(String keyword, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
			Integer status, Date startDateObj, Date endDateObj, int start,
			int end, OrderByComparator obc, String[] orderBys) throws Exception {
		VanBanPhapQuyGrid grid = new VanBanPhapQuyGrid();
		
		try {
			grid = vanBanPhapQuyFinder.timKiemVanBanPhapQuyTheoNgayTao( keyword,  groupId,
					 loaiVanBanIds,  linhVucVanBanIds,  coQuanBanHanhIds,  nhomVanBanIds,
					 status,  startDateObj,  endDateObj,  start,
					 end,  obc,orderBys);
		} catch(Exception e) {
			_log.error(e);
		}
		
		return grid;
	}
	
	private static Log _log = LogFactoryUtil.getLog(VanBanPhapQuyLocalServiceImpl.class);
	
}