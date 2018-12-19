<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.viettel.portal.thongke.model.PhongBan"%>
<%@page import="com.viettel.portal.thongke.service.PhongBanLocalServiceUtil"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/phongban/init.jsp"%>

<%
	long id = ParamUtil.getLong(request, "id");
	String name="",descriptions="";
	int order_=0;
    PhongBan phongBan = null;
	if(id > 0){
		try{
			phongBan = PhongBanLocalServiceUtil.getPhongBan(id);
		}
		catch(Exception ex){}
	}
	if(phongBan!=null){
		name=phongBan.getName();
		descriptions=phongBan.getDescriptions();
		order_=phongBan.getOrder_();
	}
	
%>

<div class="phongban-update-form">
			
	<portlet:actionURL name="updatePhongBan" var="updatePhongBanActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</portlet:actionURL>
	
	<aui:form name="fm" enctype="multipart/form-data" method="post" action="<%=updatePhongBanActionURL%>" >
			
		<aui:model-context bean="<%= phongBan %>" model="<%= PhongBan.class %>"/>
		
		<aui:input name="name" label="ten-phongban" type="text" size="255" value="<%=name %>">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="descriptions" label="descriptions" type="textarea" value="<%=descriptions %>"/>
		<aui:input name="order_" label="position-show" type="text" size="10" value="<%=order_ %>">
			<aui:validator name="required" />
			<aui:validator name="number">
				true
			</aui:validator>
		</aui:input>   
        
		<aui:button-row>
			<aui:button type="submit" label="save" value="save"/>
			<aui:button name="closePhongBanUpdateFormBtn" value="cancel" label="cancel"/>
		</aui:button-row>	
	</aui:form>
</div>


<aui:script>
	AUI().ready(function(A){
		
		var closePhongBanUpdateFormBtn = A.one('#<portlet:namespace/>closePhongBanUpdateFormBtn');
        
		if(closePhongBanUpdateFormBtn){
            
			closePhongBanUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
	});
</aui:script>