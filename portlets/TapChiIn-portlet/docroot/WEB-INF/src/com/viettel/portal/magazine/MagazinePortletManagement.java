package com.viettel.portal.magazine;

import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelHintsUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.viettel.portal.magazine.model.Magazine;
import com.viettel.portal.magazine.service.MagazineContentLocalServiceUtil;
import com.viettel.portal.magazine.service.MagazineLocalServiceUtil;
import com.viettel.portal.magazine.service.MagazineZoneLocalService;
import com.viettel.portal.magazine.service.MagazineZoneLocalServiceUtil;
import com.viettel.portal.magazine.util.MagazineFileUtil;
import com.viettel.portal.magazine.util.NotAloneException;

public class MagazinePortletManagement extends MVCPortlet {
	private final static Log _log = LogFactoryUtil
			.getLog(MagazinePortletManagement.class);
 
	public void deleteMagazine(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		// Kiểm tra có thông tin phụ không, nếu có thì ko xóa
		
		try {
			int id = ParamUtil.getInteger(actionRequest, "id");
			int countZone = MagazineZoneLocalServiceUtil.countByMagazineID(id);
			int countContent = MagazineContentLocalServiceUtil.countByMagazineID(id);
			if (countContent > 0 || countZone > 0){
				SessionErrors.add(actionRequest, NotAloneException.class.getName());
			}
			else{
				MagazineLocalServiceUtil.deleteMagazine(id);
			}
		}catch(Exception ex){
			_log.error(ex);
		}
		finally{
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
	}
	public void updateMagazine(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		InputStream imageStream = null;
		
		try {
			PortletPreferences preferences = PortletPreferencesFactoryUtil .getPortletSetup(actionRequest);
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);
			long userId = PortalUtil.getUserId(uploadPortletRequest);
			String userFullname = PortalUtil.getUserName(userId, "Guest");
			String name = ParamUtil.getString(uploadPortletRequest, "name");
			int publishNumber = ParamUtil.getInteger(uploadPortletRequest, "publishNumber");
			int publishYear = ParamUtil.getInteger(uploadPortletRequest, "publishYear");
			imageStream = uploadPortletRequest.getFileAsStream("imageUrlInput");
			long fileId = ParamUtil.getLong(uploadPortletRequest, "imageUrl");

			if(imageStream != null){
				byte[] imageFileBytes = FileUtil.getBytes(imageStream);
				String imageFileName = uploadPortletRequest.getFileName("imageUrlInput");
				if (MagazineFileUtil.validateImageThumbnail(imageFileName, imageFileBytes.length, preferences)) {
					
					String friendlyFileName = getUrlTitle(0, name);// MagazineFileUtil.getFriendlyFileName(name);
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
				}
			}
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Magazine.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			int id = ParamUtil.getInteger(actionRequest, "id");
			Date distributedDate = null;
			int ddDay = ParamUtil.getInteger(actionRequest, "ddDay");
			int ddMonth = ParamUtil.getInteger(actionRequest, "ddMonth");
			int ddYear = ParamUtil.getInteger(actionRequest, "ddYear");
			String distributedDateStr = ParamUtil.getString(actionRequest, "distributedDate");
			if((distributedDateStr != null && !distributedDateStr.isEmpty()) && ddDay > 0 && ddMonth >= 0 && ddYear > 0){
				Calendar calendarS = Calendar.getInstance();
				calendarS.set(Calendar.DAY_OF_MONTH, ddDay);
				calendarS.set(Calendar.MONTH, ddMonth);
				calendarS.set(Calendar.YEAR, ddYear);
				distributedDate = calendarS.getTime();
			}
			if (id > 0) {
				MagazineLocalServiceUtil.updateMagazine(id, groupId, userId, userFullname, name, publishNumber, publishYear, fileId, distributedDate, serviceContext);
			} 
			else {
				MagazineLocalServiceUtil.addMagazine(groupId, userId, userFullname, name, publishNumber, publishYear, fileId, distributedDate, serviceContext);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch(Exception e){
			_log.error(e);
			if (e instanceof FileTypeException || e instanceof FileSizeException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
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
	 
	public void deleteMagazineZone(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		// Kiểm tra có thông tin phụ không, nếu có thì ko xóa
		
		try {
			int id = ParamUtil.getInteger(actionRequest, "id");
			int countContent = MagazineContentLocalServiceUtil.countByMagazineZoneID(id);
			if (countContent > 0){
				SessionErrors.add(actionRequest, NotAloneException.class.getName());
			}
			else{
				MagazineZoneLocalServiceUtil.deleteMagazineZone(id);
			}
		}catch(Exception ex){
			_log.error(ex);
		}
		finally{
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
	}
	
	public void updateMagazineZone(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		InputStream imageStream = null;
		
		try {
			//PortletPreferences preferences = PortletPreferencesFactoryUtil .getPortletSetup(actionRequest);
			//UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userFullname = PortalUtil.getUserName(userId, "Guest");
			String name = ParamUtil.getString(actionRequest, "name");
			int sortOrder = ParamUtil.getInteger(actionRequest, "sortOrder");
			int magazineID = ParamUtil.getInteger(actionRequest, "magazineID");
			int id = ParamUtil.getInteger(actionRequest, "id");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Magazine.class.getName(), actionRequest);
			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			if (id > 0) {
				MagazineZoneLocalServiceUtil.updateMagazineZone(id, groupId, userId, userFullname, magazineID, name, sortOrder, serviceContext);
			} 
			else {
				MagazineZoneLocalServiceUtil.addMagazineZone(groupId, userId, userFullname, magazineID, name, sortOrder, serviceContext);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch(Exception e){
			_log.error(e);
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
			
		}
		finally{
			StreamUtil.cleanUp(imageStream);
		}
	}
	 
	public void deleteMagazineContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			int id = ParamUtil.getInteger(actionRequest, "id");
			MagazineContentLocalServiceUtil.deleteMagazineContent(id);
		}catch(Exception ex){
			_log.error(ex);
		}
		finally{
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
	}
	
	public void updateMagazineContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		InputStream imageStream = null;
		
		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userFullname = PortalUtil.getUserName(userId, "Guest");
			String headline = ParamUtil.getString(actionRequest, "headline");
			int sortOrder = ParamUtil.getInteger(actionRequest, "sortOrder");
			int magazineID = ParamUtil.getInteger(actionRequest, "magazineID");
			int magazineZoneID = ParamUtil.getInteger(actionRequest, "magazineZoneID");
			String body = ParamUtil.getString(actionRequest, "body");
			String author = ParamUtil.getString(actionRequest, "author");
			String jobtitle = ParamUtil.getString(actionRequest, "jobtitle");
			int id = ParamUtil.getInteger(actionRequest, "id");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Magazine.class.getName(), actionRequest);
			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			if (id > 0) {
				MagazineContentLocalServiceUtil.updateMagazineContent(id, groupId, userId, userFullname, magazineID, magazineZoneID, headline, body, author, jobtitle, sortOrder, serviceContext);
			} 
			else {
				MagazineContentLocalServiceUtil.addMagazineContent(groupId, userId, userFullname, magazineID, magazineZoneID, headline, body, author, jobtitle, sortOrder, serviceContext);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch(Exception e){
			_log.error(e);
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
			
		}
		finally{
			StreamUtil.cleanUp(imageStream);
		}
	}
	public static String getUrlTitle(int id, String title) {
		if (title == null) {
			return String.valueOf(id);
		}

		title = StringUtil.toLowerCase(title.trim());

		if (Validator.isNull(title) || Validator.isNumber(title) ||
			title.equals("rss")) {

			title = String.valueOf(id);
		}
		else {
			title = FriendlyURLNormalizerUtil.normalize(
				title, _friendlyURLPattern);
		}

		return ModelHintsUtil.trimString(
			JournalArticle.class.getName(), "urlTitle", title);
	}
	private static Pattern _friendlyURLPattern = Pattern.compile("[^a-z0-9_-]");
}
