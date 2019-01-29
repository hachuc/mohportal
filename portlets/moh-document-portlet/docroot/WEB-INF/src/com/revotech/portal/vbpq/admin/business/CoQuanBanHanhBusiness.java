package com.revotech.portal.vbpq.admin.business;

import java.util.ArrayList;
import java.util.List;

import com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan;
import com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class CoQuanBanHanhBusiness {

	/**
	 * @param keyword
	 * @param groupId
	 * @return
	 */
	public static int countCoQuan(String keyword, long groupId) {
		int count = 0;

		try {
			count = CoQuanBanHanhVanBanLocalServiceUtil.countCoQuan(keyword,
					groupId);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}

	/**
	 * Get coquanbanhanh by custom query
	 * 
	 * @param keyword
	 * @param groupId
	 * @param obc
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<CoQuanBanHanhVanBan> findCoQuan(String keyword,
			long groupId, OrderByComparator obc, int start, int end) {
		List<CoQuanBanHanhVanBan> ls = new ArrayList<CoQuanBanHanhVanBan>();

		try {
			ls = CoQuanBanHanhVanBanLocalServiceUtil.findCoQuan(keyword,
					groupId, obc, start, end);
		} catch (Exception e) {
			LOG.error(e);
		}

		return ls;
	}

	/**
	 * Get CoQuanBanHanhVanBan by id
	 * 
	 * @param coQuanBanHanhId
	 * @return
	 */
	public static CoQuanBanHanhVanBan getCoQuanBanHanh(long coQuanBanHanhId) {
		CoQuanBanHanhVanBan coquan = null;

		try {
			coquan = CoQuanBanHanhVanBanLocalServiceUtil
					.fetchCoQuanBanHanhVanBan(coQuanBanHanhId);
		} catch (SystemException e) {
			LOG.error(e);
		}

		return coquan;
	}

	/**
	 * Get all CoQuanBanHanhVanBan
	 * 
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<CoQuanBanHanhVanBan> getAll(long groupId, int start,
			int end) {
		List<CoQuanBanHanhVanBan> ls = new ArrayList<CoQuanBanHanhVanBan>();

		try {
			ls = CoQuanBanHanhVanBanLocalServiceUtil
					.getAll(groupId, start, end);
		} catch (Exception e) {
			LOG.error(e);
		}

		return ls;
	}

	/**
	 * Get CoQuanBanHanh by TrangThai
	 * 
	 * @param groupId
	 * @param trangThai
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<CoQuanBanHanhVanBan> getByTrangThai(long groupId,
			boolean trangThai, int start, int end) {
		List<CoQuanBanHanhVanBan> ls = new ArrayList<CoQuanBanHanhVanBan>();

		try {
			ls = CoQuanBanHanhVanBanLocalServiceUtil.getByTrangThai(groupId, trangThai, start, end);
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
			CoQuanBanHanhVanBanLocalServiceUtil.countAll(groupId);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}

	/**
	 * Count CoQuanBanHanh by TrangThai
	 * 
	 * @param groupId
	 * @param trangThai
	 * @return
	 */
	public static int countByTrangThai(long groupId, boolean trangThai) {
		int count = 0;

		try {
			CoQuanBanHanhVanBanLocalServiceUtil.countByTrangThai(groupId,
					trangThai);
		} catch (Exception e) {
			LOG.error(e);
		}

		return count;
	}
	
	public static List<CoQuanBanHanhVanBan> getByListSelected(long[] coQuanBanHanhIds) {
		List<CoQuanBanHanhVanBan> list = new ArrayList<CoQuanBanHanhVanBan>();
		
		for(long coQuanBanHanhId : coQuanBanHanhIds) {
			CoQuanBanHanhVanBan coQuanBanHanh = CoQuanBanHanhBusiness.getCoQuanBanHanh(coQuanBanHanhId);
			
			if(coQuanBanHanh != null) {
				list.add(coQuanBanHanh);
			}
		}
		
		return list;
	}

	private static final Log LOG = LogFactoryUtil
			.getLog(CoQuanBanHanhBusiness.class);
}
