package com.revotech.portal.tthc.portlet.level2display;

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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationImpl extends DefaultConfigurationAction{
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
			
		// TODO Auto-generated method stub
			try {
				
				String portletResource = ParamUtil.getString(actionRequest, "portletResource");
				
				PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
				String portletTitle = ParamUtil.getString(actionRequest, "portletTitle",StringPool.BLANK);
				int displayItem = ParamUtil.getInteger(actionRequest, "displayItem");
				
				preferences.setValue("displayItem", String.valueOf(displayItem));
				preferences.setValue("portletTitle", portletTitle);
				
				if(SessionErrors.isEmpty(actionRequest)){
					
					preferences.store();
					
					SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);
	
					SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
				}
				
			} catch (Exception e) {
				_log.error(e);
				e.printStackTrace();
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
	}
	
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/view/level2/config.jsp";
	}
	
	
	private static Log _log = LogFactory.getLog(ConfigurationImpl.class);

}
