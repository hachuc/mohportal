<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.service.DistributionLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
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
<%@include file="/html/admin/list-content/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
	long autoId = ParamUtil.getLong(request, "autoId", 0L);
	long distributionId = ParamUtil.getLong(request, "distributionId", 0L);
	Content content = ContentLocalServiceUtil.fetchByAutoId(autoId, scopeGroupId);
%>
<c:if test='<%= content!=null %>'>
<%
	String author = PortalUtil.getUserName(content.getCreatedByUserId(), "");
	String editor = PortalUtil.getUserName(content.getEditedByUserId(), "");
	String approver = PortalUtil.getUserName(content.getReviewedByUserId(), "");
	String deployer = PortalUtil.getUserName(content.getPublishedByUserId(), "");
	int version = content.getVersion();
	int status = content.getStatus();
	Distribution dist = DistributionLocalServiceUtil.getDistribution(distributionId);
%>
<liferay-ui:panel-container cssClass="basic-info" id="basic-info-container" extended="true"> 
	<liferay-ui:panel collapsible="<%=false%>" extended="<%=true%>" id="basic-info" persistState="<%=true%>" title='xem-bai-viet' iconCssClass="view">
		<div class="main-content">
			<div class="content-wrapper">
				<c:if test="<%=Validator.isNotNull(content.getSubTitle())%>">
					<span style="color:Blue;font-size:12px;font-weight:bold;"><%=HtmlUtil.escape(content.getSubTitle())%></span>
				</c:if>
				<div class="story">
					<span style="font-size:16px;"><%= HtmlUtil.escape(content.getTitle()) %></span>
				</div>
				<%
				
				%>
				<div class="storytime">
				    <span><%= dateTimeFormat.format(dist != null? dist.getDistributedDate() : content.getCreateDate())%></span>
				</div>				
				<div class="text"> 
					<c:choose>
						<c:when test='<%= content.getImagePosition() == 1 && Validator.isNotNull(content.getImageUrl()) %>'>
							<div class="avatartop">
								<img class="avatar" src="<%= content.getImageUrl()%>">
							</div>
							<div class="avatartopdesc"><span><%= HtmlUtil.escape(content.getImageCaption())%></span></div>
							<span class="text" style="font-weight:bold;font-style:italic;">
								<%= (content.getCopyRight().length()>0)?"("+HtmlUtil.escape(content.getCopyRight())+")":""%>
							</span>
							<span class="text" style="font-weight:bold;">
								<%= HtmlUtil.escape(content.getSubContent())%>
							</span>
						</c:when>
						<c:when test='<%= content.getImagePosition() == 2 && Validator.isNotNull(content.getImageUrl()) %>'>
							<table cellspacing="3" cellpadding="3" width="1" align="left" border="0">
								<tbody>
									<tr>
										<td><img class="avatar" src="<%= content.getImageUrl()%>"></td>
									</tr>
									<tr>
										<td class="avatardesc"><%= HtmlUtil.escape(content.getImageCaption())%></td>
									</tr>
								</tbody>
							</table>
							<span class="text" style="font-weight:bold;font-style:italic;">
								<%= (content.getCopyRight().length()>0)?"("+HtmlUtil.escape(content.getCopyRight())+")":""%>
							</span>
							<span class="text" style="font-weight:bold;">
								<%= content.getSubContent()%>
							</span>
						</c:when>
						<c:when test='<%= content.getImagePosition() == 0 && Validator.isNotNull(content.getImageUrl()) %>'>
							<table cellspacing="3" cellpadding="3" width="1" align="right" border="0">
								<tbody>
									<tr>
										<td><img class="avatar" src="<%= "http://125.212.226.47:8087" + content.getImageUrl()%>"></td>
									</tr>
									<tr>
										<td class="avatardesc"><%= HtmlUtil.escape(content.getImageCaption()) %></td>
									</tr>
								</tbody>
							</table>
							<span class="text" style="font-weight:bold;font-style:italic;">
								<%= (content.getCopyRight().length()>0)?"("+HtmlUtil.escape(content.getCopyRight())+")":""%>
							</span>
							<span class="text" style="font-weight:bold;">
								<%= content.getSubContent()%>
							</span>
						</c:when>
						<c:when test='<%= content.getImagePosition() == 4 && Validator.isNotNull(content.getImageUrl()) %>'>
							<table cellspacing="3" cellpadding="3" width="1" align="right" border="0">
								<tbody>
									<tr>
										<td><img class="avatar" src="<%= content.getImageUrl()%>"></td>
									</tr>
									<tr>
										<td class="avatardesc"><%= HtmlUtil.escape(content.getImageCaption())%></td>
									</tr>
								</tbody>
							</table>
							<span class="text" style="font-weight:bold;font-style:italic;">
								<%= (content.getCopyRight().length()>0)?"("+HtmlUtil.escape(content.getCopyRight())+")":""%>
							</span>
							<span class="text" style="font-weight:bold;">
								<%= content.getSubContent()%>
							</span>
						</c:when>
						<c:when test='<%= content.getImagePosition() == 5 && Validator.isNotNull(content.getImageUrl()) %>'>
							<span class="text" style="font-weight:bold;font-style:italic;">
							 	<%= (content.getCopyRight().length()>0)?"("+HtmlUtil.escape(content.getCopyRight())+")":""%>
							</span>
							<div class="avatarbottom">
								<img class="avatar" src="<%= content.getImageUrl()%>">
							</div>
							<div class="avatartopdesc"><span><%= content.getImageCaption()%></span></div>
						</c:when>
						<c:otherwise>
							<span class="text" style="font-weight:bold;font-style:italic;">
								<%= (content.getCopyRight().length()>0)?"("+HtmlUtil.escape(content.getCopyRight())+")":""%>
							</span>
							<span class="text" style="font-weight:bold;">
								<%= content.getSubContent()%>
							</span>
						</c:otherwise>
					</c:choose>
					<p><%= content.getContent() %></p>
					<c:if test='<%= Validator.isNotNull(content.getAuthor()) %>'>
						<p align="right"><%= HtmlUtil.escape(content.getAuthor()) %></p>
					</c:if>
				</div>
				<div class="author-info">
					<div class="notice">
						<c:if test='<%= version >= 1 %>'>
							<span><liferay-ui:message key="creator-by-user" /> :</span> <strong><%= author%></strong>
						</c:if>
						<c:if test='<%= version >= 2 && status > 8 %>'>
							<span><liferay-ui:message key="editor-by-user" /> : <%= editor%></span>
						</c:if>
						<c:if test='<%= version >= 3 && status > 256%>'>
							<span><liferay-ui:message key="reviewer-by-user" /> : <%= approver%></span>
						</c:if>
						<c:if test='<%= version == 4 && status > 2048%>'>
							<span><liferay-ui:message key="deployer-by-user" /> : <%= deployer%></span>
						</c:if>
						
					</div>
				</div>
			</div>
		</div>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
</c:if>