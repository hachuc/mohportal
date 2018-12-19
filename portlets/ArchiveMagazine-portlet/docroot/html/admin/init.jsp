<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ include file="/init.jsp" %>

<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);

    int displayPage = 5;

    int videoDelta = 1;

    long totalVideo = 0;

    long selectedCategoryId = -1;

    int curVideoPage = GetterUtil.getInteger(httpRequest.getParameter("curVideoPage"), 1);

    int start = (curVideoPage - 1) * videoDelta;

    int totalPage = 1;

	//String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	String videoLibraryPortletResource = "2_WAR_viettelmediaportlet";

	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");

	String videoSearchKeyword = ParamUtil.getString(request, "keywords", StringPool.BLANK);
	
	int publishYear = ParamUtil.getInteger(request, "publishYear", 2010);
	
	int magazineId = ParamUtil.getInteger(request, "mgzId", 0);

	int contentId = ParamUtil.getInteger(request, "contentId", 0);
%>

<portlet:renderURL var="adminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</portlet:renderURL>
