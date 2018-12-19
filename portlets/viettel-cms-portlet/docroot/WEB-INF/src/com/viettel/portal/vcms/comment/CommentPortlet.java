package com.viettel.portal.vcms.comment;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.vcms.model.Comment;
import com.viettel.portal.vcms.model.ContentType;
import com.viettel.portal.vcms.permission.CategoryPermission;
import com.viettel.portal.vcms.service.CommentLocalServiceUtil;

/**
 * Portlet implementation class CommentPortlet
 */
public class CommentPortlet extends MVCPortlet {
	public void onlineComment(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long commentId = ParamUtil.getLong(actionRequest, "commentId",0L);

			boolean visible = ParamUtil.getBoolean(actionRequest, "visible", false);

			String ridirectURL = ParamUtil.getString(actionRequest, "redirect");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(ContentType.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] { CategoryPermission.VIEW });
			serviceContext.setGuestPermissions(new String[] { CategoryPermission.VIEW });
			
			Comment comment = CommentLocalServiceUtil.getComment(commentId);
			if(comment!=null){
				comment.setVisible(!visible);
				CommentLocalServiceUtil.updateComment(comment);
			}

			actionResponse.sendRedirect(ridirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	public void updateComment(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			String userName = PortalUtil.getUserName(userId, "Guest");

			long commentId = ParamUtil.getLong(actionRequest, "commentId",0L);

			boolean visible = ParamUtil.getBoolean(actionRequest, "visible", false);

			String fullName = ParamUtil.getString(actionRequest, "fullName");
			
			String address =  ParamUtil.getString(actionRequest, "address");
			
			String email = ParamUtil.getString(actionRequest, "email");
			
			String content = ParamUtil.getString(actionRequest, "body");
			
			String ridirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(ContentType.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] { CategoryPermission.VIEW });
			serviceContext.setGuestPermissions(new String[] { CategoryPermission.VIEW });
			
			Comment comment = CommentLocalServiceUtil.getComment(commentId);
			if(comment!=null){
				comment.setVisible(visible);
				comment.setFullName(fullName);
				comment.setEmail(email);
				comment.setBody(content);
				comment.setUserId(userId);
				comment.setAddress(address);
				comment.setUserName(userName);
				comment.setModifiedDate(new Date());
				CommentLocalServiceUtil.updateComment(comment);
			}

			actionResponse.sendRedirect(ridirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	public void deleteComment(ActionRequest actionRequest,ActionResponse actionResponse){
		try {
			long commentId = ParamUtil.getLong(actionRequest, "commentId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(commentId > 0){
				
				CommentLocalServiceUtil.deleteComment(commentId);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	private static final Log _log = LogFactory.getLog(CommentPortlet.class);
}