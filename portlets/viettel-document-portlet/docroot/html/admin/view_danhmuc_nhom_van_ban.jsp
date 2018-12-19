<%@page import="com.liferay.portal.kernel.util.Html"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.viettel.portal.vbpq.portlet.NhomVanBanController"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.viettel.portal.vbpq.model.NhomVanBan"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.permission.AdminPermission"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
%>
<liferay-ui:error key="<%= NhomVanBanController.NHOM_VAN_BAN_DELETE_ERROR_HAS_CHILD%>" message="Đã có dữ liệu, không xóa được nhóm!" />
<liferay-util:include page='<%= templatePath + "top_tabs.jsp" %>' servletContext="<%= application %>" />

<liferay-util:include page='<%= templatePath + "top_tabs_danhmuc.jsp" %>' servletContext="<%= application %>" />

<c:if test="<%= AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_LINHVUC) %>">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="editEntryURL">
				<portlet:param name="mvcPath" value='<%= templatePath + "edit_view_danhmuc_nhom_van_ban.jsp" %>' />
				<portlet:param name="redirect" value="<%= redirect %>"/>
			</portlet:renderURL>

			<aui:nav-item href="<%= editEntryURL %>" label="add" name="addEntryButton" iconCssClass="icon-plus"/>
		</aui:nav>

		<aui:nav-bar-search cssClass="pull-right">
			<liferay-portlet:renderURL var="searchLinhVucURL">
				<portlet:param name="mvcPath" value="/html/admin/view_danhmuc_nhom_van_ban.jsp"/>
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
	<portlet:param name="mvcPath" value='/html/admin/view_danhmuc_nhom_van_ban.jsp' />
</liferay-portlet:renderURL>

<%

	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(NhomVanBan.class);
	if (keyword != null)
	dynamicQuery.add(RestrictionsFactoryUtil.like("tenNhom", "%" + keyword + "%"));
	dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getScopeGroupId()));
	dynamicQuery.addOrder(OrderFactoryUtil.desc("ngayTao"));
	List<NhomVanBan> ls = NhomVanBanLocalServiceUtil.dynamicQuery(dynamicQuery);
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/admin/view_danhmuc_nhom_van_ban.jsp");

%>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		
	<aui:fieldset>
		<liferay-ui:search-container  emptyResultsMessage="no-result-were-found" iteratorURL="<%= iteratorURL %>">
			<liferay-ui:search-container-results
				results="<%= ListUtil.subList(ls, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%= ls.size() %>"
		/>

			<liferay-ui:search-container-row
	 			className="com.viettel.portal.vbpq.model.NhomVanBan"
				keyProperty="id"
				modelVar="nhomvanban"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='<%= templatePath + "edit_view_danhmuc_nhom_van_ban.jsp" %>' />
					<portlet:param name="id" value="<%=String.valueOf(nhomvanban.getId()) %>"/>
					<portlet:param name="redirect" value="<%= redirect %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="#"
					value="<%=String.valueOf(index+1) %>"
					href="<%=rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					value = "<%= HtmlUtil.escape(nhomvanban.getTenNhom()) %>" 
					name="Tên nhóm"
					href="<%=rowURL %>"
				/>

				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="ngayTao"
				>
					<%= dateFormatDate.format(nhomvanban.getNgayTao()) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					property="nguoiTao"
					href="<%=rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="ngaySua"
				>
					<%= dateFormatDate.format(nhomvanban.getNgaySua()) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					property="nguoiSua"
					href="<%=rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text buffer="bf" name="Hiển thị">
				<%
					String check = (nhomvanban.getTrangThai() == WorkflowConstants.STATUS_APPROVED ? "checked":"");
					String html = "<input type='checkbox' " + check + " />";
					bf.append(html);
				%>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="action"
				>
					<liferay-ui:icon-menu>
						<portlet:actionURL var="deleteURL" name="createOrEditNhomVanBan">
							<portlet:param name="<%= NhomVanBanController.NHOM_VAN_BAN_ID %>" value="<%= String.valueOf(nhomvanban.getId()) %>"/>
							<portlet:param name="<%= NhomVanBanController.NHOM_VAN_BAN_ACTION_DELETE %>" value="true"/>
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