
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

<%@page import="com.revotech.portal.vbpq.service.AttachFileLocalServiceUtil"%>
<%@page import="com.revotech.portal.vbpq.model.AttachFile"%>
<%@page import="com.revotech.portal.vbpq.util.VanBanPhapQuyUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.revotech.portal.vbpq.admin.business.VanBanPhapQuyBusiness"%>
<%@page import="com.revotech.portal.vbpq.model.VanBanPhapQuy"%>
<%@page import="com.revotech.portal.vbpq.util.VanBanPhapQuyConstants"%>
<%@page import="com.revotech.portal.vbpq.util.WebKeys"%>
<%@ include file="/init.jsp" %>

<%
	List<VanBanPhapQuy> lsLastestVanBan = VanBanPhapQuyBusiness.findByGroupId(scopeId, 0, numberVbpqDisplay);

	LiferayPortletURL viewFullContentURL = 
			PortletURLFactoryUtil.create(request, WebKeys.VBPQ_PORTLET_NAME, layout.getPlid(), PortletRequest.RENDER_PHASE);
	viewFullContentURL.setParameter("mvcPath", "/html/portlet/list/view_detail.jsp");
	List<AttachFile> lsFile = new ArrayList<AttachFile>(); 
	
%>

<liferay-portlet:renderURL var="viewMoreURL">
</liferay-portlet:renderURL>

<div class="vanban">
	<h5 class="tlecmh5">
		<a class="hdCM" href="<%= viewMoreURL%>">
			<i class="tlecm"></i><liferay-ui:message key="van-ban"/>
		</a>
	</h5>
	
	<table class="tablelist-style5">
		<tbody>
			<tr>
				<th align="left" class="vbpq-table-header col1">STT</th>
				<th align="left" class="vbpq-table-header col2"><liferay-ui:message key="so-ky-hieu"/></th>
				<th align="left" class="vbpq-table-header col3"><liferay-ui:message key="trich-yeu"/></th>
				<th align="left" class="vbpq-table-header col4"><liferay-ui:message key="ngay-ban-hanh"/></th>
				<th align="left" class="vbpq-table-header col5"> <liferay-ui:message key="tinh-trang"/></th>
				<th class="vbpq-table-header col6">&nbsp</th>
			</tr>
				<%
					for(VanBanPhapQuy vanban : lsLastestVanBan)
					{
				%>
					<liferay-portlet:renderURL var="viewDetailURL" portletName="<%= WebKeys.VBPQ_PORTLET_NAME%>">
						<portlet:param name="mvcPath" value="/html/portlet/list/view_detail.jsp"/>
						<portlet:param name="id" value="<%= String.valueOf(vanban.getId()) %>"/>
						<portlet:param name="redirect" value="<%= redirect %>"/>
					</liferay-portlet:renderURL>
					<tr>
						<td align="left">
							<%=lsLastestVanBan.indexOf(vanban) + 1 %>
						</td>
						<td align="left">
							<a href="<%= viewDetailURL %>">
								<%=HtmlUtil.escape( vanban.getMaVanBan()) %>
							</a>
						</td>
						
						<td class="link_vanban" align="left">
							<a href="<%= viewDetailURL %>">
								<%=HtmlUtil.escape( vanban.getTrichYeu()) %>
							</a>
								<%
									if (Validator.isNotNull(lsFile)) {
										try {
										lsFile = AttachFileLocalServiceUtil.getAttachByVanBan(vanban.getId());
										} catch (Exception e) {
											
										}
									}

									for (AttachFile atf : lsFile)
									{
										String imgStr = "/portal-vbpq-portlet/images/" + VanBanPhapQuyUtils.getExtensionFile(atf.getFileName()) + ".png";
								%>
								<div class="vb_file">
									<div class="vb_file_img"><img alt="" src="<%= imgStr %>"></div>
									<div class="vb_file_link"><a href="<%= atf.getFileLink() %>"><%= atf.getFileName() %></a></div>
									<div style="clear: both;"></div>
								</div> 
								
								<%
									}
								%>
										
						</td>
						<td align="left">
							<a href="<%= viewDetailURL %>">
								<%= dateFormatDate.format(vanban.getNgayBanHanh()) %>
							</a>
						</td>
						
						<td>
							<a href="<%= viewDetailURL %>">
								<liferay-ui:message key="con-hieu-luc"/>
							</a>
						</td>
						
						<td>
							<span class="vbpq_download">
								<i class="fa fa-download" aria-hidden="true"></i>
							</span>
						</td>
					</tr>
				<%
					}
				%>
		</tbody>
	</table>
</div>

