<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.Feedback"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.legal_faq.search.FAQEntrySearch"%>
<%@page import="com.portal_egov.portlet.legal_faq.comparator.FAQStatusComparator"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="com.portal_egov.portlet.legal_faq.permission.LegalFAQEntryPermission"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String portletId = PortalUtil.getPortletId(request);
	
	String emptyResultMessageKey = "no-entry-found";
	//Tu khoa tim kiem
	String searchKeyword = ParamUtil.getString(request, "searchKeyword", StringPool.BLANK);
	
	if(Validator.isNotNull(searchKeyword)){
		
		emptyResultMessageKey = "no-search-result-found";
	}
	
	//String entryCommand = ParamUtil.getString(request, "entryCommand",StringPool.BLANK);
	
	int legalFAQEntryIndex = 0;
	
%>

<liferay-portlet:renderURL varImpl="feedbackURL">
	<portlet:param name="mvcPath" value="/html/legal_faq_management_portlet/management.jsp" />
	<portlet:param name="tabs1" value="Feedback"/>
	<portlet:param name="searchKeyword" value="<%=searchKeyword %>"/>
    <portlet:param name="resetCur" value='true' />
</liferay-portlet:renderURL>
<div class="feedback-list">
<aui:nav-bar cssClass="custom-toolbar">
	<aui:nav-bar-search cssClass="pull-right">
		<liferay-portlet:renderURL var="searchFeedbackURL">
			<liferay-portlet:param name="mvcPath" value="/html/legal_faq_management_portlet/management.jsp" />
			<liferay-portlet:param name="tabs1" value="Feedback"/>
		</liferay-portlet:renderURL>
		<div class="form-search">
			<aui:form action="<%= searchFeedbackURL %>" method="post" name="fm">
				<liferay-ui:input-search id="keywords1" name="searchKeyword" placeholder="Từ khóa"/>
			</aui:form>
		</div>
	</aui:nav-bar-search>
</aui:nav-bar>


	<liferay-ui:search-container delta="20" emptyResultsMessage="<%=emptyResultMessageKey %>" iteratorURL="<%= feedbackURL %>">
		<%
			List<Feedback> feedbacks = FeedbackLocalServiceUtil.findByKeyword(scopeGroupId, searchKeyword, searchContainer.getStart(), searchContainer.getEnd());
			int totalFeedbacks = FeedbackLocalServiceUtil.countFeedbacks(scopeGroupId, searchKeyword);
		%>
		
		<liferay-ui:search-container-results results="<%=feedbacks%>" total="<%=totalFeedbacks %>" />			
		
		<liferay-ui:search-container-row className="Feedback" keyProperty="feedbackId" modelVar="faqEntry" escapedModel="<%=true %>" >
			<%
				StringBundler sb = new StringBundler();

				sb.append("javascript:");
				sb.append("showFeedbackPreviewDialog");
				sb.append("('");
				sb.append(faqEntry.getFeedbackId());
				sb.append("')");

				String	rowHREF = sb.toString();
			%>
																						
			<liferay-ui:search-container-column-text name="#" 
				value="<%=String.valueOf(++legalFAQEntryIndex) %>" 
				href="<%=rowHREF %>"
				/>
			<liferay-ui:search-container-column-text name="Tiêu đề" 
				value="<%= String.valueOf(faqEntry.getTitle())%>" 
				orderable="<%=false %>"
				href="<%=rowHREF %>"
			/>
			<liferay-ui:search-container-column-text name="Tóm tắt nội dung" 
				value="<%=String.valueOf(faqEntry.getSummary()) %>" 
				orderable="<%=false %>"
				href="<%=rowHREF %>"
			/>
			<liferay-ui:search-container-column-text name="Nội dung" 
				value='<%=String.valueOf(faqEntry.getBody().length() > 450 ? faqEntry.getBody().substring(0, 500)+" ..." : faqEntry.getBody()) %>' 
				orderable="<%=false %>"
				href="<%=rowHREF %>"
			/>
			<liferay-ui:search-container-column-text name="Người gửi" 
				value="<%= String.valueOf(faqEntry.getFullName()) %>" 
				orderable="<%=false %>"
				href="<%=rowHREF %>"
				
			/>
			<liferay-ui:search-container-column-text name="Email" 
				value="<%= String.valueOf(faqEntry.getEmail()) %>" 
				orderable="<%=false %>"
				href="<%=rowHREF %>"
			/>
			<liferay-ui:search-container-column-text name="Ngày gửi" 
				value="<%= dateFormat.format(faqEntry.getCreateDate()) %>" 
				orderable="<%=false %>"
				href="<%=rowHREF %>"
			/>
			<liferay-portlet:actionURL  name="deleteFeedback" var="deleteFAQEntryURL">
					<liferay-portlet:param name="feedbackId" value="<%=String.valueOf(faqEntry.getFeedbackId())%>"/>
					<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
				</liferay-portlet:actionURL>
				<liferay-ui:search-container-column-text name="delete" 
				>	
					<liferay-ui:icon-delete url="<%= deleteFAQEntryURL %>" />
				</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
		<%-- <liferay-portlet:renderURLParams varImpl="searchFeedbackURL">
			<liferay-portlet:param name="mvcPath" value="/html/legal_faq_management_portlet/management.jsp" />
			<liferay-portlet:param name="tabs1" value="Feedback"/>
			<liferay-portlet:param name="searchKeyword" value="<%=searchKeyword %>"/>
		    <portlet:param name="resetCur" value='true' />
		</liferay-portlet:renderURLParams> --%>
		
		
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</div>
<aui:script>

	var A = AUI();
	
	AUI().ready('aui-base',function(A){
		
		var faqEntrySearchInput = A.one('#<portlet:namespace/>keywords1');
		
		if(faqEntrySearchInput){
			faqEntrySearchInput.focus();
		}
	});

	Liferay.provide(
		window,
		'showFeedbackPreviewDialog',
		function(feedbackId) {
			
			//A.DialogManager.hideAll();
								
			var faqPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(faqPreviewRenderURL){
				
				faqPreviewRenderURL.setPortletId('<%=portletId %>');
				faqPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				faqPreviewRenderURL.setParameter('jspPage', '/html/legal_faq_management_portlet/feedback/feedback_preview.jsp');
				faqPreviewRenderURL.setParameter('feedbackId', feedbackId);
				faqPreviewRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '#<portlet:namespace/>faqEntryPermissionBtn',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true,
						cache: false,
						after: {
							visibleChange: function(event) {
								location.reload();
							}
                        }
					},
					id: '<portlet:namespace/>faqPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "faq-preview-content") %>',
					uri: faqPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
</aui:script>

<!-- <style>
	.legal_faq_management-portlet.lfr-search-container tr:hover td {
	    background: #d3e8f1;
	    /* border: 1px solid #d3e8f1; */
	}
	.width-7{
		width: 7%;
	}
	.width-30{
		width: 30%;
	}
	.width-13{
		width: 13%;
	}
	.width-15{
		width: 15%;
	}
	.width-10{
		width: 10%;
	}
</style> -->
