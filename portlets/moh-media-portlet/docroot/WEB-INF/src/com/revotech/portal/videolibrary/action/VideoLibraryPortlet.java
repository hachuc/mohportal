package com.revotech.portal.videolibrary.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
//import com.revotech.portal.videolibrary.DuplicateVLCategoryNameException;
import com.revotech.portal.videolibrary.ImageFileSizeException;
import com.revotech.portal.videolibrary.ImageFileTypeException;
import com.revotech.portal.videolibrary.VideoFileSizeException;
import com.revotech.portal.videolibrary.VideoFileTypeException;
import com.revotech.portal.videolibrary.model.VLCategory;
import com.revotech.portal.videolibrary.model.VLVideo;
import com.revotech.portal.videolibrary.model.VLVideoCategory;
import com.revotech.portal.videolibrary.model.VideoClip;
import com.revotech.portal.videolibrary.service.VLCategoryLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VideoClipLocalServiceUtil;
import com.revotech.portal.videolibrary.util.VideoConstants;
import com.revotech.portal.videolibrary.util.VideoFileUtil;

/**
 * Portlet implementation class VideoLibraryPortlet
 */
public class VideoLibraryPortlet extends MVCPortlet {
	public void updateVLCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			// long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long groupId = ParamUtil.getLong(actionRequest, "groupId");
			String userName = PortalUtil.getUserName(userId, "Guest");

			long categoryId = ParamUtil
					.getLong(actionRequest, "categoryId", 0L);

			String categoryName = ParamUtil.getString(actionRequest,
					"categoryName");

			// String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			boolean invisible = ParamUtil
					.getBoolean(actionRequest, "invisible");

			if (categoryName.length() > 75 || categoryName.length() < 3) {

			}

			List<VLCategory> categories = VLCategoryLocalServiceUtil
					.findByCategoryName(categoryName, groupId);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(VLCategory.class.getName(), actionRequest);
			if (Validator.isNotNull(categoryId)) {
				

				VLCategory category = null;

				if (categoryId > 0) {
					category = VLCategoryLocalServiceUtil
							.getVLCategory(categoryId);
				}

				if (Validator.isNotNull(category)) {

					if (categories != null && !categories.isEmpty()
							&& !category.getCategoryName().equals(categoryName)) {
						return;
					}

					VLCategoryLocalServiceUtil.updateVLCategory(categoryId,
							companyId, groupId, userId, userName, categoryName,
							invisible, serviceContext);

				}
			} else {

				if (categories != null && !categories.isEmpty()) {
					return;
				}
				VLCategoryLocalServiceUtil.addVLCategory(companyId, groupId, userId, userName, categoryName, invisible, serviceContext);
			}

			SessionMessages.add(actionRequest, "category-saved-successfully");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			SessionErrors.add(actionRequest, "save-failed");

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
	}

	public void migrateVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			List<VideoClip> lstCate = VideoClipLocalServiceUtil.findAll();
			_log.info("Tong so video -->" + lstCate.size());
			int i = 0;
			if (Validator.isNotNull(lstCate) && lstCate.size() > 0) {
				for (VideoClip cat : lstCate) {
					long companyId = PortalUtil.getCompanyId(actionRequest);

					long groupId = PortalUtil.getScopeGroupId(actionRequest);

					long userId = PortalUtil.getUserId(actionRequest);

					String userName = PortalUtil.getUserName(userId, "Guest");

					String videoName = cat.getName();

					String videoDescription = cat.getDescription();

					String videoType = VideoConstants.EXTERNAL_VIDEO_TYPE;

					String videoUrl = StringUtil.replace(cat.getVideoUrl(),".flv",".mp4");

					String imageUrl = cat.getImageUrl();
					String smallImageUrl = cat.getImageUrl();

					ServiceContext serviceContext = ServiceContextFactory
							.getInstance(VLVideo.class.getName(), actionRequest);

					serviceContext
							.setGroupPermissions(new String[] { ActionKeys.VIEW });
					serviceContext
							.setGuestPermissions(new String[] { ActionKeys.VIEW });

					VLVideo video = VLVideoLocalServiceUtil.addVideo(0L, companyId, groupId,
							userId, userName, videoName, videoDescription,
							videoType, videoUrl, 0L, true, 0L, serviceContext,smallImageUrl);
					i++;
					if(cat.getCreationDate()!=null && video !=null){						
						video.setModifiedDate(cat.getCreationDate());
						VLVideoLocalServiceUtil.updateVLVideo(video);
					}
				}
				_log.info("Tong so video -->" + i);
			}
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "save-failed");

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
	}

	public void deleteVLCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		long groupId = PortalUtil.getScopeGroupId(actionRequest);
		long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

		VLCategory category = null;

		if (categoryId > 0) {
			category = VLCategoryLocalServiceUtil.getVLCategory(categoryId);
		}

		if (Validator.isNotNull(category)) {
			List<VLVideoCategory> videoCategories = VLVideoCategoryLocalServiceUtil
					.findByCategory(categoryId, groupId);
			if (videoCategories != null) {
				for (VLVideoCategory videoCategory : videoCategories) {
					VLVideoCategoryLocalServiceUtil
							.deleteVLVideoCategory(videoCategory);
				}
			}
			List<VLVideo> videos = VLVideoLocalServiceUtil.findByKeyword(
					groupId, categoryId, null, 0, Integer.MAX_VALUE, null);
			if (videos != null && !videos.isEmpty()) {
				for (VLVideo video : videos) {
					video.setCategoryId(0);
					video.setModifiedDate(new Date());
					VLVideoLocalServiceUtil.updateVLVideo(video);
				}
			}
			VLCategoryLocalServiceUtil.deleteVLCategory(category);

		}

		if (Validator.isNotNull(redirectURL)) {
			try {
				actionResponse.sendRedirect(redirectURL);
			} catch (IOException e) {
				_log.warn(e);
			}
		}
	}

	public void updateVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		InputStream videoFileStream = null;
		InputStream imageStream = null;

		try {

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest);

			UploadPortletRequest uploadPortletRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			long companyId = PortalUtil.getCompanyId(uploadPortletRequest);

			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);

			long userId = PortalUtil.getUserId(uploadPortletRequest);

			String userName = PortalUtil.getUserName(userId, "Guest");

			long videoFolderId = ParamUtil
					.getLong(uploadPortletRequest, "videoFolderId",
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

			long videoId = ParamUtil.getLong(uploadPortletRequest, "videoId");

			long categoryId = ParamUtil.getLong(uploadPortletRequest,
					"videoCategory", 0L);

			String videoName = ParamUtil.getString(uploadPortletRequest,
					"videoName");

			String videoDescription = ParamUtil.getString(uploadPortletRequest,
					"description");

			String videoType = ParamUtil.getString(uploadPortletRequest,
					"videoType");
			String linkResult = ParamUtil.getString(uploadPortletRequest,
					"smallImageUrl");

			String videoUrl = "";

			long videoFileId = ParamUtil
					.getLong(uploadPortletRequest, "fileId");
			boolean videoThumbnailImage = ParamUtil.getBoolean(
					uploadPortletRequest, "videoThumbnailImage");

			long thumbnailImageId = ParamUtil.getLong(uploadPortletRequest,
					"thumbnailImageId");

			// External video
			//if (Validator.equals(videoType, VideoConstants.EXTERNAL_VIDEO_TYPE)) {

			//	if (videoFileId > 0L) {
					// delete internal video file
			//		DLAppServiceUtil.deleteFileEntry(videoFileId);
			//		videoFileId = 0L;
			//	}

			//	videoUrl = ParamUtil
			//			.getString(uploadPortletRequest, "videoUrl");
			//} else {// Internal video

				videoFileStream = uploadPortletRequest
						.getFileAsStream("videoFile");

				if (videoFileStream != null) {

					videoUrl = "";

					byte[] videoFileBytes = FileUtil.getBytes(videoFileStream);

					String videoFileName = uploadPortletRequest
							.getFileName("videoFile");

					if (VideoFileUtil.validateVideoFile(videoFileName,
							videoFileBytes)) {
						
						String friendlyFileName = VideoFileUtil
								.getFriendlyFileName(videoName);
//						String timeStampFileName = friendlyFileName
//								+ StringPool.MINUS
//								+ String.valueOf(System.nanoTime())
//								+ StringPool.PERIOD
//								+ FileUtil.getExtension(videoFileName);

						String mimeType = MimeTypesUtil
								.getContentType(videoFileName);

						ServiceContext serviceContext = ServiceContextFactory
								.getInstance(FileEntry.class.getName(),
										actionRequest);

						serviceContext
								.setGroupPermissions(new String[] { ActionKeys.VIEW });
						serviceContext
								.setGuestPermissions(new String[] { ActionKeys.VIEW });

						if (videoFileId > 0) {

//							DLAppServiceUtil.updateFileEntry(videoFileId,
//									timeStampFileName, mimeType,
//									timeStampFileName, StringPool.BLANK,
//									StringPool.BLANK, true, videoFileBytes,
//									serviceContext);
							DLAppServiceUtil.updateFileEntry(videoFileId,
									videoFileName, mimeType,
									videoFileName, StringPool.BLANK,
									StringPool.BLANK, true, videoFileBytes,
									serviceContext);
						} else {

							FileEntry videoFile = DLAppServiceUtil
									.addFileEntry(groupId, videoFolderId,
											videoFileName, mimeType,
											videoFileName,
											StringPool.BLANK, StringPool.BLANK,
											videoFileBytes, serviceContext);
//							FileEntry videoFile = DLAppServiceUtil
//									.addFileEntry(groupId, videoFolderId,
//											timeStampFileName, mimeType,
//											timeStampFileName,
//											StringPool.BLANK, StringPool.BLANK,
//											videoFileBytes, serviceContext);

							if (videoFile != null) {

								videoFileId = videoFile.getFileEntryId();
							}
						}
					} else {

					}
				}
		//	}

			if (videoThumbnailImage) {

				imageStream = uploadPortletRequest
						.getFileAsStream("videoThumbnailImageFile");

				if (imageStream != null) {

					byte[] thumbnailFileBytes = FileUtil.getBytes(imageStream);

					String thumbnailFileName = uploadPortletRequest
							.getFileName("videoThumbnailImageFile");

					if (VideoFileUtil.validateImageThumbnail(thumbnailFileName,
							thumbnailFileBytes.length, preferences)) {

						String friendlyFileName = VideoFileUtil
								.getFriendlyFileName(videoName);

						String timeStampFileName = friendlyFileName
								+ StringPool.MINUS
								+ String.valueOf(System.nanoTime())
								+ StringPool.PERIOD
								+ FileUtil.getExtension(thumbnailFileName);

						String mimeType = MimeTypesUtil
								.getContentType(thumbnailFileName);

						ServiceContext serviceContext = ServiceContextFactory
								.getInstance(FileEntry.class.getName(),
										actionRequest);

						serviceContext
								.setGroupPermissions(new String[] { ActionKeys.VIEW });
						serviceContext
								.setGuestPermissions(new String[] { ActionKeys.VIEW });

						if (thumbnailImageId > 0) {

							DLAppServiceUtil.updateFileEntry(thumbnailImageId,
									timeStampFileName, mimeType,
									timeStampFileName, StringPool.BLANK,
									StringPool.BLANK, true, thumbnailFileBytes,
									serviceContext);
						} else {

							FileEntry thumbnailImageFile = DLAppServiceUtil
									.addFileEntry(groupId, videoFolderId,
											timeStampFileName, mimeType,
											timeStampFileName,
											StringPool.BLANK, StringPool.BLANK,
											thumbnailFileBytes, serviceContext);

							if (thumbnailImageFile != null) {

								thumbnailImageId = thumbnailImageFile
										.getFileEntryId();
							}
						}
					}
				}
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					VLVideo.class.getName(), actionRequest);

			serviceContext
					.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext
					.setGuestPermissions(new String[] { ActionKeys.VIEW });

			if (videoId > 0) {

				VLVideoLocalServiceUtil.updateVideo(videoId, categoryId,
						companyId, groupId, userId, userName, videoName,
						videoDescription, videoType, videoUrl, videoFileId,
						videoThumbnailImage, thumbnailImageId, serviceContext,linkResult);

				if ((Validator.isNotNull(categoryId)) && (categoryId > 0L)) {
					long id = 0L;

					if (VLVideoCategoryLocalServiceUtil.findByVideo(videoId,
							groupId).size() > 0) {
						id = VLVideoCategoryLocalServiceUtil
								.findByVideo(videoId, groupId).get(0).getId();
					}

					if (id > 0L) {
						VLVideoCategoryLocalServiceUtil.updateVLVideoCategory(
								id, categoryId, videoId, groupId,
								serviceContext);
					} else {
						VLVideoCategoryLocalServiceUtil.addVLVideoCategory(
								categoryId, videoId, groupId, serviceContext);
					}
				}

			} else {

				VLVideoLocalServiceUtil.addVideo(categoryId, companyId,
						groupId, userId, userName, videoName, videoDescription,
						videoType, videoUrl, videoFileId, videoThumbnailImage,
						thumbnailImageId, serviceContext,linkResult);

			}
			actionRequest.setAttribute("categoryId", categoryId);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			if (e instanceof VideoFileTypeException
					|| e instanceof VideoFileSizeException
					|| e instanceof ImageFileTypeException
					|| e instanceof ImageFileSizeException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			} else {
				_log.error(e);
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		} finally {
			StreamUtil.cleanUp(videoFileStream);
			StreamUtil.cleanUp(imageStream);
		}
	}

	public void deleteAllVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {
			long groupId = ParamUtil.getLong(actionRequest, "groupId");
			List<VLVideo> lstVideo = VLVideoLocalServiceUtil
					.findByGroup(groupId);
			for (VLVideo video : lstVideo) {

				if (video != null && video.getFileId() > 0L) {
					FileEntry videoFile = null;
					try {
						videoFile = DLAppServiceUtil.getFileEntry(video
								.getFileId());
					} catch (Exception e) {
						_log.error(e);
					}

					if (videoFile != null) {
						DLAppServiceUtil.deleteFileEntry(video.getFileId());
					}
				}

				if (video != null && video.getImageId() > 0L) {

					FileEntry videoImage = null;

					try {
						videoImage = DLAppServiceUtil.getFileEntry(video
								.getImageId());
					} catch (Exception e) {
						_log.error(e);
					}

					if (videoImage != null) {
						DLAppServiceUtil.deleteFileEntry(video.getImageId());
					}

				}

				VLVideoLocalServiceUtil.deleteVLVideo(video);

				List<VLVideoCategory> listMap = VLVideoCategoryLocalServiceUtil
						.findByVideo(video.getVideoId(), groupId);

				if (Validator.isNotNull(listMap))
					for (int i = 0; i < listMap.size(); i++) {
						VLVideoCategoryLocalServiceUtil
								.deleteVLVideoCategory(listMap.get(i));
					}
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long videoId = ParamUtil.getLong(actionRequest, "videoId");
			long groupId = ParamUtil.getLong(actionRequest, "groupId");
			if (videoId > 0) {

				VLVideo video = VLVideoLocalServiceUtil.getVLVideo(videoId);

				if (video != null && video.getFileId() > 0L) {
					FileEntry videoFile = null;
					try {
						videoFile = DLAppServiceUtil.getFileEntry(video
								.getFileId());
					} catch (Exception e) {
						_log.error(e);
					}

					if (videoFile != null) {
						DLAppServiceUtil.deleteFileEntry(video.getFileId());
					}
				}

				if (video != null && video.getImageId() > 0L) {

					FileEntry videoImage = null;

					try {
						videoImage = DLAppServiceUtil.getFileEntry(video
								.getImageId());
					} catch (Exception e) {
						_log.error(e);
					}

					if (videoImage != null) {
						DLAppServiceUtil.deleteFileEntry(video.getImageId());
					}

				}

				VLVideoLocalServiceUtil.deleteVLVideo(videoId);

				List<VLVideoCategory> listMap = VLVideoCategoryLocalServiceUtil
						.findByVideo(videoId, groupId);

				if (Validator.isNotNull(listMap))
					for (int i = 0; i < listMap.size(); i++) {
						VLVideoCategoryLocalServiceUtil
								.deleteVLVideoCategory(listMap.get(i));
					}

			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.render(request, response);
	}

	private final static Log _log = LogFactoryUtil
			.getLog(VideoLibraryPortlet.class);
}
