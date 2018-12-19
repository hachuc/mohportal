<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/photo/init.jsp"%>
<div class="Around_Video_Image Box_Tab_Video">
<c:choose>
	<c:when test="<%=Validator.isNotNull(displayStyle) %>">
		<c:if test='<%=displayStyle == null || displayStyle.isEmpty() || Validator.equals(displayStyle, "default-style") %>'>
			<liferay-util:include page="/html/photo/display/photos_carousel.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
	</c:when>
	
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
				label="please-config-this-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>
</div>
