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

List<LegalDocument> thuTucHanhChinhs = LegalDocumentLocalServiceUtil.getLatestLegalDocument(groupId, 2, true, 0, displayItem, comparator);
 %>
<div class="box-container" id="a09">
	<div class="box-content-08">
		<div class="title">
			<div>
					<a href=""
						title="<%=HtmlUtil.escape(portletTitle)%>"><%=HtmlUtil.escape(portletTitle)%></a>
			</div>
		</div>
		<div class="content">
			<div class="list">
				<ul>
				    <%
					int count =0;

				    for(LegalDocument doc : thuTucHanhChinhs)
					{
				%>
				<li><a href="<%= doc.getLdLink()%>"><%= HtmlUtil.escape(doc.getLdTitle()) %></a></li>
				<%
				}
				%>
				</ul>
			</div>
		</div>
	</div>
</div>