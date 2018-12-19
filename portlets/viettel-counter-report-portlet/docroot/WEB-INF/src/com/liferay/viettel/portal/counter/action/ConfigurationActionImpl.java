package com.liferay.viettel.portal.counter.action;

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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
			String portletResource = ParamUtil.getString(actionRequest,
					"portletResource");

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest, portletResource);

			if (cmd.equals(Constants.UPDATE)) {
				String[] categoryIdValues = null;
				categoryIdValues = StringUtil.split(ParamUtil.getString(
						actionRequest, "queryCategoryIds"));
				// preferences.setValue("categoryIdValues", categoryIdValues);
				// preferences.setValue("porletTitle", porletTitle);
				// preferences.setValue("displayItem",
				// String.valueOf(displayItem));
				setPreference(actionRequest, "categoryIdValues",
						categoryIdValues);

				preferences.store();

				super.processAction(portletConfig, actionRequest,
						actionResponse);
			}
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName(), e);
		}
	}

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/view/config.jsp";
	}

	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);

}
