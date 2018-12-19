<%@page import="com.revotech.portal.tthc.model.LegalDocument"%>
<%@page import="com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.service.CategoryLocalServiceUtil"%>
<%@page import="com.revotech.portal.tthc.model.Category"%>
<%@page import="com.revotech.portal.tthc.util.ActionKeys"%>
<%@page import="com.revotech.portal.tthc.permission.AdminPermission"%>
<%@ include file="/html/admin/init.jsp" %>
<liferay-util:include page='/html/admin/tabs.jsp' servletContext="<%= application %>" />
<liferay-util:include page='/html/admin/legaldocument/tabs_level.jsp' servletContext="<%= application %>" />
<%
	String keyword = ParamUtil.getString(request, "keywords");
	int ldlevel= ParamUtil.getInteger(request, "ldlevel", 2);
%>

<aui:nav-bar>
	<c:if test="<%= AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_DOCUMENT) %>">
	<aui:nav>
		<portlet:renderURL var="editEntryURL"  windowState="<%=LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="mvcPath" value='/html/admin/legaldocument/edit.jsp' />
			<portlet:param name="ldlevel" value='<%= String.valueOf(ldlevel) %>' />
			<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
		</portlet:renderURL>
		<%
			String javascriptHref = "javascript:updateDocumentForm('" + editEntryURL.toString() + "')";
		%>
			<aui:nav-item href="<%=javascriptHref%>" label="add" name="addEntryButton" iconCssClass="icon-plus"/>
	</aui:nav>
	</c:if>
	<aui:nav-bar-search cssClass="pull-right">
			<liferay-portlet:renderURL varImpl="searchURL">
				<portlet:param name="mvcPath" value='/html/admin/legaldocument/documents.jsp' />
			</liferay-portlet:renderURL>
			
			<div class="form-search">
				<aui:form action="<%= searchURL %>" method="post" name="fm">
					<liferay-ui:input-search id="keywords1" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
				</aui:form>
			</div>
		</aui:nav-bar-search>
</aui:nav-bar>
<liferay-ui:search-container emptyResultsMessage="no-found-document">
	<%
		List<LegalDocument> lst = LegalDocumentLocalServiceUtil.findByKeyword(keyword, groupId, 0L, 0L, ldlevel, searchContainer.getStart(), searchContainer.getEnd());
		total = LegalDocumentLocalServiceUtil.countByKeyword(keyword, groupId, 0L, 0L,ldlevel);
	%>
	
	<liferay-ui:search-container-results results="<%=lst %>" total="<%=total %>"/>
	
	<liferay-ui:search-container-row className="LegalDocument" keyProperty="ldId" modelVar="ld" escapedModel="<%=true %>">
		<liferay-ui:search-container-column-text name="ma-thu-tuc" value="<%=ld.getLdCode()%>" 
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="ten-thu-tuc-hanh-chinh" value="<%= ld.getLdTitle() %>"
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="muc-do" value="<%=String.valueOf(ld.getLdLevel())%>"
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="co-quan-ban-hanh" value="<%= String.valueOf(ld.getIdCoquanbanhanh())%>" 
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="don-vi-thuc-hien" value="<%= HtmlUtil.escape(ld.getLdDonvithuchien())%>" 
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="linh-vuc" value="<%= String.valueOf(ld.getIdLinhvuc())%>" 
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
			<c:if test="<%=AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CATEGORY) %>">
				<portlet:renderURL var="editDocumentURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="jspPage" value="/html/admin/legaldocument/edit.jsp" />
					<portlet:param name="ldId" value="<%= String.valueOf(ld.getLdId()) %>" />
					<portlet:param name="ldLevel" value="<%=String.valueOf(ld.getLdLevel())%>"/>   
				</portlet:renderURL>
				
				<a href="javascript:;" onclick='updateDocumentForm("<%=editDocumentURL.toString() %>");'>
					<liferay-ui:icon image="edit"/>
				</a>
			</c:if>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
			<c:if test="<%=AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_CATEGORY) %>">
				<portlet:actionURL  name="deleteDocument" var="deleteDocumentActionURL">
					<portlet:param name="ldId" value="<%=String.valueOf(ld.getLdId())%>"/>
					<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>  
					<portlet:param name="idCoquanbanhanh" value="<%=String.valueOf(ld.getIdCoquanbanhanh())%>"/>   
					<portlet:param name="idLinhvuc" value="<%=String.valueOf(ld.getIdLinhvuc())%>"/>   
				</portlet:actionURL>            
				<liferay-ui:icon-delete url="<%= deleteDocumentActionURL %>" confirmation="confirm-delete-category" />
			</c:if>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script use="aui-base,uploader">

	Liferay.provide(
		window,
		'updateDocumentForm',
		function(url){
			
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
				title: '<liferay-ui:message key="add-new-document" />',
				uri: url,
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
</aui:script>