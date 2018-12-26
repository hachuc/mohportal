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
			
	<portlet:actionURL name="updateVideo" var="updateVideoActionURL">
		<portlet:param name="videoId" value="<%=String.valueOf(videoId) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</portlet:actionURL>
	<aui:form name="fm" enctype="multipart/form-data" method="post" action="<%=updateVideoActionURL%>" >
			
		<aui:model-context bean="<%= video %>" model="<%= VLVideo.class %>"/>
			
		<aui:input name="videoName" label="doc-code" type="text" size="100">
			<aui:validator name="required" />
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
				
		<aui:input name="description" type="text" label="company-name">
			<aui:validator name="maxLength">2000</aui:validator>
		</aui:input>
				
		<aui:select name="videoCategory">
			<c:choose>
				<c:when test="<%=(categories.size()>0) %>">
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
		<aui:select name="videoType" label="video-type">
			<aui:option label="central" value="<%=VideoConstants.INTERNAL_VIDEO_TYPE %>" 
								selected='<%=Validator.equals(videoType, VideoConstants.INTERNAL_VIDEO_TYPE) %>'/>
			<aui:option label="local" value="<%=VideoConstants.EXTERNAL_VIDEO_TYPE %>" 
								selected='<%=Validator.equals(videoType, VideoConstants.EXTERNAL_VIDEO_TYPE) %>'/>
		</aui:select>
		
		<aui:input name="smallImageUrl" type="text" label="link-result">
			<aui:validator name="maxLength">2000</aui:validator>
		</aui:input>		
		<div id="<portlet:namespace />video-upload-container">
			<% if(video != null){ %>
				<aui:input type="file" name="videoFile" accept=".pdf,.xlsx,.xls,.rar,.zip"/>	
			<% } else { %>
				<aui:input type="file" name="videoFile" accept=".pdf,.xlsx,.xls,.rar,.zip" />
			<% } %>				

			<% if (video != null && video.getImageId() > 0) {
					FileEntry videoFile = null;
					try{
						videoFile = DLAppServiceUtil.getFileEntry(video.getFileId());
					}catch(Exception e){}					
				%>
				<liferay-ui:message key="file-attach"/> <%= videoFile.getTitle() %>
			<%} %>			
			<aui:input type="hidden" name="fileId" value="<%=videoFileId %>"/>
		</div>	
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
		
		var closeVideoUpdateFormBtn = A.one('#<portlet:namespace/>closeVideoUpdateFormBtn');
        
		if(closeVideoUpdateFormBtn){
            
			closeVideoUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
			});
		}
	});
</aui:script>