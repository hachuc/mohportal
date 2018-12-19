<%@page import="com.viettel.portal.vcms.service.CategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Category"%>
<%@page import="sun.util.resources.LocaleData"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/frontend/publisher/init.jsp"%>
<liferay-portlet:actionURL portletConfiguration="true"
	var="publisherConfigURL">
	<liferay-portlet:param name="portletResource"
		value="<%=portletResource%>" />
</liferay-portlet:actionURL>
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
				<aui:input type="text" name="portletTitle" value="<%= portletTitle %>" label="portlet-title" />
				<aui:fieldset>
					<aui:select name="itemDisplay" label="display-items">
						<%
							for (int i : displayItems) {
						%>
						<aui:option value="<%=i%>" selected="<%=itemDisplay == i%>"><%=i%></aui:option>
	
						<%
							}
						%>
					</aui:select>
					<aui:select name="itemDisplayList" label="display-list-items">
						<%
							for (int i : displayItems) {
						%>
						<aui:option value="<%=i%>" selected="<%=itemDisplayList == i%>"><%=i%></aui:option>
	
						<%
							}
						%>
					</aui:select>
					<aui:select name="displayStyle" label="display-style">
						<aui:option value="abstract" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "abstract")%>' label="abstract" />
						<aui:option value="full_content" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "full_content")%>' label="full-content" />
					</aui:select>
					<aui:input type="checkbox" name="showAuthor" label="show-author" checked="<%=showAuthor%>" />
					<aui:input type="checkbox" name="showByDate" label="show-date-ticker" checked="<%=showByDate%>" />
					<aui:input type="checkbox" name="showPublishDate" label="show-publish-date" checked="<%=showPublishDate%>" />
					<aui:input type="checkbox" name="showSocialBookmark" label="show-publish-date" checked="<%=showSocialBookmark%>" />
					<aui:input type="checkbox" name="allowDiscussion" label="allow-discussion" checked="<%=allowDiscussion%>" />
				</aui:fieldset>
			</aui:field-wrapper>
		</liferay-ui:panel>
		<liferay-ui:panel collapsible="<%=true%>" extended="<%=false%>" id="select-content" persistState="<%=true%>"
			title="filter-content">
			<aui:fieldset>
				<aui:select name="categoryId" label="choose-category">
					<%
						if (categories != null) {
							for (Category cat : categories) {
					%>
					<aui:option value="<%=cat.getCategoryId()%>" selected="<%= cat.getCategoryId() == selectedCategoryId %>"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
					<%
							}
						}
					%>
				</aui:select>
				<aui:select name="paginationType">
					<aui:option label="none" selected='<%= paginationType.equals("none") %>' />
					<aui:option label="simple" selected='<%= paginationType.equals("simple") %>' />
					<aui:option label="regular" selected='<%= paginationType.equals("regular") %>' />
				</aui:select>
				<input name="fromDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="<%=defaultFromDate%>">
				<input name="endDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="<%=defaultToDate%>">
			</aui:fieldset>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
	<aui:button-row>
		<aui:button type="submit" value="save" />
		<aui:button type="cancel" />
	</aui:button-row>
</aui:form>