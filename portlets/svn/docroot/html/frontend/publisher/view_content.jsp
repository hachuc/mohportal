<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.util.CmsConstants"%>
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
<%@ include file="/html/frontend/publisher/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
	//long categoryId = ParamUtil.getLong(request, "contentId", 0L);
	long dttrId = ParamUtil.getLong(request, "distId", 0L);
	//String urlTitle  = ParamUtil.getString(request, "urlTitle", StringPool.BLANK);
	boolean print = ParamUtil.getString(request, "viewMode").equals(Constants.PRINT);
	boolean show = true;
	if(dttrId == 0)
		show = false;
	Distribution distribution = DistributionLocalServiceUtil.fetchDistribution(dttrId);
	if (distribution == null)
		show = false;
	Content content = ContentLocalServiceUtil.findByContentId(distribution.getContentId(), scopeGroupId, distribution.getVersion(), CmsConstants.FINAL_STATUS);
%>
<c:if test='<%=show%>'>
	<div class="clearfix pb5">
		<div class="pull-right">
			<span style="font-size: 12px;"><liferay-ui:message key="xem-voi-co-chu" /></span>&nbsp;
			<span onclick="resizeText(-1)" class="change-size-button pointer"
				id="down"><img
				src="/viettel-cms-portlet/images/FontTSmall.png"
				width="10" height="10" alt=""></span> <span onclick="resizeText(1)"
				class="change-size-button pointer" id="up"><img
				src="/viettel-cms-portlet/images/FontTLage.png"
				width="14" height="14" alt="">
			</span>&nbsp;&nbsp;
			<%@ include file="/html/frontend/publisher/distribution_print.jspf"%>
		</div>
	</div>
	<div class="contentDetail">
		<%
				if (content != null) {
					String viewContentURL = VCMSPubliserUtil.getViewContentURL(request, distribution, linkedLayout);
		%>

		<c:if test="<%=Validator.isNotNull(content.getSubTitle())%>">
			<h6 class="sub-title-content text-change-size"><%=HtmlUtil.escape(content.getSubTitle())%></h6>
		</c:if>
		<h3 class="text-change-size story"><%=HtmlUtil.escape(content.getTitle())%></h3>
		
		<c:if test="<%=showPublishDate%>">
			<div>
				<p class="time-post text-change-size"><%=dateTimeFormat.format(distribution.getDistributedDate())%></p>
			</div>
		</c:if>
		<div class="contentDetail text-change-size mt15" align="justify">
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
			<p>
				<%=content.getContent()%>
			</p>
			<c:if test="<%= Validator.isNotNull(content.getAuthor()) %>">
				<div class="author"><%= HtmlUtil.escape(content.getAuthor()) %></div>
			</c:if>
		</div>
		<c:if test="<%= showSocialBookmark %>">
		<div class="hidden-print">
			<liferay-ui:social-bookmarks
				contentId="<%= String.valueOf(content.getContentId()) %>"
				displayStyle="horizontal"
				target="_blank"
				title="<%= content.getTitle() %>"
				url="<%= PortalUtil.getCanonicalURL(viewContentURL, themeDisplay, linkedLayout) %>"
			/>
			</div>
		</c:if>
		<c:if test='<%= allowDiscussion %>'>
			<div class="hidden-print">
			<%@ include file="/html/frontend/publisher/comment_box.jspf" %>
			</div>
		</c:if>
		<%
			}
		%>
	</div>
	<%
		List<Distribution> lstRelateContents = DistributionLocalServiceUtil.findRelateContents(scopeGroupId,
				distribution.getDistributionId(), 0, 10);
			if (lstRelateContents.size() > 0) {
	%>
	<h2 class="other-news-title hidden-print"><liferay-ui:message key="news-new" /></h2>
	<ul class="othernews hidden-print">
		<% for(Distribution dis : lstRelateContents){
			String viewURL = VCMSPubliserUtil.getViewContentURL(request, dis, linkedLayout);
			Content entry = ContentLocalServiceUtil.findByContentId(dis.getContentId(), scopeGroupId, CmsConstants.PUBLISHED_NEWS, CmsConstants.FINAL_STATUS);
			if(entry == null)
				continue;
			String title = entry!=null ? entry.getTitle() : "";
			%>
			<li><a href="<%=viewURL%>"><%= HtmlUtil.escape(title) %></a>
			<c:if test="<%= showPublishDate %>">
				&nbsp;&nbsp;<span class="time-post">(<%= dateFormat.format(dis.getDistributedDate()) %>)</span>
			</c:if>
			</li>
		<% } %>
	</ul>
	<%
		}
	%>

</c:if>

<script type="text/javascript">
	$(document).ready(function() {
		getSize();
		$("#up").on("click", function() {

			// parse font size, if less than 50 increase font size
			if ((size + 1) <= 50) {
				$(".text-change-size").css("font-size", "+=1");
			}
		});

		$("#down").on("click", function() {
			if ((size - 1) >= 12) {
				$(".text-change-size").css("font-size", "-=1");
			}
		});
	});
	function getSize() {
		size = $(".contentDetail").css("font-size");
		size = parseInt(size, 14);
	}

	//get inital font size
</script>