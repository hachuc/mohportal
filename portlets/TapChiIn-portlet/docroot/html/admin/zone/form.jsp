<%@page import="com.viettel.portal.magazine.service.*"%>
<%@page import="com.viettel.portal.magazine.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.viettel.portal.magazine.FileTypeException" %>
<%@page import="com.viettel.portal.magazine.FileSizeException" %>
<%@page import="com.viettel.portal.magazine.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	int id = ParamUtil.getInteger(request, "id");
	int magazineId = ParamUtil.getInteger(request, "magazineId");
	MagazineZone mz = null;
	if (id > 0){
		mz = MagazineZoneLocalServiceUtil.getMagazineZone(id);
	}
	Magazine magazine = null;
	if(magazineId > 0){
		magazine = MagazineLocalServiceUtil.getMagazine(magazineId);
	}
%>

<div class="magazine-zone-update-form">

	<portlet:actionURL name="updateMagazineZone" var="updateMagazineZoneActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id)%>" />
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
	</portlet:actionURL>

	<aui:form name="fm" enctype="multipart/form-data" method="post"
		action="<%=updateMagazineZoneActionURL%>">
		<aui:model-context bean="<%=mz%>" model="<%=MagazineZone.class%>" />
		<aui:input name="magazineID" type="hidden" value="<%= mz != null ? mz.getMagazineID() : magazineId %>"></aui:input>
		<aui:row>
			<aui:col span="4">
				<b><%= magazine != null ? HtmlUtil.escape( magazine.getName() ) : "" %></b>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<aui:input name="name" label="name" type="text" size="500">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="4">
				<aui:input name="sortOrder" label="sortOrder" type="number" size="10" value='<%= mz != null ? mz.getSortOrder() : "" %>'>
				</aui:input>
			</aui:col>
		</aui:row>

		<aui:button-row>
			<aui:button type="submit" value="save-s" />
			<aui:button name="closeMagazineZoneUpdateFormBtn" value="cancel-c" />
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	AUI().ready( function(A) {
		var closeMagazineZoneUpdateFormBtn = A.one('#<portlet:namespace/>closeMagazineZoneUpdateFormBtn');
		if (closeMagazineZoneUpdateFormBtn) {
			closeMagazineZoneUpdateFormBtn.on('click', function() {
				Liferay.Util.getWindow().destroy();
			});
		}
	});
</aui:script>
	

