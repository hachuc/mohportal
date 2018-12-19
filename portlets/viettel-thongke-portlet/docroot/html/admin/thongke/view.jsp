<%@page import="java.util.List"%>
<%@ include file="/html/init.jsp" %>

<aui:fieldset >
	<aui:column columnWidth="100">
	    <div id="headerReport"></div>
		<liferay-util:include page="/html/admin/thongke/toolbar.jsp"  servletContext="<%=application %>" />
		<liferay-util:include page="/html/admin/thongke/baocao.jsp"  servletContext="<%=application %>" />
	</aui:column>
</aui:fieldset>
