<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="/html/admin/init.jsp" %>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","contenttype");
	String tabNames = "contenttype,contenttypecost";
%>

<liferay-portlet:renderURL var="adminURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/cost/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=adminURL%>">
	<c:if test='<%=Validator.equals(tabs1, "contenttype") %>'>
	    <liferay-util:include page="/html/admin/cost/tabs/contenttype.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=Validator.equals(tabs1, "contenttypecost") %>'>
	    <liferay-util:include page="/html/admin/cost/tabs/contenttypecost.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>

