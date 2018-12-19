package com.viettel.portal.survey;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.comments.CommentPortlet;

/**
 * Portlet implementation class SurveyPortlet
 */
public class SurveyPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		try {
			
			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
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
	    	_log.info("Warning: Viettel FAQ Portlet - invalid captcha text!");
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
	private static Log _log = LogFactory.getLog(SurveyPortlet.class.getName());

}
