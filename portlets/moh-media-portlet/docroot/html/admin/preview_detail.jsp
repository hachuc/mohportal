

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.revotech.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.revotech.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.revotech.portal.videolibrary.model.VLVideo"%>
<%@page import="com.revotech.portal.videolibrary.util.VideoConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long videoId = ParamUtil.getLong(request, "videoId");

	VLVideo video = null;
	String fileName ="";
	String rankName ="";
	String fileUrl ="";
	VLCategory category = null;
	
	if(videoId > 0){
		video = VLVideoLocalServiceUtil.getVLVideo(videoId);
		
		category = VLCategoryLocalServiceUtil.fetchVLCategory(categoryId);
		FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(video.getFileId());
		
		
		if(Validator.equals(video.getVideoType(), VideoConstants.INTERNAL_VIDEO_TYPE)){
			rankName = VideoConstants.INTERNAL_NAME;
		}else if(Validator.equals(video.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
			rankName = VideoConstants.EXTERNAL_NAME;
		}
		
		if(videoFileEntry != null){
			fileName = videoFileEntry.getTitle();
			fileUrl = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
		}
	}

%>
<c:if test="<%=video != null%>">
		<table style="width:100%;margin-left:10px">
			<tr>
				<td class="title-table"><liferay-ui:message key="doc-code" /></td>
				<td class="value-table"><b><%=video.getVideoName() %></b></td>
			</tr>
			<tr>
				<td class="title-table"><liferay-ui:message key="video-category" />Lĩnh vực</td>
				<td class="value-table"><%=category.getCategoryName() %></td>
			</tr>
			<tr>
				<td class="title-table"><liferay-ui:message key="video-type" /></td>
				<td class="value-table"><%= rankName %></td>
			</tr>
			<tr>
				<td class="title-table"><liferay-ui:message key="company-name" /></td>
				<td class="value-table"><%=video.getDescription() %></td>
			</tr>
			<tr>
				<td class="title-table"><liferay-ui:message key="link-result" /></td>
				<td class="value-table"><a target="_blank" href="<%=video.getSmallImageUrl() %>"><liferay-ui:message key="view-result" /> </a></td>
			</tr>
			<tr>
				<td class="title-table"><liferay-ui:message key="file-name" /></td>
				<td class="value-table"><a href="<%=fileUrl%>"><%=fileName %></a></td>
			</tr>
		</table>
		
	</c:if>



