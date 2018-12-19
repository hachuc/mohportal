<%@ include file="/init.jsp" %>
<%@page import="com.viettel.portal.magazine.service.MagazineLocalServiceUtil" %>
<%@page import="com.viettel.portal.magazine.model.Magazine" %>
<%
String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);
long layoutId = Long.parseLong(portletPreferences.getValue("lienKetTrang", "0"));
List<Magazine> lstMagazine = MagazineLocalServiceUtil.getLastestMagazine();
Magazine latestItem = null;
if(Validator.isNotNull(lstMagazine)){
	latestItem = lstMagazine.get(0);
}
%>