<%@page
	import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page
	import="com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.model.LegalDocument"%>
<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@ include file="/html/view/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%
	List<Category> lstLinhVuc = CategoryLocalServiceUtil.getByCategoryType(groupId, 2);
%>
<liferay-portlet:renderURL portletName="SearchLegalDocument_WAR_thutuchanhchinhportlet"
 plid="<%=layoutId%>"  var="searchTTHCUrl" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	
</liferay-portlet:renderURL>
<div class="news-wrapper clearfix">
	<div class="news-heading-top m-b-15 clearfix">
		<h2 class="news-heading"> <a href="<%= searchTTHCUrl%>"><%= HtmlUtil.escape(portletTitle) %></a> <span></span> </h2>
	</div>
	<div class="list-news-3 m-t-10 clearfix">
		<div class="col-md-12">
			<aui:select name="idLinhvuc" cssClass="span12" label="" id="idLinhvuc">
				<aui:option value="0" label='chon-danh-muc' />
				<%
					if (lstLinhVuc != null) {
													for (Category item : lstLinhVuc) {
				%>
				<aui:option value="<%=String.valueOf(item.getCategoryId())%>"><%=HtmlUtil.escape(item.getCategoryName())%></aui:option>
				<%
					}
				}
				%>
			</aui:select>
		</div>
	</div>
	<div class="list-news-3 m-t-5 clearfix">
		<div class="col-md-12">
			<aui:input type="text" cssClass="span12" label="" name="keywords"
				placeholder="keywords-to-search" id="keywords" />
		</div>
		<div class="col-md-12 m-t-5">
			<aui:button cssClass="btn-primary" name="search" value="tthch-search" />
		</div>
	</div>
</div>
<aui:script use="aui-base,node,aui-io-request">
	A.ready('liferay-portlet-url', function(A) {
		A.one("#<portlet:namespace/>search").on(
		"click",
		function() {
			var renderURL = Liferay.PortletURL.createRenderURL();
			renderURL.setLifecycle(Liferay.PortletURL.RENDER_PHASE);
			renderURL.setPlid('<%= layoutId%>');
			renderURL.setPortletId("SearchLegalDocument_WAR_thutuchanhchinhportlet");
			var idLinhvuc = A.one("#<portlet:namespace />idLinhvuc").val();
			var keywords = A.one("#<portlet:namespace />keywords").val();
			console.log('idLinhvuc=' + idLinhvuc);
			debugger;
			renderURL.setParameter("idLinhvuc", idLinhvuc);
			renderURL.setParameter("keywords", keywords);
			window.location = renderURL;
		});
	});
</aui:script>