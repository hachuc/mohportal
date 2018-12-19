
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
<%@page import="com.viettel.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.NhomVanBan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.viettel.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyConstants"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyUtils"%>
<%@page import="com.viettel.portal.vbpq.service.AttachFileLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.AttachFile"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LoaiVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.LoaiVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.LinhVucVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.VanBanPhapQuy"%>
<%@page import="com.viettel.portal.vbpq.admin.business.VanBanPhapQuyBusiness"%>
<%@page import="com.viettel.portal.vbpq.permission.AdminPermission"%>
<%@page import="com.viettel.portal.vbpq.VanBanPhapQuyGrid" %>
<%@ include file="init.jsp" %>

<liferay-util:include page='<%= templatePath + "top_tabs.jsp" %>' servletContext="<%= application %>" />
<%
String keyword = ParamUtil.getString(request, "keyword");

int typeContentMenu = ParamUtil.getInteger(request, "typeContent");

long entryId = ParamUtil.getLong(request, "entryId");
long coQuanBanHanhId = ParamUtil.getLong(request, "coQuanBanHanhId", 0);
long loaiVanBanId = ParamUtil.getLong(request, "loaiVanBanId", 0);
long linhVucVanBanId = ParamUtil.getLong(request, "linhVucVanBanId", 0);
int year = ParamUtil.getInteger(request, "year");

if (typeContentMenu != 0 && entryId != 0) {
	if (typeContentMenu == 1) {
		coQuanBanHanhId = entryId;
	} else if (typeContentMenu == 2) {
		linhVucVanBanId = entryId;
	} else if (typeContentMenu == 3) {
		loaiVanBanId = entryId;
	}
}

List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = null;
if(coQuanBanHanhIdPrefs != null && coQuanBanHanhIdPrefs.length > 0) {
	lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByListSelected(coQuanBanHanhIdPrefs);
} else {
	lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByTrangThai(scopeId, true, -1, -1);
}

List<LinhVucVanBan> lsLinhVuc = null;
if(linhVucVanBanIdPrefs != null && linhVucVanBanIdPrefs.length > 0) {
	lsLinhVuc = LinhVucVanBanBusiness.getByListSelected(linhVucVanBanIdPrefs);
} else {
	lsLinhVuc = LinhVucVanBanBusiness.getByTrangThai(scopeId, true, -1, -1);
}

List<LoaiVanBan> lsLoaiVanBan = null;
if(loaiVanBanIdPrefs != null && loaiVanBanIdPrefs.length > 0) {
	lsLoaiVanBan = LoaiVanBanBusiness.getByListSelected(loaiVanBanIdPrefs);
} else {
	lsLoaiVanBan = LoaiVanBanBusiness.getByTrangThai(scopeId, true, -1, -1);
}

long[] coQuanBanHanhIds = coQuanBanHanhIdPrefs;
if(coQuanBanHanhId > 0) {
	coQuanBanHanhIds = new long[]{coQuanBanHanhId};
}

long[] linhVucVanBanIds = linhVucVanBanIdPrefs;
if(linhVucVanBanId > 0) {
	linhVucVanBanIds = new long[]{linhVucVanBanId};
}
long[] loaiVanBanIds = loaiVanBanIdPrefs;
if(loaiVanBanId > 0) {
	loaiVanBanIds = new long[]{loaiVanBanId};
}

Date startDate = null;
Date endDate = null;
//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
if(year > 0){
	Calendar cStartDate = Calendar.getInstance();
	cStartDate.set(Calendar.YEAR, year);
	cStartDate.set(Calendar.MONTH, 0);
	cStartDate.set(Calendar.DAY_OF_MONTH, 1);
	cStartDate.set(Calendar.HOUR_OF_DAY, 0);
	cStartDate.set(Calendar.MINUTE, 0);
	cStartDate.set(Calendar.SECOND, 0);
	cStartDate.set(Calendar.MILLISECOND, 0);
	startDate = cStartDate.getTime();
	//System.out.println(format.format(cStartDate.getTime()));
	
	Calendar cEndDate = Calendar.getInstance();
	cEndDate.set(Calendar.YEAR, year);
	cEndDate.set(Calendar.MONTH, 11);
	cEndDate.set(Calendar.DAY_OF_MONTH, 31);
	cEndDate.set(Calendar.HOUR_OF_DAY, 23);
	cEndDate.set(Calendar.MINUTE, 59);
	cEndDate.set(Calendar.SECOND, 59);
	cEndDate.set(Calendar.MILLISECOND, 0);
	endDate = cEndDate.getTime();
	//System.out.println(format.format(cEndDate.getTime()));
}
String nhom = portletPreferences.getValue("nhomVanBanId", "");
String[] nhomVanBanIds = new String[0];
if (nhom.length() > 0) {
	nhomVanBanIds = nhom.split(",");
}
long nhomVanBanId = ParamUtil.getLong(request, "nhomVanBanId", 0);

long[] nhoms = new long[nhomVanBanIds.length];
if (nhomVanBanId > 0) {
	nhoms = new long[] {nhomVanBanId};
} else {
	nhoms = new long[nhomVanBanIds.length];
	for (int i = 0; i < nhomVanBanIds.length; i++) {
		if (nhomVanBanIds[i].trim().length() > 0) {
			nhoms[i] = Long.parseLong(nhomVanBanIds[i].trim());
		}
	}
}


int itemPerPage = Integer.parseInt(portletPreferences.getValue("itemPerPage", "10"));
String strCate = portletPreferences.getValue("ngayTao", "NGAYTAO_DESC");
String[] orderBys = strCate.split(",");
System.out.println("orderBys  =  "+orderBys);
System.out.println("strCate  =  "+strCate);
boolean showNhomvanBan = Boolean.parseBoolean(portletPreferences.getValue("showNhomVanBan", "true"));

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/portlet/list/view.jsp");
iteratorURL.setParameter("keyword", keyword);
iteratorURL.setParameter("coQuanBanHanhId", String.valueOf(coQuanBanHanhId));
iteratorURL.setParameter("linhVucVanBanId", String.valueOf(linhVucVanBanId));
iteratorURL.setParameter("loaiVanBanId", String.valueOf(loaiVanBanId));
iteratorURL.setParameter("nhomVanBanId", String.valueOf(nhomVanBanId));

%>
<c:if test="<%= AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_VANBANPHAPQUY) %>">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="editEntryURL">
				<portlet:param name="mvcPath" value='<%= templatePath + "edit_vanban.jsp" %>' />
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:renderURL>

			<aui:nav-item href="<%= editEntryURL %>" label="add" name="addEntryButton" iconCssClass="icon-plus"/>
		</aui:nav>
	</aui:nav-bar>
</c:if>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view_vanban.jsp" %>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		
	<aui:fieldset>
		<liferay-ui:search-container delta="20" emptyResultsMessage="no-result-were-found" 
			searchContainer="<%= new VanBanSearch(liferayPortletRequest, currentURLObj) %>">
			<liferay-ui:search-form
				page='<%= templatePath + "view_vanban_search.jsp" %>'
				servletContext="<%= application %>"
			/>
			
			<%
				VanBanDisplayTerms searchTerms = (VanBanDisplayTerms)searchContainer.getSearchTerms();
				int start = searchContainer.getStart();
				int end = searchContainer.getDelta();
				VanBanPhapQuyGrid grid = VanBanPhapQuyLocalServiceUtil.timKiemVanBanPhapQuyTheoNgayTao(keyword, scopeId,
						loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds , nhoms, searchTerms.getStatusObj(), searchTerms.getStartDateObj(), searchTerms.getEndDateObj(),
						start, end , null, orderBys);
			%>
			
			<liferay-ui:search-container-results
				results="<%= grid.getList() %>"
				total="<%=  grid.getTotal() %>"
			/>

			<liferay-ui:search-container-row
	 			className="com.viettel.portal.vbpq.model.VanBanPhapQuy"
				keyProperty="id"
				modelVar="vanban"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='<%= templatePath + "edit_vanban.jsp" %>' />
					<portlet:param name="id" value="<%=String.valueOf(vanban.getId()) %>"/>
					<portlet:param name="redirect" value="<%= currentURL %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="STT"
					value="<%=String.valueOf(index+1) %>"
					href="<%=rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="ma-van-ban"
					href="<%= rowURL %>"
					value="<%= HtmlUtil.escape(vanban.getMaVanBan()) %>"
				/>
				
				<liferay-ui:search-container-column-text 
					name="trich-yeu"
					value="<%= HtmlUtil.escape(vanban.getTrichYeu())%>"
					href="<%= rowURL %>"
				/>

				<liferay-ui:search-container-column-text 
					name="nguoi-tao"
					property="nguoiTao"
					href="<%= rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="ngay-tao"
					href="<%=rowURL %>"
				>
					<%= dateFormatDateTime.format(vanban.getNgaySua()) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="ngay-ban-hanh"
					href="<%=rowURL %>"
				>
					<c:if test="<%= vanban.getNgayBanHanh() != null %>">
						<%= dateFormatDate.format(vanban.getNgayBanHanh()) %>
					</c:if>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="status"
					href="<%=rowURL %>"
				>
					<c:choose>
						<c:when test="<%= vanban.getStatus() == VanBanPhapQuyConstants.STATUS_PUBLISH %>">
							<liferay-ui:message key="da-dang" />
						</c:when>
						
						<c:otherwise>
							<liferay-ui:message key="chua-dang" />
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-column-text>

				<%
				boolean deletePermission = AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_VANBANPHAPQUY);
				boolean publishPermission = vanban.getStatus() != VanBanPhapQuyConstants.STATUS_PUBLISH 
					&& AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PUBLISH_VANBAN);
				%>
				
				<c:if test="<%= deletePermission || publishPermission %>">
					<liferay-ui:search-container-column-text
						name="action"
					>
						<c:if test="<%= publishPermission %>">
							
							<portlet:actionURL var="publishURL" name="updateStatusVanBan">
								<portlet:param name="id" value="<%= String.valueOf(vanban.getId()) %>"/>
								<portlet:param name="status" value="<%= String.valueOf(VanBanPhapQuyConstants.STATUS_PUBLISH) %>"/>
								<portlet:param name="redirect" value="<%= currentURL %>"/>
							</portlet:actionURL>
							
							<liferay-ui:icon image="post" message="publish" url="<%=publishURL %>" />
						</c:if>
						
						<c:if test="<%= deletePermission %>">
							<portlet:actionURL var="deleteURL" name="deleteVanBan">
								<portlet:param name="id" value="<%= String.valueOf(vanban.getId()) %>"/>
								<portlet:param name="redirect" value="<%= currentURL %>"/>
							</portlet:actionURL>
						
							<liferay-ui:icon-delete url="<%= deleteURL %>" />
						</c:if>
					</liferay-ui:search-container-column-text>
				</c:if>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator/>
			
		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>
