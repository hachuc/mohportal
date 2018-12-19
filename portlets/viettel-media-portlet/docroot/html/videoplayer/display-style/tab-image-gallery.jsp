<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.kernel.servlet.ServletContextUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.ImageProcessorUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileVersion"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/init.jsp"%>

<%
	long javaScriptLastModified = ServletContextUtil.getLastModified(application, "/js/", true);
	long scopeId = GetterUtil.getLong( portletPreferences.getValue("scopeId", String.valueOf( themeDisplay.getScopeGroupId())));
%>


<c:choose>
	<c:when test="<%=selectedImageFolderId > 0L %>">
		<div class="imageGallerySliderFrame">
			<div id="<portlet:namespace />imageGallerySlider" class="imageGallerySlider">
			<%
				//Danh sach cac file co trong thu muc
				List<FileEntry> fileEntryList = new ArrayList<FileEntry>();
				if(numbersOfImageDisplay > 0){
					fileEntryList = DLAppServiceUtil.getFileEntries(scopeId, selectedImageFolderId,0,numbersOfImageDisplay);
				}else{
					fileEntryList = DLAppServiceUtil.getFileEntries(scopeId, selectedImageFolderId);
				}
				
				
				int fileIndex = 0;
				
				for(FileEntry fileEntry : fileEntryList){
					
					FileVersion fileVersion = fileEntry.getLatestFileVersion();
					
					//Kiem tra file co phai la dinh dang anh hay khong?
					boolean hasImage = ImageProcessorUtil.hasImages(fileVersion);
					
					if(hasImage){//Truong hop dung la file anh

						//Duong dan den file anh voi kich thuoc day du
						String imageHref = DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, StringPool.BLANK);
						
						String imageDescription = HtmlUtil.escape(fileEntry.getDescription());
							
						if(Validator.isNull(imageDescription)){
							
							imageDescription = HtmlUtil.escape(fileEntry.getTitle());
						}
						
						String imageCssClass = "";
						
						if(fileIndex == 0){
							
							imageCssClass = "active";
						}
						
						fileIndex ++;
			%>		
						<div class="image-thumbnail-preview <%=imageCssClass%>">
							<a href="<%=imageHref%>" title="<%=imageDescription%>">
								<img src="<%= imageHref %>" class="<%=imageCssClass%>"/>
							</a>
						</div>
						
			<%
					}
				}
			%>
			</div>
			
			<c:if test='<%=displayGalleryLink %>'>
				<%
				Layout layoutTemp = LayoutLocalServiceUtil.getLayout(galleryPageId);
				
				String viewImageGalleryLink = PortalUtil.getLayoutFriendlyURL(layoutTemp, themeDisplay);
				%>

			</c:if>
		</div>
	</c:when>
	
	<c:otherwise>
		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
				label="please-config-this-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>
<span class = "<portlet:namespace />templateInfo" style = "display:none;"></span>
<script type="text/javascript">

	function slideSwitch() {
	    var active = jQuery('#<portlet:namespace />imageGallerySlider DIV.active');
	
	    if ( active.length == 0 ) active = jQuery('#<portlet:namespace />imageGallerySlider DIV:last');
	
	    // use this to pull the divs in the order they appear in the markup
	    var next =  active.next().length ? active.next(): jQuery('#<portlet:namespace />imageGallerySlider DIV:first');
	
	    active.addClass('last-active');
	
	    next.css({opacity: 0.0})
	        .addClass('active')
	        .animate({opacity: 1.0}, 1000, function() {
	            active.removeClass('active last-active');
	        });
	}
	
	jQuery(function() {
	    setInterval( "slideSwitch()", 5000 );
	});

</script>
	
<aui:script use="aui-image-viewer-gallery,aui-media-viewer-plugin">
	var A = AUI();
	
	var imageGallerySlider = A.one('#<portlet:namespace />imageGallerySlider');
	
	var templateInfo = A.one('.<portlet:namespace />templateInfo');
	
	if(imageGallerySlider){
		
		var viewportRegion = A.getDoc().get('viewportRegion');
			
		var maxHeight = (viewportRegion.height * 0.9);
		var maxWidth = (viewportRegion.width * 0.9);
		var imageGallery = new A.ImageGallery({
				anim: true,
		        caption: '',
		        captionFromTitle: true,
		        imageAnim: {
		         duration: 1,
		         easing: 'easeIn'
		        },
		        lockScroll: true,
				links: imageGallerySlider.all('a'),
				autoPlay: true,
				showControls: true,
				maxHeight: maxHeight,
				maxWidth: maxWidth,
				delay: 8000,
				infoTemplate: '',
				playingLabel: '',
				captionFromTitle: false,
				preloadNeighborImages: true,
				preloadAllImages: true,
				pagination: {
			          total: 5
			    },
				showInfo: true
			}		
		).render();
		
		
		imageGallerySlider.setStyles({
		    height:  <%=imageThumbnailHeight + 4%>,
		    width:   <%=imageThumbnailWidth + 4%>
		})
		
		if(<%=useCustomImageSize %>){
		
			var imageThumbnail = imageGallerySlider.all('img');
			
			imageThumbnail.setStyles({
			    height:  <%=imageThumbnailHeight %>,
			    width:   <%=imageThumbnailWidth %>
			})
		}
	}
</aui:script>
