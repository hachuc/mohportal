<%@page import="java.util.Calendar"%>
<%@page import="com.viettel.portal.banner.BannerFileTypeException"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.viettel.portal.banner.BannerFileSizeException"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.viettel.portal.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.viettel.portal.banner.model.Banner"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.viettel.portal.banner.util.BannerConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="com.viettel.portal.banner.util.BannerFileUtil"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long id = ParamUtil.getLong(request, "id");
	
	String bannerType = BannerConstants.INTERNAL_BANNER_TYPE;
	
	List<DLFolder> folders = new ArrayList<DLFolder>();
	
	folders = DLFolderLocalServiceUtil.getFolders(scopeGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

	Banner banner = null;
	
	int day = 0;
	int month = 0;
	int year = 0;
	if(id > 0){
		banner = BannerLocalServiceUtil.getBanner(id);
		if(banner.getNgayKetThuc() != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(banner.getNgayKetThuc());
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) ;
			day = cal.get(Calendar.DAY_OF_MONTH);
		}
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateBanner();";
%>

<div class="banner-update-form">
	<liferay-ui:error key="<%= BannerFileTypeException.class.getName() %>" message="not-support-this-image-file-type"/>	
	<liferay-ui:error key="<%= BannerFileSizeException.class.getName() %>" message="image-size-too-larger"/>			
			
	<portlet:actionURL name="updateBanner" var="updateBannerActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</portlet:actionURL>
	
	<aui:form name="fm" enctype="multipart/form-data" method="post" action="<%=updateBannerActionURL%>" >
			
		<aui:model-context bean="<%= banner %>" model="<%= Banner.class %>"/>
		<aui:input type="hidden" name="fileId"/>
		<aui:input type="hidden" name="fileSize"/>
		
		<aui:input name="ten" label="Tên-banner" type="text" size="255">
			<aui:validator name="required" />
			<aui:validator name="maxLength">500</aui:validator>
			<aui:validator name="minLength">3</aui:validator>
		</aui:input>
		<aui:input name="lienKet" label="Liên-kết" type="text" size="500">
			<aui:validator name="maxLength">2000</aui:validator>
			<aui:validator name="minLength">3</aui:validator>
		</aui:input>		
		<div>
			<liferay-ui:message key="Ngày-kết-thúc"/>
			<%if(day > 0 && month > 0 && year > 0){ %>
		        <liferay-ui:input-date name="ngayKetThuc"
			        dayParam="nktDay" dayValue="<%= day %>" 
			        monthParam="nktMonth" monthValue="<%= month %>" 
			        yearParam="nktYear" yearValue="<%= year %>"/>	
	        <%} else{ %>
		        <liferay-ui:input-date  name="ngayKetThuc"
		        	nullable="true"
			        dayParam="nktDay" 
			        monthParam="nktMonth" 
			        yearParam="nktYear"/>	
	        <%} %>
        </div>
		<aui:input name="order_" label="Vị-trí-hiển-thị" type="text" size="10">
			<aui:validator name="required" />
			<aui:validator name="number">
				true
			</aui:validator>
			<aui:validator name="maxLength">11</aui:validator>
		</aui:input>   
		<span style="font-size: 10px;">
			<liferay-ui:message key="Vị-trí-hiển-thị-ghi-chú" />    
		</span> 
        <% if (banner != null){ %>
			<div id="<portlet:namespace />banner-upload-container">
				<aui:input type="file" name="bannerFile" label="Ảnh" >
				</aui:input>
			</div>	
		<% } else {%>
			<div id="<portlet:namespace />banner-upload-container">
				<aui:input type="file" name="bannerFile" label="Ảnh" >
					<aui:validator name="required" />
				</aui:input>
			</div>	
		<% } %>		
		<% if(banner != null && banner.getFileId() > 0){ %>
			<%
				String bannerThumbnailURL = request.getContextPath() + "/images/default-banner-thumbnail.jpg";
				FileEntry thumbnailImage = null;
				try{
					thumbnailImage = DLAppServiceUtil.getFileEntry(banner.getFileId());
				}catch(Exception e){
					
				}
				if(thumbnailImage != null){
					bannerThumbnailURL = BannerFileUtil.getBannerThumbnailURL(themeDisplay, thumbnailImage);
				}
				
			%>
			<div id="<portlet:namespace/>previewImageThumbnai">
				<img alt="" src="<%=bannerThumbnailURL %>" width="150">
			</div>
		<% } %>
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeBannerUpdateFormBtn" value="cancel"/>
		</aui:button-row>	
	</aui:form>
</div>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />bannerThumbnailImageCheckbox','<portlet:namespace />banner-thumbnail-img-container');
</aui:script>

<aui:script>
	AUI().ready(function(A){
		
		var closeBannerUpdateFormBtn = A.one('#<portlet:namespace/>closeBannerUpdateFormBtn');
        
		if(closeBannerUpdateFormBtn){
            
			closeBannerUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
	});
</aui:script>