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
	String keyword = ParamUtil.getString(request, "searchKeyword");
	int searchOption = ParamUtil.getInteger(request, "optradio", 0);  
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
				id="basic-info" persistState="<%=true%>" title='user-comment'>
				<aui:field-wrapper label="">
					<aui:fieldset>
						<div class="form-group clearfix">
							<label class="col-md-1"><liferay-ui:message key="keyword" /> :</label>
							<div class="col-md-4">
							<input type="text" name="<portlet:namespace />searchKeyword" value="<%= keyword %>" class="form-control" />
							</div>
							<div class="col-md-7">
								<button type="submit" class="btn btn-default"><liferay-ui:message key="search-command" /></button>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-1"><liferay-ui:message key="search-by" /> :</label>
							<div class="col-md-4">
							<label class="radio-inline">
						      <input type="radio" name="<portlet:namespace />optradio" <c:if test='<%= searchOption==0 %>'> checked </c:if> value="0" /><liferay-ui:message key="select-all"/>
						    </label>
						    <label class="radio-inline">
						      <input type="radio" name="<portlet:namespace />optradio" <c:if test='<%= searchOption==1 %>'> checked </c:if> value="1" /><liferay-ui:message key="select-fullname"/>
						    </label>
						    <label class="radio-inline">
						      <input type="radio" name="<portlet:namespace />optradio" <c:if test='<%= searchOption==2 %>'> checked </c:if> value="2" /><liferay-ui:message key="select-email"/>
						    </label>
						    <label class="radio-inline">
						      <input type="radio" name="<portlet:namespace />optradio" <c:if test='<%= searchOption==3 %>'> checked </c:if> value="3" /><liferay-ui:message key="select-body"/>
						    </label>
						    </div>
						    <div class="col-md-7">
						    
						    </div>
						</div>
					</aui:fieldset>
				</aui:field-wrapper>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		
		<aui:fieldset>
		<liferay-ui:search-container delta="20" emptyResultsMessage="no-result-were-found" iteratorURL="<%= searchURL %>">
		<%
		List lstResults = CommentLocalServiceUtil.customSearchByKeyword(companyId, scopeGroupId, keyword, searchOption, searchContainer.getStart(), searchContainer.getEnd()); 
		int totalA = CommentLocalServiceUtil.customCountByKeyword(companyId, scopeGroupId, keyword, searchOption);
		String serilizeString=null;
		JSONArray commentDataJsonArray=null;
		%>
			<liferay-ui:search-container-results
				results="<%= lstResults%>"
				total="<%=totalA %>"
			/>
			

			<liferay-ui:search-container-row className="java.lang.Object" modelVar="comment">
			<%
			serilizeString=JSONFactoryUtil.serialize(comment);
			commentDataJsonArray=JSONFactoryUtil.createJSONArray(serilizeString);
			boolean isvisible = GetterUtil.getBoolean(commentDataJsonArray.getString(8), false);

			%>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='/html/admin/comment/view_content.jsp' />
					<portlet:param name="autoId" value="<%=HtmlUtil.escape(commentDataJsonArray.getString(7)) %>"/>
					<portlet:param name="distributionId" value="<%= HtmlUtil.escape(commentDataJsonArray.getString(1)) %>"/>
					<portlet:param name="redirect" value="<%= redirect %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="STT"
					value="<%=String.valueOf(index+1) %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="header-fullname">
				<a href="#"><%= HtmlUtil.escape(commentDataJsonArray.getString(3)) %></a>
					<p><%= HtmlUtil.escape(commentDataJsonArray.getString(5)) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="cmt-article"
					href="<%= rowURL %>"
					value="<%= HtmlUtil.escape(commentDataJsonArray.getString(2))%>"
				>

				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="cmt-email"
					value="<%= HtmlUtil.escape(commentDataJsonArray.getString(4))%>"
				>

				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="send-date"
					value="<%= commentDataJsonArray.getString(6)%>"
				>

				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="cmt-option" cssClass="align-center double-icon"
				>
					<portlet:actionURL var="goOnlineURL" name="onlineComment">
						<portlet:param name="commentId" value="<%= commentDataJsonArray.getString(0) %>"/>
						<portlet:param name="visible" value="<%= commentDataJsonArray.getString(8) %>"/>
						<portlet:param name="redirect" value="<%= redirect %>"/>
					</portlet:actionURL>
					<portlet:renderURL var="editCommentURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/comment/edit_comment.jsp" />
						<portlet:param name="commentId" value="<%= commentDataJsonArray.getString(0) %>" />
						<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
					</portlet:renderURL>
					<portlet:actionURL var="deleteURL" name="deleteComment">
						<portlet:param name="commentId" value="<%= commentDataJsonArray.getString(0) %>"/>
						<portlet:param name="cmd" value="<%= Constants.DELETE %>"/>
						<portlet:param name="redirectURL" value="<%= redirect %>"/>
					</portlet:actionURL>
					<c:if test='<%= isvisible %>'>
						<a href="<%= goOnlineURL.toString() %>" title="Online"><i class="glyphicon icon-eye-open"></i></a>
					</c:if>
					<c:if test='<%= !isvisible %>'>
						<a href="<%= goOnlineURL.toString() %>" title="Offline"><i class="glyphicon icon-eye-close"></i></a>
					</c:if>
					<a  href="javascript:;" onclick='updateCommentForm("<%=editCommentURL.toString() %>");' title="Sửa"><i class="glyphicon icon-edit"></i></a>
					<a href="<%= deleteURL.toString() %>" title="Xóa" onclick="return confirm('Bạn muốn xóa phản hồi này?');"><i class="glyphicon icon-trash"></i></a>
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