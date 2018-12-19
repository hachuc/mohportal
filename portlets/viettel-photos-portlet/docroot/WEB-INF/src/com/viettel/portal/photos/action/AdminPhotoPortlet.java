package com.viettel.portal.photos.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.photos.PhotoFileSizeException;
import com.viettel.portal.photos.PhotoFileTypeException;
import com.viettel.portal.photos.DuplicateCategoryNameException;
import com.viettel.portal.photos.action.AdminPhotoPortlet;
import com.viettel.portal.photos.model.PCategory;
import com.viettel.portal.photos.model.Photo;
import com.viettel.portal.photos.service.PCategoryLocalServiceUtil;
import com.viettel.portal.photos.service.PhotoLocalServiceUtil;
import com.viettel.portal.photos.util.PhotoFileUtil;

public class AdminPhotoPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.render(request, response);
	}

	private final static Log _log = LogFactoryUtil
			.getLog(AdminPhotoPortlet.class);
 
	public void updatePhoto(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
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
			
			String caption = ParamUtil.getString(uploadPortletRequest, "caption");
			//_log.info("VIETTEL PORTAL: name -> " + name);
			Long categoryId = ParamUtil.getLong(uploadPortletRequest, "categoryId", 0L);
			imageStream = uploadPortletRequest.getFileAsStream("photoFile");
			long fileId = 0;
			long fileSize = 0;
			if(imageStream != null){
				byte[] imageFileBytes = FileUtil.getBytes(imageStream);
				String imageFileName = uploadPortletRequest.getFileName("photoFile");
				if (PhotoFileUtil.validateImageThumbnail(imageFileName, imageFileBytes.length, preferences)) {
					String friendlyFileName = "PHOTOS-";//PhotoFileUtil.getFriendlyFileName(caption);
					String timeStampFileName = friendlyFileName
							+ StringPool.MINUS
							+ String.valueOf(System.nanoTime())
							+ StringPool.PERIOD
							+ FileUtil.getExtension(imageFileName);
					String mimeType = MimeTypesUtil.getContentType(imageFileName);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(FileEntry.class.getName(),actionRequest);
					serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
					serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
					FileEntry imageFile = DLAppServiceUtil
							.addFileEntry(groupId, 0,
								timeStampFileName, mimeType,
								timeStampFileName,
								StringPool.BLANK, StringPool.BLANK,
								imageFileBytes, serviceContext);
					fileId = imageFile.getFileEntryId();
					fileSize = imageFile.getSize();
				}
			}
			else{
				 fileId = ParamUtil.getInteger(actionRequest, "fileId");;
				 fileSize = ParamUtil.getLong(actionRequest, "fileSize");;
			}
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Photo.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			long photoId = ParamUtil.getLong(actionRequest, "photoId");
			
			int order_ = ParamUtil.getInteger(actionRequest, "order_");
			boolean status = ParamUtil.getBoolean(actionRequest, "status", true);
			if (photoId > 0) {
				PhotoLocalServiceUtil.updatePhoto(photoId,categoryId,companyId,
						groupId, userId, userName, caption,order_,status,
						fileId, null, null, fileSize, serviceContext);
			} 
			else {
				PhotoLocalServiceUtil.addPhoto(categoryId, companyId,
						groupId, userId, userName, caption,order_,status,
						fileId, null, null, fileSize, serviceContext);
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch(Exception e){
			if (e instanceof PhotoFileTypeException || e instanceof PhotoFileSizeException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			} else {
				_log.error(e);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
			
		}
		finally{
			StreamUtil.cleanUp(imageStream);
		}
	}
	
	/**
	 * X�a photo
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void deletePhoto(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			// long groupId = ParamUtil.getLong(actionRequest, "groupId");
			if (id > 0) {
				Photo photo = PhotoLocalServiceUtil.getPhoto(id);
				if (photo != null) {
					PhotoLocalServiceUtil.deletePhoto(photo);
					if(photo.getFileId() > 0L){
						FileEntry photoFile = null;
						try {
							photoFile = DLAppServiceUtil.getFileEntry(photo.getFileId());
						} catch (Exception e) {
							_log.error(e);
						}
						
						if(photoFile != null){
							DLAppServiceUtil.deleteFileEntry(photo.getFileId());
						}
					}
				}
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void updatePCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			// long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long groupId = ParamUtil.getLong(actionRequest, "groupId");
			String userName = PortalUtil.getUserName(userId, "Guest");
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);
			String categoryName = ParamUtil.getString(actionRequest, "name");
			boolean status = ParamUtil.getBoolean(actionRequest, "status");
			int corder = ParamUtil.getInteger(actionRequest, "order_");
			String redirectURL = ParamUtil.getString(actionRequest,"redirectURL");
			List<PCategory> categories = PCategoryLocalServiceUtil.findByGroupAndName(groupId, categoryName);
			if (Validator.isNotNull(categoryId) && categoryId > 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PCategory.class.getName(), actionRequest);
				PCategory category = null;
				if (categoryId > 0) {
					category = PCategoryLocalServiceUtil.getPCategory(categoryId);
				}

				if (Validator.isNotNull(category)) {
					if (categories != null && !categories.isEmpty() && !category.getName().equals(categoryName)) {
						throw new DuplicateCategoryNameException();
					}
					PCategoryLocalServiceUtil.updateCategory(categoryId, companyId,
							groupId, userId, userName, categoryName, status,corder,
							serviceContext);
				}
			} else {
				if (categories != null && !categories.isEmpty()) {
					throw new DuplicateCategoryNameException();
				}
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PCategory.class.getName(), actionRequest);
				serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
				PCategoryLocalServiceUtil.addCategory(companyId, groupId,
						userId, userName, categoryName, status,corder,
						serviceContext);

			}
			SessionMessages.add(actionRequest, "category-saved-successfully");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			if (e instanceof DuplicateCategoryNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			} else {
				SessionErrors.add(actionRequest, "save-failed");
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
	}

	public void deletePCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		
		long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		PCategory category = null;
		if (categoryId > 0) {
			category = PCategoryLocalServiceUtil.getPCategory(categoryId);
		}
		if (Validator.isNotNull(category)) {
			PCategoryLocalServiceUtil.deletePCategory(category);
		}
		
		if (Validator.isNotNull(redirectURL)) {
			try {
				actionResponse.sendRedirect(redirectURL);
			} catch (IOException e) {
				_log.warn(e);
			}
		}
	}
}
