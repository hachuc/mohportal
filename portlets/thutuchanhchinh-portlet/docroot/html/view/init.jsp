<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="/html/init.jsp" %>

<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
    int displayPage = 5;
    int linkDelta = 1;
    long totalLink = 0;
    long selectedCategoryId = -1;
    int curLinkPage = GetterUtil.getInteger(httpRequest.getParameter("curLinkPage"), 1);
    int start = (curLinkPage - 1) * linkDelta;
    int totalPage = 1;
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
	
	String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);
	String displayStyle = portletPreferences.getValue("displayStyle", "show-search");
	int displayItem = GetterUtil.getInteger(portletPreferences.getValue("displayItem", "5"));
	long layoutId = GetterUtil.getLong(portletPreferences.getValue("lienKetTrang", String.valueOf(themeDisplay.getPlid())));
	int[] displayItems = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 50, 100 };
%>