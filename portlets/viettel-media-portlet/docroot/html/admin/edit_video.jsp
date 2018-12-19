<%@page import="com.viettel.portal.videolibrary.ImageFileTypeException"%>
<%@page import="com.viettel.portal.videolibrary.VideoFileSizeException"%>
<%@page import="com.viettel.portal.videolibrary.VideoFileTypeException"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.viettel.portal.videolibrary.ImageFileSizeException"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.viettel.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLCategory"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideoCategory"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	boolean useVideoThumbnail = true;

	long videoFileId = 0L;
	
	long abstractImageId = 0L;

	long videoId = ParamUtil.getLong(request, "videoId");
	
	String videoType = VideoConstants.INTERNAL_VIDEO_TYPE;
	
	List<DLFolder> folders = new ArrayList<DLFolder>();
	
	folders = DLFolderLocalServiceUtil.getFolders(scopeGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

	VLVideo video = null;
	
	if(videoId > 0){
		
		video = VLVideoLocalServiceUtil.getVLVideo(videoId);
		
		if(video != null){
			
			videoType = video.getVideoType(); 
			videoFileId = video.getFileId();
			abstractImageId = video.getImageId();
			categoryId = video.getCategoryId();
			List<VLVideoCategory> listMap = VLVideoCategoryLocalServiceUtil.findByVideo(videoId, scopeGroupId);
			
			//if ((Validator.isNotNull(listMap))&&(listMap.size()>0))
			//	categoryId = listMap.get(0).getCategoryId();
		}
	}
	else{
		categoryId = ParamUtil.getLong(request, "categoryId");
	}
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateVideo();";
	
	List<VLCategory> categories = VLCategoryLocalServiceUtil.findByGroup(scopeGroupId);
	
	
%>

<div class="video-update-form">
	<liferay-ui:error key="<%= VideoFileTypeException.class.getName() %>" message="not-support-this-video-file-type"/>	
	<liferay-ui:error key="<%= VideoFileSizeException.class.getName() %>" message="video-size-too-larger"/>
	<liferay-ui:error key="<%= ImageFileTypeException.class.getName() %>" message="not-support-this-image-file-type"/>	
	<liferay-ui:error key="<%= ImageFileSizeException.class.getName() %>" message="image-size-too-larger"/>			
			
	<portlet:actionURL name="updateVideo" var="updateVideoActionURL">
		<portlet:param name="videoId" value="<%=String.valueOf(videoId) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</portlet:actionURL>
	
	<aui:form name="fm" enctype="multipart/form-data" method="post" action="<%=updateVideoActionURL%>" >
			
		<aui:model-context bean="<%= video %>" model="<%= VLVideo.class %>"/>
			
		<aui:input name="videoName" label="video-title" type="text" size="100">
			<aui:validator name="required" />
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
				
		<aui:input name="description" type="textarea">
			<aui:validator name="maxLength">2000</aui:validator>
		</aui:input>
				
		<aui:select name="videoCategory">
			<c:choose>
				<c:when test="<%=(categories.size()>0) %>">
					<aui:option label = "video-category" value = ""	
						selected = "<%=(Validator.equals(categoryId, 0L)) %>"/>
					<%
						for (int i = 0; i < categories.size();i++){
						%>
							<aui:option label = "<%=HtmlUtil.escape(categories.get(i).getCategoryName()) %>" 
								value = "<%=categories.get(i).getCategoryId() %>"
								selected = "<%=Validator.equals(categories.get(i).getCategoryId(), categoryId) %>"/>
						<%
						}
					%>
				</c:when>
				<c:otherwise>
					<aui:option  label = "no-category" value = "0L"/>
				</c:otherwise>
			</c:choose>
		</aui:select>
		
		
		
		<aui:select name="videoFolderId" label="video-folder">
			<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>"><liferay-ui:message key="root-folder"/></aui:option>
			<c:if test="<%=folders != null%>">
				<%
					for (DLFolder folder : folders) {
						if (folder.isHidden()) {
							continue;
						}
				%>
				<aui:option value="<%=folder.getFolderId()%>"><%=HtmlUtil.escape(folder.getName())%></aui:option>
				<%
					}
				%>
			</c:if>
		</aui:select>
				
		<aui:select name="videoType" label="video-type">
			<aui:option label="internal" value="<%=VideoConstants.INTERNAL_VIDEO_TYPE %>" 
								selected='<%=Validator.equals(videoType, VideoConstants.INTERNAL_VIDEO_TYPE) %>'/>
			<aui:option label="external" value="<%=VideoConstants.EXTERNAL_VIDEO_TYPE %>" 
								selected='<%=Validator.equals(videoType, VideoConstants.EXTERNAL_VIDEO_TYPE) %>'/>
		</aui:select>
					
		<div id="<portlet:namespace />video-url-container"  class='<%=Validator.equals(videoType, VideoConstants.INTERNAL_VIDEO_TYPE) ? "hide" : ""%>'>
			<aui:input name="videoUrl" label="video-url"/>
		</div>
				
		<div id="<portlet:namespace />video-upload-container" class='<%=Validator.equals(videoType, VideoConstants.EXTERNAL_VIDEO_TYPE) ? "hide" : ""%>'>
			<% if(video != null){ %>
				<aui:input type="file" name="videoFile" accept=".mp3,.mp4,.ogg"/>	
			<% } else { %>
				<aui:input type="file" name="videoFile" accept=".mp3,.mp4,.ogg" />
			<% } %>				

			<% if (video != null && video.getImageId() > 0) {
					FileEntry videoFile = null;
					try{
						videoFile = DLAppServiceUtil.getFileEntry(video.getFileId());
					}catch(Exception e){}					
				%>
				<liferay-ui:message key="Tệp-video"/> <%= HtmlUtil.escape(videoFile.getTitle()) %>
			<%} %>			
			<aui:input type="hidden" name="fileId" value="<%=videoFileId %>"/>
		</div>	
		<aui:input type="checkbox" name="videoThumbnailImage" value="<%=useVideoThumbnail %>" label="use-video-thumbnail-image"/>
		<c:choose>
			<c:when test="<%=video != null && video.getImageId() > 0%>">
				<%
					String videoThumbnailURL = request.getContextPath() + "/images/default-video-thumbnail.jpg";
					FileEntry thumbnailImage = null;
					try{
						thumbnailImage = DLAppServiceUtil.getFileEntry(video.getImageId());
					}catch(Exception e){}
					
					if(thumbnailImage != null){
						videoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
					}				
				%>
				<div id="<portlet:namespace/>previewImageThumbnai">
					<img alt="" src="<%=videoThumbnailURL %>" width="150" height="120">
				</div>
				
				<div id="<portlet:namespace />video-thumbnail-img-container" class="hide">
					<aui:input type="file" name="videoThumbnailImageFile" label="video-thumbnail-image" accept=".png,.jpeg,.jpg"/>
				</div>
				
				<div class="change-image">
					<a href="javascript:;" id="<portlet:namespace />changeImage"><liferay-ui:message key="change"/></a>
				</div>
				
				<div class="cancel-change-image">
					<a href="javascript:;" id="<portlet:namespace />cancelChangeImage"><liferay-ui:message key="cancel"/></a>
				</div>
				
			</c:when>
			<c:otherwise>
				<div id="<portlet:namespace />video-thumbnail-img-container">
					<aui:input type="file" name="videoThumbnailImageFile" label="video-thumbnail-image" accept=".png,.jpeg,.jpg"/>
				</div>
			</c:otherwise>
		</c:choose>
		
		<aui:input type="hidden" name="thumbnailImageId" value="<%=abstractImageId %>"/>
	
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeVideoUpdateFormBtn" value="cancel"/>
		</aui:button-row>	
	</aui:form>
</div>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />videoThumbnailImageCheckbox','<portlet:namespace />video-thumbnail-img-container');
</aui:script>

<aui:script>
	AUI().ready(function(A){
		
		var videoTypeSelector = A.one('#<portlet:namespace/>videoType');
		
		var videoUrlContainer = A.one('#<portlet:namespace />video-url-container');
		
		var videoUploadContainer = A.one('#<portlet:namespace />video-upload-container');
		
		var videoPlayerContainer = A.one('#<portlet:namespace />video-player-container');
		
		
		var changeImage = A.one('#<portlet:namespace />changeImage');
		var cancelChangeImage = A.one('#<portlet:namespace />cancelChangeImage');
		
		if(changeImage){
			Liferay.Util.toggleBoxes('<portlet:namespace />changeImage','<portlet:namespace />video-thumbnail-img-container');
			Liferay.Util.toggleBoxes('<portlet:namespace />changeImage','<portlet:namespace/>cancelChangeImage');
			changeImage.on('click', function(){
				A.one('#<portlet:namespace/>previewImageThumbnai').hide();
				A.one('#<portlet:namespace/>video-thumbnail-img-container').show();
				changeImage.hide();
			});
		}
		
		if(cancelChangeImage){
			cancelChangeImage.on('click', function(){
				A.one('#<portlet:namespace/>video-thumbnail-img-container').hide();
				A.one('#<portlet:namespace/>previewImageThumbnai').show();
				A.one('#<portlet:namespace/>videoThumbnailImageFile').val(null);
				changeImage.show();
				cancelChangeImage.hide();
				
			});
		}
		
		if(videoTypeSelector && videoTypeSelector.val() == '<%=VideoConstants.INTERNAL_VIDEO_TYPE %>'){
			
			videoUrlContainer.hide();
			
			videoUploadContainer.show();
			
		}else if(videoTypeSelector && videoTypeSelector.val() == '<%=VideoConstants.EXTERNAL_VIDEO_TYPE %>'){
			
			videoUrlContainer.show();
			
			videoUploadContainer.hide();
			
			if(videoPlayerContainer){
				
				videoPlayerContainer.hide();
				
			}
		}
		
		if(videoTypeSelector){
			
			videoTypeSelector.on('change',function(){
				
				var selectedValue = videoTypeSelector.val();
				
				if(selectedValue == '<%=VideoConstants.INTERNAL_VIDEO_TYPE %>'){
					
					videoUrlContainer.hide();
					
					videoUploadContainer.show();
					
				}else{
					
					videoUrlContainer.show();
					
					videoUploadContainer.hide();
					
					if(videoPlayerContainer){
						
						videoPlayerContainer.hide();
						
					}
				}
			});
		}
		
		var closeVideoUpdateFormBtn = A.one('#<portlet:namespace/>closeVideoUpdateFormBtn');
        
		if(closeVideoUpdateFormBtn){
            
			closeVideoUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
	});
</aui:script>