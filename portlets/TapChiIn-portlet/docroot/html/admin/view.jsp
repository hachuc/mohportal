<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="/html/admin/init.jsp" %>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","admin_magazine");
	String tabNames = "admin_magazine,admin_zone,admin_contents";
%>

<liferay-portlet:renderURL var="adminURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=adminURL%>">
	<c:if test='<%=Validator.equals(tabs1, "admin_magazine") %>'>
	    <liferay-util:include page="/html/admin/tabs/magazine.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=Validator.equals(tabs1, "admin_zone") %>'>
	    <liferay-util:include page="/html/admin/tabs/zone.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=Validator.equals(tabs1, "admin_contents") %>'>
	    <liferay-util:include page="/html/admin/tabs/contents.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>

