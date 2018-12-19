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
<%@ include file="/html/admin/comment/init.jsp" %>
<%
	long contentId = ParamUtil.getLong(request, "distributionId");
		 if(contentId > 0){
			 request.setAttribute("view.contentId", contentId);
		 }
%>
<c:if test='<%= contentId == 0 %>'>
	<liferay-util:include page='/html/admin/comment/view_allcomments.jsp' servletContext="<%= application %>" />
</c:if>
<c:if test='<%= contentId > 0 %>'>
	<liferay-util:include page='/html/admin/comment/view_by_content.jsp' servletContext="<%= application %>" />
</c:if>