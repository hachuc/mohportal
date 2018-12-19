<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideoCategory"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.swing.plaf.ListUI"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.List"%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/videoplayer/init.jsp"%>

<div class="media-tab">
	<liferay-ui:tabs names="video-library,image-library" refresh="false" tabsValues="video-library,image-library">
		<div class="media-tab-content">
			<liferay-ui:section>
				<liferay-util:include page='<%="/html/videoplayer/display-style/tab-video-gallery.jsp" %>' servletContext="<%= application %>" />
			</liferay-ui:section>
			
			<liferay-ui:section>
				<liferay-util:include page='<%="/html/videoplayer/display-style/tab-image-gallery.jsp" %>' servletContext="<%= application %>" />
			</liferay-ui:section>
		</div>
	</liferay-ui:tabs>
</div>