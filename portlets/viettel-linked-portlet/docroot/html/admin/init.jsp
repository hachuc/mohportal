<%@page import="com.viettel.portal.links.service.LCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.links.model.LCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="/init.jsp" %>

<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
    int displayPage = 5;
    int linkDelta = 1;
    long totalLink = 0;
    long selectedCategoryId = -1;
    int curLinkPage = GetterUtil.getInteger(httpRequest.getParameter("curLinkPage"), 1);
    int start = (curLinkPage - 1) * linkDelta;
    int totalPage = 1;
	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);
	String linkLibraryPortletResource = "2_WAR_viettellinksportlet";
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
	String linkSearchKeyword = ParamUtil.getString(request, "keywords", StringPool.BLANK);
	long categoryId = ParamUtil.getLong(request, "categoryId", -1L);
	if(categoryId < 0){
		List<LCategory> categories = LCategoryLocalServiceUtil.findByGroup(scopeGroupId, 0, 1);
		if(categories != null && !categories.isEmpty()){
			categoryId = categories.get(0).getCategoryId();
		}else{
			categoryId = 0;
		}
	}
	selectedCategoryId = categoryId;
%>

<portlet:renderURL var="adminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</portlet:renderURL>
