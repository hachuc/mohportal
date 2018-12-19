package com.viettel.portal.vbpq.admin.action;

import java.io.InputStream;

import javax.portlet.ActionRequest;

import com.viettel.portal.vbpq.model.VanBanPhapQuy;
import com.viettel.portal.vbpq.service.AttachFileLocalServiceUtil;
import com.viettel.portal.vbpq.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.PwdGenerator;

public class AttachFileAction {

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @param vanBan
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void updateAttachFile(ActionRequest actionRequest,
			VanBanPhapQuy vanBan) throws PortalException, SystemException {
		
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);

		FileEntry fileEntry = null;

		long id = ParamUtil.getLong(uploadPortletRequest, "id");

		try {
			fileEntry = updateFileEntry(actionRequest);
		} catch (Exception e) {
			_log.error(e);
		}

		if (Validator.isNotNull(fileEntry)) {
			String fileLink = createLinkFile(fileEntry);

			AttachFileLocalServiceUtil.updateAttachFile(id, vanBan.getId(),
					fileEntry.getFileEntryId(), fileLink);
		}

	}

	/**
	 * @param fileEntry
	 * @return
	 */
	private String createLinkFile(FileEntry fileEntry) {
		String fileLink = StringPool.BLANK;

		StringBuffer sb = new StringBuffer();

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

	/**
	 * @param uploadPortletRequest
	 * @param actionResponse
	 * @return
	 * @throws Exception
	 */
	private FileEntry updateFileEntry(
			ActionRequest actionRequest) throws Exception {
		
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest
				.getAttribute(com.viettel.portal.vbpq.util.WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);

		long fileEntryId = ParamUtil.getLong(uploadPortletRequest,
				"fileEntryId");

		long repositoryId = ParamUtil.getLong(uploadPortletRequest,
				"repositoryId");
		long folderId = ParamUtil.getLong(uploadPortletRequest, "folderId");
		String sourceFileName = uploadPortletRequest.getFileName("file");
		String title = ParamUtil.getString(uploadPortletRequest, "ten")
				+ PwdGenerator.getPassword(6);

		String description = ParamUtil.getString(uploadPortletRequest, "moTa");
		String changeLog = ParamUtil.getString(uploadPortletRequest,
				"changeLog");
		boolean majorVersion = ParamUtil.getBoolean(uploadPortletRequest,
				"majorVersion");

		if (folderId > 0) {
			Folder folder = DLAppLocalServiceUtil.getFolder(folderId);

			if (folder.getGroupId() != themeDisplay.getScopeGroupId()) {
				throw new NoSuchFolderException();
			}
		}

		InputStream inputStream = null;

		try {
			String contentType = uploadPortletRequest.getContentType("file");

			long size = uploadPortletRequest.getSize("file");

			if ((cmd.contentEquals(Constants.ADD) || cmd
					.contentEquals(Constants.UPDATE)) && (size == 0)) {

				contentType = MimeTypesUtil.getContentType(title);
			}

			inputStream = uploadPortletRequest.getFileAsStream("file");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), uploadPortletRequest);

			FileEntry fileEntry = null;

			if (cmd.contentEquals(Constants.ADD)
					|| cmd.contentEquals(Constants.UPDATE)) {

				// Add file entry

				fileEntry = DLAppLocalServiceUtil.addFileEntry(
					serviceContext.getUserId(), repositoryId, folderId,
					sourceFileName, contentType, title, description,
					changeLog, inputStream, size, serviceContext);

			} else {

				// Update file entry

				fileEntry = DLAppLocalServiceUtil.updateFileEntry(
					serviceContext.getUserId(), fileEntryId,
					sourceFileName, contentType, title, description,
					changeLog, majorVersion, inputStream, size,
					serviceContext);
			}

			return fileEntry;
		} catch (Exception e) {
			UploadException uploadException = (UploadException) uploadPortletRequest
					.getAttribute(WebKeys.UPLOAD_EXCEPTION);

			if ((uploadException != null)
					&& uploadException.isExceededSizeLimit()) {

				throw new FileSizeException(uploadException.getCause());
			}

			throw e;
		} finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	private static final Log _log = LogFactoryUtil
			.getLog(AttachFileAction.class);

}
