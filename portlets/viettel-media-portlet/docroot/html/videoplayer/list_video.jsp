
<%@page import="com.viettel.portal.videolibrary.permission.VideoPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.viettel.portal.videolibrary.search.VideoSearch"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/videoplayer/init.jsp"%>


<liferay-portlet:renderURL var="searchVideoURL">
	<liferay-portlet:param name="mvcPath" value="/html/videoplayer/list_video.jsp"/>
	<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="listVideoURL" var="">
	<liferay-portlet:param name="jspPage" value="/html/videoplayer/list_video.jsp"/>
	<liferay-portlet:param name="keywords" value="<%=keywords %>"/>
	<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
</liferay-portlet:renderURL>


<div class="list-vl-video">
	<div class="form-search">
		<aui:form action="<%= searchVideoURL %>" method="post" name="fm">
			<liferay-ui:input-search id="keywords1" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
		</aui:form>
	</div>
	<liferay-ui:search-container searchContainer="<%= new VideoSearch(renderRequest, listVideoURL)%>" emptyResultsMessage="no-found-video">
		<%
			List<VLVideo> videos = VLVideoLocalServiceUtil.findByKeyword(scopeId, categoryId, keywords, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		
			total = (int)VLVideoLocalServiceUtil.countByByKeyword(scopeId, categoryId, keywords);
		%>
		
		<liferay-ui:search-container-results results="<%=videos %>" total="<%=total %>"/>
		
		<liferay-ui:search-container-row className="VLVideo" keyProperty="videoId" modelVar="video" escapedModel="<%=true %>">
			<liferay-ui:search-container-column-text name="#" cssClass="tbl_cell_video_image">
				<%
					String videoThumbnailURL = request.getContextPath() + "/images/default-video-thumbnail.jpg";
					if(video.getImage() && video.getImageId() > 0){
						FileEntry thumbnailImage = null;
						try{
							thumbnailImage = DLAppServiceUtil.getFileEntry(video.getImageId());
						}catch(Exception e){}
						
						if(thumbnailImage != null){
							videoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
						}
					}
				%>
				
				<div style="position: relative;">
					<img src = "<%=videoThumbnailURL %>" width = "130px" height = "130px"/>
					<span class="play-icon"></span>
				</div>
			</liferay-ui:search-container-column-text>
			
			<portlet:renderURL var="viewVideoURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="jspPage" value="/html/admin/preview_video.jsp" />
				<portlet:param name="videoId" value="<%=String.valueOf(video.getVideoId()) %>" />
			</portlet:renderURL>
			
			<%
			StringBundler previewVideo = new StringBundler();

			previewVideo.append("javascript:");
			previewVideo.append("viewVLVideoForm");
			previewVideo.append("('");
			previewVideo.append(viewVideoURL.toString());
			previewVideo.append("')");

			%>
			
			<liferay-ui:search-container-column-text name="video-name" orderable="<%=true %>" value="<%=video.getVideoName()%>"
				href="<%=previewVideo.toString() %>"
				title="<%=HtmlUtil.escape(video.getVideoName()) %>" valign="middle"
			/>
			
			<liferay-ui:search-container-column-text name="modified-date" value="<%=dateTimeFormat.format(video.getModifiedDate())%>"
				orderable="<%=true %>"
				orderableProperty="modified-date"
				href="<%=previewVideo.toString() %>"
			/>
			
			<liferay-ui:search-container-column-text name="created-by-user" value="<%=video.getUserName()%>" 
				orderable="<%=true %>"
				orderableProperty="user-name"
				href="<%=previewVideo.toString() %>"
			/>
			
			<liferay-ui:search-container-column-text name="select" align="center" cssClass="tbl_cell_action">
				<aui:button name="select" value="select" videoid="<%=video.getVideoId() %>"
				 videoname="<%=HtmlUtil.escape( video.getVideoName() ) %>" videodesc="<%=HtmlUtil.escape(video.getDescription()) %>" modifieddate="<%=dateTimeFormat.format(video.getModifiedDate()) %>"/>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>


<aui:script use="aui-base">
function escapeHtml(html)
{
    var text = document.createTextNode(html);
    var div = document.createElement('div');
    div.appendChild(text);
    return div.innerHTML;
}
	AUI().ready(function(A){
		var selectBtns = A.all('#<portlet:namespace/>select');
		selectBtns.each(function(btn){
			btn.on('click', function(){
				var videoid = btn.attr('videoid');
				var videoname = btn.attr('videoname');
				var videodesc = btn.attr('videodesc');
				var modifieddate = btn.attr('modifieddate');
				
				var openingWindow = Liferay.Util.getOpener();
				
				var tblSelectedVideos = openingWindow.document.getElementById("cfg-tbl-video-selected");
				var row = document.createElement('div');
				row.setAttribute('class', 'tbl-row');
				var cols = '<span class="tbl-col-1">' + videoname + '</span>' +
				'<span class="tbl-col-2">' + videodesc + '</span>' + 
				'<span class="tbl-col-3">' + modifieddate + '</span>' +
				'<span class="tbl-col-4" onclick="removeSelectedVideo(this)">x</span>' + '<input type="hidden" name="_86_selectedVideoId" value="'+videoid +'">';
				row.innerHTML = cols;
				tblSelectedVideos.appendChild(row);
			});
		});
	});
	
	Liferay.provide(
			window,
			'viewVLVideoForm',
			function(url){
				var title="<liferay-ui:message key='view-video'/>";
				var dialogWidow = {
					dialog: {
						constrain: true,
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						cache: false,
						width:640
					},
					title: title,
					uri: url,
				};
				Liferay.Util.openWindow(dialogWidow);	
			}
		);
</aui:script>