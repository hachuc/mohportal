package com.viettel.portal.vbpq.admin.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.viettel.portal.tthc.service.TTHCAttachFileLocalServiceUtil;
import com.viettel.portal.vbpq.model.AttachFile;
import com.viettel.portal.vbpq.model.VanBanPhapQuy;
import com.viettel.portal.vbpq.service.AttachFileLocalServiceUtil;
import com.viettel.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil;
import com.viettel.portal.vbpq.util.MessageErrors;
import com.viettel.portal.vbpq.util.VanBanPhapQuyUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

public class VanBanPhapQuyAction {

	public static final String ID = "id";
	public static final String GROUP_ID = "groupId";
	public static final String MA_VAN_BAN = "maVanBan";
	public static final String CO_QUAN_BAN_HANH = "coQuanBanHanh";
	public static final String LOAI_VAN_BAN = "loaiVanBan";
	public static final String LINH_VUC_ID = "linhVucVanBan";
	public static final String VAN_BAN_THAY_THE = "vanBanThayThe";
	public static final String TRICH_YEU = "trichYeu";
	public static final String NGUOI_KY = "nguoiKy";
	public static final String NGAY_BAN_HANH = "ngayBanHanh";
	public static final String NGAY_CO_HIEU_LUC = "ngayCoHieuLuc";
	public static final String NGAY_HET_HIEU_LUC = "ngayHetHieuLuc";
	public static final String NEVER_EXPIRE = "neverExpire";
	public static final String STATUS = "status";

	public void deleteVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		long id = ParamUtil.getLong(actionRequest, ID);

		VanBanPhapQuy vanban = VanBanPhapQuyLocalServiceUtil.getVanBan(id);

		if (Validator.isNotNull(vanban)) {
			VanBanPhapQuyLocalServiceUtil.deleteVanBan(vanban);
		}

	}
	
	public void deleteAttachment(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException,
	SystemException {
		long fileId = ParamUtil.getLong(actionRequest, "fileId");
		long attachmentId = ParamUtil.getLong(actionRequest, "attachmentId");
		String backURL = ParamUtil.getString(actionRequest, "backURL");
		System.out.println("--------------fileId------"+fileId);
		System.out.println("--------------attachmentId------"+attachmentId);
		try {

			DLAppServiceUtil.deleteFileEntry(fileId);
			
			
			AttachFileLocalServiceUtil.deleteAttachFile(attachmentId);
			
		} catch (Exception e) {
			_log.error(e);
		} finally {
			if (Validator.isNotNull(backURL)) {
				try {
					actionResponse.sendRedirect(backURL);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void updateStatusVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		ServiceContext context = ServiceContextFactory
				.getInstance(actionRequest);

		long id = ParamUtil.getLong(actionRequest, ID);

		int status = ParamUtil.getInteger(actionRequest, STATUS);

		if (id > 0) {
			VanBanPhapQuyLocalServiceUtil.updateStatusVanBan(id, status,
					context.getUserId());
		}
	}

	/**
	 * Update VanBanPhapQuy
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void updateVanBanPhapQuy(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {

		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);

		DateFormat dateFormat = DateFormatFactoryUtil
				.getSimpleDateFormat("dd/MM/yyyy");

		long id = ParamUtil.getLong(uploadPortletRequest, ID);
		String maVanBan = ParamUtil.getString(uploadPortletRequest, MA_VAN_BAN);

		long coquanbanhanhId = ParamUtil.getLong(uploadPortletRequest,
				CO_QUAN_BAN_HANH);

		long linhvucId = ParamUtil.getLong(uploadPortletRequest, LINH_VUC_ID);

		long loaivanbanId = ParamUtil.getLong(uploadPortletRequest,
				LOAI_VAN_BAN);

//		long vanBanThayThe = ParamUtil.getLong(uploadPortletRequest,
//				VAN_BAN_THAY_THE);
		
		String trichYeu = ParamUtil.getString(uploadPortletRequest, TRICH_YEU);
		String nguoiKy = ParamUtil.getString(uploadPortletRequest, NGUOI_KY);
		Date ngayBanHanh = ParamUtil.getDate(uploadPortletRequest,
				NGAY_BAN_HANH, dateFormat);
		Date ngayCoHieuLuc = ParamUtil.getDate(uploadPortletRequest,
				NGAY_CO_HIEU_LUC, dateFormat);

		boolean neverExpire = ParamUtil.getBoolean(uploadPortletRequest,
				NEVER_EXPIRE);

		Date ngayHetHieuLuc = neverExpire ? null : ParamUtil.getDate(
				uploadPortletRequest, NGAY_HET_HIEU_LUC, dateFormat);

		int status = ParamUtil.getInteger(uploadPortletRequest, STATUS);

		long[] deleteAttachFileIds = ParamUtil.getLongValues(
				uploadPortletRequest, "deleteAttachFileIds");

		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);

		ServiceContext context = ServiceContextFactory
				.getInstance(actionRequest);

		long vanBanFolderId = ParamUtil.getLong(uploadPortletRequest,
				"vanBanFolderId", DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		long nhomVanVanId = ParamUtil.getLong(actionRequest, "nhomVanBanId", 0);

		Map<String, FileItem[]> files = uploadPortletRequest
				.getMultipartParameterMap();

		List<String> errors = new ArrayList<String>();

		boolean valid = validationInput(coquanbanhanhId, loaivanbanId,
				linhvucId, maVanBan, errors);
		
		if (valid && (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE))) {
			try {
				List<FileEntry> fileEntryList = new ArrayList<FileEntry>();

				if (Validator.isNotNull(files)) {

					for (Entry<String, FileItem[]> file2 : files.entrySet()) {

						FileItem item[] = file2.getValue();
						try{
							
							for (FileItem fileItem : item) {
							
								InputStream vanBanFileStream = fileItem
										.getInputStream();

								byte[] vanBanFileBytes = FileUtil
										.getBytes(vanBanFileStream);

								String vanBanFileName = fileItem.getFileName();

								if (VanBanPhapQuyUtils.validateFile(vanBanFileName, vanBanFileBytes)) {
									try {
										
										String timeStampFileName = getVanBanFileName(vanBanFileName);

										String mimeType = MimeTypesUtil.getContentType(vanBanFileName);

										context.setAddGroupPermissions(true);
										context.setAddGuestPermissions(true);
										FileEntry fileEntry = DLAppLocalServiceUtil
												.addFileEntry(context.getUserId(),
														context.getScopeGroupId(),
														vanBanFolderId,
														timeStampFileName, mimeType,
														timeStampFileName,
														StringPool.BLANK,
														StringPool.BLANK,
														vanBanFileBytes, context);

										fileEntryList.add(fileEntry);
									} catch (Exception e) {
										_log.error(e);
									}
									
								}
							}
							
						}catch(Exception e){
							_log.error(e);
						}
					}

				}

				VanBanPhapQuy vanban = VanBanPhapQuyLocalServiceUtil
						.updateVanBanPhapQuy(context.getUserId(),
								context.getScopeGroupId(), id, maVanBan,
								neverExpire, coquanbanhanhId, linhvucId,
								loaivanbanId, ngayBanHanh, ngayCoHieuLuc,
								ngayHetHieuLuc, nguoiKy, trichYeu,
								0, status, nhomVanVanId);

				if (Validator.isNotNull(fileEntryList)) {

					for (FileEntry fileEntry : fileEntryList) {
						String fileLink = createLinkFile(fileEntry);

						AttachFileLocalServiceUtil.updateAttachFile(0,
								vanban.getId(), fileEntry.getFileEntryId(),
								fileLink, fileEntry.getTitle(),
								Long.toString(fileEntry.getSize()));
					}

				}

				// Xoa Van ban attach files
				for (long deleteAttachFileId : deleteAttachFileIds) {
					AttachFileLocalServiceUtil
							.deleteAttachFile(deleteAttachFileId);
				}
			} catch (Exception e) {
				_log.error(e);
			}

		}

		for (String error : errors) {
			SessionErrors.add(actionRequest, error);
		}

		if (!SessionErrors.isEmpty(actionRequest)) {

			String backURL = ParamUtil.getString(uploadPortletRequest,
					"backURL");

			/*
			 * SessionMessages.add( actionRequest,
			 * PortalUtil.getPortletId(actionRequest) +
			 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			 */

			if (Validator.isNotNull(backURL)) {
				actionResponse.sendRedirect(backURL);
			}
		}
	}

	/**
	 * @param coquanbanhanh
	 * @param loaivanban
	 * @param linhvucvanban
	 * @param nguoiKy
	 * @param trichyeu
	 * @param errors
	 * @return
	 */
	private boolean validationInput(long coquanbanhanh, long loaivanban,
			long linhvucvanban, String maVanBan ,List<String> errors) {

		boolean result = true;

		if (Validator.isNull(maVanBan)) {
			errors.add(MessageErrors.EMPTY_TEN_VAN_BAN);
			result = false;
		}

		if (coquanbanhanh == 0) {
			errors.add(MessageErrors.UNCHECK_CO_QUAN_BAN_HANH);
			result = false;

		}
		

		

		if (loaivanban == 0) {
			errors.add(MessageErrors.UNCHECK_LOAI_VAN_BAN);
			result = false;

		}

		if (linhvucvanban == 0) {
			errors.add(MessageErrors.UNCHECK_LINH_VUC_VAN_BAN);
			result = false;

		}

		return result;
	}

	/**
	 * @param fileEntry
	 * @return
	 */
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

	private String getVanBanFileName(String vanBanFileName) {

		Date now = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		StringBuilder sb = new StringBuilder(8);

		sb.append(sdf.format(now));
		sb.append(StringPool.PERIOD);
		sb.append(FileUtil.getExtension(vanBanFileName));

		return sb.toString();
	}

	private static final Log _log = LogFactoryUtil
			.getLog(VanBanPhapQuyAction.class);

}
