<%@page import="com.revotech.portal.vbpq.service.LoaiVanBanLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.service.LinhVucVanBanLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil"%>
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
<%@ include file="init.jsp" %>

<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.revotech.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.revotech.portal.vbpq.model.NhomVanBan"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.revotech.portal.vbpq.util.VanBanPhapQuyConstants"%>
<%@page import="com.revotech.portal.vbpq.service.AttachFileLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.model.AttachFile"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.revotech.portal.vbpq.admin.business.LoaiVanBanBusiness"%>
<%@page import="com.revotech.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryPos"%>
<%@page import="com.revotech.portal.vbpq.model.LoaiVanBan"%>
<%@page import="com.revotech.portal.vbpq.model.LinhVucVanBan"%>
<%@page import="com.revotech.portal.vbpq.admin.action.CoQuanBanHanhAction"%>
<%@page import="com.revotech.portal.vbpq.terms.VanBanPhapQuyTerms"%>
<%@page import="com.revotech.portal.vbpq.admin.business.VanBanPhapQuyBusiness"%>
<%@page import="com.revotech.portal.vbpq.model.VanBanPhapQuy"%>
<%@page import="com.revotech.portal.vbpq.terms.CoQuanBanHanhTerms"%>
<%@page import="com.revotech.portal.vbpq.util.MessageErrors"%>
<%@page import="com.revotech.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@page import="com.revotech.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.revotech.portal.vbpq.permission.AdminPermission"%>

<liferay-util:include page='<%= templatePath + "top_tabs.jsp" %>' servletContext="<%= application %>" />

<%
	long id = ParamUtil.getLong(request, "id");
	VanBanPhapQuy vanban = VanBanPhapQuyBusiness.getVanBan(id);
	
	boolean neverExpire = true;
	
	if (Validator.isNotNull(vanban)) {
		neverExpire = vanban.getNgayHetHieuLuc() != null ? false : true;
	}

	List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByTrangThai(scopeGroupId, true, -1, -1);
	List<LinhVucVanBan> lsLinhVuc = LinhVucVanBanBusiness.getByTrangThai(scopeGroupId, true, -1, -1);
	List<LoaiVanBan> lsLoaiVanBan = LoaiVanBanBusiness.getByTrangThai(scopeGroupId, true, -1, -1);
	
	List<DLFolder> folders = DLFolderLocalServiceUtil.getFolders(scopeGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	
	List<AttachFile> vanBanAttachFiles = null;
	
	if(vanban != null) {
		vanBanAttachFiles = VanBanPhapQuyBusiness.getAttachFiles(vanban.getId());
	}
	
	long vanBanFolderId = VanBanPhapQuyUtils.getFolderId(themeDisplay.getUserId(), scopeGroupId);
	
	int status = VanBanPhapQuyConstants.STATUS_DRAFT;
	
	if(vanban != null) {
		status = vanban.getStatus();
	}
%>


<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (vanban == null) ? "them-moi-van-ban" : "sua-van-ban" %>'
/>

<portlet:actionURL name="updateVanBanPhapQuy" var="updateVanBanPhapQuyURL"/>

<aui:form cssClass="vbpq-form" action="<%= updateVanBanPhapQuyURL %>" method="post" name="fm" enctype="multipart/form-data">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Validator.isNotNull(vanban) ? Constants.UPDATE : Constants.ADD %>"/>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= currentURL %>" />
	<aui:input name="id" type="hidden" value="<%= id %>" />
	<aui:input name="vanBanFolderId" type="hidden" value="<%= vanBanFolderId %>" />
	<aui:input name="status" type="hidden" value="<%= status %>" />
	
	<liferay-ui:error key="<%= MessageErrors.EMPTY_NGUOI_KY %>" message="<%= MessageErrors.EMPTY_NGUOI_KY %>" />
	<liferay-ui:error key="<%= MessageErrors.EMPTY_TEN_VAN_BAN %>" message="<%= MessageErrors.EMPTY_TEN_VAN_BAN %>" />
	<liferay-ui:error key="<%= MessageErrors.EMPTY_TRICH_YEU %>" message="<%= MessageErrors.EMPTY_TRICH_YEU %>" />
	<liferay-ui:error key="<%= MessageErrors.UNCHECK_LOAI_VAN_BAN %>" message="<%= MessageErrors.UNCHECK_LOAI_VAN_BAN %>" />
	<liferay-ui:error key="<%= MessageErrors.UNCHECK_LINH_VUC_VAN_BAN %>" message="<%= MessageErrors.UNCHECK_LINH_VUC_VAN_BAN %>" />
	<liferay-ui:error key="<%= MessageErrors.UNCHECK_CO_QUAN_BAN_HANH %>" message="<%= MessageErrors.UNCHECK_CO_QUAN_BAN_HANH %>" />


	<liferay-ui:error key="<%= MessageErrors.DuplicateFile %>" message="<%= MessageErrors.DuplicateFile %>" />
	
	
	
	<aui:fieldset>
		<aui:model-context bean="<%= vanban %>" model="<%= VanBanPhapQuy.class %>" />
		
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:input name="<%= VanBanPhapQuyTerms.MA_VAN_BAN %>" autoFocus="<%= true %>" type="text" cssClass="span12">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:input name="trichYeu" type="textarea" cssClass="trich-yeu span12" style='<%= "height: " + ModelHintsConstants.TEXTAREA_DISPLAY_HEIGHT + "px;" %>'/>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 33 %>">
			<aui:select name="nhomVanBanId" label="Nhóm văn bản" showEmptyOption="true" required="true">
				<%
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(NhomVanBan.class);
					dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getScopeGroupId()));
					dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", WorkflowConstants.STATUS_APPROVED));
					List<NhomVanBan> ls = NhomVanBanLocalServiceUtil.dynamicQuery(dynamicQuery);
					for (NhomVanBan nv : ls) {
						boolean selected = false;
						if (vanban != null) {
							if (vanban.getNhomVanBanId() == nv.getId()) selected = true;
						}
				%>
				<aui:option value="<%= String.valueOf(nv.getId()) %>" label="<%= HtmlUtil.escape(nv.getTenNhom())  %>" selected="<%= selected %>"></aui:option>
				<% } %>
			</aui:select>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 33 %>">
				<aui:select name="coQuanBanHanh" showEmptyOption="<%= true %>" required="<%= true %>">
					<%
						if (Validator.isNotNull(vanban)){
							List<CoQuanBanHanhVanBan> coQuanBanHanhVanBans = CoQuanBanHanhVanBanLocalServiceUtil.findByNhomVanBanId(vanban.getNhomVanBanId());
							for(int i =0 ; i < coQuanBanHanhVanBans.size() ; i++){
								CoQuanBanHanhVanBan coQuanBanHanhVanBan = coQuanBanHanhVanBans.get(i);
								if(coQuanBanHanhVanBan.getId() == vanban.getCoQuanBanHanh()){
									%>
									<aui:option value="<%=coQuanBanHanhVanBan.getId() %>" label="<%= HtmlUtil.escape(coQuanBanHanhVanBan.getTen()) %>" selected="<%=true %>"/>
									<%
								}
								else{
									%>
									<aui:option value="<%=coQuanBanHanhVanBan.getId() %>" label="<%= HtmlUtil.escape(coQuanBanHanhVanBan.getTen()) %>" />
									<%
								}
							}
						}
					%>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:select name="linhVucVanBan" showEmptyOption="<%= true %>" required="<%= true %>">
					<%
					if (Validator.isNotNull(vanban)){
						List<LinhVucVanBan> linhVucVanBans = LinhVucVanBanLocalServiceUtil.findByNhomVanBanId(vanban.getNhomVanBanId());
						for(int i =0 ; i < linhVucVanBans.size() ; i++){
							LinhVucVanBan linhVucVanBan = linhVucVanBans.get(i);
							if(linhVucVanBan.getId() == vanban.getLinhVucVanBan()){
								%>
								<aui:option value="<%=linhVucVanBan.getId() %>" label="<%= HtmlUtil.escape(linhVucVanBan.getTen()) %>" selected="<%=true %>"/>
								<%
							}
							else{
								%>
								<aui:option value="<%=linhVucVanBan.getId() %>" label="<%= HtmlUtil.escape(linhVucVanBan.getTen()) %>" />
								<%
							}
						}
					}
					
					%>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:select name="loaiVanBan" showEmptyOption="<%= true %>" required="<%= true %>">
					<%
					if (Validator.isNotNull(vanban)){
						List<LoaiVanBan> loaiVanBans = LoaiVanBanLocalServiceUtil.findByNhomVanBanId(vanban.getNhomVanBanId());
						for(int i = 0 ; i < loaiVanBans.size() ; i++){
							LoaiVanBan loaiVanBan = loaiVanBans.get(i);
							if(loaiVanBan.getId() == vanban.getLoaiVanBan()){
								%>
								<aui:option value="<%=loaiVanBan.getId() %>" label="<%= HtmlUtil.escape(loaiVanBan.getTen()) %>" selected="<%=true %>"/>
								<%
							}
							else{
								%>
								<aui:option value="<%=loaiVanBan.getId() %>" label="<%= HtmlUtil.escape(loaiVanBan.getTen()) %>" />
								<%
							}
						}
					}
					%>
				</aui:select>
			</aui:col>
		</aui:row>
		
		
		
		<aui:row>
			<aui:col width="<%= 33 %>">
				<aui:input name="ngayBanHanh" />
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:input name="ngayCoHieuLuc" />
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:input name="ngayHetHieuLuc" dateTogglerCheckboxLabel="never-expire" disabled="<%= neverExpire %>" formName="fm" />
			</aui:col>
			
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 66 %>">
				<aui:field-wrapper >
					<aui:input autoFocus="<%= true %>"  name="vanBanFile" multiple="<%=true %>" onChange='<%= renderResponse.getNamespace() + "validateTitle();" %>' style="width: auto;" type="file">
						<aui:validator name="acceptFiles">
						'<%= ".doc, .pdf, .docx,.rar,.zip" %>'
						</aui:validator>
					</aui:input>
					
					<c:if test="<%= vanBanAttachFiles != null %>">
					<span>chọn để xóa file  </span>
						<ul class="vanBanAttachFiles" >
							<% for(AttachFile attachFile : vanBanAttachFiles) { %>
							<li>
								<input type="checkbox" name="deleteAttachFileIds" value="<%= attachFile.getId() %>"/>
								
								<a href="<%= attachFile.getFileLink() %>">
									<c:if test="<%= attachFile.getId() > 0 %>">
										<%= HtmlUtil.escape(attachFile.getFileName()) %> (<%= GetterUtil.getLong(attachFile.getFileSize()) / 1024 %> KB)
									</c:if>
									
									<c:if test="<%= attachFile.getId() == 0 %>">
										<%= HtmlUtil.escape(attachFile.getFileLink()) %>
									</c:if>
									
								</a>
							</li>
							<% } %>
						</ul>
					</c:if>
				</aui:field-wrapper>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:input name="nguoiKy" type="text" cssClass="nguoi-ky span12"/>
			</aui:col>
		</aui:row>

		<aui:button-row>
			<aui:button type="submit" value="save"/>
			
			<%
			boolean publishPermission = status != VanBanPhapQuyConstants.STATUS_PUBLISH 
				&& AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PUBLISH_VANBAN);
			%>
		
			<c:if test="<%= publishPermission %>">
				<aui:button value="luu-va-dang" onClick='<%=renderResponse.getNamespace() + "updateStatusVanBan();" %>'/>
			</c:if>
			
			<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script>
	function <portlet:namespace />updateVanBan() {
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateVanBanPhapQuy"/>');
	}
	
	function <portlet:namespace />validateTitle() {
		Liferay.Form.get('<portlet:namespace />fm').formValidator.validateField('<portlet:namespace />title');
	}
	
	function <portlet:namespace />updateStatusVanBan() {
		document.<portlet:namespace />fm.<portlet:namespace />status.value = <%= VanBanPhapQuyConstants.STATUS_PUBLISH %>;
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateVanBanPhapQuy"/>');
	}
</aui:script>

<portlet:resourceURL var="serverURL"></portlet:resourceURL>

<aui:script use="aui-base,node,aui-io-request">
function htmlEncode( html ) {
    return document.createElement( 'a' ).appendChild( 
        document.createTextNode( html ) ).parentNode.innerHTML;
};
	var A = AUI();

	var findNhomVanBan = document.getElementById("<portlet:namespace/>nhomVanBanId");
	if (findNhomVanBan == null) return;
	
	A.one("#<portlet:namespace/>nhomVanBanId").on("change", function(){
		getData(
				"<%= serverURL %>",
				"<%= scopeId %>",
				"0",
				"layCoQuanBanHanh",
				"#<portlet:namespace/>nhomVanBanId",
				"#<portlet:namespace/>coQuanBanHanh"
			);
		getData(
				"<%= serverURL %>",
				"<%= scopeId %>",
				"0",
				"layLinhVucVanBan",
				"#<portlet:namespace/>nhomVanBanId",
				"#<portlet:namespace/>linhVucVanBan"
			);
		getData(
				"<%= serverURL %>",
				"<%= scopeId %>",
				"0",
				"layTheLoaiVanBan",
				"#<portlet:namespace/>nhomVanBanId",
				"#<portlet:namespace/>loaiVanBan"
			);
	});	
	
	function getData(url, groupId, currentData, useMethod, selectFromId, selectToIdChange) {
		var id01 = selectFromId.split("#");
		var id02 = selectToIdChange.split("#");
		if (id01 == null || id02 == null) return;
		var se1 = document.getElementById(id01[1]);
		var se2 = document.getElementById(id02[1]);
		
		if (se1 == null || se2 == null) {
			return;
		}
		var checkValue = A.one(selectFromId).val();
		if (!checkValue) {
			A.one(selectToIdChange).empty();
			A.one(selectToIdChange).append("<option></option>")
			return;
		}
		var value = A.one(selectFromId).val();
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
							data = this.get("responseData");
							if (data == null || (data != null && data.length == 0)) return;
							var nhomVanBanId = currentData;
							nhom.append("<option value='0'></option>");
							 for(var i = 0; i < data.length; i++) {
								 var selected = "";
								 if (nhomVanBanId == data[i].id) selected = " selected ";
								var op = "<option value='"+ data[i].id +"' +"+ selected +">" + htmlEncode(data[i].name) + "</option>";
								nhom.append(op);
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

<%!
	private static final Log _log = LogFactoryUtil.getLog("html_portlet_admin_edit_vanban_jsp"); 
%>