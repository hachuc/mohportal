
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/videoplayer/init.jsp"%>
<div class="video-player-wrapper">
<c:choose>
	<c:when test="<%=Validator.isNotNull(displayStyle) %>">
		<c:if test='<%=Validator.equals(displayStyle, "default-style") %>'>
			<liferay-util:include page="/html/videoplayer/display-style/default-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
		
		<c:if test='<%=Validator.equals(displayStyle, "focus-style") %>'>
			<liferay-util:include page="/html/videoplayer/display-style/focus-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
		
		<c:if test='<%=Validator.equals(displayStyle, "videoWidget") %>'>
			<liferay-util:include page="/html/videoplayer/display-style/videoWidget.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
			
		<c:if test='<%=Validator.equals(displayStyle, "gallery-style") %>'>
			<liferay-util:include page="/html/videoplayer/display-style/gallery-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
					
		<c:if test='<%=Validator.equals(displayStyle, "slider-style") %>'>
			<liferay-util:include page="/html/videoplayer/display-style/slider-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
		<c:if test='<%=Validator.equals(displayStyle, "grid-style") %>'>
			<liferay-util:include page="/html/videoplayer/display-style/grid-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
		<c:if test='<%=Validator.equals(displayStyle, "image-video-tab-style") %>'>
			<liferay-util:include page="/html/videoplayer/display-style/image-video-tab-style.jsp" servletContext="<%=getServletContext() %>"/>
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
