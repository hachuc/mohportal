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
<%@page import="com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.NhomVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.LoaiVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.LinhVucVanBan"%>
<%@page import="com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LoaiVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@ include file="init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<%
VanBanSearch searchContainer = (VanBanSearch)request.getAttribute("liferay-ui:search:searchContainer");

VanBanDisplayTerms displayTerms = (VanBanDisplayTerms)searchContainer.getDisplayTerms();

List<Group> sites = VanBanPhapQuyUtils.getSiteAvailables(themeDisplay);
String keyword = ParamUtil.getString(request, "keyword");

Calendar startCalendar = Calendar.getInstance();
if(displayTerms.getStartDateObj() != null) {
	startCalendar.setTime(displayTerms.getStartDateObj());
}

Calendar endCalendar = Calendar.getInstance();
if(displayTerms.getEndDateObj() != null) {
	endCalendar.setTime(displayTerms.getEndDateObj());
}

List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByTrangThai(displayTerms.getGroupId(), true, -1, -1);
List<LinhVucVanBan> lsLinhVuc = LinhVucVanBanBusiness.getByTrangThai(displayTerms.getGroupId(), true, -1, -1);
List<LoaiVanBan> lsLoaiVanBan = LoaiVanBanBusiness.getByTrangThai(displayTerms.getGroupId(), true, -1, -1);
String nhom = portletPreferences.getValue("nhomVanBanId", "");
String[] nhomVanBanIds = new String[0];
long coQuanBanHanhId = ParamUtil.getLong(request, "coQuanBanHanhId", 0);
long loaiVanBanId = ParamUtil.getLong(request, "loaiVanBanId", 0);
long linhVucVanBanId = ParamUtil.getLong(request, "linhVucVanBanId", 0);
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

%>
<portlet:resourceURL var="serverURL"></portlet:resourceURL>
<div class="vbpq-search-box">
	<aui:fieldset class="search-form-vbpq">
		<aui:row>
			<aui:col width="33">
				<aui:fieldset>
					<aui:select name="nhomVanBanId" label="nhom-van-ban" cssClass="vbpq_input_select span12" showEmptyOption="<%= true %>">
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
				</aui:fieldset>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="<%= 33 %>">
				<aui:fieldset>
					<aui:select name="loaiVanBanId" label="loai-van-ban" cssClass="vbpq_input_select span12" showEmptyOption="<%= true %>">
					</aui:select>
				</aui:fieldset>
			</aui:col>
	
			<aui:col width="<%= 33 %>">
				<aui:fieldset>
					<aui:select name="coQuanBanHanhId" label="co-quan-ban-hanh" cssClass="vbpq_input_select span12" showEmptyOption="<%= true %>">
					</aui:select>
				</aui:fieldset>
			</aui:col>
	
			<aui:col width="<%= 33 %>">
				<aui:fieldset>
					<aui:select name="linhVucVanBanId" label="linh-vuc-van-ban" cssClass="vbpq_input_select span12" showEmptyOption="<%= true %>">
					</aui:select>
				</aui:fieldset>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 33 %>">
				<aui:fieldset>
					<aui:select name="<%= displayTerms.STATUS %>" 
						cssClass="vbpq_input_select span12"
						showEmptyOption="<%= true %>">
						
							<aui:option value="<%= VanBanPhapQuyConstants.STATUS_PUBLISH %>" label="da-dang"
								selected="<%= VanBanPhapQuyConstants.STATUS_PUBLISH == displayTerms.getStatus() %>" />
								
							<aui:option value="<%= VanBanPhapQuyConstants.STATUS_DRAFT %>" label="chua-dang"
								selected="<%= VanBanPhapQuyConstants.STATUS_DRAFT == displayTerms.getStatus() %>" />
						
					</aui:select>
				</aui:fieldset>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:field-wrapper label="tao-tu-ngay">
					<liferay-ui:input-date
						dayValue="<%= startCalendar.get(Calendar.DATE) %>"
						dayParam='<%= displayTerms.START_DATE + "Day" %>'
						disabled="<%= false %>"
						firstDayOfWeek="<%= startCalendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%= startCalendar.get(Calendar.MONTH) %>"
						monthParam='<%= displayTerms.START_DATE + "Month" %>'
						yearValue="<%= startCalendar.get(Calendar.YEAR) %>"
						yearParam='<%= displayTerms.START_DATE + "Year" %>'
						name="<%= displayTerms.START_DATE %>"
					/>
				</aui:field-wrapper>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:field-wrapper label="ban-hanh-den-ngay">
					<liferay-ui:input-date
						dayValue="<%= endCalendar.get(Calendar.DATE) %>"
						dayParam='<%= displayTerms.END_DATE + "Day" %>'
						disabled="<%= false %>"
						firstDayOfWeek="<%= endCalendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%= endCalendar.get(Calendar.MONTH) %>"
						monthParam='<%= displayTerms.END_DATE + "Month" %>'
						yearValue="<%= endCalendar.get(Calendar.YEAR) %>"
						yearParam='<%= displayTerms.END_DATE + "Year" %>'
						name="<%= displayTerms.END_DATE %>"
					/>
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<c:if test="<%= permissionChecker.isCompanyAdmin() && AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_THONGKE_SITE) %>">
				<aui:col width="<%= 33 %>">
					<aui:select name="<%= displayTerms.GROUP_ID %>" label="site" cssClass="vbpq_input_select span12" showEmptyOption="<%= true %>">
						<% 
						for(Group site : sites) {
						%>
							<aui:option value="<%= site.getGroupId() %>" selected="<%= site.getGroupId() == displayTerms.getGroupId() %>"><%= HtmlUtil.escape( site.getName() )%></aui:option>
						<% } %>
					</aui:select>
				</aui:col>
			</c:if>
			
			<aui:col width="<%= 33 %>">
				<aui:fieldset>
					<aui:input name="keyword" type="text" cssClass="vbpq_input_text span12" label="keyword" value="<%= keyword %>" />
				</aui:fieldset>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
					<div class="mt25">
						<aui:button-row>
							<aui:button type="submit" value="search" cssClass="search_button"/>
						</aui:button-row>

					</div>
			</aui:col>
		</aui:row>
	</aui:fieldset>
</div>
<aui:script use="aui-base,node,aui-io-request">
function escapeHtml(html)
{
    var text = document.createTextNode(html);
    var div = document.createElement('div');
    div.appendChild(text);
    return div.innerHTML;
};
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
											//console.log("thay doi nhom van ban");
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
											if (value != "") {
												A.io.request(url, {
													 method: 'post',
										              dataType: 'json',
										              data: {
										            	<portlet:namespace/>idNhom: value,
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