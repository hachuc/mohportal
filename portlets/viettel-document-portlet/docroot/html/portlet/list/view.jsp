<%@page import="com.liferay.portal.kernel.util.Html"%>
<%@page
	import="com.viettel.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil"%>
<%@page
	import="com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.NhomVanBan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.viettel.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyConstants"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyUtils"%>
<%@page
	import="com.viettel.portal.vbpq.service.AttachFileLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.AttachFile"%>
<%@page
	import="com.viettel.portal.vbpq.admin.business.LoaiVanBanBusiness"%>
<%@page
	import="com.viettel.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page
	import="com.viettel.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.LoaiVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.LinhVucVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.VanBanPhapQuy"%>
<%@page
	import="com.viettel.portal.vbpq.admin.business.VanBanPhapQuyBusiness"%>
<%@page import="com.viettel.portal.vbpq.permission.AdminPermission"%>
<%@page import="com.viettel.portal.vbpq.VanBanPhapQuyGrid"%>
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
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/init.jsp"%>

<%
	boolean showTrichYeu = Boolean.parseBoolean(portletPreferences.getValue("showTrichYeu", "false"));

%>
<c:if test="<%= showTrichYeu %>">
	<liferay-util:include page="/html/portlet/list/trich_yeu.jsp"
		servletContext="<%= application %>"></liferay-util:include>
</c:if>
<c:if test="<%= !showTrichYeu %>">

	<%
	String keyword = ParamUtil.getString(request, "keyword");
	int typeContentMenu = ParamUtil.getInteger(request, "typeContent");
	long entryId = ParamUtil.getLong(request, "entryId");
	long coQuanBanHanhId = ParamUtil.getLong(request, "coQuanBanHanhId", 0);
	long loaiVanBanId = ParamUtil.getLong(request, "loaiVanBanId", 0);
	long linhVucVanBanId = ParamUtil.getLong(request, "linhVucVanBanId", 0);
	int year = ParamUtil.getInteger(request, "year");
	
	if (typeContentMenu != 0 && entryId != 0) {
		if (typeContentMenu == 1 && coQuanBanHanhId <= 0) {
			coQuanBanHanhId = entryId;
		} else if (typeContentMenu == 2 && linhVucVanBanId <= 0) {
			linhVucVanBanId = entryId;
		} else if (typeContentMenu == 3 && loaiVanBanId <= 0) {
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
	String strCate = portletPreferences.getValue("ngayBanHanh", "NGAYBANHANH_DESC");
	String[] orderBys = strCate.split(",");

	boolean showNhomvanBan = Boolean.parseBoolean(portletPreferences.getValue("showNhomVanBan", "true"));
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/portlet/list/view.jsp");
	iteratorURL.setParameter("keyword", keyword);
	iteratorURL.setParameter("coQuanBanHanhId", String.valueOf(coQuanBanHanhId));
	iteratorURL.setParameter("linhVucVanBanId", String.valueOf(linhVucVanBanId));
	iteratorURL.setParameter("loaiVanBanId", String.valueOf(loaiVanBanId));
	iteratorURL.setParameter("nhomVanBanId", String.valueOf(nhomVanBanId));
%>

	<portlet:resourceURL var="serverURL"></portlet:resourceURL>

	<liferay-portlet:renderURL varImpl="searchURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
	</liferay-portlet:renderURL>
	<div class="vbpq-display-portlet ">
		<h1 class="portlet-title">
			<span> <img
				src="/viettel-document-portlet/images/vbpq_category_portlet_icon.png" />
			</span> <span class="portlet-title-text"> <liferay-ui:message
					key="van-ban-phap-quy"></liferay-ui:message>
			</span>
		</h1>
		<aui:form action="<%= searchURL %>" method="get" name="fm"
			cssClass="vbpq-search-form mt20">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label pr5"><liferay-ui:message
							key="keyword" /></label> <input name="keyword" type="text"
						class="form-control" value="<%= keyword %>" />
				</div>
			</div>
			<c:if test="<%= showNhomvanBan %>">
				<div class="col-md-6">
					<div class="form-group">
							<aui:select name="nhomVanBanId" label="nhom-van-ban" cssClass="form-control" showEmptyOption="<%= false %>">
								<%
									List<Long> idList = new ArrayList();
									for(String st : nhomVanBanIds) {
										idList.add(Long.parseLong(st));
									}
									List<NhomVanBan> ls = NhomVanBanLocalServiceUtil.getNhomVanBanById(idList);
									for (NhomVanBan nv : ls) {
										boolean selected = nv.getId() == nhomVanBanId;
								%>
									<aui:option label="<%= HtmlUtil.escape(nv.getTenNhom())  %>" selected="<%= selected %>" value="<%= String.valueOf(nv.getId()) %>"></aui:option>
								<% } %>
							</aui:select>	
							
					</div>
				</div>
			</c:if>

			<c:if test="<%= showSearchCoQuanBanHanh %>">
				<div class="col-md-6">
					<div class="form-group">
						<aui:select name="coQuanBanHanhId"
							class="form-control" label="co-quan-ban-hanh">
							<%
							if(lsCoQuanBanHanh.size()> 0){
								for (CoQuanBanHanhVanBan cq : lsCoQuanBanHanh) {
									boolean selected = cq.getId() == coQuanBanHanhId;
							%>
								<aui:option label="<%= HtmlUtil.escape(cq.getTen())  %>" selected="<%= selected %>" value="<%= String.valueOf(cq.getId()) %>"></aui:option>
							<% }} %>
						</aui:select>
					</div>
				</div>
			</c:if>

			<c:if test="<%= showSearchLoaiVanBan %>">
				<div class="col-md-6">
					<div class="form-group">
						<aui:select name="loaiVanBanId"
							class="form-control" label="loai-van-ban">
							<%
							if(lsLoaiVanBan.size()> 0){
								for (LoaiVanBan lvb : lsLoaiVanBan) {
									boolean selected = lvb.getId() == loaiVanBanId;
							%>
								<aui:option label="<%= HtmlUtil.escape(lvb.getTen())  %>" selected="<%= selected %>" value="<%= String.valueOf(lvb.getId()) %>"></aui:option>
							<% }} %>
						</aui:select>
					</div>
				</div>
			</c:if>

			<c:if test="<%= showSearchLinhVuc %>">
				<div class="col-md-6">
					<div class="form-group">
						<aui:select name="linhVucVanBanId"
							class="form-control" label="linh-vuc-van-ban">
							<%
							if(lsLinhVuc.size()> 0){
								for (LinhVucVanBan lv : lsLinhVuc) {
									boolean selected = lv.getId() == linhVucVanBanId;
							%>
								<aui:option label="<%= HtmlUtil.escape(lv.getTen())  %>" selected="<%= selected %>" value="<%= String.valueOf(lv.getId()) %>"></aui:option>
							<% }} %>
						</aui:select>
					</div>
				</div>
			</c:if>

			<c:if test="<%= showSearchYear %>">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label pr5"><liferay-ui:message
								key="year" /></label> <aui:select name="year" class="form-control">
							<%
							for (int i = 1992; i< 2020; i++)
							{
						%>
							<option value="<%= i %>" label="<%= i %>"
								selected="<%= i == year %>" />
							<%
							}
						%>
						</aui:select>
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-md-12" style="text-align: center;">
					<aui:button name="search" type="submit" value="document-search"
						cssClass="btn btn-grey text-bold" />
				</div>
			</div>
			<div class="search-result-vbpq table-responsive">
				<liferay-ui:search-container iteratorURL="<%= iteratorURL %>"
					delta="<%= itemPerPage %>"
					emptyResultsMessage="no-result-were-found">

					<%
				int start = searchContainer.getStart();
				int end = searchContainer.getDelta();
				System.err.println("keyword -> " + keyword);
				VanBanPhapQuyGrid grid = VanBanPhapQuyLocalServiceUtil.timKiemVanBanPhapQuy(keyword, scopeId,
						loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds , nhoms, VanBanPhapQuyConstants.STATUS_PUBLISH, startDate, endDate,
						start, end , null, orderBys);
			%>
					<liferay-ui:search-container-results
						results="<%= grid.getList() %>" total="<%=  grid.getTotal() %>" />
					<liferay-ui:search-container-row
						className="com.viettel.portal.vbpq.model.VanBanPhapQuy"
						keyProperty="id" modelVar="vanban">
						<portlet:renderURL var="rowURL">
							<portlet:param name="mvcPath"
								value='<%= templatePath + "view_detail.jsp" %>' />
							<portlet:param name="id"
								value="<%=String.valueOf(vanban.getId()) %>" />
						</portlet:renderURL>


						<liferay-ui:search-container-column-text name="ma-van-ban"
							value="<%= HtmlUtil.escape(vanban.getMaVanBan()) %>"
							cssClass="vbpq-sohieuvanban" align="left" />

						<liferay-ui:search-container-column-text name="trich-yeu"
							value="<%= HtmlUtil.escape(vanban.getTrichYeu()) %>"
							href="<%= rowURL %>">
							<div class="social hot tooltipstered">
								<%= vanban.getTrichYeu() %>
							</div>
						</liferay-ui:search-container-column-text>

						<c:if test="<%= showCQBH %>">
							<liferay-ui:search-container-column-text name="don-vi-ban-hanh"
								cssClass="vbpq-donvibanhanh">

								<%
								long cqbhId = vanban.getCoQuanBanHanh();
								String tenCQBH = StringPool.BLANK;
								if(cqbhId > 0){
									CoQuanBanHanhVanBan banHanhVanBan = null;
									try{
										banHanhVanBan = CoQuanBanHanhVanBanLocalServiceUtil.getCoQuanBanHanh(cqbhId);
										if(banHanhVanBan != null){
											tenCQBH =  banHanhVanBan.getTen();
										}
									}catch(Exception e){
										
									}
								}
							%>
								<%= HtmlUtil.escape(tenCQBH) %>
							</liferay-ui:search-container-column-text>
						</c:if>
						<c:if test="<%= showNgayBanHanh %>">
							<liferay-ui:search-container-column-text name="ngay-ban-hanh"
								cssClass="vbpq-ngaybanhanh center">
								<%= dateFormatDate.format(vanban.getNgayBanHanh()) %>
							</liferay-ui:search-container-column-text>
						</c:if>

						<c:if test="<%= showNguoiKy %>">
							<liferay-ui:search-container-column-text name="nguoi-ky"
								value="<%= HtmlUtil.escape(vanban.getNguoiKy()) %>"
								cssClass="vbpq-nguoiky center" />
						</c:if>
						<c:if test="<%= showAttachment %>">
							<liferay-ui:search-container-column-text name="file-dinh-kem"
								cssClass="vbpq-file-dinh-kem center">
								<%
							List<AttachFile> lsFile = new ArrayList<AttachFile>(); 
							
							if (Validator.isNotNull(lsFile)) {
								lsFile = AttachFileLocalServiceUtil.getAttachByVanBan(vanban.getId());
							}
						%>

								<c:if test="<%= lsFile.size() != 0 %>">
									<%
							for (AttachFile atf : lsFile)
							{
								StringBuilder sb = new StringBuilder(4);
								
								String ext = VanBanPhapQuyUtils.getExtensionFile(atf.getFileName());
								
								if(Validator.isNotNull(ext)) {
									sb.append(request.getContextPath());
									sb.append("/images/");
									sb.append(ext.toUpperCase());
									sb.append(".png");
								}
								
								String imgStr = sb.toString();
							%>
									<a href="<%= atf.getFileLink() %>" style="padding-right: 5px;"
										title="<%= HtmlUtil.escape(vanban.getMaVanBan()) %>"> <c:choose>
											<c:when test="<%= Validator.isNotNull(imgStr) %>">
												<img alt="" src="<%= imgStr %>" />
											</c:when>

											<c:otherwise>
												<liferay-ui:icon image="clip" />
											</c:otherwise>
										</c:choose>
									</a>
									<% } %>
								</c:if>
							</liferay-ui:search-container-column-text>
						</c:if>
					</liferay-ui:search-container-row>

					<liferay-ui:search-iterator />

				</liferay-ui:search-container>
			</div>
		</aui:form>
	</div>
<aui:script use="aui-base,node,aui-io-request">
function escapeHtml(html)
{
    var text = document.createTextNode(html);
    var div = document.createElement('div');
    div.appendChild(text);
    return div.innerHTML;
}

getData(
		"<%= serverURL %>",
		"<%= scopeId %>",
		"<%= coQuanBanHanhId %>",
		"layCoQuanBanHanh",
		"#<portlet:namespace/>nhomVanBanId",
		"#<portlet:namespace/>coQuanBanHanhId"
	);
	getData(
			"<%= serverURL %>",
			"<%= scopeId %>",
			"<%= linhVucVanBanId %>",
			"layLinhVucVanBan",
			"#<portlet:namespace/>nhomVanBanId",
			"#<portlet:namespace/>linhVucVanBanId"
		);
	getData(
			"<%= serverURL %>",
			"<%= scopeId %>",
			"<%= loaiVanBanId %>",
			"layTheLoaiVanBan",
			"#<portlet:namespace/>nhomVanBanId",
			"#<portlet:namespace/>loaiVanBanId"
		);
	var findNhomVanBan = document.getElementById("<portlet:namespace/>nhomVanBanId");
	if (findNhomVanBan == null) return;
	
	A.one("#<portlet:namespace/>nhomVanBanId").on("change", function(){
		
		getData(
			"<%= serverURL %>",
			"<%= scopeId %>",
			"<%= coQuanBanHanhId %>",
			"layCoQuanBanHanh",
			"#<portlet:namespace/>nhomVanBanId",
			"#<portlet:namespace/>coQuanBanHanhId"
		);
		getData(
				"<%= serverURL %>",
				"<%= scopeId %>",
				"<%= linhVucVanBanId %>",
				"layLinhVucVanBan",
				"#<portlet:namespace/>nhomVanBanId",
				"#<portlet:namespace/>linhVucVanBanId"
			);
		getData(
				"<%= serverURL %>",
				"<%= scopeId %>",
				"<%= loaiVanBanId %>",
				"layTheLoaiVanBan",
				"#<portlet:namespace/>nhomVanBanId",
				"#<portlet:namespace/>loaiVanBanId"
			);
	})	;	
										
										function getData(url, groupId, currentData, useMethod, selectFromId, selectToIdChange) {
											var id01 = selectFromId.split("#");
											var id02 = selectToIdChange.split("#");
											if (id01 == null || id02 == null) return;
											var se1 = document.getElementById(id01[1]);
											var se2 = document.getElementById(id02[1]);
											
											if (se1 == null || se2 == null) return;
											var value = A.one(selectFromId).val();
// 											console.log("value = " + value);
											var nhom = A.one(selectToIdChange);
											console.log("nhom");
											if (value != "") {
												A.io.request(url, {
													 method: 'post',
										              dataType: 'json',
										              data: {
										            	<portlet:namespace/>id: value,
										            	<portlet:namespace/>method: useMethod,
										            	<portlet:namespace/>groupId: groupId
										              },
														on: {
															success: function(data){
																nhom.empty();
// 																console.log(data);
																
																data = this.get("responseData");
																if (data == null || (data != null && data.length == 0)) return;
																var nhomVanBanId = currentData;
																nhom.append("<option value='0'></option>");
																 for(var i = 0; i < data.length; i++) {
																	 var selected = "";
																	 if (nhomVanBanId == data[i].id) selected = " selected ";
																	var op = "<option value='"+ data[i].id +"' +"+ selected +">" + escapeHtml(data[i].name) + "</option>";
																	nhom.append(op);
// 																	console.log(op);
																 }
															},
															error: function(){
																alert("error");
															}
														}
													});
											}
											
										}
</aui:script>

</c:if>
