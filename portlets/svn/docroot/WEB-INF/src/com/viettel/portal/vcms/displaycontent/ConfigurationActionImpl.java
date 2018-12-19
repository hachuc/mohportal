package com.viettel.portal.vcms.displaycontent;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction{
	
@Override
public void processAction(PortletConfig portletConfig,
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
	try {
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		String portletTitle = ParamUtil.getString(actionRequest, "portletTitle");
		String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");
		String layoutUuid = ParamUtil.getString(actionRequest, "layoutUuid");
		int itemDisplay = ParamUtil.getInteger(actionRequest, "itemDisplay");
		int titleLength = ParamUtil.getInteger(actionRequest, "titleLength");
		//long selectedCategoryId =ParamUtil.getLong(actionRequest, "categoryId");
		boolean showPublishDate = ParamUtil.getBoolean(actionRequest, "showPublishDate");
		String[] categoryIds = ParamUtil.getParameterValues(actionRequest, "categoryIds");
		
		preferences.setValue("layoutUuid", layoutUuid);
		preferences.setValue("portletTitle", portletTitle);
		preferences.setValue("itemDisplay", String.valueOf(itemDisplay));
		preferences.setValue("displayStyle", String.valueOf(displayStyle));
		preferences.setValue("titleLength", String.valueOf(titleLength));
		preferences.setValue("showPublishDate", String.valueOf(showPublishDate));
		//preferences.setValue("selectedCategoryId", String.valueOf(selectedCategoryId));
		preferences.setValues("categoryIds", categoryIds);
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

@Override
public String render(PortletConfig portletConfig,
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {
	return "/html/frontend/vcms-display/config.jsp";
}
private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
}
