<%@ include file="/html/frontend/init.jsp" %>
<c:if test='<%= (mzId == 0 || mcId ==0) && magazineId > 0 %>'>
	<liferay-util:include page='<%="/html/frontend/display/magazine_list.jsp" %>' servletContext="<%= application %>" />
</c:if>
<c:if test='<%= mzId > 0 && mcId > 0 && magazineId > 0 %>'>
	<liferay-util:include page='<%="/html/frontend/display/magazine_detail.jsp" %>' servletContext="<%= application %>" />
</c:if>