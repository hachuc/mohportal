<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<script src="<%=request.getContextPath() %>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery-1.11.3.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery-ui.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery-ui.css">
<%@ include file="/html/init.jsp"%>

<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);

    
	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	long menuId=ParamUtil.getLong(request, "menuId", 0);
	
	
%>

<portlet:renderURL var="adminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/nhuanbut/view.jsp"/>
</portlet:renderURL>