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
<%@include file="/html/admin/init.jsp"%>
<%
	String keyword = ParamUtil.getString(request, "searchKeyword");
	long categoryId = ParamUtil.getLong(request, "categoryId", 0L);
	int searchBy = ParamUtil.getInteger(request, "searchBy", 0);
	int searchOption = ParamUtil.getInteger(request, "searchOption", 0);
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
			<%
			List<Content> lstResults = ContentLocalServiceUtil.findByStatusVersion(keyword, scopeGroupId,categoryId, showByAuthorId, arrStatus, arrVersion, searchOption, searchContainer.getOrderByComparator(), searchContainer.getStart(), searchContainer.getEnd()); 
			int totalA = ContentLocalServiceUtil.countByStatusVersion(keyword, scopeGroupId,categoryId, showByAuthorId, arrStatus, arrVersion);
		%>
			<liferay-ui:search-container-results
				results="<%= lstResults%>"
				total="<%=totalA %>"
			/>
			

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
					name="author"
					value="<%= HtmlUtil.escape(content.getCreatedByUserName())%>"
				/>
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="create-date-1s2"
					value="<%= dateFormat.format(content.getCreateDate())%>"
				/>
				<liferay-ui:search-container-column-text
					name="option" cssClass="align-center double-icon"
				>
					<portlet:actionURL var="deleteURL" name="deleteContent">
						<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
						<portlet:param name="cmd" value="<%= Constants.DELETE %>"/>						
						<portlet:param name="version" value="<%= String.valueOf(content.getVersion()) %>"/>
						<portlet:param name="status" value="<%= String.valueOf(content.getStatus()) %>"/>
						<portlet:param name="redirect" value="<%= redirect %>"/>
					</portlet:actionURL>
					<a href="<%= deleteURL.toString() %>" title="Xóa" onclick="return confirm('Bạn muốn xóa viết này?');"><i class="glyphicon icon-trash"></i></a>
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