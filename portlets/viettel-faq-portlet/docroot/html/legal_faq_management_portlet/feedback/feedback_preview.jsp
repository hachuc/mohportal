<%@page import="com.viettel.portal.fileupload.util.FileUploadUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.Feedback"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style type="text/css">
	.faq-entry-preview{
		font-size: 12px;
		padding: 0px;
		margin: 0px;
	}
	
	.faq-entry-preview .faq-entry-title{
		font-size: 18px;
		color: #00528b;
		padding: 10px 0px;
		font-weight: bold;
		text-align: center;
		text-decoration: underline;
	}
	
	.faq-entry-preview .faq-entry-content{
		color: #434343;
		text-align: justify;
	}
		
	.faq-entry-preview .faq-entry-content table{
		
		border-collapse: collapse;
		width: 100%;
	}	
	
	.faq-entry-preview .faq-entry-content table tr{
		border-bottom: 1px dotted #E4E4E4;
		height: 35px;
	}
				
	.faq-entry-preview .faq-entry-content table tr td{
		padding: 5px 0px;
	}
			
	.faq-entry-preview .faq-entry-content table tr td:first-child{
		color: #00528B;
		min-width: 120px;
		font-weight: bold;
	}
</style>

<%@include file="/html/init.jsp"%>

<%
	long feedbackId = ParamUtil.getLong(request, "feedbackId",0L);
	String fileAttachUrl ="";
	Feedback feedback = null;
	
	
	if(feedbackId > 0){
		
		feedback = FeedbackLocalServiceUtil.getFeedback(feedbackId);
		if(feedback.getFileId() > 0){
			
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(feedback.getFileId());
					
			if(fileEntry != null){
						
				fileAttachUrl = FileUploadUtil.getFilePreviewURL(themeDisplay, fileEntry);
			}
		}
	}
%>


<c:choose>
<c:when test="<%=feedback != null %>">
		<div class="faq-entry-preview">
			<div class="faq-entry-title">
				<span><%=feedback.getTitle() %></span>
			</div>
			<div class="faq-entry-content">
				<table>
																		
					
					<tr>			
						<td><liferay-ui:message key="Người gửi"/></td>
						<td><%=feedback.getFullName() %></td>
					</tr>
						
						<tr>			
							<td><liferay-ui:message key="phone-numbers"/></td>
							<td><%=feedback.getPhone() %></td>
						</tr>
					
						<tr>			
							<td><liferay-ui:message key="Email"/></td>
							<td><%=feedback.getEmail() %></td>
						</tr>
						<tr>			
							<td><liferay-ui:message key="Địa chỉ"/></td>
							<td><%=feedback.getAddress() %></td>
						</tr>
									
					<tr>			
						<td><liferay-ui:message key="Ngày gửi"/></td>
						<td><%=dateFormat.format(feedback.getCreateDate()) %></td>
					</tr>
																								
					<tr>			
						<td><liferay-ui:message key="Nội dung tóm tắt"/></td>
						<td><liferay-ui:message key="<%=feedback.getSummary() %>"/></td>
					</tr>
					<tr>			
						<td><liferay-ui:message key="Nội dung"/></td>
						<td><liferay-ui:message key="<%=feedback.getBody() %>"/></td>
					</tr>
					
						<tr>			
							<td><liferay-ui:message key="Đơn vị công tác"/></td>
							<td><%=feedback.getWorkFor() %></td>
						</tr>
					
						<tr>			
							<td><liferay-ui:message key="Tài khoản gửi"/></td>
							<td><%=feedback.getUserName() %></td>
						</tr>
						
						<tr>			
							<td><liferay-ui:message key="File đính kèm"/></td>
							<td>
								<a href="<%=fileAttachUrl %>">
									<liferay-ui:message key="<%=feedback.getFileName() %>"/>
								</a>
							</td>
						</tr>
				</table>
			</div>
		</div>
				
		<div class="aui-button-holder">
			<aui:button value="close" name="closePopupBtn"/>
		</div></c:when>
	<c:otherwise>
		<div class="portlet-msg-info">
			<span><liferay-ui:message key="no-such-faq-entry-with-primary-key"/> <%=feedbackId %></span>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		var closePopupBtn = A.one('#<portlet:namespace/>closePopupBtn');
		
		if(closePopupBtn){
			closePopupBtn.on('click',function(){
				var dialog = Liferay.Util.getWindow('<portlet:namespace/>faqPreviewDialog');
				if(dialog){
					dialog.destroy();
				}
			});
		}
		
	});
</script>
