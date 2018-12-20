<%@page import="com.liferay.portal.kernel.util.Html"%>

<%@ include file="/html/view/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="homeLinksPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="config-form" method="post" action="<%= homeLinksPortletConfigURL %>">
	<aui:row>
		<aui:input type="text" label="portlet-title" name="portletTitle" value="<%= portletTitle %>" />	
	</aui:row>
	<aui:row>
		<aui:select name="lienKetTrang" label="lien-ket-trang">
			<%				
				List<Layout> lls = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false);
				for (Layout lt : lls) {
					boolean select = (layoutId == lt.getPlid() ? true:false);
			%>
			<aui:option label="<%= lt.getName(themeDisplay.getLocale()) %>" selected="<%= select %>" value="<%= String.valueOf(lt.getPlid()) %>"></aui:option>
			<% } %>
		</aui:select>
	</aui:row>
	<aui:row>
		<aui:select name="displayStyle" label="trang-hien-thi">
			<aui:option value="show-search" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "show-search") %>' label="show-search-view" />
			<aui:option value="show-results" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "show-results") %>' label="show-results-view" />
		</aui:select>
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button type="cancel"/>
	</aui:button-row>
</aui:form>