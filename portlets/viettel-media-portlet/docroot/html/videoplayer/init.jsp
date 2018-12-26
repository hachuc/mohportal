<%@page import="org.apache.commons.logging.Log"%>
<%@page import="org.apache.commons.logging.LogFactory"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
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

	long categoryId = -1L;
	long videoPageLayoutId = GetterUtil.getLong(portletPreferences.getValue("videoPageLayoutId",
			String.valueOf(themeDisplay.getPlid())));

	int videoFrameWidth = GetterUtil.getInteger(portletPreferences.getValue("videoFrameWidth",
			String.valueOf(VideoConstants.DEFAULT_VIDEO_FRAME_WIDTH)));
	int videoFrameHeight = GetterUtil.getInteger(portletPreferences.getValue("videoFrameHeight",
			String.valueOf(VideoConstants.DEFAULT_VIDEO_FRAME_HEIGHT)));

	String videoAdminPortletResource = "1_WAR_viettelmediaportlet";
	String portletVideoPlayerId = "videoplayer_WAR_videoplayerportlet";
	String displayStyle = portletPreferences.getValue("displayStyle", "focus-style");
	String prefixLink = portletPreferences.getValue("prefixLink", "");
	String styleTitle = portletPreferences.getValue("styleTitle", LanguageUtil.get(locale, "title"));
	
	
	String widthUnit = portletPreferences.getValue("widthUnit", VideoConstants.PIXEL);
	String heightUnit = portletPreferences.getValue("heightUnit", VideoConstants.PIXEL);
	String keywords = ParamUtil.getString(request, "keywords", StringPool.BLANK);
	String videoWidth = String.valueOf(videoFrameWidth);
	String videoHeight = String.valueOf(videoFrameHeight);
	String selectedVideosId = portletPreferences.getValue("selectedVideosId", StringPool.BLANK);
	long scopeId = GetterUtil.getLong( portletPreferences.getValue("scopeId", String.valueOf( themeDisplay.getScopeGroupId())));

	if(widthUnit.equals(VideoConstants.PERCENT)){
		videoWidth = videoFrameWidth + widthUnit;

	}
	if(heightUnit.equals(VideoConstants.PERCENT)){
		videoHeight = videoFrameHeight + VideoConstants.PERCENT;
	}

	int numbersOfVideoDisplay = GetterUtil.getInteger(portletPreferences.getValue("numbersOfVideoDisplay", "0"));
	int categoryVideoDisplay = GetterUtil.getInteger(portletPreferences.getValue("categoryVideoDisplay", "0"));
	
	boolean showTitle = GetterUtil.getBoolean(portletPreferences.getValue("showTitle", "true"));
	boolean showViewMoreVideoLink = GetterUtil.getBoolean(portletPreferences.getValue("showViewMoreVideoLink", "true"));
	boolean showVideoThumbnail = GetterUtil.getBoolean(portletPreferences.getValue("showVideoThumbnail", "false"));
	boolean showVideoPublishDate = GetterUtil.getBoolean(portletPreferences.getValue("showVideoPublishDate", "false"));
	boolean useCustomVideoFrameSize = GetterUtil.getBoolean(portletPreferences.getValue("useCustomVideoFrameSize", "false"));
	boolean autoPlay = false;
%>

<liferay-portlet:renderURL varImpl="videoPlayerURL" var="">
	<liferay-portlet:param name="jspPage" value="/html/videoplayer/view.jsp"/>
	<liferay-portlet:param name="keywords" value="<%=keywords %>"/>
	<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
</liferay-portlet:renderURL>

<portlet:renderURL var="videoFullPageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/videoplayer/view.jsp"/>
</portlet:renderURL>


<%!
	private static Log _log = LogFactory.getLog("html.videolibrary.portlet");
%>
