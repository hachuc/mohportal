package com.viettel.portal.photos.action;

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
			
			//long scopeId = ParamUtil.getLong(actionRequest, "scopeId");
			//preferences.setValue("scopeId", String.valueOf(scopeId));
			
			String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");
			
			String styleTitle = ParamUtil.getString(actionRequest, "styleTitle");
			
			//String[] arrSelectedPhotosId = ParamUtil.getParameterValues(actionRequest, "selectedPhotoId");
			
			//String selectedPhotosId = StringUtil.merge(arrSelectedPhotosId);
			
			int numbersOfAlbumDisplay = ParamUtil.getInteger(actionRequest, "numbersOfAlbumDisplay");
			int albumDisplay = ParamUtil.getInteger(actionRequest, "albumDisplay");
			
			//boolean showPhotoThumbnail = ParamUtil.getBoolean(actionRequest, "showPhotoThumbnail",false);
			
			//boolean showPhotoPublishDate = ParamUtil.getBoolean(actionRequest, "showPhotoPublishDate",false);
			
			boolean showViewMorePhotoLink = ParamUtil.getBoolean(actionRequest, "showViewMorePhotoLink",true);
			
			if(showViewMorePhotoLink){
				
				long photoPageLayoutId = ParamUtil.getLong(actionRequest, "photoPageLayoutId");
				
				preferences.setValue("photoPageLayoutId", String.valueOf(photoPageLayoutId));
			}
			
			
			preferences.setValue("displayStyle", displayStyle);
			preferences.setValue("styleTitle", styleTitle);
			preferences.setValue("numbersOfAlbumDisplay", String.valueOf(numbersOfAlbumDisplay));
			preferences.setValue("albumDisplay", String.valueOf(albumDisplay));
			//preferences.setValue("selectedPhotosId", selectedPhotosId);
			//preferences.setValue("showPhotoThumbnail", String.valueOf(showPhotoThumbnail));
			//preferences.setValue("showPhotoPublishDate", String.valueOf(showPhotoPublishDate));
			preferences.setValue("showViewMorePhotoLink", String.valueOf(showViewMorePhotoLink));
			
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
		return "/html/photo/config.jsp";
	}
	
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
}