package com.viettel.portal.magazine.archive.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.magazine.archive.action.LatestMagazinePortlet;
import com.viettel.portal.magazine.archive.model.Content;
import com.viettel.portal.magazine.archive.model.Magazine;
import com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil;
import com.viettel.portal.magazine.archive.service.MagazineLocalServiceUtil;

/**
 * Portlet implementation class ArchivePortletAdmin
 */
public class ArchivePortletAdmin extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub
		String method = ParamUtil.getString(resourceRequest, "method", null);
		if (Validator.isNotNull(method)) {
			if (method.equals("getMagazineByYear")) {
				getMagazineByYear(resourceRequest, resourceResponse);
			} 
		}
	}
	public void updateContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			// long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long groupId = ParamUtil.getLong(actionRequest, "groupId");
			String userName = PortalUtil.getUserName(userId, "Guest");

			int contentId = ParamUtil
					.getInteger(actionRequest, "contentId", 0);

			String subject = ParamUtil.getString(actionRequest,
					"Subject");
			String author = ParamUtil.getString(actionRequest,
					"Author");
			String authoTitle = ParamUtil.getString(actionRequest,
					"AuthoTitle");
			String fileUrl = ParamUtil.getString(actionRequest,
					"FileUrl");
			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(contentId)) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Content.class.getName(), actionRequest);

				Content content = null;

				if (contentId > 0) {
					content = ContentLocalServiceUtil.getContent(contentId);
					content.setSubject(subject);
					content.setAuthor(author);
					content.setAuthorTitle(authoTitle);
					content.setFileUrl(fileUrl);
				}

				if (Validator.isNotNull(content)) {

					ContentLocalServiceUtil.updateContent(content);

				}
			} else {
				SessionErrors.add(actionRequest, "save-failed");
				return;

			}

			SessionMessages.add(actionRequest, "content-saved-successfully");

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
	private void getMagazineByYear(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		try {
			resourceResponse.setContentType("text/html");
			PrintWriter writer = resourceResponse.getWriter();
			int PublishYear = ParamUtil.getInteger(resourceRequest, "PublishYear", 2010);

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
					.forClass(Magazine.class);
			dynamicQuery.add(RestrictionsFactoryUtil.eq("PublishYear", PublishYear));
			List<Magazine> ls = MagazineLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (ls != null) {
				String jsonString = "[";
				for (int i = 0; i < ls.size(); i++) {
					jsonString += "{ \"id\":" + ls.get(i).getID()
							+ ", \"name\": \"" + ls.get(i).getName() + "\" }";
					if (i + 1 < ls.size())
						jsonString += ",";
				}
				jsonString += "]";
				JSONArray array = JSONFactoryUtil.createJSONArray(jsonString);
				writer.print(array.toString());
			}

			writer.flush();
			writer.close();
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(ArchivePortletAdmin.class);

}
