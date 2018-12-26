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

#<portlet:namespace />objectsSearchContainer_col-co-quan-ban-hanh{
	text-align: center;
	white-space: nowrap;
}
#<portlet:namespace />objectsSearchContainer_col-co-quan-thuc-hien{
	text-align: center;
	white-space: nowrap;
}
#<portlet:namespace />objectsSearchContainer_col-co-quan-linh-vuc{
	text-align: center;
	white-space: nowrap;
}
#<portlet:namespace />objectsSearchContainer_col-ma-thu-tuc{
	text-align: center;
	white-space: nowrap;
}
#<portlet:namespace />objectsSearchContainer_col-ten-thu-tuc-hanh-chinh{
	text-align: center;
	white-space: nowrap;
}
</style>
<%
	String keywords = ParamUtil.getString(request, "keywords");
	long idLinhvuc = ParamUtil.getLong(request, "idLinhvuc", 0L);
	long idCoquanbanhanh = ParamUtil.getLong(request, "idCoquanbanhanh", 0L);

	System.out.println("idlinhvuc:" + idLinhvuc + " -- idcoquan:" + idCoquanbanhanh);
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setParameter("jspPage", "/html/view/search/results.jsp");
	portletURL.setParameter("keywords", keywords);
	portletURL.setParameter("idLinhvuc", String.valueOf(idLinhvuc));
	portletURL.setParameter("idCoquanbanhanh", String.valueOf(idCoquanbanhanh));

	List<Category> lstLinhVuc = CategoryLocalServiceUtil.getByCategoryType(groupId, 2);

	List<Category> lstCoQuanBanHanh = CategoryLocalServiceUtil.getByCategoryType(groupId, 1);
%>

<liferay-portlet:renderURL varImpl="searchTTHC">
	<portlet:param name="mvcPath" value="/html/view/search/results.jsp" />
</liferay-portlet:renderURL>

<div class="page-content boxed tthc-search">
	<aui:form action="<%=searchTTHC%>" method="post" name="fm"
		cssClass="vbpq-form form-horizontal">
		<liferay-portlet:renderURLParams varImpl="searchTTHC" />
		<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
			id="basic-info" persistState="<%=true%>"
			title='tim-kiem-thu-tuc-hanh-chinh'>
			<div class="form-group clearfix">
				<label class="col-md-3 control-label">
					<liferay-ui:message key="co-quan-ban-hanh" />
				</label>
				
				<div class="col-md-8">
					<aui:input type="text" cssClass="span12" label=""
								name="keywords" placeholder="keywords-to-search" value="<%= keywords %>" />
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="form-group clearfix">
				<label class="col-md-3 control-label"><liferay-ui:message key="linh-vuc" /></label>
				
				<div class="col-md-8">
					<aui:select name="idLinhvuc" cssClass="span12" label="">
						<aui:option value="0" label="chon-linh-vuc" />
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
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="form-group clearfix">
				<label class="col-md-3 control-label"><liferay-ui:message key="co-quan-ban-hanh" /></label>
				
				<div class="col-md-8">
					<aui:input type="text" cssClass="span12" label=""
								name="coQuanbanhanh" placeholder="nhap-co-quan-ban-hanh" value="<%= keywords %>" />
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="form-group clearfix">
				<label class="col-md-3 control-label"></label>
				
				<div class="col-md-9 control-group">
					<aui:button name="search" type="submit" value="tthch-search"
								cssClass="btn btn-grey text-bold" />
				</div>
			</div>
		</liferay-ui:panel>
		<div class="tthc-search-table table-responsive pl0 mt20">
			<liferay-ui:search-container delta="20"
				emptyResultsMessage="no-result-were-found"
				iteratorURL="<%=searchTTHC%>">
				<%
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
					<liferay-ui:search-container-column-text name="co-quan-ban-hanh"
						align="center" cssClass="tthc-ccbh"
						value="<%=HtmlUtil.escape(ttDataJsonArray.getString(6))%>">
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="linh-vuc"
						align="center" cssClass="tthc-linhvuc"
						value="<%=HtmlUtil.escape(ttDataJsonArray.getString(5))%>">
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="co-quan-thuc-hien"
						align="center" cssClass="tthc-cqth"
						value="<%=HtmlUtil.escape(ttDataJsonArray.getString(7))%>">
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</aui:form>

</div>
