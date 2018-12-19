<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@page import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.permission.AdminPermission"%>
<%@page import="com.revotech.portal.tthc.util.ActionKeys"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	long id = ParamUtil.getLong(request, "id");
	int ctype = ParamUtil.getInteger(request, "ctype", 1);
	Category lcategory = CategoryLocalServiceUtil.fetchCategory(id);
	
%>

<portlet:actionURL name="updateCategory" var="updateCategoryURL"/>

<aui:form cssClass="vbpq-form" action="" method="post" name="fm" onSubmit='<%= "event.preventDefault(); submitForm(event.target);" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value=""/>
	<aui:input name="redirectURL" type="hidden" value="<%= redirect %>" />
	<aui:input name="id" type="hidden" value="<%= id %>" />
	
	<liferay-ui:error key="empty-category-name" message="empty-category-name" />

	<aui:fieldset>
		<aui:model-context bean="<%= lcategory %>" model="<%= Category.class %>" />
		
		<aui:input name="categoryName" autoFocus="<%= true %>" type="text" cssClass="lfr-input-text" label="category-name">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="categoryDesc" type="text" cssClass="lfr-input-text" label="category-desc">
		</aui:input>
		<aui:input value="<%= lcategory != null ? lcategory.getIsActive() : true %>" name="isActive" cssClass="lfr-checkbox" label="hien-thi"/>
		
		<aui:input name="catOrder" cssClass="lfr-input-text-order" type="text" label="sort-order"/>
		
		<aui:input type="hidden" name="categoryType" value="<%= ctype%>" />
		
		<aui:button-row>
			<aui:button type="button" value='<%= lcategory != null ? "save" : "add-new" %>' onClick='<%=renderResponse.getNamespace() + "updateCategory();" %>'/>
			
			<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
		</aui:button-row>
	
	</aui:fieldset>

</aui:form>

<aui:script>
	function <portlet:namespace />updateCategory() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (lcategory == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateCategory"/>');
	}
</aui:script>

<%!
	private static final Log _log = LogFactoryUtil.getLog("html_portlet_admin_edit_category_jsp"); 
%>