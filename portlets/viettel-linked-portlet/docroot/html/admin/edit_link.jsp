<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.viettel.portal.links.service.VLinkLocalServiceUtil"%>
<%@page import="com.viettel.portal.links.model.VLink"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long id = ParamUtil.getLong(request, "id");
	List<DLFolder> folders = new ArrayList<DLFolder>();
	folders = DLFolderLocalServiceUtil.getFolders(scopeGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	VLink ct = null;
	if(id > 0){
		ct = VLinkLocalServiceUtil.getVLink(id);
		selectedCategoryId = ParamUtil.getLong(request, "categoryId", 0L);
	}
	else{
		selectedCategoryId = categoryId;
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateVLink();";
%>

<div class="contact-update-form">		
	<portlet:actionURL name="updateVLink" var="updateVLinkActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</portlet:actionURL>
	
	<aui:form name="fm" enctype="multipart/form-data" method="post" action="<%=updateVLinkActionURL%>" >
			
		<aui:model-context bean="<%= ct %>" model="<%= VLink.class %>"/>
		<aui:input type="hidden" name="categoryId" value="<%=selectedCategoryId %>"/>
		<aui:input name="linkName" label="Tên-linkName" type="text" size="255">
			<aui:validator name="required" />
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
		<aui:input name="url" label="Tên-url" type="text" size="255">
			<aui:validator name="maxLength">2000</aui:validator>
		</aui:input>	
		<aui:input name="corder" label="Vị-trí-hiển-thị" type="text" size="10">
			<aui:validator name="required" />
			<aui:validator name="number">
				true
			</aui:validator>
			<aui:validator name="maxLength">11</aui:validator>
		</aui:input>   
		<span style="font-size: 10px;">
			<liferay-ui:message key="Vị-trí-hiển-thị-ghi-chú" />    
		</span> 
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeLinkUpdateFormBtn" value="cancel"/>
		</aui:button-row>	
	</aui:form>
</div>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />contactThumbnailImageCheckbox','<portlet:namespace />contact-thumbnail-img-container');
</aui:script>

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