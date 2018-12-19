<%@page import="com.liferay.viettel.portal.counter.service.CounterReportLocalServiceUtil"%>
<%@page import="com.liferay.viettel.portal.counter.model.CounterReport"%>
<%@page import="com.liferay.portlet.asset.model.*" %>
<%@page import="com.liferay.portlet.asset.service.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/admin/init.jsp" %>
<% 
	Date now = new Date();
	int startDateDay = ParamUtil.getInteger(request, "startDateDay", 1);
	int startDateMonth = ParamUtil.getInteger(request, "startDateMonth", now.getMonth());
	int startDateYear = ParamUtil.getInteger(request, "startDateYear",  1900 + now.getYear());
	
	int endDateDay = ParamUtil.getInteger(request, "endDateDay", now.getDate() + 1);
	int endDateMonth = ParamUtil.getInteger(request, "endDateMonth", now.getMonth());
	int endDateYear = ParamUtil.getInteger(request, "endDateYear", 1900 + now.getYear());
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date startDate = dateFormat.parse(startDateDay + "/" + (startDateMonth + 1) + "/" + startDateYear);
	Date endDate = dateFormat.parse(endDateDay + "/" + (endDateMonth + 1) + "/" + endDateYear);
	Calendar c = Calendar.getInstance();
	//c.setTime(endDate);
	//c.add(Calendar.DATE, 1);
	//endDate = c.getTime();
%>
<liferay-portlet:renderURL varImpl="reportCategoryURL">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="tabs1" value="admin_visitor"/>
</liferay-portlet:renderURL>

<aui:form action="<%=reportCategoryURL%>" method="post" name="fm" cssClass="form-horizontal">
	<liferay-portlet:renderURLParams varImpl="reportCategoryURL" />
	<div  class="report-row">
		<div class="span3">
			<liferay-ui:message key="report-visitor-start-date"></liferay-ui:message>
	     	<liferay-ui:input-date  name="startDate"
				dayParam="startDateDay" dayValue="<%=startDateDay %>"
				monthParam="startDateMonth" monthValue="<%=startDateMonth %>"
				yearParam="startDateYear" yearValue="<%=startDateYear %>"/>	
		</div>
		<div class="span3">
			<liferay-ui:message key="report-visitor-end-date"></liferay-ui:message>
			<liferay-ui:input-date  name="endDate"
				dayParam="endDateDay" dayValue="<%=endDateDay %>"
				monthParam="endDateMonth" monthValue="<%=endDateMonth %>"
				yearParam="endDateYear" yearValue="<%=endDateYear %>"/>
		</div>
	</div>
	<div class="report-row ">
		<div class="span6" style="text-align: center;margin: 0px !important;">
			<aui:button name="search" type="submit" value="report-visitor" cssClass="btn btn-grey text-bold"/>
		</div>
	</div>
	<div  class="report-row pt10">
		<div class="span6" style="margin: 0px !important;">
			<table class="table table-bordered">
				<thead>
					 <tr>
					   <th style="width:30%;">
					   	<liferay-ui:message key="report-visitor-title"></liferay-ui:message>
					   </th>
					   <th><liferay-ui:message key="report-visitor-number"></liferay-ui:message></th>
					 </tr>
			  	</thead>
			  	<tbody>
					 <%
					 	Date temp = endDate;
					 	while(temp.compareTo(startDate) >= 0){ %>
					  <tr>
					    <td><%= HtmlUtil.escape(dateFormat.format(temp)) %></td>
					    <td>
					    	<%= CounterReportLocalServiceUtil.counterVisitor(temp) %>
					    </td>
					  </tr>
						
					<%
						c = Calendar.getInstance();
						c.setTime(temp);
						c.add(Calendar.DATE, -1);
						temp = c.getTime();
					 	} %>
				</tbody>
			
			</table>
		</div>
	</div>
</aui:form>