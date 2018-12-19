<%@page import="java.util.Arrays"%>
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
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
	long contentId = ParamUtil.getLong(request, "contentId", 0L);
	int version = ParamUtil.getInteger(request, "version");
	int versionLeft = ParamUtil.getInteger(request, "versionLeft", 4);
	int versionRight = ParamUtil.getInteger(request, "versionRight", 4);
	int indexL = 0, indexR = 0;
	List<Content> contents = ContentLocalServiceUtil
			.findByGroupContent(scopeGroupId, contentId);
	Content contentLeft = null, contentRight = null;
	for(Content sub : contents){
		if(sub.getVersion() == versionLeft)
			contentLeft = sub;
		if(sub.getVersion() == versionRight)
			contentRight = sub;
	}
%>
<liferay-ui:panel-container cssClass="basic-info"
	id="basic-info-container" extended="true">
	<liferay-ui:panel collapsible="<%=false%>" extended="<%=true%>"
		id="basic-info" persistState="<%=true%>" title='so-sanh-bai-viet'
		iconCssClass="glyphicon icon-random">
		<aui:fieldset>
		<aui:form action="<%=PortalUtil.getCurrentURL(request)%>" method="post" name="fm">
			<aui:input type="hidden" name="diffs" value="true" />
			<aui:column columnWidth="50">
				<div class="list_header">
						<aui:select name="versionLeft" label="Phiên bản so sánh"  inlineLabel="true" onChange='<%= renderResponse.getNamespace() + "versionChanged();" %>' style="width: 100%; margin-bottom: 0;">
							<aui:option  value='1' selected="<%=versionLeft == 1 %>"><liferay-ui:message key="version-creator" /></aui:option>
							<aui:option  value='2' selected="<%=versionLeft == 2 %>"><liferay-ui:message key="version-editor" /></aui:option>
							<aui:option  value='3' selected="<%=versionLeft == 3 %>"><liferay-ui:message key="version-reviewer" /></aui:option>
							<aui:option  value='4' selected="<%=versionLeft == 4 %>"><liferay-ui:message key="version-deployer" /></aui:option>
						</aui:select>
				</div>
				<c:if test='<%=contentLeft != null%>'>
					<%
						String authorLeft = PortalUtil.getUserName(contentLeft.getCreatedByUserId(), "");
						String editorLeft = PortalUtil.getUserName(contentLeft.getEditedByUserId(), "");
						String approverLeft = PortalUtil.getUserName(contentLeft.getReviewedByUserId(), "");
						String deployerLeft = PortalUtil.getUserName(contentLeft.getPublishedByUserId(), "");
					%>
					<div class="main-content">
						<div class="content-wrapper">
							<div class="story" id="title1">
								<span style="font-size: 16px;"><%=contentLeft.getTitle()%></span>
							</div>
							<div class="storytime">
								<span><%=dateTimeFormat.format(contentLeft.getCreateDate())%></span>
							</div>
							<div class="text" id="content1">
								<%= contentLeft.getContent() %>
							</div>
							<div class="author-info">
								<div class="notice">
									<c:if test='<%=version >= 1%>'>
										<span><liferay-ui:message key="creator-by-user" /> :</span>
										<strong><%=authorLeft%></strong>
									</c:if>
									<c:if test='<%=version >= 2%>'>
										<span><liferay-ui:message key="editor-by-user" /> : <%=editorLeft%></span>
									</c:if>
									<c:if test='<%=version >= 3%>'>
										<span><liferay-ui:message key="reviewer-by-user" /> :
											<%=approverLeft%></span>
									</c:if>
									<c:if test='<%=version == 4%>'>
										<span><liferay-ui:message key="deployer-by-user" /> :
											<%=deployerLeft%></span>
									</c:if>
								</div>
							</div>							
						</div>
					</div>
				</c:if>
			</aui:column>
			<aui:column columnWidth="50">
				<div class="list_header">
						<aui:select name="versionRight" label="Phiên bản so sánh" inlineField="true" inlineLabel="true" onChange='<%= renderResponse.getNamespace() + "versionChanged();" %>' style="width: 100%; margin-bottom: 0;">
							<aui:option  value='1' selected="<%=versionLeft == 1 %>"><liferay-ui:message key="version-creator" /></aui:option>
							<aui:option  value='2' selected="<%=versionLeft == 2 %>"><liferay-ui:message key="version-editor" /></aui:option>
							<aui:option  value='3' selected="<%=versionLeft == 3 %>"><liferay-ui:message key="version-reviewer" /></aui:option>
							<aui:option  value='4' selected="<%=versionLeft == 4 %>"><liferay-ui:message key="version-deployer" /></aui:option>
						</aui:select>
				</div>
				<c:if test='<%=contentRight != null%>'>
					<%
						String authorRight = PortalUtil.getUserName(contentRight.getCreatedByUserId(), "");
						String editorRight = PortalUtil.getUserName(contentRight.getEditedByUserId(), "");
						String approverRight = PortalUtil.getUserName(contentRight.getReviewedByUserId(), "");
						String deployerRight = PortalUtil.getUserName(contentRight.getPublishedByUserId(), "");
					%>
					<div class="main-content">
						<div class="content-wrapper">
							<div class="story" id="title2">
								<span style="font-size: 16px;"><%=contentLeft.getTitle()%></span>
							</div>
							<div class="storytime">
								<span><%=dateTimeFormat.format(contentLeft.getCreateDate())%></span>
							</div>
							<div class="text" id="content2">
								<%= contentRight.getContent() %>
							</div>
							<div class="author-info">
								<div class="notice">
									<c:if test='<%=version >= 1%>'>
										<span><liferay-ui:message key="creator-by-user" /> : <%=authorRight%></span>
									</c:if>
									<c:if test='<%=version >= 2%>'>
										<span><liferay-ui:message key="editor-by-user" /> : <%=editorRight%></span>
									</c:if>
									<c:if test='<%=version >= 3%>'>
										<span><liferay-ui:message key="reviewer-by-user" /> : <%=approverRight%></span>
									</c:if>
									<c:if test='<%=version == 4%>'>
										<span><liferay-ui:message key="deployer-by-user" /> : <%=deployerRight%></span>
									</c:if>
								</div>
							</div>							
						</div>
					</div>
				</c:if>
			</aui:column>
		</aui:form>
		</aui:fieldset>
	</liferay-ui:panel>
</liferay-ui:panel-container>
<aui:script>
document.getElementById('title1').innerHTML = '<%=HtmlUtil.escapeJS(contentLeft.getTitle()) %>';
var diffTitle = <portlet:namespace />diff('<%=HtmlUtil.escapeJS(contentLeft.getTitle()) %>', '<%=HtmlUtil.escapeJS(contentRight.getTitle()) %>');
document.getElementById('title2').innerHTML = diffTitle;

document.getElementById('content1').innerHTML = '<%=HtmlUtil.escapeJS(contentLeft.getContent()) %>';
var diffDescription = <portlet:namespace />diff('<%=HtmlUtil.escapeJS(contentLeft.getContent()) %>', '<%=HtmlUtil.escapeJS(contentRight.getContent()) %>');
document.getElementById('content2').innerHTML = diffDescription;

function <portlet:namespace />versionChanged(){
	submitForm(document.<portlet:namespace />fm);
}

function <portlet:namespace />diff(text1, text2) {
	var dmp = new diff_match_patch();
	dmp.Diff_Timeout = parseFloat('3');
	var d = dmp.diff_main(text1, text2);
	dmp.diff_cleanupSemantic(d);
	var ds = dmp.diff_prettyHtml(d);
	return ds;
}

function <portlet:namespace />initArticleContent1() {
	return '<%=UnicodeFormatter.toString(contentLeft.getContent()) %>';
}

function <portlet:namespace />initArticleContent2() {
	var text1 = <portlet:namespace />initArticleContent1();
	var text2 = '<%=UnicodeFormatter.toString(contentRight.getContent()) %>';
	return <portlet:namespace />diff(text1, text2);
}
</aui:script>
