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

<%@ include file="/html/init.jsp" %>

<%-- <aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add"> --%>
	
	<portlet:renderURL var="editPhongbanURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="jspPage" value="/html/admin/phongban/edit_phongban.jsp" />
		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
	</portlet:renderURL>
	<%
		String javascriptHref = "javascript:updatePhongBanForm('" + editPhongbanURL.toString() + "')";
	%>
	<aui:nav-item href="<%=javascriptHref%>" id="them_moi_phongban"
		iconCssClass="icon-file" 
		label='them-moi-phongban' />
	<style>
	#<portlet:namespace />them_moi_phongban >a{
		text-decoration: underline;
		font-size:16px;
		font-weight: bold !important;
	}
	</style>
<%-- </aui:nav-item> --%>

