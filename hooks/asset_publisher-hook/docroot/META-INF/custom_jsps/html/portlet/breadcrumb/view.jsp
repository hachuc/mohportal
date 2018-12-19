<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/breadcrumb/init.jsp" %>
<div class="breadcrumbWrapper">
<%
List<Group> sites = user.getMySiteGroups();
Group g = GroupLocalServiceUtil.getGroup(scopeGroupId);
g.getFriendlyURL();
String url=themeDisplay.getPortalURL(); 
if(g.getActive()==true && g.getSite()==true && !g.getFriendlyURL().isEmpty())
url=url+"/web"+ g.getFriendlyURL();
%>
<c:if test="<%= showHome %>">
<div class="breadcrumbHome">
	<a href="<%= url%>"><liferay-ui:message key="trang-chu" /> </a>
</div>
</c:if>
<div class="breadcrumbTaglib">
<liferay-ui:breadcrumb
	showCurrentGroup="<%= showCurrentGroup %>"
	showCurrentPortlet="<%= showCurrentPortlet %>"
	showGuestGroup="<%= showGuestGroup %>"
	showLayout="<%= showLayout %>"
	showParentGroups="<%= showParentGroups %>"
	showPortletBreadcrumb="<%= showPortletBreadcrumb %>"

/>
</div>
</div>