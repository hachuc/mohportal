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
	<aui:form action="<%=searchTTHC%>" method="post" name="fm"
		cssClass="vbpq-form">
		<liferay-portlet:renderURLParams varImpl="searchTTHC" />
		<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
			id="basic-info" persistState="<%=true%>"
			title='tim-kiem-thu-tuc-hanh-chinh'>
			<aui:field-wrapper label="">
				<aui:fieldset>
					<aui:row>
						<aui:col width="<%= 50 %>">
							<aui:select name="idCoquanbanhanh" cssClass="span12" label="co-quan-ban-hanh" showEmptyOption="<%= true %>">
								<%
									if (lstCoQuanBanHanh != null) {
														for (Category cat : lstCoQuanBanHanh) {
								%>
								<c:if test='<%=idCoquanbanhanh == cat.getCategoryId()%>'>
									<aui:option selected="true"
										value="<%=String.valueOf(cat.getCategoryId())%>"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
								</c:if>
								<c:if test='<%=idCoquanbanhanh != cat.getCategoryId()%>'>
									<aui:option value="<%=String.valueOf(cat.getCategoryId())%>"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
								</c:if>
								<%
									}
													}
								%>
							</aui:select>
						</aui:col>
						<aui:col width="<%= 50 %>">
							<aui:select name="idLinhvuc" cssClass="span12" label="linh-vuc" showEmptyOption="<%= true %>">
								<%
									if (lstLinhVuc != null) {
														for (Category item : lstLinhVuc) {
								%>
								<c:if test='<%=idLinhvuc == item.getCategoryId()%>'>
									<aui:option selected="true"
										value="<%=String.valueOf(item.getCategoryId())%>"><%=HtmlUtil.escape(item.getCategoryName())%></aui:option>
								</c:if>
								<c:if test='<%=idLinhvuc != item.getCategoryId()%>'>
									<aui:option value="<%=String.valueOf(item.getCategoryId())%>"><%=HtmlUtil.escape(item.getCategoryName())%></aui:option>
								</c:if>
								<%
									}
													}
								%>
							</aui:select>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col width="<%= 60 %>">
							<aui:input type="text" cssClass="span12" label=""
								name="keywords" placeholder="keywords-to-search" />
						</aui:col>
						<aui:col width="<%= 40 %>">
							<aui:button name="search" type="submit" value="tthc-search"
								cssClass="btn btn-grey text-bold" />
						</aui:col>
					</aui:row>
				</aui:fieldset>
			</aui:field-wrapper>
		</liferay-ui:panel>
		<div class="tthc-search-table table-responsive pl0 mt20">
			<liferay-ui:search-container delta="20"
				emptyResultsMessage="no-result-were-found"
				iteratorURL="<%=searchTTHC%>">
				<%
					//List<LegalDocument> thuTucHanhChinhs = new ArrayList<LegalDocument>();
							//int totalTTHC = 0;
							List thuTucHanhChinhs = LegalDocumentLocalServiceUtil.findFieldByKeyword(keywords, groupId,
									idCoquanbanhanh, idLinhvuc, 2, searchContainer.getStart(), searchContainer.getEnd());
							int totalTTHC = LegalDocumentLocalServiceUtil.countByKeyword(keywords, groupId, idCoquanbanhanh,
									idLinhvuc, 2);
				%>
				<liferay-ui:search-container-results results='<%=thuTucHanhChinhs%>'
					total='<%=totalTTHC%>' />
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

					<liferay-ui:search-container-column-text name="linh-vuc"
						align="center" cssClass="tthc-tenthutuc"
						value="<%=HtmlUtil.escape(ttDataJsonArray.getString(5))%>">
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text name="co-quan-ban-hanh"
						align="center" cssClass="tthc-tenthutuc"
						value="<%=HtmlUtil.escape(ttDataJsonArray.getString(6))%>">
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</aui:form>

</div>
