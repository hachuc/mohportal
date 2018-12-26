<%@page
	import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page
	import="com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.model.LegalDocument"%>
<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@ include file="/html/view/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
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
<style type="text/css">
.aui .tthc-search .breadcrumb:first-child:before {
	display: none;
}

.aui .tthc-search nav a.breadcrumb:before {
	color: #757575;
	font-size: 16px;
}

.aui .tthc-search .breadcrumb:before {
	content: '/';
	color: rgba(255, 255, 255, 0.7);
	vertical-align: top;
	display: inline-block;
	font-weight: normal;
	font-style: normal;
	font-size: 25px;
	margin: 0 10px 0 8px;
	-webkit-font-smoothing: antialiased;
}

.aui .tthc-search nav a.breadcrumb:last-child {
	color: #757575;
}

.aui .tthc-search nav a.breadcrumb {
	color: #757575;
	font-size: 14px;
}
</style>
<%
	String keywords = ParamUtil.getString(request, "keywords");
	long idLinhvuc = ParamUtil.getLong(request, "idLinhvuc", 0L);
	long idCoquanbanhanh = ParamUtil.getLong(request, "idCoquanbanhanh", 0L);

	System.out.println("idlinhvuc:" + idLinhvuc + " -- idcoquan:" + idCoquanbanhanh);
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setParameter("jspPage", "/html/view/level2/view.jsp");
	portletURL.setParameter("keywords", keywords);
	portletURL.setParameter("idLinhvuc", String.valueOf(idLinhvuc));
	portletURL.setParameter("idCoquanbanhanh", String.valueOf(idCoquanbanhanh));

	List<Category> lstLinhVuc = CategoryLocalServiceUtil.getByCategoryType(groupId, 2);

	List<Category> lstCoQuanBanHanh = CategoryLocalServiceUtil.getByCategoryType(groupId, 1);
%>

<liferay-portlet:renderURL varImpl="searchTTHC">
	<portlet:param name="mvcPath" value="/html/view/level2/view.jsp" />
</liferay-portlet:renderURL>

<div class="page-content boxed tthc-search">
	<div class="row">
		<div class="col-md-12 mt30">
			<div class="mag_row">
				<aui:form action="<%=searchTTHC%>" method="post" name="fm"
					cssClass="form-horizontal">
					<liferay-portlet:renderURLParams varImpl="searchTTHC" />
					<liferay-ui:panel-container cssClass="basic-info"
						id="basic-info-container" extended="true">
						<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
							id="basic-info" persistState="<%=true%>"
							title='tra-cuc-dich-vu-cong'>
							<aui:field-wrapper label="">
								<aui:row>
									<aui:col width="<%= 50 %>">
										<select name="<portlet:namespace />idCoquanbanhanh"
											id="<portlet:namespace />idCoquanbanhanh"
											class="form-control">
											<option value="0"><liferay-ui:message
													key='co-quan-ban-hanh' /></option>
											<%
												if (lstCoQuanBanHanh != null) {
																	for (Category cat : lstCoQuanBanHanh) {
											%>
											<c:if test='<%=idCoquanbanhanh == cat.getCategoryId()%>'>
												<option selected="true"
													value="<%=String.valueOf(cat.getCategoryId())%>"><%=HtmlUtil.escape(cat.getCategoryName())%></option>
											</c:if>
											<c:if test='<%=idCoquanbanhanh != cat.getCategoryId()%>'>
												<option value="<%=String.valueOf(cat.getCategoryId())%>"><%=HtmlUtil.escape(cat.getCategoryName())%></option>
											</c:if>
											<%
												}
																}
											%>
										</select>
									</aui:col>
									<aui:col width="<%= 50 %>">
										<select name="<portlet:namespace />idLinhvuc"
											id="<portlet:namespace />idLinhvuc" class="form-control">
											<option value="0"><liferay-ui:message key='linh-vuc' /></option>
											<%
												if (lstLinhVuc != null) {
																	for (Category item : lstLinhVuc) {
											%>
											<c:if test='<%=idLinhvuc == item.getCategoryId()%>'>
												<option selected="true"
													value="<%=String.valueOf(item.getCategoryId())%>"><%=HtmlUtil.escape(item.getCategoryName())%></option>
											</c:if>
											<c:if test='<%=idLinhvuc != item.getCategoryId()%>'>
												<option value="<%=String.valueOf(item.getCategoryId())%>"><%=HtmlUtil.escape(item.getCategoryName())%></option>
											</c:if>
											<%
												}
																}
											%>
										</select>
									</aui:col>
								</aui:row>
								<aui:row>
								<aui:col width="<%= 50 %>">
										<input style="margin-top: 15px;height: 34px;" type="text" class="form-control"
											name="<portlet:namespace />keywords"
											id="<portlet:namespace />keywords"
											placeholder="<liferay-ui:message key='keywords-to-search' />" />
									</aui:col>
									<aui:col width="<%= 50 %>">
										<aui:button name="search" style="margin-top: 15px;" type="submit" value="tthc-search"
											cssClass="btn btn-grey text-bold" />
									</aui:col>
								</aui:row>
							</aui:field-wrapper>
						</liferay-ui:panel>
						<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
							id="basic-info" persistState="<%=true%>"
							title='danh-sach-dich-vu-cong'>
							<aui:field-wrapper label="">
								<div class="tthc-search-table table-responsive pl0 mt20">
									<liferay-ui:search-container delta="20"
										emptyResultsMessage="no-result-were-found"
										iteratorURL="<%=searchTTHC %>">
										<%
											//List<LegalDocument> thuTucHanhChinhs = new ArrayList<LegalDocument>();
																//int totalTTHC = 0;
																List thuTucHanhChinhs = LegalDocumentLocalServiceUtil.findFieldByKeyword(keywords,
																		groupId, idCoquanbanhanh, idLinhvuc, 3, searchContainer.getStart(),
																		searchContainer.getEnd());
																int totalTTHC = LegalDocumentLocalServiceUtil.countByKeyword(keywords, groupId,
																		idCoquanbanhanh, idLinhvuc, 3);
										%>
										<liferay-ui:search-container-results
											results='<%=thuTucHanhChinhs%>' total='<%=totalTTHC%>' />
										<%
											String serilizeString = null;
																JSONArray ttDataJsonArray = null;
										%>
										<liferay-ui:search-container-row className="java.lang.Object"
											modelVar="thuTuc">
											<%
												serilizeString = JSONFactoryUtil.serialize(thuTuc);
																		ttDataJsonArray = JSONFactoryUtil.createJSONArray(serilizeString);
											%>

											<liferay-ui:search-container-column-text name="ma-thu-tuc"
												cssClass="tthc-stt" align="center"
												value="<%=HtmlUtil.escape(ttDataJsonArray.getString(0))%>" />

											<liferay-ui:search-container-column-text
												name="ten-thu-tuc-hanh-chinh" align="center"
												cssClass="tthc-tenthutuc"
												href="<%=HtmlUtil.escape(ttDataJsonArray.getString(2))%>"
												value="<%=HtmlUtil.escape(ttDataJsonArray.getString(1))%>">
											</liferay-ui:search-container-column-text>
											<liferay-ui:search-container-column-text name="muc-do"
												align="center" cssClass="tthc-cqbh">
												<button type="button"
													class="btnmucdo btn btn-success btn-xs btn-kc">3</button>
											</liferay-ui:search-container-column-text>
											<liferay-ui:search-container-column-text name="linh-vuc"
												align="center" cssClass="tthc-linhvuc"
												value="<%=HtmlUtil.escape(ttDataJsonArray.getString(5))%>">
											</liferay-ui:search-container-column-text>

											<liferay-ui:search-container-column-text
												name="don-vi-thuc-hien" align="center"
												cssClass="tthc-cqth"
												value="<%=HtmlUtil.escape(ttDataJsonArray.getString(7))%>">
											</liferay-ui:search-container-column-text>
											<liferay-ui:search-container-column-text
												name="nop-ho-so-truc-tuyen" align="center"
												cssClass="tthc-cqth">
												<a class="btn btn-info  btn-xs btn-kc" href="<%=HtmlUtil.escape(ttDataJsonArray.getString(3))%>"><liferay-ui:message
														key="nop-ho-so" /></a>
											</liferay-ui:search-container-column-text>
										</liferay-ui:search-container-row>
										<liferay-ui:search-iterator />
									</liferay-ui:search-container>
								</div>
							</aui:field-wrapper>
						</liferay-ui:panel>
					</liferay-ui:panel-container>
				</aui:form>
			</div>
		</div>
	</div>
</div>
