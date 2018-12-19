<%@page import="com.viettel.portal.vcms.model.Legal_Zone"%>
<%@page import="com.viettel.portal.vcms.service.Legal_ZoneLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Category"%>
<%@page import="com.viettel.portal.vcms.service.CategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@page import="com.viettel.portal.vcms.permission.CategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/migrate/init.jsp"%>

<%
	String LegalUserID = "LegalUserID";
%>
<liferay-util:include page='<%=templatePath + "tabs.jsp"%>'
	servletContext="<%=application%>" />
	
<portlet:actionURL name="MigrateContent" var="migrateArticleURL">
	<portlet:param name="mvcPath" value='/html/admin/migrate/migrate_articles.jsp' />
</portlet:actionURL>
<aui:form method="post" action="<%=migrateArticleURL %>">
	<aui:input type="hidden" name="redirect" value='<%= currentURL %>' />	
	<aui:row>
		<aui:input type="text" name="prefixUrl" placeholder="http://125.212.226.47:8087" />
		<aui:input type="text" name="expandoUserKey" placeholder="LegalUserID" value="<%= LegalUserID %>" />
	</aui:row>
	<aui:row>
		<button type="submit" class="btn btn-primary">Submit</button>
	</aui:row>
</aui:form>