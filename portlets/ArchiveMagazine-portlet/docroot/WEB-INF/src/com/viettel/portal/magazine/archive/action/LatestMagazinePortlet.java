package com.viettel.portal.magazine.archive.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.magazine.archive.model.Magazine;
import com.viettel.portal.magazine.archive.service.MagazineLocalServiceUtil;

public class LatestMagazinePortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub
		String method = ParamUtil.getString(resourceRequest, "method", null);
		if (Validator.isNotNull(method)) {
			if (method.equals("getMagazineByYear")) {
				getMagazineByYear(resourceRequest, resourceResponse);
			} 
		}
	}

	private void getMagazineByYear(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		try {
			resourceResponse.setContentType("text/html");
			PrintWriter writer = resourceResponse.getWriter();
			int PublishYear = ParamUtil.getInteger(resourceRequest, "PublishYear", 2010);

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
					.forClass(Magazine.class);
			dynamicQuery.add(RestrictionsFactoryUtil.eq("PublishYear", PublishYear));
			List<Magazine> ls = MagazineLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (ls != null) {
				String jsonString = "[";
				for (int i = 0; i < ls.size(); i++) {
					jsonString += "{ \"id\":" + ls.get(i).getID()
							+ ", \"name\": \"" + ls.get(i).getName() + "\" }";
					if (i + 1 < ls.size())
						jsonString += ",";
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
	
	private static final Log _log = LogFactoryUtil.getLog(LatestMagazinePortlet.class);
}
