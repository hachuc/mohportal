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
 <c:choose>
	<c:when test="<%=!map.isEmpty() && playVideo!= null%>">
		<div class="video-player-default-style">
			<%
			String playVideoTitle = playVideo.getVideoName();
			
			String playVideoURL = StringPool.BLANK;
			
			String playVideoThumbnailURL = request.getContextPath() + "/images/default-video-thumbnail.jpg";
			
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
			<div class="video-player-frame" >
				<c:choose>
					<c:when test='<%=isYoutube %>'>
						<div class="external-video-frame">
							<%=playVideoURL %>
						</div>
					</c:when>
					
					<c:otherwise>
						<div class="video-player" id="<portlet:namespace />videoPlayer"></div>
									
						<aui:script>
							AUI().ready(function(A){
								jwplayer("<portlet:namespace />videoPlayer").setup({
									flashplayer : '<%= request.getContextPath() + "/jwplayer/jwplayer.flash.swf" %>',
									file: '<%=playVideoURL%>',
									image: '<%=playVideoThumbnailURL %>',
									height: '<%=videoHeight%>',
									width: '<%=videoWidth%>',
									autostart: <%=autoPlay %>
						        });
						        jwplayer("<portlet:namespace />videoPlayer").onReady (function (){
						        	 A.one('#<portlet:namespace />videoPlayer_logo').setStyle ('display','none');
						        });
						        
							});
						</aui:script>
					</c:otherwise>
				</c:choose>
				
				<div class="video-playlist">
					<ul>
						<li class="playing"><a href="javascript:;" title="<%=HtmlUtil.escape(playVideo.getVideoName())%>"><%=StringUtil.shorten(HtmlUtil.escape(playVideo.getVideoName()), 50) %></a></li>
						<%
						for(Entry<Long, VLVideo> entry : map.entrySet()) {
						    long key = entry.getKey();
						    if(key != selectedVideoId){
						    	 VLVideo video = entry.getValue();
						    	 %>
						    	 	<liferay-portlet:renderURL var="nextVideoURL" plid="<%=themeDisplay.getPlid() %>">
						    	 		<liferay-portlet:param name="mvcPath" value="/html/videoplayer/view.jsp"/>
						    	 		<liferay-portlet:param name="selectedVideoId" value="<%=String.valueOf(key) %>"/>
						    	 	</liferay-portlet:renderURL>
						    	 	<li class="next-video"><a href="<%=nextVideoURL.toString() %>" title="<%=HtmlUtil.escape(video.getVideoName())%>"><%=StringUtil.shorten(HtmlUtil.escape(video.getVideoName()), 50) %></a></li>
						    	 <%
						    }
						   
						}
					%>
					</ul>
					
				</div>
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
