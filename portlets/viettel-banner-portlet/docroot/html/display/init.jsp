<%@page import="org.apache.commons.logging.Log"%>
<%@page import="org.apache.commons.logging.LogFactory"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.viettel.portal.banner.util.BannerConstants"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy");
	String portletResource = ParamUtil.getString(request,"portletResource");
	if (Validator.isNotNull(portletResource)) {
		portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String selectedBannersId = portletPreferences.getValue("selectedBannersId", StringPool.BLANK);	
	String keywords = ParamUtil.getString(request, "keywords", StringPool.BLANK);
%>

<%! 
	private static Log _log = LogFactory.getLog("html.banner.portlet");
%>
