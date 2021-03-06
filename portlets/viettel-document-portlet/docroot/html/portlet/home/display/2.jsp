<%@page import="com.viettel.portal.vbpq.util.WebKeys"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyConstants"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.viettel.portal.vbpq.admin.business.VanBanPhapQuyBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.VanBanPhapQuy"%>
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
	List<VanBanPhapQuy> lsLastestVanBan = VanBanPhapQuyBusiness.findByGroupId(scopeId, 0, numberVbpqDisplay);
	LiferayPortletURL viewFullContentURL =
			PortletURLFactoryUtil.create(request, "4_WAR_vietteldocumentportlet", layout.getPlid(), PortletRequest.RENDER_PHASE);
	viewFullContentURL.setParameter("mvcPath", "/html/portlet/list/view_detail.jsp");

%>

<liferay-portlet:renderURL var="viewMoreURL">
</liferay-portlet:renderURL>
<div class="box-container" id="a09">
	<div class="box-content-08">
		<div class="title">
			<div>
			<c:choose>
				<c:when test="<%=Validator.isNotNull(linkedLayoutURL)%>">
					<a href="<%=linkedLayoutURL%>"
						title="<%=HtmlUtil.escape(titleDisplay)%>"><%=HtmlUtil.escape(titleDisplay)%></a>
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0);"><%=HtmlUtil.escape(titleDisplay)%></a>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
		<div class="content">
			<div class="list">
				<ul>
				    <%
					int count =0;

					for(VanBanPhapQuy vanban : lsLastestVanBan)
					{
				%>
						<liferay-portlet:renderURL var="viewDetailURL" portletName="<%= WebKeys.VBPQ_PORTLET_NAME%>">
						<portlet:param name="mvcPath" value="/html/portlet/list/view_detail.jsp"/>
						<portlet:param name="id" value="<%= String.valueOf(vanban.getId()) %>"/>
						<portlet:param name="redirect" value="<%= redirect %>"/>
					</liferay-portlet:renderURL>
				<li><a href="<%=viewDetailURL%>"><%=HtmlUtil.escape(vanban.getTrichYeu())%></a></li>
				<%
				}
				%>
				</ul>
			</div>
		</div>
	</div>
</div>