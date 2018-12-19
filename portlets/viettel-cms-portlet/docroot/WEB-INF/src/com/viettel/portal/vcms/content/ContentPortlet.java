package com.viettel.portal.vcms.content;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.ContentDetail;
import com.viettel.portal.vcms.service.ContentLocalServiceUtil;
import com.viettel.portal.vcms.util.CmsConstants;
import com.viettel.portal.vcms.util.CmsUtil;

/**
 * Portlet implementation class ContentPortlet
 */
public class ContentPortlet extends MVCPortlet {
	public void newContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		UploadPortletRequest uploadPortletRequest = null;
		try {
			uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);
			long companyId = PortalUtil.getCompanyId(uploadPortletRequest);
			long userId = PortalUtil.getUserId(uploadPortletRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			InputStream imageStream = null;
			String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);
			String title = ParamUtil.getString(uploadPortletRequest, "title", StringPool.BLANK);
			String subTitle = ParamUtil.getString(uploadPortletRequest, "subTitle", StringPool.BLANK);
			String summary = ParamUtil.getString(uploadPortletRequest, "summary", StringPool.BLANK);
			String subContent = ParamUtil.getString(uploadPortletRequest, "subContent", StringPool.BLANK);
			String content = ParamUtil.getString(uploadPortletRequest, "content", StringPool.BLANK);
			String copyRight = ParamUtil.getString(uploadPortletRequest, "copyRight", StringPool.BLANK);
			String author = ParamUtil.getString(uploadPortletRequest, "author", StringPool.BLANK);
			String jobTitle = ParamUtil.getString(uploadPortletRequest, "jobTitle", StringPool.BLANK);
			long categoryId = ParamUtil.getLong(uploadPortletRequest, "categoryId");
			int newsType = ParamUtil.getInteger(uploadPortletRequest, "newsType");
			
			List<String> errors = new ArrayList<String>();
			String smallImageUrl = StringPool.BLANK;
			String urlTitle = CmsUtil.getFriendlyFileName(title);

			imageStream = uploadPortletRequest.getFileAsStream("smallImage");

			long fileId = 0;
			if (imageStream != null) {
				byte[] imageFileBytes = FileUtil.getBytes(imageStream);
				String imageFileName = uploadPortletRequest
						.getFileName("smallImage");

				String friendlyFileName = CmsUtil
						.getFriendlyFileName(imageFileName);
				String timeStampFileName = friendlyFileName + StringPool.MINUS
						+ String.valueOf(System.nanoTime()) + StringPool.PERIOD
						+ FileUtil.getExtension(imageFileName);
				String mimeType = MimeTypesUtil.getContentType(imageFileName);
				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(FileEntry.class.getName(), actionRequest);
				serviceContext
						.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext
						.setGuestPermissions(new String[] { ActionKeys.VIEW });
				FileEntry imageFile = DLAppServiceUtil.addFileEntry(groupId, 0,
						timeStampFileName, mimeType, timeStampFileName,
						StringPool.BLANK, StringPool.BLANK, imageFileBytes,
						serviceContext);
				fileId = imageFile.getFileEntryId();
				smallImageUrl = createLinkFile(imageFile);				
			} else {
				fileId = ParamUtil.getInteger(actionRequest, "fileId");
			}
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Content.class.getName(), actionRequest);
			ServiceContext serviceDetailContext = ServiceContextFactory.getInstance(
					ContentDetail.class.getName(), actionRequest);
			serviceContext
					.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext
					.setGuestPermissions(new String[] { ActionKeys.VIEW });
			if (validationInput(title, categoryId, content, newsType, errors)){
				if (cmd.equals(Constants.ADD)) {
					Content entryContent = ContentLocalServiceUtil.addContent(
							groupId, companyId, userId, userName,0L, 0L, 0, 1, subTitle,
							title, summary, subContent, content, fileId, smallImageUrl,
							categoryId, copyRight, CmsConstants.ADD_NEWS, userId,
							userName, author, jobTitle, newsType, serviceContext, serviceDetailContext);
				}
			}
			
			for (String error : errors) {
				SessionErrors.add(uploadPortletRequest, error);
			}

		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(uploadPortletRequest, e.getClass().getName());
		}
		sendCustomRedirect(uploadPortletRequest, actionResponse);
	}
	private boolean validationInput(String ten, long categoryId, String content, int newsType, List<String> errors) {

		boolean result = true;
		if (Validator.isNull(ten) || (categoryId <= 0) || (newsType <= 0) || (Validator.isNull(content)))
			result = false;
		if (Validator.isNull(ten)) {
			errors.add("empty-title");
		}
		if(categoryId <= 0){
			errors.add("you-must-choose-category");
		}
		if(newsType <= 0){
			errors.add("you-must-choose-news-type");
		}
		if (Validator.isNull(content)) {
			errors.add("empty-content");
		}
		return result;
	}
	private String createLinkFile(FileEntry fileEntry) {
		String fileLink = StringPool.BLANK;

		StringBuilder sb = new StringBuilder();

		sb.append(StringPool.SLASH);
		sb.append("documents");
		sb.append(StringPool.SLASH);
		sb.append(fileEntry.getRepositoryId());
		sb.append(StringPool.SLASH);
		sb.append(fileEntry.getFolderId());
		sb.append(StringPool.SLASH);
		sb.append(fileEntry.getTitle());
		sb.append(StringPool.SLASH);
		sb.append(fileEntry.getUuid());

		fileLink = sb.toString();

		return fileLink;
	}
	private void sendCustomRedirect(UploadPortletRequest uploadPortletRequest,
			ActionResponse actionResponse) throws IOException {

		if (!SessionErrors.isEmpty(uploadPortletRequest)) {

			SessionMessages
					.add(uploadPortletRequest,
							PortalUtil.getPortletId(uploadPortletRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

		String backURL = ParamUtil.getString(uploadPortletRequest, "backURL");
		if (Validator.isNotNull(backURL)) {
			actionResponse.sendRedirect(backURL);
		}
	}

	private static final Log _log = LogFactory.getLog(ContentPortlet.class);
}
