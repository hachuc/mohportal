<%
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
%>
<%@ include file="/html/admin/init.jsp" %>
<%
	String viewPath = templatePath + "display/listv" + roleVersion + "s" + stateValue + ".jsp";
	String addContentPath = templatePath + "new_content.jsp";
	System.out.println(viewPath);
%>
<c:if test='<%= viewMode == 2 %>'>
	<liferay-util:include page='<%= viewPath %>' servletContext="<%= application %>" />
</c:if>
<c:if test='<%= viewMode == 1 %>'>
	<liferay-util:include page='<%= addContentPath %>' servletContext="<%= application %>" />
</c:if>

