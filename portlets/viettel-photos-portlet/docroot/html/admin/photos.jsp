<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%--<%@page import="com.viettel.portal.photos.permission.PhotoPermission"%> --%>
<%@page import="com.viettel.portal.photos.service.PhotoLocalServiceUtil"%>
<%@page import="com.viettel.portal.photos.model.Photo"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.viettel.portal.photos.util.PhotoFileUtil"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/admin/init.jsp"%>
<%
	String blank = "";
%>

<liferay-portlet:renderURL varImpl="photoAdminHomePageImplURL" var="">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="photoSearchKeyword" value="<%=photoSearchKeyword %>"/>
</liferay-portlet:renderURL>

<div class="list-vl-photo">
	<liferay-ui:search-container emptyResultsMessage="no-found-photo">
		<%
			List<Photo> photos = PhotoLocalServiceUtil.findPhotos(scopeGroupId, photoSearchKeyword, selectedCategoryId, searchContainer.getStart(), searchContainer.getEnd());
			total = (int)PhotoLocalServiceUtil.countPhotos(scopeGroupId, photoSearchKeyword, selectedCategoryId);
		%>
		
		<liferay-ui:search-container-results results="<%=photos %>" total="<%=total %>"/>
		
		<liferay-ui:search-container-row className="com.viettel.portal.photos.model.Photo" keyProperty="photoId" modelVar="photo" escapedModel="<%=true %>">
	
			<liferay-ui:search-container-column-text name="#" 
				orderable="<%=false %>"
			>
				<% 
				String photoThumbnailURL = request.getContextPath() + "/images/default-photo-thumbnail.jpg";
				if(photo != null && photo.getFileId() > 0){ %>
					<%
						FileEntry thumbnailImage = null;
						try{
							thumbnailImage = DLAppServiceUtil.getFileEntry(photo.getFileId());
						}catch(Exception e){
							
						}
						if(thumbnailImage != null){
							photoThumbnailURL = PhotoFileUtil.getPhotoThumbnailURL(themeDisplay, thumbnailImage);
						}
						
					%>
					<div id="<portlet:namespace/>previewImageThumbnai">
						<img alt="" src="<%=photoThumbnailURL %>" width="150">
					</div>				
				<% } %>					
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Tên-photo" value="<%= photo.getCaption()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Ngày-tạo" value="<%=photo.getCreateDate() != null ? dateTimeFormat.format(photo.getCreateDate()) : null%>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Người-tạo" value="<%= photo.getUserName()%>" 
				orderable="<%=false %>"
			/>			
			<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
				<portlet:renderURL var="editPhotoURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="jspPage" value="/html/admin/edit_photo.jsp" />
					<portlet:param name="id" value="<%= String.valueOf(photo.getPhotoId()) %>" />
					<portlet:param name="categoryId" value="<%= String.valueOf(photo.getCategoryId()) %>" />
				</portlet:renderURL>
				
				<a href="javascript:;" onclick='updatePhotoForm("<%=editPhotoURL.toString() %>");'>
					<liferay-ui:icon image="edit"/>
				</a>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
				<portlet:actionURL  name="deletePhoto" var="deletePhotoActionURL">
					<portlet:param name="id" value="<%=String.valueOf(photo.getPhotoId())%>"/>
					<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>   
					<portlet:param name="redirectURL" value='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace()%>'/>
				</portlet:actionURL>            
				<liferay-ui:icon-delete url="<%= deletePhotoActionURL %>" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>