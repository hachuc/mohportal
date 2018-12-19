<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
<%@page import="com.viettel.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLCategory"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.swing.plaf.ListUI"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideoCategory"%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/videoplayer/init.jsp"%>

<%

	long selectedVideoId = ParamUtil.getLong(request, "videoId", 0);
	
	List<VLCategory> categories = VLCategoryLocalServiceUtil.findByGroup(scopeId);
	
	categoryId = ParamUtil.getLong(request, "categoryId", 0);
	
	if (selectedVideoId > 0){
		
		List<VLVideoCategory> listMap = VLVideoCategoryLocalServiceUtil.findByVideo(selectedVideoId, scopeId);
		
		if ((Validator.isNotNull(listMap)) && (listMap.size()>0)){
			categoryId = listMap.get(0).getCategoryId();
		}
		
	}else if(categories != null && categoryId == 0){
		categoryId = categories.get(0).getCategoryId();
	}
	
	List<VLVideo> videoList = null;
	
	List<VLVideo> videoPlaylist = new ArrayList<VLVideo>();
	if(numbersOfVideoDisplay > 0){
		videoList = VLVideoLocalServiceUtil.findByCategoryId(categoryId, scopeId, 0, numbersOfVideoDisplay);
	}else{
		videoList = VLVideoLocalServiceUtil.findByCategoryId(categoryId, scopeId);
	}
	
	if(videoList.size() > 1){
		videoPlaylist = ListUtil.subList(videoList, 0, videoList.size());
	}
	
%>
<c:choose>
	<c:when test="<%=((videoList!=null)&&(!videoList.isEmpty()))%>">
	
		<div class="video-gallery-style">
		<%
			VLVideo topVideo = videoList.get(0);
					
			if(selectedVideoId > 0){
						
				autoPlay = true;
						
				topVideo = VLVideoLocalServiceUtil.getVLVideo(selectedVideoId);
						
				renderResponse.setTitle(topVideo.getVideoName());
			}
					
			String topVideoTitle = topVideo.getVideoName();
					
			String topVideoURL = StringPool.BLANK;
					
			String topVideoThumbnailURL = request.getContextPath() + "/images/default-video-thumbnail.jpg";
					
			boolean isYoutube = false;
			
			if(Validator.equals(topVideo.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
				
				if (topVideo.getVideoUrl().toLowerCase().contains("youtube")){
					isYoutube = true;
					String externalVideoId = VideoFileUtil.getVideoIdFromYoutubeURL(topVideo.getVideoUrl());
					topVideoURL = VideoFileUtil.getEmbedYoutubeVideoURL(videoWidth, videoHeight, externalVideoId);
				}
				else{
					topVideoURL = topVideo.getVideoUrl();
				}
						
			}else{
						
				if(topVideo.getFileId() > 0){
							
					FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(topVideo.getFileId());
							
					if(videoFileEntry != null){
								
						topVideoURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
					}
				}
			}
					
			if(topVideo.getImage() && topVideo.getImageId() > 0){
						
				FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(topVideo.getImageId());
						
				if(thumbnailImage != null){
							
					topVideoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
				}
			}
		%>
		<div class="left-content">			
		<div class="video-player-frame" >
			<div class="top-video-title">
				<a href="javascript:;" title="<%=topVideoTitle %>"><%=HtmlUtil.escape(topVideoTitle) %></a>
			</div>
			<c:choose>
				<c:when test='<%=isYoutube %>'>
					<div class="external-video-frame">
						<%=HtmlUtil.escape(topVideoURL) %>
					</div>
				</c:when>
				
				<c:otherwise>
					<div class="video-player" id="<portlet:namespace />videoPlayer"></div>
						<aui:script>
							AUI().ready(function(A){
								jwplayer("<portlet:namespace />videoPlayer").setup({
								        file: '<%=topVideoURL%>',
								        image: '<%=topVideoThumbnailURL %>',
						    		    height: <%=videoFrameHeight%>,
								        width: <%=videoFrameWidth%>,
								        autostart: <%=autoPlay %>
								});
							jwplayer("<portlet:namespace />videoPlayer").onReady (function (){
									A.one('#<portlet:namespace />videoPlayer_logo').setStyle ('display','none');
								});
							});
						</aui:script>
				</c:otherwise>
			</c:choose>
		</div>
					

		<div class="other-video"><span class="content"><liferay-ui:message key="other-video"/></span></div>
		<div class="video-gallery">
			<ul class="gallery-wrapper">
			<%
				for(VLVideo videoEntry : videoPlaylist){
								
					String videoTitle = videoEntry.getVideoName();
								
					String videoURL = StringPool.BLANK;
								
					if(videoEntry.getFileId() > 0){
									
						FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(videoEntry.getFileId());
									
						if(videoFileEntry != null){
										
							videoURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
						}
					}
								
					String videoThumbnailURL = request.getContextPath() + "/images/default-video-thumbnail.jpg";
								
					if(videoEntry.getImage() && videoEntry.getImageId() > 0){
									
						FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(videoEntry.getImageId());
									
						if(thumbnailImage != null){
										
							videoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
						}
					}
								
					String videoPublishDate = dateTimeFormat.format(videoEntry.getCreateDate());
				%>
							
				<liferay-portlet:renderURL var="videoPlaylistURL">
					<liferay-portlet:param name="videoId" value="<%=String.valueOf(videoEntry.getVideoId()) %>"/>
					<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
				</liferay-portlet:renderURL>
					<li class="video-entry">
						<div class="video-detail">
							<div class="video-thumbnail">
								<a href="<%=videoPlaylistURL %>" title="<%=videoTitle %>">
									<div class="play-icon"></div>
								</a>
								<a href="<%=videoPlaylistURL %>" title="<%=videoTitle %>">
									<span class="thumbnail-container">
										<img alt="<%=HtmlUtil.escape(videoTitle) %>" src="<%=videoThumbnailURL%>">
									</span>
								</a>
							</div>
										
							<div class="video-name">
								<a href="<%=videoPlaylistURL %>" title="<%=videoTitle %>">
									<span class="video-title"><%=HtmlUtil.escape(videoTitle) %></span>
										<c:if test='<%=showVideoPublishDate %>'>
											<span class="video-upload-date"><%=videoPublishDate %></span>
										</c:if>
								</a>
							</div>
						</div>
					</li>
					<%
					}
					%>
				</ul>
						
				<div style="clear:both;"></div>
			</div>
			</div>
			<div class="right-content">
				<ul>
					<li class="category-header"><liferay-ui:message key="video-category"/></li>
					<c:if test="<%=categories != null %>">
					<%
						for(VLCategory category:categories){
							String css = StringPool.BLANK;
							if(categoryId == category.getCategoryId()){
								css = "selected";
							}
							%>
								<li class="<%=css%>">
								<a href='<%=videoFullPageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "categoryId=" + category.getCategoryId()%>'>
									<%=HtmlUtil.escape(category.getCategoryName()) %>
								</a></li>
							<%
						}
					%>
					</c:if>
				</ul>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="no-video-found"/>
	</c:otherwise>
</c:choose>

