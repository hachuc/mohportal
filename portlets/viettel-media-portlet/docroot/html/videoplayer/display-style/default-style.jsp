<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
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
<style type="text/css">
	/*.video-title h5 {
	    color: rgba(0,0,0,0.54);
	    font-size: 1.2rem;
	    font-weight: 500;
	    text-transform: uppercase;
	    line-height: 40px;
	    border-bottom: solid 3px rgba(0,0,0,0.38);
	}*/
	
	.video-player-wrapper span.title {
	    display: block;
	    margin: .5rem 0;
	    font-size: 1rem;
	    font-weight: 500;
	    color: rgba(0,0,0,0.87);
	    min-height: 42px;
	}	
	
	@media screen and (min-width: 768px){
		.aui  #videoCarousel  .carousel-indicators {
		    bottom: 50px;
		}
	}
	
	#videoCarousel .carousel-control span.glyphicon{
		margin-top: -40px;
	}	
	
	.video-player .play-icon{
		position: absolute;
	    top: 36%;
	    left: 44%;
	    cursor: pointer;
	}
	.aui #videoCarousel .carousel-control{
		top:50%;
		bottom: 50%;
	}
</style>
<%
	HashMap<Long, VLVideo> map = new HashMap<Long, VLVideo>();
	if(numbersOfVideoDisplay > 0){
		 List<VLVideo> list = VLVideoLocalServiceUtil.findByGroup(groupId, 0, numbersOfImageDisplay);
		 for(VLVideo video : list){
		 	if(!video.isInvisible()){
				if(!map.containsKey(video.getVideoId())){
					map.put(video.getVideoId(), video);
				}
		 	}
		 }
	}
	else if(categoryVideoDisplay >= 0){
		 List<VLVideo> list = VLVideoLocalServiceUtil.findByCategoryId(categoryVideoDisplay, groupId);
		 for(VLVideo video : list){
		 	if(!video.isInvisible()){
				if(!map.containsKey(video.getVideoId())){
					map.put(video.getVideoId(), video);
				}
		 	}
		 }
	}
	else if(selectedVideosId != null && !selectedVideosId.isEmpty()){
		long[] videoIds = StringUtil.split(selectedVideosId, 0L);
		if(videoIds != null && videoIds.length > 0){
			for(long videoId : videoIds){
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
		}
	}
%>
<c:if test="<%=Validator.isNotNull(styleTitle) %>">
	<div class="mt15">
		<div class="headerBox">
			<%=styleTitle %>
		</div>
	</div>
</c:if>
 <c:choose>
	<c:when test="<%=!map.isEmpty()%>">
<div class="row">
	<div id="videoCarousel" class="carousel slide" data-ride="carousel" data-interval="false">
	  <!-- Indicators -->
	  <ol class="hide-when-play carousel-indicators">
	  
		<%
			for (int i = 0; i < map.size(); i++) {
		%>
	    	<li data-target="#videoCarousel" data-slide-to="<%= i %>" class='<%= (i == 0 ? "active" : "")%>'></li>
		<%
			}
		 %>
	  </ol>
		<div class="carousel-inner video-player-default-style">
			<%
			int i = 0;
			for(Entry<Long, VLVideo> entry : map.entrySet()) {
				VLVideo playVideo = entry.getValue();
				String playVideoTitle = playVideo.getVideoName();
				
				String playVideoURL = StringPool.BLANK;
				
				String playVideoThumbnailURL = request.getContextPath() +  "/images/default-video-thumbnail.jpg";
				
				boolean isYoutube = false;
				
				if(Validator.equals(playVideo.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
					if (playVideo.getVideoUrl().toLowerCase().contains("youtube")){
						isYoutube = true;
						String externalVideoId = VideoFileUtil.getVideoIdFromYoutubeURL(playVideo.getVideoUrl());
						playVideoURL = VideoFileUtil.getEmbedYoutubeVideoURL(videoWidth, videoHeight, externalVideoId);
					}
					else{
						playVideoURL = playVideo.getVideoUrl();
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
			%>
			<div class='item video-player-frame reset <%= i == 0 ? "active" : "" %>' >
				<c:choose>
					<c:when test='<%=isYoutube %>'>
						<div class="external-video-frame">
							<%=HtmlUtil.escape(playVideoURL) %>
						</div>
					</c:when>
					
					<c:otherwise>
						<div class="video-player" id="" >
							<video width="100%" class=" video-<%=i %>" data-index="<%=i%>" controls>
							  <source src="<%=playVideoURL %>">
							  Your browser does not support the video tag.
							</video>
							<img data-index="<%=i %>" class="play-icon play-icon-<%=i %>" src="/viettel-media-portlet/images/play-icon.png" alt="PLAY"/>
						</div>
						
					</c:otherwise>
				</c:choose>
				<span class="title"><%=StringUtil.shorten(HtmlUtil.escape(playVideo.getVideoName()), 255) %></span>
			</div>
			<% i++;} %>
		</div>
		  <!-- Left and right controls -->		
		  <a class="hide-when-play left carousel-control" href="#videoCarousel" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="hide-when-play right carousel-control" href="#videoCarousel" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>		
	</div>
	<c:if test='<%=showViewMoreVideoLink %>'>
		<%
		Layout layoutTemp = LayoutLocalServiceUtil.getLayout(videoPageLayoutId);
		
		String viewMoreVideoURL = PortalUtil.getLayoutFriendlyURL(layoutTemp, themeDisplay);
		%>
		<div class="view-more-video-link">
			<a href="<%=viewMoreVideoURL%>"><liferay-ui:message key="view-more-video"/></a>
		</div>
		
		<div style="clear: both;"></div>
	</c:if>	
</div>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg"><liferay-ui:message key="no-video-found"/></div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	$(document).ready(function(){
		$('.external-video-frame iframe').css({
			'width'  : '100%',
			'max-width' : '100%',
			'height' : ((9.0/16.0) * $('.external-video-frame').parent().width()) + "px"
		});
		
		$('.video-player video').bind('click', function(e){
			if($(e.target).get(0).paused){
				$(e.target).get(0).play();
				var currentVideoIndex = $(e.target).attr('data-index');
				$('.play-icon-' + currentVideoIndex).hide();
				$('.hide-when-play').hide();
			}
			else{
				$(e.target).get(0).pause();
				var currentVideoIndex = $(e.target).attr('data-index');
				$('.play-icon-' + currentVideoIndex).show();
				$('.hide-when-play').show();
			}
		});
		
	    $('.video-player video').on('ended',function(e){
			var currentVideoIndex = $(e.target).attr('data-index');
			$('.play-icon-' + currentVideoIndex).show();
			$('.hide-when-play').show();
      	});
	    
	    $('.video-player video').on('play', function (e) {
			var currentVideoIndex = $(e.target).attr('data-index');
			$('.play-icon-' + currentVideoIndex).hide();
			$('.hide-when-play').hide();
	    });
		
		$('.play-icon').bind('click', function(e){
			$('.video-player video').get(0).pause();
			$(e.target).hide();
			var currentVideoIndex = $(e.target).attr('data-index');
			$('.video-' + currentVideoIndex).get(0).play();
			$('.hide-when-play').hide();
		});
	});
</script>


