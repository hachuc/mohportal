<%@page import="com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.NhomVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.LoaiVanBan"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LoaiVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.permission.AdminPermission"%>
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

<%@ include file="init.jsp" %>


<%
	String keyword = ParamUtil.getString(request, "keywords");
		 PortletURL iteratorURL = renderResponse.createRenderURL();
			iteratorURL.setParameter("mvcPath", "/html/admin/view_danhmuc_loaivanban.jsp");
%>

<liferay-util:include page='<%= templatePath + "top_tabs.jsp" %>' servletContext="<%= application %>" />

<liferay-util:include page='<%= templatePath + "top_tabs_danhmuc.jsp" %>' servletContext="<%= application %>" />

<c:if test="<%= AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_LOAIVANBAN) %>">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="editEntryURL">
				<portlet:param name="mvcPath" value='<%= templatePath + "edit_danhmuc_loaivanban.jsp" %>' />
				<portlet:param name="redirect" value="<%= redirect %>"/>
			</portlet:renderURL>

			<aui:nav-item href="<%= editEntryURL %>" label="add" name="addEntryButton" iconCssClass="icon-plus"/>
		</aui:nav>

		<aui:nav-bar-search cssClass="pull-right">
			<liferay-portlet:renderURL var="searchLinhVucURL">
				<portlet:param name="mvcPath" value="/html/admin/view_danhmuc_loaivanban.jsp"/>
			</liferay-portlet:renderURL>
			
			<div class="form-search">
				<aui:form action="<%= searchLinhVucURL %>" method="post" name="fm">
					<liferay-ui:input-search id="keywords1" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
				</aui:form>
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
</c:if>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view_danhmuc_loaivanban.jsp" %>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		
	<aui:fieldset>
		<liferay-ui:search-container delta="20" emptyResultsMessage="no-result-were-found" iteratorURL="<%= iteratorURL %>">
			<liferay-ui:search-container-results
				results="<%= LoaiVanBanBusiness.findLoaiVanBan(keyword, themeDisplay.getScopeGroupId(),searchContainer.getOrderByComparator(), searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%= LoaiVanBanBusiness.countLoaiVanBan(keyword, themeDisplay.getScopeGroupId()) %>"
		/>

			<liferay-ui:search-container-row
	 			className="com.viettel.portal.vbpq.model.LoaiVanBan"
				keyProperty="id"
				modelVar="loaivb"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='<%= templatePath + "edit_danhmuc_loaivanban.jsp" %>' />
					<portlet:param name="id" value="<%=String.valueOf(loaivb.getId()) %>"/>
					<portlet:param name="redirect" value="<%= redirect %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="#"
					value="<%=String.valueOf(index+1) %>"
					href="<%=rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					value="<%= HtmlUtil.escape( loaivb.getTen() )%>"
				/>
				
				<liferay-ui:search-container-column-text
				name="nhom-van-ban"
					href="<%=rowURL %>"
					buffer="bf"
				>
				<%
				try {
					NhomVanBan nv = NhomVanBanLocalServiceUtil.getNhomVanBan(loaivb.getNhomVanBanId());
					if (nv != null) {
						bf.append(nv.getTenNhom());
					}
				} catch (Exception e){};
				%>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="ngayTao"
				>
					<%= dateFormatDate.format(loaivb.getNgayTao()) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					property="nguoiTao"
					href="<%=rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="ngaySua"
				>
					<%= dateFormatDate.format(loaivb.getNgaySua()) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					property="nguoiSua"
					href="<%=rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="action"
				>
					<liferay-ui:icon-menu>
						<portlet:actionURL var="deleteURL" name="deleteLoaiVanBan">
							<portlet:param name="id" value="<%= String.valueOf(loaivb.getId()) %>"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:actionURL>
					
						<liferay-ui:icon-delete url="<%= deleteURL %>" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />

		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>