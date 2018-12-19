package com.viettel.portal.vcms.category;

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
import com.viettel.portal.vcms.model.Category;
import com.viettel.portal.vcms.permission.CategoryPermission;
import com.viettel.portal.vcms.service.CategoryLocalServiceUtil;

/**
 * Portlet implementation class CategoryAdminPortlet
 */
public class CategoryAdminPortlet extends MVCPortlet {
 
	public void updateCategory(ActionRequest actionRequest,ActionResponse actionResponse){		
		
		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			int sortOrder = ParamUtil.getInteger(actionRequest, "sortOrder",0);
			
			String categoryName = ParamUtil.getString(actionRequest, "categoryName",StringPool.BLANK);
			
			String categoryDesc = ParamUtil.getString(actionRequest, "categoryDesc",StringPool.BLANK);
			
			String ridirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Category.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {CategoryPermission.VIEW});
			serviceContext.setGuestPermissions(new String[] {CategoryPermission.VIEW});
			if(categoryId > 0){
				//update FAQ Category
				CategoryLocalServiceUtil.updateCategory(categoryId, companyId, groupId, userId, sortOrder, categoryName, categoryDesc);
			}else{
				//add new FAQ Category
				CategoryLocalServiceUtil.addCategory(companyId, groupId, userId, sortOrder,categoryName, categoryDesc, serviceContext);
			}
			
			actionResponse.sendRedirect(ridirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void deleteCategory(ActionRequest actionRequest,ActionResponse actionResponse){
		try {
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(categoryId > 0){
				
				CategoryLocalServiceUtil.delCategory(categoryId);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	private Log _log = LogFactory.getLog(CategoryAdminPortlet.class.getName());
}
