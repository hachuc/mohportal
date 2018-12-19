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
<div class="row">
	<div class="col-md-8">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<thead>
					<th><liferay-ui:message key="category-name" /></th>
					<th><liferay-ui:message key="sort-order" /></th>
					<th><liferay-ui:message key="edit" /></th>
					<th><liferay-ui:message key="delete" /></th>
				</thead>
				<tbody>
					<%
						for (Category cat : lst) {
					%>
					<tr>
						<td><%=cat.getCategoryName()%></td>
						<td><input type="text" name="catId<%=cat.getCategoryId()%>"
							class="cat-item w100" value='<%=cat.getSortOrder()%>' /></td>
						<td><p data-placement="top" data-toggle="tooltip"
								title="Edit">
								<button class="btn btn-primary btn-xs" data-title="Edit"
									data-toggle="modal" data-target="#edit">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</p></td>
						<td><p data-placement="top" data-toggle="tooltip"
								title="Delete">
								<button class="btn btn-danger btn-xs" data-title="Delete"
									data-toggle="modal" data-target="#delete">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</p></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-md-4">
	<c:if test="<%=CategoryPermission.contains(permissionChecker,
							scopeGroupId, CategoryPermission.UPDATE)%>">
		<liferay-portlet:actionURL var="updateCategoryURL"
			name="updateCategory">
			<liferay-portlet:param name="jspPage"
				value="/html/admin/category/view.jsp" />
			<liferay-portlet:param name="redirectURL"
				value="<%=PortalUtil.getCurrentURL(request)%>" />
		</liferay-portlet:actionURL>
		<div align="center">
			<aui:form name="fm" method="post" action="<%=updateCategoryURL%>">
				<table>
					<tr>
						<td><liferay-ui:message key="category-name" /><span
							class="required">(*)</span></td>
						<td><aui:input type="text" name="categoryName" label=""
								value='<%=currentCategory != null ? currentCategory
							.getCategoryName() : ""%>'>
								<aui:validator name="required" />
							</aui:input></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="category-desc" /></td>

						<td><aui:input type="textarea" name="categoryDesc" label=""
								value='<%=currentCategory != null ? currentCategory
						.getCategoryDesc() : ""%>' />
						</td>
					</tr>
					<tr>
						<td><liferay-ui:message key="sort-order-label" /></td>

						<td><aui:input name="sortOrder" label="" type="text"
								value='<%=currentCategory != null ? currentCategory
							.getSortOrder() : ""%>'
								size="10">
								<aui:validator name="required" />
								<aui:validator name="number">
										true
									</aui:validator>
							</aui:input></td>
					</tr>

					<tr>
						<td><liferay-ui:message key="" /></td>

						<td>
							<div class="button_row">								
									<aui:button type="submit" value="save" />
								<aui:button type="button" value="cancel"
									href="<%=PortalUtil.getCurrentURL(request)%>" />
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
					</tr>
				</table>
				<aui:input type="hidden" name="categoryId" value="<%=categoryId%>" />
			</aui:form>
		</div>
		</c:if>
	</div>
</div>