<%@page import="com.viettel.portal.vcms.permission.CategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.viettel.portal.vcms.model.Category"%>
<%@ page
	import="com.viettel.portal.vcms.service.CategoryLocalServiceUtil"%>
<%@include file="/html/admin/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
	String categoryCommand = ParamUtil.getString(request,
			"categoryCommand", StringPool.BLANK);

	Category currentCategory = null;

	long categoryId = ParamUtil.getLong(request, "categoryId", 0L);

	if (categoryId > 0) {
		currentCategory = CategoryLocalServiceUtil
				.getCategory(categoryId);
	}

	List<Category> lst = CategoryLocalServiceUtil.getCategories(
			scopeGroupId, -1, -1);
%>
<div class="clearfix">
	<aui:column columnWidth="60">
		<liferay-ui:panel-container id="panel-container-2" extended="true" accordion="true">
			<liferay-ui:panel id="panel-c1" title="Danh sách chuyên mục" collapsible="false" extended="true">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<thead>
					<th class="w60"><liferay-ui:message key="category-name" /></th>
					<th class="w25"><liferay-ui:message key="sort-order" /></th>
					<th class="w15 align-center"><liferay-ui:message key="option" /></th>
				</thead>
				<tbody>
					<%
						for (Category cat : lst) {
					%>
					<tr>
						<td class="w60"><%= HtmlUtil.escape(cat.getCategoryName()) %></td>
						<td class="w25"><input type="text" name="catId<%=cat.getCategoryId()%>"
							class="cat-item w100" value='<%=cat.getSortOrder()%>' /></td>
						<td class="w15 align-center">
							<portlet:renderURL var="editURL">
								<portlet:param name="mvcPath" value='/html/admin/category/view.jsp' />
								<portlet:param name="categoryId" value="<%= String.valueOf(cat.getCategoryId()) %>"/>
								<portlet:param name="redirect" value="<%= redirect %>"/>
							</portlet:renderURL>
							<a href="<%= editURL.toString() %>" title="Sửa chuyên mục" class="btn btn-primary btn-xs"><i class="glyphicon icon-edit"></i></a>
							<portlet:actionURL var="deleteURL" name="deleteCategory">
								<portlet:param name="categoryId" value="<%= String.valueOf(cat.getCategoryId())%>" />
								<portlet:param name="cmd" value="<%= Constants.DELETE %>"/>	
								<portlet:param name="redirect" value="<%= redirect %>"/>
							</portlet:actionURL>
							<a href="<%= deleteURL.toString() %>" onclick="return confirm('Bạn muốn xóa chuyên mục này?');" title="Xoá chuyên mục" class="btn btn-danger btn-xs"><i class="glyphicon icon-trash"></i></a>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</aui:column>
	<aui:column columnWidth="40">
	<c:if test="<%=CategoryPermission.contains(permissionChecker,
							scopeGroupId, CategoryPermission.UPDATE)%>">
		<liferay-ui:panel-container id="panel-container-2" extended="true" accordion="true">
			<liferay-ui:panel id="panel-c1" title="Thêm/Cập nhật chuyên mục" collapsible="false" extended="true">
			<liferay-portlet:actionURL var="updateCategoryURL"
				name="updateCategory">
				<liferay-portlet:param name="jspPage"
					value="/html/admin/category/view.jsp" />
				<liferay-portlet:param name="redirectURL"
					value="<%=PortalUtil.getCurrentURL(request)%>" />
			</liferay-portlet:actionURL>
			<aui:form name="fm" method="post" action="<%=updateCategoryURL%>">
				<div class="form-group">
				    <label for="<portlet:namespace />categoryName"><liferay-ui:message key="category-name" /><span class="required">(*)</span></label>
				    <input type="text" class="form-control" id="<portlet:namespace />categoryName" name="<portlet:namespace />categoryName" value='<%=currentCategory != null ? HtmlUtil.escape(currentCategory.getCategoryName()) : ""%>'>
				</div>
				<div class="form-group">
				    <label for="<portlet:namespace />categoryDesc"><liferay-ui:message key="category-desc" /></label>
				    <aui:input type="textarea" name="categoryDesc" label="" value='<%= currentCategory != null ? HtmlUtil.escape(currentCategory.getCategoryDesc()) : ""%>' />
				</div>
				<div class="form-group">
				    <label for="<portlet:namespace />sortOrder"><liferay-ui:message key="sort-order-label" /></label>
				    <aui:input name="sortOrder" label="" type="text"
						value='<%=currentCategory != null ? currentCategory.getSortOrder() : ""%>'
						size="10">
						<aui:validator name="required" />
						<aui:validator name="digits">
							true
						</aui:validator>
					</aui:input>
				</div>
				<div class="form-button">
					<aui:button type="submit" value="save" />
					<aui:button type="button" value="cancel" href="<%=PortalUtil.getCurrentURL(request)%>" />
				</div>
				<aui:input type="hidden" name="categoryId" value="<%=categoryId%>" />
			</aui:form>
		</liferay-ui:panel></liferay-ui:panel-container>
	</c:if>
	</aui:column>
</div>