<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/init.jsp"%>

<%
	long parentFolderId = ParamUtil.getLong(request, "parentFolderId");

	String redirect = ParamUtil.getString(request, "redirect",PortalUtil.getCurrentURL(request));
	
	String portletInstanceName = ParamUtil.getString(request, "portletResource");
	
	List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
%>

<liferay-portlet:actionURL var="addImageFolderActionURL" name="addImageFolder" portletName="<%=portletInstanceName %>">
	<liferay-portlet:param  name="redirect" value="<%=redirect%>"/>
</liferay-portlet:actionURL>



<aui:script>
	AUI().ready(function(A){
					
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</aui:script>