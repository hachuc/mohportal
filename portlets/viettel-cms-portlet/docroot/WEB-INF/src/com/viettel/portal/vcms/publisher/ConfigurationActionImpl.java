package com.viettel.portal.vcms.publisher;

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
		String paginationType = ParamUtil.getString(actionRequest, "paginationType");
		int itemDisplay = ParamUtil.getInteger(actionRequest, "itemDisplay");
		int itemDisplayList = ParamUtil.getInteger(actionRequest, "itemDisplayList");
		long selectedCategoryId =ParamUtil.getLong(actionRequest, "categoryId");
		boolean showAuthor = ParamUtil.getBoolean(actionRequest, "showAuthor");
		boolean showSocialBookmark = ParamUtil.getBoolean(actionRequest, "showSocialBookmark");
		boolean showPublishDate = ParamUtil.getBoolean(actionRequest, "showPublishDate");
		boolean showByDate = ParamUtil.getBoolean(actionRequest, "showByDate");
		boolean allowDiscussion = ParamUtil.getBoolean(actionRequest, "allowDiscussion");
		
		preferences.setValue("portletTitle", portletTitle);
		preferences.setValue("paginationType", paginationType);
		preferences.setValue("itemDisplay", String.valueOf(itemDisplay));
		preferences.setValue("itemDisplayList", String.valueOf(itemDisplayList));
		preferences.setValue("showAuthor", String.valueOf(showAuthor));
		preferences.setValue("showSocialBookmark", String.valueOf(showSocialBookmark));
		preferences.setValue("showPublishDate", String.valueOf(showPublishDate));
		preferences.setValue("showByDate", String.valueOf(showByDate));
		preferences.setValue("allowDiscussion", String.valueOf(allowDiscussion));
		preferences.setValue("selectedCategoryId", String.valueOf(selectedCategoryId));
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
	return "/html/frontend/publisher/config.jsp";
}
private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
}
