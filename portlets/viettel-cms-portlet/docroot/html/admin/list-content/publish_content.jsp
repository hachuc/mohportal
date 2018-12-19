<%@page import="java.util.Arrays"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.viettel.portal.vcms.service.ContentTypeLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.ContentType"%>
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
	System.out.println("publish_content");
	long autoId = ParamUtil.getLong(request, "autoId", 0L);
	Content content = ContentLocalServiceUtil.fetchByAutoId(autoId, scopeGroupId);
	List<Category> categories = new ArrayList<Category>();
	try {
		categories = CategoryLocalServiceUtil.getAllCategories(scopeGroupId);
	} catch (Exception e) {
	}
	String[] categoryIds = new String[]{String.valueOf(content.getCategoryId())};
	String redirectURL = ParamUtil.getString(request, "redirectURL");
	String backURL = ParamUtil.getString(request, "backURL");
	List<ContentType> lstContentTypes = ContentTypeLocalServiceUtil.getAllContentType(scopeGroupId);
%>
<c:if test='<%=content != null%>'>
	<%
		String author = PortalUtil.getUserName(content.getCreatedByUserId(), "");
			String editor = PortalUtil.getUserName(content.getEditedByUserId(), "");
			String approver = PortalUtil.getUserName(content.getReviewedByUserId(), "");
			String deployer = PortalUtil.getUserName(content.getPublishedByUserId(), "");
			int version = content.getVersion();
			int status = content.getStatus();
			//Date defaultPublishDate = new Date()
			TimeZone timezone = TimeZone.getTimeZone("Asia/Saigon");
			Calendar calendar = Calendar.getInstance(timezone);
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat dateTimeformatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			DateFormat timeFormater = new SimpleDateFormat("HH:mm:ss");
			
			formatter.setCalendar(calendar);
			formatter.setTimeZone(timezone);
			dateTimeformatter.setCalendar(calendar);
			dateTimeformatter.setTimeZone(timezone);
			System.out.println("current date with time zone ==>" + calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR));
			timeFormater.setCalendar(calendar);
			timeFormater.setTimeZone(timezone);
	%>
	<aui:fieldset>
	<liferay-ui:panel  title="Chọn triển khai">
		<aui:column columnWidth="30">
		<portlet:actionURL var="publishContentURL" name="publishContent">
			<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
			<portlet:param name="contentId" value="<%=String.valueOf(content.getContentId())%>" />
			<portlet:param name="redirect" value="<%=backURL%>" />
		</portlet:actionURL>
		<aui:form name="fm" method="post" action="<%= publishContentURL %>" cssClass="form-horizontal">
			<liferay-ui:panel-container id="panel-container-1" extended="true"
				accordion="true">
				<liferay-ui:panel id="panel-c1" title="Đăng vào chuyên mục"
					collapsible="false" extended="true" cssClass="pnl-categories">
					<select name="<portlet:namespace />categoryIds" class="chosen-select" data-placeholder="Chọn chuyên mục..." multiple>
						<%
							if (categories != null) {
								for (Category cat : categories) {
									String isSelected = Arrays.asList(categoryIds).contains(String.valueOf(cat.getCategoryId()))? " selected":"";
						%>
						<option value="<%=cat.getCategoryId()%>" <%= isSelected %>><%=HtmlUtil.escape(cat.getCategoryName())%></option>
						<%
								}
							}
						%>
					</select>
				</liferay-ui:panel>
				<liferay-ui:panel id="panel-c1" title="Thời gian triển khai" collapsible="false" extended="true">

					<aui:input type="hidden" name="publishDateTime" value="<%= dateTimeformatter.format(calendar.getTime()) %>" />
					<div class="form-inline">
						<div class="view-by-date row">
							<label class="col-md-3 p0"><liferay-ui:message key="publish-at" /></label>
							<div class="col-md-9 p0">
								<select name="<portlet:namespace />vdate">
									<% for(int i = 1; i<= 31; i++) {
										String isSelected = i==calendar.get(calendar.DATE) ? " selected" : "";
									%>
									<option value="<%= i%>" <%= isSelected %>><%= String.valueOf(i)%></option>
									<% } %>
								</select>
								/
								<select name="<portlet:namespace />vmonth">
									<% for(int i = 1; i<= 12; i++) {
										String isSelected = i==calendar.get(calendar.MONTH) + 1 ? " selected" : "";
									%>
									<option value="<%= i%>" <%= isSelected %>><%= String.valueOf(i)%></option>
									<% } %>
								</select> 
								/
								<select name="<portlet:namespace />vyear">
									<% for(int i = 2009; i<= calendar.get(Calendar.YEAR); i++) {
										String isSelected = i==calendar.get(calendar.YEAR) ? " selected" : "";
									%>
									<option value="<%= i%>" <%= isSelected %>><%= String.valueOf(i)%></option>
									<% } %>
								</select>
							</div>
						</div>
						<div class="view-by-date row">
							<label class="col-md-3 p0">&nbsp;</label>
							<div class="col-md-9 p0">
							<select name="<portlet:namespace />vhouses">
								<% for(int i = 0; i< 24; i++) {
									String isSelected = i==calendar.get(calendar.HOUR_OF_DAY) ? " selected" : "";
								%>
								<option value="<%= i%>" <%= isSelected %>><%= String.valueOf(i)%></option>
								<% } %>
							</select>
							/
							<select name="<portlet:namespace />vminutes">
								<% for(int i = 0; i< 60; i++) {
									String isSelected = i==calendar.get(calendar.MINUTE) ? " selected" : "";
								%>
								<option value="<%= i%>" <%= isSelected %>><%= String.valueOf(i)%></option>
								<% } %>
							</select> 
							/
							<select name="<portlet:namespace />vseconds">
								<% for(int i = 0; i< 60; i++) {
									String isSelected = i==calendar.get(calendar.SECOND) ? " selected" : "";
									
								%>
								<option value="<%= i%>" <%= isSelected %>><%= String.valueOf(i)%></option>
								<% } %>
							</select>
							</div>
						</div>
						<div class="view-by-date row">
							<label class="col-md-3 p0"><liferay-ui:message key="content-type" /></label>
							<div class="col-md-9 p0">
								<select name="<portlet:namespace />newsType">
									<aui:option value="0" label="choose-one" selected="true" />
									<%
										if(lstContentTypes != null){
													for(ContentType cat: lstContentTypes){
													String isSelected = cat.getContenTypeId() == (long)content.getNewsType() ? " selected" : "";
									%>
									<option value="<%=cat.getContenTypeId()%>" isSelected><%=HtmlUtil.escape(cat.getName())%></option>
									<%
										}
										}
									%>
								</select>
								</div>
						</div>
						<div class="view-by-date row">
							<label class="col-md-3 p0">&nbsp;</label>
							<div class="col-md-9 p0">
								<aui:input type="checkbox" name="allowDiscustion" label="allow-discussion" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<aui:button type="submit" value='publish-content'>
								</aui:button>
								<a class="btn btn-primary" href="<%=backURL%>" role="button"><i
									class="glyphicon icon-circle-arrow-right"></i> <liferay-ui:message
										key="continue-edit-content" /></a>
							</div>
						</div>
					</div>
				</liferay-ui:panel>
			</liferay-ui:panel-container>
			<aui:input type="hidden" name="version" value='<%= content.getVersion() %>' />
					</aui:form>
		</aui:column>
		<aui:column columnWidth="70">
			<liferay-ui:panel-container id="panel-container-2" extended="true"
				accordion="true">
				<liferay-ui:panel id="panel-c1" title="Nội dung bài viết"
					collapsible="false" extended="true">
					<div class="main-content">
						<div class="content-wrapper">
							<div>
								<h4 style="color: red; font-size: 14px;"><%=HtmlUtil.escape(content.getSubTitle()) %></h4>
							</div>
							<div class="header-title">
								<h1 style="color: #0066CC; font-size: 18px;"><%=HtmlUtil.escape(content.getTitle())%></h1>
							</div>
							<div><p><%=dateTimeFormat.format(content.getCreateDate())%></p></div>
							<c:if test="<%=content.getCopyRight().length()>0 %>">
								<strong style="font-style: italic;">(<%=HtmlUtil.escape(content.getCopyRight())%>)</strong>
							</c:if>
							<div class="content">
								<strong><%=content.getSubContent() %></strong>
							</div>
							<div class="content">
								<p><%=content.getContent()%></p>
							</div>
							<div class="alert alert-info">
								<c:if test='<%=version >= 1%>'>
									<label class="label-control"><liferay-ui:message
											key="creator-by-user" /> :</label>
									<strong><%=HtmlUtil.escape(author)%></strong>
								</c:if>
								<c:if test='<%=version >= 2 && status > 8%>'>
									<label class="label-control"><liferay-ui:message
											key="editor-by-user" /> :</label>
									<strong><%=HtmlUtil.escape(editor)%></strong>
								</c:if>
								<c:if test='<%=version >= 3 && status > 256%>'>
									<label class="label-control"><liferay-ui:message
											key="reviewer-by-user" /> :</label>
									<strong><%=HtmlUtil.escape(approver)%></strong>
								</c:if>
								<c:if test='<%=version == 4 && status > 2048%>'>
									<label class="label-control"><liferay-ui:message
											key="deployer-by-user" /> :</label>
									<strong><%=HtmlUtil.escape(deployer)%></strong>
								</c:if>
							</div>
						</div>
					</div>
				</liferay-ui:panel>
			</liferay-ui:panel-container>
		</aui:column>
		</liferay-ui:panel>
	</aui:fieldset>
	<script>
	$(function() {
	    $('.chosen-select').chosen({width: "100%"});
	  });
	</script>
	

</c:if>
