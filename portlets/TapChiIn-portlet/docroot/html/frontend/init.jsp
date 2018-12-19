<%@page import="com.viettel.portal.magazine.service.MagazineContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.model.MagazineContent"%>
<%@page import="com.viettel.portal.magazine.service.MagazineLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.model.Magazine"%>
<%@ include file="/init.jsp" %>

<%
long layoutId = Long.parseLong(portletPreferences.getValue("lienKetTrang", "0"));
int magazineId = ParamUtil.getInteger(request, "magazineId", 0);
int mzId = ParamUtil.getInteger(request, "mzId", 0);
int mcId = ParamUtil.getInteger(request, "mcId", 0);
Magazine mgz = MagazineLocalServiceUtil.fetchMagazine(magazineId);

%>