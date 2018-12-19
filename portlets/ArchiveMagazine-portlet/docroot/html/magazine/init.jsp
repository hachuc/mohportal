<%@ include file="/init.jsp" %>
<%
String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);
long layoutId = Long.parseLong(portletPreferences.getValue("lienKetTrang", "0"));
%>