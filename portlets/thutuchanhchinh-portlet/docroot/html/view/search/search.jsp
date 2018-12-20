<%@page
	import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page
	import="com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.model.LegalDocument"%>
<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@ include file="/html/view/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String keywords = ParamUtil.getString(request, "keywords");
	long idLinhvuc = ParamUtil.getLong(request, "idLinhvuc", 0L);

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setParameter("jspPage", "/html/view/search/results.jsp");
	portletURL.setParameter("keywords", keywords);
	portletURL.setParameter("idLinhvuc", String.valueOf(idLinhvuc));

	List<Category> lstLinhVuc = CategoryLocalServiceUtil.getByCategoryType(groupId, 2);

	List<Category> lstCoQuanBanHanh = CategoryLocalServiceUtil.getByCategoryType(groupId, 1);
%>

<liferay-portlet:renderURL varImpl="searchTTHC">
	<portlet:param name="mvcPath" value="/html/view/search/results.jsp" />
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
						<aui:col width="<%=50%>">
							<aui:input type="text" cssClass="span12" label="" name="keywords"
								placeholder="keywords-to-search" />
						</aui:col>
						<aui:col width="<%=50%>">
							<aui:select name="idLinhvuc" cssClass="span12" label="linh-vuc"
								showEmptyOption="<%=true%>">
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
						<aui:col width="<%=100%>">
							<aui:button name="search" type="submit" value="tthc-search"
								cssClass="btn btn-grey text-bold" />
						</aui:col>
					</aui:row>
				</aui:fieldset>
			</aui:field-wrapper>
		</liferay-ui:panel>
	</aui:form>
</div>