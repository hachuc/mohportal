<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
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
	
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@include file="/html/admin/list-content/init.jsp"%>
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
	String viewPage8192 = VCMSPubliserUtil.getRedirectUrl(request,portletPreferences, themeDisplay, "linkToPage8192");
%>
<style>
	#<portlet:namespace />contentsSearchContainer_col-deploy-title, #<portlet:namespace />contentsSearchContainer_col-create-date{
		text-align: center;
	}
</style>
<liferay-ui:success key="success" message="dang-thanh-cong"/>
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
			<liferay-ui:search-container-results
				results="<%= ContentLocalServiceUtil.findByStatusVersion(keyword, scopeGroupId,categoryId, 0L, arrStatus, arrVersion, searchOption, searchContainer.getOrderByComparator(), searchContainer.getStart(), searchContainer.getEnd()) %>"
				total="<%=ContentLocalServiceUtil.countByStatusVersion(keyword, scopeGroupId,categoryId, 0L, arrStatus, arrVersion) %>"
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
				<%
					Category cat = CategoryLocalServiceUtil.fetchCategory(content.getCategoryId());
				%>
				<liferay-ui:search-container-column-text href="<%=rowURL %>" name="category-title" value="<%= cat!=null?cat.getCategoryName(): StringPool.BLANK%>" />
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="deploy-title"
					value="<%= content.getPublishedByUserName()%>" align="center" cssClass="align-center"
				/>
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="create-date"
					value="<%= dateFormat.format(content.getCreateDate())%>"
				/>
				<liferay-ui:search-container-column-text 
					name="option" cssClass="align-center double-icon">
					<portlet:renderURL var="editURL">
						<portlet:param name="mvcPath" value='<%= templatePath + "edit_content.jsp" %>' />
						<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
						<portlet:param name="contentId" value="<%= String.valueOf(content.getContentId()) %>"/>
						<portlet:param name="redirect" value="<%= redirect %>"/>
					</portlet:renderURL>
					<portlet:renderURL var="publishContentURL">
						<portlet:param name="mvcPath" value='<%= templatePath + "publish_content.jsp" %>' />
						<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
						<portlet:param name="contentId" value="<%= String.valueOf(content.getContentId()) %>"/>
						<portlet:param name="redirect" value="<%= viewPage8192 %>"/>
						<portlet:param name="backURL" value="<%=viewPage8192%>" />
					</portlet:renderURL>
					<portlet:renderURL var="rejectURL">
						<portlet:param name="mvcPath" value='<%=templatePath + "reject_content.jsp"%>' />
						<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
						<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
						<portlet:param name="redirectURL" value="<%=currentURL%>" />
						<portlet:param name="backURL" value="<%=currentURL%>" />
					</portlet:renderURL>
					
					<portlet:actionURL var="editActionURL" name="updateNextStatus">
						<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
						<portlet:param name="cmd" value="UDDEPLOYER" />
						<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
						<portlet:param name="nextStatus" value="4096" />
						<portlet:param name="redirect" value="<%=editURL.toString()%>" />
					</portlet:actionURL>
					<portlet:actionURL var="cancelEditURL" name="updateNextStatus">
						<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
						<portlet:param name="cmd" value="RMDEPLOYER" />
						<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
						<portlet:param name="nextStatus" value="2048" />
						<portlet:param name="redirect" value="<%=currentURL%>" />
					</portlet:actionURL>
					<portlet:actionURL var="publishActionURL" name="updateNextStatus">
						<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
						<portlet:param name="cmd" value="UDDEPLOYER" />
						<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
						<portlet:param name="nextStatus" value="4096" />
						<portlet:param name="redirect" value="<%=publishContentURL.toString()%>" />
						
					</portlet:actionURL>
					<portlet:actionURL var="forwardActionURL" name="updateNextStatus">
						<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
						<portlet:param name="cmd" value="UDDEPLOYER" />
						<portlet:param name="version" value="<%= String.valueOf(content.getVersion()) %>"/>
						<portlet:param name="nextStatus" value="8192" />
						<portlet:param name="redirect" value="<%= redirect %>"/>
					</portlet:actionURL>
					<portlet:renderURL var="compareURL">
						<portlet:param name="mvcPath" value='<%=templatePath + "compare_content.jsp"%>' />
						<portlet:param name="contentId" value="<%=String.valueOf(content.getContentId())%>" />
						<portlet:param name="version" value="4"/>
						<portlet:param name="redirectURL" value="<%=currentURL%>" />
						<portlet:param name="version" value="4"/>
					</portlet:renderURL>
					<a href="<%= compareURL.toString() %>" title="So sánh"><i class="glyphicon icon-random"></i></a>
					<a href="<%= rejectURL.toString() %>" title="Trả về" onclick="return confirm('Bạn muốn trả lại bài viết này?');"><i class="glyphicon icon-circle-arrow-left"></i></a>
					<a href="<%= editActionURL.toString() %>" title="Chọn biên tập"><i class="glyphicon icon-ok-circle"></i></a>
					<a href="<%= cancelEditURL.toString() %>" title="Thôi biên tập"><i class="glyphicon icon-ban-circle"></i></a>
					<a href="<%= publishActionURL.toString() %>" title="Chọn triển khai"><i class="glyphicon icon-wrench"></i></a>
					<a href="<%= forwardActionURL.toString() %>" title="Đăng bài"><i class="glyphicon icon-globe"></i></a>
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