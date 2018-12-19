package com.viettel.portal.thongke.action;

import java.io.IOException;
import java.io.InputStream;

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
import com.viettel.portal.thongke.model.PhongBan;
import com.viettel.portal.thongke.service.PhongBanLocalServiceUtil;

/**
 * Portlet implementation class QuanLyPhongBan
 */
public class QuanLyPhongBan extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.render(request, response);
	}
	private final static Log _log = LogFactoryUtil
			.getLog(QuanLyPhongBan.class);
	public void updatePhongBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			long companyId = PortalUtil.getCompanyId(uploadPortletRequest);
			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);
			long userId = PortalUtil.getUserId(uploadPortletRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			
			String name = ParamUtil.getString(uploadPortletRequest, "name");
			String descriptions = ParamUtil.getString(uploadPortletRequest, "descriptions");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(PhongBan.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			long phongBanId = ParamUtil.getLong(actionRequest, "id");
			
			int order_ = ParamUtil.getInteger(actionRequest, "order_");
			boolean status = ParamUtil.getBoolean(actionRequest, "status", true);
			if (phongBanId > 0) {
				PhongBanLocalServiceUtil.updatePhongBan(phongBanId,companyId,
						groupId, userId, userName, name,descriptions,order_,status,	serviceContext);
			} 
			else {
				PhongBanLocalServiceUtil.addPhongBan(companyId,	groupId, userId, userName, name,descriptions,order_,status,
						 serviceContext);
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch(Exception e){
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
			
		}
		
	}
	public void deletePhongBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException, PortalException{
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			if (id > 0) {
				PhongBan phongBan = PhongBanLocalServiceUtil.getPhongBan(id);
				if (phongBan != null) {
					PhongBanLocalServiceUtil.deletePhongBan(phongBan);
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

}
