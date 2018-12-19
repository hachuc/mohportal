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
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ include file="/html/taglib/taglib-init.jsp" %>

<%
	String name = (String)request.getAttribute("fds-ategorymgt:ctld:name");
	String cssClass = (String)request.getAttribute("fds-ategorymgt:ctld:cssClass");
	String renderMode = (String)request.getAttribute("fds-ategorymgt:ctld:renderMode");
	String inlineLabel = GetterUtil.getString((String)request.getAttribute("fds-ategorymgt:ctld:inlineLabel"), StringPool.BLANK);
	String valueOption = GetterUtil.getString((String)request.getAttribute("fds-ategorymgt:ctld:valueOption"), "id");
	boolean showLabel = GetterUtil.getBoolean(request.getAttribute("fds-ategorymgt:ctld:showLabel"), true);
	long value = (Long) GetterUtil.getLong((Long) request.getAttribute("fds-ategorymgt:ctld:value"), 0);
	
	
%>
<%!
private static final String _NAMESPACE = "categorymgt:ctlr:";
%>