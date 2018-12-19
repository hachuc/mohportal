package com.viettel.portal.feedback;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.Part;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.File;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.legal_faq.model.Feedback;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;
import com.portal_egov.portlet.legal_faq.permission.LegalFAQEntryPermission;
import com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.service.persistence.FeedbackUtil;
import com.viettel.portal.fileupload.util.FileUploadUtil;

/**
 * Portlet implementation class SurveyPortlet
 */
public class FeedbackPortlet extends MVCPortlet {
	public void addFeedback(ActionRequest actionRequest,ActionResponse actionResponse){
		InputStream imageStream = null;
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			String userName = PortalUtil.getUserName(userId, "Guest");
			
			String title = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "title",StringPool.BLANK));
			
			String summary = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "summary",StringPool.BLANK));
			
			String body = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "body",StringPool.BLANK));
			
			String fullName = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "fullName",StringPool.BLANK));

			String workFor = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "workFor",StringPool.BLANK));
			String phone = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "phone",StringPool.BLANK));
			String email = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "email",StringPool.BLANK));
			String address = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "address",StringPool.BLANK));
			String visitorIp = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "visitorIp",StringPool.BLANK));
			imageStream = uploadPortletRequest.getFileAsStream("fileUpload");
			
			long fileId = 0;
			String fileURL = "";
			String fileName = uploadPortletRequest.getFileName("fileUpload");
			if(imageStream != null){
				byte[] imageFileBytes = FileUtil.getBytes(imageStream);
				String imageFileName = uploadPortletRequest.getFileName("fileUpload");
					String friendlyFileName = FileUploadUtil.getFriendlyFileName(imageFileName);
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
					//fileURL = imageFile.getFolder();
			}else {
				fileId = ParamUtil.getInteger(actionRequest, "fileId");
				fileURL = ParamUtil.getString(actionRequest, "fileURL");
			}
			
			
			//String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			//Date now = new Date();
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Feedback.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {LegalFAQEntryPermission.VIEW});
			serviceContext.setGuestPermissions(new String[] {LegalFAQEntryPermission.VIEW});
			
//			feedback.setFullName(fullName);
			//= FeedbackLocalServiceUtil.addFeedback(feedback);
			
			if(checkCaptcha(actionRequest)){
				
				long feedbackId = CounterLocalServiceUtil.increment();
				Feedback feedback = FeedbackLocalServiceUtil.createFeedback(feedbackId);
				feedback.setCompanyId(companyId);
				feedback.setGroupId(groupId);
				feedback.setUserId(userId);
				feedback.setUserName(userName);
				feedback.setTitle(title);
				feedback.setSummary(summary);
				feedback.setBody(body);
				feedback.setFullName(fullName);
				feedback.setWorkFor(workFor);
				feedback.setPhone(phone);
				feedback.setEmail(email);
				feedback.setAddress(address);
				feedback.setCreateDate(new Date());
				feedback.setFileId(fileId);
				feedback.setFileName(fileName);
				feedback.setFileURL(fileURL);
				feedback.setIpAddress(visitorIp);
				FeedbackLocalServiceUtil.addFeedback(feedback);
				/*LegalFAQEntry faqEntry =  LegalFAQEntryLocalServiceUtil.addFAQEntry(companyId, groupId, userId, categoryId, citizenName,
					citizenPhone, citizenEmail, now, askTitle, askContent, now, StringPool.BLANK, 0,
					LegalFAQConstants.LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE, LegalFAQConstants.LEGAL_FAQ_ENTRY_DEFAULT_STATUS_VALUE, serviceContext);
				
				String emailContent = FAQEmailUtil.buildFAQEmailContent(faqEntry);
				
				FAQEmailUtil.sendMail(emailContent);*/
				
				SessionMessages.add(actionRequest, "give-ask-success");
				
			}else{
				SessionErrors.add(actionRequest, "invalid-captcha");
			}
			
			//actionResponse.sendRedirect(redirectURL);
			
		}catch(Exception e){
			SessionErrors.add(actionRequest, "give-ask-unsuccess");
			_log.error(e);
		}
	}
	
	public void deleteFeedback(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			long feedbackId = ParamUtil.getLong(actionRequest, "feedbackId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(feedbackId > 0){
				
				FeedbackLocalServiceUtil.deleteFeedback(feedbackId);
				SessionMessages.add(actionRequest, "Xóa thành công");
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
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
	
	
	private static Log _log = LogFactory.getLog(FeedbackPortlet.class.getName());

}
