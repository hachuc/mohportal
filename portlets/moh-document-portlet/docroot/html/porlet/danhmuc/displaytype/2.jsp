<%@page import="com.revotech.portal.vbpq.util.WebKeys"%>
<%@page import="com.revotech.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page import="com.revotech.portal.vbpq.model.LinhVucVanBan"%>
<%@page import="com.revotech.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
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

<%@ include file="/init.jsp" %>

<%
	List<LinhVucVanBan> list = LinhVucVanBanBusiness.getByTrangThai(scopeId, true, 0, 100);
	long _entryId = ParamUtil.getLong(request, "entryId", -1L);
 	String _typeContent = ParamUtil.getString(request, "typeContent", "");		 
%>

<div class="vbpq-display-portlet">
	<h1 class="portlet-title">
		<span>
			<img src="/revotech-document-portlet/images/vbpq_category_portlet_icon.png"/>
		</span>
		<span class="portlet-title-text">
			<liferay-ui:message key="linh-vuc-van-ban"></liferay-ui:message>
		</span>
	</h1>
	<div class="portlet-content">
		<div class="vbpq-category-view">
			<ul>
				<%
					for (LinhVucVanBan linhvuc : list) {
						
				%>
					<li class='<%= (_typeContent.equals(typeContent) && linhvuc.getId() == _entryId ? "selected" : "") %>'>
						<liferay-portlet:renderURL var="viewVBPQ" portletName="<%= WebKeys.VBPQ_PORTLET_NAME %>">
								<portlet:param name="typeContent" value="<%= typeContent %>"/>
								<portlet:param name="entryId" value="<%= Long.toString(linhvuc.getId()) %>"/>
						</liferay-portlet:renderURL>
		
						<a href="<%= viewVBPQ %>">
							<%= HtmlUtil.escape( linhvuc.getTen()) %>
						</a>
					</li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</div>
