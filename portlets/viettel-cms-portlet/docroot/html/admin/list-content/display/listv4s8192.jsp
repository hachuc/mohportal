<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.service.DistributionLocalServiceUtil"%>
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
				id="basic-info" persistState="<%=true%>" title='<%=!showForAuthor? "page-title-v" + roleVersion + "s" + stateValue:"page-title-v" + roleVersion + "s" + stateValue+"s" %>'>
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
								<aui:option value="<%=cat.getCategoryId()%>"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
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
			<c:choose>
				<c:when test='<%= showForAuthor %>'>
					<liferay-ui:search-container-results
					results="<%= DistributionLocalServiceUtil.findByVersionAndStatus(scopeGroupId,categoryId, keyword,  userId, searchOption, searchContainer.getStart(), searchContainer.getEnd()) %>"
					total="<%= DistributionLocalServiceUtil.countByVersionAndStatus(scopeGroupId,categoryId, keyword, userId, searchOption)%>"
				/>
				</c:when>
				<c:otherwise>
					<%
						List lstResults = DistributionLocalServiceUtil.findByVersionAndStatus(scopeGroupId,categoryId, keyword,  0L, searchOption, searchContainer.getStart(), searchContainer.getEnd());
						int totalA = DistributionLocalServiceUtil.countByVersionAndStatus(scopeGroupId,categoryId, keyword, 0L, searchOption);
					%>
						<liferay-ui:search-container-results
							results="<%= lstResults%>"
							total="<%=totalA %>"
						/>
				</c:otherwise>
			</c:choose>
			<%
			String serilizeString=null;
			JSONArray commentDataJsonArray=null;
			%>
			<liferay-ui:search-container-row
	 			className="java.lang.Object"
				modelVar="content"
			>
			<% 
				serilizeString=JSONFactoryUtil.serialize(content);
				commentDataJsonArray=JSONFactoryUtil.createJSONArray(serilizeString);
				boolean isvisible = GetterUtil.getBoolean(commentDataJsonArray.getString(8), false);
			%>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='<%= templatePath + "view_content.jsp" %>' />
					<portlet:param name="autoId" value="<%=commentDataJsonArray.getString(0) %>"/>
					<portlet:param name="editable" value="<%= String.valueOf(false)%>" />
					<portlet:param name="redirect" value="<%= redirect %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="STT"
					value="<%=String.valueOf(index+1) %>"
					href="<%=rowURL %>" 
				/>
				
				<liferay-ui:search-container-column-text name="search-by-title" href="<%= rowURL %>" value="<%= HtmlUtil.escape(commentDataJsonArray.getString(10))%>" />
				<%
					Distribution dist = DistributionLocalServiceUtil.fetchOneByContentId(scopeGroupId, GetterUtil.getLong(commentDataJsonArray.getString(2)));
				%>
				<c:if test="<%= !showForAuthor %>">
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="category-title" value="<%= HtmlUtil.escape(commentDataJsonArray.getString(22)) %>" />
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="discustion">
						<liferay-portlet:renderURL portletName="Comment_WAR_viettelcmsportlet" var="openCommentPortletURL" plid="<%=themeDisplay.getPlid()%>"  varImpl="openCommentPortletURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
							<liferay-portlet:param name="distributionId" value="<%= commentDataJsonArray.getString(1)%>"/>
						</liferay-portlet:renderURL>
						<a href='<%= VCMSPubliserUtil.getViewCommentURL(request, portletPreferences, themeDisplay, GetterUtil.getLong(commentDataJsonArray.getString(1)), "linkToPage1000")%>'><i class="glyphicon icon-comment"></i> <span style="font-size:12px;"><%= HtmlUtil.escape(commentDataJsonArray.getString(21)) %></span></a>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="deploy-title" value="<%= HtmlUtil.escape(commentDataJsonArray.getString(20))%>" cssClass="align-center" />				
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="date-send" value="<%= HtmlUtil.escape(commentDataJsonArray.getString(8))%>" cssClass="align-center" />
				</c:if>
				<c:if test="<%= showForAuthor %>">
					
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="deploy-title" value="<%= HtmlUtil.escape(commentDataJsonArray.getString(20))%>" cssClass="align-center" />				
					<liferay-ui:search-container-column-text href="<%=rowURL %>" name="date-send" value="<%= HtmlUtil.escape(commentDataJsonArray.getString(8))%>" cssClass="align-center" />
				</c:if>

				<c:if test="<%= !showForAuthor %>">
					<liferay-ui:search-container-column-text
					name="option" cssClass="align-center double-icon">
					<portlet:renderURL var="editURL">
						<portlet:param name="autoId" value="<%= commentDataJsonArray.getString(0) %>"/>
						<portlet:param name="distributionId" value="<%= commentDataJsonArray.getString(1) %>"/>
						<portlet:param name="contentId" value="<%= commentDataJsonArray.getString(2) %>"/>
						<portlet:param name="mvcPath" value='<%= templatePath + "edit_publish_content.jsp" %>' />
						<portlet:param name="redirect" value="<%= currentURL %>"/>
					</portlet:renderURL>
					<portlet:actionURL var="unPublishContentURL" name="unPublishContent">
						<portlet:param name="autoId" value="<%=commentDataJsonArray.getString(0)%>" />
						<portlet:param name="contentId" value="<%=commentDataJsonArray.getString(2)%>" />
						<portlet:param name="cmd" value="UNDEPLOY" />
						<portlet:param name="version" value="<%=commentDataJsonArray.getString(9)%>" />
						<portlet:param name="status" value="<%=commentDataJsonArray.getString(12)%>" />
						<portlet:param name="redirect" value="<%=currentURL%>" />
					</portlet:actionURL>
					<portlet:actionURL var="deleteActionURL" name="removeContent">
						<portlet:param name="autoId" value="<%= commentDataJsonArray.getString(0) %>"/>
						<portlet:param name="cmd" value="<%= Constants.DELETE %>" />
						<portlet:param name="version" value="<%=commentDataJsonArray.getString(9)%>" />
						<portlet:param name="contentId" value="<%= commentDataJsonArray.getString(2) %>"/>
						<portlet:param name="redirect" value="<%= redirect %>"/>
					</portlet:actionURL>
					<portlet:renderURL var="compareURL">
						<portlet:param name="mvcPath" value='<%=templatePath + "compare_content.jsp"%>' />
						<portlet:param name="contentId" value="<%=commentDataJsonArray.getString(2)%>" />
						<portlet:param name="version" value="4"/>
						<portlet:param name="statusBt" value="8192"/>
						<portlet:param name="redirectURL" value="<%=currentURL%>" />
						<portlet:param name="version" value="4"/>
						<portlet:param name="statusBt" value="8192"/>
					</portlet:renderURL>
					
					<a href="<%= compareURL.toString() %>" title="So sánh"><i class="glyphicon icon-random"></i></a>
					<a href="<%= unPublishContentURL.toString() %>" title="Gỡ bài" onclick="return confirm('Bạn muốn gỡ bài viết này?');"><i class="glyphicon icon-circle-arrow-left"></i></a>
					<a href="<%= editURL.toString() %>" title="Sửa bài"><i class="glyphicon icon-edit"></i></a>
					<a href="<%= deleteActionURL.toString() %>" title="Xoá bài" onclick="return confirm('Bạn muốn xoá bài viết này?');"><i class="glyphicon icon-trash"></i></a>
				</liferay-ui:search-container-column-text>
				</c:if>
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