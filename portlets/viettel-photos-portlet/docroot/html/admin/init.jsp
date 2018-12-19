<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.viettel.portal.photos.model.*"%>
<%@page import="com.viettel.portal.photos.service.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ include file="/init.jsp"%>

<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);

    int displayPage = 5;

    int photoDelta = 1;
    
    long totalPhoto = 0;
    
    long selectedCategoryId = -1;
    
    int curPhotoPage = GetterUtil.getInteger(httpRequest.getParameter("curPhotoPage"), 1);
    
    int start = (curPhotoPage - 1) * photoDelta;
    
    int totalPage = 1;
    
	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	String photoLibraryPortletResource = "photo_war_pointportalphotoportle";
	
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	String photoSearchKeyword = ParamUtil.getString(request, "keywords", StringPool.BLANK);
	
	long categoryId = ParamUtil.getLong(request, "categoryId", -1L);
	if(categoryId < 0){
		List<PCategory> categories = PCategoryLocalServiceUtil.findByGroup(groupId, 0, 1);
		if(categories != null && !categories.isEmpty()){
			categoryId = categories.get(0).getId();
		}else{
			categoryId = 0;
		}
	}
	selectedCategoryId = categoryId;	
%>

<portlet:renderURL var="adminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</portlet:renderURL>