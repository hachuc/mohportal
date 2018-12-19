<%@page import="com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.archive.model.Content"%>
<%@page import="com.viettel.portal.magazine.archive.service.MagazineLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.archive.model.Magazine"%>
<%@ include file="/init.jsp" %>

<%
String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);
String imageFolderPath = portletPreferences.getValue("imageFolderPath", StringPool.BLANK);
int magazineId = ParamUtil.getInteger(request, "mgzId", 0);
Magazine mgz = MagazineLocalServiceUtil.fetchMagazine(magazineId);

%>