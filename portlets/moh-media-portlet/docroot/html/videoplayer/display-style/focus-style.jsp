<%@page import="com.revotech.portal.videolibrary.util.VideoConstants"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.revotech.portal.videolibrary.util.VideoFileUtil"%>
<%@page
	import="com.revotech.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.revotech.portal.videolibrary.model.VLVideo"%>
<%@page
	import="com.revotech.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.videolibrary.model.VLVideoCategory"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.swing.plaf.ListUI"%>
<%@page
	import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page
	import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript"
	src="/moh-media-portlet/js/swfobject.js"></script>
<%@include file="/html/videoplayer/init.jsp"%>
<%
	long selectedVideoId = ParamUtil.getLong(request, "selectedVideoId", 0L);

	HashMap<Long, VLVideo> map = new HashMap<Long, VLVideo>();
	
	VLVideo playVideo = null;
	
	long[] videoIds = StringUtil.split(selectedVideosId, 0L);
	
	if(videoIds != null && videoIds.length > 0){
		for(long videoId:videoIds){
			if(videoId > 0){
				VLVideo video = null;
				try{
			video = VLVideoLocalServiceUtil.getVLVideo(videoId);
			
				}catch(Exception e){
			_log.error(e);
				}
				
				if(video != null && !video.isInvisible()){
			
			if(!map.containsKey(videoId)){
				map.put(videoId, video);
			}
				}
			}
		}
	}else if(categoryVideoDisplay > 0L){
		List<VLVideo> lstVideos = VLVideoLocalServiceUtil.findByCategoryId(categoryVideoDisplay, groupId, 0, numbersOfVideoDisplay);
		if(lstVideos!=null && !lstVideos.isEmpty()){
			for(VLVideo video : lstVideos){
				map.put(video.getVideoId(), video);
			}
		}
	}
	if(selectedVideoId <= 0){
		try{
			Entry<Long,VLVideo> entry = map.entrySet().iterator().next();
			Long key= entry.getKey();
			selectedVideoId = key;
		}catch(Exception e){
			_log.warn(e);
		}
	}
	playVideo = map.get(selectedVideoId);
%>
<c:if test="<%=Validator.isNotNull(styleTitle)%>">
	<div class="mt15">
		<div class="headerBox">
			<%=styleTitle%>
		</div>
	</div>
</c:if>
<c:choose>
	<c:when test="<%=!map.isEmpty() && playVideo!= null%>">

		<div class="">
			<%
				String playVideoTitle = playVideo.getVideoName();
							
							String playVideoURL = StringPool.BLANK;
							
							String playVideoThumbnailURL = request.getContextPath() +  "/images/videoclip.jpg";
							
							boolean isYoutube = false;
							
							if(Validator.equals(playVideo.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
								
								if (playVideo.getVideoUrl().toLowerCase().contains("youtube")){
									isYoutube = true;
									String externalVideoId = VideoFileUtil.getVideoIdFromYoutubeURL(playVideo.getVideoUrl());
									playVideoURL = VideoFileUtil.getEmbedYoutubeVideoURL(videoWidth, videoHeight, externalVideoId);
								}
								else{
									playVideoURL = prefixLink + playVideo.getVideoUrl();
								}
								
							}else{
								if(playVideo.getFileId() > 0){
									
									FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(playVideo.getFileId());
									
									if(videoFileEntry != null){
										
										playVideoURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
									}
								}
							}
							if(playVideo.getImage() && playVideo.getImageId() > 0){
								
								FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(playVideo.getImageId());
								
								if(thumbnailImage != null){
									playVideoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
								}
							}
							else if(Validator.isNotNull(playVideo.getSmallImageUrl())){
								playVideoThumbnailURL = prefixLink + playVideo.getSmallImageUrl();
							}
			%>
			<div class="video-player-frame Box_Video_Image">
				<div id="videoPlayer">
					<c:if test='<%=isYoutube %>'>
					<div class="external-video-frame" width="100%" id="videoPlayer1">
						<%= playVideoURL %>
					</div>
					</c:if>
					<c:if test='<%=!isYoutube %>'>
					<video controls src="<%= playVideoURL %>" id="videoPlayer2" poster="<%=playVideoThumbnailURL %>" width="100%">
						<p>Trinh duyet khong ho tro</p>
					</video>
					</c:if>
				</div>
				<div id="titleVideo" class="st_title text-bold"> <a href="#" target="_blank"><%= playVideoTitle %></a> </div>				
				<ul id="playlist" class="chuyendelink">
					<%
						for(Entry<Long, VLVideo> entry : map.entrySet()) {
							    long key = entry.getKey();
							    //if(key != selectedVideoId){
							    	 VLVideo video = entry.getValue();
							    	 String playURL = StringPool.BLANK;
							    	 String ThumbnailURL = request.getContextPath()+ "/images/videoclip.jpg";
							    	 boolean isYtb = false;
							    	 if(Validator.equals(video.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
							    		 if (video.getVideoUrl().toLowerCase().contains("youtube")){											
							    			 String externalVideoId = VideoFileUtil.getVideoIdFromYoutubeURL(playVideo.getVideoUrl());
											 playURL = VideoFileUtil.getEmbedYoutubeVideoURL(videoWidth, videoHeight, externalVideoId);
											 isYtb = true;
											}
							    		 else{
							    			 playURL = prefixLink + video.getVideoUrl();
							    		 }
											
										}else{
										
											if(video.getFileId() > 0){
												
												FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(video.getFileId());
												FileEntry thumbnailImage2 = DLAppServiceUtil.getFileEntry(video.getImageId());
												if(videoFileEntry != null){
													
													playURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
												}
												
												if(thumbnailImage2 != null){
													
													ThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage2);
												}
											}
											
											
										}
							    	 if (!isYtb){	
							    	 
					%>
					<li movieurl="<%= playURL%>" moviesposter="<%=ThumbnailURL%>" data-title="<%=HtmlUtil.escape(video.getVideoName())%>" class='<%= key == selectedVideoId ?"hidden":"" %>'
						moviestype="video"><i class="fa fa-play-circle-o"></i><a class="media" href="javascript:void(0);"><%=HtmlUtil.escape(video.getVideoName())%></a></li>
					<%
							    }
							    	 else{ %>
						<li movieurl="<%=video.getVideoUrl()%>" moviesposter="<%=ThumbnailURL%>" data-title="<%=HtmlUtil.escape(video.getVideoName())%>" class='<%= key == selectedVideoId ?"hidden":"" %>'
						moviestype="youtube"><i class="fa fa-play-circle-o"></i><a class="media" href="javascript:void(0);"><%=HtmlUtil.escape(video.getVideoName())%></a></li>	    	 
							    	 <%	 
							    }}
					%>
				</ul>

			</div>
			<script type="text/javascript">
				$(function() {
					var videoPlayer = $("#videoPlayer");
					$("#playlist li").on("click",function() {
						$("#playlist li").removeClass("hidden");
						$(this).addClass("hidden");
						$("#titleVideo").text($(this).attr('data-title'));
						if ($(this).attr("moviestype") && $(this).attr("moviestype") == "video") {
							
							var video = $('<video />', {
							    id: 'videoPlayer2',
							    src: $(this).attr("movieurl"),
							    poster: $(this).attr("moviesposter"),
							    type: 'video/mp4',
							    controls: true,
							    autoplay: true,
							    width: '100%'
							});
							videoPlayer.empty();
							video.appendTo(videoPlayer);
						} else if ($(this).attr("moviestype") && $(this).attr("moviestype") == "youtube") {
							
							var obj = {"video": {
								"value": "<iframe title='YouTube video player' type=\"text/html\" width='<%= videoWidth%>' height='<%= videoHeight%>' src='" + $(this).attr("movieurl").replace("watch?v=","embed//") + "' frameborder='0' allowFullScreen></iframe>"
								}}
							
							videoPlayer.empty();
							videoPlayer.html(obj.video.value);
						}
					})
				})
			</script>
			<c:if test='<%=showViewMoreVideoLink%>'>
				<%
					Layout layoutTemp = LayoutLocalServiceUtil
										.getLayout(videoPageLayoutId);

								String viewMoreVideoURL = PortalUtil
										.getLayoutFriendlyURL(layoutTemp, themeDisplay);
				%>
				<div class="view-more-video-link">
					<a href="<%=viewMoreVideoURL%>"><liferay-ui:message
							key="view-more-video" /></a>
				</div>

				<div style="clear: both;"></div>
			</c:if>
		</div>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg">
			<liferay-ui:message key="no-video-found" />
		</div>
	</c:otherwise>
</c:choose>
