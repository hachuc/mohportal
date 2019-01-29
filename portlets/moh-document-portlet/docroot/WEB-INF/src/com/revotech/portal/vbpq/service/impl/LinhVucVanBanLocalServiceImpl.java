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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.revotech.portal.vbpq.service.base.LinhVucVanBanLocalServiceBaseImpl;
import com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan;
import com.revotech.portal.vbpq.model.LinhVucVanBan;

/**
 * The implementation of the linh vuc van ban local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.revotech.portal.vbpq.service.LinhVucVanBanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.revotech.portal.vbpq.service.base.LinhVucVanBanLocalServiceBaseImpl
 * @see com.revotech.portal.vbpq.service.LinhVucVanBanLocalServiceUtil
 */
public class LinhVucVanBanLocalServiceImpl
	extends LinhVucVanBanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.revotech.portal.vbpq.service.LinhVucVanBanLocalServiceUtil} to access the linh vuc van ban local service.
	 */


	public List<LinhVucVanBan> findByNhomVanBanId(long nhomVanBanId) throws SystemException {
		return linhVucVanBanPersistence.findByNhomVanBanId(nhomVanBanId);
	}
	
	public LinhVucVanBan getByGroupId_Ten(long groupId, String ten) throws SystemException {
		return linhVucVanBanPersistence.fetchByGroupId_Ten(groupId, ten);
	}
	
	/**
	 * @param keyword
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countLinhVuc(String keyword, long groupId)
			throws PortalException, SystemException {
		return linhVucVanBanFinder.count(keyword, groupId);
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
	public List<LinhVucVanBan> findLinhVuc(String keyword, long groupId,
			OrderByComparator obc, int start, int end) throws PortalException,
			SystemException {
		return linhVucVanBanFinder.find(keyword, groupId, obc, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalService#
	 * getCoQuanBanHanh(long)
	 */
	public LinhVucVanBan getLinhVuc(long linhvucId) throws PortalException,
			SystemException {
		return linhVucVanBanPersistence.fetchByPrimaryKey(linhvucId);
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
		return linhVucVanBanPersistence.countByTrangThai(trangThai, groupId);
	}

	/**
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countAll(long groupId) throws PortalException, SystemException {
		return linhVucVanBanPersistence.countByG_(groupId);
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
	public List<LinhVucVanBan> getByTrangThai(long groupId, boolean trangThai,
			int start, int end) throws PortalException, SystemException {
		return linhVucVanBanPersistence.findByTrangThai(trangThai, groupId,
				start, end);
	}

	/**
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<LinhVucVanBan> getAll(long groupId, int start, int end)
			throws PortalException, SystemException {
		return linhVucVanBanPersistence.findByG_(groupId, start, end);
	}

	/**
	 * Delete coquan by Id
	 * 
	 * @param id
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteLinhVuc(long id) throws PortalException, SystemException {
		LinhVucVanBan linhvuc = linhVucVanBanPersistence.findByPrimaryKey(id);

		deleteLinhVuc(linhvuc);
	}

	/**
	 * Delete coquan by entry
	 * 
	 * @param coquan
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteLinhVuc(LinhVucVanBan linhvuc) throws PortalException,
			SystemException {
		linhVucVanBanPersistence.remove(linhvuc);
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
	public LinhVucVanBan updateLinhVucVanBan(long userId, long id, String ten,
			boolean trangThai, int order_, long groupId, long nhomVanBanId)
			throws PortalException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		LinhVucVanBan linhvuc = null;

		if (id > 0) {
			linhvuc = linhVucVanBanPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(CoQuanBanHanhVanBan.class
					.getName());

			linhvuc = linhVucVanBanPersistence.create(id);

			linhvuc.setNgayTao(now);
			linhvuc.setNguoiTao(user.getFullName());
		}

		linhvuc.setNgaySua(now);
		linhvuc.setNguoiSua(user.getFullName());
		linhvuc.setTen(ten);
		linhvuc.setTrangThai(trangThai);
		linhvuc.setOrder_(order_);
		linhvuc.setGroupId(groupId);
		linhvuc.setNhomVanBanId(nhomVanBanId);

		linhVucVanBanPersistence.update(linhvuc);

		linhVucVanBanPersistence.clearCache();

		return linhvuc;
	}
}