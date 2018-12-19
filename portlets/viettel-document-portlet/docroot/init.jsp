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
<%@page import="com.viettel.portal.vbpq.util.ActionKeys"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
	
	String currentURL = currentURLObj.toString();
	
	String redirect = ParamUtil.getString(request, "redirect", currentURL);
	
	String templatePath = portletConfig.getInitParameter("template-path");
	String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);
	String dmPortletTitle = portletPreferences.getValue("dmPortletTitle", StringPool.BLANK);
	long layoutId = Long.parseLong(portletPreferences.getValue("lienKetTrang", "0"));
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
	
	String defaultTypeContent = "1"; //Co quan ban hanh
	String defaultHomeDisplay = "1"; //Co quan ban hanh
	
	int defaultNumberVbpqDisplay = 5;
	
	String typeContent = preferences.getValue("typeContent", defaultTypeContent);
	String homeDisplay = preferences.getValue("homeDisplay", defaultHomeDisplay);
	
	int numberVbpqDisplay = GetterUtil.getInteger(preferences.getValue("numberVbpqDisplay", "5"));
	
	long scopeId = GetterUtil.getLong(portletPreferences.getValue("scopeId", null), scopeGroupId);
	
	boolean showSearchCoQuanBanHanh = GetterUtil.getBoolean(portletPreferences.getValue("showSearchCoQuanBanHanh", null), true);
	boolean showSearchLoaiVanBan = GetterUtil.getBoolean(portletPreferences.getValue("showSearchLoaiVanBan", null), true);
	boolean showSearchLinhVuc = GetterUtil.getBoolean(portletPreferences.getValue("showSearchLinhVuc", null), true);
	boolean showNgayBanHanh = GetterUtil.getBoolean(portletPreferences.getValue("showNgayBanHanh", null), true);
	boolean showNguoiKy = GetterUtil.getBoolean(portletPreferences.getValue("showNguoiKy", null), true);
	boolean showDetail = GetterUtil.getBoolean(portletPreferences.getValue("showDetail", null), true);
	boolean showAttachment = GetterUtil.getBoolean(portletPreferences.getValue("showAttachment", null), true);
	boolean showCQBH = GetterUtil.getBoolean(portletPreferences.getValue("showCQBH", null), false);
	boolean showSearchYear = GetterUtil.getBoolean(portletPreferences.getValue("showSearchYear", null), false);
	String coQuanBanHanhPrefs = portletPreferences.getValue("coquanbanhanh", null);
	
	long[] coQuanBanHanhIdPrefsHome = GetterUtil.getLongValues(portletPreferences.getValues("coquanbanhanhhome", new String[]{}));
	
	/* System.out.println(coQuanBanHanhIdPrefsHome.length); */
	
	String linhVucVanBanPrefs = portletPreferences.getValue("linhvuc", null);
	String loaiVanBanPrefs = portletPreferences.getValue("loaivanban", null);
	String yearsPrefs = portletPreferences.getValue("year", null);
	
	long[] coQuanBanHanhIdPrefs = null;
	if(Validator.isNotNull(coQuanBanHanhPrefs)) {
		coQuanBanHanhIdPrefs = StringUtil.split(coQuanBanHanhPrefs, 0l);
	}

	long[] linhVucVanBanIdPrefs = null;
	if(Validator.isNotNull(linhVucVanBanPrefs)) {
		linhVucVanBanIdPrefs = StringUtil.split(linhVucVanBanPrefs, 0l);
	}
	
	int[] years = null;
	if(Validator.isNotNull(yearsPrefs)) {
		years = StringUtil.split(yearsPrefs, 0);
	}
	
	
	long[] loaiVanBanIdPrefs = null;
	if(Validator.isNotNull(loaiVanBanPrefs)) {
		loaiVanBanIdPrefs = StringUtil.split(loaiVanBanPrefs, 0l);
	}
	
	Format dateFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");
	Format dateFormatDateTime = FastDateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy HH:mm");
	Format dateFormatTime = FastDateFormatFactoryUtil.getTime(locale, timeZone);
	
	DecimalFormat priceFormat = new DecimalFormat();
	DecimalFormatSymbols dfs = priceFormat.getDecimalFormatSymbols();  
	
	dfs.setDecimalSeparator(',');
	dfs.setGroupingSeparator('.');
	priceFormat.setMinimumFractionDigits(0);
	priceFormat.setDecimalFormatSymbols(dfs);
%>