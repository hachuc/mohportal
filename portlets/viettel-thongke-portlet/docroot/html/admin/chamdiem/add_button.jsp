<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryTypeServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryType"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>

<%@ include file="/html/admin/chamdiem/init.jsp" %>
<%
    String javascriptHref="";
   
    if(menuId==0){
%>
	
	<portlet:renderURL var="editChamDiemPhongBanURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="jspPage" value="/html/admin/chamdiem/edit_chamdiemphongban.jsp" />
		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
		<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>" />
		<portlet:param name="popup" value="1" />
	</portlet:renderURL>
	<%
		javascriptHref = "javascript:updateChamDiemPhongBanForm('" + editChamDiemPhongBanURL.toString() + "')";
	%>
	
<%}else if(menuId==1){ %>	

    <portlet:renderURL var="editChamDiemBaiVietURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="jspPage" value="/html/admin/chamdiem/edit_chamdiembaiviet.jsp" />
		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
		<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>" />
		<portlet:param name="popup" value="1" />
	</portlet:renderURL>
	<%
		javascriptHref = "javascript:updateChamDiemBaiVietForm('" + editChamDiemBaiVietURL.toString() + "')";
	%>
<%}else if(menuId==2){ %>	

    <portlet:renderURL var="editChamDiemBaiVietNgoaiURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="jspPage" value="/html/admin/chamdiem/edit_chamdiembaivietngoai.jsp" />
		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
		<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>" />
		<portlet:param name="popup" value="1" />
	</portlet:renderURL>
	<%
		javascriptHref = "javascript:updateChamDiemBaiVietNgoaiForm('" + editChamDiemBaiVietNgoaiURL.toString() + "')";
	%>
<%} %>
<aui:nav-item href="<%=javascriptHref%>"  id="them_moi_du_lieu"
		iconCssClass="icon-file" 
		label='them-moi-du-lieu' />
<style>
#<portlet:namespace />them_moi_du_lieu >a{
	text-decoration: underline;
	font-size:16px;
	font-weight: bold !important;
}
</style>