<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ include file="/init.jsp"%>

<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);

    int displayPage = 5;

    int bannerDelta = 1;
    
    long totalBanner = 0;
    
    long selectedCategoryId = -1;
    
    int curBannerPage = GetterUtil.getInteger(httpRequest.getParameter("curBannerPage"), 1);
    
    int start = (curBannerPage - 1) * bannerDelta;
    
    int totalPage = 1;
    
	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	String bannerLibraryPortletResource = "banner_war_pointportalbannerportle";
	
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	String bannerSearchKeyword = ParamUtil.getString(request, "keywords", StringPool.BLANK);
%>

<portlet:renderURL var="adminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</portlet:renderURL>