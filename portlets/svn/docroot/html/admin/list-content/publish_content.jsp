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
	long autoId = ParamUtil.getLong(request, "autoId", 0L);
	Content content = ContentLocalServiceUtil.fetchByAutoId(autoId, scopeGroupId);
	List<Category> categories = new ArrayList<Category>();
	try{
		categories = CategoryLocalServiceUtil.getAllCategories(scopeGroupId);
	}catch(Exception e){}
%>
<c:if test='<%=content != null%>'>
	<%
		String author = PortalUtil.getUserName(
					content.getCreatedByUserId(), "");
			String editor = PortalUtil.getUserName(
					content.getEditedByUserId(), "");
			String approver = PortalUtil.getUserName(
					content.getReviewedByUserId(), "");
			String deployer = PortalUtil.getUserName(
					content.getPublishedByUserId(), "");
			int version = content.getVersion();
			int status = content.getStatus();
			Date defaultPublishDate = new Date();
	%>
	<aui:fieldset>
		<aui:column columnWidth="30">
			<liferay-ui:panel-container id="panel-container-1" extended="true"
				accordion="true">
				<liferay-ui:panel id="panel-c1" title="Đăng vào chuyên mục"
					collapsible="false" extended="true">
					<% for (Category cate : categories){
						boolean selected = false;
						if(cate.getCategoryId()==content.getCategoryId())
							selected = true;
					%>
					<aui:input name="cblCategory" type="checkbox" value="<%= cate.getCategoryId() %>" checked="<%= selected %>" label="<%= cate.getCategoryName() %>" />
					<%} %>
				</liferay-ui:panel>
				<liferay-ui:panel id="panel-c1" title="Thời gian triển khai"
					collapsible="false" extended="true">
						<input name="publishDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="<%=defaultPublishDate%>">
						<input name="publishTime" class="form-control time" type="text" placeholder="hh:mm" value="12:00 AM">
						
						<div>
								<portlet:actionURL var="sendURL" name="sendToNextStep">
									<portlet:param name="autoId"
										value="<%=String.valueOf(content
											.getAutoId())%>" />
									<portlet:param name="cmd" value="send" />
									<portlet:param name="version"
										value="<%=String.valueOf(version)%>" />
									<portlet:param name="status"
										value="<%=String.valueOf(status)%>" />
									<portlet:param name="redirect" value="<%=redirect%>" />
								</portlet:actionURL>
								<a class="btn btn-default" href="<%=sendURL.toString()%>"
									role="button"><i class="glyphicon icon-globe"></i> <liferay-ui:message
										key="publish-content" /></a>
								
								<a class="btn btn-primary" href="<%=redirect%>"
									role="button"><i class="glyphicon icon-circle-arrow-right"></i> <liferay-ui:message
										key="continue-edit-content" /></a>
							</div>
					</liferay-ui:panel>
			</liferay-ui:panel-container>
		</aui:column>
		<aui:column columnWidth="70">
			<liferay-ui:panel-container id="panel-container-2" extended="true"
				accordion="true">
				<liferay-ui:panel id="panel-c1" title="Nội dung bài viết"
					collapsible="false" extended="true">
					<div class="main-content">
						<div class="content-wrapper">
							<div class="header-title">
								<h1><%=content.getTitle()%></h1>
							</div>
							<div class="content">
								<p><%=content.getContent()%></p>
							</div>
							<div class="alert alert-info">
								<c:if test='<%=version >= 1%>'>
									<label class="label-control"><liferay-ui:message
											key="creator-by-user" /> :</label>
									<strong><%=author%></strong>
								</c:if>
								<c:if test='<%=version >= 2 && status > 8%>'>
									<label class="label-control"><liferay-ui:message
											key="editor-by-user" /> :</label>
									<strong><%=editor%></strong>
								</c:if>
								<c:if test='<%=version >= 3 && status > 256%>'>
									<label class="label-control"><liferay-ui:message
											key="reviewer-by-user" /> :</label>
									<strong><%=approver%></strong>
								</c:if>
								<c:if test='<%=version == 4 && status > 2048%>'>
									<label class="label-control"><liferay-ui:message
											key="deployer-by-user" /> :</label>
									<strong><%=deployer%></strong>
								</c:if>
							</div>							
						</div>
					</div>
				</liferay-ui:panel>
			</liferay-ui:panel-container>
		</aui:column>
	</aui:fieldset>
	<aui:script>
    AUI().use('aui-datepicker','aui-timepicker',
        function(A) {
            new A.DatePicker({
                trigger: '.date',
                mask: '%d/%m/%Y',
                popover: {
                    zIndex: 1000
                }
            });
            new A.TimePicker(
         	      {
         	        trigger: '.time'
         	      }
         	    );
        }
    );
</aui:script>
</c:if>