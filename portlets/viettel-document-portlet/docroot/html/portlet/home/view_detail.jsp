<%@page import="com.liferay.portal.kernel.util.FileUtil"%>
<%@page import="com.viettel.portal.vbpq.service.AttachFileLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.AttachFile"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyUtils"%>
<%@page import="com.viettel.portal.vbpq.model.VanBanPhapQuy"%>
<%@page import="com.viettel.portal.vbpq.admin.business.VanBanPhapQuyBusiness"%>
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

<%@ include file="/init.jsp" %>

<%
	long vanbanId = ParamUtil.getLong(request, "id");
	VanBanPhapQuy vanban = VanBanPhapQuyBusiness.getVanBan(vanbanId);
	List<AttachFile> lsFile = new ArrayList<AttachFile>(); 
	if (Validator.isNotNull(lsFile)) {
		lsFile = AttachFileLocalServiceUtil.getAttachByVanBan(vanban.getId());
	}
	List<VanBanPhapQuy> lsLastestVanBan = VanBanPhapQuyBusiness.findByGroupId(scopeGroupId, 0, 11);
%>

<c:choose>
	<c:when test="<%= Validator.isNotNull(vanban) %>">
		<div class="vbpq-display-portlet ">
			<h1 class="portlet-title">
				<span>
					<img src="/viettel-document-portlet/images/vbpq_category_portlet_icon.png"/>
				</span>
				<span class="portlet-title-text">	
					<liferay-ui:message key="van-ban-phap-quy"></liferay-ui:message>
				</span>
			</h1>
		</div>
		<div class="row mt10">
			<div class="col-md-12">
				<h4 class="text-bold"><%=HtmlUtil.escape( vanban.getTrichYeu() )%></h4> 
				<div class="vbpq-detail mt10">
					<div class="table-responsive ">
						<table style="width: 100%;" class="table table-bordered table-doc-col">
							<tr>
								<td class="vbpq-detail-col1 text-bold">
									<liferay-ui:message key="ma-van-ban"/>
								</td>
								<td><%= HtmlUtil.escape( vanban.getMaVanBan() )%></td>
							</tr>
							<tr>
								<td class="vbpq-detail-col1 text-bold">
									<liferay-ui:message key="ngay-ban-hanh"/>
								</td>
								<td><%= dateFormatDate.format(vanban.getNgayBanHanh()) %></td>
							</tr>
							<tr>
								<td class="vbpq-detail-col1 text-bold">
									<liferay-ui:message key="ngay-co-hieu-luc"/>
								</td>
								<td><%= dateFormatDate.format(vanban.getNgayCoHieuLuc()) %></td>
							</tr>
							<tr>
								<td class="vbpq-detail-col1 text-bold">
									<liferay-ui:message key="nguoi-ky"/>
								</td>
								<td><%= HtmlUtil.escape(vanban.getNguoiKy()) %></td>
							</tr>
							<tr>
								<td class="vbpq-detail-col1 text-bold">
									<liferay-ui:message key="trich-yeu"/>
								</td>
								<td><%= HtmlUtil.escape(vanban.getTrichYeu()) %></td>
							</tr>
							
							<tr>
								<td class="vbpq-detail-col1 text-bold">
									<liferay-ui:message key="co-quan-ban-hanh"/>
								</td>
								<td><%=HtmlUtil.escape( VanBanPhapQuyUtils.getCoQuanBanHanh(vanban)) %></td>
							</tr>
				
							<tr>
								<td class="vbpq-detail-col1 text-bold">
									<liferay-ui:message key="loai-van-ban"/>
								</td>
								<td><%= HtmlUtil.escape(VanBanPhapQuyUtils.getLoaiVanBan(vanban)) %></td>
							</tr>
						</table>
					</div>
				</div>
				<c:if test="<%= lsFile.size() != 0 %>">
					<div class="vbpq-attachfile">
						<div class="vbpq-tldk">
							<liferay-ui:message key="file-dinh-kem"/>
						</div>
						<table>
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
							<tr>
								<td style="padding-right: 5px;">
									<a href="<%= atf.getFileLink() %>">
										<c:choose>
											<c:when test="<%= Validator.isNotNull(imgStr) %>">
												<img alt="" src="<%= imgStr %>" />
											</c:when>
											
											<c:otherwise>
												<liferay-ui:icon image="clip"/>
											</c:otherwise>
										</c:choose>
									</a>
								</td>
								
								<td>
									<a href="<%= atf.getFileLink() %>"><%= HtmlUtil.escape(atf.getFileName() )%></a>
								</td>
							</tr>
							
							<%
								}
							%>
						</table>
					</div>
				</c:if>
			</div>
		</div>
		
		<c:if test="<%= lsLastestVanBan.size() > 1 %>">
			<div class="row mt10">
				<div class="col-md-12">
					<div class="vbpq-tldk text-bold">
						<liferay-ui:message key="van-ban-khac"/>
					</div>
					
					<div class="list-orther-documents mt10">
						<ul>
							<% 
								for (VanBanPhapQuy vb : lsLastestVanBan) {
									if (vb.getId() != vanbanId) {
							%>
									<portlet:renderURL var="rowURL">
										<portlet:param name="mvcPath" value='<%= templatePath + "view_detail.jsp" %>' />
										<portlet:param name="id" value="<%=String.valueOf(vb.getId()) %>"/>
									</portlet:renderURL>
									
									<li> <a href="<%= rowURL %>"><%= HtmlUtil.escape(vb.getTrichYeu()) %> </a> <span> (<%= dateFormatDate.format(vb.getNgayBanHanh()) %>)</span></li>
							<%
									}
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</c:if>
		<div class="row mt10">
			<div class="col-md-12 text-bold">
				<a href="javascript:history.go(-1)"><liferay-ui:message key="back"/></a>
			</div>
		</div>
		
	</c:when>

	<c:otherwise>
		<div class="vbpq-display-portlet ">
			<h1 class="portlet-title">
				<span>
					<img src="/viettel-document-portlet/images/vbpq_category_portlet_icon.png"/>
				</span>
				<span class="portlet-title-text">
					<liferay-ui:message key="van-ban-phap-quy-khong-ton-tai"/>
				</span>
			</h1>
			<div class="row mt10">
				<div class="col-md-12 text-bold">
					 <a href="javascript:history.go(-1)">&nbsp;&larr; <liferay-ui:message key="back"/></a>
				</div>		
			</div>	
		</div>
	</c:otherwise>
</c:choose>




