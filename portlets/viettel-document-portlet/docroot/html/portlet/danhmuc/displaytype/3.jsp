<%@page import="com.viettel.portal.vbpq.util.WebKeys"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LoaiVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.LoaiVanBan"%>
<%@page import="com.viettel.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan"%>
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
	List<LoaiVanBan> list = LoaiVanBanBusiness.getByTrangThai(scopeId, true, 0, 100);		 
	long _entryId = ParamUtil.getLong(request, "entryId", -1L);
 	String _typeContent = ParamUtil.getString(request, "typeContent", "");
%>

<div class="vbpq-display-portlet">
	<h1 class="portlet-title">
		<span>
			<img src="/viettel-document-portlet/images/vbpq_category_portlet_icon.png"/>
		</span>
		<span class="portlet-title-text">
		<liferay-ui:message key="loai-van-ban"></liferay-ui:message>
		</span>
	</h1>
	<div class="portlet-content">
		<div class="vbpq-category-view">
			<ul>
				<%
					for (LoaiVanBan loai : list) {
						
				%>
					<li class='<%= (_typeContent.equals(typeContent) && loai.getId() == _entryId ? "selected" : "") %>'>
						<liferay-portlet:renderURL var="viewVBPQ" portletName="<%= WebKeys.VBPQ_PORTLET_NAME %>">
								<portlet:param name="typeContent" value="<%= typeContent %>"/>
								<portlet:param name="entryId" value="<%= Long.toString(loai.getId()) %>"/>
						</liferay-portlet:renderURL>	
		
						<a href="<%= viewVBPQ %>">
							<%= HtmlUtil.escape( loai.getTen()) %>
						</a>		
					</li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</div>
