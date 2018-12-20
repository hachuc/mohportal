
<%@ include file="/html/view/init.jsp" %>
<%
	System.out.println("displayStyle=" + displayStyle);
%>

<c:if test='<%=StringUtil.equalsIgnoreCase(displayStyle, "show-search") %>'>
	<liferay-util:include page='<%="/html/view/search/search.jsp" %>' servletContext="<%= application %>" />
</c:if>
<c:if test='<%=StringUtil.equalsIgnoreCase(displayStyle, "show-results") %>'>
	<liferay-util:include page='<%="/html/view/search/results.jsp" %>' servletContext="<%= application %>" />
</c:if>