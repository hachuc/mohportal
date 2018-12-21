<%@page import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ include file="/html/view/init.jsp" %>
<%
	List<Category> lstLinhVuc = CategoryLocalServiceUtil.getByCategoryType(groupId, 2);
%>
<div id="display_7">
<liferay-ui:panel collapsible="<%=false%>" extended="<%=true%>"
			id="basic-info" persistState="<%=true%>" title='danh-muc-linh-vuc'>
			<div class="box_content">
			<ul class="list_news">
				<% for(Category cat : lstLinhVuc){ %>
					<liferay-portlet:renderURL portletName="SearchLegalDocument_WAR_thutuchanhchinhportlet" plid="<%=layoutId%>"  var="searchTTHCUrl" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
						<liferay-portlet:param name="idLinhvuc" value="<%= String.valueOf(cat.getCategoryId()) %>"/>
					</liferay-portlet:renderURL>
					<li class="list_item">
						<div class="title">
							<a href="<%= searchTTHCUrl%>"><%= HtmlUtil.escape(cat.getCategoryName()) %></a>
						</div>
					</li>
				<% } %>
			</ul>
			</div>
</liferay-ui:panel>
</div>