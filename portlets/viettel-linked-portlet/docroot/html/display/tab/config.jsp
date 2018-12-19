<%@page import="com.viettel.portal.links.model.LCategory"%>
<%@page import="com.viettel.portal.links.service.LCategoryLocalServiceUtil"%>

<%@ include file="/html/display/tab/init.jsp" %>
<% 
	List<LCategory> categories = LCategoryLocalServiceUtil.findByGroupAndState(scopeGroupId, true);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="homeLinksPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="menu-links-config-form" method="post" action="<%= homeLinksPortletConfigURL %>">

	<aui:row>
		<aui:select name="categoryIds" label="Nhom-lien-ket-hien-thi" multiple="true">
			<% for(LCategory category : categories) { %>
				<aui:option value="<%= category.getCategoryId() %>" label="<%=HtmlUtil.escape( category.getCategoryName() )%>" selected="<%= categoryIds.contains( category.getCategoryId())  %>"/>
			<% } %>
			<aui:option value="0" label="other-category"/>
		</aui:select>
	</aui:row>
	
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button type="cancel"/>
	</aui:button-row>
</aui:form>