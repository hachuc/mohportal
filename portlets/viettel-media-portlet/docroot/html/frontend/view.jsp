
<%@page import="com.viettel.portal.videolibrary.util.VideoFileUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.viettel.portal.videolibrary.util.VideoConstants"%>
<%@page import="com.viettel.portal.videolibrary.service.VLVideoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/frontend/init.jsp"%>
<%
	String docCode = ParamUtil.getString(request, "docCode");
	String rank = ParamUtil.getString(request, "rank",VideoConstants.INTERNAL_VIDEO_TYPE);
	long fieldId = ParamUtil.getLong(request, "fieldId", 0L);
	String companyName = ParamUtil.getString(request, "companyName");
	List<VLCategory> categories = VLCategoryLocalServiceUtil.getByGroupUserSite(groupId);
%>
<style>
	#<portlet:namespace />contentsSearchContainer_col-deploy-title, #<portlet:namespace />contentsSearchContainer_col-create-date{
		text-align: center;
	}
</style>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="jspPage" value='/html/frontend/view.jsp' />
<%-- 	<portlet:param name="docCode" value='<%= docCode %>' />
	<portlet:param name="rank" value='<%= rank %>' />
	<portlet:param name="fieldId" value='<%= String.valueOf(fieldId) %>' />
	<portlet:param name="companyName" value='<%= companyName %>' />
 --%>    <portlet:param name="resetCur" value='true' />
</liferay-portlet:renderURL>
<h4 class="headerBoxh4">Kết quả dịch vụ hành chính công111 <%= categories.size() %></h4>
<div class="form-search ">
	<aui:form action="<%=searchURL%>" method="get" name="fm"
		class="form-horizontal listcontent-form" role="form">
		<liferay-portlet:renderURLParams varImpl="searchURL"/>
		<liferay-ui:panel-container cssClass="basic-info"
			id="basic-info-container" extended="true">
			<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
				id="basic-info" persistState="<%=true%>" title='chose-condition-search'>
				<aui:field-wrapper label="">
				
				<aui:fieldset >
					<aui:row>
						<aui:column cssClass="formSearch" columnWidth="50">
							<aui:select name="rank" label="video-type">
								<aui:option label="central" value="<%=VideoConstants.INTERNAL_VIDEO_TYPE %>" 
													selected='<%=Validator.equals(rank, VideoConstants.INTERNAL_VIDEO_TYPE) %>'/>
								<aui:option label="local" value="<%=VideoConstants.EXTERNAL_VIDEO_TYPE %>" 
													selected='<%=Validator.equals(rank, VideoConstants.EXTERNAL_VIDEO_TYPE) %>'/>
							</aui:select>
							<aui:input name="docCode" label="doc-code" type="text" size="100" value="<%=docCode %>">
								<aui:validator name="maxLength">500</aui:validator>
							</aui:input>
						</aui:column>
						<aui:column cssClass="formSearch" columnWidth="50">
							<aui:select name="fieldId" label="video-category">
								<c:choose>
									<c:when test="<%=(categories.size()>0) %>">
										<aui:option label = "chose-vlcategory" value = "0"	
											selected = "true"/>
										<%
											for (int i = 0; i < categories.size();i++){
											%>
												<aui:option label = "<%=HtmlUtil.escape(categories.get(i).getCategoryName()) %>" 
													value = "<%=categories.get(i).getCategoryId() %>"/>
											<%
											}
										%>
									</c:when>
									<c:otherwise>
										<aui:option  label = "no-category" value = "0L"/>
									</c:otherwise>
								</c:choose>
							</aui:select>
							<aui:input name="companyName" type="text" label="company-name">
								<aui:validator name="maxLength">2000</aui:validator>
							</aui:input>
						</aui:column>
					</aui:row>
					<aui:row>
					</aui:row>
				</aui:fieldset>
				</aui:field-wrapper>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		<aui:button type="submit" value="search" /> <br/>
		<span class="lable-result"><liferay-ui:message key="list-public-service-result" /></span><br/> 
		<% int totalResult = (int)VLVideoLocalServiceUtil.countByKeywordFrontend(groupId, rank, docCode, fieldId, companyName); %>
		<span class="result-value"><liferay-ui:message key="total-result" /><%= totalResult %></span>
		<aui:fieldset>
		<liferay-ui:search-container delta="10" emptyResultsMessage="no-result-were-found" iteratorURL="<%= searchURL %>">
			<liferay-ui:search-container-results
				results="<%= VLVideoLocalServiceUtil.findByKeywordFrontend(groupId, rank, docCode,fieldId,companyName, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator()) %>"
				total="<%=(int)VLVideoLocalServiceUtil.countByKeywordFrontend(groupId, rank, docCode, fieldId, companyName) %>"
			/>
			

			<liferay-ui:search-container-row
	 			className="com.viettel.portal.videolibrary.model.VLVideo"
				keyProperty="videoId"
				modelVar="video"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='/html/frontend/preview_detail.jsp' />
					<portlet:param name="videoId" value="<%=String.valueOf(video.getVideoId()) %>"/>
					<portlet:param name="editable" value="<%= String.valueOf(false)%>" />
					<portlet:param name="redirect" value="<%= redirect %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="STT"
					value="<%=String.valueOf(index+1) %>"
				/>
				<liferay-ui:search-container-column-text cssClass="width-20"
					name="doc-code"
					href="<%= rowURL %>"
					value="<%=video.getVideoName() %>"
				/>
				<%
				VLCategory vlCategory = VLCategoryLocalServiceUtil.fetchVLCategory(video.getCategoryId());
				%>
				
				<liferay-ui:search-container-column-text name="video-category" value="<%= vlCategory!=null?vlCategory.getCategoryName(): StringPool.BLANK%>" />
				
				<liferay-ui:search-container-column-text name="company-name" value="<%=video.getDescription()%>" />
				<%
				String rankName ="";
				
				if(Validator.equals(video.getVideoType(), VideoConstants.INTERNAL_VIDEO_TYPE)){
					rankName = VideoConstants.INTERNAL_NAME;
				}else if(Validator.equals(video.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
					rankName = VideoConstants.EXTERNAL_NAME;
				}
				%>
				<liferay-ui:search-container-column-text name="video-type" value="<%=rankName%>" />
				<%
				String fileName ="";
				String fileUrl ="";
				FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(video.getFileId());
				if(videoFileEntry != null){
					fileName = videoFileEntry.getTitle();
					fileUrl = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
				}
				%>
				<liferay-ui:search-container-column-text cssClass="shorttext" name="file-name" value="<%=fileName%>"
				title="<%=fileName %>" href="<%=fileUrl %>"  valign="middle"/>
				
				
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
			
		</liferay-ui:search-container>
	</aui:fieldset>
	</aui:form>
</div>