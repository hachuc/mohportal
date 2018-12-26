
<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLCategory"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.viettel.portal.videolibrary.search.VideoSearch"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/videoplayer/init.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$(".list-video").jCarouselLite({ // Lấy class của ul và gọi hàm jCarouselLite() trong thư viện
			btnNext : ".next_QC",
			btnPrev : ".prev_QC",
			vertical : false, // chạy theo chiều dọc
			hoverPause : true, // Hover vào nó sẽ dừng lại
			visible : 6, // Số bài viết cần hiện
			auto : 5000, // Tự động scroll
			speed : 2000
		// Tốc độ scroll
		});
	});
</script>
<liferay-portlet:renderURL var="viewVideoURL"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	<liferay-portlet:param name="mvcPath"
		value="/html/videoplayer/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="searchVideoURL">
	<liferay-portlet:param name="mvcPath"
		value="/html/videoplayer/view.jsp" />
</liferay-portlet:renderURL>

<%
	long videoId = ParamUtil.getLong(request, "videoId", -1L);
	int total = 0;
	int offset = 1;
	int delta = 2;
	int curPage = ParamUtil.getInteger(request, "curPage", 1);
	int start = (curPage - 1) * delta;
	int end = start + delta;
	int totalPage = 1;
	VLVideo playVideo = null;
	List<VLCategory> categories = new ArrayList<VLCategory>();
	List<VLVideo> videos = new ArrayList<VLVideo>();

	String videoURL = StringPool.BLANK;
	String videoThumbnailURL = request.getContextPath() + "/images/default-video-thumbnail.jpg";
	String portletId = portletDisplay.getId();
	//SearchContainer searchContainer = new VideoSearch(renderRequest, videoPlayerURL);
	try{
		total = (int)VLVideoLocalServiceUtil.countByByKeyword(scopeId, categoryId, keywords);
		
		if(total > delta){
	if(total % delta == 0){
		totalPage = total / delta;
	}else{
		totalPage = (int)(total / delta) + 1;
	}
		}
		videos = VLVideoLocalServiceUtil.findByKeyword(scopeId, categoryId, keywords, 
		start, end, null);
		categories = VLCategoryLocalServiceUtil.findByGroupAndState(scopeId, false);
		
		if(videoId > 0){
	playVideo = VLVideoLocalServiceUtil.getVLVideo(videoId);
		}else{
	playVideo = videos.get(0);
		}
	}catch(Exception e){
		_log.error(e);
	}
	LiferayPortletURL pageURL = 
	PortletURLFactoryUtil.create(request, portletId, layout.getLayoutId(), PortletRequest.RENDER_PHASE);
	pageURL.setParameter("mvcPath", "/html/videoplayer/view.jsp");
	pageURL.setParameter("keywords", keywords);
	pageURL.setParameter("categoryId", String.valueOf(categoryId));
	pageURL.setPlid(layout.getPlid());
	//searchContainer.setResults(videos);
	//searchContainer.setTotal(total);
%>
<div class="grid-view-wrapper">
	<c:if test="<%=playVideo!= null%>">
		<div class="video-title">
			<%=HtmlUtil.escape(playVideo.getVideoName())%>
		</div>
	</c:if>

	<div class="player-wrapper">
		<c:choose>
			<c:when test="<%=playVideo!= null%>">
				<div class="player-video">
					<%
						if(playVideo.getImage() && playVideo.getImageId() > 0){
									
							FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(playVideo.getImageId());
									
							if(thumbnailImage != null){
										
								videoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
							}
						}
								
						if(Validator.equals(playVideo.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE) && playVideo.getVideoUrl().toLowerCase().contains("youtube")){
							
							String externalVideoId = VideoFileUtil.getVideoIdFromYoutubeURL(playVideo.getVideoUrl());
									
							videoURL = VideoFileUtil.getEmbedYoutubeVideoURL(videoWidth, videoHeight, externalVideoId);
					%>
					<div class="external-video-frame">
						<%=videoURL%>
					</div>
					<%
						} else {
											
							if(playVideo.getFileId() > 0){
										
								FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(playVideo.getFileId());
										
								if(videoFileEntry != null){		
									videoURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
								}
							}
							else{
								videoURL = playVideo.getVideoUrl();
							}
					%>
					<div class="video-player" id="<portlet:namespace />videoPlayer"></div>
					<aui:script>
						AUI()
								.ready(
										function(A) {
											jwplayer(
													"<portlet:namespace />videoPlayer")
													.setup(
															{
																flashplayer : '<%= request.getContextPath() + "/jwplayer/jwplayer.flash.swf" %>',
																file : '<%=videoURL%>',
																image : '<%=videoThumbnailURL%>',
																height : '<%=videoHeight%>',
																width : '<%=videoWidth%>',
																autostart : <%=autoPlay %>,
																controls : true
															});

											jwplayer(
													"<portlet:namespace />videoPlayer")
													.onReady(
															function() {
																A
																		.one(
																				'#<portlet:namespace />videoPlayer_logo')
																		.setStyle(
																				'display',
																				'none');
															});
										});
					</aui:script>
								
					
							<%
						}
					%>
				</div>
			</c:when>
			<c:otherwise>
				<div class="portlet-msg">
					<liferay-ui:message key="no-found-video" />
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="search-form">
		<aui:form name="searchfm" method="post" action="<%=searchVideoURL%>">
			<div class="search-form-row">
				<span class="row-label"> <liferay-ui:message key="keywords" />
				</span> <span class="row-input"> <aui:input type="text"
						placeholder="keywords" value="<%=keywords%>" name="keywords"
						label="" />
				</span>
			</div>

			<div class="search-form-row">
				<span class="row-label"> <liferay-ui:message key="category" />
				</span> <span class="row-input"> <aui:select name="categoryId"
						label="">
						<aui:option value="-1">
							<liferay-ui:message key="all" />
						</aui:option>
						<c:if test="<%=categories != null%>">
							<%
								for(VLCategory category:categories){
							%>
							<aui:option value="<%=category.getCategoryId()%>"
								selected="<%=category.getCategoryId() == categoryId%>"><%=HtmlUtil.escape(category.getCategoryName())%></aui:option>
							<%
								}
							%>
						</c:if>
					</aui:select>
				</span>
			</div>

			<div class="search-form-row">
				<span class="row-label"></span> <span class="row-input"> <aui:button
						type="submit" cssClass="btnSearchVideo" name="search"
						value="search" />
				</span>
			</div>
		</aui:form>
	</div>

	<c:if test="<%=videos != null && !videos.isEmpty()%>">
		<div class="list-video-wrapper">
			<div class="list-video-title">
				<liferay-ui:message key="Video" />
			</div>

			<div class="list-video">
				<ul style="margin: 0px; padding: 0px; position: relative; list-style-type: none; z-index: 1; width: 2533px; left: -1341px;">
					<%
						for(VLVideo video:videos){
									LiferayPortletURL url = videoPlayerURL;
									url.setParameter("videoId", String.valueOf(video.getVideoId()));
									url.setParameter("keywords", keywords);
									url.setParameter("categoryId", String.valueOf(categoryId));
													
									String itemThumbnailURL = request.getContextPath() + "/images/default-video-thumbnail.jpg";
														
									if(video.getImage() && video.getImageId() > 0){
										FileEntry thumbnailImage = null;
										try{
											thumbnailImage = DLAppServiceUtil.getFileEntry(video.getImageId());
										}catch(Exception e){
											_log.error(e);
										}
															
										if(thumbnailImage != null){
											itemThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
										}
									}
					%>
					<li class="video-item" style="overflow: hidden; float: left; width: 136px; height: 85px;"><span class="item-container"> <span
							class="item-row"> <span class="item-content"> <a
									href="<%=url%>"><img alt="<%=video.getDescription()%>"
										title="<%=HtmlUtil.escape(video.getVideoName())%>" src="<%=itemThumbnailURL%>"></a>
							</span>
						</span> <span class="item-row"> <span class="item-title"> <a
									href="<%=url%>" title="<%=HtmlUtil.escape(video.getVideoName())%>"><%=StringUtil.shorten(HtmlUtil.escape(video.getVideoName()), 50)%></a>
							</span>
						</span>
					</span></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</c:if>
</div>
<c:if test="<%=videos != null && !videos.isEmpty()%>">
	<div id="<portlet:namespace/>pagination"
		class="pagination pagination-large video-pagination"></div>
	<aui:script>
		AUI().use(
				'aui-base',
				'liferay-portlet-url',
				'aui-pagination',
				function(A) {
					new A.Pagination({
						after : {
							changeRequest : function(event) {
								var page = event.state.page;
								/* var pageURL = Liferay.PortletURL.createRenderURL();
								pageURL.setParameter("curPage", page);
								pageURL.setParameter("mvcPath", "/html/videoplayer/view.jsp");
								pageURL.setPortletId('<%=portletId%>');
								pageURL.setParameter("keywords", '<%=keywords%>');
								pageURL.setParameter("categoryId", '<%=categoryId%>');
								pageURL.setPlid('<%= layout.getPlid() %>'); */

								var pageURL = '<%=pageURL.toString()%>';
								pageURL = pageURL + '&_' + '<%=portletId%>'
										+ '_curPage=' + page;
								if (page != '<%=curPage%>') {
									window.location.href = pageURL.toString();
								}
							}
						},
						boundingBox : '#<portlet:namespace/>pagination',
						offset : '<%=offset%>',
						page : '<%=curPage%>',
						strings : {
							next : '»',
							prev : '«'
						},
						total : '<%=totalPage%>'
					}).render();
				});
	</aui:script>
		

	</c:if>

