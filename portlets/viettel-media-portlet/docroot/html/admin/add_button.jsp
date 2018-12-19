<%@page import="com.viettel.portal.videolibrary.permission.VideoPermission"%>
<%@page import="com.viettel.portal.videolibrary.permission.CategoryPermission"%>
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
	<c:if test="<%= CategoryPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editCategoryURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="jspPage" value="/html/admin/edit_category.jsp" />
			<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
			<portlet:param name="categoryId" value="<%=String.valueOf(0) %>" />
			<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
		</portlet:renderURL>
		<%
			String javascriptHref = "javascript:updateVLCategoryForm('" + editCategoryURL.toString() + "')";
		%>
		<aui:nav-item href="<%=javascriptHref%>"
			iconCssClass="icon-file" 
			label='add-vl-category' />
	</c:if>
	<c:if test="<%= VideoPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editVideoURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="jspPage" value="/html/admin/edit_video.jsp" />
			<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
			<portlet:param name="categoryId" value="<%=String.valueOf(selectedCategoryId) %>" />
			<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
		</portlet:renderURL>
		<%
			String javascriptHref = "javascript:updateVLVideoForm('" + editVideoURL.toString() + "')";
		%>
		<aui:nav-item href="<%=javascriptHref%>"
			iconCssClass="icon-file" 
			label='add-vl-video' />
	</c:if>
</aui:nav-item>

