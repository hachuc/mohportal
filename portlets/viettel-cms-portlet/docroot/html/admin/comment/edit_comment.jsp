<%@page import="com.viettel.portal.vcms.service.CommentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Comment"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/comment/init.jsp"%>

<%
	long commentId = ParamUtil.getLong(request, "commentId");
	Comment cmt = null;
	if(commentId > 0){
		cmt = CommentLocalServiceUtil.getComment(commentId);
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateComment();";
%>

<div class="contact-update-form">		
	<portlet:actionURL name="updateComment" var="updateCommentActionURL">
		<portlet:param name="commentId" value="<%=String.valueOf(commentId) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</portlet:actionURL>
	
	<aui:form name="fm" enctype="multipart/form-data" method="post" action="<%=updateCommentActionURL%>" >
			
		<aui:model-context bean="<%= cmt %>" model="<%= Comment.class %>"/>
		<aui:input name="fullName" label="header-fullname" type="text" size="255">
			<aui:validator name="required" />
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
		<aui:input name="address" label="cmt-address" type="text" size="255">
			<aui:validator name="maxLength">2000</aui:validator>
		</aui:input>
		<aui:input name="email" label="cmt-email" type="text" size="255">
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>
		<aui:input name="visible" type="checkbox" label="cmt-online" checked="<%= cmt.getVisible() %>" />
		<aui:input name="body" label="cmt-body" type="text" size="255">
			<aui:validator name="maxLength">2000</aui:validator>
		</aui:input>
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeLinkUpdateFormBtn" value="cancel"/>
		</aui:button-row>	
	</aui:form>
</div>

<aui:script>
	AUI().ready(function(A){
		
		var closeLinkUpdateFormBtn = A.one('#<portlet:namespace/>closeLinkUpdateFormBtn');
        
		if(closeLinkUpdateFormBtn){
            
			closeLinkUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
	});
</aui:script>