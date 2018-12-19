<%@page import="java.util.List"%>
<%@ include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<aui:fieldset >
    <aui:column columnWidth="15">
		<liferay-util:include page="/html/admin/nhuanbut/menus.jsp"  servletContext="<%=application %>" />
	</aui:column>
	<aui:column columnWidth="85">
	    <div id="headerReport">
	    
	    </div>
	    <liferay-util:include page="/html/admin/nhuanbut/nhuanbut.jsp"  servletContext="<%=application %>" />
	    	
		
	</aui:column>
</aui:fieldset>
