<%@page import="java.util.Arrays"%>
<%@page import="com.viettel.portal.vcms.util.CmsUtil"%>
<%@page import="com.viettel.portal.vcms.service.CategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Category"%>
<%@page import="sun.util.resources.LocaleData"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/frontend/most-viewed/init.jsp"%>
<liferay-portlet:actionURL portletConfiguration="true"
	var="publisherConfigURL">
	<liferay-portlet:param name="portletResource"
		value="<%=portletResource%>" />
</liferay-portlet:actionURL>
<link rel="stylesheet" href="/viettel-cms-portlet/css/chosen.min.css">

<%
	
	Date defaultFromDate = new Date();
	Calendar c = Calendar.getInstance();
	c.setTime(defaultFromDate);
	c.add(Calendar.DATE, 7);
	Date defaultToDate = c.getTime();
	
	List<Category> categories = new ArrayList<Category>();
	try {
		categories = CategoryLocalServiceUtil.getAllCategories(scopeGroupId);
	} catch (Exception e) {
	}
%>
<aui:form action="<%=publisherConfigURL%>" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />
	<liferay-ui:panel-container cssClass="basic-info"
		id="basic-info-container" extended="true">
		<liferay-ui:panel collapsible="<%=false%>" extended="<%=true%>"
			id="basic-info" persistState="<%=true%>" title="config-info">
			<aui:field-wrapper label="">
				<aui:fieldset>
					<aui:input type="text" name="portletTitle" value="<%= portletTitle %>" label="portlet-title" />

					<aui:select name="filterType" label="filter-type">
						<aui:option value="list_title_style" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "list_title_style")%>' label="list-title-style" />
						<aui:option value="small_image_style" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "small_image_style")%>' label="small-image-style" />
						<aui:option value="bullet_style" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "bullet_style")%>' label="bullet-style" />
					</aui:select>
					
					<aui:select name="layoutUuid" label="link-to-page" showEmptyOption="<%=true %>">
						<%=VCMSPubliserUtil.buildLayoutsToSelect(layoutUuid, true, themeDisplay) %>
					</aui:select>
					
					<aui:select name="itemDisplay" label="display-items">
						<%
							for (int i : displayItems) {
						%>
						<aui:option value="<%=i%>" selected="<%=itemDisplay == i%>"><%=i%></aui:option>
	
						<%
							}
						%>
					</aui:select>
					
					<aui:select name="filterByDate" label="filter-by-date">
						<%
							for (int i : filterByDates) {
						%>
						<aui:option value="<%=i%>" selected="<%= filterByDate == i%>"><%=i%> <liferay-ui:message key="date-label-ignorecase" /></aui:option>
	
						<%
							}
						%>
					</aui:select>
					
					<aui:select name="titleLength" label="title-length">
						<%
							for (int i : arrTitleLength) {
						%>
						<aui:option value="<%=i%>" selected="<%=itemDisplay == i%>"><%=i%></aui:option>
	
						<%
							}
						%>
					</aui:select>
					
					<aui:input type="checkbox" name="showPublishDate" label="show-publish-date" checked="<%= showPublishDate%>" />
					
					<aui:input type="checkbox" name="showViewCount" label="show-view-count" checked="<%= showViewCount%>" />
					
					<select name="<portlet:namespace />categoryIds" class="chosen-select" data-placeholder="Chọn chuyên mục..." multiple>
						<%
							if (categories != null) {
								for (Category cat : categories) {
									String isSelected = Arrays.asList(categoryIds).contains(String.valueOf(cat.getCategoryId()))? " selected":"";
						%>
						<option value="<%=cat.getCategoryId()%>" <%= isSelected %>><%=HtmlUtil.escape(cat.getCategoryName())%></option>
						<%
								}
							}
						%>
					</select>
				</aui:fieldset>
			</aui:field-wrapper>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
	<aui:button-row>
		<aui:button type="submit" value="save" />
		<aui:button type="cancel" />
	</aui:button-row>
</aui:form>

<script>
  $(function() {
    $('.chosen-select').chosen({width: "100%"});
  });
</script>