<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ include file="/html/view/init.jsp"%>
<%@page import="com.liferay.viettel.portal.counter.ReportCounter" %>
<%@page import="com.liferay.viettel.portal.counter.service.CounterReportLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<ReportCounter> listArticle = CounterReportLocalServiceUtil.counterArticle(categoryId, startDate, endDate, 0, displayItem);
	SimpleDateFormat dfomat = new SimpleDateFormat(" (dd/MM)");
%>
<div class="title-tinnoibat">
	<a href="#" title="Tin nổi bật"><%=HtmlUtil.escape(portletTitle)%></a>
</div>
<ul class="list-news">
	<% for(ReportCounter item : listArticle){ %>
	<li>
	<div class="meta-date">
		<span><%= dfomat.format(item.getPublishDate()) %></span>
	</div>
	<a href="<%= item.getAssetUrl()%>"><%= HtmlUtil.escape(item.getTitle()) %></a></li>
	
	<% } %>
</ul>
