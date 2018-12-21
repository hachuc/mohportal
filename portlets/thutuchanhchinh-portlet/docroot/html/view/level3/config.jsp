<%@page import="com.liferay.portal.kernel.util.Html"%>

<%@ include file="/html/view/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="categoryLinksPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="config-form" method="post" action="<%= categoryLinksPortletConfigURL %>">
	<aui:row>
		<aui:input type="text" label="portlet-title" name="portletTitle" value="<%= portletTitle %>" />	
	</aui:row>
	<aui:row>
		<aui:select name="displayItem" label="display-items">
			<%
				for (int i : displayItems) {
			%>
			<aui:option value="<%=i%>" selected="<%=displayItem == i%>"><%=i%></aui:option>

			<%
				}
			%>
		</aui:select>
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button type="cancel"/>
	</aui:button-row>
</aui:form>