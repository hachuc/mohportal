package com.viettel.portal.vcms.contenttype;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.vcms.category.CategoryAdminPortlet;
import com.viettel.portal.vcms.model.ContentType;
import com.viettel.portal.vcms.permission.CategoryPermission;
import com.viettel.portal.vcms.service.CategoryLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentTypeLocalServiceUtil;

/**
 * Portlet implementation class ContentTypePortlet
 */
public class ContentTypePortlet extends MVCPortlet {
	public void updateContentType(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			int contentTypeId = ParamUtil.getInteger(actionRequest, "contentTypeId", 0);

			int sortOrder = ParamUtil.getInteger(actionRequest, "sortOrder", 0);
			
			double cost = ParamUtil.getDouble(actionRequest, "cost", 0);

			String typeName = ParamUtil.getString(actionRequest, "name", StringPool.BLANK);

			String typeDesc = ParamUtil.getString(actionRequest, "description", StringPool.BLANK);

			String ridirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(ContentType.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] { CategoryPermission.VIEW });
			serviceContext.setGuestPermissions(new String[] { CategoryPermission.VIEW });
			
			ContentTypeLocalServiceUtil.updateContentType(groupId, companyId, userId, contentTypeId, typeName, typeDesc, sortOrder, cost, serviceContext);

			actionResponse.sendRedirect(ridirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	public void deleteContentType(ActionRequest actionRequest,ActionResponse actionResponse){
		try {
			long contentTypeId = ParamUtil.getLong(actionRequest, "contentTypeId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(contentTypeId > 0){
				
				ContentTypeLocalServiceUtil.deleteContentType(contentTypeId);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	private Log _log = LogFactory.getLog(ContentTypePortlet.class.getName());
}
