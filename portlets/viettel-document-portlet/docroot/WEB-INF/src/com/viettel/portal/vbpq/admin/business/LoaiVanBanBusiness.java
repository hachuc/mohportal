package com.viettel.portal.vbpq.admin.business;

import java.util.ArrayList;
import java.util.List;

import com.viettel.portal.vbpq.model.LoaiVanBan;
import com.viettel.portal.vbpq.service.LoaiVanBanLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class LoaiVanBanBusiness {
	/**
	 * @param keyword
	 * @param groupId
	 * @return
	 */
	public static int countLoaiVanBan(String keyword, long groupId) {
		int count = 0;

		try {
			count = LoaiVanBanLocalServiceUtil.countLoaiVb(keyword, groupId);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}

	/**
	 * Get LoaiVanBan by custom query
	 * 
	 * @param keyword
	 * @param groupId
	 * @param obc
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<LoaiVanBan> findLoaiVanBan(String keyword, long groupId,
			OrderByComparator obc, int start, int end) {
		List<LoaiVanBan> ls = new ArrayList<LoaiVanBan>();

		try {
			ls = LoaiVanBanLocalServiceUtil.findLoaiVb(keyword, groupId, obc,
					start, end);
		} catch (Exception e) {
			LOG.error(e);
		}

		return ls;
	}

	/**
	 * Get LoaiVanBan by id
	 * 
	 * @param linhvucId
	 * @return
	 */
	public static LoaiVanBan getLoaiVanBan(long loaiVBId) {
		LoaiVanBan loaivb = null;

		try {
			loaivb = LoaiVanBanLocalServiceUtil.fetchLoaiVanBan(loaiVBId);
		} catch (SystemException e) {
			LOG.error(e);
		}

		return loaivb;
	}

	/**
	 * Get all LinhVucVanBan
	 * 
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<LoaiVanBan> getAll(long groupId, int start, int end) {
		List<LoaiVanBan> ls = new ArrayList<LoaiVanBan>();

		try {
			ls = LoaiVanBanLocalServiceUtil.getAll(groupId, start, end);
		} catch (Exception e) {
			LOG.error(e);
		}

		return ls;
	}

	/**
	 * Get LinhVucVanBan by TrangThai
	 * 
	 * @param groupId
	 * @param trangThai
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<LoaiVanBan> getByTrangThai(long groupId,
			boolean trangThai, int start, int end) {
		List<LoaiVanBan> ls = new ArrayList<LoaiVanBan>();

		try {
			ls = LoaiVanBanLocalServiceUtil.getByTrangThai(groupId, trangThai,
					start, end);
		} catch (Exception e) {
			LOG.error(e);
		}

		return ls;
	}

	/**
	 * Count CoQuanBanHanh
	 * 
	 * @param groupId
	 * @return
	 */
	public static int countAll(long groupId) {
		int count = 0;

		try {
			LoaiVanBanLocalServiceUtil.countAll(groupId);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}

	/**
	 * Count LoaiVanBan by TrangThai
	 * 
	 * @param groupId
	 * @param trangThai
	 * @return
	 */
	public static int countByTrangThai(long groupId, boolean trangThai) {
		int count = 0;

		try {
			LoaiVanBanLocalServiceUtil.countByTrangThai(groupId, trangThai);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}
	
	public static List<LoaiVanBan> getByListSelected(long[] loaiVanBanIds) {
		List<LoaiVanBan> list = new ArrayList<LoaiVanBan>();
		
		for(long loaiVanBanId : loaiVanBanIds) {
			LoaiVanBan loaiVanBan = LoaiVanBanBusiness.getLoaiVanBan(loaiVanBanId);
			
			if(loaiVanBan != null) {
				list.add(loaiVanBan);
			}
		}
		
		return list;
	}

	private static final Log LOG = LogFactoryUtil
			.getLog(LoaiVanBanBusiness.class);
}
