<%@page import="com.viettel.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.viettel.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil"%>
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
	LiferayPortletURL viewFullContentURL = 
			PortletURLFactoryUtil.create(request, "4_WAR_vietteldocumentportlet", layout.getPlid(), PortletRequest.RENDER_PHASE);
	viewFullContentURL.setParameter("mvcPath", "/html/portlet/list/view_detail.jsp");
	
%>

<liferay-portlet:renderURL var="viewMoreURL"/>
<div class="vbpq-list2-wrapper">
	<div class="vbpq-list2-ct-other">
		<c:if test="<%=coQuanBanHanhIdPrefsHome != null && coQuanBanHanhIdPrefsHome.length > 0 %>">
			<div class="vbpq-toptabs">
				<ul class="toptabs">
				<%
					for(int i = 0; i < coQuanBanHanhIdPrefsHome.length; i++){
						CoQuanBanHanhVanBan coQuanBanHanhVanBan = null;
						try{
							coQuanBanHanhVanBan = CoQuanBanHanhVanBanLocalServiceUtil.getCoQuanBanHanhVanBan(coQuanBanHanhIdPrefsHome[i]);
						}catch(Exception e){
							continue;
						}
						if(coQuanBanHanhVanBan != null){
							%>
								<li class="tab" data='<%="tab"+i%>'><%=HtmlUtil.escape(coQuanBanHanhVanBan.getTen()) %></li>
							<%
						}
					}
				%>
				</ul>
			</div>
			<%
				for(int i = 0; i < coQuanBanHanhIdPrefsHome.length; i++){
					String id = "tab" + i;
					String style = "display: none";
					if(i == 0){
						style = "display: block";
					}
					%>
						<ul id="<%=id%>" style="<%=style%>" class="tabcontent">
							<%
								List<VanBanPhapQuy> lsLastestVanBan = null;
								try{
									lsLastestVanBan = VanBanPhapQuyLocalServiceUtil.findByG_CQBH_S(scopeId, coQuanBanHanhIdPrefsHome[i], VanBanPhapQuyConstants.STATUS_PUBLISH, 0, numberVbpqDisplay);
								}catch(Exception e){
									continue;
								}
								if(lsLastestVanBan != null){
									int count = 0;
									for(VanBanPhapQuy vanban : lsLastestVanBan){
										%>
											<liferay-portlet:renderURL var="viewDetailURL" portletName="<%= WebKeys.VBPQ_PORTLET_NAME%>">
												<portlet:param name="mvcPath" value="/html/portlet/list/view_detail.jsp"/>
												<portlet:param name="id" value="<%= String.valueOf(vanban.getId()) %>"/>
												<portlet:param name="redirect" value="<%= redirect %>"/>
											</liferay-portlet:renderURL>
										<%
										
										if(count == 0){
											%>
												<li class="lst2-normal-firstChild">
													<a href="<%=viewDetailURL%>">
														<span class="text"><%=HtmlUtil.escape(vanban.getTrichYeu())%></span>
													</a>
												</li>
											<%
										}else{
											%>
												<li class="lst2-normal"><a href="<%=viewDetailURL%>"><span
													class="text"><%=HtmlUtil.escape(vanban.getTrichYeu())%></span></a></li>
											<%
										}
										count++;
									}
								}
							%>
						</ul>
					<%
				}
			%>
		</c:if>
	</div>
</div>

<aui:script>
	AUI().ready(function(A){
		var tabs = A.all('.tab');
		if(tabs){
			tabs.each(function(node){
				var data = node.attr('data');
				node.on('click', function(){
					var contents = A.all('.tabcontent');
					if(contents){
						contents.each(function(tabcontent){
							tabcontent.hide();
						});
					}
					var content = A.one('#' + data).show();
				});
			});
		}
	});
</aui:script>


