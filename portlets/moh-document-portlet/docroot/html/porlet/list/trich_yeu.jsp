<%@page import="java.util.Arrays"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.revotech.portal.vbpq.service.LoaiVanBanLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.model.NhomVanBan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.util.VanBanPhapQuyConstants"%>
<%@page import="com.revotech.portal.vbpq.util.VanBanPhapQuyUtils"%>
<%@page import="com.revotech.portal.vbpq.service.AttachFileLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.model.AttachFile"%>
<%@page import="com.revotech.portal.vbpq.admin.business.LoaiVanBanBusiness"%>
<%@page import="com.revotech.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page import="com.revotech.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@page import="com.revotech.portal.vbpq.model.LoaiVanBan"%>
<%@page import="com.revotech.portal.vbpq.model.LinhVucVanBan"%>
<%@page import="com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.revotech.portal.vbpq.model.VanBanPhapQuy"%>
<%@page import="com.revotech.portal.vbpq.admin.business.VanBanPhapQuyBusiness"%>
<%@page import="com.revotech.portal.vbpq.permission.AdminPermission"%>
<%@page import="com.revotech.portal.vbpq.VanBanPhapQuyGrid" %>
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
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/init.jsp" %>

<%!
%>

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
	String strCate = portletPreferences.getValue("chuyenMucUuTien", "NGAYBANHANH_ASC");
	String[] orderBys = strCate.split(",");
	
	String portletTitle1 = ParamUtil.getString(request, "portletTitle");
	
	boolean showNhomvanBan = Boolean.parseBoolean(portletPreferences.getValue("showNhomVanBan", "true"));
	boolean showTrichYeu = Boolean.parseBoolean(portletPreferences.getValue("showTrichYeu", "false"));
	long selectlayoutId = Long.parseLong(portletPreferences.getValue("lienKetTrang", "0"));
	boolean showIconBaiVietMoiNhat = Boolean.parseBoolean(portletPreferences.getValue("showIconBaiVietMoiNhat", "true"));

	int size = 0;
	try{
		size = VanBanPhapQuyLocalServiceUtil.count(keyword, scopeId,
				loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, nhoms, VanBanPhapQuyConstants.STATUS_PUBLISH, startDate, endDate);
	}catch (Exception e){
		System.out.println(e);
	}
	boolean isShowMore = (size > itemPerPage ? true:false);
	int chieuDaiTY = Integer.parseInt(portletPreferences.getValue("chieuDaiTrichYeu", "80"));
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
%>

		<%
			PortletURL readMoreURL = PortletURLFactoryUtil.create(request, "4_WAR_revotechdocumentportlet", selectlayoutId, PortletRequest.RENDER_PHASE);
			readMoreURL.setParameter("mvcPath", "/html/portlet/list/view.jsp");
			
			PortletURL rowURL1 = PortletURLFactoryUtil.create(request, "4_WAR_revotechdocumentportlet", selectlayoutId, PortletRequest.RENDER_PHASE);
		//	rowURL1.setParameter("mvcPath", "");
		%>
	
	
		
		<c:if test="<%=Validator.isNotNull(portletTitle) %>" >
		<h4 class="news-header-title">
			<c:choose>
				<c:when test="<%= Validator.isNotNull(rowURL1) %>">
					<a href="<%= rowURL1 %>" title="<%= HtmlUtil.escape(portletTitle) %>"><%= HtmlUtil.escape(portletTitle) %></a>
				</c:when>
				<c:otherwise>
					<span><%= HtmlUtil.escape(portletTitle) %></span>
				</c:otherwise>
			</c:choose>
		</h4>
	</c:if>
	<liferay-ui:search-container  delta="<%= itemPerPage %>" emptyResultsMessage="no-result-were-found">
	<liferay-ui:search-container-results
	<%
		VanBanPhapQuyGrid grid = VanBanPhapQuyLocalServiceUtil.timKiemVanBanPhapQuy(keyword, scopeId,
				loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, nhoms , VanBanPhapQuyConstants.STATUS_PUBLISH, startDate, endDate,
				0, itemPerPage , null, orderBys);
	%>
			results="<%= grid.getList() %>"
			total="<%=  grid.getTotal()  %>"
	/>     
		<liferay-ui:search-container-row
 			className="com.revotech.portal.vbpq.model.VanBanPhapQuy"
			keyProperty="id"
			modelVar="vanban"
		>
		<%
			PortletURL rowURL = PortletURLFactoryUtil.create(request, "4_WAR_revotechdocumentportlet", selectlayoutId, PortletRequest.RENDER_PHASE);
			rowURL.setParameter("id", String.valueOf(vanban.getId()));
			rowURL.setParameter("mvcPath", "/html/portlet/list/view_detail.jsp");
			
		
			
		%>
		
			
			<liferay-ui:search-container-column-text 
				name="trich-yeu"
				buffer="bf"
				>
				<%
				StringBuffer buffer = new StringBuffer();
				LoaiVanBan lvb = LoaiVanBanLocalServiceUtil.getLoaiVanBan(vanban.getLoaiVanBan());
				
				String str1 = HtmlUtil.extractText(lvb.getTen());
				String str2 = HtmlUtil.extractText(vanban.getMaVanBan());
				DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				String ngaybanhanh = dateformat.format(vanban.getNgayBanHanh());
				String str3 = HtmlUtil.extractText(ngaybanhanh);
				String str =str1+ " số " + str2 +" ngày "+ str3+ " " + HtmlUtil.extractText(vanban.getTrichYeu());
				String[] ar = StringUtil.split(str, " ");
				String[] T1 = Arrays.copyOfRange(ar, 0,chieuDaiTY-1);
				String str4 = null;
				if(ar.length >chieuDaiTY){
					str4 = StringUtil.merge(T1," ")+"...";
				} else 
					{
					str4 = str;
					}
				
				/* if (ar.length > chieuDaiTY) str = str.substring(0, chieuDaiTY) + "..."; */
				buffer.append("<a href=\""+ rowURL.toString() +"\">");
				buffer.append(str4); 
				if (vanban.getNgayTao() != null) {
					if (df.format(vanban.getNgayTao()).equals(df.format(new Date()))) {
						String icon = request.getContextPath() + "/images/new_2.gif";
						buffer.append("<img src='"+icon+"' />");
					}
				}
				
				buffer.append("</a>");
				
				bf.append(buffer.toString());
				
				%>
			</liferay-ui:search-container-column-text>
			
			
			
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator paginate="false" />

	</liferay-ui:search-container>
	
	
	
	<aui:script use="aui-base,node">
		var findEle = document.getElementById("_4_WAR_revotechdocumentportlet_vanBanPhapQuiesSearchContainer_col-trich-yeu");
		if (findEle != null) {
			A.one("#_4_WAR_revotechdocumentportlet_vanBanPhapQuiesSearchContainer_col-trich-yeu").hide();
		}
	</aui:script>

								