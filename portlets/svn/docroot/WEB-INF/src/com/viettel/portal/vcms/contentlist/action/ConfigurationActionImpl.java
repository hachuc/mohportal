package com.viettel.portal.vcms.contentlist.action;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;

public class ConfigurationActionImpl extends DefaultConfigurationAction{
	
@Override
public void processAction(PortletConfig portletConfig,
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
	try {
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		int contentListState = ParamUtil.getInteger(actionRequest, "contentListState");
		int roleVersion = ParamUtil.getInteger(actionRequest, "roleVersion");
		int viewMode = ParamUtil.getInteger(actionRequest, "viewMode");
		
		boolean showForAuthor = ParamUtil.getBoolean(actionRequest, "showForAuthor");
		preferences.setValue("contentListState", String.valueOf(contentListState));
		preferences.setValue("viewMode", String.valueOf(viewMode));
		preferences.setValue("roleVersion", String.valueOf(roleVersion));
		preferences.setValue("showForAuthor", String.valueOf(showForAuthor));
		if(SessionErrors.isEmpty(actionRequest)){
			preferences.store();
			SessionMessages.add(actionRequest,portletConfig.getPortletName() 
					+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);
			SessionMessages.add(actionRequest,portletConfig.getPortletName() 
					+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
		
	}catch(Exception e){
		_log.error(e);
	}
}

/* (non-Javadoc)
 * @see com.liferay.portal.kernel.portlet.DefaultConfigurationAction#serveResource(javax.portlet.PortletConfig, javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
 */
@Override
public void serveResource(PortletConfig portletConfig,
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {
	try {
		resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
		int version = ParamUtil.getInteger(resourceRequest, "version", 0);
		JSONArray statusArray = JSONFactoryUtil.createJSONArray();
		if (version != 0){
			JSONArray arrays = JSONFactoryUtil.createJSONArray(VERSION_STATUS);
			for(int i = 0; i<arrays.length(); i++){
				JSONObject jsonObject = arrays.getJSONObject(i);
				if(version == jsonObject.getInt("Version")){
					statusArray = jsonObject.getJSONArray("");					
					break;
				}
			}
		}
		writer.print(statusArray.toString());
        writer.flush();
        writer.close();
	} catch (Exception e) {
		_log.error(e);
	}
}

@Override
public String render(PortletConfig portletConfig,
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {
	return "/html/admin/list-content/config.jsp";
}
private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
private static String VERSION_STATUS="[{\"Version\":1,\"Status\":[{\"Status\":1,\"Message\":\"bai-moi-viet\"},{\"Status\":2,\"Message\":\"bai-gui-bien-tap\"}]},{\"Version\":2,\"Status\":[{\"Status\":4,\"Message\":\"bai-tra-lai-phong-vien\"},{\"Status\":8,\"Message\":\"bai-cho-bien-tap\"},{\"Status\":16,\"Message\":\"bai-dang-bien-tap\"},{\"Status\":32,\"Message\":\"bai-gui-kiem-duyet\"}]},{\"Version\":3,\"Status\":[{\"Status\":256,\"Message\":\"bai-cho-kiem-duyet\"},{\"Status\":512,\"Message\":\"bai-dang-kiem-duyet\"},{\"Status\":128,\"Message\":\"bai-tra-lai-bien-tap\"},{\"Status\":1024,\"Message\":\"bai-gui-trien-khai\"}]},{\"Version\":4,\"Status\":[{\"Status\":64,\"Message\":\"bai-tra-lai-bien-tap\"},{\"Status\":2048,\"Message\":\"bai-cho-trien-khai\"},{\"Status\":4096,\"Message\":\"bai-dang-trien-khai\"},{\"Status\":8192,\"Message\":\"bai-da-dang\"},{\"Status\":1024,\"Message\":\"bai-gui-trien-khai\"}]}]";
}
