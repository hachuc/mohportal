package com.revotech.portal.vbpq.terms;

import java.text.DateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class VanBanPhapQuyTerms extends DisplayTerms {

	public static final String ID = "id";
	public static final String GROUP_ID = "groupId";
	public static final String MA_VAN_BAN = "maVanBan";
	public static final String CO_QUAN_BAN_HANH = "coQuanBanHanh";
	public static final String LOAI_VAN_BAN = "loaiVanBan";
	public static final String LINH_VUC_ID = "linhVucVanBan";
	public static final String VAN_BAN_THAY_THE = "vanBanThayThe";
	public static final String TRICH_YEU = "trichYeu";
	public static final String NGUOI_KY = "nguoiKy";
	public static final String NGAY_BAN_HANH = "ngayBanHanh";
	public static final String NGAY_CO_HIEU_LUC = "ngayCoHieuLuc";
	public static final String NGAY_HET_HIEU_LUC = "ngayHetHieuLuc";
	
	// trang thai xem van ban co la dang van ban khong bao gio het hieu luc
	// khong
	public static final String TRANG_THAI = "neverExpire";

	public VanBanPhapQuyTerms(ActionRequest request) {
		super(request);

		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(request);

		DateFormat dateFormat = DateFormatFactoryUtil
				.getSimpleDateFormat("dd/MM/yyyy");

		id = ParamUtil.getLong(uploadPortletRequest, ID);
		groupId = ParamUtil.getLong(uploadPortletRequest, GROUP_ID);
		maVanBan = ParamUtil.getString(uploadPortletRequest, MA_VAN_BAN);
		coquanbanhanhId = ParamUtil.getLong(uploadPortletRequest,
				CO_QUAN_BAN_HANH);
		linhvucId = ParamUtil.getLong(uploadPortletRequest, LINH_VUC_ID);
		loaivanbanId = ParamUtil.getLong(uploadPortletRequest, LOAI_VAN_BAN);
		vanBanThayThe = ParamUtil.getLong(uploadPortletRequest,
				VAN_BAN_THAY_THE);
		trichYeu = ParamUtil.getString(uploadPortletRequest, TRICH_YEU);
		nguoiKy = ParamUtil.getString(uploadPortletRequest, NGUOI_KY);
		ngayBanHanh = ParamUtil.getDate(uploadPortletRequest, NGAY_BAN_HANH,
				dateFormat);
		ngayCoHieuLuc = ParamUtil.getDate(uploadPortletRequest,
				NGAY_CO_HIEU_LUC, dateFormat);
		ngayHetHieuLuc = ParamUtil.getDate(uploadPortletRequest,
				NGAY_HET_HIEU_LUC, dateFormat);
		trangThai = ParamUtil.getBoolean(uploadPortletRequest, TRANG_THAI);

		cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getMaVanBan() {
		return maVanBan;
	}

	public void setMaVanBan(String maVanBan) {
		this.maVanBan = maVanBan;
	}

	public long getCoquanbanhanhId() {
		return coquanbanhanhId;
	}

	public void setCoquanbanhanhId(long coquanbanhanhId) {
		this.coquanbanhanhId = coquanbanhanhId;
	}

	public long getLoaivanbanId() {
		return loaivanbanId;
	}

	public void setLoaivanbanId(long loaivanbanId) {
		this.loaivanbanId = loaivanbanId;
	}

	public long getLinhvucId() {
		return linhvucId;
	}

	public void setLinhvucId(long linhvucId) {
		this.linhvucId = linhvucId;
	}

	public long getVanBanThayThe() {
		return vanBanThayThe;
	}

	public void setVanBanThayThe(long vanBanThayThe) {
		this.vanBanThayThe = vanBanThayThe;
	}

	public String getTrichYeu() {
		return trichYeu;
	}

	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}

	public String getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public Date getNgayBanHanh() {
		return ngayBanHanh;
	}

	public void setNgayBanHanh(Date ngayBanHanh) {
		this.ngayBanHanh = ngayBanHanh;
	}

	public Date getNgayCoHieuLuc() {
		return ngayCoHieuLuc;
	}

	public void setNgayCoHieuLuc(Date ngayCoHieuLuc) {
		this.ngayCoHieuLuc = ngayCoHieuLuc;
	}

	public Date getNgayHetHieuLuc() {
		return ngayHetHieuLuc;
	}

	public void setNgayHetHieuLuc(Date ngayHetHieuLuc) {
		this.ngayHetHieuLuc = ngayHetHieuLuc;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	protected String cmd;
	protected long id;
	protected long groupId;
	protected String maVanBan;
	protected long coquanbanhanhId;
	protected long loaivanbanId;
	protected long linhvucId;
	protected long vanBanThayThe;
	protected String trichYeu;
	protected String nguoiKy;
	protected Date ngayBanHanh;
	protected Date ngayCoHieuLuc;
	protected Date ngayHetHieuLuc;
	protected boolean trangThai;

}
