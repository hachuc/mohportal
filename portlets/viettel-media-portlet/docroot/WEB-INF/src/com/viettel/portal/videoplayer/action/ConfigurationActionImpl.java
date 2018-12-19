package com.viettel.portal.videoplayer.action;

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
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;


public class ConfigurationActionImpl extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			long scopeId = ParamUtil.getLong(actionRequest, "scopeId");
			preferences.setValue("scopeId", String.valueOf(scopeId));
			
			String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");
			
			//long categoryId = ParamUtil.getLong(actionRequest, "videoCategory", -1);
			
			String styleTitle = ParamUtil.getString(actionRequest, "styleTitle");
			String prefixLink = ParamUtil.getString(actionRequest, "prefixLink");
			
			
			String[] arrSelectedVideosId = ParamUtil.getParameterValues(actionRequest, "selectedVideoId");
			
			String selectedVideosId = StringUtil.merge(arrSelectedVideosId);
			
			int numbersOfVideoDisplay = ParamUtil.getInteger(actionRequest, "numbersOfVideoDisplay");
			int categoryVideoDisplay = ParamUtil.getInteger(actionRequest, "categoryVideoDisplay");
			
			boolean useCustomVideoFrameSize = ParamUtil.getBoolean(actionRequest, "useCustomVideoFrameSize",false);
			
			if(useCustomVideoFrameSize){
				
				int videoFrameHeight = ParamUtil.getInteger(actionRequest, "videoFrameHeight");
				int videoFrameWidth = ParamUtil.getInteger(actionRequest, "videoFrameWidth");
				String heightUnit =  ParamUtil.getString(actionRequest, "heightUnit");
				String widthUnit =  ParamUtil.getString(actionRequest, "widthUnit");
				preferences.setValue("videoFrameHeight", String.valueOf(videoFrameHeight));
				preferences.setValue("videoFrameWidth", String.valueOf(videoFrameWidth));
				preferences.setValue("heightUnit",heightUnit);
				preferences.setValue("widthUnit",widthUnit);
			}
			
			boolean showTitle = ParamUtil.getBoolean(actionRequest, "showTitle",false);
			
			boolean showVideoThumbnail = ParamUtil.getBoolean(actionRequest, "showVideoThumbnail",false);
			
			boolean showVideoPublishDate = ParamUtil.getBoolean(actionRequest, "showVideoPublishDate",false);
			
			boolean showViewMoreVideoLink = ParamUtil.getBoolean(actionRequest, "showViewMoreVideoLink",true);
			
			if(showViewMoreVideoLink){
				
				long videoPageLayoutId = ParamUtil.getLong(actionRequest, "videoPageLayoutId");
				
				preferences.setValue("videoPageLayoutId", String.valueOf(videoPageLayoutId));
			}
			
			
			preferences.setValue("displayStyle", displayStyle);
			preferences.setValue("styleTitle", styleTitle);
			preferences.setValue("prefixLink", prefixLink);
			
			preferences.setValue("numbersOfVideoDisplay", String.valueOf(numbersOfVideoDisplay));
			preferences.setValue("categoryVideoDisplay", String.valueOf(categoryVideoDisplay));
			preferences.setValue("useCustomVideoFrameSize", String.valueOf(useCustomVideoFrameSize));
			preferences.setValue("selectedVideosId", selectedVideosId);
			preferences.setValue("showVideoThumbnail", String.valueOf(showVideoThumbnail));
			preferences.setValue("showTitle", String.valueOf(showTitle));
			preferences.setValue("showVideoPublishDate", String.valueOf(showVideoPublishDate));
			preferences.setValue("showViewMoreVideoLink", String.valueOf(showViewMoreVideoLink));

			
			// image
			
			long selectedImageFolderId = ParamUtil.getLong(actionRequest, "selectedImageFolderId",DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			
			int numbersOfImageDisplay = ParamUtil.getInteger(actionRequest, "numbersOfImageDisplay",DEFAULT_NUMBERS_OF_IMG_DISPLAY);
			
			boolean useThumbnailImage = ParamUtil.getBoolean(actionRequest, "useThumbnailImage",true);
			
			boolean useCustomImageSize = ParamUtil.getBoolean(actionRequest, "useCustomImageSize",false);
			
			if(useCustomImageSize){
				
				int imageThumbnailWidth = ParamUtil.getInteger(actionRequest, "imageThumbnailWidth",DEFAULT_IMAGE_THUMBNAIL_MAX_WIDTH);
				
				int imageThumbnailHeight = ParamUtil.getInteger(actionRequest, "imageThumbnailHeight",DEFAULT_IMAGE_THUMBNAIL_MAX_HEIGHT);
				
				preferences.setValue("useCustomImageSize", String.valueOf(useCustomImageSize));
				preferences.setValue("imageThumbnailWidth", String.valueOf(imageThumbnailWidth));
				preferences.setValue("imageThumbnailHeight", String.valueOf(imageThumbnailHeight));
			}
			
			boolean displayGalleryLink = ParamUtil.getBoolean(actionRequest, "displayGalleryLink",true);
			
			if(displayGalleryLink){
				
				long galleryPageId = ParamUtil.getLong(actionRequest, "galleryPageId",DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
				
				preferences.setValue("galleryPageId", String.valueOf(galleryPageId));
			}
			
			preferences.setValue("displayGalleryLink", String.valueOf(displayGalleryLink));
			preferences.setValue("useThumbnailImage", String.valueOf(useThumbnailImage));
			preferences.setValue("selectedImageFolderId", String.valueOf(selectedImageFolderId));
			preferences.setValue("numbersOfImageDisplay", String.valueOf(numbersOfImageDisplay));
			
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
		return "/html/videoplayer/config.jsp";
	}
	
	private static final int DEFAULT_NUMBERS_OF_IMG_DISPLAY = 5;
	
	private static final int DEFAULT_IMAGE_THUMBNAIL_MAX_WIDTH = 260;
	
	private static final int DEFAULT_IMAGE_THUMBNAIL_MAX_HEIGHT = 140;
	
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
}