package com.viettel.portal.vbpq.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.viettel.portal.tthc.service.LinhVucThuTucLocalServiceUtil;
import com.viettel.portal.vbpq.admin.action.CoQuanBanHanhAction;
import com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan;
import com.viettel.portal.vbpq.model.LinhVucVanBan;
import com.viettel.portal.vbpq.model.LoaiVanBan;
import com.viettel.portal.vbpq.model.NhomVanBan;
import com.viettel.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil;
import com.viettel.portal.vbpq.service.LinhVucVanBanLocalServiceUtil;
import com.viettel.portal.vbpq.service.LoaiVanBanLocalServiceUtil;
import com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

public class NhomVanBanController {
	private static Log _log = LogFactory.getLog(NhomVanBanController.class);

	public static final String NHOM_VAN_BAN_ID = "NHOM_VAN_BAN_ID";
	public static final String NHOM_VAN_BAN_TEN_NHOM = "NHOM_VAN_BAN_TEN_NHOM";
	public static final String NHOM_VAN_BAN_TRANG_THAI = "NHOM_VAN_BAN_TRANG_THAI";
	public static final String NHOM_VAN_BAN_MO_TA = "NHOM_VAN_BAN_MO_TA";
	public static final String NHOM_VAN_BAN_CREATE_SUCCESS = "NHOM_VAN_BAN_CREATE_SUCCESS";
	public static final String NHOM_VAN_BAN_CREATE_ERROR = "NHOM_VAN_BAN_CREATE_ERROR";
	public static final String NHOM_VAN_BAN_CREATE_ERROR_EMPTY = "NHOM_VAN_BAN_CREATE_ERROR_EMPTY";
	public static final String NHOM_VAN_BAN_DELETE_ERROR_HAS_CHILD = "NHOM_VAN_BAN_DELETE_ERROR_HAS_CHILD";
	public static final String NHOM_VAN_BAN_ACTION_DELETE = "NHOM_VAN_BAN_ACTION_DELETE";
	public static final SimpleDateFormat DATE_FORMAT_YY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void createOrEditOrDeleteNhomVanBan(ActionRequest  actionRequest, ActionResponse  actionResponse) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long id = ParamUtil.getLong(actionRequest, NHOM_VAN_BAN_ID, 0);
			boolean delete = ParamUtil.getBoolean(actionRequest, NHOM_VAN_BAN_ACTION_DELETE, false);
			if (id > 0 && delete) {
				List<LinhVucVanBan> lvvbs = LinhVucVanBanLocalServiceUtil.findByNhomVanBanId(id);
				List<CoQuanBanHanhVanBan> cqbhs = CoQuanBanHanhVanBanLocalServiceUtil.findByNhomVanBanId(id);
				List<LoaiVanBan> lvbs = LoaiVanBanLocalServiceUtil.findByNhomVanBanId(id);
				if(!lvvbs.isEmpty() || !cqbhs.isEmpty() || !lvbs.isEmpty() ){
					SessionErrors.add(actionRequest, NHOM_VAN_BAN_DELETE_ERROR_HAS_CHILD, "Đã có dữ liệu, không xóa được nhóm!");
					actionResponse.setRenderParameter("mvcPath", "/html/admin/view_danhmuc_nhom_van_ban.jsp");
					return;
				}
				NhomVanBanLocalServiceUtil.deleteNhomVanBan(id);
				Map<String, String[]> pa = new HashMap<String, String[]>();
				pa.put("mvcPath", new String[]{ "/html/admin/view_danhmuc_nhom_van_ban.jsp"});
				redirect(pa, actionRequest, actionResponse);
				return;
			}
			String tenNhom = ParamUtil.getString(actionRequest, NHOM_VAN_BAN_TEN_NHOM, "");
			String hienThi = ParamUtil.getString(actionRequest, NHOM_VAN_BAN_TRANG_THAI, "true");
			
			if (Validator.isNull(tenNhom)) {
				SessionErrors.add(actionRequest, NHOM_VAN_BAN_CREATE_ERROR_EMPTY, "Phải nhập tên nhóm!");
				actionResponse.setRenderParameter("mvcPath", "/html/admin/edit_view_danhmuc_nhom_van_ban.jsp");
				return;
			}
			
			NhomVanBan nv = null;
			Date currentDate = new Date();
			if (id == 0) {
				id = CounterLocalServiceUtil.increment(NhomVanBan.class.getName());
				nv = NhomVanBanLocalServiceUtil.createNhomVanBan(id);
				nv.setNgayTao(DATE_FORMAT_YY_MM_DD_HH_MM_SS.parse(DATE_FORMAT_YY_MM_DD_HH_MM_SS.format(currentDate)));
				nv.setNgaySua(DATE_FORMAT_YY_MM_DD_HH_MM_SS.parse(DATE_FORMAT_YY_MM_DD_HH_MM_SS.format(currentDate)));
				nv.setNguoiTao(themeDisplay.getUser().getFullName());
				nv.setNguoiTaoId(themeDisplay.getUserId());
			} else {
				nv = NhomVanBanLocalServiceUtil.getNhomVanBan(id);
				nv.setNgaySua(DATE_FORMAT_YY_MM_DD_HH_MM_SS.parse(DATE_FORMAT_YY_MM_DD_HH_MM_SS.format(currentDate)));
				nv.setNguoiSua(themeDisplay.getUser().getFullName());
				nv.setNguoiSuaId(themeDisplay.getUserId());
			}
			if (!tenNhom.equals(nv.getTenNhom())) {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(NhomVanBan.class);
				dynamicQuery.add(RestrictionsFactoryUtil.eq("tenNhom", tenNhom));
				List<NhomVanBan> ls = NhomVanBanLocalServiceUtil.dynamicQuery(dynamicQuery);
				if (ls.size() > 0) {
					SessionErrors.add(actionRequest, NHOM_VAN_BAN_CREATE_ERROR, "Tên hóm đã tồn tại!");
					actionResponse.setRenderParameter("mvcPath", "/html/admin/edit_view_danhmuc_nhom_van_ban.jsp");
					return;
				}
			}
			nv.setTenNhom(tenNhom);
			if (hienThi.equals("true")) {
				nv.setTrangThai(WorkflowConstants.STATUS_APPROVED);
			} else {
				nv.setTrangThai(WorkflowConstants.STATUS_DRAFT);
			}
			nv.setGroupId(themeDisplay.getScopeGroupId());
			NhomVanBanLocalServiceUtil.updateNhomVanBan(nv);
			SessionMessages.add(actionRequest, NHOM_VAN_BAN_CREATE_SUCCESS, "Tạo nhóm thành công!");
			Map<String, String[]> pa = new HashMap<String, String[]>();
			pa.put("mvcPath", new String[]{ "/html/admin/view_danhmuc_nhom_van_ban.jsp"});
			redirect(pa, actionRequest, actionResponse);
		} catch (Exception e) {
			// TODO: handle exception
			_log.error(e);
		}
	}
	
	
	private static void redirect(Map<String, String[]> params, ActionRequest actionRequest, ActionResponse actionResponse) {
		
		String portletName = (String) actionRequest
				.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest),
				portletName, themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		redirectURL.setParameters(params);
		try {
			actionResponse.sendRedirect(redirectURL.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
	}
	

}
