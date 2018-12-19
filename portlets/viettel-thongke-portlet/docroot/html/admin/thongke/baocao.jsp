<%@ include file="/html/admin/thongke/init.jsp" %>

<%
/*String keywords = ParamUtil.getString(request, "keywords","");
String fromDate = ParamUtil.getString(request, "fromDate","");
String toDate = ParamUtil.getString(request, "toDate","");
System.out.println("menuId: "+menuId);
System.out.println("keywords: "+keywords);
System.out.println("fromDate: "+fromDate);
System.out.println("toDate: "+toDate); */

if(menuId==0){
%>
<liferay-util:include page="/html/admin/thongke/bcTongHopTinBaiCanBo.jsp"  servletContext="<%=application %>" />
<%}else if(menuId==1){
%>

<%}else if(menuId==2){
%>

<%}%>