package com.viettel.portal.banner.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.banner.BannerFileSizeException;
import com.viettel.portal.banner.BannerFileTypeException;
import com.viettel.portal.banner.model.Banner;
import com.viettel.portal.banner.service.BannerLocalServiceUtil;
import com.viettel.portal.banner.util.BannerFileUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * Portlet implementation class AdminBanner
 */
public class AdminBannerPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.render(request, response);
	}

	private final static Log _log = LogFactoryUtil
			.getLog(AdminBannerPortlet.class);
 
	public void updateBanner(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		_log.info("VIETTEL PORTAL: UPDATE BANNER");
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
			
			String ten = ParamUtil.getString(uploadPortletRequest, "ten");
			_log.info("VIETTEL PORTAL: ten -> " + ten);

			imageStream = uploadPortletRequest.getFileAsStream("bannerFile");
			long fileId = 0;
			long fileSize = 0;
			if(imageStream != null){
				byte[] imageFileBytes = FileUtil.getBytes(imageStream);
				String imageFileName = uploadPortletRequest.getFileName("bannerFile");
				if (BannerFileUtil.validateImageThumbnail(imageFileName, imageFileBytes.length, preferences)) {
					String friendlyFileName = BannerFileUtil.getFriendlyFileName(ten);
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
					_log.info("VIETTEL PORTAL: IMAGE -> " + imageFile.getSize());
				}
			}
			else{
				 fileId = ParamUtil.getInteger(actionRequest, "fileId");;
				 fileSize = ParamUtil.getInteger(actionRequest, "fileSize");;
			}
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Banner.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			long id = ParamUtil.getLong(actionRequest, "id");
			Date ngayKetThuc = null;
			int nktDay = ParamUtil.getInteger(actionRequest, "nktDay");
			int nktMonth = ParamUtil.getInteger(actionRequest, "nktMonth");
			int nktYear = ParamUtil.getInteger(actionRequest, "nktYear");
			String ngayKetThucStr = ParamUtil.getString(actionRequest, "ngayKetThuc");
			if((ngayKetThucStr != null && !ngayKetThucStr.isEmpty()) && nktDay > 0 && nktMonth >= 0 && nktYear > 0){
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.DAY_OF_MONTH, nktDay);
				calendar.set(Calendar.MONTH, nktMonth);
				calendar.set(Calendar.YEAR, nktYear);
				ngayKetThuc = calendar.getTime();
			}
			int order_ = ParamUtil.getInteger(actionRequest, "order_");
			String lienKet = ParamUtil.getString(actionRequest, "lienKet");
			if (id > 0) {
				BannerLocalServiceUtil.updateBanner(id, companyId,
						groupId, userId, userName, ten, ngayKetThuc,order_,lienKet,
						fileId, null, null, fileSize, serviceContext);
			} 
			else {
				BannerLocalServiceUtil.addBanner(companyId,
						groupId, userId, userName, ten, ngayKetThuc,order_,lienKet,
						fileId, null, null, fileSize, serviceContext);
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch(Exception e){
			if (e instanceof BannerFileTypeException || e instanceof BannerFileSizeException) {
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
	 * Xóa banner
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void deleteBanner(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			// long groupId = ParamUtil.getLong(actionRequest, "groupId");
			if (id > 0) {
				Banner banner = BannerLocalServiceUtil.getBanner(id);
				if (banner != null && banner.getFileId() > 0L) {
					FileEntry bannerFile = null;
					try {
						bannerFile = DLAppServiceUtil.getFileEntry(banner.getFileId());
					} catch (Exception e) {}
					
					if(bannerFile != null){
						DLAppServiceUtil.deleteFileEntry(banner.getFileId());
					}
				}

				if (banner != null && banner.getFileId() > 0L) {
					FileEntry bannerImage = null;
					try {
						bannerImage = DLAppServiceUtil.getFileEntry(banner.getFileId());
					} catch (Exception e) {}
					
					if(bannerImage != null){
						DLAppServiceUtil.deleteFileEntry(banner.getFileId());
					}
				}
				BannerLocalServiceUtil.deleteBanner(id);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

}
