<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@ include file="/html/photo/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<style type="text/css">
	.album-main{
	  width : 100%;
	  clear: both;
	  height : auto;
	  float:left;
	  box-sizing : border-box;
	  padding : 5px;
	}
	.album-main #album-main-title{
	  margin-top : 5px;
	  width : 100%;
	}
	.album-item {
	  width : 33.3334%;
	  max-width : 33.3334%;
	  height : auto;
	  float : left;
	  box-sizing: border-box;
	  padding : 5px;
	  cursor : pointer;
	  position : relative;
	}
	
	.album-item  img{
	  width :100%;
	  max-width : 100%;
	}
	
	.album-item span{
	  width : 100%;
	  height : auto;
	  display : inline-block;
	  margin-top:5px;
	}
	.album-item .mask{
	  position : absolute;
	  background:red;
	  color:white;
	  top: 5px;
	  left: 5px;
	  padding : 3px;
	  font-size : 90%;
	  box-sizing:border-box;
	}
	.album-item img{
		height : 112px;
	}
	
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
	    margin: 0.5rem 0;
	    font-size: 1rem;
	    font-weight: 500;
	    color: rgba(0, 0, 0, 0.87);
	    min-height: 42px;
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
	.big-photo #photosCarousel{
		height: 100%;
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
    .clear {
    	clear: both;
    }	
    .bold{
    	font-weight : bold;
    }
</style>
<%
	long selectedAlbumId = ParamUtil.getLong(request, "selectedAlbumId", 0L);
	long paId = ParamUtil.getLong(request, "paId");
	int total = 0;
	int offset = 1;
	int delta = 6;
	int curPage = ParamUtil.getInteger(request, "curPage", 1);
	 start = (curPage - 1) * delta;
	int end = start + delta;
	 totalPage = 1;
	List<PCategory> albums = null;
	albums = PCategoryLocalServiceUtil.findByGroup(groupId, start, end);
	total = (int)PCategoryLocalServiceUtil.countByGroup(scopeGroupId);
	
	List<Long> albumIds = new ArrayList<Long>();
	if (albums != null && !albums.isEmpty()){
		for(PCategory album : albums){
			albumIds.add(album.getId());
		}
	}
	
	List<Photo> photos = PhotoLocalServiceUtil.findByAlbumIds(groupId, albumIds);
    
	if(total > delta){
		if(total % delta == 0){
			totalPage = total / delta;
		}else{
			totalPage = (int)(total / delta) + 1;
		}
	}
	String portletId = portletDisplay.getId();
	LiferayPortletURL pageURL = 
	PortletURLFactoryUtil.create(request, portletId, layout.getLayoutId(), PortletRequest.RENDER_PHASE);
	pageURL.setParameter("mvcPath", "/html/photo/albums.jsp");
	pageURL.setPlid(layout.getPlid());

%>
<c:choose>
	<c:when test="<%=!albums.isEmpty()%>">
	
		<%
			PCategory first = albums.get(0);
			String firstAlbumName = first.getName();
		%>
		<div class="album-main">
			<div id="album-main-title"  class="bold">
				<%= HtmlUtil.escape(firstAlbumName) %>
			</div>

			<div id="photos-main-view">
				<a href="#" class="close-button"><i class="fa fa-times-circle-o" aria-hidden="true"></i></a>
				<div id="photosCarousel" class="carousel slide" data-ride="carousel" >
					<div class="carousel-inner  photos">			
					<% 	
					String fileUrl="";
					int i = 0;
					for(Photo photo : photos){
						if(first.getId() == photo.getCategoryId()){
							if (photo.getFileId() > 0) {
								FileEntry photoFileEntry = DLAppServiceUtil.getFileEntry(photo.getFileId());
								if (photoFileEntry != null) {
									fileUrl = PhotoFileUtil.getPhotoThumbnailURL(themeDisplay, photoFileEntry);
								}
							}
							String name = photo.getCaption();
						%>
							<div class="item <%= i == 0 ? "active" : ""%>">
								<a href="#"> <img
									class="show-big-photo"
									alt="<%=HtmlUtil.escapeAttribute(name)%>"
									src="<%=fileUrl%>"></a>
								<a href="#" class="title" style="text-align: center;"><%=HtmlUtil.escape(name)%></a>									
							</div>
						<%
						i++;
						}
					}
					%>				
					</div>
					<a class="left carousel-control" href="#photosCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#photosCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
			<%
				if(albums != null && !albums.isEmpty()){ 
					i = 0;
					for(PCategory album : albums){
						String albumName = album.getName();
						HashMap<String, String> map = new HashMap<String, String>();
						String firstPhotoUrl = null;
						for(Photo photo : photos){
							if(album.getId() == photo.getCategoryId()){
								String url = "";
								String name = photo.getCaption();
								FileEntry photoFileEntry = DLAppServiceUtil.getFileEntry(photo.getFileId());
								if (photoFileEntry != null) {
									url = PhotoFileUtil.getPhotoThumbnailURL(themeDisplay, photoFileEntry);
								}
								map.put(url, name);
								if(firstPhotoUrl == null){
									firstPhotoUrl = url;
								}
							}
						}
			%>
							
							<div class="album-item" data-photo='<%=JSONFactoryUtil.looseSerialize(map) %>' data-name='<%= albumName %>'>
								<% if (i == 0){ %>
									<div class="mask">Đang xem...</div>
								<%} %>
								<div>
									<img src="<%=firstPhotoUrl %>" />
								</div>
								<div class="bold"  style="text-align: center;"> 
									<%= HtmlUtil.escape(albumName) %>
								</div>
							</div>
						
			<% 
					i++;
				}
					}
			%>
	</c:when>	
</c:choose>
<div class="clear"></div>
<div id="<portlet:namespace/>pagination"
	class="pagination pagination-large video-pagination"></div>
	<!-- Script phân trang -->
<aui:script>
	AUI().use(
			'aui-base',
			'liferay-portlet-url',
			'aui-pagination',
			'portlet-url',
			function(A) {
				new A.Pagination({
					after : {
						changeRequest : function(event) {
							var page = event.state.page;
							var pageURL = '<%=pageURL.toString()%>';
							pageURL = pageURL + '&_' + '<%=portletId%>'
									+ '_curPage=' + page;
							
							if (page != '<%=curPage%>') {
								window.location.href = pageURL.toString();
							}
						}
					},
					boundingBox : '#<portlet:namespace/>pagination',
					offset : '<%=offset%>',
					page : '<%=curPage%>',
					strings : {
						next : '»',
						prev : '«' 
					},
					total : '<%=totalPage%>'
				}).render();

			});

	
</aui:script>
<script type="text/javascript">
	$(document).ready(function(){
		$('.show-big-photo').bind('click', function(e){
			$('#photos-main-view').addClass('big-photo');
		});
		$('#photos-main-view .close-button').bind('click', function(e){
			$('#photos-main-view').removeClass('big-photo');
		});
		$('#photos-main-view img').css({
			'max-height' : (9.0/16.0 * $('#photos-main-view').width()) + "px",
			'min-height' : (9.0/16.0 * $('#photos-main-view').width()) + "px"
		});		
		$(document).keyup(function(e) {
	     	if (e.keyCode == 27) {
	    	 	$('#photos-main-view').removeClass('big-photo');
	    	}
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
	  									'<a href="#" class="title">', objs[key], '</a>',									
	  								'</div>'
  					               ].join(''));
  					i++;
  				}

  				$('#photos-main-view img').css({
  					'max-height' : (9.0/16.0 * $('#photos-main-view').width()) + "px",
  					'min-height' : (9.0/16.0 * $('#photos-main-view').width()) + "px"
  				});  				
  				$('.show-big-photo').bind('click', function(e){
  					$('#photos-main-view').addClass('big-photo');
  				});
 			}
  			$('.mask').remove();
  		    $item.append('<div class="mask">đang xem...</div>')
  		    window.scrollTo(0,0);
		});
	});
</script>		