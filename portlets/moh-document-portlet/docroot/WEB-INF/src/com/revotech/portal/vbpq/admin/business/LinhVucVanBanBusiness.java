package com.revotech.portal.vbpq.admin.business;

import java.util.ArrayList;
import java.util.List;

import com.revotech.portal.vbpq.model.LinhVucVanBan;
import com.revotech.portal.vbpq.service.LinhVucVanBanLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class LinhVucVanBanBusiness {
	/**
	 * @param keyword
	 * @param groupId
	 * @return
	 */
	public static int countLinhVuc(String keyword, long groupId) {
		int count = 0;

		try {
			count = LinhVucVanBanLocalServiceUtil.countLinhVuc(keyword, groupId);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}

	/**
	 * Get LinhVucVanBan by custom query
	 * 
	 * @param keyword
	 * @param groupId
	 * @param obc
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<LinhVucVanBan> findLinhVuc(String keyword, long groupId,
			OrderByComparator obc, int start, int end) {
		List<LinhVucVanBan> ls = new ArrayList<LinhVucVanBan>();

		try {
			ls = LinhVucVanBanLocalServiceUtil.findLinhVuc(keyword, groupId, obc, start, end);
		} catch (Exception e) {
			LOG.error(e);
		}

		return ls;
	}

	/**
	 * Get LinhVucVanBan by id
	 * 
	 * @param coQuanBanHanhId
	 * @return
	 */
	public static LinhVucVanBan getLinhVucVanBan(long linhvucId) {
		LinhVucVanBan linhvuc = null;

		try {
			linhvuc = LinhVucVanBanLocalServiceUtil.fetchLinhVucVanBan(linhvucId);
		} catch (SystemException e) {
			LOG.error(e);
		}

		return linhvuc;
	}

	/**
	 * Get all LinhVucVanBan
	 * 
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<LinhVucVanBan> getAll(long groupId, int start, int end) {
		List<LinhVucVanBan> ls = new ArrayList<LinhVucVanBan>();

		try {
			ls = LinhVucVanBanLocalServiceUtil.getAll(groupId, start, end);
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
	public static List<LinhVucVanBan> getByTrangThai(long groupId,
			boolean trangThai, int start, int end) {
		List<LinhVucVanBan> ls = new ArrayList<LinhVucVanBan>();

		try {
			ls = LinhVucVanBanLocalServiceUtil.getByTrangThai(groupId, trangThai,
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
			LinhVucVanBanLocalServiceUtil.countAll(groupId);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}

	/**
	 * Count LinhVucVanBan by TrangThai
	 * 
	 * @param groupId
	 * @param trangThai
	 * @return
	 */
	public static int countByTrangThai(long groupId, boolean trangThai) {
		int count = 0;

		try {
			LinhVucVanBanLocalServiceUtil.countByTrangThai(groupId, trangThai);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}
	
	public static List<LinhVucVanBan> getByListSelected(long[] linhVucVanBanIds) {
		List<LinhVucVanBan> list = new ArrayList<LinhVucVanBan>();
		
		for(long linhVucVanBanId : linhVucVanBanIds) {
			LinhVucVanBan linhVucVanBan = LinhVucVanBanBusiness.getLinhVucVanBan(linhVucVanBanId);
			
			if(linhVucVanBan != null) {
				list.add(linhVucVanBan);
			}
		}
		
		return list;
	}

	private static final Log LOG = LogFactoryUtil
			.getLog(LinhVucVanBanBusiness.class);
}
