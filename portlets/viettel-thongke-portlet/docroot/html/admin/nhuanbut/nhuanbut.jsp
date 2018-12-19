<%@ include file="/html/admin/nhuanbut/init.jsp" %>

<%
/*String keywords = ParamUtil.getString(request, "keywords","");
String fromDate = ParamUtil.getString(request, "fromDate","");
String toDate = ParamUtil.getString(request, "toDate","");
System.out.println("menuId: "+menuId);
System.out.println("keywords: "+keywords);
System.out.println("fromDate: "+fromDate);
System.out.println("toDate: "+toDate); */

if(menuId==0){ %>
	<liferay-util:include page="/html/admin/nhuanbut/xuatbaocao.jsp"  servletContext="<%=application %>" />
	<liferay-util:include page="/html/admin/nhuanbut/bangkenhuanbut.jsp"  servletContext="<%=application %>" />
<%}else if(menuId==5){ %>
	<%-- <liferay-util:include page="/html/admin/nhuanbut/toolbar.jsp"  servletContext="<%=application %>" /> --%>
	<%-- <liferay-util:include page="/html/admin/nhuanbut/bangquanlynhuanbut.jsp"  servletContext="<%=application %>" /> --%>
	<liferay-util:include page="/html/admin/nhuanbut/xuatbaocao.jsp"  servletContext="<%=application %>" />
	<liferay-util:include page="/html/admin/nhuanbut/bangkenhuanbut.jsp"  servletContext="<%=application %>" />
<%}%>