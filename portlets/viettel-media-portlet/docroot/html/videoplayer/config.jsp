<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLVideo"%>
<%@page import="com.viettel.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLCategory"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/videoplayer/init.jsp"%>

<liferay-portlet:renderURL var="selectVideoFormURL" portletName="<%=portletResource %>">
	<liferay-portlet:param name="jspPage" value="/html/videoplayer/list_video.jsp"/>
</liferay-portlet:renderURL>
<%
	//Danh sach tat ca cac folder hien co trong document library
	//List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(scopeId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

	int[] numbersOfVideoDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
	
	List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
	
	List<VLCategory> listCategory = VLCategoryLocalServiceUtil.findByGroup(scopeId);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<liferay-portlet:renderURL var="updateImageFolderURL" portletName="<%=portletResource %>">
	<liferay-portlet:param name="jspPage" value="/html/common/image-folder-update-form.jsp" />
	<liferay-portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request) %>"/>	
</liferay-portlet:renderURL>

<aui:form name="fm" method="post" action="<%=configurationActionURL %>">
	
	<div class="portlet-config-form">
		<div class="lfr-form-row">
			<%
				List<Group> groups = GroupLocalServiceUtil.getUserGroups(themeDisplay.getUserId());
			%>
			<aui:select name="scopeId" label="scope">
				<%for(Group group : groups) { %>
					<aui:option value="<%= group.getGroupId() %>" label="<%= HtmlUtil.escape(group.getName()) %>" selected="<%= scopeId == group.getGroupId()%>"/>
				<%} %>
			</aui:select>
		</div>
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input name="styleTitle" value="<%=styleTitle %>"/>
				<aui:input name="prefixLink" value="<%=prefixLink %>"/>
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input name="showTitle" value="<%=showTitle %>" type="checkbox"/> 
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:select name="numbersOfVideoDisplay">
					<aui:option label="video-none" value="-1" selected="<%=numbersOfVideoDisplay == -1 %>"/>
					<%
					for(int value : numbersOfVideoDisplayValues){
					%>
						<aui:option label="<%=String.valueOf(value) %>" value="<%=String.valueOf(value) %>" 
									selected="<%= numbersOfVideoDisplay == value%>"/>
					<%
					}
					%>
				</aui:select>
			</div>
		</div>	
		<div class="lfr-form-row">
			<div class="row-fields">
				<liferay-ui:message key="video-or"></liferay-ui:message>
				<aui:select name="categoryVideoDisplay">
					<aui:option label="video-none" value="-1" selected="<%=categoryVideoDisplay == -1 %>"/>
					<aui:option label="other-vl-category" value="0" selected="<%=categoryVideoDisplay == 0 %>"/>
					<%
					for(VLCategory cate : listCategory){
					%>
						<aui:option label="<%=String.valueOf(cate.getCategoryName()) %>" value="<%=String.valueOf(cate.getCategoryId()) %>" 
									selected="<%= categoryVideoDisplay == cate.getCategoryId()%>"/>
					<%
					}
					%>
				</aui:select>
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="row-fields">
				<liferay-ui:message key="video-or"></liferay-ui:message>
				<div id="selected-video-display">
					<aui:button name="selectVideo" value="select-video" type="button"/>
					<div class="cfg-tbl-video-selected" id="cfg-tbl-video-selected">
						<div class="tbl-header">
							<span class="tbl-col-1"><liferay-ui:message key="video-name"/></span>
							<span class="tbl-col-2"><liferay-ui:message key="video-desc"/></span>
							<span class="tbl-col-3"><liferay-ui:message key="modified-date"/></span>
							<span class="tbl-col-4"><liferay-ui:message key="delete"/></span>
						</div>
						<c:if test="<%=Validator.isNotNull(selectedVideosId) %>">
						<%
							long[] videoIds = StringUtil.split(selectedVideosId, 0L);
							if(videoIds != null && videoIds.length > 0){
								for(long videoId:videoIds){
									if(videoId > 0){
										VLVideo video = null;
										try{
											video = VLVideoLocalServiceUtil.getVLVideo(videoId);
										}catch(Exception e){
											_log.warn(e);
										}
										
										if(video != null && !video.isInvisible()){
											%>
												<div class="tbl-row">
													<span class="tbl-col-1"><%=HtmlUtil.escape( video.getVideoName() )%></span>
													<span class="tbl-col-2"><%=HtmlUtil.escape( video.getDescription() ) %></span>
													<span class="tbl-col-3"><%=dateTimeFormat.format(video.getModifiedDate()) %></span>
													<span class="tbl-col-4" onclick="removeSelectedVideo(this)">X</span>
													<input type="hidden" name="_86_selectedVideoId" value="<%=video.getVideoId()%>">
												</div>
											<%
										}
									}
								}
							}
						%>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:select name="displayStyle" label="display-style" >
					<aui:option label="default-style" value="default-style" 
								selected='<%=Validator.equals(displayStyle, "default-style") %>'/>
					<aui:option label="focus-style" value="focus-style" 
								selected='<%=Validator.equals(displayStyle, "focus-style") %>'/>
					<aui:option label="videoWidget" value="videoWidget" 
								selected='<%=Validator.equals(displayStyle, "videoWidget") %>'/>
				</aui:select>			
			</div>
		</div>

		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input type="checkbox" name="useCustomVideoFrameSize" value="<%=useCustomVideoFrameSize %>"/>
				
				<div id="<portlet:namespace />frameSizeSettingContainer" class="aui-helper-hidden">
					<div>
						<span style="float:left;">
							<aui:input name="videoFrameHeight" value="<%=videoFrameHeight %>">
								<aui:validator name="digits"/>
							</aui:input>
						</span>
						<span style="float:left; margin-left: 10px">
							<aui:select name="heightUnit" label="unit">
								<aui:option value="px" selected="<%=heightUnit.equals(VideoConstants.PIXEL) %>">px</aui:option>
								<aui:option value="%" selected="<%=heightUnit.equals(VideoConstants.PERCENT) %>">%</aui:option>
							</aui:select>	
						</span>
					</div>
					
					<div>
						<span style="float:left;">
							<aui:input name="videoFrameWidth" value="<%=videoFrameWidth %>">
								<aui:validator name="digits"/>
							</aui:input>
						</span>
						
						
						<span style="float:left; margin-left: 10px">
							<aui:select name="widthUnit" label="unit">
								<aui:option value="px" selected="<%=widthUnit.equals(VideoConstants.PIXEL) %>">px</aui:option>
								<aui:option value="%" selected="<%=widthUnit.equals(VideoConstants.PERCENT) %>">%</aui:option>
							</aui:select>	
						</span>
					</div>
				</div>
			</div>
		</div>
				
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input type="checkbox" name="showViewMoreVideoLink" value="<%=showViewMoreVideoLink %>"/>
				<div id="<portlet:namespace />videoPageSelectorContainer" class="aui-helper-hidden">
					<aui:select name="videoPageLayoutId" label="display-video-on-page">
						<%
						for(Layout layoutTemp : groupLayoutList){
						%>
							<aui:option label="<%=HtmlUtil.stripHtml( layoutTemp.getName() )%>" value="<%=layoutTemp.getPlid() %>" 
										selected="<%=videoPageLayoutId == layoutTemp.getPlid() %>"/>
						<%
						}
						%>
					</aui:select>
				</div>
			</div>
		</div>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="cancelBtn" value="cancel"/>
		</aui:button-row>
	</div>
</aui:form>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />useCustomVideoFrameSizeCheckbox','<portlet:namespace />frameSizeSettingContainer');
	Liferay.Util.toggleBoxes('<portlet:namespace />showViewMoreVideoLinkCheckbox','<portlet:namespace />videoPageSelectorContainer');
</aui:script>

<aui:script use="aui-base">
	AUI().ready(function(A){
		
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		var displayStyleSelect = A.one('#<portlet:namespace/>displayStyle');
		
		if (displayStyleSelect){
			if(displayStyleSelect.val == 'grid-style'){
				A.one ('#selected-video-display').setStyle ("display","none");
			}
			displayStyleSelect.on('change',function(){
				var displayStyle = displayStyleSelect.attr('value');
				
				if (displayStyle == 'grid-style'){
					A.one ('#selected-video-display').setStyle ("display","none");
				}
				else{
					A.one ('#selected-video-display').setStyle ("display","block");
				}
			});
		}
		
		if(closeConfigPageBtn){	
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
		
		var selectVideo = A.one('#<portlet:namespace/>selectVideo');
		
		if(selectVideo){
			selectVideo.on('click', function(A){
				selectVLVideoForm('<%=selectVideoFormURL.toString()%>');
			});
		}
	});
	
	Liferay.provide(
		window,
		'selectVLVideoForm',
		function(url){
			var title="<liferay-ui:message key='select-video'/>";
			var dialogWidow = {
				dialog: {
					constrain: true,
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: '80%',
					cache: false,
					after: {
						visibleChange: function(event) {
						}
                    }
				},
				title: title,
				uri: url,
			};
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
	Liferay.provide(
		window,
		'removeSelectedVideo',
		function(e){
			var A = AUI();
			var row = A.one(e).ancestor();
			var msg="<liferay-ui:message key='do-you-want-remove-this-video'/>";
			var r = confirm(msg);
			if(r){
				if(row){
					row.remove();
				}
			}else{
				return;
			}
		}
	);
</aui:script>

<aui:script>

AUI().ready('aui-base','liferay-portlet-url',function(A){
	
	var createFolderIcon = A.one('#<portlet:namespace />createFolderIcon');
	
	if(createFolderIcon){
	
		createFolderIcon.on('click',function(){
			
			var folderSelector = A.one('#<portlet:namespace />selectedImageFolderId');
			
			if(folderSelector){
				
				var parentFolderId = folderSelector.val();
								
				var updateFolderURL = Liferay.PortletURL.createRenderURL();
											
				updateFolderURL.setPortletId('<%=portletResource %>');
				updateFolderURL.setParameter('portletResource', '<%=portletResource %>');
				updateFolderURL.setWindowState('pop_up');
				updateFolderURL.setParameter('jspPage', '/html/common/image-folder-update-form.jsp');
				updateFolderURL.setParameter('parentFolderId', parentFolderId);
				updateFolderURL.setDoAsGroupId('<%=scopeId %>');
				
				<portlet:namespace />addImageFolder(updateFolderURL);
			}
		});
	}
					
	var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
	
	if(closeConfigPageBtn){
		
		closeConfigPageBtn.on('click',function(){
			Liferay.Util.getWindow().close();
		});
	}
	
	Liferay.Util.toggleBoxes('<portlet:namespace />useCustomImageSizeCheckbox','<portlet:namespace />customImageSizePanel');

	Liferay.Util.toggleBoxes('<portlet:namespace />displayGalleryLinkCheckbox','<portlet:namespace />displayGalleryLinkPanel');
});

	
Liferay.provide(
	window,
	'<portlet:namespace />addImageFolder',
	function(url) {
	
		var A = AUI();
		
		var config = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 820,
					cache: false
				},
			uri: url
		};
		Liferay.Util.openWindow(config);
	}
);
</aui:script>

