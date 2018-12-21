<%@page import="com.revotech.portal.tthc.model.LegalDocument"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparatorFactory"%>
<%@page import="com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ include file="/html/view/init.jsp" %>
<%
OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil.getOrderByComparatorFactory();
OrderByComparator comparator = orderByComparatorFactory.create("LegalDocument","ldCode", true);

List<LegalDocument> thuTucHanhChinhs = LegalDocumentLocalServiceUtil.getLatestLegalDocument(groupId, 3, true, 0, displayItem, comparator);
 %>
 <div id="display_7">
<liferay-ui:panel collapsible="<%=false%>" extended="<%=true%>"
			id="basic-info" persistState="<%=true%>" title='<%= portletTitle %>'>
			<div class="box_content">
			<ul class="list_news">
				<% for(LegalDocument doc : thuTucHanhChinhs){ %>
					<li class="list_item">
						<div class="title">
							<a href="<%= doc.getLdLevel3Link()%> "><%= HtmlUtil.escape(doc.getLdTitle()) %></a>
						</div>
					</li>
				<% } %>
			</ul>
			</div>
</liferay-ui:panel>
</div>