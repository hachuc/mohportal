<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/asset_publisher/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
List results = (List)request.getAttribute("view.jsp-results");

int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();

request.setAttribute("view.jsp-showIconLabel", true);

String title = (String)request.getAttribute("view.jsp-title");

if (Validator.isNull(title)) {
	title = assetRenderer.getTitle(locale);
}

String viewURL = AssetPublisherHelperImpl.getAssetViewURL(liferayPortletRequest, liferayPortletResponse, assetEntry, viewInContext);

String viewURLMessage = viewInContext ? assetRenderer.getViewInContextMessage() : "read-more-x-about-x";

String summary = StringUtil.shorten(assetRenderer.getSummary(locale), abstractLength);

String smallImagePath = assetRenderer.getThumbnailPath(renderRequest);

Calendar calendar = Calendar.getInstance();
calendar.setTime(assetEntry.getPublishDate());
int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

Format dateFormatDateTime = FastDateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy HH:mm",locale,timeZone);
String[] strDayOfWeek = {" ", "Chủ Nhật, ngày ", "Thứ Hai, ngày ", "Thứ Ba, ngày ", "Thứ Tư, ngày ",
		  "Thứ Năm, ngày ", "Thứ Sáu, ngày ", "Thứ Bẩy, ngày "
		};
String assetPubLishDate = strDayOfWeek[dayOfWeek] + dateFormatDateTime.format(assetEntry.getPublishDate());

%>

<c:if test="<%= show %>">
<div class="itemm">
	<div class="row">
		<liferay-util:include
			page="/html/portlet/asset_publisher/asset_actions.jsp" />

		<div class="col-md-4 col-xs-5">
			<c:choose>
				<c:when test="<%= Validator.isNotNull(viewURL) %>">
					<a href="<%= viewURL %>"><img alt=""
						src="<%= assetRenderer.getThumbnailPath(renderRequest) %>" /></a>
				</c:when>
				<c:otherwise>
					<a href="javascript:;"><img alt=""
						src="<%= assetRenderer.getIconPath(renderRequest) %>" /></a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-md-8 col-xs-7 content">
			<h3 class="asset-title">
				<c:choose>
					<c:when test="<%= Validator.isNotNull(viewURL) %>">
						<a href="<%= viewURL %>"><%= HtmlUtil.escape(title) %></a>
					</c:when>
					<c:otherwise>
						<%= HtmlUtil.escape(title) %>
					</c:otherwise>
				</c:choose>
			</h3>
			<c:if test='<%= showCmsPublishDate %>'>
				<span class="time"><%= assetPubLishDate %></span>
			</c:if>
			<p class="hidden-xs">

				<%
				String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_ABSTRACT);

				request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
				request.setAttribute(WebKeys.ASSET_PUBLISHER_ABSTRACT_LENGTH, abstractLength);
				request.setAttribute(WebKeys.ASSET_PUBLISHER_VIEW_URL, viewURL);
				%>

				<c:choose>
					<c:when test="<%= path == null %>">
						<%= HtmlUtil.escape(summary) %>
					</c:when>
					<c:otherwise>
						<liferay-util:include page="<%= path %>"
							portletId="<%= assetRendererFactory.getPortletId() %>" />
					</c:otherwise>
				</c:choose>
				
			</p>
			<div class="asset-metadata">

				<%
			request.setAttribute("asset_metadata.jspf-filterByMetadata", true);
			%>

				<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf"%>
			</div>
		</div>
	</div>
	</div>
</c:if>