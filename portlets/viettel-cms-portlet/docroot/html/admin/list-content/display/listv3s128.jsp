<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@page import="com.viettel.portal.vcms.permission.CategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.viettel.portal.vcms.model.Category"%>
<%@ page
	import="com.viettel.portal.vcms.service.CategoryLocalServiceUtil"%>
<%@include file="/html/admin/list-content/init.jsp"%>
<%
	String keyword = ParamUtil.getString(request, "searchKeyword");
	long categoryId = ParamUtil.getLong(request, "categoryId", 0L);
	int searchBy = ParamUtil.getInteger(request, "searchBy", 0);
	int searchOption = ParamUtil.getInteger(request, "searchOption", 0);
	String viewPage128 = VCMSPubliserUtil.getRedirectUrl(request,portletPreferences, themeDisplay, "linkToPage128");
	List<Category> categories = new ArrayList<Category>();
	try {
		categories = CategoryLocalServiceUtil
				.getAllCategories(scopeGroupId);
	} catch (Exception e) {
	}
%>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
	<portlet:param name="searchKeyword" value='<%= keyword %>' />
	<portlet:param name="searchBy" value='<%= String.valueOf(searchBy) %>' />
	<portlet:param name="searchOption" value='<%= String.valueOf(searchOption) %>' />
	<portlet:param name="categoryId" value='<%= String.valueOf(categoryId)%>' />
    <portlet:param name="resetCur" value='true' />
</liferay-portlet:renderURL>
<div class="form-search ">
	<aui:form action="<%=searchURL%>" method="get" name="fm"
		class="form-horizontal listcontent-form" role="form">
		<liferay-ui:panel-container cssClass="basic-info"
			id="basic-info-container" extended="true">
			<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
				id="basic-info" persistState="<%=true%>" title='<%= "page-title-v" + roleVersion + "s" + stateValue %>'>
				<aui:field-wrapper label="">
					<aui:fieldset>
						<aui:column columnWidth="30">
							<div class="control-group">
								<aui:input name="searchKeyword" label="key-word"
									autoFocus="<%=true%>" type="text" cssClass="lfr-input-text"
									inlineField="<%=true%>" />
							</div>
							<aui:select name="categoryId" label="choose-category">
								<aui:option value="0" label="all-types" selected="true" />
								<%
									if (categories != null) {
																	for (Category cat : categories) {
								%>
								<aui:option value="<%=cat
															.getCategoryId()%>"><%=HtmlUtil.escape(cat
															.getCategoryName())%></aui:option>
								<%
									}
																}
								%>
							</aui:select>
						</aui:column>

						<aui:column columnWidth="10">
							<aui:select name="searchBy" label="search-by">
								<aui:option value="0" label="all-types" selected="true" />
								<aui:option value="1" label="search-title" />
								<aui:option value="2" label="search-by-content" />
							</aui:select>
							<aui:select name="searchOption" label="search-option">
								<aui:option value="0" label="relative-option" selected="true" />
								<aui:option value="1" label="absolute-option" />
							</aui:select>
						</aui:column>
						<aui:column columnWidth="10">
							<label class="control-label">&nbsp;</label>
							<aui:button type="submit" value="search" />
						</aui:column>
						<aui:column columnWidth="45">

						</aui:column>
					</aui:fieldset>
				</aui:field-wrapper>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		
		<aui:fieldset>
		<liferay-ui:search-container delta="20" emptyResultsMessage="no-result-were-found" iteratorURL="<%= searchURL %>">
			<c:if test='<%= stateValue == 128 || stateValue == 64 %>'>
			<%
				arrStatus = new int[]{64, 128};
				arrVersion = new int[]{3,4};
			%>
			<liferay-ui:search-container-results
				results="<%= ContentLocalServiceUtil.findByStatusVersion(keyword, scopeGroupId,categoryId, 0L, arrStatus, arrVersion, searchOption, searchContainer.getOrderByComparator(), searchContainer.getStart(), searchContainer.getEnd()) %>"
				total="<%=ContentLocalServiceUtil.countByStatusVersion(keyword, scopeGroupId,categoryId, 0L, arrStatus, arrVersion) %>"
			/>
			</c:if>

			<liferay-ui:search-container-row
	 			className="com.viettel.portal.vcms.model.Content"
				keyProperty="autoId"
				modelVar="content"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='<%= templatePath + "view_content.jsp" %>' />
					<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId()) %>"/>
					<portlet:param name="contentId" value="<%=String.valueOf(content.getContentId()) %>"/>
					<portlet:param name="editable" value="<%= String.valueOf(false)%>" />
					<portlet:param name="redirect" value="<%= redirect %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="STT"
					value="<%=String.valueOf(index+1) %>"
					href="<%=rowURL %>" 
				/>
				
				<liferay-ui:search-container-column-text
					name="search-by-title"
					href="<%= rowURL %>"
					value="<%= HtmlUtil.escape(content.getTitle())%>"
				>

				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="editor"
					value="<%= HtmlUtil.escape(content.getEditedByUserName())%>"
				/>
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="create-date"
					value="<%= dateFormat.format(content.getCreateDate())%>"
				/>
				<liferay-ui:search-container-column-text
					name="action" cssClass="align-center double-icon">
					<portlet:actionURL var="rewriteContentURL" name="rewriteContentVersion34">
                        <portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
                        <portlet:param name="contentId" value="<%=String.valueOf(content.getContentId())%>" />
                        <portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
                        <portlet:param name="status" value="<%=String.valueOf(content.getStatus())%>" />
                        <portlet:param name="redirectURL" value="<%=currentURL%>" />
                    </portlet:actionURL>
					<portlet:renderURL var="rejectURL">
						<portlet:param name="mvcPath" value='<%=templatePath + "reject_content.jsp"%>' />
						<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
						<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
                        <portlet:param name="status" value="<%=String.valueOf(content.getStatus())%>" />
						<portlet:param name="contentId" value="<%=String.valueOf(content.getContentId())%>" />
						<portlet:param name="redirectURL" value="<%=currentURL%>" />
						<portlet:param name="backURL" value="<%= viewPage128 %>" />
					</portlet:renderURL>
					
					<portlet:renderURL var="viewComment" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value='<%=templatePath + "view_notes.jsp"%>' />
						<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
						<portlet:param name="contentId" value="<%=String.valueOf(content.getContentId())%>" />
						<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />							
					</portlet:renderURL>
					<%
						String javascriptHref = "javascript:viewCommentForm('" + viewComment.toString() + "')";
					%>
					<a href="<%= rewriteContentURL.toString() %>" title="Viết lại"><i class="glyphicon icon-edit"></i></a>
					<a href="<%= rejectURL.toString() %>" title="Trả về" onclick="return confirm('Bạn muốn trả lại viết này?');"><i class="glyphicon icon-circle-arrow-left"></i></a>
					<a href="<%= javascriptHref %>" title="Chú thích" ><i class="glyphicon icon-comment"></i></a>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>
			<liferay-portlet:renderURLParams varImpl="searchURL">
					<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
					<portlet:param name="searchKeyword" value='<%= keyword %>' />
					<portlet:param name="searchBy" value='<%= String.valueOf(searchBy) %>' />
					<portlet:param name="searchOption" value='<%= String.valueOf(searchOption) %>' />
					<portlet:param name="categoryId" value='<%= String.valueOf(categoryId)%>' />
	    			<portlet:param name="resetCur" value='true' />
				</liferay-portlet:renderURLParams>
			<liferay-ui:search-iterator />

		</liferay-ui:search-container>
	</aui:fieldset>
	</aui:form>
</div>
<aui:script use="aui-base,uploader">
	Liferay.provide(
		window,
		'viewCommentForm',
		function(url){
			
			var dialogWidow = {
				dialog: {
					constrain: true,
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: '40%',
					cache: false,
				},
				title: '<liferay-ui:message key="xem-chu-thich" />',
				uri: url,
				
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
</aui:script>