package com.viettel.portal.hook.action;

import java.util.Enumeration;

import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;

public class CustomLoginAction extends BaseStrutsPortletAction  {
	public static boolean checkCaptcha(PortletRequest request) throws Exception {

		boolean isValidCaptcha = true;

		String enteredCaptchaText = ParamUtil.getString(request, "captchaText");

		PortletSession session = request.getPortletSession();

		String captchaText = getCaptchaValueFromSession(session);

		if (Validator.isNull(captchaText)) {

			isValidCaptcha = false;
		}
		if (!Validator.equals(captchaText, enteredCaptchaText)) {

			isValidCaptcha = false;
			//_log.info("Warning: Legal FAQ Portlet - invalid captcha text!");
		}

		return isValidCaptcha;
	}

	private static String getCaptchaValueFromSession(PortletSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
			String name = atNames.nextElement();
			if (name.contains("CAPTCHA_TEXT")) {
				return (String) session.getAttribute(name);
			}
		}
		return null;
	}	
	public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
		if (!checkCaptcha(actionRequest)) {
			SessionErrors.add(actionRequest, "invalid-captcha");
			// Nếu có param kiểm soát thì tốt hơn
			actionResponse.setWindowState(WindowState.MAXIMIZED);
			return;
		}		
        originalStrutsPortletAction.processAction(
            originalStrutsPortletAction, portletConfig, actionRequest,
            actionResponse);
    }

    public String render(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws Exception {
        System.out.println("Custom Struts Action");
        return originalStrutsPortletAction.render(
            null, portletConfig, renderRequest, renderResponse);

    }

    public void serveResource(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ResourceRequest resourceRequest,
            ResourceResponse resourceResponse)
        throws Exception {

//        originalStrutsPortletAction.serveResource(
//            originalStrutsPortletAction, portletConfig, resourceRequest,
//            resourceResponse);
        try {
            CaptchaUtil.serveImage(resourceRequest, resourceResponse);
	      }
	      catch (Exception e) {
	            //_log.error(e);
	      }

    }
}
