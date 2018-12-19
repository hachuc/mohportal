package com.viettel.portal.vbpq.action;

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

public class VbpqHomeConfigurationImpl extends DefaultConfigurationAction{
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
			
		// TODO Auto-generated method stub
			try {
				
				String portletResource = ParamUtil.getString(actionRequest, "portletResource");
				
				PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
				
				long scopeId = ParamUtil.getLong(actionRequest, "scopeId");
				
				//Kieu hien thi
				String homeDisplay = ParamUtil.getString(actionRequest, "homeDisplay", StringPool.BLANK);
				int numberVbpqDisplay = ParamUtil.getInteger(actionRequest, "numberVbpqDisplay", 5);
				String[] cqbhs = ParamUtil.getParameterValues(actionRequest, "coquanbanhanhhome");
				
				preferences.setValue("scopeId", String.valueOf(scopeId));
				preferences.setValue("homeDisplay", homeDisplay);
				preferences.setValue("numberVbpqDisplay", String.valueOf(numberVbpqDisplay));
				preferences.setValues("coquanbanhanhhome", cqbhs);
				
				if(SessionErrors.isEmpty(actionRequest)){
					
					preferences.store();
					
					SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);
	
					SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
				}
				
			} catch (Exception e) {
				_log.error(e);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
	}
	
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/config/configurationHome.jsp";
	}
	
	
	private static Log _log = LogFactory.getLog(VbpqHomeConfigurationImpl.class);

}
