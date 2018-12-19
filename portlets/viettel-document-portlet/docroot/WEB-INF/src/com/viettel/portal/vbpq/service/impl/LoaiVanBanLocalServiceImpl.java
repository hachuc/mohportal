/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.viettel.portal.vbpq.service.impl;

import java.util.Date;
import java.util.List;

import com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan;
import com.viettel.portal.vbpq.model.LinhVucVanBan;
import com.viettel.portal.vbpq.model.LoaiVanBan;
import com.viettel.portal.vbpq.service.base.LoaiVanBanLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;

/**
 * The implementation of the loai van ban local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.vbpq.service.LoaiVanBanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.vbpq.service.base.LoaiVanBanLocalServiceBaseImpl
 * @see com.viettel.portal.vbpq.service.LoaiVanBanLocalServiceUtil
 */
public class LoaiVanBanLocalServiceImpl extends LoaiVanBanLocalServiceBaseImpl {

	public List<LoaiVanBan> findByNhomVanBanId(long nhomVanBanId) throws SystemException {
		return loaiVanBanPersistence.findByNhomVanBanId(nhomVanBanId);
	}
	
	public LoaiVanBan getByGroupId_Ten(long groupId, String ten) throws SystemException {
		return loaiVanBanPersistence.fetchByGroupId_Ten(groupId, ten);
	}
	/**
	 * @param keyword
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countLoaiVb(String keyword, long groupId)
			throws PortalException, SystemException {
		return loaiVanBanFinder.count(keyword, groupId);
	}

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
	public List<LoaiVanBan> findLoaiVb(String keyword, long groupId,
			OrderByComparator obc, int start, int end) throws PortalException,
			SystemException {
		return loaiVanBanFinder.find(keyword, groupId, obc, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.viettel.portal.vbpq.service.CoQuanBanHanhVanBanLocalService#
	 * getCoQuanBanHanh(long)
	 */
	public LoaiVanBan getLoaiVb(long linhvucId) throws PortalException,
			SystemException {
		return loaiVanBanPersistence.fetchByPrimaryKey(linhvucId);
	}

	/**
	 * @param groupId
	 * @param trangThai
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countByTrangThai(long groupId, boolean trangThai)
			throws PortalException, SystemException {
		return loaiVanBanPersistence.countByTrangThai(trangThai, groupId);
	}

	/**
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countAll(long groupId) throws PortalException, SystemException {
		return loaiVanBanPersistence.countByG_(groupId);
	}

	/**
	 * @param groupId
	 * @param trangThai
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<LoaiVanBan> getByTrangThai(long groupId, boolean trangThai,
			int start, int end) throws PortalException, SystemException {
		return loaiVanBanPersistence.findByTrangThai(trangThai, groupId, start,
				end);
	}

	/**
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<LoaiVanBan> getAll(long groupId, int start, int end)
			throws PortalException, SystemException {
		return loaiVanBanPersistence.findByG_(groupId, start, end);
	}

	/**
	 * Delete LoaiVanban by Id
	 * 
	 * @param id
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteLoaiVb(long id) throws PortalException, SystemException {
		LoaiVanBan loaivb = loaiVanBanPersistence.findByPrimaryKey(id);

		deleteLoaiVb(loaivb);
	}

	/**
	 * Delete LoaiVanban by entry
	 * 
	 * @param coquan
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteLoaiVb(LoaiVanBan loaivb) throws PortalException,
			SystemException {
		loaiVanBanPersistence.remove(loaivb);
	}

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
	public LoaiVanBan updateLoaiVanBan(long userId, long id, String ten,
			boolean trangThai, int order_, long groupId, long nhomVanBanId)
			throws PortalException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		LoaiVanBan loaivanban = null;

		if (id > 0) {
			loaivanban = loaiVanBanPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(CoQuanBanHanhVanBan.class
					.getName());

			loaivanban = loaiVanBanPersistence.create(id);

			loaivanban.setNgayTao(now);
			loaivanban.setNguoiTao(user.getFullName());
		}

		loaivanban.setNgaySua(now);
		loaivanban.setNguoiSua(user.getFullName());
		loaivanban.setTen(ten);
		loaivanban.setTrangThai(trangThai);
		loaivanban.setOrder_(order_);
		loaivanban.setGroupId(groupId);
		loaivanban.setNhomVanBanId(nhomVanBanId);

		loaiVanBanPersistence.update(loaivanban);

		loaiVanBanPersistence.clearCache();

		return loaivanban;
	}
}