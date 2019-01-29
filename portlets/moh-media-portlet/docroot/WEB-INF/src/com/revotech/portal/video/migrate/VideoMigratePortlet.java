package com.revotech.portal.video.migrate;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.revotech.portal.videolibrary.model.VLCategory;
import com.revotech.portal.videolibrary.model.VLVideo;
import com.revotech.portal.videolibrary.model.VideoCategory;
import com.revotech.portal.videolibrary.model.VideoClip;
import com.revotech.portal.videolibrary.service.VLCategoryLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VideoCategoryLocalService;
import com.revotech.portal.videolibrary.service.VideoCategoryLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VideoClipLocalServiceUtil;
import com.revotech.portal.videolibrary.util.VideoConstants;

/**
 * Portlet implementation class VideoMigratePortlet
 */
public class VideoMigratePortlet extends MVCPortlet {
	public void migrateCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			String userName = PortalUtil.getUserName(userId, "Guest");

			List<VideoCategory> lstCate = VideoCategoryLocalServiceUtil.findAll();

			VLCategoryLocalServiceUtil.removeAll(groupId);

			if (Validator.isNotNull(lstCate) && !lstCate.isEmpty()) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(VLCategory.class.getName(),
						actionRequest);
				serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });

				for (VideoCategory cat : lstCate) {
					long categoryId = cat.getID();
					String catName = cat.getName();
					VLCategoryLocalServiceUtil.addLegalCategory(groupId, companyId, userId, userName, categoryId,
							catName, true, serviceContext);
					_log.info("migrate category -->" + cat.getName());
				}
			}
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "save-failed");

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
	}

	public void migrateVideo(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			String userName = PortalUtil.getUserName(userId, "Guest");
			
			List<VideoClip> lstCate = VideoClipLocalServiceUtil.findAll();
			_log.info("Tong so video -->" + lstCate.size());
			VLVideoLocalServiceUtil.removeAll(groupId);
			int i = 0;
			if (!lstCate.isEmpty() && lstCate.size() > 0) {
				for (VideoClip cat : lstCate) {
					
					String videoName = cat.getName();

					String videoDescription = cat.getDescription();

					String videoType = VideoConstants.EXTERNAL_VIDEO_TYPE;

					String videoUrl = StringUtil.replace(cat.getVideoUrl(), ".flv", ".mp4");

					String imageUrl = cat.getImageUrl();
					
					long categoryId = cat.getCategoryID();

					ServiceContext serviceContext = ServiceContextFactory.getInstance(VLVideo.class.getName(),
							actionRequest);
					serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
					serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });

					VLVideoLocalServiceUtil.addLegalVideo(categoryId, companyId, groupId, userId, userName,
							videoName, videoDescription, videoType, videoUrl, 0L, true, 0L, imageUrl, cat.getCreationDate(), cat.getModifiedDate(), serviceContext);
					i++;
				}
				_log.info("Tong so video -->" + i);
			}
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "save-failed");
		}
	}

	private final static Log _log = LogFactoryUtil.getLog(VideoMigratePortlet.class);
}
