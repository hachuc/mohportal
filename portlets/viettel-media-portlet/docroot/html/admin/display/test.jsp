<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/admin/init.jsp" %>
<%

long videoId = ParamUtil.getLong(request, "videoId");
VLVideo video = null;
String videoThumbnailURL = request.getContextPath()
        + "/images/default-video-thumbnail.jpg";
if(videoId > 0){
	video = VLVideoLocalServiceUtil.getVLVideo(videoId);
}

if(video != null){
	if(video.getImage() && video.getImageId() > 0){
	    FileEntry thumbnailImage = null;
	    try{
	        thumbnailImage = DLAppServiceUtil.getFileEntry(video.getImageId());
	    }catch(Exception e){}
	    
	    if(thumbnailImage != null){
	        videoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
	    }
	}
}
%>
<div>
    <img src = "<%=videoThumbnailURL %>" width = "130px" height = "130px"/>
    <span class="play-icon"></span>
</div>

