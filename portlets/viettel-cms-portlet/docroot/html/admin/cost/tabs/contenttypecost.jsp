<%@page import="java.util.TimeZone"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.viettel.portal.vcms.service.ContentTypeCostLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.ContentTypeCost"%>
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
	long contentTypeId = ParamUtil.getLong(request, "contentTypeId", 0L);
	System.out.println(contentTypeId);
	long contentTypeCostId = ParamUtil.getLong(request, "contentTypeCostId", 0L);
	List<ContentTypeCost> lstCost = ContentTypeCostLocalServiceUtil.getByType(scopeGroupId, contentTypeId);
	List<ContentType> contentTypes = ContentTypeLocalServiceUtil.getAllContentType(scopeGroupId);
	ContentTypeCost item = null;
	if(contentTypeCostId>0L){
		item = ContentTypeCostLocalServiceUtil.fetchContentTypeCost(contentTypeCostId);
	}
	if(contentTypeCostId> 0L)
		item = ContentTypeCostLocalServiceUtil.fetchContentTypeCost(contentTypeCostId);
	Calendar cal = CalendarFactoryUtil.getCalendar(TimeZone.getDefault(), locale);

	int startDateValue = cal.get(Calendar.DATE);
	int startMonthValue = cal.get(Calendar.MONTH);
	int startYearValue = cal.get(Calendar.YEAR);
%>
	
	<liferay-portlet:renderURL var="categoryAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/cost/view.jsp" />
		<liferay-portlet:param name="tabs1" value="contenttypecost"/>
	</liferay-portlet:renderURL>
			
	<liferay-portlet:renderURL var="addLoaiTepCongBaoURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/cost/view.jsp" />
		<liferay-portlet:param name="tabs1" value="contenttypecost"/>
	</liferay-portlet:renderURL>
			
	<liferay-portlet:actionURL var="updateLoaiTepCongBaoURL" name="updateContentTypeCost">
		<liferay-portlet:param name="jspPage" value="/html/admin/cost/view.jsp" />
		<liferay-portlet:param name="tabs1" value="contenttypecost"/>
		<liferay-portlet:param name="ridirectURL" value="<%=categoryAdminHomePageURL %>" />
	</liferay-portlet:actionURL>
	
	<div class="legal-cc-admin-toolbar">
		<div class="lfr-header-row">
			<div class="lfr-header-row-content">
				<aui:nav-bar cssClass="custom-toolbar">
					<aui:nav id="toolbarContainer" >
						<div class="list-content-type">
							<aui:select name="contentTypes" label="">
								<% for(ContentType ctype : contentTypes){									
									%>
									<c:if test='<%= Validator.equals(contentTypeId, ctype.getContenTypeId()) %>'>
										<aui:option value="<%= ctype.getContenTypeId() %>" selected="selected" label="<%= HtmlUtil.escape(ctype.getName()) %>" />
									</c:if>
									<c:if test='<%= !Validator.equals(contentTypeId, ctype.getContenTypeId()) %>'>
										<aui:option value="<%= ctype.getContenTypeId() %>" label="<%= HtmlUtil.escape(ctype.getName()) %>" />
									</c:if>
								<% } %>
							</aui:select>
						</div>
					</aui:nav>
				</aui:nav-bar>		
			</div>
		</div>
	</div>
	<div class="row">
	<div class="col-md-9">
		<liferay-ui:search-container emptyResultsMessage="cc-no-entry-found">
			<%
				int categoryIndex = 0;
					List<ContentTypeCost> categoryList = ContentTypeCostLocalServiceUtil.searchByType(scopeGroupId,
							contentTypeId, searchContainer.getStart(), searchContainer.getEnd());
					int totalResult = ContentTypeCostLocalServiceUtil.countByType(scopeGroupId, contentTypeId);
			%>		
			<liferay-ui:search-container-results
				results="<%=categoryList%>"
				total="<%=totalResult%>"
			>			
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="ContentTypeCost" keyProperty="costId" modelVar="cTypeCost" >
				<% categoryIndex++; %>												
				<liferay-portlet:renderURL var="editLoaiTepCongBaoURL" >
					<liferay-portlet:param name="contentTypeCostId" value="<%=String.valueOf(cTypeCost.getCostId())%>"/>
					<liferay-portlet:param name="tabs1" value="contenttypecost"/>
				</liferay-portlet:renderURL>
										
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(categoryIndex)%>" href="<%=editLoaiTepCongBaoURL %>"/>
				
				<liferay-ui:search-container-column-text name="cc-name" value="<%=String.valueOf(cTypeCost.getContentTypeID()) %>" href="<%=editLoaiTepCongBaoURL %>"/>
				
				<liferay-ui:search-container-column-text name="from-date" value="<%=dateFormat.format( cTypeCost.getFromDate())%>"/>
				
				<liferay-ui:search-container-column-text name="to-date" value="<%= dateFormat.format(cTypeCost.getToDate())%>"/>
				
				<liferay-ui:search-container-column-text name="edit">															
					<liferay-ui:icon image="edit" message="edit" url="<%= editLoaiTepCongBaoURL %>" />
				</liferay-ui:search-container-column-text>
														
				<liferay-portlet:actionURL  name="deleteContentTypeCost" var="deleteContentTypeCostUrl">
					<portlet:param name="contentTypeCostId" value="<%= String.valueOf(cTypeCost.getCostId())%>"/>
					<portlet:param name="redirectURL" value="<%= PortalUtil.getCurrentURL(request)%>"/>
				</liferay-portlet:actionURL>
				<liferay-ui:search-container-column-text name="delete">
					<liferay-ui:icon-delete url="<%= deleteContentTypeCostUrl %>" />
				</liferay-ui:search-container-column-text>		
				
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator/>
		</liferay-ui:search-container>
	</div>
	<div class="col-md-3">
		<aui:form name="cc_category_update_form"  method="post" action="<%=updateLoaiTepCongBaoURL%>">
					<div class="form-group col-md-12">
						<div class="col-md-6"><liferay-ui:message key="content-type-name"/> (<liferay-ui:message key="required"/>)</div>
						<div class="col-md-6">
							<liferay-ui:input-date dayParam="schedulerStartDateDay" dayValue="<%=startDateValue %>"  
							disabled="<%= false %>" monthParam="schedulerStartDateMonth" monthValue="<%=startMonthValue%>" name="startDate" yearParam="schedulerStartDateYear" yearValue="<%=startYearValue%>">

							</liferay-ui:input-date>
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
				<aui:input type="hidden" name="contentTypeId"  value="<%=contentTypeId%>" />
				<aui:input name="redirectURL" type="hidden" value="<%=categoryAdminHomePageURL%>"></aui:input>
			</aui:form>
	</div>
	</div>
<script type="text/javascript">
	AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
		A.one('#<portlet:namespace />contentTypes').on(
		        'change',
		        function(event) {
		        	var value=this.val();
		        	var renderUrl1 = Liferay.PortletURL.createRenderURL();
		        	renderUrl1.setWindowState("<%=LiferayWindowState.NORMAL.toString() %>");
		        	renderUrl1.setParameter("contentTypeId",value);
		        	renderUrl1.setPortletMode("<%=LiferayPortletMode.VIEW %>");
		        	renderUrl1.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
		        	renderUrl1.setParameter("jspPage","/html/admin/cost/tabs/contenttypecost.jsp");
		        	
		    		window.location.href = renderUrl1.toString();
		        }
		);
	});
</script>