<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@ include file="/html/init.jsp"%>

<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);

    
	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	String phongBanSearchKeyword = ParamUtil.getString(request, "keywords", StringPool.BLANK);
	
	
%>

<portlet:renderURL var="adminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/phongban/view.jsp"/>
</portlet:renderURL>