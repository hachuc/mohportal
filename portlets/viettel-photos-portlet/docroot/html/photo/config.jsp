<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.List"%>
<%@page import="com.viettel.portal.photos.model.PCategory"%>
<%@page import="com.viettel.portal.photos.service.PCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.photos.model.Photo"%>
<%@page import="com.viettel.portal.photos.service.PhotoLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/photo/init.jsp"%>

<%
	int[] numbersOfAlbumDisplayValues = {1,2,3,4,5,6,7,8,9,10};
	
	List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
	
	List<PCategory> listCategory = PCategoryLocalServiceUtil.findByGroup(scopeGroupId);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<aui:form name="fm" method="post" action="<%=configurationActionURL %>">
	
	<div class="portlet-config-form">
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input name="styleTitle" value="<%=styleTitle %>"/>
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:select name="numbersOfAlbumDisplay">
					<aui:option label="photo-none" value="-1" selected="<%=numbersOfAlbumDisplay == -1 %>"/>
					<%
					for(int value : numbersOfAlbumDisplayValues){
					%>
						<aui:option label="<%=String.valueOf(value) %>" value="<%=String.valueOf(value) %>" 
									selected="<%= numbersOfAlbumDisplay == value%>"/>
					<%
					}
					%>
				</aui:select>
			</div>
		</div>	
		<div class="lfr-form-row">
			<div class="row-fields">
				<liferay-ui:message key="photo-or"></liferay-ui:message>
				<aui:select name="albumDisplay">
					<aui:option label="photo-none" value="-1" selected="<%=albumDisplay == -1 %>"/>
					<%
					for(PCategory cate : listCategory){
					%>
						<aui:option label="<%=HtmlUtil.escape(cate.getName()) %>" value="<%=String.valueOf(cate.getId()) %>" 
									selected="<%= albumDisplay == cate.getId()%>"/>
					<%
					}
					%>
				</aui:select>
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:select name="displayStyle" label="display-style" >
					<aui:option label="default-style" value="default-style" 
								selected='<%=Validator.equals(displayStyle, "default-style") %>'/>
				</aui:select>			
			</div>
		</div>
				
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input type="checkbox" name="showViewMorePhotoLink" value="<%=showViewMorePhotoLink %>"/>
				<div id="<portlet:namespace />photoPageSelectorContainer" class="aui-helper-hidden">
					<aui:select name="photoPageLayoutId" label="display-photo-on-page">
						<%
						for(Layout layoutTemp : groupLayoutList){
						%>
							<aui:option label="<%=HtmlUtil.stripHtml( layoutTemp.getName() )%>" value="<%=layoutTemp.getPlid() %>" 
										selected="<%=photoPageLayoutId == layoutTemp.getPlid() %>"/>
						<%
						}
						%>
					</aui:select>
				</div>
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
								<aui:option value="px" selected='<%=heightUnit.equals("px") %>'>px</aui:option>
								<aui:option value="%" selected='<%=heightUnit.equals(StringPool.PERCENT) %>'>%</aui:option>
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
								<aui:option value="px" selected='<%=widthUnit.equals("px") %>'>px</aui:option>s
								<aui:option value="%" selected='<%=widthUnit.equals(StringPool.PERCENT) %>'>%</aui:option>
							</aui:select>	
						</span>
					</div>
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
	Liferay.Util.toggleBoxes('<portlet:namespace />useCustomPhotoFrameSizeCheckbox','<portlet:namespace />frameSizeSettingContainer');
	Liferay.Util.toggleBoxes('<portlet:namespace />showViewMorePhotoLinkCheckbox','<portlet:namespace />photoPageSelectorContainer');
</aui:script>

<aui:script use="aui-base">
	AUI().ready(function(A){
		
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){	
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</aui:script>

