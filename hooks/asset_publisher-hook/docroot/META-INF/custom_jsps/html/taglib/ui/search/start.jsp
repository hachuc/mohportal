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

<%@ include file="/html/taglib/ui/search/init.jsp"%>

<%
long groupId = ParamUtil.getLong(request, namespace + "groupId");

Group group = themeDisplay.getScopeGroup();

String keywords = ParamUtil.getString(request, namespace + "keywords");

PortletURL portletURL = null;

if (portletResponse != null) {
	LiferayPortletResponse liferayPortletResponse = (LiferayPortletResponse)portletResponse;

	portletURL = liferayPortletResponse.createLiferayPortletURL(PortletKeys.SEARCH, PortletRequest.RENDER_PHASE);
}
else {
	portletURL = new PortletURLImpl(request, PortletKeys.SEARCH, plid, PortletRequest.RENDER_PHASE);
}

portletURL.setParameter("struts_action", "/search/search");
portletURL.setParameter("redirect", currentURL);
portletURL.setPortletMode(PortletMode.VIEW);
portletURL.setWindowState(WindowState.MAXIMIZED);

pageContext.setAttribute("portletURL", portletURL);
%>

<form action="<%= HtmlUtil.escapeAttribute(portletURL.toString()) %>"
	method="get" name="<%= randomNamespace %><%= namespace %>fm"
	onSubmit="<%= randomNamespace %><%= namespace %>search(); return false;">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<div class="input-group input-group-sm">
		<input class="form-control" placeholder="Search" type="text"
			name='<%= namespace + "keywords" %>'
			value="<%= HtmlUtil.escapeAttribute(keywords) %>">
		<div class="input-group-btn">
			<button class="btn btn-default" type="submit">
				<i class="fa fa-search"></i>
			</button>
		</div>
	</div>
	<aui:script>
		function <%= randomNamespace %><%= namespace %>search() {
			var keywords = document.<%= randomNamespace %><%= namespace %>fm.<%= namespace %>keywords.value;
	
			keywords = keywords.replace(/^\s+|\s+$/, '');
	
			if (keywords != '') {
				submitForm(document.<%= randomNamespace %><%= namespace %>fm);
			}
		}
	</aui:script>