<%@page import="com.viettel.portal.magazine.service.MagazineLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.model.Magazine"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.viettel.portal.magazine.FileTypeException" %>
<%@page import="com.viettel.portal.magazine.FileSizeException" %>
<%@page import="com.viettel.portal.magazine.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	int id = ParamUtil.getInteger(request, "id");
	Magazine magazine = null;
	if (id > 0){
		magazine = MagazineLocalServiceUtil.getMagazine(id);
	}
	int day = 0;	
	int month = 0;
	int year = 0;
	if(magazine != null && magazine.getDistributedDate() != null){
		Calendar cal = Calendar.getInstance();
		cal.setTime(magazine.getDistributedDate());
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) ;
		day = cal.get(Calendar.DAY_OF_MONTH);
	}
%>

<div class="magazine-update-form">
	<liferay-ui:error key="<%=FileTypeException.class.getName()%>"
		message="not-support-this-image-file-type" />
	<liferay-ui:error key="<%=FileSizeException.class.getName()%>"
		message="image-size-too-larger" />

	<portlet:actionURL name="updateMagazine" var="updateMagazineActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id)%>" />
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
	</portlet:actionURL>

	<aui:form name="fm" enctype="multipart/form-data" method="post"
		action="<%=updateMagazineActionURL%>"  cssClass="magazine-form">

		<aui:model-context bean="<%=magazine%>" model="<%=Magazine.class%>" />
		<aui:input type="hidden" name="imageUrl" />

		<aui:row>
			<aui:col>
				<aui:input name="name" label="name" type="text" size="500">
					<aui:validator name="required" />
					<aui:validator name="maxLength">250</aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col>
				<aui:input name="publishNumber" label="publishNumber" type="number" size="255" value='<%= magazine != null ? magazine.getPublishNumber() : "" %>'>
					<aui:validator name="required" />
					<aui:validator name="maxLength">11</aui:validator>
					<aui:validator name="number">true</aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col>
				<aui:select name="publishYear" id="publishYear" label="publishYear">
					<%
						Date now = new Date();
						int currentYear = now.getYear() + 1900;
						for(int i = currentYear; i >= 1955; i--){
							%>
							<aui:option value="<%= i %>" label="<%= i %>"></aui:option>
							<%
						}
					%>
				</aui:select>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col>
			<liferay-ui:message key="distributedDate" />
			<%
				if(day > 0 && month >= 0 && year > 0){
			%>
			<liferay-ui:input-date name="distributedDate" dayParam="ddDay"
				dayValue="<%=day%>" monthParam="ddMonth" monthValue="<%=month%>"
				yearParam="ddYear" yearValue="<%=year%>" />
			<%
				} else{
			%>
			<liferay-ui:input-date name="distributedDate" nullable="true"
				dayParam="ddDay" monthParam="ddMonth" yearParam="ddYear" />
			<%
				}
			%>

			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col>
				<%
					if (magazine != null){
				%>
					<aui:input type="file" name="imageUrlInput" label="imageUrl"
						accept=".png,.jpeg,.jpg,.gif">
					</aui:input>
				<%
					} else {
				%>
					<aui:input type="file" name="imageUrlInput" label="imageUrl"
						accept=".png,.jpeg,.jpg,.gif">
						<aui:validator name="required" />
					</aui:input>
				<%
					}
				%>
				<%
					if(magazine != null && magazine.getImageID() > 0){
				%>
				<%
					String thumbnailURL = request.getContextPath() + "/images/default-thumbnail.jpg";
						FileEntry thumbnailImage = null;
						try{
							thumbnailImage = DLAppServiceUtil.getFileEntry(magazine.getImageID());
						}catch(Exception e){
							
						}
						if(thumbnailImage != null){
							thumbnailURL = MagazineFileUtil.getThumbnailURL(themeDisplay, thumbnailImage);
						}
				%>
				<div id="<portlet:namespace/>previewImageThumbnai">
					<img alt="" src="<%=thumbnailURL%>" width="150">
				</div>
				<%
					}
				%>				
			</aui:col>
		</aui:row>

		<aui:button-row>
			<aui:button type="submit" value="save-s" />
			<aui:button name="closeMagazineUpdateFormBtn" value="cancel-c" />
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	AUI().ready( function(A) {
		var closeMagazineUpdateFormBtn = A.one('#<portlet:namespace/>closeMagazineUpdateFormBtn');
		if (closeMagazineUpdateFormBtn) {
			closeMagazineUpdateFormBtn.on('click', function() {
				Liferay.Util.getWindow().destroy();
			});
		}
	});
</aui:script>
	

