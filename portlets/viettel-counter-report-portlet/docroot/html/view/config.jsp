<%@ include file="/html/view/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" >
	<liferay-portlet:param name="portletResource" value="<%=portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="fm" method="post" action="<%=configurationActionURL%>">
<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<div class="portlet-config-form">
		<div class="lfr-form-row">

			<aui:input type="text" name="preferences--portletTitle--" label="portlet-title"
				value="<%=portletTitle%>" />
		</div>
		<div class="lfr-form-row">
			<div class="query-condition">
				<span class="query-label"><liferay-ui:message key="filter-by-category"/></span>
			</div>
			<div class="field categories-selector cfn-categories-selector">
				<liferay-ui:asset-categories-selector
					curCategoryIds='<%=categoryIdValues%>'
					hiddenInput="queryCategoryIds" />
			</div>
		</div>
		<div class="lfr-form-row">
			<aui:select name="preferences--displayItem--" label="display-item">
				<%
					int[] displayItems = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
									12, 13, 14, 15, 20 };

							for (int displayItem_ : displayItems) {
				%>

				<aui:option label="<%=displayItem_%>"
					selected="<%=(displayItem_ == displayItem)%>" />

				<%
					}
				%>
			</aui:select>
		</div>

		<aui:button-row>
			<aui:button type="submit" value="save" />
			<aui:button type="cancel" />
		</aui:button-row>
	</div>
</aui:form>