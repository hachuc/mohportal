package com.viettel.portal.links.action;

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

public class LinkTabConfigurationImpl extends DefaultConfigurationAction{
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
			
		// TODO Auto-generated method stub
			try {
				String portletResource = ParamUtil.getString(actionRequest, "portletResource");			
				PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
				long[] ids = ParamUtil.getLongValues(actionRequest, "categoryIds");
				String  categoryIds = "";
				if(ids != null && ids.length > 0){
					for (long l : ids) {
						categoryIds += ("".equals(categoryIds) ? "" + l : "," + l);
					}
				}
				_log.error("VIETTEL PORTAL categoryIds -> " + categoryIds);
				preferences.setValue("categoryIds", categoryIds);
				preferences.store();
				
			} catch (Exception e) {
				_log.error(e);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
	}
	
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/display/tab/config.jsp";
	}
	
	
	private static Log _log = LogFactory.getLog(LinkTabConfigurationImpl.class);

}
