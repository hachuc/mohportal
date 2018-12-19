<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.viettel.portal.photos.PhotoFileTypeException"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.viettel.portal.photos.PhotoFileSizeException"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.viettel.portal.photos.service.PhotoLocalServiceUtil"%>
<%@page import="com.viettel.portal.photos.model.Photo"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.viettel.portal.photos.util.PhotoConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="com.viettel.portal.photos.util.PhotoFileUtil"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long id = ParamUtil.getLong(request, "id");
	
	Photo photo = null;
	if(id > 0){
		photo = PhotoLocalServiceUtil.getPhoto(id);
		selectedCategoryId = photo.getCategoryId();//ParamUtil.getLong(request, "categoryId", 0L);
	}
	else{
		selectedCategoryId = categoryId;
		if(selectedCategoryId < 0){
			selectedCategoryId = ParamUtil.getLong(request, "categoryId", 0L);
		}
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updatePhoto();";
%>

<div class="photo-update-form">
	<liferay-ui:error key="<%= PhotoFileTypeException.class.getName() %>" message="not-support-this-image-file-type"/>	
	<liferay-ui:error key="<%= PhotoFileSizeException.class.getName() %>" message="image-size-too-larger"/>			
			
	<portlet:actionURL name="updatePhoto" var="updatePhotoActionURL">
		<portlet:param name="photoId" value="<%=String.valueOf(id) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</portlet:actionURL>
	
	<aui:form name="fm" enctype="multipart/form-data" method="post" action="<%=updatePhotoActionURL%>" >
			
		<aui:model-context bean="<%= photo %>" model="<%= Photo.class %>"/>
		<aui:input type="hidden" name="fileId"/>
		<aui:input type="hidden" name="fileSize"/>
		<aui:input type="hidden" name="categoryId" value="<%=selectedCategoryId %>"/>
		
		<aui:input name="caption" label="Tên-photo" type="text" size="255">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="order_" label="Vị-trí-hiển-thị" type="text" size="10">
			<aui:validator name="required" />
			<aui:validator name="number">
				true
			</aui:validator>
		</aui:input>   
        <% if (photo != null){ %>
			<div id="<portlet:namespace />photo-upload-container">
				<aui:input type="file" name="photoFile" label="photo" accept=".png,.jpeg,.jpg">
				</aui:input>
			</div>	
		<% } else {%>
			<div id="<portlet:namespace />photo-upload-container">
				<aui:input type="file" name="photoFile" label="photo" accept=".png,.jpeg,.jpg,.gif" >
					<aui:validator name="required" />
				</aui:input>
			</div>	
		<% } %>		
		<% if(photo != null && photo.getFileId() > 0){ %>
			<%
				String photoThumbnailURL = request.getContextPath() + "/images/default-photo-thumbnail.jpg";
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
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closePhotoUpdateFormBtn" value="cancel"/>
		</aui:button-row>	
	</aui:form>
</div>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />photoThumbnailImageCheckbox','<portlet:namespace />photo-thumbnail-img-container');
</aui:script>

<aui:script>
	AUI().ready(function(A){
		
		var closePhotoUpdateFormBtn = A.one('#<portlet:namespace/>closePhotoUpdateFormBtn');
        
		if(closePhotoUpdateFormBtn){
            
			closePhotoUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
	});
</aui:script>