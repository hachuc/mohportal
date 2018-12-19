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
	int magazineZoneId = ParamUtil.getInteger(request, "magazineZoneId");
	MagazineContent mc = null;
	
	String body = StringPool.BLANK;
	if (id > 0){
		mc = MagazineContentLocalServiceUtil.getMagazineContent(id);
		body = mc.getBody();
	}
	Magazine magazine = null;
	if(magazineId > 0){
		magazine = MagazineLocalServiceUtil.getMagazine(magazineId);
	}
	List<MagazineZone> zones = MagazineZoneLocalServiceUtil.findByMagazineID(magazineId, 0, Integer.MAX_VALUE);
%>
<style>
	.magazine-zone-update-form .form-group input[type="text"]{
		width: 95%;
	}
	.magazine-zone-update-form .form-group h3 .label{
		font-size: 16px;
	}
</style>
<div class="magazine-zone-update-form col-md-12 clearfix">

	<portlet:actionURL name="updateMagazineContent" var="updateMagazineContentActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id)%>" />
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
	</portlet:actionURL>

	<aui:form name="fm" enctype="multipart/form-data" method="post"
		action="<%=updateMagazineContentActionURL%>" cssClass="magazine-form form-horizontal">
		<aui:model-context bean="<%=mc%>" model="<%=MagazineContent.class%>" />
		<aui:input name="magazineID" type="hidden" value="<%= mc != null ? mc.getMagazineID() : magazineId %>"></aui:input>
		<div class="form-group">
			<h3><label class="label" for="<portlet:namespace />categoryName"><%= magazine != null ? HtmlUtil.escape(magazine.getName()) : "" %></label></h3>
		</div>
		<div class="form-group">
		    <label for="<portlet:namespace />headline"><liferay-ui:message key="headline" /></label>
		    <aui:input type="text" name="headline" label="" size="500">
		    	<aui:validator name="required">true</aui:validator>
		    </aui:input>
		</div>
		<div class="form-group">
		    <label for="<portlet:namespace />magazineZoneID"><liferay-ui:message key="magazineZoneID" /></label>
		    <aui:select name="magazineZoneID" id="magazineZoneID" label="" showEmptyOption="false">
				<%
				for(MagazineZone mz : zones){
					%>
					<aui:option value="<%= mz.getID() %>" label="<%= HtmlUtil.escape(mz.getName()) %>" selected="<%= mz.getID() == magazineZoneId %>"></aui:option>
					<%
				}
				%>
			</aui:select>
		</div>
		<div class="form-group">
		    <label><liferay-ui:message key="admin_contents" /></label>
		    <liferay-ui:input-editor name="body" width="100%" initMethod="initBody" height="400px" toolbarSet="liferayArticle" />
		</div>
		<div class="form-group">
		    <label for="<portlet:namespace />author"><liferay-ui:message key="author" /></label>
		    <aui:input type="text" name="author" label="" size="500">
		    	<aui:validator name="maxLength">150</aui:validator>
		    </aui:input>
		</div>
		<div class="form-group">
		    <label for="<portlet:namespace />jobtitle"><liferay-ui:message key="jobtitle" /></label>
		    <aui:input type="text" name="jobtitle" label="" size="500">
		    	<aui:validator name="maxLength">250</aui:validator>
		    </aui:input>
		</div>
		<div class="form-group">
		    <label for="<portlet:namespace />sortOrder"><liferay-ui:message key="sortOrder" /></label>
		    <aui:input type="number" name="sortOrder" label="" size="10" value='<%= mc != null ? mc.getSortOrder() : "" %>'>
		    	<aui:validator name="maxLength">11</aui:validator>
		    </aui:input>
		</div>

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
	function <portlet:namespace />initBody(){
		return "<%= UnicodeFormatter.toString(body) %>";
	}
</aui:script>
	

