<%@page import="com.viettel.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLCategory"%>
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

	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	String videoLibraryPortletResource = "2_WAR_viettelmediaportlet";

	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");

	String videoSearchKeyword = ParamUtil.getString(request, "keywords", StringPool.BLANK);

	long categoryId = ParamUtil.getLong(request, "categoryId", -1L);

	if(categoryId < 0){

		List<VLCategory> categories = VLCategoryLocalServiceUtil.findByGroup(scopeGroupId, 0, 1);

		if(categories != null && !categories.isEmpty()){

			categoryId = categories.get(0).getCategoryId();

		}else{

			categoryId = 0;
		}
	}

	selectedCategoryId = categoryId;
		
	String redirect = ParamUtil.getString(request, "redirect", currentURL);
%>

<portlet:renderURL var="adminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</portlet:renderURL>
