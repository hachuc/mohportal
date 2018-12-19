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
	long autoId = ParamUtil.getLong(request, "autoId", 0L);
	//long contentId = ParamUtil.getLong(request, "contentId", 0L);
	Content content = ContentLocalServiceUtil.fetchByAutoId(autoId, scopeGroupId);
	int[] v1Status = new int[]{1};
	int[] v2Status = new int[]{8,16};
	int[] v3Status = new int[]{256, 512};
	int[] v4Status = new int[]{2048, 4096};
%>
<c:if test='<%= content!=null %>'>
<%
	String author = PortalUtil.getUserName(content.getCreatedByUserId(), "");
	String editor = PortalUtil.getUserName(content.getEditedByUserId(), "");
	String approver = PortalUtil.getUserName(content.getReviewedByUserId(), "");
	String deployer = PortalUtil.getUserName(content.getPublishedByUserId(), "");
	int version = content.getVersion();
	int status = content.getStatus();
%>
<liferay-ui:panel-container cssClass="basic-info" id="basic-info-container" extended="true"> 
	<liferay-ui:panel collapsible="<%=false%>" extended="<%=true%>" id="basic-info" persistState="<%=true%>" title='xem-bai-viet' iconCssClass="glyphicon icon-eye-open">
		<div class="main-content">
			<div class="content-wrapper">
				<c:if test="<%=Validator.isNotNull(content.getSubTitle())%>">
					<span style="color:Blue;font-size:12px;font-weight:bold;"><%=HtmlUtil.escape(content.getSubTitle())%></span>
				</c:if>
				<div class="story">
					<span style="font-size:16px;"><%= content.getTitle() %></span>
				</div>
				<div class="storytime">
				    <span><%= dateTimeFormat.format(content.getCreateDate()) %></span>
				</div>				
				<div class="text"> 
					<c:choose>
						<c:when test='<%= content.getImagePosition() == 1 && Validator.isNotNull(content.getImageUrl()) %>'>
							<div class="avatartop">
								<img class="avatar" src="<%= content.getImageUrl()%>">
							</div>
							<div class="avatartopdesc"><span><%= content.getImageCaption()%></span></div>
							<span class="text" style="font-weight:bold;font-style:italic;">
								
							</span>
							<span class="text" style="font-weight:bold;">
								<%= content.getSubContent()%>
							</span>
						</c:when>
						<c:when test='<%= content.getImagePosition() == 2 && Validator.isNotNull(content.getImageUrl()) %>'>
							<table cellspacing="3" cellpadding="3" width="1" align="left" border="0">
								<tbody>
									<tr>
										<td><img class="avatar" src="<%= content.getImageUrl()%>"></td>
									</tr>
									<tr>
										<td class="avatardesc"><%= content.getImageCaption()%></td>
									</tr>
								</tbody>
							</table>
							<span class="text" style="font-weight:bold;font-style:italic;">
								
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
										<td class="avatardesc"><%= content.getImageCaption()%></td>
									</tr>
								</tbody>
							</table>
							<span class="text" style="font-weight:bold;font-style:italic;">
								
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
										<td class="avatardesc"><%= content.getImageCaption()%></td>
									</tr>
								</tbody>
							</table>
							<span class="text" style="font-weight:bold;font-style:italic;">
								
							</span>
							<span class="text" style="font-weight:bold;">
								<%= content.getSubContent()%>
							</span>
						</c:when>
						<c:when test='<%= content.getImagePosition() == 5 && Validator.isNotNull(content.getImageUrl()) %>'>
							<span class="text" style="font-weight:bold;font-style:italic;">
								
							</span>
							<span class="text" style="font-weight:bold;">
								<%= content.getSubContent()%>
							</span>
							<div class="avatarbottom">
								<img class="avatar" src="<%= content.getImageUrl()%>">
							</div>
							<div class="avatartopdesc"><span><%= content.getImageCaption()%></span></div>
						</c:when>
						<c:otherwise>
							<span class="text" style="font-weight:bold;font-style:italic;">
								
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
				<div class="align-center">
				<c:choose>
					<c:when test='<%= version == 1 && status == 1 %>'>
						<portlet:renderURL var="editURL">
							<portlet:param name="mvcPath" value='<%= templatePath + "edit_content.jsp" %>' />
							<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:renderURL>
						<a class="btn btn-small" href="<%= editURL.toString() %>" role="button"><i class="fa fa-edit"></i> <liferay-ui:message key="edit-content" /></a>
						<portlet:actionURL var="sendURL" name="sendToNextStep">
							<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
							<portlet:param name="cmd" value="send"/>
							<portlet:param name="version" value="<%= String.valueOf(version) %>"/>
							<portlet:param name="status" value="<%= String.valueOf(status) %>"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:actionURL>
						<a class="btn btn-small" href="<%= sendURL.toString() %>" role="button"><i class="fa fa-arrow-circle-o-right"></i> <liferay-ui:message key="send-content" /></a>
					</c:when>
					<c:when test='<%= version == 2 && (status == 8 || status==16) %>'>
						<portlet:renderURL var="editURL">
							<portlet:param name="mvcPath" value='<%= templatePath + "edit_content.jsp" %>' />
							<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
							<portlet:param name="contentId" value="<%= String.valueOf(content.getContentId()) %>"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:renderURL>
						<portlet:renderURL var="rejectURL">
							<portlet:param name="mvcPath" value='<%=templatePath + "reject_content.jsp"%>' />
							<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
							<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
							<portlet:param name="redirectURL" value="<%=currentURL%>" />								
						</portlet:renderURL>
						<a class="btn btn-small" href="<%= rejectURL.toString() %>" role="button" onclick="return confirm('Bạn muốn trả lại bài viết này?');"><i class="glyphicon icon-circle-arrow-left"></i> <liferay-ui:message key="tra-ve" /></a>
						<portlet:actionURL var="editActionURL" name="updateNextStatus">
							<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
							<portlet:param name="cmd" value="UDEDITOR" />
							<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
							<portlet:param name="nextStatus" value="16" />
							<portlet:param name="redirect" value="<%=editURL.toString()%>" />
						</portlet:actionURL>
						<a class="btn btn-small" href="<%= editActionURL.toString() %>" role="button"><i class="glyphicon icon-ok-circle"></i> <liferay-ui:message key="chon-bien-tap" /></a>
						<portlet:actionURL var="cancelEditURL" name="updateNextStatus">
							<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
							<portlet:param name="cmd" value="RMEDITOR" />
							<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
							<portlet:param name="nextStatus" value="8" />
							<portlet:param name="redirect" value="<%=currentURL%>" />
						</portlet:actionURL>
						<a class="btn btn-small" href="<%= cancelEditURL.toString() %>" role="button"><i class="glyphicon icon-ban-circle"></i> <liferay-ui:message key="thoi-bien-tap" /></a>
						<portlet:actionURL var="forwardActionURL" name="sendToNextStep">
							<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
							<portlet:param name="version" value="<%= String.valueOf(content.getVersion()) %>"/>
							<portlet:param name="status" value="<%= String.valueOf(content.getStatus()) %>"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:actionURL>
						<a class="btn btn-small" href="<%= forwardActionURL.toString() %>" role="button" onclick="return confirm('Bạn muốn gửi bài viết này?');"><i class="glyphicon icon-circle-arrow-right"></i> <liferay-ui:message key="gui-di" /></a>
					</c:when>
					<c:when test='<%= version == 3 &&  (status == 256 || status==512)%>'>
					
					</c:when>
					<c:when test='<%= version == 4 &&  (status == 2048 || status==4096) %>'>
					
					</c:when>
				</c:choose>			
				</div>
			</div>
		</div>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
</c:if>
