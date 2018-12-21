<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@page import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.model.LegalDocument"%>
<%@page import="com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.permission.AdminPermission"%>
<%@page import="com.revotech.portal.tthc.util.ActionKeys"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	long ldId = ParamUtil.getLong(request, "ldId");
	int ldlevel = ParamUtil.getInteger(request, "ldlevel", 2);
	LegalDocument document = LegalDocumentLocalServiceUtil.fetchLegalDocument(ldId);
	List<Category> lstLinhVuc = CategoryLocalServiceUtil.getCategories(groupId, true, 2, -1, -1);
	List<Category> lstCoquanthuchien = CategoryLocalServiceUtil.getCategories(groupId, true, 1, -1, -1);
%>

<portlet:actionURL name="updateDocument" var="updateCategoryURL"/>

<aui:form cssClass="vbpq-form" action="" method="post" name="fm" onSubmit='<%= "event.preventDefault(); submitForm(event.target);" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value=""/>
	<aui:input name="redirectURL" type="hidden" value="<%= redirect %>" />
	<aui:input name="ldId" type="hidden" value="<%= ldId %>" />
	
	<liferay-ui:error key="empty-document-name" message="empty-document-name" />

	<aui:fieldset>
		<aui:model-context bean="<%= document %>" model="<%= LegalDocument.class %>" />
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:input name="ldCode" autoFocus="<%= true %>" type="text" cssClass="span12" label="ld-code">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:input name="ldTitle" type="textarea" cssClass="trich-yeu span12" label="ld-title" style='<%= "height: " + ModelHintsConstants.TEXTAREA_DISPLAY_HEIGHT + "px;" %>'/>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:input name="ldLink" type="text" cssClass="span12" label="ld-ldLink">
				</aui:input>
			</aui:col>
		</aui:row>
		<c:if test='<%= ldlevel == 3 %>'>
			<aui:row>
				<aui:col width="<%= 100 %>">
					<aui:input name="ldLevel3Link" type="text" cssClass="span12" label="ld-Level3Link">
					</aui:input>
				</aui:col>
			</aui:row>
		</c:if>
		<aui:row>
			<aui:col width="<%= 33 %>">
				<aui:select name="idCoquanbanhanh" label="ld-coquanbanhanh" showEmptyOption="<%= true %>" required="<%= true %>">
					<%
						for (Category cat : lstCoquanthuchien){
						
					%>
					<c:if test='<%= document!=null && document.getIdCoquanbanhanh() == cat.getCategoryId() %>'>
						<aui:option value='<%= cat.getCategoryId() %>' label='<%= cat.getCategoryName()%>' />
					</c:if>
					<c:if test='<%= document==null|| document.getIdCoquanbanhanh() != cat.getCategoryId() %>'>
					<aui:option value='<%= cat.getCategoryId() %>' label='<%= cat.getCategoryName()%>' />
					</c:if>
					<% } %>
				</aui:select>
			</aui:col>
			<aui:col width="<%= 33 %>">
				<aui:select name="idLinhvuc" label="linh-vuc" showEmptyOption="<%= true %>" required="<%= true %>">
					<%
						for (Category cat : lstLinhVuc){
						
					%>
					<c:if test='<%= document!=null && document.getIdLinhvuc() == cat.getCategoryId() %>'>
						<aui:option selected="selected" value='<%= cat.getCategoryId() %>' label='<%= cat.getCategoryName()%>' />
					</c:if>
					<c:if test='<%= document==null|| document.getIdLinhvuc() != cat.getCategoryId() %>'>
						<aui:option value='<%= cat.getCategoryId() %>' label='<%= cat.getCategoryName()%>' />
					</c:if>
					<% } %>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:input name="ldDonvithuchien" type="text" cssClass="span12" label="don-vi-thuc-hien">
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:input name="isActive" type="checkbox" label="isActive" checked="<%= document!=null?document.getIsActive() : true %>">
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:input type="hidden" name="ldlevel" value="<%= ldlevel%>" />
		
		<aui:button-row>
			<aui:button type="button" value='<%= document != null ? "save" : "add-new" %>' onClick='<%=renderResponse.getNamespace() + "updateDocument();" %>'/>
			
			<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
		</aui:button-row>
	
	</aui:fieldset>

</aui:form>

<aui:script>
	function <portlet:namespace />updateDocument() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (document == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateDocument"/>');
	}
</aui:script>

<%!
	private static final Log _log = LogFactoryUtil.getLog("html_portlet_admin_edit_category_jsp"); 
%>