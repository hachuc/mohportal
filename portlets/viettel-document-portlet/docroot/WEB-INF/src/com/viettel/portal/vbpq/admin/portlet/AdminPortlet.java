package com.viettel.portal.vbpq.admin.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.viettel.portal.vbpq.admin.action.CoQuanBanHanhAction;
import com.viettel.portal.vbpq.admin.action.LinhVucVanBanAction;
import com.viettel.portal.vbpq.admin.action.LoaiVanBanAction;
import com.viettel.portal.vbpq.admin.action.VanBanPhapQuyAction;
import com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan;
import com.viettel.portal.vbpq.model.LinhVucVanBan;
import com.viettel.portal.vbpq.model.LoaiVanBan;
import com.viettel.portal.vbpq.portlet.NhomVanBanController;
import com.viettel.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil;
import com.viettel.portal.vbpq.service.LinhVucVanBanLocalServiceUtil;
import com.viettel.portal.vbpq.service.LoaiVanBanLocalServiceUtil;
import com.viettel.portal.vbpq.service.impl.VanBanPhapQuyLocalServiceImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.json.JSONFactoryUtil;

public class AdminPortlet extends MVCPortlet {

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateVanBanPhapQuy(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			VanBanPhapQuyAction action = new VanBanPhapQuyAction();
			action.updateVanBanPhapQuy(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}

	
	/**updateStatusVanBan
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateStatusVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			VanBanPhapQuyAction action = new VanBanPhapQuyAction();
			action.updateStatusVanBan(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateLoaiVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			LoaiVanBanAction action = new LoaiVanBanAction();
			action.updateLoaiVanBan(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void deleteLoaiVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			LoaiVanBanAction action = new LoaiVanBanAction();
			action.deleteLoaiVanBan(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}
	
	public void deleteVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			VanBanPhapQuyAction action = new VanBanPhapQuyAction();
			action.deleteVanBan(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * Update LinhVucVanBan
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateLinhVuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			LinhVucVanBanAction action = new LinhVucVanBanAction();
			action.updateLinhVuc(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * Delete LinhVucVanban
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void deleteLinhVuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			LinhVucVanBanAction action = new LinhVucVanBanAction();
			action.deleteLinhVuc(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);
	}

	/**
	 * Delete CoQuanBanHanh
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void deleteCoQuanBanHanh(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		try {
			CoQuanBanHanhAction action = new CoQuanBanHanhAction();
			action.deleteCoQuanBanHanh(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);
	}

	/**
	 * Update CoQuanBanHanh
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateCoQuanBanHanh(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			CoQuanBanHanhAction action = new CoQuanBanHanhAction();
			action.updateCoQuanBanHanh(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * Send a Custom redirect after execute action
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	private void sendCustomRedirect(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		if (!SessionErrors.isEmpty(actionRequest)) {
			String backURL = ParamUtil.getString(actionRequest, "backURL");

			SessionMessages
					.add(actionRequest,
							PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			if (Validator.isNotNull(backURL)) {
				actionResponse.sendRedirect(backURL);
			}
		}
	}
	
	public void createOrEditNhomVanBan(ActionRequest actionRequest, ActionResponse actionResponse) {
		NhomVanBanController.createOrEditOrDeleteNhomVanBan(actionRequest, actionResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(AdminPortlet.class);
	
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub
		String method = ParamUtil.getString(resourceRequest, "method", null);
		if (Validator.isNotNull(method)) {
			if (method.equals("layCoQuanBanHanh")) {
				layCoQuanBanHanh(resourceRequest, resourceResponse);
			} else if (method.equals("layLinhVucVanBan")) {
				layLinhVucVanBan(resourceRequest, resourceResponse);
				
			} else if (method.equals("layTheLoaiVanBan")) {
				layTheLoaiVanBan(resourceRequest, resourceResponse);
				
			}
		}
	}
	
	
	private void layCoQuanBanHanh(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			resourceResponse.setContentType("text/html");
	        PrintWriter writer = resourceResponse.getWriter();
			long id = ParamUtil.getLong(resourceRequest, "id", 0);
			long groupId = ParamUtil.getLong(resourceRequest, "groupId");
			if (id == 0 || groupId == 0) return;
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CoQuanBanHanhVanBan.class);
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("nhomVanBanId", id));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", true));
			dynamicQuery.addOrder(OrderFactoryUtil.asc("ten"));
			List<CoQuanBanHanhVanBan> ls = CoQuanBanHanhVanBanLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (ls != null) {
				String jsonString = "[";
				for (int i = 0; i < ls.size(); i++) {
					jsonString += "{ \"id\":"+ls.get(i).getId()+", \"name\": \""+ls.get(i).getTen()+"\" }";
					if (i + 1 < ls.size()) jsonString += ",";
				}
				jsonString += "]";
				JSONArray array = JSONFactoryUtil.createJSONArray(jsonString);
				writer.print(array.toString());
			}
			
			

	        writer.flush();
	        writer.close();
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private void layLinhVucVanBan(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			resourceResponse.setContentType("text/html");
	        PrintWriter writer = resourceResponse.getWriter();
			long id = ParamUtil.getLong(resourceRequest, "id", 0);
			long groupId = ParamUtil.getLong(resourceRequest, "groupId");
			if (id == 0 || groupId == 0) return;
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LinhVucVanBan.class);
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("nhomVanBanId", id));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", true));
			dynamicQuery.addOrder(OrderFactoryUtil.asc("ten"));
			List<LinhVucVanBan> ls = LinhVucVanBanLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (ls != null) {
				String jsonString = "[";
				for (int i = 0; i < ls.size(); i++) {
					jsonString += "{ \"id\":"+ls.get(i).getId()+", \"name\": \""+ls.get(i).getTen()+"\" }";
					if (i + 1 < ls.size()) jsonString += ",";
				}
				jsonString += "]";
				JSONArray array = JSONFactoryUtil.createJSONArray(jsonString);
				writer.print(array.toString());
			}

	        writer.flush();
	        writer.close();
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private void layTheLoaiVanBan(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			resourceResponse.setContentType("text/html");
	        PrintWriter writer = resourceResponse.getWriter();
			long id = ParamUtil.getLong(resourceRequest, "id", 0);
			long groupId = ParamUtil.getLong(resourceRequest, "groupId");
			
			if (id == 0 || groupId == 0) return;
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LoaiVanBan.class);
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("nhomVanBanId", id));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", true));
			dynamicQuery.addOrder(OrderFactoryUtil.asc("ten"));
			List<LoaiVanBan> ls = LoaiVanBanLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (ls != null) {
				String jsonString = "[";
				for (int i = 0; i < ls.size(); i++) {
					jsonString += "{ \"id\":"+ls.get(i).getId()+", \"name\": \""+ls.get(i).getTen()+"\" }";
					if (i + 1 < ls.size()) jsonString += ",";
				}
				jsonString += "]";
				JSONArray array = JSONFactoryUtil.createJSONArray(jsonString);
				writer.print(array.toString());
			}

	        writer.flush();
	        writer.close();
		} catch (Exception e) {
			_log.error(e);
		}
	}
}
