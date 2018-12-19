package com.viettel.portal.links.action;

import java.io.IOException;
import java.io.InputStream;
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
import com.viettel.portal.links.DuplicateCategoryNameException;
import com.viettel.portal.links.model.LCategory;
import com.viettel.portal.links.model.VLink;
import com.viettel.portal.links.service.LCategoryLocalServiceUtil;
import com.viettel.portal.links.service.VLinkLocalServiceUtil;

/**
 * Portlet implementation class AdminLinksPortlet
 */
public class AdminLinksPortlet extends MVCPortlet {
	public void updateLCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			// long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long groupId = ParamUtil.getLong(actionRequest, "groupId");
			String userName = PortalUtil.getUserName(userId, "Guest");
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);
			String categoryName = ParamUtil.getString(actionRequest, "categoryName");
			boolean isActive = ParamUtil.getBoolean(actionRequest, "isActive");
			int corder = ParamUtil.getInteger(actionRequest, "corder");
			String redirectURL = ParamUtil.getString(actionRequest,"redirectURL");
			List<LCategory> categories = LCategoryLocalServiceUtil.findByCategoryName(categoryName, groupId);
			if (Validator.isNotNull(categoryId)) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(LCategory.class.getName(), actionRequest);
				LCategory category = null;
				if (categoryId > 0) {
					category = LCategoryLocalServiceUtil.getLCategory(categoryId);
				}

				if (Validator.isNotNull(category)) {
					if (categories != null && !categories.isEmpty() && !category.getCategoryName().equals(categoryName)) {
						throw new DuplicateCategoryNameException();
					}
					LCategoryLocalServiceUtil.updateCategory(categoryId, companyId,
							groupId, userId, userName, categoryName, isActive,corder,
							serviceContext);
				}
			} else {
				if (categories != null && !categories.isEmpty()) {
					throw new DuplicateCategoryNameException();
				}
				ServiceContext serviceContext = ServiceContextFactory.getInstance(LCategory.class.getName(), actionRequest);
				serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
				LCategoryLocalServiceUtil.addCategory(companyId, groupId,
						userId, userName, categoryName, isActive,corder,
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

	public void deleteCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		// long groupId = PortalUtil.getScopeGroupId(actionRequest);
		long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		LCategory category = null;
		if (categoryId > 0) {
			category = LCategoryLocalServiceUtil.getLCategory(categoryId);
		}
		if (Validator.isNotNull(category)) {
			LCategoryLocalServiceUtil.deleteLCategory(category);
		}
		
		if (Validator.isNotNull(redirectURL)) {
			try {
				actionResponse.sendRedirect(redirectURL);
			} catch (IOException e) {
				_log.warn(e);
			}
		}
	}

	public void updateVLink(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		_log.info("VIETTEL PORTAL: UPDATE CONTACT");
		try {
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			String linkName = ParamUtil.getString(actionRequest, "linkName");
			String url = ParamUtil.getString(actionRequest, "url");
			Integer corder = ParamUtil.getInteger(actionRequest, "corder");
			Long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
			
			long id = ParamUtil.getLong(actionRequest, "id");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(LCategory.class.getName(), actionRequest);
			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			if (id > 0) {
				VLinkLocalServiceUtil.updateLink(id, companyId,
						groupId, userId, userName, categoryId, linkName,url, corder, serviceContext);
			} 
			else {
				VLinkLocalServiceUtil.addLink(companyId,
						groupId, userId, userName, categoryId, linkName,url, corder, serviceContext);
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
	
	/**
	 * Xóa vcontact
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void deleteVLink(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			// long groupId = ParamUtil.getLong(actionRequest, "groupId");
			if (id > 0) {
				VLink vcontact = VLinkLocalServiceUtil.getVLink(id);
				VLinkLocalServiceUtil.deleteVLink(id);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
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
			.getLog(AdminLinksPortlet.class);
}
