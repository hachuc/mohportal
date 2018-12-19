<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@page import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.permission.AdminPermission"%>
<%@page import="com.revotech.portal.tthc.util.ActionKeys"%>
<%@ include file="/html/admin/init.jsp" %>
<%
	String keyword = ParamUtil.getString(request, "keywords");
	int ctype= ParamUtil.getInteger(request, "ctype", 1);
	System.out.println("ctype=:" + ctype);
%>

<liferay-util:include page='/html/admin/tabs.jsp' servletContext="<%= application %>" />

<liferay-util:include page='/html/admin/category/tabs_category.jsp' servletContext="<%= application %>" />
<portlet:renderURL var="categoryAdminURL">
	<portlet:param name="mvcPath" value='/html/admin/category/categories.jsp' />
	<portlet:param name="ctype" value='<%= String.valueOf(ctype)%>' />
</portlet:renderURL>
<c:if test="<%= AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CATEGORY) %>">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="editLCategoryURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="jspPage" value="/html/admin/category/edit.jsp" />
				<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
				<portlet:param name="ctype" value='<%= String.valueOf(ctype)%>' />
			</portlet:renderURL>
			<%
				String javascriptHref = "javascript:updateCategoryForm('" + editLCategoryURL.toString() + "')";
			%>
			<aui:nav-item href="<%=javascriptHref%>" label="add" name="addEntryButton" iconCssClass="icon-plus"/>
		</aui:nav>

		<aui:nav-bar-search cssClass="pull-right">
			<liferay-portlet:renderURL varImpl="searchURL">
				<portlet:param name="mvcPath" value='/html/admin/category/categories.jsp' />
				<portlet:param name="ctype" value='<%= String.valueOf(ctype) %>' />
			</liferay-portlet:renderURL>
			
			<div class="form-search">
				<aui:form action="<%= searchURL %>" method="post" name="fm">
					<liferay-ui:input-search id="keywords1" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
				</aui:form>
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
</c:if>
<liferay-ui:search-container emptyResultsMessage="no-found-category">
	<%
		List<Category> lst = CategoryLocalServiceUtil.findByKeyword(groupId, keyword, ctype, searchContainer.getStart(), searchContainer.getEnd());
		total = CategoryLocalServiceUtil.countByKeyword(groupId, keyword, ctype);
	%>
	
	<liferay-ui:search-container-results results="<%=lst %>" total="<%=total %>"/>
	
	<liferay-ui:search-container-row className="Category" keyProperty="categoryId" modelVar="ct" escapedModel="<%=true %>">
		<c:if test='<%= ctype==1 %>'>
		<liferay-ui:search-container-column-text name="ten-co-quan-ban-hanh" value="<%=ct.getCategoryName()%>" 
			orderable="<%=false %>" />
		</c:if>
		<c:if test='<%= ctype==2 %>'>
			<liferay-ui:search-container-column-text name="ten-linh-vuc" value="<%=ct.getCategoryName()%>" 
			orderable="<%=false %>" />
		</c:if>
		<liferay-ui:search-container-column-text name="vi-tri-hien-thi" value="<%= String.valueOf(ct.getCatOrder()) %>"
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="ngay-tao" value="<%=dateTimeFormat.format(ct.getCreateDate())%>"
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="nguoi-tao" value="<%= ct.getUserName()%>" 
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
			<c:if test="<%=AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CATEGORY) %>">
				<portlet:renderURL var="editCategoryURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="jspPage" value="/html/admin/category/edit.jsp" />
					<portlet:param name="id" value="<%= String.valueOf(ct.getCategoryId()) %>" />
					<portlet:param name="ctype" value="<%=String.valueOf(ct.getCategoryType())%>"/>   
				</portlet:renderURL>
				
				<a href="javascript:;" onclick='updateCategoryForm("<%=editCategoryURL.toString() %>");'>
					<liferay-ui:icon image="edit"/>
				</a>
			</c:if>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
			<c:if test="<%=AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_CATEGORY) %>">
				<portlet:actionURL  name="deleteCategory" var="deleteCategoryActionURL">
					<portlet:param name="id" value="<%=String.valueOf(ct.getCategoryId())%>"/>
					<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>  
					<portlet:param name="categoryId" value="<%=String.valueOf(ct.getCategoryId())%>"/>   
				</portlet:actionURL>            
				<liferay-ui:icon-delete url="<%= deleteCategoryActionURL %>" confirmation="confirm-delete-category" />
			</c:if>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
	
<aui:script use="aui-base,uploader">

	Liferay.provide(
		window,
		'updateCategoryForm',
		function(url){
		 	var ctype='<%= ctype%>';
		 	var titlebar = '<liferay-ui:message key="add-new-cqbh" />';
		 	if(ctype=='2')
		 		titlebar = '<liferay-ui:message key="add-new-linh-vuc" />';
			var dialogWidow = {
				dialog: {
					constrain: true,
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: '80%',
					cache: false,
					after: {
						visibleChange: function(event) {
							location.reload();
						}
                       }
				},
				title: titlebar,
				uri: url,
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
</aui:script>