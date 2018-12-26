<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long videoId = ParamUtil.getLong(request, "videoId");

	VLVideo video = null;
	
	if(videoId > 0){
		video = VLVideoLocalServiceUtil.getVLVideo(videoId);
	}

%>

	<c:if test="<%=video != null%>">
			<div class="preview-video-title">
				<%=HtmlUtil.escape(video.getVideoName()) %>
			</div>
			
			<div class="preview-video-description">
				<%=HtmlUtil.escape(video.getDescription()) %>
			</div>
			
			<c:choose>
				<c:when test='<%=Validator.equals(video.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE) %>'>
					<div class="video-embed-preview"><%=video.getVideoUrl() %></div>
				</c:when>
				<c:otherwise>
				<%
					String videoURL = StringPool.BLANK;
							
					String videoThumbnailURL = request.getContextPath() + "/images/default-video-thumbnail.jpg";
							
					if(video.getFileId() > 0){
								
						FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(video.getFileId());
								
						if(videoFileEntry != null){
									
							videoURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
						}
					}
							
					if(video.getImage() && video.getImageId() > 0){
								
						FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(video.getImageId());
								
						if(thumbnailImage != null){	
							videoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
						}
					}
				%>
							
				<div id="<portlet:namespace />video-player-container" class="video-player-frame" >
					<div class="video-player" id="<portlet:namespace />videoPlayer"></div>
				</div>
				<aui:script>
					AUI().ready(function(A){
						jwplayer("<portlet:namespace />videoPlayer").setup({
							flashplayer: request.getContextPath() + '/jwplayer/jwplayer.flash.swf',
							file: '<%=videoURL%>',
							image: '<%=videoThumbnailURL %>',
						    height: 350,
							width: 568
						});
					});
				</aui:script>
			</c:otherwise>
		</c:choose>
	</c:if>