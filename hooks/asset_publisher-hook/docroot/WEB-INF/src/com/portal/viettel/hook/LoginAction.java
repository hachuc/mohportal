
package com.portal.viettel.hook;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;

import com.liferay.portal.kernel.captcha.Captcha;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {
	
	public void validateCaptcha(ActionRequest actionRequest,
	        ActionResponse actionResponse) throws IOException, PortletException {
	
		try {
            CaptchaUtil.check(actionRequest);
            
        } catch (CaptchaException e) {
 
            SessionErrors.add(actionRequest, "errorMessage");
        }
		
		
	}
	public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
		validateCaptcha(actionRequest, actionResponse);
        originalStrutsPortletAction.processAction(
            originalStrutsPortletAction, portletConfig, actionRequest,
            actionResponse);
    }
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		try {
			
			//CaptchaUtil.check(request);
			User user = PortalUtil.getUser(request);
			if(user != null){
			boolean isAdmin = false;
			List<Role> userRoles = user.getRoles();

			for (Role r : userRoles) {
				if (r.getName().equalsIgnoreCase(RoleConstants.ADMINISTRATOR)) {
					isAdmin = true;
					break;
				}
			}

			if (!isAdmin) {

				LinkedHashMap<String, Object> groupParams = new LinkedHashMap<String, Object>();

				groupParams.put("active", Boolean.TRUE);
				groupParams.put("site", Boolean.TRUE);
				groupParams.put("usersGroups", new Long(user.getUserId()));

				List<Group> mySites = GroupLocalServiceUtil.search(user.getCompanyId(), groupParams, 0, 2);

				if (mySites.size() == 1) {
					response.sendRedirect("/group" + mySites.get(0).getFriendlyURL());
				}
			}
		}
		} catch (Exception e) {
			throw new ActionException("Captcha error");
		}
	}

    public void serveResource(ResourceRequest resourceRequest,
                ResourceResponse resourceResponse)
          throws  IOException, PortletException {

          try {
                CaptchaUtil.serveImage(resourceRequest, resourceResponse);
          }
          catch (Exception e) {
                //_log.error(e);
          }
    }
	
	
	
	private Log _log = LogFactoryUtil.getLog(LoginAction.class);
}
