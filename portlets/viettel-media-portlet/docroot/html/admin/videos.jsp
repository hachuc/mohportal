<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.viettel.portal.videolibrary.search.VideoSearch"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.viettel.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLCategory"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.viettel.portal.videolibrary.permission.VideoPermission"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<liferay-portlet:renderURL varImpl="videoAdminHomePageImplURL" var="">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="videoSearchKeyword" value="<%=videoSearchKeyword %>"/>
	<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
</liferay-portlet:renderURL>

<div class="list-vl-video">
	<liferay-ui:search-container searchContainer="<%= new VideoSearch(renderRequest, videoAdminHomePageImplURL)%>" emptyResultsMessage="no-found-video">
		<%
			List<VLVideo> videos = VLVideoLocalServiceUtil.findByKeyword(scopeGroupId, selectedCategoryId, videoSearchKeyword, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			total = (int)VLVideoLocalServiceUtil.countByByKeyword(scopeGroupId, selectedCategoryId, videoSearchKeyword);
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
			
			<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
				<c:if test="<%=VideoPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">
					<portlet:renderURL var="editVideoURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/edit_video.jsp" />
						<portlet:param name="videoId" value="<%=String.valueOf(video.getVideoId()) %>" />
						<portlet:param name="categoryId" value="<%=String.valueOf(video.getCategoryId()) %>" />
					</portlet:renderURL>
					
					<a href="javascript:;" onclick='updateVLVideoForm("<%=editVideoURL.toString() %>");'>
						<liferay-ui:icon image="edit"/>
					</a>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
				<c:if test="<%=VideoPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE) %>">
					<portlet:actionURL  name="deleteVideo" var="deleteVideoActionURL">
						<portlet:param name="videoId" value="<%=String.valueOf(video.getVideoId())%>"/>
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>       
						<portlet:param name="categoryId" value="<%=String.valueOf(categoryId)%>"/>  
						<portlet:param name="redirectURL" value='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "categoryId=" + categoryId%>'/>
					</portlet:actionURL>            
					<liferay-ui:icon-delete url="<%= deleteVideoActionURL %>" />
				</c:if>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>