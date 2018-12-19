<%@page import="java.util.HashMap"%>
<%@page import="com.viettel.portal.photos.util.PhotoFileUtil"%>
<%@page import="com.viettel.portal.photos.service.PhotoLocalServiceUtil"%>
<%@page import="com.viettel.portal.photos.model.Photo"%>
<%@page import="com.viettel.portal.photos.service.PCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.photos.model.PCategory"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ include file="/html/photo/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<style type="text/css">
	.picture-title h5 {
	    color: rgba(0,0,0,0.54);
	    font-size: 1.2rem;
	    font-weight: 500;
	    text-transform: uppercase;
	    line-height: 40px;
	    border-bottom: solid 3px rgba(0,0,0,0.38);
	}
	#photosCarousel{
		max-width: 100%;
		width: 100%;
		padding: 0;
		margin : 0;
	}
	.photos{
		max-width: 100%;
		width: 100%;
	}
	
	.aui .photos>.item>img, .aui .photos>.item>a>img {
	    display: block;
	    max-width: 100%;
	    height: auto;
	    line-height: 1;
	    width: 100%;
	    max-height: 90%;
	}
	.aui .photos a.title{
		display: block;
	    margin: 0.5rem 2px;
	    font-size: 1rem;
	    font-weight: 500;
	    color: #fff;
	}
	@media screen and (min-width: 768px){
		.aui  #photosCarousel  .carousel-indicators {
		    bottom: 50px;
		}
	}
	
	#photosCarousel .carousel-control span.glyphicon{
		margin-top: -40px;
	}
	.aui #photosCarousel .carousel-control{
		top:50%;
		bottom: 50%;
	}
	.big-photo{
		position: fixed;
	    width: 100%;
	    height: 100%;
	    top: 0;
	    left: 0;
	    right: 0;
	    bottom: 0;
	    z-index: 1000;
	    color: white !important;
	    padding: 20px;
	    background: rgba(0, 0, 0, 0.9);
	}
	.aui .big-photo a.title{
		color: white !important;
	    width: 100%;
	    max-width: 100%;
	    text-align: center;	
	}
	.close-button {
		display: none;
		position: absolute;
		top: 10px;
		right: 10px;
		width: 24px;
		height: 24px;
		cursor: pointer;
		line-height: 24px;
		text-align: center;
	    z-index: 1001;
	    font-size: 24px;
	}
	.close-button i{
		color: red;
	}
	.big-photo .close-button{
		display: block;
	}
	.aui .picture-title h5 a{
	    float: right;
	    text-transform: none;
	    font-weight: normal;
	    font-size: 1rem;	
	    color: #039be5;
	}
	.aui .big-photo .item a img {
	    max-height: 90vh!important;
	    width: auto !important;
	    margin: 0 auto;	
	    max-width: 100%;
    }	
    .aui .title-info{
    	position: absolute;
	    bottom: 0;
	    width: 100%;
	    text-align: justify;
	    padding-bottom: 5px;
	    background: url("/viettel-photos-portlet/images/transparent-bg.png");
    }
    .title-info a {
	    text-decoration: none;
	    color: #fff;
	    font-weight: bold;
	}
</style>

<%
	HashMap<PCategory, List<Photo>> map = new HashMap<PCategory, List<Photo>>();
	if(numbersOfAlbumDisplay > 0){
		List<PCategory> albums =  PCategoryLocalServiceUtil.getPCategories(0, (int)numbersOfAlbumDisplay - 1);
		for(PCategory album : albums){
		 	List<Photo> list = PhotoLocalServiceUtil.findByCategoryAndGroup(album.getId(), groupId, true, 0, Integer.MAX_VALUE);
		 	map.put(album, list);
		}
	}
	else if(albumDisplay >= 0){
		PCategory album = PCategoryLocalServiceUtil.fetchPCategory(albumDisplay);
	 	List<Photo> list = PhotoLocalServiceUtil.findByCategoryAndGroup(albumDisplay, groupId, true, 0, Integer.MAX_VALUE);
	 	map.put(album, list);
	}
%>
<c:if test="<%=Validator.isNotNull(styleTitle) %>">
	<div class="title-tinnoibat">
				<%=styleTitle %>
				<% if(showViewMorePhotoLink){ %>
					<liferay-portlet:renderURL var="viewMoreURL" plid="<%= photoPageLayoutId %>">
					</liferay-portlet:renderURL>				
					<a href="<%=viewMoreURL %>"><liferay-ui:message key="Xem thêm"/></a>
				<%} %>
		</div>
</c:if>
<% if (map.size() >= 1){ 
	 Entry<PCategory,List<Photo>> entry = map.entrySet().iterator().next();
	 PCategory album = entry.getKey();
	 List<Photo> photos = entry.getValue();
%>
<div class="Box_Video_Image" id="photos-main-view">
	<a href="#" class="close-button"><i class="fa fa-times-circle-o" aria-hidden="true"></i></a>
	<div id="photosCarousel" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner photos">
			<%
				int i = 0;
				
				for (Photo photo : photos) {
					String photoThumbnailURL = "";
					FileEntry thumbnailImage = null;
					try{
						thumbnailImage = DLAppServiceUtil.getFileEntry(photo.getFileId());
					}catch(Exception e){
						//Log
					}
					if(thumbnailImage != null){
						photoThumbnailURL = PhotoFileUtil.getPhotoThumbnailURL(themeDisplay, thumbnailImage);
					}
			%>
				<div class='item reset <%= i == 0 ? "active" : "" %>'>
					<a href="#"> <img
						class="show-big-photo"
						alt="<%=HtmlUtil.escapeAttribute(photo.getCaption())%>"
						src="<%=photoThumbnailURL%>"></a>
					<div class="title-info">
						<a href="#" class="title"><%=HtmlUtil.escape(photo.getCaption())%></a>
					</div>
				</div>
			<%
				i++;
				}
			%>
		</div>
		  <!-- Left and right controls -->		
		  <a class="left carousel-control" href="#photosCarousel" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#photosCarousel" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
	</div>
</div>
<div id="album-main-title" class="st_title"> <a href="#" style="cursor: unset;"><%= HtmlUtil.escape(album.getName()) %></a> </div>
<%} %>
<% if (map.size() > 0){
	%>

	<ul class="chuyendelink">
	<% 
	for(Entry<PCategory,List<Photo>> entry : map.entrySet()){
		PCategory album = entry.getKey();
		List<Photo> photos = entry.getValue();
		HashMap<String, String> mapPhotos = new HashMap<String, String>();
		String firstPhotoUrl = null;
		for(Photo photo : photos){
			String url = "";
			String name = photo.getCaption();
			FileEntry photoFileEntry = DLAppServiceUtil.getFileEntry(photo.getFileId());
			if (photoFileEntry != null) {
				url = PhotoFileUtil.getPhotoThumbnailURL(themeDisplay, photoFileEntry);
			}
			mapPhotos.put(url, name);
		}
%>
	<li class="album-item" data-photo='<%=JSONFactoryUtil.looseSerialize(mapPhotos) %>' data-name='<%= album.getName() %>'>
		<%=HtmlUtil.escape(album.getName()) %>
	</li>
<%
	}%>
	</ul>
	<%
}%>
<script type="text/javascript">
	$(document).ready(function(){
		$('.show-big-photo').bind('click', function(e){
			$('#photos-main-view').addClass('big-photo');
		});
		$('#photos-main-view .close-button').bind('click', function(e){
			$('#photos-main-view').removeClass('big-photo');
		});
		$('#photos-main-view img').css({
			'max-height' : '<%= videoFrameHeight%>' + "px",
			'min-height' : '<%= videoFrameHeight%>' + + "px"
		});			
		var $albumMainTitle = $('#album-main-title');
		$('.album-item').bind('click', function(event){
			event.preventDefault();
		 	var $item = $(event.target).closest('.album-item');
 			var photos = $item.attr('data-photo');
 			if (photos != null){
 				var objs = JSON.parse(photos);
  				var name = $item.attr('data-name');
  				$albumMainTitle.html(name);
  				var $inner = $('#photosCarousel .carousel-inner');
  				$inner.html('');
  				var i = 0;
  				for(var key in objs){
  					$inner.append([
  									'<div class="item ', i == 0 ? "active" : "", '">',
  										'<a href="#"> <img class="show-big-photo" alt="', objs[key] , '" src="', key, '"></a>',
	  									'<div class="title-info"><a href="#" class="title">', objs[key], '</a></div>',									
	  								'</div>'
  					               ].join(''));
  					i++;
  				}

  				$('#photos-main-view img').css({
  					'max-height' : '<%= videoFrameHeight%>' + "px",
  					'min-height' : '<%= videoFrameHeight%>' + "px"
  				});  				
  				$('.show-big-photo').bind('click', function(e){
  					$('#photos-main-view').addClass('big-photo');
  				});
 			}
		});
	});
	
</script>