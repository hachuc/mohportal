<%@page import="java.util.TimeZone"%>
<%@page import="com.liferay.viettel.portal.counter.service.CounterReportLocalServiceUtil"%>
<%@page import="com.liferay.viettel.portal.counter.model.CounterReport"%>
<%@page import="com.liferay.viettel.portal.counter.ReportCounter" %>
<%@page import="com.liferay.portlet.asset.model.*" %>
<%@page import="com.liferay.portlet.asset.service.*" %>
<%@page import="com.liferay.portal.kernel.xml.*" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/admin/init.jsp" %>
<%
	/*Date now = new Date();
	int startDateDay = ParamUtil.getInteger(request, "startDateDay", now.getDate());
	int startDateMonth = ParamUtil.getInteger(request, "startDateMonth", now.getMonth());
	int startDateYear = ParamUtil.getInteger(request, "startDateYear",  1900 + now.getYear());
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date startDate = dateFormat.parse(startDateDay + "/" + (startDateMonth + 1) + "/" + startDateYear);
	Calendar c = Calendar.getInstance();
	c.setTime(startDate);
	c.add(Calendar.DATE, 1);
	Date endDate = c.getTime();*/

	Date now = new Date();
	int startDateDay = ParamUtil.getInteger(request, "startDateDay", 1);
	int startDateMonth = ParamUtil.getInteger(request, "startDateMonth", now.getMonth());
	int startDateYear = ParamUtil.getInteger(request, "startDateYear",  1900 + now.getYear());
	
	int endDateDay = ParamUtil.getInteger(request, "endDateDay", 0);
	int endDateMonth = ParamUtil.getInteger(request, "endDateMonth", now.getMonth());
	int endDateYear = ParamUtil.getInteger(request, "endDateYear", 1900 + now.getYear());
	if (endDateDay <= 0) {
		switch (now.getMonth() + 1) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			endDateDay = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			endDateDay = 30;
			break;
		case 2:
			if (endDateYear % 4 == 0 && endDateYear % 100 != 0) {
				endDateDay = 29;
			} else {
				endDateDay = 28;
			}
			break;
		}
	} 
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date startDate = dateFormat.parse(startDateDay + "/" + (startDateMonth + 1) + "/" + startDateYear);
	Date endDate = dateFormat.parse(endDateDay + "/" + (endDateMonth + 1) + "/" + endDateYear);
	Calendar c = Calendar.getInstance();
	c.setTime(endDate);
	c.add(Calendar.DATE, 1);
	endDate = c.getTime();
%>
<liferay-portlet:renderURL varImpl="reportCategoryURL">
	<portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<portlet:param name="tabs1" value="admin_article"/>
	<portlet:param name="startDateDay" value='<%= String.valueOf(startDateDay) %>' />
    <portlet:param name="startDateMonth" value='<%= String.valueOf(startDateMonth) %>' />
    <portlet:param name="startDateYear" value='<%= String.valueOf(startDateYear) %>' />
    <portlet:param name="endDateDay" value='<%= String.valueOf(endDateDay) %>' />
    <portlet:param name="endDateMonth" value='<%= String.valueOf(endDateMonth) %>' />
    <portlet:param name="endDateYear" value='<%= String.valueOf(endDateYear) %>' />
    <portlet:param name="resetCur" value='true' />
</liferay-portlet:renderURL>

<aui:form action="<%=reportCategoryURL%>" method="get" name="fm" cssClass="form-horizontal">
	<div class="report-row">
		<div class="span3">
			<liferay-ui:message key="report-category-start-date"></liferay-ui:message>
	     	<liferay-ui:input-date  name="startDate"
				dayParam="startDateDay" dayValue="<%=startDateDay %>"
				monthParam="startDateMonth" monthValue="<%=startDateMonth %>"
				yearParam="startDateYear" yearValue="<%=startDateYear %>"/>
		</div>
		<div class="span3">
			<liferay-ui:message key="report-category-end-date"></liferay-ui:message>
			<liferay-ui:input-date  name="endDate"
				dayParam="endDateDay" dayValue="<%=endDateDay %>"
				monthParam="endDateMonth" monthValue="<%=endDateMonth %>"
				yearParam="endDateYear" yearValue="<%=endDateYear %>"/>
		</div>
	</div>
	<div class="report-row ">
		<div class="span6" style="text-align: center;margin: 0px !important;">
			<aui:button name="search" type="submit" value="report-category" cssClass="btn btn-grey text-bold"/>
		</div>
	</div>
	<div class="report-row pt10">
	
		<liferay-ui:search-container delta="20" emptyResultsMessage="Không-có-bản-ghi-nào" iteratorURL="<%= reportCategoryURL %>">
		
		<%
			List list = CounterReportLocalServiceUtil.counterArticle(0L, startDate, endDate, searchContainer.getStart(), searchContainer.getEnd());
			total = (int)CounterReportLocalServiceUtil.countArticle(0L, startDate, endDate, searchContainer.getStart(), searchContainer.getEnd());
		%>
		
		<liferay-ui:search-container-results results="<%=list %>" total="<%=total %>"/>
		<%
			String serilizeString=null;
			JSONArray countArticleDataJsonArray=null;
			%>
			<liferay-ui:search-container-row className="java.lang.Object" modelVar="article" escapedModel="<%=true %>">
			<% 
				serilizeString=JSONFactoryUtil.serialize(article);
				countArticleDataJsonArray=JSONFactoryUtil.createJSONArray(serilizeString);
				/* boolean isvisible = GetterUtil.getBoolean(commentDataJsonArray.getString(8), false); */
			%>
			<liferay-ui:search-container-column-text name="report-article-title" value="<%= HtmlUtil.escape(countArticleDataJsonArray.getString(0))%>" />
			<liferay-ui:search-container-column-text name="report-article-number" value="<%= StringPool.BLANK + countArticleDataJsonArray.getString(1)%>" />
		</liferay-ui:search-container-row>
		<liferay-portlet:renderURLParams varImpl="reportCategoryURL">
			<portlet:param name="startDateDay" value='<%= String.valueOf(startDateDay) %>' />
		    <portlet:param name="startDateMonth" value='<%= String.valueOf(startDateMonth) %>' />
		    <portlet:param name="startDateYear" value='<%= String.valueOf(startDateYear) %>' />
		    <portlet:param name="endDateDay" value='<%= String.valueOf(endDateDay) %>' />
		    <portlet:param name="endDateMonth" value='<%= String.valueOf(endDateMonth) %>' />
		    <portlet:param name="endDateYear" value='<%= String.valueOf(endDateYear) %>' />
		    <portlet:param name="resetCur" value='true' />
		</liferay-portlet:renderURLParams>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
	</div>
</aui:form>