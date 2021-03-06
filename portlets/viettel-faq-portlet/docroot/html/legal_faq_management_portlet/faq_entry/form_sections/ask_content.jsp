<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int yearRange = 20;

	long legalFAQEntryId = ParamUtil.getLong(request, "legalFAQEntryId",0L);

	long faqCategoryId = 0L;
	
	String askContent = "";
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date askDate = calendar.getTime();
	
	LegalFAQEntry legalFAQEntry = null;
	
	if(legalFAQEntryId > 0){
		
		legalFAQEntry = LegalFAQEntryLocalServiceUtil.getEntry(legalFAQEntryId);
		
		if(legalFAQEntry != null){
			
			faqCategoryId = legalFAQEntry.getCategoryId();
			askDate = legalFAQEntry.getAskDate();
			askContent = legalFAQEntry.getAskContent();
		}
	}
	
	List<LegalFAQCategory> faqCategoryList = LegalFAQCategoryLocalServiceUtil.findByGroup(scopeGroupId);
%>


	<h3><liferay-ui:message key="ask-user-information" /></h3>
		
	<aui:input type="text" name="citizenName" label="sender-name" value='<%= (legalFAQEntry != null) ? legalFAQEntry.getCitizenName() : ""%>'>
		<aui:validator name="required"/>
	</aui:input>
			
	<aui:input type="text" name="citizenPhone" label="content-title" value='<%= (legalFAQEntry != null) ? legalFAQEntry.getCitizenPhone() : ""%>'/>
				
	<aui:input type="text" name="citizenEmail" label="email-address" value='<%= (legalFAQEntry != null) ? legalFAQEntry.getCitizenEmail() : ""%>'>
		<aui:validator name="required"/>
	</aui:input>	
		
	<aui:input type="text" name="askTitle" value='<%= (legalFAQEntry != null) ? legalFAQEntry.getAskTitle() : ""%>' label="ask-address" >
		<aui:validator name="required"/>
	</aui:input>
	
	<div class="lfr-form-row">
		<span style="display: block;"><liferay-ui:message key="ask-date"/></span>
		
		<div class="date-picker">
			<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />askDatePicker">
				<input type="hidden" name="askDate" id="<portlet:namespace />askDate" size="30" />
			</div>
			
			<liferay-ui:input-date
					disabled="<%= false %>"
					dayValue="<%=askDate.getDate() %>" dayParam="askDayParam" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
					monthValue="<%=askDate.getMonth() %>" monthParam="askMonthParam" 
					yearValue="<%=askDate.getYear() + 1900 %>" yearParam="askYearParam" 
			/>
		</div>
	</div>
	
	<aui:input type="textarea" name="askContent" value='<%= (legalFAQEntry != null) ? legalFAQEntry.getAskContent() : ""%>' label="ask-content" >
		<aui:validator name="required"/>
	</aui:input>
	
	<aui:select name="status" label="Status">
		<aui:option value="0" label="do-not-show" selected="<%= legalFAQEntry.getStatus() == 0 %>"></aui:option>
		<aui:option value="1" label="show" selected="<%= legalFAQEntry.getStatus() == 1 %>"></aui:option>
	</aui:select>