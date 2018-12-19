<%@page import="com.viettel.portal.banner.permission.BannerPermission"%>
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

<%@ include file="/html/admin/init.jsp" %>

<aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add">
	<c:if test="<%= BannerPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editBannerURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="jspPage" value="/html/admin/edit_banner.jsp" />
			<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
			<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
		</portlet:renderURL>
		<%
			String javascriptHref = "javascript:updateBannerForm('" + editBannerURL.toString() + "')";
		%>
		<aui:nav-item href="<%=javascriptHref%>"
			iconCssClass="icon-file" 
			label='them-moi-banner' />
	</c:if>
</aui:nav-item>

