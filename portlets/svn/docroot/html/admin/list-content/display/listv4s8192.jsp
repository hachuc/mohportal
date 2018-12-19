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
<style>
	#<portlet:namespace />contentsSearchContainer_col-deploy-title, #<portlet:namespace />contentsSearchContainer_col-send-date{
		text-align: center;
	}
</style>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</liferay-portlet:renderURL>
<div class="form-search ">
	<aui:form action="<%=searchURL%>" method="get" name="fm"
		class="form-horizontal listcontent-form" role="form">
		<liferay-portlet:renderURLParams varImpl="searchURL" />
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
								<aui:option value="1" label="search-by-title" />
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
			<c:choose>
				<c:when test='<%= showForAuthor %>'>
					<liferay-ui:search-container-results
					results="<%= ContentLocalServiceUtil.findByStatusVersion(keyword, scopeGroupId,categoryId, userId, arrStatus, arrVersion, searchOption, searchContainer.getOrderByComparator(), searchContainer.getStart(), searchContainer.getEnd()) %>"
					total="<%=ContentLocalServiceUtil.countByStatusVersion(keyword, scopeGroupId,categoryId, userId, arrStatus, arrVersion) %>"
				/>
				</c:when>
				<c:otherwise>
					<%
						List<Content> lstResults = null;
						int totalA = 0;
						if(keyword.isEmpty()){
							lstResults = ContentLocalServiceUtil.getContentsByStatusVersion(scopeGroupId, roleVersion, stateValue, searchContainer.getStart(), searchContainer.getEnd());
							totalA = ContentLocalServiceUtil.countContentsByStatusVersion(scopeGroupId, roleVersion, stateValue);
						}else{
							lstResults = ContentLocalServiceUtil.findByStatusVersion(keyword, scopeGroupId,categoryId, 0L, arrStatus, arrVersion, searchOption, searchContainer.getOrderByComparator(), searchContainer.getStart(), searchContainer.getEnd()); 
							totalA = ContentLocalServiceUtil.countByStatusVersion(keyword, scopeGroupId,categoryId, 0L, arrStatus, arrVersion);
						}
					%>
						<liferay-ui:search-container-results
							results="<%= lstResults%>"
							total="<%=totalA %>"
						/>
				</c:otherwise>
			</c:choose>
			
			<liferay-ui:search-container-row
	 			className="com.viettel.portal.vcms.model.Content"
				keyProperty="autoId"
				modelVar="content"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='<%= templatePath + "view_content.jsp" %>' />
					<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId()) %>"/>
					<portlet:param name="editable" value="<%= String.valueOf(false)%>" />
					<portlet:param name="redirect" value="<%= redirect %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="STT"
					value="<%=String.valueOf(index+1) %>"
					href="<%=rowURL %>" 
				/>
				
				<liferay-ui:search-container-column-text name="search-by-title" href="<%= rowURL %>" value="<%= content.getTitle()%>" />
				<%
					Category cat = CategoryLocalServiceUtil.fetchCategory(content.getCategoryId());
				%>
				<c:if test="<%= !showForAuthor %>">
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="category-title" value="<%= cat!=null?cat.getCategoryName(): StringPool.BLANK%>" />
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="discustion" value="<%= content.getPublishedByUserName()%>" />
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="deploy-title" value="<%= content.getPublishedByUserName()%>" cssClass="align-center" />				
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="send-date" value="<%= dateFormat.format(content.getCreateDate())%>" cssClass="align-center" />
				</c:if>
				<c:if test="<%= showForAuthor %>">
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="deploy-title" value="<%= content.getPublishedByUserName()%>" cssClass="align-center" />				
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="deploy-date" value="<%= dateFormat.format(content.getCreateDate())%>" cssClass="align-center" />
				</c:if>

				<c:if test="<%= !showForAuthor %>">
					<liferay-ui:search-container-column-text
					name="option" cssClass="align-center">
							<portlet:renderURL var="editURL">
								<portlet:param name="mvcPath" value='<%= templatePath + "edit_content.jsp" %>' />
								<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
								<portlet:param name="contentId" value="<%= String.valueOf(content.getContentId()) %>"/>
								<portlet:param name="redirect" value="<%= redirect %>"/>
							</portlet:renderURL>
							<portlet:actionURL var="unPublishContentURL" name="unPublishContent">
								<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
								<portlet:param name="contentId" value="<%=String.valueOf(content.getContentId())%>" />
								<portlet:param name="cmd" value="UNDEPLOY" />
								<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
								<portlet:param name="status" value="<%=String.valueOf(content.getStatus())%>" />
								<portlet:param name="redirect" value="<%=currentURL%>" />
							</portlet:actionURL>
							<portlet:actionURL var="deleteActionURL" name="removeContent">
								<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
								<portlet:param name="cmd" value="<%= Constants.DELETE %>" />
								<portlet:param name="contentId" value="<%= String.valueOf(content.getContentId()) %>"/>
								<portlet:param name="redirect" value="<%= redirect %>"/>
							</portlet:actionURL>
							<portlet:renderURL var="compareURL">
								<portlet:param name="mvcPath" value='<%=templatePath + "compare_content.jsp"%>' />
								<portlet:param name="contentId" value="<%=String.valueOf(content.getContentId())%>" />
								<portlet:param name="redirectURL" value="<%=currentURL%>" />
							</portlet:renderURL>
							
							<a href="<%= compareURL.toString() %>" title="So sánh"><i class="glyphicon icon-random"></i></a>
							<a href="<%= unPublishContentURL.toString() %>" title="Gỡ bài" onclick="return confirm('Bạn muốn gỡ bài viết này?');"><i class="glyphicon icon-circle-arrow-left"></i></a>
							<a href="<%= editURL.toString() %>" title="Sửa bài"><i class="glyphicon icon-edit"></i></a>
							<a href="<%= deleteActionURL.toString() %>" title="Xoá bài" onclick="return confirm('Bạn muốn xoá bài viết này?');"><i class="glyphicon icon-trash"></i></a>
				</liferay-ui:search-container-column-text>
				</c:if>
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />

		</liferay-ui:search-container>
	</aui:fieldset>
	</aui:form>
</div>