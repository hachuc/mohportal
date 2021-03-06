package com.portal_egov.portlet.legal_faq;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;
import com.portal_egov.portlet.legal_faq.permission.LegalFAQCategoryPermission;
import com.portal_egov.portlet.legal_faq.permission.LegalFAQEntryPermission;
import com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.util.LegalFAQConstants;

/**
 * Portlet implementation class legal_faq_management
 */
public class LegalFAQManagement extends MVCPortlet {
 
	public void updateFAQEntry(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long legalFAQEntryId = ParamUtil.getLong(actionRequest, "legalFAQEntryId",0L);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			//int categoryType = ParamUtil.getInteger(actionRequest, "categoryType",1);

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			String citizenName = ParamUtil.getString(actionRequest, "citizenName",StringPool.BLANK);
			
			String citizenPhone = ParamUtil.getString(actionRequest, "citizenPhone",StringPool.BLANK);
			
			String citizenEmail = ParamUtil.getString(actionRequest, "citizenEmail",StringPool.BLANK);
			
			String askTitle = ParamUtil.getString(actionRequest, "askTitle",StringPool.BLANK);
			
			String askContent = ParamUtil.getString(actionRequest, "askContent",StringPool.BLANK);
			
			String answerContent = ParamUtil.getString(actionRequest, "answerContent",StringPool.BLANK);			
			
			Date askDate = getDatePickerValue(actionRequest, "askDayParam", "askMonthParam", "askYearParam");
			
			Date answerDate = getDatePickerValue(actionRequest, "answerDayParam", "answerMonthParam", "answerYearParam");
			
			int faqEntryPublishStatus = ParamUtil.getInteger(actionRequest, LegalFAQConstants.FAQ_ENTRY_PUBLISH_STATUS
																	,LegalFAQConstants.LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE);
			
			int faqEntryStatus = ParamUtil.getInteger(actionRequest, "status",0);			
			
			
			if(legalFAQEntryId > 0){
				
				//update FAQ Entry
				LegalFAQEntryLocalServiceUtil.updateFAQEntry(legalFAQEntryId, companyId, groupId, userId, categoryId,
					citizenName, citizenPhone, citizenEmail, askDate, askTitle, askContent, answerDate, answerContent,
					faqEntryPublishStatus, faqEntryStatus);
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void deleteFAQEntry(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long legalFAQEntryId = ParamUtil.getLong(actionRequest, "legalFAQEntryId",0L);
			
			if(legalFAQEntryId > 0){
				
				LegalFAQEntryLocalServiceUtil.deleteFAQEntry(legalFAQEntryId);
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	public void deleteFeedback(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			long FeedbackId = ParamUtil.getLong(actionRequest, "FeedbackId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(FeedbackId > 0){
				
				FeedbackLocalServiceUtil.deleteFeedback(FeedbackId);
				SessionMessages.add(actionRequest, "X�a th�nh c�ng");
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	public void updateFAQCategory(ActionRequest actionRequest,ActionResponse actionResponse){		
		
		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			int categoryType = ParamUtil.getInteger(actionRequest, "categoryType",1);
			
			long parentId = ParamUtil.getLong(actionRequest, "parentId",0L);
			
			String categoryName = ParamUtil.getString(actionRequest, "categoryName",StringPool.BLANK);
			
			String categoryDesc = ParamUtil.getString(actionRequest, "categoryDesc",StringPool.BLANK);
			
			String ridirectURL = ParamUtil.getString(actionRequest, "ridirectURL");
			
			if(categoryId > 0){
				
				//update FAQ Category
				LegalFAQCategoryLocalServiceUtil.updateCategory(categoryId, companyId, groupId, categoryType, userId, parentId, categoryName, categoryDesc);
			}else{

				ServiceContext serviceContext = ServiceContextFactory.getInstance(LegalFAQCategory.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {LegalFAQCategoryPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {LegalFAQCategoryPermission.VIEW});
				//add new FAQ Category
				LegalFAQCategoryLocalServiceUtil.addCategory(companyId, groupId, categoryType, userId, parentId, categoryName, categoryDesc, serviceContext);
			}
			
			actionResponse.sendRedirect(ridirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void deleteFAQCategory(ActionRequest actionRequest,ActionResponse actionResponse){
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(categoryId > 0){
				
				List<LegalFAQCategory> childFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByParent(companyId, categoryId);
				
				//update parentId cua cac category con
				for(LegalFAQCategory childCategory : childFAQCategoryList){
					
					childCategory.setParentId(0);
					LegalFAQCategoryLocalServiceUtil.updateLegalFAQCategory(childCategory);
				}
				
				List<LegalFAQEntry> faqEntryList = LegalFAQEntryLocalServiceUtil.findByCategory(companyId, categoryId);
				
				//update categoryId cua cac FAQ Entry
				for(LegalFAQEntry faqEntry : faqEntryList){
					
					faqEntry.setCategoryId(0);
					
					LegalFAQEntryLocalServiceUtil.updateLegalFAQEntry(faqEntry);
				}
				
				LegalFAQCategoryLocalServiceUtil.deleteCategory(categoryId);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void updateFAQSettings(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			boolean autoSendEmail = ParamUtil.getBoolean(actionRequest, "autoSendEmail", true);
			
			preferences.setValue("autoSendEmail", String.valueOf(autoSendEmail));
			
			if(autoSendEmail){
				
				String fromEmailName = ParamUtil.getString(actionRequest, "fromEmailName");
				String fromEmailAddress = ParamUtil.getString(actionRequest, "fromEmailAddress");
				
				String toEmailAddress = ParamUtil.getString(actionRequest, "toEmailAddress");
				String emailSubject = ParamUtil.getString(actionRequest, "emailSubject");
				
				preferences.setValue("fromEmailName", fromEmailName);
				preferences.setValue("fromEmailAddress", fromEmailAddress);
				preferences.setValue("toEmailAddress", toEmailAddress);
				preferences.setValue("emailSubject", emailSubject);
			}
			
			preferences.store();
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	/**
	 * @todo LAY GIA TRI TU DATE PICKER TREN FORM UPDATE
	 * @author ChucHV	
	 * @date Aug 16, 2012
	 * @return Date
	 * @param actionRequest
	 * @param dayParam
	 * @param monthParam
	 * @param yearParam
	 * @return
	 */
	private static Date getDatePickerValue(ActionRequest actionRequest,String dayParam,String monthParam,String yearParam){
		
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		
		try {
			//ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute( WebKeys.THEME_DISPLAY);

			int dayValue = ParamUtil.getInteger(actionRequest, dayParam,calendar.get(Calendar.DATE));
			
			int monthValue = ParamUtil.getInteger(actionRequest, monthParam,calendar.get(Calendar.MONTH));
			
			int yearValue = ParamUtil.getInteger(actionRequest, yearParam,calendar.get(Calendar.YEAR));
			
			Date datePickerValue = PortalUtil.getDate(monthValue, dayValue, yearValue, PortalException.class);//, themeDisplay.getTimeZone()
			
			//System.err.println("themeDisplay.getTimeZone() -> " + themeDisplay.getTimeZone() + " dayValue -> " + dayValue + " monthValue -> " + monthValue + " yearValue -> " + yearValue + " datePickerValue -> " + datePickerValue.toString());
			
			return datePickerValue;
		}
		catch (Exception e) {
			return calendar.getTime();
		}
	}
	
	private Log _log = LogFactory.getLog(LegalFAQManagement.class.getName());
}
