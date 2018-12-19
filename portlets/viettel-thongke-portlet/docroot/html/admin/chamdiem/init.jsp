<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp"%>
<script src="<%=request.getContextPath() %>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery-1.11.3.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery-ui.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery-ui.css">
<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);

    
	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	String phongBanSearchKeyword = ParamUtil.getString(request, "keywords", StringPool.BLANK);
	long menuId=ParamUtil.getLong(request, "menuId", 0);
	long classTypeId=482110;
	//--  menuId=0   : cham diem phong ban
	//--  menuId=1   : cham diem bai viet
	//--  menuId=2   : cham diem bai viet ngoai
	
%>

<portlet:renderURL var="adminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/chamdiem/view.jsp"/>
</portlet:renderURL>