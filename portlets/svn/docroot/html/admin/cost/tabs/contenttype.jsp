<%@page import="com.viettel.portal.vcms.service.ContentTypeLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.ContentType"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/cost/init.jsp"%>

<%
	String categoryCommand = ParamUtil.getString(request, "categoryCommand");
	String keywordSearch = ParamUtil.getString(request, "keywordSearch");
	long contentTypeId = ParamUtil.getLong(request, "contentTypeId",0L);
	ContentType entity = null;
	if(contentTypeId > 0){
		entity = ContentTypeLocalServiceUtil.fetchContentType(contentTypeId);
	}
%>
	
	<liferay-portlet:renderURL var="categoryAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/cost/view.jsp" />
		<liferay-portlet:param name="tabs1" value="contenttype"/>
	</liferay-portlet:renderURL>
			
	<liferay-portlet:renderURL var="addLoaiTepCongBaoURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/cost/view.jsp" />
		<liferay-portlet:param name="tabs1" value="contenttype"/>
		<liferay-portlet:param name="categoryCommand" value="updateCategoryCommand"/>
	</liferay-portlet:renderURL>
			
	<liferay-portlet:actionURL var="updateLoaiTepCongBaoURL" name="updateContentType">
		<liferay-portlet:param name="jspPage" value="/html/admin/cost/view.jsp" />
		<liferay-portlet:param name="tabs1" value="contenttype"/>
		<liferay-portlet:param name="ridirectURL" value="<%=categoryAdminHomePageURL %>" />
	</liferay-portlet:actionURL>
	
	<div class="legal-cc-admin-toolbar">
		<div class="lfr-header-row">
			<div class="lfr-header-row-content">
				<aui:nav-bar cssClass="custom-toolbar">
					<aui:nav id="toolbarContainer" >
						<aui:nav-item href="<%=addLoaiTepCongBaoURL %>"
							iconCssClass="icon-file" 
							label='add-cc-category' />
					</aui:nav>
					<aui:nav-bar-search cssClass="pull-right">
						<div class="form-search">
							<aui:form action="<%= categoryAdminHomePageURL %>" method="post" name="fm">
								<liferay-ui:input-search id="keywordSearch" name="keywordSearch" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
							</aui:form>
						</div>
					</aui:nav-bar-search>
				</aui:nav-bar>		
			</div>
		</div>
	</div>
	
	<c:if test='<%=Validator.equals(categoryCommand, "updateCategoryCommand")%>'>
		<div class="cc_category_update_form">
			<br/>
			<aui:form name="cc_category_update_form"  method="post" action="<%=updateLoaiTepCongBaoURL%>">
					<div class="form-group col-md-12">
						<div class="col-md-6"><liferay-ui:message key="content-type-name"/> (<liferay-ui:message key="required"/>)</div>
						<div class="col-md-6">
							<aui:input type="text" name="name" label="" 
										value='<%= entity != null ? entity.getName() : ""%>'>
								<aui:validator  name="required"/>
								<aui:validator name="maxLength">100</aui:validator>
							</aui:input>
						</div>	
					</div>	
					<div class="form-group col-md-12">
						<div class="col-md-6"><liferay-ui:message key="content-type-desc"/></div>
						<div class="col-md-6">
							<aui:input type="text" name="description" label="" value='<%= entity != null ? entity.getName() : ""%>'>
								<aui:validator  name="required"/>
								<aui:validator name="maxLength">100</aui:validator>
							</aui:input>
						</div>	
					</div>						
					<div class="form-group col-md-12">
						<div class="col-md-6"><liferay-ui:message key="cc-order"/></div>
						
						<div class="col-md-6">
							<aui:input name="sortOrder" label="" value='<%= entity != null ? entity.getSortOrder(): "0"%>'>
								<aui:validator name="digits"/>
							</aui:input>
						</div>
					</div>
					<div class="form-group col-md-12">
						<div class="col-md-6">
						</div>
						
						<div class="col-md-6">			
							<div class="button_row">												
								<aui:button type="submit" value="save" />							
								<aui:button type="button" value="cancel" href="<%=categoryAdminHomePageURL %>"/>
							</div>
						</div>
					</div>
				<aui:input type="hidden" name="categoryId"  value="<%=contentTypeId%>" />
				<aui:input name="redirectURL" type="hidden" value="<%=categoryAdminHomePageURL%>"></aui:input>
			</aui:form>
		</div>
		<br/>
	</c:if>

	<div>
		<liferay-ui:search-container emptyResultsMessage="cc-no-entry-found">

			<%	
				int categoryIndex = 0;
				List<ContentType> categoryList = ContentTypeLocalServiceUtil.getContentTypes(scopeGroupId, keywordSearch,  searchContainer.getStart(), searchContainer.getEnd());
				int totalLoaiTepCongBao = ContentTypeLocalServiceUtil.countContentTypes(scopeGroupId, keywordSearch);
			%>		
			<liferay-ui:search-container-results
				results="<%=categoryList%>"
				total="<%=totalLoaiTepCongBao%>"
			>			
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="ContentType" keyProperty="id" modelVar="category" >
				<% categoryIndex++; %>												
				<liferay-portlet:renderURL var="editLoaiTepCongBaoURL" >
					<liferay-portlet:param name="contentTypeId" value="<%=String.valueOf(category.getContenTypeId())%>"/>
					<liferay-portlet:param name="categoryCommand" value="updateCategoryCommand"/>
					<liferay-portlet:param name="tabs1" value="contenttype"/>
				</liferay-portlet:renderURL>
										
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(categoryIndex)%>" href="<%=editLoaiTepCongBaoURL %>"/>
				
				<liferay-ui:search-container-column-text name="cc-name" value="<%=category.getName() %>" href="<%=editLoaiTepCongBaoURL %>"/>
				
				<liferay-ui:search-container-column-text name="cc-order" value="<%=String.valueOf( category.getSortOrder() )%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=UserLocalServiceUtil.getUser(category.getUserId()).getFullName()%>"/>
				
				<liferay-ui:search-container-column-text name="edit">															
					<liferay-ui:icon image="edit" message="edit" url="<%= editLoaiTepCongBaoURL %>" />
				</liferay-ui:search-container-column-text>
														
				<liferay-portlet:actionURL  name="deleteContentType" var="deleteContentType">
					<portlet:param name="contentTypeId" value="<%=String.valueOf(category.getContenTypeId())%>"/>
					<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
				</liferay-portlet:actionURL>
				<liferay-ui:search-container-column-text name="delete">
					<liferay-ui:icon-delete url="<%= deleteContentType %>" />
				</liferay-ui:search-container-column-text>		
				
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator paginate="<%=false %>"/>
		</liferay-ui:search-container>
	</div>

<script type="text/javascript">
	
	AUI().ready('aui-form-validator', function(A){
		
		if(<%=Validator.equals(categoryCommand, "updateCategoryCommand")%>){
		
			var categoryInput = A.one('#<portlet:namespace />name');
			
			if(categoryInput){
				categoryInput.focus();
			}
					
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />cc_category_update_form,
		
		        rules: {
		            <portlet:namespace />name: {
		                required: true,
		                rangeLength: ['1','150']
		            },
		            <portlet:namespace />sortOrder: {
		                required: false,
		                rangeLength: ['0','300']
		            }
		        }
		    });
		}
	});

</script>