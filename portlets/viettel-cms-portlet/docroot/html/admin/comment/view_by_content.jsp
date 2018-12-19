<%@page import="com.viettel.portal.vcms.util.CmsConstants"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.service.DistributionLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Comment"%>
<%@page import="com.viettel.portal.vcms.service.CommentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@page import="com.viettel.portal.vcms.permission.CategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.viettel.portal.vcms.model.Category"%>
<%@ page import="com.viettel.portal.vcms.service.CategoryLocalServiceUtil"%>
<%@include file="/html/admin/comment/init.jsp"%>
<%
	long distId = (Long) request.getAttribute("view.contentId");
	Distribution dist = DistributionLocalServiceUtil.getDistribution(distId);
	Content content = null;
	if(dist!=null)
		content = ContentLocalServiceUtil.fecthLastestContent(scopeGroupId, dist.getContentId(), CmsConstants.PUBLISHED_NEWS, CmsConstants.FINAL_STATUS);
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='/html/admin/comment/view.jsp' />
</liferay-portlet:renderURL>
<div  class="form-search ">
	<aui:form action="<%=searchURL%>" method="get" name="fm"
		class="form-horizontal listcontent-form" role="form">
		<liferay-portlet:renderURLParams varImpl="searchURL" />
		<liferay-ui:panel-container cssClass="basic-info"
			id="basic-info-container" extended="true">
			<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
				id="basic-info" persistState="<%=true%>" title='user-comment-posts'>
				<aui:field-wrapper label="">
					<aui:fieldset>
						<div class="form-group clearfix">
						<c:if test='<%= content!=null %>'>
							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value='/html/admin/comment/view_content.jsp' />
								<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId()) %>" />
								<portlet:param name="distributionId" value="<%=String.valueOf(distId) %>" />
								<portlet:param name="redirect" value="<%= redirect %>" />
							</portlet:renderURL>
								<h3><a href="<%= rowURL%>"><%= HtmlUtil.escape(content.getTitle()) %></a></h3>
							</div>
						</c:if>
					</aui:fieldset>
				</aui:field-wrapper>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		
		<aui:fieldset>
		<liferay-ui:search-container delta="20" emptyResultsMessage="no-result-were-found" iteratorURL="<%= searchURL %>">
		<%
		List<Comment> lstComment = CommentLocalServiceUtil.getByContentId(scopeGroupId, distId, searchContainer.getStart(), searchContainer.getEnd());
		int totalA = CommentLocalServiceUtil.countByContentId(scopeGroupId, distId);
		%>
			<liferay-ui:search-container-results
				results="<%= lstComment%>"
				total="<%=totalA %>"
			/>
			

			<liferay-ui:search-container-row className="com.viettel.portal.vcms.model.Comment" modelVar="comment">
				
				<liferay-ui:search-container-column-text
					name="STT"
					value="<%=String.valueOf(index+1) %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="header-fullname">
					<a href="#"><%= HtmlUtil.escape(comment.getFullName()) %></a>
					<p><%= HtmlUtil.escape(comment.getBody()) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="cmt-email"
					value="<%= HtmlUtil.escape(comment.getEmail())%>"
				>

				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="send-date"
					value="<%= dateFormat.format(comment.getCreateDate())%>"
				>

				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="option" cssClass="align-center double-icon"
				>
					<portlet:actionURL var="goOnlineURL" name="onlineComment">
						<portlet:param name="commentId" value="<%= String.valueOf(comment.getCommentId()) %>"/>
						<portlet:param name="visible" value="<%= String.valueOf(comment.getVisible()) %>"/>
						<portlet:param name="redirect" value="<%= redirect %>"/>
					</portlet:actionURL>
					<portlet:renderURL var="editCommentURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/comment/edit_comment.jsp" />
						<portlet:param name="commentId" value="<%= String.valueOf(comment.getCommentId()) %>" />
						<portlet:param name="redirectURL" value="<%= PortalUtil.getCurrentURL(request)%>" />
					</portlet:renderURL>
					<portlet:actionURL var="deleteURL" name="deleteComment">
						<portlet:param name="commentId" value="<%= String.valueOf(comment.getCommentId()) %>"/>
						<portlet:param name="cmd" value="<%= Constants.DELETE %>"/>
						<portlet:param name="redirectURL" value="<%= redirect %>"/>
					</portlet:actionURL>
					<c:if test='<%= comment.getVisible() %>'>
						<a href="<%= goOnlineURL.toString() %>" title="Online"><i class="glyphicon icon-eye-open"></i></a>
					</c:if>
					<c:if test='<%= !comment.getVisible() %>'>
						<a href="<%= goOnlineURL.toString() %>" title="Offline"><i class="glyphicon icon-eye-close"></i></a>
					</c:if>
					<a  href="javascript:;" onclick='updateCommentForm("<%= editCommentURL.toString() %>");' title="Sửa"><i class="glyphicon icon-edit"></i></a>
					<a href="<%= deleteURL %>" title="Xóa" onclick="return confirm('Bạn muốn xóa phản hồi này?');"><i class="glyphicon icon-trash"></i></a>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />

		</liferay-ui:search-container>
	</aui:fieldset>
	</aui:form>
</div>
<aui:script use="">
Liferay.provide(
		window,
		'updateCommentForm',
		function(url){
			
			var dialogWidow = {
				dialog: {
					constrain: true,
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: '80%',
					cache: false,
					after: {
						visibleChange: function(event) {
							location.reload();
						}
                    }
				},
				title: '<liferay-ui:message key="edit-comment" />',
				uri: url,
				
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
</aui:script>