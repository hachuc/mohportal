<%@page import="com.revotech.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.revotech.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.revotech.portal.videolibrary.model.VLVideo"%>
<%@page import="com.revotech.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.videolibrary.model.VLVideoCategory"%>
<%@page import="javax.portlet.PortletURL"%>
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

	List<VLVideo> videoList = new ArrayList<VLVideo>();

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
					
					if(!videoList.contains(video)){
						videoList.add(video);
					}
				}
			}
		}
	}

%>
<c:choose>
	<c:when test="<%=!videoList.isEmpty()%>">
		<div class="video-slider-style">

			<div class="style-title">
				<span><%=styleTitle %></span>
			</div>
			
			<div class="style-content">
				<ul id="<portlet:namespace/>jcarousel" class="jcarousel-skin-tango">
					<%
					for(VLVideo videoEntry : videoList){
						
						String videoTitle = StringUtil.shorten(videoEntry.getVideoName(),40);
						
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
						
					%>
					
						<liferay-portlet:renderURL var="videoPlaylistURL" plid="<%=videoPageLayoutId %>">
							<liferay-portlet:param name="videoId" value="<%=String.valueOf(videoEntry.getVideoId()) %>"/>
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
									<a href="<%=videoPlaylistURL %>" title="<%=HtmlUtil.escape(videoTitle) %>">
										<span class="video-title"><%=HtmlUtil.escape(videoTitle) %></span>
									</a>
								</div>
							</div>
						</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
				
		<script type="text/javascript">
		
			jQuery(document).ready(function() {
			    jQuery('#<portlet:namespace/>jcarousel').jcarousel({        
			    	scroll: 1,
			    	auto: 10,
			    	wrap: 'both'
			    });
			});
		</script>
	</c:when>
	<c:otherwise>
		<liferay-portlet:renderURL var="allVideoCategorytURL">
			<liferay-portlet:param name="categoryId" value="0"/>
		</liferay-portlet:renderURL>
		<div class = "back-link">
			<a href = "<%=allVideoCategorytURL %>">
				<span class ="back-link-title">
					<liferay-ui:message key="list-categories"/>
				</span>
			</a>
		</div>
		<hr>	
		<liferay-ui:message key="no-video-found"/>
	</c:otherwise>
</c:choose>

