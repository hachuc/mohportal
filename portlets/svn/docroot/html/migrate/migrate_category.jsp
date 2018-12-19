<%@page import="com.viettel.portal.vcms.service.Legal_ZoneLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Legal_Zone"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/migrate/init.jsp"%>

<liferay-util:include page='<%=templatePath + "tabs.jsp"%>'
	servletContext="<%=application%>" />


<portlet:actionURL name="MigrateCategory" var="migrateCategoryURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "migrate_category.jsp"%>' />
</portlet:actionURL>

<form method="post" action="<%=migrateCategoryURL%>" name="fm">	
	<aui:input type="hidden" name="redirect" value='<%= currentURL %>' />
	<button type="submit" class="btn btn-primary">Submit</button>
</form>