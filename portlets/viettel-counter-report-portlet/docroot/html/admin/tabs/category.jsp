<%@page import="com.liferay.viettel.portal.counter.service.CategoryLocalServiceUtil"%>
<%@page import="com.liferay.viettel.portal.counter.model.Category"%>
<%@page import="com.liferay.viettel.portal.counter.service.CounterReportLocalServiceUtil"%>
<%@page import="com.liferay.viettel.portal.counter.model.CounterReport"%>
<%@page import="com.liferay.portlet.asset.model.*" %>
<%@page import="com.liferay.portlet.asset.service.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/admin/init.jsp" %>
<% 
	/* AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId).get(0);
	List<AssetCategory> categories = null;
	if(vocabulary != null){
		categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabulary.getVocabularyId(), -1, -1, null);
	} */
	long groupId = scopeGroupId;
	List<Category> categories = CategoryLocalServiceUtil.getAll(groupId);
	Date now = new Date();
	int startDateDay = ParamUtil.getInteger(request, "startDateDay", 1);
	int startDateMonth = ParamUtil.getInteger(request, "startDateMonth", now.getMonth());
	int startDateYear = ParamUtil.getInteger(request, "startDateYear",  1900 + now.getYear());
	
	int endDateDay = ParamUtil.getInteger(request, "endDateDay", 0);
	int endDateMonth = ParamUtil.getInteger(request, "endDateMonth", now.getMonth());
	int endDateYear = ParamUtil.getInteger(request, "endDateYear", 1900 + now.getYear());
	if(endDateDay <= 0){
		switch(now.getMonth() + 1){
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
				if(endDateYear % 4 == 0 && endDateYear % 100 != 0){
					endDateDay = 29;
				}
				else{
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
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="tabs1" value="admin_category"/>
</liferay-portlet:renderURL>

<aui:form action="<%=reportCategoryURL%>" method="post" name="fm" cssClass="form-horizontal">
	<liferay-portlet:renderURLParams varImpl="reportCategoryURL" />
	<div  class="report-row">
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
	<div  class="report-row pt10">
		<div class="span6" style="margin: 0px !important;">
			<table class="table table-bordered">
				<thead>
					 <tr>
					   <th style="width:70%;">
							<liferay-ui:message key="report-category-title"></liferay-ui:message>
						</th>
					   <th>
					   	<liferay-ui:message key="report-category-number"></liferay-ui:message>
					   </th>
					 </tr>
			  	</thead>
			  	<tbody>
					 <% for(Category category : categories){ %>
					  <tr>
					    <td><%= HtmlUtil.escape(category.getCategoryName()) %></td>
					    <td>
					    	<%= CounterReportLocalServiceUtil.counterCategory(category.getCategoryId(), startDate, endDate) %>
					    </td>
					  </tr>
						
					<%} %>
				</tbody>
			
			</table>
		</div>
	</div>
</aui:form>