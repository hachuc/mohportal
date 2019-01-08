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
<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
 
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
			<portlet:renderURL var="viewVideoURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="jspPage" value="/html/admin/preview_detail.jsp" />
				<portlet:param name="videoId" value="<%=String.valueOf(video.getVideoId()) %>" />
			</portlet:renderURL>
			
			<%
			StringBundler previewVideo = new StringBundler();
			
			previewVideo.append("javascript:");
			previewVideo.append("viewVLVideoForm");
			previewVideo.append("('");
			previewVideo.append(viewVideoURL.toString());
			previewVideo.append("')");
			VLCategory category = VLCategoryLocalServiceUtil.fetchVLCategory(categoryId);
			FileEntry videoFileEntry = null;
			if(video !=null && video.getFileId() > 0){
				videoFileEntry = DLAppServiceUtil.getFileEntry(video.getFileId());
			}
			String fileName ="";
			String rankName ="";
			
			if(Validator.equals(video.getVideoType(), VideoConstants.INTERNAL_VIDEO_TYPE)){
				rankName = VideoConstants.INTERNAL_NAME;
			}else if(Validator.equals(video.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
				rankName = VideoConstants.EXTERNAL_NAME;
			}
			
			if(videoFileEntry != null){
				fileName = videoFileEntry.getTitle();
			}
			%>

			<liferay-ui:search-container-column-text name="doc-code" orderable="<%=true %>" value="<%=video.getVideoName()%>"
				href="<%=previewVideo.toString() %>"
				title="<%=video.getVideoName() %>" valign="middle"
			/>
			<liferay-ui:search-container-column-text name="video-category" orderable="<%=true %>" value="<%=category.getCategoryName()%>"
				title="<%=category.getCategoryName() %>" valign="middle"
			/>
			
			<liferay-ui:search-container-column-text name="video-type" orderable="<%=true %>" value="<%=rankName%>"
				title="<%=rankName %>" valign="middle"
			/>
			<liferay-ui:search-container-column-text name="company-name" orderable="<%=true %>" value="<%=video.getDescription()%>"
				title="<%=video.getDescription() %>" valign="middle"
			/>
			<liferay-ui:search-container-column-text name="file-name" orderable="<%=true %>" value="<%=fileName%>"
				title="<%=fileName %>" valign="middle"
			/>
			<liferay-ui:search-container-column-text name="modified-date" value="<%=dateTimeFormat.format(video.getModifiedDate())%>"
				orderable="<%=true %>"
				orderableProperty="modified-date"
				title="<%=previewVideo.toString() %>"
			/>
			
			<liferay-ui:search-container-column-text name="created-by-user" value="<%=video.getUserName()%>" 
				orderable="<%=true %>"
				orderableProperty="user-name"
				title="<%=previewVideo.toString() %>"
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