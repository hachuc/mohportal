package com.viettel.portal.vbpq.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.viettel.portal.vbpq.action.VbpqHomeConfigurationImpl;
import com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan;
import com.viettel.portal.vbpq.model.LinhVucVanBan;
import com.viettel.portal.vbpq.model.LoaiVanBan;
import com.viettel.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil;
import com.viettel.portal.vbpq.service.LinhVucVanBanLocalServiceUtil;
import com.viettel.portal.vbpq.service.LoaiVanBanLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.json.JSONFactoryUtil;

public class VanBanPhapQuyPortlet extends MVCPortlet {

	private static Log _log = LogFactory.getLog(VanBanPhapQuyPortlet.class);
	
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
			_log.error(e);
		}
	}
}
