package com.viettel.portal.vbpq.admin.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.viettel.portal.vbpq.model.AttachFile;
import com.viettel.portal.vbpq.model.VanBanPhapQuy;
import com.viettel.portal.vbpq.service.AttachFileLocalServiceUtil;
import com.viettel.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class VanBanPhapQuyBusiness {

	/**
	 * Count VanBanPhapQuy
	 * 
	 * @param groupId
	 * @param keyword
	 * @param coquanbanhanh
	 * @param loaivanban
	 * @param linhvuc
	 * @return
	 */
	public static int count(String keyword, long groupId, long[] loaiVanBanIds, 
			long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds, Integer status, 
			Date startDateObj, Date endDateObj) {
		int count = 0;
		try {
			count = VanBanPhapQuyLocalServiceUtil.count(keyword, groupId,
					loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds, status, startDateObj, endDateObj);
		} catch (Exception e) {
			_log.error(e);
		}

		return count;
	}

	/**
	 * Find VanBanPhapQuy
	 * 
	 * @param groupId
	 * @param keyword
	 * @param coquanbanhanh
	 * @param loaivanban
	 * @param linhvuc
	 * @param obc
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<VanBanPhapQuy> find(String keyword, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
			Integer status, Date startDateObj, Date endDateObj, int start,
			int end, OrderByComparator obc, String[] orderBys) {
		List<VanBanPhapQuy> ls = new ArrayList<VanBanPhapQuy>();
		try {	
			ls = VanBanPhapQuyLocalServiceUtil.find(keyword, groupId,
					loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, nhomVanBanIds, status,
				startDateObj, endDateObj, start, end, obc, orderBys);
		
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;
	}

	/**
	 * @param groupId
	 * @return
	 */
	public static int countByGroupId(long groupId) {
		int count = 0;

		try {
			count = VanBanPhapQuyLocalServiceUtil.countAll(groupId);
		} catch (Exception e) {
			_log.error(e);
		}

		return count;
	}

	/**
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<VanBanPhapQuy> findByGroupId(long groupId, int start,
			int end) {
		List<VanBanPhapQuy> ls = new ArrayList<VanBanPhapQuy>();

		try {
			ls = VanBanPhapQuyLocalServiceUtil.getAll(groupId, start, end);
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;
	}

	/**
	 * @param vanbanId
	 * @return
	 */
	public static VanBanPhapQuy getVanBan(long vanbanId) {
		VanBanPhapQuy vanban = null;
		
		try {
			vanban = VanBanPhapQuyLocalServiceUtil.getVanBan(vanbanId);
		} catch (Exception e) {
			_log.error(e);
		}

		return vanban;
	}
	
	public static List<AttachFile> getAttachFiles(long vanBanId) {
		List<AttachFile> vanBanFiles = new ArrayList<AttachFile>();
		
		try {
			vanBanFiles = AttachFileLocalServiceUtil.getAttachByVanBan(vanBanId);
		} catch (Exception e) {
			_log.error(e);
		}

		return vanBanFiles;
	}

	private static final Log _log = LogFactoryUtil.getLog(VanBanPhapQuy.class);
}
