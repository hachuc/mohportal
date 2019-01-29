<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.revotech.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.videolibrary.model.VLCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/init.jsp" %>
<div class="category-update-form">
	<liferay-ui:success key="category-saved-successfully" message="category-saved-successfully" />

	
	<portlet:actionURL name="migrateVideo" var="updateVLVideoURL">
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>" />
	</portlet:actionURL>
	<portlet:actionURL name="migrateCategory" var="updateVLCategoryURL">
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>" />
	</portlet:actionURL>
	<aui:button name="migateCategory" value="migrate-category" href="<%= updateVLCategoryURL %>" />
	<aui:button name="migateVideo" value="migrate-video" href="<%= updateVLVideoURL %>" />
</div>
