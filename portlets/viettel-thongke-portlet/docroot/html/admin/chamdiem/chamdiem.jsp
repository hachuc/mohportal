<%@ include file="/html/admin/chamdiem/init.jsp" %>

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
<liferay-util:include page="/html/admin/chamdiem/chamdiemphongban.jsp"  servletContext="<%=application %>" />
<%}else if(menuId==1){
%>
<liferay-util:include page="/html/admin/chamdiem/chamdiembaiviet.jsp"  servletContext="<%=application %>" />
<%}else if(menuId==2){
%>
<liferay-util:include page="/html/admin/chamdiem/chamdiembaivietngoai.jsp"  servletContext="<%=application %>" />
<%}%>