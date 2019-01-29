<%@page import="com.revotech.portal.vbpq.util.WebKeys"%>
<%@page
	import="com.revotech.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@page import="com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%
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
%>

<%@ include file="/init.jsp"%>
<%
	List<CoQuanBanHanhVanBan> cqbhs = CoQuanBanHanhBusiness.getByTrangThai(scopeId, true, 0, 100);
	long _entryId = ParamUtil.getLong(request, "entryId", -1L);
 	String _typeContent = ParamUtil.getString(request, "typeContent", "");
%>
<div class="mt15">
	<div class="headerBox" style="line-height: 18px;">
		<c:choose>
			<c:when test="<%= Validator.isNotNull(layoutId) %>">
				<liferay-portlet:renderURL var="viewPage" plid="<%= layoutId %>" />
				<a href="<%= viewPage %>"
					title="<%= HtmlUtil.escape(dmPortletTitle) %>"><%= HtmlUtil.escape(dmPortletTitle) %></a>
			</c:when>
			<c:otherwise>
				<%= HtmlUtil.escape(dmPortletTitle) %>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="containerBox bdr-box p10">
		<ul class="LatestNews li_bullet red_bullet">

			<%
					for (CoQuanBanHanhVanBan cqbh : cqbhs) {
						
				%>
			<li class="clearfix">
				<c:choose>
					<c:when test="<%= Validator.isNotNull(layoutId) %>">
						<liferay-portlet:renderURL var="viewVBPQ" plid="<%= layoutId %>" portletName="<%= WebKeys.VBPQ_PORTLET_NAME %>">
							<portlet:param name="typeContent" value="<%= typeContent %>" />
							<portlet:param name="entryId" value="<%= Long.toString(cqbh.getId()) %>" />
						</liferay-portlet:renderURL> 
						<a href="<%= viewVBPQ %>"> <%= HtmlUtil.escape( cqbh.getTen() )%>
					</c:when>
					<c:otherwise>
						<liferay-portlet:renderURL var="viewVBPQ" portletName="<%= WebKeys.VBPQ_PORTLET_NAME %>">
							<portlet:param name="typeContent" value="<%= typeContent %>" />
							<portlet:param name="entryId" value="<%= Long.toString(cqbh.getId()) %>" />
						</liferay-portlet:renderURL> 
						<a href="<%= viewVBPQ %>"> <%= HtmlUtil.escape( cqbh.getTen() )%></a>
					</c:otherwise>
				</c:choose>
			</li>
			<%
					}
				%>
		</ul>
	</div>
</div>
