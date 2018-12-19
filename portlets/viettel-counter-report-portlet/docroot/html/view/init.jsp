<%
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@ page import="com.liferay.portal.kernel.bean.BeanPropertiesUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.log.Log"%>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.servlet.ServletContextUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatConstants"%>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@ page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@ page import="com.liferay.portal.kernel.util.Time"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeProperties"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.model.Layout"%>
<%@ page import="com.liferay.portal.model.LayoutConstants"%>
<%@ page import="com.liferay.portal.model.Portlet"%>
<%@ page import="com.liferay.portal.model.RoleConstants"%>
<%@ page import="com.liferay.portal.model.Ticket"%>
<%@ page import="com.liferay.portal.model.TicketConstants"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.model.ModelHintsConstants"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.PortletLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.permission.LayoutPermissionUtil"%>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@ page import="com.liferay.portal.service.permission.GroupPermissionUtil"%>
<%@ page import="com.liferay.portal.service.ServiceContext"%>
<%@ page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@ page import="com.liferay.portal.security.auth.PrincipalException"%>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>

<%@ page import="com.liferay.portlet.documentlibrary.DuplicateFileException"%>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ page import="com.liferay.portlet.PortletURLUtil"%>

<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="javax.portlet.WindowState" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DecimalFormatSymbols"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
	
	String currentURL = currentURLObj.toString();
	
	String redirect = ParamUtil.getString(request, "redirect", currentURL);
	
	String templatePath = portletConfig.getInitParameter("template-path");
	
	
	
	
	PortletPreferences preferences = null;
	
	if (renderRequest != null) 
	{
		preferences = renderRequest.getPreferences();
	}
	
	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) 
	{
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	String[] categoryIds = portletPreferences.getValues("categoryIdValues", new String[0]);
	
	long categoryId = 0L;
	
	if(categoryIds.length > 0)
	{
		categoryId = GetterUtil.getLong(categoryIds[0]);
	}
	
	String categoryIdValues = StringUtil.merge(categoryIds);
	
	String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);
	
	int displayItem = GetterUtil.getInteger(portletPreferences.getValue("displayItem", null), 5);
	
	Date now = new Date();
	int startDateDay = ParamUtil.getInteger(request, "startDateDay", 1);
	int startDateMonth = ParamUtil.getInteger(request, "startDateMonth", now.getMonth());
	int startDateYear = ParamUtil.getInteger(request, "startDateYear",  1900 + now.getYear());
	
	int endDateDay = ParamUtil.getInteger(request, "endDateDay", 0);
	int endDateMonth = ParamUtil.getInteger(request, "endDateMonth", now.getMonth());
	int endDateYear = ParamUtil.getInteger(request, "endDateYear", 1900 + now.getYear());
	if(endDateDay <= 0){
		switch(now.getMonth() + 1){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				endDateDay = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				endDateDay = 30;
				break;
			case 2:
				if(endDateYear % 4 == 0 && endDateYear % 100 != 0){
					endDateDay = 29;
				}
				else{
					endDateDay = 28;
				}
				break;
		}
	}
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date startDate = dateFormat.parse(startDateDay + "/" + (startDateMonth + 1) + "/" + startDateYear);
	Date endDate = dateFormat.parse(endDateDay + "/" + (endDateMonth + 1) + "/" + endDateYear);
	Calendar c = Calendar.getInstance();
	c.setTime(endDate);
	c.add(Calendar.DATE, 1);
	endDate = c.getTime();
%>